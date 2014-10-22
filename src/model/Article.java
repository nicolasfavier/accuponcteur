package model;

public class Article {
	
	private String titre;
	private String description;
	private String date;
	private String createur;
	
	public Article() {
		super();
		this.titre = "";
		this.description = "";
		this.date = "";
		this.createur = "";
	}
	
	public Article(String titre, String description, String date, String createur) {
		super();
		this.titre = titre;
		this.description = description;
		this.date = date;
		this.createur = createur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
