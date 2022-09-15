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
        idpic = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        middlename = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        suffix = new javax.swing.JTextField();
        idnumlabel = new javax.swing.JLabel();
        idnum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gendermale = new javax.swing.JRadioButton();
        genderfemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        section = new javax.swing.JComboBox<>();
        browse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablelist = new javax.swing.JTable();
        birthdate = new com.toedter.calendar.JDateChooser();

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("ADD");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idpic.setBackground(new java.awt.Color(153, 153, 153));
        idpic.setForeground(new java.awt.Color(102, 102, 102));
        idpic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        firstname.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        firstname.setForeground(new java.awt.Color(204, 204, 204));
        firstname.setText("First Name");
        firstname.setToolTipText("First Name");
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameFocusLost(evt);
            }
        });

        middlename.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        middlename.setForeground(new java.awt.Color(204, 204, 204));
        middlename.setText("Middle Name");
        middlename.setToolTipText("First Name");
        middlename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                middlenameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                middlenameFocusLost(evt);
            }
        });

        lastname.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lastname.setForeground(new java.awt.Color(204, 204, 204));
        lastname.setText("Last Name");
        lastname.setToolTipText("First Name");
        lastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameFocusLost(evt);
            }
        });

        suffix.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        suffix.setForeground(new java.awt.Color(204, 204, 204));
        suffix.setText("Suffix (Sr., Jr., III.,etc.)");
        suffix.setToolTipText("First Name");
        suffix.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                suffixFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                suffixFocusLost(evt);
            }
        });

        idnumlabel.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        idnumlabel.setText("Student ID No.");

        idnum.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        idnum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Birthdate:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Gender:");

        gendermale.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        gendermale.setText("Male");

        genderfemale.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        genderfemale.setText("Female");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Course:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Section:");

        course.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT", "BSCS", "ARCHITECTURE", "ENGINEERING" }));
        course.setSelectedIndex(-1);

        section.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        section.setSelectedIndex(-1);

        browse.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        browse.setText("BROWSE");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        add.setText("ADD USER");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablelist.getTableHeader().setResizingAllowed(false);
        tablelist.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablelist);
        if (tablelist.getColumnModel().getColumnCount() > 0) {
            tablelist.getColumnModel().getColumn(0).setResizable(false);
            tablelist.getColumnModel().getColumn(1).setResizable(false);
            tablelist.getColumnModel().getColumn(2).setResizable(false);
            tablelist.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(gendermale)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderfemale)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(idpic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(suffix, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(firstname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(birthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(browse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idnumlabel)
                            .addComponent(idnum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idpic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idnum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idnumlabel)
                    .addComponent(browse))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gendermale)
                            .addComponent(genderfemale))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        
        if(courses.equals("BSIT")){
            
            course.setSelectedIndex(0);
        }
        
        else if(courses.equals("BSCS")){
            
            course.setSelectedIndex(1);
        }
        
        else if(courses.equals("Architecture")){
            
            course.setSelectedIndex(2);
        }
        
        else if(courses.equals("Engineering")){
            
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
    private javax.swing.JLabel idpic;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JTextField suffix;
    private javax.swing.JTable tablelist;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
