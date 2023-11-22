package id.dana.danah5.ocrreceipt;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u0019\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001a8\u0005X\u0084\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/danah5/ocrreceipt/BaseOCRBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/fastjson/JSONObject;", "info", "", "isBackgroundProcess", "Lid/dana/ocr/model/OCRRequestModel;", "createNewOCRRequestModel", "(Lcom/alibaba/fastjson/JSONObject;Z)Lid/dana/ocr/model/OCRRequestModel;", "", "getRules", "(Lcom/alibaba/fastjson/JSONObject;)Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "handleOCRReceipt", "(Landroid/app/Activity;ZLcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lcom/alibaba/ariver/app/api/Page;", "page", "handleOnMethodCalled", "(Lcom/alibaba/fastjson/JSONObject;ZLcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "tryUploadOCRReceipt", "Lid/dana/danah5/ocrreceipt/OCRReceiptManager;", "ocrReceiptManager", "Lid/dana/danah5/ocrreceipt/OCRReceiptManager;", "getOcrReceiptManager", "()Lid/dana/danah5/ocrreceipt/OCRReceiptManager;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseOCRBridge extends BaseBridge {
    public static final String EVENT_PARAM_IS_NULL = "event param is null";
    private static final String INFO_KEY_MERCHANT_ALIAS = "merchantNameAlias";
    private static final String INFO_KEY_MERCHANT_ID = "merchantId";
    private static final String INFO_KEY_RULES = "rules";
    private static final String INFO_KEY_TOKEN = "token";
    private static final String INFO_KEY_USER_LOYALTY_ID = "userLoyaltyId";
    private final OCRReceiptManager ocrReceiptManager = new OCRReceiptManager();

    public abstract String getTag();

    public abstract void tryUploadOCRReceipt(Activity activity, boolean isBackgroundProcess, JSONObject info, BridgeCallback bridgeCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getOcrReceiptManager")
    public final OCRReceiptManager getOcrReceiptManager() {
        return this.ocrReceiptManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handleOnMethodCalled(JSONObject info, boolean isBackgroundProcess, BridgeCallback bridgeCallback, Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        JSONObject jSONObject = info;
        if (jSONObject == null || jSONObject.isEmpty()) {
            bridgeCallback.sendJSONResponse(OCRReceiptPluginResultFactory.getFailedResult("007"));
            DanaLog.BuiltInFictitiousFunctionClassFactory(getTag(), EVENT_PARAM_IS_NULL);
            return;
        }
        handleOCRReceipt(BridgeExtensionExtKt.getActivity(page), isBackgroundProcess, info, bridgeCallback);
    }

    private final void handleOCRReceipt(Activity activity, boolean isBackgroundProcess, JSONObject info, BridgeCallback bridgeCallback) {
        String str;
        String str2;
        try {
            tryUploadOCRReceipt(activity, isBackgroundProcess, info, bridgeCallback);
        } catch (IllegalStateException e) {
            if (e instanceof OCRReceiptException) {
                str = e.getMessage();
                str2 = ((OCRReceiptException) e).getEvent();
            } else {
                str = EVENT_PARAM_IS_NULL;
                str2 = "007";
            }
            DanaLog.BuiltInFictitiousFunctionClassFactory(getTag(), str);
            bridgeCallback.sendJSONResponse(OCRReceiptPluginResultFactory.getFailedResult(str2));
        }
    }

    private final String getRules(JSONObject info) {
        String string = info.getString(INFO_KEY_RULES);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final OCRRequestModel createNewOCRRequestModel(JSONObject info, boolean isBackgroundProcess) {
        Intrinsics.checkNotNullParameter(info, "");
        String string = info.getString("merchantId");
        String str = string == null ? "" : string;
        String string2 = info.getString(INFO_KEY_USER_LOYALTY_ID);
        String str2 = string2 == null ? "" : string2;
        String string3 = info.getString("token");
        String str3 = string3 == null ? "" : string3;
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = info.getJSONArray(INFO_KEY_MERCHANT_ALIAS).iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (next == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add(i, (String) next);
            i++;
        }
        OCRRequestModel oCRRequestModel = new OCRRequestModel(isBackgroundProcess, getRules(info), arrayList, str, str2, str3);
        if (oCRRequestModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
            throw new OCRReceiptException(EVENT_PARAM_IS_NULL, "007");
        }
        return oCRRequestModel;
    }
}
