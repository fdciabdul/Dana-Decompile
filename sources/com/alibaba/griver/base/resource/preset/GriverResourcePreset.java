package com.alibaba.griver.base.resource.preset;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.resource.preset.GriverResourcePresetProxy;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
import o.A;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class GriverResourcePreset {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String APPX_PRESET_JSON = "/appx.json";
    public static final String DEFAULT_PRESET_PATH = "Griver";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;

    /* renamed from: a  reason: collision with root package name */
    private static GriverResourcePresetProxy f6376a;
    private static Map<String, AppModel> b;
    private static Map<String, RVResourcePresetProxy.PresetPackage> c;
    private static List<String> d;

    static void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 269894690;
    }

    static /* synthetic */ List access$000() {
        int i = PlaceComponentResult + 121;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        List<String> a2 = a();
        try {
            int i3 = PlaceComponentResult + 73;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return a2;
            }
            int i4 = 68 / 0;
            return a2;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ GriverResourcePresetProxy access$100() {
        int i = MyBillsEntityDataFactory + 51;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            try {
                return f6376a;
            } catch (Exception e) {
                throw e;
            }
        }
        GriverResourcePresetProxy griverResourcePresetProxy = f6376a;
        Object obj = null;
        obj.hashCode();
        return griverResourcePresetProxy;
    }

    static {
        try {
            BuiltInFictitiousFunctionClassFactory();
            f6376a = new GriverResourcePresetProxy() { // from class: com.alibaba.griver.base.resource.preset.GriverResourcePreset.1
                @Override // com.alibaba.griver.api.resource.preset.GriverResourcePresetProxy
                public final String getPresetResourcePath() {
                    return "Griver";
                }
            };
            int i = PlaceComponentResult + 15;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void setGriverResourcePresetProxy(GriverResourcePresetProxy griverResourcePresetProxy) {
        int i = MyBillsEntityDataFactory + 1;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (griverResourcePresetProxy == null) {
            return;
        }
        int i3 = PlaceComponentResult + 97;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        f6376a = griverResourcePresetProxy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if ((com.alibaba.ariver.kernel.common.utils.ProcessUtils.isMainProcess() ? false : true) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w("GriverResourcePreset", "do not save preset configuration in non-main process");
        r0 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.MyBillsEntityDataFactory + 33;
        com.alibaba.griver.base.resource.preset.GriverResourcePreset.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if ((r0 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        r0 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r0 = 'A';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        if (r0 == 'N') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        com.alibaba.griver.base.common.executor.GriverExecutors.getSingleOrderThreadExecutorByName("saveConfiguration").execute(new com.alibaba.griver.base.resource.preset.GriverResourcePreset.AnonymousClass2(10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (com.alibaba.ariver.kernel.common.utils.ProcessUtils.isMainProcess() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void savePresetConfiguration() {
        /*
            int r0 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.PlaceComponentResult
            int r0 = r0 + 31
            int r1 = r0 % 128
            com.alibaba.griver.base.resource.preset.GriverResourcePreset.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1b
            boolean r0 = com.alibaba.ariver.kernel.common.utils.ProcessUtils.isMainProcess()     // Catch: java.lang.Exception -> L19
            r2 = 70
            int r2 = r2 / r1
            if (r0 != 0) goto L48
            goto L24
        L17:
            r0 = move-exception
            throw r0
        L19:
            r0 = move-exception
            throw r0
        L1b:
            boolean r0 = com.alibaba.ariver.kernel.common.utils.ProcessUtils.isMainProcess()
            if (r0 != 0) goto L22
            r1 = 1
        L22:
            if (r1 == 0) goto L48
        L24:
            java.lang.String r0 = "GriverResourcePreset"
            java.lang.String r1 = "do not save preset configuration in non-main process"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r0, r1)
            int r0 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.MyBillsEntityDataFactory
            int r0 = r0 + 33
            int r1 = r0 % 128
            com.alibaba.griver.base.resource.preset.GriverResourcePreset.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 78
            if (r0 != 0) goto L3c
            r0 = 78
            goto L3e
        L3c:
            r0 = 65
        L3e:
            if (r0 == r1) goto L41
            return
        L41:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L46
            return
        L46:
            r0 = move-exception
            throw r0
        L48:
            java.lang.String r0 = "saveConfiguration"
            java.util.concurrent.Executor r0 = com.alibaba.griver.base.common.executor.GriverExecutors.getSingleOrderThreadExecutorByName(r0)
            com.alibaba.griver.base.resource.preset.GriverResourcePreset$2 r1 = new com.alibaba.griver.base.resource.preset.GriverResourcePreset$2
            r2 = 10
            r1.<init>(r2)
            r0.execute(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.resource.preset.GriverResourcePreset.savePresetConfiguration():void");
    }

    private static List<String> a() {
        int i = PlaceComponentResult + 71;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (d == null) {
            d = new ArrayList();
            Resources resources = GriverEnv.getResources();
            StringBuilder sb = new StringBuilder();
            sb.append(f6376a.getPresetResourcePath());
            sb.append("/applist.json");
            try {
                JSONObject parseObject = JSON.parseObject(IOUtils.readAsset(resources, sb.toString()));
                Object[] objArr = new Object[1];
                e(new char[]{65531, 65514, 65534, CharCompanionObject.MAX_VALUE, '\f', 65531, 2, '\r', '\r', CharCompanionObject.MAX_VALUE, 1, 65531, 5, 65533}, 109 - (ViewConfiguration.getTouchSlop() >> 8), 15 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), true, TextUtils.indexOf("", "", 0) + 8, objArr);
                d = JSON.parseArray(JSON.toJSONString(parseObject.get(((String) objArr[0]).intern())), String.class);
            } catch (Exception e) {
                GriverLogger.w("GriverResourcePreset", "parse preset shared package failed", e);
            }
        }
        List<String> list = d;
        int i3 = PlaceComponentResult + 35;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : 'G') != 'D') {
            return list;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        return list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if (r3 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (com.alibaba.griver.base.resource.preset.GriverResourcePreset.b == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> getPresetAppInfos() {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "mini"
            java.lang.String r2 = "GriverResourcePreset"
            int r3 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.PlaceComponentResult
            int r3 = r3 + 103
            int r4 = r3 % 128
            com.alibaba.griver.base.resource.preset.GriverResourcePreset.MyBillsEntityDataFactory = r4
            r4 = 2
            int r3 = r3 % r4
            r5 = 39
            if (r3 == 0) goto L17
            r3 = 39
            goto L19
        L17:
            r3 = 31
        L19:
            if (r3 == r5) goto L20
            java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> r3 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.b
            if (r3 != 0) goto Ldf
            goto L26
        L20:
            java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> r3 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.b
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> Le2
            if (r3 != 0) goto Ldf
        L26:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.alibaba.griver.base.resource.preset.GriverResourcePreset.b = r3
            android.content.res.Resources r3 = com.alibaba.griver.base.common.env.GriverEnv.getResources()
            java.lang.String r5 = "Griver/appx.json"
            java.lang.String r3 = com.alibaba.ariver.kernel.common.utils.IOUtils.readAsset(r3, r5)
            com.alibaba.fastjson.JSONObject r3 = com.alibaba.fastjson.JSON.parseObject(r3)     // Catch: java.lang.Throwable -> L56
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = com.alibaba.fastjson.JSON.toJSONString(r3)     // Catch: java.lang.Throwable -> L56
            java.util.Map r3 = com.alibaba.griver.base.resource.GriverResourceManager.parseAppInfoFromJSONString(r3)     // Catch: java.lang.Throwable -> L56
            java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> r5 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.b     // Catch: java.lang.Throwable -> L56
            r5.putAll(r3)     // Catch: java.lang.Throwable -> L56
            int r3 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.MyBillsEntityDataFactory
            int r3 = r3 + 121
            int r5 = r3 % 128
            com.alibaba.griver.base.resource.preset.GriverResourcePreset.PlaceComponentResult = r5
            int r3 = r3 % r4
            goto L5d
        L56:
            r3 = move-exception
            java.lang.String r5 = "read appx configuration failed"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r2, r5, r3)
        L5d:
            android.content.res.Resources r3 = com.alibaba.griver.base.common.env.GriverEnv.getResources()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.alibaba.griver.api.resource.preset.GriverResourcePresetProxy r6 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.f6376a
            java.lang.String r6 = r6.getPresetResourcePath()
            r5.append(r6)
            java.lang.String r6 = "/applist.json"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r3 = com.alibaba.ariver.kernel.common.utils.IOUtils.readAsset(r3, r5)
            com.alibaba.fastjson.JSONObject r3 = com.alibaba.fastjson.JSON.parseObject(r3)     // Catch: java.lang.Exception -> Ld9
            r5 = 4
            char[] r6 = new char[r5]     // Catch: java.lang.Exception -> Ld9
            r7 = 3
            r12 = 0
            r6[r12] = r7     // Catch: java.lang.Exception -> Ld9
            r8 = 65524(0xfff4, float:9.1819E-41)
            r9 = 1
            r6[r9] = r8     // Catch: java.lang.Exception -> Ld9
            r8 = 6
            r6[r4] = r8     // Catch: java.lang.Exception -> Ld9
            r6[r7] = r7     // Catch: java.lang.Exception -> Ld9
            int r7 = android.view.MotionEvent.axisFromString(r0)     // Catch: java.lang.Exception -> Ld9
            int r7 = 115 - r7
            int r0 = android.text.TextUtils.getOffsetBefore(r0, r12)     // Catch: java.lang.Exception -> Ld9
            int r8 = r0 + 4
            r0 = 1
            r10 = 0
            int r5 = android.widget.ExpandableListView.getPackedPositionGroup(r10)     // Catch: java.lang.Exception -> Ld9
            int r10 = r5 + 2
            java.lang.Object[] r4 = new java.lang.Object[r9]     // Catch: java.lang.Exception -> Ld9
            r9 = r0
            r11 = r4
            e(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> Ld9
            r0 = r4[r12]     // Catch: java.lang.Exception -> Ld9
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Ld9
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> Ld9
            java.lang.Object r0 = r3.get(r0)     // Catch: java.lang.Exception -> Ld9
            java.lang.String r0 = com.alibaba.fastjson.JSON.toJSONString(r0)     // Catch: java.lang.Exception -> Ld9
            java.util.Map r0 = com.alibaba.griver.base.resource.GriverResourceManager.parseAppInfoFromJSONString(r0)     // Catch: java.lang.Exception -> Ld9
            java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> r4 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.b     // Catch: java.lang.Exception -> Ld9
            r4.putAll(r0)     // Catch: java.lang.Exception -> Ld9
            java.lang.Object r0 = r3.get(r1)     // Catch: java.lang.Exception -> Ld9
            java.lang.String r0 = com.alibaba.fastjson.JSON.toJSONString(r0)     // Catch: java.lang.Exception -> Ld9
            java.util.Map r0 = com.alibaba.griver.base.resource.GriverResourceManager.parseAppInfoFromJSONString(r0)     // Catch: java.lang.Exception -> Ld9
            java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> r1 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.b     // Catch: java.lang.Exception -> Ld9
            r1.putAll(r0)     // Catch: java.lang.Exception -> Ld9
            goto Ldf
        Ld9:
            r0 = move-exception
            java.lang.String r1 = "parse preset config failed"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r2, r1, r0)
        Ldf:
            java.util.Map<java.lang.String, com.alibaba.ariver.resource.api.models.AppModel> r0 = com.alibaba.griver.base.resource.preset.GriverResourcePreset.b
            return r0
        Le2:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.resource.preset.GriverResourcePreset.getPresetAppInfos():java.util.Map");
    }

    public static Map<String, RVResourcePresetProxy.PresetPackage> getPresetPackage() {
        String[] list;
        try {
            if (c == null) {
                c = new HashMap();
                try {
                    ArrayList arrayList = new ArrayList();
                    if (!(TextUtils.equals(f6376a.getPresetResourcePath(), "Griver")) && (list = GriverEnv.getApplicationContext().getAssets().list("Griver")) != null) {
                        int i = MyBillsEntityDataFactory + 21;
                        PlaceComponentResult = i % 128;
                        int i2 = i % 2;
                        if (list.length > 0) {
                            GriverLogger.d("GriverResourcePreset", "add default path preset package");
                            arrayList.addAll(Arrays.asList(list));
                        }
                    }
                    String[] list2 = GriverEnv.getApplicationContext().getAssets().list(f6376a.getPresetResourcePath());
                    if ((list2 != null ? (char) 30 : '!') == 30) {
                        if (list2.length > 0) {
                            int i3 = MyBillsEntityDataFactory + 63;
                            PlaceComponentResult = i3 % 128;
                            int i4 = i3 % 2;
                            GriverLogger.d("GriverResourcePreset", "add app path preset package");
                            arrayList.addAll(Arrays.asList(list2));
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (int i5 = 0; i5 < arrayList.size(); i5++) {
                            int i6 = MyBillsEntityDataFactory + 11;
                            PlaceComponentResult = i6 % 128;
                            int i7 = i6 % 2;
                            final String str = (String) arrayList.get(i5);
                            if (!(TextUtils.isEmpty(str)) && str.endsWith(".amr")) {
                                int lastIndexOf = str.lastIndexOf("_");
                                int lastIndexOf2 = str.lastIndexOf(".");
                                if ((lastIndexOf > 0) && lastIndexOf2 > 0) {
                                    String substring = str.substring(0, lastIndexOf);
                                    String substring2 = str.substring(lastIndexOf + 1, lastIndexOf2);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("load preset appId: ");
                                    sb.append(substring);
                                    sb.append(", version: ");
                                    sb.append(substring2);
                                    GriverLogger.d("GriverResourcePreset", sb.toString());
                                    c.put(substring, new RVResourcePresetProxy.PresetPackage(substring, substring2, new RVResourcePresetProxy.InputStreamGetter() { // from class: com.alibaba.griver.base.resource.preset.GriverResourcePreset.3
                                        private static int MyBillsEntityDataFactory = 0;
                                        private static int getAuthRequestContext = 1;

                                        @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy.InputStreamGetter
                                        public final InputStream onGetInputStream() {
                                            Application applicationContext;
                                            int i8 = MyBillsEntityDataFactory + 23;
                                            getAuthRequestContext = i8 % 128;
                                            Object[] objArr = null;
                                            try {
                                                if (i8 % 2 != 0) {
                                                    applicationContext = GriverEnv.getApplicationContext();
                                                } else {
                                                    applicationContext = GriverEnv.getApplicationContext();
                                                    int length = objArr.length;
                                                }
                                                try {
                                                    AssetManager assets = ((Resources) Application.class.getMethod("getResources", null).invoke(applicationContext, null)).getAssets();
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append(GriverResourcePreset.access$100().getPresetResourcePath());
                                                    sb2.append(File.separator);
                                                    sb2.append(str);
                                                    try {
                                                        Object[] objArr2 = {assets, sb2.toString()};
                                                        Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                                                        if (obj == null) {
                                                            obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - (ViewConfiguration.getLongPressTimeout() >> 16)), TextUtils.indexOf("", "", 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 48)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                                            NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                                                        }
                                                        InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr2);
                                                        int i9 = getAuthRequestContext + 59;
                                                        MyBillsEntityDataFactory = i9 % 128;
                                                        int i10 = i9 % 2;
                                                        return inputStream;
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            } catch (IOException e) {
                                                GriverLogger.e("GriverResourcePreset", "onGetInputStream error", e);
                                                return null;
                                            }
                                        }
                                    }));
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    GriverLogger.e("GriverResourcePreset", "get preset package failed", e);
                }
            }
            return c;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void e(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            int i4 = $11 + 53;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr3[i6] = (char) (cArr3[i6] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr3, 0, cArr4, 0, i2);
            System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if ((z ? '@' : '[') != '[') {
            int i7 = $11 + 1;
            $10 = i7 % 128;
            if (i7 % 2 == 0) {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
            } else {
                cArr2 = new char[i2];
                try {
                    a2.MyBillsEntityDataFactory = 1;
                } catch (Exception e) {
                    throw e;
                }
            }
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? 'L' : 'E') == 'E') {
                    break;
                }
                try {
                    cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr3 = cArr2;
        }
        objArr[0] = new String(cArr3);
    }
}
