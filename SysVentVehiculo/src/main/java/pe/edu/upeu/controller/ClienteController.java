package pe.edu.upeu.controller;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.service.ClienteService;
import pe.edu.upeu.service.ClienteServiceImp;

public class ClienteController {
    @FXML
    Button btnGuardar, btnActualizar, btnLimpiar, btnEliminar;
    @FXML
    TextField txtDNI, txtNombre, txtTelefono, txtEmail;
    @FXML
    TableView<Cliente> regClienteTabla;
    private TableColumn<Cliente, String> colDNI, colNombre, colTelefono, colEmail;
    ObservableList<Cliente> clientes;
    int index=-1;
    ClienteService cs= ClienteServiceImp.getInstance();
    @FXML
    public void initialize() {
        definirColumnas();
        Listar();
        agregarEventoSeleccion();
        btnEliminar.setOnAction(e -> {
            if (index != -1) {
                cs.delete(index);
                Listar();
                limpiarForm();

            }
        });
        btnLimpiar.setOnAction(e -> {
            limpiarForm();
        });
    }
    void limpiarForm(){
        txtTelefono.setText("");
        txtDNI.setText("");
        txtEmail.setText("");
        txtNombre.setText("");

    }

    public void definirColumnas(){
        colDNI=new TableColumn<>("DNI");
        colEmail=new TableColumn<>("Email");
        colNombre=new TableColumn<>("Nombre");
        colTelefono=new TableColumn<>("Telefono");
        regClienteTabla.getColumns().addAll(colDNI, colNombre,colTelefono, colEmail);
    }

    private void Listar(){
        colDNI.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getIdDni()));
        colDNI.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getNombre()));
        colDNI.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getEmail()));
        colDNI.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getTelefono()));
        clientes= FXCollections.observableArrayList(cs.finAll());
        regClienteTabla.setItems(clientes);
    }

    private void agregarEventoSeleccion(){
        regClienteTabla.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue)->{
                    if (newValue!=null){
                        txtDNI.setText(newValue.getIdDni());
                        txtEmail.setText(newValue.getEmail());
                        txtNombre.setText(newValue.getNombre());
                        txtTelefono.setText(newValue.getTelefono());

                    }

                });
    }

    }

