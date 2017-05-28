package com.example.rekin_biznesu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Kalkulacyjny extends AppCompatActivity {
    float A1, A2, B1, B2, C1, C2, D1, D2, E1, E2, F1, F2, G1, G2, H1, H2, I1, I2 = 0;
    float J1, J2, K1, K2, L1, L2, M1, M2, N1, N2, O1, O2, P1, P2 = 0;

    float zysk1 = 0;
    float zysk2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akalkulacyjny);
        MainActivity.wariant = "kalkulacyjny";
    }

    public void ak(View view) {
        try {
            EditText a23 = (EditText) findViewById(R.id.ak23);
            float a23v = Float.valueOf(a23.getText().toString());

            EditText a24 = (EditText) findViewById(R.id.ak24);
            float a24v = Float.valueOf(a24.getText().toString());

            EditText a13 = (EditText) findViewById(R.id.ak13);
            float a13v = Float.valueOf(a13.getText().toString());

            EditText a14 = (EditText) findViewById(R.id.ak14);
            float a14v = Float.valueOf(a14.getText().toString());

            A1 = a23v + a13v;
            A2 = a14v + a24v;
        } catch (NumberFormatException e) {
        }

        setContentView(R.layout.bkalkucjny);
    }

    public void bkc(View view) {
        try {
            EditText b23 = (EditText) findViewById(R.id.bk23);
            float b23v = Float.valueOf(b23.getText().toString());

            EditText b24 = (EditText) findViewById(R.id.bk24);
            float b24v = Float.valueOf(b24.getText().toString());

            EditText b13 = (EditText) findViewById(R.id.bk13);
            float b13v = Float.valueOf(b13.getText().toString());

            EditText b14 = (EditText) findViewById(R.id.bk14);
            float b14v = Float.valueOf(b14.getText().toString());

            B1 = b23v + b13v;
            B2 = b14v + b24v;
        } catch (NumberFormatException e) {
        }
        setContentView(R.layout.cde_kalkulacyjny);
        C1 = A1 - B1;
        C2 = A2 - B2;
        TextView c1 = (TextView) findViewById(R.id.ck03);
        c1.setText(String.valueOf(C1));

        TextView c2 = (TextView) findViewById(R.id.ck04);
        c2.setText(String.valueOf(C2));

    }

    public void cde(View view) {
        try {
            EditText d1 = (EditText) findViewById(R.id.dk03);
            D1 = Float.valueOf(d1.getText().toString());

            EditText d2 = (EditText) findViewById(R.id.dk04);
            D2 = Float.valueOf(d2.getText().toString());

            EditText e1 = (EditText) findViewById(R.id.ek03);
            E1 = Float.valueOf(e1.getText().toString());

            EditText e2 = (EditText) findViewById(R.id.ek04);
            E2 = Float.valueOf(e2.getText().toString());
        } catch (NumberFormatException e) {
        }
        setContentView(R.layout.fkalkulacyjny);

        F1 = C1 - D1 - E1;
        F2 = C2 - D2 - E2;

        TextView c1 = (TextView) findViewById(R.id.fk03);
        c1.setText(String.valueOf(F1));

        TextView c2 = (TextView) findViewById(R.id.fk04);
        c2.setText(String.valueOf(F2));

    }

    public void fk(View view) {
        setContentView(R.layout.dpozostaleprzychody);

        TextView dnag = (TextView) findViewById(R.id.d01);
        dnag.setText("G");
    }

    public void de(View view) {

        int[] ids1 = new int[]{R.id.d13, R.id.d23, R.id.d313, R.id.d323, R.id.d333};//edittexty layout d
        int[] ids2 = new int[]{R.id.d14, R.id.d24, R.id.d314, R.id.d324, R.id.d334};//edittexty layout d

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                G1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                G2 += value;
            } catch (NumberFormatException e) {
            }
        }
        setContentView(R.layout.epozostalekosztyop);
        TextView enah = (TextView) findViewById(R.id.e01);
        enah.setText("H");
    }

    public void ef(View view) {
//        suma
        int[] ids1 = new int[]{R.id.e13, R.id.e23, R.id.e313, R.id.e323, R.id.e333};//edittexty layout e
        int[] ids2 = new int[]{R.id.e14, R.id.e24, R.id.e314, R.id.e324, R.id.e334};//edittexty layout e

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                H1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                H2 += value;
            } catch (NumberFormatException e) {
            }
        }
        setContentView(R.layout.fzyskzdzialalnosci);
        I1 = F1 + G1 - H1;
        I2 = F2 + G2 - H2;

        TextView f03 = (TextView) findViewById(R.id.f03);
        f03.setText(String.valueOf(I1));

        TextView f04 = (TextView) findViewById(R.id.f04);
        f04.setText(String.valueOf(I2));

        TextView enah = (TextView) findViewById(R.id.f01);
        enah.setText("I");
    }

    public void fg(View view) {

        setContentView(R.layout.gprzychodyfinansowe);
        TextView enah = (TextView) findViewById(R.id.g01);
        enah.setText("J");
    }

    public void gh(View view) {
//        suma
        int[] ids1 = new int[]{R.id.g13, R.id.g23, R.id.g33, R.id.g43, R.id.g53};//edittexty layout g1
        int[] ids2 = new int[]{R.id.g14, R.id.g24, R.id.g34, R.id.g44, R.id.g54};//edittexty layout g2

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                J1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                J2 += value;
            } catch (NumberFormatException e) {
            }
        }
        setContentView(R.layout.hkosztyfinansowe);
        TextView enah = (TextView) findViewById(R.id.h01);
        enah.setText("K");
    }

    public void hi(View view) {
//        suma
        int[] ids1 = new int[]{R.id.h13, R.id.h23, R.id.h33, R.id.h43};//edittexty layout h
        int[] ids2 = new int[]{R.id.h14, R.id.h24, R.id.h34, R.id.h44};//edittexty layout h

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                K1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                K2 += value;
            } catch (NumberFormatException e) {
            }
        }
        setContentView(R.layout.izyskzdzialgosp);
        L1 = I1 + J1 - K1;
        L2 = I2 + J2 - K2;

        TextView i03 = (TextView) findViewById(R.id.i03);
        i03.setText(String.valueOf(L1));

        TextView i04 = (TextView) findViewById(R.id.i04);
        i04.setText(String.valueOf(L2));
        TextView enah = (TextView) findViewById(R.id.i01);
        enah.setText("L");
    }

    public void ij(View view) {
//        (F+G-H)  v l=i+j-k

        setContentView(R.layout.jwynikizdarzen);
        TextView enah = (TextView) findViewById(R.id.j01);
        enah.setText("M");
    }

    public void jk(View view) {
//         (J.I.-J.II.)  v m= m.i -m.ii


        EditText j23 = (EditText) findViewById(R.id.j23);
        float j23v = Float.valueOf(j23.getText().toString());

        EditText j24 = (EditText) findViewById(R.id.j24);
        float j24v = Float.valueOf(j24.getText().toString());

        EditText j13 = (EditText) findViewById(R.id.j13);
        float j13v = Float.valueOf(j13.getText().toString());

        EditText j14 = (EditText) findViewById(R.id.j14);
        float j14v = Float.valueOf(j14.getText().toString());

        setContentView(R.layout.kzyskbrutto);

        TextView k03 = (TextView) findViewById(R.id.k03);
        TextView k04 = (TextView) findViewById(R.id.k04);

        M1 = j13v - j23v;
        M2 = j14v - j24v;

        N1 = L1 + M1;
        N2 = L2 + M2;

        k03.setText(String.valueOf(N1));
        k04.setText(String.valueOf(N2));

        TextView enah = (TextView) findViewById(R.id.k01);
        enah.setText("N");
    }

    public void kl(View view) {
//          k=(I+J)  v n=l+m
        setContentView(R.layout.lpodatekdochodowy);

        TextView enah = (TextView) findViewById(R.id.l01);
        enah.setText("O");
    }

    public void lm(View view) {
        EditText l03 = (EditText) findViewById(R.id.l03);
        EditText l04 = (EditText) findViewById(R.id.l04);

        O1 = Float.valueOf(l03.getText().toString());
        O2 = Float.valueOf(l04.getText().toString());
        Toast.makeText(getApplicationContext(), "Obliczono przychód netto.", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.mpozostale);

    }

    public void mn(View view) {
//    zysk =    (K-L-M)  v n-o-p
        setContentView(R.layout.nzysknetto);
        TextView n03 = (TextView) findViewById(R.id.n03);
        TextView n04 = (TextView) findViewById(R.id.n04);

        zysk1 = N1 - O1 - P1;
        zysk2 = N2 - O2 - P2;

        MainActivity.zyskObrotowy = zysk2;
        MainActivity.zyskPoprzedni = zysk1;

        n03.setText(String.valueOf(zysk1));
        n04.setText(String.valueOf(zysk2));
    }

    public void wroc(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void zapisz(View view) {

        Intent intent = new Intent(this, Baza.class);
        startActivity(intent);
    }
}
