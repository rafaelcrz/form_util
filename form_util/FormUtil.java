package form_util;

/**
 * @author Rafael Felipe
 * @e-mail rafael.felipe1989@gmail.com
 * @version 1.0
 * @since 12/06/2016
 */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.text.JTextComponent;

/**
 * Essa classe contém vários métodos úteis na criação de formulários em Java.
 */
public class FormUtil {

    private static final String CLEAN = ""; //campo vazio

    /**
     * Verifica se os campos de texto passados por parametros estão preenchidos
     *
     * @param mensagem Mensagem que será exibida no campo vazio alertando o
     * usuário
     * @param inputs campos de texto JTextField
     * @return <b>true</b> - Todos os campos estão preenchidos <br> <b>false</b>
     * - Existe pelo menos um campo vazio
     */
    public static boolean isFull(String mensagem, JTextComponent... inputs) {
        boolean status = true; //estado do campo
        JTextComponent in = null; // 'classe pai' dos JTextField e JTextArea
        for (JTextComponent inputVoid : inputs) { //todos campos vazios
            if (inputVoid.getText().equalsIgnoreCase(CLEAN) || inputVoid.getText().equalsIgnoreCase(mensagem)) {//caso campo esteja vazio
                inputVoid.setBackground(Color.red);
                inputVoid.setText(mensagem);
                //Precisou fazer um casting, porque o método não é aceito para o JTextComponent
                if (inputVoid instanceof JTextField) {
                    in = (JTextField) inputVoid; 
                } else if (inputVoid instanceof JTextArea) {
                    in = (JTextArea) inputVoid;
                }
                //quando clica no campo vazio
                in.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        //O campo vazio possui uma mensagem de obrigatoriedade, ex "campo obritario"
                        //quando clica nesse campo, a mensagem é apagada e a cor de fundo volta
                        //ao original
                        inputVoid.setBackground(Color.WHITE);
                        inputVoid.setText(CLEAN);
                    }
                });
                status = false;
            } else {
                inputVoid.setBackground(Color.WHITE);
                inputVoid.setText(inputVoid.getText());
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
     *
     * @param txt mensagem de texto
     */
    public static void msg(String txt) {
        JOptionPane.showConfirmDialog(null, txt);
    }

}
