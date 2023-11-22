package com.alibaba.griver.core.liteprocess;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.alibaba.griver.core.ui.activity.GriverTransActivity;
import com.alibaba.griver.core.update.GriverIpcMessageConstants;
import java.util.Iterator;
import java.util.LinkedList;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class LiteProcessManager {
    public static int LITE_PROCESS_NUM = 1;
    public static final int MAX_LITE_PROCESS_NUM = 3;
    public static final String TAG = "LiteProcessManager";

    /* renamed from: a */
    private static LinkedList<LiteProcess> f6432a = new LinkedList<>();
    private static SparseArray<Class> b = new SparseArray<>();
    private static SparseArray<Class> c = new SparseArray<>();
    private static SparseArray<Class> d = new SparseArray<>();
    private static LiteProcess e = new LiteProcess();

    private LiteProcessManager() {
        a();
    }

    public static final LiteProcessManager getInstance() {
        try {
            return SingletonHolder.f6433a;
        } catch (Throwable unused) {
            LiteProcessManager unused2 = SingletonHolder.f6433a = new LiteProcessManager();
            return SingletonHolder.f6433a;
        }
    }

    public static boolean needSupportLiteProcess() {
        return "YES".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_MP_MULTI_PROCESS_SWITCH));
    }

    public LiteProcess getMainProcess() {
        return e;
    }

    private void a() {
        synchronized (this) {
            e.reset();
            e.setLpid(0);
            if (needSupportLiteProcess()) {
                if (!ProcessUtils.isMainProcess()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LiteProcessServerManager must be in main process. ");
                    sb.append(Log.getStackTraceString(new Throwable()));
                    RVLogger.e(TAG, sb.toString());
                    return;
                }
                try {
                    LITE_PROCESS_NUM = Math.min(Integer.parseInt(GriverConfig.getConfig(GriverConfigConstants.KEY_MP_APP_PROCESS_SIZE)), 3);
                } catch (Exception unused) {
                    LITE_PROCESS_NUM = 1;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("support ");
                sb2.append(LITE_PROCESS_NUM);
                sb2.append(" process to run mini program");
                RVLogger.d(TAG, sb2.toString());
                for (int i = 1; i <= LITE_PROCESS_NUM; i++) {
                    LiteProcess liteProcess = new LiteProcess();
                    liteProcess.reset();
                    liteProcess.setLpid(i);
                    f6432a.add(liteProcess);
                    int i2 = i - 1;
                    b.put(i, IpcMsgClientService.SERVICE_CLASSES[i2]);
                    c.put(i, GriverBaseActivity.ACTIVITY_CLASSES[i2]);
                    d.put(i, GriverTransActivity.ACTIVITY_CLASSES[i2]);
                }
                RVLogger.d(TAG, "LiteProcessServerManager init");
            }
        }
    }

    private Class<? extends Activity> a(int i, boolean z) {
        return (z ? d : c).get(i);
    }

    public Class<? extends Activity> startApp(final RVAppRecord rVAppRecord, Intent intent) {
        LiteProcess findProcessByAppId = findProcessByAppId(rVAppRecord.getAppId());
        if (findProcessByAppId != null && findProcessByAppId.getState() == 1) {
            a(findProcessByAppId.getLpid(), BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false));
        }
        Application applicationContext = GriverEnv.getApplicationContext();
        if (findProcessByAppId != null && findProcessByAppId.getState() == 2) {
            boolean z = BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("isTransparent", z);
            intent.putExtras(rVAppRecord.getStartParams());
            intent.setClass(applicationContext, a(findProcessByAppId.getLpid(), BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false)));
            applicationContext.startActivity(intent);
            a(findProcessByAppId.getLpid(), BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false));
        }
        if (findProcessByAppId == null) {
            findProcessByAppId = findProcessCanStart();
        }
        if (findProcessByAppId == null) {
            RVLogger.d(TAG, "all the process are busy.");
            return null;
        }
        findProcessByAppId.setState(1);
        findProcessByAppId.setAppId(rVAppRecord.getAppId());
        boolean z2 = BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("isTransparent", z2);
        intent.putExtras(rVAppRecord.getStartParams());
        intent.setClass(applicationContext, a(findProcessByAppId.getLpid(), BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false)));
        applicationContext.startActivity(intent);
        Intent intent2 = new Intent();
        intent2.setClass(applicationContext, b.get(findProcessByAppId.getLpid()));
        applicationContext.startService(intent2);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.alibaba.griver.core.liteprocess.LiteProcessManager.1
            {
                LiteProcessManager.this = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                StringBuilder sb = new StringBuilder();
                sb.append("onServiceConnected ");
                sb.append(componentName);
                RVLogger.d(LiteProcessManager.TAG, sb.toString());
                IpcChannelManager.getInstance().registerClientChannel(rVAppRecord.getStartToken(), IIpcChannel.Stub.asInterface(iBinder));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                StringBuilder sb = new StringBuilder();
                sb.append("onServiceDisconnected ");
                sb.append(componentName);
                RVLogger.d(LiteProcessManager.TAG, sb.toString());
                IpcChannelManager.getInstance().unRegisterClientChannel(rVAppRecord.getStartToken());
            }
        };
        findProcessByAppId.setServiceConnection(serviceConnection);
        applicationContext.bindService(intent2, serviceConnection, 0);
        return a(findProcessByAppId.getLpid(), BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false));
    }

    public void closeApp(String str) {
        synchronized (this) {
            if (TextUtils.equals(e.getAppId(), str)) {
                a(e);
            } else {
                a(findProcessByAppId(str));
            }
        }
    }

    public void closeApp(int i) {
        synchronized (this) {
            if (i == e.getLpid()) {
                a(e);
            } else {
                a(findProcessByLpid(i));
            }
        }
    }

    public void closeAllApp() {
        synchronized (this) {
            a(e);
            Iterator<LiteProcess> it = f6432a.iterator();
            while (it.hasNext()) {
                LiteProcess next = it.next();
                if (next.getState() == 0) {
                    RVLogger.d(TAG, "LiteProcessServerManager LiteProcess is already free");
                } else {
                    a(next);
                }
            }
        }
    }

    private void a(LiteProcess liteProcess) {
        synchronized (this) {
            if (liteProcess != null) {
                if (liteProcess.getState() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("closeApp pid == ");
                    sb.append(liteProcess.getPid());
                    sb.append(", appId == ");
                    sb.append(liteProcess.getAppId());
                    sb.append(", state == ");
                    sb.append(liteProcess.getState());
                    RVLogger.d(TAG, sb.toString());
                    Bundle bundle = new Bundle();
                    bundle.putString(RVConstants.EXTRA_PREPARE_ABORT_REASON, "Finish from mStartToken!");
                    IpcServerUtils.sendMsgToClient(liteProcess.getAppId(), liteProcess.getStartToken(), 4, bundle);
                    liteProcess.reset();
                }
            }
        }
    }

    public LiteProcess findProcessCanStart() {
        synchronized (this) {
            Iterator<LiteProcess> it = f6432a.iterator();
            while (it.hasNext()) {
                LiteProcess next = it.next();
                if (next != null && next.getState() == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("findProcessCanStart TERMINATED ");
                    sb.append(next);
                    RVLogger.d(TAG, sb.toString());
                    return next;
                }
            }
            return null;
        }
    }

    public LiteProcess findProcessByLpid(int i) {
        synchronized (this) {
            Iterator<LiteProcess> it = f6432a.iterator();
            while (it.hasNext()) {
                LiteProcess next = it.next();
                if (next.getLpid() == i) {
                    return next;
                }
            }
            return null;
        }
    }

    public LiteProcess findProcessByPid(int i) {
        synchronized (this) {
            Iterator<LiteProcess> it = f6432a.iterator();
            while (it.hasNext()) {
                LiteProcess next = it.next();
                if (next.getPid() == i) {
                    return next;
                }
            }
            return null;
        }
    }

    public LiteProcess findProcessByAppId(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<LiteProcess> it = f6432a.iterator();
            while (it.hasNext()) {
                LiteProcess next = it.next();
                if (str.equals(next.getAppId())) {
                    return next;
                }
            }
            return null;
        }
    }

    public void sendMessage(String str, int i, Bundle bundle) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            LiteProcess findProcessByAppId = getInstance().findProcessByAppId(str);
            if (findProcessByAppId != null) {
                IpcServerUtils.sendMsgToClient(findProcessByAppId.getAppId(), findProcessByAppId.getStartToken(), i, GriverIpcMessageConstants.BIZ_CODE, bundle2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class SingletonHolder {

        /* renamed from: a */
        private static LiteProcessManager f6433a = new LiteProcessManager();

        private SingletonHolder() {
        }
    }
}
