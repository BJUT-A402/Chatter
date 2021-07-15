package Utils;

import javax.swing.*;
import java.awt.*;

public class MyRenderer extends DefaultListCellRenderer {
    private Color rowColor;
    private int row;
    private int[] rows;

    public MyRenderer(int row, Color color) {
        this.rowColor = color;
        this.row = row;
    }

    public MyRenderer(int[] rows, Color color) {
        this.rowColor = color;
        this.rows = rows;
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (rows == null) {
            if (index == row) {
                setBackground(this.rowColor);
            }
        } else {
            for (int i = 0; i < rows.length; i++) {
                if (index == rows[i]) {
                    setBackground(this.rowColor);
                }
            }
        }
        return this;
    }
}
