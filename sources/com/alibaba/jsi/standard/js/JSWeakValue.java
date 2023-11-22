package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.LeakUtil;

/* loaded from: classes6.dex */
public class JSWeakValue implements Deletable {
    private final JSContext mContext;
    private final JSValue mValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSWeakValue(JSContext jSContext, JSValue jSValue, boolean z) {
        this.mContext = jSContext;
        this.mValue = jSValue;
        if (z) {
            LeakUtil.add(jSContext, this);
        }
    }

    public JSValue lock(JSContext jSContext) {
        JSValue jSValue = this.mValue;
        if (jSValue != null) {
            return jSValue.lockWeak(jSContext);
        }
        return null;
    }

    public boolean expired(JSContext jSContext) {
        JSValue jSValue = this.mValue;
        if (jSValue != null) {
            return jSValue.weakExpired(jSContext);
        }
        return true;
    }

    @Override // com.alibaba.jsi.standard.js.Deletable
    public void delete() {
        LeakUtil.remove(this.mContext, this);
        JSValue jSValue = this.mValue;
        if (jSValue != null) {
            jSValue.delete();
        }
    }
}
