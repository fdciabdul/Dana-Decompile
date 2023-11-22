package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private final Context b;
    private final String c;
    private String d;
    private String e;
    private volatile IAIDLInvoke f;
    private String g;
    private WeakReference<Activity> h;
    private WeakReference<Activity> i;
    private List<Scope> l;
    private List<PermissionInfo> m;
    private Map<Api<?>, Api.ApiOptions> n;

    /* renamed from: o */
    private SubAppInfo f7459o;
    private final ReentrantLock s;
    private final Condition t;
    private ConnectionResult u;
    private HuaweiApiClient.ConnectionCallbacks v;
    private HuaweiApiClient.OnConnectionFailedListener w;
    private Handler x;
    private Handler y;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {18, 119, 36, -59, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 176;
    private static final Object z = new Object();
    private static final Object A = new Object();

    /* renamed from: a */
    private int f7458a = -1;
    private boolean j = false;
    private AtomicInteger k = new AtomicInteger(1);
    private long p = 0;
    private int q = 0;
    private final Object r = new Object();

    /* loaded from: classes7.dex */
    public class a implements Handler.Callback {
        a() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.k.get() == 5) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Handler.Callback {
        b() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.k.get() == 2) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* loaded from: classes7.dex */
        class a implements Runnable {
            final /* synthetic */ ResolveResult BuiltInFictitiousFunctionClassFactory;

            a(ResolveResult resolveResult) {
                e.this = r1;
                this.BuiltInFictitiousFunctionClassFactory = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.a(this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        private e() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public /* synthetic */ void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, byte b) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* loaded from: classes7.dex */
        class a implements Runnable {
            final /* synthetic */ ResolveResult KClassImpl$Data$declaredNonStaticMembers$2;

            a(ResolveResult resolveResult) {
                f.this = r1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.b(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        private f() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public /* synthetic */ void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, byte b) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private g() {
            HuaweiApiClientImpl.this = r1;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public /* synthetic */ void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            ResolveResult<JosGetNoticeResp> resolveResult2 = resolveResult;
            if (resolveResult2 == null || !resolveResult2.getStatus().isSuccess() || (noticeIntent = (value = resolveResult2.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
            Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.h.get(), HuaweiApiClientImpl.this.getTopActivity());
            if (validActivity != null) {
                HuaweiApiClientImpl.this.j = true;
                validActivity.startActivity(noticeIntent);
                return;
            }
            HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
        }

        /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, byte b) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.s = reentrantLock;
        this.t = reentrantLock.newCondition();
        this.x = null;
        this.y = null;
        this.b = context;
        String appId = Util.getAppId(context);
        this.c = appId;
        this.d = appId;
        this.e = Util.getCpId(context);
    }

    private static void B(byte b2, byte b3, byte b4, Object[] objArr) {
        int i = 16 - (b4 * 12);
        int i2 = 106 - (b3 * 7);
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = (b2 * 3) + 13;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i++;
            i2 = i5 + i2 + 2;
            i5 = i5;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i2;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i2;
            int i7 = i5;
            i++;
            i2 = i6 + bArr[i] + 2;
            i5 = i7;
        }
    }

    private DisconnectInfo d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return new DisconnectInfo(this.l, arrayList);
    }

    private int e() {
        int hmsVersion = Util.getHmsVersion(this.b);
        if (hmsVersion == 0 || hmsVersion < 20503000) {
            int f2 = f();
            if (g()) {
                if (f2 < 20503000) {
                    return 20503000;
                }
                return f2;
            } else if (f2 < 20600000) {
                return 20600000;
            } else {
                return f2;
            }
        }
        return hmsVersion;
    }

    private int f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i = 0;
        if (apiMap == null) {
            return 0;
        }
        Iterator<Api<?>> it = apiMap.keySet().iterator();
        while (it.hasNext()) {
            String apiName = it.next().getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i) {
                i = intValue;
            }
        }
        return i;
    }

    private boolean g() {
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(it.next().getApiName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void h() {
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.x = new Handler(Looper.getMainLooper(), new a());
        }
        this.x.sendEmptyMessageDelayed(2, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
    }

    private void i() {
        synchronized (A) {
            Handler handler = this.y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.y = new Handler(Looper.getMainLooper(), new b());
            }
            boolean sendEmptyMessageDelayed = this.y.sendEmptyMessageDelayed(3, 3000L);
            StringBuilder sb = new StringBuilder();
            sb.append("sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : ");
            sb.append(sendEmptyMessageDelayed);
            HMSLog.d("HuaweiApiClientImpl", sb.toString());
        }
    }

    private void j() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, c()).setResultCallback(new e(this, (byte) 0));
    }

    private void k() {
        ConnectService.disconnect(this, d()).setResultCallback(new f(this, (byte) 0));
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, c()).setResultCallback(new e(this, (byte) 0));
    }

    private void m() {
        if (this.j) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.b) == 0) {
            ConnectService.getNotice(this, 0, "6.5.0.300").setResultCallback(new g(this, (byte) 0));
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.b, this);
        this.f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i, ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback != null && str != null && bundle != null) {
            if (!innerIsConnected()) {
                HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
                return CommonCode.ErrorCode.CLIENT_API_INVALID;
            }
            DataBuffer dataBuffer = new DataBuffer(str, i);
            MessageCodec authRequestContext = CodecLookup.getAuthRequestContext(dataBuffer.PlaceComponentResult);
            dataBuffer.MyBillsEntityDataFactory = bundle;
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), getSessionId());
            requestHeader.getAuthRequestContext = getApiNameList();
            dataBuffer.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.PlaceComponentResult(requestHeader, new Bundle());
            try {
                getService().asyncCall(dataBuffer, new c(this, resultCallback));
                return 0;
            } catch (RemoteException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("remote exception:");
                sb.append(e2.getMessage());
                HMSLog.e("HuaweiApiClientImpl", sb.toString());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
        return CommonCode.ErrorCode.ARGUMENTS_INVALID;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        } else {
            checkUpdatelistener.onResult(-1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
        int i = this.k.get();
        StringBuilder sb = new StringBuilder();
        sb.append("Enter connect, Connection Status: ");
        sb.append(i);
        HMSLog.i("HuaweiApiClientImpl", sb.toString());
        if (i == 3 || i == 5 || i == 2 || i == 4) {
            return;
        }
        if (activity != null) {
            this.h = new WeakReference<>(activity);
            this.i = new WeakReference<>(activity);
        }
        this.d = TextUtils.isEmpty(this.c) ? Util.getAppId(this.b) : this.c;
        int e2 = e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect minVersion:");
        sb2.append(e2);
        HMSLog.i("HuaweiApiClientImpl", sb2.toString());
        HuaweiApiAvailability.setServicesVersionCode(e2);
        int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, e2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("In connect, isHuaweiMobileServicesAvailable result: ");
        sb3.append(isHuaweiMobileServicesAvailable);
        HMSLog.i("HuaweiApiClientImpl", sb3.toString());
        this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        if (isHuaweiMobileServicesAvailable == 0) {
            c(5);
            if (this.f == null) {
                a();
                return;
            }
            c(2);
            j();
            i();
        } else if (this.w != null) {
            b(isHuaweiMobileServicesAvailable);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
        int i = this.k.get();
        StringBuilder sb = new StringBuilder();
        sb.append("Enter forceConnect, Connection Status: ");
        sb.append(i);
        HMSLog.i("HuaweiApiClientImpl", sb.toString());
        if (i == 3 || i == 5 || i == 2 || i == 4) {
            return;
        }
        this.d = TextUtils.isEmpty(this.c) ? Util.getAppId(this.b) : this.c;
        l();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.f7458a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f7458a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new d(this);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i = this.k.get();
        StringBuilder sb = new StringBuilder();
        sb.append("Enter disconnect, Connection Status: ");
        sb.append(i);
        HMSLog.i("HuaweiApiClientImpl", sb.toString());
        if (i != 2) {
            if (i == 3) {
                c(4);
                k();
                return;
            } else if (i != 5) {
                return;
            } else {
                a(2);
            }
        }
        c(4);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.u;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.f7459o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            return this.w == onConnectionFailedListener;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            return this.v == connectionCallbacks;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.s.lock();
            try {
                connect((Activity) null);
                while (isConnecting()) {
                    try {
                        try {
                            this.t.await();
                        } catch (InterruptedException unused) {
                            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                            byte b3 = (byte) (b2 - 1);
                            Object[] objArr = new Object[1];
                            B(b2, b3, b3, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
                            byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                            Object[] objArr2 = new Object[1];
                            B(b4, b5, b5, objArr2);
                            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                            ConnectionResult connectionResult = new ConnectionResult(15, (PendingIntent) null);
                            this.s.unlock();
                            return connectionResult;
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                if (isConnected()) {
                    this.u = null;
                    ConnectionResult connectionResult2 = new ConnectionResult(0, (PendingIntent) null);
                    this.s.unlock();
                    return connectionResult2;
                }
                ConnectionResult connectionResult3 = this.u;
                if (connectionResult3 != null) {
                    this.s.unlock();
                    return connectionResult3;
                }
                ConnectionResult connectionResult4 = new ConnectionResult(13, (PendingIntent) null);
                this.s.unlock();
                return connectionResult4;
            } catch (Throwable th2) {
                this.s.unlock();
                throw th2;
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.k.get() == 3 || this.k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.q == 0) {
            this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
        }
        if (this.q < 20504000) {
            long currentTimeMillis = System.currentTimeMillis() - this.p;
            if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
                return innerIsConnected();
            }
            if (innerIsConnected()) {
                Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS).getStatus();
                if (status.isSuccess()) {
                    this.p = System.currentTimeMillis();
                    return true;
                }
                int statusCode = status.getStatusCode();
                StringBuilder sb = new StringBuilder();
                sb.append("isConnected is false, statuscode:");
                sb.append(statusCode);
                HMSLog.i("HuaweiApiClientImpl", sb.toString());
                if (statusCode != 907135004) {
                    n();
                    c(1);
                    this.p = System.currentTimeMillis();
                    return false;
                }
                return false;
            }
            return false;
        }
        return innerIsConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i = this.k.get();
        return i == 2 || i == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.w != null) {
                WeakReference<Activity> weakReference = this.h;
                PendingIntent pendingIntent = null;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.w.onConnectionFailed(connectionResult);
                this.u = connectionResult;
            }
        } else if (this.k.get() == 5) {
            c(2);
            j();
            i();
        } else if (this.k.get() != 3) {
            n();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.r) {
            if (this.w != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.r) {
            if (this.v != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.v = null;
            }
        }
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.n = map;
    }

    public void setAutoLifecycleClientId(int i) {
        this.f7458a = i;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z2) {
        this.j = z2;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.m = list;
    }

    public void setScopes(List<Scope> list) {
        this.l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.c) ? Util.getAppId(this.b) : this.c)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f7459o = new SubAppInfo(subAppInfo);
        return true;
    }

    public void c(int i) {
        this.k.set(i);
        if (i == 1 || i == 3 || i == 2) {
            this.s.lock();
            try {
                this.t.signalAll();
            } finally {
                this.s.unlock();
            }
        }
    }

    private void b(int i) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i);
            StringBuilder sb = new StringBuilder();
            sb.append("connect 2.0 fail: ");
            sb.append(i);
            HMSLog.i("HuaweiApiClientImpl", sb.toString());
        }
        ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
        this.w.onConnectionFailed(connectionResult);
        this.u = connectionResult;
    }

    private void a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.b).getServiceAction());
        HMSPackageManager.getInstance(this.b).refreshForMultiService();
        intent.setPackage(HMSPackageManager.getInstance(this.b).getHMSPackageNameForMultiService());
        synchronized (z) {
            if (this.b.bindService(intent, this, 1)) {
                h();
                return;
            }
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private ConnectInfo c() {
        String packageSignature = new PackageManagerHelper(this.b).getPackageSignature(this.b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f7459o;
        return new ConnectInfo(getApiNameList(), this.l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    public void b() {
        n();
        if (this.w != null) {
            int i = UIUtil.isBackground(this.b) ? 7 : 6;
            WeakReference<Activity> weakReference = this.h;
            PendingIntent pendingIntent = null;
            if (weakReference != null && weakReference.get() != null) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i);
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.h != null) {
            m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.h);
                }
            }
        }
    }

    private void a(int i) {
        if (i == 2) {
            synchronized (z) {
                Handler handler = this.x;
                if (handler != null) {
                    handler.removeMessages(i);
                    this.x = null;
                }
            }
        }
        if (i == 3) {
            synchronized (A) {
                Handler handler2 = this.y;
                if (handler2 != null) {
                    handler2.removeMessages(i);
                    this.y = null;
                }
            }
        }
        synchronized (z) {
            Handler handler3 = this.x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.x = null;
            }
        }
    }

    public void b(ResolveResult<DisconnectResp> resolveResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("Enter onDisconnectionResult, disconnect from server result: ");
        sb.append(resolveResult.getStatus().getStatusCode());
        HMSLog.i("HuaweiApiClientImpl", sb.toString());
        n();
        c(1);
    }

    public void a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f != null && this.k.get() == 2) {
            a(3);
            ConnectResp value = resolveResult.getValue();
            if (value != null) {
                this.g = value.sessionId;
            }
            SubAppInfo subAppInfo = this.f7459o;
            PendingIntent pendingIntent = null;
            String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
            if (!TextUtils.isEmpty(subAppID)) {
                this.d = subAppID;
            }
            int statusCode = resolveResult.getStatus().getStatusCode();
            StringBuilder sb = new StringBuilder();
            sb.append("Enter onConnectionResult, connect to server result: ");
            sb.append(statusCode);
            HMSLog.i("HuaweiApiClientImpl", sb.toString());
            if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                c(resolveResult);
                return;
            } else if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                n();
                c(1);
                HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
                if (connectionCallbacks != null) {
                    connectionCallbacks.onConnectionSuspended(3);
                    return;
                }
                return;
            } else {
                n();
                c(1);
                if (this.w != null) {
                    WeakReference<Activity> weakReference = this.h;
                    if (weakReference != null && weakReference.get() != null) {
                        pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), statusCode);
                    }
                    ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                    this.w.onConnectionFailed(connectionResult);
                    this.u = connectionResult;
                    return;
                }
                return;
            }
        }
        HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i) {
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        ConnectionResult connectionResult = new ConnectionResult(14, (PendingIntent) null);
                        this.s.unlock();
                        return connectionResult;
                    }
                    try {
                        try {
                            nanos = this.t.awaitNanos(nanos);
                        } catch (InterruptedException unused) {
                            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                            byte b3 = (byte) (b2 - 1);
                            Object[] objArr = new Object[1];
                            B(b2, b3, b3, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
                            byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                            Object[] objArr2 = new Object[1];
                            B(b4, b5, b5, objArr2);
                            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                            ConnectionResult connectionResult2 = new ConnectionResult(15, (PendingIntent) null);
                            this.s.unlock();
                            return connectionResult2;
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                if (isConnected()) {
                    this.u = null;
                    ConnectionResult connectionResult3 = new ConnectionResult(0, (PendingIntent) null);
                    this.s.unlock();
                    return connectionResult3;
                }
                ConnectionResult connectionResult4 = this.u;
                if (connectionResult4 != null) {
                    this.s.unlock();
                    return connectionResult4;
                }
                ConnectionResult connectionResult5 = new ConnectionResult(13, (PendingIntent) null);
                this.s.unlock();
                return connectionResult5;
            } catch (Throwable th2) {
                this.s.unlock();
                throw th2;
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    /* loaded from: classes7.dex */
    class c extends IAIDLCallback.Stub {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f7460a;

        c(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
            this.f7460a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            if (dataBuffer != null) {
                MessageCodec authRequestContext = CodecLookup.getAuthRequestContext(dataBuffer.PlaceComponentResult);
                ResponseHeader responseHeader = new ResponseHeader();
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(dataBuffer.KClassImpl$Data$declaredNonStaticMembers$2, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getAuthRequestContext(), dataBuffer.MyBillsEntityDataFactory);
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.f7460a.onResult(bundleResult);
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.f7460a.onResult(new BundleResult(-1, null));
        }
    }

    /* loaded from: classes7.dex */
    static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient) {
            super(apiClient, null, null);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* synthetic */ Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }
}
