package DA;

import java.io.Serializable;
import java.util.GregorianCalendar;


public class Aluno implements Serializable {
	private String nome;
	private GregorianCalendar dateBirth;
	private String problematica;
	private String nrAluno;
	private String dt;
	private String[] documentsNames = new String[3];
	private String[] documentsFilenames = new String[3];
	private String imageFilename;


	public Aluno(String nome, GregorianCalendar dateBirth, String problematica,
					String nrAluno, String dt, String document1, String document2, String document3, String imageFilename){
		this.nome = nome;
		this.dateBirth = dateBirth;
		this.problematica = problematica;
		this.nrAluno = nrAluno;
		documentsFilenames[0] = document1;
		documentsFilenames[1] = document2;
		documentsFilenames[2] = document3;
		this.imageFilename = imageFilename;
	}
	
	public Aluno(String nome, GregorianCalendar dateBirth, String problematica,
					String nrAluno, String dt){
		this.nome = nome;
		this.dateBirth = dateBirth;
		this.problematica = problematica;
		this.nrAluno = nrAluno;
		this.dt = dt;
	}

	
	
	public String getNome(){
		return nome;
	}

	public GregorianCalendar getDateBirth() {
		return dateBirth;
	}
	
	public String getDateBirthString() {
		String s1 = Integer.toString(dateBirth.get(GregorianCalendar.DAY_OF_MONTH));
		String s2 = Integer.toString(dateBirth.get(GregorianCalendar.MONTH)+1);
		String s3 = Integer.toString(dateBirth.get(GregorianCalendar.YEAR));
		return s1 + "-"+ s2 + "-" + s3;
	}

	public String getProblematica() {
		return problematica;
	}

	public String getNrAluno() {
		return nrAluno;
	}

	public String getDt() {
		return dt;
	}

	public String[] getDocumentsFilenames() {
		return documentsFilenames;
	}
	
		
	public String getDocumentFilename(int nr){
		return documentsFilenames[nr-1];
	}
	
	public String[] getDocumentsNames() {
		return documentsNames;
	}
	
	public String getDocumentName(int nr){
		return documentsNames[nr-1];
	}
	
	public void setDocumentName(int nr, String name){
		documentsNames[nr-1] = name;
	}
	
	public void setDocumentFilename(int nr, String filename){
		documentsFilenames[nr-1] = filename;
	}
	
	
}
