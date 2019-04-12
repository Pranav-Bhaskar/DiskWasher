class DiskWasher{
	static public void main(String[] args){
		Action action = new Action();
		ArgumentParser argumentParser = new ArgumentParser(args, action);
		ActionTaker actiontaker = new ActionTaker(action);
	}
}
