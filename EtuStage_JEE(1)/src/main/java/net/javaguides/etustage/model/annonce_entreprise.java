package net.javaguides.etustage.model;

public class annonce_entreprise {
	
	private int Id_AnnEntrp ;
	private String Titre ;
	private String Description_Annc;
	private String Domaine;
	private String Duree;
	private String Type_Stag;
	private int Id_Entrp;
	private String St_image;
	
	
	public annonce_entreprise(int id_AnnEntrp, String titre,String domaine, String description_Annc,  String duree,
			String type_Stag, int id_Entrp) {
		super();
		Id_AnnEntrp = id_AnnEntrp;
		Titre = titre;
		Description_Annc = description_Annc;
		Domaine=domaine;
		Duree = duree;
		Type_Stag = type_Stag;
		Id_Entrp = id_Entrp;
	}

	
	public annonce_entreprise(int id_AnnEntrp, String titre,String domaine, String description_Annc,  String duree,
			String type_Stag, int id_Entrp,String image) {
		super();
		Id_AnnEntrp = id_AnnEntrp;
		Titre = titre;
		Description_Annc = description_Annc;
		Domaine=domaine;
		Duree = duree;
		Type_Stag = type_Stag;
		Id_Entrp = id_Entrp;
		St_image=image;
	}

	public annonce_entreprise(String titre,String domaine, String description_Annc,  String duree, String type_Stag,
			int id_Entrp) {
		super();
		Titre = titre;
		Domaine=domaine;
		Description_Annc = description_Annc;
	
		Duree = duree;
		Type_Stag = type_Stag;
		Id_Entrp = id_Entrp;
	}


	public int getId_AnnEntrp() {
		return Id_AnnEntrp;
	}


	public void setId_AnnEntrp(int id_AnnEntrp) {
		Id_AnnEntrp = id_AnnEntrp;
	}


	public String getTitre() {
		return Titre;
	}


	public void setTitre(String titre) {
		Titre = titre;
	}


	public String getDescription_Annc() {
		return Description_Annc;
	}


	public void setDescription_Annc(String description_Annc) {
		Description_Annc = description_Annc;
	}


	

	public String getDuree() {
		return Duree;
	}


	public void setDuree(String duree) {
		Duree = duree;
	}


	public String getType_Stag() {
		return Type_Stag;
	}


	public void setType_Stag(String type_Stag) {
		Type_Stag = type_Stag;
	}


	public int getId_Entrp() {
		return Id_Entrp;
	}


	public void setId_Entrp(int id_Entrp) {
		Id_Entrp = id_Entrp;
	}


	public String getDomaine() {
		return Domaine;
	}


	public void setDomaine(String domaine) {
		Domaine = domaine;
	}


	public String getSt_image() {
		return St_image;
	}


	public void setSt_image(String st_image) {
		St_image = st_image;
	}
	
	
	public String getFirst50Chars() {
		return this.getDescription_Annc().substring(0,150);
	}

}
