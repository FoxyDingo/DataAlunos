package DA;

import DA.Exceptions.AlunoAlreadyExistsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Turma implements Serializable {
	private TreeMap<String, Aluno> alunos = new TreeMap<String, Aluno>();
	private String nome;

	public Turma(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return nome;
	}
	public void adicionaAluno(Aluno aluno) throws AlunoAlreadyExistsException{
		if(alunos.containsKey(aluno.getNome())){
			throw new AlunoAlreadyExistsException();
		}
		alunos.put(aluno.getNome(), aluno);
	}

	public void removeAluno(String aluno){
		alunos.remove(aluno);
	}

	public Aluno[] getAlunos(){
		Aluno[] alunosArr = new Aluno[alunos.size()];
		int i = 0;
		for(Aluno aluno : alunos.values()){
			alunosArr[i++] = aluno;
			
		}
		return alunosArr;
	}
	
	public Aluno getAluno(String nome){
		if(alunos.containsKey(nome)){
			return alunos.get(nome);
		} else{
			//TODO :
			//WE ASSUME THIS WILL NEVER HAPPEN BECAUSE OF THE CONTROLLERGUI
			//throw new AlunoDoesntExistException();
			return null;
		}
	}
}
