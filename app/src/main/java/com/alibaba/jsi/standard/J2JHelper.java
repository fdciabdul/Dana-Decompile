package com.alibaba.jsi.standard;

import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.Deletable;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSBoolean;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSException;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSNumber;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSString;
import com.alibaba.jsi.standard.js.JSSymbol;
import com.alibaba.jsi.standard.js.JSValue;
import com.alibaba.jsi.standard.js.JSVoid;
import com.alibaba.jsi.standard.js.JSWeakValue;
import com.alibaba.jsi.standard.js.Template;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public class J2JHelper {
    private final JSContext mContext;
    private final Map<String, JSFunction> mClasses = new HashMap();
    private final Map<String, Object> mJavaObjects = new HashMap();
    private final Map<Object, JSObjectHolder> mJSObjects = new WeakHashMap();
    private final Map<JSObjectHolder, Object> mJSObjectHolders = new WeakHashMap();
    private Template mArrayObjectTemplate = null;
    private final Map<Class, Template> mObjectTemplates = new HashMap();
    private final Map<Class, Template> mClassPrototypeTemplates = new HashMap();
    private final List<Deletable> mUnusedObjects = new ArrayList();
    private boolean mAddSuper = true;
    private boolean mAddField = true;
    private boolean mSupportClass = false;
    private boolean mAddClassObject = false;
    private boolean mAddInnerClass = true;
    private boolean mSupportUnknownJSObject = false;
    private Class<? extends Annotation> mAnnotationClass = null;
    private boolean mIsClearingObjects = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J2JHelper(JSContext jSContext) {
        this.mContext = jSContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initialize(Object obj, Class<? extends Annotation> cls) {
        this.mAnnotationClass = cls;
        if (obj == null) {
            return;
        }
        this.mAddSuper = OSUtil.getBooleanValueFromArgs(obj, "javaSuper", this.mAddSuper);
        this.mAddField = OSUtil.getBooleanValueFromArgs(obj, "javaField", this.mAddField);
        this.mSupportClass = OSUtil.getBooleanValueFromArgs(obj, "javaClass", this.mSupportClass);
        this.mAddClassObject = OSUtil.getBooleanValueFromArgs(obj, "classObject", this.mAddClassObject);
        this.mAddInnerClass = OSUtil.getBooleanValueFromArgs(obj, "innerClass", this.mAddInnerClass);
        this.mSupportUnknownJSObject = OSUtil.getBooleanValueFromArgs(obj, "jsObject", this.mSupportUnknownJSObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        clearTemplates();
        deleteUnusedObjects();
        clearJavaObjects();
        clearJavaClasses(this.mContext);
    }

    private void clearTemplates() {
        Template template = this.mArrayObjectTemplate;
        if (template != null) {
            template.delete();
            this.mArrayObjectTemplate = null;
        }
        Iterator<Template> it = this.mObjectTemplates.values().iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
        this.mObjectTemplates.clear();
        Iterator<Template> it2 = this.mClassPrototypeTemplates.values().iterator();
        while (it2.hasNext()) {
            it2.next().delete();
        }
        this.mClassPrototypeTemplates.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteUnusedObjects() {
        JSEngine jSEngine = this.mContext.getJSEngine();
        synchronized (this.mUnusedObjects) {
            if (this.mUnusedObjects.isEmpty()) {
                return;
            }
            if (jSEngine.isDisposed()) {
                this.mUnusedObjects.clear();
                return;
            }
            EngineScope engineScope = new EngineScope(jSEngine);
            try {
                synchronized (this.mUnusedObjects) {
                    Iterator<Deletable> it = this.mUnusedObjects.iterator();
                    while (it.hasNext()) {
                        it.next().delete();
                    }
                    this.mUnusedObjects.clear();
                }
            } finally {
                engineScope.exit();
            }
        }
    }

    private void syncDeleteUnusedObjectsIfTooMany() {
        synchronized (this.mUnusedObjects) {
            if (this.mUnusedObjects.size() >= 30) {
                Iterator<Deletable> it = this.mUnusedObjects.iterator();
                while (it.hasNext()) {
                    it.next().delete();
                }
                this.mUnusedObjects.clear();
            }
        }
    }

    public void markUnused(Deletable deletable) {
        if (deletable == null) {
            return;
        }
        synchronized (this.mUnusedObjects) {
            this.mUnusedObjects.add(deletable);
        }
        this.mContext.getJSEngine().notifyDeleteUnusedObjects(this.mContext);
    }

    public boolean addJavaObject(String str, Object obj) {
        if (this.mJavaObjects.get(str) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Java object with name \"");
            sb.append(str);
            sb.append("\" already exists");
            OSUtil.w(sb.toString());
            return false;
        }
        JSObject javaObjectToJS = javaObjectToJS(this.mContext, obj);
        if (javaObjectToJS == null) {
            return false;
        }
        this.mJavaObjects.put(str, obj);
        JSObject globalObject = this.mContext.globalObject();
        boolean z = globalObject.set(this.mContext, str, javaObjectToJS);
        javaObjectToJS.delete();
        globalObject.delete();
        return z;
    }

    public boolean removeJavaObject(String str) {
        Object obj = this.mJavaObjects.get(str);
        if (obj == null) {
            return false;
        }
        detachJavaObject(obj);
        JSObject globalObject = this.mContext.globalObject();
        globalObject.remove(this.mContext, str);
        globalObject.delete();
        this.mJavaObjects.remove(str);
        return true;
    }

    public boolean detachJavaObject(Object obj) {
        JSObjectHolder remove;
        if (this.mIsClearingObjects || (remove = this.mJSObjects.remove(obj)) == null) {
            return false;
        }
        boolean detach = remove.detach(true);
        this.mJSObjectHolders.remove(remove);
        return detach;
    }

    public boolean addJavaClass(Class cls, String str) {
        JSFunction importJavaClass = importJavaClass(this.mContext, cls, str);
        if (importJavaClass != null) {
            importJavaClass.delete();
            return true;
        }
        return false;
    }

    public void enableImportClass() {
        if (!this.mSupportClass) {
            OSUtil.w("\"javaClass\" is not enabled!");
            return;
        }
        JSFunction jSFunction = new JSFunction(this.mContext, new JSCallback() { // from class: com.alibaba.jsi.standard.J2JHelper.1
            /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
            @Override // com.alibaba.jsi.standard.js.JSCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.alibaba.jsi.standard.js.JSValue onCallFunction(com.alibaba.jsi.standard.js.Arguments r8) {
                /*
                    r7 = this;
                    com.alibaba.jsi.standard.JSContext r0 = r8.getContext()
                    int r1 = r8.count()
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == r3) goto L19
                    int r1 = r8.count()
                    if (r1 == r2) goto L19
                    java.lang.String r8 = "importClass only accept 1 or 2 string argument(s)"
                    com.alibaba.jsi.standard.J2JHelper.access$000(r0, r8)
                    return r4
                L19:
                    r1 = 0
                    com.alibaba.jsi.standard.js.JSValue r5 = r8.get(r1)
                    boolean r6 = r5 instanceof com.alibaba.jsi.standard.js.JSString
                    if (r6 != 0) goto L2d
                    if (r5 == 0) goto L27
                    r5.delete()
                L27:
                    java.lang.String r8 = "importClass argument 0 must be a string"
                    com.alibaba.jsi.standard.J2JHelper.access$000(r0, r8)
                    return r4
                L2d:
                    int r6 = r8.count()
                    if (r6 != r2) goto L4d
                    com.alibaba.jsi.standard.js.JSValue r8 = r8.get(r3)
                    boolean r2 = r8 instanceof com.alibaba.jsi.standard.js.JSString
                    if (r2 != 0) goto L46
                    if (r8 == 0) goto L40
                    r8.delete()
                L40:
                    java.lang.String r8 = "importClass argument 1 must be a string"
                    com.alibaba.jsi.standard.J2JHelper.access$000(r0, r8)
                    return r4
                L46:
                    com.alibaba.jsi.standard.js.JSString r8 = (com.alibaba.jsi.standard.js.JSString) r8
                    java.lang.String r8 = r8.valueOf()
                    goto L4e
                L4d:
                    r8 = r4
                L4e:
                    com.alibaba.jsi.standard.js.JSString r5 = (com.alibaba.jsi.standard.js.JSString) r5
                    java.lang.String r2 = r5.valueOf()
                    java.lang.Class r1 = java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L59
                    goto La3
                L59:
                    r5 = 46
                    int r5 = r2.lastIndexOf(r5)
                    if (r5 <= 0) goto L8b
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r1 = r2.substring(r1, r5)
                    r6.append(r1)
                    java.lang.String r1 = "$"
                    r6.append(r1)
                    int r5 = r5 + r3
                    java.lang.String r1 = r2.substring(r5)
                    r6.append(r1)
                    java.lang.String r1 = r6.toString()
                    java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L8b
                    if (r8 != 0) goto L8c
                    java.lang.String r8 = r2.substring(r5)     // Catch: java.lang.ClassNotFoundException -> L89
                    goto L8c
                L89:
                    goto L8c
                L8b:
                    r1 = r4
                L8c:
                    if (r1 != 0) goto La3
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    r8.<init>()
                    java.lang.String r1 = "can not found java class "
                    r8.append(r1)
                    r8.append(r2)
                    java.lang.String r8 = r8.toString()
                    com.alibaba.jsi.standard.J2JHelper.access$000(r0, r8)
                    return r4
                La3:
                    com.alibaba.jsi.standard.J2JHelper r2 = com.alibaba.jsi.standard.J2JHelper.this
                    com.alibaba.jsi.standard.js.JSFunction r8 = com.alibaba.jsi.standard.J2JHelper.access$100(r2, r0, r1, r8)
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.AnonymousClass1.onCallFunction(com.alibaba.jsi.standard.js.Arguments):com.alibaba.jsi.standard.js.JSValue");
            }
        }, "importClass");
        JSObject globalObject = this.mContext.globalObject();
        globalObject.set(this.mContext, "importClass", jSFunction);
        globalObject.delete();
        jSFunction.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ArrayObjectCallback extends JSCallback {
        private final Class mElementType;
        private final Object mObject;

        ArrayObjectCallback(Object obj) {
            this.mObject = obj;
            this.mElementType = obj.getClass().getComponentType();
        }

        Object getObject() {
            return this.mObject;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public String getIdentifier() {
            return this.mObject.toString();
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public void onDetached() {
            JSObjectHolder jSObjectHolder;
            if (J2JHelper.this.mIsClearingObjects || (jSObjectHolder = (JSObjectHolder) J2JHelper.this.mJSObjects.remove(this.mObject)) == null) {
                return;
            }
            jSObjectHolder.detach(false);
            J2JHelper.this.mJSObjectHolders.remove(jSObjectHolder);
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onGetIndexedProperty(JSContext jSContext, JSValue jSValue, int i) {
            jSValue.delete();
            try {
                return J2JHelper.this.javaToJS(jSContext, Array.get(this.mObject, i));
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Get array element at ");
                sb.append(i);
                sb.append(" failed: ");
                sb.append(th.toString());
                J2JHelper.throwException(jSContext, sb.toString(), th);
                return null;
            }
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onSetIndexedProperty(JSContext jSContext, JSValue jSValue, int i, JSValue jSValue2) {
            Throwable th;
            Object obj;
            jSValue.delete();
            Class cls = this.mElementType;
            if (cls != null) {
                J2JHelper j2JHelper = J2JHelper.this;
                if (j2JHelper.match(cls, j2JHelper.getJSType(jSContext, jSValue2))) {
                    try {
                        obj = J2JHelper.this.jsToJava(jSContext, jSValue2);
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                    }
                    try {
                        Array.set(this.mObject, i, obj);
                        return jSValue2;
                    } catch (Throwable th3) {
                        th = th3;
                        jSValue2.delete();
                        if (obj instanceof JSValue) {
                            ((JSValue) obj).delete();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Set array element at ");
                        sb.append(i);
                        sb.append(" failed: ");
                        sb.append(th.toString());
                        J2JHelper.throwException(jSContext, sb.toString(), th);
                        return null;
                    }
                }
            }
            jSValue2.delete();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Set a mismatch value type into array at index ");
            sb2.append(i);
            J2JHelper.throwException(jSContext, sb2.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ObjectFieldsCallback extends JSCallback {
        private final Class mClass;
        private final Object mObject;

        ObjectFieldsCallback(Object obj) {
            this.mObject = obj;
            this.mClass = obj.getClass();
        }

        Object getObject() {
            return this.mObject;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public String getIdentifier() {
            return this.mObject.toString();
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public void onDetached() {
            JSObjectHolder jSObjectHolder;
            if (J2JHelper.this.mIsClearingObjects || (jSObjectHolder = (JSObjectHolder) J2JHelper.this.mJSObjects.remove(this.mObject)) == null) {
                return;
            }
            jSObjectHolder.detach(false);
            J2JHelper.this.mJSObjectHolders.remove(jSObjectHolder);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // com.alibaba.jsi.standard.js.JSCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.alibaba.jsi.standard.js.JSValue onGetProperty(com.alibaba.jsi.standard.JSContext r5, com.alibaba.jsi.standard.js.JSValue r6, java.lang.String r7) {
            /*
                r4 = this;
                r6.delete()
                java.lang.Object r6 = r4.mObject
                r0 = 0
                if (r6 != 0) goto L1d
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = "Java object has been detached while getting "
                r6.append(r1)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r6)
                return r0
            L1d:
                r6 = 1
                java.lang.Class r1 = r4.mClass     // Catch: java.lang.NoSuchFieldException -> L28
                java.lang.reflect.Field r1 = r1.getField(r7)     // Catch: java.lang.NoSuchFieldException -> L28
                r1.setAccessible(r6)     // Catch: java.lang.NoSuchFieldException -> L29
                goto L3d
            L28:
                r1 = r0
            L29:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not found property "
                r2.append(r3)
                r2.append(r7)
                java.lang.String r2 = r2.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r2)
            L3d:
                if (r1 == 0) goto L8a
                int r2 = r1.getModifiers()
                r2 = r2 & 9
                if (r2 == r6) goto L5c
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = "No property named "
                r6.append(r1)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r6)
                goto L8a
            L5c:
                java.lang.Object r6 = r4.mObject     // Catch: java.lang.Throwable -> L69
                java.lang.Object r6 = r1.get(r6)     // Catch: java.lang.Throwable -> L69
                com.alibaba.jsi.standard.J2JHelper r1 = com.alibaba.jsi.standard.J2JHelper.this     // Catch: java.lang.Throwable -> L69
                com.alibaba.jsi.standard.js.JSValue r0 = r1.javaToJS(r5, r6)     // Catch: java.lang.Throwable -> L69
                goto L8a
            L69:
                r6 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Get property "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = " failed: "
                r1.append(r7)
                java.lang.String r7 = r6.toString()
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                com.alibaba.jsi.standard.J2JHelper.access$500(r5, r7, r6)
            L8a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.ObjectFieldsCallback.onGetProperty(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSValue, java.lang.String):com.alibaba.jsi.standard.js.JSValue");
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public void onSetProperty(JSContext jSContext, JSValue jSValue, String str, JSValue jSValue2) {
            jSValue.delete();
            if (this.mObject == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Java object has been detached while setting ");
                sb.append(str);
                J2JHelper.throwException(jSContext, sb.toString());
                jSValue2.delete();
                return;
            }
            Field field = null;
            try {
                field = this.mClass.getField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Not found property ");
                sb2.append(str);
                J2JHelper.throwException(jSContext, sb2.toString());
            }
            if (field != null) {
                if ((field.getModifiers() & 9) == 1) {
                    if (J2JHelper.this.match(field.getType(), J2JHelper.this.getJSType(jSContext, jSValue2))) {
                        Object jsToJava = J2JHelper.this.jsToJava(jSContext, jSValue2);
                        try {
                            field.set(this.mObject, jsToJava);
                        } catch (Throwable th) {
                            if (jsToJava instanceof JSValue) {
                                ((JSValue) jsToJava).delete();
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Set property ");
                            sb3.append(str);
                            sb3.append(" failed: ");
                            sb3.append(th.toString());
                            J2JHelper.throwException(jSContext, sb3.toString(), th);
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Set a mismatch value type into property '");
                        sb4.append(str);
                        sb4.append("'");
                        J2JHelper.throwException(jSContext, sb4.toString());
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("No property named ");
                    sb5.append(str);
                    J2JHelper.throwException(jSContext, sb5.toString());
                }
            }
            jSValue2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ObjectsSharedCallback extends JSCallback {
        private final Object mCachedMethods = OSUtil.createStringMethodLruBuffer(16);
        private final Class mClass;
        private final String mClassName;

        ObjectsSharedCallback(String str, Class cls) {
            this.mClassName = str;
            this.mClass = cls;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public String getIdentifier() {
            return this.mClassName;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            JSContext context = arguments.getContext();
            JSValue thiz = arguments.thiz();
            Object jsToJava = J2JHelper.this.jsToJava(context, thiz, false);
            if (jsToJava != null) {
                JSValue onCallFunctionCommon = J2JHelper.this.onCallFunctionCommon(arguments, jsToJava.getClass(), jsToJava, this.mCachedMethods);
                thiz.delete();
                return onCallFunctionCommon;
            }
            thiz.delete();
            StringBuilder sb = new StringBuilder();
            sb.append("Can not get java this object while calling '");
            sb.append(arguments.getFunctionName());
            sb.append("', it may be detached");
            J2JHelper.throwException(context, sb.toString());
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // com.alibaba.jsi.standard.js.JSCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.alibaba.jsi.standard.js.JSValue onGetProperty(com.alibaba.jsi.standard.JSContext r4, com.alibaba.jsi.standard.js.JSValue r5, java.lang.String r6) {
            /*
                r3 = this;
                r5.delete()
                r5 = 0
                java.lang.Class r0 = r3.mClass     // Catch: java.lang.NoSuchFieldException -> Lf
                java.lang.reflect.Field r0 = r0.getField(r6)     // Catch: java.lang.NoSuchFieldException -> Lf
                r1 = 1
                r0.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L10
                goto L24
            Lf:
                r0 = r5
            L10:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Not found static property "
                r1.append(r2)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r4, r1)
            L24:
                if (r0 == 0) goto L70
                int r1 = r0.getModifiers()
                r2 = 9
                r1 = r1 & r2
                if (r1 == r2) goto L44
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "No static property named "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r4, r6)
                goto L70
            L44:
                java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Throwable -> L4f
                com.alibaba.jsi.standard.J2JHelper r1 = com.alibaba.jsi.standard.J2JHelper.this     // Catch: java.lang.Throwable -> L4f
                com.alibaba.jsi.standard.js.JSValue r5 = r1.javaToJS(r4, r0)     // Catch: java.lang.Throwable -> L4f
                goto L70
            L4f:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Get static property "
                r1.append(r2)
                r1.append(r6)
                java.lang.String r6 = " failed: "
                r1.append(r6)
                java.lang.String r6 = r0.toString()
                r1.append(r6)
                java.lang.String r6 = r1.toString()
                com.alibaba.jsi.standard.J2JHelper.access$500(r4, r6, r0)
            L70:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.ObjectsSharedCallback.onGetProperty(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSValue, java.lang.String):com.alibaba.jsi.standard.js.JSValue");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        @Override // com.alibaba.jsi.standard.js.JSCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSetProperty(com.alibaba.jsi.standard.JSContext r5, com.alibaba.jsi.standard.js.JSValue r6, java.lang.String r7, com.alibaba.jsi.standard.js.JSValue r8) {
            /*
                r4 = this;
                r6.delete()
                r6 = 0
                java.lang.Class r0 = r4.mClass     // Catch: java.lang.NoSuchFieldException -> Lf
                java.lang.reflect.Field r0 = r0.getField(r7)     // Catch: java.lang.NoSuchFieldException -> Lf
                r1 = 1
                r0.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L10
                goto L24
            Lf:
                r0 = r6
            L10:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Not found static property "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r1 = r1.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r1)
            L24:
                if (r0 == 0) goto La4
                int r1 = r0.getModifiers()
                r2 = 9
                r1 = r1 & r2
                if (r1 == r2) goto L44
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "No static property named "
                r6.append(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r6)
                goto La4
            L44:
                com.alibaba.jsi.standard.J2JHelper r1 = com.alibaba.jsi.standard.J2JHelper.this
                java.lang.Class r2 = r0.getType()
                com.alibaba.jsi.standard.J2JHelper r3 = com.alibaba.jsi.standard.J2JHelper.this
                java.lang.Class r3 = com.alibaba.jsi.standard.J2JHelper.access$600(r3, r5, r8)
                boolean r1 = com.alibaba.jsi.standard.J2JHelper.access$700(r1, r2, r3)
                if (r1 == 0) goto L8b
                com.alibaba.jsi.standard.J2JHelper r1 = com.alibaba.jsi.standard.J2JHelper.this
                java.lang.Object r1 = r1.jsToJava(r5, r8)
                r0.set(r6, r1)     // Catch: java.lang.Throwable -> L60
                goto La4
            L60:
                r6 = move-exception
                boolean r0 = r1 instanceof com.alibaba.jsi.standard.js.JSValue
                if (r0 == 0) goto L6a
                com.alibaba.jsi.standard.js.JSValue r1 = (com.alibaba.jsi.standard.js.JSValue) r1
                r1.delete()
            L6a:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Set static property "
                r0.append(r1)
                r0.append(r7)
                java.lang.String r7 = " failed: "
                r0.append(r7)
                java.lang.String r7 = r6.toString()
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                com.alibaba.jsi.standard.J2JHelper.access$500(r5, r7, r6)
                goto La4
            L8b:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Set a mismatch value type into static property '"
                r6.append(r0)
                r6.append(r7)
                java.lang.String r7 = "'"
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r6)
            La4:
                r8.delete()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.ObjectsSharedCallback.onSetProperty(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSValue, java.lang.String, com.alibaba.jsi.standard.js.JSValue):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ConstructorCallback extends JSCallback {
        private final Class mClass;
        private final String mClassName;

        ConstructorCallback(String str, Class cls) {
            this.mClassName = str;
            this.mClass = cls;
        }

        Class getJavaClass() {
            return this.mClass;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public String getIdentifier() {
            return this.mClassName;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            Object[] objArr;
            JSContext context = arguments.getContext();
            if (!arguments.isConstructCall()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Java constructor '");
                sb.append(this.mClassName);
                sb.append("' can not be called as a function!");
                J2JHelper.throwException(context, sb.toString());
                return null;
            }
            if (this.mClass.isInterface()) {
                if (arguments.count() == 1) {
                    JSValue jSValue = arguments.get(0);
                    if (jSValue instanceof JSObject) {
                        return J2JHelper.this.javaToJS(context, context.getJSSupport().as((JSObject) jSValue, this.mClass));
                    } else if (jSValue != null) {
                        jSValue.delete();
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Java interface constructor ");
                sb2.append(this.mClassName);
                sb2.append(" only accept one JSObject argument!");
                J2JHelper.throwException(context, sb2.toString());
                return null;
            }
            Constructor<?>[] constructors = this.mClass.getConstructors();
            Class[] jSTypes = J2JHelper.this.getJSTypes(context, arguments);
            for (Constructor<?> constructor : constructors) {
                if ((constructor.getModifiers() & 1) != 0 && ((J2JHelper.this.mAnnotationClass == null || constructor.isAnnotationPresent(J2JHelper.this.mAnnotationClass)) && J2JHelper.this.matchAll(constructor.getParameterTypes(), jSTypes))) {
                    int length = jSTypes.length;
                    if (length > 0) {
                        objArr = new Object[length];
                        for (int i = 0; i < length; i++) {
                            JSValue jSValue2 = arguments.get(i);
                            objArr[i] = J2JHelper.this.jsToJava(context, jSValue2);
                            jSValue2.delete();
                        }
                    } else {
                        objArr = null;
                    }
                    try {
                        return J2JHelper.this.javaObjectToJS(context, constructor.newInstance(objArr));
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        while (th2.getCause() != null) {
                            th2 = th2.getCause();
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Java constructor occurs exception: ");
                        sb3.append(th2.toString());
                        J2JHelper.throwException(context, sb3.toString(), th);
                        return null;
                    }
                }
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Can not found a matched constructor for '");
            sb4.append(this.mClassName);
            sb4.append("' with ");
            sb4.append(arguments.count());
            sb4.append(" argument");
            sb4.append(arguments.count() > 1 ? "s " : " ");
            sb4.append(J2JHelper.argsDescription(jSTypes));
            J2JHelper.throwException(context, sb4.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ClassStaticCallback extends JSCallback {
        private final Object mCachedMethods = OSUtil.createStringMethodLruBuffer(16);
        private final Class mClass;
        private final String mClassName;

        ClassStaticCallback(String str, Class cls) {
            this.mClassName = str;
            this.mClass = cls;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public String getIdentifier() {
            return this.mClassName;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            return J2JHelper.this.onCallFunctionCommon(arguments, this.mClass, null, this.mCachedMethods);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        @Override // com.alibaba.jsi.standard.js.JSCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.alibaba.jsi.standard.js.JSValue onGetProperty(com.alibaba.jsi.standard.JSContext r5, com.alibaba.jsi.standard.js.JSValue r6, java.lang.String r7) {
            /*
                r4 = this;
                r0 = 0
                java.lang.Class r1 = r4.mClass     // Catch: java.lang.NoSuchFieldException -> Lc
                java.lang.reflect.Field r1 = r1.getField(r7)     // Catch: java.lang.NoSuchFieldException -> Lc
                r2 = 1
                r1.setAccessible(r2)     // Catch: java.lang.NoSuchFieldException -> Ld
                goto L21
            Lc:
                r1 = r0
            Ld:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not found static property "
                r2.append(r3)
                r2.append(r7)
                java.lang.String r2 = r2.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r2)
            L21:
                if (r1 == 0) goto L6d
                int r2 = r1.getModifiers()
                r3 = 9
                r2 = r2 & r3
                if (r2 == r3) goto L41
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "No static property named "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r5, r7)
                goto L6d
            L41:
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L4c
                com.alibaba.jsi.standard.J2JHelper r2 = com.alibaba.jsi.standard.J2JHelper.this     // Catch: java.lang.Throwable -> L4c
                com.alibaba.jsi.standard.js.JSValue r0 = r2.javaToJS(r5, r1)     // Catch: java.lang.Throwable -> L4c
                goto L6d
            L4c:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Get static property '"
                r2.append(r3)
                r2.append(r7)
                java.lang.String r7 = "' failed: "
                r2.append(r7)
                java.lang.String r7 = r1.toString()
                r2.append(r7)
                java.lang.String r7 = r2.toString()
                com.alibaba.jsi.standard.J2JHelper.access$500(r5, r7, r1)
            L6d:
                r6.delete()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.ClassStaticCallback.onGetProperty(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSValue, java.lang.String):com.alibaba.jsi.standard.js.JSValue");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        @Override // com.alibaba.jsi.standard.js.JSCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onSetProperty(com.alibaba.jsi.standard.JSContext r6, com.alibaba.jsi.standard.js.JSValue r7, java.lang.String r8, com.alibaba.jsi.standard.js.JSValue r9) {
            /*
                r5 = this;
                r0 = 0
                java.lang.Class r1 = r5.mClass     // Catch: java.lang.NoSuchFieldException -> Lc
                java.lang.reflect.Field r1 = r1.getField(r8)     // Catch: java.lang.NoSuchFieldException -> Lc
                r2 = 1
                r1.setAccessible(r2)     // Catch: java.lang.NoSuchFieldException -> Ld
                goto L21
            Lc:
                r1 = r0
            Ld:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not found static property "
                r2.append(r3)
                r2.append(r8)
                java.lang.String r2 = r2.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r6, r2)
            L21:
                if (r1 == 0) goto La1
                int r2 = r1.getModifiers()
                r3 = 9
                r2 = r2 & r3
                if (r2 == r3) goto L41
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "No static property named "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r6, r8)
                goto La1
            L41:
                com.alibaba.jsi.standard.J2JHelper r2 = com.alibaba.jsi.standard.J2JHelper.this
                java.lang.Class r3 = r1.getType()
                com.alibaba.jsi.standard.J2JHelper r4 = com.alibaba.jsi.standard.J2JHelper.this
                java.lang.Class r4 = com.alibaba.jsi.standard.J2JHelper.access$600(r4, r6, r9)
                boolean r2 = com.alibaba.jsi.standard.J2JHelper.access$700(r2, r3, r4)
                if (r2 == 0) goto L88
                com.alibaba.jsi.standard.J2JHelper r2 = com.alibaba.jsi.standard.J2JHelper.this
                java.lang.Object r2 = r2.jsToJava(r6, r9)
                r1.set(r0, r2)     // Catch: java.lang.Throwable -> L5d
                goto La1
            L5d:
                r0 = move-exception
                boolean r1 = r2 instanceof com.alibaba.jsi.standard.js.JSValue
                if (r1 == 0) goto L67
                com.alibaba.jsi.standard.js.JSValue r2 = (com.alibaba.jsi.standard.js.JSValue) r2
                r2.delete()
            L67:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Set static property "
                r1.append(r2)
                r1.append(r8)
                java.lang.String r8 = " failed: "
                r1.append(r8)
                java.lang.String r8 = r0.toString()
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                com.alibaba.jsi.standard.J2JHelper.access$500(r6, r8, r0)
                goto La1
            L88:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Set a mismatch value type into static property '"
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = "'"
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                com.alibaba.jsi.standard.J2JHelper.access$000(r6, r8)
            La1:
                r7.delete()
                r9.delete()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.ClassStaticCallback.onSetProperty(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSValue, java.lang.String, com.alibaba.jsi.standard.js.JSValue):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSValue onCallFunctionCommon(Arguments arguments, Class cls, Object obj, Object obj2) {
        boolean z = obj == null;
        JSContext context = arguments.getContext();
        String functionName = arguments.getFunctionName();
        Class[] jSTypes = getJSTypes(context, arguments);
        Method methodFromLruBuffer = OSUtil.getMethodFromLruBuffer(obj2, functionName);
        if (methodFromLruBuffer != null && matchAll(methodFromLruBuffer.getParameterTypes(), jSTypes)) {
            return callJava(context, arguments, methodFromLruBuffer, obj);
        }
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(functionName) && ((!z || (method.getModifiers() & 9) == 9) && matchAll(method.getParameterTypes(), jSTypes))) {
                OSUtil.putIntoLruBuffer(obj2, functionName, method);
                return callJava(context, arguments, method, obj);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not found a matched ");
        sb.append(z ? "static " : "");
        sb.append("method '");
        sb.append(functionName);
        sb.append("' with ");
        sb.append(arguments.count());
        sb.append(" argument");
        sb.append(arguments.count() > 1 ? "s " : " ");
        sb.append(argsDescription(jSTypes));
        throwException(context, sb.toString());
        return null;
    }

    private JSValue callJava(JSContext jSContext, Arguments arguments, Method method, Object obj) {
        Object[] objArr;
        int count = arguments.count();
        if (count > 0) {
            objArr = new Object[count];
            for (int i = 0; i < count; i++) {
                JSValue jSValue = arguments.get(i);
                objArr[i] = jsToJava(jSContext, jSValue);
                jSValue.delete();
            }
        } else {
            objArr = null;
        }
        try {
            method.setAccessible(true);
            Object invoke = method.invoke(obj, objArr);
            if (method.getReturnType() == Void.TYPE) {
                return JSVoid.undefinedValue();
            }
            return javaToJS(jSContext, invoke, false);
        } catch (Throwable th) {
            Throwable th2 = th;
            while (th2.getCause() != null) {
                th2 = th2.getCause();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Function ");
            sb.append(arguments.getFunctionName());
            sb.append(" occurs exception: ");
            sb.append(th2.toString());
            throwException(jSContext, sb.toString(), th);
            return null;
        }
    }

    public Object jsToJava(JSContext jSContext, JSValue jSValue) {
        return jsToJava(jSContext, jSValue, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object jsToJava(JSContext jSContext, JSValue jSValue, boolean z) {
        if (jSValue instanceof JSVoid) {
            return null;
        }
        if (jSValue instanceof JSBoolean) {
            return Boolean.valueOf(((JSBoolean) jSValue).valueOf());
        }
        if (jSValue instanceof JSNumber) {
            double valueOf = ((JSNumber) jSValue).valueOf();
            int i = (int) valueOf;
            if (valueOf == i) {
                return Integer.valueOf(i);
            }
            long j = (long) valueOf;
            if (valueOf == j) {
                return Long.valueOf(j);
            }
            return Double.valueOf(valueOf);
        } else if (jSValue instanceof JSString) {
            return ((JSString) jSValue).valueOf();
        } else {
            if (jSValue instanceof JSFunction) {
                JSCallback functionCallback = ((JSFunction) jSValue).getFunctionCallback(jSContext);
                if (functionCallback instanceof ConstructorCallback) {
                    return ((ConstructorCallback) functionCallback).getJavaClass();
                }
                return null;
            } else if (jSValue instanceof JSObject) {
                JSCallback jSCallback = ((JSObject) jSValue).getJSCallback(jSContext);
                if (jSCallback instanceof ObjectFieldsCallback) {
                    return ((ObjectFieldsCallback) jSCallback).getObject();
                }
                if (jSCallback instanceof ArrayObjectCallback) {
                    return ((ArrayObjectCallback) jSCallback).getObject();
                }
                if (this.mSupportUnknownJSObject) {
                    return z ? jSValue.copy(jSContext) : jSValue;
                }
                return null;
            } else if (this.mSupportUnknownJSObject && (jSValue instanceof JSSymbol)) {
                return z ? jSValue.copy(jSContext) : jSValue;
            } else {
                return null;
            }
        }
    }

    public JSValue javaToJS(JSContext jSContext, Object obj) {
        return javaToJS(jSContext, obj, true);
    }

    private JSValue javaToJS(JSContext jSContext, Object obj, boolean z) {
        if (obj == null) {
            return JSVoid.nullValue();
        }
        if (obj instanceof Boolean) {
            return JSBoolean.valueFor(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Integer) {
            return new JSNumber(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return new JSNumber(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return new JSNumber(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return new JSString((String) obj);
        }
        if (obj instanceof Class) {
            return getClassDefinition(jSContext, (Class) obj);
        }
        if (obj instanceof JSValue) {
            if (z) {
                return ((JSValue) obj).copy(jSContext);
            }
            return (JSValue) obj;
        }
        return javaObjectToJS(jSContext, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Class[] getJSTypes(JSContext jSContext, Arguments arguments) {
        int count = arguments.count();
        Class[] clsArr = new Class[count];
        for (int i = 0; i < count; i++) {
            JSValue jSValue = arguments.get(i);
            clsArr[i] = getJSType(jSContext, jSValue);
            jSValue.delete();
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Class getJSType(JSContext jSContext, JSValue jSValue) {
        if (jSValue instanceof JSBoolean) {
            return Boolean.TYPE;
        }
        if (jSValue instanceof JSNumber) {
            double valueOf = ((JSNumber) jSValue).valueOf();
            if (valueOf == ((int) valueOf)) {
                return Integer.TYPE;
            }
            if (valueOf == ((long) valueOf)) {
                return Long.TYPE;
            }
            return Double.TYPE;
        } else if (jSValue instanceof JSVoid) {
            return Void.TYPE;
        } else {
            if (jSValue instanceof JSString) {
                return String.class;
            }
            if (jSValue instanceof JSFunction) {
                if (((JSFunction) jSValue).getFunctionCallback(jSContext) instanceof ConstructorCallback) {
                    return Class.class;
                }
                return null;
            } else if (jSValue instanceof JSObject) {
                JSCallback jSCallback = ((JSObject) jSValue).getJSCallback(jSContext);
                if (jSCallback instanceof ObjectFieldsCallback) {
                    Object object = ((ObjectFieldsCallback) jSCallback).getObject();
                    if (object != null) {
                        return object.getClass();
                    }
                    return null;
                } else if (jSCallback instanceof ArrayObjectCallback) {
                    Object object2 = ((ArrayObjectCallback) jSCallback).getObject();
                    if (object2 != null) {
                        return object2.getClass();
                    }
                    return null;
                } else if (this.mSupportUnknownJSObject) {
                    return jSValue.getClass();
                } else {
                    return null;
                }
            } else if (this.mSupportUnknownJSObject && (jSValue instanceof JSSymbol)) {
                return jSValue.getClass();
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean matchAll(Class[] clsArr, Class[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int i = 0;
        for (Class cls : clsArr2) {
            if (!match(clsArr[i], cls)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean match(Class<?> cls, Class cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        return (cls2 == Boolean.TYPE || cls2 == Boolean.class) ? cls == Boolean.class || cls == Boolean.TYPE || cls == Object.class : (cls2 == Integer.TYPE || cls2 == Integer.class) ? cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Double.class || cls == Double.TYPE || cls == Object.class : (cls2 == Long.TYPE || cls2 == Long.class) ? cls == Long.class || cls == Long.TYPE || cls == Double.class || cls == Double.TYPE || cls == Object.class : (cls2 == Double.TYPE || cls2 == Double.class) ? cls == Double.class || cls == Double.TYPE || cls == Object.class : ((cls2 != Void.TYPE && cls2 != Void.class) || cls == Boolean.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Double.TYPE || cls == Byte.TYPE || cls == Character.TYPE || cls == Short.TYPE || cls == Float.TYPE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String argsDescription(Class[] clsArr) {
        String name;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < clsArr.length; i++) {
            Class cls = clsArr[i];
            if (cls == Boolean.TYPE) {
                name = "boolean";
            } else if (cls == Integer.TYPE) {
                name = "int";
            } else if (cls == Long.TYPE) {
                name = "long";
            } else if (cls == Double.TYPE) {
                name = "double";
            } else if (cls == String.class) {
                name = "String";
            } else if (cls == Void.TYPE) {
                name = "Object";
            } else if (cls == Class.class) {
                name = "Class";
            } else {
                name = cls != null ? cls.getName() : "<unsupported>";
            }
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(name);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class JSObjectHolder {
        private JSContext mContext;
        private JSWeakValue mJSObject;

        JSObjectHolder(JSContext jSContext, JSObject jSObject) {
            this.mContext = jSContext;
            this.mJSObject = jSObject.createWeak(jSContext);
        }

        JSObject lockObject(JSContext jSContext) {
            JSValue lock;
            JSWeakValue jSWeakValue = this.mJSObject;
            if (jSWeakValue != null && (lock = jSWeakValue.lock(jSContext)) != null) {
                if (lock instanceof JSObject) {
                    return (JSObject) lock;
                }
                lock.delete();
            }
            return null;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            JSWeakValue jSWeakValue = this.mJSObject;
            if (jSWeakValue != null) {
                J2JHelper.this.markUnused(jSWeakValue);
                this.mJSObject = null;
            }
        }

        boolean detach(boolean z) {
            JSValue lock;
            JSWeakValue jSWeakValue = this.mJSObject;
            if (jSWeakValue == null) {
                return false;
            }
            this.mJSObject = null;
            if (z && (lock = jSWeakValue.lock(this.mContext)) != null) {
                if (lock instanceof JSObject) {
                    ((JSObject) lock).detachJSCallback(this.mContext);
                }
                lock.delete();
            }
            jSWeakValue.delete();
            return true;
        }
    }

    private void clearJavaObjects() {
        this.mIsClearingObjects = true;
        Iterator<JSObjectHolder> it = this.mJSObjectHolders.keySet().iterator();
        while (it.hasNext()) {
            it.next().detach(true);
        }
        this.mIsClearingObjects = false;
        this.mJSObjects.clear();
        this.mJSObjectHolders.clear();
        this.mJavaObjects.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSObject javaObjectToJS(JSContext jSContext, Object obj) {
        JSObject newJSObject;
        Class<? extends Annotation> cls;
        JSObject lockObject;
        JSObjectHolder jSObjectHolder = this.mJSObjects.get(obj);
        if (jSObjectHolder != null && (lockObject = jSObjectHolder.lockObject(jSContext)) != null) {
            this.mJSObjectHolders.size();
            return lockObject;
        }
        syncDeleteUnusedObjectsIfTooMany();
        Class<?> cls2 = obj.getClass();
        if (cls2.isArray()) {
            if (this.mArrayObjectTemplate == null) {
                this.mArrayObjectTemplate = Template.createIndexed(jSContext.getJSEngine());
            }
            newJSObject = this.mArrayObjectTemplate.newJSObject(jSContext, new ArrayObjectCallback(obj));
            newJSObject.set(jSContext, "length", new JSNumber(Array.getLength(obj)));
        } else {
            Template template = this.mObjectTemplates.get(cls2);
            if (template == null) {
                template = Template.create(jSContext.getJSEngine());
                if (this.mAddField) {
                    for (Field field : this.mAddSuper ? cls2.getFields() : cls2.getDeclaredFields()) {
                        if ((field.getModifiers() & 9) == 1 && ((cls = this.mAnnotationClass) == null || field.isAnnotationPresent(cls))) {
                            template.addAccessor(field.getName(), 0);
                        }
                    }
                }
                this.mObjectTemplates.put(cls2, template);
            }
            newJSObject = template.newJSObject(jSContext, new ObjectFieldsCallback(obj));
        }
        if (this.mSupportClass) {
            JSFunction classDefinition = getClassDefinition(jSContext, cls2);
            if (classDefinition != null) {
                JSValue jSValue = classDefinition.get(jSContext, "prototype");
                if (jSValue != null) {
                    newJSObject.setPrototype(jSContext, jSValue);
                    jSValue.delete();
                }
                classDefinition.delete();
            }
        } else {
            JSObject classPrototype = getClassPrototype(jSContext, cls2, this.mAddSuper, true);
            if (classPrototype != null) {
                newJSObject.setPrototype(jSContext, classPrototype);
                classPrototype.delete();
            }
        }
        JSObjectHolder jSObjectHolder2 = new JSObjectHolder(jSContext, newJSObject);
        this.mJSObjects.put(obj, jSObjectHolder2);
        this.mJSObjectHolders.put(jSObjectHolder2, null);
        return newJSObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSFunction importJavaClass(JSContext jSContext, Class cls, String str) {
        JSFunction classDefinition = getClassDefinition(jSContext, cls);
        if (classDefinition == null) {
            return null;
        }
        if (str == null) {
            str = getClassName(cls.getName());
        }
        JSObject globalObject = jSContext.globalObject();
        globalObject.set(jSContext, str, classDefinition);
        globalObject.delete();
        return classDefinition;
    }

    private void clearJavaClasses(JSContext jSContext) {
        for (JSFunction jSFunction : this.mClasses.values()) {
            JSValue prototype = jSFunction.getPrototype(jSContext);
            if (prototype != null) {
                if (prototype instanceof JSObject) {
                    ((JSObject) prototype).detachJSCallback(jSContext);
                }
                prototype.delete();
            }
            jSFunction.detachJSCallback(jSContext);
            jSFunction.delete();
        }
        this.mClasses.clear();
    }

    private JSFunction getClassDefinition(JSContext jSContext, Class cls) {
        return getClassDefinition(jSContext, cls, cls.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.jsi.standard.js.JSFunction getClassDefinition(com.alibaba.jsi.standard.JSContext r9, java.lang.Class r10, java.lang.String r11) {
        /*
            r8 = this;
            boolean r0 = r8.mSupportClass
            if (r0 != 0) goto L6
            r9 = 0
            return r9
        L6:
            java.util.Map<java.lang.String, com.alibaba.jsi.standard.js.JSFunction> r0 = r8.mClasses
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L1d
            java.util.Map<java.lang.String, com.alibaba.jsi.standard.js.JSFunction> r10 = r8.mClasses
            java.lang.Object r10 = r10.get(r11)
            com.alibaba.jsi.standard.js.JSFunction r10 = (com.alibaba.jsi.standard.js.JSFunction) r10
            com.alibaba.jsi.standard.js.JSValue r9 = r10.copy(r9)
            com.alibaba.jsi.standard.js.JSFunction r9 = (com.alibaba.jsi.standard.js.JSFunction) r9
            return r9
        L1d:
            java.lang.String r0 = r8.getClassName(r11)
            com.alibaba.jsi.standard.js.JSFunction r1 = new com.alibaba.jsi.standard.js.JSFunction
            com.alibaba.jsi.standard.J2JHelper$ConstructorCallback r2 = new com.alibaba.jsi.standard.J2JHelper$ConstructorCallback
            r2.<init>(r11, r10)
            r3 = 1
            r1.<init>(r9, r2, r0, r3)
            com.alibaba.jsi.standard.js.JSObject r0 = r8.getClassProto(r9, r10)
            r2 = 0
            com.alibaba.jsi.standard.js.JSObject r4 = r8.getClassPrototype(r9, r10, r2, r2)
            r1.setPrototype(r9, r0)
            java.lang.String r5 = "prototype"
            r1.set(r9, r5, r4)
            java.lang.String r6 = "constructor"
            r4.set(r9, r6, r1)
            java.util.Map<java.lang.String, com.alibaba.jsi.standard.js.JSFunction> r6 = r8.mClasses
            com.alibaba.jsi.standard.js.JSValue r7 = r1.copy(r9)
            com.alibaba.jsi.standard.js.JSFunction r7 = (com.alibaba.jsi.standard.js.JSFunction) r7
            r6.put(r11, r7)
            java.lang.Class r11 = r10.getSuperclass()
            if (r11 == 0) goto L76
            boolean r6 = r8.mAddSuper
            if (r6 == 0) goto L76
            java.lang.String r6 = r11.getName()
            com.alibaba.jsi.standard.js.JSFunction r11 = r8.getClassDefinition(r9, r11, r6)
            if (r11 == 0) goto L94
            com.alibaba.jsi.standard.js.JSValue r6 = r11.getPrototype(r9)
            r0.setPrototype(r9, r6)
            r6.delete()
            com.alibaba.jsi.standard.js.JSValue r5 = r11.get(r9, r5)
            r4.setPrototype(r9, r5)
            r5.delete()
            goto L91
        L76:
            java.lang.String r11 = "Function"
            com.alibaba.jsi.standard.js.JSValue r11 = r9.getGlobal(r11)
            if (r11 == 0) goto L94
            boolean r6 = r11 instanceof com.alibaba.jsi.standard.js.JSObject
            if (r6 == 0) goto L91
            r6 = r11
            com.alibaba.jsi.standard.js.JSObject r6 = (com.alibaba.jsi.standard.js.JSObject) r6
            com.alibaba.jsi.standard.js.JSValue r5 = r6.get(r9, r5)
            if (r5 == 0) goto L91
            r0.setPrototype(r9, r5)
            r5.delete()
        L91:
            r11.delete()
        L94:
            r4.delete()
            boolean r11 = r8.mAddInnerClass
            if (r11 == 0) goto Ld3
            java.lang.Class[] r11 = r10.getDeclaredClasses()
            int r4 = r11.length
        La0:
            if (r2 >= r4) goto Ld3
            r5 = r11[r2]
            int r6 = r5.getModifiers()
            r6 = r6 & r3
            if (r6 != r3) goto Ld0
            java.lang.Class<? extends java.lang.annotation.Annotation> r6 = r8.mAnnotationClass
            if (r6 == 0) goto Lb5
            boolean r6 = r5.isAnnotationPresent(r6)
            if (r6 == 0) goto Ld0
        Lb5:
            com.alibaba.jsi.standard.js.JSFunction r6 = r8.getClassDefinition(r9, r5)
            if (r6 == 0) goto Ld0
            java.lang.String r5 = r5.getName()
            r7 = 36
            int r7 = r5.lastIndexOf(r7)
            int r7 = r7 + r3
            java.lang.String r5 = r5.substring(r7)
            r0.set(r9, r5, r6)
            r6.delete()
        Ld0:
            int r2 = r2 + 1
            goto La0
        Ld3:
            r0.delete()
            boolean r11 = r8.mAddClassObject
            if (r11 == 0) goto Le6
            com.alibaba.jsi.standard.js.JSObject r10 = r8.javaObjectToJS(r9, r10)
            java.lang.String r11 = "class"
            r1.set(r9, r11, r10)
            r10.delete()
        Le6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.J2JHelper.getClassDefinition(com.alibaba.jsi.standard.JSContext, java.lang.Class, java.lang.String):com.alibaba.jsi.standard.js.JSFunction");
    }

    private JSObject getClassProto(JSContext jSContext, Class cls) {
        Class<? extends Annotation> cls2;
        Class<? extends Annotation> cls3;
        Template create = Template.create(jSContext.getJSEngine());
        for (Method method : cls.getDeclaredMethods()) {
            if ((method.getModifiers() & 9) == 9 && ((cls3 = this.mAnnotationClass) == null || method.isAnnotationPresent(cls3))) {
                create.addFunction(method.getName(), 0);
            }
        }
        if (this.mAddField) {
            for (Field field : cls.getDeclaredFields()) {
                if ((field.getModifiers() & 9) == 9 && ((cls2 = this.mAnnotationClass) == null || field.isAnnotationPresent(cls2))) {
                    create.addAccessor(field.getName(), 0);
                }
            }
        }
        JSObject newJSObject = create.newJSObject(jSContext, new ClassStaticCallback(cls.getName(), cls));
        create.delete();
        return newJSObject;
    }

    private JSObject getClassPrototype(JSContext jSContext, Class cls, boolean z, boolean z2) {
        Class<? extends Annotation> cls2;
        Class<? extends Annotation> cls3;
        Template template = z2 ? this.mClassPrototypeTemplates.get(cls) : null;
        if (template == null) {
            template = Template.create(jSContext.getJSEngine());
            for (Method method : z ? cls.getMethods() : cls.getDeclaredMethods()) {
                if ((method.getModifiers() & 1) == 1 && ((cls3 = this.mAnnotationClass) == null || method.isAnnotationPresent(cls3))) {
                    template.addFunction(method.getName(), 0);
                }
            }
            if (this.mAddField) {
                for (Field field : z ? cls.getFields() : cls.getDeclaredFields()) {
                    if ((field.getModifiers() & 9) == 9 && ((cls2 = this.mAnnotationClass) == null || field.isAnnotationPresent(cls2))) {
                        template.addAccessor(field.getName(), 0);
                    }
                }
            }
        }
        if (z2) {
            this.mClassPrototypeTemplates.put(cls, template);
        }
        JSObject newJSObject = template.newJSObject(jSContext, new ObjectsSharedCallback(cls.getName(), cls));
        if (!z2) {
            template.delete();
        }
        return newJSObject;
    }

    private String getClassName(String str) {
        return str.substring(str.lastIndexOf(46) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ExceptionOutputStream extends OutputStream {
        private StringBuilder mData;

        private ExceptionOutputStream() {
            this.mData = new StringBuilder();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.mData.append(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.mData.append((CharSequence) new String(bArr, i, i2), i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.mData.append(new String(bArr));
        }

        String getData() {
            return this.mData.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void throwException(JSContext jSContext, String str) {
        throwException(jSContext, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void throwException(JSContext jSContext, String str, Throwable th) {
        JSValue value;
        JSException jSException = new JSException(jSContext, str);
        if (th != null && (value = jSException.getValue(jSContext)) != null) {
            try {
                ExceptionOutputStream exceptionOutputStream = new ExceptionOutputStream();
                th.printStackTrace(new PrintStream(exceptionOutputStream));
                ((JSObject) value).set(jSContext, "java_stack", new JSString(exceptionOutputStream.getData()));
            } catch (Throwable unused) {
            }
            value.delete();
        }
        jSContext.throwException(jSException);
        jSException.delete();
    }
}
