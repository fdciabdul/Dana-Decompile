package id.dana.splitbill.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SplitBillHistoryModel implements Parcelable {
    public static final Parcelable.Creator<SplitBillHistoryModel> CREATOR = new Parcelable.Creator<SplitBillHistoryModel>() { // from class: id.dana.splitbill.model.SplitBillHistoryModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ SplitBillHistoryModel createFromParcel(Parcel parcel) {
            return new SplitBillHistoryModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SplitBillHistoryModel[] newArray(int i) {
            return new SplitBillHistoryModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public List<PayerModel> KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public int getAuthRequestContext;
    public String getErrorConfigVersion;
    public String lookAheadTest;
    private long scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ SplitBillHistoryModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public SplitBillHistoryModel() {
    }

    private SplitBillHistoryModel(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.scheduleImpl = parcel.readLong();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
        parcel.readList(arrayList, PayerModel.class.getClassLoader());
        this.getErrorConfigVersion = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
    }

    public final List<PayerModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        for (PayerModel payerModel : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if ("IN_PROGRESS".equals(payerModel.lookAheadTest)) {
                arrayList.add(payerModel);
            }
        }
        return arrayList;
    }

    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory == this.getAuthRequestContext;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeLong(this.scheduleImpl);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeList(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
