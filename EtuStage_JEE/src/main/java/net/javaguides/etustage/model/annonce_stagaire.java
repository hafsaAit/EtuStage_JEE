package net.javaguides.etustage.model;

/**
 * @author moude
 *
 */
public class annonce_stagaire {
	private int Id_AnnSatg;
	private String Titre_Stage;
	private String Domaine_Stage;
	private String Description;
	private String Type_stage;
	private String Duree;
	private int Id_Stag;
	private String userImage;

	public annonce_stagaire(int id_AnnSatg, String titre_Stage, String domaine_Stage, String description,
			String type_stage, String duree, int id_Stag, String userimage) {
		super();
		Id_AnnSatg = id_AnnSatg;
		Titre_Stage = titre_Stage;
		Domaine_Stage = domaine_Stage;
		Description = description;
		Type_stage = type_stage;
		Duree = duree;
		Id_Stag = id_Stag;
		userImage = userimage;
	}

	public annonce_stagaire(int id_AnnSatg, String titre_Stage, String domaine_Stage, String description,
			String type_stage, String duree, int id_Stag) {
		super();
		Id_AnnSatg = id_AnnSatg;
		Titre_Stage = titre_Stage;
		Domaine_Stage = domaine_Stage;
		Description = description;
		Type_stage = type_stage;
		Duree = duree;
		Id_Stag = id_Stag;
	}

	public annonce_stagaire(String titre_Stage, String domaine_Stage, String description, String type_stage,
			String duree, int id_Stag) {
		super();
		Titre_Stage = titre_Stage;
		Domaine_Stage = domaine_Stage;
		Description = description;
		Type_stage = type_stage;
		Duree = duree;
		Id_Stag = id_Stag;
	}

	public int getId_AnnSatg() {
		return Id_AnnSatg;
	}

	public void setId_AnnSatg(int id_AnnSatg) {
		Id_AnnSatg = id_AnnSatg;
	}

	public String getTitre_Stage() {
		return Titre_Stage;
	}

	public void setTitre_Stage(String titre_Stage) {
		Titre_Stage = titre_Stage;
	}

	public String getDomaine_Stage() {
		return Domaine_Stage;
	}

	public void setDomaine_Stage(String domaine_Stage) {
		Domaine_Stage = domaine_Stage;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getType_stage() {
		return Type_stage;
	}

	public void setType_stage(String type_stage) {
		Type_stage = type_stage;
	}

	public String getDuree() {
		return Duree;
	}

	public void setDuree(String duree) {
		Duree = duree;
	}

	public int getId_Stag() {
		return Id_Stag;
	}

	public void setId_Stag(int id_Stag) {
		Id_Stag = id_Stag;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

}
