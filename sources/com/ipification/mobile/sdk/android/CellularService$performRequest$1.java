package com.ipification.mobile.sdk.android;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.ipification.mobile.sdk.android.CellularService;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.callback.IPNetworkCallback;
import com.ipification.mobile.sdk.android.connection.CellularConnection;
import com.ipification.mobile.sdk.android.connection.DefaultConnection;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.response.CoverageResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\b"}, d2 = {"Lcom/ipification/mobile/sdk/android/CellularService$performRequest$1;", "Lcom/ipification/mobile/sdk/android/callback/IPNetworkCallback;", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lcom/ipification/mobile/sdk/android/exception/CellularException;)V", "Landroid/net/Network;", "(Landroid/net/Network;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class CellularService$performRequest$1 implements IPNetworkCallback {
    public final /* synthetic */ CellularService<T> BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ AuthRequest getAuthRequestContext;

    @Override // com.ipification.mobile.sdk.android.callback.IPNetworkCallback
    public final void BuiltInFictitiousFunctionClassFactory(Network p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        final CellularService<T> cellularService = this.BuiltInFictitiousFunctionClassFactory;
        AuthRequest authRequest = this.getAuthRequestContext;
        CellularCallback<T> cellularCallback = new CellularCallback<T>() { // from class: com.ipification.mobile.sdk.android.CellularService$performRequest$1$onSuccess$1
            @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
            public final void BuiltInFictitiousFunctionClassFactory(CellularException p02) {
                Intrinsics.checkParameterIsNotNull(p02, "");
                CellularService<T> cellularService2 = cellularService;
                if (cellularService2.KClassImpl$Data$declaredNonStaticMembers$2) {
                    CellularService.Companion companion = CellularService.PlaceComponentResult;
                    Context context = cellularService2.BuiltInFictitiousFunctionClassFactory;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    }
                    CellularService.Companion.getAuthRequestContext(context);
                }
                CellularCallback<T> cellularCallback2 = cellularService.getAuthRequestContext;
                if (cellularCallback2 == null) {
                    Intrinsics.throwNpe();
                }
                cellularCallback2.BuiltInFictitiousFunctionClassFactory(p02);
            }

            @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
            public final void PlaceComponentResult(T p02) {
                if ((p02 instanceof CoverageResponse) && cellularService.KClassImpl$Data$declaredNonStaticMembers$2 && !((CoverageResponse) p02).PlaceComponentResult()) {
                    CellularService.Companion companion = CellularService.PlaceComponentResult;
                    Context context = cellularService.BuiltInFictitiousFunctionClassFactory;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        throw null;
                    }
                    CellularService.Companion.getAuthRequestContext(context);
                }
                CellularCallback<T> cellularCallback2 = cellularService.getAuthRequestContext;
                if (cellularCallback2 == null) {
                    Intrinsics.throwNpe();
                }
                cellularCallback2.PlaceComponentResult(p02);
            }
        };
        CellularService.Companion companion = CellularService.PlaceComponentResult;
        if (p0 == null) {
            Context context = cellularService.BuiltInFictitiousFunctionClassFactory;
            if (context != null) {
                new DefaultConnection(false, context, authRequest, cellularCallback).execute(new Unit[0]);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            Context context2 = cellularService.BuiltInFictitiousFunctionClassFactory;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            CellularConnection cellularConnection = new CellularConnection(authRequest, cellularCallback, p0, context2);
            Context context3 = cellularService.BuiltInFictitiousFunctionClassFactory;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            String obj = authRequest.PlaceComponentResult(context3).toString();
            Intrinsics.checkExpressionValueIsNotNull(obj, "");
            cellularConnection.getAuthRequestContext(obj, false);
        }
    }

    @Override // com.ipification.mobile.sdk.android.callback.IPNetworkCallback
    public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.stringPlus("error", p0.getAuthRequestContext);
        CellularCallback<T> cellularCallback = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        if (cellularCallback != 0) {
            cellularCallback.BuiltInFictitiousFunctionClassFactory(p0);
        }
        CellularService<T> cellularService = this.BuiltInFictitiousFunctionClassFactory;
        if (cellularService.KClassImpl$Data$declaredNonStaticMembers$2) {
            CellularService.Companion companion = CellularService.PlaceComponentResult;
            Context context = cellularService.BuiltInFictitiousFunctionClassFactory;
            if (context != null) {
                CellularService.Companion.getAuthRequestContext(context);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        }
    }
}
