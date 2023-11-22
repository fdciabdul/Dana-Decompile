package id.dana.nearbyme.merchantdetail.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B9\u0012\b\b\u0002\u0010\u0006\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u001a"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "I", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantImageModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MerchantImageModel> CREATOR = new Creator();

    public MerchantImageModel() {
        this(null, null, null, null, 0, 31, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantImageModel) {
            MerchantImageModel merchantImageModel = (MerchantImageModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, merchantImageModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, merchantImageModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, merchantImageModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantImageModel.BuiltInFictitiousFunctionClassFactory) && this.MyBillsEntityDataFactory == merchantImageModel.MyBillsEntityDataFactory;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.getAuthRequestContext.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.MyBillsEntityDataFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantImageModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeInt(this.MyBillsEntityDataFactory);
    }

    public MerchantImageModel(String str, String str2, String str3, String str4, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.MyBillsEntityDataFactory = i;
    }

    public /* synthetic */ MerchantImageModel(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? 0 : i);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory == 3;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel$Companion;", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "p0", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "getAuthRequestContext", "(Lid/dana/feeds/domain/timeline/model/ActivityResponse;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static List<MerchantImageModel> getAuthRequestContext(ActivityResponse p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ArrayList arrayList = new ArrayList();
            List<String> imageUrls = p0.getImageUrls();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageUrls, 10));
            for (String str : imageUrls) {
                HashMap<String, String> extendInfo = p0.getExtendInfo();
                String userId = extendInfo != null ? ExtendInfoUtilKt.getUserId(extendInfo) : null;
                String str2 = userId == null ? "" : userId;
                HashMap<String, String> extendInfo2 = p0.getExtendInfo();
                String displayName = extendInfo2 != null ? ExtendInfoUtilKt.getDisplayName(extendInfo2) : null;
                String str3 = displayName == null ? "" : displayName;
                HashMap<String, String> extendInfo3 = p0.getExtendInfo();
                String profileAvatar = extendInfo3 != null ? ExtendInfoUtilKt.getProfileAvatar(extendInfo3) : null;
                arrayList2.add(Boolean.valueOf(arrayList.add(new MerchantImageModel(str2, str3, profileAvatar == null ? "" : profileAvatar, str, 1))));
            }
            return arrayList;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MerchantImageModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MerchantImageModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MerchantImageModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MerchantImageModel[] newArray(int i) {
            return new MerchantImageModel[i];
        }
    }

    public static /* synthetic */ MerchantImageModel KClassImpl$Data$declaredNonStaticMembers$2(MerchantImageModel merchantImageModel) {
        String str = merchantImageModel.getAuthRequestContext;
        String str2 = merchantImageModel.PlaceComponentResult;
        String str3 = merchantImageModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str4 = merchantImageModel.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        return new MerchantImageModel(str, str2, str3, str4, 2);
    }
}
