package id.dana.danah5.share.directtext;

import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danah5/share/directtext/ShareDirectTextResultFactory;", "", "", "errorType", "Lcom/alibaba/fastjson/JSONObject;", "getResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "<init>", "()V", BehaviorLogger.Key.ERROR_CODE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareDirectTextResultFactory {
    public static final ShareDirectTextResultFactory INSTANCE = new ShareDirectTextResultFactory();

    private ShareDirectTextResultFactory() {
    }

    public final JSONObject getResult(String errorType) {
        String str;
        if (Intrinsics.areEqual(errorType, "SUCCESS")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        jSONObject3.put((JSONObject) "success", (String) Boolean.FALSE);
        if (Intrinsics.areEqual(errorType, "NO_MESSAGE")) {
            str = "003";
        } else {
            str = Intrinsics.areEqual(errorType, "APPLICATION_NOT_FOUND") ? "004" : "001";
        }
        jSONObject3.put((JSONObject) "error", str);
        return jSONObject2;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/danah5/share/directtext/ShareDirectTextResultFactory$ErrorCode;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    @interface ErrorCode {
        public static final String APPLICATION_NOT_FOUND = "004";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String ERROR_CODE_NO_MESSAGE = "003";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/danah5/share/directtext/ShareDirectTextResultFactory$ErrorCode$Companion;", "", "", "APPLICATION_NOT_FOUND", "Ljava/lang/String;", "ERROR_CODE_NO_MESSAGE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String APPLICATION_NOT_FOUND = "004";
            public static final String ERROR_CODE_NO_MESSAGE = "003";

            private Companion() {
            }
        }
    }
}
