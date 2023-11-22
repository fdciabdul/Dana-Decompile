package com.alibaba.griver.core.model.amcs;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class AMCSConfigRpcResult implements Serializable {
    public List<String> deleteKeys;
    public String errorCode;
    public String errorMessage;
    public Map<String, String> extendInfo;
    public boolean increment;
    public String responseTime;
    public boolean success;
    public Map<String, AMCSConfigKeyDetails> updateKeyDetails;
    public JSONObject updateKeys;
}
