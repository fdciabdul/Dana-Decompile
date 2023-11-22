package id.dana.richview.boundcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.domain.payasset.model.Institution;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class BoundCard implements Parcelable {
    public static final Parcelable.Creator<BoundCard> CREATOR = new Parcelable.Creator<BoundCard>() { // from class: id.dana.richview.boundcard.model.BoundCard.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BoundCard createFromParcel(Parcel parcel) {
            return new BoundCard(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BoundCard[] newArray(int i) {
            return new BoundCard[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String DatabaseTableConfigUtil;
    private Double FragmentBottomSheetPaymentSettingBinding;
    public String GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public List<PayChannelOptionViewDTO> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String NetworkUserEntityData$$ExternalSyntheticLambda3;
    private String NetworkUserEntityData$$ExternalSyntheticLambda6;
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    private String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public String PlaceComponentResult;
    private String PrepareContext;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String initRecordTimeStamp;
    public String isLayoutRequested;
    public String lookAheadTest;
    public Boolean moveToNextValue;
    private Double newProxyInstance;
    public boolean scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BoundCard() {
    }

    protected BoundCard(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.moveToNextValue = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.getErrorConfigVersion = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.initRecordTimeStamp = parcel.readString();
        this.GetContactSyncConfig = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = arrayList;
        parcel.readList(arrayList, PayChannelOptionViewDTO.class.getClassLoader());
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parcel.readString();
        this.PrepareContext = parcel.readString();
        this.newProxyInstance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = parcel.readString();
        this.FragmentBottomSheetPaymentSettingBinding = (Double) parcel.readValue(Double.class.getClassLoader());
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = parcel.readString();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return "BALANCE".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
    }

    public final boolean PlaceComponentResult() {
        return "DIRECT_DEBIT_CREDIT_CARD".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda7) || "DIRECT_DEBIT_DEBIT_CARD".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return Institution.BCA_ONEKLIK.equalsIgnoreCase(this.lookAheadTest);
    }

    public final boolean scheduleImpl() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeValue(this.moveToNextValue);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.GetContactSyncConfig);
        parcel.writeList(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeString(this.PrepareContext);
        parcel.writeValue(this.newProxyInstance);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        parcel.writeValue(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.scheduleImpl;
    }

    public final boolean MyBillsEntityDataFactory() {
        return "ADD_CARD".equalsIgnoreCase(this.BuiltInFictitiousFunctionClassFactory);
    }

    public final boolean getAuthRequestContext() {
        return !TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory) || "DEBIT_CARD".equals(this.PlaceComponentResult);
    }
}
