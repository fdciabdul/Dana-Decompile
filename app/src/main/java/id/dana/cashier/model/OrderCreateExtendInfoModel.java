package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/model/OrderCreateExtendInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/TncUrlModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/TncUrlModel;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/cashier/model/TncUrlModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OrderCreateExtendInfoModel implements Parcelable {
    public static final Parcelable.Creator<OrderCreateExtendInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final TncUrlModel MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.cashier.model.TncUrlModel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OrderCreateExtendInfoModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.model.OrderCreateExtendInfoModel.<init>():void");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        TncUrlModel tncUrlModel = this.MyBillsEntityDataFactory;
        if (tncUrlModel == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        tncUrlModel.writeToParcel(p0, p1);
    }

    public OrderCreateExtendInfoModel(TncUrlModel tncUrlModel) {
        this.MyBillsEntityDataFactory = tncUrlModel;
    }

    public /* synthetic */ OrderCreateExtendInfoModel(TncUrlModel tncUrlModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tncUrlModel);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<OrderCreateExtendInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OrderCreateExtendInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new OrderCreateExtendInfoModel(parcel.readInt() == 0 ? null : TncUrlModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OrderCreateExtendInfoModel[] newArray(int i) {
            return new OrderCreateExtendInfoModel[i];
        }
    }
}
