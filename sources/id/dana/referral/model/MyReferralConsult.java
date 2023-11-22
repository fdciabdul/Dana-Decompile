package id.dana.referral.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class MyReferralConsult implements Parcelable {
    public static final Parcelable.Creator<MyReferralConsult> CREATOR = new Parcelable.Creator<MyReferralConsult>() { // from class: id.dana.referral.model.MyReferralConsult.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ MyReferralConsult createFromParcel(Parcel parcel) {
            return new MyReferralConsult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MyReferralConsult[] newArray(int i) {
            return new MyReferralConsult[i];
        }
    };
    public ReferralCampaignInfo KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    String PlaceComponentResult;
    public ReferralCampaignInfo getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        parcel.writeParcelable(this.getAuthRequestContext, i);
    }

    public MyReferralConsult() {
    }

    protected MyReferralConsult(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (ReferralCampaignInfo) parcel.readParcelable(ReferralCampaignInfo.class.getClassLoader());
        this.getAuthRequestContext = (ReferralCampaignInfo) parcel.readParcelable(ReferralCampaignInfo.class.getClassLoader());
    }
}
