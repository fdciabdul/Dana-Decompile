package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSCallback {
    public String getIdentifier() {
        return null;
    }

    public JSValue onCallConstructor(Arguments arguments) {
        return null;
    }

    public JSValue onCallFunction(Arguments arguments) {
        return null;
    }

    public void onDetached() {
    }

    public JSValue onGetProperty(JSContext jSContext, JSValue jSValue, String str) {
        jSValue.delete();
        return null;
    }

    public void onSetProperty(JSContext jSContext, JSValue jSValue, String str, JSValue jSValue2) {
        jSValue.delete();
        jSValue2.delete();
    }

    public JSValue onGetNamedProperty(JSContext jSContext, JSValue jSValue, String str) {
        jSValue.delete();
        return null;
    }

    public JSValue onSetNamedProperty(JSContext jSContext, JSValue jSValue, String str, JSValue jSValue2) {
        jSValue.delete();
        jSValue2.delete();
        return null;
    }

    public int onQueryNamedProperty(JSContext jSContext, JSValue jSValue, String str) {
        jSValue.delete();
        return 0;
    }

    public boolean onDeleteNamedProperty(JSContext jSContext, JSValue jSValue, String str) {
        jSValue.delete();
        return true;
    }

    public JSValue[] onEnumerateNamedProperty(JSContext jSContext, JSValue jSValue) {
        jSValue.delete();
        return null;
    }

    public JSValue onGetIndexedProperty(JSContext jSContext, JSValue jSValue, int i) {
        jSValue.delete();
        return null;
    }

    public JSValue onSetIndexedProperty(JSContext jSContext, JSValue jSValue, int i, JSValue jSValue2) {
        jSValue.delete();
        jSValue2.delete();
        return null;
    }

    public int onQueryIndexedProperty(JSContext jSContext, JSValue jSValue, int i) {
        jSValue.delete();
        return 0;
    }

    public boolean onDeleteIndexedProperty(JSContext jSContext, JSValue jSValue, int i) {
        jSValue.delete();
        return true;
    }

    public JSValue[] onEnumerateIndexedProperty(JSContext jSContext, JSValue jSValue) {
        jSValue.delete();
        return null;
    }
}
