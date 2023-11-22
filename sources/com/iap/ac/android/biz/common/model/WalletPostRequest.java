package com.iap.ac.android.biz.common.model;

import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;

/* loaded from: classes3.dex */
public class WalletPostRequest extends BaseRpcRequest {
    public String operationType;
    public String pspId;
    public String requestData;

    public WalletPostRequest(String str, String str2, String str3) {
        this.pspId = str;
        this.operationType = str2;
        this.requestData = str3;
    }

    public WalletPostRequest() {
    }
}
