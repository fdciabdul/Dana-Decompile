package id.dana.sendmoney.ui.groupsend.landing.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/model/TransferUserInfoQueryModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class TransferUserInfoQueryModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TransferUserInfoQueryModel) {
            TransferUserInfoQueryModel transferUserInfoQueryModel = (TransferUserInfoQueryModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, transferUserInfoQueryModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, transferUserInfoQueryModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, transferUserInfoQueryModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferUserInfoQueryModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }
}