package fja.edu.com.bdmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnCadastro;
    private EditText etLogin,etSenha;
    private String inputLogin,inputSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLoginMain);
        btnCadastro = findViewById(R.id.btnCadastroMain);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etLogin = findViewById(R.id.etLoginMain);
                etSenha = findViewById(R.id.etSenhaMain);

                inputLogin = etLogin.getText().toString();
                inputSenha = etSenha.getText().toString();
                String loginCheck,senhaCheck;

                Boolean loginValido = false,senhaValida = false;
                Integer permissao = 0;

                ControleBanco crud = new ControleBanco(getBaseContext());
                Cursor cursor = crud.carregarUsuario();

                do {
                    cursor.moveToNext();
                    loginCheck = cursor.getString(cursor.getColumnIndex("LOGIN"));
                    if(loginCheck.equals(inputLogin)){
                        loginValido = true;
                    }
                }while(!loginValido.equals(true));

                do {
                    cursor.moveToNext();
                    senhaCheck = cursor.getString(cursor.getColumnIndex("SENHA"));
                    if(senhaCheck.equals(inputSenha)){
                        senhaValida = true;
                    }
                }while(!senhaValida.equals(true));

                permissao = cursor.getInt(cursor.getColumnIndex("PERMISSAO"));

                if (loginValido == Boolean.TRUE && senhaValida == Boolean.TRUE) {
                    if(permissao == 1) {
                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }else if(permissao == 2){
                            Intent intent = new Intent(MainActivity.this, MenuAdminActivity.class);
                            startActivity(intent);
                            }
                } else {
                    Toast.makeText(MainActivity.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

}
