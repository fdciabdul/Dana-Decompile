package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class HMSBIInitializer {
    public static final Object d = new Object();
    public static HMSBIInitializer e;
    public static HiAnalyticsInstance f;

    /* renamed from: a  reason: collision with root package name */
    public final Context f7511a;
    public AtomicBoolean b = new AtomicBoolean(false);
    public boolean c = c.a();

    /* loaded from: classes8.dex */
    public class a implements IQueryUrlCallBack {
        public a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("get grs failed, the errorcode is ");
            sb.append(i);
            HMSLog.e("HMSBIInitializer", sb.toString());
            HMSBIInitializer.this.b.set(false);
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.c) {
                    HmsHiAnalyticsUtils.BuiltInFictitiousFunctionClassFactory(HMSBIInitializer.this.f7511a, str, "com.huawei.hwid");
                } else {
                    HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
                    HiAnalyticsInstance unused = HMSBIInitializer.f = new HiAnalyticsInstance.Builder(HMSBIInitializer.this.f7511a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
                    HMSBIInitializer.f.setAppid("com.huawei.hwid");
                }
                HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.b.set(false);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AsyncTask<String, Integer, Void> {
        public b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.a(strArr[0]);
            return null;
        }

        public /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this();
        }
    }

    public HMSBIInitializer(Context context) {
        this.f7511a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (d) {
            if (e == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    e = new HMSBIInitializer(applicationContext);
                } else {
                    e = new HMSBIInitializer(context);
                }
            }
        }
        return e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f;
    }

    public void initBI() {
        boolean initFlag;
        if (!this.c) {
            initFlag = HmsHiAnalyticsUtils.MyBillsEntityDataFactory();
        } else {
            initFlag = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Builder->biInitFlag :");
        sb.append(initFlag);
        HMSLog.i("HMSBIInitializer", sb.toString());
        if (initFlag || com.huawei.hms.stats.a.c(this.f7511a) || !this.b.compareAndSet(false, true)) {
            return;
        }
        String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f7511a);
        if (!TextUtils.isEmpty(issueCountryCode)) {
            issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
        }
        if (!"UNKNOWN".equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
            new b(this, null).execute(issueCountryCode);
            return;
        }
        HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
        this.b.set(false);
    }

    public boolean isInit() {
        if (!this.c) {
            return HmsHiAnalyticsUtils.MyBillsEntityDataFactory();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public final void a(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f7511a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a());
    }
}
