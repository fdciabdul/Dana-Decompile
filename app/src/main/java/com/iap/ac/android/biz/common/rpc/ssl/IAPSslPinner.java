package com.iap.ac.android.biz.common.rpc.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.rpc.ssl.SSLPinningManager;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes3.dex */
public class IAPSslPinner {
    public static final IAPSslPinner INSTANCE = new IAPSslPinner();
    public static final String TAG = "IAPSslPinner";
    public SSLPinningManager pinningManager;

    private void parseCertBase64(List<String> list, List<String> list2) {
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = new String(Base64.decode(str, 2));
                    if (!list2.contains(str2)) {
                        list2.add(str2);
                    }
                }
            }
        }
    }

    public void addCertificates(List<String> list) {
        if (list == null || list.size() == 0 || this.pinningManager == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = new String(Base64.decode(str, 2));
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            this.pinningManager.addCertificates(arrayList);
        } catch (Exception e) {
            ACLog.e(TAG, "Add certificates error!", e);
            disableSslPinning();
            ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_SSLPINNING_ADD_CERTS_FAIL, "Add remote certificates fail!");
        }
    }

    public void disableSslPinning() {
        if (this.pinningManager != null) {
            ACLog.i(TAG, "disableSslPinning...");
            this.pinningManager.setPinningMode(0);
        }
    }

    public void enableSslPinning() {
        if (this.pinningManager != null) {
            ACLog.i(TAG, "enableSslPinning...");
            this.pinningManager.setPinningMode(1);
        }
    }

    public void init(Context context) {
        this.pinningManager = new SSLPinningManager(context);
        if (ConfigCenter.INSTANCE.getSslPinningToggle()) {
            this.pinningManager.setPinningMode(1);
            ACLog.d(Constants.TAG, "IAPSslPinner.init: PINNING_MODE_CERTIFICATE");
            try {
                ArrayList arrayList = new ArrayList();
                List<String> sslCertList = ACManager.getInstance().getSslCertList();
                List<String> acCertificates = ConfigCenter.INSTANCE.getAcCertificates();
                parseCertBase64(sslCertList, arrayList);
                parseCertBase64(acCertificates, arrayList);
                this.pinningManager.addCertificates(arrayList);
                if (arrayList.size() == 0) {
                    ACLog.w(TAG, "Cannot find certificatest. Disable ssl pinning.");
                    disableSslPinning();
                    return;
                }
                return;
            } catch (Exception e) {
                ACLog.e(TAG, "Add preset certificates error!", e);
                disableSslPinning();
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_SSLPINNING_ADD_CERTS_FAIL, "Add preset certificates fail!");
                return;
            }
        }
        this.pinningManager.setPinningMode(0);
        ACLog.d(Constants.TAG, "IAPSslPinner.init: PINNING_MODE_NONE");
    }

    public void verifyConnection(HttpsURLConnection httpsURLConnection) throws SSLException {
        SSLPinningManager sSLPinningManager = this.pinningManager;
        if (sSLPinningManager != null) {
            sSLPinningManager.validateCertificates(httpsURLConnection);
        }
    }
}
