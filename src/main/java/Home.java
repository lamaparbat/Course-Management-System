
import Backend.Admin;
import Backend.Course_Backend;
import Backend.Credential;
import Backend.Instructor;
import Backend.Student;
import Backend.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class Home extends javax.swing.JFrame {

    public Home() throws ClassNotFoundException, SQLException, IOException {
        // default user authentication routing
        authRoute();

        //table config        
        activity_table.getColumnModel().getColumn(0).setPreferredWidth(30);
        activity_table.getColumnModel().getColumn(1).setPreferredWidth(700);
        activity_table.setBounds(0, 0, 600, 30);
        //center the rows values
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        activity_table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //fill the table rows
        addActivityTableRows();
    }

    private void authRoute() throws ClassNotFoundException, SQLException, IOException {
        //check if file exist or not
        if (new Credential().isEmpty() == true) {
            this.setVisible(false);
            this.dispose();
            new Signup().setVisible(true);
        } else {
            // load the component        
            initComponents();
        }
    }

    private void initComponents() throws ClassNotFoundException, SQLException {

        jPanel8 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        sibar_title = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        course_btn = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        calendar_btn = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        mail_btn = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        setting_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        dashboard_btn = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        logout_btn = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        tutor_btn = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        notif_title = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activity_table = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        coursebox = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        teacherbox = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        studentbox = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        notif_icon = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        notif_title1 = new javax.swing.JLabel();
        notif_icon1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel17 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText(" New user currenlty registered  X");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText(" New user currenlty registered  X");

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText(" New user currenlty registered  X");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addContainerGap(9, Short.MAX_VALUE))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addContainerGap(8, Short.MAX_VALUE))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        sidebar.setBackground(new java.awt.Color(102, 102, 102));
        sidebar.setForeground(new java.awt.Color(255, 255, 255));

        sibar_title.setFont(new java.awt.Font("Menlo", 1, 13)); // NOI18N
        sibar_title.setForeground(new java.awt.Color(228, 226, 226));
        sibar_title.setText("COURSE MANGEMENT SYSTEM");

        logo.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/logo.png")); // NOI18N

        jPanel2.setLayout(null);

        jPanel7.setLayout(null);
        jPanel2.add(jPanel7);

        course_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        course_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel29.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/course.png")); // NOI18N

        jLabel36.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel36.setText("Courses");

        javax.swing.GroupLayout course_btnLayout = new javax.swing.GroupLayout(course_btn);
        course_btn.setLayout(course_btnLayout);
        course_btnLayout.setHorizontalGroup(
                course_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(course_btnLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        course_btnLayout.setVerticalGroup(
                course_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        calendar_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        calendar_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel38.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/student.png")); // NOI18N

        jLabel39.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel39.setText("Students");

        javax.swing.GroupLayout calendar_btnLayout = new javax.swing.GroupLayout(calendar_btn);
        calendar_btn.setLayout(calendar_btnLayout);
        calendar_btnLayout.setHorizontalGroup(
                calendar_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(calendar_btnLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
        );
        calendar_btnLayout.setVerticalGroup(
                calendar_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mail_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mail_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel40.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/mail.png")); // NOI18N

        jLabel41.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel41.setText("Mail");

        javax.swing.GroupLayout mail_btnLayout = new javax.swing.GroupLayout(mail_btn);
        mail_btn.setLayout(mail_btnLayout);
        mail_btnLayout.setHorizontalGroup(
                mail_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mail_btnLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel41)
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        mail_btnLayout.setVerticalGroup(
                mail_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setting_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setting_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel42.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/setting.png")); // NOI18N

        jLabel43.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel43.setText("Setting");

        javax.swing.GroupLayout setting_btnLayout = new javax.swing.GroupLayout(setting_btn);
        setting_btn.setLayout(setting_btnLayout);
        setting_btnLayout.setHorizontalGroup(
                setting_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(setting_btnLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel43)
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        setting_btnLayout.setVerticalGroup(
                setting_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dashboard_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dashboard_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard_btn.setForeground(Color.WHITE);
        dashboard_btn.setBackground(new java.awt.Color(255, 153, 153));

        jLabel30.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/dashboard2.png")); // NOI18N

        jLabel44.setFont(new java.awt.Font("Monospaced", 0, 16));
        jLabel44.setForeground(Color.WHITE);
        jLabel44.setText("Dashboard");

        javax.swing.GroupLayout dashboard_btnLayout = new javax.swing.GroupLayout(dashboard_btn);
        dashboard_btn.setLayout(dashboard_btnLayout);
        dashboard_btnLayout.setHorizontalGroup(
                dashboard_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dashboard_btnLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
        );
        dashboard_btnLayout.setVerticalGroup(
                dashboard_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        logout_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        //navigator onclick event handling
        dashboard_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    dashboard_navigate(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        course_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    courses_navigate(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tutor_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tutors_navigate(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        calendar_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    calendar_navigate(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        mail_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    mail_navigate(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        setting_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    try {
                        setting_navigate(evt);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        logout_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    logout(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel48.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/logout.png")); // NOI18N

        jLabel49.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel49.setText("Logout");

        javax.swing.GroupLayout logout_btnLayout = new javax.swing.GroupLayout(logout_btn);
        logout_btn.setLayout(logout_btnLayout);
        logout_btnLayout.setHorizontalGroup(
                logout_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(logout_btnLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel49)
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        logout_btnLayout.setVerticalGroup(
                logout_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tutor_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tutor_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel50.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/teachers.png")); // NOI18N

        jLabel51.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jLabel51.setText("Tutors");

        javax.swing.GroupLayout tutor_btnLayout = new javax.swing.GroupLayout(tutor_btn);
        tutor_btn.setLayout(tutor_btnLayout);
        tutor_btnLayout.setHorizontalGroup(
                tutor_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tutor_btnLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel50)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        );
        tutor_btnLayout.setVerticalGroup(
                tutor_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(sidebarLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(setting_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(sidebarLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(course_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dashboard_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tutor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(calendar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mail_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sidebarLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(sibar_title, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sidebarLayout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(logo)))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sibar_title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dashboard_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(sidebarLayout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addComponent(course_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tutor_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(calendar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mail_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(setting_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(91, Short.MAX_VALUE))
        );

        notif_title.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        notif_title.setText("Notification");

        jPanel9.setBackground(new java.awt.Color(255, 153, 153));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText(" New user currenlty registered ");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel4.setText("12:30 am");

        jLabel6.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel5)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel6))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel4)))
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel6)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        //increase table header size
        JTableHeader th = activity_table.getTableHeader();
        th.setFont(new Font("Dialog", Font.BOLD, 14));

        activity_table.setBackground(new java.awt.Color(29, 90, 250));
        activity_table.setForeground(new Color(250, 250, 250));

        //increase table header height
        JTableHeader header = activity_table.getTableHeader();
        header.setPreferredSize(new Dimension(35, 35));

        //increase the table row height
        activity_table.setRowHeight(activity_table.getRowHeight() + 15);

        //increase table rows font size
        activity_table.setFont(new Font("Serif", Font.PLAIN, 14));

        activity_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Activity Name"
                }
        ));

        jScrollPane1.setViewportView(activity_table);

        jLabel24.setFont(new java.awt.Font("Menlo", 0, 20)); // NOI18N
        jLabel24.setText("DASHBOARD");

        coursebox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jLabel20.setText("Total Courses");

        jLabel23.setFont(new java.awt.Font("Monospaced", 0, 50)); // NOI18N
        jLabel23.setText(String.valueOf(new Course_Backend().getTotalCoursesCount()) + "  ");

        jButton3.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/folder.png")); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout courseboxLayout = new javax.swing.GroupLayout(coursebox);
        coursebox.setLayout(courseboxLayout);
        courseboxLayout.setHorizontalGroup(
                courseboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseboxLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(14, 14, 14))
                        .addGroup(courseboxLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        courseboxLayout.setVerticalGroup(
                courseboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseboxLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addContainerGap(36, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, courseboxLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addContainerGap())
        );

        teacherbox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jLabel21.setText("Total Teachers");

        jLabel26.setFont(new java.awt.Font("Monospaced", 0, 50)); // NOI18N
        jLabel26.setText(String.valueOf(" " + new Instructor().getTotalTutorsCount()) + "  ");

        jButton4.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/folder.png")); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout teacherboxLayout = new javax.swing.GroupLayout(teacherbox);
        teacherbox.setLayout(teacherboxLayout);
        teacherboxLayout.setHorizontalGroup(
                teacherboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(teacherboxLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(teacherboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        teacherboxLayout.setVerticalGroup(
                teacherboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(teacherboxLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26)
                                .addContainerGap(38, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teacherboxLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addContainerGap())
        );

        studentbox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jLabel22.setText("Total Students");

        jLabel25.setFont(new java.awt.Font("Monospaced", 0, 50)); // NOI18N
        jLabel25.setText(" " + String.valueOf(new Student().getTotalStudentsCount()) + "   ");

        jButton10.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/folder.png")); // NOI18N
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout studentboxLayout = new javax.swing.GroupLayout(studentbox);
        studentbox.setLayout(studentboxLayout);
        studentboxLayout.setHorizontalGroup(
                studentboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentboxLayout.createSequentialGroup()
                                .addGroup(studentboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(studentboxLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel22)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(studentboxLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton10)))
                                .addContainerGap())
        );
        studentboxLayout.setVerticalGroup(
                studentboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentboxLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addContainerGap(37, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentboxLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10)
                                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Activities History");

        notif_icon.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/notif.png")); // NOI18N

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText(" New user currenlty registered ");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel8.setText("12:30 am");

        jLabel9.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel7)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel9))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel8)))
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel9)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel8)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText(" New user currenlty registered ");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel14.setText("12:30 am");

        jLabel15.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel10)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel15))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel14)))
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel15)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel14)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(204, 255, 255));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel16.setText(" New user currenlty registered ");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel17.setText("12:30 am");

        jLabel18.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel16)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel18))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel17)))
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel18)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel17)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel19.setText("See More ..... ");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        notif_title1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        notif_title1.setText("To Do");

        notif_icon1.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/todo.png")); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 153, 153));

        jLabel45.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel45.setText(" New user currenlty registered ");

        jLabel46.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel46.setText("12:30 am");

        jLabel47.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel47.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel45)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel47))
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel46)))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel45)
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel47)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel46)
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 255, 255));

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel32.setText(" New user currenlty registered ");

        jLabel33.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel33.setText("12:30 am");

        jLabel34.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel32)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel34))
                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel33)))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel32)
                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel34)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel33)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 153, 153));

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel27.setText(" New user currenlty registered ");

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel28.setText("12:30 am");

        jLabel31.setFont(new java.awt.Font("Marker Felt", 0, 14)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/delete.png")); // NOI18N
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel27)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel31))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel28)))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel27)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel31)))
                                .addGap(2, 2, 2)
                                .addComponent(jLabel28)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(coursebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(teacherbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(9, 9, 9)
                                                                .addComponent(studentbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(notif_title)
                                                .addGap(8, 8, 8)
                                                .addComponent(notif_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel19)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(notif_title1)
                                                                                .addGap(13, 13, 13)
                                                                                .addComponent(notif_icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel24)
                                                .addGap(6, 6, 6)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(coursebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(teacherbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addGap(12, 12, 12)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(notif_title)
                                                        .addComponent(notif_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel19)
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(notif_title1)
                                                        .addComponent(notif_icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    //dashboard navigate
    private void dashboard_navigate(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException, IOException {
        Window win = SwingUtilities.getWindowAncestor((Component) evt.getSource());
        win.dispose();
        new Home().setVisible(true);
    }

    //courses navigate
    private void courses_navigate(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException {
        Window win = SwingUtilities.getWindowAncestor((Component) evt.getSource());
        win.dispose();
        new Course().setVisible(true);
    }

    //tutors function
    private void tutors_navigate(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException {
        Window win = SwingUtilities.getWindowAncestor((Component) evt.getSource());
        win.dispose();
        new Tutors().setVisible(true);
    }

    //logout function
    private void calendar_navigate(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException, FileNotFoundException {

        Window win = SwingUtilities.getWindowAncestor((Component) evt.getSource());
        win.dispose();
        new Students().setVisible(true);
    }

    //calendar navigate
    private void mail_navigate(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException, URISyntaxException, IOException {

        // open browser and link to mail
        desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://gmail.com/"));

    }

    //setting navigate
    private void setting_navigate(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException, FileNotFoundException {
        Window win = SwingUtilities.getWindowAncestor((Component) evt.getSource());
        win.dispose();
        new Setting().setVisible(true);
    }

    //logout navigate
    private void logout(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException {
        if (new User().logout()) {
            //dipose the current running homepeage
            this.dispose();
            //redirect to login page
            new Login().setVisible(true);
        }
    }

    //activity table update
    void addActivityTableRows() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = (DefaultTableModel) activity_table.getModel();

        ArrayList<String> activity_log = new Admin().getActivityList();
        //add the row value
        Object[] row = new Object[2];
        for (int i = 0; i < activity_log.size(); i++) {
            row[0] = i + 1;
            row[1] = "  " + activity_log.get(i);
            model.addRow(row);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Home().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTable activity_table;
    private javax.swing.JPanel calendar_btn;
    private javax.swing.JPanel course_btn;
    private javax.swing.JPanel coursebox;
    private javax.swing.JPanel dashboard_btn;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logout_btn;
    private javax.swing.JPanel mail_btn;
    private javax.swing.JLabel notif_icon;
    private javax.swing.JLabel notif_icon1;
    private javax.swing.JLabel notif_title;
    private javax.swing.JLabel notif_title1;
    private javax.swing.JPanel setting_btn;
    private javax.swing.JLabel sibar_title;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel studentbox;
    private javax.swing.JPanel teacherbox;
    private javax.swing.JPanel tutor_btn;
    private Desktop desktop;
    // End of variables declaration                   
}
