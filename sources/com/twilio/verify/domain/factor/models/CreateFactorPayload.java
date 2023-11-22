package com.twilio.verify.domain.factor.models;

import com.twilio.verify.models.FactorType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010\u0012\u0006\u0010!\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010X\u0016¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0011\u0010\r\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\n8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0016\u001a\u00020\n8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u001b\u001a\u00020\u00178\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a"}, d2 = {"Lcom/twilio/verify/domain/factor/models/CreateFactorPayload;", "Lcom/twilio/verify/domain/factor/models/FactorDataPayload;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "getAuthRequestContext", "MyBillsEntityDataFactory", "getErrorConfigVersion", "moveToNextValue", "Lcom/twilio/verify/models/FactorType;", "lookAheadTest", "Lcom/twilio/verify/models/FactorType;", "()Lcom/twilio/verify/models/FactorType;", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Lcom/twilio/verify/models/FactorType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class CreateFactorPayload implements FactorDataPayload {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Map<String, String> getAuthRequestContext;
    public final Map<String, String> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final FactorType scheduleImpl;

    public CreateFactorPayload(String str, FactorType factorType, String str2, String str3, Map<String, String> map, Map<String, String> map2, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(factorType, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(str3, "");
        Intrinsics.checkParameterIsNotNull(map, "");
        Intrinsics.checkParameterIsNotNull(map2, "");
        Intrinsics.checkParameterIsNotNull(str4, "");
        this.PlaceComponentResult = str;
        this.scheduleImpl = factorType;
        this.moveToNextValue = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.MyBillsEntityDataFactory = map;
        this.getAuthRequestContext = map2;
        this.BuiltInFictitiousFunctionClassFactory = str4;
    }

    @Override // com.twilio.verify.domain.factor.models.FactorDataPayload
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final FactorType getScheduleImpl() {
        return this.scheduleImpl;
    }

    @Override // com.twilio.verify.domain.factor.models.FactorDataPayload
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // com.twilio.verify.domain.factor.models.FactorDataPayload
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof CreateFactorPayload) {
                CreateFactorPayload createFactorPayload = (CreateFactorPayload) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, createFactorPayload.PlaceComponentResult) && Intrinsics.areEqual(this.scheduleImpl, createFactorPayload.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, createFactorPayload.moveToNextValue) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, createFactorPayload.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, createFactorPayload.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, createFactorPayload.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, createFactorPayload.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str != null ? str.hashCode() : 0;
        FactorType factorType = this.scheduleImpl;
        int hashCode2 = factorType != null ? factorType.hashCode() : 0;
        String str2 = this.moveToNextValue;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode4 = str3 != null ? str3.hashCode() : 0;
        Map<String, String> map = this.MyBillsEntityDataFactory;
        int hashCode5 = map != null ? map.hashCode() : 0;
        Map<String, String> map2 = this.getAuthRequestContext;
        int hashCode6 = map2 != null ? map2.hashCode() : 0;
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateFactorPayload(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(")");
        return sb.toString();
    }
}
