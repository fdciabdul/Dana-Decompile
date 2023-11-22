package id.dana.cashier.model.featureTime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "J", "<init>", "(Ljava/lang/String;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureTimeModel implements Parcelable {
    public static final Parcelable.Creator<FeatureTimeModel> CREATOR = new Creator();
    public final long MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    public FeatureTimeModel() {
        this(null, 0L, 3, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        p0.writeLong(this.MyBillsEntityDataFactory);
    }

    public FeatureTimeModel(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = j;
    }

    public /* synthetic */ FeatureTimeModel(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Empty" : str, (i & 2) != 0 ? 0L : j);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<FeatureTimeModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FeatureTimeModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new FeatureTimeModel(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FeatureTimeModel[] newArray(int i) {
            return new FeatureTimeModel[i];
        }
    }
}
