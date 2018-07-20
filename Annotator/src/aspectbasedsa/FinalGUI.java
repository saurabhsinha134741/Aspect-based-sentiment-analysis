/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aspectbasedsa;


import java.awt.Desktop;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author My Pc
 */
public class FinalGUI extends javax.swing.JFrame {

    
    DefaultTableModel model = new DefaultTableModel();
   // JTablejTable1 = new JTable(model);
    int aspect_term_row_status=1;
    int aspect_category_row_status=1;
       int at=1;
     int ac=1;
     static int count=0;
     static String str[]=new String[600000];
     String at_pol;
     static int line_status=-1;
     int at_status=1;
     int ac_status=1;
    ArrayList<String> _at1=new ArrayList<String>();;
    ArrayList<String> _at2=new ArrayList<String>();
    ArrayList<String> _at3=new ArrayList<String>();
   
    ArrayList<JComboBox> comobox=new ArrayList<JComboBox>();
    
    static int no_of_column=3;
    
    
     DefaultTableModel models=new DefaultTableModel() ;
    static String list_of_polarity[]=new String[5];
    static String list_of_category[]=new String[110];
    int len; 
    int len1;
    /**
     * Creates new form FinalGUI
     */
    public FinalGUI()  {
        initComponents();
         jLabel7.setText("<HTML><FONT color=\"#000099\"><U>Acknowledgement</U></FONT>"
        + "</HTML>");
        jLabel6.setText("<HTML><FONT color=\"#000099\"><U>Help</U></FONT>"
        + "</HTML>");
         String line1 = null;
        try
      {
          FileReader f=new FileReader("HiABSA1516.config");
          BufferedReader b=new BufferedReader(f);
          String line2=null;
          while((line1=b.readLine())!=null)
          {
              
              if(line1.contains("ASPECT_CATEGORY"))
              {
                 
                Pattern pattern = Pattern.compile("ASPECT_CATEGORY"+"(.*?)"+"[:]");
                Matcher matcher = pattern.matcher(line1);
                String q = null;
                
                while (matcher.find()) {
                    q=matcher.group(1).toString();
                   q=q.replace("[","");
                   q=q.replace("]","");
                   String sy1[]=q.split(",");
                   len1=sy1.length;
                   list_of_category[0]=" ";
                
                  for(int i=0;i<len1;i++)
                   {
                       list_of_category[i+1]=sy1[i];        // here we have all categories in this
                      // System.out.println(sy1[i]);
                   }
                  
                  
                  
                   
                   
              //    System.out.println(q);
                   
                   
                }
              }
             
              if(line1.contains("SENTENCE_POLARITY"))
              {
                  line1=line1.replace("SENTENCE_POLARITY","");
                   line1=line1.replace("[","");
                   line1=line1.replace("]","");
                   String sy[]=line1.split(",");
                   len=sy.length;
                   list_of_polarity[0]=" ";
                   for(int i=0;i<len;i++)
                   {
                       list_of_polarity[i+1]=sy[i];        //here we have list of polarities
                     //  System.out.println(sy[i]);
                   }
               //   System.out.println(line1);
                 
              }
          }
        
      }
        
    
        catch(Exception p)
        {
            p.printStackTrace();
        }
     
      
        
        for(int i=0;i<=len;i++)
            {
        jComboBox1.addItem(list_of_polarity[i]);          // for sentence polarities
            }
 // Add the no of Columns       
/*for(int t=0;t<=no_of_column;t++)
{
jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//jTable1.getColumnModel().addColumn().setPreferredWidth(752);
models =(DefaultTableModel) jTable2.getModel();
models.addColumn(" Aspect Term");
//jTable1.setAutoResizeMode(JTable.AUTO_RESIZE);
TableColumn gradeColumn = jTable2.getColumnModel().getColumn(t);
JComboBox comboBox = new JComboBox();
        
     
        for(int i=0;i<list_of_polarity.length;i++)
            {
        comboBox.addItem(list_of_polarity[i]);
            }
            gradeColumn.setCellEditor(new DefaultCellEditor(comboBox));
}
* 
* */

jTable1.getColumnModel().getColumn(0).setPreferredWidth(752);
jTable1.getColumnModel().getColumn(1).setPreferredWidth(185);
jTable1.getColumnModel().getColumn(2).setPreferredWidth(185);

   TableColumn gradeColumn = jTable1.getColumnModel().getColumn(1);
   TableColumn gradeColumn1 = jTable1.getColumnModel().getColumn(2);
   
         JComboBox comboBox = new JComboBox();
         JComboBox comboBox2 = new JComboBox();
         
         try {
            for(int i=0;i<list_of_polarity.length;i++)
            {
        comboBox.addItem(list_of_polarity[i]);
            }
    } catch (NullPointerException e) {
    } catch (Exception e) {
        e.printStackTrace();
    }
    gradeColumn1.setCellEditor(new DefaultCellEditor(comboBox));
    
    //FOR CATEGORIES
    try {
            for(int i=0;i<list_of_category.length;i++)
            {
        comboBox2.addItem(list_of_category[i]);
            }
    } catch (NullPointerException e) {
    } catch (Exception e) {
        e.printStackTrace();
    }
    gradeColumn.setCellEditor(new DefaultCellEditor(comboBox2));
  
  
 
         
      
   
    
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Annotator");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextArea1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Text");

        jLabel2.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}

            },
            new String [] {
                "OTE", "Category(E#A)", "Polarity"
            }
        ));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(2);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Sentence Polarity");

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Close");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("IITP Annotator");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Semi Eval Task 15/16");

        jLabel9.setIcon(new javax.swing.ImageIcon("F:\\research\\Documents\\NetBeansProjects\\Annotator\\IIT-Patna.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Help");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Acknowledgement");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(779, 779, 779)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
         model.addRow(new Object[]{});
        
        
        aspect_term_row_status++;   
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
        
      model =(DefaultTableModel) jTable1.getModel();
      
        if(aspect_term_row_status>1)
        {
             model.removeRow(aspect_term_row_status-1);
              aspect_term_row_status--;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

   
    
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     //  String item_combo=(String) jComboBox1.getSelectedItem();
     //   System.out.println(item_combo);
         String cat_pol;
         String aspect_pol;
         String text;
         String sentence_pol=(String) jComboBox1.getSelectedItem();
         text=jTextArea1.getText();                                  // this is the text
          
    
      
      
        for(int k=0;k<aspect_term_row_status;k++)
        {
           _at1.add((String) jTable1.getModel().getValueAt(k, 0));
           //_at2.add((String) jComboBox1.getSelectedItem());
        
        //   System.out.println(jTable1.getModel().getValueAt(k, 0)+"asddfghj"); 
        }
         
        for(int k=0;k<aspect_term_row_status;k++)
        {
           _at2.add((String) jTable1.getModel().getValueAt(k, 1));
           //_at2.add((String) jComboBox1.getSelectedItem());
        
          // System.out.println(jTable1.getModel().getValueAt(k, 1)+"asddfghj"); 
        }
         for(int k=0;k<aspect_term_row_status;k++)
        {
           _at3.add((String) jTable1.getModel().getValueAt(k, 2));
           //_at2.add((String) jComboBox1.getSelectedItem());
        
          // System.out.println(jTable1.getModel().getValueAt(k, 1)+"asddfghj"); 
        }
        
        
       
        
        
         
        
       
        
        
         
         
        if(sentence_pol==null)
        {
         sentence_pol="1"; 
        }
       // sentence_pol="1";
        
        /// ---------------------------
        // File Writing Operation is going on
        String final_line=String.valueOf(line_status+1)+"\t";
        final_line=final_line+sentence_pol+"\t"+text;
        
        for(int j=0;j<_at1.size();j++)  
              {
                  if(_at1.get(j)!=null&&!_at1.get(j).equals(" "))
                  {
                    final_line=final_line+"\t"+_at1.get(j);  
                  }
                 
                  if(_at2.get(j)!=null&&!_at2.get(j).equals(" "))
                  {
                    final_line=final_line+":"+_at2.get(j);  
                  }
                   if(_at3.get(j)!=null&&!_at3.get(j).equals(" "))
                  {
                    final_line=final_line+":"+_at3.get(j);  
                  }
                  
              }
       
         final_line=final_line.trim();
         System.out.println(final_line);
        
  //   jComboBox1.setEnabled(false);
      //jComboBox1.setSelectedIndex(0);
      line_status++;
         jTextField1.setText(String.valueOf(line_status+1));
         jTextArea1.setText(str[line_status]);
       _at1.clear();
        _at2.clear();
        _at3.clear();
        
        if(line_status>=1)
        {
           try {
               FileWriter file=new FileWriter(new File("Output1516.txt"),true);
               BufferedWriter buffer=new BufferedWriter(file);
               buffer.write(final_line);
               buffer.newLine();
               buffer.close();
           } catch (IOException ex) {
               Logger.getLogger(FinalGUI.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
        
        
        
    
        for(int i=1;i<aspect_term_row_status;i++)
        {
            ((DefaultTableModel)jTable1.getModel()).removeRow(i);
        }
        
         
         jTable1.setValueAt(" ",0,0);
        jTable1.setValueAt(" ",0,1);
        jTable1.setValueAt(" ",0,2);
        
        
       
      aspect_term_row_status=1;
         aspect_category_row_status=1;
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextArea1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseReleased
        // TODO add your handling code here:
        
             
        jTable1.setValueAt(jTextArea1.getSelectedText(),aspect_term_row_status-1,0);
       
        
    }//GEN-LAST:event_jTextArea1MouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     /*   // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            //
            FileWriter fw=new FileWriter("PreviousReview.txt");
            BufferedWriter bufferedWriter =new BufferedWriter(fw);
            while(line_status<=count)
            {
                bufferedWriter.write(str[line_status]);
                bufferedWriter.newLine(); 
                line_status++;
                System.out.println("line"+line_status+" "+count+" "+str[line_status]);
            }
            
           

bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FinalGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.exit(0);
        
        
        setVisible(false);
        
        */
        try
        {
            FileWriter fwi=new FileWriter("PreviousReview.txt");
            BufferedWriter bwi=new BufferedWriter(fwi);
            bwi.write((Integer.toString(line_status-1)));
            bwi.close();  
        }
        catch(Exception ar)
        {
            ar.printStackTrace();
        }
         
        setVisible(false);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        /*
        
         for ack
        
        */
         try {
      Desktop desktop = null;
      if (Desktop.isDesktopSupported()) {
        desktop = Desktop.getDesktop();
      }

       desktop.open(new File("acknowledge.txt"));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
        
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        /*
        
        
        help
        
        */
         try {
      Desktop desktop = null;
      if (Desktop.isDesktopSupported()) {
        desktop = Desktop.getDesktop();
      }

       desktop.open(new File("help.txt"));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    }//GEN-LAST:event_jLabel6MouseClicked
                                

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Creatryte and display the form */
       
         try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            // start application
            new FinalGUI();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalGUI().setVisible(true);
            }
        });
                  //read all the reviews
                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("Review.txt"),"utf-8"));
               //   StringBuffer stringBuffer = new StringBuffer();
                  String line;
                  try
                  {
                      
                   while ((line = bufferedReader.readLine()) != null) {
                   str[count]=line;
                   count++;            
           
                  }
                 bufferedReader.close();
                 // System.out.println("CCoonntteennttss ooff ffiillee::");
                //  System.out.println(stringBuffer.toString()); 
        
                  } catch (IOException e) {
                  e.printStackTrace();
                  }
                 
                  /*
                 
                  
                  
                  //check whether previos is present or not
                  int pre_status=0;
                  pre_status=check_prev("PreviousReview.txt");
                  if(pre_status!=0)
                  {
                     //no previous button 
                      System.out.println("c"+pre_status+"count"+count);
                  
                      
                  }
                   System.out.println("c"+pre_status+"count"+count);
                          
                          */
                              
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
