/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 //*/
package aspectbasedsa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author GAURAV KUMAR
 */
public class Misc {
    
    int START_LINE=1;
    int END_LINE=5417;
    String Aspect_Term[]=new String[20];
    String Aspect_Term_polarity[]=new String[20];
    String Aspect_Category[]=new String[20];
    String Aspect_Category_Polarity[]=new String[20];
    int count_term=0;
    int count_category=1;
    
    
    public void SemiEval() throws FileNotFoundException, IOException
    {
     BufferedReader buffer=new BufferedReader(new FileReader(new File("Outputi.txt")));
      BufferedWriter writer=new BufferedWriter(new FileWriter(new File("SEMIEVAL.txt"),true));
     String line;
     int start=1;
     int end=1;
     while((line=buffer.readLine())!=null)
     {
          if(start>=START_LINE&&end<=END_LINE)
          {
          String[] result=line.split("\t");
          String text=result[2];
          try
            {
            int j=3;
            count_term=0;
            
            writer.write(start+"\t"+text);
            
            for(j=3;j<(result.length);j++)
                 {
                     if(result[j].contains("category"))
                          {
                         break;
                     }
                     
                    String aspect_term_1[]=result[j].split(":"); 
                    Aspect_Term[j-3]=aspect_term_1[0];
                    System.out.println(aspect_term_1[0]);
                    Aspect_Term_polarity[j-3]=aspect_term_1[1];
                    count_term++;
                   
                    writer.write("\t");
                    writer.write(Aspect_Term[count_term-1]+":#");
                    writer.write(Aspect_Term_polarity[count_term-1]);
                    
                }
            
            
      
                  
            writer.newLine();
          
          }
          catch(ArrayIndexOutOfBoundsException e)
          {
            //  continue;
          }
          
          }
          start++;
          end++;
          
     }
     buffer.close();
     writer.close();
             
    }
    
    
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        
        Misc m=new Misc();
        m.SemiEval();
   /*     String sy[]=new String[5000];
        int p=0;
        File f=new File("Output.txt");
        BufferedReader buffer=new BufferedReader(new FileReader(f));
        String line;
        int status=0;
       
             while((line=buffer.readLine())!=null)
        {
            String[] l=line.split("\t");
           
            //String match= String.valueOf(i);
          // sy[p++]=l[0];
            
        } 
         
             
           for(int i=1;i<=5417;i++)
           {
               int status1=0;
               String i1=Integer.toString(i);
               for(int j=1;j<=2561;j++)
               {
                   if(sy[j].equals(i1))
                   {
                       status1=1;
                      // System.out.println("R$^$^$");
                    
                    
                   } else {
                   }
               }
               
               if(status1==0)
               {
                   System.out.println(i);
               }
               status1=0;
           }
      
       buffer.close();      
       * 
        */
       
    }
    
}
