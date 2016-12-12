import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {
    public UserInterface() {
        super("Битва");

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
        JTextField nameSquadFirst = new JTextField("Введите имя 1-ого отряда", 20);
        JTextField nameSquadSecond = new JTextField("Введите имя 2-ого отряда", 20);
        JTextField warriorName = new JTextField("Введите имя война", 20);

        JTextArea listSquadFirst = new JTextArea(20, 10);
        JTextArea listSquadSecond = new JTextArea(20, 10);

        JComboBox listWarriors = new JComboBox();
        listWarriors.setName("sssss");

        JButton addToFirstSquad = new JButton("Добавить в 1-ый отряд");
        JButton addToSecondSquad = new JButton("Добавить во 2-ой отряд");

        JTextArea consoleText = new JTextArea(20, 10);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(consoleText)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(nameSquadFirst)
                                .addComponent(listSquadFirst)
                                .addComponent(addToFirstSquad)
                                .addComponent(warriorName)
                                .addComponent(listWarriors))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(nameSquadSecond)
                                .addComponent(listSquadSecond)
                                .addComponent(addToSecondSquad))));

        layout.linkSize(SwingConstants.HORIZONTAL, addToFirstSquad, addToSecondSquad);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(consoleText))
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
                                .addComponent(addToFirstSquad)
                                .addComponent(addToSecondSquad))));

//        layout.setHorizontalGroup(layout.createSequentialGroup()
//                .addComponent(label)
//                .addGroup(layout.createParallelGroup(LEADING)
//                        .addComponent(textField)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(LEADING)
//                                        .addComponent(caseCheckBox)
//                                        .addComponent(wholeCheckBox))
//                                .addGroup(layout.createParallelGroup(LEADING)
//                                        .addComponent(wrapCheckBox)
//                                        .addComponent(backCheckBox))))
//                .addGroup(layout.createParallelGroup(LEADING)
//                        .addComponent(findButton)
//                        .addComponent(cancelButton)));
//
//        layout.linkSize(SwingConstants.HORIZONTAL, findButton, cancelButton);
//
//        layout.setVerticalGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(BASELINE)
//                        .addComponent(label)
//                        .addComponent(textField)
//                        .addComponent(findButton))
//                .addGroup(layout.createParallelGroup(LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(BASELINE)
//                                        .addComponent(caseCheckBox)
//                                        .addComponent(wrapCheckBox))
//                                .addGroup(layout.createParallelGroup(BASELINE)
//                                        .addComponent(wholeCheckBox)
//                                        .addComponent(backCheckBox)))
//                        .addComponent(cancelButton)));



//        layout.setHorizontalGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addComponent(nameSquadFirst)
//                        .addComponent(listSquadFirst))
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addComponent(nameSquadSecond)
//                        .addComponent(listSquadSecond))
//                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addComponent(warriorName)
//                        .addComponent(listWarriors))
////                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
////                        .addComponent(addToFirstSquad)
////                        .addComponent(addToSecondSquad))

//                );


//        layout.linkSize(SwingConstants.HORIZONTAL, addToFirstSquad, addToSecondSquad);


    }
}
