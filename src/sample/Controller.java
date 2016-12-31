package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    Thread recurentThread;
    Thread iterativeThread;
    @FXML private void onRecurentAction() {
        recurentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(numberField.getText() != null && !numberField.getText().equals("")) {
                    int result = countRecurrently(Integer.valueOf(numberField.getText()));
                    recurentResult.setText(result + "");
                }
            }
        });
        recurentThread.run();
    }
    @FXML private void onIterateAction() {
        iterativeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(numberField.getText() != null && !numberField.getText().equals("")) {
                    int result = countIteratively(Integer.valueOf(numberField.getText()));
                    interatevelyResult.setText(result + "");
                }
            }
        });
        iterativeThread.run();
    }
    @FXML private void onInteruptAction() {
        if(recurentThread != null) {
            recurentThread.interrupt();
        }
        if(iterativeThread != null) {
            iterativeThread.interrupt();
        }
    }
    @FXML TextField numberField;
    @FXML Label recurentResult;
    @FXML Label interatevelyResult;

    private int countRecurrently(int number) {
        int result = 1;
        if(number != 0) {
            result = number;
            result *= countRecurrently(number - 1);
        }
        return result;
    }
    private int countIteratively(int number) {
        int result = 1;
        for(int i = number; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
