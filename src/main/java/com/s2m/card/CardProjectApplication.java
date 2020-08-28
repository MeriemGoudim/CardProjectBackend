package com.s2m.card;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.s2m.card.services.FilesStorageService;

@SpringBootApplication
public class CardProjectApplication implements CommandLineRunner{
	
	@Resource
	  FilesStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(CardProjectApplication.class, args);
	}
	
	@Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
	

}
