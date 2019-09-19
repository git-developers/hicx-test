package util.factoryPattern.entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.util.StringUtils;

import com.hicx.model.FileStored;

import util.factoryPattern.interfaces.InterfaceFactory;

public class Doc extends BaseEntity implements InterfaceFactory {
	
	public Doc(FileStored fileStored) {
	    super(fileStored);
	}
	
	@Override
	public int getCountDots() {
		return StringUtils.countOccurrencesOf(string, ".");
	}
	
	@Override
	public int getCountWords() {
		return string.split("\\s+").length;
	}
	
	@Override
	public long getLinesCount() {
        long lineCount = 0;
        
        try {
        	Path path = Paths.get(fileStored.getPath());
			lineCount = Files.lines(path).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return lineCount;
	}

	@Override
	public boolean moveFile() {
        File file = new File(fileStored.getPath()); 
        file.renameTo(new File(PATH_TO_MOVE +  getFileName(fileStored.getPath())) );
        
        return true;
	}
	
	
}
