package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: androidx.fragment.app.FragmentManagerState.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    ArrayList<String> BuiltInFictitiousFunctionClassFactory;
    ArrayList<String> KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    ArrayList<String> PlaceComponentResult;
    BackStackRecordState[] getAuthRequestContext;
    ArrayList<FragmentManager.LaunchedFragmentInfo> getErrorConfigVersion;
    String lookAheadTest;
    ArrayList<BackStackState> scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
        this.lookAheadTest = null;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
        this.scheduleImpl = new ArrayList<>();
    }

    public FragmentManagerState(Parcel parcel) {
        this.lookAheadTest = null;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
        this.scheduleImpl = new ArrayList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.createStringArrayList();
        this.PlaceComponentResult = parcel.createStringArrayList();
        this.getAuthRequestContext = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.MyBillsEntityDataFactory = parcel.readInt();
        this.lookAheadTest = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.createStringArrayList();
        this.scheduleImpl = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.getErrorConfigVersion = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeStringList(this.PlaceComponentResult);
        parcel.writeTypedArray(this.getAuthRequestContext, i);
        parcel.writeInt(this.MyBillsEntityDataFactory);
        parcel.writeString(this.lookAheadTest);
        parcel.writeStringList(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeTypedList(this.scheduleImpl);
        parcel.writeTypedList(this.getErrorConfigVersion);
    }
}
