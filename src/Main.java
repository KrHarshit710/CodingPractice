import java.util.Objects;

public class Main {
    int a;
    int b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return a == main.a && b == main.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}