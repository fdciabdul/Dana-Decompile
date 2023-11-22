package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.JSEngine;
import com.alibaba.jsi.standard.LeakUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Template implements Deletable {
    private static final int kTemplateCommon = 0;
    private static final int kTemplateIndexed = 2;
    private static final int kTemplateNamed = 1;
    private boolean mDeleted = false;
    JSEngine mEngine;
    long mNativePtr;

    Template(JSEngine jSEngine, long j) {
        this.mEngine = jSEngine;
        this.mNativePtr = j;
        LeakUtil.add(jSEngine, this);
    }

    @Override // com.alibaba.jsi.standard.js.Deletable
    public void delete() {
        long j = this.mNativePtr;
        if (j != 0 && !this.mDeleted) {
            Bridge.nativeDelete(j, 2);
            this.mNativePtr = 0L;
            LeakUtil.remove(this.mEngine, this);
        }
        this.mDeleted = true;
    }

    private void checkDeleted() {
        if (this.mDeleted) {
            StringBuilder sb = new StringBuilder();
            sb.append("Template has been deleted: ");
            sb.append(this);
            throw new RuntimeException(sb.toString());
        }
    }

    public void detach() {
        if (this.mNativePtr != 0) {
            LeakUtil.remove(this.mEngine, this);
            this.mNativePtr = 0L;
        }
    }

    @Deprecated
    public static Template create() {
        return new Template(null, Bridge.createNative((JSContext) null, 20, 0L));
    }

    public static Template create(JSEngine jSEngine) {
        return new Template(jSEngine, Bridge.createNative(jSEngine, 22, 0L, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Object[]) null));
    }

    @Deprecated
    public static Template createNamed() {
        return new Template(null, Bridge.createNative((JSContext) null, 20, 1L));
    }

    public static Template createNamed(JSEngine jSEngine) {
        return new Template(jSEngine, Bridge.createNative(jSEngine, 22, 1L, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Object[]) null));
    }

    @Deprecated
    public static Template createIndexed() {
        return new Template(null, Bridge.createNative((JSContext) null, 20, 2L));
    }

    public static Template createIndexed(JSEngine jSEngine) {
        return new Template(jSEngine, Bridge.createNative(jSEngine, 22, 2L, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Object[]) null));
    }

    public boolean addFunction(String str, int i) {
        checkDeleted();
        return Bridge.cmd(null, 650, this.mNativePtr, (long) i, new Object[]{str}) != null;
    }

    public boolean addAccessor(String str, int i) {
        checkDeleted();
        return Bridge.cmd(null, 651, this.mNativePtr, (long) i, new Object[]{str}) != null;
    }

    public boolean addPrimitive(String str, JSPrimitive jSPrimitive, int i) {
        checkDeleted();
        return Bridge.cmd(null, 652, this.mNativePtr, (long) i, new Object[]{str, jSPrimitive}) != null;
    }

    public boolean addBoolean(String str, boolean z, int i) {
        return addPrimitive(str, JSBoolean.valueFor(z), i);
    }

    public boolean addInteger(String str, int i, int i2) {
        return addPrimitive(str, new JSNumber(i), i2);
    }

    public boolean addDouble(String str, double d, int i) {
        return addPrimitive(str, new JSNumber(d), i);
    }

    public boolean addString(String str, String str2, int i) {
        return addPrimitive(str, new JSString(str2), i);
    }

    public JSObject newJSObject(JSContext jSContext, JSCallback jSCallback) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 653, this.mNativePtr, new Object[]{jSCallback});
        if (cmd instanceof JSObject) {
            return (JSObject) cmd;
        }
        return null;
    }

    public JSFunction newJSClass(JSContext jSContext, String str, JSCallback jSCallback) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 654, this.mNativePtr, new Object[]{str, jSCallback});
        if (cmd instanceof JSFunction) {
            return (JSFunction) cmd;
        }
        return null;
    }
}
