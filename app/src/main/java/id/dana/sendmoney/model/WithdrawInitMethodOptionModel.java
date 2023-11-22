package id.dana.sendmoney.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/model/WithdrawInitMethodOptionModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/sendmoney/model/WithdrawSavedCardChannelModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "Lid/dana/sendmoney/model/WithdrawInitChannelOptionModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "p1", "p2", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WithdrawInitMethodOptionModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<WithdrawInitChannelOptionModel> BuiltInFictitiousFunctionClassFactory;
    public final List<WithdrawSavedCardChannelModel> MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof WithdrawInitMethodOptionModel) {
            WithdrawInitMethodOptionModel withdrawInitMethodOptionModel = (WithdrawInitMethodOptionModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, withdrawInitMethodOptionModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, withdrawInitMethodOptionModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, withdrawInitMethodOptionModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        List<WithdrawSavedCardChannelModel> list = this.MyBillsEntityDataFactory;
        int hashCode = list == null ? 0 : list.hashCode();
        List<WithdrawInitChannelOptionModel> list2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        String str = this.PlaceComponentResult;
        return (((hashCode * 31) + hashCode2) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawInitMethodOptionModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public WithdrawInitMethodOptionModel(List<WithdrawSavedCardChannelModel> list, List<WithdrawInitChannelOptionModel> list2, String str) {
        this.MyBillsEntityDataFactory = list;
        this.BuiltInFictitiousFunctionClassFactory = list2;
        this.PlaceComponentResult = str;
    }
}
