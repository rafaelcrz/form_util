/**
 * @author Rafael Felipe
 * @e-mail rafael.felipe1989@gmail.com
 * @version 1.0
 * @since 12/06/2016
 */
package form_util;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 * Essa classe contém vários métodos úteis na criação de formulários em Java.
 */
public class FormUtil {

    private static final String CLEAN = ""; //campo vazio

    /**
     * Verifica se os campos de texto passados por parametros estão preenchidos
     *
     * @param mensagem Mensagem que será exibida no campo vazio alertando o usuário
     * @param inputs campos de texto JTextField
     * @return <b>true</b> - Todos os campos estão preenchidos <br> <b>false</b> - Existe pelo menos um campo vazio
     */
    public static boolean isFull(String mensagem, JTextComponent... inputs) {
        boolean status = true;
        for (JTextComponent input : inputs) {
            if (input.getText().equalsIgnoreCase(CLEAN) || input.getText().equalsIgnoreCase(mensagem)) {
                input.setBackground(Color.red);
                input.setText(mensagem);
                status = false;
            } else {
                input.setBackground(Color.WHITE);
                input.setText(input.getText());
            }
        }
        return status;
    }

    /**
     * Limpa todos os campos de texto passados por parâmetro
     *
     * @param inputs campos de texto JTextField
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
     * Habilita todos os componentes (JComponent) passados por parâmetro
     *
     * @param components componentes JComponent 
     */
    public static void enableComponents(JComponent... components) {
        for (JComponent component : components) {
            if (!component.isEnabled()) {
                component.setEnabled(true);
            }
        }
    }

    /**
     * Desabilita todos os componentes (JComponent) passados por parâmetro
     *
     * @param components components JComponent
     */
    public static void disableComponents(JComponent... components) {
        for (JComponent component : components) {
            if (component.isEnabled()) {
                component.setEnabled(false);
            }
        }
    }

    /**
     * Exibe uma mensagem de texto (JOptionPane)
     * @param txt mensagem de texto
     */
    public static void msg(String txt) {
        JOptionPane.showConfirmDialog(null, txt);
    }

}
