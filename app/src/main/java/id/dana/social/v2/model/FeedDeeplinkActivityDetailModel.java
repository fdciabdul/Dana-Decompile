package id.dana.social.v2.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.social.model.FeedModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00128\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\f\u0010\u0015R\u001a\u0010\u0010\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/social/v2/model/FeedDeeplinkActivityDetailModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/social/model/FeedModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/model/FeedModel;", "", "MyBillsEntityDataFactory", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "p3", "p4", "<init>", "(Lid/dana/social/model/FeedModel;Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedDeeplinkActivityDetailModel implements Parcelable {
    public static final Parcelable.Creator<FeedDeeplinkActivityDetailModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final FeedModel getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.writeToParcel(p0, p1);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
    }

    public FeedDeeplinkActivityDetailModel(FeedModel feedModel, String str, String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getAuthRequestContext = feedModel;
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.BuiltInFictitiousFunctionClassFactory = z2;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<FeedDeeplinkActivityDetailModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FeedDeeplinkActivityDetailModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new FeedDeeplinkActivityDetailModel(FeedModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FeedDeeplinkActivityDetailModel[] newArray(int i) {
            return new FeedDeeplinkActivityDetailModel[i];
        }
    }
}
