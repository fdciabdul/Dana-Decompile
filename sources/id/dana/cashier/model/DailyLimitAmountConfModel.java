package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/cashier/model/DailyLimitAmountConfModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Lkotlin/ranges/ClosedRange;", "", "MyBillsEntityDataFactory", "()Lkotlin/ranges/ClosedRange;", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyLimitAmountConfModel implements Parcelable {
    public static final Parcelable.Creator<DailyLimitAmountConfModel> CREATOR = new Creator();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Integer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Integer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Integer MyBillsEntityDataFactory;

    public DailyLimitAmountConfModel() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        Integer num2 = this.MyBillsEntityDataFactory;
        if (num2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num2.intValue());
        }
        Integer num3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (num3 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(num3.intValue());
    }

    public DailyLimitAmountConfModel(Integer num, Integer num2, Integer num3) {
        this.BuiltInFictitiousFunctionClassFactory = num;
        this.MyBillsEntityDataFactory = num2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = num3;
    }

    public /* synthetic */ DailyLimitAmountConfModel(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }

    public final ClosedRange<Long> MyBillsEntityDataFactory() {
        return new LongRange(NumberExtKt.toSafeLong(this.KClassImpl$Data$declaredNonStaticMembers$2, 0L), NumberExtKt.toSafeLong(this.MyBillsEntityDataFactory, 0L));
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<DailyLimitAmountConfModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DailyLimitAmountConfModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new DailyLimitAmountConfModel(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DailyLimitAmountConfModel[] newArray(int i) {
            return new DailyLimitAmountConfModel[i];
        }
    }
}
