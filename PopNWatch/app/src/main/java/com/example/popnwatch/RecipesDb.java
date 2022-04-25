package com.example.popnwatch;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class RecipesDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "PopNWatch.db";
    private static final int DB_VERSION = 1;
    Context context;

    private static final String Recipes = "Recipes";
    private static final String ID ="recipe_id";
    private static final String RECIPES_NAME="name";
    private static final String RECIPES_IMG="img";
    private static final String RECIPES_DESC="description";
    private static final String RECIPES_ETA="ETA";
    private static final String RECIPES_GENRE="genre";

    public RecipesDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super( context, name, factory, version );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+Recipes+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ RECIPES_NAME + " VARCHAR(50), " + RECIPES_IMG + " VARCHAR(255)," + RECIPES_DESC + " VARCHAR(255),"
                + RECIPES_ETA + " VARCHAR(25)," + RECIPES_GENRE + " VARCHAR(25));";

        sqLiteDatabase.execSQL( query );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "Drop table if exists " + Recipes;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public boolean addRecipe(String name, String img, String desc, String eta, String genre){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("img", img);
        contentValues.put("description", desc);
        contentValues.put("ETA", eta);
        contentValues.put("genre", genre);
        database.insert("Recipes",null,contentValues);

        return true;
    }
}
