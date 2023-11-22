package com.alibaba.ariver.app.api.mtop;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class SendMtopResponse implements Serializable {
    public byte[] data;
    public String errorCode;
    public String errorMsg;
    public Map<String, List<String>> headers;
    public boolean success;
}
