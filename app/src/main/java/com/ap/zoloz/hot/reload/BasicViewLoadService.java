package com.ap.zoloz.hot.reload;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.zebra.data.BoxData;
import com.ap.zoloz.hot.reload.layot.LayoutModel;
import com.ap.zoloz.hot.reload.layot.ZDocModel;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* loaded from: classes7.dex */
public class BasicViewLoadService extends ViewLoadService {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {110, -41, 63, 58, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 133;
    private File mConfigDir;
    private String mConfigPath;
    private Thread mLoadConfigThread;
    private boolean mIsUsedConfig = true;
    private StringsManager mStringsManager = new StringsManager();
    private Map<String, Map<String, String>> mAllResources = new HashMap();
    private Map<String, ZDocModel> mZdocLayouts = new HashMap();
    private String mSpecialJson = "";
    private Map<String, String> mLayoutMapping = new HashMap();
    private Object mLock = new Object();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = com.ap.zoloz.hot.reload.BasicViewLoadService.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 12
            int r6 = 15 - r6
            int r7 = r7 * 3
            int r7 = r7 + 13
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L32
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L32:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ap.zoloz.hot.reload.BasicViewLoadService.a(byte, short, int, java.lang.Object[]):void");
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    protected void onInitViewLoadService(BioServiceManager bioServiceManager, String str) {
        this.mConfigPath = str;
        if (TextUtils.isEmpty(str)) {
            this.mIsUsedConfig = false;
            return;
        }
        File file = new File(this.mConfigPath);
        this.mConfigDir = file;
        if (!file.exists()) {
            this.mIsUsedConfig = false;
            return;
        }
        this.mLayoutMapping.clear();
        this.mLayoutMapping.put("standard_frame", "layout_manual_stand_frame");
        this.mLayoutMapping.put("passport_frame", "layout_manual_passport");
        this.mLayoutMapping.put("empty_frame", "layout_manual_0");
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr2);
            if ("main".equals(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName())) {
                synchronized (this.mLock) {
                    asyncLoadConfig();
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                return;
            }
            syncLoadConfig();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private void asyncLoadConfig() {
        if (this.mLoadConfigThread == null) {
            this.mLoadConfigThread = new Thread(new NotifyRunnalbe(this.mLock) { // from class: com.ap.zoloz.hot.reload.BasicViewLoadService.1
                @Override // com.ap.zoloz.hot.reload.BasicViewLoadService.NotifyRunnalbe
                public void realRun() {
                    BasicViewLoadService.this.syncLoadConfig();
                }
            });
        }
        this.mLoadConfigThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncLoadConfig() {
        File[] listFiles = this.mConfigDir.listFiles(new FilenameFilter() { // from class: com.ap.zoloz.hot.reload.BasicViewLoadService.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("strings");
            }
        });
        this.mStringsManager.clear();
        for (File file : listFiles) {
            String fileToString = fileToString(file);
            if (!TextUtils.isEmpty(fileToString.trim())) {
                try {
                    this.mStringsManager.add(file.getName(), (Map) JSON.parseObject(fileToString, new TypeReference<Map<String, String>>() { // from class: com.ap.zoloz.hot.reload.BasicViewLoadService.3
                    }.getType(), new Feature[0]));
                } catch (Exception unused) {
                }
            }
        }
        try {
            this.mAllResources = (Map) JSON.parseObject(fileToString(new File(this.mConfigDir, "resources.json")), new TypeReference<Map<String, Map<String, String>>>() { // from class: com.ap.zoloz.hot.reload.BasicViewLoadService.4
            }.getType(), new Feature[0]);
        } catch (Exception unused2) {
            this.mAllResources = new HashMap();
        }
        if (this.mAllResources == null) {
            this.mAllResources = new HashMap();
        }
        try {
            Map<String, ZDocModel> map = ((LayoutModel) JSON.parseObject(fileToString(new File(this.mConfigDir, "layout.json")), LayoutModel.class)).zdoc;
            this.mZdocLayouts = map;
            if (map == null) {
                this.mZdocLayouts = new HashMap();
            }
        } catch (Exception unused3) {
            this.mZdocLayouts = new HashMap();
        }
    }

    private void convertZdocLayoutToSpecial() {
        for (Map.Entry<String, ZDocModel> entry : this.mZdocLayouts.entrySet()) {
            ZDocModel value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append("zdoc_");
            sb.append(value.get("view"));
            sb.append("_tips_");
            sb.append(entry.getKey());
            String obj = sb.toString();
            if (!this.mStringsManager.containsKey(obj)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("zdoc_");
                sb2.append(value.get("view"));
                sb2.append("_tips");
                obj = sb2.toString();
            }
            value.put("textResId", obj);
        }
        SerializeFilter[] serializeFilterArr = {new NameFilter() { // from class: com.ap.zoloz.hot.reload.BasicViewLoadService.5
            @Override // com.alibaba.fastjson.serializer.NameFilter
            public String process(Object obj2, String str, Object obj3) {
                return str.equals("view") ? BoxData.ATTR_LAYOUT : str;
            }
        }, new ValueFilter() { // from class: com.ap.zoloz.hot.reload.BasicViewLoadService.6
            @Override // com.alibaba.fastjson.serializer.ValueFilter
            public Object process(Object obj2, String str, Object obj3) {
                if (str.equals(BoxData.ATTR_LAYOUT)) {
                    String str2 = (String) BasicViewLoadService.this.mLayoutMapping.get(obj3);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
                return obj3;
            }
        }};
        Map<String, ZDocModel> map = this.mZdocLayouts;
        if (map == null || map.isEmpty()) {
            this.mSpecialJson = "";
        } else {
            this.mSpecialJson = JSON.toJSONString(this.mZdocLayouts, serializeFilterArr, new SerializerFeature[0]);
        }
    }

    private String fileToString(File file) {
        try {
            Scanner useDelimiter = new Scanner(new FileInputStream(file)).useDelimiter("\\A");
            return useDelimiter.hasNext() ? useDelimiter.next() : "";
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public String getString(String str, int i) {
        return this.mStringsManager.getString(this.mContext, str, i);
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public int getColor(String str, int i) {
        Map<String, String> map = this.mAllResources.get("color");
        if (map == null || map.get(str) == null) {
            return this.mContext.getResources().getColor(i);
        }
        return Color.parseColor(map.get(str));
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public boolean getBool(String str, int i) {
        Map<String, String> map = this.mAllResources.get("bool");
        if (map == null || map.get(str) == null) {
            return this.mContext.getResources().getBoolean(i);
        }
        return Boolean.TRUE.toString().equals(map.get(str));
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public int getInteger(String str, int i) {
        Map<String, String> map = this.mAllResources.get("integer");
        if (map == null || map.get(str) == null) {
            return this.mContext.getResources().getInteger(i);
        }
        try {
            return Integer.parseInt(map.get(str));
        } catch (NumberFormatException unused) {
            return this.mContext.getResources().getInteger(i);
        }
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public Drawable getDrawable(String str, int i) {
        Map<String, String> map = this.mAllResources.get("image");
        if (map == null || map.get(str) == null) {
            return InstrumentInjector.Resources_getDrawable(this.mContext.getResources(), i);
        }
        File file = new File(this.mConfigDir, map.get(str));
        if (!file.exists()) {
            return InstrumentInjector.Resources_getDrawable(this.mContext.getResources(), i);
        }
        try {
            float f = this.mContext.getResources().getDisplayMetrics().density;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = (int) (3.0f / f);
            return new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeFile(file.getAbsolutePath(), options));
        } catch (Exception unused) {
            return InstrumentInjector.Resources_getDrawable(this.mContext.getResources(), i);
        }
    }

    public void setLayoutMapping(Map<String, String> map) {
        this.mLayoutMapping.putAll(map);
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public String getSpecialUiLayout() {
        if (this.mIsUsedConfig) {
            if (TextUtils.isEmpty(this.mSpecialJson)) {
                convertZdocLayoutToSpecial();
            }
            return this.mSpecialJson;
        }
        return null;
    }

    public boolean isUsedConfig() {
        return this.mIsUsedConfig;
    }

    /* loaded from: classes7.dex */
    abstract class NotifyRunnalbe implements Runnable {
        private Object mLock;

        protected abstract void realRun();

        public NotifyRunnalbe(Object obj) {
            this.mLock = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            realRun();
            synchronized (this.mLock) {
                Object obj = this.mLock;
                if (obj != null) {
                    obj.notifyAll();
                }
            }
        }
    }

    @Override // com.ap.zoloz.hot.reload.ViewLoadService
    public boolean configContainKey(String str, String str2) {
        if ("strings".equals(str)) {
            return this.mStringsManager.containsKey(str2);
        }
        if ("drawable".equals(str)) {
            str = "image";
        }
        Map<String, String> map = this.mAllResources.get(str);
        if (map == null || map.isEmpty()) {
            return false;
        }
        return map.containsKey(str2);
    }
}
