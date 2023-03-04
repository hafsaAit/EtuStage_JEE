package net.javaguides.etustage.model;

public class stagaire {
	private static int Id_Stag;
	private String Nom;
	private String Prenom;
	private String Password;
	private String Email;
	private String GSM;
	private String St_image;

	public stagaire() {

	}

	public stagaire(int id_Stag, String nom, String prenom, String password, String email, String gSM,
			String st_image) {
		super();
		Id_Stag = id_Stag;
		Nom = nom;
		Prenom = prenom;
		Password = password;
		Email = email;
		GSM = gSM;

		St_image = st_image;
	}

	public stagaire(String nom, String prenom, String password, String email, String gSM, String st_image) {
		super();
		Nom = nom;
		Prenom = prenom;
		Password = password;
		Email = email;
		GSM = gSM;
		St_image = st_image;
	}

	public static int getId_Stag() {
		try {
			return Id_Stag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Id_Stag;
	}

	public void setId_Stag(int id_Stag) {
		Id_Stag = id_Stag;
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGSM() {
		return GSM;
	}

	public void setGSM(String gSM) {
		GSM = gSM;
	}

	public String getSt_image() {
		return St_image;
	}

	public void setSt_image(String st_image) {
		St_image = st_image;
	}

}
