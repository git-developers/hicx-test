package com.hicx.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hicx.model.FileStored;


import java.nio.charset.StandardCharsets;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("main-home", "fileStored", new FileStored());
    }
	
	@GetMapping(value = "/sh-call")
	public ModelAndView shCall(@RequestParam(value = "path", required = true) String filePath) {
		
        String string = readLineByLine(filePath);
        
        int countDots = StringUtils.countOccurrencesOf(string, ".");
        
        int countWords = string.split("\\s+").length;
        
        long lineCount = 0;
        try {
        	Path path = Paths.get(filePath);
			lineCount = Files.lines(path).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        //MOVE
        File file = new File(filePath); 
        file.renameTo(new File("/home/pollo/files/.processed/" +  getFileName(filePath)) );
        
		
        String message = "PATH:: " + filePath + " --> countDots::" + countDots + "-- countWords::" + countWords + "-- lineCount::" + lineCount + "\n";
		return new ModelAndView("sh-call", "message", message);
    }
	
	@RequestMapping(value = "/main-submit", method = RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("fileStored") FileStored fileStored, BindingResult result, ModelMap model) {
		
        if (result.hasErrors()) {
            return "error";
        }
        
        //model.addAttribute("id", file.getId());
        model.addAttribute("name", fileStored.getPath());
        
        String string = readLineByLine(fileStored.getPath());
        
        int countDots = StringUtils.countOccurrencesOf(string, ".");
        
        int countWords = string.split("\\s+").length;
        
        
        long lineCount = 0;
        try {
        	Path path = Paths.get(fileStored.getPath());
			lineCount = Files.lines(path).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.print("PATH:: " + fileStored.getPath() + " --> countDots::" + countDots + "-- countWords::" + countWords + "-- lineCount::" + lineCount + "\n" );
        

       
        //MOVE
        File file = new File(fileStored.getPath()); 
        file.renameTo(new File("/home/pollo/files/.processed/" +  getFileName(fileStored.getPath())) );
       
        
        return "main-home";
    }
	
	private static String readLineByLine(String filePath)
	{
	    StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
	    {
	        stream.forEach(s -> contentBuilder.append(s));
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return contentBuilder.toString();
	}
	
	private String getFileName(String filePath)
	{
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}
	
}
