import sun.reflect.Reflection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    public UserInterface() {
        super("Битва");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ActionListener actionListener = new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JComboBox box = (JComboBox)e.getSource();
//                String item = (String)box.getSelectedItem();
////                label.setText(item);
//            }
//        };
//
        setSize(640, 480);
        addComponentToPane();
        pack();
        setVisible(true);
    }

    public void addComponentToPane() {
        JTextField nameSquadFirst = getTextField("Введите имя 1-ого отряда");
        JTextField nameSquadSecond = getTextField("Введите имя 2-ого отряда");
        JTextField warriorName = getTextField("Введите имя война");

        JTextArea listSquadFirst = new JTextArea(20, 10);
        listSquadFirst.setEditable(false);
        JTextArea listSquadSecond = new JTextArea(20, 10);
        listSquadSecond.setEditable(false);
        JTextArea consoleText = new JTextArea(10, 10);
        consoleText.setEditable(false);

        JComboBox listWarriors = getComboBox();

        JButton addToFirstSquadButton = new JButton("Добавить в 1-ый отряд");
        JButton addToSecondSquadButton = new JButton("Добавить во 2-ой отряд");
        JButton fightButton = new JButton("В бой!");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(consoleText)
                        .addComponent(fightButton)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameSquadFirst)
                                        .addComponent(listSquadFirst)
                                        .addComponent(addToFirstSquadButton)
                                        .addComponent(warriorName)
                                        .addComponent(listWarriors))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameSquadSecond)
                                        .addComponent(listSquadSecond)
                                        .addComponent(addToSecondSquadButton)))));

        layout.linkSize(SwingConstants.HORIZONTAL, addToFirstSquadButton, addToSecondSquadButton);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(consoleText))
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
                                .addComponent(listWarriors))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addToFirstSquadButton)
                                .addComponent(addToSecondSquadButton))));
    }

    private JTextField getTextField(String text){
        JTextField textField = new JTextField(text, 20);
//        ActionListener listener = e -> {
//            JTextField field = (JTextField) e.getSource();
//            if ((field.getText()).equals(text)){
//                System.out.println(field.getText());
//            }
//        };
//
//        textField.addActionListener(listener);
        return textField;
    }

    private JComboBox getComboBox(){
        JComboBox comboBox = new JComboBox();
        return comboBox;
    }
}
