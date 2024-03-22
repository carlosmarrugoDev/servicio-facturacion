/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.utilidades;
 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 
import javax.swing.JTextField;

/** 
 * @author LuisT
 */
public class Validador_de_Campos {

    public void validarSoloLetras(final JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int k = (int) e.getKeyChar();
                //@ =64 
                if (Character.isDigit(c)) {
                    e.consume();
//                    JOptionPane.showMessageDialog(null, "Se permite solo Letras", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    campo.requestFocus(); 
                } 
            }
        });
    }
 

    public void validarSoloNumeros(final JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int k = (int) e.getKeyChar();
                if (!Character.isDigit(c) || k == 33 || k == 34 || k == 35 || k == 36 || k == 37 || k == 38 || k == 39 || k == 40 || k == 41 || k == 42
                        || k == 43 || k == 44 || k == 45 || k == 46 || k == 47 || k == 58 || k == 59 || k == 60 || k == 61 || k == 62 || k == 63 || k == 64 || k == 91
                        || k == 92 || k == 93 || k == 94 || k == 95 || k == 96 || k == 123 || k == 124 || k == 125 || k == 126 || k == 127 || k == 128 || k == 129
                        || k == 130 || k == 131 || k == 132 || k == 133 || k == 134 || k == 135 || k == 136 || k == 137 || k == 138 || k == 139 || k == 140
                        || k == 141 || k == 142 || k == 143 || k == 144 || k == 145 || k == 146 || k == 147 || k == 148 || k == 149 || k == 150 || k == 151
                        || k == 152 || k == 153 || k == 154 || k == 155 || k == 156 || k == 157 || k == 158 || k == 159 || k == 160 || k == 161 || k == 162 || k == 163
                        || k == 166 || k == 167 || k == 168 || k == 169 || k == 170 || k == 171 || k == 172 || k == 173 || k == 174 || k == 175 || k == 176 || k == 177
                        || k == 178 || k == 179 || k == 180 || k == 182 || k == 184 || k == 185 || k == 186 || k == 187 || k == 188 || k == 189 || k == 190 || k == 191
                        || k == 192 || k == 193 || k == 194 || k == 195 || k == 196 || k == 197 || k == 198 || k == 199 || k == 200 || k == 201 || k == 202 || k == 203
                        || k == 204 || k == 205 || k == 206 || k == 207 || k == 208 || k == 209 || k == 210 || k == 211 || k == 213 || k == 214 || k == 215 || k == 216
                        || k == 217 || k == 218 || k == 219 || k == 220 || k == 221 || k == 222 || k == 223 || k == 225 || k == 226 || k == 228
                        || k == 229 || k == 230 || k == 231 || k == 232 || k == 234 || k == 236 || k == 237 || k == 239 || k == 240 || k == 241 || k == 242 || k == 243
                        || k == 244 || k == 245 || k == 246 || k == 247 || k == 248 || k == 249 || k == 251 || k == 252 || k == 253 || k == 254) {
                    e.consume();
//                    JOptionPane.showMessageDialog(null, "Se permite solo Números", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    campo.requestFocus();
                }
            }
        });
    }

}
