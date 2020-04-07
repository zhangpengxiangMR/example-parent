public class Test {

    public static void main(String[] args) {

        System.out.println(toLowerFirstCase("B"));
    }


    private static String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        chars[0] += 32 ;
        return String.valueOf(chars);
    }

}
