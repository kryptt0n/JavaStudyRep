public class StringClass {
    StringBuilder sb;

    public void PrintString(){
        sb = new StringBuilder("hello");
        sb.append(" world!");
        System.out.println(sb.substring(2));
    }

}
