import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class Form extends JFrame {
    JButton ADD,RETRIEVE,UPDATE,DELETE;
    JPanel panel;
    JLabel label1,label2, label3,label0;
    final JTextField text1,text2, text3,text0;
    public Form() {
        final Vector columnNames = new Vector();
        final Vector data = new Vector();
        label0 = new JLabel();
        label0.setText("CIN :");
        text0 = new JTextField(20);
        label1 = new JLabel();
        label1.setText("Nom :");
        text1 = new JTextField(20);
        label2 = new JLabel();
        label2.setText("Prenom :");
        text2 = new JTextField(20);
        label3 = new JLabel();
        label3.setText("Age:");
        text3 = new JTextField(20);
        //Create button
        ADD=new JButton("Ajouter");
        RETRIEVE=new JButton("Afficher");
        UPDATE=new JButton("Mise a jour");
        DELETE = new JButton("Supprimer");
        panel=new JPanel(new GridLayout(6,2));
        panel.setSize(400,200);
        panel.setPreferredSize(new Dimension(400, 200));
        panel.add(label0);
        panel.add(text0);
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(label3);
        panel.add(text3);
        //Add to panel buttons
        panel.add(ADD);
        panel.add(RETRIEVE);
        panel.add(UPDATE);
        panel.add(DELETE);
        this.setTitle("Formulaire");
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.setSize(420,250);

        //actions listener
        RETRIEVE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExempleJdbc test = new ExempleJdbc();
                try {
                    test.loadDriver();
                    test.listPersons();
                } catch (ClassNotFoundException e1) {
                    System.err.println("Pilote JDBC introuvable !");
                } catch (SQLException e1) {
                    System.out.println("SQLException:  " + e1.getMessage());
                }
            }
        });
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExempleJdbc test = new ExempleJdbc();
                   String cin= text0.getText(); String nom= text1.getText();
                   String prenom= text2.getText();  String age= text3.getText();

                    test.ajouterDonnees(cin,nom,prenom,Integer.parseInt(age));
                    vider();

            }
        });


    }

    public  void vider(){
        text0.setText("");
        text1.setText("");
        text2.setText("");
        text3.setText("");
    }
}
