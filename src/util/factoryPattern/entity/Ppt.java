package util.factoryPattern.entity;

import com.hicx.model.FileStored;

import util.factoryPattern.interfaces.InterfaceFactory;

public class Ppt extends BaseEntity implements InterfaceFactory {

	public Ppt(FileStored fileStored) {
	    super(fileStored);
	}

	@Override
	public int getCountDots() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCountWords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLinesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean moveFile() {
		// TODO Auto-generated method stub
		return false;
	}
}
