package com.yanyuuki.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeManagerUI extends JFrame implements ActionListener {

    private static final String[] COLUMNS = {"ID", "姓名", "性别", "年龄", "电话", "职位", "入职时间", "薪水", "部门信息"};
    private static final String APP_TITLE = "Human Resource Management System";
    private static final String CMD_SEARCH = "search";
    private static final String CMD_ADD = "add";
    private static final String CMD_EDIT = "edit";
    private static final String CMD_DELETE = "delete";
    private static final String DELIMITER = "|";
    private static final String MODULE_DIR_NAME = "itheima-employee-sys";
    private static final Path EMPLOYEE_FILE = resolveEmployeeFilePath();

    private static final Font TITLE_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 28);
    private static final Font SUB_TITLE_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 14);
    private static final Font TEXT_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 14);
    private static final Font BUTTON_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 14);

    private static final Color CARD_BORDER = new Color(196, 208, 228, 160);
    private static final Color INPUT_BORDER = new Color(202, 214, 233);
    private static final Color INPUT_BG = new Color(248, 251, 255);

    private final String currentUsername;
    private final List<Employee> allEmployees = new ArrayList<>();

    private JTextField searchField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel countLabel;
    private JLabel currentUserLabel;

    // 构造即启动：确保在 Swing 事件派发线程中初始化界面。
    public EmployeeManagerUI() {
        this("Unknown");
    }

    public EmployeeManagerUI(String currentUsername) {
        this.currentUsername = currentUsername;
        if (SwingUtilities.isEventDispatchThread()) {
            initWindow();
        } else {
            SwingUtilities.invokeLater(this::initWindow);
        }
    }

    // 独立运行入口，便于���接调试本界面。
    public static void main(String[] args) {
        new EmployeeManagerUI();
    }

    // 初始化主窗口与整体布局结构（背景层 + 卡片层）。
    private void initWindow() {
        setupLookAndFeel();

        setTitle(APP_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 700);
        setMinimumSize(new Dimension(900, 560));
        setLocationRelativeTo(null);

        GradientPanel background = new GradientPanel();
        background.setLayout(new GridBagLayout());

        RoundedPanel card = new RoundedPanel(24, new Color(255, 255, 255, 246));
        card.setLayout(new BorderLayout(0, 10));
        card.setPreferredSize(new Dimension(980, 620));
        card.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        card.setBorder(BorderFactory.createEmptyBorder(22, 24, 20, 24));
        card.add(createHeaderPanel(), BorderLayout.NORTH);
        card.add(createBodyPanel(), BorderLayout.CENTER);

        background.add(card);
        setContentPane(background);

        loadEmployeesFromFile();
        reloadTable("");

        setVisible(true);
    }

    // 头部：标题、副标题、当前筛选结果统计。
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JPanel titleBox = new JPanel();
        titleBox.setOpaque(false);
        titleBox.setLayout(new BoxLayout(titleBox, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Employee Information Management");
        title.setFont(TITLE_FONT);
        title.setForeground(new Color(32, 48, 74));
        title.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JLabel subTitle = new JLabel("Search, add, edit and delete employee records efficiently");
        subTitle.setFont(SUB_TITLE_FONT);
        subTitle.setForeground(new Color(102, 116, 137));
        subTitle.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        countLabel = new JLabel("Showing 0 / 0");
        countLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
        countLabel.setForeground(new Color(52, 76, 112));
        countLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 216, 238), 1),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        currentUserLabel = new JLabel("Current user: " + currentUsername);
        currentUserLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
        currentUserLabel.setForeground(new Color(52, 76, 112));
        currentUserLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 216, 238), 1),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        titleBox.add(title);
        titleBox.add(Box.createVerticalStrut(6));
        titleBox.add(subTitle);

        header.add(titleBox, BorderLayout.WEST);
        JPanel rightInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        rightInfoPanel.setOpaque(false);
        rightInfoPanel.add(currentUserLabel);
        rightInfoPanel.add(countLabel);
        header.add(rightInfoPanel, BorderLayout.EAST);
        return header;
    }

    // 主体：上方搜索操作区 + 中部表格区。
    private JPanel createBodyPanel() {
        JPanel body = new JPanel(new BorderLayout(0, 10));
        body.setOpaque(false);
        body.add(createTopPanel(), BorderLayout.NORTH);
        body.add(createTablePanel(), BorderLayout.CENTER);
        return body;
    }

    // 第一行操作区（居中）：关键词输入、搜索、新增。
    private JPanel createTopPanel() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);

        // First row is centered: input + search + add.
        JPanel topRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        topRow.setOpaque(false);

        searchField = new JTextField(24);
        styleInput(searchField);

        JButton searchButton = new RoundedButton("Search", new Color(32, 93, 222), Color.WHITE);
        JButton addButton = new RoundedButton("Add", new Color(236, 241, 250), new Color(53, 74, 106));
        searchButton.setActionCommand(CMD_SEARCH);
        addButton.setActionCommand(CMD_ADD);

        JLabel keywordLabel = new JLabel("Keyword:");
        keywordLabel.setFont(TEXT_FONT);
        keywordLabel.setForeground(new Color(65, 80, 104));

        topRow.add(keywordLabel);
        topRow.add(searchField);
        topRow.add(searchButton);
        topRow.add(addButton);

        searchButton.addActionListener(this);
        addButton.addActionListener(this);
        searchField.setActionCommand(CMD_SEARCH);
        searchField.addActionListener(this);

        wrapper.add(topRow, BorderLayout.CENTER);
        return wrapper;
    }

    // 表格区：只读表格 + 右键菜单��编辑/删除）。
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        tableModel = new DefaultTableModel(COLUMNS, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        table.setGridColor(new Color(230, 236, 247));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setFont(TEXT_FONT);
        table.setForeground(new Color(52, 65, 86));
        table.setSelectionBackground(new Color(220, 233, 255));
        table.setSelectionForeground(new Color(32, 48, 74));

        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        header.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
        header.setBackground(new Color(236, 242, 252));
        header.setForeground(new Color(48, 66, 94));

        JPopupMenu rowMenu = createRowPopupMenu();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopupIfNeeded(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopupIfNeeded(e);
            }

            private void showPopupIfNeeded(MouseEvent e) {
                // 右键前先选中当前行，保证菜单操作作用于目标数据。
                if (!e.isPopupTrigger()) {
                    return;
                }
                int row = table.rowAtPoint(e.getPoint());
                if (row < 0) {
                    return;
                }
                table.setRowSelectionInterval(row, row);
                rowMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(216, 226, 242), 1),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    // 每行右键菜单：编辑和删除。
    private JPopupMenu createRowPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem deleteItem = new JMenuItem("Delete");
        editItem.setActionCommand(CMD_EDIT);
        deleteItem.setActionCommand(CMD_DELETE);

        editItem.addActionListener(this);
        deleteItem.addActionListener(this);

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        return popupMenu;
    }

    // 新增流程：弹表单 -> 校验 ID 唯一 -> 入库并刷新。
    private void handleAdd() {
        EmployeeFormResult result = showEmployeeForm(null);
        if (result == null) {
            return;
        }

        if (findById(result.id) != null) {
            JOptionPane.showMessageDialog(this, "Employee ID already exists.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        allEmployees.add(result.toEmployee());
        saveEmployeesToFile();
        reloadTable(searchField.getText());
    }

    // 编辑流程：读取当前行 -> 回填表单 -> 校验并更新 -> 刷新。
    private void handleEdit() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }

        String selectedId = String.valueOf(tableModel.getValueAt(selectedRow, 0));
        Employee target = findById(selectedId);
        if (target == null) {
            return;
        }

        EmployeeFormResult result = showEmployeeForm(target);
        if (result == null) {
            return;
        }

        if (!target.id.equals(result.id) && findById(result.id) != null) {
            JOptionPane.showMessageDialog(this, "Employee ID already exists.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        target.id = result.id;
        target.name = result.name;
        target.gender = result.gender;
        target.age = result.age;
        target.position = result.position;
        target.salary = result.salary;
        target.department = result.department;
        target.phone = result.phone;
        target.hireDate = result.hireDate;

        saveEmployeesToFile();
        reloadTable(searchField.getText());
    }

    // 删除流程：确认后删除并刷新。
    private void handleDelete() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }

        String selectedId = String.valueOf(tableModel.getValueAt(selectedRow, 0));
        Employee target = findById(selectedId);
        if (target == null) {
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete employee " + target.name + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        allEmployees.remove(target);
        saveEmployeesToFile();
        reloadTable(searchField.getText());
    }

    // 统一的新增/编辑表单弹窗。
    private EmployeeFormResult showEmployeeForm(Employee employee) {
        boolean editMode = employee != null;

        JTextField idField = new JTextField(editMode ? employee.id : "", 18);
        JTextField nameField = new JTextField(editMode ? employee.name : "", 18);
        JTextField genderField = new JTextField(editMode ? employee.gender : "", 18);
        JTextField ageField = new JTextField(editMode ? employee.age : "", 18);
        JTextField phoneField = new JTextField(editMode ? employee.phone : "", 18);
        JTextField positionField = new JTextField(editMode ? employee.position : "", 18);
        JTextField hireDateField = new JTextField(editMode ? employee.hireDate : "", 18);
        JTextField salaryField = new JTextField(editMode ? employee.salary : "", 18);
        JTextField departmentField = new JTextField(editMode ? employee.department : "", 18);

        styleInput(idField);
        styleInput(nameField);
        styleInput(genderField);
        styleInput(ageField);
        styleInput(phoneField);
        styleInput(positionField);
        styleInput(hireDateField);
        styleInput(salaryField);
        styleInput(departmentField);

        JPanel form = new JPanel(new GridLayout(0, 2, 10, 8));
        form.setBorder(BorderFactory.createEmptyBorder(8, 4, 8, 4));
        form.add(new JLabel("ID:"));
        form.add(idField);
        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("Gender:"));
        form.add(genderField);
        form.add(new JLabel("Age:"));
        form.add(ageField);
        form.add(new JLabel("Phone:"));
        form.add(phoneField);
        form.add(new JLabel("Position:"));
        form.add(positionField);
        form.add(new JLabel("Hire Date (yyyy-MM-dd):"));
        form.add(hireDateField);
        form.add(new JLabel("Salary:"));
        form.add(salaryField);
        form.add(new JLabel("Department:"));
        form.add(departmentField);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(form);

        int option = JOptionPane.showConfirmDialog(
                this,
                wrapper,
                editMode ? "Edit Employee" : "Add Employee",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (option != JOptionPane.OK_OPTION) {
            return null;
        }

        EmployeeFormResult result = new EmployeeFormResult(
                idField.getText().trim(),
                nameField.getText().trim(),
                genderField.getText().trim(),
                ageField.getText().trim(),
                phoneField.getText().trim(),
                positionField.getText().trim(),
                hireDateField.getText().trim(),
                salaryField.getText().trim(),
                departmentField.getText().trim()
        );

        if (!result.isValid()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case CMD_SEARCH:
                reloadTable(searchField.getText());
                break;
            case CMD_ADD:
                handleAdd();
                break;
            case CMD_EDIT:
                handleEdit();
                break;
            case CMD_DELETE:
                handleDelete();
                break;
            default:
                break;
        }
    }

    // 根据关键词重建表格数据，同时更新右上角计数。
    private void reloadTable(String keyword) {
        String q = keyword == null ? "" : keyword.trim().toLowerCase();
        tableModel.setRowCount(0);
        int shown = 0;
        for (Employee employee : allEmployees) {
            if (matches(employee, q)) {
                tableModel.addRow(new Object[]{
                        employee.id,
                        employee.name,
                        employee.gender,
                        employee.age,
                        employee.phone,
                        employee.position,
                        employee.hireDate,
                        employee.salary,
                        employee.department
                });
                shown++;
            }
        }
        if (countLabel != null) {
            countLabel.setText("Showing " + shown + " / " + allEmployees.size());
        }
    }

    // 搜索匹配策略：按 ID/姓名/部门/电话模糊匹配。
    private boolean matches(Employee employee, String q) {
        if (q.isEmpty()) {
            return true;
        }
        return employee.id.toLowerCase().contains(q)
                || employee.name.toLowerCase().contains(q)
                || employee.gender.toLowerCase().contains(q)
                || employee.age.toLowerCase().contains(q)
                || employee.position.toLowerCase().contains(q)
                || employee.salary.toLowerCase().contains(q)
                || employee.department.toLowerCase().contains(q)
                || employee.phone.toLowerCase().contains(q);
    }

    // 根据员工 ID 查找对象。
    private Employee findById(String id) {
        for (Employee employee : allEmployees) {
            if (employee.id.equals(id)) {
                return employee;
            }
        }
        return null;
    }

    // 从文件读取员工数据。
    private void loadEmployeesFromFile() {
        allEmployees.clear();
        ensureEmployeeFileExists();
        try {
            List<String> lines = Files.readAllLines(EMPLOYEE_FILE, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] p = line.split(Pattern.quote(DELIMITER), -1);
                if (p.length != 9) {
                    continue;
                }
                allEmployees.add(new Employee(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read employees file.", e);
        }
    }

    // 将当前员工数据写回文件。
    private void saveEmployeesToFile() {
        ensureEmployeeFileExists();
        List<String> lines = new ArrayList<>();
        for (Employee employee : allEmployees) {
            lines.add(employee.id + DELIMITER + employee.name + DELIMITER + employee.gender + DELIMITER + employee.age +
                    DELIMITER + employee.phone + DELIMITER + employee.position + DELIMITER + employee.hireDate +
                    DELIMITER + employee.salary + DELIMITER + employee.department);
        }
        try {
            Files.write(EMPLOYEE_FILE, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write employees file.", e);
        }
    }

    private void ensureEmployeeFileExists() {
        try {
            Path parent = EMPLOYEE_FILE.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            if (!Files.exists(EMPLOYEE_FILE)) {
                Files.createFile(EMPLOYEE_FILE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to prepare employees file.", e);
        }
    }

    // Lock employee data into <module>/data/employees.txt to avoid path drift.
    private static Path resolveEmployeeFilePath() {
        Path current = Paths.get(System.getProperty("user.dir", "")).toAbsolutePath().normalize();
        if (current.getFileName() != null && MODULE_DIR_NAME.equals(current.getFileName().toString())) {
            return current.resolve("data").resolve("employees.txt");
        }

        Path modulePath = current.resolve(MODULE_DIR_NAME);
        if (Files.exists(modulePath) && Files.isDirectory(modulePath)) {
            return modulePath.resolve("data").resolve("employees.txt");
        }

        return current.resolve("data").resolve("employees.txt");
    }

    // 输入框统一样式：字体、边框、背景、光标色。
    private void styleInput(JTextField field) {
        field.setPreferredSize(new Dimension(240, 38));
        field.setFont(TEXT_FONT);
        field.setForeground(new Color(38, 52, 72));
        field.setBackground(INPUT_BG);
        field.setCaretColor(new Color(32, 93, 222));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(INPUT_BORDER, 1),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));
    }

    // 尝试应用 Nimbus 外观，失败则回退系统默认外观。
    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }
    }

    // 页面整体浅色渐变背景。
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

    // 圆角卡片容器（白底 + 细边框）。
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

    // 自定义圆角按钮：根据悬停/按下状态动态变色。
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
            setPreferredSize(new Dimension(120, 38));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color fill = getModel().isPressed() ? bgColor.darker() : (getModel().isRollover() ? bgColor.brighter() : bgColor);
            g2.setColor(fill);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);

            g2.setColor(new Color(0, 0, 0, 25));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 16, 16);
            g2.dispose();

            super.paintComponent(g);
        }
    }

    private static class Employee {
        private String id;
        private String name;
        private String gender;
        private String age;
        private String position;
        private String salary;
        private String department;
        private String phone;
        private String hireDate;

        private Employee(String id, String name, String gender, String age, String phone, String position, String hireDate, String salary, String department) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.phone = phone;
            this.position = position;
            this.hireDate = hireDate;
            this.salary = salary;
            this.department = department;
        }
    }

    private static class EmployeeFormResult {
        private final String id;
        private final String name;
        private final String gender;
        private final String age;
        private final String phone;
        private final String position;
        private final String hireDate;
        private final String salary;
        private final String department;

        private EmployeeFormResult(String id, String name, String gender, String age, String phone, String position, String hireDate, String salary, String department) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.phone = phone;
            this.position = position;
            this.hireDate = hireDate;
            this.salary = salary;
            this.department = department;
        }

        private boolean isValid() {
            return !id.isEmpty()
                    && !name.isEmpty()
                    && !gender.isEmpty()
                    && !age.isEmpty()
                    && !phone.isEmpty()
                    && !position.isEmpty()
                    && !hireDate.isEmpty()
                    && !salary.isEmpty()
                    && !department.isEmpty();
        }

        private Employee toEmployee() {
            return new Employee(id, name, gender, age, phone, position, hireDate, salary, department);
        }
    }
}
