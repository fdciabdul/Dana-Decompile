package com.ta.audid.e;

import com.ta.audid.g.m;

@com.ta.audid.b.a.c("utdid")
/* loaded from: classes.dex */
public class b extends com.ta.audid.b.b {
    @com.ta.audid.b.a.a("content")
    private String f;
    @com.ta.audid.b.a.a("priority")
    public String priority;
    @com.ta.audid.b.a.a("time")
    public String time;

    public b() {
        this.time = null;
        this.priority = "3";
        this.f = null;
    }

    public b(String str) {
        this.time = null;
        this.f = null;
        this.priority = "3";
        this.time = String.valueOf(System.currentTimeMillis());
        setContent(str);
    }

    public String H() {
        return e.d(this.f);
    }

    public void setContent(String str) {
        if (str != null) {
            try {
                this.f = e.e(str);
            } catch (Exception e) {
                m.e("", e, new Object[0]);
            }
        }
    }
}
