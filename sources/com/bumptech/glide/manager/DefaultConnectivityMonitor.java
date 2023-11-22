package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    boolean BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    final ConnectivityMonitor.ConnectivityListener MyBillsEntityDataFactory;
    private final BroadcastReceiver PlaceComponentResult = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.DefaultConnectivityMonitor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory;
            DefaultConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory = DefaultConnectivityMonitor.KClassImpl$Data$declaredNonStaticMembers$2(context);
            if (z != DefaultConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("connectivity changed, isConnected: ");
                    sb.append(DefaultConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory);
                    InstrumentInjector.log_d("ConnectivityMonitor", sb.toString());
                }
                DefaultConnectivityMonitor.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(DefaultConnectivityMonitor.this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    };
    private boolean getAuthRequestContext;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
        this.MyBillsEntityDataFactory = connectivityListener;
    }

    static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.PlaceComponentResult((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                InstrumentInjector.log_w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onStart() {
        if (this.getAuthRequestContext) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.registerReceiver(this.PlaceComponentResult, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.getAuthRequestContext = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                InstrumentInjector.log_w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onStop() {
        if (this.getAuthRequestContext) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.unregisterReceiver(this.PlaceComponentResult);
            this.getAuthRequestContext = false;
        }
    }
}
