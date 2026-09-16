-- PASSO 1: Criação do Banco de Dados e Tabela para o CRUD de Funcionários

CREATE DATABASE IF NOT EXISTS crud_funcionarios;
USE crud_funcionarios;

CREATE TABLE IF NOT EXISTS funcionarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  funcao VARCHAR(100) NOT NULL,
  salario DECIMAL(10,2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
