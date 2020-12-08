package mmf.murzich;

public class Main {

    public static void main(String[] args) {
        String[] words = {"Караганда", "Воронеж", "Киев", "Жданов", "Витебск", "Архангельск"};
        Euler euler = new Euler(words);
        if (euler.eulerMethod()) System.out.println("Можно");
        else System.out.println("Нельзя");
    }
}