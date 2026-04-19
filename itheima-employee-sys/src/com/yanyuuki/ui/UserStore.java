package com.yanyuuki.ui;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class UserStore {

    private static final String DELIMITER = "|";
    private static final String MODULE_DIR_NAME = "itheima-employee-sys";
    private static final Path USER_FILE = resolveUserFilePath();

    private UserStore() {
    }

    public static List<UserAccount> loadUsers() {
        ensureFileExists();
        List<UserAccount> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(USER_FILE, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                // Use a quoted delimiter regex to avoid accidental split errors.
                String[] parts = line.split(Pattern.quote(DELIMITER), -1);
                if (parts.length != 3) {
                    continue;
                }
                users.add(new UserAccount(parts[0], parts[1], parts[2]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read users file.", e);
        }
        return users;
    }

    public static void saveUsers(List<UserAccount> users) {
        ensureFileExists();
        List<String> lines = new ArrayList<>();
        for (UserAccount user : users) {
            lines.add(user.getUsername() + DELIMITER + user.getPassword() + DELIMITER + user.getDisplayName());
        }
        try {
            Files.write(USER_FILE, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write users file.", e);
        }
    }

    private static void ensureFileExists() {
        try {
            Path parent = USER_FILE.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            if (!Files.exists(USER_FILE)) {
                Files.createFile(USER_FILE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to prepare users file.", e);
        }
    }

    // Force a single storage location: <module>/data/users.txt
    private static Path resolveUserFilePath() {
        Path current = Paths.get(System.getProperty("user.dir", "")).toAbsolutePath().normalize();
        if (current.getFileName() != null && MODULE_DIR_NAME.equals(current.getFileName().toString())) {
            return current.resolve("data").resolve("users.txt");
        }

        Path modulePath = current.resolve(MODULE_DIR_NAME);
        if (Files.exists(modulePath) && Files.isDirectory(modulePath)) {
            return modulePath.resolve("data").resolve("users.txt");
        }

        // Fallback for uncommon launch dirs.
        return current.resolve("data").resolve("users.txt");
    }
}

