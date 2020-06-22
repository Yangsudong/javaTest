package com.yedam.exam2;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BookController implements Initializable {
	@FXML
	TableView<Book> tableView;
	@FXML
	Button btnAdd, btnChart, btnClose, btnFormCancel, btnEditCancel;
	@FXML
	BarChart barChart;

	ObservableList<Book> books;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		books = FXCollections.observableArrayList();

		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonAddAction(arg0);
			}
		});
		btnChart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				buttonChartAction(arg0);
			}
		});

//		더블클릭시 수정
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 2) {
					Stage addStage = new Stage(StageStyle.UTILITY);
					addStage.initModality(Modality.WINDOW_MODAL);
					addStage.initOwner(tableView.getScene().getWindow());

					try {

						Parent parent = FXMLLoader.load(getClass().getResource("UpdateBook.fxml"));
						Scene scene = new Scene(parent);
						addStage.setScene(scene);
						addStage.setResizable(false);
						addStage.show();

						Button btnEdit = (Button) parent.lookup("#btnEdit");
						btnEdit.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								TextField bookName = (TextField) parent.lookup("#bookName1");
								TextField bookWriter = (TextField) parent.lookup("#bookWriter1");
								TextField bookPrice = (TextField) parent.lookup("#bookPrice1");
								TextField bookSales = (TextField) parent.lookup("#bookSales1");

								tableView.getSelectionModel().selectedItemProperty().getValue()
										.setBookName(bookName.getText());
								tableView.getSelectionModel().selectedItemProperty().getValue()
										.setBookWriter(bookWriter.getText());
								tableView.getSelectionModel().selectedItemProperty().getValue()
										.setBookPrice(Integer.parseInt(bookPrice.getText()));
								tableView.getSelectionModel().selectedItemProperty().getValue()
										.setBookSales(Integer.parseInt(bookSales.getText()));
							}
						});

						Button btnEditCancel = (Button) parent.lookup("#btnEditCancel");
						btnEditCancel.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								addStage.close();
							}
						});

					} catch (IOException e) {
						e.printStackTrace();
						
					}
				} else {
					return;
				}
			}
		});

		// 매칭
		TableColumn<Book, ?> tcBookCode = tableView.getColumns().get(0);
		tcBookCode.setCellValueFactory(new PropertyValueFactory("bookCode"));
		TableColumn<Book, ?> tcBookName = tableView.getColumns().get(1);
		tcBookName.setCellValueFactory(new PropertyValueFactory("bookName"));
		TableColumn<Book, ?> tcBookWriter = tableView.getColumns().get(2);
		tcBookWriter.setCellValueFactory(new PropertyValueFactory("bookWriter"));
		TableColumn<Book, ?> tcBookPrice = tableView.getColumns().get(3);
		tcBookPrice.setCellValueFactory(new PropertyValueFactory("bookPrice"));
		TableColumn<Book, ?> tcBookSales = tableView.getColumns().get(4);
		tcBookSales.setCellValueFactory(new PropertyValueFactory("bookSales"));

		tableView.setItems(books);

	}

	public void buttonAddAction(ActionEvent ae) {
		// 윈도우 Stage의 스타일지정
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(btnAdd.getScene().getWindow()); // addStage의 주window설정

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();

			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");

			btnFormAdd.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					TextField bookCode = (TextField) parent.lookup("#bookCode");
					TextField bookName = (TextField) parent.lookup("#bookName");
					TextField bookWriter = (TextField) parent.lookup("#bookWriter");
					TextField bookPrice = (TextField) parent.lookup("#bookPrice");
					TextField bookSales = (TextField) parent.lookup("#bookSales");

					Book book = new Book(bookName.getText(), bookWriter.getText(), Integer.parseInt(bookCode.getText()),
							Integer.parseInt(bookPrice.getText()), Integer.parseInt(bookSales.getText()));
					books.add(book);
					addStage.close();

				}
			});

			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					addStage.close();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void buttonChartAction(ActionEvent ae) {
		Stage chartStage = new Stage(StageStyle.UTILITY);
		chartStage.initModality(Modality.WINDOW_MODAL);
		chartStage.initOwner(btnAdd.getScene().getWindow());

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("bookChart.fxml"));
			BarChart barChart = (BarChart) parent.lookup("#barChart");

			XYChart.Series<String, Integer> seriesBookPrice = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasBookPrice = FXCollections.observableArrayList();
			for (int i = 0; i < books.size(); i++) {
				datasBookPrice.add(new XYChart.Data(books.get(i).getBookName(), books.get(i).getBookSales()));
				// "도서명", 금액
			}
			seriesBookPrice.setData(datasBookPrice);
			seriesBookPrice.setName("금액");

			XYChart.Series<String, Integer> seriesBookSales = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasBookSales = FXCollections.observableArrayList();
			for (int i = 0; i < books.size(); i++) {
				datasBookSales.add(new XYChart.Data(books.get(i).getBookName(), books.get(i).getBookSales()));
				// "도서명", 판매량
			}
			seriesBookSales.setData(datasBookSales);
			seriesBookSales.setName("판매량");

			barChart.setData(FXCollections.observableArrayList(seriesBookPrice, seriesBookSales));

			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.show();
			chartStage.setResizable(false);

			Button btnClose = (Button) parent.lookup("#btnClose");
			btnClose.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					chartStage.close();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
