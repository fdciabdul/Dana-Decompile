package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018"}, d2 = {"Lid/dana/cashier/model/PayMethodViewDtoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "getAuthRequestContext", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "", "Lid/dana/cashier/model/AssetCardModel;", "Ljava/util/List;", "Lid/dana/cashier/model/CashierPayChannelModel;", "MyBillsEntityDataFactory", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayMethodViewDtoModel implements Parcelable {
    public static final Parcelable.Creator<PayMethodViewDtoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final List<CashierPayChannelModel> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    final List<AssetCardModel> getAuthRequestContext;

    public PayMethodViewDtoModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PayMethodViewDtoModel) {
            PayMethodViewDtoModel payMethodViewDtoModel = (PayMethodViewDtoModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, payMethodViewDtoModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, payMethodViewDtoModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, payMethodViewDtoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, payMethodViewDtoModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str == null ? 0 : str.hashCode();
        List<AssetCardModel> list = this.getAuthRequestContext;
        int hashCode2 = list == null ? 0 : list.hashCode();
        List<CashierPayChannelModel> list2 = this.MyBillsEntityDataFactory;
        int hashCode3 = list2 == null ? 0 : list2.hashCode();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayMethodViewDtoModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        List<AssetCardModel> list = this.getAuthRequestContext;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<AssetCardModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        List<CashierPayChannelModel> list2 = this.MyBillsEntityDataFactory;
        if (list2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list2.size());
            Iterator<CashierPayChannelModel> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(p0, p1);
            }
        }
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    public PayMethodViewDtoModel(String str, List<AssetCardModel> list, List<CashierPayChannelModel> list2, String str2) {
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = list;
        this.MyBillsEntityDataFactory = list2;
        this.BuiltInFictitiousFunctionClassFactory = str2;
    }

    public /* synthetic */ PayMethodViewDtoModel(String str, List list, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2);
    }

    public final boolean getAuthRequestContext() {
        return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "CREDIT_CARD") || Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "DEBIT_CARD") || Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "DIRECT_DEBIT_CREDIT_CARD") || Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "DIRECT_DEBIT_DEBIT_CARD") || Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "NET_BANKING");
    }

    public final boolean PlaceComponentResult() {
        return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "VIRTUAL_ACCOUNT");
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, "OTC");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<PayMethodViewDtoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PayMethodViewDtoModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(AssetCardModel.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList3 = arrayList;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList2.add(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
                }
            }
            return new PayMethodViewDtoModel(readString, arrayList3, arrayList2, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PayMethodViewDtoModel[] newArray(int i) {
            return new PayMethodViewDtoModel[i];
        }
    }
}
