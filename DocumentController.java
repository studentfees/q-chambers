package com.qchambers.controller;

import com.qchambers.model.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.LocalDate;

public class DocumentController {

    @FXML private TableView<Document> documentTable;
    @FXML private TableColumn<Document, String> idColumn;
    @FXML private TableColumn<Document, String> nameColumn;
    @FXML private TableColumn<Document, String> typeColumn;
    @FXML private TableColumn<Document, String> caseIdColumn;
    @FXML private TableColumn<Document, LocalDate> uploadDateColumn;
    @FXML private TableColumn<Document, String> filePathColumn;

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField typeField;
    @FXML private TextField caseIdField;
    @FXML private DatePicker uploadDatePicker;
    @FXML private TextField filePathField;
    @FXML private Button chooseFileButton;

    private ObservableList<Document> documentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        caseIdColumn.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        uploadDateColumn.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));
        filePathColumn.setCellValueFactory(new PropertyValueFactory<>("filePath"));

        documentTable.setItems(documentList);
    }

    @FXML
    private void addDocument() {
        String id = idField.getText();
        String name = nameField.getText();
        String type = typeField.getText();
        String caseId = caseIdField.getText();
        LocalDate uploadDate = uploadDatePicker.getValue();
        String filePath = filePathField.getText();

        if (!id.isEmpty() && !name.isEmpty()) {
            Document document = new Document(id, name, type, caseId, uploadDate, filePath);
            documentList.add(document);
            clearFields();
        }
    }

    @FXML
    private void updateDocument() {
        Document selectedDocument = documentTable.getSelectionModel().getSelectedItem();
        if (selectedDocument != null) {
            selectedDocument.setName(nameField.getText());
            selectedDocument.setType(typeField.getText());
            selectedDocument.setCaseId(caseIdField.getText());
            selectedDocument.setUploadDate(uploadDatePicker.getValue());
            selectedDocument.setFilePath(filePathField.getText());
            documentTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void deleteDocument() {
        Document selectedDocument = documentTable.getSelectionModel().getSelectedItem();
        if (selectedDocument != null) {
            documentList.remove(selectedDocument);
            clearFields();
        }
    }

    @FXML
    private void selectDocument() {
        Document selectedDocument = documentTable.getSelectionModel().getSelectedItem();
        if (selectedDocument != null) {
            idField.setText(selectedDocument.getId());
            nameField.setText(selectedDocument.getName());
            typeField.setText(selectedDocument.getType());
            caseIdField.setText(selectedDocument.getCaseId());
            uploadDatePicker.setValue(selectedDocument.getUploadDate());
            filePathField.setText(selectedDocument.getFilePath());
        }
    }

    @FXML
    private void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        typeField.clear();
        caseIdField.clear();
        uploadDatePicker.setValue(null);
        filePathField.clear();
    }
}
