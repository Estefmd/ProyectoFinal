package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.viewController;

import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.controller.UsuarioController;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsuarioViewController {

    UsuarioController usuarioController;
    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private TableView<UsuarioDto> tableViewUsuarios;

    @FXML
    private TableColumn<UsuarioDto, String> colIdUsuario;

    @FXML
    private TableColumn<UsuarioDto, String> colNombreCompleto;

    @FXML
    private TableColumn<UsuarioDto, String> colCorreo;

    @FXML
    private TableColumn<UsuarioDto, String> colNumeroTelefono;

    @FXML
    private TableColumn<UsuarioDto, String> colDireccion;

    @FXML
    private TableColumn<UsuarioDto, Double> colSaldo;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private TextField txtNombreCompleto;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNumeroTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtSaldo;

    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
        initView();
    }

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void onEditarUsuario(ActionEvent event) {
        actualizarUsuario();
    }

    @FXML
    void onEliminarUsuario(ActionEvent event) {
        eliminarUsuario();
    }

    @FXML
    void onBuscarUsuario(ActionEvent event) {
        buscarUsuario();
    }

    @FXML
    void onLimpiarDatos(ActionEvent event) {
        limpiarCampos();
        mostrarMensaje("Datos limpiados", null, "Todos los campos han sido limpiados", Alert.AlertType.INFORMATION);
    }

    private void initView() {
        initDataBinding();
        obtenerUsuarios();
        tableViewUsuarios.setItems(listaUsuariosDto);
        listenerSelection();
    }

    private void initDataBinding() {
        colIdUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idUsuario()));
        colNombreCompleto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreCompleto()));
        colCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        colNumeroTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numeroTelefono()));
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
    }

    private void obtenerUsuarios() {
        listaUsuariosDto.addAll(usuarioController.obtenerUsuarios());
    }

    private void listenerSelection() {
        tableViewUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }

    private void agregarUsuario() {
        UsuarioDto usuarioDto = crearUsuarioDto();
        if (datosValidos(usuarioDto)) {
            if (usuarioController.agregarUsuario(usuarioDto)) {
                listaUsuariosDto.add(usuarioDto);
                limpiarCampos();
                mostrarMensaje("Usuario agregado", null, "Usuario agregado exitosamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", null, "No se pudo agregar el usuario", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Campos incompletos", null, "Por favor complete todos los campos", Alert.AlertType.WARNING);
        }
    }

    private void actualizarUsuario() {
        if (usuarioSeleccionado != null) {
            UsuarioDto usuarioDto = crearUsuarioDto();
            if (usuarioController.actualizarUsuario(usuarioSeleccionado.idUsuario(), usuarioDto)) {
                int index = listaUsuariosDto.indexOf(usuarioSeleccionado);
                listaUsuariosDto.set(index, usuarioDto);
                limpiarCampos();
                mostrarMensaje("Usuario actualizado", null, "Usuario actualizado exitosamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", null, "No se pudo actualizar el usuario", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Atención", null, "Seleccione un usuario para editar", Alert.AlertType.WARNING);
        }
    }

    private void eliminarUsuario() {
        if (usuarioSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Está seguro de eliminar este usuario?")) {
                if (usuarioController.eliminarUsuario(usuarioSeleccionado.idUsuario())) {
                    listaUsuariosDto.remove(usuarioSeleccionado);
                    limpiarCampos();
                    mostrarMensaje("Usuario eliminado", null, "Usuario eliminado exitosamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Error", null, "No se pudo eliminar el usuario", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Atención", null, "Seleccione un usuario para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void buscarUsuario() {
        String idUsuarioBuscado = txtIdUsuario.getText();
        if (idUsuarioBuscado.isBlank()) {
            mostrarMensaje("Campo vacío", null, "Ingrese el ID del usuario a buscar", Alert.AlertType.WARNING);
            return;
        }

        boolean encontrado = false;
        for (UsuarioDto usuarioDto : listaUsuariosDto) {
            if (usuarioDto.idUsuario().equals(idUsuarioBuscado)) {
                mostrarInformacionUsuario(usuarioDto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            mostrarMensaje("No encontrado", null, "No se encontró un usuario con ese ID", Alert.AlertType.INFORMATION);
        }
    }

    private UsuarioDto crearUsuarioDto() {
        double saldo = 0;
        try {
            saldo = Double.parseDouble(txtSaldo.getText());
        } catch (NumberFormatException e) {
            saldo = 0;
        }
        return new UsuarioDto(
                txtIdUsuario.getText(),
                txtNombreCompleto.getText(),
                txtCorreo.getText(),
                txtNumeroTelefono.getText(),
                txtDireccion.getText(),
                saldo
        );
    }

    private boolean datosValidos(UsuarioDto usuarioDto) {
        return !(usuarioDto.idUsuario().isBlank() ||
                usuarioDto.nombreCompleto().isBlank() ||
                usuarioDto.correo().isBlank() ||
                usuarioDto.numeroTelefono().isBlank() ||
                usuarioDto.direccion().isBlank());
    }

    private void mostrarInformacionUsuario(UsuarioDto usuarioSeleccionado) {
        if (usuarioSeleccionado != null) {
            txtIdUsuario.setText(usuarioSeleccionado.idUsuario());
            txtNombreCompleto.setText(usuarioSeleccionado.nombreCompleto());
            txtCorreo.setText(usuarioSeleccionado.correo());
            txtNumeroTelefono.setText(usuarioSeleccionado.numeroTelefono());
            txtDireccion.setText(usuarioSeleccionado.direccion());
            txtSaldo.setText(String.valueOf(usuarioSeleccionado.saldo()));
        }
    }

    private void limpiarCampos() {
        txtIdUsuario.clear();
        txtNombreCompleto.clear();
        txtCorreo.clear();
        txtNumeroTelefono.clear();
        txtDireccion.clear();
        txtSaldo.clear();
        tableViewUsuarios.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        Optional<ButtonType> action = alerta.showAndWait();
        return action.isPresent() && action.get() == ButtonType.OK;
    }
}

