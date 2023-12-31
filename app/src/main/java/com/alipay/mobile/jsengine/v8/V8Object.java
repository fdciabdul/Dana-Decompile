package com.alipay.mobile.jsengine.v8;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class V8Object extends V8Value {
    public V8Object(V8 v8) {
        this(v8, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V8Object(V8 v8, Object obj) {
        super(v8);
        if (v8 != null) {
            this.v8.checkThread();
            initialize(this.v8.getV8RuntimePtr(), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V8Object() {
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    protected V8Value createTwin() {
        return new V8Object(this.v8);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public V8Object twin() {
        return (V8Object) super.twin();
    }

    public boolean contains(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.contains(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String[] getKeys() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getKeys(this.v8.getV8RuntimePtr(), this.objectHandle);
    }

    public int getType(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getType(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public Object get(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str);
    }

    public int getInteger(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getInteger(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public boolean getBoolean(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getBoolean(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public double getDouble(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getDouble(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String getString(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getString(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public V8Array getArray(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Array)) {
            return (V8Array) obj;
        }
        throw new V8ResultUndefined();
    }

    public V8Object getObject(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Object)) {
            return (V8Object) obj;
        }
        throw new V8ResultUndefined();
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        return this.v8.executeIntegerFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0L : v8Array.getHandle());
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        return this.v8.executeDoubleFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0L : v8Array.getHandle());
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        return this.v8.executeStringFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0L : v8Array.getHandle());
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        return this.v8.executeBooleanFunction(this.v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0L : v8Array.getHandle());
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 5, this.objectHandle, str, v8Array == null ? 0L : v8Array.getHandle());
        if (executeFunction instanceof V8Array) {
            return (V8Array) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str, v8Array == null ? 0L : v8Array.getHandle());
        if (executeFunction instanceof V8Object) {
            return (V8Object) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public Object executeFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        return this.v8.executeFunction(this.v8.getV8RuntimePtr(), 0, this.objectHandle, str, v8Array == null ? 0L : v8Array.getHandle());
    }

    public Object executeJSFunction(String str) {
        return executeFunction(str, null);
    }

    public Object executeJSFunction(String str, Object... objArr) {
        if (objArr == null) {
            return executeFunction(str, null);
        }
        V8Array v8Array = new V8Array(this.v8.getRuntime());
        try {
            for (Object obj : objArr) {
                if (obj == null) {
                    v8Array.pushNull();
                } else if (obj instanceof V8Value) {
                    v8Array.push((V8Value) obj);
                } else if (obj instanceof Integer) {
                    v8Array.push((Integer) obj);
                } else if (obj instanceof Double) {
                    v8Array.push((Double) obj);
                } else if (obj instanceof Long) {
                    v8Array.push(((Long) obj).doubleValue());
                } else if (obj instanceof Float) {
                    v8Array.push(((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    v8Array.push((Boolean) obj);
                } else if (obj instanceof String) {
                    v8Array.push((String) obj);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported Object of type: ");
                    sb.append(obj.getClass());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            return executeFunction(str, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Array);
        this.v8.executeVoidFunction(this.v8.getV8RuntimePtr(), this.objectHandle, str, v8Array == null ? 0L : v8Array.getHandle());
    }

    public V8Object add(String str, int i) {
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, i);
        return this;
    }

    public V8Object add(String str, boolean z) {
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, z);
        return this;
    }

    public V8Object add(String str, double d) {
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, d);
        return this;
    }

    public V8Object add(String str, String str2) {
        this.v8.checkThread();
        checkReleased();
        if (str2 == null) {
            this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(V8.getUndefined())) {
            this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.v8.addObject(this.v8.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        return this;
    }

    public V8Object addUndefined(String str) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object addNull(String str) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        this.v8.checkThread();
        checkReleased();
        this.v8.setPrototype(this.v8.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
        return this;
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        this.v8.checkThread();
        checkReleased();
        this.v8.registerCallback(javaCallback, getHandle(), str);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        this.v8.checkThread();
        checkReleased();
        this.v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        return registerJavaMethod(obj, str, str2, clsArr, false);
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        this.v8.checkThread();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.v8.registerCallback(obj, method, getHandle(), str2, z);
            return this;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (SecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public String toString() {
        if (isReleased() || this.v8.isReleased()) {
            return "[Object released]";
        }
        this.v8.checkThread();
        return this.v8.toString(this.v8.getV8RuntimePtr(), getHandle());
    }

    private void checkKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Undefined extends V8Object {
        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public int hashCode() {
            return 919;
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean isReleased() {
            return false;
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean isUndefined() {
            return true;
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value, com.alipay.mobile.jsengine.v8.Releasable
        public void release() {
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
        public Undefined twin() {
            return (Undefined) super.twin();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, double d) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public Object executeJSFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public Object executeFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object addUndefined(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public boolean contains(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public double executeDoubleFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int executeIntegerFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String[] getKeys() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object getObject(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String getString(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int getType(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            throw new UnsupportedOperationException();
        }
    }
}
