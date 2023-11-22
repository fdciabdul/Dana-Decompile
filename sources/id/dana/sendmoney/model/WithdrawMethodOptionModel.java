package id.dana.sendmoney.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u0012\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/sendmoney/model/WithdrawMethodOptionModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/sendmoney/model/WithdrawSavedCardChannelModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "PlaceComponentResult", "Lid/dana/sendmoney/model/WithdrawChannelModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p1", "p2", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WithdrawMethodOptionModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<WithdrawSavedCardChannelModel> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<WithdrawChannelModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof WithdrawMethodOptionModel) {
            WithdrawMethodOptionModel withdrawMethodOptionModel = (WithdrawMethodOptionModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, withdrawMethodOptionModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, withdrawMethodOptionModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, withdrawMethodOptionModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.PlaceComponentResult.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawMethodOptionModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public WithdrawMethodOptionModel(List<WithdrawSavedCardChannelModel> list, List<WithdrawChannelModel> list2, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list2;
        this.MyBillsEntityDataFactory = str;
    }
}
