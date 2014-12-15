package com.example.shoppinglist.interfaces;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.shoppinglist.R;

public class Preferences {
	private final static String FONT_SIZE = "font_sizes";
	private final static String FONT_COLOR_ID = "font_color_id";
	private final static String FONT_COLOR = "font_color";
	private static final String PREFS = "prefs"; //string for shared preferences file across the app
	
	
	protected static SharedPreferences getApplicationPreferences(Context context){
		return context.getSharedPreferences(PREFS, context.MODE_PRIVATE);
	}
	
	public static String readFontSize(Context context){
		String default_font_size = context.getResources().getString(R.string.default_font_size);
		String f_size = getApplicationPreferences(context).getString(FONT_SIZE, default_font_size);
		Log.i(FONT_SIZE+" read: ", f_size);
		return f_size;
	}
	
	public static int readFontColorId(Context context){
    	int saved_font_color_id = getApplicationPreferences(context).getInt(FONT_COLOR_ID, 0);
    	Log.i(FONT_COLOR_ID+" read: ", Integer.valueOf(saved_font_color_id).toString());
    	return saved_font_color_id;
    }

    
    public static void saveFontSize(Context context, String new_font_size){
    	SharedPreferences.Editor editor = getApplicationPreferences(context).edit();
		editor.putString(FONT_SIZE, new_font_size);
		Log.i(FONT_SIZE+" saved: ", new_font_size);
		editor.commit();
    }

    public static boolean saveFontColorId(Context context, int new_font_color_id){
    	SharedPreferences.Editor editor = getApplicationPreferences(context).edit();
    	editor.putInt(FONT_COLOR_ID, new_font_color_id);
    	Log.i(FONT_COLOR_ID+" saved: ", Integer.valueOf(new_font_color_id).toString()); 
    	return editor.commit();
    }
    
    public static boolean saveFontColor(Context context, String new_font_color){
    	SharedPreferences.Editor editor = getApplicationPreferences(context).edit();
    	editor.putString(FONT_COLOR, new_font_color);
    	Log.i(FONT_COLOR+" saved: ", new_font_color);
    	return editor.commit();
    }

    
}
