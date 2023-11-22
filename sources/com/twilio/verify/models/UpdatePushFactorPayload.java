package com.twilio.verify.models;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\r\u001a\u00020\n8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0010\u0010\f"}, d2 = {"Lcom/twilio/verify/models/UpdatePushFactorPayload;", "Lcom/twilio/verify/models/UpdateFactorPayload;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class UpdatePushFactorPayload implements UpdateFactorPayload {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    public UpdatePushFactorPayload(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
    }

    @Override // com.twilio.verify.models.UpdateFactorPayload
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof UpdatePushFactorPayload) {
                UpdatePushFactorPayload updatePushFactorPayload = (UpdatePushFactorPayload) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, updatePushFactorPayload.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, updatePushFactorPayload.getAuthRequestContext);
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
        sb.append("UpdatePushFactorPayload(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(")");
        return sb.toString();
    }
}
