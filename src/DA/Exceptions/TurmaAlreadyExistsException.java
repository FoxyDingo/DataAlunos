package DA.Exceptions;

public class TurmaAlreadyExistsException extends Exception {

	public TurmaAlreadyExistsException(){
		super("Ja existe uma turma com este nome!");
	}
}
