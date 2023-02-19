package net.javaguides.etustage.model;

public class favouris {
	private int id_fav;
	private int Id_AnnEntrp;
	private int Id_AnnStag;
	private int Id_Stag;
	private int Id_Entrp;
	
	
	public favouris(int id_fav, int id_AnnEntrp, int id_AnnStag, int id_Stag, int id_Entrp) {
		super();
		this.id_fav = id_fav;
		Id_AnnEntrp = id_AnnEntrp;
		Id_AnnStag = id_AnnStag;
		Id_Stag = id_Stag;
		Id_Entrp = id_Entrp;
	}


	public favouris(int id_AnnEntrp, int id_AnnStag, int id_Stag, int id_Entrp) {
		super();
		Id_AnnEntrp = id_AnnEntrp;
		Id_AnnStag = id_AnnStag;
		Id_Stag = id_Stag;
		Id_Entrp = id_Entrp;
	}


	public int getId_fav() {
		return id_fav;
	}


	public void setId_fav(int id_fav) {
		this.id_fav = id_fav;
	}


	public int getId_AnnEntrp() {
		return Id_AnnEntrp;
	}


	public void setId_AnnEntrp(int id_AnnEntrp) {
		Id_AnnEntrp = id_AnnEntrp;
	}


	public int getId_AnnStag() {
		return Id_AnnStag;
	}


	public void setId_AnnStag(int id_AnnStag) {
		Id_AnnStag = id_AnnStag;
	}


	public int getId_Stag() {
		return Id_Stag;
	}


	public void setId_Stag(int id_Stag) {
		Id_Stag = id_Stag;
	}


	public int getId_Entrp() {
		return Id_Entrp;
	}


	public void setId_Entrp(int id_Entrp) {
		Id_Entrp = id_Entrp;
	}
	
	
	

}
