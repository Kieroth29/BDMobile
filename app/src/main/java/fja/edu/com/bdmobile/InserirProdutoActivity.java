package fja.edu.com.bdmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InserirProdutoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inserir_produto);

            Button btn = findViewById(R.id.btnCadProduto);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ControleBanco crud = new ControleBanco(getBaseContext());
                    EditText nome = findViewById(R.id.et1CadProduto);
                    EditText desc = findViewById((R.id.et2CadProduto));
                    EditText armazem = findViewById(R.id.et3CadProduto);
                    String nomeString = nome.getText().toString();
                    String descString = desc.getText().toString();
                    String armazemString = armazem.getText().toString();
                    String resultado;

                    resultado = crud.insereProduto(nomeString,descString,armazemString,null);

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(InserirProdutoActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
            });
        }
}
