package fja.edu.com.bdmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText et1,et2,et3,et4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ControleBanco crud = new ControleBanco(getBaseContext());
                et1 = findViewById(R.id.etLoginCadastro);
                et2 = findViewById(R.id.etSenhaCadastro);
                et3 = findViewById(R.id.etNomeCadastro);
                et4 = findViewById(R.id.etCargoCadastro);

                String userString = et1.getText().toString();
                String senhaString = et2.getText().toString();
                String nomeString = et3.getText().toString();
                String cargoString = et4.getText().toString();
                String resultado;

                resultado = crud.insereUsuario(null,userString,senhaString,nomeString,cargoString,null);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(CadastroActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
