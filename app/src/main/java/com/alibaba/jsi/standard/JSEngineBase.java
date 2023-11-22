package com.alibaba.jsi.standard;

import com.alibaba.jsi.standard.js.Bridge;
import com.alibaba.jsi.standard.js.Deletable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class JSEngineBase {
    private static final int CROSS_THREAD_TASK_CHECK_LOOP_ONCE = 4;
    private static final int CROSS_THREAD_TASK_DELETE_UNUSED_OBJECTS = 6;
    private static final int CROSS_THREAD_TASK_DUMP_ALIVE_OBJECTS = 3;
    private static final int CROSS_THREAD_TASK_EXTERNAL_MEMORY_CHANGE = 7;
    private static final int CROSS_THREAD_TASK_ON_LOW_MEMORY = 5;
    private static final int CROSS_THREAD_TASK_START_TRACE = 1;
    private static final int CROSS_THREAD_TASK_STOP_TRACE = 2;
    public static final int kEngineJSC = 2;
    public static final int kEngineQJS = 3;
    public static final int kEngineV8 = 1;
    private static final Map<String, Long> sIdentifierMap = new HashMap();
    private static final Map<Long, JSEngine> sJSEngines = new HashMap();
    private static final Object sSoLoadLock = new Object();
    private static final String sTraceCategories = "jsi,v8,v8.compile,disabled-by-default-v8.compile";
    private static final String sTraceFilePattern = "/sdcard/jsi_trace_${pid}_${time}_${index}.json";
    private final String mEmbedderName;
    private final Object mHandler;
    long mNativeInstance;
    private final ArrayList<JSContext> mContexts = new ArrayList<>();
    private final Runnable mAsyncLoopRunnable = new CrossThreadRunnable(4);
    boolean mPrintObjectsAtDispose = true;
    private boolean mRunningHandlerMatches = false;
    private boolean mEnableStat = false;
    private boolean mHasObjects = false;
    private int mMaxPrintCount = 20;
    private final Set<Deletable> mObjects = new HashSet();
    private final Object[] mDataSlots = new Object[6];

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSEngineBase(Object obj, String str, String str2, String str3, int i, long j, Object obj2) {
        Object obj3;
        String str4;
        String str5;
        this.mNativeInstance = 0L;
        if (obj != null) {
            Util.initialize(obj);
        }
        this.mEmbedderName = str;
        boolean z = j == 0;
        if (obj2 == null) {
            obj3 = OSUtil.createHandlerForCurrentThread();
            if (obj3 == null) {
                if (z) {
                    throw new RuntimeException("Create JSEngine in a thread with Looper, or specify a Handler");
                }
                warnThreadNoHandler();
            }
        } else {
            obj3 = obj2;
        }
        this.mHandler = obj3;
        if (z) {
            if (obj != null) {
                String packageName = OSUtil.getPackageName(obj);
                str4 = OSUtil.getPackageVersionName(obj, packageName);
                str5 = packageName;
            } else {
                str4 = "";
                str5 = str4;
            }
            JNIBridge.nativeSetInfo(0L, "app-package", str5, 0L);
            JNIBridge.nativeSetInfo(0L, "app-version", str4, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append(Util.sJSIDataDir);
            sb.append("/");
            sb.append(str3);
            String obj4 = sb.toString();
            if (supportMultipleEngine()) {
                Object engineCmd = Bridge.engineCmd(null, 8, i, new Object[]{obj4, str, str2});
                if (engineCmd instanceof Long) {
                    this.mNativeInstance = ((Long) engineCmd).longValue();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Create JSEngine '");
                    sb2.append(str);
                    sb2.append("' failed!");
                    OSUtil.e(sb2.toString());
                }
            } else {
                this.mNativeInstance = JNIBridge.nativeInitInstance(obj4, str, str2);
            }
            requestLoopAsync(0L);
            return;
        }
        this.mNativeInstance = j;
    }

    public long getNativeInstance() {
        return this.mNativeInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispose(boolean z) {
        synchronized (this) {
            Iterator<JSContext> it = getContexts().iterator();
            while (it.hasNext()) {
                removeContext(it.next());
            }
            if (this.mEnableStat && this.mPrintObjectsAtDispose) {
                OSUtil.i("Print java objects at dispose ...");
                doPrintObjects();
            }
            long j = this.mNativeInstance;
            this.mNativeInstance = 0L;
            if (!z) {
                JNIBridge.nativeDisposeInstance(j);
            }
            if (this.mEnableStat) {
                LeakUtil.statSwitchChanged(false);
                this.mEnableStat = false;
            }
            Map<Long, JSEngine> map = sJSEngines;
            synchronized (map) {
                sIdentifierMap.remove(this.mEmbedderName);
                map.remove(Long.valueOf(j));
            }
        }
    }

    public static JSEngine getInstance(long j) {
        JSEngine jSEngine;
        Map<Long, JSEngine> map = sJSEngines;
        synchronized (map) {
            jSEngine = map.get(Long.valueOf(j));
        }
        return jSEngine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSEngine createInstanceImpl(Object obj, String str, String str2, String str3, String str4, int i, long j, Object obj2) {
        JSEngine jSEngine;
        Map<Long, JSEngine> map = sJSEngines;
        synchronized (map) {
            Map<String, Long> map2 = sIdentifierMap;
            Long l = map2.get(str);
            if (l != null && l.longValue() != 0 && (jSEngine = map.get(l)) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instance '");
                sb.append(str);
                sb.append("' already created!");
                OSUtil.w(sb.toString());
                return jSEngine;
            }
            JSEngine jSEngine2 = new JSEngine(obj, str, str2, str4, i, j, obj2);
            map2.put(str, Long.valueOf(jSEngine2.mNativeInstance));
            map.put(Long.valueOf(jSEngine2.mNativeInstance), jSEngine2);
            if (str3 != null && str3.length() > 0) {
                jSEngine2.mPrintObjectsAtDispose = !str3.contains("--disable-print-objects-at-dispose");
                JNIBridge.nativeSetInfo(jSEngine2.mNativeInstance, "flags", str3, 0L);
            }
            return jSEngine2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean loadSoImpl(String str, String str2, String str3) {
        boolean loadSo;
        synchronized (sSoLoadLock) {
            loadSo = Util.loadSo(str, str2, str3);
        }
        return loadSo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSContext createContextImpl(String str, Object obj, Class<? extends Annotation> cls) {
        JSContext jSContext = new JSContext(str, obj, (JSEngine) this, cls);
        jSContext.setDeleteUnusedObjectsRunnable(new CrossThreadRunnable(6, new Object[]{jSContext}));
        synchronized (this.mContexts) {
            this.mContexts.add(jSContext);
        }
        requestLoopAsync(0L);
        return jSContext;
    }

    public static JSEngine getInstance(String str) {
        Map<Long, JSEngine> map = sJSEngines;
        synchronized (map) {
            Long l = sIdentifierMap.get(str);
            if (l == null || l.longValue() == 0) {
                return null;
            }
            return map.get(l);
        }
    }

    public String getEmbedderName() {
        return this.mEmbedderName;
    }

    public void dispose() {
        dispose(false);
    }

    public boolean isDisposed() {
        return this.mNativeInstance == 0;
    }

    public List<JSContext> getContexts() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mContexts) {
            Iterator<JSContext> it = this.mContexts.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public int getContextCount() {
        int size;
        synchronized (this.mContexts) {
            size = this.mContexts.size();
        }
        return size;
    }

    public JSContext getContext(long j) {
        synchronized (this.mContexts) {
            Iterator<JSContext> it = this.mContexts.iterator();
            while (it.hasNext()) {
                JSContext next = it.next();
                if (next.getId() == j) {
                    return next;
                }
            }
            return null;
        }
    }

    public JSContext createContext(String str) {
        return createContextImpl(str, null, null);
    }

    public void removeContext(JSContext jSContext) {
        if (!jSContext.isDisposed()) {
            jSContext.dispose();
        }
        synchronized (this.mContexts) {
            this.mContexts.remove(jSContext);
        }
        requestLoopAsync(0L);
    }

    public void startTrace(String str, String str2) {
        if (str == null) {
            str = sTraceFilePattern;
        }
        if (str2 == null) {
            str2 = sTraceCategories;
        }
        if (syncCall()) {
            doStartTrace(str, str2);
            return;
        }
        Object obj = this.mHandler;
        if (obj != null) {
            OSUtil.postTask(obj, new CrossThreadRunnable(1, new Object[]{str, str2}));
        } else {
            warnThreadNoHandler();
        }
    }

    public void stopTrace() {
        if (syncCall()) {
            doStopTrace();
            return;
        }
        Object obj = this.mHandler;
        if (obj != null) {
            OSUtil.postTask(obj, new CrossThreadRunnable(2));
        } else {
            warnThreadNoHandler();
        }
    }

    public long onExternalMemoryChange(long j) {
        if (syncCall()) {
            return JNIBridge.nativeCommand(9L, this.mNativeInstance, new Object[]{Long.valueOf(j)});
        }
        Object obj = this.mHandler;
        if (obj != null) {
            OSUtil.postTask(obj, new CrossThreadRunnable(7, new Object[]{Long.valueOf(j)}));
            return -1L;
        }
        warnThreadNoHandler();
        return -1L;
    }

    public void onLowMemory() {
        if (syncCall()) {
            JNIBridge.nativeOnLowMemory(this.mNativeInstance);
            return;
        }
        Object obj = this.mHandler;
        if (obj != null) {
            OSUtil.postTask(obj, new CrossThreadRunnable(5));
        } else {
            warnThreadNoHandler();
        }
    }

    public void setEnableStats(boolean z) {
        if (this.mEnableStat != z && !isDisposed()) {
            LeakUtil.statSwitchChanged(z);
            this.mEnableStat = z;
        }
        if (!z) {
            synchronized (this.mObjects) {
                this.mObjects.clear();
                this.mHasObjects = false;
            }
        }
        Bridge.engineCmd((JSEngine) this, 5, z ? 1L : 0L);
    }

    public void setMaxPrintCount(int i) {
        this.mMaxPrintCount = i;
    }

    public void printObjects() {
        if (syncCall()) {
            doPrintObjects();
            return;
        }
        Object obj = this.mHandler;
        if (obj != null) {
            OSUtil.postTask(obj, new CrossThreadRunnable(3));
        } else {
            warnThreadNoHandler();
        }
    }

    public int getCurrentEngineType() {
        Object engineCmd = Bridge.engineCmd((JSEngine) this, 6, 0L);
        if (engineCmd instanceof Integer) {
            return ((Integer) engineCmd).intValue();
        }
        return 0;
    }

    public static boolean supportMultipleEngine() {
        return Bridge.engineCmd(null, 7, 0L) != null;
    }

    public static String getEngineType() {
        Object engineCmd = Bridge.engineCmd(null, 4, 0L);
        if (engineCmd instanceof String) {
            return (String) engineCmd;
        }
        return null;
    }

    public static String getVersion() {
        return JNIBridge.nativeGetVersion(null);
    }

    public static int getVersionInt() {
        return (int) JNIBridge.nativeCommand(3L, 0L, null);
    }

    public boolean setData(int i, Object obj) {
        Object[] objArr = this.mDataSlots;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = obj;
        return true;
    }

    public Object getData(int i) {
        Object[] objArr = this.mDataSlots;
        if (i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public int getDataSlotsCount() {
        return this.mDataSlots.length;
    }

    public static boolean startRemoteInspect(String str) {
        return JNIBridge.nativeCommand(10L, 0L, new Object[]{str}) == 1;
    }

    public static void stopRemoteInspect() {
        JNIBridge.nativeCommand(11L, 0L, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void objectCreated(Deletable deletable) {
        if (this.mEnableStat) {
            synchronized (this.mObjects) {
                this.mObjects.add(deletable);
                this.mHasObjects = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void objectDeleted(Deletable deletable) {
        if (this.mHasObjects) {
            synchronized (this.mObjects) {
                this.mObjects.remove(deletable);
                this.mHasObjects = this.mObjects.size() != 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestLoopAsync(long j) {
        Object obj = this.mHandler;
        if (obj != null) {
            OSUtil.removeTask(obj, this.mAsyncLoopRunnable);
            OSUtil.postTask(this.mHandler, this.mAsyncLoopRunnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyDeleteUnusedObjects(JSContext jSContext) {
        if (this.mHandler != null) {
            Runnable deleteUnusedObjectsRunnable = jSContext.getDeleteUnusedObjectsRunnable();
            OSUtil.removeTask(this.mHandler, deleteUnusedObjectsRunnable);
            OSUtil.postTask(this.mHandler, deleteUnusedObjectsRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class CrossThreadRunnable implements Runnable {
        private final Object[] mArgs;
        private final int mTaskType;

        CrossThreadRunnable(int i) {
            this.mTaskType = i;
            this.mArgs = null;
        }

        CrossThreadRunnable(int i, Object[] objArr) {
            this.mTaskType = i;
            this.mArgs = objArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSEngineBase jSEngineBase = JSEngineBase.this;
            jSEngineBase.mRunningHandlerMatches = OSUtil.handlerInCurrentThread(jSEngineBase.mHandler);
            switch (this.mTaskType) {
                case 1:
                    JSEngineBase jSEngineBase2 = JSEngineBase.this;
                    Object[] objArr = this.mArgs;
                    jSEngineBase2.doStartTrace((String) objArr[0], (String) objArr[1]);
                    return;
                case 2:
                    JSEngineBase.this.doStopTrace();
                    return;
                case 3:
                    JSEngineBase.this.doPrintObjects();
                    return;
                case 4:
                    JNIBridge.nativeOnLoop(JSEngineBase.this.mNativeInstance);
                    return;
                case 5:
                    JNIBridge.nativeOnLowMemory(JSEngineBase.this.mNativeInstance);
                    return;
                case 6:
                    ((JSContext) this.mArgs[0]).getJ2JHelper().deleteUnusedObjects();
                    return;
                case 7:
                    JNIBridge.nativeCommand(9L, JSEngineBase.this.mNativeInstance, this.mArgs);
                    return;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown JSI task ");
                    sb.append(this.mTaskType);
                    OSUtil.e(sb.toString());
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartTrace(String str, String str2) {
        OSUtil.i("Starting trace");
        if (JNIBridge.nativeStartTrace(this.mNativeInstance, str, str2)) {
            return;
        }
        OSUtil.e("Start trace failed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStopTrace() {
        OSUtil.i("Stopping trace");
        JNIBridge.nativeStopTrace(this.mNativeInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPrintObjects() {
        JSContext jSContext;
        synchronized (this.mContexts) {
            Iterator<JSContext> it = this.mContexts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    jSContext = null;
                    break;
                }
                jSContext = it.next();
                if (!jSContext.isDisposed()) {
                    break;
                }
            }
        }
        synchronized (this.mObjects) {
            LeakUtil.printObjects(jSContext, this.mObjects, this.mEmbedderName, this.mMaxPrintCount);
        }
    }

    private void warnThreadNoHandler() {
        StringBuilder sb = new StringBuilder();
        sb.append("The creation thread of JSEngine \"");
        sb.append(this.mEmbedderName);
        sb.append("\" do not have a looper!");
        OSUtil.w(sb.toString());
    }

    private boolean syncCall() {
        return this.mRunningHandlerMatches && OSUtil.handlerInCurrentThread(this.mHandler);
    }
}
