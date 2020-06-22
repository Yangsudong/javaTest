package com.yedam.exam2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	private SimpleStringProperty bookName;
	private SimpleStringProperty bookWriter;
	private SimpleIntegerProperty bookCode;
	private SimpleIntegerProperty bookPrice;
	private SimpleIntegerProperty bookSales;

public Book(String bookName, String bookWriter, int bookCode, int bookPrice, int bookSales) {
	this.bookName = new SimpleStringProperty(bookName);
	this.bookWriter = new SimpleStringProperty(bookWriter);
	this.bookCode = new SimpleIntegerProperty(bookCode);
	this.bookPrice = new SimpleIntegerProperty(bookPrice);
	this.bookSales = new SimpleIntegerProperty(bookSales);
}
	// bookName
	public void setBookName(String bookName) {
		this.bookName.set(bookName);
	}

	public String getBookName() {
		return this.bookName.get();
	}

	public SimpleStringProperty bookNameProperty() {
		return this.bookName;
	}
	
	// bookWriter
	public void setBookWriter(String bookWriter) {
		this.bookWriter.set(bookWriter);
	}

	public String getBookWriter() {
		return this.bookWriter.get();
	}

	public SimpleStringProperty bookWriterProperty() {
		return this.bookWriter;
	}
	
	// bookCode
	public void setBookCode(int bookCode) {
		this.bookCode.set(bookCode);
	}

	public int getBookCode() {
		return this.bookCode.get();
	}

	public SimpleIntegerProperty bookCodeProperty() {
		return this.bookCode;
	}
	
	//bookPrice
	public void setBookPrice(int bookPrice) {
		this.bookPrice.set(bookPrice);
	}

	public int getBookPrice() {
		return this.bookPrice.get();
	}

	public SimpleIntegerProperty bookPriceProperty() {
		return this.bookPrice;
	}
	
	//bookSales
	public void setBookSales(int bookSales) {
		this.bookSales.set(bookSales);
	}

	public int getBookSales() {
		return this.bookSales.get();
	}

	public SimpleIntegerProperty bookSalesProperty() {
		return this.bookSales;
	}
}
