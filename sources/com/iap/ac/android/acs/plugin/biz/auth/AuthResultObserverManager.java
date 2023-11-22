package com.iap.ac.android.acs.plugin.biz.auth;

import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.common.log.ACLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class AuthResultObserverManager {
    public static final String TAG = "IAPConnectPlugin";
    public static final int TYPE_PAY_SIGN_CENTER = 2;
    public static final int TYPE_SIGN_CONTRACT = 1;
    public static List<AuthResultObserver> signContractObservers = new CopyOnWriteArrayList();
    public static List<AuthResultObserver> paySignCenterObservers = new CopyOnWriteArrayList();

    public static void notifyAuthResult(AuthResult authResult) {
        if (!signContractObservers.isEmpty()) {
            StringBuilder a2 = a.a("AuthCodeObserverManager#notifyAuthResult, signContract observers size: ");
            a2.append(signContractObservers.size());
            ACLog.d("IAPConnectPlugin", a2.toString());
            Iterator<AuthResultObserver> it = signContractObservers.iterator();
            while (it.hasNext()) {
                it.next().onGetAuthResult(authResult);
            }
        }
        if (paySignCenterObservers.isEmpty()) {
            return;
        }
        StringBuilder a3 = a.a("AuthCodeObserverManager#notifyAuthResult, paySignCenter observers size: ");
        a3.append(paySignCenterObservers.size());
        ACLog.d("IAPConnectPlugin", a3.toString());
        Iterator<AuthResultObserver> it2 = paySignCenterObservers.iterator();
        while (it2.hasNext()) {
            it2.next().onGetAuthResult(authResult);
        }
    }

    public static void registerObserver(int i, AuthResultObserver authResultObserver) {
        if (authResultObserver != null) {
            if (i == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthCodeObserverManager#registerObserver for signContract: ");
                sb.append(authResultObserver);
                ACLog.d("IAPConnectPlugin", sb.toString());
                signContractObservers.add(authResultObserver);
            } else if (i == 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("AuthCodeObserverManager#registerObserver for paySignCenter: ");
                sb2.append(authResultObserver);
                ACLog.d("IAPConnectPlugin", sb2.toString());
                paySignCenterObservers.add(authResultObserver);
            }
        }
    }

    public static void unregisterObserver(int i, AuthResultObserver authResultObserver) {
        if (authResultObserver != null) {
            if (i == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("AuthCodeObserverManager#unregisterObserver for signContract: ");
                sb.append(authResultObserver);
                ACLog.d("IAPConnectPlugin", sb.toString());
                signContractObservers.remove(authResultObserver);
            } else if (i == 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("AuthCodeObserverManager#unregisterObserver for paySignCenter: ");
                sb2.append(authResultObserver);
                ACLog.d("IAPConnectPlugin", sb2.toString());
                paySignCenterObservers.remove(authResultObserver);
            }
        }
    }
}
