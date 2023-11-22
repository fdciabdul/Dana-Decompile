package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a"}, d2 = {"Lid/dana/cashier/model/RemainingCardLimitAmountModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Long;", "MyBillsEntityDataFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/String;", "lookAheadTest", "scheduleImpl", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RemainingCardLimitAmountModel implements Parcelable {
    public static final Parcelable.Creator<RemainingCardLimitAmountModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Long MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final Long PlaceComponentResult;
    public final String getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;

    public RemainingCardLimitAmountModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RemainingCardLimitAmountModel) {
            RemainingCardLimitAmountModel remainingCardLimitAmountModel = (RemainingCardLimitAmountModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, remainingCardLimitAmountModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, remainingCardLimitAmountModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, remainingCardLimitAmountModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, remainingCardLimitAmountModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, remainingCardLimitAmountModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.scheduleImpl, remainingCardLimitAmountModel.scheduleImpl);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.MyBillsEntityDataFactory;
        int hashCode = l == null ? 0 : l.hashCode();
        Long l2 = this.PlaceComponentResult;
        int hashCode2 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = l3 == null ? 0 : l3.hashCode();
        String str = this.getAuthRequestContext;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.scheduleImpl;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemainingCardLimitAmountModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Long l = this.MyBillsEntityDataFactory;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        Long l2 = this.PlaceComponentResult;
        if (l2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l2.longValue());
        }
        Long l3 = this.BuiltInFictitiousFunctionClassFactory;
        if (l3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l3.longValue());
        }
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.scheduleImpl);
    }

    public RemainingCardLimitAmountModel(Long l, Long l2, Long l3, String str, String str2, String str3) {
        this.MyBillsEntityDataFactory = l;
        this.PlaceComponentResult = l2;
        this.BuiltInFictitiousFunctionClassFactory = l3;
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.scheduleImpl = str3;
    }

    public /* synthetic */ RemainingCardLimitAmountModel(Long l, Long l2, Long l3, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<RemainingCardLimitAmountModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RemainingCardLimitAmountModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new RemainingCardLimitAmountModel(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RemainingCardLimitAmountModel[] newArray(int i) {
            return new RemainingCardLimitAmountModel[i];
        }
    }
}
