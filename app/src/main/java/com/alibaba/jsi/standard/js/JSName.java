package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSName extends JSPrimitive {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isName() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSName(JSContext jSContext, long j) {
        super(jSContext, j);
    }
}
