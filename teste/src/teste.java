import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class teste {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(teste::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Menu LOTOFÁCIL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Menu LOTOFÁCIL");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel);

        JButton button1 = new JButton("Apostar de 0 a 100");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();
            }
        });
        panel.add(button1);

        JButton button2 = new JButton("Apostar de A à Z");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta2();
            }
        });
        panel.add(button2);

        JButton button3 = new JButton("Apostar em par ou ímpar");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta3();
            }
        });
        panel.add(button3);

        JButton button4 = new JButton("Sair");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(button4);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void aposta1() {
        String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
        try {
            int num = Integer.parseInt(input);
            if (num >= 0 && num <= 100) {
                Random rdm = new Random();
                int numSorteado = rdm.nextInt(101);
                if (num == numSorteado) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numSorteado + ".");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }

    private static void aposta2() {
        String input = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z:");
        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            char letra = Character.toUpperCase(input.charAt(0));
            char letraPremiada = 'I';
            if (letra == letraPremiada) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada + ".");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }

    private static void aposta3() {
        String input = JOptionPane.showInputDialog(null, "Digite um número inteiro:");
        try {
            int num = Integer.parseInt(input);
            if (num % 2 == 0) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }
}

