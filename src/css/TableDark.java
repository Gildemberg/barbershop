package css;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableDark extends JTable {

    private TableDarkHeader header;
    private TableDarkCell cell;

    public TableDark() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 60));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(60);
        setBackground(new Color(255, 255, 255));
    }

    public void setColumnAlignment(int column, int align) {
        header.setAlignment(column, align);
    }

    public void setCellAlignment(int column, int align) {
        cell.setAlignment(column, align);
    }

    public void setColumnWidth(int column, int width) {
        getColumnModel().getColumn(column).setPreferredWidth(width);
        getColumnModel().getColumn(column).setMinWidth(width);
        getColumnModel().getColumn(column).setMaxWidth(width);
        getColumnModel().getColumn(column).setMinWidth(10);
        getColumnModel().getColumn(column).setMaxWidth(10000);
    }

    private class TableDarkHeader extends DefaultTableCellRenderer {

        private final Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            JLabel com = (JLabel) super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(new Color(135,206,235));
            com.setForeground(new Color(255, 255, 255));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 24));
            setHorizontalAlignment(JLabel.CENTER);
            com.setBorder(BorderFactory.createCompoundBorder(
                    new MatteBorder(10, 5, 10, 5, new Color(255, 255, 255)), 
                    new EmptyBorder(10, 10, 10, 10)));
            return com;
        }
    }

    private class TableDarkCell extends DefaultTableCellRenderer {

        private final Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
            JLabel com = (JLabel) super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(0, 51, 102, 80));
                } else {
                    com.setBackground(new Color(70,130,180, 80 ));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Color(0, 51, 102));
                } else {
                    com.setBackground(new Color(70,130,180));
                }
            }
            com.setForeground(new Color(255, 255, 255));
            com.setBorder(BorderFactory.createMatteBorder(
                    0, 5, 10, 5, new Color(255, 255, 255))); 
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.CENTER);
            }
            return com;
        }
    }
}