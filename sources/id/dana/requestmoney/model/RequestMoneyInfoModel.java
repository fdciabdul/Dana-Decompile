package id.dana.requestmoney.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/requestmoney/model/RequestMoneyInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "I", "MyBillsEntityDataFactory", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RequestMoneyInfoModel {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RequestMoneyInfoModel() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.model.RequestMoneyInfoModel.<init>():void");
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RequestMoneyInfoModel) {
            RequestMoneyInfoModel requestMoneyInfoModel = (RequestMoneyInfoModel) p0;
            return this.BuiltInFictitiousFunctionClassFactory == requestMoneyInfoModel.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == requestMoneyInfoModel.MyBillsEntityDataFactory;
        }
        return false;
    }

    public final int hashCode() {
        return (this.BuiltInFictitiousFunctionClassFactory * 31) + this.MyBillsEntityDataFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RequestMoneyInfoModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public RequestMoneyInfoModel(int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = i2;
    }

    public /* synthetic */ RequestMoneyInfoModel(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
