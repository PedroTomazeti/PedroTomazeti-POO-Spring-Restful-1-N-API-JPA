# PedroTomazeti-POO-Spring-Restful-1-N-API-JPA

Assim que você baixar o repositório, abra ele com o IntelliJ (ou a Java IDE de sua preferência) baixe todas as dependências necessárias e compile.

Em seguida, procure um arquivo chamado "application.example.properties". Ele está exatamente no caminho: src -> main -> resources. Este arquivo é importante para a execução pois contém todas as configurações necessárias para se comunicar com o banco de dados.

Para começar a configuração, copie ele para outro arquivo chamado apenas "application.properties" no mesmo local, e preencha as chaves:

```
...
spring.datasource.url=[...]
spring.datasource.username=
spring.datasource.password=
...
```

Perceba que o campo URL já tem dados inseridos - é apenas para facilitar o preenchimento caso esteja usando o JDBC: neste caso, faça o seguinte:

```
jdbc:DATABASE_MANAGER://localhost:DATABASE_PORT/DATABASE_OR_SCHEMA_NAME
```

1. DATABASE_MANAGER: você irá trocar pelo respectivo gerenciador instalado localmente (mysql, mariadb, postgres, etc...);

2. DATABASE_PORT: você irá substituir pela porta padrão da sua conexão com o banco de dados;

3. DATABASE_OR_SCHEMA_NAME: é basicamente o nome da database (caso esteja usando MariaDB), ou schema (caso esteja usando MySQL pelo Workbench);

4. não salve ainda, vamos configurar agora o username e o password



Voltando a atenção agora ao banco de dados: é importante que você crie, ou já tenha criado uma database/schema para ser usada na aplicação, e um usuário que tenha as permissões necessárias para usar.

Se o database/schema já tiver sido criado, se preocupe apenas em definir um usuário com senha, e com permissões para usar essa base da dados.

Se você ainda for criar o database/schema da nossa aplicação, use o mesmo nome de DATABASE_OR_SCHEMA; e na janela de configuração, ponha um usuário que já exista e que tenha acesso livre a esse database.

Por fim, falta apenas criar a tabela a ser usada pela aplicação. Apenas execute a seguinte query dentro da nossa database:

```sql
create table cursos(
    id int not null auto_increment,
    nome varchar(45) not null,
    carga_horaria varchar(45) not null,
    data_inicio date not null,
    primary key(id)
);
```

E feito!

Dê run na aplicação, e visualize o seu funcionamento na seguinte URL:

```
http://localhost:8101/
```
