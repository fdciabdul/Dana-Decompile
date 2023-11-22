package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* loaded from: classes8.dex */
public class aq implements LoggerInterface {
    private LoggerInterface KClassImpl$Data$declaredNonStaticMembers$2;
    private LoggerInterface MyBillsEntityDataFactory;

    public aq(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loggerInterface;
        this.MyBillsEntityDataFactory = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        LoggerInterface loggerInterface = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (loggerInterface != null) {
            loggerInterface.BuiltInFictitiousFunctionClassFactory(str);
        }
        LoggerInterface loggerInterface2 = this.MyBillsEntityDataFactory;
        if (loggerInterface2 != null) {
            loggerInterface2.BuiltInFictitiousFunctionClassFactory(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void PlaceComponentResult(String str, Throwable th) {
        LoggerInterface loggerInterface = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (loggerInterface != null) {
            loggerInterface.PlaceComponentResult(str, th);
        }
        LoggerInterface loggerInterface2 = this.MyBillsEntityDataFactory;
        if (loggerInterface2 != null) {
            loggerInterface2.PlaceComponentResult(str, th);
        }
    }
}
