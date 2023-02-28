package br.xpcriativa.app.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String name = "Phantom.db";
    private static final int version = 1;
    private SQLiteDatabase db;

    public DBHandler(Context context){
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void createDatabase(){
        try{
            db = this.getWritableDatabase();

            db.execSQL("create table if not exists user (" +
                    "id integer primary key autoincrement, " +
                    "email varchar(50)," +
                    "password varchar(50))");

            db.execSQL("insert into user (email, password) values" +
                    "('felipe@gmail.com', '123')," +
                    "('dudu@gmail.com', '123')," +
                    "('marco@gmail.com', '123')," +
                    "('ulissera@gmail.com', '123')," +
                    "('adm', 'adm')");
            db.close();
        }catch(Exception e){
            System.out.println("Error creating database: " + e);
        }
    }
}
