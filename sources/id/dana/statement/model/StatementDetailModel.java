package id.dana.statement.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010"}, d2 = {"Lid/dana/statement/model/StatementDetailModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/model/CurrencyAmountModel;", "PlaceComponentResult", "Lid/dana/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "", "J", "getAuthRequestContext", "<init>", "(JLid/dana/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementDetailModel implements Parcelable {
    public static final Parcelable.Creator<StatementDetailModel> CREATOR = new Creator();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final long getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CurrencyAmountModel MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeLong(this.getAuthRequestContext);
        p0.writeParcelable(this.MyBillsEntityDataFactory, p1);
    }

    public StatementDetailModel(long j, CurrencyAmountModel currencyAmountModel) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        this.getAuthRequestContext = j;
        this.MyBillsEntityDataFactory = currencyAmountModel;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<StatementDetailModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StatementDetailModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new StatementDetailModel(parcel.readLong(), (CurrencyAmountModel) parcel.readParcelable(StatementDetailModel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StatementDetailModel[] newArray(int i) {
            return new StatementDetailModel[i];
        }
    }
}
