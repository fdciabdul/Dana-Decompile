package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSVoid extends JSPrimitive {
    private final boolean mIsUndefined;
    private static final JSVoid sUndefinedValue = new JSVoid(true);
    private static final JSVoid sNullValue = new JSVoid(false);

    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSValue copy(JSContext jSContext) {
        return this;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isVoid() {
        return true;
    }

    public JSVoid() {
        super(null);
        this.mIsUndefined = true;
    }

    public JSVoid(boolean z) {
        super(null);
        this.mIsUndefined = z;
    }

    public static JSVoid undefinedValue() {
        return sUndefinedValue;
    }

    public static JSVoid nullValue() {
        return sNullValue;
    }

    public boolean isUndefined() {
        return this.mIsUndefined;
    }

    public boolean isNull() {
        return !this.mIsUndefined;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public String toString(JSContext jSContext) {
        Object[] objArr = new Object[1];
        objArr[0] = this.mIsUndefined ? "undefined" : "null";
        return String.format("Void(%s)", objArr);
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean equals(JSValue jSValue) {
        return jSValue.isVoid() && this.mIsUndefined == ((JSVoid) jSValue).mIsUndefined;
    }
}
