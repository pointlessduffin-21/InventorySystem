package profilingsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Conrad P. Francisco Jr.
 */
public class menu extends javax.swing.JFrame {

    private byte[] imgdata;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int row = 100;
    int id = 0;
    ButtonGroup button = new ButtonGroup();
    
    public menu() {
        initComponents();
        conn = Methods.opensDB();
        this.refresh();
        URL iconURL = getClass().getResource("pwclogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        button.add(gendermale);
        button.add(genderfemale);
    }

        public void refresh(){
       
        if(Methods.openDB()){
            String[] columns = {"StudentID", "LastName", "Course", "Sec"};
            String[][] records = Methods.read("Students",columns);
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(records, columns){
                @Override
                public boolean isCellEditable(int row, int column) {
                    
                    return false;
                }
            };
            model.setRowCount(row);
            this.tablelist.setModel(model);
            
            ListSelectionListener lsl = new ListSelectionListener(){
                public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                    if (tablelist.getSelectedRow() > -1) {
                        int row = tablelist.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "Row is " + row);
                        if(Methods.openDB()){
                            String sr_id = tablelist.getValueAt(tablelist.getSelectedRow(), 0).toString();
                            id = Integer.parseInt(sr_id);
                            String[][] result = Methods.read("Students", "StudentID=" + id);
                            idnum.setText(result[0][0]);
                            firstname.setText(result[0][1]);
                            middlename.setText(result[0][2]);
                            lastname.setText(result[0][3]);
                            suffix.setText(result[0][4]);
                            setBirthdate(result[0][5]);
                            setGender(result[0][6]);
                            setCourse(result[0][7]);
                            setSection(result[0][8]);
                            
                            firstname.setForeground(Color.BLACK);
                            middlename.setForeground(Color.BLACK);
                            lastname.setForeground(Color.BLACK);
                            suffix.setForeground(Color.BLACK);
                            
                            try{
                                
                                byte[] in = Methods.read("Students", "IDPic", id);
                                ImageIcon icon = new ImageIcon(in);
                                Toolkit toolkit = Toolkit.getDefaultToolkit();
                                Image image = icon.getImage();
                                Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                                idpic.setIcon(new javax.swing.ImageIcon(scaledImage));
                            }
                            catch(Exception e){
                                
                                System.out.print("Load Image Error: " + e.getMessage());
                                
                            }
                            Methods.closeDB();
                        }
                    }
                }
            };
            this.tablelist.getSelectionModel().addListSelectionListener(lsl);
            Methods.closeDB();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        middlename = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        suffix = new javax.swing.JTextField();
        idnumlabel = new javax.swing.JLabel();
        idnum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gendermale = new javax.swing.JRadioButton();
        genderfemale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        idnumlabel2 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        section = new javax.swing.JComboBox<>();
        browse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablelist = new javax.swing.JTable();
        birthdate = new com.toedter.calendar.JDateChooser();
        idnumlabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idpic = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("ADD");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstname.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        firstname.setForeground(new java.awt.Color(204, 204, 204));
        firstname.setText("Ex. Nestle Food Corp.");
        firstname.setToolTipText("First Name");
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameFocusLost(evt);
            }
        });
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 258, 44));

        middlename.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        middlename.setForeground(new java.awt.Color(204, 204, 204));
        middlename.setText("Ex. 15");
        middlename.setToolTipText("First Name");
        middlename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                middlenameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                middlenameFocusLost(evt);
            }
        });
        jPanel1.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 260, 44));

        lastname.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lastname.setForeground(new java.awt.Color(204, 204, 204));
        lastname.setText("Ex. Bear Brand");
        lastname.setToolTipText("First Name");
        lastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameFocusLost(evt);
            }
        });
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 246, 44));

        suffix.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        suffix.setForeground(new java.awt.Color(204, 204, 204));
        suffix.setText("Add Notes");
        suffix.setToolTipText("First Name");
        suffix.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                suffixFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                suffixFocusLost(evt);
            }
        });
        jPanel1.add(suffix, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 450, 200));

        idnumlabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        idnumlabel.setForeground(new java.awt.Color(0, 0, 0));
        idnumlabel.setText("ITEM CODE");
        jPanel1.add(idnumlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 30));

        idnum.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        idnum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(idnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 200, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("REMARKS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profilingsystem/sm.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 210));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TYPE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        gendermale.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        gendermale.setText("DOMESTIC");
        jPanel1.add(gendermale, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        genderfemale.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        genderfemale.setText("INTERNATIONAL");
        jPanel1.add(genderfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CATEGORY");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 30));

        idnumlabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        idnumlabel2.setForeground(new java.awt.Color(0, 0, 0));
        idnumlabel2.setText("INVENTORY LIST");
        jPanel1.add(idnumlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, -1, -1));

        course.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MILK", "DAIRY", "BEVERAGES", "LAUNDRY" }));
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 162, -1));

        section.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MILK", "DAIRY", "BEVERAGES", "LAUNDRY" }));
        jPanel1.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 162, -1));

        browse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        browse.setText("BROWSE");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        jPanel1.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 190, 110));

        tablelist.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ITEM ID", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablelist.getTableHeader().setResizingAllowed(false);
        tablelist.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablelist);
        if (tablelist.getColumnModel().getColumnCount() > 0) {
            tablelist.getColumnModel().getColumn(0).setResizable(false);
            tablelist.getColumnModel().getColumn(1).setResizable(false);
            tablelist.getColumnModel().getColumn(2).setResizable(false);
            tablelist.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 418, 530));
        jPanel1.add(birthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 270, 42));

        idnumlabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        idnumlabel1.setForeground(new java.awt.Color(0, 0, 0));
        idnumlabel1.setText("SM SUPERMART INVENTORY");
        jPanel1.add(idnumlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        add.setText("ADD ITEM");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 190, 110));

        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 620, 122, -1));

        delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 620, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Product Received at");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("PRODUCT NAME");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("SUPPLIER");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("PRODUCT QUANTITY (BOXES)");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profilingsystem/lowpoly1.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 660));

        idpic.setBackground(new java.awt.Color(153, 153, 153));
        idpic.setForeground(new java.awt.Color(102, 102, 102));
        idpic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(idpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 577, 67, 23));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 541, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void firstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusGained
        if(firstname.getText().equals("First Name")){
            
            firstname.setText("");
        }
        
        firstname.setForeground(Color.BLUE);
    }//GEN-LAST:event_firstnameFocusGained

    private void firstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusLost
        
        if(firstname.getText().equals("")){
            
            firstname.setText("First Name");
            firstname.setForeground(new Color(204,204,204));
        }
        
        else {
            
            firstname.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_firstnameFocusLost

    private void middlenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middlenameFocusGained
        
        if(middlename.getText().equals("Middle Name")){
            
            middlename.setText("");
        }
        
        middlename.setForeground(Color.BLUE);
        
    }//GEN-LAST:event_middlenameFocusGained

    private void middlenameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middlenameFocusLost
        
        if(middlename.getText().equals("")){
            
            middlename.setText("Middle Name");
            middlename.setForeground(new Color(204,204,204));
        }
        
        else {
            
            middlename.setForeground(Color.BLACK); 
        }
       
    }//GEN-LAST:event_middlenameFocusLost

    private void lastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameFocusGained
        
        if(lastname.getText().equals("Last Name")){
            
            lastname.setText("");
        }
        
        lastname.setForeground(Color.BLUE);
        
    }//GEN-LAST:event_lastnameFocusGained

    private void lastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameFocusLost
        
        if(lastname.getText().equals("")){
            
            lastname.setText("Last Name");
            lastname.setForeground(new Color(204,204,204));
        }
        
        else {
            
            lastname.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_lastnameFocusLost

    private void suffixFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_suffixFocusGained
        
        if(suffix.getText().equals("Suffix (Sr., Jr., III.,etc.)")){
            
            suffix.setText("");
        }
        
        suffix.setForeground(Color.BLUE);
        
    }//GEN-LAST:event_suffixFocusGained

    private void suffixFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_suffixFocusLost
        
        if(suffix.getText().equals("")){
            
            suffix.setText("Suffix (Sr., Jr., III.,etc.)");
            suffix.setForeground(new Color(204,204,204));
        }
        else {
            
            suffix.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_suffixFocusLost

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        
        File fimage = new File(filename);
        try{
            
            FileInputStream fis = new FileInputStream(fimage);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf)) !=-1;){
                
                bos.write(buf,0,readNum);
                
            }
            imgdata = bos.toByteArray();
            
            java.awt.Image image = stretchImage(filename, this.idpic);
            this.idpic.setIcon(new javax.swing.ImageIcon(image));
            
            
        }
        catch(Exception e){
            
            System.out.println("FileInputStream Error: "+ e.getMessage());
        
        }
        
    }//GEN-LAST:event_browseActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        new addstudent().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        int DialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to Update?","", DialogButton);
        if(result == JOptionPane.YES_OPTION){
        
            if(Methods.openDB()){
               
                String fname = getFname();
                String mname = getMname();
                String lname = getLname();
                String sx = getSuffix();
                java.util.Date birth = (java.util.Date) birthdate.getDate();
                java.sql.Date birthsqlDate = new java.sql.Date(birth.getTime());
                byte[] image = this.imgdata;
                String gender = getGender();
                String course = getCourse();
                String section = getSection();
                String value = "FirstName='"+fname+"', MiddleName='"+mname+"', LastName='"+lname+"', Suffix='"+sx+"', Birthdate='"+birthsqlDate+"', Gender='"+gender+"', Course='"+course+"', Sec='"+section+"'";
                System.out.println(value);
                System.out.println(id);
                String newid = Integer.toString(id);
                if(Methods.updatestudent("Students",value,newid)){
                
                    Methods.update("Students", image, "IDPic", id);
                    javax.swing.JOptionPane.showMessageDialog(null, "Data has been updated successfully.");
                }
                
                else{
                    
                    javax.swing.JOptionPane.showMessageDialog(null, "Update Error!");
                }
                Methods.closeDB();
                this.refresh();
            }
        
        }
        
        else if (result == JOptionPane.NO_OPTION){
        
            new menu().setVisible(true);
            dispose();
            
        }
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would you like to remove student records?", "Delete Employee Details", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION) {
        
            if(Methods.openDB()){
                
                if(Methods.deletestudent("Students", id)){
                    
                    javax.swing.JOptionPane.showMessageDialog(null, "Student records has been deleted successfuly");
                    new menu().setVisible(true);
                    dispose();
                    
                }
                
                else {
                    
                    javax.swing.JOptionPane.showMessageDialog(null, "Data Deletion Error!!");
                }
                Methods.closeDB();
                this.refresh();
            }
            
        }
        
        else if(dialogResult == JOptionPane.NO_OPTION){
            
            new menu().setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    public void setSection(String sections){
        
        if(sections.equals("A")){
            
            section.setSelectedIndex(0);
        }
        
        else if(sections.equals("B")){
            
            section.setSelectedIndex(1);
        }
        
        else if(sections.equals("C")){
            
            section.setSelectedIndex(2);
        }
        
        else if(sections.equals("D")){
            
            section.setSelectedIndex(3);
        }
        
        else if (sections.equals("-1")){
            
            section.setSelectedIndex(-1);
        }
    }
    
    public void setCourse(String courses){
        
        if(courses.equals("MILK")){
            
            course.setSelectedIndex(0);
        }
        
        else if(courses.equals("DAIRY")){
            
            course.setSelectedIndex(1);
        }
        
        else if(courses.equals("BEVERAGES")){
            
            course.setSelectedIndex(2);
        }
        
        else if(courses.equals("LAUNDRY")){
            
            course.setSelectedIndex(3);
        }
        
        else if (courses.equals("-1")){
            
            course.setSelectedIndex(-1);
        }
    }
    
    public void setGender(String gender){
        
        if(gender.equals("Male")){
            
            gendermale.setSelected(true);
        }
        
        else {
            
            genderfemale.setSelected(true);
        }
    }
    
    public void setBirthdate(String date){
        
        Date dated;
            
            try {
                dated = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                birthdate.setDate(dated);
            
            } 
            
            catch (ParseException ex) {
            
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public Image stretchImage(String path, JLabel label){
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(path);
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        return scaledImage;
        
    }
    
    public String getGender(){
        
        String gender = " ";
        
        if(gendermale.isSelected()){
                        
        gender = "Male";
                        
        }
                    
        else if (genderfemale.isSelected()) {
                        
        gender = "Female";
        
        }
        
        return gender;
    }
    
    public String getCourse(){
        
        String courses = " ";
        
        int a = course.getSelectedIndex();
        
        switch(a){
            
            case 0:
                
                courses = "BSIT";
                break;
            
            case 1:
                
                courses = "BSCS";
                break;
            
            case 2:
                
                courses = "Architecture";
                break;
            
            case 3:
                
                courses = "Engineering";
                break;
        }
        
        
        return courses;
    }
    
    public String getSection(){
        
        String sections = " ";
        
        int a = section.getSelectedIndex();
        
        switch(a){
            
            case 0:
                
                sections = "A";
                break;
            
            case 1:
                
                sections = "B";
                break;
            
            case 2:
                
                sections = "C";
                break;
            
            case 3:
                
                sections = "D";
                break;
        }
        
        return sections;
    }
    
    public String getFname(){
        
        String fname = firstname.getText();
        if(fname == "First Name"){
            
            fname = "''";
        }
        return fname;
    }
    
    public String getMname(){
        
        String mname = middlename.getText();
        if(mname == "Middle Name"){
            
            mname = "''";
        }
        return mname;
    }
    
    public String getLname(){
        
        String lname = lastname.getText();
        if(lname == "Last Name"){
            
            lname = "''";
        }
        return lname;
    }
    
    public String getSuffix(){
        
        String sx = suffix.getText();
        if(sx.equals("Suffix (Sr., Jr., III.,etc.)")){
            
            sx = " ";
        }
        return sx;
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private com.toedter.calendar.JDateChooser birthdate;
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JButton delete;
    private javax.swing.JTextField firstname;
    private javax.swing.JRadioButton genderfemale;
    private javax.swing.JRadioButton gendermale;
    private javax.swing.JLabel idnum;
    private javax.swing.JLabel idnumlabel;
    private javax.swing.JLabel idnumlabel1;
    private javax.swing.JLabel idnumlabel2;
    private javax.swing.JLabel idpic;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JTextField suffix;
    private javax.swing.JTable tablelist;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
