package id.dana.core.ui.util.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import androidx.view.LiveData;
import com.alibaba.griver.base.common.utils.NetworkUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.util.OSUtil;
import id.dana.core.ui.util.PermissionHelper;
import id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor$networkCallback$2;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e*\u0002\u000b\u0011\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0014\u0010\u001a\u001a\u00020\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016H\u0002J\u000f\u0010!\u001a\u0004\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0014H\u0014J\b\u0010$\u001a\u00020\u0014H\u0014J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0014H\u0003J\b\u0010(\u001a\u00020\u0014H\u0003J\b\u0010)\u001a\u00020\u0014H\u0002J\b\u0010*\u001a\u00020\u0014H\u0003R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006-"}, d2 = {"Lid/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor;", "Landroidx/lifecycle/LiveData;", "Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "networkCallback", "id/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor$networkCallback$2$1", "getNetworkCallback", "()Lid/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor$networkCallback$2$1;", "networkCallback$delegate", "Lkotlin/Lazy;", "networkReceiver", "id/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor$networkReceiver$1", "Lid/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor$networkReceiver$1;", "checkCellularNetworkStrength", "", "subType", "", "checkWifiNetworkStrength", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "determineSlowOrFastConnection", "networkInfo", "Landroid/net/NetworkInfo;", "getActiveNetwork", "getCellularNetwork", "", "type", "getNetworkType", "()Ljava/lang/Integer;", "onActive", "onInactive", DanaLogConstants.BizType.REGISTER, "registerBroadcastReceiver", "registerNetworkCallbackForLollipop", "registerNetworkCallbackForNougat", "unregister", "unregisterNetworkCallback", "Companion", "UnknownCellularNetworkException", "core-ui_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectivityWithSignalMonitor extends LiveData<ConnectivityModel> {
    public static final Companion PlaceComponentResult = new Companion(null);
    private final Context NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConnectivityWithSignalMonitor$networkReceiver$1 lookAheadTest;
    private final Lazy scheduleImpl;

    /* JADX WARN: Type inference failed for: r2v4, types: [id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor$networkReceiver$1] */
    public ConnectivityWithSignalMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = context;
        this.scheduleImpl = LazyKt.lazy(new Function0<ConnectivityWithSignalMonitor$networkCallback$2.AnonymousClass1>() { // from class: id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor$networkCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor$networkCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ConnectivityWithSignalMonitor connectivityWithSignalMonitor = ConnectivityWithSignalMonitor.this;
                return new ConnectivityManager.NetworkCallback() { // from class: id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor$networkCallback$2.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onLost(Network p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        ConnectivityWithSignalMonitor.this.BuiltInFictitiousFunctionClassFactory((ConnectivityWithSignalMonitor) new ConnectivityModel.SignalStatus(InternetConnectionStatus.NOT_CONNECTED));
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onCapabilitiesChanged(Network p0, NetworkCapabilities p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        ConnectivityWithSignalMonitor.this.MyBillsEntityDataFactory(p1);
                    }
                };
            }
        });
        this.lookAheadTest = new BroadcastReceiver() { // from class: id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor$networkReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "");
                Intrinsics.checkNotNullParameter(intent, "");
                ConnectivityWithSignalMonitor.this.MyBillsEntityDataFactory((NetworkCapabilities) null);
            }
        };
    }

    @Override // androidx.view.LiveData
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory((NetworkCapabilities) null);
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.lookAheadTest()) {
            OSUtil oSUtil2 = OSUtil.INSTANCE;
            if (OSUtil.MyBillsEntityDataFactory()) {
                NetworkRequest.Builder addCapability = new NetworkRequest.Builder().addCapability(12);
                if (Build.VERSION.SDK_INT >= 23) {
                    addCapability.addCapability(16);
                }
                NetworkRequest build = addCapability.addTransportType(0).addTransportType(1).build();
                Object systemService = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
                if (systemService != null) {
                    ((ConnectivityManager) systemService).registerNetworkCallback(build, (ConnectivityWithSignalMonitor$networkCallback$2.AnonymousClass1) this.scheduleImpl.getValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ContextCompat.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, new IntentFilter("connectivity.ACTION_CONNECTIVITY"), 4);
            return;
        }
        Object systemService2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
        if (systemService2 != null) {
            ((ConnectivityManager) systemService2).registerDefaultNetworkCallback((ConnectivityWithSignalMonitor$networkCallback$2.AnonymousClass1) this.scheduleImpl.getValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @Override // androidx.view.LiveData
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.MyBillsEntityDataFactory()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.unregisterReceiver(this.lookAheadTest);
            return;
        }
        Object systemService = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
        if (systemService != null) {
            ((ConnectivityManager) systemService).unregisterNetworkCallback((ConnectivityWithSignalMonitor$networkCallback$2.AnonymousClass1) this.scheduleImpl.getValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(NetworkCapabilities networkCapabilities, NetworkInfo networkInfo) {
        if (!networkInfo.isConnected()) {
            BuiltInFictitiousFunctionClassFactory((ConnectivityWithSignalMonitor) new ConnectivityModel.SignalStatus(InternetConnectionStatus.NOT_CONNECTED));
        } else if (networkInfo.getType() == 1) {
            BuiltInFictitiousFunctionClassFactory(networkCapabilities);
        } else if (networkInfo.getType() == 0) {
            Object systemService = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    MyBillsEntityDataFactory(activeNetworkInfo.getSubtype());
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    private final Integer KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (PermissionHelper.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, "android.permission.READ_PHONE_STATE")) {
                Object systemService = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("phone");
                TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
                if (telephonyManager != null) {
                    return Integer.valueOf(telephonyManager.getDataNetworkType());
                }
                return null;
            }
            return null;
        }
        Object systemService2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
        if (systemService2 != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService2).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return Integer.valueOf(activeNetworkInfo.getSubtype());
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    private final void MyBillsEntityDataFactory(int i) {
        String str;
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                str = "2G";
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                str = "3G";
                break;
            case 13:
            case 18:
            case 19:
                str = "4G";
                break;
            case 20:
                str = NetworkUtils.NETWORK_TYPE_5G;
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        if (Intrinsics.areEqual(str, "2G")) {
            BuiltInFictitiousFunctionClassFactory((ConnectivityWithSignalMonitor) new ConnectivityModel.SignalStatus(InternetConnectionStatus.SLOW_CONNECTION));
        } else {
            BuiltInFictitiousFunctionClassFactory((ConnectivityWithSignalMonitor) new ConnectivityModel.SignalStatus(InternetConnectionStatus.FAST_CONNECTION));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor$UnknownCellularNetworkException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "message", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class UnknownCellularNetworkException extends IllegalStateException {
        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnknownCellularNetworkException() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor.UnknownCellularNetworkException.<init>():void");
        }

        public /* synthetic */ UnknownCellularNetworkException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "CellularNetwork is unknown" : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownCellularNetworkException(String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(android.net.NetworkCapabilities r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L38
            int r5 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r5 >= r1) goto Lb
            r5 = r0
            goto L38
        Lb:
            android.content.Context r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.String r1 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r1)
            java.lang.String r2 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            if (r5 == 0) goto L32
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5
            android.content.Context r3 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.Object r1 = r3.getSystemService(r1)
            if (r1 == 0) goto L2c
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            android.net.Network r1 = r1.getActiveNetwork()
            android.net.NetworkCapabilities r5 = r5.getNetworkCapabilities(r1)
            goto L38
        L2c:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            r5.<init>(r2)
            throw r5
        L32:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            r5.<init>(r2)
            throw r5
        L38:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r1 < r2) goto L54
            if (r5 == 0) goto L45
            android.net.TransportInfo r1 = r5.getTransportInfo()
            goto L46
        L45:
            r1 = r0
        L46:
            if (r1 == 0) goto L54
            android.net.TransportInfo r5 = r5.getTransportInfo()
            boolean r1 = r5 instanceof android.net.wifi.WifiInfo
            if (r1 == 0) goto L68
            r0 = r5
            android.net.wifi.WifiInfo r0 = (android.net.wifi.WifiInfo) r0
            goto L68
        L54:
            android.content.Context r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r0 = "wifi"
            java.lang.Object r5 = r5.getSystemService(r0)
            if (r5 == 0) goto L9b
            android.net.wifi.WifiManager r5 = (android.net.wifi.WifiManager) r5
            android.net.wifi.WifiInfo r0 = r5.getConnectionInfo()
        L68:
            if (r0 == 0) goto L9a
            int r5 = r0.getRssi()
            r1 = -71
            if (r5 > r1) goto L7d
            id.dana.core.ui.util.connectivity.model.ConnectivityModel$SignalStatus r5 = new id.dana.core.ui.util.connectivity.model.ConnectivityModel$SignalStatus
            java.lang.String r0 = "SLOW_CONNECTION"
            r5.<init>(r0)
            r4.BuiltInFictitiousFunctionClassFactory(r5)
            return
        L7d:
            int r5 = r0.getRssi()
            r0 = -90
            if (r5 > r0) goto L90
            id.dana.core.ui.util.connectivity.model.ConnectivityModel$SignalStatus r5 = new id.dana.core.ui.util.connectivity.model.ConnectivityModel$SignalStatus
            java.lang.String r0 = "NOT_CONNECTED"
            r5.<init>(r0)
            r4.BuiltInFictitiousFunctionClassFactory(r5)
            return
        L90:
            id.dana.core.ui.util.connectivity.model.ConnectivityModel$SignalStatus r5 = new id.dana.core.ui.util.connectivity.model.ConnectivityModel$SignalStatus
            java.lang.String r0 = "FAST_CONNECTION"
            r5.<init>(r0)
            r4.BuiltInFictitiousFunctionClassFactory(r5)
        L9a:
            return
        L9b:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.net.wifi.WifiManager"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor.BuiltInFictitiousFunctionClassFactory(android.net.NetworkCapabilities):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            if (Build.VERSION.SDK_INT < 23) {
                networkCapabilities = null;
            } else {
                Object systemService = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                Object systemService2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
                if (systemService2 != null) {
                    networkCapabilities = connectivityManager.getNetworkCapabilities(((ConnectivityManager) systemService2).getActiveNetwork());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
                }
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            Object systemService3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
            if (systemService3 != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService3).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2(networkCapabilities, activeNetworkInfo);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } else if (networkCapabilities != null) {
            if (!networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) {
                BuiltInFictitiousFunctionClassFactory((ConnectivityWithSignalMonitor) new ConnectivityModel.SignalStatus(InternetConnectionStatus.NOT_CONNECTED));
            } else if (networkCapabilities.hasTransport(1)) {
                BuiltInFictitiousFunctionClassFactory(networkCapabilities);
            } else {
                if (networkCapabilities.hasTransport(0)) {
                    Integer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                    MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.intValue() : 0);
                }
            }
        } else {
            Object systemService4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("connectivity");
            if (systemService4 != null) {
                NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) systemService4).getActiveNetworkInfo();
                if (activeNetworkInfo2 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2((NetworkCapabilities) null, activeNetworkInfo2);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }
}
