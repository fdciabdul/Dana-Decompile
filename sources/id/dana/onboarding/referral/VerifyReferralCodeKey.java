package id.dana.onboarding.referral;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import id.dana.base.BaseKey;
import id.dana.onboarding.referral.VerifyReferralCodeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\n\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018"}, d2 = {"Lid/dana/onboarding/referral/VerifyReferralCodeKey;", "Landroid/os/Parcelable;", "Lid/dana/base/BaseKey;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "()Landroidx/fragment/app/Fragment;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VerifyReferralCodeKey extends BaseKey implements Parcelable {
    public static final Parcelable.Creator<VerifyReferralCodeKey> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof VerifyReferralCodeKey) {
            VerifyReferralCodeKey verifyReferralCodeKey = (VerifyReferralCodeKey) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, verifyReferralCodeKey.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, verifyReferralCodeKey.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getAuthRequestContext.hashCode();
        String str = this.MyBillsEntityDataFactory;
        return (hashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyReferralCodeKey(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
    }

    public VerifyReferralCodeKey(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = str2;
    }

    @Override // id.dana.base.BaseKey
    public final Fragment MyBillsEntityDataFactory() {
        VerifyReferralCodeFragment.Companion companion = VerifyReferralCodeFragment.PlaceComponentResult;
        return VerifyReferralCodeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<VerifyReferralCodeKey> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VerifyReferralCodeKey createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new VerifyReferralCodeKey(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VerifyReferralCodeKey[] newArray(int i) {
            return new VerifyReferralCodeKey[i];
        }
    }
}
