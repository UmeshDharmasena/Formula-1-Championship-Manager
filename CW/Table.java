import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Table extends JPanel {
    Formula1ChampionshipManager f1Manager = new Formula1ChampionshipManager();
    static ArrayList<Formula1Driver> driverValues = new ArrayList<Formula1Driver>();
    private static String[] columnNames = { "Name", "Location", "Team", "Points", "No: of Races" };
    private DefaultTableModel tableModel = new DefaultTableModel(null, columnNames); // https://stackoverflow.com/questions/19471404/create-dynamic-table-to-add-new-entry-with-button
    private JTable table = new JTable(tableModel);
    private JScrollPane scrollP = new JScrollPane(table);
    private JScrollBar ScrollB = scrollP.getVerticalScrollBar();
    private boolean isAutoScroll;
    private static JFrame jf = new JFrame();
    ArrayList<Formula1Driver> DriverList = new ArrayList();
    Formula1ChampionshipManager DriverStats = new Formula1ChampionshipManager();
    JPanel panel = new JPanel();

        
    public Table(){
        jf.setTitle("Driver Table");
        this.setLayout(new BorderLayout());
        Dimension fSize = new Dimension(800, 400);
        table.setPreferredScrollableViewportSize(fSize);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollB.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                isAutoScroll = !e.getValueIsAdjusting();
            }
        });// https://stackoverflow.com/questions/19471404/create-dynamic-table-to-add-new-entry-with-button
        DriverList = DriverStats.GetDriverList();
    }
    
    public void ShowTable() {
        table.setBounds(30, 40, 200, 300);
        new Table(); //https://www.geeksforgeeks.org/java-swing-jtable/
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(scrollP);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setSize(500,200);//https://www.tutorialspoint.com/how-to-create-defaulttablemodel-which-is-an-implementation-of-tablemodel
        jf.setVisible(true);
       
    }

    private void addRow(Formula1Driver driverRow) {
        tableModel.addRow(new Object[] {
                String.valueOf(driverRow.GetName()),
                String.valueOf(driverRow.GetLocation()),
                String.valueOf(driverRow.GetTeam()),
                String.valueOf(driverRow.GetPoints()),
                String.valueOf(driverRow.GetRacesParticipated())
        });

    }

    public void setValues(ArrayList<Formula1Driver> driverVals) {
        EmptyValues();
        for (int i = 0; i < driverVals.size(); i++) {
            this.driverValues.add(driverVals.get(i));
            addRow(driverVals.get(i));
        }
        PointsSort();
    }
//https://stackoverflow.com/questions/28823670/how-to-sort-jtable-in-shortest-way
    public void EmptyValues() {
        tableModel.setRowCount(0);
        driverValues.clear();

    }

    public void PointsSort() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());

        sorter.setComparator(4, new Comparator<String>() {
            @Override
            public int compare(String val1, String val2) {
                try {
                    int num1 = Integer.parseInt(val1);
                    int num2 = Integer.parseInt(val2);
                    return num1 - num2;
                } catch (NumberFormatException e) {
                    return val1.compareTo(val2);
                }
            }
        });

    }

    


    


}