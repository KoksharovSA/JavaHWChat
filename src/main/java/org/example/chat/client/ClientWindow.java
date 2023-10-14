package org.example.chat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ClientWindow extends JFrame implements IWindow {
    private IClient client;

    @Override
    public void setClientWindow(IClient client) {
        this.client = client;
    }

    private static final int WIDTH = 500;
    private static final int HEIGHT = 650;
    String netStatus = "Disconnect";
    JButton buttonSend, buttonConnect;
    JTextField textFieldConnectionIP, textFieldConnectionPort, textFieldMessage, textFieldName;
    JLabel labelIP, labelPort, labelName;
    JTextArea textAreaChat;

    public ClientWindow() throws HeadlessException {
        configureWindow();
        createElements();
        arrangeElements();
        setVisible(true);
    }

    @Override
    public void printMessage(String message) {
        textAreaChat.append(message);
    }

    public void sendMessage(String message) throws IOException {
        client.sendMessage(message);
    }

    public void createElements() {
        buttonSend = new JButton("Send");
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sendMessage(textFieldName.getText() + ": " + textFieldMessage.getText() + "\n");
                    textFieldMessage.setText("");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonConnect = new JButton("Connect");
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (netStatus == "Disconnect") {
                    client.connect();
                    netStatus = "Online";
                    setTitle("OnlineChat - " + netStatus);
                    buttonConnect.setText("Disconnect");
                } else {
                    client.disconnect();
                    netStatus = "Disconnect";
                    setTitle("OnlineChat - " + netStatus);
                    buttonConnect.setText("Connect");
                    textAreaChat.setText("");
                }
            }
        });
        labelName = new JLabel("Name");
        labelName.setHorizontalAlignment(JLabel.RIGHT);
        labelIP = new JLabel("IP address");
        labelIP.setHorizontalAlignment(JLabel.RIGHT);
        labelPort = new JLabel("Port");
        labelPort.setHorizontalAlignment(JLabel.RIGHT);
        textFieldName = new JTextField();
        textFieldName.setText("Serg");
        textFieldConnectionIP = new JTextField();
        textFieldConnectionIP.setText("127.0.0.1");
        textFieldConnectionPort = new JTextField();
        textFieldConnectionPort.setText("55555");
        textFieldMessage = new JTextField();
        textFieldMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        sendMessage(textFieldName.getText() + ": " + textFieldMessage.getText() + "\n");
                        textFieldMessage.setText("");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        textAreaChat = new JTextArea();
        textAreaChat.setEditable(false);
        textAreaChat.setWrapStyleWord(true);
    }

    public void arrangeElements() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(4, 4, 4, 4));

        gridBagLayout.rowHeights = new int[]{23, 23, 23, 500, 23};
        gridBagLayout.rowWeights = new double[]{1, 1, 1, 1, 1};
        gridBagLayout.columnWeights = new double[]{1, 1, 1, 1};
        gridBagLayout.columnWidths = new int[]{80, 125, 125, 125};

        panel.setLayout(gridBagLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.insets = new Insets(0, 0, 0, 4);
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelName, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelIP, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(labelPort, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(textFieldName, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldConnectionIP, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(textFieldConnectionPort, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weighty = 0.9;
        constraints.gridx = 3;
        constraints.gridy = 0;
        panel.add(buttonConnect, constraints);

        constraints.insets = new Insets(4, 0, 4, 0);
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(textAreaChat, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridwidth = 3;
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(textFieldMessage, constraints);

        constraints.gridx = 3;
        constraints.gridy = 4;
        panel.add(buttonSend, constraints);

        this.add(panel);
    }

    public void configureWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("OnlineChat - " + netStatus);
        setResizable(false);
    }
}
