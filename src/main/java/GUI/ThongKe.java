/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.ThanhVienBLL;
import BLL.ThietBiBLL;
import BLL.ThongTinSuDungBLL;
import BLL.XuLyBLL;
import DAL.Entities.ThongTinSuDung;
import DAL.Entities.XuLy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author lamquoc
 */
public class ThongKe extends javax.swing.JPanel {

    private final ThongTinSuDungBLL thongTinSuDungBLL = new ThongTinSuDungBLL();
    private final ThanhVienBLL thanhVienBLL = new ThanhVienBLL();
    private final ThietBiBLL thietBiBLL = new ThietBiBLL();
    private final XuLyBLL xuLyBLL = new XuLyBLL();
    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();


        fillData(thanhVienBLL.getAllKhoa(), thanhVienBLL.getAllNganh(), thietBiBLL.getListTenTB());

        jComboBox3.addActionListener((ActionEvent e) -> {
            String selectedValue = (String) jComboBox3.getSelectedItem();
            if (selectedValue != null) {
                switch (selectedValue) {
                    case "Theo ngày" -> {
                        FromDate.setEnabled(true);
                        ToDate.setEnabled(true);
                        jComboBox1.setEnabled(false);
                        jComboBox2.setEnabled(false);
                    }
                    case "Theo khoa" -> {
                        FromDate.setEnabled(false);
                        ToDate.setEnabled(false);
                        jComboBox1.setEnabled(true);
                        jComboBox2.setEnabled(false);
                    }
                    case "Theo ngành" -> {
                        FromDate.setEnabled(false);
                        ToDate.setEnabled(false);
                        jComboBox1.setEnabled(false);
                        jComboBox2.setEnabled(true);
                    }
                    default -> {
                        FromDate.setEnabled(false);
                        ToDate.setEnabled(false);
                        jComboBox1.setEnabled(false);
                        jComboBox2.setEnabled(false);
                    }
                }
            }
        });

        jComboBox3.setSelectedItem("--Chọn thống kê theo--");

        ToDate.addChangeListener((ChangeEvent e) -> {
            Date selectedDate2 = (Date) FromDate.getValue();
            Date selectedDate4 = (Date) ToDate.getValue();
                   
            if (selectedDate2 != null && selectedDate4 != null && !selectedDate4.after(selectedDate2)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(selectedDate2);
                calendar.add(Calendar.SECOND, 1);
                ToDate.setValue(calendar.getTime());
                JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        jSpinner5.addChangeListener((ChangeEvent e) -> {
            Date selectedDate2 = (Date) jSpinner3.getValue();
            Date selectedDate4 = (Date) jSpinner5.getValue();
            if (selectedDate2 != null && selectedDate4 != null && !selectedDate4.after(selectedDate2)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(selectedDate2);
                calendar.add(Calendar.SECOND, 1);
                jSpinner5.setValue(calendar.getTime());
                JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        jComboBox9.addActionListener((ActionEvent e) -> {
            String selectedValue = (String) jComboBox9.getSelectedItem();
            if (selectedValue != null) {
                switch (selectedValue) {
                    case "Đang được mượn" -> {
                        jLabel18.setText("Ngày: ");
                        jSpinner3.setEnabled(true);
                        jSpinner5.setEnabled(false);
                        jComboBox7.setEnabled(false);
                        
                        jLabel19.setVisible(false);
                        jLabel20.setVisible(false);
                        jSpinner5.setVisible(false);
                    }
                    case "Được mượn theo thời gian" -> {
                        jLabel18.setText("Từ ngày: ");
                        jSpinner3.setEnabled(true);
                        jSpinner5.setEnabled(true);
                        jComboBox7.setEnabled(false);
                        
                        jLabel19.setVisible(true);
                        jLabel20.setVisible(true);
                        jSpinner5.setVisible(true);
                        
                    }
                    case "Được mượn theo tên thiết bị" -> {
                        jLabel18.setText("Từ ngày: ");
                        jSpinner3.setEnabled(false);
                        jSpinner5.setEnabled(false);
                        jComboBox7.setEnabled(true);
                        
                        jLabel19.setVisible(true);
                        jLabel20.setVisible(true);
                        jSpinner5.setVisible(true);
                        
                    }
                    default -> {
                        jLabel18.setText("Từ ngày: ");
                        jSpinner3.setEnabled(false);
                        jSpinner5.setEnabled(false);
                        jComboBox7.setEnabled(false);
                        
                        jLabel19.setVisible(true);
                        jLabel20.setVisible(true);
                        jSpinner5.setVisible(true);
                        
                    }
                }
            }
        });

        jComboBox9.setSelectedItem("--Chọn thống kê theo--");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ThongKeThanhVien_Btn = new javax.swing.JButton();
        Date dateT2 = new Date();

        SpinnerDateModel sm2 = new SpinnerDateModel(dateT2, null, null, Calendar.HOUR_OF_DAY);
        FromDate = new javax.swing.JSpinner(sm2);
        Date dateT4 = new Date();

        SpinnerDateModel sm4 = new SpinnerDateModel(dateT4, null, null, Calendar.HOUR_OF_DAY);
        ToDate = new javax.swing.JSpinner(sm4);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ThongKeThanhVien_Table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        ThongKeThietBi_Btn = new javax.swing.JButton();
        Date dateT3 = new Date();

        SpinnerDateModel sm3 = new SpinnerDateModel(dateT3, null, null, Calendar.HOUR_OF_DAY);
        jSpinner3 = new javax.swing.JSpinner(sm3);
        Date dateT5 = new Date();

        SpinnerDateModel sm5 = new SpinnerDateModel(dateT5, null, null, Calendar.HOUR_OF_DAY);
        jSpinner5 = new javax.swing.JSpinner(sm5);
        jScrollPane2 = new javax.swing.JScrollPane();
        ThongKeThietBi_Table = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        ThongKeViPham_Btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ThongKeViPham_Table = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(862, 690));
        setPreferredSize(new java.awt.Dimension(862, 690));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 113, 135));
        jLabel2.setText("Thống kê");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê sinh viên vào khu vực học tập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N
        jPanel4.setMaximumSize(new java.awt.Dimension(650, 32767));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Từ ngày:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Đến ngày:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Khoa:");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Ngành:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn thống kê theo--", "Theo ngày", "Theo khoa", "Theo ngành" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setText("Thống kê theo:");

        ThongKeThanhVien_Btn.setText("Thống kê");
        ThongKeThanhVien_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeThanhVien_BtnMouseClicked(evt);
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(FromDate, dateFormat.toPattern());

        de1.getTextField().setEditable(false);

        FromDate.setEditor(de1);

        JSpinner.DateEditor de4 = new JSpinner.DateEditor(ToDate, dateFormat.toPattern());

        de4.getTextField().setEditable(false);
        ToDate.setEditor(de4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FromDate)
                            .addComponent(ToDate))))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(53, 53, 53)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ThongKeThanhVien_Btn)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(ThongKeThanhVien_Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(FromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addComponent(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Số lượng sinh viên vào khu vực học tập:");

        ThongKeThanhVien_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thành viên", "Họ và tên", "Khoa", "Ngành", "Số điện thoại", "Email", "Thời gian vào"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ThongKeThanhVien_Table);
        if (ThongKeThanhVien_Table.getColumnModel().getColumnCount() > 0) {
            ThongKeThanhVien_Table.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("Danh sách:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8))
                    .addComponent(jLabel9)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thống kê thành viên", jPanel1);

        jPanel2.setBackground(java.awt.Color.white);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê thiết bị", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel18.setText("Từ ngày:");

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel19.setText("Đến ngày:");

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel20.setText("Tên:");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn thống kê theo--", "Đang được mượn", "Được mượn theo thời gian", "Được mượn theo tên thiết bị" }));

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel22.setText("Thống kê theo:");

        ThongKeThietBi_Btn.setText("Thống kê");
        ThongKeThietBi_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeThietBi_BtnMouseClicked(evt);
            }
        });

        JSpinner.DateEditor de3 = new JSpinner.DateEditor(jSpinner3, dateFormat.toPattern());

        de3.getTextField().setEditable(false);

        jSpinner3.setEditor(de3);

        JSpinner.DateEditor de5 = new JSpinner.DateEditor(jSpinner5, dateFormat.toPattern());

        de5.getTextField().setEditable(false);
        jSpinner5.setEditor(de5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBox9, 0, 209, Short.MAX_VALUE)
                        .addGap(284, 284, 284))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(jSpinner5))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(ThongKeThietBi_Btn)
                .addGap(9, 9, 9))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19))
                                    .addComponent(ThongKeThietBi_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel17))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        ThongKeThietBi_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "Mã thành viên mượn", "Họ tên", "Mô tả thiết bị", "Thời gian mượn", "Thời gian trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ThongKeThietBi_Table);

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel21.setText("Danh sách:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel6.getAccessibleContext().setAccessibleName("Thống kê thiết bị\n");

        jTabbedPane2.addTab("Thống kê thiết bị", jPanel2);

        jPanel3.setBackground(java.awt.Color.white);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê vi phạm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 14))); // NOI18N

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn thống kê theo--", "Đã được xử lý", "Đang xử lý" }));

        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel37.setText("Thống kê theo:");

        ThongKeViPham_Btn.setText("Thống kê");
        ThongKeViPham_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeViPham_BtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBox14, 0, 209, Short.MAX_VALUE)
                .addGap(376, 376, 376))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ThongKeViPham_Btn)
                .addGap(37, 37, 37))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33))
                .addGap(8, 8, 8)
                .addComponent(ThongKeViPham_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        ThongKeViPham_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã xử lý", "Mã thành viên", "Họ tên", "Hình thức", "Số tiền", "Ngày xử lý"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(ThongKeViPham_Table);

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel38.setText("Tổng tiền bồi thường:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addGap(33, 33, 33)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thống kê vi phạm", jPanel3);

        for (int i = 0; i < jTabbedPane2.getTabCount(); i++) {
            jTabbedPane2.setForegroundAt(i, new Color(0x647187)); // Set text color of tab headers
            jTabbedPane2.setBackgroundAt(i, Color.LIGHT_GRAY); // Set background color of tab headers
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThongKeThanhVien_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeThanhVien_BtnMouseClicked
        String choosen = (String) jComboBox3.getSelectedItem(); //Lấy kiểu thống kê (theo thời gian, khoa, ngành)
        switch (choosen) {
            case "Theo ngày" -> {
                Date selectedDate1 = (Date) FromDate.getValue();
                Date selectedDate2 = (Date) ToDate.getValue();
                if (selectedDate1 != null && selectedDate2 != null && selectedDate2.after(selectedDate1)) {
                    List<ThongTinSuDung> ls = thongTinSuDungBLL.getStatisticInfo(selectedDate1, selectedDate2);
                    if (ls != null) {
                        jLabel8.setText(ls.size() + "");
                        loadData(ls, ThongKeThanhVien_Table);
                    } else {
                        jLabel8.setText("0");
                        loadData(null, ThongKeThanhVien_Table);
                    }
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(selectedDate1);
                    calendar.add(Calendar.SECOND, 1); 
                    ToDate.setValue(calendar.getTime());
                    JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case "Theo khoa" -> {
                String khoa = (String) jComboBox1.getSelectedItem(); //Lấy lựa chọn khoa
                List<ThongTinSuDung> ls = thongTinSuDungBLL.getStatisticInfo("khoa", khoa);
                if (ls != null) {
                    jLabel8.setText(ls.size() + "");
                    loadData(ls, ThongKeThanhVien_Table);
                } else {
                    jLabel8.setText("0");
                    loadData(null, ThongKeThanhVien_Table);
                }
                break;
            }
            case "Theo ngành" -> {
                String nganh = (String) jComboBox2.getSelectedItem(); //Lấy lựa chọn ngành
                List<ThongTinSuDung> ls = thongTinSuDungBLL.getStatisticInfo("nganh", nganh);
                if (ls != null) {
                    jLabel8.setText(ls.size() + "");
                    loadData(ls, ThongKeThanhVien_Table);
                } else {
                    jLabel8.setText("0");
                    loadData(null, ThongKeThanhVien_Table);
                }
                break;
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Chọn kiểu thống kê!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_ThongKeThanhVien_BtnMouseClicked

    private void ThongKeThietBi_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeThietBi_BtnMouseClicked
        String choosen = (String) jComboBox9.getSelectedItem();
        switch (choosen) {
            case "Đang được mượn" -> {
                Date selectedDate = (Date) jSpinner3.getValue();
                if (selectedDate != null) {
                    List<ThongTinSuDung> ls = thongTinSuDungBLL.getStatisticInfo(selectedDate);
                    loadData2(ls, ThongKeThietBi_Table);
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn thời gian thống kê!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case "Được mượn theo thời gian" -> {
                Date selectedDate1 = (Date) jSpinner3.getValue();
                Date selectedDate2 = (Date) jSpinner5.getValue();
                if (selectedDate1 != null && selectedDate2 != null && selectedDate1.before(selectedDate2)) {
                    List<ThongTinSuDung> ls = thongTinSuDungBLL.getStatisticInfo(selectedDate1, selectedDate2, "thietbi");       
                    loadData2(ls, ThongKeThietBi_Table);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(selectedDate1);
                    calendar.add(Calendar.SECOND, 1); 
                    jSpinner5.setValue(calendar.getTime());
                    JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case "Được mượn theo tên thiết bị" -> {
                String tenTB = (String) jComboBox7.getSelectedItem();
                List<ThongTinSuDung> ls = thongTinSuDungBLL.getStatisticInfo(tenTB);
                loadData2(ls, ThongKeThietBi_Table);
                break;
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Chọn kiểu thống kê!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_ThongKeThietBi_BtnMouseClicked

    private void ThongKeViPham_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeViPham_BtnMouseClicked
        String choosen = (String) jComboBox14.getSelectedItem();
        switch (choosen) {
            case "Đã được xử lý" -> {
                loadData3(xuLyBLL.getListXuLyStatistic(1), ThongKeViPham_Table);
                jLabel34.setVisible(false);
                jLabel38.setVisible(false);
                break;
            }
            case "Đang xử lý" -> {
                loadData3(xuLyBLL.getListXuLyStatistic(0), ThongKeViPham_Table);
                jLabel34.setVisible(true);
                jLabel38.setVisible(true);          
                break;
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Chọn kiểu thống kê!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_ThongKeViPham_BtnMouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void loadData(List<ThongTinSuDung> list, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if (list != null) {
            for (ThongTinSuDung tv : list) {
                Object[] data = {tv.getThanhVien().getMaTV(), tv.getThanhVien().getHoTen(), tv.getThanhVien().getKhoa(), tv.getThanhVien().getNganh(), tv.getThanhVien().getSDT(), tv.getThanhVien().getEmail(), tv.getTGVao()};
                model.addRow(data);
            }
        }
    }

    private void loadData2(List<ThongTinSuDung> list, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        if (list != null) {
            for (ThongTinSuDung tv : list) {
                Object[] data = {tv.getThietBi().getMaTB(), tv.getThietBi().getTenTB(), tv.getThanhVien().getMaTV(), tv.getThanhVien().getHoTen(), tv.getThietBi().getMoTaTB(), tv.getTGMuon(), tv.getTGTra()};
                model.addRow(data);
            }
        }
    }
    
    private void loadData3(List<XuLy> list, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        double tong = 0;
        if (list != null) {
            for (XuLy tv : list) {
                Object[] data = {tv.getMaXL(),tv.getThanhVien().getMaTV(),tv.getThanhVien().getHoTen(),tv.getHinhThucXL(),tv.getSoTien(),tv.getNgayXL()};
                if(tv.getSoTien()!= null){
                    tong += tv.getSoTien();
                }
                model.addRow(data);
            }
        }
        jLabel34.setText(tong+"");
    }

    private void fillData(List<String> khoa, List<String> nganh, List<String> tenTB) {
        jComboBox1.removeAllItems();
        for (String i : khoa) {
            jComboBox1.addItem(i);
        }

        jComboBox2.removeAllItems();
        for (String i : nganh) {
            jComboBox2.addItem(i);
        }
        
        jComboBox7.removeAllItems();
        for (String i : tenTB){
            jComboBox7.addItem(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner FromDate;
    private javax.swing.JButton ThongKeThanhVien_Btn;
    private javax.swing.JTable ThongKeThanhVien_Table;
    private javax.swing.JButton ThongKeThietBi_Btn;
    private javax.swing.JTable ThongKeThietBi_Table;
    private javax.swing.JButton ThongKeViPham_Btn;
    private javax.swing.JTable ThongKeViPham_Table;
    private javax.swing.JSpinner ToDate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
