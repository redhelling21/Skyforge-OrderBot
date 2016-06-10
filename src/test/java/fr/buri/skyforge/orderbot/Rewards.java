package fr.buri.skyforge.orderbot;

public enum Rewards {
	AMMO("2097702377.png"),
	SUPPLIES("2097702364.png"),
	GIFTS("2097703072.png"),
	SECRET_KNOWLEDGE("2097886270.png"),
	FOLLOWERS("2097812012.png"),
	VICTOR_MEDAL("2097842866.png"),
	FAITH("2097812391.png"),
	FIGHTER_AMULET("2097712772.png"),
	ACOLYTE_MEDAILLON("2097712784.png"),
	MESSENGER_NECKLACE("2097712760.png");
	
	private String url;
	Rewards(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
}
