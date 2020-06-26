package fja.edu.com.bdmobile;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class ConsultaArmazemActivity extends AppCompatActivity {

    private Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_armazem);

        sp1 = findViewById(R.id.sp1ConsArmazem);
        sp2 = findViewById(R.id.sp2ConsArmazem);

        TextView tv1 = findViewById(R.id.tv1ConsArmazem);

        ControleBanco crud = new ControleBanco(getBaseContext());
        Cursor cursor = crud.carregarArmazem();

        String[] camposArmazem = new String[] {CriarBanco.ID, CriarBanco.LOCAL};
        String[] camposProduto = new String[] {CriarBanco.IDPRODUTO, CriarBanco.NOMEPRODUTO};
        String[] descProduto = new String[] {CriarBanco.DESCPRODUTO};
        int[] idViews1 = new int[] {R.id.sp1ConsArmazem};
        int[] idViews2 = new int[] {R.id.sp2ConsArmazem};
        int[] idViews3 = new int[] {R.id.tv1ConsArmazem};

        SimpleCursorAdapter adaptador1 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,camposArmazem,idViews1, 0);
        sp1.setAdapter(adaptador1);

        SimpleCursorAdapter adaptador2 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,camposProduto,idViews2,0);
        sp2.setAdapter(adaptador2);

        SimpleCursorAdapter adaptador3 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor,descProduto,idViews3,0);
        tv1.setTag(adaptador3);
    }

}
