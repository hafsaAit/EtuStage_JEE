package net.javaguides.etustage.model;

public class favouris_stagaire {
	
	private int Id_fav;
	private int Id_Stag;
	private int Id_AnnEntp;
	
	
	public favouris_stagaire(int id_fav, int id_Stag, int id_AnnEntp) {
		super();
		Id_fav = id_fav;
		Id_Stag = id_Stag;
		Id_AnnEntp = id_AnnEntp;
	}


	public favouris_stagaire(int id_Stag, int id_AnnEntp) {
		super();
		Id_Stag = id_Stag;
		Id_AnnEntp = id_AnnEntp;
	}


	public int getId_fav() {
		return Id_fav;
	}


	public void setId_fav(int id_fav) {
		Id_fav = id_fav;
	}


	public int getId_Stag() {
		return Id_Stag;
	}


	public void setId_Stag(int id_Stag) {
		Id_Stag = id_Stag;
	}


	public int getId_AnnEntp() {
		return Id_AnnEntp;
	}


	public void setId_AnnEntp(int id_AnnEntp) {
		Id_AnnEntp = id_AnnEntp;
	}
	
	
	
	

}
