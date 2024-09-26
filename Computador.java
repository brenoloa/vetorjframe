package models;

import java.awt.*;
import javax.swing.*;

public class Computador extends JFrame {
    private JComboBox<String> processadorComboBox;
    private JComboBox<String> memoriaComboBox;
    private JComboBox<String> hdComboBox;
    private JComboBox<String> monitorComboBox;
    private JButton calcularButton;
    private JLabel precoLabel;

    public Computador() {
        // Configurações básicas do JFrame
        setTitle("Configuração de Computador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new GridLayout(6, 2, 10, 10));

        // Opções para os componentes
        String[] processadores = {"i3", "i5", "i7"};
        String[] memorias = {"4GB", "8GB", "16GB"};
        String[] hds = {"500GB", "1TB"};
        String[] monitores = {"15 polegadas", "17 polegadas"};

        // Labels e ComboBoxes para seleção dos componentes
        add(new JLabel("Processador:"));
        processadorComboBox = new JComboBox<>(processadores);
        add(processadorComboBox);

        add(new JLabel("Memória:"));
        memoriaComboBox = new JComboBox<>(memorias);
        add(memoriaComboBox);

        add(new JLabel("HD:"));
        hdComboBox = new JComboBox<>(hds);
        add(hdComboBox);

        add(new JLabel("Monitor:"));
        monitorComboBox = new JComboBox<>(monitores);
        add(monitorComboBox);

        // Botão para calcular o preço
        calcularButton = new JButton("Calcular Preço");
        add(calcularButton);

        // Label para exibir o preço calculado
        precoLabel = new JLabel("Preço: R$ 0");
        add(precoLabel);

        // Ação do botão para calcular o preço
        calcularButton.addActionListener(e -> calcularPreco());

        setVisible(true); // Torna a janela visível
    }

    // Método para calcular e exibir o preço total do computador
    private void calcularPreco() {
        int precoTotal = 1000; // Preço fixo da placa-mãe

        // Tabela de preços dos processadores
        String processador = (String) processadorComboBox.getSelectedItem();
        precoTotal += switch (processador) {
            case "i3" -> 400;
            case "i5" -> 600;
            case "i7" -> 800;
            default -> 0;
        };

        // Tabela de preços das memórias
        String memoria = (String) memoriaComboBox.getSelectedItem();
        precoTotal += switch (memoria) {
            case "4GB" -> 350;
            case "8GB" -> 650;
            case "16GB" -> 1200;
            default -> 0;
        };

        // Tabela de preços dos HDs
        String hd = (String) hdComboBox.getSelectedItem();
        precoTotal += switch (hd) {
            case "500GB" -> 270;
            case "1TB" -> 500;
            default -> 0;
        };

        // Tabela de preços dos monitores
        String monitor = (String) monitorComboBox.getSelectedItem();
        precoTotal += switch (monitor) {
            case "15 polegadas" -> 320;
            case "17 polegadas" -> 520;
            default -> 0;
        };

        precoLabel.setText("Preço: R$ " + precoTotal);
    }
}
