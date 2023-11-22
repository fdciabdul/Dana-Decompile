package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSPrimitive extends JSValue {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isPrimitive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSPrimitive(JSContext jSContext) {
        super(jSContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSPrimitive(JSContext jSContext, long j) {
        super(jSContext, j);
    }
}
