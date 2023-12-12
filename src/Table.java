import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {
    Object[][] data ;
    public Table( Object[][] d){

       this.data=d;
        String[] columnNames = {"Nom", "Prenom", "age"};

        // Modèle de tableau par défaut
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        // Définir un rendu personnalisé pour les cellules
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150)); // Ajustez ces valeurs pour définir l'espacement
        ((JTable) table).setDefaultRenderer(Object.class, cellRenderer);

        JScrollPane scrollPane = new JScrollPane( table );
        this.add( scrollPane );
        this.setSize(400,200);
        this.setVisible(true);

    }
}
