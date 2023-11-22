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
import androidx.core.content.ContextCompat;
import androidx.view.LiveData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.util.OSUtil;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor$networkCallback$2;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0002\u000b\u0011\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0003J\b\u0010\u001b\u001a\u00020\u0016H\u0003J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0003J\u0014\u0010\u001e\u001a\u00020\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006!"}, d2 = {"Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "Landroidx/lifecycle/LiveData;", "Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "networkCallback", "id/dana/core/ui/util/connectivity/ConnectivityMonitor$networkCallback$2$1", "getNetworkCallback", "()Lid/dana/core/ui/util/connectivity/ConnectivityMonitor$networkCallback$2$1;", "networkCallback$delegate", "Lkotlin/Lazy;", "networkReceiver", "id/dana/core/ui/util/connectivity/ConnectivityMonitor$networkReceiver$1", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor$networkReceiver$1;", "getActiveNetwork", "Landroid/net/NetworkCapabilities;", "onActive", "", "onInactive", DanaLogConstants.BizType.REGISTER, "registerBroadcastReceiver", "registerNetworkCallbackForLollipop", "registerNetworkCallbackForNougat", "unregister", "unregisterNetworkCallback", "updateConnection", "networkCapabilities", "Companion", "core-ui_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectivityMonitor extends LiveData<ConnectivityModel> {
    public static final Companion PlaceComponentResult = new Companion(null);
    private final ConnectivityMonitor$networkReceiver$1 NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy lookAheadTest;
    private final Context scheduleImpl;

    /* JADX WARN: Type inference failed for: r2v4, types: [id.dana.core.ui.util.connectivity.ConnectivityMonitor$networkReceiver$1] */
    public ConnectivityMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.scheduleImpl = context;
        this.lookAheadTest = LazyKt.lazy(new Function0<ConnectivityMonitor$networkCallback$2.AnonymousClass1>() { // from class: id.dana.core.ui.util.connectivity.ConnectivityMonitor$networkCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.core.ui.util.connectivity.ConnectivityMonitor$networkCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ConnectivityMonitor connectivityMonitor = ConnectivityMonitor.this;
                return new ConnectivityManager.NetworkCallback() { // from class: id.dana.core.ui.util.connectivity.ConnectivityMonitor$networkCallback$2.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onAvailable(Network p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        ConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory((ConnectivityMonitor) new ConnectivityModel.ConnectionStatus(true));
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onLost(Network p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        ConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory((ConnectivityMonitor) new ConnectivityModel.ConnectionStatus(false));
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onCapabilitiesChanged(Network p0, NetworkCapabilities p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        ConnectivityMonitor.this.KClassImpl$Data$declaredNonStaticMembers$2(p1);
                    }
                };
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new BroadcastReceiver() { // from class: id.dana.core.ui.util.connectivity.ConnectivityMonitor$networkReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "");
                Intrinsics.checkNotNullParameter(intent, "");
                ConnectivityMonitor.this.KClassImpl$Data$declaredNonStaticMembers$2((NetworkCapabilities) null);
            }
        };
    }

    @Override // androidx.view.LiveData
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        KClassImpl$Data$declaredNonStaticMembers$2((NetworkCapabilities) null);
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.lookAheadTest()) {
            OSUtil oSUtil2 = OSUtil.INSTANCE;
            if (OSUtil.MyBillsEntityDataFactory()) {
                NetworkRequest.Builder addCapability = new NetworkRequest.Builder().addCapability(12);
                if (Build.VERSION.SDK_INT >= 23) {
                    addCapability.addCapability(16);
                }
                NetworkRequest build = addCapability.addTransportType(0).addTransportType(1).build();
                Object systemService = this.scheduleImpl.getSystemService("connectivity");
                if (systemService != null) {
                    ((ConnectivityManager) systemService).registerNetworkCallback(build, (ConnectivityMonitor$networkCallback$2.AnonymousClass1) this.lookAheadTest.getValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ContextCompat.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, new IntentFilter("connectivity.ACTION_CONNECTIVITY"), 4);
            return;
        }
        Object systemService2 = this.scheduleImpl.getSystemService("connectivity");
        if (systemService2 != null) {
            ((ConnectivityManager) systemService2).registerDefaultNetworkCallback((ConnectivityMonitor$networkCallback$2.AnonymousClass1) this.lookAheadTest.getValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @Override // androidx.view.LiveData
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.MyBillsEntityDataFactory()) {
            this.scheduleImpl.unregisterReceiver(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            return;
        }
        Object systemService = this.scheduleImpl.getSystemService("connectivity");
        if (systemService != null) {
            ((ConnectivityManager) systemService).unregisterNetworkCallback((ConnectivityMonitor$networkCallback$2.AnonymousClass1) this.lookAheadTest.getValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            networkCapabilities = KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (Build.VERSION.SDK_INT < 21) {
            Object systemService = this.scheduleImpl.getSystemService("connectivity");
            if (systemService != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    BuiltInFictitiousFunctionClassFactory((ConnectivityMonitor) new ConnectivityModel.ConnectionStatus(activeNetworkInfo.isConnected()));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        } else if (networkCapabilities != null) {
            if (!networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) {
                BuiltInFictitiousFunctionClassFactory((ConnectivityMonitor) new ConnectivityModel.ConnectionStatus(false));
            } else {
                BuiltInFictitiousFunctionClassFactory((ConnectivityMonitor) new ConnectivityModel.ConnectionStatus(true));
            }
        } else {
            Object systemService2 = this.scheduleImpl.getSystemService("connectivity");
            if (systemService2 != null) {
                NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) systemService2).getActiveNetworkInfo();
                if (activeNetworkInfo2 != null) {
                    BuiltInFictitiousFunctionClassFactory((ConnectivityMonitor) new ConnectivityModel.ConnectionStatus(activeNetworkInfo2.isConnected()));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    private final NetworkCapabilities KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        Object systemService = this.scheduleImpl.getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Object systemService2 = this.scheduleImpl.getSystemService("connectivity");
        if (systemService2 != null) {
            return connectivityManager.getNetworkCapabilities(((ConnectivityManager) systemService2).getActiveNetwork());
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/core/ui/util/connectivity/ConnectivityMonitor$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
