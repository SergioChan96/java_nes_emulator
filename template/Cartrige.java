package sample;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cartrige {
    private byte[] rom;
    public Cartrige (String path){
        try {
            rom = Files.readAllBytes(Paths.get(path));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void dump(){
        System.out.print("rom: ");
        for (int i = 0; i < rom.length; i++) {
            System.out.printf("%x, ", rom[i]);

        }
    }
    public byte[] loadToMemory(){
        return rom;
    }
}
