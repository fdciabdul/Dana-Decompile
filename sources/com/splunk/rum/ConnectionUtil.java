package com.splunk.rum;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import com.splunk.rum.NetworkDetector;
import j$.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ConnectionUtil {
    static final CurrentNetwork PlaceComponentResult;
    static final CurrentNetwork getAuthRequestContext;
    private final NetworkDetector BuiltInFictitiousFunctionClassFactory;
    volatile ConnectionStateListener KClassImpl$Data$declaredNonStaticMembers$2;
    volatile CurrentNetwork MyBillsEntityDataFactory = PlaceComponentResult;

    static {
        byte b = 0;
        getAuthRequestContext = new CurrentNetwork(CurrentNetwork.getAuthRequestContext(NetworkState.NO_NETWORK_AVAILABLE), b);
        PlaceComponentResult = new CurrentNetwork(CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_UNKNOWN), b);
    }

    ConnectionUtil(NetworkDetector networkDetector) {
        this.BuiltInFictitiousFunctionClassFactory = networkDetector;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CurrentNetwork KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        } catch (Exception unused) {
            this.MyBillsEntityDataFactory = PlaceComponentResult;
        }
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NetworkRequest getAuthRequestContext() {
        return new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(2).addTransportType(3).addTransportType(4).build();
    }

    final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    /* loaded from: classes3.dex */
    class ConnectionMonitor extends ConnectivityManager.NetworkCallback {
        private ConnectionMonitor() {
        }

        /* synthetic */ ConnectionMonitor(ConnectionUtil connectionUtil, byte b) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            InstrumentInjector.log_d("SplunkRum", "onAvailable: ");
            CurrentNetwork KClassImpl$Data$declaredNonStaticMembers$2 = ConnectionUtil.this.KClassImpl$Data$declaredNonStaticMembers$2();
            ConnectionStateListener connectionStateListener = ConnectionUtil.this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (connectionStateListener != null) {
                connectionStateListener.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                StringBuilder sb = new StringBuilder();
                sb.append("  onAvailable: isConnected:");
                sb.append(ConnectionUtil.this.BuiltInFictitiousFunctionClassFactory());
                sb.append(", activeNetwork: ");
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                InstrumentInjector.log_d("SplunkRum", sb.toString());
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            InstrumentInjector.log_d("SplunkRum", "onLost: ");
            CurrentNetwork currentNetwork = ConnectionUtil.getAuthRequestContext;
            ConnectionUtil.this.MyBillsEntityDataFactory = currentNetwork;
            ConnectionStateListener connectionStateListener = ConnectionUtil.this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (connectionStateListener != null) {
                connectionStateListener.PlaceComponentResult(currentNetwork);
                StringBuilder sb = new StringBuilder();
                sb.append("  onLost: isConnected:false, activeNetwork: ");
                sb.append(currentNetwork);
                InstrumentInjector.log_d("SplunkRum", sb.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Factory {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ConnectionUtil MyBillsEntityDataFactory(Application application) {
            Context applicationContext = application.getApplicationContext();
            ConnectionUtil connectionUtil = new ConnectionUtil(NetworkDetector.CC.PlaceComponentResult(applicationContext));
            Supplier supplier = new Supplier() { // from class: com.splunk.rum.ConnectionUtil$Factory$$ExternalSyntheticLambda0
                @Override // j$.util.function.Supplier
                public final Object get() {
                    return ConnectionUtil.getAuthRequestContext();
                }
            };
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            connectionUtil.KClassImpl$Data$declaredNonStaticMembers$2();
            try {
                byte b = 0;
                if (Build.VERSION.SDK_INT >= 24) {
                    connectivityManager.registerDefaultNetworkCallback(new ConnectionMonitor(connectionUtil, b));
                } else {
                    connectivityManager.registerNetworkCallback((NetworkRequest) supplier.get(), new ConnectionMonitor(connectionUtil, b));
                }
            } catch (Exception e) {
                InstrumentInjector.log_w("SplunkRum", "Failed to register network callbacks. Automatic network monitoring is disabled.", e);
            }
            return connectionUtil;
        }
    }
}
