/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.utilidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 *
 * @author LuisT
 */
public class FormatoCombox {

    public void modelo_1CBX(JComboBox JBX) {
        /**
         * 1ro --ARRIBA 2do --IZQUIERDA 3ro --ABAJO 4to --DERECHA
         */
        Font fuente = new Font("Tahoma", 0, 11);
        JBX.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.decode("#FFFFFF")));
        JBX.setFont(fuente); 
        JBX.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.decode("#E3F2FD"));
            }

            public void focusLost(FocusEvent e) {
                e.getComponent().setBackground(Color.WHITE);
            }
        });

    }

}
