package com.xuqian.mapp.util;

import java.util.ArrayList;

/**
 * Created by xuqian on 2015/8/17.
 */
public class JsonFormatUtil {

    /**
     *
     * @param json
     * @param fillStringUint
     * @return
     */
    public static String formatJson(String json, String fillStringUint) {
        if (json == null || json.trim().length() == 0) {
            return null;
        }
        int fixedLenth = 0;
        ArrayList<String> tokenList = new ArrayList<>();
        {
            String jsonTemp = json;
            //预读取
            while (jsonTemp.length() > 0) {
                String token = getToken(jsonTemp);
                jsonTemp = jsonTemp.substring(token.length());
                token = token.trim();
                tokenList.add(token);
            }
        }

        for (int i = 0; i<tokenList.size(); i++) {
            String token = tokenList.get(i);
            int length = token.getBytes().length;
            if (length > fixedLenth && i< tokenList.size() - 1 && tokenList.get(i + 1).equals(":")) {
                fixedLenth = length;
            }
        }

        StringBuilder buf = new StringBuilder();
        int count = 0;
        for (int i= 0; i < tokenList.size(); i++) {
            String token = tokenList.get(i);
            if (token.equals(",")) {
                buf.append(token);
                doFill(buf, count, fillStringUint);
                continue;
            }
            if (token.equals(":")) {
                buf.append("").append(token).append(" ");
                continue;
            }
            if (token.equals("{")) {
                String nextToken = tokenList.get(i + 1);
                if (nextToken.equals("}")) {
                    i++;
                    buf.append("{ }");
                } else {
                    count++;
                    buf.append(token);
                    doFill(buf, count, fillStringUint);
                }
                continue;
            }
            if (token.equals("}")) {
                count--;
                doFill(buf, count, fillStringUint);
                buf.append(token);
                continue;
            }

        }
        return buf.toString();
    }

    /**
     *
     * @param json
     * @return
     */
    public static String getToken(String json) {
        StringBuilder buf = new StringBuilder();
        boolean isInYinHao = false;
        while (json.length() > 0) {
            String token = json.substring(0, 1);
            json = json.substring(1);
        }

        return buf.toString();
    }

    /**
     *
     * @param buf
     * @param count
     * @param fillStringUnit
     */
    private static void doFill(StringBuilder buf, int count, String fillStringUnit) {
            buf.append("\n");
            for (int i = 0; i < count; i++) {
                buf.append(fillStringUnit);
            }
    }
}
