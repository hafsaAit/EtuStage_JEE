package net.javaguides.etustage.model;

public class entreprise {
	
<<<<<<< Updated upstream
	private int Id_Entrp;
	private String Nom ;
	private String Prenom;
	private String Société;
=======
	private static int Id_Entrp;
	private String NomEntreprise ;
>>>>>>> Stashed changes
	private String Password;
	private String GSM;
	private String Ville;
	private String St_image ;
	
	
	public entreprise(int id_Entrp, String nom, String prenom, String société, String password, String gSM,
			String ville, String st_image) {
		super();
		Id_Entrp = id_Entrp;
		Nom = nom;
		Prenom = prenom;
		Société = société;
		Password = password;
		GSM = gSM;
		Ville = ville;
		St_image = st_image;
	}


	public entreprise(String nom, String prenom, String société, String password, String gSM, String ville,
			String st_image) {
		super();
		Nom = nom;
		Prenom = prenom;
		Société = société;
		Password = password;
		GSM = gSM;
		Ville = ville;
		St_image = st_image;
	}


	public static int getId_Entrp() {
		try {
			return Id_Entrp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Id_Entrp;
	}


	public void setId_Entrp(int id_Entrp) {
		Id_Entrp = id_Entrp;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrenom() {
		return Prenom;
	}


	public void setPrenom(String prenom) {
		Prenom = prenom;
	}


	public String getSociété() {
		return Société;
	}


	public void setSociété(String société) {
		Société = société;
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
