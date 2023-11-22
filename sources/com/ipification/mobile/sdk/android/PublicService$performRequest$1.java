package com.ipification.mobile.sdk.android;

import android.content.Context;
import android.net.Network;
import com.ipification.mobile.sdk.android.PublicService;
import com.ipification.mobile.sdk.android.callback.IPNetworkCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\b"}, d2 = {"Lcom/ipification/mobile/sdk/android/PublicService$performRequest$1;", "Lcom/ipification/mobile/sdk/android/callback/IPNetworkCallback;", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lcom/ipification/mobile/sdk/android/exception/CellularException;)V", "Landroid/net/Network;", "(Landroid/net/Network;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PublicService$performRequest$1 implements IPNetworkCallback {
    public final /* synthetic */ AuthRequest BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ PublicService<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.ipification.mobile.sdk.android.callback.IPNetworkCallback
    public final void BuiltInFictitiousFunctionClassFactory(Network p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        PublicService<T> publicService = this.KClassImpl$Data$declaredNonStaticMembers$2;
        publicService.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, p0, publicService.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // com.ipification.mobile.sdk.android.callback.IPNetworkCallback
    public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.stringPlus("error", p0.getAuthRequestContext);
        this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(p0);
        PublicService<T> publicService = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (publicService.MyBillsEntityDataFactory) {
            PublicService.Companion companion = PublicService.PlaceComponentResult;
            Context context = publicService.getAuthRequestContext;
            if (context != null) {
                PublicService.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        }
    }
}
