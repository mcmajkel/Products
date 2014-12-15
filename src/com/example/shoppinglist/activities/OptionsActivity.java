package com.example.shoppinglist.activities;

import com.example.shoppinglist.R;
import com.example.shoppinglist.R.array;
import com.example.shoppinglist.R.id;
import com.example.shoppinglist.R.layout;
import com.example.shoppinglist.R.menu;
import com.example.shoppinglist.interfaces.Preferences;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class OptionsActivity extends ActionBarActivity {
	
//	Preferences prefs = new Preferences(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		populateSpinnerWithColors();
		readPreferences();
	}
	
	public void savePreferences(View v){
		EditText number_font_size = (EditText) findViewById(R.id.number_font_size);
		String new_font_size = number_font_size.getText().toString();
		Preferences.saveFontSize(this,new_font_size);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner_font_color);
		int new_font_color_id = spinner.getSelectedItemPosition();
		Preferences.saveFontColorId(this, new_font_color_id);
		
		String new_font_color = spinner.getSelectedItem().toString();
		Preferences.saveFontColor(this, new_font_color);
	}


	protected void populateSpinnerWithColors(){
		Spinner spinner = (Spinner) findViewById(R.id.spinner_font_color);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_colors, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	
	protected void readPreferences() {
		EditText number_font_size = (EditText) findViewById(R.id.number_font_size);
		String f_size = Preferences.readFontSize(this);
		number_font_size.setText(f_size);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner_font_color);
		spinner.setSelection(Preferences.readFontColorId(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
