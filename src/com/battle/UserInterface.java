package com.battle;

import com.battle.controlers.UserInterfaceController;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UserInterface extends JFrame {
    private UserInterfaceController controller;
    private JTextField nameSquadFirst;
    private JTextField nameSquadSecond;
    private JTextField warriorName;
    private JTextArea listSquadFirst;
    private JTextArea listSquadSecond;
    private JTextArea consoleText;
    private JComboBox<String> characters;

    public UserInterface() {
        super("Битва");
        controller = new UserInterfaceController();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        addComponentToPane();
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserInterface();
    }

    public void addComponentToPane() {
        nameSquadFirst = getTextField("Введите имя 1-ого отряда");
        nameSquadSecond = getTextField("Введите имя 2-ого отряда");
        warriorName = getTextField("Введите имя война");

        listSquadFirst = getTextArea();
        listSquadSecond = getTextArea();
        consoleText = getTextArea();
        JScrollPane scrollConsoleText = new JScrollPane(consoleText);
        characters = getComboBox();

        JButton addToFirstSquadButton = getBtnAddWarrior("Добавить в 1-ый отряд", listSquadFirst);
        JButton addToSecondSquadButton = getBtnAddWarrior("Добавить во 2-ой отряд", listSquadSecond);
        JButton fightButton = getBtnFight("В бой!");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollConsoleText)
                        .addComponent(fightButton)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameSquadFirst)
                                        .addComponent(listSquadFirst)
                                        .addComponent(addToFirstSquadButton)
                                        .addComponent(warriorName)
                                        .addComponent(characters))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameSquadSecond)
                                        .addComponent(listSquadSecond)
                                        .addComponent(addToSecondSquadButton)))));

        layout.linkSize(SwingConstants.HORIZONTAL, addToFirstSquadButton, addToSecondSquadButton);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(scrollConsoleText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fightButton))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameSquadFirst)
                                .addComponent(nameSquadSecond))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(listSquadFirst)
                                .addComponent(listSquadSecond))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(warriorName))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(characters))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addToFirstSquadButton)
                                .addComponent(addToSecondSquadButton))));
    }

    private JTextField getTextField(String text) {
        JTextField textField = new JTextField(text, 20);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if ((textField.getText()).equals(text)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if ((textField.getText()).equals("")) {
                    textField.setText(text);
                }
            }
        });
        return textField;
    }

    private JComboBox<String> getComboBox() {
        return new JComboBox<>(controller.getAllCharactersName());
    }

    private JTextArea getTextArea() {
        JTextArea textArea = new JTextArea(10, 10);
        textArea.setEditable(false);
        return textArea;
    }

    private JButton getBtnAddWarrior(String nameBtn, JTextArea listSquad) {
        JButton btn = new JButton(nameBtn);
        btn.addActionListener(e -> {
            String character = characters.getSelectedItem().toString();
            String name = warriorName.getText();
            listSquad.append(character + " - " + name + "\n");
        });
        return btn;
    }

    private JButton getBtnFight(String nameBtn) {
        JButton btn = new JButton(nameBtn);
        btn.addActionListener(e -> controller.fight(this));
        return btn;
    }

    public JTextField getNameSquadFirst() {
        return nameSquadFirst;
    }

    public JTextField getNameSquadSecond() {
        return nameSquadSecond;
    }

    public JTextField getWarriorName() {
        return warriorName;
    }

    public JTextArea getListSquadFirst() {
        return listSquadFirst;
    }

    public JTextArea getListSquadSecond() {
        return listSquadSecond;
    }

    public JTextArea getConsoleText() {
        return consoleText;
    }

    public JComboBox<String> getCharacters() {
        return characters;
    }
}
