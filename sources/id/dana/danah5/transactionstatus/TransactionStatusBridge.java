package id.dana.danah5.transactionstatus;

import android.os.CountDownTimer;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.base.BaseBridgeExtension;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.notification.TransactionDetailNotificationBus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\n\u001a\u00020\r2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\n\u0010\u0015R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a"}, d2 = {"Lid/dana/danah5/transactionstatus/TransactionStatusBridge;", "Lid/dana/danah5/base/BaseBridgeExtension;", "", Companion.TransactionStatusParamKey.TRANSACTION_ID, "", "errorCode", "Lcom/alibaba/fastjson/JSONObject;", "getFailedResult", "(Ljava/lang/String;I)Lcom/alibaba/fastjson/JSONObject;", "", "transactionStatus", "getSuccessResult", "(Ljava/lang/String;Z)Lcom/alibaba/fastjson/JSONObject;", "", "startListenToPushNotification", "(Ljava/lang/String;)V", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/danah5/transactionstatus/TransactionStatusBridge$timer$1;", "timer", "Lid/dana/danah5/transactionstatus/TransactionStatusBridge$timer$1;", "Ljava/lang/String;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransactionStatusBridge extends BaseBridgeExtension {
    public static final int ERROR_EMPTY_TRANSACTION_ID = 1;
    public static final int ERROR_TIMEOUT = 2;
    private BridgeCallback bridgeCallback;
    private final TransactionStatusBridge$timer$1 timer = new CountDownTimer() { // from class: id.dana.danah5.transactionstatus.TransactionStatusBridge$timer$1
        @Override // android.os.CountDownTimer
        public final void onTick(long millisUntilFinished) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(2000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            BridgeCallback bridgeCallback;
            String str;
            JSONObject failedResult;
            bridgeCallback = TransactionStatusBridge.this.bridgeCallback;
            String str2 = null;
            if (bridgeCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback = null;
            }
            TransactionStatusBridge transactionStatusBridge = TransactionStatusBridge.this;
            str = transactionStatusBridge.transactionId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str2 = str;
            }
            failedResult = transactionStatusBridge.getFailedResult(str2, 2);
            bridgeCallback.sendJSONResponse(failedResult);
        }
    };
    private String transactionId;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void transactionStatus(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        String str = null;
        String string = info != null ? info.getString(Companion.TransactionStatusParamKey.TRANSACTION_ID) : null;
        if (string == null) {
            string = "";
        }
        this.transactionId = string;
        if (BridgeExtensionExtKt.getActivity(page) != null) {
            String str2 = this.transactionId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                str = str2;
            }
            startListenToPushNotification(str);
        }
    }

    private final void startListenToPushNotification(final String transactionId) {
        if (transactionId.length() > 0) {
            start();
            addDisposable(TransactionDetailNotificationBus.PlaceComponentResult(new Function1<TransactionDetailNotificationBus.TransactionDetailInfo, Unit>() { // from class: id.dana.danah5.transactionstatus.TransactionStatusBridge$startListenToPushNotification$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TransactionDetailNotificationBus.TransactionDetailInfo transactionDetailInfo) {
                    invoke2(transactionDetailInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TransactionDetailNotificationBus.TransactionDetailInfo transactionDetailInfo) {
                    TransactionStatusBridge$timer$1 transactionStatusBridge$timer$1;
                    BridgeCallback bridgeCallback;
                    JSONObject successResult;
                    BridgeCallback bridgeCallback2;
                    JSONObject failedResult;
                    Intrinsics.checkNotNullParameter(transactionDetailInfo, "");
                    transactionStatusBridge$timer$1 = TransactionStatusBridge.this.timer;
                    transactionStatusBridge$timer$1.cancel();
                    String str = transactionDetailInfo.BuiltInFictitiousFunctionClassFactory;
                    if (str == null) {
                        str = "";
                    }
                    boolean areEqual = Intrinsics.areEqual(transactionDetailInfo.getAuthRequestContext, "BIZ_ORDER_SUCCESS");
                    BridgeCallback bridgeCallback3 = null;
                    if (str.length() == 0) {
                        bridgeCallback2 = TransactionStatusBridge.this.bridgeCallback;
                        if (bridgeCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bridgeCallback3 = bridgeCallback2;
                        }
                        failedResult = TransactionStatusBridge.this.getFailedResult(transactionId, 1);
                        bridgeCallback3.sendJSONResponse(failedResult);
                    } else if (Intrinsics.areEqual(transactionId, str)) {
                        bridgeCallback = TransactionStatusBridge.this.bridgeCallback;
                        if (bridgeCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bridgeCallback3 = bridgeCallback;
                        }
                        successResult = TransactionStatusBridge.this.getSuccessResult(str, areEqual);
                        bridgeCallback3.sendJSONResponse(successResult);
                    }
                }
            }));
            return;
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        bridgeCallback.sendJSONResponse(getFailedResult(transactionId, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getSuccessResult(String transactionId, boolean transactionStatus) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        jSONObject2.put((JSONObject) Companion.TransactionStatusParamKey.TRANSACTION_ID, transactionId);
        jSONObject2.put((JSONObject) "transactionStatus", (String) Boolean.valueOf(transactionStatus));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getFailedResult(String transactionId, int errorCode) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "errorCode", (String) Integer.valueOf(errorCode));
        jSONObject2.put((JSONObject) Companion.TransactionStatusParamKey.TRANSACTION_ID, transactionId);
        return jSONObject;
    }
}
