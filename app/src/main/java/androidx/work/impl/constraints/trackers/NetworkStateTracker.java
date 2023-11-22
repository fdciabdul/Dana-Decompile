package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("NetworkStateTracker");
    private final ConnectivityManager NetworkUserEntityData$$ExternalSyntheticLambda0;
    private NetworkStateBroadcastReceiver getAuthRequestContext;
    private NetworkStateCallback lookAheadTest;

    public NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ConnectivityManager) this.MyBillsEntityDataFactory.getSystemService("connectivity");
        if (getAuthRequestContext()) {
            this.lookAheadTest = new NetworkStateCallback();
        } else {
            this.getAuthRequestContext = new NetworkStateBroadcastReceiver();
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void PlaceComponentResult() {
        if (getAuthRequestContext()) {
            try {
                Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, "Registering network callback", new Throwable[0]);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.registerDefaultNetworkCallback(this.lookAheadTest);
                return;
            } catch (IllegalArgumentException | SecurityException e) {
                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "Received exception while registering network callback", e);
                return;
            }
        }
        Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, "Registering broadcast receiver", new Throwable[0]);
        this.MyBillsEntityDataFactory.registerReceiver(this.getAuthRequestContext, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (getAuthRequestContext()) {
            try {
                Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, "Unregistering network callback", new Throwable[0]);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.unregisterNetworkCallback(this.lookAheadTest);
                return;
            } catch (IllegalArgumentException | SecurityException e) {
                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "Received exception while unregistering network callback", e);
                return;
            }
        }
        Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, "Unregistering broadcast receiver", new Throwable[0]);
        this.MyBillsEntityDataFactory.unregisterReceiver(this.getAuthRequestContext);
    }

    private static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final NetworkState MyBillsEntityDataFactory() {
        NetworkInfo activeNetworkInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getActiveNetworkInfo();
        boolean z = false;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean errorConfigVersion = getErrorConfigVersion();
        boolean MyBillsEntityDataFactory = ConnectivityManagerCompat.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z = true;
        }
        return new NetworkState(z2, errorConfigVersion, MyBillsEntityDataFactory, z);
    }

    private boolean getErrorConfigVersion() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNetworkCapabilities(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "Unable to validate active network", e);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        NetworkStateCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Logger.getAuthRequestContext().PlaceComponentResult(NetworkStateTracker.PlaceComponentResult, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.MyBillsEntityDataFactory((NetworkStateTracker) networkStateTracker.MyBillsEntityDataFactory());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Logger.getAuthRequestContext().PlaceComponentResult(NetworkStateTracker.PlaceComponentResult, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.MyBillsEntityDataFactory((NetworkStateTracker) networkStateTracker.MyBillsEntityDataFactory());
        }
    }

    /* loaded from: classes3.dex */
    class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        NetworkStateBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            Logger.getAuthRequestContext().PlaceComponentResult(NetworkStateTracker.PlaceComponentResult, "Network broadcast received", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.MyBillsEntityDataFactory((NetworkStateTracker) networkStateTracker.MyBillsEntityDataFactory());
        }
    }
}
