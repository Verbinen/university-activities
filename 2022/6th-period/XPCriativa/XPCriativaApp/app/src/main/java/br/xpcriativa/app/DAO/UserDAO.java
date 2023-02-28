package br.xpcriativa.app.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.xpcriativa.app.User;

public class UserDAO {

    private DBHandler dbHandler;
    private SQLiteDatabase db;

    public UserDAO(Context context){
        dbHandler = new DBHandler(context);
    }

    public void insertUser(User user){
        db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        db.insert("user", null, values);
        db.close();
    }

    public boolean hasUser(String email){
        db = dbHandler.getReadableDatabase();

        String query = String.format("select * from user where email = '%s'", email);
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            db.close();
            return true;
        }

        db.close();
        return false;
    }

    public boolean isValidLogin(String email, String pwd){
        if(!hasUser(email))
            return false;

        db = dbHandler.getReadableDatabase();

        String query = String.format("select * from user " +
                "where email = '%s' and " +
                "password = '%s'", email, pwd);
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            db.close();
            return true;
        }
        db.close();
        return false;
    }
}
