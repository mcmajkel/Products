package com.example.shoppinglist.helpers;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataBaseManager extends SQLiteOpenHelper {
	public static final String TABLE_PRODUCTS="products";
	public static final String COLUMN_ID="_id";
	public static final String COLUMN_NAME="name";
	public static final String COLUMN_USED="used";
	private static final String DATABASE_NAME = "products.db";
	private static final int DATABASE_VERSION = 2;
	
	private static final String DATABASE_CREATE = "create table "
		      + TABLE_PRODUCTS + "(" + COLUMN_ID
		      + " integer primary key autoincrement, " + COLUMN_NAME
		      + " text not null, " + COLUMN_USED + " bool);";

	public DataBaseManager(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DataBaseManager.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
		    onCreate(db);
	}

}
