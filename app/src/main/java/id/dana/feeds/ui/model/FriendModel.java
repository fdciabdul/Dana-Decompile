package id.dana.feeds.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.ui.enums.FriendshipStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012Bu\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u000b\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020!\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0007\u0012\b\b\u0002\u0010.\u001a\u00020\u001e\u0012\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0011\u0010\u0018\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0011\u0010 \u001a\u00020\u001eX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0012\u0010#\u001a\u00020!X\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\"R\u0011\u0010\u0013\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0011\u0010$\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0011\u0010&\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/feeds/ui/model/FriendModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "PlaceComponentResult", "getErrorConfigVersion", "", "J", "moveToNextValue", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "scheduleImpl", "lookAheadTest", "I", "initRecordTimeStamp", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/feeds/ui/enums/FriendshipStatus;Ljava/lang/String;Ljava/lang/String;IZJZ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FriendModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final long moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final int initRecordTimeStamp;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public FriendshipStatus scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FriendModel> CREATOR = new Creator();

    public FriendModel() {
        this(null, null, null, false, null, null, null, 0, false, 0L, false, 2047, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FriendModel) {
            FriendModel friendModel = (FriendModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, friendModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getErrorConfigVersion, friendModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, friendModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.PlaceComponentResult == friendModel.PlaceComponentResult && this.scheduleImpl == friendModel.scheduleImpl && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, friendModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.lookAheadTest, friendModel.lookAheadTest) && this.initRecordTimeStamp == friendModel.initRecordTimeStamp && this.MyBillsEntityDataFactory == friendModel.MyBillsEntityDataFactory && this.moveToNextValue == friendModel.moveToNextValue && this.getAuthRequestContext == friendModel.getAuthRequestContext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode2 = this.getErrorConfigVersion.hashCode();
        int hashCode3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        boolean z = this.PlaceComponentResult;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode4 = this.scheduleImpl.hashCode();
        int hashCode5 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode6 = this.lookAheadTest.hashCode();
        int i2 = this.initRecordTimeStamp;
        boolean z2 = this.MyBillsEntityDataFactory;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.moveToNextValue);
        boolean z3 = this.getAuthRequestContext;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i2) * 31) + i3) * 31) + m) * 31) + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FriendModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeInt(this.PlaceComponentResult ? 1 : 0);
        p0.writeString(this.scheduleImpl.name());
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.lookAheadTest);
        p0.writeInt(this.initRecordTimeStamp);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        p0.writeLong(this.moveToNextValue);
        p0.writeInt(this.getAuthRequestContext ? 1 : 0);
    }

    public FriendModel(String str, String str2, String str3, boolean z, FriendshipStatus friendshipStatus, String str4, String str5, int i, boolean z2, long j, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(friendshipStatus, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getErrorConfigVersion = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str3;
        this.PlaceComponentResult = z;
        this.scheduleImpl = friendshipStatus;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.lookAheadTest = str5;
        this.initRecordTimeStamp = i;
        this.MyBillsEntityDataFactory = z2;
        this.moveToNextValue = j;
        this.getAuthRequestContext = z3;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public /* synthetic */ FriendModel(String str, String str2, String str3, boolean z, FriendshipStatus friendshipStatus, String str4, String str5, int i, boolean z2, long j, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? FriendshipStatus.NOT_AFFILIATED : friendshipStatus, (i2 & 32) != 0 ? "" : str4, (i2 & 64) == 0 ? str5 : "", (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? false : z2, (i2 & 512) != 0 ? 0L : j, (i2 & 1024) == 0 ? z3 : false);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0006\u0010\rJ\u0011\u0010\u0003\u001a\u00020\u0002*\u00020\u000e¢\u0006\u0004\b\u0003\u0010\u000f"}, d2 = {"Lid/dana/feeds/ui/model/FriendModel$Companion;", "", "Lid/dana/feeds/ui/model/FriendModel;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/feeds/ui/model/FriendModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "p0", "Lid/dana/feeds/ui/enums/FriendshipStatus;", "(Ljava/lang/String;)Lid/dana/feeds/ui/enums/FriendshipStatus;", "Lid/dana/feeds/domain/friend/model/Friend;", "(Lid/dana/feeds/domain/friend/model/Friend;)Lid/dana/feeds/ui/model/FriendModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FriendModel getAuthRequestContext() {
            return new FriendModel(null, null, null, false, null, null, null, 1, false, 0L, false, 1919, null);
        }

        public static FriendModel MyBillsEntityDataFactory() {
            return new FriendModel(null, null, null, false, null, null, null, 3, false, 0L, false, 1919, null);
        }

        public static FriendModel PlaceComponentResult() {
            return new FriendModel(null, null, null, false, null, null, null, 2, false, 0L, false, 1919, null);
        }

        public static FriendModel BuiltInFictitiousFunctionClassFactory() {
            return new FriendModel(null, null, null, false, null, null, null, 4, false, 0L, false, 1919, null);
        }

        public static FriendModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new FriendModel(null, null, null, false, null, null, null, 5, false, 0L, false, 1919, null);
        }

        public static FriendModel NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return new FriendModel(null, null, null, false, null, null, null, 6, false, 0L, false, 1919, null);
        }

        public static FriendModel BuiltInFictitiousFunctionClassFactory(Friend friend) {
            Intrinsics.checkNotNullParameter(friend, "");
            String avatar = friend.getAvatar();
            String userId = friend.getUserId();
            String username = friend.getUsername();
            String kycName = friend.getKycName();
            return new FriendModel(null, avatar, userId, false, MyBillsEntityDataFactory(friend.getStatus()), kycName, username, 0, friend.getDefaultUsername(), friend.getRequestDate(), friend.getIsRequester(), 9, null);
        }

        private static FriendshipStatus MyBillsEntityDataFactory(String p0) {
            try {
                return FriendshipStatus.valueOf(p0);
            } catch (IllegalArgumentException unused) {
                return FriendshipStatus.ERROR;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<FriendModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FriendModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new FriendModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, FriendshipStatus.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readLong(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FriendModel[] newArray(int i) {
            return new FriendModel[i];
        }
    }
}
