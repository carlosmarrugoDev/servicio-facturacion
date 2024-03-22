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
import javax.swing.JTextField;

/**
 *
 * @author LuisT
 */
public class FormatoTextField {

    public void modelo_1TF(JTextField JTF, int opcion_visual) {

        if (opcion_visual == 0) {
            /**
             * 1ro --ARRIBA 2do --IZQUIERDA 3ro --ABAJO 4to --DERECHA
             */
            Font fuente = new Font("Tahoma", 0, 11);
            JTF.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.decode("#E0E0E0")));
            JTF.setFont(fuente);
            JTF.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    e.getComponent().setBackground(Color.decode("#E3F2FD"));
                }

                public void focusLost(FocusEvent e) {
                    e.getComponent().setBackground(Color.WHITE);
                }
            });
        } else if (opcion_visual == 1) {
            /**
             * 1ro --ARRIBA 2do --IZQUIERDA 3ro --ABAJO 4to --DERECHA
             */
            JTF.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.decode("#E0E0E0")));

            JTF.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    e.getComponent().setBackground(Color.decode("#E3F2FD"));
                }

                public void focusLost(FocusEvent e) {
                    e.getComponent().setBackground(Color.WHITE);
                }
            });
        } else if (opcion_visual == 2) {
            /**
             * 1ro --ARRIBA 2do --IZQUIERDA 3ro --ABAJO 4to --DERECHA
             */
            JTF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#E0E0E0")));

            JTF.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    e.getComponent().setBackground(Color.decode("#E3F2FD"));
                }

                public void focusLost(FocusEvent e) {
                    e.getComponent().setBackground(Color.WHITE);
                }
            });
        } else if (opcion_visual == 3) {
            /**
             * 1ro --ARRIBA 2do --IZQUIERDA 3ro --ABAJO 4to --DERECHA
             */
            JTF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#E0E0E0")));
            JTF.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    e.getComponent().setBackground(Color.WHITE);
                }

                public void focusLost(FocusEvent e) {
                    e.getComponent().setBackground(Color.WHITE);
                }
            });
        }

    }

}
