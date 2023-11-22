package com.ipification.mobile.sdk.android;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.push.e;
import com.ipification.mobile.sdk.android.InternalService;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.callback.IPNetworkCallback;
import com.ipification.mobile.sdk.android.connection.CellularConnection;
import com.ipification.mobile.sdk.android.connection.DefaultConnection;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.utils.LogLevel;
import com.ipification.mobile.sdk.android.utils.LogUtils;
import com.ipification.mobile.sdk.android.utils.NetworkUtils;
import com.ipification.mobile.sdk.im.IMLocale;
import com.ipification.mobile.sdk.im.IMTheme;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001\u001f\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001QB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u001b\u0010)\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000¢\u0006\u0002\b+J\u001c\u0010)\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u001c\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020-2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ0\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u0001032\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u00104\u001a\u00020\fH\u0002J\u0010\u00105\u001a\u0004\u0018\u00010-2\u0006\u00106\u001a\u00020-J\u001c\u00107\u001a\u00020&2\n\u00108\u001a\u000609j\u0002`:2\u0006\u0010;\u001a\u00020<H\u0002J\u001e\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020?2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002J\u001e\u0010C\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007J(\u0010C\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002J-\u0010E\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0010\u0010I\u001a\u00020&2\u0006\u0010H\u001a\u00020\u001dH\u0002J\u000e\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\nJ\u0012\u0010J\u001a\u00020\f2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010-J\u000e\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020\fJ\u0010\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020-H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/ipification/mobile/sdk/android/InternalService;", "T", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "()V", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "authorizationServiceConfiguration", "Lcom/ipification/mobile/sdk/android/AuthorizationServiceConfiguration;", "autoRemoveNetwork", "", "cellularCallback", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", HummerConstants.CONTEXT, "imLocale", "Lcom/ipification/mobile/sdk/im/IMLocale;", "getImLocale$ipification_auth_release", "()Lcom/ipification/mobile/sdk/im/IMLocale;", "setImLocale$ipification_auth_release", "(Lcom/ipification/mobile/sdk/im/IMLocale;)V", "imTheme", "Lcom/ipification/mobile/sdk/im/IMTheme;", "getImTheme$ipification_auth_release", "()Lcom/ipification/mobile/sdk/im/IMTheme;", "setImTheme$ipification_auth_release", "(Lcom/ipification/mobile/sdk/im/IMTheme;)V", "mAuthRequest", "Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "mCallback", "com/ipification/mobile/sdk/android/InternalService$mCallback$1", "Lcom/ipification/mobile/sdk/android/InternalService$mCallback$1;", "networkProcess", "Lcom/ipification/mobile/sdk/android/NetworkManager;", "supportIMFlow", "triedIMFlow", "callbackFailed", "", "exception", "Lcom/ipification/mobile/sdk/android/exception/CellularException;", "checkCoverage", "callback", "checkCoverage$ipification_auth_release", "phoneNumber", "", "checkRequestedIP", "url", DataflowMonitorModel.METHOD_NAME_CONNECTION, "cellularRequest", "network", "Landroid/net/Network;", "forceOKHttpConnection", "getConfiguration", "name", "handleException", e.PlaceComponentResult, "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "handleIMResponse", "response", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "handleNoNetworkError", "handleUnAvailableCase", "notRegisterCallbackError", "performAuth", "customRequest", "performAuthentication", "performAuthentication$ipification_auth_release", "performIMRequest", "authRequest", "performRequest", "setAuthorizationServiceConfiguration", "config", "fileName", "setAutoRemoveNetwork", "removeNetwork", "showLog", "log", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class InternalService<T> {
    public static final Companion MyBillsEntityDataFactory = new Companion(null);
    public Activity BuiltInFictitiousFunctionClassFactory;
    public boolean DatabaseTableConfigUtil;
    public boolean GetContactSyncConfig;
    public CellularCallback<T> KClassImpl$Data$declaredNonStaticMembers$2;
    public IMLocale NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Context PlaceComponentResult;
    public boolean getAuthRequestContext;
    public InternalService$mCallback$1 getErrorConfigVersion;
    public IMTheme lookAheadTest;
    public NetworkManager moveToNextValue;
    public AuthRequest scheduleImpl;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/InternalService$Companion;", "", "Landroid/content/Context;", "p0", "", "PlaceComponentResult", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static boolean PlaceComponentResult(Context p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            return NetworkManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0).PlaceComponentResult();
        }
    }

    public InternalService() {
        this.getErrorConfigVersion = new InternalService$mCallback$1(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InternalService(Context context) {
        this();
        Intrinsics.checkParameterIsNotNull(context, "");
        this.PlaceComponentResult = context;
        this.moveToNextValue = NetworkManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(context);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void BuiltInFictitiousFunctionClassFactory(AuthRequest authRequest, Network network, CellularCallback<T> cellularCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            Context context = this.PlaceComponentResult;
            if (context != null) {
                new DefaultConnection(false, context, authRequest, cellularCallback).execute(new Unit[0]);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        }
        Context context2 = this.PlaceComponentResult;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        CellularConnection cellularConnection = new CellularConnection(authRequest, cellularCallback, network, context2);
        Context context3 = this.PlaceComponentResult;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        String obj = authRequest.PlaceComponentResult(context3).toString();
        Intrinsics.checkExpressionValueIsNotNull(obj, "");
        cellularConnection.getAuthRequestContext(obj, false);
    }

    public final void PlaceComponentResult(Exception exc, int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Intrinsics.stringPlus("", exc.getLocalizedMessage());
            return;
        }
        CellularException cellularException = new CellularException();
        cellularException.getAuthRequestContext = Integer.valueOf(i);
        cellularException.MyBillsEntityDataFactory = exc;
        this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(cellularException);
    }

    private void MyBillsEntityDataFactory() {
        CellularCallback.DefaultImpls.getAuthRequestContext(LogUtils.getAuthRequestContext, "notRegisterCallbackError");
        CellularException cellularException = new CellularException();
        cellularException.getAuthRequestContext = 1001;
        cellularException.MyBillsEntityDataFactory = new NullPointerException("You have to register CellularCallback before performing Request");
        this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(cellularException);
    }

    public final void getAuthRequestContext(AuthRequest authRequest) {
        authRequest.getErrorConfigVersion = false;
        LogUtils.Companion companion = LogUtils.getAuthRequestContext;
        LogUtils.Companion.BuiltInFictitiousFunctionClassFactory(LogLevel.ERROR);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            MyBillsEntityDataFactory();
            return;
        }
        NetworkUtils.Companion companion2 = NetworkUtils.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = this.PlaceComponentResult;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        if (!NetworkUtils.Companion.getAuthRequestContext(context)) {
            Context context2 = this.PlaceComponentResult;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            } else if (!NetworkUtils.Companion.MyBillsEntityDataFactory(context2)) {
                CellularCallback.DefaultImpls.getAuthRequestContext(companion, "No Internet connection");
                CellularException cellularException = new CellularException();
                cellularException.getAuthRequestContext = 1000;
                cellularException.MyBillsEntityDataFactory = new NetworkErrorException("No Internet connection");
                this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(cellularException);
                return;
            }
        }
        BuiltInFictitiousFunctionClassFactory(authRequest, null, this.getErrorConfigVersion);
    }

    public final void PlaceComponentResult(final AuthRequest authRequest) {
        authRequest.getErrorConfigVersion = true;
        LogUtils.Companion companion = LogUtils.getAuthRequestContext;
        LogUtils.Companion.BuiltInFictitiousFunctionClassFactory(LogLevel.ERROR);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            MyBillsEntityDataFactory();
            return;
        }
        NetworkUtils.Companion companion2 = NetworkUtils.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = this.PlaceComponentResult;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        } else if (!NetworkUtils.Companion.getAuthRequestContext(context)) {
            Context context2 = this.PlaceComponentResult;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            } else if (NetworkUtils.Companion.MyBillsEntityDataFactory(context2) && this.DatabaseTableConfigUtil) {
                getAuthRequestContext(authRequest);
            } else {
                CellularCallback.DefaultImpls.getAuthRequestContext(companion, "onUnavailable: Your cellular network is not active or not available");
                CellularException cellularException = new CellularException();
                cellularException.getAuthRequestContext = 1000;
                cellularException.MyBillsEntityDataFactory = new NetworkErrorException("Your cellular network is not active or not available");
                this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(cellularException);
            }
        } else {
            Context context3 = this.PlaceComponentResult;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            if (NetworkUtils.Companion.getAuthRequestContext(context3)) {
                Context context4 = this.PlaceComponentResult;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                } else if (!NetworkUtils.Companion.MyBillsEntityDataFactory(context4)) {
                    BuiltInFictitiousFunctionClassFactory(authRequest, null, this.getErrorConfigVersion);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 21) {
                PlaceComponentResult(new NullPointerException("Our SDK does not support Android SDK under 21 (android 5.0)"), 1006);
                return;
            }
            NetworkManager networkManager = this.moveToNextValue;
            if (networkManager != null) {
                networkManager.MyBillsEntityDataFactory(new IPNetworkCallback(this) { // from class: com.ipification.mobile.sdk.android.InternalService$performRequest$1
                    public final /* synthetic */ InternalService<T> PlaceComponentResult;

                    {
                        this.PlaceComponentResult = this;
                    }

                    @Override // com.ipification.mobile.sdk.android.callback.IPNetworkCallback
                    public final void BuiltInFictitiousFunctionClassFactory(Network p0) {
                        Intrinsics.checkParameterIsNotNull(p0, "");
                        InternalService<T> internalService = this.PlaceComponentResult;
                        internalService.BuiltInFictitiousFunctionClassFactory(authRequest, p0, internalService.getErrorConfigVersion);
                    }

                    @Override // com.ipification.mobile.sdk.android.callback.IPNetworkCallback
                    public final void BuiltInFictitiousFunctionClassFactory(CellularException p0) {
                        Intrinsics.checkParameterIsNotNull(p0, "");
                        Intrinsics.stringPlus("error", p0.getAuthRequestContext);
                        this.PlaceComponentResult.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(p0);
                        InternalService<T> internalService = this.PlaceComponentResult;
                        if (internalService.getAuthRequestContext) {
                            InternalService.Companion companion3 = InternalService.MyBillsEntityDataFactory;
                            Context context5 = internalService.PlaceComponentResult;
                            if (context5 != null) {
                                InternalService.Companion.PlaceComponentResult(context5);
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                throw null;
                            }
                        }
                    }
                });
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Context context = this.PlaceComponentResult;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            throw null;
        }
        AuthorizationServiceConfiguration authorizationServiceConfiguration = new AuthorizationServiceConfiguration(context);
        try {
            Context context2 = this.PlaceComponentResult;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                throw null;
            }
            authorizationServiceConfiguration.BuiltInFictitiousFunctionClassFactory(context2);
            Intrinsics.checkParameterIsNotNull(authorizationServiceConfiguration, "");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
