package com.heiha.sinfonia.example.util;

/**
 * <br>
 * <b>Project:</b> example<br>
 * <b>Date:</b> 2017/9/1 10:44<br>
 * <b>Author:</b> heiha<br>
 */
public class JSON {
    private static final String REGEX_KEY = "\"\"";
    private static final String REGEX = "\\[\\]";


    /**
     * TODO 基本格式合法则合法，因此涉及递归调用
     * @param json
     * @return
     */
    public static String prettify(String json) {
        if (json == null)
            JsonError.ERROR0.error(0, 0, "");
        char[] jsonArray = json.trim().toCharArray();
        if (jsonArray.length == 0)
            JsonError.ERROR0.error(0, 0, "");
        int start = 0;
        int end = jsonArray.length - 1;
        StringBuffer prefix = new StringBuffer();
        StringBuffer suffix = new StringBuffer();

        while (start < end) {
            prefix.append(jsonArray[start++]);
            suffix.append(jsonArray[end--]);
        }
        return prefix.append(suffix.reverse()).toString();
    }

    public static void validate(char[] json) {

    }

    private static boolean validateKey() {
        return true;
    }

    private static boolean validateValue() {
        return true;
    }

    private static boolean validatePair(String pair) {
        String[] pairs = pair.split(":");
        return false;

    }

    public static void main(String[] args) {
        System.out.println(JSON.prettify("{}"));
    }
}
