package com.ipification.mobile.sdk.android;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.push.e;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.connection.CellularConnection;
import com.ipification.mobile.sdk.android.connection.DefaultConnection;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.utils.LogLevel;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import com.ipification.mobile.sdk.android.utils.NetworkUtils;
import com.ipification.mobile.sdk.im.listener.IMPublicAPICallback;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u001f\u0018\u0000 N*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001NB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J0\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.2\u0006\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000201J\u001c\u00103\u001a\u00020&2\n\u00104\u001a\u000605j\u0002`62\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J,\u0010?\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u001d2\u0006\u0010-\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\fH\u0002J\u0016\u0010?\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0015J'\u0010B\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u001d2\u0006\u0010-\u001a\u00020\u0015H\u0000¢\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u0010\u0010F\u001a\u00020&2\u0006\u0010E\u001a\u00020\u001dH\u0002J\u000e\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020\nJ\u0012\u0010G\u001a\u00020\f2\n\b\u0002\u0010I\u001a\u0004\u0018\u000101J\u000e\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\fJ\u0010\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u000201H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/ipification/mobile/sdk/android/PublicService;", "T", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "()V", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "authorizationServiceConfiguration", "Lcom/ipification/mobile/sdk/android/AuthorizationServiceConfiguration;", "autoRemoveNetwork", "", HummerConstants.CONTEXT, "imLocale", "Lcom/ipification/mobile/sdk/im/IMLocale;", "getImLocale$ipification_auth_release", "()Lcom/ipification/mobile/sdk/im/IMLocale;", "setImLocale$ipification_auth_release", "(Lcom/ipification/mobile/sdk/im/IMLocale;)V", "imPublicAPICallback", "Lcom/ipification/mobile/sdk/im/listener/IMPublicAPICallback;", "imTheme", "Lcom/ipification/mobile/sdk/im/IMTheme;", "getImTheme$ipification_auth_release", "()Lcom/ipification/mobile/sdk/im/IMTheme;", "setImTheme$ipification_auth_release", "(Lcom/ipification/mobile/sdk/im/IMTheme;)V", "mAuthRequest", "Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "mCallback", "com/ipification/mobile/sdk/android/PublicService$mCallback$1", "Lcom/ipification/mobile/sdk/android/PublicService$mCallback$1;", "networkProcess", "Lcom/ipification/mobile/sdk/android/NetworkManager;", "supportIMFlow", "triedIMFlow", "callbackFailed", "", "exception", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", DataflowMonitorModel.METHOD_NAME_CONNECTION, "cellularRequest", "network", "Landroid/net/Network;", "callback", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "forceOKHttpConnection", "getConfiguration", "", "name", "handleException", e.PlaceComponentResult, "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "handleIMResponse", "response", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "handleNoNetworkError", "handleUnAvailableCase", "notRegisterCallbackError", "performAuth", "customRequest", "isOnlyIMFlow", "performAuthentication", "performAuthentication$ipification_auth_release", "performIMRequest", "authRequest", "performRequest", "setAuthorizationServiceConfiguration", "config", "fileName", "setAutoRemoveNetwork", "removeNetwork", "showLog", "log", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PublicService<T> {
    public static final Companion PlaceComponentResult = new Companion(null);
    public AuthRequest BuiltInFictitiousFunctionClassFactory;
    public IMPublicAPICallback KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public PublicService$mCallback$1 NetworkUserEntityData$$ExternalSyntheticLambda0 = new PublicService$mCallback$1(this);
    public Context getAuthRequestContext;
    public boolean getErrorConfigVersion;
    public boolean moveToNextValue;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/PublicService$Companion;", "", "Landroid/content/Context;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            return NetworkManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0).PlaceComponentResult();
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(AuthRequest authRequest, Network network, CellularCallback<T> cellularCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            Context context = this.getAuthRequestContext;
            if (context != null) {
                new DefaultConnection(false, context, authRequest, cellularCallback).execute(new Unit[0]);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        }
        Context context2 = this.getAuthRequestContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        CellularConnection cellularConnection = new CellularConnection(authRequest, cellularCallback, network, context2);
        Context context3 = this.getAuthRequestContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        String obj = authRequest.PlaceComponentResult(context3).toString();
        Intrinsics.checkExpressionValueIsNotNull(obj, "");
        cellularConnection.getAuthRequestContext(obj, false);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(AuthRequest authRequest) {
        authRequest.getErrorConfigVersion = false;
        LogUtils.Companion companion = LogUtils.getAuthRequestContext;
        LogUtils.Companion.BuiltInFictitiousFunctionClassFactory(LogLevel.ERROR);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            CellularCallback.DefaultImpls.getAuthRequestContext(LogUtils.getAuthRequestContext, "notRegisterCallbackError");
            CellularException cellularException = new CellularException();
            cellularException.getAuthRequestContext = 1001;
            cellularException.MyBillsEntityDataFactory = new NullPointerException("You have to register CellularCallback before performing Request");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(cellularException);
            return;
        }
        NetworkUtils.Companion companion2 = NetworkUtils.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = this.getAuthRequestContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        if (!NetworkUtils.Companion.getAuthRequestContext(context)) {
            Context context2 = this.getAuthRequestContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            } else if (!NetworkUtils.Companion.MyBillsEntityDataFactory(context2)) {
                CellularCallback.DefaultImpls.getAuthRequestContext(companion, "No Internet connection");
                CellularException cellularException2 = new CellularException();
                cellularException2.getAuthRequestContext = 1000;
                cellularException2.MyBillsEntityDataFactory = new NetworkErrorException("No Internet connection");
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(cellularException2);
                return;
            }
        }
        BuiltInFictitiousFunctionClassFactory(authRequest, null, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
