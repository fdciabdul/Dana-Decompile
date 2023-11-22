package id.dana.danah5.bottomsheet.service;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.bottomsheet.ServicesBottomSheetDialog;
import id.dana.domain.extension.JSONArrayExtKt;
import id.dana.scanner.ScannerActivity;
import id.dana.utils.UrlUtil;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u0012*\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;", "", "", "dismissBottomSheetDialog", "()V", "", "params", "", "getListOfService", "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "showServicesBottomSheetDialog", "(Landroidx/fragment/app/FragmentActivity;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;", "addQuery", "(Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;Lcom/alibaba/fastjson/JSONObject;)Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;", "Lid/dana/bottomsheet/ServicesBottomSheetDialog;", "servicesBottomSheetDialog", "Lid/dana/bottomsheet/ServicesBottomSheetDialog;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServicesBottomSheetManager {
    public static final String DEEPLINK_QUERY_NAME = "params";
    public static final String DEFAULT_TITLE_BOTTOMSHEET_SERVICE = "Select services";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_WITH_CATEGORIES = "withCategory";
    public static final String PARAM_WITH_DEEPLINK = "withDeepLink";
    public static final String PARAM_WITH_SERVICES = "withServices";
    private ServicesBottomSheetDialog servicesBottomSheetDialog;

    public final void dismissBottomSheetDialog() {
        ServicesBottomSheetDialog servicesBottomSheetDialog = this.servicesBottomSheetDialog;
        if (servicesBottomSheetDialog == null || !servicesBottomSheetDialog.isVisible()) {
            return;
        }
        servicesBottomSheetDialog.dismissAllowingStateLoss();
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.jvm.functions.Function1, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function1] */
    public final void showServicesBottomSheetDialog(FragmentActivity fragmentActivity, JSONObject info, final BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        ServicesBottomSheetDialog servicesBottomSheetDialog = this.servicesBottomSheetDialog;
        if (servicesBottomSheetDialog != null) {
            if (!servicesBottomSheetDialog.isAdded()) {
                servicesBottomSheetDialog = null;
            }
            if (servicesBottomSheetDialog != null) {
                return;
            }
        }
        String string = info != null ? info.getString("title") : null;
        if (string == null) {
            string = DEFAULT_TITLE_BOTTOMSHEET_SERVICE;
        } else {
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        ?? r11 = 0;
        ?? r13 = 0;
        ServicesBottomSheetDialog.Builder addQuery = addQuery(new ServicesBottomSheetDialog.Builder(string, null, null, r11, null, r13, null, 126, null), info);
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager$showServicesBottomSheetDialog$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.SUCCESS);
                this.dismissBottomSheetDialog();
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        addQuery.BuiltInFictitiousFunctionClassFactory = function1;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager$showServicesBottomSheetDialog$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BridgeCallback.this.sendBridgeResponse(ServiceBridgeResponseFactory.INSTANCE.getUSER_CANCEL());
                this.dismissBottomSheetDialog();
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        addQuery.PlaceComponentResult = function0;
        Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager$showServicesBottomSheetDialog$2$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
            
                r1.sendBridgeResponse(id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory.INSTANCE.getFAIL_FETCH_SERVICES());
             */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(java.lang.String r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    int r0 = r3.hashCode()
                    r1 = -476790647(0xffffffffe394c089, float:-5.4879835E21)
                    if (r0 == r1) goto L35
                    r1 = 248045090(0xec8de22, float:4.9517713E-30)
                    if (r0 == r1) goto L21
                    r1 = 986623908(0x3aceafa4, float:0.0015768898)
                    if (r0 != r1) goto L49
                    java.lang.String r0 = "FAIL_FETCH_SERVICES"
                    boolean r3 = r3.equals(r0)
                    if (r3 != 0) goto L29
                    goto L49
                L21:
                    java.lang.String r0 = "FAIL_EMPTY_SERVICE"
                    boolean r3 = r3.equals(r0)
                    if (r3 == 0) goto L49
                L29:
                    com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r3 = com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback.this
                    id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory r0 = id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory.INSTANCE
                    com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r0 = r0.getFAIL_FETCH_SERVICES()
                    r3.sendBridgeResponse(r0)
                    goto L50
                L35:
                    java.lang.String r0 = "FAIL_DO_ACTION"
                    boolean r3 = r3.equals(r0)
                    if (r3 == 0) goto L49
                    com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r3 = com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback.this
                    id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory r0 = id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory.INSTANCE
                    com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r0 = r0.getFAIL_FETCH_AUTH_CODE()
                    r3.sendBridgeResponse(r0)
                    goto L50
                L49:
                    com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r3 = com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback.this
                    com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r0 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.UNKNOWN_ERROR
                    r3.sendBridgeResponse(r0)
                L50:
                    id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager r3 = r2
                    r3.dismissBottomSheetDialog()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager$showServicesBottomSheetDialog$2$3.invoke2(java.lang.String):void");
            }
        };
        Intrinsics.checkNotNullParameter(function12, "");
        addQuery.getAuthRequestContext = function12;
        Intrinsics.checkNotNullParameter(TrackerKey.SourceType.JS_API, "");
        addQuery.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.SourceType.JS_API;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        Intrinsics.checkNotNullParameter(supportFragmentManager, "");
        ServicesBottomSheetDialog servicesBottomSheetDialog2 = new ServicesBottomSheetDialog(new ServicesBottomSheetDialog.Builder(addQuery.lookAheadTest, addQuery.MyBillsEntityDataFactory, addQuery.moveToNextValue, addQuery.BuiltInFictitiousFunctionClassFactory, addQuery.PlaceComponentResult, addQuery.getAuthRequestContext, r11, 64, r13));
        servicesBottomSheetDialog2.show(supportFragmentManager, "SERVICE_BOTTOM_SHEET_DIALOG");
        this.servicesBottomSheetDialog = servicesBottomSheetDialog2;
        Unit unit = Unit.INSTANCE;
    }

    private final ServicesBottomSheetDialog.Builder addQuery(ServicesBottomSheetDialog.Builder builder, JSONObject jSONObject) {
        List<String> list;
        if (jSONObject != null) {
            JSONArray jSONArray = jSONObject.getJSONArray(PARAM_WITH_SERVICES);
            if (jSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(jSONArray, "");
                List<String> mutableListOfString = JSONArrayExtKt.toMutableListOfString(jSONArray);
                Intrinsics.checkNotNullParameter(ScannerActivity.SERVICE_KEY, "");
                Intrinsics.checkNotNullParameter(mutableListOfString, "");
                builder.MyBillsEntityDataFactory = ScannerActivity.SERVICE_KEY;
                builder.moveToNextValue = mutableListOfString;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(PARAM_WITH_CATEGORIES);
            if (jSONArray2 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "");
                List<String> mutableListOfString2 = JSONArrayExtKt.toMutableListOfString(jSONArray2);
                Intrinsics.checkNotNullParameter("CATEGORY_SERVICE", "");
                Intrinsics.checkNotNullParameter(mutableListOfString2, "");
                builder.MyBillsEntityDataFactory = "CATEGORY_SERVICE";
                builder.moveToNextValue = mutableListOfString2;
            }
            String string = jSONObject.getString(PARAM_WITH_DEEPLINK);
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "");
                Map<String, List<String>> PlaceComponentResult = UrlUtil.PlaceComponentResult(new URL(string));
                if (PlaceComponentResult != null && (list = PlaceComponentResult.get("params")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : list) {
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        List<String> listOfService = getListOfService(str);
                        if (listOfService != null) {
                            arrayList.addAll(listOfService);
                        }
                    }
                    Intrinsics.checkNotNullParameter(ScannerActivity.SERVICE_KEY, "");
                    Intrinsics.checkNotNullParameter(arrayList, "");
                    builder.MyBillsEntityDataFactory = ScannerActivity.SERVICE_KEY;
                    builder.moveToNextValue = arrayList;
                }
            }
        }
        return builder;
    }

    private final List<String> getListOfService(String params) {
        try {
            return UrlUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(params).get("services");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
