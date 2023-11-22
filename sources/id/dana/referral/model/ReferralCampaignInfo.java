package id.dana.referral.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;

/* loaded from: classes5.dex */
public class ReferralCampaignInfo implements Parcelable {
    public static final Parcelable.Creator<ReferralCampaignInfo> CREATOR = new Parcelable.Creator<ReferralCampaignInfo>() { // from class: id.dana.referral.model.ReferralCampaignInfo.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ReferralCampaignInfo createFromParcel(Parcel parcel) {
            return new ReferralCampaignInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ReferralCampaignInfo[] newArray(int i) {
            return new ReferralCampaignInfo[i];
        }
    };
    boolean BuiltInFictitiousFunctionClassFactory;
    public CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ReferralCampaignInfo() {
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.BuiltInFictitiousFunctionClassFactory ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.PlaceComponentResult);
    }

    protected ReferralCampaignInfo(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = parcel.readByte() != 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.MyBillsEntityDataFactory = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
    }
}
