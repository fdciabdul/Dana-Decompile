package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.Lifecycle;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new Parcelable.Creator<BackStackRecordState>() { // from class: androidx.fragment.app.BackStackRecordState.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BackStackRecordState[] newArray(int i) {
            return new BackStackRecordState[i];
        }
    };
    final int BuiltInFictitiousFunctionClassFactory;
    final ArrayList<String> GetContactSyncConfig;
    final CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
    final CharSequence MyBillsEntityDataFactory;
    final ArrayList<String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    final ArrayList<String> NetworkUserEntityData$$ExternalSyntheticLambda2;
    final int[] PlaceComponentResult;
    final int getAuthRequestContext;
    final int getErrorConfigVersion;
    final int initRecordTimeStamp;
    final int[] lookAheadTest;
    final int[] moveToNextValue;
    final String scheduleImpl;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackStackRecordState(BackStackRecord backStackRecord) {
        int size = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.size();
        this.moveToNextValue = new int[size * 6];
        if (!backStackRecord.scheduleImpl) {
            throw new IllegalStateException("Not on back stack");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>(size);
        this.lookAheadTest = new int[size];
        this.PlaceComponentResult = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            FragmentTransaction.Op op = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i);
            int i3 = i2 + 1;
            this.moveToNextValue[i2] = op.PlaceComponentResult;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(op.BuiltInFictitiousFunctionClassFactory != null ? op.BuiltInFictitiousFunctionClassFactory.mWho : null);
            int i4 = i3 + 1;
            this.moveToNextValue[i3] = op.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0;
            int i5 = i4 + 1;
            this.moveToNextValue[i4] = op.getAuthRequestContext;
            int i6 = i5 + 1;
            this.moveToNextValue[i5] = op.MyBillsEntityDataFactory;
            int i7 = i6 + 1;
            this.moveToNextValue[i6] = op.scheduleImpl;
            this.moveToNextValue[i7] = op.moveToNextValue;
            this.lookAheadTest[i] = op.lookAheadTest.ordinal();
            this.PlaceComponentResult[i] = op.KClassImpl$Data$declaredNonStaticMembers$2.ordinal();
            i++;
            i2 = i7 + 1;
        }
        this.initRecordTimeStamp = backStackRecord.FragmentBottomSheetPaymentSettingBinding;
        this.scheduleImpl = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.getErrorConfigVersion = backStackRecord.BuiltInFictitiousFunctionClassFactory;
        this.getAuthRequestContext = backStackRecord.initRecordTimeStamp;
        this.MyBillsEntityDataFactory = backStackRecord.DatabaseTableConfigUtil;
        this.BuiltInFictitiousFunctionClassFactory = backStackRecord.getErrorConfigVersion;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = backStackRecord.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.GetContactSyncConfig = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = backStackRecord.isLayoutRequested;
    }

    BackStackRecordState(Parcel parcel) {
        this.moveToNextValue = parcel.createIntArray();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.createStringArrayList();
        this.lookAheadTest = parcel.createIntArray();
        this.PlaceComponentResult = parcel.createIntArray();
        this.initRecordTimeStamp = parcel.readInt();
        this.scheduleImpl = parcel.readString();
        this.getErrorConfigVersion = parcel.readInt();
        this.getAuthRequestContext = parcel.readInt();
        this.MyBillsEntityDataFactory = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.createStringArrayList();
        this.GetContactSyncConfig = parcel.createStringArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(BackStackRecord backStackRecord) {
        int i = 0;
        int i2 = 0;
        while (i < this.moveToNextValue.length) {
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i3 = i + 1;
            op.PlaceComponentResult = this.moveToNextValue[i];
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(backStackRecord);
                sb.append(" op #");
                sb.append(i2);
                sb.append(" base fragment #");
                sb.append(this.moveToNextValue[i3]);
                InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
            }
            op.lookAheadTest = Lifecycle.State.values()[this.lookAheadTest[i2]];
            op.KClassImpl$Data$declaredNonStaticMembers$2 = Lifecycle.State.values()[this.PlaceComponentResult[i2]];
            int i4 = i3 + 1;
            op.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.moveToNextValue[i3] != 0;
            int i5 = i4 + 1;
            op.getAuthRequestContext = this.moveToNextValue[i4];
            int i6 = i5 + 1;
            op.MyBillsEntityDataFactory = this.moveToNextValue[i5];
            int i7 = i6 + 1;
            op.scheduleImpl = this.moveToNextValue[i6];
            op.moveToNextValue = this.moveToNextValue[i7];
            backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda2 = op.getAuthRequestContext;
            backStackRecord.GetContactSyncConfig = op.MyBillsEntityDataFactory;
            backStackRecord.newProxyInstance = op.scheduleImpl;
            backStackRecord.PrepareContext = op.moveToNextValue;
            backStackRecord.BuiltInFictitiousFunctionClassFactory(op);
            i2++;
            i = i7 + 1;
        }
        backStackRecord.FragmentBottomSheetPaymentSettingBinding = this.initRecordTimeStamp;
        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.scheduleImpl;
        backStackRecord.scheduleImpl = true;
        backStackRecord.initRecordTimeStamp = this.getAuthRequestContext;
        backStackRecord.DatabaseTableConfigUtil = this.MyBillsEntityDataFactory;
        backStackRecord.getErrorConfigVersion = this.BuiltInFictitiousFunctionClassFactory;
        backStackRecord.lookAheadTest = this.KClassImpl$Data$declaredNonStaticMembers$2;
        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda5 = this.GetContactSyncConfig;
        backStackRecord.isLayoutRequested = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.moveToNextValue);
        parcel.writeStringList(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeIntArray(this.lookAheadTest);
        parcel.writeIntArray(this.PlaceComponentResult);
        parcel.writeInt(this.initRecordTimeStamp);
        parcel.writeString(this.scheduleImpl);
        parcel.writeInt(this.getErrorConfigVersion);
        parcel.writeInt(this.getAuthRequestContext);
        TextUtils.writeToParcel(this.MyBillsEntityDataFactory, parcel, 0);
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        TextUtils.writeToParcel(this.KClassImpl$Data$declaredNonStaticMembers$2, parcel, 0);
        parcel.writeStringList(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeStringList(this.GetContactSyncConfig);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? 1 : 0);
    }
}
