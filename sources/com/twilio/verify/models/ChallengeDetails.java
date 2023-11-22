package com.twilio.verify.models;

import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/twilio/verify/models/ChallengeDetails;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Date;", "getAuthRequestContext", "Ljava/util/Date;", "", "Lcom/twilio/verify/models/Detail;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Date;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class ChallengeDetails {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<Detail> PlaceComponentResult;
    public final Date getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof ChallengeDetails) {
                ChallengeDetails challengeDetails = (ChallengeDetails) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, challengeDetails.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, challengeDetails.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, challengeDetails.getAuthRequestContext);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str != null ? str.hashCode() : 0;
        List<Detail> list = this.PlaceComponentResult;
        int hashCode2 = list != null ? list.hashCode() : 0;
        Date date = this.getAuthRequestContext;
        return (((hashCode * 31) + hashCode2) * 31) + (date != null ? date.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChallengeDetails(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(")");
        return sb.toString();
    }

    public ChallengeDetails(String str, List<Detail> list, Date date) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = date;
    }
}
