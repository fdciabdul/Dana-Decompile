package com.ipification.mobile.sdk.android;

import android.content.Context;
import android.net.Uri;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.push.e;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.connection.DefaultConnection;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.response.RedirectResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 2*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\fJ\u001c\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\fJ0\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u001e\u001a\u00020\nH\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u0018J\u001c\u0010!\u001a\u00020\u00122\n\u0010\"\u001a\u00060#j\u0002`$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0012H\u0002J\u0014\u0010)\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\fJ\u001e\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u001b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\fJ\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u001bH\u0002J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\bJ\u0012\u0010-\u001a\u00020\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0018J\u000e\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\nR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/ipification/mobile/sdk/android/CellularService;", "T", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "()V", "authorizationServiceConfiguration", "Lcom/ipification/mobile/sdk/android/AuthorizationServiceConfiguration;", "autoRemoveNetwork", "", "cellularCallback", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", HummerConstants.CONTEXT, "mCallback", "networkProcess", "Lcom/ipification/mobile/sdk/android/NetworkManager;", "callbackFailed", "", "exception", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "checkCoverage", "callback", "phoneNumber", "", DataflowMonitorModel.METHOD_NAME_CONNECTION, "cellularRequest", "Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "network", "Landroid/net/Network;", "isMobileOnly", "getConfiguration", "name", "handleException", e.PlaceComponentResult, "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "handleUnAvailableCase", "notRegisterCallbackError", "performAuth", "extraRequest", "performRequest", "authRequest", "setAuthorizationServiceConfiguration", "config", "fileName", "setAutoRemoveNetwork", "removeNetwork", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class CellularService<T> {
    public static final Companion PlaceComponentResult = new Companion(null);
    public Context BuiltInFictitiousFunctionClassFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public CellularCallback<T> MyBillsEntityDataFactory;
    public CellularCallback<T> getAuthRequestContext = new CellularCallback<T>(this) { // from class: com.ipification.mobile.sdk.android.CellularService$mCallback$1
        public final /* synthetic */ CellularService<T> KClassImpl$Data$declaredNonStaticMembers$2;

        {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
        }

        @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
        public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            CellularCallback<T> cellularCallback = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
            if (cellularCallback != null) {
                cellularCallback.BuiltInFictitiousFunctionClassFactory(p0);
            }
        }

        @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
        public final void PlaceComponentResult(T p0) {
            if (!(p0 instanceof RedirectResponse)) {
                CellularCallback<T> cellularCallback = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                if (cellularCallback != null) {
                    cellularCallback.PlaceComponentResult(p0);
                    return;
                }
                return;
            }
            RedirectResponse redirectResponse = (RedirectResponse) p0;
            String str = redirectResponse.getAuthRequestContext;
            Intrinsics.stringPlus("onRedirect ", str);
            AuthRequest.Builder builder = new AuthRequest.Builder(Uri.parse(str));
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = redirectResponse.KClassImpl$Data$declaredNonStaticMembers$2;
            IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
            if (IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5 != null) {
                Uri uri = IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (uri == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkParameterIsNotNull(uri, "");
                builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = uri;
            }
            AuthRequest KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
            Context context = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            if (context != null) {
                new DefaultConnection(true, context, KClassImpl$Data$declaredNonStaticMembers$2, this).execute(new Unit[0]);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/CellularService$Companion;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static boolean getAuthRequestContext(Context p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            return NetworkManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0).PlaceComponentResult();
        }
    }
}
