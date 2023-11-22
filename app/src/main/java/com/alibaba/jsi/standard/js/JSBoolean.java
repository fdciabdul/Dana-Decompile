package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes6.dex */
public class JSBoolean extends JSPrimitive {
    private final boolean mValue;
    private static final JSBoolean sTrueValue = new JSBoolean(true);
    private static final JSBoolean sFalseValue = new JSBoolean(false);

    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSValue copy(JSContext jSContext) {
        return this;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isBoolean() {
        return true;
    }

    public JSBoolean(boolean z) {
        super(null);
        this.mValue = z;
    }

    public static JSBoolean trueValue() {
        return sTrueValue;
    }

    public static JSBoolean falseValue() {
        return sFalseValue;
    }

    public static JSBoolean valueFor(boolean z) {
        return z ? sTrueValue : sFalseValue;
    }

    public boolean valueOf() {
        return this.mValue;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public String toString(JSContext jSContext) {
        return this.mValue ? SummaryActivity.CHECKED : "false";
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean equals(JSValue jSValue) {
        return jSValue.isBoolean() && this.mValue == ((JSBoolean) jSValue).mValue;
    }
}
