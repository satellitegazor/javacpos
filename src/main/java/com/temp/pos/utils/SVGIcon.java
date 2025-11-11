// src/main/java/com/temp/pos/utils/SVGIcon.java
package com.temp.pos.utils;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class SVGIcon {
    public static Icon load(String resourcePath, int width, int height) {
        try (InputStream is = SVGIcon.class.getResourceAsStream("/icons/" + resourcePath)) {
            if (is == null) return new ImageIcon();

            PNGTranscoder t = new PNGTranscoder();
            t.addTranscodingHint(PNGTranscoder.KEY_WIDTH, (float) width);
            t.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, (float) height);

            TranscoderInput input = new TranscoderInput(is);
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            org.apache.batik.transcoder.TranscoderOutput output = new org.apache.batik.transcoder.TranscoderOutput(baos);
            t.transcode(input, output);

            byte[] imgData = baos.toByteArray();
            BufferedImage img = javax.imageio.ImageIO.read(new java.io.ByteArrayInputStream(imgData));
            return new ImageIcon(img);
        } catch (Exception e) {
            return new ImageIcon();
        }
    }
}