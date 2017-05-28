package com.example.rekin_biznesu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Porownawczy extends AppCompatActivity {
    float A1, A2, B1, B2, C1, C2, D1, D2, E1, E2, F1, F2, G1, G2, H1, H2, I1, I2 = 0;
    float J1, J2, K1, K2, L1, L2, M1, M2, N1, N2, O1, O2, P1, P2 = 0;

    float zysk1 = 0;
    float zysk2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aprzychodynetto);
        MainActivity.wariant = "porownawczy";
    }

    public void ab(View view) {
        //=SUMA(C12:C15) 1-4

        int[] ids1 = new int[]{R.id.a13, R.id.a23, R.id.a33, R.id.a43};//edittexty layout a
        int[] ids2 = new int[]{R.id.a14, R.id.a24, R.id.a34, R.id.a44};//edittexty layout a

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                A1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                A2 += value;
            } catch (NumberFormatException e) {
            }
        }

        Toast.makeText(getApplicationContext(), "Przychód netto za rok poprzedni: " + A1 + ". Przychód netto za rok obrotowy: " + A2, Toast.LENGTH_SHORT).show();

        setContentView(R.layout.bkosztydzialalnosdciop);
    }

    public void bc(View view) {
//        =SUMA(C17:C24)
        int[] ids1 = new int[]{R.id.b13, R.id.b23, R.id.b33, R.id.b43, R.id.b53, R.id.b63, R.id.b73, R.id.b83};//edittexty layout b1
        int[] ids2 = new int[]{R.id.b14, R.id.b24, R.id.b34, R.id.b44, R.id.b54, R.id.b64, R.id.b74, R.id.b84};//edittexty layout b2

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                B1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                B2 += value;
            } catch (NumberFormatException e) {
            }
        }
        C1 = A1 - B1;
        C2 = A2 - B2;
        setContentView(R.layout.czyskzesprzedazy);

        TextView c03 = (TextView) findViewById(R.id.c03);
        c03.setText(String.valueOf(C1));

        TextView c04 = (TextView) findViewById(R.id.c04);
        c04.setText(String.valueOf(C2));

    }

    public void cd(View view) {
//        =C11-C16 a-b
        setContentView(R.layout.dpozostaleprzychody);
    }

    public void de(View view) {

        int[] ids1 = new int[]{R.id.d13, R.id.d23, R.id.d313, R.id.d323, R.id.d333};//edittexty layout d
        int[] ids2 = new int[]{R.id.d14, R.id.d24, R.id.d314, R.id.d324, R.id.d334};//edittexty layout d

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                D1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                D2 += value;
            } catch (NumberFormatException e) {
            }
        }
        setContentView(R.layout.epozostalekosztyop);
    }

    public void ef(View view) {
//        suma
        int[] ids1 = new int[]{R.id.e13, R.id.e23, R.id.e313, R.id.e323, R.id.e333};//edittexty layout e
        int[] ids2 = new int[]{R.id.e14, R.id.e24, R.id.e314, R.id.e324, R.id.e334};//edittexty layout e

        for (int id : ids1) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                E1 += value;
            } catch (NumberFormatException e) {
            }
        }

        for (int id : ids2) {
            try {
                EditText t = (EditText) findViewById(id);
                float value = Float.valueOf(t.getText().toString());
                E2 += value;
            } catch (NumberFormatException e) {
            }
        }
        setContentView(R.layout.fzyskzdzialalnosci);

        F1 = C1 + D1 - E1;
        F2 = C2 + D2 - E2;

        TextView f03 = (TextView) findViewById(R.id.f03);
        f03.setText(String.valueOf(F1));

        TextView f04 = (TextView) findViewById(R.id.f04);
        f04.setText(String.valueOf(F2));
    }

    public void fg(View view) {

        setContentView(R.layout.gprzychodyfinansowe);
    }

    public void gh(View view) {
//        suma
        int[] ids1 = new int[]{R.id.g13, R.id.g23, R.id.g33, R.id.g43, R.id.g53};//edittexty layout g1
        int[] ids2 = new int[]{R.id.g14, R.id.g24, R.id.g34, R.id.g44, R.id.g54};//edittexty layout g2

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
        setContentView(R.layout.hkosztyfinansowe);
    }

    public void hi(View view) {
//        suma
        int[] ids1 = new int[]{R.id.h13, R.id.h23, R.id.h33, R.id.h43};//edittexty layout h
        int[] ids2 = new int[]{R.id.h14, R.id.h24, R.id.h34, R.id.h44};//edittexty layout h

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
        setContentView(R.layout.izyskzdzialgosp);
        I1 = F1 + G1 - H1;
        I2 = F2 + G2 - H2;

        TextView i03 = (TextView) findViewById(R.id.i03);
        i03.setText(String.valueOf(I1));

        TextView i04 = (TextView) findViewById(R.id.i04);
        i04.setText(String.valueOf(I2));
    }

    public void ij(View view) {
//        (F+G-H)  v l=i+j-k
        setContentView(R.layout.jwynikizdarzen);
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

        J1 = j13v - j23v;
        J2 = j14v - j24v;

        K1 = I1 + J1;
        K2 = I2 + J2;

        k03.setText(String.valueOf(K1));
        k04.setText(String.valueOf(K2));
    }

    public void kl(View view) {
//          k=(I+J)  v n=l+m
        setContentView(R.layout.lpodatekdochodowy);
    }

    public void lm(View view) {
        EditText l03 = (EditText) findViewById(R.id.l03);
        EditText l04 = (EditText) findViewById(R.id.l04);
        L1 = Float.valueOf(l03.getText().toString());
        L2 = Float.valueOf(l04.getText().toString());
        Toast.makeText(getApplicationContext(), "Obliczono przychód netto.", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.mpozostale);

    }

    public void mn(View view) {
//    zysk=    (K-L-M)  v n-o-p
        setContentView(R.layout.nzysknetto);
        TextView n03 = (TextView) findViewById(R.id.n03);
        TextView n04 = (TextView) findViewById(R.id.n04);

        zysk1 = K1 - L1 - M1;
        zysk2 = K2 - L2 - M2;

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
