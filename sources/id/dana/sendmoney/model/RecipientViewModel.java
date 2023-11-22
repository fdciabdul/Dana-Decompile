package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;

/* loaded from: classes5.dex */
public class RecipientViewModel extends BaseRecipientModel implements Parcelable {
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    public int PrepareContext;
    public static final DiffUtil.ItemCallback<RecipientViewModel> newProxyInstance = new DiffUtil.ItemCallback<RecipientViewModel>() { // from class: id.dana.sendmoney.model.RecipientViewModel.1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return BuiltInFictitiousFunctionClassFactory(recipientViewModel, recipientViewModel2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean getAuthRequestContext(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return MyBillsEntityDataFactory(recipientViewModel, recipientViewModel2);
        }

        private static boolean MyBillsEntityDataFactory(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return recipientViewModel.toString().equals(recipientViewModel2.toString());
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return recipientViewModel.toString().equals(recipientViewModel2.toString());
        }
    };
    public static final Parcelable.Creator<RecipientViewModel> CREATOR = new Parcelable.Creator<RecipientViewModel>() { // from class: id.dana.sendmoney.model.RecipientViewModel.2
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RecipientViewModel createFromParcel(Parcel parcel) {
            return new RecipientViewModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecipientViewModel[] newArray(int i) {
            return new RecipientViewModel[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RecipientViewModel(int i) {
        this.PrepareContext = i;
    }

    public RecipientViewModel(int i, String str) {
        this.PrepareContext = i;
        this.getErrorConfigVersion = str;
    }

    protected RecipientViewModel(Parcel parcel) {
        this.PrepareContext = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(KClassImpl$Data$declaredNonStaticMembers$2());
        parcel.writeString(PlaceComponentResult());
        parcel.writeString(BuiltInFictitiousFunctionClassFactory());
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(NetworkUserEntityData$$ExternalSyntheticLambda0());
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeLong(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(MyBillsEntityDataFactory());
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeInt(this.PrepareContext);
        parcel.writeValue(Boolean.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
        parcel.writeInt(this.moveToNextValue.intValue());
    }
}
