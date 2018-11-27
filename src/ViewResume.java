
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GEHNA
 */
public class ViewResume extends javax.swing.JFrame {

    String usn;
  
    /**
     * Creates new form NewJFrame
     */
    public ViewResume() {
        initComponents();
    }
    
    public ViewResume(String usn){
        this.usn=usn;
       
        initComponents();
         try{
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume","root","5431");
                    
                    //************************** PERSONAL *********************************
                    String sql = "select * from personal where usn='"+usn+"';";
                    PreparedStatement pst=con.prepareStatement(sql);
                    ResultSet rs=pst.executeQuery(sql);

                    if(rs.next()){
                        String f_name=rs.getString("first_name");
                        String l_name=rs.getString("last_name");
                        String email1=rs.getString("email");
                        String phone1=rs.getString("phone");
                        String addr=rs.getString("address");
                        String cgpa1=rs.getString("cgpa");
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_personal.getModel();
                        model.addRow(new Object[]{f_name,l_name,email1,phone1,addr,cgpa1}); 
                    } 
                    
                    //************************** EDUCATION *********************************
                    
                    String sql1="Select * from education where usn='"+usn+"';";
                    PreparedStatement pst1=con.prepareStatement(sql1);
                    ResultSet rs1=pst1.executeQuery(sql1);
                      
                    int flag =0;
                    while(rs1.next()){
                        String Ename=rs1.getString("ename");
                        String Degree=rs1.getString("degree");
                        String Eyear=rs1.getString("e_year");
                        String Percent=rs1.getString("percentage");
                        flag=1;
                        DefaultTableModel model=(DefaultTableModel)REtable_education.getModel();
                        model.addRow(new Object[]{Ename,Degree,Eyear,Percent}); 
                    }
                    if(flag==0){
                       Panel_education.setVisible(false); 
                    }
                    
                    //************************** PROJECTS *********************************
                    
                    flag=0;
                    String sql2 = "select * from projects where usn='"+usn+"';";
                    PreparedStatement pst2=con.prepareStatement(sql);
                    ResultSet rs2=pst2.executeQuery(sql2);
                    
                    while(rs2.next()){
                        String title=rs2.getString("title");
                        String Pyear=rs2.getString("p_year");
                        String Pdesc=rs2.getString("p_desc");
                        String link=rs2.getString("link");
                        String category=rs2.getString("category");
                        flag=1;
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_projects.getModel();
                        model.addRow(new Object[]{title,Pyear,Pdesc,link,category}); 
                    }
                    if(flag==0)
                        Panel_projects.setVisible(false);
                    
                    //************************** SKILLS *********************************
                    
                    flag=0;
                    String sql3 = "select * from skills where usn='"+usn+"';";
                    PreparedStatement pst3=con.prepareStatement(sql3);
                    ResultSet rs3=pst3.executeQuery(sql3);
                    
                    while(rs3.next()){
                        String Sno=rs3.getString("s_no");
                        String Skill=rs3.getString("skill");
                        
                        flag=1;
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_skills.getModel();
                        model.addRow(new Object[]{Sno,Skill}); 
                    }
                    if(flag==0)
                        Panel_skills.setVisible(false);
                    
                     //************************** CERTIFICATIONS *********************************
                    
                    flag=0;
                    String sql4 = "select * from certifications where usn='"+usn+"';";
                    PreparedStatement pst4=con.prepareStatement(sql4);
                    ResultSet rs4=pst4.executeQuery(sql4);
                    
                    while(rs4.next()){
                        String Cno=rs4.getString("c_no");
                        String Cname=rs4.getString("c_name");
                        String Ctype=rs4.getString("c_type");
                         
                        flag=1;
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_certifications.getModel();
                        model.addRow(new Object[]{Cno,Cname,Ctype}); 
                    }
                    if(flag==0)
                        Panel_certifications.setVisible(false);
                    
                     //************************** INTERNSHIPS *********************************
                    
                    flag=0;
                    String sql5 = "select * from internships where usn='"+usn+"';";
                    PreparedStatement pst5=con.prepareStatement(sql5);
                    ResultSet rs5=pst5.executeQuery(sql5);
                    
                    while(rs5.next()){
                        String Compname=rs5.getString("company_name");
                        String Duration=rs5.getString("duration");
                        String Idesc=rs5.getString("i_desc");
                        String Ino=rs5.getString("i_no");
                        String Icat=rs5.getString("category");
                         
                        flag=1;
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_internships.getModel();
                        model.addRow(new Object[]{Compname,Duration,Idesc,Ino,Icat}); 
                    }
                    if(flag==0)
                        Panel_internships.setVisible(false);
                    
                     //************************** EXTRA-CURRICULAR *********************************
                    
                    flag=0;
                    String sql6 = "select * from extra_curricular where usn='"+usn+"';";
                    PreparedStatement pst6=con.prepareStatement(sql6);
                    ResultSet rs6=pst6.executeQuery(sql6);
                    
                    while(rs6.next()){
                        String Eno=rs6.getString("e_no");
                        String Edesc=rs6.getString("e_desc");
                        flag=1;
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_extra.getModel();
                        model.addRow(new Object[]{Eno,Edesc}); 
                    }
                    if(flag==0)
                        Panel_extra.setVisible(false);
                    
                     //************************** PUBLICATIONS *********************************
                    
                    flag=0;
                    String sql7 = "select * from publications where usn='"+usn+"';";
                    PreparedStatement pst7=con.prepareStatement(sql7);
                    ResultSet rs7=pst7.executeQuery(sql7);
                    
                    while(rs7.next()){
                        String Pname=rs7.getString("p_name");
                        String Plink=rs7.getString("pub_link");
                        flag=1;
                        
                        DefaultTableModel model=(DefaultTableModel)REtable_publications.getModel();
                        model.addRow(new Object[]{Pname,Plink}); 
                    }
                    if(flag==0)
                        Panel_publications.setVisible(false);
                    
         }
         catch(Exception e){
             System.out.println(e);
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane28 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jScrollPane45 = new javax.swing.JScrollPane();
        REtable_personal = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        Panel_education = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        REtable_education = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        Panel_projects = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        REtable_projects = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        Panel_skills = new javax.swing.JPanel();
        jScrollPane31 = new javax.swing.JScrollPane();
        REtable_skills = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        Panel_certifications = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        REtable_certifications = new javax.swing.JTable();
        Panel_internships = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        REtable_internships = new javax.swing.JTable();
        Panel_extra = new javax.swing.JPanel();
        jScrollPane47 = new javax.swing.JScrollPane();
        REtable_extra = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        Panel_publications = new javax.swing.JPanel();
        jScrollPane48 = new javax.swing.JScrollPane();
        REtable_publications = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        REtable_personal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Email", "Phone", "Address", "CGPA"
            }
        ));
        jScrollPane45.setViewportView(REtable_personal);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Personal Details");

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane45, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_education.setBackground(new java.awt.Color(255, 255, 255));

        REtable_education.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instituition Name", "Degree", "Year of Graduation", "Percentage"
            }
        ));
        jScrollPane29.setViewportView(REtable_education);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Education");

        javax.swing.GroupLayout Panel_educationLayout = new javax.swing.GroupLayout(Panel_education);
        Panel_education.setLayout(Panel_educationLayout);
        Panel_educationLayout.setHorizontalGroup(
            Panel_educationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_educationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_educationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_educationLayout.setVerticalGroup(
            Panel_educationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_educationLayout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_projects.setBackground(new java.awt.Color(255, 255, 255));

        REtable_projects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Year", "Description", "Link", "Category"
            }
        ));
        jScrollPane30.setViewportView(REtable_projects);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Projects");

        javax.swing.GroupLayout Panel_projectsLayout = new javax.swing.GroupLayout(Panel_projects);
        Panel_projects.setLayout(Panel_projectsLayout);
        Panel_projectsLayout.setHorizontalGroup(
            Panel_projectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_projectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_projectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_projectsLayout.setVerticalGroup(
            Panel_projectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_projectsLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_skills.setBackground(new java.awt.Color(255, 255, 255));

        REtable_skills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "Skill"
            }
        ));
        jScrollPane31.setViewportView(REtable_skills);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Skills");

        javax.swing.GroupLayout Panel_skillsLayout = new javax.swing.GroupLayout(Panel_skills);
        Panel_skills.setLayout(Panel_skillsLayout);
        Panel_skillsLayout.setHorizontalGroup(
            Panel_skillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_skillsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_skillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_skillsLayout.setVerticalGroup(
            Panel_skillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_skillsLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_certifications.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Certifications");

        REtable_certifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No", "Name", "Type"
            }
        ));
        jScrollPane46.setViewportView(REtable_certifications);

        javax.swing.GroupLayout Panel_certificationsLayout = new javax.swing.GroupLayout(Panel_certifications);
        Panel_certifications.setLayout(Panel_certificationsLayout);
        Panel_certificationsLayout.setHorizontalGroup(
            Panel_certificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_certificationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_certificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_certificationsLayout.setVerticalGroup(
            Panel_certificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_certificationsLayout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_internships.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Internships");

        REtable_internships.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No", "Comapny Name", "Duration", "Description", "Category"
            }
        ));
        jScrollPane32.setViewportView(REtable_internships);

        javax.swing.GroupLayout Panel_internshipsLayout = new javax.swing.GroupLayout(Panel_internships);
        Panel_internships.setLayout(Panel_internshipsLayout);
        Panel_internshipsLayout.setHorizontalGroup(
            Panel_internshipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_internshipsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_internshipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_internshipsLayout.setVerticalGroup(
            Panel_internshipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_internshipsLayout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Panel_extra.setBackground(new java.awt.Color(255, 255, 255));

        REtable_extra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No", "Description"
            }
        ));
        jScrollPane47.setViewportView(REtable_extra);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Extra Curricular");

        javax.swing.GroupLayout Panel_extraLayout = new javax.swing.GroupLayout(Panel_extra);
        Panel_extra.setLayout(Panel_extraLayout);
        Panel_extraLayout.setHorizontalGroup(
            Panel_extraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_extraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_extraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_extraLayout.setVerticalGroup(
            Panel_extraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_extraLayout.createSequentialGroup()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_publications.setBackground(new java.awt.Color(255, 255, 255));

        REtable_publications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Link"
            }
        ));
        jScrollPane48.setViewportView(REtable_publications);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Publications");

        javax.swing.GroupLayout Panel_publicationsLayout = new javax.swing.GroupLayout(Panel_publications);
        Panel_publications.setLayout(Panel_publicationsLayout);
        Panel_publicationsLayout.setHorizontalGroup(
            Panel_publicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_publicationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_publicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_publicationsLayout.setVerticalGroup(
            Panel_publicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_publicationsLayout.createSequentialGroup()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Panel_certifications, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_education, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_projects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_skills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_internships, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_extra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_publications, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_education, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_projects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_skills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_certifications, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_internships, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Panel_publications, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane28.setViewportView(jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("RESUME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewResume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewResume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewResume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewResume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewResume().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_certifications;
    private javax.swing.JPanel Panel_education;
    private javax.swing.JPanel Panel_extra;
    private javax.swing.JPanel Panel_internships;
    private javax.swing.JPanel Panel_projects;
    private javax.swing.JPanel Panel_publications;
    private javax.swing.JPanel Panel_skills;
    private javax.swing.JTable REtable_certifications;
    private javax.swing.JTable REtable_education;
    private javax.swing.JTable REtable_extra;
    private javax.swing.JTable REtable_internships;
    private javax.swing.JTable REtable_personal;
    private javax.swing.JTable REtable_projects;
    private javax.swing.JTable REtable_publications;
    private javax.swing.JTable REtable_skills;
    private javax.swing.JTable Rtable_education;
    private javax.swing.JTable Rtable_education1;
    private javax.swing.JTable Rtable_education2;
    private javax.swing.JTable Rtable_education3;
    private javax.swing.JTable Rtable_education4;
    private javax.swing.JTable Rtable_education5;
    private javax.swing.JTable Rtable_education6;
    private javax.swing.JTable Rtable_education7;
    private javax.swing.JTable Rtable_education8;
    private javax.swing.JTable Rtable_personal26;
    private javax.swing.JTable Rtable_personal27;
    private javax.swing.JTable Rtable_personal28;
    private javax.swing.JTable Rtable_personal29;
    private javax.swing.JTable Rtable_personal30;
    private javax.swing.JTable Rtable_personal31;
    private javax.swing.JTable Rtable_personal32;
    private javax.swing.JTable Rtable_personal33;
    private javax.swing.JTable Rtable_personal34;
    private javax.swing.JTable Rtable_personal36;
    private javax.swing.JTable Rtable_skills3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
