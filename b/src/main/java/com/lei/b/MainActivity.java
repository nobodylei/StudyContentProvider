package com.lei.b;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button in_stu,in_tch,query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in_stu = findViewById(R.id.insert_student);
        in_tch = findViewById(R.id.insert_tetcher);
        query = findViewById(R.id.edit_query);

        in_tch.setOnClickListener(this);
        in_tch.setOnClickListener(this);
        query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ContentResolver resolver;
        Uri uri;
        Uri resultUri;
        switch(v.getId()) {
            case R.id.insert_student:
                //内容解析者
                resolver = getContentResolver();
                uri = Uri.parse("content://com.baidu/student");
                ContentValues values = new ContentValues();
                values.put("name","lisi");
                values.put("age",15);
                resultUri = resolver.insert(uri, values);
                Log.i("tag",resultUri.toString());
                break;
            case R.id.insert_tetcher:
                //内容解析者
                resolver = getContentResolver();
                uri = Uri.parse("content://com.baidu/teacher");
                ContentValues values2 = new ContentValues();
                values2.put("name","zhangsan");
                values2.put("kemu","english");
                resultUri = resolver.insert(uri, values2);
                Log.i("tag",resultUri.toString());

                String mime = resolver.getType(uri);//可以告诉你uri操纵的是什么类型的数据
                break;
            case R.id.edit_query:
                //内容解析者
                resolver = getContentResolver();
                uri = Uri.parse("content://com.baidu");
                resolver.query(uri, null, null, null,null);
        }

    }
}
