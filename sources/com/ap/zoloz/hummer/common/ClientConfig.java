package com.ap.zoloz.hummer.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ClientConfig {
    @JSONField(name = "clientStartIndex")
    public int clientStartIndex = 0;
    @JSONField(name = "flowId")
    public String flowId = null;
    @JSONField(name = "factorContext")
    public Map<String, Object> factorContext = new HashMap();
    @JSONField(name = "tasks")
    public ArrayList<TaskConfig> tasks = new ArrayList<>();
    @JSONField(name = HummerConstants.ZSTACK)
    public ArrayList<Map<String, String>> zStack = new ArrayList<>();
}
