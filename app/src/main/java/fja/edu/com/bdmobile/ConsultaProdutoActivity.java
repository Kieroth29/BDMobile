package fja.edu.com.bdmobile;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class ConsultaProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_produto);

        Spinner sp = findViewById(R.id.spConsProd);

        TextView tv1 = findViewById(R.id.tv1ConsProd);
        TextView tv2 = findViewById(R.id.tv2ConsProd);

        ControleBanco crud = new ControleBanco(getBaseContext());
        Cursor cursor = crud.carregarProdutos();

        String[] spinnerProduto = new String[] {CriarBanco.IDPRODUTO, CriarBanco.NOMEPRODUTO};
        String[] descProduto = new String[] {CriarBanco.DESCPRODUTO};
        String[] armazemProduto = new String[] {CriarBanco.LOCALARMAZEM};
        int[] idViews1 = new int[] {R.id.spConsProd};
        int[] idViews2 = new int[] {R.id.tv1ConsProd};
        int[] idViews3 = new int[] {R.id.tv2ConsProd};

        SimpleCursorAdapter adaptador1 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,spinnerProduto,idViews1, 0);
        sp.setAdapter(adaptador1);

        SimpleCursorAdapter adaptador2 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,descProduto,idViews2,0);
        tv1.setTag(adaptador2);

        SimpleCursorAdapter adaptador3 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,armazemProduto,idViews3,0);
        tv2.setTag(adaptador3);
    }

}