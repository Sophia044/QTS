-- ============================================================
--  Script SQL - Criação do banco de dados e tabela
--  Projeto: Sistema de Cadastro de Usuário
--  Banco:   projetojava
-- ============================================================

-- Cria o banco caso ele ainda não exista
CREATE DATABASE IF NOT EXISTS projetojava;

-- Seleciona o banco para uso
USE projetojava;

-- Cria a tabela 'usuario'
-- id        → chave primária, gerada automaticamente (AUTO_INCREMENT)
-- nome      → nome completo do usuário
-- cpf       → CPF do usuário (armazenado como texto)
-- email     → endereço de e-mail
-- telefone  → número de telefone
CREATE TABLE IF NOT EXISTS usuario (
  id       BIGINT(10)   AUTO_INCREMENT,
  nome     VARCHAR(255),
  cpf      VARCHAR(255),
  email    VARCHAR(255),
  telefone VARCHAR(255),
  PRIMARY KEY (id)
);

-- Mensagem de confirmação (visível ao executar via linha de comando)
SELECT 'Banco de dados e tabela criados com sucesso!' AS Status;
