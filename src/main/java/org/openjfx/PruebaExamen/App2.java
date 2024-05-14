package org.openjfx.PruebaExamen;

import java.sql.Connection;
import java.util.ArrayList;

import org.openjfx.PruebaExamen.utils.UtilsBD;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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

		RadioButton radHombre = new RadioButton("Hombre");
		RadioButton radMujer = new RadioButton("Mujer");
		ToggleGroup tglSexo = new ToggleGroup();
		radHombre.setToggleGroup(tglSexo);
		radMujer.setToggleGroup(tglSexo);
		radHombre.setSelected(true);
		tglSexo.getSelectedToggle();

		ChoiceBox<String> chbAvestruces = new ChoiceBox<>();
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
			System.out.println(chbAvestruces.getValue());
			// chbAvestruces.getSelectionModel().selectedItemProperty();
			if (chbAvestruces.getSelectionModel().getSelectedIndex() != -1) {
				listaKoalas = DAO.cargarLacayos(
						listaAvestruces.get(chbAvestruces.getSelectionModel().getSelectedIndex()).getIdAvestruz(), con);
				for (int i = 0; i < listaKoalas.size(); i++) {
					Label nombre = new Label(listaKoalas.get(i).getNombre());
					panelKoalas.getChildren().add(nombre);
				}
			}
			RadioButton radio = (RadioButton) tglSexo.getSelectedToggle();
			System.out.println(radio.getText());

		});

//		toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                RadioButton selectedRadioButton = (RadioButton) newValue;
//                System.out.println("Seleccionado: " + selectedRadioButton.getText());
//            }
//        });

		pane.getChildren().addAll(chbAvestruces, btnBuscarLacayos, radHombre, radMujer, panelKoalas);

		Scene scene = new Scene(pane, 600, 400);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}