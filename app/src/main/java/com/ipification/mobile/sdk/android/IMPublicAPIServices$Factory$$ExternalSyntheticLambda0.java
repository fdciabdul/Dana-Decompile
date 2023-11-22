package com.ipification.mobile.sdk.android;

import androidx.view.Observer;
import com.ipification.mobile.sdk.android.IMPublicAPIServices;
import com.ipification.mobile.sdk.im.data.SessionResponse;
import com.ipification.mobile.sdk.im.listener.CompleteSessionCallback;

/* loaded from: classes8.dex */
public final /* synthetic */ class IMPublicAPIServices$Factory$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ CompleteSessionCallback getAuthRequestContext;

    @Override // androidx.view.Observer
    public final void onChanged(Object obj) {
        IMPublicAPIServices.Companion.PlaceComponentResult(this.getAuthRequestContext, (SessionResponse) obj);
    }
}
