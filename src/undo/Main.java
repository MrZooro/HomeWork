package undo;

public class Main {

    public static void main(String[] args) {
        // создаём строку и выводим её
        StringBuilderWithUndo str = new StringBuilderWithUndo("value");
        System.out.println(str);

        //изменяем строку
        str.append(" one");
        str.append(" two");
        str.append(" three");
        str.append(" four");

        //выводим обновлённую строку
        System.out.println(str);

        // откатываем последнее изменение и выводим обновлённую строку
        str.undo();
        System.out.println(str);

        // откатываем два последних изменения и выводим обновлённую строку
        str.undo();
        str.undo();
        System.out.println(str);

        // откатываем два последних изменения и выводим обновлённую строку
        str.undo();
        System.out.println(str);

        // изменяем строку и выводим обновлённую строку
        str.append(" new beginning");
        System.out.println(str);

        // откатываем два последних изменения и выводим обновлённую строку
        str.undo();
        System.out.print(str);
    }
}


