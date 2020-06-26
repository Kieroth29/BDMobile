package fja.edu.com.bdmobile;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AlterarProdutoActivity extends AppCompatActivity {

    ControleBanco crud;
    Cursor cursor;
    String idProd;
    EditText et1,et2,et3;
    String contEt1,contEt2,contEt3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        et1 = findViewById(R.id.et1AltProduto);
        et2 = findViewById(R.id.et2AltProduto);
        et3 = findViewById(R.id.et3AltProduto);

        Button btn1 = findViewById(R.id.btn1AltProduto);
        Button btn2 = findViewById(R.id.btn2AltProduto);

        idProd = this.getIntent().getStringExtra("id");

        crud = new ControleBanco(getBaseContext());

        cursor = crud.carregaProdutoId(Integer.parseInt(idProd));
        et1.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.NOME)));
        et2.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.DESC)));
        et3.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.LOCALARMAZEM)));

        et1.addTextChangedListener(new TextWatcher() {

                                       public void afterTextChanged(Editable s) {
                                       }

                                       public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                       }

                                       public void onTextChanged(CharSequence s, int start, int before, int count) {
                                           idProd = cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.ID));

                                       }
            });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.alteraProduto(idProd,contEt1,contEt2,contEt3);
                Intent intent = new Intent(AlterarProdutoActivity.this,ConsultaProdutoActivity.class);
                Toast.makeText(AlterarProdutoActivity.this, "Produto alterado.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.deletaProduto(Integer.parseInt(idProd));
                Toast.makeText(AlterarProdutoActivity.this, "Produto deletado.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AlterarProdutoActivity.this,MenuAdminActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}