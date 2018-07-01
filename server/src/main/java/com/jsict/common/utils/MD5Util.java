package com.jsict.common.utils;

import java.security.MessageDigest;
import java.util.Date;

public class MD5Util {
	public final static String MD5(String pwd) {  
        //用于加密的字符  
		char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f','A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = pwd.getBytes();  
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) { 
                byte byte0 = md[i];  
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf]; 
            }  
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    }
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		System.out.println(MD5("haoxiang_smoke_001"+new Date().getTime()).toLowerCase());
		Long time=1512118730810L;
		System.out.println(MD5(MD5("dd675244ac2fcbd06bf03e1b4d2bd095")+time).toLowerCase());
		System.out.println(MD5(MD5("DD675244AC2FCBD06BF03E1B4D2BD095")+time));
	}
}
