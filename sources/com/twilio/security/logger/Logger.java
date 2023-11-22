package com.twilio.security.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/twilio/security/logger/Logger;", "", "()V", "loggerContract", "Lcom/twilio/security/logger/LoggerContract;", "getLoggerContract", "()Lcom/twilio/security/logger/LoggerContract;", "setLoggerContract", "(Lcom/twilio/security/logger/LoggerContract;)V", "log", "", "logLevel", "Lcom/twilio/security/logger/Level;", "message", "", "throwable", "", "security_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class Logger {
    private static LoggerContract BuiltInFictitiousFunctionClassFactory;
    public static final Logger PlaceComponentResult = new Logger();

    private Logger() {
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Level level, String str) {
        Intrinsics.checkParameterIsNotNull(level, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        LoggerContract loggerContract = BuiltInFictitiousFunctionClassFactory;
        if (loggerContract != null) {
            loggerContract.KClassImpl$Data$declaredNonStaticMembers$2(level, str, null);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Level level, String str, Throwable th) {
        Intrinsics.checkParameterIsNotNull(level, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        LoggerContract loggerContract = BuiltInFictitiousFunctionClassFactory;
        if (loggerContract != null) {
            loggerContract.KClassImpl$Data$declaredNonStaticMembers$2(level, str, th);
        }
    }
}
