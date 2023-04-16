package entities;

public class Proprietà {
	
	private String pagine;
	private String volume;
	
	
	public Proprietà(String pagine, String volume) {
		this.pagine=pagine;
		this.volume=volume;
	}
	
	
	public String getPagine() {
		return pagine;
	}
	
	public void setPagine(String pagine) {
		this.pagine = pagine;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}

}
