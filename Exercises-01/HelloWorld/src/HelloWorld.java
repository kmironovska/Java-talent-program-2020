public class HelloWorld {
    int test = 10;

    void printTestOne(){
        int test = 20;
        System.out.println(test);
        System.out.println(this.test);
    }
    void printTestTwo(){
        System.out.println(test);
    }
    public static void main(String[] args) {
        HelloWorld he = new HelloWorld();
        he.printTestOne();
        he.printTestTwo();

    }
}
