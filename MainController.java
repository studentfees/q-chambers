package com.qchambers.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    @FXML
    private void handleClients() {
        loadView("clientView.fxml", "Client Management");
    }

    @FXML
    private void handleCases() {
        loadView("caseView.fxml", "Case Management");
    }

    @FXML
    private void handleDocuments() {
        loadView("documentView.fxml", "Document Storage");
    }

    @FXML
    private void handleBills() {
        loadView("billView.fxml", "Billing");
    }

    @FXML
    private void handleAppointments() {
        loadView("appointmentView.fxml", "Scheduling");
    }

    private void loadView(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
