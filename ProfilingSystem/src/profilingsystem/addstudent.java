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
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Conrad P. Francisco Jr.
 */
public class addstudent extends javax.swing.JFrame {

    private byte[] imgdata;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int id = 0;
    
    public addstudent() {
        initComponents();
        conn = Methods.opensDB();
        URL iconURL = getClass().getResource("pwclogo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        ButtonGroup button = new ButtonGroup();
        button.add(gendermale);
        button.add(genderfemale);
        id = getID();
        String x = Integer.toString(id);
        idnum.setText(x);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        middlename = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        suffix = new javax.swing.JTextField();
        idnumlabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idnum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gendermale = new javax.swing.JRadioButton();
        genderfemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        section = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        birthdate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idnumlabel1 = new javax.swing.JLabel();
        idnumlabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        idpic = new javax.swing.JLabel();
        browse = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("ADD");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 260, 43));

        middlename.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        middlename.setForeground(new java.awt.Color(204, 204, 204));
        middlename.setText("Ex. 50");
        middlename.setToolTipText("First Name");
        middlename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                middlenameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                middlenameFocusLost(evt);
            }
        });
        jPanel1.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 260, 47));

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
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 263, 46));

        suffix.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        suffix.setForeground(new java.awt.Color(204, 204, 204));
        suffix.setToolTipText("First Name");
        suffix.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                suffixFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                suffixFocusLost(evt);
            }
        });
        suffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suffixActionPerformed(evt);
            }
        });
        jPanel1.add(suffix, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 260, 110));

        idnumlabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        idnumlabel.setForeground(new java.awt.Color(0, 0, 0));
        idnumlabel.setText("ITEM NUMBER");
        jPanel1.add(idnumlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profilingsystem/sm.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        idnum.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        idnum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(idnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 200, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SUPPLIER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 95, 31));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TYPE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 72, -1));

        gendermale.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        gendermale.setText("DOMESTIC");
        jPanel1.add(gendermale, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        genderfemale.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        genderfemale.setText("INTERNATIONAL");
        jPanel1.add(genderfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CATEGORY");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        course.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MILK", "DAIRY", "BEVERAGES", "LAUNDRY" }));
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        section.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MILK", "DAIRY", "BEVERAGES", "LAUNDRY" }));
        section.setToolTipText("");
        section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionActionPerformed(evt);
            }
        });
        jPanel1.add(section, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        add.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        add.setText("ADD STOCKS");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, -1, -1));
        jPanel1.add(birthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 263, 43));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PRODUCT RECEIVED AT");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("PRODUCT NAME");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("PRODUCT QUANTITY  BOXES ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 215, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("REMARKS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        idnumlabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        idnumlabel1.setForeground(new java.awt.Color(0, 0, 0));
        idnumlabel1.setText("SM SUPERMART");
        jPanel1.add(idnumlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        idnumlabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        idnumlabel2.setForeground(new java.awt.Color(0, 0, 0));
        idnumlabel2.setText("Add an Item to the Inventory");
        jPanel1.add(idnumlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profilingsystem/458594.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profilingsystem/blur.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 680));

        idpic.setBackground(new java.awt.Color(153, 153, 153));
        idpic.setForeground(new java.awt.Color(102, 102, 102));
        idpic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        browse.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        browse.setText("BROWSE");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(browse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idpic, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idpic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 537, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        if(suffix.getText().equals("Type here")){
            
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

        try{

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
                String value = id+", '"+fname+"', '"+mname+"', '"+lname+"', '"+sx+"', '"+birthsqlDate+"', '"+gender+"', '"+course+"', '"+section+"',  ''";
                System.out.println(value);
                    
                    if(Methods.create("Students", value)){
                        
                        Methods.update("Students", image, "IDPic", id);
                        
                    }
                    Methods.closeDB();
                    new menu().setVisible(true);
                    dispose();
                }
            
        }
        
        catch(Exception e){
            
            System.out.println("Error: "+e);
        }
    }//GEN-LAST:event_addActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
        new menu().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void sectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void suffixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suffixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suffixActionPerformed

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
                
                courses = "MILK";
                break;
            
            case 1:
                
                courses = "DAIRY";
                break;
            
            case 2:
                
                courses = "BEVERAGES";
                break;
            
            case 3:
                
                courses = "LAUNDRY";
                break;
        }
        
        
        return courses;
    }
    
    public String getSection(){
        
        String sections = " ";
        
        int a = section.getSelectedIndex();
        
        switch(a){
            
            case 0:
                
                sections = "MILK";
                break;
            
            case 1:
                
                sections = "DAIRY";
                break;
            
            case 2:
                
                sections = "BEVERAGES";
                break;
            
            case 3:
                
                sections = "LAUNDRY";
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
            
            sx = "''";
        }
        return sx;
    }
    
    public int getID(){
        
        String query = "SELECT MAX(StudentID) AS StudentID FROM Students";
        int id = 0;
        try{
            
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            id = rs.getInt("StudentID");
            pst.close();
            rs.close();
            Methods.closesDB();
            if(id==0){
                
                int year = Calendar.getInstance().get(Calendar.YEAR);
                String a = Integer.toString(year);
                String[] split = a.split("0");
                String b = split[1]+"00001";
                id = Integer.parseInt(b);
            }
            
            else{
                
                id+=1;
            }
        }
        
        catch(Exception e){
            
            System.out.println("Getting ID: "+e);
        }
        
        return id;
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addstudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private com.toedter.calendar.JDateChooser birthdate;
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> course;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JTextField suffix;
    // End of variables declaration//GEN-END:variables
}
