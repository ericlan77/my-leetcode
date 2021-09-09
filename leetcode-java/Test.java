public class Test {
    public static void main(String[] args) {
        String input = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        String[] list = input.split(",");

        for(String ele: list)
            System.out.println(ele);
    }
}
