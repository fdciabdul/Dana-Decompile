package id.dana.backgroundwork;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.backgroundwork.DeviceStatsReportWorker", f = "DeviceStatsReportWorker.kt", i = {}, l = {24}, m = "doWork", n = {}, s = {})
/* loaded from: classes.dex */
final class DeviceStatsReportWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceStatsReportWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceStatsReportWorker$doWork$1(DeviceStatsReportWorker deviceStatsReportWorker, Continuation<? super DeviceStatsReportWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = deviceStatsReportWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }
}
