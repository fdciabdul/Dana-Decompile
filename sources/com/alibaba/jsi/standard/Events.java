package com.alibaba.jsi.standard;

import com.alibaba.jsi.standard.js.JSException;

/* loaded from: classes6.dex */
public class Events {
    public static final int kRaiseFromExecuteJS = 1;
    public static final int kRaiseFromFunctionCall = 2;
    public static final int kRaiseFromJSIInternal = 12;
    public static final int kRaiseFromJSObjectGet = 6;
    public static final int kRaiseFromJSObjectSet = 7;
    public static final int kRaiseFromJSPromise = 5;
    public static final int kRaiseFromJSTimer = 4;
    public static final int kRaiseFromNewInstance = 3;
    public static final int kRaiseFromOtherApiCall = 11;
    public static final int kRaiseFromWasmFunctionCall = 9;
    public static final int kRaiseFromWasmInstanceMake = 10;
    public static final int kRaiseFromWasmModuleMake = 8;

    public boolean onJSSupportException(JSContext jSContext, Throwable th) {
        return false;
    }

    public void onReload(JSContext jSContext) {
    }

    public boolean onUncaughtJSException(JSContext jSContext, JSException jSException, int i) {
        if (jSException != null) {
            jSException.delete();
            return false;
        }
        return false;
    }
}
