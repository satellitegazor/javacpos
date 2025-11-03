package com.temp.pos;

import com.formdev.flatlaf.*;
import com.temp.pos.sbm.SBMLogonFrame;
import com.temp.pos.views.longterm.LTLogonFrame;
import com.temp.pos.views.shortterm.STLogonFrame;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
	String module = args.length > 0 ? args[0] : "";
        //FlatLightLaf.setup();
        FlatIntelliJLaf.setup();
        SwingUtilities.invokeLater(new RunnableImpl(module));
    }

    private static class RunnableImpl implements Runnable {

        
        private final String module;

        public RunnableImpl(String module) {
            this.module = module;
        }

        @Override
        public void run() {
            switch (module) {
                case "-lt" -> {
                    LTLogonFrame longTermFrame = new LTLogonFrame();
                    longTermFrame.setVisible(true);
                }
                case "-st" -> {
                    STLogonFrame shortTermFrame = new STLogonFrame();
                    shortTermFrame.setVisible(true);
                }
                case "-sbm" -> {
                    SBMLogonFrame sbmFrame = new SBMLogonFrame();
                    sbmFrame.setVisible(true);
                }
                default -> {
                    JOptionPane.showMessageDialog(null,
                            "Invalid or missing module argument. Use -lt, -st, or -sbm.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        }
    }
}