package org.zw.singleton.jeeframework.common.generatedcode;

public class ConfigCode {
	public static void main(String[] args) {
		boolean b = TemplateJava.get("gen", "singleton_zw", "代码生成","gen_code",null);
		if(b){
		System.out.println("生成成功");
		}else{
			System.out.println("表不存在");
		}

	}

}
