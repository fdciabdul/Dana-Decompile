package com.twilio.verify.logger;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010"}, d2 = {"Lcom/twilio/verify/logger/DefaultLoggerService;", "Lcom/twilio/verify/logger/LoggerService;", "Lcom/twilio/verify/logger/LogLevel;", "p0", "", "p1", "", "p2", "", "getAuthRequestContext", "(Lcom/twilio/verify/logger/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lcom/twilio/verify/logger/LogAdapter;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/logger/LogAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/logger/LogLevel;", "()Lcom/twilio/verify/logger/LogLevel;", "Companion"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final class DefaultLoggerService implements LoggerService {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final LogLevel getAuthRequestContext;
    private final LogAdapter MyBillsEntityDataFactory;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
    /* loaded from: classes8.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LogLevel.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            iArr[LogLevel.Error.ordinal()] = 1;
            iArr[LogLevel.Info.ordinal()] = 2;
            iArr[LogLevel.Debug.ordinal()] = 3;
        }
    }

    @Override // com.twilio.verify.logger.LoggerService
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final LogLevel getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.twilio.verify.logger.LoggerService
    public final void getAuthRequestContext(LogLevel p0, String p1, Throwable p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        if (this.getAuthRequestContext == LogLevel.All || this.getAuthRequestContext == p0) {
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
            if (i == 1) {
                this.MyBillsEntityDataFactory.getAuthRequestContext("TwilioVerify", p1, p2);
            } else if (i == 2) {
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("TwilioVerify", p1, p2);
            } else if (i == 3) {
                this.MyBillsEntityDataFactory.PlaceComponentResult("TwilioVerify", p1, p2);
            } else {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory("TwilioVerify", p1, p2);
            }
        }
    }
}
