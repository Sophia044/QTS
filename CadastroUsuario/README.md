# 📋 Sistema de Cadastro de Usuário
### Java Swing + JDBC + MySQL | NetBeans

---

## 📁 Estrutura do Projeto

```
CadastroUsuario/
├── banco_de_dados/
│   └── criar_banco.sql          ← Script SQL para criar banco e tabela
├── nbproject/
│   ├── project.xml              ← Configuração do NetBeans
│   └── project.properties       ← Propriedades de build
└── src/
    ├── factory/
    │   ├── ConnectionFactory.java   ← Fábrica de conexões JDBC
    │   └── TestaConexao.java        ← Teste rápido de conexão
    ├── modelo/
    │   └── Usuario.java             ← Classe de modelo (POJO)
    ├── dao/
    │   └── UsuarioDAO.java          ← Acesso ao banco (INSERT)
    └── gui/
        └── UsuarioGUI.java          ← Interface gráfica (JFrame)
```

---

## ⚙️ Pré-requisitos

| Requisito | Versão recomendada |
|-----------|-------------------|
| Java JDK  | 8 ou superior     |
| NetBeans IDE | 12+ ou Apache NetBeans |
| MySQL Server | 5.7 ou superior |
| mysql-connector-java | 8.x |

---

## 🗄️ 1. Configurar o banco de dados MySQL

Abra o **MySQL Workbench** (ou terminal MySQL) e execute:

```sql
-- Abra o arquivo: banco_de_dados/criar_banco.sql
-- Ou cole o conteúdo abaixo:

CREATE DATABASE IF NOT EXISTS projetojava;
USE projetojava;

CREATE TABLE IF NOT EXISTS usuario (
  id       BIGINT(10)   AUTO_INCREMENT,
  nome     VARCHAR(255),
  cpf      VARCHAR(255),
  email    VARCHAR(255),
  telefone VARCHAR(255),
  PRIMARY KEY (id)
);
```

> **Dica:** Se o MySQL pedir senha de root, edite ConnectionFactory.java
> e altere o campo SENHA = "" para a sua senha.

---

## 🔌 2. Adicionar o driver JDBC no NetBeans

O driver MySQL não vem incluído no Java. Você precisa baixar e adicionar manualmente:

### Passo a passo:

1. Baixe o **mysql-connector-java** em:
   https://dev.mysql.com/downloads/connector/j/
   (escolha "Platform Independent" → .jar)

2. No NetBeans, clique com o botão direito no projeto CadastroUsuario

3. Vá em **Properties** → **Libraries** → **Add JAR/Folder**

4. Selecione o arquivo .jar do connector (ex: mysql-connector-java-8.x.x.jar)

5. Clique em **OK** para confirmar

---

## 🚀 3. Importar o projeto no NetBeans

1. Abra o NetBeans IDE
2. **File → Open Project** (ou Ctrl+Shift+O)
3. Navegue até a pasta CadastroUsuario/
4. Clique em **Open Project**

---

## ✅ 4. Testar a conexão

Antes de executar a GUI, teste se o banco está acessível:

1. No NetBeans, expanda Source Packages → factory
2. Clique com botão direito em TestaConexao.java
3. Selecione **Run File**
4. No console, deve aparecer:
   ```
   Conexão aberta!
   Conexão fechada com sucesso.
   ```

---

## ▶️ 5. Executar a aplicação

- Pressione **F6** (ou clique no botão play verde)
- A janela "Cadastro de Usuário" será aberta

---

## 🖥️ Como usar a interface

| Ação | Comportamento |
|------|--------------|
| Preencha todos os campos e clique Cadastrar | Salva no banco e exibe mensagem de sucesso |
| Deixe algum campo vazio e clique Cadastrar | Exibe alerta de erro "Campos obrigatórios" |
| Clique em Limpar | Apaga todos os campos |
| Clique em Sair | Fecha a aplicação |

---

## 🏗️ Arquitetura (camadas)

```
GUI  (gui.UsuarioGUI)          <- Apresentação (Swing)
       |
       v chama
DAO  (dao.UsuarioDAO)          <- Acesso a dados (PreparedStatement)
       |
       v usa
Factory (factory.ConnFactory)  <- Infraestrutura (Conexão JDBC)
```

---

## 🔒 Segurança

- PreparedStatement previne SQL Injection: os dados do usuário
  são tratados como valores, nunca como código SQL.

---

## 📌 Observações didáticas

- try-with-resources fecha Connection e PreparedStatement automaticamente,
  evitando memory leaks.
- A RuntimeException em ConnectionFactory evita que toda a aplicação
  precise declarar throws SQLException.
- SwingUtilities.invokeLater garante que a GUI rode na EDT
  (Event Dispatch Thread), seguindo as boas práticas do Swing.
