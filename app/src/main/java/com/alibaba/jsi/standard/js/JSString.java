package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSString extends JSName {
    private final String mValue;

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isString() {
        return true;
    }

    public JSString(String str) {
        super(null, 0L);
        this.mValue = str;
    }

    public String valueOf() {
        return this.mValue;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public String toString(JSContext jSContext) {
        return this.mValue;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSValue copy(JSContext jSContext) {
        return new JSString(this.mValue);
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean equals(JSValue jSValue) {
        if (jSValue.isString()) {
            return this.mValue.equals(((JSString) jSValue).mValue);
        }
        return false;
    }
}
