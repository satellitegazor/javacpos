package com.temp.pos.longterm.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.temp.pos.BaseLogonFrame;
import com.temp.pos.models.common.DailyExchRateMdl;
import com.temp.pos.longterm.models.LTCAbbrLocationModel;
import com.temp.pos.longterm.models.LTCVendorLocationsResultModel;
import com.temp.pos.longterm.models.LocationConfigModel;
import com.temp.pos.longterm.controllers.LTSaleController;
import com.temp.pos.longterm.models.SaleState;
import com.temp.pos.longterm.models.VLogonModel;
import com.temp.pos.longterm.models.VendorLoginResultsModel;
import com.temp.pos.services.CommonClient;
import com.temp.pos.services.LTCClient;
import com.temp.pos.utils.TimeZoneUtils;
import com.temp.pos.utils.WebApiConstants;
import com.temp.pos.utils.LongTerm.VendorDataCache;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class LTLogonFrame extends JFrame implements BaseLogonFrame {
    private static final Logger logger = LoggerFactory.getLogger(LTLogonFrame.class);
    private JTextField exchangeNumberField, vendorNumberField;
    private JComboBox<String> locationComboBox;
    private JPasswordField pinField;
    private JLabel statusLabel;
    
    private String userId;
    private static final String CREDENTIALS_FILE = "cpos.cfg";

    public LTLogonFrame(String vendorNumber, String pin) {
        setTitle("Concession POS - LT Module Sign-in");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setLayout(new BorderLayout(20, 20));

        // Set larger font for all components
        Font largeFont = new Font("Arial", Font.BOLD, 24);
        Font buttonFont = new Font("Arial", Font.BOLD, 28);

        // Header panel with Logout and Login labels
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        JLabel logoutLabel = new JLabel("Logout");
        logoutLabel.setFont(largeFont);
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(largeFont);
        headerPanel.add(logoutLabel);
        headerPanel.add(loginLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main panel for input fields
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased spacing for touch
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Exchange label
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel exchangeLabel = new JLabel("Exchange");
        exchangeLabel.setFont(largeFont);
        mainPanel.add(exchangeLabel, gbc);
        gbc.gridx = 1;
        exchangeNumberField = new JTextField(vendorNumber, 20);
        exchangeNumberField.setFont(largeFont);
        exchangeNumberField.setPreferredSize(new Dimension(300, 40));
        // Add 4-character limit and numeric-only restriction to exchangeNumberField
        ((AbstractDocument) exchangeNumberField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private boolean isNumeric(String text) {
                return text.matches("\\d*"); // Only digits (0-9) allowed
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if (newText.length() <= 4 && isNumeric(newText)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
                if (newText.length() <= 4 && isNumeric(newText)) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
        mainPanel.add(exchangeNumberField, gbc);

        // Vendor Number
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel vendorLabel = new JLabel("Vendor Number");
        vendorLabel.setFont(largeFont);
        mainPanel.add(vendorLabel, gbc);
        gbc.gridx = 1;
        vendorNumberField = new JTextField(vendorNumber, 20);
        vendorNumberField.setFont(largeFont);
        vendorNumberField.setPreferredSize(new Dimension(300, 40));
        // Add 8-character limit and numeric-only restriction to vendorNumberField
        ((AbstractDocument) vendorNumberField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private boolean isNumeric(String text) {
                return text.matches("\\d*"); // Only digits (0-9) allowed
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if (newText.length() <= 8 && isNumeric(newText)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + string + currentText.substring(offset);
                if (newText.length() <= 8 && isNumeric(newText)) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
        mainPanel.add(vendorNumberField, gbc);

        // Location
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setFont(largeFont);
        mainPanel.add(locationLabel, gbc);
        gbc.gridx = 1;
        locationComboBox = new JComboBox();
        locationComboBox.setFont(largeFont);
        locationComboBox.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(locationComboBox, gbc);

        // PIN
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(largeFont);
        mainPanel.add(pinLabel, gbc);
        gbc.gridx = 1;
        pinField = new JPasswordField(pin, 20);
        pinField.setFont(largeFont);
        pinField.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(pinField, gbc);

        // Logon button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton logonButton = new JButton("Logon");
        logonButton.setFont(buttonFont);
        logonButton.setPreferredSize(new Dimension(200, 60));
        mainPanel.add(logonButton, gbc);

        // Status label
        gbc.gridx = 0;
        gbc.gridy = 5;
        statusLabel = new JLabel("");
        statusLabel.setFont(largeFont);
        statusLabel.setForeground(Color.RED);
        
        mainPanel.add(statusLabel, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Add DocumentListener for exchangeNumberField and vendorNumberField
        DocumentListener fieldChangeListener;
        fieldChangeListener = new DocumentListener() {
            private void checkFields() {
                String exchangeText = exchangeNumberField.getText();
                String vendorText = vendorNumberField.getText();
                if (exchangeText.matches("\\d{4}") && vendorText.matches("\\d{8}")) {
                    SwingUtilities.invokeLater(() -> {
                        try {
                            CommonClient webCli = new CommonClient();
                            // Call CommonClient.getVendorLocations with exchangeNumber and vendorNumber
                            LTCVendorLocationsResultModel results = webCli.getVendorLocations(exchangeText, vendorText, "100", TimeZoneUtils.getSystemTimezoneOffsetFromCentralTime());
                            VendorDataCache.getInstance().storeLocations(results.getLocations());

                            // Parse JSON response
                            //JSONObject json = new JSONObject(jsonResponse);
                            //JSONArray locations = json.getJSONObject("results").getJSONArray("locations");
                            // Clear existing items in locationComboBox
                            locationComboBox.removeAllItems();
                            
                            // Add facility names to locationComboBox
                            //foreach(LTCAbbrLocationModel loc in )
                            results.getLocations().forEach(loc -> {
                                System.out.println("Adding location: " + loc.getFacilityName());
                                locationComboBox.addItem(loc.getFacilityName());
                                        });
                            

                            // Select first item if available
                            if (locationComboBox.getItemCount() > 0) {
                                locationComboBox.setSelectedIndex(0);
                            }
                            
                            
                        } catch (Exception e) {
                            statusLabel.setForeground(Color.RED);
                            statusLabel.setText("Error fetching locations: \n" + e.getMessage());
                            System.out.println(e.getMessage() + "\n" );
                            e.printStackTrace();
                        }
                    });
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }
        };

        exchangeNumberField.getDocument().addDocumentListener(fieldChangeListener);
        vendorNumberField.getDocument().addDocumentListener(fieldChangeListener);

        // Logon button action
        logonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPin = new String(pinField.getPassword());
                String inputVendorNumber = vendorNumberField.getText();
                String location = (String) locationComboBox.getSelectedItem();

                LTCAbbrLocationModel locs = VendorDataCache.getInstance().getLocations().stream()
                        .filter(loc -> loc.getFacilityName().equals(location))
                        .findFirst()
                        .orElse(null);

                CommonClient webCli = new CommonClient();
                VLogonModel vModel = new VLogonModel();
                vModel.setCliTimeVar(TimeZoneUtils.getSystemTimezoneOffsetFromCentralTime());
                vModel.setPin(inputPin);
                vModel.setVendorNumber(inputVendorNumber);
                vModel.setExchangeNumber(exchangeNumberField.getText());
                vModel.setGuid(WebApiConstants.postGuid);
                vModel.setLocationUID(locs != null ? locs.getLocationUID() : 0);
                vModel.setFacilityNumber(Integer.toString(locs != null ? locs.getLocationUID() : 0));
                vModel.setFacilityName(locs.getFacilityName());
                vModel.setContractType(true);
                
                ObjectMapper mapper = new ObjectMapper();
                try {
                    
                    String jsonString = mapper.writeValueAsString(vModel);
                    logger.info("VLogonModel JSON: " + jsonString);
                } catch (JsonProcessingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    logger.error("Error serializing VLogonModel: ", e1);
                }

                VendorLoginResultsModel logonRslt = webCli.valPin(vModel);
                String jString;
                try {
                    saveCredentials(inputVendorNumber, exchangeNumberField.getText(), (String)locationComboBox.getSelectedItem());
                    jString = mapper.writeValueAsString(logonRslt);
                    logger.info("VendorLoginResultsModel JSON: " + jString);
                    System.out.println(jString);
                    
                } catch (JsonProcessingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
                if (logonRslt.isAuthorized() && !inputVendorNumber.isEmpty() && location != null) {
                    VendorDataCache.getInstance().storeLoginResult(logonRslt);
                    
                    userId = String.valueOf(logonRslt.individualUID);
                    
                    LTCClient ltcCli = new LTCClient();
                    try {
                        LocationConfigModel locCnfg = ltcCli.getLocationConfigs(logonRslt.getIndividualUID(), locs.getLocationUID(), 0);
                        VendorDataCache.getInstance().storeLocationConfig(locCnfg);
                        
                        DailyExchRateMdl rate = ltcCli.getDailyExchRate(locs.getLocationUID(), TimeZoneUtils.getTodayBusinessDate(), String.valueOf(logonRslt.getIndividualUID()));
                        if (rate != null) {
                            VendorDataCache.getInstance().storeDailyExchRate(rate);
                        }
                    } catch (Exception ex) {
                        logger.error("Error fetching daily exchange rate: ", ex);
                    }
                    statusLabel.setForeground(Color.GREEN);
                    statusLabel.setText("Success! Your message has been sent successfully.");
                    SwingUtilities.invokeLater(() -> {
                        //JFrame saleTranFrame = getSaleTranFrame();
                        //saleTranFrame.setVisible(true);

                        //dispose();
                    });
                } else {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Error! Unable to login. Please verify the credentials entered.");
                }
            }
        });
        
        loadCredentials();
//        SwingUtilities.invokeLater(() -> {
//            pinField.requestFocusInWindow();
//        });
        
    }

    public LTLogonFrame() {
        this("", "");
    }

    @Override
    public JFrame getSaleTranFrame() {
//        SaleView view1 = new SaleView() {
//            @Override
//            public void updateBilling(SaleState state) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void updateItems(java.util.List<?> items) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void showMessage(String message) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void clearAll() {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void setStatus(String status) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        };
        LTSaleTranView view = new LTSaleTranView(this);
        LTSaleController controller = new LTSaleController();
        controller.setView(view);
        CommonClient comClient = new CommonClient();
        return new LTSaleTranFrame(userId, controller);
    }
    
    private void saveCredentials(String vendorNumber, String ExchNum, String LocationName) {
        
        try (FileWriter writer = new FileWriter(CREDENTIALS_FILE)) {
            writer.write("vendor=" + vendorNumber + "\n");
            writer.write("exch=" + ExchNum + "\n");
            writer.write("location=" + LocationName + "\n");
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving credentials: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCredentials() {
        File file = new File(CREDENTIALS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("vendor=")) {
                        vendorNumberField.setText(line.substring("vendor=".length()));
                    } else if (line.startsWith("exch=")) {
                        exchangeNumberField.setText(line.substring("exch=".length()));                        
                    }
                    else if (line.startsWith("location=")) {
                        locationComboBox.setSelectedItem(line.substring("location=".length()));
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading credentials: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}