package com.qchambers.controller;

import com.qchambers.model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class AppointmentController {

    @FXML private TableView<Appointment> appointmentTable;
    @FXML private TableColumn<Appointment, String> idColumn;
    @FXML private TableColumn<Appointment, String> titleColumn;
    @FXML private TableColumn<Appointment, String> clientIdColumn;
    @FXML private TableColumn<Appointment, String> caseIdColumn;
    @FXML private TableColumn<Appointment, LocalDateTime> dateTimeColumn;
    @FXML private TableColumn<Appointment, String> locationColumn;
    @FXML private TableColumn<Appointment, String> notesColumn;

    @FXML private TextField idField;
    @FXML private TextField titleField;
    @FXML private TextField clientIdField;
    @FXML private TextField caseIdField;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private TextField locationField;
    @FXML private TextArea notesArea;

    private ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        caseIdColumn.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        dateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        appointmentTable.setItems(appointmentList);
    }

    @FXML
    private void addAppointment() {
        String id = idField.getText();
        String title = titleField.getText();
        String clientId = clientIdField.getText();
        String caseId = caseIdField.getText();
        LocalDateTime dateTime = LocalDateTime.of(datePicker.getValue(), java.time.LocalTime.parse(timeField.getText()));
        String location = locationField.getText();
        String notes = notesArea.getText();

        if (!id.isEmpty() && !title.isEmpty()) {
            Appointment appointment = new Appointment(id, title, clientId, caseId, dateTime, location, notes);
            appointmentList.add(appointment);
            clearFields();
        }
    }

    @FXML
    private void updateAppointment() {
        Appointment selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            selectedAppointment.setTitle(titleField.getText());
            selectedAppointment.setClientId(clientIdField.getText());
            selectedAppointment.setCaseId(caseIdField.getText());
            selectedAppointment.setDateTime(LocalDateTime.of(datePicker.getValue(), java.time.LocalTime.parse(timeField.getText())));
            selectedAppointment.setLocation(locationField.getText());
            selectedAppointment.setNotes(notesArea.getText());
            appointmentTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void deleteAppointment() {
        Appointment selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            appointmentList.remove(selectedAppointment);
            clearFields();
        }
    }

    @FXML
    private void selectAppointment() {
        Appointment selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            idField.setText(selectedAppointment.getId());
            titleField.setText(selectedAppointment.getTitle());
            clientIdField.setText(selectedAppointment.getClientId());
            caseIdField.setText(selectedAppointment.getCaseId());
            datePicker.setValue(selectedAppointment.getDateTime().toLocalDate());
            timeField.setText(selectedAppointment.getDateTime().toLocalTime().toString());
            locationField.setText(selectedAppointment.getLocation());
            notesArea.setText(selectedAppointment.getNotes());
        }
    }

    private void clearFields() {
        idField.clear();
        titleField.clear();
        clientIdField.clear();
        caseIdField.clear();
        datePicker.setValue(null);
        timeField.clear();
        locationField.clear();
        notesArea.clear();
    }
}
