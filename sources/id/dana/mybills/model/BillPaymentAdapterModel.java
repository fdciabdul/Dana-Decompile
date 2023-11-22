package id.dana.mybills.model;

import id.dana.analytics.tracker.TrackerKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/mybills/model/BillPaymentAdapterModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "MyBillsEntityDataFactory", "Lid/dana/mybills/model/BillsPaymentHeaderModel;", "getAuthRequestContext", "Lid/dana/mybills/model/BillsPaymentHeaderModel;", "Lid/dana/mybills/model/BillPaymentStatusModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/model/BillPaymentStatusModel;", "PlaceComponentResult", "I", "p1", "p2", "p3", "<init>", "(Lid/dana/mybills/model/BillsPaymentHeaderModel;Lid/dana/mybills/model/BillPaymentStatusModel;Ljava/util/List;I)V", "ViewTypeEnum"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillPaymentAdapterModel {
    public final BillPaymentStatusModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<BillPaymentAdapterModel> MyBillsEntityDataFactory;
    public final int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final BillsPaymentHeaderModel KClassImpl$Data$declaredNonStaticMembers$2;

    public BillPaymentAdapterModel() {
        this(null, null, null, 0, 15, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BillPaymentAdapterModel) {
            BillPaymentAdapterModel billPaymentAdapterModel = (BillPaymentAdapterModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, billPaymentAdapterModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, billPaymentAdapterModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, billPaymentAdapterModel.MyBillsEntityDataFactory) && this.PlaceComponentResult == billPaymentAdapterModel.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        BillsPaymentHeaderModel billsPaymentHeaderModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = billsPaymentHeaderModel == null ? 0 : billsPaymentHeaderModel.hashCode();
        BillPaymentStatusModel billPaymentStatusModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = billPaymentStatusModel == null ? 0 : billPaymentStatusModel.hashCode();
        List<BillPaymentAdapterModel> list = this.MyBillsEntityDataFactory;
        return (((((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0)) * 31) + this.PlaceComponentResult;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillPaymentAdapterModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private BillPaymentAdapterModel(BillsPaymentHeaderModel billsPaymentHeaderModel, BillPaymentStatusModel billPaymentStatusModel, List<BillPaymentAdapterModel> list, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = billsPaymentHeaderModel;
        this.BuiltInFictitiousFunctionClassFactory = billPaymentStatusModel;
        this.MyBillsEntityDataFactory = list;
        this.PlaceComponentResult = i;
    }

    public /* synthetic */ BillPaymentAdapterModel(BillsPaymentHeaderModel billsPaymentHeaderModel, BillPaymentStatusModel billPaymentStatusModel, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : billsPaymentHeaderModel, (i2 & 2) != 0 ? null : billPaymentStatusModel, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? ViewTypeEnum.ITEMS.ordinal() : i);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b"}, d2 = {"Lid/dana/mybills/model/BillPaymentAdapterModel$ViewTypeEnum;", "", "", "viewType", "<init>", "(Ljava/lang/String;II)V", "HEADER", "ITEMS", TrackerKey.RecipientDestinationTypeProperty.GROUP}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ViewTypeEnum {
        HEADER(0),
        ITEMS(1),
        GROUP(2);

        ViewTypeEnum(int i) {
        }
    }
}
