package id.dana.riskChallenges.domain.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\r"}, d2 = {"Lid/dana/riskChallenges/domain/model/RequestOtpModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "p1", "p2", "p3", "p4", "<init>", "(IIIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RequestOtpModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RequestOtpModel) {
            RequestOtpModel requestOtpModel = (RequestOtpModel) p0;
            return this.BuiltInFictitiousFunctionClassFactory == requestOtpModel.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext == requestOtpModel.getAuthRequestContext && this.MyBillsEntityDataFactory == requestOtpModel.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == requestOtpModel.KClassImpl$Data$declaredNonStaticMembers$2 && this.PlaceComponentResult == requestOtpModel.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.BuiltInFictitiousFunctionClassFactory * 31) + this.getAuthRequestContext) * 31) + this.MyBillsEntityDataFactory) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + this.PlaceComponentResult;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RequestOtpModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public RequestOtpModel(int i, int i2, int i3, int i4, int i5) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.getAuthRequestContext = i2;
        this.MyBillsEntityDataFactory = i3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
        this.PlaceComponentResult = i5;
    }
}
