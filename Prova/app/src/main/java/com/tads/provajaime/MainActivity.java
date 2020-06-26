package com.tads.provajaime;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE,null);


            banco.execSQL("CREATE TABLE IF NOT EXISTS frases( id INTEGER PRIMARY KEY AUTOINCREMENT, frase VARCHAR)");


//            banco.execSQL("INSERT INTO frases values(1,'sorria, seu dia vai melhorar')");
//            banco.execSQL("INSERT INTO frases values(2,'So e corno, quem descobre')");
//            banco.execSQL("INSERT INTO frases values(3,'Nao de o passo maior que a perna')");
//            banco.execSQL("INSERT INTO frases values(4,'Dias de luta, dias de gloria')");
//            banco.execSQL("INSERT INTO frases values(5,'A vida e bela')");

//            while(true){
//                Thread.sleep(10000);
//            }



            int min = 1;
            int max = 5;

//            while (true) {


                int id = new Random().nextInt((max - min) + 1) + min;
                String SQL = "SELECT frase FROM frases WHERE id = " + id;
                Cursor cursor = banco.rawQuery(SQL, null);
                cursor.moveToFirst();
                int IndiceFrase = cursor.getColumnIndex("frase");
                String fraseDoDia = cursor.getString(IndiceFrase);

                final TextView msg = (TextView) findViewById(R.id.msgDoDia);

                msg.setText(fraseDoDia);

//                Thread.sleep(1000);

//                            }

        }catch (Exception e){
            Log.i("ERRO CAPATO","");
            e.printStackTrace();
        }

    }
}
