package main;

import java.io.File;

import freemarker.template.*;

public class Modle {
	File Templet = new File("etc/Templet.xml") ;
	
	private Configuration configuration = null ;
	
	public Modle() {
		configuration = new Configuration() ;
		configuration.setDefaultEncoding("utf-8");
	}
	
	public void CreateDoc () {
		
		
		
	}
	
	public void getData() {
		
	}
	
}
