package com.qchambers.controller;

import com.qchambers.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientController {

    @FXML private TableView<Client> clientTable;
    @FXML private TableColumn<Client, String> idColumn;
    @FXML private TableColumn<Client, String> nameColumn;
    @FXML private TableColumn<Client, String> emailColumn;
    @FXML private TableColumn<Client, String> phoneColumn;
    @FXML private TableColumn<Client, String> addressColumn;

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextArea addressArea;

    private ObservableList<Client> clientList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        clientTable.setItems(clientList);
    }

    @FXML
    private void addClient() {
        String id = idField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressArea.getText();

        if (!id.isEmpty() && !name.isEmpty()) {
            Client client = new Client(id, name, email, phone, address);
            clientList.add(client);
            clearFields();
        }
    }

    @FXML
    private void updateClient() {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            selectedClient.setName(nameField.getText());
            selectedClient.setEmail(emailField.getText());
            selectedClient.setPhone(phoneField.getText());
            selectedClient.setAddress(addressArea.getText());
            clientTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void deleteClient() {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            clientList.remove(selectedClient);
            clearFields();
        }
    }

    @FXML
    private void selectClient() {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            idField.setText(selectedClient.getId());
            nameField.setText(selectedClient.getName());
            emailField.setText(selectedClient.getEmail());
            phoneField.setText(selectedClient.getPhone());
            addressArea.setText(selectedClient.getAddress());
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        emailField.clear();
        phoneField.clear();
        addressArea.clear();
    }
}
