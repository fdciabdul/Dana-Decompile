package com.iap.ac.android.bscanc.b;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.oauth.OAuthUtil;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.cpm.online.manager.OnlinePaymentCodeManager;
import com.iap.ac.android.cpm.online.rpc.service.MobileInStorePaymentEncodeRpcResult;

/* loaded from: classes8.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7550a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ IPaymentCodeListener d;
    public final /* synthetic */ OnlinePaymentCodeManager e;

    public b(OnlinePaymentCodeManager onlinePaymentCodeManager, int i, String str, int i2, IPaymentCodeListener iPaymentCodeListener) {
        this.e = onlinePaymentCodeManager;
        this.f7550a = i;
        this.b = str;
        this.c = i2;
        this.d = iPaymentCodeListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        OnlinePaymentCodeManager onlinePaymentCodeManager;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int oAuthChainType = OAuthUtil.getInstance().getOAuthChainType();
        ACLog.i(Constants.TAG, "refreshPaymentCode start in thread");
        this.e.f7564a.lock();
        try {
            MobileInStorePaymentEncodeRpcResult a2 = new a().a(this.f7550a, this.b, this.c, this.e.e);
            if (a2 != null) {
                if (a2.success) {
                    int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                    com.iap.ac.android.bscanc.a.b.b().a(Utils.stringToLong(a2.currentServerTime, System.currentTimeMillis()) + (elapsedRealtime2 / 2));
                    this.e.a(a2, this.d, this.b, elapsedRealtime, oAuthChainType);
                } else {
                    OnlinePaymentCodeManager onlinePaymentCodeManager2 = this.e;
                    IPaymentCodeListener iPaymentCodeListener = this.d;
                    String str = a2.errorCode;
                    String str2 = a2.errorMessage;
                    onlinePaymentCodeManager2.a(iPaymentCodeListener, str, str2, str2, SystemClock.elapsedRealtime() - elapsedRealtime, a2.traceId, oAuthChainType);
                }
            } else {
                this.e.a(this.d, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", "RPC refresh code error: rpc failed", SystemClock.elapsedRealtime() - elapsedRealtime, "", oAuthChainType);
            }
            onlinePaymentCodeManager = this.e;
        } catch (Throwable th) {
            try {
                this.e.a(this.d, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", Utils.e(th), SystemClock.elapsedRealtime() - elapsedRealtime, "", oAuthChainType);
                onlinePaymentCodeManager = this.e;
            } catch (Throwable th2) {
                this.e.f7564a.unlock();
                throw th2;
            }
        }
        onlinePaymentCodeManager.f7564a.unlock();
    }
}
