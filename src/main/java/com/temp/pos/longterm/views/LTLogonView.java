package com.temp.pos.longterm.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.temp.pos.longterm.models.LTCAbbrLocationModel;
import com.temp.pos.longterm.models.LTCVendorLocationsResultModel;
import com.temp.pos.longterm.models.LocationConfigModel;
import com.temp.pos.longterm.models.VLogonModel;
import com.temp.pos.longterm.models.VendorLoginResultsModel;
import com.temp.pos.models.common.DailyExchRateMdl;
import com.temp.pos.services.CommonClient;
import com.temp.pos.services.LTCClient;
import com.temp.pos.utils.LongTerm.VendorDataCache;
import com.temp.pos.utils.TimeZoneUtils;
import com.temp.pos.utils.WebApiConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LTLogonView extends JPanel {
    private static final Logger logger = LoggerFactory.getLogger(LTLogonView.class);
    private JTextField exchangeNumberField, vendorNumberField;
    private JComboBox<String> locationComboBox;
    private JPasswordField pinField;
    private JLabel statusLabel;

    private String userId;
    private static final String CREDENTIALS_FILE = "cpos.cfg";

    private LTConcessionsFrame _parent;

    public LTLogonView(LTConcessionsFrame parent) {
        _parent = parent;

        setLayout(new BorderLayout(20, 20));
        setBackground(Color.WHITE);

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
        exchangeNumberField = new JTextField("", 20);
        exchangeNumberField.setFont(largeFont);
        exchangeNumberField.setPreferredSize(new Dimension(300, 40));
        // Add 4-character limit and numeric-only restriction to exchangeNumberField
        ((AbstractDocument) exchangeNumberField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private boolean isNumeric(String text) {
                return text.matches("\\d*"); // Only digits (0-9)
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + (text == null ? "" : text);
                newStr = newStr.replaceAll("\\D", ""); // Remove non-digits
                if (newStr.length() <= 4 && isNumeric(newStr)) {
                    super.replace(fb, offset, length, text, attrs);
                    fetchVendorLocationDetails(newStr);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                string = string.replaceAll("\\D", ""); // Remove non-digits
                super.insertString(fb, offset, string, attr);
                fetchVendorLocationDetails(fb.getDocument().getText(0, fb.getDocument().getLength()));
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
                fetchVendorLocationDetails(fb.getDocument().getText(0, fb.getDocument().getLength()));
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
        vendorNumberField = new JTextField("", 20);
        vendorNumberField.setFont(largeFont);
        vendorNumberField.setPreferredSize(new Dimension(300, 40));
        vendorNumberField.setEditable(false);
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
        locationComboBox = new JComboBox<>();
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
        pinField = new JPasswordField("", 20);
        pinField.setFont(largeFont);
        pinField.setPreferredSize(new Dimension(300, 40));
        pinField.setEchoChar('*');
        pinField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (pinField.getPassword().length == 4) {
                    performLogin();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        mainPanel.add(pinField, gbc);

        // Logon button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton logonButton = new JButton("Logon");
        logonButton.setFont(buttonFont);
        logonButton.setPreferredSize(new Dimension(200, 60));
        mainPanel.add(logonButton, gbc);


        // Status
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        statusLabel = new JLabel("");
        statusLabel.setFont(largeFont);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(statusLabel, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Add DocumentListener for exchangeNumberField and vendorNumberField
        DocumentListener fieldChangeListener;
        fieldChangeListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

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
                            System.out.println(e.getMessage() + "\n");
                            e.printStackTrace();
                        }
                    });
                }
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
                    saveCredentials(inputVendorNumber, exchangeNumberField.getText(), (String) locationComboBox.getSelectedItem());
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
//                        JFrame saleTranFrame = getSaleTranFrame();
//                        saleTranFrame.setVisible(true);
//                        dispose();
                        parent.onLoginSuccess(userId);
                    });
                } else {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Error! Unable to login. Please verify the credentials entered.");
                }
            }
        });


        loadCredentials();
        SwingUtilities.invokeLater(() -> pinField.requestFocusInWindow());
    }

    private void fetchVendorLocationDetails(String exchNum) {
        if (exchNum.length() == 4) {
            try {
                String exchangeText = exchangeNumberField.getText();
                String vendorText = vendorNumberField.getText();

                LTCVendorLocationsResultModel result = new LTCClient().getVendorLocations(vendorText, "100", TimeZoneUtils.getSystemTimezoneOffsetFromCentralTime());
                if (result.getLocations().isEmpty()) {
                    statusLabel.setText("No locations found for exchange number");
                    locationComboBox.setModel(new DefaultComboBoxModel<>());
                    return;
                }

                List<String> locationNames = result.getLocations().stream()
                        .map(LTCAbbrLocationModel::getFacilityName)
                        .collect(Collectors.toList());
                locationComboBox.setModel(new DefaultComboBoxModel<>(locationNames.toArray(new String[0])));
                locationComboBox.setSelectedIndex(0);

                LTCAbbrLocationModel selected = result.getLocations().get(0);
                vendorNumberField.setText(vendorText);
                vendorNumberField.setEditable(false);

            } catch (Exception e) {
                logger.error("Error fetching vendor locations: {}", e.getMessage(), e);
                statusLabel.setText("Error fetching locations");
            }
        }
    }

    private void performLogin() {
        String vendorNumber = vendorNumberField.getText();
        String pin = new String(pinField.getPassword());

        if (vendorNumber.isEmpty() || pin.isEmpty()) {
            statusLabel.setText("Enter Vendor Number and PIN");
            return;
        }

        try {

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
                saveCredentials(inputVendorNumber, exchangeNumberField.getText(), (String) locationComboBox.getSelectedItem());
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
            } else {
                statusLabel.setForeground(Color.RED);
                statusLabel.setText("Error! Unable to login. Please verify the credentials entered.");
            }
            statusLabel.setForeground(Color.GREEN);
            statusLabel.setText("Success! Your message has been sent successfully.");

            String exchangeNum = exchangeNumberField.getText();
            String locationName = (String) locationComboBox.getSelectedItem();
            saveCredentials(vendorNumber, exchangeNum, locationName);

            LocationConfigModel config = VendorDataCache.getInstance().getLocationConfig(userId);
            VendorDataCache.getInstance().storeDailyExchRate(new DailyExchRateMdl());

            SwingUtilities.invokeLater(() -> {
                _parent.onLoginSuccess(userId);
            });


            // Callback to show sale panel
            //onLoginSuccess.run();

        } catch (Exception e) {
            logger.error("Login error: {}", e.getMessage(), e);
            statusLabel.setText("Unable to login. Please verify credentials.");
        }
    }

    private void saveCredentials(String vendorNumber, String exchNum, String locationName) {
        try (FileWriter writer = new FileWriter(CREDENTIALS_FILE)) {
            writer.write("vendor=" + vendorNumber + "\n");
            writer.write("exch=" + exchNum + "\n");
            writer.write("location=" + locationName + "\n");
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
                    } else if (line.startsWith("location=")) {
                        locationComboBox.setSelectedItem(line.substring("location=".length()));
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading credentials: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}