package com.company;

public class movieDTO {
    private String name, addr;

    public movieDTO(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }
    public String getAddr() {
        return addr;
    }

    @Override
    public String toString() {
        return "NamecardVO [name=" + name + ", addr=" + addr + "]";
    }
}
