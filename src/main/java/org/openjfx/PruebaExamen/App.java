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
		Tab tab2 = new Tab("Editar");

		BorderPane bdpDistribucion = new BorderPane();
		ScrollPane slpScroll = new ScrollPane();

		MenuBar barraMenu = new MenuBar();

		Menu mArchivo = new Menu("Archivo");
		MenuItem iCargar = new MenuItem("Cargar");

		iCargar.setOnAction(e -> {
			VBox panelTotal = new VBox();

			ArrayList<KoalaDO> arrayKoala = DAO.getKoala(con);

			VBox panelKoala = new VBox();
			VBox panelKoalaTab2 = new VBox();
			for (int i = 0; i < arrayKoala.size(); i++) {
				Button editar = new Button("Editar");
				Label nombre = new Label(arrayKoala.get(i).getNombre());
				Label nickguerra = new Label(arrayKoala.get(i).getNickguerra());
				Label edad = new Label(Integer.toString(arrayKoala.get(i).getEdad()));
				Label color = new Label(arrayKoala.get(i).getColor());
				panelKoala.getChildren().addAll(nombre, nickguerra, edad, color, editar);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					panelKoalaTab2.getChildren().clear();
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNombre = new TextField();
					txtNombre.setText(arrayKoala.get(arrayPaProbar[0]).getNombre());

					TextField txtNickguerra = new TextField();
					txtNickguerra.setText(arrayKoala.get(arrayPaProbar[0]).getNickguerra());

					TextField txtEdad = new TextField();
					txtEdad.setText(Integer.toString(arrayKoala.get(arrayPaProbar[0]).getEdad()));

					TextField txtColor = new TextField();
					txtColor.setText(arrayKoala.get(arrayPaProbar[0]).getColor());

					panelKoalaTab2.getChildren().addAll(txtNombre, txtNickguerra, txtEdad, txtColor, mostrar);

					tab2.setContent(panelKoalaTab2);

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

			ArrayList<AvestruzDO> arrayAvestruz = DAO.getAvestruz(con);
			VBox panelAvestruz = new VBox();
			VBox panelAvestruzTab2 = new VBox();
			for (int i = 0; i < arrayAvestruz.size(); i++) {
				Button editar = new Button("Editar");
				Label nombre = new Label(arrayAvestruz.get(i).getNombre());
				Label nickguerra = new Label(arrayAvestruz.get(i).getNickguerra());
				Label edad = new Label(Integer.toString(arrayAvestruz.get(i).getEdad()));
				Label altura = new Label(Double.toString(arrayAvestruz.get(i).getAltura()));
				panelAvestruz.getChildren().addAll(nombre, nickguerra, edad, altura, editar);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					panelAvestruzTab2.getChildren().clear();
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNombre = new TextField();
					txtNombre.setText(arrayAvestruz.get(arrayPaProbar[0]).getNombre());

					TextField txtNickguerra = new TextField();
					txtNickguerra.setText(arrayAvestruz.get(arrayPaProbar[0]).getNickguerra());

					TextField txtEdad = new TextField();
					txtEdad.setText(Integer.toString(arrayAvestruz.get(arrayPaProbar[0]).getEdad()));

					TextField txtAltura = new TextField();
					txtAltura.setText(Double.toString(arrayAvestruz.get(arrayPaProbar[0]).getAltura()));

					panelAvestruzTab2.getChildren().addAll(txtNombre, txtNickguerra, txtEdad, txtAltura, mostrar);

					tab2.setContent(panelAvestruzTab2);

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

						Label lblAltura = new Label(txtAltura.getText());
						lblAltura.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						panelProductoVEmerg.getChildren().addAll(lblNombre, lblNickguerra, lblEdad, lblAltura);
						Scene escenaEmerg = new Scene(panelProductoVEmerg, 400, 200);
						ventanaEmergente.setScene(escenaEmerg);
						ventanaEmergente.show();
					});
				});
			}

			ArrayList<CarritoDO> arrayCarrito = DAO.getCarrito(con);
			VBox panelCarrito = new VBox();
			VBox panelCarritoTab2 = new VBox();
			for (int i = 0; i < arrayCarrito.size(); i++) {
				Button editar = new Button("Editar");
				Label numSerie = new Label(arrayCarrito.get(i).getNumSerie());
				Label marca = new Label(arrayCarrito.get(i).getMarca());
				Label velocidad = new Label(Integer.toString(arrayCarrito.get(i).getVelocidadMax()));
				Label armamento = new Label(arrayCarrito.get(i).getArmamento());
				panelCarrito.getChildren().addAll(numSerie, marca, velocidad, armamento, editar);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					panelCarritoTab2.getChildren().clear();
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNumserie = new TextField();
					txtNumserie.setText(arrayCarrito.get(arrayPaProbar[0]).getNumSerie());

					TextField txtMarca = new TextField();
					txtMarca.setText(arrayCarrito.get(arrayPaProbar[0]).getMarca());

					TextField txtVelocidad = new TextField();
					txtVelocidad.setText(Integer.toString(arrayCarrito.get(arrayPaProbar[0]).getVelocidadMax()));

					TextField txtArmamento = new TextField();
					txtArmamento.setText(arrayCarrito.get(arrayPaProbar[0]).getArmamento());

					panelCarritoTab2.getChildren().addAll(txtNumserie, txtMarca, txtVelocidad, txtArmamento, mostrar);

					tab2.setContent(panelCarritoTab2);

					mostrar.setOnAction(e3 -> {
						Stage ventanaEmergente = new Stage();
						VBox panelProductoVEmerg = new VBox();
						Label lblNumSerie = new Label(txtNumserie.getText());
						lblNumSerie.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblMarca = new Label(txtMarca.getText());
						lblMarca.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblVelocidad = new Label(txtVelocidad.getText());
						lblVelocidad.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblArmamento = new Label(txtArmamento.getText());
						lblArmamento.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						panelProductoVEmerg.getChildren().addAll(lblNumSerie, lblMarca, lblVelocidad, lblArmamento);
						Scene escenaEmerg = new Scene(panelProductoVEmerg, 400, 200);
						ventanaEmergente.setScene(escenaEmerg);
						ventanaEmergente.show();
					});
				});
			}
			panelTotal.getChildren().addAll(panelKoala, panelAvestruz, panelCarrito);
			slpScroll.setContent(panelTotal);

		});

		MenuItem iGuardar = new MenuItem("Guardar");
		MenuItem iSalir = new MenuItem("Salir");

		iSalir.setOnAction(e -> {
			stage.close();
		});

		Menu mComponentes = new Menu("Componentes");
		MenuItem iTarjetasGraficas = new MenuItem("Tarjetas Gráficas");

		iTarjetasGraficas.setOnAction(e -> {
			ArrayList<KoalaDO> arrayKoala = DAO.getKoala(con);
			VBox panelKoala = new VBox();
			VBox panelKoalaTab2 = new VBox();
			for (int i = 0; i < arrayKoala.size(); i++) {
				Button editar = new Button("Editar");
				Label nombre = new Label(arrayKoala.get(i).getNombre());
				Label nickguerra = new Label(arrayKoala.get(i).getNickguerra());
				Label edad = new Label(Integer.toString(arrayKoala.get(i).getEdad()));
				Label color = new Label(arrayKoala.get(i).getColor());
				panelKoala.getChildren().addAll(nombre, nickguerra, edad, color, editar);
				slpScroll.setContent(panelKoala);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					panelKoalaTab2.getChildren().clear();
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNombre = new TextField();
					txtNombre.setText(arrayKoala.get(arrayPaProbar[0]).getNombre());

					TextField txtNickguerra = new TextField();
					txtNickguerra.setText(arrayKoala.get(arrayPaProbar[0]).getNickguerra());

					TextField txtEdad = new TextField();
					txtEdad.setText(Integer.toString(arrayKoala.get(arrayPaProbar[0]).getEdad()));

					TextField txtColor = new TextField();
					txtColor.setText(arrayKoala.get(arrayPaProbar[0]).getColor());

					panelKoalaTab2.getChildren().addAll(txtNombre, txtNickguerra, txtEdad, txtColor, mostrar);

					tab2.setContent(panelKoalaTab2);

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

		MenuItem iMicroprocesadores = new MenuItem("Microprocesadores");
		iMicroprocesadores.setOnAction(e -> {
			ArrayList<AvestruzDO> arrayAvestruz = DAO.getAvestruz(con);
			VBox panelAvestruz = new VBox();
			VBox panelAvestruzTab2 = new VBox();
			for (int i = 0; i < arrayAvestruz.size(); i++) {
				Button editar = new Button("Editar");
				Label nombre = new Label(arrayAvestruz.get(i).getNombre());
				Label nickguerra = new Label(arrayAvestruz.get(i).getNickguerra());
				Label edad = new Label(Integer.toString(arrayAvestruz.get(i).getEdad()));
				Label altura = new Label(Double.toString(arrayAvestruz.get(i).getAltura()));
				panelAvestruz.getChildren().addAll(nombre, nickguerra, edad, altura, editar);
				slpScroll.setContent(panelAvestruz);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					panelAvestruzTab2.getChildren().clear();
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNombre = new TextField();
					txtNombre.setText(arrayAvestruz.get(arrayPaProbar[0]).getNombre());

					TextField txtNickguerra = new TextField();
					txtNickguerra.setText(arrayAvestruz.get(arrayPaProbar[0]).getNickguerra());

					TextField txtEdad = new TextField();
					txtEdad.setText(Integer.toString(arrayAvestruz.get(arrayPaProbar[0]).getEdad()));

					TextField txtAltura = new TextField();
					txtAltura.setText(Double.toString(arrayAvestruz.get(arrayPaProbar[0]).getAltura()));

					panelAvestruzTab2.getChildren().addAll(txtNombre, txtNickguerra, txtEdad, txtAltura, mostrar);

					tab2.setContent(panelAvestruzTab2);

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

						Label lblAltura = new Label(txtAltura.getText());
						lblAltura.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						panelProductoVEmerg.getChildren().addAll(lblNombre, lblNickguerra, lblEdad, lblAltura);
						Scene escenaEmerg = new Scene(panelProductoVEmerg, 400, 200);
						ventanaEmergente.setScene(escenaEmerg);
						ventanaEmergente.show();
					});
				});
			}
		});

		MenuItem iMemoria = new MenuItem("Memoria");
		iMemoria.setOnAction(e -> {
			ArrayList<CarritoDO> arrayCarrito = DAO.getCarrito(con);
			VBox panelCarrito = new VBox();
			VBox panelCarritoTab2 = new VBox();
			for (int i = 0; i < arrayCarrito.size(); i++) {
				Button editar = new Button("Editar");
				Label numSerie = new Label(arrayCarrito.get(i).getNumSerie());
				Label marca = new Label(arrayCarrito.get(i).getMarca());
				Label velocidad = new Label(Integer.toString(arrayCarrito.get(i).getVelocidadMax()));
				Label armamento = new Label(arrayCarrito.get(i).getArmamento());
				panelCarrito.getChildren().addAll(numSerie, marca, velocidad, armamento, editar);
				slpScroll.setContent(panelCarrito);

				int[] arrayPaProbar = { i };

				editar.setOnAction(e2 -> {
					panelCarritoTab2.getChildren().clear();
					tbpMain.getTabs().add(tab2);
					Button mostrar = new Button("Mostrar");
					TextField txtNumserie = new TextField();
					txtNumserie.setText(arrayCarrito.get(arrayPaProbar[0]).getNumSerie());

					TextField txtMarca = new TextField();
					txtMarca.setText(arrayCarrito.get(arrayPaProbar[0]).getMarca());

					TextField txtVelocidad = new TextField();
					txtVelocidad.setText(Integer.toString(arrayCarrito.get(arrayPaProbar[0]).getVelocidadMax()));

					TextField txtArmamento = new TextField();
					txtArmamento.setText(arrayCarrito.get(arrayPaProbar[0]).getArmamento());

					panelCarritoTab2.getChildren().addAll(txtNumserie, txtMarca, txtVelocidad, txtArmamento, mostrar);

					tab2.setContent(panelCarritoTab2);

					mostrar.setOnAction(e3 -> {
						Stage ventanaEmergente = new Stage();
						VBox panelProductoVEmerg = new VBox();
						Label lblNumSerie = new Label(txtNumserie.getText());
						lblNumSerie.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblMarca = new Label(txtMarca.getText());
						lblMarca.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblVelocidad = new Label(txtVelocidad.getText());
						lblVelocidad.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						Label lblArmamento = new Label(txtArmamento.getText());
						lblArmamento.setStyle(
								"-fx-font-size: 16px; -fx-font-family: Arial; -fx-text-fill: rgb(255, 0, 0);");

						panelProductoVEmerg.getChildren().addAll(lblNumSerie, lblMarca, lblVelocidad, lblArmamento);
						Scene escenaEmerg = new Scene(panelProductoVEmerg, 400, 200);
						ventanaEmergente.setScene(escenaEmerg);
						ventanaEmergente.show();
					});
				});
			}

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

	/*
	 * ESTILOS
	 * 
	 * [TAMAÑO DE TEXTO]
	 * 
	 * setStyle("-fx-font-size: 16px;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [COLOR DE TEXTO]
	 * 
	 * setStyle("-fx-text-fill: blue;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [COLOR DE FONDO]
	 * 
	 * setStyle("-fx-background-color: #4CAF50;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [COLOR DE FONDO CON GRADIENTE]
	 * 
	 * setStyle("-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E8B57);"
	 * ); );
	 * ----------------------------------------------------------------------------
	 * 
	 * [COLOR DEL BORDE]
	 * 
	 * setStyle("-fx-border-color: #000000;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [GROSOR DEL BORDE]
	 * 
	 * setStyle("-fx-border-width: 2px;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [RADIO DEL BORDE]
	 * 
	 * setStyle("-fx-border-radius: 5px;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [ESTILO DE LETRA]
	 * 
	 * setStyle("-fx-font-style: italic;");
	 * ----------------------------------------------------------------------------
	 * 
	 * [ANCHO DE LETRA]
	 * 
	 * setStyle("-fx-font-weight: bold;");
	 * 
	 * setStyle("-fx-font-weight: light;");
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * [PADDING]
	 * 
	 * setStyle("-fx-padding: 10px;");
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * [OPACIDAD]
	 * 
	 * setStyle("-fx-opacity: 0.7;");
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * 
	 * [HOVER]
	 * 
	 * button.setOnMouseEntered(e ->
	 * button.setStyle("-fx-background-color: #2E8B57; -fx-text-fill: white;"));
	 * 
	 * button.setOnMouseExited(e ->
	 * button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));
	 * 
	 */

	public static void main(String[] args) {
		launch();
	}

}