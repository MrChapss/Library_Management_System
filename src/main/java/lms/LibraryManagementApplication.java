package lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}
	

}

// 

/*
 * 1. ADD AKO ROLES PARA SA DATABASE MALAMAN KUNG SINO STUDENT OR ADMIN (02/05/26)
 * 	  UPDATE: DONE, PERO  NAKA 0 OR 1 YUNG RESULT SA DATABASE AND IT WAS RECOMMENDED TO BE THAT WAY
 * 
 * 2. MAG PROMPT NG ERROR MESSAGE SA CREATE ACCOUNT KAPAG 
 *    EXISITNG USERNAME OR EMPTY INPUTS INSTEAD NA SUCCESS MESSAGE (02/06/26)
 *    
 * 3. MAG PROMPT NG PROPER ERROR MESSAGE KAPAG ERROR YUNG INPUTS NILA SA POST/PUT/DELETE MAPPING (02/06/26)
 */