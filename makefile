CC=javac
build: prog.java
	@$(CC) prog.java

install: DiskWasher.class
	@echo "Creating Directory"
	@mkdir -p /usr/share/DiskWasher
	@echo "Copying Files."
	@cp *.class /usr/bin/diskwiper
	@echo "#!/usr/bin/bash
	java /usr/bin/diskwiper.class" > /usr/bin/diskwiper
	@echo "Setting Permitions."
	@chmod 755 /usr/bin/diskwiper
	@chmod 755 -R /usr/share/DiskWiper
