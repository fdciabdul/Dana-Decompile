package com.alipay.android.phone.mobilesdk.socketcraft.integrated.ssl;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl.DefaultSSLExtensions;
import com.alipay.mobile.common.transport.utils.SSLSocketUtil;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
public class MPaaSSSLExtensions extends DefaultSSLExtensions {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl.DefaultSSLExtensions, com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl.SSLExtensions
    public void enableTlsExtensions(SSLSocket sSLSocket, String str) {
        SSLSocketUtil.enableTlsExtensions(sSLSocket, str);
    }
}
