package com.alipay.mobile.jsengine.v8;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class V8 extends V8Object {
    static volatile int runtimeCounter;
    Map<String, Object> data;
    Map<Long, MethodDescriptor> functionRegistry;
    long objectReferences;
    LinkedList<ReferenceHandler> referenceHandlers;
    List<Releasable> resources;
    long v8RuntimePtr;
    Map<Long, V8Value> v8WeakReferences;
    static Object lock = new Object();
    static V8Value undefined = new V8Object.Undefined();
    static Object invalid = new Object();
    static boolean sEnableCloseGuard = false;

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

    public static String getSCMRevision() {
        return "Unknown revision ID";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class MethodDescriptor {
        JavaCallback callback;
        boolean includeReceiver;
        Method method;
        Object object;
        JavaVoidCallback voidCallback;

        MethodDescriptor() {
        }
    }

    public static V8 createV8Runtime() {
        return createV8Runtime(null, null);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null);
    }

    public static V8 createV8Runtime(String str, Object obj) {
        V8 v8 = new V8(str, obj, true);
        synchronized (lock) {
            runtimeCounter++;
        }
        try {
            sEnableCloseGuard = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("jsengine_enableCloseGuard", true);
        } catch (Throwable unused) {
        }
        return v8;
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.add(0, referenceHandler);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.remove(referenceHandler);
    }

    public void setData(String str, Object obj) {
        synchronized (this) {
            if (this.data == null) {
                this.data = new HashMap();
            }
            this.data.put(str, obj);
        }
    }

    public Object getData(String str) {
        Map<String, Object> map = this.data;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            it.next().v8HandleCreated(v8Value);
        }
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            it.next().v8HandleDisposed(v8Value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V8(String str, Object obj, boolean z) {
        super(null);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.objectReferences = 0L;
        this.v8RuntimePtr = 0L;
        this.resources = null;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList<>();
        if (z) {
            this.released = false;
            this.v8RuntimePtr = _createIsolate(str, obj);
            checkThread();
            this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
        }
    }

    public boolean loadNativePlugin(String str, String str2, String str3, int i) {
        return _loadNativePlugin(this.v8RuntimePtr, str, str2, str3, i);
    }

    public void loadNativePlugins(String str, String[] strArr) {
        _loadNativePlugins(this.v8RuntimePtr, str, strArr);
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    public long getObjectReferenceCount() {
        return this.objectReferences - this.v8WeakReferences.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public static String getV8Version() {
        return _getVersion();
    }

    public String getHeapStatistics() {
        return _getHeapStatistics(getV8RuntimePtr());
    }

    public static void setFlags(String str) {
        _setFlags(str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value, com.alipay.mobile.jsengine.v8.Releasable
    public void release() {
        release(true);
    }

    public void terminateExecution() {
        terminateExecution(this.v8RuntimePtr);
    }

    public void release(boolean z) {
        if (isReleased()) {
            return;
        }
        checkThread();
        releaseResources();
        releaseNativeMethodDescriptors();
        synchronized (lock) {
            runtimeCounter--;
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseNativeMethodDescriptors() {
        Iterator<Long> it = this.functionRegistry.keySet().iterator();
        while (it.hasNext()) {
            releaseMethodDescriptor(this.v8RuntimePtr, it.next().longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseResources() {
        List<Releasable> list = this.resources;
        if (list != null) {
            Iterator<Releasable> it = list.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.resources.clear();
            this.resources = null;
        }
    }

    public void registerResource(Releasable releasable) {
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
    }

    public int executeIntegerScript(String str) {
        return executeIntegerScript(str, null, 0);
    }

    public int executeIntegerScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeIntegerScript(this.v8RuntimePtr, str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
    }

    public double executeDoubleScript(String str) {
        return executeDoubleScript(str, null, 0);
    }

    public double executeDoubleScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeDoubleScript(this.v8RuntimePtr, str, str2, i);
    }

    public String executeStringScript(String str) {
        return executeStringScript(str, null, 0);
    }

    public String executeStringScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeStringScript(this.v8RuntimePtr, str, str2, i);
    }

    public boolean executeBooleanScript(String str) {
        return executeBooleanScript(str, null, 0);
    }

    public boolean executeBooleanScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeBooleanScript(this.v8RuntimePtr, str, str2, i);
    }

    public V8Array executeArrayScript(String str) {
        return executeArrayScript(str, null, 0);
    }

    public V8Array executeArrayScript(String str, String str2, int i) {
        checkThread();
        Object executeScript = executeScript(str, str2, i);
        if (executeScript instanceof V8Array) {
            return (V8Array) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public Object executeScript(String str) {
        return executeScript(str, null, 0);
    }

    public Object executeScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i);
    }

    public V8Object executeObjectScript(String str) {
        return executeObjectScript(str, null, 0);
    }

    public V8Object executeObjectScript(String str, String str2, int i) {
        checkThread();
        Object executeScript = executeScript(str, str2, i);
        if (executeScript instanceof V8Object) {
            return (V8Object) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, (String) null, 0);
    }

    public void executeVoidScript(byte[] bArr) {
        executeVoidScript(bArr, (String) null, 0);
    }

    public void executeVoidScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i);
    }

    public void executeVoidScript(byte[] bArr, String str, int i) {
        checkThread();
        _executeVoidScript2(this.v8RuntimePtr, bArr, str, i);
    }

    public void executeVoidScriptInContext(V8Context v8Context, String str, String str2, int i) {
        checkThread();
        checkScript(str);
        _executeVoidScriptInContext(this.v8RuntimePtr, v8Context.getContextHandle(), str, str2, i);
    }

    public void executeVoidScriptInContext(V8Context v8Context, byte[] bArr, String str, int i) {
        checkThread();
        _executeVoidScript2InContext(this.v8RuntimePtr, v8Context.getContextHandle(), bArr, str, i);
    }

    public long compileScript(String str, String str2, int i) {
        return _compileScript(this.v8RuntimePtr, str, str2, i);
    }

    public void runScript(long j) {
        _runScript(this.v8RuntimePtr, j);
    }

    public long getBuildID() {
        return _getBuildID();
    }

    public void lowMemoryNotification() {
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
    }

    public void flushCodeCache() {
        _flushCodeCache(getV8RuntimePtr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkRuntime(V8Value v8Value) {
        if (v8Value == null || v8Value.isUndefined()) {
            return;
        }
        V8 runtime = v8Value.getRuntime();
        if (runtime == null || runtime.isReleased() || runtime != this) {
            throw new Error("Invalid target runtime");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkThread() {
        if (isReleased()) {
            throw new Error("Runtime disposed error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkScript(String str) {
        if (str == null) {
            throw new NullPointerException("Script is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerCallback(Object obj, Method method, long j, String str, boolean z) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, isVoidMethod(method))), methodDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j, str, true)), methodDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerCallback(JavaCallback javaCallback, long j, String str) {
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j, str, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
    }

    private boolean isVoidMethod(Method method) {
        return method.getReturnType().equals(Void.TYPE);
    }

    private Object getDefaultValue(Class<?> cls) {
        if (cls.equals(V8Object.class)) {
            return new V8Object.Undefined();
        }
        if (cls.equals(V8Array.class)) {
            return new V8Array.Undefined();
        }
        return invalid;
    }

    protected void disposeMethodID(long j) {
        this.functionRegistry.remove(Long.valueOf(j));
    }

    protected void weakReferenceReleased(long j) {
        V8Value v8Value = this.v8WeakReferences.get(Long.valueOf(j));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j));
            try {
                v8Value.release();
            } catch (Exception unused) {
            }
        }
    }

    protected Object callObjectJavaMethod(long j, V8Object v8Object, V8Array v8Array) throws Throwable {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor.callback != null) {
            return checkResult(methodDescriptor.callback.invoke(v8Object, v8Array));
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            try {
                try {
                    return checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
                } catch (IllegalAccessException e) {
                    throw e;
                } catch (IllegalArgumentException e2) {
                    throw e2;
                }
            } catch (InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        } finally {
            releaseArguments(args, isVarArgs);
        }
    }

    private Object checkResult(Object obj) {
        if (obj == null) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (obj instanceof V8Value) {
            if (((V8Value) obj).isReleased()) {
                throw new V8RuntimeException("V8Value already released");
            }
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown return type: ");
        sb.append(obj.getClass());
        throw new V8RuntimeException(sb.toString());
    }

    protected void callVoidJavaMethod(long j, V8Object v8Object, V8Array v8Array) throws Throwable {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor.voidCallback != null) {
            methodDescriptor.voidCallback.invoke(v8Object, v8Array);
            return;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            try {
                methodDescriptor.method.invoke(methodDescriptor.object, args);
            } catch (IllegalAccessException e) {
                throw e;
            } catch (IllegalArgumentException e2) {
                throw e2;
            } catch (InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        } finally {
            releaseArguments(args, isVarArgs);
        }
    }

    private void checkArgs(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj == invalid) {
                throw new IllegalArgumentException("argument type mismatch");
            }
        }
    }

    private void releaseArguments(Object[] objArr, boolean z) {
        if (z && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).release();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).release();
            }
        }
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z) {
        int length = methodDescriptor.method.getParameterTypes().length;
        int i = z ? length - 1 : length;
        Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
        ArrayList arrayList = new ArrayList();
        populateParamters(v8Array, i, defaultValues, arrayList, methodDescriptor.includeReceiver);
        if (z) {
            Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
            defaultValues[i] = varArgContainer;
        }
        return defaultValues;
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i) {
        Class<?> cls = clsArr[clsArr.length - 1];
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return Array.newInstance(cls, i);
    }

    private void populateParamters(V8Array v8Array, int i, Object[] objArr, List<Object> list, boolean z) {
        for (int i2 = z ? 1 : 0; i2 < v8Array.length() + (z ? 1 : 0); i2++) {
            if (i2 >= i) {
                list.add(getArrayItem(v8Array, i2 - (z ? 1 : 0)));
            } else {
                objArr[i2] = getArrayItem(v8Array, i2 - (z ? 1 : 0));
            }
        }
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z) {
        int i = 0;
        if (z) {
            objArr[0] = v8Object;
            i = 1;
        }
        while (i < objArr.length) {
            objArr[i] = getDefaultValue(clsArr[i]);
            i++;
        }
        return objArr;
    }

    private Object getArrayItem(V8Array v8Array, int i) {
        try {
            int type = v8Array.getType(i);
            if (type != 10) {
                if (type != 99) {
                    switch (type) {
                        case 1:
                            return Integer.valueOf(v8Array.getInteger(i));
                        case 2:
                            return Double.valueOf(v8Array.getDouble(i));
                        case 3:
                            return Boolean.valueOf(v8Array.getBoolean(i));
                        case 4:
                            return v8Array.getString(i);
                        case 5:
                        case 8:
                            return v8Array.getArray(i);
                        case 6:
                            return v8Array.getObject(i);
                        case 7:
                            return v8Array.getObject(i);
                        default:
                            return null;
                    }
                }
                return getUndefined();
            }
            return v8Array.get(i);
        } catch (V8ResultUndefined unused) {
            return null;
        }
    }

    public long serialize(long j) {
        return _serialize(this.v8RuntimePtr, j);
    }

    public V8Value deserialize(long j) {
        Object _deserialize = _deserialize(this.v8RuntimePtr, j);
        if (_deserialize instanceof V8Value) {
            return (V8Value) _deserialize;
        }
        return null;
    }

    public void cancelSerialization(long j) {
        _cancelSerialization(j);
    }

    public boolean pumpMessageLoop(boolean z) {
        return _pumpMessageLoop(this.v8RuntimePtr, z);
    }

    public boolean enableDebugAgent(String str) {
        return _enableDebugAgent(getV8RuntimePtr(), str);
    }

    public void dispatchFrontendMessage(long j, String str) {
        _dispatchFrontendMessage(j, str);
    }

    public void dispatchPluginEvent(int i, String str, int i2) {
        _dispatchPluginEvent(this.v8RuntimePtr, i, str, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8Object(long j) {
        return _initNewV8Object(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8Context(long j, long j2) {
        return _initNewV8Context(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enterContext(long j, long j2) {
        _enterContext(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void exitContext(long j, long j2) {
        _exitContext(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getContextGlobalHandle(long j, long j2) {
        return _getContextGlobalHandle(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void debugRegisterContext(long j, String str) {
        _debugRegisterContext(getV8RuntimePtr(), j, str);
    }

    protected void lowMemoryNotification(long j) {
        _lowMemoryNotification(j);
    }

    protected void createTwin(long j, long j2, long j3) {
        _createTwin(j, j2, j3);
    }

    protected int executeIntegerScript(long j, String str, String str2, int i) {
        return _executeIntegerScript(j, str, str2, i);
    }

    protected double executeDoubleScript(long j, String str, String str2, int i) {
        return _executeDoubleScript(j, str, str2, i);
    }

    protected String executeStringScript(long j, String str, String str2, int i) {
        return _executeStringScript(j, str, str2, i);
    }

    protected boolean executeBooleanScript(long j, String str, String str2, int i) {
        return _executeBooleanScript(j, str, str2, i);
    }

    protected Object executeScript(long j, int i, String str, String str2, int i2) {
        return _executeScript(j, i, str, str2, i2);
    }

    protected void executeVoidScript(long j, String str, String str2, int i) {
        _executeVoidScript(j, str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWeak(long j, long j2) {
        _setWeak(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isWeak(long j, long j2) {
        return _isWeak(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release(long j, long j2) {
        _release(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean contains(long j, long j2, String str) {
        return _contains(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getKeys(long j, long j2) {
        return _getKeys(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getInteger(long j, long j2, String str) {
        return _getInteger(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getBoolean(long j, long j2, String str) {
        return _getBoolean(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double getDouble(long j, long j2, String str) {
        return _getDouble(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(long j, long j2, String str) {
        return _getString(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object get(long j, int i, long j2, String str) {
        return _get(j, i, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int executeIntegerFunction(long j, long j2, String str, long j3) {
        return _executeIntegerFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double executeDoubleFunction(long j, long j2, String str, long j3) {
        return _executeDoubleFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String executeStringFunction(long j, long j2, String str, long j3) {
        return _executeStringFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean executeBooleanFunction(long j, long j2, String str, long j3) {
        return _executeBooleanFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object executeFunction(long j, int i, long j2, String str, long j3) {
        return _executeFunction(j, i, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object executeFunction(long j, long j2, long j3, long j4) {
        return _executeFunction(j, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeVoidFunction(long j, long j2, String str, long j3) {
        _executeVoidFunction(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean jsEquals(long j, long j2, long j3) {
        return _equals(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toString(long j, long j2) {
        return _toString(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean strictEquals(long j, long j2, long j3) {
        return _strictEquals(j, j2, j3);
    }

    protected boolean sameValue(long j, long j2, long j3) {
        return _sameValue(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int identityHash(long j, long j2) {
        return _identityHash(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j, long j2, String str, int i) {
        _add(j, j2, str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addObject(long j, long j2, String str, long j3) {
        _addObject(j, j2, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j, long j2, String str, boolean z) {
        _add(j, j2, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j, long j2, String str, double d) {
        _add(j, j2, str, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j, long j2, String str, String str2) {
        if (str2 == null) {
            _addNull(j, j2, str);
        } else {
            _add(j, j2, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addUndefined(long j, long j2, String str) {
        _addUndefined(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addNull(long j, long j2, String str) {
        _addNull(j, j2, str);
    }

    protected long registerJavaMethod(long j, long j2, String str, boolean z) {
        return _registerJavaMethod(j, j2, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        return _initNewV8ArrayBuffer(j, byteBuffer, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8ArrayBuffer(long j, int i) {
        return _initNewV8ArrayBuffer(j, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        return _createV8ArrayBufferBackingStore(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8Array(long j) {
        return _initNewV8Array(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long[] initNewV8Function(long j) {
        checkThread();
        return _initNewV8Function(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetSize(long j, long j2) {
        return _arrayGetSize(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetInteger(long j, long j2, int i) {
        return _arrayGetInteger(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arrayGetBoolean(long j, long j2, int i) {
        return _arrayGetBoolean(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte arrayGetByte(long j, long j2, int i) {
        return _arrayGetByte(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double arrayGetDouble(long j, long j2, int i) {
        return _arrayGetDouble(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String arrayGetString(long j, long j2, int i) {
        return _arrayGetString(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object arrayGet(long j, int i, long j2, int i2) {
        return _arrayGet(j, i, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayIntItem(long j, long j2, int i) {
        _addArrayIntItem(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayBooleanItem(long j, long j2, boolean z) {
        _addArrayBooleanItem(j, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayDoubleItem(long j, long j2, double d) {
        _addArrayDoubleItem(j, j2, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayStringItem(long j, long j2, String str) {
        if (str == null) {
            _addArrayNullItem(j, j2);
        } else {
            _addArrayStringItem(j, j2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayObjectItem(long j, long j2, long j3) {
        _addArrayObjectItem(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayUndefinedItem(long j, long j2) {
        _addArrayUndefinedItem(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayNullItem(long j, long j2) {
        _addArrayNullItem(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j, long j2) {
        return _getType(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j, long j2, String str) {
        return _getType(j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j, long j2, int i) {
        return _getType(j, j2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getArrayType(long j, long j2) {
        return _getArrayType(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j, long j2, int i, int i2) {
        return _getType(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrototype(long j, long j2, long j3) {
        _setPrototype(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] arrayGetIntegers(long j, long j2, int i, int i2) {
        return _arrayGetIntegers(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double[] arrayGetDoubles(long j, long j2, int i, int i2) {
        return _arrayGetDoubles(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean[] arrayGetBooleans(long j, long j2, int i, int i2) {
        return _arrayGetBooleans(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] arrayGetBytes(long j, long j2, int i, int i2) {
        return _arrayGetBytes(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] arrayGetStrings(long j, long j2, int i, int i2) {
        return _arrayGetStrings(j, j2, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetIntegers(long j, long j2, int i, int i2, int[] iArr) {
        return _arrayGetIntegers(j, j2, i, i2, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetDoubles(long j, long j2, int i, int i2, double[] dArr) {
        return _arrayGetDoubles(j, j2, i, i2, dArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetBooleans(long j, long j2, int i, int i2, boolean[] zArr) {
        return _arrayGetBooleans(j, j2, i, i2, zArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetBytes(long j, long j2, int i, int i2, byte[] bArr) {
        return _arrayGetBytes(j, j2, i, i2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetStrings(long j, long j2, int i, int i2, String[] strArr) {
        return _arrayGetStrings(j, j2, i, i2, strArr);
    }

    protected void terminateExecution(long j) {
        _terminateExecution(j);
    }

    protected void releaseMethodDescriptor(long j, long j2) {
        _releaseMethodDescriptor(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addObjRef(V8Value v8Value) {
        this.objectReferences++;
        if (this.referenceHandlers.isEmpty()) {
            return;
        }
        notifyReferenceCreated(v8Value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseObjRef(V8Value v8Value) {
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
    }
}
