package fja.edu.com.bdmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InserirTransferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_transferencia);

        Button btn = findViewById(R.id.btnCadTransf);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControleBanco crud = new ControleBanco(getBaseContext());
                EditText arm_des = findViewById(R.id.et1CadTransf);
                EditText arm_sai = findViewById((R.id.et2CadTransf));
                EditText prod = findViewById(R.id.et3CadTransf);
                String desString = arm_des.getText().toString();
                String saiString = arm_sai.getText().toString();
                String prodString = prod.getText().toString();
                String resultado;

                resultado = crud.insereTransferencia(null,desString,saiString,prodString,null);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
