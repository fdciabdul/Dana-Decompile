package com.twilio.verify.logger;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.LoggerContract;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/twilio/verify/logger/LoggerImplementation;", "Lcom/twilio/security/logger/LoggerContract;", "Lcom/twilio/verify/logger/LoggerService;", "p0", "", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/logger/LoggerService;)V", "Lcom/twilio/security/logger/Level;", "", "p1", "", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/twilio/security/logger/Level;Ljava/lang/String;Ljava/lang/Throwable;)V", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class LoggerImplementation implements LoggerContract {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public static ExecutorService BuiltInFictitiousFunctionClassFactory;
    public static final LoggerImplementation INSTANCE = new LoggerImplementation();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final List<LoggerService> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();

    static {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "");
        BuiltInFictitiousFunctionClassFactory = newFixedThreadPool;
    }

    private LoggerImplementation() {
    }

    @JvmName(name = "getAuthRequestContext")
    public static List<LoggerService> getAuthRequestContext() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static void MyBillsEntityDataFactory(LoggerService p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2.add(p0);
    }

    @Override // com.twilio.security.logger.LoggerContract
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final Level p0, final String p1, final Throwable p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: com.twilio.verify.logger.LoggerImplementation$log$1
            @Override // java.lang.Runnable
            public final void run() {
                LogLevel logLevel;
                LogLevel[] values = LogLevel.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        logLevel = null;
                        break;
                    }
                    logLevel = values[i];
                    if (logLevel.getLevel() == Level.this) {
                        break;
                    }
                    i++;
                }
                if (logLevel != null) {
                    LoggerImplementation loggerImplementation = LoggerImplementation.INSTANCE;
                    List<LoggerService> authRequestContext = LoggerImplementation.getAuthRequestContext();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : authRequestContext) {
                        LoggerService loggerService = (LoggerService) obj;
                        if (loggerService.getAuthRequestContext() == LogLevel.All || loggerService.getAuthRequestContext() == logLevel) {
                            arrayList.add(obj);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((LoggerService) it.next()).getAuthRequestContext(logLevel, p1, p2);
                    }
                }
            }
        });
    }
}
