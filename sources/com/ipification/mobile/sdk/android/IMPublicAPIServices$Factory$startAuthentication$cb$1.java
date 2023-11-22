package com.ipification.mobile.sdk.android;

import com.ipification.mobile.sdk.android.exception.IPificationError;
import com.ipification.mobile.sdk.im.listener.IMPublicAPICallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/IMPublicAPIServices$Factory$startAuthentication$cb$1;", "Lcom/ipification/mobile/sdk/im/listener/IMPublicAPICallback;", "Lcom/ipification/mobile/sdk/android/exception/IPificationError;", "p0", "", "MyBillsEntityDataFactory", "(Lcom/ipification/mobile/sdk/android/exception/IPificationError;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class IMPublicAPIServices$Factory$startAuthentication$cb$1 implements IMPublicAPICallback {
    public final /* synthetic */ IMPublicAPICallback getAuthRequestContext;

    @Override // com.ipification.mobile.sdk.im.listener.IMPublicAPICallback
    public final void MyBillsEntityDataFactory(IPificationError p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        this.getAuthRequestContext.MyBillsEntityDataFactory(p0);
    }
}
