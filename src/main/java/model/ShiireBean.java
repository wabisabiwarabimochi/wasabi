package model;

import java.io.Serializable;

public class ShiireBean implements Serializable{
	private String shiireid;
	private String shiiremei;
	private String shiireaddres;
	private String shiiretel;
	private int shihonkin;
	private int nouki;

	public ShiireBean() {}
	public ShiireBean(String shiireid,String shiiremei, String shiireaddres, String shiiretel,int shihonkin, int nouki) {
		this.shiireid = shiireid;
		this.shiiremei = shiiremei;
		this.shiireaddres = shiireaddres;
		this.shiiretel = shiiretel;
		this.shihonkin = shihonkin;
		this.nouki = nouki;
	}
	public String getShiireid() {return this.shiireid;}
	public String getShiiremei() {return this.shiiremei;}
	public String getShiireaddress() {return this.shiireaddres;}
	public String getShiiretel() {return this.shiiretel;}
	public int getShihonkin() {return this.shihonkin;}
	public int getNouki() {return this.nouki;}
}

