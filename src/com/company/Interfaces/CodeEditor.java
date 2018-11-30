package com.company.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class CodeEditor extends JTextPane {
    public CodeEditor(String text) {
        super();
        setText(text);
        try {
            // String filePath = "Resources/DejaVuSansMono.ttf";
            // URL url = this.getClass().getResource(filePath);
            // File file = new File(url.toURI());
            //  Font monospaced = Font.createFont(Font.TRUETYPE_FONT, file);

            Font f = new Font("DejaVu Sans Mono", Font.TRUETYPE_FONT, 16);
            setFont(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
      //  Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
    }
}
