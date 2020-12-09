/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author GUSTAVO
 */
public class StringBuilderPlus {

       private StringBuilder sb;

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

       public String toString()
       {
           return sb.toString();
       }
}
