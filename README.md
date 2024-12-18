# af-testes

A classe User fornece métodos para criar uma conexão e verificar junto ao banco de dados se o usuário existe ou não.
A classe possui dois métodos: conectarDB e verificarUsuario, e dois atributos, nome e result.

### conectarDB()
método público, retorna uma instancia de java.sql.Connection
Abre uma conexão com o banco de dados utilizando uma connection string padrão e retorna a conexão criada. 

### nome
atributo público, String
nome do usuário encontrado no banco de dados, valor "" caso pesquisa não tenha sido feita ou usuário não foi encontrado

### result
atributo público, boolean
indica se a pesquisa retornou algum resultado ou não, valor true caso o usuário tenha sido encontrado, false caso pesquisa não tenha sido feita ou usuário não foi encontrado

### verificarUsuario(String login, String senha)
método público, retorna boolean
verifica com o banco de dados se existe um usuário com as credenciais informadas, retorna true para funcionário encontrado, e false para não encontrado. Atualiza o valor das propriedades result e nome. 

## erros no código:

- O nome da classe sendo instanciada pra conectar com o banco "com.mysql.Driver.Manager" está errada, deveria ser "com.mysql.cj.jdbc.Driver"
- não necessáriamente um erro (não vai quebrar o código), mas não há um tratamento de erro efetivo, os catchs existem mas não é feito nada com o erro, nenhuma mensagem é exibida nem nada
- falha de segurança: credenciais do bd digitados no código


## testes:
### estrutura de controle: 
ok
- todos os trechos de código são executados

### teste de condição: 
ok
- if (rs.next())
    - rs.next() = true
    - rs.next() = false

### teste de fluxo de dados: 
ok, todas as variáveis são declaradas antes do uso, e todas são utilizadas
- Connection conn = null;
- String url = "fdbc:mysql://127.0.0.1/test?=user=lopes&password=123";
- public String nome = "";
- public boolean result = false;
- String sql = "";
- Connection conn = conectarDB();
- Statement st = conn.createStatement()
- ResultSet rs = st.executeQuery(sql);

### teste de ciclo: 
ok, não há loops


## Grafo de fluxo:
![grafo de fluxo](./grafo-de-fluxo.png)

## Complexidade ciclomática (M)
M = E - N + 2P

E (arestas) = 13

N (nós) = 9


P (componentes conectados) = 2

M = 13 - 9 + (2*2)

M = 4 + 4 = 8

## Caminhos possíveis

4-1-3-5-6-9

4-1-2-3-5-8-9

4-1-3-5-6-8-9

4-1-3-5-6-7-8-9

4-1-3-5-8-9

4-1-3-5-6-7-9
