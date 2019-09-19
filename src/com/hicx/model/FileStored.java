package com.hicx.model;

import util.prototypePattern.interfaces.PrototypeCapable;

public class FileStored implements PrototypeCapable {

	private long id;
	private String path;
	
	public FileStored() {

	}
	
	public FileStored(String path) {
		this.path = path;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
    @Override
    public FileStored clone() throws CloneNotSupportedException {
        System.out.println("Cloning FileStored object..");
        return (FileStored) super.clone();
    }
    
    @Override
    public String toString() {
        return "FileStored";
    }
}
