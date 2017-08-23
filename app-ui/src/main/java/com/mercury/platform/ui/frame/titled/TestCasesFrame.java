package com.mercury.platform.ui.frame.titled;

import com.mercury.platform.shared.store.MercuryStoreCore;
import com.mercury.platform.ui.misc.AppThemeColor;

import javax.swing.*;
import java.awt.*;

public class TestCasesFrame extends AbstractTitledComponentFrame {
    private TestEngine testEngine;

    public TestCasesFrame() {
        super();
    }

    @Override
    public void onViewInit() {
        this.testEngine = new TestEngine();
        this.add(getTestCasesPanel(), BorderLayout.CENTER);
        this.pack();
    }

    @Override
    protected String getFrameTitle() {
        return "Example of usage";
    }


    private JPanel getTestCasesPanel() {
        JPanel testPanel = new JPanel(new GridBagLayout());

        GridBagConstraints buttonColumn = new GridBagConstraints();
        GridBagConstraints titleColumn = new GridBagConstraints();
        buttonColumn.fill = GridBagConstraints.HORIZONTAL;
        titleColumn.fill = GridBagConstraints.HORIZONTAL;
        buttonColumn.weightx = 0.25f;
        titleColumn.weightx = 0.9f;
        buttonColumn.anchor = GridBagConstraints.NORTHWEST;
        titleColumn.anchor = GridBagConstraints.NORTHWEST;
        buttonColumn.gridy = 0;
        buttonColumn.gridx = 0;
        titleColumn.gridy = 0;
        titleColumn.gridx = 1;
        buttonColumn.insets = new Insets(3, 3, 3, 0);
        titleColumn.insets = new Insets(3, 3, 3, 0);

        JButton button = componentsFactory.getBorderedButton("Click");
        button.addActionListener(action -> {
            MercuryStoreCore.newNotificationSubject.onNext(this.testEngine.getRandomItemIncMessage());
        });
        ;
        testPanel.add(button, buttonColumn);
        buttonColumn.gridy++;
        JLabel textLabel = componentsFactory.getTextLabel("Random incoming item message");
        testPanel.add(textLabel, titleColumn);
        titleColumn.gridy++;

        JButton button1 = componentsFactory.getBorderedButton("Click");
        button1.addActionListener(action -> {
            MercuryStoreCore.newNotificationSubject.onNext(this.testEngine.getRandomCurrencyIncMessage());
        });
        testPanel.add(button1, buttonColumn);
        buttonColumn.gridy++;
        JLabel textLabel1 = componentsFactory.getTextLabel("Random incoming currency message");
        testPanel.add(textLabel1, titleColumn);
        titleColumn.gridy++;

        JButton outItemButton = componentsFactory.getBorderedButton("Click");
        outItemButton.addActionListener(action -> {
            MercuryStoreCore.newNotificationSubject.onNext(this.testEngine.getRandomItemOutMessage());
        });
        testPanel.add(outItemButton, buttonColumn);
        buttonColumn.gridy++;
        JLabel outItemLabel = componentsFactory.getTextLabel("Random outgoing item message");
        testPanel.add(outItemLabel, titleColumn);
        titleColumn.gridy++;

        JButton outCurrencyButton = componentsFactory.getBorderedButton("Click");
        outCurrencyButton.addActionListener(action -> {
            MercuryStoreCore.newNotificationSubject.onNext(this.testEngine.getRandomCurrencyOutMessage());
        });
        testPanel.add(outCurrencyButton, buttonColumn);
        buttonColumn.gridy++;
        JLabel outCurrencyLabel = componentsFactory.getTextLabel("Random outgoing currency message");
        testPanel.add(outCurrencyLabel, titleColumn);
        titleColumn.gridy++;
        testPanel.setBackground(AppThemeColor.TRANSPARENT);

        JButton chatScannerButton = componentsFactory.getBorderedButton("Click");
        chatScannerButton.addActionListener(action -> {
            MercuryStoreCore.newScannerMessageSubject.onNext(this.testEngine.getRandomScannerMessage());
        });
        testPanel.add(chatScannerButton, buttonColumn);
        buttonColumn.gridy++;
        JLabel chatScannerLabel = componentsFactory.getTextLabel("Random chat scanner message");
        testPanel.add(chatScannerLabel, titleColumn);
        titleColumn.gridy++;
        testPanel.setBackground(AppThemeColor.TRANSPARENT);

        return testPanel;
    }

    @Override
    public void subscribe() {

    }
}
