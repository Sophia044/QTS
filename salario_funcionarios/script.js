// ===========================
// Seletores globais
// ===========================
const modal     = document.querySelector('.modal-container')
const tbody     = document.querySelector('tbody')
const sNome     = document.querySelector('#m-nome')
const sFuncao   = document.querySelector('#m-funcao')
const sSalario  = document.querySelector('#m-salario')
const btnSalvar = document.querySelector('#btnSalvar')

let itens
let id

// ===========================
// Persistência (BD simulado)
// Isolado para futura substituição por chamadas fetch/API
// ===========================
const getItensBD = () => JSON.parse(localStorage.getItem('dbfunc')) ?? []
const setItensBD = () => localStorage.setItem('dbfunc', JSON.stringify(itens))

// ===========================
// openModal(edit, index)
// Abre o modal, configura fechamento ao clicar fora,
// preenche ou limpa os campos conforme o modo.
// ===========================
function openModal(edit = false, index = 0) {
  modal.classList.add('active')

  // Fecha ao clicar no overlay (fora do .modal)
  modal.onclick = (e) => {
    if (e.target === modal) closeModal()
  }

  if (edit) {
    sNome.value    = itens[index].nome
    sFuncao.value  = itens[index].funcao
    sSalario.value = itens[index].salario
    id = index
  } else {
    sNome.value    = ''
    sFuncao.value  = ''
    sSalario.value = ''
    id = undefined
  }
}

// ===========================
// closeModal()
// Remove a classe 'active' do modal-container
// ===========================
function closeModal() {
  modal.classList.remove('active')
}

// ===========================
// editItem(index)
// Abre o modal no modo edição com os dados do item
// ===========================
function editItem(index) {
  openModal(true, index)
}

// ===========================
// deleteItem(index)
// Remove o item da lista, salva e recarrega a tabela
// ===========================
function deleteItem(index) {
  if (!confirm('Deseja realmente excluir este funcionário?')) return
  itens.splice(index, 1)
  setItensBD()
  loadItens()
}

// ===========================
// insertItem(item, index)
// Cria e insere uma linha <tr> na tabela
// ===========================
function insertItem(item, index) {
  const tr = document.createElement('tr')

  const salarioFormatado = Number(item.salario).toLocaleString('pt-BR', {
    style: 'currency',
    currency: 'BRL'
  })

  tr.innerHTML = `
    <td>${item.nome}</td>
    <td>${item.funcao}</td>
    <td>${salarioFormatado}</td>
    <td class="acao">
      <button class="btn-edit" onclick="editItem(${index})" title="Editar">
        <i class='bx bx-edit'></i>
      </button>
    </td>
    <td class="acao">
      <button class="btn-delete" onclick="deleteItem(${index})" title="Excluir">
        <i class='bx bx-trash'></i>
      </button>
    </td>
  `

  tbody.appendChild(tr)
}

// ===========================
// loadItens()
// Busca do BD e renderiza todos os itens na tabela
// ===========================
function loadItens() {
  itens = getItensBD()
  tbody.innerHTML = ''

  if (itens.length === 0) {
    tbody.innerHTML = `
      <tr class="empty-row">
        <td colspan="5">
          <i class='bx bx-user-x'></i>
          Nenhum funcionário cadastrado ainda.
        </td>
      </tr>
    `
    return
  }

  itens.forEach((item, index) => insertItem(item, index))
}

// ===========================
// btnSalvar.onclick
// Valida, salva (insert ou update) e atualiza a UI
// ===========================
btnSalvar.onclick = (e) => {
  e.preventDefault()

  const nome    = sNome.value.trim()
  const funcao  = sFuncao.value.trim()
  const salario = sSalario.value.trim()

  // Validação
  if (!nome || !funcao || !salario) {
    alert('Por favor, preencha todos os campos.')
    return
  }

  if (id !== undefined) {
    // UPDATE
    itens[id] = { nome, funcao, salario }
  } else {
    // INSERT
    itens.push({ nome, funcao, salario })
  }

  setItensBD()
  closeModal()
  loadItens()
  id = undefined
}

// ===========================
// Inicialização
// ===========================
loadItens()
