# Projeto de Cadastro de Usuários

Este projeto é uma atividade da matéria de Lógica de Programação, orientada pelo professor Leonardo Guedes da PUC GOIÁS. O objetivo é criar um sistema de cadastro de usuários que permita realizar operações básicas de CRUD (Create, Read, Update, Delete).

## Funcionalidades

O programa oferece as seguintes funcionalidades:

1. **Cadastrar um usuário (Create)**
2. **Consultar usuários cadastrados (Read)**
3. **Consultar um determinado usuário (Read)**
4. **Atualizar um registro de usuário (Update)**
5. **Deletar um registro de usuário (Delete)**
6. **Sair**

## Estrutura do Código

O código está estruturado da seguinte forma:

- **Variáveis Globais**:
  - `Scanner sc`: Para leitura de entradas do usuário.
  - `ArrayList<String> nomes`: Para armazenar os nomes dos usuários.
  - `ArrayList<Integer> nascimento`: Para armazenar as datas de nascimento dos usuários.
  - `ArrayList<String> telefone`: Para armazenar os telefones dos usuários.
  - `ArrayList<String> senha`: Para armazenar as senhas dos usuários.

- **Método Principal (`main`)**:
  - Exibe um menu de opções para o usuário.
  - Chama os métodos correspondentes às operações escolhidas pelo usuário.

- **Métodos Auxiliares**:
  - `GerarTitulo(String titulo)`: Exibe um título formatado.
  - `CadastrarUsuario()`: Realiza o cadastro de um novo usuário.
  - `ConsultarUsuarios()`: Lista todos os usuários cadastrados.
  - `ConsultarUsuario()`: Exibe os dados de um usuário específico.
  - `AtualizarUsuario()`: Atualiza os dados de um usuário específico.
  - `deletarUsuario()`: Remove um usuário do sistema.

## Como Executar

1. Compile o código Java.
2. Execute o programa.
3. Siga as instruções exibidas no menu para realizar as operações desejadas.

## Exemplo de Uso

Ao executar o programa, o usuário verá o seguinte menu:

Escolha uma opção:

1 - Cadastrar um usuário (Create); 
2 - Consultar usuários cadastrados (Read); 
3 - Consultar um determinado usuário (Read); 
4 - Atualizar um registro de usuário (Update); 
5 - Deletar um registro de usuário (Delete); 
6 - Sair;


O usuário pode então escolher uma das opções para realizar a operação correspondente.

## Observações

- Certifique-se de inserir dados válidos ao cadastrar ou atualizar um usuário.
- O índice dos usuários começa em 1 para facilitar a interação com o usuário.
- O programa continuará executando até que a opção "Sair" seja escolhida.

## Pontuação

A atividade vale um total de 10 pontos possíveis.

