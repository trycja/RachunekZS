package com.example.rekin_biznesu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Baza extends AppCompatActivity {

    RequestQueue requestQueue;
    private static String url_insert = "http://v-ie.uek.krakow.pl/~s186156/php/ins.php";

    String identyfikator;
    int rok, rokPoprzedni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baza);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public void dalej(View view) {
        EditText rokED = (EditText) findViewById(R.id.rok1);
        EditText identyfikatorED = (EditText) findViewById(R.id.ident1);
        rok = Integer.parseInt(rokED.getText().toString());
        rokPoprzedni = rok - 1;
        identyfikator = identyfikatorED.getText().toString();

        StringRequest request = new StringRequest(Request.Method.POST, url_insert, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("nazwa", identyfikator);
                parameters.put("rokPoprzedni", String.valueOf(rokPoprzedni));
                parameters.put("rokObrotowy", String.valueOf(rok));
                parameters.put("wariant", MainActivity.wariant);
                parameters.put("zyskPoprzedni", String.valueOf(MainActivity.zyskPoprzedni));
                parameters.put("zyskObecny", String.valueOf(MainActivity.zyskObrotowy));
                return parameters;
            }
        };
        requestQueue.add(request);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
