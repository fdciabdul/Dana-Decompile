package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.animation.HomeTabActivity;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.wallet_v3.model.WalletTab;
import id.dana.pay.PayCardViewItem;
import id.dana.wallet_v3.factory.WalletCardViewItemFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004 !\"#BI\b\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0001\u0004$%&'"}, d2 = {"Lid/dana/wallet_v3/model/InvestmentCardModel;", "Lid/dana/wallet_v3/model/AssetCardModel;", "", "assetType", "Ljava/lang/String;", "getAssetType", "()Ljava/lang/String;", "cardBackground", "getCardBackground", "cardName", "getCardName", "id", "getId", "Lid/dana/pay/PayCardViewItem;", "payCardViewItem", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "()Lid/dana/pay/PayCardViewItem;", HomeTabActivity.WALLET_SECTION, "getSection", "", "viewType", "I", "getViewType", "()I", "Lid/dana/domain/wallet_v3/model/WalletTab;", "walletTab", "Lid/dana/domain/wallet_v3/model/WalletTab;", "getWalletTab", "()Lid/dana/domain/wallet_v3/model/WalletTab;", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/WalletTab;ILjava/lang/String;)V", "DanaGoalsCard", "DanaPlusCard", "EmasCard", "EmptyInvestmentCard", "Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel$EmptyInvestmentCard;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InvestmentCardModel extends AssetCardModel {
    private final String assetType;
    private final String cardBackground;
    private final String cardName;
    private final String id;
    private final PayCardViewItem payCardViewItem;
    private final String section;
    private final int viewType;
    private final WalletTab walletTab;

    public /* synthetic */ InvestmentCardModel(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, WalletTab walletTab, int i, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(payCardViewItem, str, str2, str3, str4, walletTab, i, str5);
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getPayCardViewItem")
    public PayCardViewItem getPayCardViewItem() {
        return this.payCardViewItem;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getAssetType")
    public String getAssetType() {
        return this.assetType;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getSection")
    public String getSection() {
        return this.section;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getId")
    public String getId() {
        return this.id;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getCardName")
    public String getCardName() {
        return this.cardName;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getWalletTab")
    public WalletTab getWalletTab() {
        return this.walletTab;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel, id.dana.wallet_v3.model.WalletV3CardModel
    @JvmName(name = "getViewType")
    public int getViewType() {
        return this.viewType;
    }

    @Override // id.dana.wallet_v3.model.AssetCardModel
    @JvmName(name = "getCardBackground")
    public String getCardBackground() {
        return this.cardBackground;
    }

    private InvestmentCardModel(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, WalletTab walletTab, int i, String str5) {
        super(payCardViewItem, str, str2, str3, str4, walletTab, i, str5, null);
        this.payCardViewItem = payCardViewItem;
        this.assetType = str;
        this.section = str2;
        this.id = str3;
        this.cardName = str4;
        this.walletTab = walletTab;
        this.viewType = i;
        this.cardBackground = str5;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007Jj\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ\u0010\u0010#\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010\u0007J \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0017\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b,\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b-\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b.\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b/\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b2\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b3\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b4\u0010\u0007"}, d2 = {"Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel;", "Lid/dana/pay/PayCardViewItem;", "component1", "()Lid/dana/pay/PayCardViewItem;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "payCardViewItem", "assetType", HomeTabActivity.WALLET_SECTION, "id", "cardName", "cardBackground", "title", FirebaseAnalytics.Param.CURRENCY, "amount", "copy", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/model/InvestmentCardModel$DanaGoalsCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAmount", "getAssetType", "getCardBackground", "getCardName", "getCurrency", "getId", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "getSection", "getTitle", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DanaGoalsCard extends InvestmentCardModel {
        public static final Parcelable.Creator<DanaGoalsCard> CREATOR = new Creator();
        private final String amount;
        private final String assetType;
        private final String cardBackground;
        private final String cardName;
        private final String currency;
        private final String id;
        private final PayCardViewItem payCardViewItem;
        private final String section;
        private final String title;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DanaGoalsCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DanaGoalsCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new DanaGoalsCard((PayCardViewItem) parcel.readParcelable(DanaGoalsCard.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DanaGoalsCard[] newArray(int i) {
                return new DanaGoalsCard[i];
            }
        }

        public final PayCardViewItem component1() {
            return getPayCardViewItem();
        }

        public final String component2() {
            return getAssetType();
        }

        public final String component3() {
            return getSection();
        }

        public final String component4() {
            return getId();
        }

        public final String component5() {
            return getCardName();
        }

        public final String component6() {
            return getCardBackground();
        }

        /* renamed from: component7  reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component8  reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* renamed from: component9  reason: from getter */
        public final String getAmount() {
            return this.amount;
        }

        public final DanaGoalsCard copy(PayCardViewItem payCardViewItem, String assetType, String section, String id2, String cardName, String cardBackground, String title, String currency, String amount) {
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(assetType, "");
            Intrinsics.checkNotNullParameter(section, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(cardName, "");
            Intrinsics.checkNotNullParameter(cardBackground, "");
            Intrinsics.checkNotNullParameter(title, "");
            Intrinsics.checkNotNullParameter(currency, "");
            Intrinsics.checkNotNullParameter(amount, "");
            return new DanaGoalsCard(payCardViewItem, assetType, section, id2, cardName, cardBackground, title, currency, amount);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DanaGoalsCard) {
                DanaGoalsCard danaGoalsCard = (DanaGoalsCard) other;
                return Intrinsics.areEqual(getPayCardViewItem(), danaGoalsCard.getPayCardViewItem()) && Intrinsics.areEqual(getAssetType(), danaGoalsCard.getAssetType()) && Intrinsics.areEqual(getSection(), danaGoalsCard.getSection()) && Intrinsics.areEqual(getId(), danaGoalsCard.getId()) && Intrinsics.areEqual(getCardName(), danaGoalsCard.getCardName()) && Intrinsics.areEqual(getCardBackground(), danaGoalsCard.getCardBackground()) && Intrinsics.areEqual(this.title, danaGoalsCard.title) && Intrinsics.areEqual(this.currency, danaGoalsCard.currency) && Intrinsics.areEqual(this.amount, danaGoalsCard.amount);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((((((((getPayCardViewItem().hashCode() * 31) + getAssetType().hashCode()) * 31) + getSection().hashCode()) * 31) + getId().hashCode()) * 31) + getCardName().hashCode()) * 31) + getCardBackground().hashCode()) * 31) + this.title.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.amount.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DanaGoalsCard(payCardViewItem=");
            sb.append(getPayCardViewItem());
            sb.append(", assetType=");
            sb.append(getAssetType());
            sb.append(", section=");
            sb.append(getSection());
            sb.append(", id=");
            sb.append(getId());
            sb.append(", cardName=");
            sb.append(getCardName());
            sb.append(", cardBackground=");
            sb.append(getCardBackground());
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", currency=");
            sb.append(this.currency);
            sb.append(", amount=");
            sb.append(this.amount);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeParcelable(this.payCardViewItem, flags);
            parcel.writeString(this.assetType);
            parcel.writeString(this.section);
            parcel.writeString(this.id);
            parcel.writeString(this.cardName);
            parcel.writeString(this.cardBackground);
            parcel.writeString(this.title);
            parcel.writeString(this.currency);
            parcel.writeString(this.amount);
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getPayCardViewItem")
        public final PayCardViewItem getPayCardViewItem() {
            return this.payCardViewItem;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getAssetType")
        public final String getAssetType() {
            return this.assetType;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getSection")
        public final String getSection() {
            return this.section;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardName")
        public final String getCardName() {
            return this.cardName;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardBackground")
        public final String getCardBackground() {
            return this.cardBackground;
        }

        @JvmName(name = "getTitle")
        public final String getTitle() {
            return this.title;
        }

        @JvmName(name = "getCurrency")
        public final String getCurrency() {
            return this.currency;
        }

        @JvmName(name = "getAmount")
        public final String getAmount() {
            return this.amount;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DanaGoalsCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            super(payCardViewItem, str, str2, str3, str4, WalletTab.Payment, 6, str5, null);
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            this.payCardViewItem = payCardViewItem;
            this.assetType = str;
            this.section = str2;
            this.id = str3;
            this.cardName = str4;
            this.cardBackground = str5;
            this.title = str6;
            this.currency = str7;
            this.amount = str8;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J|\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b'\u0010\nJ \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0013\u001a\u00020\b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010.\u001a\u0004\b/\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b1\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b2\u0010\nR\u001a\u0010\u0016\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b3\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b4\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b5\u0010\nR\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u00106\u001a\u0004\b7\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b8\u0010\nR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b9\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b:\u0010\n"}, d2 = {"Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel;", "Lid/dana/pay/PayCardViewItem;", "component1", "()Lid/dana/pay/PayCardViewItem;", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "component10", "()Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "payCardViewItem", "assetType", HomeTabActivity.WALLET_SECTION, "id", "cardName", "cardBackground", "totalGainLossAmount", "totalGainLossPercent", "dailyGainLossAmount", "availableBalance", "copy", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)Lid/dana/wallet_v3/model/InvestmentCardModel$DanaPlusCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAssetType", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "getAvailableBalance", "getCardBackground", "getCardName", "getDailyGainLossAmount", "getId", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "getSection", "getTotalGainLossAmount", "getTotalGainLossPercent", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DanaPlusCard extends InvestmentCardModel {
        public static final Parcelable.Creator<DanaPlusCard> CREATOR = new Creator();
        private final String assetType;
        private final MultiCurrencyMoneyView availableBalance;
        private final String cardBackground;
        private final String cardName;
        private final MultiCurrencyMoneyView dailyGainLossAmount;
        private final String id;
        private final PayCardViewItem payCardViewItem;
        private final String section;
        private final MultiCurrencyMoneyView totalGainLossAmount;
        private final String totalGainLossPercent;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DanaPlusCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DanaPlusCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new DanaPlusCard((PayCardViewItem) parcel.readParcelable(DanaPlusCard.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (MultiCurrencyMoneyView) parcel.readParcelable(DanaPlusCard.class.getClassLoader()), parcel.readString(), (MultiCurrencyMoneyView) parcel.readParcelable(DanaPlusCard.class.getClassLoader()), (MultiCurrencyMoneyView) parcel.readParcelable(DanaPlusCard.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DanaPlusCard[] newArray(int i) {
                return new DanaPlusCard[i];
            }
        }

        public final PayCardViewItem component1() {
            return getPayCardViewItem();
        }

        /* renamed from: component10  reason: from getter */
        public final MultiCurrencyMoneyView getAvailableBalance() {
            return this.availableBalance;
        }

        public final String component2() {
            return getAssetType();
        }

        public final String component3() {
            return getSection();
        }

        public final String component4() {
            return getId();
        }

        public final String component5() {
            return getCardName();
        }

        public final String component6() {
            return getCardBackground();
        }

        /* renamed from: component7  reason: from getter */
        public final MultiCurrencyMoneyView getTotalGainLossAmount() {
            return this.totalGainLossAmount;
        }

        /* renamed from: component8  reason: from getter */
        public final String getTotalGainLossPercent() {
            return this.totalGainLossPercent;
        }

        /* renamed from: component9  reason: from getter */
        public final MultiCurrencyMoneyView getDailyGainLossAmount() {
            return this.dailyGainLossAmount;
        }

        public final DanaPlusCard copy(PayCardViewItem payCardViewItem, String assetType, String section, String id2, String cardName, String cardBackground, MultiCurrencyMoneyView totalGainLossAmount, String totalGainLossPercent, MultiCurrencyMoneyView dailyGainLossAmount, MultiCurrencyMoneyView availableBalance) {
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(assetType, "");
            Intrinsics.checkNotNullParameter(section, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(cardName, "");
            Intrinsics.checkNotNullParameter(cardBackground, "");
            return new DanaPlusCard(payCardViewItem, assetType, section, id2, cardName, cardBackground, totalGainLossAmount, totalGainLossPercent, dailyGainLossAmount, availableBalance);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DanaPlusCard) {
                DanaPlusCard danaPlusCard = (DanaPlusCard) other;
                return Intrinsics.areEqual(getPayCardViewItem(), danaPlusCard.getPayCardViewItem()) && Intrinsics.areEqual(getAssetType(), danaPlusCard.getAssetType()) && Intrinsics.areEqual(getSection(), danaPlusCard.getSection()) && Intrinsics.areEqual(getId(), danaPlusCard.getId()) && Intrinsics.areEqual(getCardName(), danaPlusCard.getCardName()) && Intrinsics.areEqual(getCardBackground(), danaPlusCard.getCardBackground()) && Intrinsics.areEqual(this.totalGainLossAmount, danaPlusCard.totalGainLossAmount) && Intrinsics.areEqual(this.totalGainLossPercent, danaPlusCard.totalGainLossPercent) && Intrinsics.areEqual(this.dailyGainLossAmount, danaPlusCard.dailyGainLossAmount) && Intrinsics.areEqual(this.availableBalance, danaPlusCard.availableBalance);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPayCardViewItem().hashCode();
            int hashCode2 = getAssetType().hashCode();
            int hashCode3 = getSection().hashCode();
            int hashCode4 = getId().hashCode();
            int hashCode5 = getCardName().hashCode();
            int hashCode6 = getCardBackground().hashCode();
            MultiCurrencyMoneyView multiCurrencyMoneyView = this.totalGainLossAmount;
            int hashCode7 = multiCurrencyMoneyView == null ? 0 : multiCurrencyMoneyView.hashCode();
            String str = this.totalGainLossPercent;
            int hashCode8 = str == null ? 0 : str.hashCode();
            MultiCurrencyMoneyView multiCurrencyMoneyView2 = this.dailyGainLossAmount;
            int hashCode9 = multiCurrencyMoneyView2 == null ? 0 : multiCurrencyMoneyView2.hashCode();
            MultiCurrencyMoneyView multiCurrencyMoneyView3 = this.availableBalance;
            return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (multiCurrencyMoneyView3 != null ? multiCurrencyMoneyView3.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DanaPlusCard(payCardViewItem=");
            sb.append(getPayCardViewItem());
            sb.append(", assetType=");
            sb.append(getAssetType());
            sb.append(", section=");
            sb.append(getSection());
            sb.append(", id=");
            sb.append(getId());
            sb.append(", cardName=");
            sb.append(getCardName());
            sb.append(", cardBackground=");
            sb.append(getCardBackground());
            sb.append(", totalGainLossAmount=");
            sb.append(this.totalGainLossAmount);
            sb.append(", totalGainLossPercent=");
            sb.append(this.totalGainLossPercent);
            sb.append(", dailyGainLossAmount=");
            sb.append(this.dailyGainLossAmount);
            sb.append(", availableBalance=");
            sb.append(this.availableBalance);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeParcelable(this.payCardViewItem, flags);
            parcel.writeString(this.assetType);
            parcel.writeString(this.section);
            parcel.writeString(this.id);
            parcel.writeString(this.cardName);
            parcel.writeString(this.cardBackground);
            parcel.writeParcelable(this.totalGainLossAmount, flags);
            parcel.writeString(this.totalGainLossPercent);
            parcel.writeParcelable(this.dailyGainLossAmount, flags);
            parcel.writeParcelable(this.availableBalance, flags);
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getPayCardViewItem")
        public final PayCardViewItem getPayCardViewItem() {
            return this.payCardViewItem;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getAssetType")
        public final String getAssetType() {
            return this.assetType;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getSection")
        public final String getSection() {
            return this.section;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardName")
        public final String getCardName() {
            return this.cardName;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardBackground")
        public final String getCardBackground() {
            return this.cardBackground;
        }

        @JvmName(name = "getTotalGainLossAmount")
        public final MultiCurrencyMoneyView getTotalGainLossAmount() {
            return this.totalGainLossAmount;
        }

        @JvmName(name = "getTotalGainLossPercent")
        public final String getTotalGainLossPercent() {
            return this.totalGainLossPercent;
        }

        @JvmName(name = "getDailyGainLossAmount")
        public final MultiCurrencyMoneyView getDailyGainLossAmount() {
            return this.dailyGainLossAmount;
        }

        @JvmName(name = "getAvailableBalance")
        public final MultiCurrencyMoneyView getAvailableBalance() {
            return this.availableBalance;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DanaPlusCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, MultiCurrencyMoneyView multiCurrencyMoneyView, String str6, MultiCurrencyMoneyView multiCurrencyMoneyView2, MultiCurrencyMoneyView multiCurrencyMoneyView3) {
            super(payCardViewItem, str, str2, str3, str4, WalletTab.Payment, 4, str5, null);
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.payCardViewItem = payCardViewItem;
            this.assetType = str;
            this.section = str2;
            this.id = str3;
            this.cardName = str4;
            this.cardBackground = str5;
            this.totalGainLossAmount = multiCurrencyMoneyView;
            this.totalGainLossPercent = str6;
            this.dailyGainLossAmount = multiCurrencyMoneyView2;
            this.availableBalance = multiCurrencyMoneyView3;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJp\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b$\u0010\u001eJ\u0010\u0010%\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b%\u0010\u0007J \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0012\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b1\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b2\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b4\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b5\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b6\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b7\u0010\u0007"}, d2 = {"Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel;", "Lid/dana/pay/PayCardViewItem;", "component1", "()Lid/dana/pay/PayCardViewItem;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "component7", "()Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "component8", "component9", "payCardViewItem", "assetType", HomeTabActivity.WALLET_SECTION, "id", "cardName", "cardBackground", "totalGainLossAmount", "totalGainLossPercent", "availableBalance", "copy", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)Lid/dana/wallet_v3/model/InvestmentCardModel$EmasCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAssetType", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "getAvailableBalance", "getCardBackground", "getCardName", "getId", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "getSection", "getTotalGainLossAmount", "getTotalGainLossPercent", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class EmasCard extends InvestmentCardModel {
        public static final Parcelable.Creator<EmasCard> CREATOR = new Creator();
        private final String assetType;
        private final MultiCurrencyMoneyView availableBalance;
        private final String cardBackground;
        private final String cardName;
        private final String id;
        private final PayCardViewItem payCardViewItem;
        private final String section;
        private final MultiCurrencyMoneyView totalGainLossAmount;
        private final String totalGainLossPercent;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<EmasCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmasCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new EmasCard((PayCardViewItem) parcel.readParcelable(EmasCard.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (MultiCurrencyMoneyView) parcel.readParcelable(EmasCard.class.getClassLoader()), parcel.readString(), (MultiCurrencyMoneyView) parcel.readParcelable(EmasCard.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmasCard[] newArray(int i) {
                return new EmasCard[i];
            }
        }

        public final PayCardViewItem component1() {
            return getPayCardViewItem();
        }

        public final String component2() {
            return getAssetType();
        }

        public final String component3() {
            return getSection();
        }

        public final String component4() {
            return getId();
        }

        public final String component5() {
            return getCardName();
        }

        public final String component6() {
            return getCardBackground();
        }

        /* renamed from: component7  reason: from getter */
        public final MultiCurrencyMoneyView getTotalGainLossAmount() {
            return this.totalGainLossAmount;
        }

        /* renamed from: component8  reason: from getter */
        public final String getTotalGainLossPercent() {
            return this.totalGainLossPercent;
        }

        /* renamed from: component9  reason: from getter */
        public final MultiCurrencyMoneyView getAvailableBalance() {
            return this.availableBalance;
        }

        public final EmasCard copy(PayCardViewItem payCardViewItem, String assetType, String section, String id2, String cardName, String cardBackground, MultiCurrencyMoneyView totalGainLossAmount, String totalGainLossPercent, MultiCurrencyMoneyView availableBalance) {
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(assetType, "");
            Intrinsics.checkNotNullParameter(section, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(cardName, "");
            Intrinsics.checkNotNullParameter(cardBackground, "");
            return new EmasCard(payCardViewItem, assetType, section, id2, cardName, cardBackground, totalGainLossAmount, totalGainLossPercent, availableBalance);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof EmasCard) {
                EmasCard emasCard = (EmasCard) other;
                return Intrinsics.areEqual(getPayCardViewItem(), emasCard.getPayCardViewItem()) && Intrinsics.areEqual(getAssetType(), emasCard.getAssetType()) && Intrinsics.areEqual(getSection(), emasCard.getSection()) && Intrinsics.areEqual(getId(), emasCard.getId()) && Intrinsics.areEqual(getCardName(), emasCard.getCardName()) && Intrinsics.areEqual(getCardBackground(), emasCard.getCardBackground()) && Intrinsics.areEqual(this.totalGainLossAmount, emasCard.totalGainLossAmount) && Intrinsics.areEqual(this.totalGainLossPercent, emasCard.totalGainLossPercent) && Intrinsics.areEqual(this.availableBalance, emasCard.availableBalance);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPayCardViewItem().hashCode();
            int hashCode2 = getAssetType().hashCode();
            int hashCode3 = getSection().hashCode();
            int hashCode4 = getId().hashCode();
            int hashCode5 = getCardName().hashCode();
            int hashCode6 = getCardBackground().hashCode();
            MultiCurrencyMoneyView multiCurrencyMoneyView = this.totalGainLossAmount;
            int hashCode7 = multiCurrencyMoneyView == null ? 0 : multiCurrencyMoneyView.hashCode();
            String str = this.totalGainLossPercent;
            int hashCode8 = str == null ? 0 : str.hashCode();
            MultiCurrencyMoneyView multiCurrencyMoneyView2 = this.availableBalance;
            return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (multiCurrencyMoneyView2 != null ? multiCurrencyMoneyView2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("EmasCard(payCardViewItem=");
            sb.append(getPayCardViewItem());
            sb.append(", assetType=");
            sb.append(getAssetType());
            sb.append(", section=");
            sb.append(getSection());
            sb.append(", id=");
            sb.append(getId());
            sb.append(", cardName=");
            sb.append(getCardName());
            sb.append(", cardBackground=");
            sb.append(getCardBackground());
            sb.append(", totalGainLossAmount=");
            sb.append(this.totalGainLossAmount);
            sb.append(", totalGainLossPercent=");
            sb.append(this.totalGainLossPercent);
            sb.append(", availableBalance=");
            sb.append(this.availableBalance);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeParcelable(this.payCardViewItem, flags);
            parcel.writeString(this.assetType);
            parcel.writeString(this.section);
            parcel.writeString(this.id);
            parcel.writeString(this.cardName);
            parcel.writeString(this.cardBackground);
            parcel.writeParcelable(this.totalGainLossAmount, flags);
            parcel.writeString(this.totalGainLossPercent);
            parcel.writeParcelable(this.availableBalance, flags);
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getPayCardViewItem")
        public final PayCardViewItem getPayCardViewItem() {
            return this.payCardViewItem;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getAssetType")
        public final String getAssetType() {
            return this.assetType;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getSection")
        public final String getSection() {
            return this.section;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardName")
        public final String getCardName() {
            return this.cardName;
        }

        @Override // id.dana.wallet_v3.model.InvestmentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardBackground")
        public final String getCardBackground() {
            return this.cardBackground;
        }

        @JvmName(name = "getTotalGainLossAmount")
        public final MultiCurrencyMoneyView getTotalGainLossAmount() {
            return this.totalGainLossAmount;
        }

        @JvmName(name = "getTotalGainLossPercent")
        public final String getTotalGainLossPercent() {
            return this.totalGainLossPercent;
        }

        @JvmName(name = "getAvailableBalance")
        public final MultiCurrencyMoneyView getAvailableBalance() {
            return this.availableBalance;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmasCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, MultiCurrencyMoneyView multiCurrencyMoneyView, String str6, MultiCurrencyMoneyView multiCurrencyMoneyView2) {
            super(payCardViewItem, str, str2, str3, str4, WalletTab.Payment, 5, str5, null);
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.payCardViewItem = payCardViewItem;
            this.assetType = str;
            this.section = str2;
            this.id = str3;
            this.cardName = str4;
            this.cardBackground = str5;
            this.totalGainLossAmount = multiCurrencyMoneyView;
            this.totalGainLossPercent = str6;
            this.availableBalance = multiCurrencyMoneyView2;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/InvestmentCardModel$EmptyInvestmentCard;", "Lid/dana/wallet_v3/model/InvestmentCardModel;", "", "component1", "()Ljava/lang/String;", "dummyData", "copy", "(Ljava/lang/String;)Lid/dana/wallet_v3/model/InvestmentCardModel$EmptyInvestmentCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDummyData", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class EmptyInvestmentCard extends InvestmentCardModel {
        public static final Parcelable.Creator<EmptyInvestmentCard> CREATOR = new Creator();
        private final String dummyData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<EmptyInvestmentCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmptyInvestmentCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new EmptyInvestmentCard(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmptyInvestmentCard[] newArray(int i) {
                return new EmptyInvestmentCard[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public EmptyInvestmentCard() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.model.InvestmentCardModel.EmptyInvestmentCard.<init>():void");
        }

        public static /* synthetic */ EmptyInvestmentCard copy$default(EmptyInvestmentCard emptyInvestmentCard, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emptyInvestmentCard.dummyData;
            }
            return emptyInvestmentCard.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDummyData() {
            return this.dummyData;
        }

        public final EmptyInvestmentCard copy(String dummyData) {
            return new EmptyInvestmentCard(dummyData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EmptyInvestmentCard) && Intrinsics.areEqual(this.dummyData, ((EmptyInvestmentCard) other).dummyData);
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
            sb.append("EmptyInvestmentCard(dummyData=");
            sb.append(this.dummyData);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.dummyData);
        }

        public /* synthetic */ EmptyInvestmentCard(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getDummyData")
        public final String getDummyData() {
            return this.dummyData;
        }

        public EmptyInvestmentCard(String str) {
            super(WalletCardViewItemFactory.INSTANCE.create("", "", false), "", "", "", "", WalletTab.Payment, 7, "", null);
            this.dummyData = str;
        }
    }
}
