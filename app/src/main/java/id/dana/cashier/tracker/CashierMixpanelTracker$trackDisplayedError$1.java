package id.dana.cashier.tracker;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.network.exception.NetworkException;
import id.dana.tracker.EventTrackerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/tracker/EventTrackerModel$Builder;", "", BridgeDSL.INVOKE, "(Lid/dana/tracker/EventTrackerModel$Builder;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class CashierMixpanelTracker$trackDisplayedError$1 extends Lambda implements Function1<EventTrackerModel.Builder, Unit> {
    final /* synthetic */ String $$displayedMessage;
    final /* synthetic */ String $$operationType;
    final /* synthetic */ String $$source;
    final /* synthetic */ Throwable $$throwable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CashierMixpanelTracker$trackDisplayedError$1(String str, String str2, Throwable th, String str3) {
        super(1);
        this.$$source = str;
        this.$$displayedMessage = str2;
        this.$$throwable = th;
        this.$$operationType = str3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
        invoke2(builder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EventTrackerModel.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        builder.MyBillsEntityDataFactory = "Displayed Error";
        builder.MyBillsEntityDataFactory("Source", this.$$source);
        builder.MyBillsEntityDataFactory("Displayed Message", this.$$displayedMessage);
        Throwable th = this.$$throwable;
        if (th instanceof NetworkException) {
            String errorCode = ((NetworkException) th).getErrorCode();
            if (errorCode == null) {
                errorCode = "";
            }
            builder.MyBillsEntityDataFactory("Error Code", errorCode);
            String traceId = ((NetworkException) this.$$throwable).getTraceId();
            if (traceId == null) {
                traceId = "";
            }
            builder.MyBillsEntityDataFactory("Trace ID", traceId);
        }
        builder.MyBillsEntityDataFactory("Operation Type", this.$$operationType);
        String message = this.$$throwable.getMessage();
        builder.MyBillsEntityDataFactory("Error Message", message != null ? message : "");
    }
}
