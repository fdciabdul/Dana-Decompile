package id.dana.data.foundation.toolbox;

import com.alipay.iap.android.common.log.MonitorWrapper;
import id.dana.domain.foundation.logger.PerformanceConstant;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class HttpEventMonitorListener extends EventListener {
    public static final EventListener.Factory KClassImpl$Data$declaredNonStaticMembers$2 = new EventListener.Factory() { // from class: id.dana.data.foundation.toolbox.HttpEventMonitorListener$$ExternalSyntheticLambda0
        @Override // okhttp3.EventListener.Factory
        public final EventListener create(Call call) {
            return HttpEventMonitorListener.BuiltInFictitiousFunctionClassFactory();
        }
    };
    private static final String PlaceComponentResult = HttpEventMonitorListener.class.getName();
    private long BuiltInFictitiousFunctionClassFactory;
    private long DatabaseTableConfigUtil;
    private long GetContactSyncConfig;
    private final long MyBillsEntityDataFactory = System.currentTimeMillis();
    private long NetworkUserEntityData$$ExternalSyntheticLambda0;
    private long NetworkUserEntityData$$ExternalSyntheticLambda1;
    private long NetworkUserEntityData$$ExternalSyntheticLambda2;
    private long NetworkUserEntityData$$ExternalSyntheticLambda7;
    private long NetworkUserEntityData$$ExternalSyntheticLambda8;
    private long PrepareContext;
    private long getAuthRequestContext;
    private long getErrorConfigVersion;
    private long initRecordTimeStamp;
    private long isLayoutRequested;
    private long lookAheadTest;
    private long moveToNextValue;
    private long newProxyInstance;
    private long scheduleImpl;

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ EventListener BuiltInFictitiousFunctionClassFactory() {
        return new HttpEventMonitorListener();
    }

    private HttpEventMonitorListener() {
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        this.getErrorConfigVersion = System.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = System.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        this.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.getAuthRequestContext = System.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = System.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 > 0) {
            this.initRecordTimeStamp = System.currentTimeMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        long currentTimeMillis = System.currentTimeMillis();
        this.PrepareContext = currentTimeMillis - this.getAuthRequestContext;
        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (j > 0) {
            this.isLayoutRequested = currentTimeMillis - j;
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = System.currentTimeMillis();
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        long currentTimeMillis = System.currentTimeMillis();
        this.moveToNextValue = currentTimeMillis;
        this.lookAheadTest = currentTimeMillis - this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        this.moveToNextValue = currentTimeMillis;
        this.lookAheadTest = currentTimeMillis - this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        long currentTimeMillis = System.currentTimeMillis();
        if (response.receivedResponseAtMillis() > this.moveToNextValue) {
            this.DatabaseTableConfigUtil = response.receivedResponseAtMillis();
        } else {
            this.DatabaseTableConfigUtil = currentTimeMillis;
        }
        this.newProxyInstance = response.receivedResponseAtMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = currentTimeMillis;
        this.GetContactSyncConfig = currentTimeMillis - this.DatabaseTableConfigUtil;
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = currentTimeMillis;
        this.GetContactSyncConfig = currentTimeMillis - this.DatabaseTableConfigUtil;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        getAuthRequestContext(call);
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        getAuthRequestContext(call);
    }

    private void getAuthRequestContext(Call call) {
        long currentTimeMillis = System.currentTimeMillis();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = currentTimeMillis - this.MyBillsEntityDataFactory;
        this.scheduleImpl = currentTimeMillis - this.getErrorConfigVersion;
        String obj = call.request().url().url().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("url", obj);
        hashMap.put("costTime", String.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
        hashMap.put("realCall", String.valueOf(this.scheduleImpl));
        hashMap.put("dns", String.valueOf(this.BuiltInFictitiousFunctionClassFactory));
        hashMap.put("tls", String.valueOf(this.initRecordTimeStamp));
        hashMap.put("tcp", String.valueOf(this.PrepareContext));
        hashMap.put("request", String.valueOf(this.lookAheadTest));
        hashMap.put("download", String.valueOf(this.GetContactSyncConfig));
        hashMap.put("ttfb", String.valueOf(this.newProxyInstance));
        hashMap.put("ssl", String.valueOf(this.isLayoutRequested));
        hashMap.put("requestStartTime", String.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        hashMap.put("requestEndTime", String.valueOf(this.moveToNextValue));
        hashMap.put("responseStartTime", String.valueOf(this.DatabaseTableConfigUtil));
        hashMap.put("responseEndTime", String.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
        hashMap.put("skywalkerRequestType", PerformanceConstant.PERFORMANCE_REQUEST_TYPE_APHOME);
        MonitorWrapper.performance("performance", "network", hashMap);
        DanaLog.MyBillsEntityDataFactory(PlaceComponentResult, hashMap.toString());
    }
}
