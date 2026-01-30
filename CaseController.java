package com.qchambers.controller;

import com.qchambers.model.Case;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CaseController {

    @FXML private TableView<Case> caseTable;
    @FXML private TableColumn<Case, String> idColumn;
    @FXML private TableColumn<Case, String> titleColumn;
    @FXML private TableColumn<Case, String> clientIdColumn;
    @FXML private TableColumn<Case, String> statusColumn;
    @FXML private TableColumn<Case, LocalDate> openDateColumn;
    @FXML private TableColumn<Case, LocalDate> closeDateColumn;
    @FXML private TableColumn<Case, String> descriptionColumn;

    @FXML private TextField idField;
    @FXML private TextField titleField;
    @FXML private TextField clientIdField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private DatePicker openDatePicker;
    @FXML private DatePicker closeDatePicker;
    @FXML private TextArea descriptionArea;

    private ObservableList<Case> caseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        openDateColumn.setCellValueFactory(new PropertyValueFactory<>("openDate"));
        closeDateColumn.setCellValueFactory(new PropertyValueFactory<>("closeDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        statusComboBox.setItems(FXCollections.observableArrayList("Open", "Closed", "Pending"));
        caseTable.setItems(caseList);
    }

    @FXML
    private void addCase() {
        String id = idField.getText();
        String title = titleField.getText();
        String clientId = clientIdField.getText();
        String status = statusComboBox.getValue();
        LocalDate openDate = openDatePicker.getValue();
        LocalDate closeDate = closeDatePicker.getValue();
        String description = descriptionArea.getText();

        if (!id.isEmpty() && !title.isEmpty() && !clientId.isEmpty()) {
            Case caseItem = new Case(id, title, clientId, status, openDate, closeDate, description, new ArrayList<>());
            caseList.add(caseItem);
            clearFields();
        }
    }

    @FXML
    private void updateCase() {
        Case selectedCase = caseTable.getSelectionModel().getSelectedItem();
        if (selectedCase != null) {
            selectedCase.setTitle(titleField.getText());
            selectedCase.setClientId(clientIdField.getText());
            selectedCase.setStatus(statusComboBox.getValue());
            selectedCase.setOpenDate(openDatePicker.getValue());
            selectedCase.setCloseDate(closeDatePicker.getValue());
            selectedCase.setDescription(descriptionArea.getText());
            caseTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void deleteCase() {
        Case selectedCase = caseTable.getSelectionModel().getSelectedItem();
        if (selectedCase != null) {
            caseList.remove(selectedCase);
            clearFields();
        }
    }

    @FXML
    private void selectCase() {
        Case selectedCase = caseTable.getSelectionModel().getSelectedItem();
        if (selectedCase != null) {
            idField.setText(selectedCase.getId());
            titleField.setText(selectedCase.getTitle());
            clientIdField.setText(selectedCase.getClientId());
            statusComboBox.setValue(selectedCase.getStatus());
            openDatePicker.setValue(selectedCase.getOpenDate());
            closeDatePicker.setValue(selectedCase.getCloseDate());
            descriptionArea.setText(selectedCase.getDescription());
        }
    }

    private void clearFields() {
        idField.clear();
        titleField.clear();
        clientIdField.clear();
        statusComboBox.setValue(null);
        openDatePicker.setValue(null);
        closeDatePicker.setValue(null);
        descriptionArea.clear();
    }
}
