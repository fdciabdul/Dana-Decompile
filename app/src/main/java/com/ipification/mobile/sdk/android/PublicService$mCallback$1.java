package com.ipification.mobile.sdk.android;

import android.content.Context;
import com.ipification.mobile.sdk.android.PublicService;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.im.listener.IMPublicAPICallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/ipification/mobile/sdk/android/PublicService$mCallback$1;", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lcom/ipification/mobile/sdk/android/exception/CellularException;)V", "PlaceComponentResult", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PublicService$mCallback$1<T> implements CellularCallback<T> {
    public final /* synthetic */ PublicService<T> getAuthRequestContext;

    public PublicService$mCallback$1(PublicService<T> publicService) {
        this.getAuthRequestContext = publicService;
    }

    @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
    public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
        AuthRequest authRequest;
        Intrinsics.checkParameterIsNotNull(p0, "");
        PublicService<T> publicService = this.getAuthRequestContext;
        if (publicService.MyBillsEntityDataFactory) {
            PublicService.Companion companion = PublicService.PlaceComponentResult;
            Context context = publicService.getAuthRequestContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            PublicService.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context);
        }
        PublicService<T> publicService2 = this.getAuthRequestContext;
        if (publicService2.getErrorConfigVersion && !publicService2.moveToNextValue && (authRequest = publicService2.BuiltInFictitiousFunctionClassFactory) != null) {
            publicService2.moveToNextValue = true;
            publicService2.KClassImpl$Data$declaredNonStaticMembers$2(authRequest);
            return;
        }
        IMPublicAPICallback iMPublicAPICallback = publicService2.KClassImpl$Data$declaredNonStaticMembers$2;
        if (iMPublicAPICallback == null) {
            Intrinsics.throwNpe();
        }
        iMPublicAPICallback.MyBillsEntityDataFactory(p0.BuiltInFictitiousFunctionClassFactory());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a4, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(T r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.ipification.mobile.sdk.android.response.RedirectResponse
            if (r0 == 0) goto L52
            com.ipification.mobile.sdk.android.response.RedirectResponse r4 = (com.ipification.mobile.sdk.android.response.RedirectResponse) r4
            java.lang.String r0 = r4.getAuthRequestContext
            java.lang.String r1 = "onRedirect "
            kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            com.ipification.mobile.sdk.android.request.AuthRequest$Builder r1 = new com.ipification.mobile.sdk.android.request.AuthRequest$Builder
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r1.<init>(r0)
            com.ipification.mobile.sdk.android.request.API_TYPE r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            r1.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            com.ipification.mobile.sdk.android.IPConfiguration$Companion r4 = com.ipification.mobile.sdk.android.IPConfiguration.INSTANCE
            com.ipification.mobile.sdk.android.IPConfiguration r4 = com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory()
            android.net.Uri r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda5
            java.lang.String r0 = ""
            if (r4 == 0) goto L36
            com.ipification.mobile.sdk.android.IPConfiguration r4 = com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory()
            android.net.Uri r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda5
            if (r4 != 0) goto L31
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L31:
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            r1.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
        L36:
            com.ipification.mobile.sdk.android.request.AuthRequest r4 = r1.KClassImpl$Data$declaredNonStaticMembers$2()
            com.ipification.mobile.sdk.android.PublicService<T> r1 = r3.getAuthRequestContext
            android.content.Context r1 = r1.getAuthRequestContext
            if (r1 == 0) goto L4d
            com.ipification.mobile.sdk.android.connection.DefaultConnection r0 = new com.ipification.mobile.sdk.android.connection.DefaultConnection
            r2 = 1
            r0.<init>(r2, r1, r4, r3)
            r4 = 0
            kotlin.Unit[] r4 = new kotlin.Unit[r4]
            r0.execute(r4)
            return
        L4d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r4 = 0
            throw r4
        L52:
            boolean r0 = r4 instanceof com.ipification.mobile.sdk.android.response.AuthResponse
            if (r0 == 0) goto Lb1
            com.ipification.mobile.sdk.android.response.AuthResponse r4 = (com.ipification.mobile.sdk.android.response.AuthResponse) r4
            boolean r0 = r4.lookAheadTest()
            if (r0 == 0) goto L7c
            com.ipification.mobile.sdk.android.model.IMSession r0 = r4.BuiltInFictitiousFunctionClassFactory()
            if (r0 == 0) goto L7c
            com.ipification.mobile.sdk.android.PublicService<T> r0 = r3.getAuthRequestContext
            com.ipification.mobile.sdk.im.listener.IMPublicAPICallback r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 != 0) goto L6d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L6d:
            com.ipification.mobile.sdk.android.model.IMSession r4 = r4.BuiltInFictitiousFunctionClassFactory()
            if (r4 != 0) goto L76
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L76:
            com.ipification.mobile.sdk.android.response.IMResponse r0 = new com.ipification.mobile.sdk.android.response.IMResponse
            r0.<init>(r4)
            return
        L7c:
            boolean r0 = r4.lookAheadTest()
            if (r0 == 0) goto La7
            com.ipification.mobile.sdk.android.model.IMSession r4 = r4.BuiltInFictitiousFunctionClassFactory()
            if (r4 != 0) goto La7
            com.ipification.mobile.sdk.android.exception.IPificationError r4 = new com.ipification.mobile.sdk.android.exception.IPificationError
            r4.<init>()
            java.lang.String r0 = "IM header is null"
            r4.MyBillsEntityDataFactory = r0
            r0 = 901(0x385, float:1.263E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.PlaceComponentResult = r0
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            r4.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            com.ipification.mobile.sdk.android.PublicService<T> r0 = r3.getAuthRequestContext
            com.ipification.mobile.sdk.im.listener.IMPublicAPICallback r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 != 0) goto Ld2
            goto Lcf
        La7:
            com.ipification.mobile.sdk.android.PublicService<T> r4 = r3.getAuthRequestContext
            com.ipification.mobile.sdk.im.listener.IMPublicAPICallback r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            if (r4 != 0) goto Lb0
            kotlin.jvm.internal.Intrinsics.throwNpe()
        Lb0:
            return
        Lb1:
            com.ipification.mobile.sdk.android.exception.IPificationError r4 = new com.ipification.mobile.sdk.android.exception.IPificationError
            r4.<init>()
            java.lang.String r0 = "not supported"
            r4.MyBillsEntityDataFactory = r0
            r0 = 902(0x386, float:1.264E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.PlaceComponentResult = r0
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            r4.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            com.ipification.mobile.sdk.android.PublicService<T> r0 = r3.getAuthRequestContext
            com.ipification.mobile.sdk.im.listener.IMPublicAPICallback r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 != 0) goto Ld2
        Lcf:
            kotlin.jvm.internal.Intrinsics.throwNpe()
        Ld2:
            r0.MyBillsEntityDataFactory(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.PublicService$mCallback$1.PlaceComponentResult(java.lang.Object):void");
    }
}
