package com.example.shoppinglist.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.example.shoppinglist.helpers.DataBaseManager;
import com.example.shoppinglist.models.Product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ProductsDataSource {
	private SQLiteDatabase database;
	private DataBaseManager dbHelper;
	private String[] allColumns = { DataBaseManager.COLUMN_ID, DataBaseManager.COLUMN_NAME,
			DataBaseManager.COLUMN_USED};
	
	public ProductsDataSource(Context context) {
	    dbHelper = new DataBaseManager(context);
	  }
	
	public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  public Product createProduct(String name) {
	    ContentValues values = new ContentValues();
	    values.put(DataBaseManager.COLUMN_NAME, name);
	    values.put(DataBaseManager.COLUMN_USED, false);
	    long insertId = database.insert(DataBaseManager.TABLE_PRODUCTS, null,
	        values);
	    Cursor cursor = database.query(DataBaseManager.TABLE_PRODUCTS,
	        allColumns, DataBaseManager.COLUMN_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Product newProduct = cursorToProduct(cursor);
	    cursor.close();
	    return newProduct;
	  }

	  public void deleteProduct(Product product) {
	    long id = product.getId();
	    System.out.println("Product deleted with id: " + id);
	    database.delete(DataBaseManager.TABLE_PRODUCTS, DataBaseManager.COLUMN_ID
	        + " = " + id, null);
	  }

	  public List<Product> getAllProducts() {
	    List<Product> products = new ArrayList<Product>();

	    Cursor cursor = database.query(DataBaseManager.TABLE_PRODUCTS,
	        allColumns, null, null, null, null, DataBaseManager.COLUMN_USED);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      Product product = cursorToProduct(cursor);
	      products.add(product);
	      cursor.moveToNext();
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return products;
	  }

	  private Product cursorToProduct(Cursor cursor) {
	    Product product = new Product();
	    product.setId(cursor.getLong(0));
	    product.setName(cursor.getString(1));
	    return product;
	  }
	} 
