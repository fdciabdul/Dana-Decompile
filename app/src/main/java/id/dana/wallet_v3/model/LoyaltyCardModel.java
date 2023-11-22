package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B1\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u00068\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0010\u001a\u00020\u000f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0002\u0018\u0019"}, d2 = {"Lid/dana/wallet_v3/model/LoyaltyCardModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "isUsed", "Z", "()Z", "", "pocketId", "Ljava/lang/String;", "getPocketId", "()Ljava/lang/String;", "pocketStatus", "getPocketStatus", "pocketType", "getPocketType", "", "viewType", "I", "getViewType", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "LoadingState", "LoyaltyCard", "Lid/dana/wallet_v3/model/LoyaltyCardModel$LoyaltyCard;", "Lid/dana/wallet_v3/model/LoyaltyCardModel$LoadingState;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class LoyaltyCardModel extends WalletV3CardModel {
    private final boolean isUsed;
    private final String pocketId;
    private final String pocketStatus;
    private final String pocketType;
    private final int viewType;

    public /* synthetic */ LoyaltyCardModel(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, i);
    }

    @JvmName(name = "getPocketId")
    public String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "getPocketStatus")
    public String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "getPocketType")
    public String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "isUsed")
    /* renamed from: isUsed  reason: from getter */
    public boolean getIsUsed() {
        return this.isUsed;
    }

    @Override // id.dana.wallet_v3.model.WalletV3CardModel
    @JvmName(name = "getViewType")
    public int getViewType() {
        return this.viewType;
    }

    private LoyaltyCardModel(String str, String str2, String str3, boolean z, int i) {
        super(i, null);
        this.pocketId = str;
        this.pocketStatus = str2;
        this.pocketType = str3;
        this.isUsed = z;
        this.viewType = i;
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bV\u0010WJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J²\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b+\u0010\u0015J\u001a\u0010.\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b0\u0010\u0015J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u0004J \u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b6\u00107R\"\u0010\u001f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u0010;R\"\u0010#\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00108\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010;R(\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010>\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010AR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00108\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u0010;R\"\u0010$\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00108\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u0010;R\u001a\u0010\u001d\u001a\u00020\u00108\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001d\u0010F\u001a\u0004\b\u001d\u0010\u0012R\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00108\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u0010;R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00108\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u0010;R\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00108\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u0010;R\u001a\u0010\u001a\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\bM\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\bN\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001c\u00108\u001a\u0004\bO\u0010\u0004R\"\u0010!\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00108\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010;R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00108\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010;R\u001a\u0010\u001e\u001a\u00020\u00138\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u0010T\u001a\u0004\bU\u0010\u0015"}, d2 = {"Lid/dana/wallet_v3/model/LoyaltyCardModel$LoyaltyCard;", "Lid/dana/wallet_v3/model/LoyaltyCardModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "", "Lid/dana/wallet_v3/model/AssetCategoryModel;", "component14", "()Ljava/util/List;", "component15", "component2", "component3", "", "component4", "()Z", "", "component5", "()I", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "pocketType", "isUsed", "viewType", "backgroundUrl", "createdDate", "point", "merchantName", "cardNumber", "iconUrl", DecodedScanBizInfoKey.LOGO_URL, "merchantId", "categories", "userPocketStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/wallet_v3/model/LoyaltyCardModel$LoyaltyCard;", "describeContents", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "getCardNumber", "setCardNumber", "Ljava/util/List;", "getCategories", "setCategories", "(Ljava/util/List;)V", "getCreatedDate", "setCreatedDate", "getIconUrl", "setIconUrl", "Z", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "getPocketId", "getPocketStatus", "getPocketType", "getPoint", "setPoint", "getUserPocketStatus", "setUserPocketStatus", "I", "getViewType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class LoyaltyCard extends LoyaltyCardModel {
        public static final Parcelable.Creator<LoyaltyCard> CREATOR = new Creator();
        private String backgroundUrl;
        private String cardNumber;
        private List<AssetCategoryModel> categories;
        private String createdDate;
        private String iconUrl;
        private final boolean isUsed;
        private String logoUrl;
        private String merchantId;
        private String merchantName;
        private final String pocketId;
        private final String pocketStatus;
        private final String pocketType;
        private String point;
        private String userPocketStatus;
        private final int viewType;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<LoyaltyCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LoyaltyCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                int i = 0;
                while (i != readInt2) {
                    arrayList.add(AssetCategoryModel.CREATOR.createFromParcel(parcel));
                    i++;
                    readInt2 = readInt2;
                }
                return new LoyaltyCard(readString, readString2, readString3, z, readInt, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, arrayList, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LoyaltyCard[] newArray(int i) {
                return new LoyaltyCard[i];
            }
        }

        public LoyaltyCard() {
            this(null, null, null, false, 0, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getCardNumber() {
            return this.cardNumber;
        }

        /* renamed from: component11  reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: component12  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component13  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        public final List<AssetCategoryModel> component14() {
            return this.categories;
        }

        /* renamed from: component15  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        public final String component2() {
            return getPocketStatus();
        }

        public final String component3() {
            return getPocketType();
        }

        public final boolean component4() {
            return getIsUsed();
        }

        public final int component5() {
            return getViewType();
        }

        /* renamed from: component6  reason: from getter */
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        /* renamed from: component7  reason: from getter */
        public final String getCreatedDate() {
            return this.createdDate;
        }

        /* renamed from: component8  reason: from getter */
        public final String getPoint() {
            return this.point;
        }

        /* renamed from: component9  reason: from getter */
        public final String getMerchantName() {
            return this.merchantName;
        }

        public final LoyaltyCard copy(String pocketId, String pocketStatus, String pocketType, boolean isUsed, int viewType, String backgroundUrl, String createdDate, String point, String merchantName, String cardNumber, String iconUrl, String logoUrl, String merchantId, List<AssetCategoryModel> categories, String userPocketStatus) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(point, "");
            Intrinsics.checkNotNullParameter(merchantName, "");
            Intrinsics.checkNotNullParameter(cardNumber, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            Intrinsics.checkNotNullParameter(categories, "");
            return new LoyaltyCard(pocketId, pocketStatus, pocketType, isUsed, viewType, backgroundUrl, createdDate, point, merchantName, cardNumber, iconUrl, logoUrl, merchantId, categories, userPocketStatus);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof LoyaltyCard) {
                LoyaltyCard loyaltyCard = (LoyaltyCard) other;
                return Intrinsics.areEqual(getPocketId(), loyaltyCard.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), loyaltyCard.getPocketStatus()) && Intrinsics.areEqual(getPocketType(), loyaltyCard.getPocketType()) && getIsUsed() == loyaltyCard.getIsUsed() && getViewType() == loyaltyCard.getViewType() && Intrinsics.areEqual(this.backgroundUrl, loyaltyCard.backgroundUrl) && Intrinsics.areEqual(this.createdDate, loyaltyCard.createdDate) && Intrinsics.areEqual(this.point, loyaltyCard.point) && Intrinsics.areEqual(this.merchantName, loyaltyCard.merchantName) && Intrinsics.areEqual(this.cardNumber, loyaltyCard.cardNumber) && Intrinsics.areEqual(this.iconUrl, loyaltyCard.iconUrl) && Intrinsics.areEqual(this.logoUrl, loyaltyCard.logoUrl) && Intrinsics.areEqual(this.merchantId, loyaltyCard.merchantId) && Intrinsics.areEqual(this.categories, loyaltyCard.categories) && Intrinsics.areEqual(this.userPocketStatus, loyaltyCard.userPocketStatus);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getPocketType().hashCode();
            boolean isUsed = getIsUsed();
            int i = isUsed;
            if (isUsed) {
                i = 1;
            }
            int viewType = getViewType();
            int hashCode4 = this.backgroundUrl.hashCode();
            String str = this.createdDate;
            int hashCode5 = str == null ? 0 : str.hashCode();
            int hashCode6 = this.point.hashCode();
            int hashCode7 = this.merchantName.hashCode();
            int hashCode8 = this.cardNumber.hashCode();
            int hashCode9 = this.iconUrl.hashCode();
            int hashCode10 = this.logoUrl.hashCode();
            String str2 = this.merchantId;
            int hashCode11 = str2 == null ? 0 : str2.hashCode();
            int hashCode12 = this.categories.hashCode();
            String str3 = this.userPocketStatus;
            return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + viewType) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str3 != null ? str3.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoyaltyCard(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", isUsed=");
            sb.append(getIsUsed());
            sb.append(", viewType=");
            sb.append(getViewType());
            sb.append(", backgroundUrl=");
            sb.append(this.backgroundUrl);
            sb.append(", createdDate=");
            sb.append(this.createdDate);
            sb.append(", point=");
            sb.append(this.point);
            sb.append(", merchantName=");
            sb.append(this.merchantName);
            sb.append(", cardNumber=");
            sb.append(this.cardNumber);
            sb.append(", iconUrl=");
            sb.append(this.iconUrl);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", categories=");
            sb.append(this.categories);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.pocketId);
            parcel.writeString(this.pocketStatus);
            parcel.writeString(this.pocketType);
            parcel.writeInt(this.isUsed ? 1 : 0);
            parcel.writeInt(this.viewType);
            parcel.writeString(this.backgroundUrl);
            parcel.writeString(this.createdDate);
            parcel.writeString(this.point);
            parcel.writeString(this.merchantName);
            parcel.writeString(this.cardNumber);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.merchantId);
            List<AssetCategoryModel> list = this.categories;
            parcel.writeInt(list.size());
            Iterator<AssetCategoryModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
            parcel.writeString(this.userPocketStatus);
        }

        @Override // id.dana.wallet_v3.model.LoyaltyCardModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.wallet_v3.model.LoyaltyCardModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.wallet_v3.model.LoyaltyCardModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.wallet_v3.model.LoyaltyCardModel
        @JvmName(name = "isUsed")
        /* renamed from: isUsed  reason: from getter */
        public final boolean getIsUsed() {
            return this.isUsed;
        }

        @Override // id.dana.wallet_v3.model.LoyaltyCardModel, id.dana.wallet_v3.model.WalletV3CardModel
        @JvmName(name = "getViewType")
        public final int getViewType() {
            return this.viewType;
        }

        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @JvmName(name = "getCreatedDate")
        public final String getCreatedDate() {
            return this.createdDate;
        }

        @JvmName(name = "setCreatedDate")
        public final void setCreatedDate(String str) {
            this.createdDate = str;
        }

        @JvmName(name = "getPoint")
        public final String getPoint() {
            return this.point;
        }

        @JvmName(name = "setPoint")
        public final void setPoint(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.point = str;
        }

        @JvmName(name = "getMerchantName")
        public final String getMerchantName() {
            return this.merchantName;
        }

        @JvmName(name = "setMerchantName")
        public final void setMerchantName(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantName = str;
        }

        @JvmName(name = "getCardNumber")
        public final String getCardNumber() {
            return this.cardNumber;
        }

        @JvmName(name = "setCardNumber")
        public final void setCardNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.cardNumber = str;
        }

        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.logoUrl = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            this.merchantId = str;
        }

        public /* synthetic */ LoyaltyCard(String str, String str2, String str3, boolean z, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, String str12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? 13 : i, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? "" : str10, (i2 & 4096) != 0 ? "" : str11, (i2 & 8192) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16384) == 0 ? str12 : "");
        }

        @JvmName(name = "getCategories")
        public final List<AssetCategoryModel> getCategories() {
            return this.categories;
        }

        @JvmName(name = "setCategories")
        public final void setCategories(List<AssetCategoryModel> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.categories = list;
        }

        @JvmName(name = "getUserPocketStatus")
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        @JvmName(name = "setUserPocketStatus")
        public final void setUserPocketStatus(String str) {
            this.userPocketStatus = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoyaltyCard(String str, String str2, String str3, boolean z, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<AssetCategoryModel> list, String str12) {
            super(str, str2, str3, z, i, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.pocketType = str3;
            this.isUsed = z;
            this.viewType = i;
            this.backgroundUrl = str4;
            this.createdDate = str5;
            this.point = str6;
            this.merchantName = str7;
            this.cardNumber = str8;
            this.iconUrl = str9;
            this.logoUrl = str10;
            this.merchantId = str11;
            this.categories = list;
            this.userPocketStatus = str12;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/LoyaltyCardModel$LoadingState;", "Lid/dana/wallet_v3/model/LoyaltyCardModel;", "", "component1", "()Ljava/lang/String;", "dummyData", "copy", "(Ljava/lang/String;)Lid/dana/wallet_v3/model/LoyaltyCardModel$LoadingState;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDummyData", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class LoadingState extends LoyaltyCardModel {
        public static final Parcelable.Creator<LoadingState> CREATOR = new Creator();
        private final String dummyData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<LoadingState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LoadingState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new LoadingState(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final LoadingState[] newArray(int i) {
                return new LoadingState[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LoadingState() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.model.LoyaltyCardModel.LoadingState.<init>():void");
        }

        public static /* synthetic */ LoadingState copy$default(LoadingState loadingState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadingState.dummyData;
            }
            return loadingState.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDummyData() {
            return this.dummyData;
        }

        public final LoadingState copy(String dummyData) {
            return new LoadingState(dummyData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoadingState) && Intrinsics.areEqual(this.dummyData, ((LoadingState) other).dummyData);
        }

        public final int hashCode() {
            String str = this.dummyData;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoadingState(dummyData=");
            sb.append(this.dummyData);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.dummyData);
        }

        public /* synthetic */ LoadingState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getDummyData")
        public final String getDummyData() {
            return this.dummyData;
        }

        public LoadingState(String str) {
            super("", "", "", false, 11, null);
            this.dummyData = str;
        }
    }
}
