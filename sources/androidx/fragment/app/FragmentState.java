package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.view.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: androidx.fragment.app.FragmentState.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final boolean BuiltInFictitiousFunctionClassFactory;
    final String DatabaseTableConfigUtil;
    Bundle GetContactSyncConfig;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final Bundle MyBillsEntityDataFactory;
    final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    final String PlaceComponentResult;
    final int getAuthRequestContext;
    final int getErrorConfigVersion;
    final String initRecordTimeStamp;
    final boolean lookAheadTest;
    final boolean moveToNextValue;
    final boolean scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState(Fragment fragment) {
        this.PlaceComponentResult = fragment.getClass().getName();
        this.initRecordTimeStamp = fragment.mWho;
        this.scheduleImpl = fragment.mFromLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragment.mFragmentId;
        this.getAuthRequestContext = fragment.mContainerId;
        this.DatabaseTableConfigUtil = fragment.mTag;
        this.lookAheadTest = fragment.mRetainInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fragment.mRemoving;
        this.BuiltInFictitiousFunctionClassFactory = fragment.mDetached;
        this.MyBillsEntityDataFactory = fragment.mArguments;
        this.moveToNextValue = fragment.mHidden;
        this.getErrorConfigVersion = fragment.mMaxState.ordinal();
    }

    FragmentState(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.initRecordTimeStamp = parcel.readString();
        this.scheduleImpl = parcel.readInt() != 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
        this.getAuthRequestContext = parcel.readInt();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.lookAheadTest = parcel.readInt() != 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readInt() != 0;
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt() != 0;
        this.MyBillsEntityDataFactory = parcel.readBundle();
        this.moveToNextValue = parcel.readInt() != 0;
        this.GetContactSyncConfig = parcel.readBundle();
        this.getErrorConfigVersion = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Fragment KClassImpl$Data$declaredNonStaticMembers$2(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        Fragment authRequestContext = fragmentFactory.getAuthRequestContext(classLoader, this.PlaceComponentResult);
        Bundle bundle = this.MyBillsEntityDataFactory;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        authRequestContext.setArguments(this.MyBillsEntityDataFactory);
        authRequestContext.mWho = this.initRecordTimeStamp;
        authRequestContext.mFromLayout = this.scheduleImpl;
        authRequestContext.mRestored = true;
        authRequestContext.mFragmentId = this.KClassImpl$Data$declaredNonStaticMembers$2;
        authRequestContext.mContainerId = this.getAuthRequestContext;
        authRequestContext.mTag = this.DatabaseTableConfigUtil;
        authRequestContext.mRetainInstance = this.lookAheadTest;
        authRequestContext.mRemoving = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        authRequestContext.mDetached = this.BuiltInFictitiousFunctionClassFactory;
        authRequestContext.mHidden = this.moveToNextValue;
        authRequestContext.mMaxState = Lifecycle.State.values()[this.getErrorConfigVersion];
        Bundle bundle2 = this.GetContactSyncConfig;
        if (bundle2 != null) {
            authRequestContext.mSavedFragmentState = bundle2;
        } else {
            authRequestContext.mSavedFragmentState = new Bundle();
        }
        return authRequestContext;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.PlaceComponentResult);
        sb.append(" (");
        sb.append(this.initRecordTimeStamp);
        sb.append(")}:");
        if (this.scheduleImpl) {
            sb.append(" fromLayout");
        }
        if (this.getAuthRequestContext != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.getAuthRequestContext));
        }
        String str = this.DatabaseTableConfigUtil;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.DatabaseTableConfigUtil);
        }
        if (this.lookAheadTest) {
            sb.append(" retainInstance");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            sb.append(" removing");
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            sb.append(" detached");
        }
        if (this.moveToNextValue) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeInt(this.scheduleImpl ? 1 : 0);
        parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeInt(this.getAuthRequestContext);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeInt(this.lookAheadTest ? 1 : 0);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
        parcel.writeBundle(this.MyBillsEntityDataFactory);
        parcel.writeInt(this.moveToNextValue ? 1 : 0);
        parcel.writeBundle(this.GetContactSyncConfig);
        parcel.writeInt(this.getErrorConfigVersion);
    }
}
