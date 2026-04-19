package com.yanyuuki.ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
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
import java.util.List;

public class LoginUI extends JFrame implements ActionListener {

    // ==================== 字体配置（统一视觉风格） ====================
    private static final Font TITLE_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 30);
    private static final Font SUB_TITLE_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 15);
    private static final Font TEXT_FONT = new Font("Microsoft YaHei UI", Font.PLAIN, 14);
    private static final Font BUTTON_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 14);
    private static final Font BRAND_FONT = new Font("Microsoft YaHei UI", Font.BOLD, 34);

    // ==================== 颜色与文案配置（后续改主题优先改这里） ====================
    private static final Color CARD_BORDER = new Color(196, 208, 228, 160);
    private static final Color INPUT_BORDER = new Color(202, 214, 233);
    private static final Color INPUT_BG = new Color(248, 251, 255);
    private static final String APP_CN_TITLE = "人事管理系统";
    private static final String CMD_LOGIN = "login";
    private static final String CMD_REGISTER = "register";
    private static final String CMD_TOGGLE_PASSWORD = "toggle_password";

    // 保存输入组件引用：后续登录校验、清空表单都要访问。
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel tipsLabel;
    private JCheckBox showPasswordCheckBox;
    private JButton loginButton;
    private JButton registerButton;

    // 构造方法即启动入口：在任意类中 new LoginUI() 就会打开登录窗口。
    public LoginUI() {
        if (SwingUtilities.isEventDispatchThread()) {
            createAndShow();
        } else {
            SwingUtilities.invokeLater(this::createAndShow);
        }
    }

    // 程序入口：委托给构造方法，保持与其他类调用方式一致。
    public static void main(String[] args) {
        new LoginUI();
    }

    // 优先使用 Nimbus 外观；失败时回退到系统默认外观。
    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }
    }

    // 创建主窗口并把登录卡片放到中心区域。
    private void createAndShow() {
        // 先设置外观，再创建组件，确保风格一致。
        setupLookAndFeel();

        // 1) 创建顶层窗口。
        setTitle(APP_CN_TITLE + " - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 600);
        setMinimumSize(new Dimension(860, 520));
        setLocationRelativeTo(null);

        // 2) 创建页面背景容器（整窗浅色渐变），并使用 GridBag 把卡片居中。
        GradientPanel background = new GradientPanel();
        background.setLayout(new GridBagLayout());

        // 3) 创建核心登录卡片并放入背景容器。
        JPanel card = createCardPanel();
        background.add(card);

        // 4) 挂载并显示。
        setContentPane(background);
        setVisible(true);
    }

    // 组装登录卡片：左侧品牌区 + 右侧表单区。
    private JPanel createCardPanel() {
        // 最外层卡片：圆角 + 半透明白底，增强层次感。
        RoundedPanel card = new RoundedPanel(24, new Color(255, 255, 255, 246));
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(860, 500));
        card.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // 左侧品牌信息区域。
        JPanel leftBrand = new BrandPanel();
        leftBrand.setPreferredSize(new Dimension(330, 500));
        leftBrand.setLayout(new BoxLayout(leftBrand, BoxLayout.Y_AXIS));
        leftBrand.setBorder(BorderFactory.createEmptyBorder(56, 38, 40, 38));

        JLabel appName = new JLabel(APP_CN_TITLE);
        appName.setFont(BRAND_FONT);
        appName.setForeground(new Color(236, 244, 255));
        appName.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        JLabel appSubName = new JLabel("Human Resource Management");
        appSubName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        appSubName.setForeground(new Color(188, 209, 242));
        appSubName.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        JLabel desc1 = new JLabel("- Staff Lifecycle Management");
        desc1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        desc1.setForeground(new Color(179, 198, 228));
        desc1.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        JLabel desc2 = new JLabel("- Attendance & Leave Tracking");
        desc2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        desc2.setForeground(new Color(179, 198, 228));
        desc2.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        JLabel desc3 = new JLabel("- Performance & Payroll Support");
        desc3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        desc3.setForeground(new Color(179, 198, 228));
        desc3.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        leftBrand.add(appName);
        leftBrand.add(Box.createVerticalStrut(10));
        leftBrand.add(appSubName);
        leftBrand.add(Box.createVerticalStrut(26));
        leftBrand.add(desc1);
        leftBrand.add(Box.createVerticalStrut(10));
        leftBrand.add(desc2);
        leftBrand.add(Box.createVerticalStrut(10));
        leftBrand.add(desc3);

        // 右侧登录交互区域。
        JPanel right = new JPanel(new BorderLayout());
        right.setOpaque(false);
        right.setBorder(BorderFactory.createEmptyBorder(42, 48, 36, 48));

        JPanel top = new JPanel();
        top.setOpaque(false);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome Back");
        title.setFont(TITLE_FONT);
        title.setForeground(new Color(32, 48, 74));
        title.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        JLabel subTitle = new JLabel("Please sign in with your enterprise account");
        subTitle.setFont(SUB_TITLE_FONT);
        subTitle.setForeground(new Color(99, 115, 140));
        subTitle.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        top.add(title);
        top.add(Box.createVerticalStrut(8));
        top.add(subTitle);

        // 使用 GridBagLayout 让表单行间距和拉伸更稳定。
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);

        // GridBagConstraints 是“当前要添加组件”的布局参数对象。
        // 思路：每加一行组件，就让 gridy++，这样按行往下排。
        GridBagConstraints gbc = new GridBagConstraints();
        // 每行上下留 9 像素空白，提升阅读性。
        gbc.insets = new Insets(9, 0, 9, 0);
        // 组件在水平方向填满可用宽度。
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // 从第 0 列、第 0 行开始放。
        gbc.gridx = 0;
        gbc.gridy = 0;
        // 允许横向分配额外空间给当前列。
        gbc.weightx = 1;

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        userLabel.setForeground(new Color(65, 80, 104));
        formPanel.add(userLabel, gbc);

        gbc.gridy++;
        usernameField = new JTextField();
        styleInput(usernameField, "Username");
        formPanel.add(usernameField, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        passwordLabel.setForeground(new Color(65, 80, 104));
        formPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField();
        styleInput(passwordField, "Password");
        formPanel.add(passwordField, gbc);

        gbc.gridy++;
        JPanel optionsRow = new JPanel(new BorderLayout());
        optionsRow.setOpaque(false);

        showPasswordCheckBox = new JCheckBox("Show password");
        showPasswordCheckBox.setOpaque(false);
        showPasswordCheckBox.setFont(TEXT_FONT);
        showPasswordCheckBox.setForeground(new Color(80, 95, 118));
        showPasswordCheckBox.setActionCommand(CMD_TOGGLE_PASSWORD);
        showPasswordCheckBox.addActionListener(this);

        JCheckBox rememberMe = new JCheckBox("Remember me");
        rememberMe.setOpaque(false);
        rememberMe.setFont(TEXT_FONT);
        rememberMe.setForeground(new Color(80, 95, 118));

        optionsRow.add(showPasswordCheckBox, BorderLayout.WEST);
        optionsRow.add(rememberMe, BorderLayout.EAST);
        formPanel.add(optionsRow, gbc);

        gbc.gridy++;
        JPanel buttonRow = new JPanel(new GridBagLayout());
        buttonRow.setOpaque(false);

        loginButton = new RoundedButton("Login", new Color(32, 93, 222), Color.WHITE);
        registerButton = new RoundedButton("Register", new Color(236, 241, 250), new Color(53, 74, 106));
        loginButton.setActionCommand(CMD_LOGIN);
        registerButton.setActionCommand(CMD_REGISTER);

        // 单独给按钮行一套约束，避免影响主表单约束对象。
        GridBagConstraints buttonGbc = new GridBagConstraints();
        buttonGbc.gridx = 0;
        buttonGbc.gridy = 0;
        // 两个按钮之间留一点水平间距。
        buttonGbc.insets = new Insets(0, 0, 0, 12);
        buttonRow.add(loginButton, buttonGbc);

        buttonGbc.gridx = 1;
        buttonGbc.insets = new Insets(0, 0, 0, 0);
        buttonRow.add(registerButton, buttonGbc);

        formPanel.add(buttonRow, gbc);

        gbc.gridy++;
        tipsLabel = new JLabel("Please register first if no account exists.", SwingConstants.LEFT);
        tipsLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
        tipsLabel.setForeground(new Color(103, 116, 137));
        formPanel.add(tipsLabel, gbc);

        // 统一走 ActionListener：按钮点击和回车都在 actionPerformed 中分发。
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        passwordField.setActionCommand(CMD_LOGIN);
        passwordField.addActionListener(this);

        // 键盘快捷键：Enter 提交，Esc 清空输入。
        // setDefaultButton 会让 Enter 自动触发 loginButton。
        getRootPane().setDefaultButton(loginButton);
        getRootPane().registerKeyboardAction(
                ignored -> resetForm(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        right.add(top, BorderLayout.NORTH);
        right.add(formPanel, BorderLayout.CENTER);
        card.add(leftBrand, BorderLayout.WEST);
        card.add(right, BorderLayout.CENTER);
        return card;
    }

    // 统一输入框样式，避免每个字段重复设置。
    private void styleInput(JTextField field, String toolTip) {
        field.setToolTipText(toolTip);
        field.setPreferredSize(new Dimension(370, 43));
        field.setFont(TEXT_FONT);
        field.setForeground(new Color(38, 52, 72));
        field.setBackground(INPUT_BG);
        field.setCaretColor(new Color(32, 93, 222));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(INPUT_BORDER, 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        if (field instanceof JPasswordField) {
            // 密码框默认使用圆点掩码字符。
            ((JPasswordField) field).setEchoChar((char) 8226);
        }
    }

    // 演示登录逻辑：从文件读取用户数据进行登录校验。
    private void doLogin() {
        // trim() 去掉首尾空格，减少误输入问题。
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // 第一步：先做非空校验。
        if (username.isEmpty() || password.isEmpty()) {
            tipsLabel.setForeground(new Color(206, 54, 54));
            tipsLabel.setText("Username and password cannot be empty.");
            return;
        }

        List<UserAccount> users = UserStore.loadUsers();
        if (users.isEmpty()) {
            tipsLabel.setForeground(new Color(206, 54, 54));
            tipsLabel.setText("No user found. Please register first.");
            return;
        }

        UserAccount matchedUser = findUser(users, username, password);
        if (matchedUser != null) {
            tipsLabel.setForeground(new Color(24, 130, 84));
            tipsLabel.setText("Login successful. Welcome, " + matchedUser.getDisplayName() + ".");
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new EmployeeManagerUI(matchedUser.getUsername());
            dispose();
        } else {
            tipsLabel.setForeground(new Color(206, 54, 54));
            tipsLabel.setText("Incorrect username or password.");
            JOptionPane.showMessageDialog(this, "Incorrect username or password.", "Login Failed", JOptionPane.WARNING_MESSAGE);
        }
    }

    // 注册入口占位：后续可在这里跳转到真正的注册页面。
    private void doRegister() {
        setVisible(false);
        new RegisterUI(this);
    }

    // 清空输入并恢复默认提示。
    private void resetForm() {
        usernameField.setText("");
        passwordField.setText("");
        tipsLabel.setForeground(new Color(98, 112, 132));
        tipsLabel.setText("Please register first if no account exists.");
        // 重置后把焦点放回用户名，方便继续输入。
        usernameField.requestFocusInWindow();
    }

    // 在文件加载到的用户集合中查找匹配账号。
    private UserAccount findUser(List<UserAccount> users, String username, String password) {
        for (UserAccount user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // 从注册界面返回登录界面时调用。
    void onBackFromRegister() {
        resetForm();
        setVisible(true);
        toFront();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case CMD_LOGIN:
                doLogin();
                break;
            case CMD_REGISTER:
                doRegister();
                break;
            case CMD_TOGGLE_PASSWORD:
                // 切换密码是否可见。
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar((char) 8226);
                }
                break;
            default:
                break;
        }
    }

    // 主窗口浅色渐变背景。
    private static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Graphics2D 支持抗锯齿和渐变等高级绘制能力。
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

    // 左侧品牌区深色渐变和装饰圆形。
    private static class BrandPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 纵向渐变：顶部更深，底部更亮。
            GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(24, 61, 132),
                    getWidth(), getHeight(), new Color(39, 96, 188)
            );
            g2.setPaint(gradient);
            g2.fillRect(0, 0, getWidth(), getHeight());
            // 两个半透明圆形作为装饰元素，避免区域过于单调。
            g2.setColor(new Color(255, 255, 255, 36));
            g2.fillOval(-70, -40, 210, 210);
            g2.fillOval(getWidth() - 130, getHeight() - 120, 220, 220);
            g2.dispose();
        }
    }

    // 登录卡片圆角容器。
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
            // 先填充圆角背景，再绘制细边框。
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.setColor(CARD_BORDER);
            g2.setStroke(new BasicStroke(1.2f));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    // 自定义圆角按钮，并根据悬停/按下状态变色。
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

            // 根据按钮状态动态决定填充色。
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
