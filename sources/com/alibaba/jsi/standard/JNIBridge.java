package com.alibaba.jsi.standard;

import com.alibaba.jsi.standard.js.JSException;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class JNIBridge {
    static final int kCmdExternalMemoryChange = 9;
    static final int kCmdGetContextId = 2;
    static final int kCmdGetGroupId = 6;
    static final int kCmdGetOrigin = 8;
    static final int kCmdGetSoLoadError = 4;
    static final int kCmdGetVersionInt = 3;
    static final int kCmdLoadJSEngineSo = 1;
    static final int kCmdSetGroup = 5;
    static final int kCmdSetOrigin = 7;
    static final int kCmdStartRemoteInspect = 10;
    static final int kCmdStopRemoteInspect = 11;
    private static final int kNativeEventCreatePage = 4;
    private static final int kNativeEventDisposePage = 5;
    private static final int kNativeEventJSEngineCreate = 2;
    private static final int kNativeEventJSEngineDispose = 3;
    private static final int kNativeEventJSException = 8;
    private static final int kNativeEventReloadPage = 7;
    private static final int kNativeEventRequestMainLoop = 1;
    private static final int kNativeEventResetPage = 6;

    public static native long nativeCommand(long j, long j2, Object[] objArr);

    public static native long nativeCreateContext(long j, String str, HashSet<Object> hashSet);

    public static native void nativeDisposeContext(long j, long j2);

    public static native void nativeDisposeInstance(long j);

    public static native Object nativeExecuteJS(long j, long j2, String str, String str2);

    public static native String nativeGetVersion(String str);

    public static native long nativeInitInstance(String str, String str2, String str3);

    public static native void nativeOnLoop(long j);

    public static native void nativeOnLowMemory(long j);

    public static native void nativeResetContext(long j, long j2);

    public static native boolean nativeSetInfo(long j, String str, String str2, long j2);

    public static native boolean nativeStartTrace(long j, String str, String str2);

    public static native void nativeStopTrace(long j);

    JNIBridge() {
    }

    static long onNativeEvent(long j, int i, long j2, Object[] objArr) {
        JSEngine jSEngine;
        JSContext context;
        JSEngine jSEngine2;
        JSContext context2;
        switch (i) {
            case 1:
                if (j2 >= 0 && (jSEngine = JSEngine.getInstance(j)) != null) {
                    jSEngine.requestLoopAsync(j2);
                    break;
                }
                break;
            case 2:
                if (objArr != null && objArr.length >= 2) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        Object obj2 = objArr[1];
                        if (obj2 instanceof String) {
                            JSEngine.createInstanceImpl(null, (String) obj, (String) obj2, "", "", 0, j, null);
                            break;
                        }
                    }
                }
                break;
            case 3:
                JSEngine.getInstance(j).dispose(true);
                break;
            case 4:
                if (objArr != null && objArr.length > 0) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof String) {
                        return JSEngine.getInstance(j).createContext((String) obj3).getId();
                    }
                }
                return 0L;
            case 5:
                if (objArr != null && objArr.length > 0) {
                    Object obj4 = objArr[0];
                    if (obj4 instanceof Boolean) {
                        boolean booleanValue = ((Boolean) obj4).booleanValue();
                        JSEngine jSEngine3 = JSEngine.getInstance(j);
                        JSContext context3 = jSEngine3.getContext(j2);
                        if (context3 != null) {
                            context3.dispose();
                            if (booleanValue) {
                                jSEngine3.removeContext(context3);
                                break;
                            }
                        }
                    }
                }
                break;
            case 6:
                JSContext context4 = JSEngine.getInstance(j).getContext(j2);
                if (context4 != null) {
                    context4.reset();
                    break;
                }
                break;
            case 7:
                JSEngine jSEngine4 = JSEngine.getInstance(j);
                if (jSEngine4 != null && (context = jSEngine4.getContext(j2)) != null) {
                    context.onReload();
                    break;
                }
                break;
            case 8:
                if (objArr == null || objArr.length < 2 || !(objArr[0] instanceof Integer) || !(objArr[1] instanceof JSException) || (jSEngine2 = JSEngine.getInstance(j)) == null || (context2 = jSEngine2.getContext(j2)) == null) {
                    return 0L;
                }
                return context2.onUncaughtJSException((JSException) objArr[1], ((Integer) objArr[0]).intValue()) ? 1L : 2L;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown JSI native event: ");
                sb.append(i);
                OSUtil.e(sb.toString());
                break;
        }
        return 0L;
    }
}
