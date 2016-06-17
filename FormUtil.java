/*
 *
 */
package form_util;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Rafael Felipe
 * @e-mail rafael.felipe1989@gmail.com
 * @version 1.0
 * @since 12/06/2016
 */
public class FormUtil {

    //Mesage for input nulls
    private static final String OBRIGATORIO = "Campo obrigatório";

    private static final String CLEAN = "";

    /**
     * This method check the inputs
     *
     * @param inputs JTextField's inputs
     * @return <b>true</b> - All inputs are complete <br> <b>false</b> - The are
     * inputs void
     */
    public static boolean isFull(JTextComponent... inputs) {
        boolean status = true;
        for (JTextComponent input : inputs) {
            if (input.getText().equalsIgnoreCase(CLEAN) || input.getText().equalsIgnoreCase(OBRIGATORIO)) {
                input.setBackground(Color.red);
                input.setText(OBRIGATORIO);
                // input.setfocus
                //input.setToolTipText(OBRIGATORIO);
                status = false;
            } else {
                input.setBackground(Color.WHITE);
                input.setText(input.getText());
            }
        }
        return status;
    }

    /**
     * This method clear the inputs of the param
     *
     * @param inputs
     */
    public static void clearInputs(JTextComponent... inputs) {
        for (JTextComponent input : inputs) {
            if (!input.getText().equals(CLEAN)) {
                input.setText(CLEAN);
                input.setBackground(Color.WHITE);
            }
        }
    }
    
    /**
     * This method enable the components get the param
     * @param components 
     */
    public static void enableComponents(JComponent... components) {
        for (JComponent component : components) {
            if (!component.isEnabled()) {
                component.setEnabled(true);
            }
        }
    }
    
    /**
     * This method disable the components get the param
     * @param components 
     */
    public static void disableComponents(JComponent... components) {
        for (JComponent component : components) {
            if (component.isEnabled()) {
                component.setEnabled(false);
            }
        }
    }
    
    public static void msg(String txt){
        JOptionPane.showConfirmDialog(null, txt);
    }



}
