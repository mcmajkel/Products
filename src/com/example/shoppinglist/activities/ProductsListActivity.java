package com.example.shoppinglist.activities;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.shoppinglist.R;
import com.example.shoppinglist.interfaces.ProductsDataSource;
import com.example.shoppinglist.models.Product;

public class ProductsListActivity extends ListActivity {
	private ProductsDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products_list);
		datasource = new ProductsDataSource(this);
		datasource.open();
		List<Product> values = datasource.getAllProducts();
//		attach arrayadapter to listview
		ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,values);
		setListAdapter(adapter);
	}
	
	public void onClick(View view) {
	    @SuppressWarnings("unchecked")
	    ArrayAdapter<Product> adapter = (ArrayAdapter<Product>) getListAdapter();
	    Product product = null;
	    switch (view.getId()) {
	    case R.id.add:
	      
	      EditText productNameInput = (EditText) findViewById(R.id.productName);
	      String productName = productNameInput.getText().toString();
	      product = datasource.createProduct(productName);
	      adapter.insert(product, 0);
	      productNameInput.setText("");
	      break;
	    case R.id.delete:
	      if (getListAdapter().getCount() > 0) {
	        product = (Product) getListAdapter().getItem(0);
	        datasource.deleteProduct(product);
	        adapter.remove(product);
	      }
	      break;
	    }
	    adapter.notifyDataSetChanged();
	  }
}
