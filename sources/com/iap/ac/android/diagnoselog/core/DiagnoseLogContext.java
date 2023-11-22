package com.iap.ac.android.diagnoselog.core;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.BuildConfig;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.config.IConfigChangeListener;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.diagnoselog.a.a;
import com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage;
import com.iap.ac.android.diagnoselog.storage.DiagnoseStorage;
import com.iap.ac.android.diagnoselog.util.FileUtil;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DiagnoseLogContext implements IConfigChangeListener {
    public static final BlockingQueue<Runnable> i = new LinkedBlockingQueue(128);
    public static DiagnoseLogContext j;

    /* renamed from: a  reason: collision with root package name */
    public DiagnoseStorage f7568a;
    public TraceLoggerImpl b;
    public ThreadPoolExecutor c;
    public Application d;
    public boolean e = false;
    public JSONObject f;
    public String g;
    public String h;

    public DiagnoseLogContext(Application application, String str) {
        this.d = application;
        this.h = str;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, i, new ThreadPoolExecutor.DiscardOldestPolicy());
        this.c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.g = FileUtil.a(application);
        this.f7568a = new DiagnoseFileStorage(application, this.g, this.c);
        this.b = new TraceLoggerImpl();
        a();
        a(application);
        JSONObject sectionConfig = ACConfig.getInstance(str).getSectionConfig("diagnose");
        if (sectionConfig != null) {
            JSONObject optJSONObject = sectionConfig.optJSONObject("command");
            this.f = optJSONObject;
            a(optJSONObject);
        }
    }

    public static DiagnoseLogContext b() {
        DiagnoseLogContext diagnoseLogContext = j;
        if (diagnoseLogContext != null) {
            return diagnoseLogContext;
        }
        throw new IllegalStateException("you should init before get");
    }

    public final void a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.d.getCacheDir());
            sb.append("/diagnoseLogZip");
            File[] listFiles = new File(sb.toString()).listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public String c() {
        return this.g;
    }

    @Override // com.iap.ac.android.common.config.IConfigChangeListener
    public void onConfigChanged(String str, Object obj) {
    }

    @Override // com.iap.ac.android.common.config.IConfigChangeListener
    public void onSectionConfigChanged(String str, JSONObject jSONObject) {
        if (TextUtils.equals(str, "diagnose")) {
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("command") : null;
            this.f = optJSONObject;
            a(optJSONObject);
        }
    }

    public final void a(Context context) {
        RpcAppInfo rpcAppInfo = new RpcAppInfo();
        rpcAppInfo.rpcGateWayUrl = BuildConfig.AMCS_GATEWAY_PROD;
        rpcAppInfo.appId = id.dana.data.BuildConfig.AMCS_LITE_GATEWAY_APP_ID;
        rpcAppInfo.addHeader("workspaceId", "default");
        RpcProxyImpl rpcProxyImpl = RpcProxyImpl.getInstance("diagnoselog_biz");
        rpcProxyImpl.initialize(context, rpcAppInfo);
        RPCProxyHost.setRpcProxy(rpcProxyImpl, "diagnoselog_biz");
        RpcGatewayController.initGatewayController(context, "diagnoselog_biz");
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("receive diagnose command --> ");
            sb.append(jSONObject);
            LoggerWrapper.i("DiagnoseLogContext", sb.toString());
            this.c.execute(new a(this, jSONObject.toString()));
        }
    }
}
