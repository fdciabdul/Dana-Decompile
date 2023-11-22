package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class ShareQRSplitBillModel implements Parcelable {
    public static final Parcelable.Creator<ShareQRSplitBillModel> CREATOR = new Parcelable.Creator<ShareQRSplitBillModel>() { // from class: id.dana.sendmoney.model.ShareQRSplitBillModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShareQRSplitBillModel createFromParcel(Parcel parcel) {
            return new ShareQRSplitBillModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ShareQRSplitBillModel[] newArray(int i) {
            return new ShareQRSplitBillModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    private String getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ ShareQRSplitBillModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public /* synthetic */ ShareQRSplitBillModel(Builder builder, byte b) {
        this(builder);
    }

    private ShareQRSplitBillModel(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getAuthRequestContext = builder.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult;
    }

    private ShareQRSplitBillModel(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.MyBillsEntityDataFactory);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public String BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        public String PlaceComponentResult;
    }
}
