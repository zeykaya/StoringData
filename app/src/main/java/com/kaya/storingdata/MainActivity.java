package com.kaya.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences; //son kaydedilen veriye ulaşılması için sharedPrefences kullanılır.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextNumber);
        textView=findViewById(R.id.textView);

        sharedPreferences=this.getSharedPreferences("com.kaya.storingdata", Context.MODE_PRIVATE);// sakladığım bilgilere sadece bu uygumala ile ulaşılsın
        int storedAge=sharedPreferences.getInt("storedAge",0);
        if (storedAge==0){
            textView.setText("your age: ");
        }else{
            textView.setText("your age:"+storedAge);
        }

    }
    public void save(View view){
        if(!editText.getText().toString().matches("")){
            int AgeUser=Integer.parseInt(editText.getText().toString());
            textView.setText("your age:"+ AgeUser);

            sharedPreferences.edit().putInt("storedAge",AgeUser).apply();
        }

    }
}