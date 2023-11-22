package com.twilio.verify.domain.factor.models;

import com.twilio.verify.models.FactorType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\r\u0012\u0006\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rX\u0016¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\n8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u000e\u001a\u00020\n8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0019\u001a\u00020\u00158\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018"}, d2 = {"Lcom/twilio/verify/domain/factor/models/UpdateFactorPayload;", "Lcom/twilio/verify/domain/factor/models/FactorDataPayload;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/Map;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Lcom/twilio/verify/models/FactorType;", "getErrorConfigVersion", "Lcom/twilio/verify/models/FactorType;", "()Lcom/twilio/verify/models/FactorType;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Lcom/twilio/verify/models/FactorType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class UpdateFactorPayload implements FactorDataPayload {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Map<String, String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final FactorType NetworkUserEntityData$$ExternalSyntheticLambda0;

    public UpdateFactorPayload(String str, FactorType factorType, String str2, String str3, Map<String, String> map, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(factorType, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(str3, "");
        Intrinsics.checkParameterIsNotNull(map, "");
        Intrinsics.checkParameterIsNotNull(str4, "");
        this.getAuthRequestContext = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = factorType;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
        this.BuiltInFictitiousFunctionClassFactory = map;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
    }

    @Override // com.twilio.verify.domain.factor.models.FactorDataPayload
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final FactorType getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.twilio.verify.domain.factor.models.FactorDataPayload
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // com.twilio.verify.domain.factor.models.FactorDataPayload
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof UpdateFactorPayload) {
                UpdateFactorPayload updateFactorPayload = (UpdateFactorPayload) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, updateFactorPayload.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, updateFactorPayload.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.PlaceComponentResult, updateFactorPayload.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, updateFactorPayload.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, updateFactorPayload.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, updateFactorPayload.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.getAuthRequestContext;
        int hashCode = str != null ? str.hashCode() : 0;
        FactorType factorType = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode2 = factorType != null ? factorType.hashCode() : 0;
        String str2 = this.PlaceComponentResult;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode4 = str3 != null ? str3.hashCode() : 0;
        Map<String, String> map = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = map != null ? map.hashCode() : 0;
        String str4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateFactorPayload(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(")");
        return sb.toString();
    }
}
