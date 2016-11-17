package DA;

//import DA.GUI.Primeira;
import DA.Exceptions.AlunoAlreadyExistsException;
import DA.Exceptions.TurmaAlreadyExistsException;

import javax.swing.*;

import java.io.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
/** *******************************************************************
 * MAIN IS ONLY USED WHEN NO GUI IS PRESENT OR FOR TESTING PURPOSES.
 * WITH GUI THE GUI ITSELF MAKES THE CALLS TO THE DATAALUNOS FUNCTIONS.
 * **********************************************************************/
public class Main {
	public static void main(String [ ] args){

		/* DataAlunos da = new DataAlunos("Valter");

		//SERIALIZATION
		try
		{
			FileOutputStream fileOut =
					new FileOutputStream("dataAlunos.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(da);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in dataAlunos.ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}

		//DESERIALIZATION
		DataAlunos d = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("dataAlunos.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			d = (DataAlunos) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("DataAlunos class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized DataAlunos " + d.getUtilizador() + "...");
	*/

		/*String dirname = "./tmp";
		File d = new File(dirname);
		// Create directory now.
		d.mkdirs();*/

		/*DataAlunos da = new DataAlunos("Jorge");


		JFrame frame = new JFrame("WelcomeForm");
		WelcomeForm wf = new WelcomeForm();
		frame.setContentPane(wf.field);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		wf.textArea1.setText("Bem-vindo " + da.getUtilizador());
		wf.editorPane1.setText("Bem-vindo " + da.getUtilizador());*/






		/*try{
			da.adicionaTurma("7 A");
			da.adicionaAluno("7 A", "Jorge", 25);
			da.adicionaAluno("7 A", "Carlos", 14);
			da.saveTurmas();
			try
			{
				FileOutputStream fileOut =
						new FileOutputStream("./tmp/dataAlunos.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(da);
				out.close();
				fileOut.close();
				System.out.println("Serialized data is saved in dataAlunos.ser");
			}catch(IOException i)
			{
				i.printStackTrace();
			}
		} catch (TurmaAlreadyExistsException e){
			System.out.println(e.getMessage());
		} catch (AlunoAlreadyExistsException e){
			System.out.println(e.getMessage());
		}*/

		/*try{
			//DESERIALIZATION
			da = null;
			try
			{
				FileInputStream fileIn = new FileInputStream("./tmp/dataAlunos.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				da = (DataAlunos) in.readObject();
				da.init();
				in.close();
				fileIn.close();
				System.out.println(da.getUtilizador());

				Turma t = da.getTurma("7 A");
				System.out.println(t.getNome());
			}catch(IOException i)
			{
				i.printStackTrace();
				return;
			}catch(ClassNotFoundException c)
			{
				System.out.println("DataAlunos class not found");
				c.printStackTrace();
				return;
			}

		} catch (Exception e){
			System.out.println(e.getMessage());
		}
*/

		// ------------- ACTUAL PROGRAM -------------
		/*JFrame frame = new JFrame("DataAlunos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
            //DESERIALIZATION
		DataAlunos d = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("./tmp/dataAlunos.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			d = (DataAlunos) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i)
		{
			//File Does Not Exist
			//We Have To Create It
			Primeira prim = new Primeira();
      frame.setContentPane(prim.PanelPrimeira);
      frame.pack();
      
		}catch(ClassNotFoundException c)
		{
			System.out.println("DataAlunos class not found");
			c.printStackTrace();
			return;
		}
            */
			    
           
	}
}
