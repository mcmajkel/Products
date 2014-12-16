package com.example.shoppinglist.activities;

import java.io.IOException;
import java.util.List;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoppinglist.CloudEndpointUtils;
import com.example.shoppinglist.R;
import com.example.shoppinglist.interfaces.ProductsDataSource;
import com.example.shoppinglist.models.Product;
import com.example.shoppinglist.productendpoint.Productendpoint;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

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
//	      
	      EditText productNameInput = (EditText) findViewById(R.id.productName);
	      String productName = productNameInput.getText().toString();
//	      product = datasource.createProduct(productName);
//	      adapter.insert(product, 0);
	      new AddToDataStoreTask().execute(productName);
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
	
	private class AddToDataStoreTask extends AsyncTask<String, Void, com.example.shoppinglist.productendpoint.model.Product> {

	    /**
	     * Calls appropriate CloudEndpoint to indicate that user checked into a place.
	     *
	     * @param params the place where the user is checking in.
	     */

		@Override
		protected com.example.shoppinglist.productendpoint.model.Product doInBackground(String... params) {
			  com.example.shoppinglist.productendpoint.model.Product product = new com.example.shoppinglist.productendpoint.model.Product ();
			  com.example.shoppinglist.productendpoint.model.Product result = new com.example.shoppinglist.productendpoint.model.Product ();
		      // Set the ID of the store where the user is. 
		      // This would be replaced by the actual ID in the final version of the code. 
		      product.setName(params[0].toString());

		      Productendpoint.Builder builder = new Productendpoint.Builder(
		          AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
		          null);
		          
		      builder = CloudEndpointUtils.updateBuilder(builder);
		      builder.setRootUrl("http://192.168.0.10:8888/_ah/api");
		      Productendpoint endpoint = builder.build();
		      

		      try {
		    	  result = endpoint.insertProduct(product).execute();
		      } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }

		      return result;
		}
		
		@Override
	    protected void onPostExecute(com.example.shoppinglist.productendpoint.model.Product result) {
			Toast toast = Toast.makeText(getApplicationContext(), result.getId().toString(), Toast.LENGTH_SHORT);
			toast.show();
	    }
	  }
	
	
}
