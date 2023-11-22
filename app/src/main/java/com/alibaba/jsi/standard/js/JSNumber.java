package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSNumber extends JSPrimitive {
    private final boolean mIsInteger;
    private final double mValue;

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isNumber() {
        return true;
    }

    public JSNumber(int i) {
        super(null);
        this.mValue = i;
        this.mIsInteger = true;
    }

    public JSNumber(double d) {
        super(null);
        this.mValue = d;
        this.mIsInteger = false;
    }

    public boolean isInteger() {
        return this.mIsInteger;
    }

    public double valueOf() {
        return this.mValue;
    }

    public int asInteger() {
        if (!this.mIsInteger) {
            throw new AssertionError("Not a integer");
        }
        return (int) this.mValue;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public String toString(JSContext jSContext) {
        if (this.mIsInteger) {
            return String.valueOf((int) this.mValue);
        }
        return String.valueOf(this.mValue);
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSValue copy(JSContext jSContext) {
        if (this.mIsInteger) {
            return new JSNumber((int) this.mValue);
        }
        return new JSNumber(this.mValue);
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean equals(JSValue jSValue) {
        return jSValue.isNumber() && this.mValue == ((JSNumber) jSValue).mValue;
    }
}
