package fr.buri.skyforge.orderbot;

public enum Resources {
	AMMO("2097702377.png"),
	SUPPLIES("2097702364.png"),
	CREDITS("2097656995.png"),
	FIGHTER_AMULET("2097712772.png"),
	ACOLYTE_MEDAILLON("2097712784.png"),
	MESSENGER_NECKLACE("2097712760.png"),
	GIFTS("2097703072.png");
	
	
	private String url;
	Resources(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
}
