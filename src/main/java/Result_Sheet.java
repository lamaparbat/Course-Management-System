
import Backend.Credential;
import Backend.Student;
import com.mysql.cj.util.StringUtils;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Result_Sheet extends javax.swing.JFrame {

    public Result_Sheet() throws FileNotFoundException, ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws FileNotFoundException, ClassNotFoundException, SQLException {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name_val = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        course_name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        report_table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        search_inp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        if (new Credential().getMode().equals("Student")) {
            //auto fill the progress result search keyword
            search_inp.setText(String.valueOf(new Credential().getId()));
            search_inp.disable();
            // auto fill the table row data -> progress report
            autoFillReport();

        }
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/report1.png")); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Progress Report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addContainerGap())
        );

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setText("Student Name :");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setText("Course : ");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setText("Module Wise Progression");

        jLabel10.setIcon(new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/progress.png")); // NOI18N

        report_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Student Name", "Module", "Percentage", "Grade"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        report_table.setRowHeight(20);
        report_table.setRowMargin(5);
        jScrollPane1.setViewportView(report_table);
        if (report_table.getColumnModel().getColumnCount() > 0) {
            report_table.getColumnModel().getColumn(0).setPreferredWidth(30);
            report_table.getColumnModel().getColumn(1).setPreferredWidth(150);
            report_table.getColumnModel().getColumn(2).setPreferredWidth(350);
            report_table.getColumnModel().getColumn(3).setPreferredWidth(80);
            report_table.getColumnModel().getColumn(3).setMaxWidth(100);
            report_table.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel11.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jLabel11.setText("Enter Student ID");

        search_inp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    search_inpKeyReleased(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Result_Sheet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Result_Sheet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Result_Sheet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_keyPressed(evt);
            }

        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel5)
                                                                                .addGap(8, 8, 8)
                                                                                .addComponent(name_val, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7)
                                                                                .addGap(8, 8, 8)
                                                                                .addComponent(course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(search_inp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel9)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(name_val))
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(course_name)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(search_inp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel9))
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    //on backspace key pressed
    public void search_keyPressed(KeyEvent e) {
        // Invoked when a key has been pressed.
        if (e.getKeyCode() == 8) {
            name_val.setText("");
            course_name.setText("");
        }
    }
    
    //auto fill the report table row
    private void autoFillReport() throws ClassNotFoundException, SQLException, FileNotFoundException{
        try {
                DefaultTableModel model = (DefaultTableModel) report_table.getModel();
                model.setRowCount(0);
                Object[] row = new Object[5];
                int id =new Credential().getId();

                //send keyword to backend
                ArrayList<Student> student_details = new Student().searchStudent(id);
                ArrayList<Student> module_result_list = new Student().getProgressReport(id);

                //report description
                if (student_details.size() > 0) {
                    name_val.setText(new Student().getStudentName(student_details.get(0)));
                    course_name.setText(new Student().getCourseName(student_details.get(0)));
                }
                

                if (module_result_list.size() > 0) {
                    for (Student i : module_result_list) {
                        //fill table
                        row[0] = i.getStudentId(i);
                        row[1] = i.getStudentName(i);
                        row[2] = i.getModuleName(i);
                        row[3] = i.getPercentage(i);
                        row[4] = i.getGrade(i);

                        //append data row to table
                        model.addRow(row);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong data type input. Integer expect!");
            }
    }    
    
    // search the report on key presss    
    private void search_inpKeyReleased(java.awt.event.KeyEvent evt) throws ClassNotFoundException, SQLException, FileNotFoundException {
        if (new Credential().getMode().equals("Student") != true) {
            try {
                DefaultTableModel model = (DefaultTableModel) report_table.getModel();
                model.setRowCount(0);
                Object[] row = new Object[5];
                int id = Integer.parseInt(search_inp.getText());

                //send keyword to backend
                ArrayList<Student> student_details = new Student().searchStudent(id);
                ArrayList<Student> module_result_list = new Student().getProgressReport(id);

                //report description
                if (student_details.size() > 0) {
                    name_val.setText(new Student().getStudentName(student_details.get(0)));
                    course_name.setText(new Student().getCourseName(student_details.get(0)));
                }

                if (module_result_list.size() > 0) {
                    for (Student i : module_result_list) {
                        //fill table
                        row[0] = i.getStudentId(i);
                        row[1] = i.getStudentName(i);
                        row[2] = i.getModuleName(i);
                        row[3] = i.getPercentage(i);
                        row[4] = i.getGrade(i);

                        //append data row to table
                        model.addRow(row);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong data type input. Integer expect!");
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Result_Sheet().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Result_Sheet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Result_Sheet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Result_Sheet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel course_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel name_val;
    private javax.swing.JTable report_table;
    private javax.swing.JTextField search_inp;
    // End of variables declaration                   
}
