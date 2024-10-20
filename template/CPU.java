package sample;

public class CPU {
    private byte a = 0x01;
    private byte b;
    private byte c;
    private byte d;
    private byte e;
    private byte h;
    private byte l;
    private byte f = (byte) 0xB0;
    //this register is the flags register and looks like this ZNHC0000 last four always 0
    //Z = zero flag N = subtract flag H = half carry flag C = carry flag
    private short sp;
    private short pc = 0x0100;
    private Memory memory;
    public CPU(Memory memory){
        this.memory = memory;
    }
    public void cycle(){
        System.out.printf("line %x ", pc);
        byte opcode = memory.get(pc);
        pc++;
        System.out.printf("executing %x%n",opcode);
        switch (opcode){
            case 0x00:
                nop();
                break;
            case (byte) 0xc3:
                jp();
                break;
            case (byte) 0x2c:
                incE();
                break;
            case (byte) 0xaf:
                xorA();
                break;
            case 0x21:
                ldHLnn();
                break;
            case 0x0e:
                ldCn();
                break;
            case 0x06:
                ldBn();
                break;
            case 0x32:
                ldHLless1A();
                break;
            default:
                System.out.printf("no such instruction available %x %n", opcode);
                System.exit(1);
        }

    }
    private void nop(){
        //wait 1 Maschine cycle or 4 T-states
    }
    private void jp(){
        // 16/12 T-states
        byte adress2 = memory.get(pc);
        pc++;
        byte adress1 = memory.get(pc);
        pc = (short) (adress1 << 8 | adress2);
    }
    private void incE(){
        e++;
        //todo implement flags Z 0 H
    }
    private void xorA(){
        //resets all flags except Z
        // 4 T-states
        a = (byte) (a^a);
        f = (byte) 0x80;
    }
    private void ldHLnn(){
        // 12 T-states
        l = memory.get(pc);
        pc++;
        h = memory.get(pc);
        pc++;
    }
    private void ldCn(){
        // 8 T-states
        c = memory.get(pc);
        pc++;
    }
    private void ldBn(){
        // 8 T-states
        b=memory.get(pc);
        pc++;
    }
    private void ldHLless1A(){
        
    }
    private void ldSPnn(){
        // 12 T-states
        byte adress2 = memory.get(pc);
        pc++;
        byte adress1 = memory.get(pc);
        sp = (short) (adress1 << 8 | adress2);
        pc++;
    }
}
