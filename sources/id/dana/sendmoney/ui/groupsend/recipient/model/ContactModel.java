package id.dana.sendmoney.ui.groupsend.recipient.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import id.dana.data.util.NumberUtils;

/* loaded from: classes9.dex */
public class ContactModel implements Parcelable {
    private String BuiltInFictitiousFunctionClassFactory;
    private String MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String PlaceComponentResult;
    private int getAuthRequestContext;
    private String getErrorConfigVersion;
    private String lookAheadTest;
    private String moveToNextValue;
    public static final DiffUtil.ItemCallback<ContactModel> KClassImpl$Data$declaredNonStaticMembers$2 = new DiffUtil.ItemCallback<ContactModel>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.model.ContactModel.1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ContactModel contactModel, ContactModel contactModel2) {
            return getAuthRequestContext2(contactModel, contactModel2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean getAuthRequestContext(ContactModel contactModel, ContactModel contactModel2) {
            return BuiltInFictitiousFunctionClassFactory(contactModel, contactModel2);
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(ContactModel contactModel, ContactModel contactModel2) {
            return contactModel.toString().equals(contactModel2.toString());
        }

        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
        private static boolean getAuthRequestContext2(ContactModel contactModel, ContactModel contactModel2) {
            return contactModel.toString().equals(contactModel2.toString());
        }
    };
    public static final Parcelable.Creator<ContactModel> CREATOR = new Parcelable.Creator<ContactModel>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.model.ContactModel.2
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ContactModel createFromParcel(Parcel parcel) {
            return new ContactModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactModel[] newArray(int i) {
            return new ContactModel[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ContactModel(Parcel parcel) {
        this.getAuthRequestContext = parcel.readInt();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.moveToNextValue = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.getAuthRequestContext);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.moveToNextValue);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.lookAheadTest);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && toString().equals(obj.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactModel{contactId=");
        sb.append(this.getAuthRequestContext);
        sb.append(", displayName='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('\'');
        sb.append(", displayPhoto='");
        sb.append(this.moveToNextValue);
        sb.append('\'');
        sb.append(", phoneNumber='");
        sb.append(NumberUtils.getClearPhoneNumber(this.getErrorConfigVersion));
        sb.append('\'');
        sb.append(", viewType=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append('}');
        return sb.toString();
    }
}
