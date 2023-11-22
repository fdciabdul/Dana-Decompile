package com.ipification.mobile.sdk.android;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.callback.IPNetworkCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import id.dana.cashier.view.InputCardNumberView;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0006\u0010\u001d\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ipification/mobile/sdk/android/NetworkManager;", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "CONNECT_NETWORK_TIMEOUT", "", "isReceiveResponse", "", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mNetwork", "Landroid/net/Network;", "mNetworkCallBack", "Landroid/net/ConnectivityManager$NetworkCallback;", DataflowMonitorModel.METHOD_NAME_CONNECTION, "", "ipNetworkCallback", "Lcom/ipification/mobile/sdk/android/callback/IPNetworkCallback;", "handleUnAvailableCase", "cellularCallback", "requestNetworkV21", "manager", "Landroid/net/ConnectivityManager;", "builder", "Landroid/net/NetworkRequest$Builder;", "requestNetworkV26", "unregister", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkManager {
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();
    public Network BuiltInFictitiousFunctionClassFactory;
    public final long MyBillsEntityDataFactory = RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
    public Context PlaceComponentResult;
    public boolean getAuthRequestContext;
    public ConnectivityManager.NetworkCallback moveToNextValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/ipification/mobile/sdk/android/NetworkManager$Companion;", "Lcom/ipification/mobile/sdk/android/SingletonHolder;", "Lcom/ipification/mobile/sdk/android/NetworkManager;", "Landroid/content/Context;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion extends SingletonHolder<NetworkManager, Context> {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.ipification.mobile.sdk.android.NetworkManager$Companion$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<Context, NetworkManager> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "<init>";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(NetworkManager.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "<init>(Landroid/content/Context;)V";
            }

            @Override // kotlin.jvm.functions.Function1
            public final NetworkManager invoke(Context context) {
                Context context2 = context;
                Intrinsics.checkParameterIsNotNull(context2, "");
                return new NetworkManager(context2);
            }
        }

        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public NetworkManager(Context context) {
        this.PlaceComponentResult = context;
    }

    public final boolean PlaceComponentResult() {
        Context context;
        if (this.moveToNextValue != null && (context = this.PlaceComponentResult) != null) {
            if (context == null) {
                try {
                    Intrinsics.throwNpe();
                } catch (Exception unused) {
                }
            }
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 21) {
                ConnectivityManager.NetworkCallback networkCallback = this.moveToNextValue;
                if (networkCallback == null) {
                    Intrinsics.throwNpe();
                }
                connectivityManager.unregisterNetworkCallback(networkCallback);
                this.BuiltInFictitiousFunctionClassFactory = null;
                this.moveToNextValue = null;
                return true;
            }
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.moveToNextValue = null;
        return false;
    }

    public final void MyBillsEntityDataFactory(final IPNetworkCallback iPNetworkCallback) {
        Intrinsics.checkParameterIsNotNull(iPNetworkCallback, "");
        if (this.PlaceComponentResult == null) {
            CellularException cellularException = new CellularException();
            cellularException.getAuthRequestContext = Integer.valueOf((int) SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR);
            iPNetworkCallback.BuiltInFictitiousFunctionClassFactory(cellularException);
            return;
        }
        Network network = this.BuiltInFictitiousFunctionClassFactory;
        if (network != null) {
            iPNetworkCallback.BuiltInFictitiousFunctionClassFactory(network);
            return;
        }
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new ConnectivityManager.NetworkCallback() { // from class: com.ipification.mobile.sdk.android.NetworkManager$connect$1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public final void onAvailable(Network p0) {
                    Intrinsics.checkParameterIsNotNull(p0, "");
                    super.onAvailable(p0);
                    CellularCallback.DefaultImpls.KClassImpl$Data$declaredNonStaticMembers$2(LogUtils.getAuthRequestContext, "onAvailable");
                    NetworkManager networkManager = NetworkManager.this;
                    networkManager.getAuthRequestContext = true;
                    networkManager.BuiltInFictitiousFunctionClassFactory = p0;
                    iPNetworkCallback.BuiltInFictitiousFunctionClassFactory(p0);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public final void onLost(Network p0) {
                    Intrinsics.checkParameterIsNotNull(p0, "");
                    super.onLost(p0);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public final void onUnavailable() {
                    super.onUnavailable();
                    NetworkManager.this.getAuthRequestContext = true;
                    CellularException cellularException2 = new CellularException();
                    cellularException2.BuiltInFictitiousFunctionClassFactory = "network unavailable";
                    cellularException2.getAuthRequestContext = 888;
                    iPNetworkCallback.BuiltInFictitiousFunctionClassFactory(cellularException2);
                    NetworkManager.this.moveToNextValue = null;
                }
            };
        }
        Context context = this.PlaceComponentResult;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addTransportType(0);
        builder.addCapability(12);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NetworkRequest build = builder.build();
                ConnectivityManager.NetworkCallback networkCallback = this.moveToNextValue;
                if (networkCallback == null) {
                    Intrinsics.throwNpe();
                }
                connectivityManager.requestNetwork(build, networkCallback, (int) this.MyBillsEntityDataFactory);
                return;
            }
            NetworkRequest build2 = builder.build();
            ConnectivityManager.NetworkCallback networkCallback2 = this.moveToNextValue;
            if (networkCallback2 == null) {
                Intrinsics.throwNpe();
            }
            connectivityManager.requestNetwork(build2, networkCallback2);
            new Timer().schedule(new TimerTask() { // from class: com.ipification.mobile.sdk.android.NetworkManager$requestNetworkV21$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    LogUtils.Companion companion = LogUtils.getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("timeout isReceiveResponse=");
                    sb.append(NetworkManager.this.getAuthRequestContext);
                    sb.append(InputCardNumberView.DIVIDER);
                    CellularCallback.DefaultImpls.KClassImpl$Data$declaredNonStaticMembers$2(companion, sb.toString());
                    if (NetworkManager.this.getAuthRequestContext) {
                        return;
                    }
                    IPNetworkCallback iPNetworkCallback2 = iPNetworkCallback;
                    CellularCallback.DefaultImpls.getAuthRequestContext(companion, "onUnavailable: Failed to request network. Timeout error");
                    CellularException cellularException2 = new CellularException();
                    cellularException2.getAuthRequestContext = 1001;
                    cellularException2.MyBillsEntityDataFactory = new NetworkErrorException("Failed to request network. Timeout error");
                    iPNetworkCallback2.BuiltInFictitiousFunctionClassFactory(cellularException2);
                }
            }, this.MyBillsEntityDataFactory);
        } catch (Exception e) {
            CellularException cellularException2 = new CellularException();
            cellularException2.MyBillsEntityDataFactory = e;
            cellularException2.getAuthRequestContext = 800;
            iPNetworkCallback.BuiltInFictitiousFunctionClassFactory(cellularException2);
            this.moveToNextValue = null;
        }
    }
}
