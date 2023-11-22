package androidx.view.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: androidx.activity.result.ActivityResult.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ActivityResult[] newArray(int i) {
            return new ActivityResult[i];
        }
    };
    public final int BuiltInFictitiousFunctionClassFactory;
    public final Intent MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ActivityResult(int i, Intent intent) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = intent;
    }

    ActivityResult(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityResult{resultCode=");
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i != -1) {
            str = i != 0 ? String.valueOf(i) : "RESULT_CANCELED";
        } else {
            str = "RESULT_OK";
        }
        sb.append(str);
        sb.append(", data=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.MyBillsEntityDataFactory == null ? 0 : 1);
        Intent intent = this.MyBillsEntityDataFactory;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}
