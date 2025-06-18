package model;

import java.util.ArrayList;
import java.util.List;

public class ShiireArrayBean {
	private List<ShiireBean> shiireList = new ArrayList<>();
	
	public ShiireArrayBean() {}
	public ShiireArrayBean(List<ShiireBean> shiireList) {
		this.shiireList = shiireList;
	}
		public List<ShiireBean> getShohinList(){
			return this.shiireList;
		}
	}
