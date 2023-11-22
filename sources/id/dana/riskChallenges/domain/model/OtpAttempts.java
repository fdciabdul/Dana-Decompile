package id.dana.riskChallenges.domain.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/domain/model/OtpAttempts;", "", "", "p0", "p1", "MyBillsEntityDataFactory", "(II)Lid/dana/riskChallenges/domain/model/OtpAttempts;", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "I", "PlaceComponentResult", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OtpAttempts {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    public static OtpAttempts MyBillsEntityDataFactory(int p0, int p1) {
        return new OtpAttempts(p0, p1);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof OtpAttempts) {
            OtpAttempts otpAttempts = (OtpAttempts) p0;
            return this.PlaceComponentResult == otpAttempts.PlaceComponentResult && this.MyBillsEntityDataFactory == otpAttempts.MyBillsEntityDataFactory;
        }
        return false;
    }

    public final int hashCode() {
        return (this.PlaceComponentResult * 31) + this.MyBillsEntityDataFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OtpAttempts(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public OtpAttempts(int i, int i2) {
        this.PlaceComponentResult = i;
        this.MyBillsEntityDataFactory = i2;
    }
}
