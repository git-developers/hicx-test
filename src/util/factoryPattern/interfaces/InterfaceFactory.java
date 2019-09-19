package util.factoryPattern.interfaces;


public interface InterfaceFactory {
	
	public static final String PATH_TO_MOVE = "/home/pollo/files/.processed/";
	
	int getCountDots();
	int getCountWords();
	long getLinesCount();
	
	boolean moveFile();
}
