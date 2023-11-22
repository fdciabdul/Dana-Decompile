package com.twilio.verify.logger;

import com.fullstory.instrumentation.InstrumentInjector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ)\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ)\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\t"}, d2 = {"Lcom/twilio/verify/logger/LogWrapper;", "Lcom/twilio/verify/logger/LogAdapter;", "", "p0", "p1", "", "p2", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final class LogWrapper implements LogAdapter {
    public static final LogWrapper INSTANCE = new LogWrapper();

    private LogWrapper() {
    }

    @Override // com.twilio.verify.logger.LogAdapter
    public final void getAuthRequestContext(String p0, String p1, Throwable p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        InstrumentInjector.log_e(p0, p1, p2);
    }

    @Override // com.twilio.verify.logger.LogAdapter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, Throwable p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        InstrumentInjector.log_i(p0, p1, p2);
    }

    @Override // com.twilio.verify.logger.LogAdapter
    public final void PlaceComponentResult(String p0, String p1, Throwable p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        InstrumentInjector.log_d(p0, p1, p2);
    }

    @Override // com.twilio.verify.logger.LogAdapter
    public final void MyBillsEntityDataFactory(String p0, String p1, Throwable p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        InstrumentInjector.log_v(p0, p1, p2);
    }
}
