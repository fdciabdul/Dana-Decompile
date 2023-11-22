package id.dana.danah5.nfcutility;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.electronicmoney.interactor.GetElectronicMoneyConfig;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyConfig;
import id.dana.electronicmoney.activity.ElectronicMoneyActivity;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b0\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ7\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u001bJ#\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010(R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/"}, d2 = {"Lid/dana/danah5/nfcutility/NfcUtilityBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/nfc/NfcAdapter;", "nfcAdapter", "", "checkCardEligibility", "(Landroid/app/Activity;Landroid/nfc/NfcAdapter;)V", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.NFC_UTILITY, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onFinalized", "()V", "onInitialized", NfcUtilityBridge.CARD_TYPE, "sourceClick", "", "topUpEnable", "openBottomSheet", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sendEmptySuccessResult", "errorCode", "message", "sendErrorResult", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/domain/electronicmoney/interactor/GetElectronicMoneyConfig;", "getElectronicMoneyConfig", "Lid/dana/domain/electronicmoney/interactor/GetElectronicMoneyConfig;", "getGetElectronicMoneyConfig", "()Lid/dana/domain/electronicmoney/interactor/GetElectronicMoneyConfig;", "setGetElectronicMoneyConfig", "(Lid/dana/domain/electronicmoney/interactor/GetElectronicMoneyConfig;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NfcUtilityBridge extends BaseBridge {
    private static final String CARD_TYPE = "cardType";
    private static final String CHECK = "check";
    private static final String DEVICE = "device";
    private static final String SOURCE_CLICK = "sourceClick";
    private static final String TOPUP_ENABLE = "topUpEnable";
    private static final String WRITE = "write";
    private BridgeCallback bridgeCallback;
    @Inject
    public GetElectronicMoneyConfig getElectronicMoneyConfig;

    @JvmName(name = "getGetElectronicMoneyConfig")
    public final GetElectronicMoneyConfig getGetElectronicMoneyConfig() {
        GetElectronicMoneyConfig getElectronicMoneyConfig = this.getElectronicMoneyConfig;
        if (getElectronicMoneyConfig != null) {
            return getElectronicMoneyConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetElectronicMoneyConfig")
    public final void setGetElectronicMoneyConfig(GetElectronicMoneyConfig getElectronicMoneyConfig) {
        Intrinsics.checkNotNullParameter(getElectronicMoneyConfig, "");
        this.getElectronicMoneyConfig = getElectronicMoneyConfig;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void nfcUtility(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.bridgeCallback = bridgeCallback;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
        if (defaultAdapter == null) {
            sendErrorResult$default(this, "002", null, 2, null);
        } else if (Intrinsics.areEqual(eventName, "check")) {
            checkCardEligibility(activity, defaultAdapter);
        } else if (Intrinsics.areEqual(eventName, WRITE)) {
            openBottomSheet(activity, info != null ? info.getString(CARD_TYPE) : null, info != null ? info.getString("sourceClick") : null, info != null ? info.getBoolean("topUpEnable") : null);
        }
    }

    static /* synthetic */ void openBottomSheet$default(NfcUtilityBridge nfcUtilityBridge, Activity activity, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 8) != 0) {
            bool = Boolean.TRUE;
        }
        nfcUtilityBridge.openBottomSheet(activity, str, str2, bool);
    }

    private final void openBottomSheet(final Activity activity, final String cardType, final String sourceClick, final Boolean topUpEnable) {
        getGetElectronicMoneyConfig().execute(NoParams.INSTANCE, new Function1<Map<String, ? extends ElectronicMoneyConfig>, Unit>() { // from class: id.dana.danah5.nfcutility.NfcUtilityBridge$openBottomSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends ElectronicMoneyConfig> map) {
                invoke2((Map<String, ElectronicMoneyConfig>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, ElectronicMoneyConfig> map) {
                Intrinsics.checkNotNullParameter(map, "");
                Set<Map.Entry<String, ElectronicMoneyConfig>> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Object obj : entrySet) {
                    if (((ElectronicMoneyConfig) ((Map.Entry) obj).getValue()).getEnable()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add((String) ((Map.Entry) it.next()).getKey());
                }
                Object[] array = arrayList3.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length == 0) {
                        NfcUtilityBridge.this.sendErrorResult("001", "No active electronic money found");
                        return;
                    }
                    String str = cardType;
                    if (!(str == null || str.length() == 0) && ArraysKt.contains(strArr, cardType)) {
                        Intent putExtra = new Intent(activity, ElectronicMoneyActivity.class).putExtra(ElectronicMoneyActivity.EXTRA_REQUESTED_CARD_TYPE, cardType).putExtra(ElectronicMoneyActivity.EXTRA_ACTIVE_ELECTRONIC_MONEYS, strArr).putExtra(ElectronicMoneyActivity.EXTRA_SOURCE_CLICK, sourceClick).putExtra(ElectronicMoneyActivity.EXTRA_TOPUP_ENABLE, topUpEnable).putExtra("android.nfc.extra.TAG", activity.getIntent().getParcelableExtra("android.nfc.extra.TAG"));
                        Intrinsics.checkNotNullExpressionValue(putExtra, "");
                        BaseBridge.startActivityForResult$default(NfcUtilityBridge.this, activity, putExtra, 0, 4, null);
                        activity.getIntent().replaceExtras(new Intent());
                        return;
                    }
                    NfcUtilityBridge nfcUtilityBridge = NfcUtilityBridge.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Card type '");
                    sb.append(cardType);
                    sb.append("' is disabled or not recognized");
                    nfcUtilityBridge.sendErrorResult("001", sb.toString());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.nfcutility.NfcUtilityBridge$openBottomSheet$2
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
                NfcUtilityBridge.sendErrorResult$default(NfcUtilityBridge.this, "001", null, 2, null);
            }
        });
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        BridgeCallback bridgeCallback = null;
        String stringExtra = data != null ? data.getStringExtra(ElectronicMoneyActivity.EXTRA_CARD_NUMBER) : null;
        String str = stringExtra;
        if (str == null || str.length() == 0) {
            return;
        }
        BridgeCallback bridgeCallback2 = this.bridgeCallback;
        if (bridgeCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bridgeCallback = bridgeCallback2;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("cardNumber", (Object) stringExtra);
        jSONObject2.put((JSONObject) "electronicMoneyInfo", (String) jSONObject3);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void checkCardEligibility(final Activity activity, NfcAdapter nfcAdapter) {
        if (nfcAdapter.isEnabled()) {
            sendEmptySuccessResult();
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: id.dana.danah5.nfcutility.NfcUtilityBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NfcUtilityBridge.m706checkCardEligibility$lambda3$lambda2(activity);
            }
        });
        sendErrorResult$default(this, "003", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkCardEligibility$lambda-3$lambda-2  reason: not valid java name */
    public static final void m706checkCardEligibility$lambda3$lambda2(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(activity);
        builder.SubSequence = activity.getString(R.string.activate_nfc_title);
        builder.GetContactSyncConfig = activity.getString(R.string.activate_nfc_message);
        builder.moveToNextValue = 0L;
        builder.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(activity.getString(R.string.activate_nfc), new Function1<View, Unit>() { // from class: id.dana.danah5.nfcutility.NfcUtilityBridge$checkCardEligibility$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                activity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(activity.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.danah5.nfcutility.NfcUtilityBridge$checkCardEligibility$1$1$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void sendErrorResult$default(NfcUtilityBridge nfcUtilityBridge, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        nfcUtilityBridge.sendErrorResult(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendErrorResult(String errorCode, String message) {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", errorCode);
        jSONObject2.put((JSONObject) "errorMessage", message);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void sendEmptySuccessResult() {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getGetElectronicMoneyConfig().dispose();
    }
}
