package com.mrabid.hhis.Helper;

/**
 * Created by Mr.Abid on 6/2/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;


    // Database Name
    private static final String DATABASE_NAME = "android_api";

    // Login table name
    private static final String TABLE_USER = "user";


    private static final String TABLE_RIWAYAT = "riwayat_pasien";

    //login table colum riwayat_pasien
   /* private static final int id = Integer.parseInt("id");
    private static final int id_dokter = Integer.parseInt("id_dokter");
    private static final int no_ktp = Integer.parseInt("no_ktp");
    private static final String nama_pasien =("nama_pasien");
    private static final int umur = Integer.parseInt("umur");
    private static final int berat_badan = Integer.parseInt("berat_badan");
    private static final int tinggi_badan = Integer.parseInt("tinggi_badan");
    private static final String turunan_penyakit =("turunan_penyakit");
    private static final String gejala = ("gejala");
    private static final String diagnosa = ("diagnosa");
    private static final String larangan =("larangan");
    private static final String note = ("note");
    private static final String tgl_periksa =("tgl_periksa");*/

    // Login Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_UID = "uid";
    private static final String KEY_CREATED_AT = "created_at";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE," + KEY_UID + " TEXT,"
                + KEY_CREATED_AT + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

       /* String CREATE_RIWAYAT_TABLE = "CREATE TABLE " + TABLE_RIWAYAT + "("
                + id + " INTEGER PRIMARY KEY," + id_dokter + " INTEGER,"
                + no_ktp + " INTEGER," + nama_pasien + " TEXT,"
                + umur + " INTEGER," +berat_badan + " INTEGER," +
                tinggi_badan + " INTEGER," +turunan_penyakit + " TEXT," +
                gejala + " TEXT," + diagnosa + " TEXT," +larangan + " TEXT," +
                note + " TEXT,"+ tgl_periksa + " TEXT" +")";
        db.execSQL(CREATE_RIWAYAT_TABLE);*/

        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RIWAYAT);
        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String name, String email, String uid, String created_at) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_EMAIL, email); // Email
        values.put(KEY_UID, uid); // Email
        values.put(KEY_CREATED_AT, created_at); // Created At

        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("uid", cursor.getString(3));
            user.put("created_at", cursor.getString(4));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        //db.delete(TABLE_RIWAYAT,null,null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }

    public void addRiwayat(int id_dokter,int no_ktp,String nama_pasien, int umur,int berat_badan,int tinggi_badan,
                           String turunan_penyakit,String gejala,String diagnosa,String larangan,String note,String tgl_periksa){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(String.valueOf(id_dokter), id_dokter);
        values.put(String.valueOf(no_ktp), no_ktp);
        values.put(nama_pasien, nama_pasien);
        values.put(String.valueOf(umur), umur);
        values.put(String.valueOf(berat_badan), berat_badan);
        values.put(String.valueOf(tinggi_badan), tinggi_badan);
        values.put(turunan_penyakit, turunan_penyakit);
        values.put(gejala, gejala);
        values.put(diagnosa, diagnosa);
        values.put(larangan, larangan);
        values.put(note, note);
        values.put(tgl_periksa, tgl_periksa);

        // Inserting Row
        long id = db.insert(TABLE_RIWAYAT, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }
}
