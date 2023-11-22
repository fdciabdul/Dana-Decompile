package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/cashier/model/PaylaterOnboardingBenefitModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PaylaterOnboardingBenefitModel implements Parcelable {
    public static final Parcelable.Creator<PaylaterOnboardingBenefitModel> CREATOR = new Creator();
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PaylaterOnboardingBenefitModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.model.PaylaterOnboardingBenefitModel.<init>():void");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.PlaceComponentResult);
    }

    public PaylaterOnboardingBenefitModel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = str2;
    }

    public /* synthetic */ PaylaterOnboardingBenefitModel(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Creator implements Parcelable.Creator<PaylaterOnboardingBenefitModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PaylaterOnboardingBenefitModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PaylaterOnboardingBenefitModel(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PaylaterOnboardingBenefitModel[] newArray(int i) {
            return new PaylaterOnboardingBenefitModel[i];
        }
    }
}
