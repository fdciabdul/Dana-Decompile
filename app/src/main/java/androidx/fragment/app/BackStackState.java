package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final List<String> BuiltInFictitiousFunctionClassFactory;
    final List<BackStackRecordState> PlaceComponentResult;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.PlaceComponentResult = list2;
    }

    BackStackState(Parcel parcel) {
        this.BuiltInFictitiousFunctionClassFactory = parcel.createStringArrayList();
        this.PlaceComponentResult = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeTypedList(this.PlaceComponentResult);
    }
}
