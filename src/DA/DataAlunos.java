package DA;

import DA.Exceptions.AlunoAlreadyExistsException;
import DA.Exceptions.TurmaAlreadyExistsException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

/**
 * TO SAVE THIS CLASS FIRST CALL SaveTurmas() before serializing
 * This class represents all the information in the program.
 * For performance reasons it is possible to load Turmas as they are needed.
 * The fields currentTurmas, turmasFilename and DAStorage are used for this purpose.
 */
public class DataAlunos implements Serializable {
	private String savePath = "./tmp/";
	private TreeMap<String, String> turmasFilename = new TreeMap<String, String>();
	private transient TreeMap<String, Turma> currentTurmas = new TreeMap<String, Turma>();
	private String utilizador;
	private int lastFilename = 0;

	public DataAlunos(String utilizador){
		this.utilizador = utilizador;
	}

	public String getUtilizador(){
		return utilizador;
	}

	public String[] getTurmas(){
		String[] turmas = new String[turmasFilename.size()];
		int i = 0;
		//System.out.println(turmasFilename.size());
		for(String turmaNome : turmasFilename.keySet()){
			turmas[i++] = turmaNome;
			
		}
		
		return turmas;
	}

	public Aluno[] getAlunos(String turmaNome){
		Turma t = getTurma(turmaNome);
		return t.getAlunos();
	}
	
	public Aluno getAluno(String turmaNome, String nome){
		Turma t = getTurma(turmaNome);
		return t.getAluno(nome);
	}

	public void adicionaTurma(String turmaNome) throws TurmaAlreadyExistsException{
		if(turmasFilename.containsKey(turmaNome)){
			throw new TurmaAlreadyExistsException();
		}
		String filename = savePath + incLastFilename() + ".ser";
		turmasFilename.put(turmaNome, filename);
		Turma turma = new Turma(turmaNome);
		currentTurmas.put(turmaNome, turma);

	}

	public void removeTurma(String turmaNome){
		Path path = Paths.get(turmasFilename.get(turmaNome));
		try{
			Files.delete(path);
		} catch(NoSuchFileException e) {
			//We Just ignore this. If there is no file we dont need to erase it
		} catch(Exception e){
			e.printStackTrace();
		}

		turmasFilename.remove(turmaNome);
		currentTurmas.remove(turmaNome);

	}

	public void adicionaAluno(String turmaNome, String nome, String dob, String problematica, String nrAluno, String dt ) 
					throws AlunoAlreadyExistsException, ParseException{
		
			DateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
			Date       date = format.parse(dob);
			GregorianCalendar  dateBirth = new GregorianCalendar();
			
			
			dateBirth.setTime( date );
		

		Aluno a = new Aluno(nome, dateBirth, problematica, nrAluno, dt);
		Turma t = getTurma(turmaNome);
		t.adicionaAluno(a);
	}

	public void removeAluno(String turmaNome, String nome){
		Turma t = getTurma(turmaNome);
		t.removeAluno(nome);
	}
	
	public String[] getDocumentsNamesAluno(String turma, String nome){
		Aluno a = getAluno(turma, nome);
		return a.getDocumentsNames();
	}
	
	public String getDocumentFilenameAluno(String turma, String nome, int docNr){
		Aluno a = getAluno(turma, nome);
		return a.getDocumentFilename(docNr);
	}
	
	public void setDocumentFilenameAluno(String turma, String nome, int docNr, String filename){
		Aluno a = getAluno(turma, nome);
		a.setDocumentFilename(docNr, filename);
	}
	
	public void setDocumentNameAluno(String turma, String nome, int docNr, String name){
		Aluno a = getAluno(turma, nome);
		a.setDocumentName(docNr, name);
	}
	
	

	/**
	 * This method is used to initialize all transient fields.
	 * Call this after Deserializing this class
	 */
	public void init(){
		currentTurmas = new TreeMap<String, Turma>();
	}
	/**
	 * This method is used to save all Turmas that were used in this session. Call this before serializing this class
	 */
	public void saveTurmas(){
		//SERIALIZATION
		try
		{
			for(Map.Entry<String, Turma> entry : currentTurmas.entrySet()){
				String filename = turmasFilename.get(entry.getKey());
				FileOutputStream fileOut =
						new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(entry.getValue());
				out.close();
				fileOut.close();
				//TODO Debug Only
				//System.out.println("Serialized turma " + entry.getKey() + " is saved in " + filename);
			}

		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}

	/*** PRIVATE METHODS ****/

	private int incLastFilename(){
		return ++lastFilename;
	}

	private Turma getTurma(String nome) {
		Turma turma = null;
		if(currentTurmas.containsKey(nome)){
			turma = currentTurmas.get(nome);
		} else {
			//DESERIALIZATION
			try
			{
				FileInputStream fileIn = new FileInputStream(turmasFilename.get(nome));
				ObjectInputStream in = new ObjectInputStream(fileIn);
				turma = (Turma) in.readObject();
				currentTurmas.put(turma.getNome(), turma);
				in.close();
				fileIn.close();
				//TODO Debug Only
				//System.out.println("Deserialized Turma " + turma.getNome());
			}catch(IOException i)
			{
				System.out.println("ERROR");
				i.printStackTrace();
				return null;
			}catch(ClassNotFoundException c)
			{
				//System.out.println("Turma class not found");
				c.printStackTrace();
				return null;
			}

		}
		return turma;
	}

}
