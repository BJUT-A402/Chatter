package Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyRenderer extends DefaultListCellRenderer {
    private Color colorOnline;
    private Color colorOffline;
    private ArrayList<Integer> rowOnline = new ArrayList<>();
    private ArrayList<Integer> rowOffline = new ArrayList<>();

    public MyRenderer(boolean[] rows, Color colorOnline, Color colorOffline) {
        this.colorOnline = colorOnline;
        this.colorOffline = colorOffline;
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                rowOnline.add(i);
            }
            else {
                rowOffline.add(i);
            }
        }
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        for (int i = 0; i < rowOnline.size(); i++) {
            if (index == rowOnline.get(i)) {
                setBackground(this.colorOnline);
            }
        }
        for (int i = 0; i < rowOffline.size(); i++) {
            if (index == rowOffline.get(i)) {
                setBackground(this.colorOffline);
            }
        }

        return this;
    }
}
