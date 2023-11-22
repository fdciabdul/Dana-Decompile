package com.twilio.verify.models;

import java.util.Date;
import kotlin.jvm.JvmName;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\r8'@'X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118'X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0012"}, d2 = {"Lcom/twilio/verify/models/Factor;", "", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/util/Date;", "()Ljava/util/Date;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/twilio/verify/models/FactorStatus;", "moveToNextValue", "()Lcom/twilio/verify/models/FactorStatus;", "(Lcom/twilio/verify/models/FactorStatus;)V", "Lcom/twilio/verify/models/FactorType;", "()Lcom/twilio/verify/models/FactorType;", "getErrorConfigVersion"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface Factor {
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    String BuiltInFictitiousFunctionClassFactory();

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    String KClassImpl$Data$declaredNonStaticMembers$2();

    @JvmName(name = "MyBillsEntityDataFactory")
    String MyBillsEntityDataFactory();

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    FactorType NetworkUserEntityData$$ExternalSyntheticLambda0();

    @JvmName(name = "PlaceComponentResult")
    Date PlaceComponentResult();

    @JvmName(name = "getAuthRequestContext")
    String getAuthRequestContext();

    @JvmName(name = "getAuthRequestContext")
    void getAuthRequestContext(FactorStatus factorStatus);

    @JvmName(name = "moveToNextValue")
    FactorStatus moveToNextValue();

    @JvmName(name = "scheduleImpl")
    String scheduleImpl();
}
