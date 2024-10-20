package sample;

public class Memory {
    private byte[] rom;

    public Memory(Cartrige cartrige){
        rom = cartrige.loadToMemory();
    }

    public byte get(short adress){
        return rom[adress];
    }
}
