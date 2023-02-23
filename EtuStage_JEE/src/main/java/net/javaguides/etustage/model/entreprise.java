package net.javaguides.etustage.model;

public class entreprise {
	

	private static int Id_Entrp;
	private String NomEntreprise ;
	private String Password;
	private String GSM;
	private String Ville;
	private String St_image ;
	
	
	public entreprise(int id_Entrp, String nomEntreprise, String password, String gSM, String ville, String st_image) {
		super();
		Id_Entrp = id_Entrp;
		NomEntreprise = nomEntreprise;
		Password = password;
		GSM = gSM;
		Ville = ville;
		St_image = st_image;
	}


	public entreprise(String nomEntreprise, String password, String gSM, String ville, String st_image) {
		super();
		NomEntreprise = nomEntreprise;
		Password = password;
		GSM = gSM;
		Ville = ville;
		St_image = st_image;
	}


	public static int getId_Entrp() {
		return Id_Entrp;
	}


	public void setId_Entrp(int id_Entrp) {
		Id_Entrp = id_Entrp;
	}


	public String getNomEntreprise() {
		return NomEntreprise;
	}


	public void setNomEntreprise(String nomEntreprise) {
		NomEntreprise = nomEntreprise;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getGSM() {
		return GSM;
	}


	public void setGSM(String gSM) {
		GSM = gSM;
	}


	public String getVille() {
		return Ville;
	}


	public void setVille(String ville) {
		Ville = ville;
	}


	public String getSt_image() {
		return St_image;
	}


	public void setSt_image(String st_image) {
		St_image = st_image;
	}
	
	
	
	
	
	
}