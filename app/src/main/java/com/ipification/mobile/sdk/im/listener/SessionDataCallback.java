package com.ipification.mobile.sdk.im.listener;

import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/ipification/mobile/sdk/im/listener/SessionDataCallback;", "", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "p0", "", "PlaceComponentResult", "(Lcom/ipification/mobile/sdk/android/exception/CellularException;)V", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/ipification/mobile/sdk/android/response/AuthResponse;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface SessionDataCallback {
    void KClassImpl$Data$declaredNonStaticMembers$2(AuthResponse p0);

    void PlaceComponentResult(CellularException p0);
}
