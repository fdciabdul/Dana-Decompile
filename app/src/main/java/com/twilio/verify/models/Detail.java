package com.twilio.verify.models;

import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lcom/twilio/verify/models/Detail;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class Detail {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof Detail) {
                Detail detail = (Detail) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, detail.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, detail.getAuthRequestContext);
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.getAuthRequestContext;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detail(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(")");
        return sb.toString();
    }

    public Detail(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
    }
}
