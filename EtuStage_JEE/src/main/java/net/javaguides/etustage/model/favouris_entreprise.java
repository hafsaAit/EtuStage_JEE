package net.javaguides.etustage.model;

public class favouris_entreprise {
	
	private int Id_fav;
	private int Id_Entrp;
	private int Id_AnnStag ;
	
	
	public favouris_entreprise(int id_fav, int id_Entrp, int id_AnnStag) {
		super();
		Id_fav = id_fav;
		Id_Entrp = id_Entrp;
		Id_AnnStag = id_AnnStag;
	}


	public favouris_entreprise(int id_Entrp, int id_AnnStag) {
		super();
		Id_Entrp = id_Entrp;
		Id_AnnStag = id_AnnStag;
	}


	public int getId_fav() {
		return Id_fav;
	}


	public void setId_fav(int id_fav) {
		Id_fav = id_fav;
	}


	public int getId_Entrp() {
		return Id_Entrp;
	}


	public void setId_Entrp(int id_Entrp) {
		Id_Entrp = id_Entrp;
	}


	public int getId_AnnStag() {
		return Id_AnnStag;
	}


	public void setId_AnnStag(int id_AnnStag) {
		Id_AnnStag = id_AnnStag;
	}
	
	

}
