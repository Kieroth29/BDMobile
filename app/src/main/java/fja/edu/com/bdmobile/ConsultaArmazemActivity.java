package fja.edu.com.bdmobile;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class ConsultaArmazemActivity extends AppCompatActivity {

    private Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_armazem);

        Spinner sp1 = findViewById(R.id.spArmazem);
        Spinner sp2 = findViewById(R.id.spProduto);

        ControleBanco crud = new ControleBanco(getBaseContext());
        Cursor cursor = crud.carregarArmazem();

        String[] camposArmazem = new String[] {CriarBanco.ID, CriarBanco.LOCAL};
        String[] camposProduto = new String[] {CriarBanco.IDPRODUTO, CriarBanco.NOMEPRODUTO,
                                               CriarBanco.DESCPRODUTO};
        int[] idViews1 = new int[] {R.id.spArmazem};
        int[] idViews2 = new int[] {R.id.spProduto};

        SimpleCursorAdapter adaptador1 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,camposArmazem,idViews1, 0);
        sp1.setAdapter(adaptador1);
        SimpleCursorAdapter adaptador2 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,camposProduto,idViews2,0);
        sp2.setAdapter(adaptador2);
    }

}
