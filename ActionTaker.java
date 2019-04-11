class ActionTaker{
	private Action action;

	private void printHelp(){
		System.out.println("\nUsage: USB-Guard [OPTION]... [FILE]...");
		System.out.println("Makes it harder for any forensics expert to retrive data from the disk.\n");
		System.out.println("  -r\t\tWrites random data on memory after all parses are over.");
		System.out.println("  -s\t\tEnables the shreading mode (used to delete files).");
		System.out.println("  -z=<number>\tUsed to set the number of parses of writing null on disk.");
	}
	
	private void writeZeros(){
		System.out.println("Writing Null");
	}

	private void writeRand(){
		System.out.println("Writing Rand");
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
		else{
			this.printSelections();
			if(this.action.getShread()){
				//shread 
			}
			else{
				for(int i=0;i < this.action.getZeros();++i)
					this.writeZeros();
				if(this.action.getRand())
					this.writeRand();
			}
		}
	}
}
