================ Welcome to dieTunes! ================

dieTunes is a simple music player written in Java.

To launch dieTunes, execute the following command 
or double-click the dieTunes.jar file:

    java -jar dieTunes.jar

To run the command as a background process, do:

    java -jar dieTunes.jar &

dieTunes will automatically search for sub-directories
in the res/music/ directory. Each sub-directory
should contain supported audio files that are meant to 
be grouped together. An example hierarchy is presented 
here:

    dieTunes.jar
    res/
        images/
            header.png
            icon.png
            speaker_deselected.png
            speaker_selected.png
        music/
            AliceGroup/
                Caterpillar.wav
                CheshireCat.wav
                QueenOfHearts.wav
                MadHatter.wav
                WhiteRabbit.wav
            PoeGroup/
                Eleonora.wav
                
The directory hierarchy shown above creates two 
separate music groups: AliceGroup and PoeGroup. The 
first group contains five supported audio files and 
the second group contains only one.

To add a new group, create a new subdirectory in the 
res/music/ directory.

The supported audio file formats are listed here:

    .wav
    .aiff
    .au

If an unsupported file type is stored anywhere in 
the res/music/ directory, it will be listed in the 
display with the suffix: "(UNSUPPORTED)"

dieTunes was created by:

    ZPL
