package com.itheima.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 局域网聊天室登录界面
 */
public class ChatEntryUI extends JFrame {

    private JTextField nicknameField;
    private JButton enterButton;
    private JButton cancelButton;

    public ChatEntryUI() {
        setTitle("聊天室登录");
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setupWindowProperties();
    }

    private void initializeComponents() {
        // 创建组件
        JLabel nicknameLabel = new JLabel("昵称:");
        nicknameField = new JTextField(15);
        enterButton = new JButton("进入");
        cancelButton = new JButton("取消");
    }

    private void setupLayout() {
        // 设置主面板布局
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 昵称标签
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("昵称:"), gbc);

        // 昵称输入框
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(nicknameField, gbc);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    private void setupEventHandlers() {
        // 进入按钮事件
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        // 取消按钮事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 回车键登录
        nicknameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String nickname = nicknameField.getText().trim();
        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入昵称", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 这里可以添加进入聊天室的逻辑
        JOptionPane.showMessageDialog(this, "欢迎 " + nickname + " 进入聊天室！", "登录成功", JOptionPane.INFORMATION_MESSAGE);

        // 隐藏登录窗口，打开聊天窗口
        setVisible(false);
        // TODO: 打开聊天主窗口
    }

    private void setupWindowProperties() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 200); // 设置窗口大小
        setLocationRelativeTo(null); // 居中显示
    }

    public static void main(String[] args) {
        // 设置外观
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 在事件调度线程中创建和显示GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatEntryUI().setVisible(true);
            }
        });
    }
}
