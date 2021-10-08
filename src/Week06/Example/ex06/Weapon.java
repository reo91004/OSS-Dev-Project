package Week06.Example.ex06;

public class Weapon {
    protected int fire() {
        return 1; // 무기는 기본적으로 한 명만 살상
    }
}

class Cannon extends Weapon {
    @Override
    protected int fire() { // 오버라이딩
        return 10; // 대포는 한 번에 10명을 살상
    }
}