package fja.edu.com.bdmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConsultaMenuActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_menu);

        btn1 = findViewById(R.id.btnConsultarArmazem);
        btn2 = findViewById(R.id.btnConsultarProduto);
        btn3 = findViewById(R.id.btnConsultarTransferencia);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultaMenuActivity.this,
                        ConsultaArmazemActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
