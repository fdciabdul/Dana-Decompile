package com.iap.ac.android.common.rpc.interfaces;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

/* loaded from: classes3.dex */
public interface HttpsTransportEventListener {
    void onConnect(HttpsURLConnection httpsURLConnection) throws SSLException;
}
