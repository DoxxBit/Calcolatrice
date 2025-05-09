package interfacciaCalcolatriceSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcolatriceGUI extends JFrame {
    private JTextField textArea1;
    private JTextField textArea2;
    private JComboBox<String> operazioniBox;
    private JLabel risultato;

    public CalcolatriceGUI() {
        setTitle("Test Swing");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // COMPONENTI USER INTERFACE
        textArea1 = new JTextField();
        textArea2 = new JTextField();

        String[] operazioni = { "Somma", "Sottrazione", "Moltiplicazione", "Divisione" };
        operazioniBox = new JComboBox<>(operazioni);

        JButton calcolaBtn = new JButton("Calcola");
        risultato = new JLabel("Risultato: ", JLabel.CENTER);

        // AGGIUNTA DEI COMPONENTI
        add(new JLabel("Numero 1:"));
        add(textArea1);
        add(new JLabel("Numero 2:"));
        add(textArea2);
        add(new JLabel("Operazione:"));
        add(operazioniBox);
        add(calcolaBtn);
        add(risultato);

        // CALL 2 ACTION DEL BOTTONE
        calcolaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcolaRisultato();
            }
        });

        setVisible(true);
    }

    private void calcolaRisultato() {
        try {
            double num1 = Double.parseDouble(textArea1.getText());
            double num2 = Double.parseDouble(textArea2.getText());
            String operazione = (String) operazioniBox.getSelectedItem();
            double totale = 0;
            
            // RICHIAMO A OGGETTO DI OPERAZIONI 
            switch (operazione) {
                case "Somma":
                    totale = Operazioni.somma(num1, num2);
                    break;
                case "Sottrazione":
                    totale = Operazioni.sottrazione(num1, num2);
                    break;
                case "Moltiplicazione":
                    totale = Operazioni.moltiplicazione(num1, num2);
                    break;
                case "Divisione":
                    totale = Operazioni.divisione(num1, num2);
                    break;
            }

            risultato.setText("Risultato: " + totale);

        } catch (NumberFormatException ex) {
            risultato.setText("Errore: inserisci numeri validi.");
        } catch (ArithmeticException ex) {
            risultato.setText("Errore: " + ex.getMessage());
        }
    }
}

