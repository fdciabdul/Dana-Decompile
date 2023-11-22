package id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import id.dana.sendmoney.ui.groupsend.recipient.model.BaseRecipientModel;

/* loaded from: classes3.dex */
public class RecipientViewModel extends BaseRecipientModel implements Parcelable {
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    public int getSupportButtonTintMode;
    public static final DiffUtil.ItemCallback<RecipientViewModel> getCallingPid = new DiffUtil.ItemCallback<RecipientViewModel>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel.1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return getAuthRequestContext2(recipientViewModel, recipientViewModel2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean getAuthRequestContext(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return PlaceComponentResult(recipientViewModel, recipientViewModel2);
        }

        private static boolean PlaceComponentResult(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return recipientViewModel.toString().equals(recipientViewModel2.toString());
        }

        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
        private static boolean getAuthRequestContext2(RecipientViewModel recipientViewModel, RecipientViewModel recipientViewModel2) {
            return recipientViewModel.toString().equals(recipientViewModel2.toString());
        }
    };
    public static final Parcelable.Creator<RecipientViewModel> CREATOR = new Parcelable.Creator<RecipientViewModel>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel.2
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
        this.getSupportButtonTintMode = i;
    }

    public RecipientViewModel(int i, String str) {
        this.getSupportButtonTintMode = i;
        this.DatabaseTableConfigUtil = str;
    }

    protected RecipientViewModel(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.initRecordTimeStamp = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = parcel.readString();
        this.newProxyInstance = parcel.readString();
        this.PrepareContext = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readLong();
        this.isLayoutRequested = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = parcel.readInt();
        this.getAuthRequestContext = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.getSupportButtonTintMode = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        parcel.writeString(this.newProxyInstance);
        parcel.writeString(this.PrepareContext);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeLong(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeString(this.isLayoutRequested);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.getSupportButtonTintMode);
        parcel.writeByte(this.NetworkUserEntityData$$ExternalSyntheticLambda5 ? (byte) 1 : (byte) 0);
    }
}
