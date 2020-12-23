package com.example.kotlinhw6_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//自訂建構子,只需要傳入一個Context物件即可
class MyDBHelper (context: Context, name: String = database, factory: SQLiteDatabase.CursorFactory? = null, version: Int = v): SQLiteOpenHelper(context, name, factory, version) {
    companion object {  //繼承SQLiteOpenHelper類別
        private const val database = "mdatabase.db"  //資料庫名稱
        private const val v = 1  //資料庫版本
    }

    override fun onCreate(db: SQLiteDatabase) {
        //建立資料表myTable,包含一個book字串欄位和一個price整數欄位
        db.execSQL("CREATE TABLE myTable(book text PRIMARY KEY, price integer NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS myTable")
        onCreate(db)
    }
}