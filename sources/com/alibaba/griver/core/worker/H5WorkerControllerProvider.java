package com.alibaba.griver.core.worker;

import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.base.api.H5Event;
import com.alibaba.griver.base.api.H5ServiceWorkerHook4Bridge;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.nebula.WorkerApiConfig;
import com.alibaba.griver.core.worker.H5Worker;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes6.dex */
public class H5WorkerControllerProvider {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String KYLIN_BRIDGE = "https://alipay.kylinBridge";
    private static int MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;
    protected static String TAG = "H5WorkerControllerProvider";
    private static Set<String> d = null;
    private static List<String> e = null;
    private static char getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    protected App app;
    private WeakReference<Page> c;
    private boolean f;
    private Handler g;
    private boolean h;
    protected H5Worker mWorker;

    /* renamed from: a  reason: collision with root package name */
    private final int f6495a = 100;
    protected boolean mIsFirstJsApi = true;
    private boolean b = true;

    static {
        PlaceComponentResult();
        try {
            int i = MyBillsEntityDataFactory + 101;
            try {
                getErrorConfigVersion = i % 128;
                if ((i % 2 == 0 ? 'R' : JSONLexer.EOI) != 'R') {
                    return;
                }
                int i2 = 72 / 0;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = (char) 31300;
        getAuthRequestContext = (char) 51015;
        PlaceComponentResult = (char) 29838;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 26824;
    }

    private static boolean a() {
        int i = getErrorConfigVersion + 65;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            int i3 = MyBillsEntityDataFactory + 105;
            try {
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return true;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    static /* synthetic */ void access$000(H5WorkerControllerProvider h5WorkerControllerProvider, JSONObject jSONObject) {
        try {
            int i = MyBillsEntityDataFactory + 53;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            h5WorkerControllerProvider.a(jSONObject);
            try {
                int i3 = MyBillsEntityDataFactory + 47;
                getErrorConfigVersion = i3 % 128;
                if ((i3 % 2 == 0 ? 'C' : '8') != '8') {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public H5WorkerControllerProvider(H5Worker h5Worker, App app) {
        this.mWorker = h5Worker;
        this.app = app;
    }

    public static boolean hasSyncApiPermission(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("hasSyncApiPermission == ");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        if ((d == null ? Typography.less : (char) 16) == '<') {
            try {
                d = WorkerApiConfig.getDefaultSyncJsApiSet();
                JSONObject parseObject = JSONUtils.parseObject(GriverConfig.getConfigWithProcessCache("h5_swSyncJsApiConfig", ""));
                JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, "added", null);
                if (jSONArray != null) {
                    int size = jSONArray.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        int i2 = getErrorConfigVersion + 59;
                        MyBillsEntityDataFactory = i2 % 128;
                        int i3 = i2 % 2;
                        try {
                            d.add(jSONArray.getString(i));
                            i++;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
                JSONArray jSONArray2 = JSONUtils.getJSONArray(parseObject, "black_list", null);
                if (jSONArray != null) {
                    int size2 = jSONArray.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        d.remove(jSONArray2.getString(i4));
                    }
                }
            } catch (Exception e3) {
                throw e3;
            }
        }
        Set<String> set = d;
        if (set != null) {
            int i5 = getErrorConfigVersion + 65;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
            if ((!set.isEmpty() ? 'Q' : '6') != '6') {
                return d.contains(str);
            }
            return false;
        }
        return false;
    }

    private void a(String str) {
        if (this.b) {
            try {
                int i = getErrorConfigVersion + 15;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                this.b = false;
                RVEvents.BRIDGE_READY.equals(str);
                int i3 = getErrorConfigVersion + 115;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i5 = getErrorConfigVersion + 5;
        MyBillsEntityDataFactory = i5 % 128;
        if ((i5 % 2 != 0 ? '\'' : 'K') != 'K') {
            int i6 = 55 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0297, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest4Worker(java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.H5WorkerControllerProvider.shouldInterceptRequest4Worker(java.lang.String):android.webkit.WebResourceResponse");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.ariver.app.api.Page getTargetH5Page(int r4, java.lang.String r5) {
        /*
            r3 = this;
            int r5 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.getErrorConfigVersion
            int r5 = r5 + 43
            int r0 = r5 % 128
            com.alibaba.griver.core.worker.H5WorkerControllerProvider.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            boolean r5 = r3.f     // Catch: java.lang.Exception -> L52
            r0 = 0
            if (r5 == 0) goto L2e
            int r5 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.getErrorConfigVersion
            int r5 = r5 + 57
            int r1 = r5 % 128
            com.alibaba.griver.core.worker.H5WorkerControllerProvider.MyBillsEntityDataFactory = r1
            int r5 = r5 % 2
            java.lang.ref.WeakReference<com.alibaba.ariver.app.api.Page> r5 = r3.c
            r1 = 50
            if (r5 == 0) goto L22
            r2 = 50
            goto L24
        L22:
            r2 = 66
        L24:
            if (r2 == r1) goto L27
            goto L2e
        L27:
            java.lang.Object r5 = r5.get()
            com.alibaba.ariver.app.api.Page r5 = (com.alibaba.ariver.app.api.Page) r5
            goto L2f
        L2e:
            r5 = r0
        L2f:
            r1 = 56
            if (r5 == 0) goto L36
            r2 = 56
            goto L38
        L36:
            r2 = 35
        L38:
            if (r2 == r1) goto L3b
            goto L4f
        L3b:
            com.alibaba.ariver.engine.api.Render r1 = r5.getRender()     // Catch: java.lang.Exception -> L50
            int r1 = r1.getPageId()     // Catch: java.lang.Exception -> L50
            r2 = 31
            if (r1 != r4) goto L4a
            r4 = 58
            goto L4c
        L4a:
            r4 = 31
        L4c:
            if (r4 == r2) goto L4f
            return r5
        L4f:
            return r0
        L50:
            r4 = move-exception
            throw r4
        L52:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.H5WorkerControllerProvider.getTargetH5Page(int, java.lang.String):com.alibaba.ariver.app.api.Page");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fb, code lost:
    
        if ((r0 == null ? 'D' : 'K') != 'K') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
    
        if (com.alibaba.ariver.kernel.common.utils.JSONUtils.getJSONObject(r10, "data", null) == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0106, code lost:
    
        r10 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.getErrorConfigVersion + 101;
        com.alibaba.griver.core.worker.H5WorkerControllerProvider.MyBillsEntityDataFactory = r10 % 128;
        r10 = r10 % 2;
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.griver.core.worker.H5WorkerControllerProvider.TAG, "invalid param, handleMsgFromWorker data = null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0117, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0124, code lost:
    
        if (com.alibaba.griver.core.embedview.NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(r10.getString("handlerName")) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0126, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0128, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0129, code lost:
    
        if (r3 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012b, code lost:
    
        r3 = r10.getString("callbackId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0135, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0137, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.griver.core.worker.H5WorkerControllerProvider.TAG, "invalid callbackId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013f, code lost:
    
        handleMsgFromJs(r10.getString("handlerName"), r10, new com.alibaba.griver.core.worker.H5WorkerControllerProvider.AnonymousClass3(r9), r9.mWorker.getWorkerId(), 80);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0156, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0157, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0158, code lost:
    
        r0 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.MyBillsEntityDataFactory + 43;
        com.alibaba.griver.core.worker.H5WorkerControllerProvider.getErrorConfigVersion = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0162, code lost:
    
        if ((r0 % 2) != 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0164, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0166, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0167, code lost:
    
        if (r0 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0169, code lost:
    
        a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016d, code lost:
    
        a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0171, code lost:
    
        r10 = 3 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMsgFromWorker(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.H5WorkerControllerProvider.handleMsgFromWorker(java.lang.String):boolean");
    }

    private void a(final JSONObject jSONObject) {
        int i;
        int i2 = getErrorConfigVersion + 87;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        if (!this.mWorker.isRenderReady()) {
            this.mWorker.registerRenderReadyListener(new H5Worker.RenderReadyListener() { // from class: com.alibaba.griver.core.worker.H5WorkerControllerProvider.4
                @Override // com.alibaba.griver.core.worker.H5Worker.RenderReadyListener
                public void onRenderReady() {
                    H5WorkerControllerProvider.access$000(H5WorkerControllerProvider.this, jSONObject);
                }
            });
            int i4 = MyBillsEntityDataFactory + 51;
            getErrorConfigVersion = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 93 / 0;
                return;
            }
            return;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
        if ((jSONObject2.containsKey("viewId") ? (char) 5 : 'Q') != 5) {
            i = -1;
        } else {
            int i6 = MyBillsEntityDataFactory + 113;
            getErrorConfigVersion = i6 % 128;
            if (!(i6 % 2 == 0)) {
                i = JSONUtils.getInt(jSONObject2, "viewId");
            } else {
                i = JSONUtils.getInt(jSONObject2, "viewId");
                int i7 = 66 / 0;
            }
        }
        try {
            try {
                if (getTargetH5Page(i, this.mWorker.getWorkerId()) == null) {
                    RVLogger.e(TAG, "error! can't find target H5Page");
                    return;
                }
                new H5Event.Builder().action("message").param(jSONObject).type("call").build();
                int i8 = getErrorConfigVersion + 11;
                MyBillsEntityDataFactory = i8 % 128;
                int i9 = i8 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (r4 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        if ((r0.contains(r4) ? false : true) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        return com.alibaba.griver.base.nebula.H5EventDispatchHandler.getAsyncHandler();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.os.Handler getHandler(java.lang.String r4) {
        /*
            r3 = this;
            java.util.List<java.lang.String> r0 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.e
            if (r0 != 0) goto L10
            java.util.List r0 = com.alibaba.griver.base.nebula.WorkerApiConfig.getDefaultAsyncJsApiList()
            com.alibaba.griver.core.worker.H5WorkerControllerProvider.e = r0
            boolean r0 = a()
            r3.h = r0
        L10:
            boolean r0 = r3.h
            if (r0 == 0) goto L52
            int r0 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.getErrorConfigVersion
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.alibaba.griver.core.worker.H5WorkerControllerProvider.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.util.List<java.lang.String> r0 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.e
            if (r0 == 0) goto L52
            int r1 = com.alibaba.griver.core.worker.H5WorkerControllerProvider.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L67
            int r1 = r1 + 7
            int r2 = r1 % 128
            com.alibaba.griver.core.worker.H5WorkerControllerProvider.getErrorConfigVersion = r2     // Catch: java.lang.Exception -> L67
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L32
            r1 = 21
            goto L33
        L32:
            r1 = 0
        L33:
            if (r1 == 0) goto L42
            boolean r4 = r0.contains(r4)
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L40
            if (r4 == 0) goto L52
            goto L4d
        L40:
            r4 = move-exception
            throw r4
        L42:
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L49
            goto L4a
        L49:
            r2 = 1
        L4a:
            if (r2 == 0) goto L4d
            goto L52
        L4d:
            android.os.Handler r4 = com.alibaba.griver.base.nebula.H5EventDispatchHandler.getAsyncHandler()
            return r4
        L52:
            android.os.Handler r4 = r3.g
            if (r4 != 0) goto L64
            android.os.Handler r4 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch: java.lang.Exception -> L62
            r4.<init>(r0)
            r3.g = r4     // Catch: java.lang.Exception -> L62
            goto L64
        L62:
            r4 = move-exception
            throw r4
        L64:
            android.os.Handler r4 = r3.g     // Catch: java.lang.Exception -> L67
            return r4
        L67:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.worker.H5WorkerControllerProvider.getHandler(java.lang.String):android.os.Handler");
    }

    protected void handleMsgFromJs(final String str, final JSONObject jSONObject, final H5ServiceWorkerHook4Bridge h5ServiceWorkerHook4Bridge, final String str2, final int i) {
        final Handler handler = getHandler(str);
        handler.post(new Runnable() { // from class: com.alibaba.griver.core.worker.H5WorkerControllerProvider.5
            @Override // java.lang.Runnable
            public void run() {
                Page targetH5Page;
                try {
                    if (!jSONObject.containsKey("viewId")) {
                        targetH5Page = H5WorkerControllerProvider.this.getTargetH5Page(-1, str2);
                    } else {
                        targetH5Page = H5WorkerControllerProvider.this.getTargetH5Page(JSONUtils.getInt(jSONObject, "viewId", -1), str2);
                    }
                    if (targetH5Page == null) {
                        if (i <= 0) {
                            RVLogger.e(H5WorkerControllerProvider.TAG, "handleMsgFromJs h5Page == null return");
                            return;
                        }
                        RVLogger.w(H5WorkerControllerProvider.TAG, "handleMsgFromJs h5Page == null, try again in 100ms");
                        handler.postDelayed(new Runnable() { // from class: com.alibaba.griver.core.worker.H5WorkerControllerProvider.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                H5WorkerControllerProvider.this.handleMsgFromJs(str, jSONObject, h5ServiceWorkerHook4Bridge, str2, i - 1);
                            }
                        }, 100L);
                        return;
                    }
                    JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
                    String string = JSONUtils.getString(jSONObject, "clientId", null);
                    if (TextUtils.isEmpty(string)) {
                        string = Long.toString(System.nanoTime());
                    }
                    String str3 = H5WorkerControllerProvider.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("clientId is ");
                    sb.append(string);
                    RVLogger.d(str3, sb.toString());
                    H5Event.Builder builder = new H5Event.Builder();
                    if (ProcessUtils.isMainProcess()) {
                        builder.action(str).param(jSONObject2).target(targetH5Page).type("call").id(string).keepCallback(false).eventSource(H5Event.FROM_WORK);
                    } else {
                        builder.action(str).param(jSONObject2).target(targetH5Page).type("call").id(string).keepCallback(false).dispatcherOnWorkerThread(true).eventSource(H5Event.FROM_WORK);
                    }
                    builder.build();
                } catch (Throwable th) {
                    RVLogger.e(H5WorkerControllerProvider.TAG, th);
                }
            }
        });
        try {
            int i2 = MyBillsEntityDataFactory + 37;
            getErrorConfigVersion = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int i3 = 15 / 0;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void destroy() {
        try {
            int i = MyBillsEntityDataFactory + 19;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            Handler handler = this.g;
            if (!(handler == null)) {
                int i3 = getErrorConfigVersion + 9;
                MyBillsEntityDataFactory = i3 % 128;
                Object obj = null;
                if ((i3 % 2 != 0 ? 'R' : '\\') != '\\') {
                    handler.removeCallbacksAndMessages(null);
                    this.g = null;
                    obj.hashCode();
                } else {
                    try {
                        handler.removeCallbacksAndMessages(null);
                        this.g = null;
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            int i4 = getErrorConfigVersion + 63;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e3) {
            throw e3;
        }
    }

    private static void i(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if (!(c.BuiltInFictitiousFunctionClassFactory >= cArr.length)) {
                int i2 = $11 + 67;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (!(i5 >= 16)) {
                        int i6 = $10 + 31;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                        i4 -= 40503;
                        i5++;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
