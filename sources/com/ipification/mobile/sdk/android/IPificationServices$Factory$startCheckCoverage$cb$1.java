package com.ipification.mobile.sdk.android;

import com.alibaba.ariver.kernel.RVEvents;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.response.CoverageResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/ipification/mobile/sdk/android/IPificationServices$Factory$startCheckCoverage$cb$1", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "Lcom/ipification/mobile/sdk/android/response/CoverageResponse;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "", "error", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "onIMCancel", "onSuccess", "response", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IPificationServices$Factory$startCheckCoverage$cb$1 implements CellularCallback<CoverageResponse> {
    public final /* synthetic */ CellularCallback<CoverageResponse> PlaceComponentResult;

    @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
    public final void BuiltInFictitiousFunctionClassFactory(CellularException cellularException) {
        Intrinsics.checkParameterIsNotNull(cellularException, "");
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(cellularException);
    }

    @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
    public final void PlaceComponentResult(CoverageResponse coverageResponse) {
        CoverageResponse coverageResponse2 = coverageResponse;
        Intrinsics.checkParameterIsNotNull(coverageResponse2, "");
        this.PlaceComponentResult.PlaceComponentResult(coverageResponse2);
    }
}
