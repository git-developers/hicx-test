package com.hicx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hicx.model.FileStored;

import util.factoryPattern.FileFactory;
import util.factoryPattern.entity.Doc;
import util.prototypePattern.PrototypeFactory;
import util.prototypePattern.PrototypeFactory.ModelType;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("main-home", "fileStored", new FileStored());
    }
	
	@GetMapping(value = "/sh-call")
	public ModelAndView shCall(@RequestParam(value = "path", required = true) String filePath) {
		
    	//UserFactory factory = new UserFactory(new Pdf(fileStored));
    	//UserFactory factory = new UserFactory(new Ppt(fileStored));
    	FileFactory factory = new FileFactory(new Doc(new FileStored(filePath)));
    	int countDots = factory.getCountDots();
    	int countWords = factory.getCountWords();
    	long linesCount = factory.getLinesCount();
    	factory.moveFile();
    	
    	try {
	        String moviePrototype  = PrototypeFactory.getInstance(ModelType.DOC).toString();
	        System.out.println(moviePrototype);
		} catch (CloneNotSupportedException e) {
	        e.printStackTrace();
	    }
		
        String message = "PATH:: " + filePath + " --> countDots::" + countDots + "-- countWords::" + countWords + "-- lineCount::" + linesCount + "\n";
		return new ModelAndView("sh-call", "message", message);

    }
	
	@RequestMapping(value = "/main-submit", method = RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("fileStored") FileStored fileStored, BindingResult result, ModelMap model) {
		
        if (result.hasErrors()) {
            return "error";
        }
        
        model.addAttribute("id", fileStored.getId());
        model.addAttribute("name", fileStored.getPath());
        
    	//UserFactory factory = new UserFactory(new Pdf(fileStored));
    	//UserFactory factory = new UserFactory(new Ppt(fileStored));
    	FileFactory factory = new FileFactory(new Doc(fileStored));
    	int countDots = factory.getCountDots();
    	int countWords = factory.getCountWords();
    	long linesCount = factory.getLinesCount();
    	factory.moveFile();
    	
    	try {
	        String moviePrototype  = PrototypeFactory.getInstance(ModelType.DOC).toString();
	        System.out.println(moviePrototype);
		} catch (CloneNotSupportedException e) {
	        e.printStackTrace();
	    }
        
        
        System.out.print("PATH:: " + fileStored.getPath() + " --> countDots::" + countDots + "-- countWords::" + countWords + "-- linesCount::" + linesCount + "\n" );
        
        return "main-home";
    }

}
