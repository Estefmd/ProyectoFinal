package co.edu.uniquindio.billeteravirtual.appbilleteravirtual.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model.Usuario;

public class UsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TableColumn<Usuario, String> colNumeroTelefono;

    @FXML
    private TableColumn<Usuario, String> colNombreCompleto;

    @FXML
    private TableColumn<Usuario, String> colIdUsuario;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TableColumn<Usuario, String> colDireccion;

    @FXML
    private TableColumn<Usuario, String> colCorreo;

    @FXML
    private TextField txtNombreCompleto;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private TextField txtNumeroTelefono;

    @FXML
    private TableColumn<Usuario, Double> colSaldo;

    @FXML
    private TextField txtSaldo;

    @FXML
    private TableView<Usuario> tableViewUsuarios;

    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        String idUsuario = txtIdUsuario.getText();
        String nombreCompleto = txtNombreCompleto.getText();
        String correo = txtCorreo.getText();
        String numeroTelefono = txtNumeroTelefono.getText();
        String direccion = txtDireccion.getText();
        try {
            double saldo = Double.parseDouble(txtSaldo.getText());

            Usuario usuarioNuevo = new Usuario(idUsuario,nombreCompleto,correo,numeroTelefono,direccion,saldo);
            listaUsuarios.add(usuarioNuevo);

            txtIdUsuario.clear();
            txtNombreCompleto.clear();
            txtCorreo.clear();
            txtNumeroTelefono.clear();
            txtDireccion.clear();
            txtSaldo.clear();
            tableViewUsuarios.refresh();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Agregar Usuario");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario agregado exitosamente");
            alerta.showAndWait();
        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El saldo no es valido, verifica el valor. Gracias!");
            alerta.showAndWait();
        }
    }

    @FXML
    void onEditarUsuario(ActionEvent event) {
        Usuario usuarioElegido = tableViewUsuarios.getSelectionModel().getSelectedItem();

        if (usuarioElegido != null) {
            try {
                usuarioElegido.setIdUsuario(txtIdUsuario.getText());
                usuarioElegido.setNombreCompleto(txtNombreCompleto.getText());
                usuarioElegido.setCorreo(txtCorreo.getText());
                usuarioElegido.setNumeroTelefono(txtNumeroTelefono.getText());
                usuarioElegido.setDireccion(txtDireccion.getText());
                usuarioElegido.setSaldo(Double.parseDouble(txtSaldo.getText()));

                tableViewUsuarios.refresh();

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Éxito!");
                alerta.setHeaderText(null);
                alerta.setContentText("Usuario editado:  " + usuarioElegido );
                alerta.showAndWait();
            } catch (NumberFormatException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("Formato debe ser numerico");
                alerta.showAndWait();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario no encontrado");
            alerta.showAndWait();
        }
    }

    @FXML
    void onEliminarUsuario(ActionEvent event) {
        Usuario usuarioElegido = tableViewUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioElegido != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Seguro quiere eliminar este usuario?");
            confirmacion.showAndWait().ifPresent(respuesta -> {
                if (respuesta == ButtonType.OK) {
                    listaUsuarios.remove(usuarioElegido);
                    tableViewUsuarios.refresh();

                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Eliminado!!!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Usuario eliminado:  " + usuarioElegido );
                    alerta.showAndWait();
                }
            });
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atención");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecciona el usuario que deseas eliminar");
            alerta.showAndWait();
        }
    }

    @FXML
    void onBuscarUsuario(ActionEvent event) {
        String idUsuarioBuscado = txtIdUsuario.getText();
        if (idUsuarioBuscado.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atencion, campo vacío");
            alerta.setHeaderText(null);
            alerta.setContentText("Ingrese el ID del usuario que desea buscar");
            alerta.showAndWait();
            return;
        }
        boolean encontrado = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equals(idUsuarioBuscado)) {
                txtNombreCompleto.setText(usuario.getNombreCompleto());
                txtCorreo.setText(usuario.getCorreo());
                txtNumeroTelefono.setText(usuario.getNumeroTelefono());
                txtDireccion.setText(usuario.getDireccion());
                txtSaldo.setText(String.valueOf(usuario.getSaldo()));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error, Usuario no encontrado");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario no encontrado por ese ID");
            alerta.showAndWait();
        }
    }
    @FXML
    void onLimpiarDatos(ActionEvent event) {
        txtIdUsuario.clear();
        txtNombreCompleto.clear();
        txtCorreo.clear();
        txtNumeroTelefono.clear();
        txtDireccion.clear();
        txtSaldo.clear();
        tableViewUsuarios.getSelectionModel().clearSelection();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Limpiado!!!");
        alerta.setHeaderText(null);
        alerta.setContentText("Los datos ingresados fueron limpiados!!!");
        alerta.showAndWait();
    }


    @FXML
    void initialize() {
        colIdUsuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colNombreCompleto.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colNumeroTelefono.setCellValueFactory(new PropertyValueFactory<>("numeroTelefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        listaUsuarios.addAll(
                new Usuario("1097923116", "Laura Martínez", "laura@gmail.com", "3134557890", "Calle 10 #14-45", 500000),
                new Usuario("7564321", "Carlos Pérez", "carlos@gmail.com", "3124345678", "Carrera 20 #12-34", 250000),
                new Usuario("43666051", "Gloria N Davila", "glorian@gmail.com", "3201876543", "Av. Central #99", 1500000)
        );
        tableViewUsuarios.setItems(listaUsuarios);

        tableViewUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null){
                txtIdUsuario.setText(newSelection.getIdUsuario());
                txtNombreCompleto.setText(newSelection.getNombreCompleto());
                txtCorreo.setText(newSelection.getCorreo());
                txtNumeroTelefono.setText(newSelection.getNumeroTelefono());
                txtDireccion.setText(newSelection.getDireccion());
                txtSaldo.setText(String.valueOf(newSelection.getSaldo()));
            }
        });
    }
}

