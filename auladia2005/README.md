# Projeto Aula Dia 20/05 (auladia2005)

Este é um projeto de aplicação web simples projetado para gerenciar o cadastro de funcionários de uma empresa. Ele permite listar, adicionar, editar e excluir funcionários (nome, função e salário) por meio de uma interface interativa com banco de dados.

Recentemente, a aplicação recebeu uma **tela de login com design premium (Glassmorphism)**, exigindo que os usuários se autentiquem antes de obter acesso às informações sensíveis de salários dos funcionários.

## Tecnologias Utilizadas

- **Frontend**: HTML5, CSS3 (Design Moderno com Glassmorphism) e JavaScript (Vanilla).
- **Backend**: Node.js com o framework Express.
- **Banco de Dados**: MySQL (pacote `mysql2`).

## Como Configurar e Executar

1. **Instale as dependências**:
   Navegue até a pasta `backend` do projeto e instale os pacotes necessários:
   ```bash
   cd backend
   npm install
   ```

2. **Configure o Banco de Dados**:
   - Inicie o seu servidor MySQL (ex: através do XAMPP).
   - O sistema espera um banco de dados local chamado `crud_funcionarios` acessível pelo usuário `root` (sem senha).
   - *Nota:* O sistema utiliza as tabelas `funcionarios` e `usuarios`. 

3. **Inicie o Servidor**:
   Ainda na pasta `backend`, execute o comando:
   ```bash
   npm start
   ```
   A aplicação ficará disponível em: **`http://localhost:3000`**

## Acesso Restrito (Login)

Para acessar a tabela de funcionários, você precisará se autenticar na tela inicial utilizando a conta de administrador padrão:

- **Usuário:** `admin`
- **Senha:** `admin123`

Após inserir essas credenciais com sucesso, a interface principal contendo a tabela de salários e opções de inclusão/edição será liberada.
