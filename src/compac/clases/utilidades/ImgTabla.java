/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author LuisT
 */
public class ImgTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;
        }
        if (value instanceof JButton) {
            JButton btn = (JButton) value;   
            return btn;
        }
        if (row % 2 != 0) {
            setBackground(Color.decode("#E1F2FC"));
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.white);
            setForeground(Color.BLACK);
        }
        if (isSelected == true) {
            setBackground(Color.decode("#00838F"));
            setForeground(Color.BLACK);
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
