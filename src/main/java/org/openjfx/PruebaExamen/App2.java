package org.openjfx.PruebaExamen;

import java.sql.Connection;
import java.util.ArrayList;

import org.openjfx.PruebaExamen.utils.UtilsBD;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App2 extends Application {

	@Override
	public void start(Stage stage) {
		Connection con = UtilsBD.conectarBD();
		VBox pane = new VBox();

		ChoiceBox chbAvestruces = new ChoiceBox();
		Button btnBuscarLacayos = new Button("Buscar Lacayos");

		ArrayList<AvestruzDO> listaAvestruces = DAO.getAvestruz(con);

		for (int i = 0; i < listaAvestruces.size(); i++) {
			chbAvestruces.getItems().add(listaAvestruces.get(i).getNombre());
		}

//		// Manejar el evento de selección
//		chbAvestruces.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("Seleccionado: " + newValue);
//        });

		VBox panelKoalas = new VBox();

		btnBuscarLacayos.setOnAction(e -> {
			panelKoalas.getChildren().clear();
			ArrayList<KoalaDO> listaKoalas = DAO.getKoala(con);
			// chbAvestruces.getSelectionModel().selectedItemProperty();
			if (chbAvestruces.getSelectionModel().getSelectedIndex() != -1) {
				listaKoalas = DAO.cargarLacayos(
						listaAvestruces.get(chbAvestruces.getSelectionModel().getSelectedIndex()).getIdAvestruz(), con);
				for (int i = 0; i < listaKoalas.size(); i++) {
					Label nombre = new Label(listaKoalas.get(i).getNombre());
					panelKoalas.getChildren().add(nombre);
				}
			}
		});

		pane.getChildren().addAll(chbAvestruces, btnBuscarLacayos, panelKoalas);

		Scene scene = new Scene(pane, 600, 400);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}