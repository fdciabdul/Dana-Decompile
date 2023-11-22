package id.dana.savings.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\n\u0012\u0006\u0010$\u001a\u00020\n\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010'\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b\u0018\u0010 "}, d2 = {"Lid/dana/savings/model/SavingCategoryModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "BuiltInFictitiousFunctionClassFactory", "(I)Ljava/lang/String;", "hashCode", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "getErrorConfigVersion", "moveToNextValue", "Z", "()Z", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SavingCategoryModel implements Parcelable {
    public static final Parcelable.Creator<SavingCategoryModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean moveToNextValue;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SavingCategoryModel) {
            SavingCategoryModel savingCategoryModel = (SavingCategoryModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, savingCategoryModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, savingCategoryModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, savingCategoryModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, savingCategoryModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, savingCategoryModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, savingCategoryModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, savingCategoryModel.getAuthRequestContext) && Intrinsics.areEqual(this.lookAheadTest, savingCategoryModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, savingCategoryModel.scheduleImpl);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.scheduleImpl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingCategoryModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.scheduleImpl);
    }

    public SavingCategoryModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getErrorConfigVersion = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.MyBillsEntityDataFactory = str5;
        this.PlaceComponentResult = str6;
        this.getAuthRequestContext = str7;
        this.lookAheadTest = str8;
        this.scheduleImpl = str9;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    public final String BuiltInFictitiousFunctionClassFactory(int p0) {
        if (p0 != 1) {
            if (p0 == 2) {
                return this.PlaceComponentResult;
            }
            if (p0 == 3) {
                return this.getAuthRequestContext;
            }
            if (p0 == 4) {
                return this.lookAheadTest;
            }
            if (p0 == 5) {
                return this.scheduleImpl;
            }
        }
        return this.MyBillsEntityDataFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SavingCategoryModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SavingCategoryModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new SavingCategoryModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SavingCategoryModel[] newArray(int i) {
            return new SavingCategoryModel[i];
        }
    }
}
