package id.dana.miniprogram.tracker;

import android.content.Context;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import id.dana.data.foundation.RpcException;
import id.dana.network.exception.NetworkException;
import id.dana.tracker.mixpanel.MixPanelTracker;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/miniprogram/tracker/MiniProgramTracker;", "", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "p3", "p4", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", Condition.TYPE_OPERATION_TYPE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MiniProgramTracker {
    public static final MiniProgramTracker INSTANCE = new MiniProgramTracker();

    private MiniProgramTracker() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/miniprogram/tracker/MiniProgramTracker$OperationType;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OperationType {
        public static final OperationType INSTANCE = new OperationType();

        private OperationType() {
        }
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context p0, Throwable p1, String p2, String p3, String p4) {
        Triple triple;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        if (p1 instanceof NetworkException) {
            NetworkException networkException = (NetworkException) p1;
            String errorCode = networkException.getErrorCode();
            String message = p1.getMessage();
            triple = new Triple(errorCode, message != null ? message : "Unknown", networkException.getTraceId());
        } else if (p1 instanceof RpcException) {
            RpcException rpcException = (RpcException) p1;
            triple = new Triple(rpcException.code, rpcException.msg, "-1");
        } else {
            String message2 = p1.getMessage();
            triple = new Triple("-1", message2 != null ? message2 : "Unknown", "-1");
        }
        String str = (String) triple.component1();
        String str2 = (String) triple.component2();
        String str3 = (String) triple.component3();
        StringBuilder sb = new StringBuilder();
        sb.append("MP_");
        sb.append(p4);
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(p0, str, p2, str2, p3, sb.toString(), str3);
    }
}
