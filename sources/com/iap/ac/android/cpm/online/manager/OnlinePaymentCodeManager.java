package com.iap.ac.android.cpm.online.manager;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import com.iap.ac.android.biz.common.internal.oauth.OAuthUtil;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.bscanc.a.a;
import com.iap.ac.android.bscanc.a.b;
import com.iap.ac.android.bscanc.a.c;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.cpm.online.rpc.model.MobileInStorePaymentEncodeResultInfo;
import com.iap.ac.android.cpm.online.rpc.service.MobileInStorePaymentEncodeRpcResult;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public class OnlinePaymentCodeManager {
    public static volatile OnlinePaymentCodeManager f;
    public String b;
    public String e;

    /* renamed from: a  reason: collision with root package name */
    public ReentrantLock f7564a = new ReentrantLock();
    public int c = 5;
    public int d = 30;

    public static OnlinePaymentCodeManager getInstance() {
        if (f == null) {
            synchronized (SPIManager.class) {
                if (f == null) {
                    f = new OnlinePaymentCodeManager();
                }
            }
        }
        return f;
    }

    public final void a(MobileInStorePaymentEncodeRpcResult mobileInStorePaymentEncodeRpcResult, IPaymentCodeListener iPaymentCodeListener, String str, long j, int i) {
        String str2 = mobileInStorePaymentEncodeRpcResult.traceId;
        List<MobileInStorePaymentEncodeResultInfo> list = mobileInStorePaymentEncodeRpcResult.mobileInStorePaymentEncodeResultInfos;
        if (list == null) {
            a(iPaymentCodeListener, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", "RPC refresh code error: code list is null", SystemClock.elapsedRealtime() - j, str2, i);
        } else if (!list.isEmpty()) {
            ConcurrentLinkedQueue<c> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
            for (MobileInStorePaymentEncodeResultInfo mobileInStorePaymentEncodeResultInfo : mobileInStorePaymentEncodeRpcResult.mobileInStorePaymentEncodeResultInfos) {
                c cVar = new c();
                cVar.f7549a = mobileInStorePaymentEncodeResultInfo.paymentCode;
                cVar.b = Utils.stringToLong(mobileInStorePaymentEncodeResultInfo.startServerTime, System.currentTimeMillis());
                concurrentLinkedQueue.add(cVar);
            }
            this.b = a(str);
            b.b().a(this.b, concurrentLinkedQueue);
            if (iPaymentCodeListener != null) {
                String a2 = b.b().a(this.b);
                if (a2 != null) {
                    b(iPaymentCodeListener, a2, str, LogConstants.Cpm.CODE_SOURCE_REMOTE, SystemClock.elapsedRealtime() - j, str2, i);
                } else {
                    a(iPaymentCodeListener, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", "RPC refresh code error: no valid code", SystemClock.elapsedRealtime() - j, str2, i);
                }
            }
        } else {
            a(iPaymentCodeListener, ResultCode.INVALID_NETWORK, "Oops! System busy. Try again later!", "RPC refresh code error: result code list is empty", SystemClock.elapsedRealtime() - j, str2, i);
        }
    }

    public final void b(IPaymentCodeListener iPaymentCodeListener, String str, String str2, String str3, long j, String str4, int i) {
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdated(str);
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_CPM_ONLINE_CODE).addParams("result", "T").addParams(LogConstants.Cpm.KEY_CODE_TYPE, str2).addParams("source", str3).addParams("timeCost", Long.valueOf(j)).addParams("traceId", str4).addParams(LogConstants.KEY_OAUTH_TYPE, Integer.valueOf(i)).event();
        ACLog.i(Constants.TAG, "OnlinePaymentCodeManager, notifyUpdateSuccess");
    }

    public void getPaymentCode(String str, CPMConfig cPMConfig, IPaymentCodeListener iPaymentCodeListener) {
        int oAuthChainType = OAuthUtil.getInstance().getOAuthChainType();
        if (!ConfigCenter.INSTANCE.getOnlineCodeToggle()) {
            a(iPaymentCodeListener, ResultCode.UNKNOWN_EXCEPTION, "Oops! System busy. Try again later!", "getPaymentCode, feature is disabled", 0L, "", oAuthChainType);
            return;
        }
        this.b = a(str);
        if (cPMConfig != null) {
            this.c = cPMConfig.encodeNum;
            this.d = cPMConfig.encodeFrequency;
            a aVar = new a();
            aVar.f7547a = cPMConfig.decodeWindowLeft * 1000;
            aVar.b = cPMConfig.decodeWindowRight * 1000;
            b.b().a(aVar);
        }
        if (TextUtils.isEmpty(str)) {
            a(iPaymentCodeListener, ResultCode.UNKNOWN_EXCEPTION, "Oops! System busy. Try again later!", "getPaymentCode, code type is empty", 0L, "", oAuthChainType);
            return;
        }
        synchronized (this) {
            String a2 = b.b().a(this.b);
            if (a2 != null) {
                String openId = SPIManager.getInstance().getOpenId();
                if (!TextUtils.isEmpty(openId) ? openId.equals(ACManager.getInstance().fetch(InnerConstants.STORAGE_KEY_AC_LOCAL_OPEN_ID)) : true) {
                    b(iPaymentCodeListener, a2, str, "LOCAL", 0L, "", oAuthChainType);
                }
            }
            int i = this.c;
            int i2 = this.d;
            ACLog.i(Constants.TAG, "refreshPaymentCode begin");
            IAPAsyncTask.asyncTask(new com.iap.ac.android.bscanc.b.b(this, i, str, i2, iPaymentCodeListener));
        }
    }

    public void setRegion(String str) {
        this.e = str;
    }

    public final void a(IPaymentCodeListener iPaymentCodeListener, String str, String str2, String str3, long j, String str4, int i) {
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdateFailed(str, str2);
        }
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_CPM_ONLINE_CODE).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", str).addParams("resultMessage", str3).addParams("timeCost", String.valueOf(j)).addParams("traceId", str4).addParams(LogConstants.KEY_OAUTH_TYPE, Integer.valueOf(i)).event();
        StringBuilder sb = new StringBuilder();
        sb.append("OnlinePaymentCodeManager, notifyUpdateFailed, message: ");
        sb.append(str3);
        ACLog.e(Constants.TAG, sb.toString());
        ACLogEvent.crucialRpcEvent("iapconnect_center", LogConstants.EVENT_ID_CPM_ONLINE_CODE_FAIL, str3, str4);
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(this.e) || !ConfigCenter.INSTANCE.getRegionCodeToggle()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(this.e);
        return sb.toString();
    }
}
