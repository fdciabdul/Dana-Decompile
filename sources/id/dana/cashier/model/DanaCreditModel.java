package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\r"}, d2 = {"Lid/dana/cashier/model/DanaCreditModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p2", "p3", "<init>", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaCreditModel implements Parcelable {
    public static final Parcelable.Creator<DanaCreditModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final MoneyViewModel MyBillsEntityDataFactory;
    public final MoneyViewModel getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel2 = this.getAuthRequestContext;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        MoneyViewModel moneyViewModel3 = this.MyBillsEntityDataFactory;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        moneyViewModel3.writeToParcel(p0, p1);
    }

    public DanaCreditModel(MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str, MoneyViewModel moneyViewModel3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel;
        this.getAuthRequestContext = moneyViewModel2;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = moneyViewModel3;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<DanaCreditModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DanaCreditModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new DanaCreditModel(parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? MoneyViewModel.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DanaCreditModel[] newArray(int i) {
            return new DanaCreditModel[i];
        }
    }
}
