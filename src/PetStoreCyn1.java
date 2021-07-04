package PetStoreCyn;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import PetStoreCyn.CaoCyn;
import PetStoreCyn.GatoCyn;
import PetStoreCyn.MamiferoCyn;

public class PetStoreCyn1 {

	private ArrayList<MamiferoCyn> mamiferos;


	public PetStoreCyn1( ) {
		this.mamiferos= new ArrayList<MamiferoCyn>();
	}

	public void adicionaAnimal(MamiferoCyn mani) {
		this.mamiferos.add(mani);
	}

	public void listarAnimais() {
		for(MamiferoCyn mani:mamiferos) {
			System.out.println(mani.toString());
		}
		System.out.println("Total = " + this.mamiferos.size() + " animais listados com sucesso!\n");
	}
	
	public void excluirAnimal(MamiferoCyn mani) {
		if (this.mamiferos.contains(mani)) {
			this.mamiferos.remove(mani);
			System.out.println("[Animal " + mani.toString() + "excluido com sucesso!]\n");
		}
		else
			System.out.println("Animal inexistente!\n");
	}

	public void excluirAnimais() {
		mamiferos.clear();
		System.out.println("Animais excluidos com sucesso!\n");
	}
	public void gravarAnimais()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\animais.dat"));
			for(MamiferoCyn mani:mamiferos) {
				outputStream.writeObject(mani);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void recuperarAnimais() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\animais.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof GatoCyn)  
					this.mamiferos.add((GatoCyn)obj);
				else if (obj instanceof CaoCyn)  
					this.mamiferos.add((CaoCyn)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Animais recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		PetStoreCyn1 pet  = new PetStoreCyn1();
	
		GatoCyn jivago    = new GatoCyn("Jivago",    2, "Joana");
		GatoCyn otto = new GatoCyn("Otto", 5, "Joana");
		CaoCyn  kika      = new CaoCyn ("Kika",  2, "João");
		CaoCyn  peludo     = new CaoCyn ("Peludo", 5, "João");
		pet.adicionaAnimal(jivago);
		pet.adicionaAnimal(otto);
		pet.adicionaAnimal(kika);
		pet.adicionaAnimal(peludo);
		pet.listarAnimais();
		pet.gravarAnimais();
		pet.excluirAnimal(otto);
		pet.listarAnimais();
		pet.excluirAnimais();
		pet.listarAnimais();
		pet.recuperarAnimais();
		pet.listarAnimais();
	}

}
