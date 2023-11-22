package com.ipification.mobile.sdk.android;

import android.content.Context;
import com.ipification.mobile.sdk.android.InternalService;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/ipification/mobile/sdk/android/InternalService$mCallback$1;", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lcom/ipification/mobile/sdk/android/exception/CellularException;)V", "PlaceComponentResult", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class InternalService$mCallback$1<T> implements CellularCallback<T> {
    public final /* synthetic */ InternalService<T> KClassImpl$Data$declaredNonStaticMembers$2;

    public InternalService$mCallback$1(InternalService<T> internalService) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = internalService;
    }

    @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
    public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
        AuthRequest authRequest;
        Intrinsics.checkParameterIsNotNull(p0, "");
        InternalService<T> internalService = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (internalService.getAuthRequestContext) {
            InternalService.Companion companion = InternalService.MyBillsEntityDataFactory;
            Context context = internalService.PlaceComponentResult;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            InternalService.Companion.PlaceComponentResult(context);
        }
        InternalService<T> internalService2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (internalService2.DatabaseTableConfigUtil && !internalService2.GetContactSyncConfig && (authRequest = internalService2.scheduleImpl) != null) {
            internalService2.GetContactSyncConfig = true;
            internalService2.getAuthRequestContext(authRequest);
            return;
        }
        CellularCallback<T> cellularCallback = internalService2.KClassImpl$Data$declaredNonStaticMembers$2;
        if (cellularCallback == null) {
            Intrinsics.throwNpe();
        }
        cellularCallback.BuiltInFictitiousFunctionClassFactory(p0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0148, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x014f, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0151, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(T r9) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.InternalService$mCallback$1.PlaceComponentResult(java.lang.Object):void");
    }
}
