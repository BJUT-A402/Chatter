package ui;

import javax.swing.*;
import java.awt.*;


public class FormChatRecord extends Form {

    public FormChatRecord() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ChatRecord = new JFrame();
        spChatRecord = new JScrollPane();
        tpChatRecord = new JTextPane();

        //======== ChatRecord ========
        {
            ChatRecord.setTitle("\u804a\u5929\u8bb0\u5f55");
            ChatRecord.setResizable(false);
            ChatRecord.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container ChatRecordContentPane = ChatRecord.getContentPane();

            //======== spChatRecord ========
            {

                //---- tpChatRecord ----
                tpChatRecord.setEditable(false);
                tpChatRecord.setFocusable(false);
                spChatRecord.setViewportView(tpChatRecord);
            }

            GroupLayout ChatRecordContentPaneLayout = new GroupLayout(ChatRecordContentPane);
            ChatRecordContentPane.setLayout(ChatRecordContentPaneLayout);
            ChatRecordContentPaneLayout.setHorizontalGroup(
                    ChatRecordContentPaneLayout.createParallelGroup()
                            .addComponent(spChatRecord, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            );
            ChatRecordContentPaneLayout.setVerticalGroup(
                    ChatRecordContentPaneLayout.createParallelGroup()
                            .addComponent(spChatRecord, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            );
            ChatRecord.pack();
            ChatRecord.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame ChatRecord;
    private JScrollPane spChatRecord;
    private JTextPane tpChatRecord;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
