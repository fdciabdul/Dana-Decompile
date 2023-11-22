package com.ipification.mobile.sdk.android.callback;

import com.alibaba.ariver.kernel.RVEvents;
import com.ipification.mobile.sdk.android.exception.IPificationError;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ipification/mobile/sdk/android/callback/IPificationCallback;", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "", "error", "Lcom/ipification/mobile/sdk/android/exception/IPificationError;", "onIMCancel", "onSuccess", "response", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface IPificationCallback {
    void MyBillsEntityDataFactory(AuthResponse authResponse);

    void getAuthRequestContext(IPificationError iPificationError);
}
