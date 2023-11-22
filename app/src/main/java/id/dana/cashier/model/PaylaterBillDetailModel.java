package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0012\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011"}, d2 = {"Lid/dana/cashier/model/PaylaterBillDetailModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterBillDetailModel implements Parcelable {
    public static final Parcelable.Creator<PaylaterBillDetailModel> CREATOR = new Creator();
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public MoneyViewModel getAuthRequestContext;
    public String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.MyBillsEntityDataFactory);
    }

    public PaylaterBillDetailModel(String str, String str2, MoneyViewModel moneyViewModel, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = moneyViewModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i2;
    }

    public /* synthetic */ PaylaterBillDetailModel(String str, String str2, MoneyViewModel moneyViewModel, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, moneyViewModel, (i3 & 8) != 0 ? 3 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<PaylaterBillDetailModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PaylaterBillDetailModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PaylaterBillDetailModel(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PaylaterBillDetailModel[] newArray(int i) {
            return new PaylaterBillDetailModel[i];
        }
    }
}
