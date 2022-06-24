import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class hashTable implements ActionListener {
    HashMap<String, Integer> abc = new HashMap<String, Integer>();
    int calc = 0, nLength = 0, i = 0, hash = 0, entradas = 0;
    String palabra;
    String[] palabraSplit;

    private JFrame ventana, mDialog;
    private JButton btnBoton;
    private JLabel txtLabel;
    private JTextField txtEntradas, txtPalabra, txtHash;

    void printWindow() {
        ventana = new JFrame("Hashtable");
        ventana.setBounds(100, 100, 600, 300);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtLabel = new JLabel("HashTable en JAVA - Por: Carlos Solis : 6-723-1380, José Villamonte : 8-794-1103");
        txtLabel.setSize(500, 50);
        txtLabel.setLocation(10, 10);
        ventana.add(txtLabel);

        txtLabel = new JLabel("Numero de Entradas: ");
        txtLabel.setSize(150, 50);
        txtLabel.setLocation(10, 60);
        ventana.add(txtLabel);

        txtEntradas = new JTextField("");
        txtEntradas.setBounds(140, 70, 430, 25);
        ventana.add(txtEntradas);

        txtLabel = new JLabel("Palabra: ");
        txtLabel.setSize(500, 50);
        txtLabel.setLocation(10, 110);
        ventana.add(txtLabel);

        txtPalabra = new JTextField("");
        txtPalabra.setBounds(140, 120, 430, 25);
        ventana.add(txtPalabra);

        txtLabel = new JLabel("Hash: ");
        txtLabel.setSize(500, 50);
        txtLabel.setLocation(10, 160);
        ventana.add(txtLabel);

        txtHash = new JTextField("");
        txtHash.setBounds(140, 170, 430, 25);
        ventana.add(txtHash);

        btnBoton = new JButton(String.valueOf("Calcular"));
        btnBoton.setBounds(10, 210, 560, 30);
        ventana.add(btnBoton);
        btnBoton.addActionListener(this);

        ventana.setVisible(true);

        abcd(abc);
    }

    public static void abcd(HashMap<String, Integer> abc) {
        abc.put(" ", 0);
        abc.put("a", 1);
        abc.put("b", 2);
        abc.put("c", 3);
        abc.put("d", 4);
        abc.put("e", 5);
        abc.put("f", 6);
        abc.put("g", 7);
        abc.put("h", 8);
        abc.put("i", 9);
        abc.put("j", 10);
        abc.put("k", 11);
        abc.put("l", 12);
        abc.put("m", 13);
        abc.put("n", 14);
        abc.put("ñ", 15);
        abc.put("o", 16);
        abc.put("p", 17);
        abc.put("q", 18);
        abc.put("r", 19);
        abc.put("s", 20);
        abc.put("t", 21);
        abc.put("u", 22);
        abc.put("v", 23);
        abc.put("w", 24);
        abc.put("x", 25);
        abc.put("y", 26);
        abc.put("z", 27);
    }

    public boolean validacion(String nEntrada) {
        boolean r;
        try {
            entradas = Integer.parseInt(nEntrada);
            r = true;
        } catch (NumberFormatException exepcion) {
            r = false;
        }
        return r;
    }

    public static int calcHash(int nLength, Integer[] palabraHash) {
        double hashCalc = 0;
        int hashFinal = 0, control = nLength;
        nLength = nLength - 1;

        for (int i = 0; i < control; i++) {
            hashCalc = hashCalc + (palabraHash[i] * (Math.pow(28, nLength)));
            nLength = nLength - 1;
        }

        hashFinal = (int) Math.round(hashCalc);

        return hashFinal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBoton) {
            if (validacion(txtEntradas.getText()) == true) {
                palabra = txtPalabra.getText();
                palabra = palabra.toLowerCase();
                palabraSplit = palabra.split("(?<=.)");
            } else {
                mDialog = new JFrame();
                JOptionPane.showMessageDialog(mDialog, "COLOCAR UN VALOR NUMERICO EN NUMERO DE ENTRADA");
            }
            nLength = palabraSplit.length;
            if (nLength > 12) {
                mDialog = new JFrame();
                JOptionPane.showMessageDialog(mDialog, "LA PALABRA NO DEBER SUPERAR LOS 12 CARACTERES");
            } else {
                Integer[] palabraVec = new Integer[nLength];

                for (i = 0; i < nLength; i++) {
                    if (abc.containsKey(palabraSplit[i])) {
                        palabraVec[i] = abc.get(palabraSplit[i]);
                    }
                }

                calc = calcHash(nLength, palabraVec);
                hash = calc % entradas;
                txtHash.setText(String.valueOf(hash));

            }
        }
    }
}
