package id.dana.feeds.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.feeds.ui.enums.FriendshipStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014B\u008b\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010'\u001a\u00020\r\u0012\b\b\u0002\u0010(\u001a\u00020\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010*\u001a\u00020\r\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0015\u0012\b\b\u0002\u0010.\u001a\u00020\u0007\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0007¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0012\u0010\u000b\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0012\u0010\u0018\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001d\u0010\fR\u001a\u0010\u001f\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u0016\u0010\fR\u0011\u0010 \u001a\u00020\rX\u0007¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0012\u0010\u001e\u001a\u00020\rX\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u001a\u0010\"\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u0018\u0010\fR\u0012\u0010!\u001a\u00020\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0011\u0010#\u001a\u00020\rX\u0007¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0012\u0010%\u001a\u00020\rX\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0011\u0010&\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b%\u0010\u001c"}, d2 = {"Lid/dana/feeds/ui/model/RelationshipItemModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "PlaceComponentResult", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "I", "MyBillsEntityDataFactory", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "getErrorConfigVersion", "lookAheadTest", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILid/dana/feeds/ui/enums/FriendshipStatus;ZIZZ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RelationshipItemModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final boolean PlaceComponentResult;
    public final String GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int getAuthRequestContext;
    public boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public FriendshipStatus KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final int NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String getErrorConfigVersion;
    public final String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<RelationshipItemModel> CREATOR = new Creator();

    public RelationshipItemModel() {
        this(null, null, null, null, null, null, false, 0, null, false, 0, false, false, 8191, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RelationshipItemModel) {
            RelationshipItemModel relationshipItemModel = (RelationshipItemModel) p0;
            return Intrinsics.areEqual(this.GetContactSyncConfig, relationshipItemModel.GetContactSyncConfig) && Intrinsics.areEqual(this.moveToNextValue, relationshipItemModel.moveToNextValue) && Intrinsics.areEqual(this.scheduleImpl, relationshipItemModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, relationshipItemModel.getErrorConfigVersion) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, relationshipItemModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.initRecordTimeStamp, relationshipItemModel.initRecordTimeStamp) && this.MyBillsEntityDataFactory == relationshipItemModel.MyBillsEntityDataFactory && this.getAuthRequestContext == relationshipItemModel.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == relationshipItemModel.KClassImpl$Data$declaredNonStaticMembers$2 && this.PlaceComponentResult == relationshipItemModel.PlaceComponentResult && this.NetworkUserEntityData$$ExternalSyntheticLambda2 == relationshipItemModel.NetworkUserEntityData$$ExternalSyntheticLambda2 && this.lookAheadTest == relationshipItemModel.lookAheadTest && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == relationshipItemModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.GetContactSyncConfig.hashCode();
        int hashCode2 = this.moveToNextValue.hashCode();
        int hashCode3 = this.scheduleImpl.hashCode();
        int hashCode4 = this.getErrorConfigVersion.hashCode();
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = str == null ? 0 : str.hashCode();
        int hashCode6 = this.initRecordTimeStamp.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = this.getAuthRequestContext;
        int hashCode7 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        boolean z2 = this.PlaceComponentResult;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        boolean z3 = this.lookAheadTest;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        boolean z4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + i2) * 31) + hashCode7) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RelationshipItemModel(GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        p0.writeInt(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2.name());
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeInt(this.lookAheadTest ? 1 : 0);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
    }

    public RelationshipItemModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, FriendshipStatus friendshipStatus, boolean z2, int i2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(friendshipStatus, "");
        this.GetContactSyncConfig = str;
        this.moveToNextValue = str2;
        this.scheduleImpl = str3;
        this.getErrorConfigVersion = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.initRecordTimeStamp = str6;
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = friendshipStatus;
        this.PlaceComponentResult = z2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i2;
        this.lookAheadTest = z3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z4;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public /* synthetic */ RelationshipItemModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, FriendshipStatus friendshipStatus, boolean z2, int i2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) == 0 ? str6 : "", (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? 0 : i, (i3 & 256) != 0 ? FriendshipStatus.EMPTY : friendshipStatus, (i3 & 512) != 0 ? false : z2, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? true : z3, (i3 & 4096) == 0 ? z4 : false);
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getLookAheadTest() {
        return this.lookAheadTest;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Intrinsics.areEqual(this.getErrorConfigVersion, "SELF");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/feeds/ui/model/RelationshipItemModel$Companion;", "", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/feeds/ui/model/RelationshipItemModel;", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "p0", "getAuthRequestContext", "(Lid/dana/feeds/ui/model/ActivityReactionsUserModel;)Lid/dana/feeds/ui/model/RelationshipItemModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static RelationshipItemModel BuiltInFictitiousFunctionClassFactory() {
            return new RelationshipItemModel(null, null, null, null, null, null, false, 0, null, false, 1, false, false, 7167, null);
        }

        public static RelationshipItemModel getAuthRequestContext(ActivityReactionsUserModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String str = p0.PlaceComponentResult;
            String str2 = str == null ? "" : str;
            String str3 = p0.getAuthRequestContext;
            String str4 = str3 == null ? "" : str3;
            String str5 = p0.BuiltInFictitiousFunctionClassFactory;
            return new RelationshipItemModel(str2, str4, str5 == null ? "" : str5, "", p0.NetworkUserEntityData$$ExternalSyntheticLambda0, null, false, 0, null, false, 0, false, false, 8160, null);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<RelationshipItemModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RelationshipItemModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new RelationshipItemModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), FriendshipStatus.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RelationshipItemModel[] newArray(int i) {
            return new RelationshipItemModel[i];
        }
    }
}
