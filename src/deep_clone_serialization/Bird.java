package deep_clone_serialization;

import java.io.Serializable;

public class Bird implements Serializable {
static String name;
final int head = 1;
transient int weight;

    public Bird() {
    }

    public Bird(int weight) {
        this.weight = weight;
    }

    public int getHead() {
        return head;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Bird{" +
                " name=" + name +
                ", head=" + head +
                ", weight=" + weight +
                '}';
    }
}
