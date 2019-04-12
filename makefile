CC=javac

build: prog.java
	@$(CC) prog.java

DiskWasher.class: prog.java
	@$(CC) prog.java

Action.class: Action.java
	@$(CC) Action.java

ArgumentParser.class: ArgumentParser.java
	@$(CC) ArgumentParser.java

ActionTaker.class: ActionTaker.java
	@$(CC) ActionTaker.java

install: DiskWasher.class Action.class ArgumentParser.class ActionTaker.class
	@echo "Creating Directory"
	@mkdir -p /usr/share/DiskWasher
	@echo "Copying Files."
	@cp *.class /usr/share/DiskWasher
	@cp diskwasher /usr/bin/diskwasher
	@echo "Setting Permitions."
	@chmod 755 /usr/bin/diskwasher
	@chmod 755 -R /usr/share/DiskWasher
	@echo "Done."

clean: 
	@rm -f *.class
	@echo "Done."
