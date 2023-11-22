package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.core.GriverParams;
import id.dana.model.ThirdPartyService;
import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JZ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0013\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\bR\u001a\u0010\u0012\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b*\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b0\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b1\u0010\b"}, d2 = {"Lid/dana/wallet_v3/model/AssetSearchRecommendationModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/utils/StringWrapper;", "component3", "()Lid/dana/utils/StringWrapper;", "component4", "component5", "Lid/dana/model/ThirdPartyService;", "component6", "()Lid/dana/model/ThirdPartyService;", "component7", "serviceType", GriverParams.ShareParams.IMAGE_URL, "title", "desc", "btnTitle", "thirdPartyService", "sectionType", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/model/ThirdPartyService;Ljava/lang/String;)Lid/dana/wallet_v3/model/AssetSearchRecommendationModel;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/utils/StringWrapper;", "getBtnTitle", "getDesc", "Ljava/lang/String;", "getImageUrl", "getSectionType", "getServiceType", "Lid/dana/model/ThirdPartyService;", "getThirdPartyService", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/model/ThirdPartyService;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AssetSearchRecommendationModel extends WalletV3CardModel {
    public static final Parcelable.Creator<AssetSearchRecommendationModel> CREATOR = new Creator();
    private final StringWrapper btnTitle;
    private final StringWrapper desc;
    private final String imageUrl;
    private final String sectionType;
    private final String serviceType;
    private final ThirdPartyService thirdPartyService;
    private final StringWrapper title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<AssetSearchRecommendationModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AssetSearchRecommendationModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new AssetSearchRecommendationModel(parcel.readString(), parcel.readString(), (StringWrapper) parcel.readParcelable(AssetSearchRecommendationModel.class.getClassLoader()), (StringWrapper) parcel.readParcelable(AssetSearchRecommendationModel.class.getClassLoader()), (StringWrapper) parcel.readParcelable(AssetSearchRecommendationModel.class.getClassLoader()), parcel.readInt() == 0 ? null : ThirdPartyService.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AssetSearchRecommendationModel[] newArray(int i) {
            return new AssetSearchRecommendationModel[i];
        }
    }

    public static /* synthetic */ AssetSearchRecommendationModel copy$default(AssetSearchRecommendationModel assetSearchRecommendationModel, String str, String str2, StringWrapper stringWrapper, StringWrapper stringWrapper2, StringWrapper stringWrapper3, ThirdPartyService thirdPartyService, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assetSearchRecommendationModel.serviceType;
        }
        if ((i & 2) != 0) {
            str2 = assetSearchRecommendationModel.imageUrl;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            stringWrapper = assetSearchRecommendationModel.title;
        }
        StringWrapper stringWrapper4 = stringWrapper;
        if ((i & 8) != 0) {
            stringWrapper2 = assetSearchRecommendationModel.desc;
        }
        StringWrapper stringWrapper5 = stringWrapper2;
        if ((i & 16) != 0) {
            stringWrapper3 = assetSearchRecommendationModel.btnTitle;
        }
        StringWrapper stringWrapper6 = stringWrapper3;
        if ((i & 32) != 0) {
            thirdPartyService = assetSearchRecommendationModel.thirdPartyService;
        }
        ThirdPartyService thirdPartyService2 = thirdPartyService;
        if ((i & 64) != 0) {
            str3 = assetSearchRecommendationModel.sectionType;
        }
        return assetSearchRecommendationModel.copy(str, str4, stringWrapper4, stringWrapper5, stringWrapper6, thirdPartyService2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getServiceType() {
        return this.serviceType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component3  reason: from getter */
    public final StringWrapper getTitle() {
        return this.title;
    }

    /* renamed from: component4  reason: from getter */
    public final StringWrapper getDesc() {
        return this.desc;
    }

    /* renamed from: component5  reason: from getter */
    public final StringWrapper getBtnTitle() {
        return this.btnTitle;
    }

    /* renamed from: component6  reason: from getter */
    public final ThirdPartyService getThirdPartyService() {
        return this.thirdPartyService;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSectionType() {
        return this.sectionType;
    }

    public final AssetSearchRecommendationModel copy(String serviceType, String imageUrl, StringWrapper title, StringWrapper desc, StringWrapper btnTitle, ThirdPartyService thirdPartyService, String sectionType) {
        Intrinsics.checkNotNullParameter(serviceType, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(desc, "");
        Intrinsics.checkNotNullParameter(btnTitle, "");
        Intrinsics.checkNotNullParameter(sectionType, "");
        return new AssetSearchRecommendationModel(serviceType, imageUrl, title, desc, btnTitle, thirdPartyService, sectionType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AssetSearchRecommendationModel) {
            AssetSearchRecommendationModel assetSearchRecommendationModel = (AssetSearchRecommendationModel) other;
            return Intrinsics.areEqual(this.serviceType, assetSearchRecommendationModel.serviceType) && Intrinsics.areEqual(this.imageUrl, assetSearchRecommendationModel.imageUrl) && Intrinsics.areEqual(this.title, assetSearchRecommendationModel.title) && Intrinsics.areEqual(this.desc, assetSearchRecommendationModel.desc) && Intrinsics.areEqual(this.btnTitle, assetSearchRecommendationModel.btnTitle) && Intrinsics.areEqual(this.thirdPartyService, assetSearchRecommendationModel.thirdPartyService) && Intrinsics.areEqual(this.sectionType, assetSearchRecommendationModel.sectionType);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.serviceType.hashCode();
        String str = this.imageUrl;
        int hashCode2 = str == null ? 0 : str.hashCode();
        int hashCode3 = this.title.hashCode();
        int hashCode4 = this.desc.hashCode();
        int hashCode5 = this.btnTitle.hashCode();
        ThirdPartyService thirdPartyService = this.thirdPartyService;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (thirdPartyService != null ? thirdPartyService.hashCode() : 0)) * 31) + this.sectionType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetSearchRecommendationModel(serviceType=");
        sb.append(this.serviceType);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", btnTitle=");
        sb.append(this.btnTitle);
        sb.append(", thirdPartyService=");
        sb.append(this.thirdPartyService);
        sb.append(", sectionType=");
        sb.append(this.sectionType);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.serviceType);
        parcel.writeString(this.imageUrl);
        parcel.writeParcelable(this.title, flags);
        parcel.writeParcelable(this.desc, flags);
        parcel.writeParcelable(this.btnTitle, flags);
        ThirdPartyService thirdPartyService = this.thirdPartyService;
        if (thirdPartyService == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            thirdPartyService.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.sectionType);
    }

    @JvmName(name = "getServiceType")
    public final String getServiceType() {
        return this.serviceType;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @JvmName(name = "getTitle")
    public final StringWrapper getTitle() {
        return this.title;
    }

    @JvmName(name = "getDesc")
    public final StringWrapper getDesc() {
        return this.desc;
    }

    @JvmName(name = "getBtnTitle")
    public final StringWrapper getBtnTitle() {
        return this.btnTitle;
    }

    @JvmName(name = "getThirdPartyService")
    public final ThirdPartyService getThirdPartyService() {
        return this.thirdPartyService;
    }

    @JvmName(name = "getSectionType")
    public final String getSectionType() {
        return this.sectionType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetSearchRecommendationModel(String str, String str2, StringWrapper stringWrapper, StringWrapper stringWrapper2, StringWrapper stringWrapper3, ThirdPartyService thirdPartyService, String str3) {
        super(16, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(stringWrapper, "");
        Intrinsics.checkNotNullParameter(stringWrapper2, "");
        Intrinsics.checkNotNullParameter(stringWrapper3, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.serviceType = str;
        this.imageUrl = str2;
        this.title = stringWrapper;
        this.desc = stringWrapper2;
        this.btnTitle = stringWrapper3;
        this.thirdPartyService = thirdPartyService;
        this.sectionType = str3;
    }
}
