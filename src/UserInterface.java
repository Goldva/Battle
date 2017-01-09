import warriors.NamesAllCharacters;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UserInterface extends JFrame {
    private JTextField nameSquadFirst;
    private JTextField nameSquadSecond;
    private JTextField warriorName;
    private JTextArea listSquadFirst;
    private JTextArea listSquadSecond;
    private JTextArea consoleText;
    private JComboBox<NamesAllCharacters> listWarriors;
    private JButton addToFirstSquadButton;
    private JButton addToSecondSquadButton;
    private JButton fightButton;

    public UserInterface() {
        super("Битва");
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

        listWarriors = getComboBox();

        addToFirstSquadButton = getBtnAddWarrior("Добавить в 1-ый отряд", listSquadFirst);
        addToSecondSquadButton = getBtnAddWarrior("Добавить во 2-ой отряд", listSquadSecond);
        fightButton = getBtnFight("В бой!");


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

    private JComboBox<NamesAllCharacters> getComboBox(){
        return new JComboBox<>(NamesAllCharacters.values());                                                //TODO: NamesAllCharacters изменить
    }

    private JTextArea getTextArea() {
        JTextArea textArea = new JTextArea(10, 10);
        textArea.setEditable(false);
        return textArea;
    }

    private JButton getBtnAddWarrior(String nameBtn, JTextArea listSquad) {
        JButton btn = new JButton(nameBtn);
        btn.addActionListener(e -> {
            String character = listWarriors.getSelectedItem().toString();                                   //TODO: в контроллер
            String name = warriorName.getText();
            listSquad.append(character + " - " + name + "\n");
        });
        return btn;
    }

    private JButton getBtnFight(String nameBtn) {
        JButton btn = new JButton(nameBtn);
        btn.addActionListener(e -> {
            Battle battle = new Battle();
            battle.newSquads(nameSquadFirst.getText(), listSquadFirst.getText().split("\n"));
            battle.newSquads(nameSquadSecond.getText(), listSquadSecond.getText().split("\n"));

            consoleText.setText("Начало поединка " + battle.getDateHelper().getFormattedStartDate() + "\n");
            consoleText.append(battle.battleProgress() + "\n");
            consoleText.append(battle.getDateHelper().getFormattedDiff() + "\n");
        });
        return btn;
    }
}
