class ArgumentParser{
	Action action;
	String[] args;
	
	private void check(String arg){
		if(arg.equals("-r")){
			action.setRand();
		}
		else if(arg.startsWith("-z=")){
			try{
				action.setZeros(Integer.parseInt(arg.substring(3)));
			}
			catch(NumberFormatException e){
				action.setError();
			}
		}
		else if(action.getShread()){
			action.setShreadFiles(arg);
		}
		else if(arg.equals("-s")){
			action.setShread(this.args.length);
		}
		else{
			action.setError();
		}
	}

	private void parse(){
		for(String arg:args){
			this.check(arg);
			if(action.getError())
				break;
		}
	}

	ArgumentParser(String[] args, Action action){
		this.action = action;
		this.args = args;
		this.parse();
	}
}
