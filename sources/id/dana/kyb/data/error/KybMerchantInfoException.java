package id.dana.kyb.data.error;

import id.dana.network.exception.NetworkException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/kyb/data/error/KybMerchantInfoException;", "Lid/dana/network/exception/NetworkException;", "", "errorCode", "errorMessage", "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybMerchantInfoException extends NetworkException {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ KybMerchantInfoException(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private KybMerchantInfoException(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r0 = new com.alipayplus.mobile.component.domain.model.result.BaseRpcResult
            r0.<init>()
            r0.errorCode = r2
            r0.errorMessage = r3
            r0.traceId = r4
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.data.error.KybMerchantInfoException.<init>(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/data/error/KybMerchantInfoException$Companion;", "", "Lid/dana/network/exception/NetworkException;", "p0", "Lid/dana/kyb/data/error/KybMerchantInfoException;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/network/exception/NetworkException;)Lid/dana/kyb/data/error/KybMerchantInfoException;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static KybMerchantInfoException KClassImpl$Data$declaredNonStaticMembers$2(NetworkException p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String errorCode = p0.getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            String message = p0.getMessage();
            String traceId = p0.getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceId, "");
            return new KybMerchantInfoException(errorCode, message, traceId, null);
        }
    }
}
