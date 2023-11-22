package com.alipay.mobile.jsengine.v8;

import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class AntV8 extends V8 {
    private native void _add(long j, long j2, String str, double d);

    private native void _add(long j, long j2, String str, int i);

    private native void _add(long j, long j2, String str, String str2);

    private native void _add(long j, long j2, String str, boolean z);

    private native void _addArrayBooleanItem(long j, long j2, boolean z);

    private native void _addArrayDoubleItem(long j, long j2, double d);

    private native void _addArrayIntItem(long j, long j2, int i);

    private native void _addArrayNullItem(long j, long j2);

    private native void _addArrayObjectItem(long j, long j2, long j3);

    private native void _addArrayStringItem(long j, long j2, String str);

    private native void _addArrayUndefinedItem(long j, long j2);

    private native void _addNull(long j, long j2, String str);

    private native void _addObject(long j, long j2, String str, long j3);

    private native void _addUndefined(long j, long j2, String str);

    private native Object _arrayGet(long j, int i, long j2, int i2);

    private native boolean _arrayGetBoolean(long j, long j2, int i);

    private native int _arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j, long j2, int i, int i2);

    private native byte _arrayGetByte(long j, long j2, int i);

    private native int _arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr);

    private native byte[] _arrayGetBytes(long j, long j2, int i, int i2);

    private native double _arrayGetDouble(long j, long j2, int i);

    private native int _arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr);

    private native double[] _arrayGetDoubles(long j, long j2, int i, int i2);

    private native int _arrayGetInteger(long j, long j2, int i);

    private native int _arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr);

    private native int[] _arrayGetIntegers(long j, long j2, int i, int i2);

    private native int _arrayGetSize(long j, long j2);

    private native String _arrayGetString(long j, long j2, int i);

    private native int _arrayGetStrings(long j, long j2, int i, int i2, String[] strArr);

    private native String[] _arrayGetStrings(long j, long j2, int i, int i2);

    private native void _cancelSerialization(long j);

    private native long _compileScript(long j, String str, String str2, int i);

    private native boolean _contains(long j, long j2, String str);

    private native long _createIsolate(String str, Object obj);

    private native void _createTwin(long j, long j2, long j3);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j, long j2, int i);

    private native void _debugRegisterContext(long j, long j2, String str);

    private native Object _deserialize(long j, long j2);

    private native void _dispatchFrontendMessage(long j, String str);

    private native void _dispatchPluginEvent(long j, int i, String str, int i2);

    private native boolean _enableDebugAgent(long j, String str);

    private native void _enterContext(long j, long j2);

    private native boolean _equals(long j, long j2, long j3);

    private native boolean _executeBooleanFunction(long j, long j2, String str, long j3);

    private native boolean _executeBooleanScript(long j, String str, String str2, int i);

    private native double _executeDoubleFunction(long j, long j2, String str, long j3);

    private native double _executeDoubleScript(long j, String str, String str2, int i);

    private native Object _executeFunction(long j, int i, long j2, String str, long j3);

    private native Object _executeFunction(long j, long j2, long j3, long j4);

    private native int _executeIntegerFunction(long j, long j2, String str, long j3);

    private native int _executeIntegerScript(long j, String str, String str2, int i);

    private native Object _executeScript(long j, int i, String str, String str2, int i2);

    private native String _executeStringFunction(long j, long j2, String str, long j3);

    private native String _executeStringScript(long j, String str, String str2, int i);

    private native void _executeVoidFunction(long j, long j2, String str, long j3);

    private native void _executeVoidScript(long j, String str, String str2, int i);

    private native void _executeVoidScript2(long j, byte[] bArr, String str, int i);

    private native void _executeVoidScript2InContext(long j, long j2, byte[] bArr, String str, int i);

    private native void _executeVoidScriptInContext(long j, long j2, String str, String str2, int i);

    private native void _exitContext(long j, long j2);

    private native void _flushCodeCache(long j);

    private native Object _get(long j, int i, long j2, String str);

    private native int _getArrayType(long j, long j2);

    private native boolean _getBoolean(long j, long j2, String str);

    private native long _getBuildID();

    private native long _getContextGlobalHandle(long j, long j2);

    private native double _getDouble(long j, long j2, String str);

    private native long _getGlobalObject(long j);

    private native String _getHeapStatistics(long j);

    private native int _getInteger(long j, long j2, String str);

    private native String[] _getKeys(long j, long j2);

    private native String _getString(long j, long j2, String str);

    private native int _getType(long j, long j2);

    private native int _getType(long j, long j2, int i);

    private native int _getType(long j, long j2, int i, int i2);

    private native int _getType(long j, long j2, String str);

    private static native String _getVersion();

    private native int _identityHash(long j, long j2);

    private native long _initNewV8Array(long j);

    private native long _initNewV8ArrayBuffer(long j, int i);

    private native long _initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long _initNewV8Context(long j, long j2);

    private native long[] _initNewV8Function(long j);

    private native long _initNewV8Object(long j);

    private native boolean _isWeak(long j, long j2);

    private native boolean _loadNativePlugin(long j, String str, String str2, String str3, int i);

    private native void _loadNativePlugins(long j, String str, String[] strArr);

    private native void _lowMemoryNotification(long j);

    private static native boolean _pumpMessageLoop(long j, boolean z);

    private native long _registerJavaMethod(long j, long j2, String str, boolean z);

    private native void _release(long j, long j2);

    private native void _releaseMethodDescriptor(long j, long j2);

    private native void _releaseRuntime(long j);

    private native void _runScript(long j, long j2);

    private native boolean _sameValue(long j, long j2, long j3);

    private native long _serialize(long j, long j2);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j, long j2, long j3);

    private native void _setWeak(long j, long j2);

    private native boolean _strictEquals(long j, long j2, long j3);

    private native void _terminateExecution(long j);

    private native String _toString(long j, long j2);

    public static V8 createV8Runtime() {
        return createV8Runtime(null, null);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null);
    }

    public static V8 createV8Runtime(String str, Object obj) {
        return new AntV8(str, obj);
    }

    protected AntV8(String str, Object obj) {
        super(null, null, false);
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str, obj);
        checkThread();
        this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean loadNativePlugin(String str, String str2, String str3, int i) {
        return _loadNativePlugin(this.v8RuntimePtr, str, str2, str3, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void loadNativePlugins(String str, String[] strArr) {
        _loadNativePlugins(this.v8RuntimePtr, str, strArr);
    }

    public static String getV8Version() {
        return _getVersion();
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public String getHeapStatistics() {
        return _getHeapStatistics(getV8RuntimePtr());
    }

    public static void setFlags(String str) {
        _setFlags(str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void release(boolean z) {
        if (isReleased()) {
            return;
        }
        checkThread();
        releaseResources();
        releaseNativeMethodDescriptors();
        _releaseRuntime(this.v8RuntimePtr);
        this.v8RuntimePtr = 0L;
        this.released = true;
        if (!z || getObjectReferenceCount() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.objectReferences);
        sb.append(" Object(s) still exist in runtime");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void executeVoidScript(byte[] bArr, String str, int i) {
        checkThread();
        _executeVoidScript2(this.v8RuntimePtr, bArr, str, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void executeVoidScriptInContext(V8Context v8Context, String str, String str2, int i) {
        checkThread();
        checkScript(str);
        _executeVoidScriptInContext(this.v8RuntimePtr, v8Context.getContextHandle(), str, str2, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void executeVoidScriptInContext(V8Context v8Context, byte[] bArr, String str, int i) {
        checkThread();
        _executeVoidScript2InContext(this.v8RuntimePtr, v8Context.getContextHandle(), bArr, str, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public long compileScript(String str, String str2, int i) {
        return _compileScript(this.v8RuntimePtr, str, str2, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void runScript(long j) {
        _runScript(this.v8RuntimePtr, j);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public long getBuildID() {
        return _getBuildID();
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void flushCodeCache() {
        _flushCodeCache(getV8RuntimePtr());
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public long serialize(long j) {
        return _serialize(this.v8RuntimePtr, j);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public V8Value deserialize(long j) {
        Object _deserialize = _deserialize(this.v8RuntimePtr, j);
        if (_deserialize instanceof V8Value) {
            return (V8Value) _deserialize;
        }
        return null;
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void cancelSerialization(long j) {
        _cancelSerialization(j);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean pumpMessageLoop(boolean z) {
        return _pumpMessageLoop(this.v8RuntimePtr, z);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean enableDebugAgent(String str) {
        return _enableDebugAgent(getV8RuntimePtr(), str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void dispatchFrontendMessage(long j, String str) {
        _dispatchFrontendMessage(j, str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    public void dispatchPluginEvent(int i, String str, int i2) {
        _dispatchPluginEvent(this.v8RuntimePtr, i, str, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long initNewV8Object(long j) {
        return _initNewV8Object(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long initNewV8Context(long j, long j2) {
        return _initNewV8Context(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void enterContext(long j, long j2) {
        _enterContext(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void exitContext(long j, long j2) {
        _exitContext(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long getContextGlobalHandle(long j, long j2) {
        return _getContextGlobalHandle(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void debugRegisterContext(long j, String str) {
        _debugRegisterContext(getV8RuntimePtr(), j, str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected void lowMemoryNotification(long j) {
        _lowMemoryNotification(j);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected void createTwin(long j, long j2, long j3) {
        _createTwin(j, j2, j3);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected int executeIntegerScript(long j, String str, String str2, int i) {
        return _executeIntegerScript(j, str, str2, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected double executeDoubleScript(long j, String str, String str2, int i) {
        return _executeDoubleScript(j, str, str2, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected String executeStringScript(long j, String str, String str2, int i) {
        return _executeStringScript(j, str, str2, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected boolean executeBooleanScript(long j, String str, String str2, int i) {
        return _executeBooleanScript(j, str, str2, i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected Object executeScript(long j, int i, String str, String str2, int i2) {
        return _executeScript(j, i, str, str2, i2);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected void executeVoidScript(long j, String str, String str2, int i) {
        _executeVoidScript(j, str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void setWeak(long j, long j2) {
        _setWeak(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean isWeak(long j, long j2) {
        return _isWeak(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void release(long j, long j2) {
        _release(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean contains(long j, long j2, String str) {
        return _contains(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public String[] getKeys(long j, long j2) {
        return _getKeys(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int getInteger(long j, long j2, String str) {
        return _getInteger(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean getBoolean(long j, long j2, String str) {
        return _getBoolean(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public double getDouble(long j, long j2, String str) {
        return _getDouble(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public String getString(long j, long j2, String str) {
        return _getString(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public Object get(long j, int i, long j2, String str) {
        return _get(j, i, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int executeIntegerFunction(long j, long j2, String str, long j3) {
        return _executeIntegerFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public double executeDoubleFunction(long j, long j2, String str, long j3) {
        return _executeDoubleFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public String executeStringFunction(long j, long j2, String str, long j3) {
        return _executeStringFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean executeBooleanFunction(long j, long j2, String str, long j3) {
        return _executeBooleanFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public Object executeFunction(long j, int i, long j2, String str, long j3) {
        return _executeFunction(j, i, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public Object executeFunction(long j, long j2, long j3, long j4) {
        return _executeFunction(j, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void executeVoidFunction(long j, long j2, String str, long j3) {
        _executeVoidFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean jsEquals(long j, long j2, long j3) {
        return _equals(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public String toString(long j, long j2) {
        return _toString(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean strictEquals(long j, long j2, long j3) {
        return _strictEquals(j, j2, j3);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected boolean sameValue(long j, long j2, long j3) {
        return _sameValue(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int identityHash(long j, long j2) {
        return _identityHash(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void add(long j, long j2, String str, int i) {
        _add(j, j2, str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addObject(long j, long j2, String str, long j3) {
        _addObject(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void add(long j, long j2, String str, boolean z) {
        _add(j, j2, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void add(long j, long j2, String str, double d) {
        _add(j, j2, str, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void add(long j, long j2, String str, String str2) {
        if (str2 == null) {
            _addNull(j, j2, str);
        } else {
            _add(j, j2, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addUndefined(long j, long j2, String str) {
        _addUndefined(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addNull(long j, long j2, String str) {
        _addNull(j, j2, str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected long registerJavaMethod(long j, long j2, String str, boolean z) {
        return _registerJavaMethod(j, j2, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        return _initNewV8ArrayBuffer(j, byteBuffer, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long initNewV8ArrayBuffer(long j, int i) {
        return _initNewV8ArrayBuffer(j, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        return _createV8ArrayBufferBackingStore(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long initNewV8Array(long j) {
        return _initNewV8Array(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public long[] initNewV8Function(long j) {
        checkThread();
        return _initNewV8Function(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetSize(long j, long j2) {
        return _arrayGetSize(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetInteger(long j, long j2, int i) {
        return _arrayGetInteger(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean arrayGetBoolean(long j, long j2, int i) {
        return _arrayGetBoolean(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public byte arrayGetByte(long j, long j2, int i) {
        return _arrayGetByte(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public double arrayGetDouble(long j, long j2, int i) {
        return _arrayGetDouble(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public String arrayGetString(long j, long j2, int i) {
        return _arrayGetString(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public Object arrayGet(long j, int i, long j2, int i2) {
        return _arrayGet(j, i, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayIntItem(long j, long j2, int i) {
        _addArrayIntItem(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayBooleanItem(long j, long j2, boolean z) {
        _addArrayBooleanItem(j, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayDoubleItem(long j, long j2, double d) {
        _addArrayDoubleItem(j, j2, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayStringItem(long j, long j2, String str) {
        if (str == null) {
            _addArrayNullItem(j, j2);
        } else {
            _addArrayStringItem(j, j2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayObjectItem(long j, long j2, long j3) {
        _addArrayObjectItem(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayUndefinedItem(long j, long j2) {
        _addArrayUndefinedItem(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void addArrayNullItem(long j, long j2) {
        _addArrayNullItem(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int getType(long j, long j2) {
        return _getType(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int getType(long j, long j2, String str) {
        return _getType(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int getType(long j, long j2, int i) {
        return _getType(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int getArrayType(long j, long j2) {
        return _getArrayType(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int getType(long j, long j2, int i, int i2) {
        return _getType(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public void setPrototype(long j, long j2, long j3) {
        _setPrototype(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int[] arrayGetIntegers(long j, long j2, int i, int i2) {
        return _arrayGetIntegers(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public double[] arrayGetDoubles(long j, long j2, int i, int i2) {
        return _arrayGetDoubles(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public boolean[] arrayGetBooleans(long j, long j2, int i, int i2) {
        return _arrayGetBooleans(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public byte[] arrayGetBytes(long j, long j2, int i, int i2) {
        return _arrayGetBytes(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public String[] arrayGetStrings(long j, long j2, int i, int i2) {
        return _arrayGetStrings(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr) {
        return _arrayGetIntegers(j, j2, i, i2, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr) {
        return _arrayGetDoubles(j, j2, i, i2, dArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr) {
        return _arrayGetBooleans(j, j2, i, i2, zArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr) {
        return _arrayGetBytes(j, j2, i, i2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8
    public int arrayGetStrings(long j, long j2, int i, int i2, String[] strArr) {
        return _arrayGetStrings(j, j2, i, i2, strArr);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected void terminateExecution(long j) {
        _terminateExecution(j);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8
    protected void releaseMethodDescriptor(long j, long j2) {
        _releaseMethodDescriptor(j, j2);
    }
}
