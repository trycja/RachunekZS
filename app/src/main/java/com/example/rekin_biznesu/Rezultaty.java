package com.example.rekin_biznesu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rezultaty extends AppCompatActivity {

    RequestQueue requestQueue;
    private static String url_get = "http://v-ie.uek.krakow.pl/~s186156/php/get.php";
    private static String url_get_years = "http://v-ie.uek.krakow.pl/~s186156/php/getYears.php";
    static List<String> rokiA = new ArrayList<>();
    String identyfikator, wariant;
    int rok;
    static float[] zyski = new float[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezultaty);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        dodajElementyDoSpinner();
    }

    public void dalej(View view) {
        EditText identyfikatorED = (EditText) findViewById(R.id.ident2);
        identyfikator = identyfikatorED.getText().toString();
        pobierz2(identyfikator, wariant);
    }

    public void dodajElementyDoSpinner() {

        String[] elementySpinner = {"porownawczy", "kalkulacyjny"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementySpinner);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerWariant);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int id, long position) {

                switch ((int) position) {
                    case 0:
                        wariant = "porownawczy";
                        break;
                    case 1:
                        wariant = "kalkulacyjny";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void pobierz(final String identyfikator, final String wariant, final int rok) {
        StringRequest request = new StringRequest(Request.Method.POST, url_get, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obiekt = new JSONObject(response);
                    String s = obiekt.getString("RachunekZS");
                    s = s.replace("[", "");
                    s = s.replace("]", "");
                    obiekt = new JSONObject(s);
                    System.out.println(obiekt);
                    zyski[0] = Float.parseFloat(obiekt.getString("zyskPoprzedni"));
                    zyski[1] = Float.parseFloat(obiekt.getString("zyskObecny"));
                    TextView zyskO = (TextView) findViewById(R.id.zyskObecny1);
                    TextView zyskP = (TextView) findViewById(R.id.zyskPoprzedni1);
                    zyskO.setText(String.valueOf(zyski[1]));
                    zyskP.setText(String.valueOf(zyski[0]));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("nazwa", identyfikator);
                parameters.put("wariant", wariant);
                parameters.put("rokObrotowy", String.valueOf(rok));
                return parameters;
            }
        };
        requestQueue.add(request);
    }

    public void pobierz2(final String identyfikator, final String wariant) {
        StringRequest request = new StringRequest(Request.Method.POST, url_get_years, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsnobject = new JSONObject(response);
                    JSONArray jsonArray = jsnobject.getJSONArray("Roki");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obiekt = jsonArray.getJSONObject(i);
                        rokiA.add(obiekt.get("rokObrotowy").toString());
                    }
                    setContentView(R.layout.rezultaty2);
                    dodajElementyDoSpinner2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("nazwa", identyfikator);
                parameters.put("wariant", wariant);
                return parameters;
            }
        };
        requestQueue.add(request);
    }

    public void zatwierdz(View view) {
        pobierz(identyfikator, wariant, rok);
    }

    public void dodajElementyDoSpinner2() {

        int wielkosc = rokiA.size();
        if (wielkosc == 0) {
            Toast.makeText(this, "Brak wyników", Toast.LENGTH_LONG).show();
        } else {
            String[] elementySpinner = new String[wielkosc];
            for (int i = 0; i < wielkosc; i++) {
                elementySpinner[i] = rokiA.get(i);
                System.out.println(elementySpinner[i]);
            }
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, elementySpinner);
            Spinner spinner = (Spinner) findViewById(R.id.spinnerRok);
            spinner.setAdapter(adp);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long arg3) {
                    rok = Integer.parseInt(parent.getItemAtPosition(position).toString());
                }

                public void onNothingSelected(AdapterView<?> arg0) {
                    Toast.makeText(getParent().getApplicationContext(), "Nie wybrano roku!", Toast.LENGTH_LONG).show();

                }
            });
        }
    }

    public void powrot(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
