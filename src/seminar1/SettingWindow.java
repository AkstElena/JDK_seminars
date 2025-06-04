package seminar1;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;

    private static final String LABEL_SIZE = "Выбранный размеры поля: ";
    private static final String LABEL_WIN_LENGTH = "Установленная длина: ";

    JButton btnStart;
    JSlider sizeW = new JSlider(3, 10);
    JSlider sizeF = new JSlider(3, 10); // добавляем бегунок для выбора размера
    JRadioButton btn1 = new JRadioButton("Человек против компьютера");
    JRadioButton btn2 = new JRadioButton("Человек против человека");  // группа радиобаттон делает false другую кнопку, когда одна нажата

    GameWindow gameWindow;

    SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);


        // Создание блока настроек
        JPanel settings = new JPanel(new GridLayout(3, 1));

        // Выбор типа игры
        JPanel typeGame = new JPanel(new GridLayout(3, 1));
        typeGame.add(new JLabel("Выберите режим игры"));
        ButtonGroup group1 = new ButtonGroup();

        btn1.setSelected(true); // по умолчанию видимая

        group1.add(btn1);
        group1.add(btn2);
        typeGame.add(btn1);
        typeGame.add(btn2);

        // Выбор длины повотрений для победы
        JPanel sizeWin = new JPanel(new GridLayout(3, 1));
        sizeWin.add(new JLabel("Выберите длину для победы"));
        JLabel currentLength = new JLabel(LABEL_WIN_LENGTH);
        sizeWin.add(currentLength);

        sizeW.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int length = sizeW.getValue();
                currentLength.setText(LABEL_WIN_LENGTH + length);

            }
        });

        sizeWin.add(sizeW);

        // Выбор размера поля
        JPanel sizeField = new JPanel(new GridLayout(3, 1));
        sizeField.add(new JLabel("Выберите размеры поля"));
        JLabel currentSize = new JLabel(LABEL_SIZE);
        sizeField.add(currentSize);

        sizeF.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sizeF.getValue(); // получаем значение бегунка
                currentSize.setText(LABEL_SIZE + size);
                sizeW.setMaximum(size);
            }
        });
        sizeField.add(sizeF);


        // Заполнение окна настроек
        settings.add(typeGame);
        settings.add(sizeField);
        settings.add(sizeWin);

        // добавляем панель настроек на основное окно
        add(settings);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();


            }
        });

        // добавляем кнопку начала игры
        add(btnStart, BorderLayout.SOUTH);


    }

    private void startNewGame() {
        int mode = 0;
        if (btn1.isSelected()) {
            mode = 1;
        } else if (btn2.isSelected()) {
            mode = 2;
        }
        gameWindow.startNewGame(mode, sizeF.getValue(), sizeF.getValue(), sizeW.getValue());
        setVisible(false);

    }


}
