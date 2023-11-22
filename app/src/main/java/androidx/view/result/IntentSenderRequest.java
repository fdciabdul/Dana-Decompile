package androidx.view.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    };
    public final IntentSender BuiltInFictitiousFunctionClassFactory;
    public final int MyBillsEntityDataFactory;
    public final int PlaceComponentResult;
    public final Intent getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = intentSender;
        this.getAuthRequestContext = intent;
        this.PlaceComponentResult = i;
        this.MyBillsEntityDataFactory = i2;
    }

    IntentSenderRequest(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.getAuthRequestContext = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.PlaceComponentResult = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, i);
        parcel.writeParcelable(this.getAuthRequestContext, i);
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeInt(this.MyBillsEntityDataFactory);
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public int BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public Intent MyBillsEntityDataFactory;
        public IntentSender PlaceComponentResult;

        public Builder(IntentSender intentSender) {
            this.PlaceComponentResult = intentSender;
        }
    }
}
