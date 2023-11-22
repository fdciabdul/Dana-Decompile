package com.ipification.mobile.sdk.android.response;

import com.ipification.mobile.sdk.android.request.API_TYPE;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/ipification/mobile/sdk/android/response/RedirectResponse;", "Lcom/ipification/mobile/sdk/android/response/CellularResponse;", "Lcom/ipification/mobile/sdk/android/request/API_TYPE;", "PlaceComponentResult", "Lcom/ipification/mobile/sdk/android/request/API_TYPE;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "", "p1", "p2", "<init>", "(ILjava/lang/String;Lcom/ipification/mobile/sdk/android/request/API_TYPE;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RedirectResponse extends CellularResponse {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public API_TYPE KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedirectResponse(int i, String str, API_TYPE api_type) {
        super(i, str);
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(api_type, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = api_type;
    }
}
