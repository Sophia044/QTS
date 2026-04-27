// Importa o módulo Express (framework para aplicações web com Node.js)
const express = require('express');

// Cria uma instância do aplicativo Express
const app = express();

// Lista de tarefas simulada (poderia vir de um banco de dados no futuro)
let tarefas = [
  { tarefa: "compilar" },
  { tarefa: "testar" }
];

// Rota GET para '/' e '/tarefas'
app.get(['/', '/tarefas'], (req, res) => {
  // Início do conteúdo HTML a ser enviado
  let conteudo = "<html><body><ul>";

  // Para cada tarefa na lista, cria um item <li> dentro da lista <ul>
  for (let t of tarefas) {
    conteudo += `<li>${t.tarefa}</li>`;
  }

  // Fecha a lista e o HTML
  conteudo += "</ul></body></html>";

  // Envia a resposta com status 200, tipo HTML e o conteúdo gerado
  res.status(200)
    .contentType('text/html')
    .send(conteudo);
});

// Inicia o servidor na porta 3000
app.listen(3000, () => {
  console.log('Servidor rodando em http://localhost:3000');
});
