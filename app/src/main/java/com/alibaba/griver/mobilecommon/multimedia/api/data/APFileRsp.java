package com.alibaba.griver.mobilecommon.multimedia.api.data;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class APFileRsp {
    public static final int CODE_ERR_AUTH_FAIL = -403;
    public static final int CODE_ERR_CURRENT_LIMITED = 2000;
    public static final int CODE_ERR_ENCRYPT_FAIL = 13;
    public static final int CODE_ERR_EXCEPTION = 1;
    public static final int CODE_ERR_FILE_ID_NOT_EXIST = 11;
    public static final int CODE_ERR_FILE_MD5_WRONG = 4;
    public static final int CODE_ERR_FILE_SIZE_WRONG = 6;
    public static final int CODE_ERR_FILE_SIZE_ZERO = 3;
    public static final int CODE_ERR_NETWORK_ERR = 10;
    public static final int CODE_ERR_NO_NETWORK = 9;
    public static final int CODE_ERR_PATH_EMPTY = 7;
    public static final int CODE_ERR_RSP_NULL = 2;
    public static final int CODE_ERR_SPACE_NOT_ENOUGH = 12;
    public static final int CODE_ERR_TASK_CANCELED = 5;
    public static final int CODE_ERR_TIMEOUT = 14;
    public static final int CODE_ERR_VIEW_REUSED = 8;
    public static final int CODE_SUCCESS = 0;
    private HashMap<String, String> extra;
    private APFileReq fileReq;
    private String msg;
    private int retCode;
    private String traceId;

    public int getRetCode() {
        return this.retCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public APFileReq getFileReq() {
        return this.fileReq;
    }

    public void setFileReq(APFileReq aPFileReq) {
        this.fileReq = aPFileReq;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APFileRsp {fileReq='");
        sb.append(this.fileReq);
        sb.append('\'');
        sb.append(", retCode=");
        sb.append(this.retCode);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append('}');
        return sb.toString();
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void addExtra(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.extra == null) {
            this.extra = new HashMap<>();
        }
        this.extra.put(str, str2);
    }

    public String getExtra(String str) {
        if (this.extra == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.extra.get(str);
    }

    public HashMap<String, String> getExtra() {
        return this.extra;
    }
}
