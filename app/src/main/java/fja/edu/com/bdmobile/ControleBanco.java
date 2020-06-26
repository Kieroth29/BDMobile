package fja.edu.com.bdmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public String insereTransferencia(String idtransferencia, String idarmazemsaida, String idarmazemdestino, String nomeproduto,
                                      String idproduto){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.ID,idtransferencia);
        valores.put(CriarBanco.IDARMAZEMSAIDA,idarmazemsaida);
        valores.put(CriarBanco.IDARMAZEMDESTINO,idarmazemdestino);
        valores.put(CriarBanco.NOMEPRODUTO,nomeproduto);
        valores.put(CriarBanco.IDPRODUTO,idproduto);

        resultado = db.insert(CriarBanco.TABELA3, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public String insereUsuario(String idusuario, String loginusuario, String senhausuario,String nomeusuario, String cargo, String permissao){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.ID,idusuario);
        valores.put(CriarBanco.LOGIN,loginusuario);
        valores.put(CriarBanco.SENHA,senhausuario);
        valores.put(CriarBanco.NOME,nomeusuario);
        valores.put(CriarBanco.CARGO,cargo);
        valores.put(CriarBanco.PERMISSAO,permissao);

        resultado = db.insert(CriarBanco.TABELA4, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor carregarArmazem(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.LOCAL,banco.IDPRODUTO,banco.NOMEPRODUTO,banco.DESCPRODUTO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA1, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarProdutos(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME,banco.DESC,banco.IDARMAZEM};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA2, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarTransferencia(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.IDARMAZEMSAIDA,banco.IDARMAZEMDESTINO,banco.IDPRODUTO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA3, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarUsuario(){
        Cursor cursor;
        String[] campos = {banco.ID,banco.LOGIN,banco.SENHA,banco.NOME,banco.CARGO,banco.PERMISSAO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA4,campos,null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaArmazemId(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.LOCAL};
        String where = CriarBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA1,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaProdutoId(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME};
        String where = CriarBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA2,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraProduto(String id, String nome, String desc,
                              String localarmazem){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriarBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriarBanco.ID, id);
        valores.put(CriarBanco.NOME, nome);
        valores.put(CriarBanco.DESCPRODUTO, desc);
        valores.put(CriarBanco.LOCALARMAZEM, localarmazem);

        db.update(CriarBanco.TABELA2,valores,where,null);
        db.close();
    }

    public void deletaProduto(int id){
        String where = CriarBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriarBanco.TABELA2,where,null);
        db.close();
    }

}
