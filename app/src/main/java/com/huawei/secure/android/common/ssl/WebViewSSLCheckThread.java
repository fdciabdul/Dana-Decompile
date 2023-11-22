package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.Response;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: classes8.dex */
public class WebViewSSLCheckThread extends Thread {
    private static final String MyBillsEntityDataFactory = "WebViewSSLCheckThread";
    private HostnameVerifier BuiltInFictitiousFunctionClassFactory;
    private SSLSocketFactory KClassImpl$Data$declaredNonStaticMembers$2;
    private Callback NetworkUserEntityData$$ExternalSyntheticLambda0;
    private X509HostnameVerifier PlaceComponentResult;
    private org.apache.http.conn.ssl.SSLSocketFactory getAuthRequestContext;
    private String lookAheadTest;
    private SslErrorHandler moveToNextValue;
    private Context scheduleImpl;

    /* loaded from: classes8.dex */
    public interface Callback {
    }

    /* loaded from: classes8.dex */
    static final class a implements okhttp3.Callback {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ SslErrorHandler MyBillsEntityDataFactory;
        final /* synthetic */ Callback PlaceComponentResult;
        final /* synthetic */ Context getAuthRequestContext;

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            String str = WebViewSSLCheckThread.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("onFailure , IO Exception : ");
            sb.append(iOException.getMessage());
            g.getAuthRequestContext(str, sb.toString());
            if (this.PlaceComponentResult != null) {
                return;
            }
            this.MyBillsEntityDataFactory.cancel();
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) throws IOException {
            g.getAuthRequestContext(WebViewSSLCheckThread.MyBillsEntityDataFactory, "onResponse . proceed");
            if (this.PlaceComponentResult != null) {
                return;
            }
            this.MyBillsEntityDataFactory.proceed();
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        SslErrorHandler sslErrorHandler;
        g.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "callbackProceed: ");
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null && (sslErrorHandler = this.moveToNextValue) != null) {
            sslErrorHandler.proceed();
        }
    }

    private void getAuthRequestContext() {
        String str = MyBillsEntityDataFactory;
        g.KClassImpl$Data$declaredNonStaticMembers$2(str, "callbackCancel: ");
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null && this.moveToNextValue != null) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(str, "callbackCancel 2: ");
            this.moveToNextValue.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0154  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.run():void");
    }
}
