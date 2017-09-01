package com.heiha.sinfonia.example.util;

/**
 * <br>
 * <b>Project:</b> example<br>
 * <b>Date:</b> 2017/9/1 11:29<br>
 * <b>Author:</b> heiha<br>
 */
public enum JsonError {
    ERROR0("") {
        @Override
        public void error(Integer row, Integer col, String line) {
            error(row, col, line, ERROR_0_EXPECT);
        }
    };

    private static final String ERROR_0_EXPECT = "'{', '['";

    private String comment;

    JsonError(String comment) {
        this.comment = comment;
    }

    public String comment() {
        return comment;
    }

    public abstract void error(Integer row, Integer col, String line);

    static void error(Integer row, Integer col, String line, String expect) {
        StringBuffer sb = new StringBuffer();
        sb.append("Parse error on line ").append(row).append(":").append("\n");
        sb.append(line).append("\n");
        for (int i = 0; i < col; i++) {
            sb.append(" ");
        }
        sb.append("^").append("\n");
        sb.append("Expecting ").append(expect);
        throw new RuntimeException(sb.toString());
    }
}
