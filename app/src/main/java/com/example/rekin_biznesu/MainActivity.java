package com.example.rekin_biznesu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static float zyskPoprzedni;
    public static float zyskObrotowy;
    public static String wariant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void idzPorownawczy(View view) {

        Intent intent = new Intent(this, Porownawczy.class);
        startActivity(intent);
    }


    public void idzKalkulacyjny(View view) {

        Intent intent = new Intent(this, Kalkulacyjny.class);
        startActivity(intent);
    }

    public void idzBaza(View view) {
        Intent intent = new Intent(this, Rezultaty.class);
        startActivity(intent);
    }
}
