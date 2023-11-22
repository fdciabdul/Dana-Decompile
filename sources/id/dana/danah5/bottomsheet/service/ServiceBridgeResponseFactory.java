package id.dana.danah5.bottomsheet.service;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/danah5/bottomsheet/service/ServiceBridgeResponseFactory;", "", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeResponse;", "FAIL_FETCH_AUTH_CODE$delegate", "Lkotlin/Lazy;", "getFAIL_FETCH_AUTH_CODE", "()Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeResponse;", "FAIL_FETCH_AUTH_CODE", "FAIL_FETCH_SERVICES$delegate", "getFAIL_FETCH_SERVICES", "FAIL_FETCH_SERVICES", "USER_CANCEL$delegate", "getUSER_CANCEL", "USER_CANCEL", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ServiceBridgeResponseFactory {
    public static final ServiceBridgeResponseFactory INSTANCE = new ServiceBridgeResponseFactory();

    /* renamed from: USER_CANCEL$delegate  reason: from kotlin metadata */
    private static final Lazy USER_CANCEL = LazyKt.lazy(new Function0<BridgeResponse.Error>() { // from class: id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory$USER_CANCEL$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BridgeResponse.Error invoke() {
            return BridgeResponse.newError(11, "user cancel");
        }
    });

    /* renamed from: FAIL_FETCH_AUTH_CODE$delegate  reason: from kotlin metadata */
    private static final Lazy FAIL_FETCH_AUTH_CODE = LazyKt.lazy(new Function0<BridgeResponse.Error>() { // from class: id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory$FAIL_FETCH_AUTH_CODE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BridgeResponse.Error invoke() {
            return BridgeResponse.newError(12, "fail fetch auth code");
        }
    });

    /* renamed from: FAIL_FETCH_SERVICES$delegate  reason: from kotlin metadata */
    private static final Lazy FAIL_FETCH_SERVICES = LazyKt.lazy(new Function0<BridgeResponse.Error>() { // from class: id.dana.danah5.bottomsheet.service.ServiceBridgeResponseFactory$FAIL_FETCH_SERVICES$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BridgeResponse.Error invoke() {
            return BridgeResponse.newError(13, "fail fetch services or services is empty");
        }
    });

    private ServiceBridgeResponseFactory() {
    }

    @JvmName(name = "getUSER_CANCEL")
    public final BridgeResponse getUSER_CANCEL() {
        Object value = USER_CANCEL.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (BridgeResponse) value;
    }

    @JvmName(name = "getFAIL_FETCH_AUTH_CODE")
    public final BridgeResponse getFAIL_FETCH_AUTH_CODE() {
        Object value = FAIL_FETCH_AUTH_CODE.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (BridgeResponse) value;
    }

    @JvmName(name = "getFAIL_FETCH_SERVICES")
    public final BridgeResponse getFAIL_FETCH_SERVICES() {
        Object value = FAIL_FETCH_SERVICES.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (BridgeResponse) value;
    }
}
