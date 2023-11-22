package com.alibaba.ariver.app.api;

import com.alibaba.ariver.kernel.RVParams;

/* loaded from: classes3.dex */
public class ParamImpl {

    /* renamed from: a  reason: collision with root package name */
    private String f5964a;
    private String b;
    private RVParams.ParamType c;
    private Object d;
    private boolean e;

    public ParamImpl(String str, String str2, RVParams.ParamType paramType, Object obj) {
        this.f5964a = str;
        this.b = str2;
        this.c = paramType;
        this.d = obj;
    }

    public ParamImpl(String str, String str2, boolean z, RVParams.ParamType paramType, Object obj) {
        this.f5964a = str;
        this.b = str2;
        this.c = paramType;
        this.d = obj;
        this.e = z;
    }

    public void setDefaultValue(Object obj) {
        this.d = obj;
    }

    public String getLongName() {
        return this.f5964a;
    }

    public String getShortName() {
        return this.b;
    }

    public RVParams.ParamType getType() {
        return this.c;
    }

    public void setType(RVParams.ParamType paramType) {
        this.c = paramType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (id.dana.sendmoney.summary.SummaryActivity.CHECKED.equalsIgnoreCase(r0) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle unify(android.os.Bundle r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamImpl.unify(android.os.Bundle, boolean):android.os.Bundle");
    }
}
