package com.twilio.verify.domain.service.models;

import com.twilio.verify.models.Service;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0010X\u0016¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\r\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u0010X\u0016¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012"}, d2 = {"Lcom/twilio/verify/domain/service/models/FactorService;", "Lcom/twilio/verify/models/Service;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/util/Date;", "getAuthRequestContext", "Ljava/util/Date;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final /* data */ class FactorService implements Service {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final Date KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final Date getAuthRequestContext;

    public FactorService(String str, Date date, Date date2, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(date, "");
        Intrinsics.checkParameterIsNotNull(date2, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(str3, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = date;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = date2;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
    }

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof FactorService) {
                FactorService factorService = (FactorService) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, factorService.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, factorService.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, factorService.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, factorService.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, factorService.MyBillsEntityDataFactory);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str != null ? str.hashCode() : 0;
        Date date = this.getAuthRequestContext;
        int hashCode2 = date != null ? date.hashCode() : 0;
        Date date2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = date2 != null ? date2.hashCode() : 0;
        String str2 = this.PlaceComponentResult;
        int hashCode4 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.MyBillsEntityDataFactory;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FactorService(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(")");
        return sb.toString();
    }
}
