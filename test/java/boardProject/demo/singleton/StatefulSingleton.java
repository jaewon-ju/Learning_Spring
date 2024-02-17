package boardProject.demo.singleton;

public class StatefulSingleton {

    private int timer;

    public void setTime(String name, int timer){
        System.out.println("name = " + name + "time = " + timer);
        this.timer = timer;
    }

    public int getTime(){
        return timer;
    }
}
