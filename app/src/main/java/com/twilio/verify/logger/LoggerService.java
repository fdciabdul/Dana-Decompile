package com.twilio.verify.logger;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b"}, d2 = {"Lcom/twilio/verify/logger/LoggerService;", "", "Lcom/twilio/verify/logger/LogLevel;", "p0", "", "p1", "", "p2", "", "getAuthRequestContext", "(Lcom/twilio/verify/logger/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "()Lcom/twilio/verify/logger/LogLevel;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public interface LoggerService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
    /* loaded from: classes8.dex */
    public static final class DefaultImpls {
    }

    @JvmName(name = "getAuthRequestContext")
    LogLevel getAuthRequestContext();

    void getAuthRequestContext(LogLevel p0, String p1, Throwable p2);
}
