package fja.edu.com.bdmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ControleBanco {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public ControleBanco(Context context){
        banco = new CriarBanco(context);
    }

    public String insereArmazem(String id ,String local,String idproduto,String nomeproduto,String descproduto){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.ID, id);
        valores.put(CriarBanco.LOCAL, local);
        valores.put(CriarBanco.IDPRODUTO, idproduto);
        valores.put(CriarBanco.NOMEPRODUTO, nomeproduto);
        valores.put(CriarBanco.DESCPRODUTO, descproduto);

        resultado = db.insert(CriarBanco.TABELA1, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public String insereProduto(String id, String nome, String desc, String idarmazem){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.ID, id);
        valores.put(CriarBanco.NOME, nome);
        valores.put(CriarBanco.DESCPRODUTO, desc);
        valores.put(CriarBanco.IDARMAZEM, idarmazem);


        resultado = db.insert(CriarBanco.TABELA2, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";

    }

    public String insereTransferencia(String idtransferencia, String idarmazemsaida, String idarmazemdestino, String idproduto){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.ID,idtransferencia);
        valores.put(CriarBanco.IDARMAZEMSAIDA,idarmazemsaida);
        valores.put(CriarBanco.IDARMAZEMDESTINO,idarmazemdestino);
        valores.put(CriarBanco.IDPRODUTO,idproduto);

        resultado = db.insert(CriarBanco.TABELA3, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public String insereUsuario(String idusuario, String nomeusuario, String cargo, String permissao){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.ID,idusuario);
        valores.put(CriarBanco.NOME,nomeusuario);
        valores.put(CriarBanco.CARGO,cargo);
        valores.put(CriarBanco.PERMISSAO,permissao);

        resultado = db.insert(CriarBanco.TABELA3, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

}
