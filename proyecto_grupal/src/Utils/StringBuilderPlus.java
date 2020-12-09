package Utils;

public class StringBuilderPlus {

       private final StringBuilder sb;

       public StringBuilderPlus(){
            sb = new StringBuilder();
       }

       public void append(String str)
       {
           sb.append(str != null ? str : "");
       }

       public void appendLine(String str)
       {
           sb.append(str != null ? str : "").append(System.getProperty("line.separator"));
       }

       @Override
       public String toString()
       {
           return sb.toString();
       }
}
