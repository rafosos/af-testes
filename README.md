# af-testes

erros no código:

- O nome da classe sendo instanciada pra conectar com o banco "com.mysql.Driver.Manager" está errada, deveria ser "com.mysql.cj.jdbc.Driver"
- string de conexão está errada:
string atual: "fdbc:mysql://127.0.0.1/test?=user=lopes&password=123";
string correta: "jdbc:mysql://localhost/test?user=minty&password=greatsqldb"
erros:
    - fdbc ao invés de jdbc;
    - "=" no começo dos parâmetros, antes de user, não deveria existir
- não necessáriamente um erro (não vai quebrar o código), mas não há um tratamento de erro efetivo, o catch existe mas não é feito nada com o erro, nenhuma mensagem é exibida nem nada
- falha de segurança: credenciais do bd digitados no código 





Fontes:
[classe mysql](https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-connect-drivermanager.html)