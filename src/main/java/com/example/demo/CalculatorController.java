package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label label;
    @FXML
    private Label expression;
    private StringBuilder text = new StringBuilder();
    @FXML
    protected void onOneButtonClick() {
        text.append("1");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onTwoButtonClick() {
        text.append("2");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onThreeButtonClick() {
        text.append("3");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onFourButtonClick() {
        text.append("4");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onFiveButtonClick() {
        text.append("5");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onSixButtonClick() {
        text.append("6");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onSevenButtonClick() {
        text.append("7");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onEightButtonClick() {
        text.append("8");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onNineButtonClick() {
        text.append("9");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onZeroButtonClick() {
        text.append("0");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onCommaButtonClick() {
        text.append(",");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onPlusButtonClick() {
        text.append(" + ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onMinusButtonClick() {
        text.append(" - ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onMultiButtonClick() {
        text.append(" * ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onDivideButtonClick() {
        text.append(" / ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onFactButtonClick() {
        text.append(" ! ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onSqrButtonClick() {
        text.append(" ^ ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onSqrtButtonClick() {
        text.append(" # ");
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onAllClearButtonClick() {
        text = new StringBuilder();
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onBackspaceButtonClick() {
        text.deleteCharAt(text.length() - 1);
        expression.setText(getText());
        label.setText("");
    }

    @FXML
    protected void onEqualsButtonClick() {
        label.setText(CalculatorUtil.calculate(text.insert(0, "(").append(")").toString()));
        text = new StringBuilder();
    }

    private String getText() {
        return text.toString().replace(" ", "");
    }
}