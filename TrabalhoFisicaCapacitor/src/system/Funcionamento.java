package system;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import view.Tela;

public class Funcionamento {

    private final Tela tela;

    public Funcionamento(Tela tela) {
        this.tela = tela;
    }

    public void calcular() {

        try {

            if (tela.getCampoIndutancia_mH().getText().trim().isEmpty()
                    || tela.getCampoCapacitancia_uF().getText().trim().isEmpty()
                    || tela.getCampoCorrenteInicial_A().getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Preencha todos os campos.",
                        "Campos vazios",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

          
            double indutancia = Double.parseDouble(
                    tela.getCampoIndutancia_mH().getText().trim().replace(",", "."));

            double capacitancia = Double.parseDouble(
                    tela.getCampoCapacitancia_uF().getText().trim().replace(",", "."));

            double correnteInicial = Double.parseDouble(
                    tela.getCampoCorrenteInicial_A().getText().trim().replace(",", "."));

          
            if (indutancia <= 0 || indutancia > 100) {
                JOptionPane.showMessageDialog(
                        null,
                        "Indutância deve estar entre 0 e 100 mH.",
                        "Valor inválido",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (capacitancia <= 0 || capacitancia > 100) {
                JOptionPane.showMessageDialog(
                        null,
                        "Capacitância deve estar entre 0 e 100 µF.",
                        "Valor inválido",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (correnteInicial < 0 || correnteInicial > 10) {
                JOptionPane.showMessageDialog(
                        null,
                        "Corrente inicial deve estar entre 0 e 10 A.",
                        "Valor inválido",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            double L = indutancia * 1e-3;
            double C = capacitancia * 1e-6;

            double qMax = correnteInicial * Math.sqrt(L * C);
            double w = 1.0 / Math.sqrt(L * C);

            double tPrimeiroMax = Math.PI / (4.0 * w);
            double taxaMaxima = (qMax * qMax / (2.0 * C)) * w;

            DecimalFormat df = new DecimalFormat("0.###");

            double qMax_uC = qMax * 1e6;
            double tPrimeiroMax_us = tPrimeiroMax * 1e6;

            String resultado = ""
                    + "(a) Carga máxima no capacitor (Qmáx)\n"
                    + "Qmáx = " + df.format(qMax_uC) + " μC\n\n"
                    + "(b) Primeiro instante (t > 0) em que a taxa de armazenamento de energia é máxima\n"
                    + "t = " + df.format(tPrimeiroMax_us) + " μs\n\n"
                    + "(c) Taxa máxima de armazenamento de energia\n"
                    + "dUc/dt = " + df.format(taxaMaxima) + " W";

            tela.setResultado(resultado);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Digite apenas valores numéricos válidos.\n",
                    "Entrada inválida",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro inesperado:\n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        }
    }
}