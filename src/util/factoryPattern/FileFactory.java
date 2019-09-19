package util.factoryPattern;

import util.factoryPattern.interfaces.InterfaceFactory;


public class FileFactory {

    private final InterfaceFactory interfaceFactory;
    
    public FileFactory(InterfaceFactory interfaceFactory) {
        this.interfaceFactory = interfaceFactory;
    }
    
    public int getCountDots() {
        return interfaceFactory.getCountDots();
    }
    
    public int getCountWords() {
        return interfaceFactory.getCountWords();
    }
    
    public long getLinesCount() {
        return interfaceFactory.getLinesCount();
    }
    
    public boolean moveFile() {
        return interfaceFactory.moveFile();
    }
}
