/**
 * 
 */
function  confirmarExclusaoInstrutor(matricula) {
	if(confirm("Deseja mesmo excluir o instrutor?")) {
		  window.location = "excluirInstrutor?matricula=" + matricula;
	}
}

function  confirmarExclusaoAluno(cpf) {
	if(confirm("Deseja mesmo excluir o aluno?")) {
		  window.location = "excluirAluno?cpf=" + cpf;
	}
}