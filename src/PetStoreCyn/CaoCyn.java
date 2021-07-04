package PetStoreCyn;

public class CaoCyn extends MamiferoCyn {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz latidos";
	}
	public CaoCyn(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Cachorro";
	}
}
