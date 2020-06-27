# CargoControl
Atividade interdisciplinar das matérias Banco de Dados II (Prof. Márcio Soussa) e Programação para Dispositivos Móveis (Prof. Arleys Castro)

CENTRO UNIVERSITÁRIO JORGE AMADO

ATIVIDADE INTERDISCIPLINAR BANCO DE DADOS/ PROGRAMAÇÃO PARA DISPOSITIVOS MÓVEIS

Marcos Vinícius Queiroz de Sant’Ana Filho

Salvador, Bahia, Brasil
2020

## Descrição da empresa

A CargoControl é uma empresa responsável por armazenamento e manejamento de estoque, possuindo diversos armazéns na cidade de Salvador. 
O app criado neste projeto tem como objetivo o controle da localização das cargas, registro de transferências e estoque dos armazéns da empresa.

## Modelo de dados

#### Tabela armazem

idarmazem (pk)

local

idproduto(fk)

nomeproduto(fk)

descproduto(fk)

#### Tabela produtos

idproduto (pk)

nome

desc

idarmazem (fk)

#### Tabela transferencia

idtransferencia (pk)

idarmazemsaida (fk)

idarmazemdestino (fk)

idproduto (fk)

#### Tabela usuario

idusuario(pk)

nome

cargo

permissao

## Regra de negócio n° 1

É sempre necessário saber o local de qualquer produto, sendo possível realizar uma consulta pelo nome do mesmo no aplicativo. 

## Regra de negócio n° 2

A tabela “usuario” terá um atributo “permissao”, referente ao nível de acesso do determinado usuário ao sistema. A permissão de administrador possibilitará alteração 
dos dados, enquanto que um usuário comum só poderá consulta-los.
Este atributo é um valor inteiro, e, por definição no código da plataforma Android, o usuário comum terá permissão 1, enquanto que o administrador terá permissão 2.
Além disso, o administrador será incluído no banco de dados como um usuário no ato da criação do BD.

## Script de criação do schema

        CREATE TABLE armazem(
                ID  integer primary key autoincrement
                LOCAL  text,
                IDPRODUTO  integer not null,
                NOMEPRODUTO  text,
                DESCPRODUTO  text,
                FOREIGN KEY (IDPRODUTO) REFERENCES  produto (ID),
                FOREIGN KEY(NOMEPRODUTO) REFERENCES  produto(NOME),
                FOREIGN KEY(DESCPRODUTO) REFERENCES produto(DESC)
                );

        CREATE TABLE produto(
                ID integer primary key autoincrement,
                NOME text,
                DESC text,
                IDARMAZEM integer,
                FOREIGN KEY(IDARMAZEM) REFERENCES armazem (ID)
                );

        CREATE TABLE transferencia(
                ID integer primary key autoincrement,
                IDARMAZEMSAIDA integer,
                IDARMAZEMDESTINO  integer,
                IDPRODUTO  integer,
                FOREIGN KEY (IDARMAZEMSAIDA) REFERENCES produto (ID),
                FOREIGN KEY (IDARMAZEMDESTINO) REFERENCES produto (ID),
                FOREIGN KEY (IDPRODUTO) REFERENCES produto (ID)
                );

        CREATE TABLE usuario(
                ID integer primary key autoincrement,
                LOGIN text,
                SENHA text,
                NOME text,
                CARGO text,
                PERMISSAO integer
                );
                
## Referências bibliográficas

Salvar dados usando o SQLite - Android Developers
https://developer.android.com/training/data-storage/sqlite#java

Criando um CRUD com Android Studio e SQLite - DevMedia
https://www.devmedia.com.br/criando-um-crud-com-android-studio-e-sqlite/32815

Android - Spinner - TutorialsPoint
https://www.tutorialspoint.com/android/android_spinner_control.htm

Materiais de aula
