package com.example.proyecto01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn00, btnBorrar;

    RadioButton rbt01,rbt02,rbt03,rbt04,rbt05,rbt06;

    StringBuilder clave;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        clave = new StringBuilder();
        contador = 0;

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);
        btn05 = findViewById(R.id.btn05);
        btn06 = findViewById(R.id.btn06);
        btn07 = findViewById(R.id.btn07);
        btn08 = findViewById(R.id.btn08);
        btn09 = findViewById(R.id.btn09);
        btn00 = findViewById(R.id.btn00);
        btnBorrar = findViewById(R.id.btnBorrar);

        btn01.setOnClickListener(onClickListener);
        btn02.setOnClickListener(onClickListener);
        btn03.setOnClickListener(onClickListener);
        btn04.setOnClickListener(onClickListener);
        btn05.setOnClickListener(onClickListener);
        btn06.setOnClickListener(onClickListener);
        btn07.setOnClickListener(onClickListener);
        btn08.setOnClickListener(onClickListener);
        btn09.setOnClickListener(onClickListener);
        btn00.setOnClickListener(onClickListener);

        rbt01 = findViewById(R.id.rbt01);
        rbt02 = findViewById(R.id.rbt02);
        rbt03 = findViewById(R.id.rbt03);
        rbt04 = findViewById(R.id.rbt04);
        rbt05 = findViewById(R.id.rbt05);
        rbt06 = findViewById(R.id.rbt06);


        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clave.length() > 0) {
                    clave.deleteCharAt(clave.length() - 1);

                    contador--;

                    switch (contador) {
                        case 0:
                            rbt01.setChecked(false);
                            break;
                        case 1:
                            rbt02.setChecked(false);
                            break;
                        case 2:
                            rbt03.setChecked(false);
                            break;
                        case 3:
                            rbt04.setChecked(false);
                            break;
                        case 4:
                            rbt05.setChecked(false);
                            break;
                        case 5:
                            rbt06.setChecked(false);
                            break;
                    }
                }
            }
        });





    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String numero = btn.getText().toString();
            clave.append(numero);
            contador++;


            switch (contador) {
                case 1:
                    rbt01.setChecked(true);
                    break;
                case 2:
                    rbt02.setChecked(true);
                    break;
                case 3:
                    rbt03.setChecked(true);
                    break;
                case 4:
                    rbt04.setChecked(true);
                    break;
                case 5:
                    rbt05.setChecked(true);
                    break;
                case 6:
                    rbt06.setChecked(true);
                    mostrarClave();
                    break;
            }
        }
    };






    // Método para mostrar la clave con un Toast
    private void mostrarClave() {
        Toast.makeText(getApplicationContext(), "La clave es: " + clave.toString(), Toast.LENGTH_LONG).show();
    }
}