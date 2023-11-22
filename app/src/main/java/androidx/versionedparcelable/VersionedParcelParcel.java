package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
class VersionedParcelParcel extends VersionedParcel {
    private final String GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final Parcel NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final int PlaceComponentResult;
    private final int getErrorConfigVersion;
    private int lookAheadTest;
    private final SparseIntArray moveToNextValue;
    private int scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelParcel(Parcel parcel, int i, int i2, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.moveToNextValue = new SparseIntArray();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.lookAheadTest = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel;
        this.getErrorConfigVersion = i;
        this.PlaceComponentResult = i2;
        this.scheduleImpl = i;
        this.GetContactSyncConfig = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean getAuthRequestContext(int i) {
        while (this.scheduleImpl < this.PlaceComponentResult) {
            int i2 = this.lookAheadTest;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setDataPosition(this.scheduleImpl);
            int readInt = this.NetworkUserEntityData$$ExternalSyntheticLambda0.readInt();
            this.lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda0.readInt();
            this.scheduleImpl += readInt;
        }
        return this.lookAheadTest == i;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void MyBillsEntityDataFactory(int i) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.moveToNextValue.put(i, this.NetworkUserEntityData$$ExternalSyntheticLambda0.dataPosition());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i >= 0) {
            int i2 = this.moveToNextValue.get(i);
            int dataPosition = this.NetworkUserEntityData$$ExternalSyntheticLambda0.dataPosition();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setDataPosition(i2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(dataPosition - i2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected final VersionedParcel getAuthRequestContext() {
        Parcel parcel = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int dataPosition = parcel.dataPosition();
        int i = this.scheduleImpl;
        if (i == this.getErrorConfigVersion) {
            i = this.PlaceComponentResult;
        }
        int i2 = i;
        StringBuilder sb = new StringBuilder();
        sb.append(this.GetContactSyncConfig);
        sb.append("  ");
        return new VersionedParcelParcel(parcel, dataPosition, i2, sb.toString(), this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void PlaceComponentResult(byte[] bArr) {
        if (bArr != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(bArr.length);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeByteArray(bArr);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void BuiltInFictitiousFunctionClassFactory(Parcelable parcelable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void MyBillsEntityDataFactory(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected final void PlaceComponentResult(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int scheduleImpl() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String moveToNextValue() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] PlaceComponentResult() {
        int readInt = this.NetworkUserEntityData$$ExternalSyntheticLambda0.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final <T extends Parcelable> T getErrorConfigVersion() {
        return (T) this.NetworkUserEntityData$$ExternalSyntheticLambda0.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.readInt() != 0;
    }
}
