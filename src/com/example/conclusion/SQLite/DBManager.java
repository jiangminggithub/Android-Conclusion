package com.example.conclusion.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DBManager {

	private Context context;
	private Person person;
	private DBHelper helper;

	public DBManager(Context context) {
		this.context = context;
	}

	public void add(int id, String name, int age) {

		helper = new DBHelper(this.context);
		SQLiteDatabase db = helper.getWritableDatabase();

		// 执行SQL语句
		// db.execSQL("insert into Person (id,name,age) values(?,?,?)",new
		// Object[] {id,name,age});

		// 调用系统提供的命令
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("name", name);
		values.put("age", age);
		db.insert("Person", null, values);

		db.close();
		helper.close();
		Toast.makeText(this.context, "数据添加成功！", Toast.LENGTH_SHORT).show();
	}

	public Person Query(String id) {

		helper = new DBHelper(this.context);
		SQLiteDatabase db = helper.getReadableDatabase();

		Cursor cursor = db.rawQuery("select * from Person where id=?", new String[] { id });

		// 查询结果中，指针可以移动的话
		if (cursor.moveToNext()) {
			person = new Person();
			person.setId(cursor.getInt(cursor.getColumnIndex("id")));
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setAge(cursor.getInt(cursor.getColumnIndex("age")));

			String result = person.getId() + "," + person.getName() + "," + person.getAge() + "!";
			Log.i("DbQuery", "-->" + result);

			db.close();
			helper.close();
			return person;
		}

		return null;

	}

	public void updata(String name, String oldName) {

		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update Person set name=? where name=?", new Object[] { name, oldName });
		db.close();
		helper.close();

		Toast.makeText(context, "修改成功！", Toast.LENGTH_SHORT).show();
	}

	public void delete(String id) {

		helper = new DBHelper(context);
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from Person where id=?", new Object[] { id });
		db.close();
		helper.close();

		Toast.makeText(context, "删除成功！", Toast.LENGTH_SHORT).show();
	}

}
