package DA.Exceptions;

public class AlunoAlreadyExistsException extends Exception {

	public AlunoAlreadyExistsException(){
		super("Ja existe um aluno com este nome!");
	}
}
