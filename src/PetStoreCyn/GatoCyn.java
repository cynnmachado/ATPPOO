package PetStoreCyn;

import PetStoreCyn.MamiferoCyn;

public class GatoCyn extends MamiferoCyn {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz Miados";
	}
	public GatoCyn(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Gato";
	}
}
