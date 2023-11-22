package com.alipay.plus.android.unipayresult.sdk.executor.a;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.ap.mobileprod.biz.uniresultpage.rpc.UniResultPageRpcFacade;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.task.AsyncTaskExecutor;
import com.alipay.iap.android.common.task.async.IAPAsyncCallback;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.plus.android.unipayresult.sdk.executor.UnifierPayResultInfo;
import com.alipay.plus.android.unipayresult.sdk.request.UnifierPollingRpcRequest;
import com.alipayplus.mobile.component.common.facade.base.result.BaseServiceResult;
import com.alipayplus.mobile.component.common.facade.uniresultpage.request.UniResultPageAckRequest;
import com.alipayplus.mobile.component.uniresultpage.service.request.UniResultPageQueryRequest;
import com.alipayplus.mobile.component.uniresultpage.service.result.UniResultPageQueryResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    public static Map<String, List<String>> a(List<String> list) {
        HashMap hashMap = new HashMap();
        for (String str : list) {
            JSONObject parseObject = JSONObject.parseObject(str);
            if (parseObject != null) {
                String string = parseObject.getString("resultBizType");
                if (!TextUtils.isEmpty(string)) {
                    List list2 = (List) hashMap.get(string);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(string, list2);
                    }
                    list2.add(str);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.alipay.plus.android.unipayresult.sdk.executor.a.a$1] */
    public static void a(final String str, final UnifierPollingRpcRequest unifierPollingRpcRequest, IAPAsyncCallback<UniResultPageQueryResult> iAPAsyncCallback) {
        new IAPAsyncTask(iAPAsyncCallback) { // from class: com.alipay.plus.android.unipayresult.sdk.executor.a.a.1
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask
            public final Object run() throws Exception {
                UniResultPageQueryRequest uniResultPageQueryRequest = new UniResultPageQueryRequest();
                uniResultPageQueryRequest.resultBizType = str;
                uniResultPageQueryRequest.linkTargetId = unifierPollingRpcRequest.mLinkTargetId;
                uniResultPageQueryRequest.bizNos = unifierPollingRpcRequest.mBizNos;
                return ((UniResultPageRpcFacade) RPCProxyHost.getInterfaceProxy(UniResultPageRpcFacade.class)).query(uniResultPageQueryRequest);
            }
        }.executeOnExecutor(AsyncTaskExecutor.getInstance().getExecutor(), new Void[0]);
    }

    public static void a(final String str, List<UnifierPayResultInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final UniResultPageRpcFacade uniResultPageRpcFacade = (UniResultPageRpcFacade) RPCProxyHost.getInterfaceProxy(UniResultPageRpcFacade.class);
        for (final UnifierPayResultInfo unifierPayResultInfo : list) {
            IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<BaseServiceResult>() { // from class: com.alipay.plus.android.unipayresult.sdk.executor.a.a.2
                @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
                /* renamed from: a  reason: merged with bridge method [inline-methods] */
                public final BaseServiceResult execute() throws Exception {
                    return UniResultPageRpcFacade.this.ack(a.b(str, unifierPayResultInfo));
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                /* renamed from: a  reason: merged with bridge method [inline-methods] */
                public final void onSuccess(BaseServiceResult baseServiceResult) {
                    LoggerWrapper.i("UniPayResultRpcHelper", String.format("asyncAckOrderList onSuccess! tradeNO = %s", unifierPayResultInfo.mBizNo));
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public final void onFailure(IAPError iAPError) {
                    LoggerWrapper.e("UniPayResultRpcHelper", String.format("asyncAckOrderList onFailure! tradeNO = %s", unifierPayResultInfo.mBizNo));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UniResultPageAckRequest b(String str, UnifierPayResultInfo unifierPayResultInfo) {
        UniResultPageAckRequest uniResultPageAckRequest = new UniResultPageAckRequest();
        uniResultPageAckRequest.bizNo = unifierPayResultInfo.mBizNo;
        uniResultPageAckRequest.linkTargetId = unifierPayResultInfo.mLinkTargetId;
        uniResultPageAckRequest.resultBizType = str;
        return uniResultPageAckRequest;
    }
}
