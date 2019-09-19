package util.prototypePattern;

import com.hicx.model.FileStored;

import util.prototypePattern.interfaces.PrototypeCapable;

public class PrototypeFactory
{
    public static class ModelType
    {
        public static final String DOC = "DOC";
        public static final String PDF = "PDF";
        public static final String PPT = "PPT";
    }
    
    private static java.util.Map<String , PrototypeCapable> prototypes = new java.util.HashMap<String , PrototypeCapable>();
 
    static
    {
    	prototypes.put(ModelType.DOC, new FileStored());
    	prototypes.put(ModelType.PDF, new FileStored());
    	prototypes.put(ModelType.PPT, new FileStored());
    }
 
    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s)).clone();
    }
}
