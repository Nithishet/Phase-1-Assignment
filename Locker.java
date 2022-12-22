package com.cisco.phase1project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Locker {
	static String DIRECTORY;
	File Foldername;
	Scanner sc=new Scanner(System.in);
	
	 public Locker() {
		DIRECTORY=System.getProperty("user.dir");
		Foldername=new File(DIRECTORY+"/FILES");
		if(!Foldername.exists())
			Foldername.mkdirs();
			System.out.println("DIRECTORY :"+ Foldername.getAbsolutePath());
		
	}
	private static final String WELCOME_PROMPT=
			
			"\n=================LOCKERS===============\n"+
	        "\n**************NITISH SHET************\n";
	
	private static final String MAIN_MENU_PROMPT=
			"\nMAIN MENU -> Select any of the following:\n"+
			"1 - List of files in the directory\n"+
			"2 - Add,Delete and search the file\n"+
			"3 - Exit the program\n";
	
	private static final String SECONDARY_MENU_PROMPT =
			"\nSelect any of the following\n"+
	        "a - Add a file\n"+
			"b - Delete a file\n"+
	        "c - Search a file\n"+
			"d - Go back to menu";
	
	void showPrimaryMenu() {
		System.out.println(MAIN_MENU_PROMPT);
		try {
			int option=sc.nextInt();
			switch(option) {
			case 1:{
				showFiles();
				showPrimaryMenu();
			}
			case 2:{
				showSecondarymenu();
			}
			case 3:{
				System.out.println("Thank You");
				System.exit(0);
			}
			default: showPrimaryMenu();
			       
			}
			
		} catch (Exception e) {
			System.out.println("please select the correct option");
			showPrimaryMenu();
		}
	}
	
	ArrayList<String> data = new ArrayList<String>();
	
    void showSecondarymenu() {
    	System.out.println(SECONDARY_MENU_PROMPT );
    	
    	char sch = 'Y';
    	try {
    		char[] input=sc.nextLine().toLowerCase().trim().toCharArray();
    		char option=sc.next().charAt(0);
    		
    		switch(option) {
    		case 'a': while(sch=='Y') {
    			System.out.println("Please enter the file name to ADD a file");
    			String filename=sc.next().trim().toLowerCase();
    			addFile(filename);
    			System.out.println();
    			System.out.println("Please enter Y to add more files");
    			System.out.println("Please enter N to exit");
				   sch=sc.next().charAt(0);	   
			}
    			showSecondarymenu();
			       break;
    		case 'b':{
    			System.out.println("Please enter the file name to DELETE a file");
    			String filename =sc.next().trim();
    			DeleteFile(filename);
    		}
    			showPrimaryMenu();
    			break;
    		case 'c':{
    			System.out.println("Please enter the file name to SEARCH a file");
    			String filename=sc.next().trim();
    			SearchFile(filename);
    			System.out.println("Please enter Y to search more files");
    			System.out.println("Please enter N to exit");
				   sch=sc.next().charAt(0);
    		}
	    		showSecondarymenu();
			       break;
    		case 'd':{
    			System.out.println("Go back to the main menu");
    			String filename=sc.nextLine();
    		}
    		default :showPrimaryMenu();
    		}
		} catch (Exception e) {
			System.out.println("please select the correct option");
			
		}
    }
    void showFiles() {
    		Collections.sort(data);
    		for(String str:data) {
    			System.out.println(str);
    		}
    	}
    
    void addFile(String filename) throws IOException {
    	for(String file:data) {
    		if(filename.equalsIgnoreCase(file)) {
    			System.out.println("File "+filename+" already exists at "+Foldername);;
    			return;
    		}
     	}
    	data.add(filename);
    	System.out.println("File "+filename+" added to "+Foldername);
    	
    }
    void DeleteFile(String filename) {
    	try {
        	for(String file:data) {
        		if(filename.equals(file)) {
        			data.remove(filename);
        			System.out.println("File "+filename+" deleted from "+Foldername);
        			return;
        		}
        	}
        	System.out.println("Delete opertion is failed. FILE NOT FOUND(FNF)");
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }
    void SearchFile(String filename) {
    	if(data.contains(filename)) {
    		System.out.println("FOUND : File "+filename+" exists at "+Foldername);
    		return;
    	} else {
    		System.out.println("FILE NOT FOUND");
    	}
	}  	     
    public static void main(String[] args) {
		System.out.println(WELCOME_PROMPT);
		Locker l=new Locker();
		l.showPrimaryMenu();
	}  
}
