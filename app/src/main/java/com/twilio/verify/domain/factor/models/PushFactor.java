package com.twilio.verify.domain.factor.models;

import com.twilio.verify.models.Factor;
import com.twilio.verify.models.FactorStatus;
import com.twilio.verify.models.FactorType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0013\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001a\u0010\u000f\u001a\u00020\u000b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u0014\u001a\u00020\u00138\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016\"\u0004\b\n\u0010\u0017R\u001a\u0010\f\u001a\u00020\u00188\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u0014\u0010\u001a"}, d2 = {"Lcom/twilio/verify/domain/factor/models/PushFactor;", "Lcom/twilio/verify/models/Factor;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "PlaceComponentResult", "Lcom/twilio/verify/domain/factor/models/Config;", "Lcom/twilio/verify/domain/factor/models/Config;", "getAuthRequestContext", "Ljava/util/Date;", "scheduleImpl", "Ljava/util/Date;", "()Ljava/util/Date;", "MyBillsEntityDataFactory", "getErrorConfigVersion", "moveToNextValue", "lookAheadTest", "Lcom/twilio/verify/models/FactorStatus;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/twilio/verify/models/FactorStatus;", "()Lcom/twilio/verify/models/FactorStatus;", "(Lcom/twilio/verify/models/FactorStatus;)V", "Lcom/twilio/verify/models/FactorType;", "Lcom/twilio/verify/models/FactorType;", "()Lcom/twilio/verify/models/FactorType;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/twilio/verify/models/FactorStatus;Ljava/util/Date;Lcom/twilio/verify/domain/factor/models/Config;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class PushFactor implements Factor {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    private FactorStatus NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Config getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final FactorType scheduleImpl;
    public final String lookAheadTest;
    public final String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Date MyBillsEntityDataFactory;

    public PushFactor(String str, String str2, String str3, String str4, String str5, FactorStatus factorStatus, Date date, Config config) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(str3, "");
        Intrinsics.checkParameterIsNotNull(str4, "");
        Intrinsics.checkParameterIsNotNull(str5, "");
        Intrinsics.checkParameterIsNotNull(factorStatus, "");
        Intrinsics.checkParameterIsNotNull(date, "");
        Intrinsics.checkParameterIsNotNull(config, "");
        this.lookAheadTest = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = str3;
        this.moveToNextValue = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = factorStatus;
        this.MyBillsEntityDataFactory = date;
        this.getAuthRequestContext = config;
        this.scheduleImpl = FactorType.PUSH;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final String getLookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(FactorStatus factorStatus) {
        Intrinsics.checkParameterIsNotNull(factorStatus, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = factorStatus;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final FactorStatus getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final Date getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.twilio.verify.models.Factor
    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    public final FactorType getScheduleImpl() {
        return this.scheduleImpl;
    }
}
