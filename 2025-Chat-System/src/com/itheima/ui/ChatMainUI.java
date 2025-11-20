package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 聊天室主界面
 */
public class ChatMainUI extends JFrame {
    private JTextArea messageArea;      // 消息展示区域
    private JList<String> userList;     // 在线用户列表
    private JTextField messageField;    // 消息输入框
    private JButton sendButton;         // 发送按钮
    private DefaultListModel<String> userListModel; // 用户列表模型
    
    public ChatMainUI(String username) {
        setTitle("聊天室 - " + username);
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setupWindowProperties();
        
        // 添加示例数据
        addSampleData();
    }
    
    private void initializeComponents() {
        // 消息展示区域
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        messageArea.setBackground(Color.WHITE);
        
        // 用户列表模型和列表
        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userList.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        userList.setBackground(Color.WHITE);
        
        // 消息输入框和发送按钮
        messageField = new JTextField(20);
        messageField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        sendButton = new JButton("发送");
        sendButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        sendButton.setFocusPainted(false);
        
        // 设置按钮背景色和边框
        sendButton.setBackground(new Color(70, 130, 180));
        sendButton.setForeground(Color.BLACK);  // 字体设为黑色
        sendButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(5, 5));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // 中间部分：消息展示区和用户列表
        JSplitPane centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        centerPanel.setDividerLocation(480);  // 调整分割位置，减小右侧面板宽度
        centerPanel.setResizeWeight(0.8);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        // 左侧消息展示区
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        messageScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messageScrollPane.setBorder(new TitledBorder("消息记录"));
        centerPanel.setLeftComponent(messageScrollPane);
        
        // 右侧用户列表
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        userScrollPane.setBorder(new TitledBorder("在线用户"));
        centerPanel.setRightComponent(userScrollPane);
        
        add(centerPanel, BorderLayout.CENTER);
        
        // 下方消息输入区域
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 0));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        
        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void setupEventHandlers() {
        // 发送按钮事件
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        
        // 回车发送消息
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        
        // 窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitChat();
            }
        });
    }
    
    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            // 这里应该发送消息到服务器
            appendMessage("我: " + message);
            messageField.setText("");
        }
    }
    
    private void appendMessage(String message) {
        messageArea.append(message + "\n");
        messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }
    
    private void exitChat() {
        int option = JOptionPane.showConfirmDialog(
            this, 
            "确定要退出聊天室吗？", 
            "退出确认", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (option == JOptionPane.YES_OPTION) {
            // 这里应该通知服务器用户离开
            System.exit(0);
        }
    }
    
    private void setupWindowProperties() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(650, 450);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
    }
    
    // 添加示例数据用于演示
    private void addSampleData() {
        // 添加示例消息
        appendMessage("系统消息: 欢迎进入聊天室!");
        appendMessage("张三: 大家好!");
        appendMessage("李四: 欢迎新朋友!");
        
        // 添加示例用户
        userListModel.addElement("张三");
        userListModel.addElement("李四");
        userListModel.addElement("王五");
        userListModel.addElement("赵六");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                new ChatMainUI("测试用户").setVisible(true);
            }
        });
    }
}