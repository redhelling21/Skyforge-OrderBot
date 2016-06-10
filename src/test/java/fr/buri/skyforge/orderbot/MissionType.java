package fr.buri.skyforge.orderbot;

public enum MissionType {
	ORDER_DEVELOPMENT("quest-cult set-common"),
	PANTHEON("quest-guild set-pro set-rare"),
	COMBAT("quest-cult set-rare"),
	INVASION("quest-rg"),
	GATHERING_RESOURCES("quest-cult set-uncommon"),
	SPECIAL("");
	
	private String classHTML;
	MissionType(String classHTML){
		this.classHTML = classHTML;
	}
	
	public String getClassHTML(){
		return this.classHTML;
	}
}
