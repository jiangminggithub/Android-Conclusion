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

		// ִ��SQL���
		// db.execSQL("insert into Person (id,name,age) values(?,?,?)",new
		// Object[] {id,name,age});

		// ����ϵͳ�ṩ������
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("name", name);
		values.put("age", age);
		db.insert("Person", null, values);

		db.close();
		helper.close();
		Toast.makeText(this.context, "������ӳɹ���", Toast.LENGTH_SHORT).show();
	}

	public Person Query(String id) {

		helper = new DBHelper(this.context);
		SQLiteDatabase db = helper.getReadableDatabase();

		Cursor cursor = db.rawQuery("select * from Person where id=?", new String[] { id });

		// ��ѯ����У�ָ������ƶ��Ļ�
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

		Toast.makeText(context, "�޸ĳɹ���", Toast.LENGTH_SHORT).show();
	}

	public void delete(String id) {

		helper = new DBHelper(context);
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from Person where id=?", new Object[] { id });
		db.close();
		helper.close();

		Toast.makeText(context, "ɾ���ɹ���", Toast.LENGTH_SHORT).show();
	}

}
