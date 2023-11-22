package id.dana.cashier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import dagger.Lazy;
import id.dana.cashier.helper.CashierInitParamHelper;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.utils.CashierTimerType;
import id.dana.danah5.DanaH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import id.dana.domain.featureconfig.model.CashierNativeConfig;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.pay.PayActivity;
import id.dana.pay.model.PayActivityListenerModel;
import id.dana.pay.model.PayResultEmoneyBannerListenerModel;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010\u0002\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u001cH\u0002J\u001c\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0015H\u0002J8\u0010*\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0010\u001a\u00020\u0011J:\u0010*\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J*\u0010*\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0010\u001a\u00020\u0011JV\u0010*\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\u0018\u0010.\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\b\u00104\u001a\u00020\u001cH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lid/dana/cashier/CashierEventHandler;", "", "getCashierNativeConfig", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/GetCashierNativeConfig;", "(Ldagger/Lazy;)V", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "cashierNativeConfig", "Lid/dana/domain/featureconfig/model/CashierNativeConfig;", HummerConstants.CONTEXT, "Landroid/content/Context;", "h5Listener", "Lid/dana/utils/danah5/DanaH5Listener;", "isReturnHome", "", "page", "Lcom/alibaba/ariver/app/api/Page;", "screenOrientation", "", "source", "timerDuration", "", "timerType", "url", "checkIfCashierNativeEnableForInnovation", "", CashierKeyParams.CASHIER_ORDER_ID, "reloadRequest", "checkIfInnovationFeature", "checkMerchantWhitelist", "createCashierEventListener", "Lid/dana/cashier/CashierEventListener;", "disposeAllUsecase", "isDanaKagetUrl", "onCashierNativeEnable", "onMerchantWhitelistEnabled", "whitelistConfig", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "mid", "openCashier", "openH5Cashier", "openFromSuccess", "openNativeCashier", "openNativeCashierWithCashierOrderId", "openNativeCashierWithIntent", "intent", "Landroid/content/Intent;", "resetCashierVisibility", "sendBridgeResponseFailed", "sendBridgeResponseSuccess", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierEventHandler {
    public static final Companion BuiltInFictitiousFunctionClassFactory = new Companion(null);
    private long DatabaseTableConfigUtil;
    private Page GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    private DanaH5Listener NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public boolean PlaceComponentResult;
    public Context getAuthRequestContext;
    private CashierNativeConfig getErrorConfigVersion;
    private String initRecordTimeStamp;
    private BridgeCallback lookAheadTest;
    private Activity moveToNextValue;
    private final Lazy<GetCashierNativeConfig> scheduleImpl;

    @Inject
    public CashierEventHandler(Lazy<GetCashierNativeConfig> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.scheduleImpl = lazy;
        this.PlaceComponentResult = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "portrait";
        this.initRecordTimeStamp = "";
    }

    public final void BuiltInFictitiousFunctionClassFactory(Activity activity, String str, DanaH5Listener danaH5Listener, String str2) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.moveToNextValue = activity;
        this.MyBillsEntityDataFactory = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = danaH5Listener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = true;
        PlaceComponentResult();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Page page, String str, BridgeCallback bridgeCallback, String str2, String str3, boolean z, String str4, long j) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.GetContactSyncConfig = page;
        this.moveToNextValue = BridgeExtensionExtKt.getActivity(page);
        this.MyBillsEntityDataFactory = StringsKt.replace$default(str, "&amp;", ContainerUtils.FIELD_DELIMITER, false, 4, (Object) null);
        this.lookAheadTest = bridgeCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str3;
        this.PlaceComponentResult = z;
        this.initRecordTimeStamp = str4;
        this.DatabaseTableConfigUtil = j;
        PlaceComponentResult();
    }

    public final void PlaceComponentResult() {
        CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
        String str = this.MyBillsEntityDataFactory;
        if (str == null) {
            str = "";
        }
        if (CashierInitParamHelper.lookAheadTest(str)) {
            KClassImpl$Data$declaredNonStaticMembers$2(true);
            BuiltInFictitiousFunctionClassFactory();
            return;
        }
        this.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1<CashierNativeConfig, Unit>() { // from class: id.dana.cashier.CashierEventHandler$getCashierNativeConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierNativeConfig cashierNativeConfig) {
                invoke2(cashierNativeConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierNativeConfig cashierNativeConfig) {
                Intrinsics.checkNotNullParameter(cashierNativeConfig, "");
                CashierEventHandler.this.getErrorConfigVersion = cashierNativeConfig;
                if (!cashierNativeConfig.isCashierNativeEnable()) {
                    CashierEventHandler.this.KClassImpl$Data$declaredNonStaticMembers$2(true);
                } else {
                    CashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2(CashierEventHandler.this);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.CashierEventHandler$getCashierNativeConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                CashierEventHandler.this.KClassImpl$Data$declaredNonStaticMembers$2(false);
                CashierEventHandler.this.scheduleImpl.get().dispose();
                StringBuilder sb = new StringBuilder();
                sb.append("[GetCashierNativeConfig]: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Activity activity = this.moveToNextValue;
        Context context = activity != null ? activity : this.getAuthRequestContext;
        if (context != null) {
            PayActivity.Companion companion = PayActivity.INSTANCE;
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            String str2 = this.MyBillsEntityDataFactory;
            String str3 = str2 == null ? "" : str2;
            CashierNativeConfig cashierNativeConfig = this.getErrorConfigVersion;
            if (cashierNativeConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierNativeConfig = null;
            }
            PlaceComponentResult(PayActivity.Companion.PlaceComponentResult(context, str, true, str3, cashierNativeConfig.isCustomKeyboardEnable(), null, null, null, null, this.PlaceComponentResult, new PayActivityListenerModel(this.NetworkUserEntityData$$ExternalSyntheticLambda0, new CashierEventListener() { // from class: id.dana.cashier.CashierEventHandler$createCashierEventListener$1
                @Override // id.dana.cashier.CashierEventListener
                public final void PlaceComponentResult(String p0, PayResultEmoneyBannerListenerModel p1) {
                    BridgeCallback bridgeCallback;
                    Intrinsics.checkNotNullParameter(p0, "");
                    bridgeCallback = CashierEventHandler.this.lookAheadTest;
                    if (bridgeCallback != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("success", (Object) Boolean.TRUE);
                        jSONObject.put("resultCode", (Object) p0);
                        if (p1 != null && p1.getMyBillsEntityDataFactory()) {
                            jSONObject.put("nfcAvailability", (Object) Boolean.valueOf(p1.getBuiltInFictitiousFunctionClassFactory()));
                        }
                        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
                    }
                }

                @Override // id.dana.cashier.CashierEventListener
                public final void PlaceComponentResult(String p0, long p1, boolean p2) {
                    BridgeCallback bridgeCallback;
                    Intrinsics.checkNotNullParameter(p0, "");
                    bridgeCallback = CashierEventHandler.this.lookAheadTest;
                    if (bridgeCallback != null) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = jSONObject;
                        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
                        if (Intrinsics.areEqual(p0, CashierTimerType.DANA_KAGET_SHARE_PAGE_TIMER)) {
                            String upperCase = "success".toUpperCase();
                            Intrinsics.checkNotNullExpressionValue(upperCase, "");
                            jSONObject2.put((JSONObject) "resultCode", upperCase);
                        }
                        jSONObject2.put((JSONObject) "timerType", p0);
                        jSONObject2.put((JSONObject) "timerDuration", (String) Long.valueOf(p1));
                        jSONObject2.put((JSONObject) "isTimerFinish", (String) Boolean.valueOf(p2));
                        bridgeCallback.sendJSONResponse(jSONObject);
                    }
                }
            }), this.initRecordTimeStamp, this.DatabaseTableConfigUtil, null, 480));
        }
    }

    private final void PlaceComponentResult(Intent intent) {
        getAuthRequestContext();
        if (this.moveToNextValue == null) {
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        PayActivity.Companion companion = PayActivity.INSTANCE;
        if (!PayActivity.Companion.MyBillsEntityDataFactory()) {
            Activity activity = this.moveToNextValue;
            Activity activity2 = activity != null ? activity : this.getAuthRequestContext;
            if (activity2 != null) {
                Page page = this.GetContactSyncConfig;
                if (page != null) {
                    page.resume();
                }
                activity2.startActivity(intent);
            }
        }
        this.scheduleImpl.get().dispose();
    }

    private final void getAuthRequestContext() {
        String str = this.MyBillsEntityDataFactory;
        boolean z = false;
        if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "epAddonId", false, 2, (Object) null)) {
            z = true;
        }
        if (z) {
            PayActivity.Companion companion = PayActivity.INSTANCE;
            PayActivity.Companion.PlaceComponentResult();
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        BridgeCallback bridgeCallback = this.lookAheadTest;
        if (bridgeCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
        }
    }

    private final void MyBillsEntityDataFactory() {
        BridgeCallback bridgeCallback = this.lookAheadTest;
        if (bridgeCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.FALSE);
            bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (z) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            MyBillsEntityDataFactory();
        }
        String str = this.MyBillsEntityDataFactory;
        if (str == null) {
            str = "";
        }
        DanaH5.startContainerFullUrl(str, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.scheduleImpl.get().dispose();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/CashierEventHandler$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        return Intrinsics.areEqual(parse.getQueryParameter("bizOrderType"), "GROUP_LUCKY_MONEY");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierEventHandler cashierEventHandler) {
        CashierNativeConfig cashierNativeConfig = null;
        if (DeepLinkParser.moveToNextValue()) {
            CashierNativeConfig cashierNativeConfig2 = cashierEventHandler.getErrorConfigVersion;
            if (cashierNativeConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                cashierNativeConfig = cashierNativeConfig2;
            }
            if (cashierNativeConfig.isDeeplinkKybEnable()) {
                cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            } else {
                cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2(true);
                return;
            }
        }
        CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
        String str = cashierEventHandler.MyBillsEntityDataFactory;
        if (str == null) {
            str = "";
        }
        Pair<String, String> PlaceComponentResult = CashierInitParamHelper.PlaceComponentResult(str);
        if (PlaceComponentResult.getFirst().length() > 0) {
            if (PlaceComponentResult.getSecond().length() > 0) {
                String first = PlaceComponentResult.getFirst();
                String second = PlaceComponentResult.getSecond();
                CashierNativeConfig cashierNativeConfig3 = cashierEventHandler.getErrorConfigVersion;
                if (cashierNativeConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    cashierNativeConfig = cashierNativeConfig3;
                }
                List<String> cashierNativeEntryPoints = cashierNativeConfig.getCashierNativeEntryPoints();
                String lowerCase = "innovation".toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                if (!cashierNativeEntryPoints.contains(lowerCase)) {
                    cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2(true);
                    return;
                }
                Activity activity = cashierEventHandler.moveToNextValue;
                Context context = activity != null ? activity : cashierEventHandler.getAuthRequestContext;
                if (context != null) {
                    PayActivity.Companion companion = PayActivity.INSTANCE;
                    cashierEventHandler.PlaceComponentResult(PayActivity.Companion.PlaceComponentResult(context, first, null, null, null, null, second, null, cashierEventHandler.initRecordTimeStamp, cashierEventHandler.DatabaseTableConfigUtil, null));
                    return;
                }
                return;
            }
        }
        CashierNativeConfig cashierNativeConfig4 = cashierEventHandler.getErrorConfigVersion;
        if (cashierNativeConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            cashierNativeConfig = cashierNativeConfig4;
        }
        CashierMerchantWhitelistConfig merchantWhitelistConfig = cashierNativeConfig.getMerchantWhitelistConfig();
        if (!merchantWhitelistConfig.isEnabled()) {
            String str2 = cashierEventHandler.MyBillsEntityDataFactory;
            if (str2 == null) {
                str2 = "";
            }
            if (!KClassImpl$Data$declaredNonStaticMembers$2(str2)) {
                cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2(true);
                return;
            }
        }
        CashierInitParamHelper cashierInitParamHelper2 = CashierInitParamHelper.INSTANCE;
        String str3 = cashierEventHandler.MyBillsEntityDataFactory;
        if (str3 == null) {
            str3 = "";
        }
        if (!merchantWhitelistConfig.checkIfMidWhitelisted(CashierInitParamHelper.NetworkUserEntityData$$ExternalSyntheticLambda0(str3))) {
            String str4 = cashierEventHandler.MyBillsEntityDataFactory;
            if (!KClassImpl$Data$declaredNonStaticMembers$2(str4 != null ? str4 : "")) {
                cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2(true);
                return;
            }
        }
        cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
