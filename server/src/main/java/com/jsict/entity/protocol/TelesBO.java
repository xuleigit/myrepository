package com.jsict.entity.protocol;

import java.io.Serializable;
import com.jsict.common.utils.JsonUtil;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class TelesBO implements Serializable{

	private static final long serialVersionUID = -6711621503638234724L;

	private String tele;

	private String name;

	private String descrip;

	private Integer state;


	@Override
	public String toString() {
		return "TelesBO [tele=" + tele + ", name=" + name + ", descrip="
				+ descrip + ", state=" + state + "]";
	}
	public static void main(String[] args) {
		TelesBO[] tbo=new TelesBO[3];
		for(int i=0;i<2;i++){
			TelesBO bo = new TelesBO();
			bo.setTele("1369360160"+i);
			bo.setDescrip(i+"----"+i);
			bo.setState(1);
			bo.setName("zh"+i);
			tbo[i]=bo;
		}
		String json = JsonUtil.toJson(tbo);
		System.out.println(json);
	}
}
