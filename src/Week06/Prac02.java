package Week06;

class TV {
    private int size;

    TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int color;

    ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    public void printProperty() {
        System.out.print(getSize() + "인치 " + color + "컬러");
    }
}

class IPTV extends ColorTV {
    String address;

    IPTV(String address, int inch, int color) {
        super(inch, color);
        this.address = address;
    }
}

public class Prac02 {
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);

        System.out.print("나의 IPTV는 " + iptv.address + " 주소의 ");
        iptv.printProperty();
    }
}
