import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class ActionTaker{
	private Action action;

	private void printHelp(){
		System.out.println("\nUsage: USB-Guard [OPTION]... [FILE]...");
		System.out.println("Makes it harder for any forensics expert to retrive data from the disk.\n");
		System.out.println("  -r\t\tWrites random data on memory after all parses are over.");
		System.out.println("  -s\t\tEnables the shreading mode (used to delete files).");
		System.out.println("  -z=<number>\tUsed to set the number of parses of writing null on disk.");
	}

	private void shread(){
		String[] fileNames = this.action.getShreadFiles();
		for(int i=0;i<this.action.getShreadFileNum();++i)
			this.processFile(fileNames[i], false);
	}

	private void washPart(){
		this.processFile(".diskwasher", true);	
	}

	private void processFile(String fileName, boolean getPartSize){
		System.out.println("File: " + fileName);
		for(int i=0;i < this.action.getZeros();++i)
			this.writeZeros(fileName, getPartSize);
		if(this.action.getRand())
			this.writeRand(fileName, getPartSize);
		
		File file = new File(fileName);
		if(file.delete())
			System.out.println("Deleted: " + fileName);
		else
			System.out.println("Could Not Delete: " + fileName);
	}

	private void updateProgressBar(double percentCompleted){
		System.out.print("\r\t[");
		for(int i=0;i<100;++i){
			if(percentCompleted > i)
				System.out.print("#");
			else
				System.out.print(" ");
		}
		System.out.printf("]\t(%.4f completed)", percentCompleted);
	}
	
	private void writeZeros(String fileName, boolean getPartSize){
		long size = 0;
		File file = new File(fileName);
		if(getPartSize){
			size = file.getUsableSpace();
		}
		else{
			size = file.length();
		}
		if(size == 0){
			System.out.println("File Size ZERO.");
		}
		FileOutputStream fileStream = null;
		try{
			fileStream = new FileOutputStream(file);
		}
		catch(IOException e){
			System.out.println(e);
			return;
		}
		System.out.print("\r\nWriting Null\n");
		byte nullChar = 0;
		double percentCompleted = 0;
		double deltaPercent = ((double)100.00/size);
		for(long writen=0;size>writen;++writen, percentCompleted+=deltaPercent){
			try{
				fileStream.write(nullChar);
			}
			catch(IOException e){
				System.out.println(e);
				break;
			}
			if(writen%4096 == 0)
				this.updateProgressBar(percentCompleted);
		}
		try{
			fileStream.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

	private void writeRand(String fileName, boolean getPartSize){
		System.out.println("\rWriting Rand");
	}

	private void printSelections(){
		System.out.println("Zeros : " + this.action.getZeros());
		System.out.println("Rand : " + this.action.getRand());
		System.out.println("Error : " + this.action.getError());
	}
	
	ActionTaker(Action action){
		this.action = action;
		if(this.action.getError()){
			this.printHelp();
		}
		else if(this.action.getShread()){
			this.printSelections();
			this.shread(); 
		}
		else{
			this.printSelections();
			this.washPart();
		}
	}
}
