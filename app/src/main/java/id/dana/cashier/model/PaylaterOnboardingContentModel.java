package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/cashier/model/PaylaterOnboardingContentModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/cashier/model/ConsultAgreementModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/ConsultAgreementModel;", "getAuthRequestContext", "", "PlaceComponentResult", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lid/dana/cashier/model/ConsultAgreementModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterOnboardingContentModel implements Parcelable {
    public static final Parcelable.Creator<PaylaterOnboardingContentModel> CREATOR = new Creator();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ConsultAgreementModel getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.getAuthRequestContext.writeToParcel(p0, p1);
    }

    public PaylaterOnboardingContentModel(String str, ConsultAgreementModel consultAgreementModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(consultAgreementModel, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = consultAgreementModel;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<PaylaterOnboardingContentModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PaylaterOnboardingContentModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PaylaterOnboardingContentModel(parcel.readString(), ConsultAgreementModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PaylaterOnboardingContentModel[] newArray(int i) {
            return new PaylaterOnboardingContentModel[i];
        }
    }
}
