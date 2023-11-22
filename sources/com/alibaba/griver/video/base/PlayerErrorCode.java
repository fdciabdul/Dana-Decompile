package com.alibaba.griver.video.base;

/* loaded from: classes6.dex */
public enum PlayerErrorCode {
    MEDIA_ERROR_UNKNOWN(1, "Unknown error"),
    MEDIA_ERROR_PLAYER_INTERNAL_ERROR(1002, "Media Player internal error"),
    MEDIA_ERROR_IO(1005, "Network error"),
    MEDIA_ERROR_PLAYER_SOURCE_ERROR(1006, "Source url error"),
    MEDIA_ERROR_PLAYER_PREPARE_ERROR(1007, "Media Player prepare error"),
    MEDIA_ERROR_MALFORMED(3002, "Video rendering error"),
    MEDIA_ERROR_UNSUPPORTED(3001, "Video decoding error");

    private int code;
    private String msg;

    PlayerErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }
}
