package fja.edu.com.bdmobile;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class ConsultaTransferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_armazem);

        Spinner sp = findViewById(R.id.sp1ConsArmazem);

        TextView tv1 = findViewById(R.id.tv1ConsTransf);
        TextView tv2 = findViewById(R.id.tv2ConsTransf);
        TextView tv3 = findViewById(R.id.tv3ConsTransf);

        ControleBanco crud = new ControleBanco(getBaseContext());
        Cursor cursor1 = crud.carregarTransferencia();
        Cursor cursor2 = crud.carregarArmazem();
        Cursor cursor3 = crud.carregarProdutos();

        String[] camposTransf = new String[] {CriarBanco.ID};
        String[] camposArmazem = new String[] {CriarBanco.ID, CriarBanco.LOCAL};
        String[] camposProduto = new String[] {CriarBanco.IDPRODUTO, CriarBanco.NOMEPRODUTO};
        int[] idViews1 = new int[] {R.id.spConsTransf};
        int[] idViews2 = new int[] {R.id.tv1ConsTransf};
        int[] idViews3 = new int[] {R.id.tv2ConsTransf};
        int[] idViews4 = new int[] {R.id.tv3ConsTransf};

        SimpleCursorAdapter adaptador1 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor1,camposTransf,idViews1, 0);
        sp.setAdapter(adaptador1);

        SimpleCursorAdapter adaptador2 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor2,camposArmazem,idViews2,0);
        tv1.setTag(adaptador2);

        SimpleCursorAdapter adaptador3 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor2,camposArmazem,idViews3,0);
        tv2.setTag(adaptador3);

        SimpleCursorAdapter adaptador4 = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_armazem,cursor3,camposProduto,idViews4,0);
        tv3.setTag(adaptador4);

    }

}
