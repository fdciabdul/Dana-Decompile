package com.ipification.mobile.sdk.android;

import android.content.Context;
import android.net.Uri;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.request.API_TYPE;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.response.CoverageResponse;
import com.ipification.mobile.sdk.im.IMLocale;
import com.ipification.mobile.sdk.im.IMTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/ipification/mobile/sdk/android/IPificationServices;", "", "<init>", "()V", "Factory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IPificationServices {
    public static IMTheme BuiltInFictitiousFunctionClassFactory;

    /* renamed from: Factory  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static IMLocale KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/ipification/mobile/sdk/android/IPificationServices$Factory;", "", "", "p0", "Landroid/content/Context;", "p1", "Lcom/ipification/mobile/sdk/android/callback/CellularCallback;", "Lcom/ipification/mobile/sdk/android/response/CoverageResponse;", "p2", "", "getAuthRequestContext", "(Ljava/lang/String;Landroid/content/Context;Lcom/ipification/mobile/sdk/android/callback/CellularCallback;)V", "Lcom/ipification/mobile/sdk/im/IMLocale;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ipification/mobile/sdk/im/IMLocale;", "Lcom/ipification/mobile/sdk/im/IMTheme;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ipification/mobile/sdk/im/IMTheme;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.ipification.mobile.sdk.android.IPificationServices$Factory  reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static void getAuthRequestContext(String p0, Context p1, final CellularCallback<CoverageResponse> p2) {
            Exception exc;
            int i;
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(p2, "");
            InternalService internalService = new InternalService(p1);
            CellularCallback cellularCallback = new CellularCallback<CoverageResponse>() { // from class: com.ipification.mobile.sdk.android.IPificationServices$Factory$startCheckCoverage$cb$2
                @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
                public final void BuiltInFictitiousFunctionClassFactory(CellularException cellularException) {
                    Intrinsics.checkParameterIsNotNull(cellularException, "");
                    p2.BuiltInFictitiousFunctionClassFactory(cellularException);
                }

                @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
                public final void PlaceComponentResult(CoverageResponse coverageResponse) {
                    CoverageResponse coverageResponse2 = coverageResponse;
                    Intrinsics.checkParameterIsNotNull(coverageResponse2, "");
                    p2.PlaceComponentResult(coverageResponse2);
                }
            };
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(cellularCallback, "");
            internalService.KClassImpl$Data$declaredNonStaticMembers$2 = cellularCallback;
            internalService.KClassImpl$Data$declaredNonStaticMembers$2();
            IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
            if (!IPConfiguration.Companion.MyBillsEntityDataFactory().getBottomSheetCardBindingView$watcherCardNumberView$1()) {
                IPConfiguration MyBillsEntityDataFactory = IPConfiguration.Companion.MyBillsEntityDataFactory();
                IPConfiguration MyBillsEntityDataFactory2 = IPConfiguration.Companion.MyBillsEntityDataFactory();
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = Uri.parse(MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda7 == IPEnvironment.SANDBOX ? MyBillsEntityDataFactory2.A ? Intrinsics.stringPlus(MyBillsEntityDataFactory2.GetContactSyncConfig, MyBillsEntityDataFactory2.DatabaseTableConfigUtil) : MyBillsEntityDataFactory2.GetContactSyncConfig : MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            if (IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                exc = new NullPointerException("The Coverage endpoint is null. Please check your configuration");
                i = 1004;
            } else {
                if (IPConfiguration.Companion.MyBillsEntityDataFactory().moveToNextValue.length() == 0) {
                    exc = new NullPointerException("Client_id is empty. Please check your init function");
                } else if (!Intrinsics.areEqual(p0, "")) {
                    AuthRequest.Builder builder = new AuthRequest.Builder(IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda2);
                    builder.KClassImpl$Data$declaredNonStaticMembers$2 = API_TYPE.COVERAGE;
                    builder.BuiltInFictitiousFunctionClassFactory = IPConfiguration.Companion.MyBillsEntityDataFactory().scheduleImpl;
                    builder.initRecordTimeStamp = IPConfiguration.Companion.MyBillsEntityDataFactory().initRecordTimeStamp;
                    if (IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5 != null) {
                        Uri uri = IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5;
                        if (uri == null) {
                            Intrinsics.throwNpe();
                        }
                        Intrinsics.checkParameterIsNotNull(uri, "");
                        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = uri;
                    }
                    String str = IPConfiguration.Companion.MyBillsEntityDataFactory().moveToNextValue;
                    Intrinsics.checkParameterIsNotNull(str, "");
                    builder.getAuthRequestContext = str;
                    builder.KClassImpl$Data$declaredNonStaticMembers$2("phone", p0);
                    AuthRequest KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (IPConfiguration.Companion.MyBillsEntityDataFactory().getOnBoardingScenario != null) {
                        Boolean bool = IPConfiguration.Companion.MyBillsEntityDataFactory().getOnBoardingScenario;
                        if (bool == null) {
                            Intrinsics.throwNpe();
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = bool.booleanValue();
                    }
                    internalService.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                } else {
                    exc = new Exception("phoneNumber parameter cannot be empty");
                }
                i = 1003;
            }
            internalService.PlaceComponentResult(exc, i);
        }

        public static final /* synthetic */ void MyBillsEntityDataFactory(String str, String str2) {
            try {
                IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
                String str3 = IPConfiguration.Companion.MyBillsEntityDataFactory().VerifyPinStateManager$executeRiskChallenge$2$1;
                if (str.length() > 1000) {
                    str = str.substring(0, 1000);
                    Intrinsics.checkExpressionValueIsNotNull(str, "");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state=");
                sb.append(str3);
                sb.append(";error_description=");
                sb.append(str);
                sb.append(";error_code=");
                sb.append((Object) str2);
                sb.append(';');
                String obj = sb.toString();
                new SubmitErrorService();
                SubmitErrorService.getAuthRequestContext(obj);
            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        }
    }
}
