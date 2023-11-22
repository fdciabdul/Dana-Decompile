package com.alipay.mobile.jsengine.v8;

/* loaded from: classes6.dex */
public class V8Array extends V8Object {
    protected V8Array() {
    }

    public V8Array(V8 v8) {
        super(v8);
        v8.checkThread();
    }

    protected V8Array(V8 v8, Object obj) {
        super(v8, obj);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    protected V8Value createTwin() {
        return new V8Array(this.v8);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Array twin() {
        return (V8Array) super.twin();
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object
    public String toString() {
        return (this.released || this.v8.isReleased()) ? "[Array released]" : super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        long initNewV8Array = this.v8.initNewV8Array(j);
        this.released = false;
        addObjectReference(initNewV8Array);
    }

    public int length() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
    }

    public int getType(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public int getType() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
    }

    public int getType(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getInteger(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public boolean getBoolean(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public byte getByte(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public double getDouble(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public String getString(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public int[] getIntegers(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getIntegers(int i, int i2, int[] iArr) {
        this.v8.checkThread();
        checkReleased();
        if (i2 > iArr.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), i, i2, iArr);
    }

    public double[] getDoubles(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getDoubles(int i, int i2, double[] dArr) {
        this.v8.checkThread();
        checkReleased();
        if (i2 > dArr.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), i, i2, dArr);
    }

    public boolean[] getBooleans(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public byte[] getBytes(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getBooleans(int i, int i2, boolean[] zArr) {
        this.v8.checkThread();
        checkReleased();
        if (i2 > zArr.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), i, i2, zArr);
    }

    public int getBytes(int i, int i2, byte[] bArr) {
        this.v8.checkThread();
        checkReleased();
        if (i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), i, i2, bArr);
    }

    public String[] getStrings(int i, int i2) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getStrings(int i, int i2, String[] strArr) {
        this.v8.checkThread();
        checkReleased();
        if (i2 > strArr.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), i, i2, strArr);
    }

    public Object get(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i);
    }

    public V8Array getArray(int i) {
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, i);
        if (arrayGet == null || (arrayGet instanceof V8Array)) {
            return (V8Array) arrayGet;
        }
        throw new V8ResultUndefined();
    }

    public V8Object getObject(int i) {
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i);
        if (arrayGet == null || (arrayGet instanceof V8Object)) {
            return (V8Object) arrayGet;
        }
        throw new V8ResultUndefined();
    }

    public V8Array push(int i) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), i);
        return this;
    }

    public V8Array push(boolean z) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), z);
        return this;
    }

    public V8Array push(double d) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), d);
        return this;
    }

    public V8Array push(String str) {
        this.v8.checkThread();
        checkReleased();
        if (str == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), str);
        }
        return this;
    }

    public V8Array push(V8Value v8Value) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        return this;
    }

    public V8Array push(Object obj) {
        this.v8.checkThread();
        checkReleased();
        boolean z = obj instanceof V8Value;
        if (z) {
            this.v8.checkRuntime((V8Value) obj);
        }
        if (obj == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (z) {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public V8Array pushNull() {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    public V8Array pushUndefined() {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Undefined extends V8Array {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array, com.alipay.mobile.jsengine.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array, com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
        public Undefined twin() {
            return (Undefined) super.twin();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, boolean z) {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public Object get(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array getArray(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public boolean getBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public boolean[] getBooleans(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public byte[] getBytes(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getBytes(int i, int i2, byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public byte getByte(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getBooleans(int i, int i2, boolean[] zArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public double getDouble(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public double[] getDoubles(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getDoubles(int i, int i2, double[] dArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getInteger(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int[] getIntegers(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getIntegers(int i, int i2, int[] iArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Object getObject(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public String getString(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public String[] getStrings(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getStrings(int i, int i2, String[] strArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getType() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getType(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getType(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int length() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array pushUndefined() {
            throw new UnsupportedOperationException();
        }
    }
}
