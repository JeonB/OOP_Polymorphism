// Main
public class Main {
    public static void main(String[] args) {
        TaxiDriver taxiDriver = new TaxiDriver(new Avante());
        taxiDriver.run(); // --> output: 100km까지 걸리는 시간은 8초
        taxiDriver.stop(); // --> output: 100km에서 0km까지 걸리는 시간은 5초
        taxiDriver.guestDropOff(); // --> output: 손님 하차
    }
}
// Taxi 인터페이스
public interface Taxi {
    public void stepOnAccelerator();
    public void stepOnBrake();
}
// 아반떼 구현 클래스
public class Avante implements Taxi {
    @Override
    public void stepOnAccelerator() {
        System.out.println("100km까지 걸리는 시간은 8초");
    }

    @Override
    public void stepOnBrake() {
        System.out.println("100km에서 0km까지 걸리는 시간은 5초");
    }
}
// 소나타 구현 클래스
public class Sonata implements Taxi {
    @Override
    public void stepOnAccelerator() {
        System.out.println("100km까지 걸리는 시간은 6초");
    }

    @Override
    public void stepOnBrake() {
        System.out.println("100km에서 0km까지 걸리는 시간은 4초");
    }
}
// 그랜저 구현 클래스
public class Grandeur implements Taxi {
    @Override
    public void stepOnAccelerator() {
        System.out.println("100km까지 걸리는 시간은 5초");
    }

    @Override
    public void stepOnBrake() {
        System.out.println("100km에서 0km까지 걸리는 시간은 3초");
    }
}
// Taxi Driver 클래스
public class TaxiDriver {
    private Taxi taxiCar;
    
    public TaxiDriver(Taxi taxiCar) {
        this.taxiCar = taxiCar;
    }
    
    // 달리다
    public void run() {
        taxiCar.stepOnAccelerator();
    }
    
    // 멈추다
    public void stop() {
        taxiCar.stepOnBrake();
    }

    public void guestDropOff() {
        System.out.println("손님 하차");
    }
}

/* 택시기사는 택시의 차 종류가 무엇이던 간에 운전을 할 수 있고 택시 업무를 수행 할 수 있다. 즉 택시가 무엇으로 바뀌던지 간에 유연하고 변경에 용이하게 대응 할 수 있다.
왜냐하면 택시기사는 기본적으로 아반떼나, 소나타, 그랜저의 구현체에 의존성을 가지는것이 아닌 Taxi 인터페이스라는 역할에 의존성을 가지기 때문이다.
만약 차량이 고장날 경우에 대비하여 택시가 아반떼가 아닌 소나타나 그랜저로 바뀌어야 한다면 택시기사는 아반떼가 아닌 소나타나 그랜저를 운전하여 
택시 업무를 수행하면 그만이다. 이 역시 소스코드에서도 쉽게 대응 가능하다. Main 함수에서 아래와 같은 수정만 이루어 지면 된다.
 */

public class Main {
    public static void main(String[] args) {
        //TaxiDriver taxiDriver = new TaxiDriver(new Avante());
        //TaxiDriver taxiDriver = new TaxiDriver(new Sonata());
        TaxiDriver taxiDriver = new TaxiDriver(new Grandeur());
        taxiDriver.run();
        taxiDriver.stop();
        taxiDriver.guestDropOff();
    }
}

/* TaxiDriver의 생성자 함수로 인스턴스만 Avante의 구현체가 아닌 Sonata나 Grandeur을 넣어주면 된다. 이렇게 하면 TaxiDriver의 생성자에서
다음과 같이 Taxi 인터페이스를 Parameter로 전달 받아 taxiCar 멤버 변수에 할당한다. 앞서 Avante와 Sonata, Grandeur 구현 클래스는
Taxi 인터페이스를 구현(상속)하고 있기 때문에 이와 같은 행위가 가능하다.
 */

public class TaxiDriver {
    private Taxi taxiCar;
    
    public TaxiDriver(Taxi taxiCar) {
        this.taxiCar = taxiCar;
    }