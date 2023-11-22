package com.splunk.rum;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.splunk.rum.CurrentNetwork;

/* loaded from: classes3.dex */
class SimpleNetworkDetector implements NetworkDetector {
    private final ConnectivityManager MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleNetworkDetector(ConnectivityManager connectivityManager) {
        this.MyBillsEntityDataFactory = connectivityManager;
    }

    @Override // com.splunk.rum.NetworkDetector
    public final CurrentNetwork BuiltInFictitiousFunctionClassFactory() {
        NetworkInfo activeNetworkInfo = this.MyBillsEntityDataFactory.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return ConnectionUtil.getAuthRequestContext;
        }
        int type = activeNetworkInfo.getType();
        byte b = 0;
        if (type == 0) {
            CurrentNetwork.Builder authRequestContext = CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_CELLULAR);
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = activeNetworkInfo.getSubtypeName();
            return new CurrentNetwork(authRequestContext, b);
        } else if (type == 1) {
            CurrentNetwork.Builder authRequestContext2 = CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_WIFI);
            authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2 = activeNetworkInfo.getSubtypeName();
            return new CurrentNetwork(authRequestContext2, b);
        } else if (type == 17) {
            CurrentNetwork.Builder authRequestContext3 = CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_VPN);
            authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2 = activeNetworkInfo.getSubtypeName();
            return new CurrentNetwork(authRequestContext3, b);
        } else {
            return ConnectionUtil.PlaceComponentResult;
        }
    }
}
