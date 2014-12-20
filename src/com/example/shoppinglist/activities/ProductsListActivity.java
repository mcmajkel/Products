package com.example.shoppinglist.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppinglist.CloudEndpointUtils;
import com.example.shoppinglist.R;
import com.example.shoppinglist.productendpoint.Productendpoint;
import com.example.shoppinglist.productendpoint.model.CollectionResponseProduct;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

public class ProductsListActivity extends ListActivity {

	private static final String ROOT_URL = "http://172.23.65.248:8888/_ah/api";
	private TextView tv = null;
    private SimpleAdapter adapter = null;
    private String[] from = { "name", "id" };
    private int[] to = { android.R.id.text1, android.R.id.text2 };

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products_list);
        tv = new TextView(this);
        tv.setText("Products");
        tv.setGravity(Gravity.CENTER);
        getListView().addHeaderView(tv);
        new GetListAsyncTask(this).execute();
	}
	
	public void onClick(View view) {
	    
	    switch (view.getId()) {
	    case R.id.add:
//	      
	      EditText productNameInput = (EditText) findViewById(R.id.productName);
	      String productName = productNameInput.getText().toString();
	      new AddToDataStoreTask(ProductsListActivity.this).execute(productName);
	      productNameInput.setText("");
	      break;
	      
	    case R.id.update:
	    	new GetListAsyncTask(ProductsListActivity.this).execute();
		      break;  
	    }

	  }
	
	private class AddToDataStoreTask extends AsyncTask<String, Void, com.example.shoppinglist.productendpoint.model.Product> {
		Context context;
        private ProgressDialog pd;

        public AddToDataStoreTask(Context context) {
          this.context = context;
        }
		
        @Override
		protected void onPreExecute(){ 
            super.onPreExecute();
                 pd = new ProgressDialog(context);
                 pd.setMessage("Adding the Product...");
                 pd.show();    
         }
		@Override
		protected com.example.shoppinglist.productendpoint.model.Product doInBackground(String... params) {
			  com.example.shoppinglist.productendpoint.model.Product product = new com.example.shoppinglist.productendpoint.model.Product ();
			  com.example.shoppinglist.productendpoint.model.Product result = new com.example.shoppinglist.productendpoint.model.Product (); 
		      product.setName(params[0].toString());

		      Productendpoint.Builder builder = new Productendpoint.Builder(
		          AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
		          null);
		          
		      builder = CloudEndpointUtils.updateBuilder(builder);
		      builder.setRootUrl(ROOT_URL);
		      Productendpoint endpoint = builder.build();
		      

		      try {
		    	  result = endpoint.insertProduct(product).execute();
		      } catch (IOException e) {
		        // 
		        e.printStackTrace();
		      }

		      return result;
		}
		
		@Override
	    protected void onPostExecute(com.example.shoppinglist.productendpoint.model.Product result) {
			pd.dismiss();
			Toast toast = Toast.makeText(getApplicationContext(), "Added: "+result.getId().toString(), Toast.LENGTH_SHORT);
			toast.show();
			new GetListAsyncTask(ProductsListActivity.this).execute();
	    }
	  }
	
	private class GetListAsyncTask extends AsyncTask<Void, Void, CollectionResponseProduct>{

		Context context;
        private ProgressDialog pd;
        
        public GetListAsyncTask(Context context){
        	this.context = context;
        }
        
        
        protected void onPreExecute(){ 
            super.onPreExecute();
                 pd = new ProgressDialog(context);
                 pd.setMessage("Retrieving Products...");
                 pd.show();    
         }
        
		@Override
		protected CollectionResponseProduct doInBackground(Void... params) {
			// TODO Auto-generated method stub
			Productendpoint.Builder builder = new Productendpoint.Builder(
			          AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
			          null);
			          
			      builder = CloudEndpointUtils.updateBuilder(builder);
			      builder.setRootUrl(ROOT_URL); 
		       CollectionResponseProduct products = null;
               try {
                           Productendpoint service =  builder.build();
                           products = service.listProduct().execute();
               } catch (Exception e) {
                 Log.d("Could not retrieve products", e.getMessage(), e);
                 e.printStackTrace();
               }
               return products;
		}
		
		protected void onPostExecute(CollectionResponseProduct products) {
            pd.dismiss();
      // Do something with the result.
            ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
             List<com.example.shoppinglist.productendpoint.model.Product> _list = products.getItems();
             
             for (com.example.shoppinglist.productendpoint.model.Product product : _list) {
            	 HashMap<String, String> item = new HashMap<String, String>();
                 item.put("name", product.getName());
                 item.put("id", "ID: "+product.getId().toString());
                 list.add(item);
             }
             adapter = new SimpleAdapter(ProductsListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
             setListAdapter(adapter);
    }
	}
	

	
}
