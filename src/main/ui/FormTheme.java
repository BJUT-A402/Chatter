package ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FormTheme extends Form {
    public static String[] themes = {
            "Light",
            "Intellij",
            "Arc",
            "Arc - Orange",
            "Cyan Light",
            "Gray",
            "Light Flat - Intellij",
            "Carbon",
            "Atom One Light",
            "Github",
            "Light Owl",
            "Material Lighter",
            "Github Dark",
            "Dark",
            "Dracula - Intellij"
    };

    public FormTheme() {
        initComponents();
    }

    private void listThemesMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            String item = listThemes.getSelectedValue().toString();
            if (item.equals(themes[0]))
                FlatLightLaf.setup();
            else if (item.equals(themes[1]))
                FlatIntelliJLaf.setup();
            else if (item.equals(themes[2]))
                FlatArcIJTheme.setup();
            else if (item.equals(themes[3]))
                FlatArcDarkOrangeIJTheme.setup();
            else if (item.equals(themes[4]))
                FlatCyanLightIJTheme.setup();
            else if (item.equals(themes[5]))
                FlatGrayIJTheme.setup();
            else if (item.equals(themes[6]))
                FlatLightFlatIJTheme.setup();
            else if (item.equals(themes[7]))
                FlatCarbonIJTheme.setup();
            else if (item.equals(themes[8]))
                FlatAtomOneLightIJTheme.setup();
            else if (item.equals(themes[9]))
                FlatGitHubIJTheme.setup();
            else if (item.equals(themes[10]))
                FlatLightOwlIJTheme.setup();
            else if (item.equals(themes[11]))
                FlatMaterialLighterIJTheme.setup();
            else if (item.equals(themes[12]))
                FlatGitHubDarkIJTheme.setup();
            else if (item.equals(themes[13]))
                FlatDarkLaf.setup();
            else if (item.equals(themes[14]))
                FlatDraculaIJTheme.setup();
            FlatLaf.updateUI();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Theme = new JFrame();
        spTheme = new JScrollPane();
        listThemes = new JList();

        //======== Theme ========
        {
            Theme.setTitle("\u9009\u62e9\u4e3b\u9898");
            Theme.setResizable(false);
            Theme.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container ThemeContentPane = Theme.getContentPane();

            //======== spTheme ========
            {

                //---- listThemes ----
                listThemes.setModel(new AbstractListModel<String>() {
                    String[] values = themes;

                    @Override
                    public int getSize() {
                        return this.values.length;
                    }

                    @Override
                    public String getElementAt(int i) {
                        return this.values[i];
                    }
                });
                listThemes.setFocusable(false);
                listThemes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        listThemesMouseClicked(e);
                    }
                });
                spTheme.setViewportView(listThemes);
            }

            GroupLayout ThemeContentPaneLayout = new GroupLayout(ThemeContentPane);
            ThemeContentPane.setLayout(ThemeContentPaneLayout);
            ThemeContentPaneLayout.setHorizontalGroup(
                    ThemeContentPaneLayout.createParallelGroup()
                            .addComponent(spTheme, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
            );
            ThemeContentPaneLayout.setVerticalGroup(
                    ThemeContentPaneLayout.createParallelGroup()
                            .addComponent(spTheme, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            );
            Theme.pack();
            Theme.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Theme;
    private JScrollPane spTheme;
    private JList listThemes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
