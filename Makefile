COMP=javac
EXEC=java
CLASS=classes
DOC=docs
SOURCE=src
TEST=test
CPATH=-classpath $(CLASS)
CTPATH=-classpath $(TJAR)
SRCPATH=-sourcepath $(SOURCE)
CDOC=javadoc
CARCH=jar cvfm
PACK= Main

.PHONY : clean all

.SILENT : doc clean all archive



compileMainOuvrier:
	@mkdir -p $(CLASS)
	$(COMP) $(SRCPATH) $(SOURCE)/$(PACK)/MainOuvrier.java -d $(CLASS)

compileMainWar:
	@mkdir -p $(CLASS)
	$(COMP) $(SRCPATH) $(SOURCE)/$(PACK)/MainWar.java -d $(CLASS)

compileMain:
	@mkdir -p $(CLASS)
	$(COMP) $(SRCPATH) $(SOURCE)/$(PACK)/Main.java -d $(CLASS)

compileAll : compileMainOuvrier, compileMainWar, compileMain

docs :
	@mkdir -p $(DOC)
	$(CDOC) -quiet $(SRCPATH) $(SOURCE)/game/*.java $(SOURCE)/game/*.java -d $(DOC)
	$(CDOC) -quiet $(SRCPATH) $(SOURCE)/game/action/*.java $(SOURCE)/game/action/*.java -d $(DOC)
	$(CDOC) -quiet $(SRCPATH) $(SOURCE)/game/board/*.java $(SOURCE)/game/board/*.java -d $(DOC)
	$(CDOC) -quiet $(SRCPATH) $(SOURCE)/game/board/cell/*.java $(SOURCE)/game/board/cell/*.java -d $(DOC)
	$(CDOC) -quiet $(SRCPATH) $(SOURCE)/game/board/resources/*.java $(SOURCE)/game/board/resources/*.java -d $(DOC)
	$(CDOC) -quiet $(SRCPATH) $(SOURCE)/game/personnage/*.java $(SOURCE)/game/personnage/*.java -d $(DOC)


guerre : compileMainWar
	@$(CARCH) jar/guerre.jar jar/manifest-guerre $(CLASS)/Main

ouvrier : compileMainOuvrier
	  @$(CARCH) jar/ouvrier.jar jar/manifest-ouvrier $(CLASS)/Main

interaction : compileMain
	  @$(CARCH) jar/interaction.jar jar/manifest-interaction $(CLASS)/Main


clean :
	rm -rf $(DOC)
	@# CLEAN ARCHIVES
	rm -rf jar/ouvrier.jar
	rm -rf jar/guerre.jar
	rm -rf jar/interaction.jar
	@# CLEAN CLASSES
	rm -rf $(CLASS)

all : clean docs guerre ouvrier interaction
