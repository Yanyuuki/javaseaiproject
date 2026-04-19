package com.yanyuuki.ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class RegisterUI extends JFrame implements ActionListener {

    private static final Font TITLE_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 28);
    private static final Font SUB_TITLE_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 14);
    private static final Font TEXT_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 14);
    private static final Font BUTTON_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 14);

    private static final Color CARD_BORDER = new Color(196, 208, 228, 160);
    private static final Color INPUT_BORDER = new Color(202, 214, 233);
    private static final Color INPUT_BG = new Color(248, 251, 255);

    private static final String CMD_REGISTER = "register";
    private static final String CMD_BACK = "back";

    private final LoginUI loginUI;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField displayNameField;

    public RegisterUI(LoginUI loginUI) {
        this.loginUI = loginUI;
        if (SwingUtilities.isEventDispatchThread()) {
            initWindow();
        } else {
            SwingUtilities.invokeLater(this::initWindow);
        }
    }

    public RegisterUI() {
        this(null);
    }

    private void initWindow() {
        setTitle("Register Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 560);
        setMinimumSize(new Dimension(760, 480));
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                showLoginUI();
            }
        });

        GradientPanel background = new GradientPanel();
        background.setLayout(new GridBagLayout());

        RoundedPanel card = new RoundedPanel(24, new Color(255, 255, 255, 246));
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(620, 430));
        card.setBorder(BorderFactory.createEmptyBorder(26, 30, 24, 30));

        JPanel top = new JPanel();
        top.setOpaque(false);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Create Account");
        title.setFont(TITLE_FONT);
        title.setForeground(new Color(32, 48, 74));
        title.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        JLabel subTitle = new JLabel("Register a new user for the HR management system");
        subTitle.setFont(SUB_TITLE_FONT);
        subTitle.setForeground(new Color(102, 116, 137));
        subTitle.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        top.add(title);
        top.add(Box.createVerticalStrut(6));
        top.add(subTitle);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        usernameField = new JTextField();
        styleInput(usernameField, "Username");
        formPanel.add(labeled("Username", usernameField), gbc);

        gbc.gridy++;
        displayNameField = new JTextField();
        styleInput(displayNameField, "Display Name");
        formPanel.add(labeled("Display Name", displayNameField), gbc);

        gbc.gridy++;
        passwordField = new JPasswordField();
        styleInput(passwordField, "Password");
        formPanel.add(labeled("Password", passwordField), gbc);

        gbc.gridy++;
        confirmPasswordField = new JPasswordField();
        styleInput(confirmPasswordField, "Confirm Password");
        formPanel.add(labeled("Confirm Password", confirmPasswordField), gbc);

        gbc.gridy++;
        JPanel buttonRow = new JPanel(new GridBagLayout());
        buttonRow.setOpaque(false);

        JButton registerButton = new RoundedButton("Register", new Color(32, 93, 222), Color.WHITE);
        registerButton.setActionCommand(CMD_REGISTER);
        registerButton.addActionListener(this);

        JButton backButton = new RoundedButton("Back", new Color(236, 241, 250), new Color(53, 74, 106));
        backButton.setActionCommand(CMD_BACK);
        backButton.addActionListener(this);

        GridBagConstraints bGbc = new GridBagConstraints();
        bGbc.gridx = 0;
        bGbc.insets = new Insets(0, 0, 0, 12);
        buttonRow.add(registerButton, bGbc);

        bGbc.gridx = 1;
        bGbc.insets = new Insets(0, 0, 0, 0);
        buttonRow.add(backButton, bGbc);

        formPanel.add(buttonRow, gbc);

        getRootPane().setDefaultButton(registerButton);
        getRootPane().registerKeyboardAction(
                ignored -> goBack(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        card.add(top, BorderLayout.NORTH);
        card.add(formPanel, BorderLayout.CENTER);

        background.add(card);
        setContentPane(background);
        setVisible(true);
    }

    private JPanel labeled(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(0, 4));
        panel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setForeground(new Color(65, 80, 104));

        panel.add(label, BorderLayout.NORTH);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }

    private void styleInput(JTextField field, String toolTip) {
        field.setToolTipText(toolTip);
        field.setPreferredSize(new Dimension(420, 40));
        field.setFont(TEXT_FONT);
        field.setForeground(new Color(38, 52, 72));
        field.setBackground(INPUT_BG);
        field.setCaretColor(new Color(32, 93, 222));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(INPUT_BORDER, 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        if (field instanceof JPasswordField) {
            ((JPasswordField) field).setEchoChar((char) 8226);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (CMD_REGISTER.equals(cmd)) {
            handleRegister();
            return;
        }
        if (CMD_BACK.equals(cmd)) {
            goBack();
        }
    }

    private void handleRegister() {
        String username = usernameField.getText().trim();
        String displayName = displayNameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirm = new String(confirmPasswordField.getPassword());

        if (username.isEmpty() || displayName.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (username.contains("|") || displayName.contains("|") || password.contains("|")) {
            JOptionPane.showMessageDialog(this, "Fields cannot contain the '|' character.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Password and confirm password are not the same.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<UserAccount> users = UserStore.loadUsers();
        for (UserAccount user : users) {
            if (user.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists.", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        users.add(new UserAccount(username, password, displayName));
        UserStore.saveUsers(users);

        JOptionPane.showMessageDialog(this, "Register success. Please login.", "Success", JOptionPane.INFORMATION_MESSAGE);
        goBack();
    }

    private void goBack() {
        dispose();
        showLoginUI();
    }

    private void showLoginUI() {
        if (loginUI != null) {
            loginUI.onBackFromRegister();
        }
    }

    private static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(238, 244, 253),
                    getWidth(), getHeight(), new Color(228, 236, 250)
            );
            g2.setPaint(gradient);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
        }
    }

    private static class RoundedPanel extends JPanel {
        private final int arc;
        private final Color fillColor;

        private RoundedPanel(int arc, Color fillColor) {
            this.arc = arc;
            this.fillColor = fillColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(fillColor);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.setColor(CARD_BORDER);
            g2.setStroke(new BasicStroke(1.2f));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    private static class RoundedButton extends JButton {
        private final Color bgColor;

        private RoundedButton(String text, Color bgColor, Color fgColor) {
            super(text);
            this.bgColor = bgColor;

            setFont(BUTTON_FONT);
            setFocusPainted(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setForeground(fgColor);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setPreferredSize(new Dimension(168, 40));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color fill = getModel().isPressed() ? bgColor.darker() : (getModel().isRollover() ? bgColor.brighter() : bgColor);
            g2.setColor(fill);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);

            g2.setColor(new Color(0, 0, 0, 25));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 18, 18);
            g2.dispose();

            super.paintComponent(g);
        }
    }
}
