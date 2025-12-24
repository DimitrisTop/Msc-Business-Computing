import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputFrame extends JFrame {

    private ArrayList<School> schools;
    private JTextField schoolField;
    private JPanel panel;

    private JButton ektypwsi;

    public InputFrame(ArrayList<School> schools) {

        this.schools = schools;

        panel = new JPanel();

        schoolField = new JTextField("Eisagete to onoma ths sxolikhs monadas pou sas endiaferei");

        ektypwsi = new JButton("Print cost");

        panel.add(schoolField);
        panel.add(ektypwsi);

        this.setContentPane(panel);

        ButtonListener printAll = new ButtonListener();
        ektypwsi.addActionListener(printAll);


        this.setSize(500, 250);
        this.setVisible(true);
        this.setTitle("Input Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String value = schoolField.getText();
            for(School s: schools) {
                if (value.equals(s.getName())) {
                    s.printTeachers();
                }
            }

        }


    }

}
