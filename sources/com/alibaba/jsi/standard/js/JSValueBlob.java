package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.LeakUtil;

/* loaded from: classes6.dex */
public class JSValueBlob implements Deletable {
    private long mNativePtr;

    public JSValueBlob(Long l) {
        long longValue = l.longValue();
        this.mNativePtr = longValue;
        if (longValue != 0) {
            LeakUtil.add(this);
        }
    }

    @Override // com.alibaba.jsi.standard.js.Deletable
    public void delete() {
        long j = this.mNativePtr;
        if (j != 0) {
            Bridge.cmd((JSContext) null, 752, j);
            this.mNativePtr = 0L;
            LeakUtil.remove(this);
        }
    }

    public JSValue deserialize(JSContext jSContext) {
        Object cmd = Bridge.cmd(jSContext, 751, this.mNativePtr);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }
}
