package Utils;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CError {
    public static final int SUCCESS = 0;

    // �û���������
    public static final int ID_NOT_FOUND = 10001;
    public static final int WRONG_PASSWORD = 10002;
    public static final int ID_EXISTED = 10003;

    // ϵͳ�߼����� --- һ����ERROR��β
    public static final int CONNECT_ERROR = 20001;
    public static final int OPEN_URL_ERROR = 20002;
    public static final int MYSQL_OPERATION_ERROR = 20003;
    public static final int SEND_MESSAGE_ERROR = 20004;

    private static Map<Integer, String> map = new HashMap<>();

    private static void initEECError() {
        map.put(ID_NOT_FOUND, "�û���������");
        map.put(WRONG_PASSWORD, "�������");
        map.put(ID_EXISTED, "�û����Ѵ���");

        map.put(CONNECT_ERROR, "����������ʧ�ܣ�");
        map.put(OPEN_URL_ERROR, "�����������ʧ�ܣ�");
        map.put(MYSQL_OPERATION_ERROR, "���ݿ����ʧ�ܣ�");
        map.put(SEND_MESSAGE_ERROR, "������Ϣʧ�ܣ�");
    }

    /**
     * ע�⣺�����ڿ��ܵ��ñ��������к��������ķ�����Ӧ����errorCode����Form������֧����
     */
    public static void error(int errorCode) {
        if (map.isEmpty())
            initEECError();

        if (errorCode == CONNECT_ERROR) {
            System.exit(1);
        }

        JOptionPane.showMessageDialog(null, map.get(errorCode), "������룺" + errorCode, JOptionPane.WARNING_MESSAGE);
    }
}

