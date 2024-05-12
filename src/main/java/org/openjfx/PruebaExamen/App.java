package org.openjfx.PruebaExamen;

import java.sql.Connection;
import java.util.ArrayList;

import org.openjfx.PruebaExamen.utils.UtilsBD;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		Connection con = UtilsBD.conectarBD();
		TabPane tbpMain = new TabPane();

		Tab tab1 = new Tab("Elementos");
		Tab tab2 = new Tab("Detalle");

		BorderPane bdpDistribucion = new BorderPane();
		ScrollPane slpScroll = new ScrollPane();

		MenuBar barraMenu = new MenuBar();

		Menu mArchivo = new Menu("Archivo");
		MenuItem iCargar = new MenuItem("Cargar");

		iCargar.setOnAction(e -> {
			ArrayList<KoalaDO> arrayProductos = DAO.getKoala(con);

			VBox panelProducto = new VBox();
			VBox panelProductoTab2 = new VBox();
			for (int i = 0; i < arrayProductos.size(); i++) {
				Button editar = new Button("Editar");
				Label nombre = new Label(arrayProductos.get(i).getNombre());
				Label nickguerra = new Label(arrayProductos.get(i).getNickguerra());
				Label edad = new Label(Integer.toString(arrayProductos.get(i).getEdad()));
				Label color = new Label(arrayProductos.get(i).getColor());
				panelProducto.getChildren().addAll(nombre, nickguerra, edad, color, editar);
				slpScroll.setContent(panelProducto);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNombre = new TextField();
					txtNombre.setText(arrayProductos.get(arrayPaProbar[0]).getNombre());

					TextField txtNickguerra = new TextField();
					txtNickguerra.setText(arrayProductos.get(arrayPaProbar[0]).getNickguerra());

					TextField txtEdad = new TextField();
					txtEdad.setText(Integer.toString(arrayProductos.get(arrayPaProbar[0]).getEdad()));

					TextField txtColor = new TextField();
					txtColor.setText(arrayProductos.get(arrayPaProbar[0]).getColor());

					panelProductoTab2.getChildren().addAll(txtNombre, txtNickguerra, txtEdad, txtColor, mostrar);

					tab2.setContent(panelProductoTab2);

					mostrar.setOnAction(e3 -> {
						Stage ventanaEmergente = new Stage();
						VBox panelProductoVEmerg = new VBox();
						Label lblNombre = new Label(txtNombre.getText());
						lblNombre.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblNickguerra = new Label(txtNickguerra.getText());
						lblNickguerra.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblEdad = new Label(txtEdad.getText());
						lblEdad.setStyle("-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblColor = new Label(txtColor.getText());
						lblColor.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						panelProductoVEmerg.getChildren().addAll(lblNombre, lblNickguerra, lblEdad, lblColor);
						Scene escenaEmerg = new Scene(panelProductoVEmerg, 400, 200);
						ventanaEmergente.setScene(escenaEmerg);
						ventanaEmergente.show();
					});
				});
			}
		});

		MenuItem iGuardar = new MenuItem("Guardar");
		MenuItem iSalir = new MenuItem("Salir");

		iSalir.setOnAction(e -> {
			stage.close();
		});

		Menu mComponentes = new Menu("Componentes");
		MenuItem iTarjetasGraficas = new MenuItem("Tarjetas Gráficas");

		iTarjetasGraficas.setOnAction(e -> {
			// Igual que Cargar pero, llamaría a una función distinta en el DAO
		});

		MenuItem iMicroprocesadores = new MenuItem("Microprocesadores");
		iMicroprocesadores.setOnAction(e -> {
			// Igual que Cargar pero, llamaría a una función distinta en el DAO
		});

		MenuItem iMemoria = new MenuItem("Memoria");
		iMemoria.setOnAction(e -> {
			// Igual que Cargar pero, llamaría a una función distinta en el DAO
		});

		Menu mAyuda = new Menu("Ayuda");
		MenuItem iAcercaDe = new MenuItem("Acerca de");
		MenuItem iContacto = new MenuItem("Contacto");

		barraMenu.getMenus().addAll(mArchivo, mComponentes, mAyuda);

		mArchivo.getItems().addAll(iCargar, iGuardar, iSalir);
		mComponentes.getItems().addAll(iTarjetasGraficas, iMicroprocesadores, iMemoria);
		mAyuda.getItems().addAll(iAcercaDe, iContacto);

		bdpDistribucion.setTop(barraMenu);
		bdpDistribucion.setCenter(slpScroll);

		tab1.setContent(bdpDistribucion);
		tab1.setClosable(false);

		tbpMain.getTabs().addAll(tab1);

		Scene scene = new Scene(tbpMain, 800, 600);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}