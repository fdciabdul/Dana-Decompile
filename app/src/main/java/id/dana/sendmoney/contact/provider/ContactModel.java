package id.dana.sendmoney.contact.provider;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import id.dana.data.util.NumberUtils;

/* loaded from: classes5.dex */
public class ContactModel implements Parcelable {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public String getErrorConfigVersion;
    private int lookAheadTest;
    private int moveToNextValue;
    public static final DiffUtil.ItemCallback<ContactModel> getAuthRequestContext = new DiffUtil.ItemCallback<ContactModel>() { // from class: id.dana.sendmoney.contact.provider.ContactModel.1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ContactModel contactModel, ContactModel contactModel2) {
            return BuiltInFictitiousFunctionClassFactory(contactModel, contactModel2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* bridge */ /* synthetic */ boolean getAuthRequestContext(ContactModel contactModel, ContactModel contactModel2) {
            return getAuthRequestContext2(contactModel, contactModel2);
        }

        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
        private static boolean getAuthRequestContext2(ContactModel contactModel, ContactModel contactModel2) {
            return contactModel.toString().equals(contactModel2.toString());
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(ContactModel contactModel, ContactModel contactModel2) {
            return contactModel.toString().equals(contactModel2.toString());
        }
    };
    public static final Parcelable.Creator<ContactModel> CREATOR = new Parcelable.Creator<ContactModel>() { // from class: id.dana.sendmoney.contact.provider.ContactModel.2
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

    public ContactModel(int i, String str, String str2, String str3) {
        this.moveToNextValue = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = str2;
        this.getErrorConfigVersion = str3;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.lookAheadTest = 3;
    }

    public ContactModel(int i, String str, String str2, String str3, String str4) {
        this.moveToNextValue = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getErrorConfigVersion = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.lookAheadTest = 3;
    }

    public ContactModel() {
        this.lookAheadTest = 6;
    }

    protected ContactModel(Parcel parcel) {
        this.moveToNextValue = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.lookAheadTest = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.moveToNextValue);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeInt(this.lookAheadTest);
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
        sb.append(this.moveToNextValue);
        sb.append(", displayName='");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('\'');
        sb.append(", displayPhoto='");
        sb.append(this.PlaceComponentResult);
        sb.append('\'');
        sb.append(", phoneNumber='");
        sb.append(NumberUtils.getClearPhoneNumber(this.getErrorConfigVersion));
        sb.append('\'');
        sb.append(", viewType=");
        sb.append(this.lookAheadTest);
        sb.append('}');
        return sb.toString();
    }
}
