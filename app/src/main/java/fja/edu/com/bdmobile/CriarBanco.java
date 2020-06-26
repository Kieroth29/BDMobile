package fja.edu.com.bdmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "bancoapp.db";
    public static final String TABELA1 = "armazem";
    public static final String ID = "_id";
    public static final String LOCAL = "local";
    public static final String IDPRODUTO = "idproduto";
    public static final String NOMEPRODUTO = "nomeproduto";
    public static final String DESCPRODUTO = "descproduto";

    public static final String TABELA2 = "produtos";
    public static final String NOME = "nome";
    public static final String DESC = "descricao";
    public static final String IDARMAZEM = "idarmazem";
    public static final String LOCALARMAZEM = "localarmazem";

    public static final String TABELA3 = "transferencia";

    public static final String IDARMAZEMSAIDA = "idarmazemsaida";
    public static final String IDARMAZEMDESTINO = "idarmazemdestino";

    public static final String TABELA4 = "usuario";
    public static final String LOGIN = "loginusuario";
    public static final String SENHA = "senhausuario";
    public static final String CARGO = "cargo";
    public static final String PERMISSAO = "permissao";

    public static final int VERSAO = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABELA1+"("
                + ID + " integer primary key autoincrement,"
                + LOCAL + " text,"
                + IDPRODUTO + " integer not null,"
                + NOMEPRODUTO + " text,"
                + DESCPRODUTO + " text,"
                + "FOREIGN KEY ("+IDPRODUTO+") REFERENCES "+TABELA2+" ("+ID+"),"
                + "FOREIGN KEY("+NOMEPRODUTO+") REFERENCES "+TABELA2+" ("+NOME+"),"
                + "FOREIGN KEY("+DESCPRODUTO+") REFERENCES "+TABELA2+" ("+DESC+")"
                +")";

        String sql2 = "CREATE TABLE "+TABELA2+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + DESC + " text,"
                + IDARMAZEM + " integer, "
                + LOCALARMAZEM + "text, "
                + "FOREIGN KEY("+IDARMAZEM+") REFERENCES "+TABELA1+" ("+ID+"),"
                + "FOREIGN KEY("+LOCALARMAZEM+") REFERENCES "+TABELA1+" ("+LOCAL+")"
                +")";

        String sql3 = "CREATE TABLE "+TABELA3+"("
                + ID + " integer primary key autoincrement,"
                + IDARMAZEMSAIDA + " integer,"
                + IDARMAZEMDESTINO + " integer,"
                + NOMEPRODUTO + "text,"
                + IDPRODUTO + " integer,"
                + "FOREIGN KEY ("+IDARMAZEMSAIDA+") REFERENCES "+TABELA2+" ("+ID+"),"
                + "FOREIGN KEY ("+IDARMAZEMDESTINO+") REFERENCES "+TABELA2+" ("+ID+"),"
                + "FOREIGN KEY ("+IDPRODUTO+") REFERENCES "+TABELA2+" ("+ID+"),"
                + "FOREIGN KEY("+NOMEPRODUTO+") REFERENCES "+TABELA2+"("+NOME+")"
                +")";

        String sql4 = "CREATE TABLE "+TABELA4+"("
                + ID + " integer primary key autoincrement,"
                + LOGIN + "text,"
                + SENHA + "text,"
                + NOME + " text,"
                + CARGO + " text,"
                + PERMISSAO + " integer"
                +")";

        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);

        ContentValues dadosadmin;
        dadosadmin = new ContentValues();

        dadosadmin.put(CriarBanco.ID,1);
        dadosadmin.put(CriarBanco.LOGIN,"admin");
        dadosadmin.put(CriarBanco.SENHA,"admin123");
        dadosadmin.put(CriarBanco.NOME,"Marcos Vinícius Queiroz de Sant'Ana Filho");
        dadosadmin.put(CriarBanco.CARGO,"Administrador");
        dadosadmin.put(CriarBanco.PERMISSAO,2);

        db.insert(CriarBanco.TABELA4, null, dadosadmin);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA1);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA2);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA3);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA4);
        onCreate(db);
    }

    public CriarBanco(Context context) {
        super(context, "bancoapp.db", null, 1);
    }
}