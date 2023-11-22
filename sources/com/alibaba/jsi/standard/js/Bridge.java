package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.JSEngine;
import com.alibaba.jsi.standard.OSUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Bridge {
    private static final String TAG = "jsi";
    static final int kArgumentsCount = 700;
    static final int kArgumentsGet = 701;
    static final int kArgumentsGetArguments = 707;
    static final int kArgumentsGetContext = 702;
    static final int kArgumentsGetFunctionName = 704;
    static final int kArgumentsIsConstructCall = 705;
    static final int kArgumentsNewTarget = 706;
    static final int kArgumentsThiz = 703;
    static final int kBooleanObjectValueOf = 301;
    public static final int kContextGetException = 12;
    public static final int kContextGetGlobalObject = 10;
    public static final int kContextHasException = 11;
    public static final int kContextThrowException = 13;
    static final int kDeleteArguments = 3;
    static final int kDeleteException = 4;
    static final int kDeleteJSValue = 1;
    static final int kDeleteTemplate = 2;
    static final int kGetJSValueClass = 1;
    static final int kJSArrayBufferByteLength = 503;
    static final int kJSArrayBufferByteOffset = 504;
    static final int kJSArrayBufferData = 505;
    static final int kJSArrayBufferDetach = 506;
    static final int kJSArrayBufferGetType = 500;
    static final int kJSArrayBufferIsExternal = 501;
    static final int kJSArrayBufferLength = 502;
    static final int kJSArrayGetLength = 200;
    public static final int kJSEngineCreate = 8;
    static final int kJSEngineEnter = 1;
    static final int kJSEngineExit = 2;
    public static final int kJSEngineGetCurrentType = 6;
    public static final int kJSEngineGetType = 4;
    public static final int kJSEngineMultiJSEngine = 7;
    public static final int kJSEngineSetStatObjects = 5;
    static final int kJSExceptionGetMessage = 602;
    static final int kJSExceptionGetName = 601;
    static final int kJSExceptionGetStack = 603;
    static final int kJSExceptionGetValue = 604;
    static final int kJSExceptionToString = 600;
    static final int kJSFunctionCall = 550;
    static final int kJSFunctionDetach = 553;
    static final int kJSFunctionGetCallback = 554;
    static final int kJSFunctionGetName = 551;
    static final int kJSFunctionNewInstance = 552;
    static final int kJSMapAsArray = 236;
    static final int kJSMapClear = 231;
    static final int kJSMapGetSize = 230;
    static final int kJSMapGetValue = 232;
    static final int kJSMapHasValue = 234;
    static final int kJSMapRemoveValue = 235;
    static final int kJSMapSetValue = 233;
    static final int kJSObjectDetachJSCallback = 122;
    static final int kJSObjectGetJSCallback = 119;
    static final int kJSObjectGetJSEngine = 118;
    static final int kJSObjectGetOwnPropertyNames = 111;
    static final int kJSObjectGetOwnPropertyNames2 = 124;
    static final int kJSObjectGetPrivate = 113;
    static final int kJSObjectGetPropertyAttributes = 120;
    static final int kJSObjectGetPropertyNames = 110;
    static final int kJSObjectGetPropertyNames2 = 123;
    static final int kJSObjectGetPrototype = 116;
    static final int kJSObjectHasPrivate = 115;
    static final int kJSObjectIndexedGet = 103;
    static final int kJSObjectIndexedHas = 107;
    static final int kJSObjectIndexedHasOwn = 109;
    static final int kJSObjectIndexedRemove = 105;
    static final int kJSObjectIndexedSet = 101;
    static final int kJSObjectNamedGet = 102;
    static final int kJSObjectNamedHas = 106;
    static final int kJSObjectNamedHasOwn = 108;
    static final int kJSObjectNamedRemove = 104;
    static final int kJSObjectNamedSet = 100;
    static final int kJSObjectRemovePrivate = 114;
    static final int kJSObjectSetIntegrityLevel = 121;
    static final int kJSObjectSetPrivate = 112;
    static final int kJSObjectSetPrototype = 117;
    static final int kJSPromiseCatch = 421;
    static final int kJSPromiseHasHandler = 422;
    static final int kJSPromiseResolverGetPromise = 400;
    static final int kJSPromiseResolverReject = 402;
    static final int kJSPromiseResolverResolve = 401;
    static final int kJSPromiseResult = 423;
    static final int kJSPromiseState = 424;
    static final int kJSPromiseThen = 420;
    static final int kJSSetAddValue = 262;
    static final int kJSSetAsArray = 265;
    static final int kJSSetClear = 261;
    static final int kJSSetGetSize = 260;
    static final int kJSSetHasValue = 263;
    static final int kJSSetRemoveValue = 264;
    static final int kJSSymbolGetName = 80;
    static final int kJSTypeArguments = 19;
    static final int kJSTypeArrayBuffer = 11;
    static final int kJSTypeBoolean = 1;
    static final int kJSTypeBooleanObject = 15;
    static final int kJSTypeDouble = 3;
    static final int kJSTypeException = 21;
    static final int kJSTypeFunction = 12;
    static final int kJSTypeInteger = 2;
    static final int kJSTypeJSArray = 8;
    static final int kJSTypeJSMap = 9;
    static final int kJSTypeJSObject = 7;
    static final int kJSTypeJSSet = 10;
    static final int kJSTypeNumberObject = 16;
    static final int kJSTypePromise = 13;
    static final int kJSTypePromiseResolver = 14;
    static final int kJSTypeString = 4;
    static final int kJSTypeStringObject = 17;
    static final int kJSTypeSymbol = 5;
    static final int kJSTypeSymbolObject = 18;
    static final int kJSTypeTemplate = 20;
    static final int kJSTypeTemplateInEngine = 22;
    static final int kJSTypeVoid = 6;
    static final int kJSValueBlobDelete = 752;
    static final int kJSValueBlobDeserialize = 751;
    static final int kJSValueBlobSerialize = 750;
    static final int kJSValueCopy = 51;
    static final int kJSValueCreateWeak = 53;
    static final int kJSValueEquals = 52;
    static final int kJSValueLockWeak = 54;
    static final int kJSValueToString = 50;
    static final int kJSValueWeakExpired = 55;
    static final int kNumberObjectValueOf = 300;
    static final int kStringObjectValueOf = 302;
    static final int kSymbolObjectValueOf = 303;
    static final int kTemplateAddAccessor = 651;
    static final int kTemplateAddFunction = 650;
    static final int kTemplateAddPrimitive = 652;
    static final int kTemplateNewJSClass = 654;
    static final int kTemplateNewJSObject = 653;

    private static native Object nativeCmd(long j, int i, long j2, long j3, Object[] objArr);

    private static native long nativeCreate(long j, int i, long j2, double d, Object[] objArr);

    public static native void nativeDelete(long j, int i);

    protected static Object createJavaPrimitive(int i, boolean z, double d, String str) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 6) {
                            return z ? JSVoid.undefinedValue() : JSVoid.nullValue();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Create JSI primitive java object with unknown type: ");
                        sb.append(i);
                        OSUtil.w(sb.toString());
                        return null;
                    }
                    return new JSString(str);
                }
                return new JSNumber(d);
            }
            return new JSNumber((int) d);
        }
        return JSBoolean.valueFor(z);
    }

    protected static int getPrimitiveType(Object obj) {
        if (obj instanceof JSValue) {
            JSValue jSValue = (JSValue) obj;
            if (jSValue.isBoolean()) {
                return 1;
            }
            if (jSValue.isNumber()) {
                return ((JSNumber) jSValue).isInteger() ? 2 : 3;
            } else if (jSValue.isString()) {
                return 4;
            } else {
                return jSValue.isVoid() ? 6 : 0;
            }
        }
        return 0;
    }

    protected static boolean getBooleanValue(Object obj) {
        return ((JSBoolean) obj).valueOf();
    }

    protected static double getNumberValue(Object obj) {
        return ((JSNumber) obj).valueOf();
    }

    protected static String getStringValue(Object obj) {
        return ((JSString) obj).valueOf();
    }

    protected static boolean voidIsUndefined(Object obj) {
        return ((JSVoid) obj).isUndefined();
    }

    protected static Object get(int i, long j, Object obj) {
        if (i != 1) {
            return null;
        }
        return JSValue.class;
    }

    protected static Object createJava(int i, long j, long j2) {
        if (19 == i) {
            return new Arguments(j2);
        }
        JSContext context = toContext(j);
        switch (i) {
            case 5:
                return new JSSymbol(context, j2);
            case 6:
            case 14:
            case 19:
            case 20:
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Create JSI java object with unknown type: ");
                sb.append(i);
                OSUtil.w(sb.toString());
                return null;
            case 7:
                return new JSObject(context, j2);
            case 8:
                return new JSArray(context, j2);
            case 9:
                return new JSMap(context, j2);
            case 10:
                return new JSSet(context, j2);
            case 11:
                return new JSArrayBuffer(context, j2);
            case 12:
                return new JSFunction(context, j2);
            case 13:
                return new JSPromise(context, j2);
            case 15:
                return new JSBooleanObject(context, j2);
            case 16:
                return new JSNumberObject(context, j2);
            case 17:
                return new JSStringObject(context, j2);
            case 18:
                return new JSSymbolObject(context, j2);
            case 21:
                return new JSException(context, j2);
        }
    }

    protected static long getNativePtr(Object obj) {
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof JSValue) {
            return ((JSValue) obj).mNativePtr;
        }
        if (obj instanceof Arguments) {
            return ((Arguments) obj).mNativePtr;
        }
        if (obj instanceof JSException) {
            return ((JSException) obj).mNativePtr;
        }
        if (obj instanceof Template) {
            return ((Template) obj).mNativePtr;
        }
        return 0L;
    }

    protected static boolean detachNative(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof JSValue) {
            ((JSValue) obj).detach();
            return true;
        } else if (obj instanceof Arguments) {
            ((Arguments) obj).detach();
            return true;
        } else if (obj instanceof JSException) {
            ((JSException) obj).detach();
            return true;
        } else if (obj instanceof Template) {
            ((Template) obj).detach();
            return true;
        } else {
            return false;
        }
    }

    public static long createNative(JSContext jSContext, int i) {
        return nativeCreate(contextNativePtr(jSContext), i, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null);
    }

    public static long createNative(JSContext jSContext, int i, Object[] objArr) {
        return nativeCreate(contextNativePtr(jSContext), i, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, objArr);
    }

    public static long createNative(JSContext jSContext, int i, long j) {
        return nativeCreate(contextNativePtr(jSContext), i, j, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null);
    }

    public static long createNative(JSContext jSContext, int i, long j, double d) {
        return nativeCreate(contextNativePtr(jSContext), i, j, d, null);
    }

    public static long createNative(JSContext jSContext, int i, long j, double d, Object[] objArr) {
        return nativeCreate(contextNativePtr(jSContext), i, j, d, objArr);
    }

    public static long createNative(JSEngine jSEngine, int i, long j, double d, Object[] objArr) {
        return nativeCreate(engineNativePtr(jSEngine), i, j, d, objArr);
    }

    private static long contextNativePtr(JSContext jSContext) {
        if (jSContext == null) {
            return 0L;
        }
        return jSContext.getNativePtr();
    }

    private static long engineNativePtr(JSEngine jSEngine) {
        if (jSEngine == null) {
            return 0L;
        }
        return jSEngine.getNativeInstance();
    }

    public static Object cmd(JSContext jSContext, int i) {
        return nativeCmd(contextNativePtr(jSContext), i, 0L, 0L, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object cmd(JSContext jSContext, int i, long j) {
        return nativeCmd(contextNativePtr(jSContext), i, j, 0L, null);
    }

    public static Object cmd(JSContext jSContext, int i, Object[] objArr) {
        return nativeCmd(contextNativePtr(jSContext), i, 0L, 0L, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object cmd(JSContext jSContext, int i, long j, long j2) {
        return nativeCmd(contextNativePtr(jSContext), i, j, j2, null);
    }

    public static Object cmd(JSContext jSContext, int i, long j, Object[] objArr) {
        return nativeCmd(contextNativePtr(jSContext), i, j, 0L, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object cmd(JSContext jSContext, int i, long j, long j2, Object[] objArr) {
        return nativeCmd(contextNativePtr(jSContext), i, j, j2, objArr);
    }

    public static Object engineCmd(JSEngine jSEngine, int i, long j) {
        return nativeCmd(engineNativePtr(jSEngine), i, j, 0L, null);
    }

    public static Object engineCmd(JSEngine jSEngine, int i, long j, Object[] objArr) {
        return nativeCmd(engineNativePtr(jSEngine), i, j, 0L, objArr);
    }

    private static JSCallback unwrap(Object obj) {
        return (JSCallback) obj;
    }

    private static JSContext toContext(long j) {
        return JSContext.getContext(j);
    }

    protected static Object onCallFunction(Object obj, Object obj2) {
        return unwrap(obj).onCallFunction((Arguments) obj2);
    }

    protected static Object onCallConstructor(Object obj, Object obj2) {
        return unwrap(obj).onCallConstructor((Arguments) obj2);
    }

    protected static Object onGetProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).onGetProperty(toContext(j), (JSValue) obj2, str);
    }

    protected static void onSetProperty(Object obj, long j, Object obj2, String str, Object obj3) {
        unwrap(obj).onSetProperty(toContext(j), (JSValue) obj2, str, (JSValue) obj3);
    }

    protected static Object onGetNamedProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).onGetNamedProperty(toContext(j), (JSValue) obj2, str);
    }

    protected static Object onSetNamedProperty(Object obj, long j, Object obj2, String str, Object obj3) {
        return unwrap(obj).onSetNamedProperty(toContext(j), (JSValue) obj2, str, (JSValue) obj3);
    }

    protected static int onQueryNamedProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).onQueryNamedProperty(toContext(j), (JSValue) obj2, str);
    }

    protected static boolean onDeleteNamedProperty(Object obj, long j, Object obj2, String str) {
        return unwrap(obj).onDeleteNamedProperty(toContext(j), (JSValue) obj2, str);
    }

    protected static Object[] onEnumerateNamedProperty(Object obj, long j, Object obj2) {
        return unwrap(obj).onEnumerateNamedProperty(toContext(j), (JSValue) obj2);
    }

    protected static Object onGetIndexedProperty(Object obj, long j, Object obj2, int i) {
        return unwrap(obj).onGetIndexedProperty(toContext(j), (JSValue) obj2, i);
    }

    protected static Object onSetIndexedProperty(Object obj, long j, Object obj2, int i, Object obj3) {
        return unwrap(obj).onSetIndexedProperty(toContext(j), (JSValue) obj2, i, (JSValue) obj3);
    }

    protected static int onQueryIndexedProperty(Object obj, long j, Object obj2, int i) {
        return unwrap(obj).onQueryIndexedProperty(toContext(j), (JSValue) obj2, i);
    }

    protected static boolean onDeleteIndexedProperty(Object obj, long j, Object obj2, int i) {
        return unwrap(obj).onDeleteIndexedProperty(toContext(j), (JSValue) obj2, i);
    }

    protected static Object[] onEnumerateIndexedProperty(Object obj, long j, Object obj2) {
        return unwrap(obj).onEnumerateIndexedProperty(toContext(j), (JSValue) obj2);
    }

    protected static void onJSCallbackDetached(Object obj) {
        unwrap(obj).onDetached();
    }
}
