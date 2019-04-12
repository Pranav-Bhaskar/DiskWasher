class Action{
	//Variables
	private boolean error;
	private int parsesZeros;
	private boolean parsesRand;
	private boolean shread;
	private int shreadFileNum;
	private String[] shreadFiles;

	//Setter Methords
	public void setError(){
		this.error = true;
	}

	public void setRand(){
		this.parsesRand = true;
	}

	public void setZeros(int parsesZeros){
		this.parsesZeros = parsesZeros;
	}

	public void setShread(int shreadFilesMax){
		this.shreadFiles = new String[shreadFilesMax];
		this.shread = true;
	}

	public void setShreadFiles(String shreadFile){
		this.shreadFiles[this.shreadFileNum++] = shreadFile;
	}

	//Getter Methords
	public boolean getError(){
		return this.error;
	}

	public boolean getRand(){
		return this.parsesRand;
	}

	public int getZeros(){
		return this.parsesZeros;
	}

	public boolean getShread(){
		return this.shread;
	}
	
	public int getShreadFileNum(){
		return this.shreadFileNum;
	}

	public String[] getShreadFiles(){
		return this.shreadFiles;
	}

	Action(){
		this.parsesZeros = 3;
		this.parsesRand = false;
		this.error = false;
		this.shread = false;
		this.shreadFileNum = 0;
	}
}
