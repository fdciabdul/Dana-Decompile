package com.alibaba.griver.core.jsapi.monitor;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class GriverLogReportConfig {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6416a;
    private JSONArray b;
    private int c;
    private int d;

    public GriverLogReportConfig(String str) {
        this.f6416a = true;
        this.b = new JSONArray();
        this.c = 30;
        this.d = 30;
        try {
            JSONObject parseObject = JSON.parseObject(str);
            this.f6416a = JSONUtils.getBoolean(parseObject, "enable", true);
            this.b = JSONUtils.getJSONArray(parseObject, "blackList", new JSONArray());
            int i = JSONUtils.getInt(parseObject, "logReportCount", 30);
            this.c = i;
            if (i <= 0) {
                this.c = 30;
            }
            int i2 = JSONUtils.getInt(parseObject, "logReportTimeSecond", 30);
            this.d = i2;
            if (i2 <= 0) {
                this.d = 30;
            }
        } catch (Throwable unused) {
        }
    }

    public boolean canReport(String str) {
        return this.f6416a && !this.b.contains(str);
    }

    public int getLogReportCount() {
        return this.c;
    }

    public int getLogReportTimeSecond() {
        return this.d;
    }
}
