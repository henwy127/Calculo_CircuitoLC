package core;

import javax.swing.SwingUtilities;
import view.Tela;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tela tela = new Tela();
            tela.setVisible(true);
        });
    }
}