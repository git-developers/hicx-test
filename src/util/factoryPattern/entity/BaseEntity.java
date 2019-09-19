package util.factoryPattern.entity;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.hicx.model.FileStored;


public class BaseEntity {

	protected FileStored fileStored;
	protected String string;
	
	public BaseEntity(FileStored fileStored) {
		this.fileStored = fileStored;
		this.string = readLineByLine(fileStored);
	}
    
	protected String readLineByLine(FileStored fileStored)
	{
	    StringBuilder contentBuilder = new StringBuilder();
	    
	    try (Stream<String> stream = Files.lines( Paths.get(fileStored.getPath()), StandardCharsets.UTF_8))
	    {
	        stream.forEach(s -> contentBuilder.append(s));
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    } finally {
	    	System.out.println("finally");
	    }
	    
	    return contentBuilder.toString();
	}
	
	protected String getFileName(String filePath)
	{
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}
	

}
