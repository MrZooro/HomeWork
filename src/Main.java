public class Main {

    public static void main(String[] args) {
        StringBuilderWithUndo str = new StringBuilderWithUndo("value");
        System.out.println(str);

        str.append(" one");
        str.append(" two");
        str.append(" three");
        str.append(" four");

        System.out.println(str);

        str.undo();
        System.out.println(str);


        str.undo();
        str.undo();
        System.out.println(str);

        str.undo();
        System.out.println(str);

        str.append(" new beginning");
        System.out.println(str);

        str.undo();
        System.out.print(str);
    }
}


