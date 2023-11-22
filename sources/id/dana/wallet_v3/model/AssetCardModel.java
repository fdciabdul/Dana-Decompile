package id.dana.wallet_v3.model;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.wallet_v3.model.WalletTab;
import id.dana.pay.PayCardViewItem;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001BI\b\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0001\u0002 !"}, d2 = {"Lid/dana/wallet_v3/model/AssetCardModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "", "assetType", "Ljava/lang/String;", "getAssetType", "()Ljava/lang/String;", "cardBackground", "getCardBackground", "cardName", "getCardName", "id", "getId", "Lid/dana/pay/PayCardViewItem;", "payCardViewItem", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "()Lid/dana/pay/PayCardViewItem;", HomeTabActivity.WALLET_SECTION, "getSection", "", "viewType", "I", "getViewType", "()I", "Lid/dana/domain/wallet_v3/model/WalletTab;", "walletTab", "Lid/dana/domain/wallet_v3/model/WalletTab;", "getWalletTab", "()Lid/dana/domain/wallet_v3/model/WalletTab;", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/WalletTab;ILjava/lang/String;)V", "Lid/dana/wallet_v3/model/InvestmentCardModel;", "Lid/dana/wallet_v3/model/PaymentCardModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AssetCardModel extends WalletV3CardModel {
    private final String assetType;
    private final String cardBackground;
    private final String cardName;
    private final String id;
    private final PayCardViewItem payCardViewItem;
    private final String section;
    private final int viewType;
    private final WalletTab walletTab;

    public /* synthetic */ AssetCardModel(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, WalletTab walletTab, int i, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(payCardViewItem, str, str2, str3, str4, walletTab, i, str5);
    }

    @JvmName(name = "getPayCardViewItem")
    public PayCardViewItem getPayCardViewItem() {
        return this.payCardViewItem;
    }

    @JvmName(name = "getAssetType")
    public String getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getSection")
    public String getSection() {
        return this.section;
    }

    @JvmName(name = "getId")
    public String getId() {
        return this.id;
    }

    @JvmName(name = "getCardName")
    public String getCardName() {
        return this.cardName;
    }

    @JvmName(name = "getWalletTab")
    public WalletTab getWalletTab() {
        return this.walletTab;
    }

    @Override // id.dana.wallet_v3.model.WalletV3CardModel
    @JvmName(name = "getViewType")
    public int getViewType() {
        return this.viewType;
    }

    @JvmName(name = "getCardBackground")
    public String getCardBackground() {
        return this.cardBackground;
    }

    private AssetCardModel(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, WalletTab walletTab, int i, String str5) {
        super(i, null);
        this.payCardViewItem = payCardViewItem;
        this.assetType = str;
        this.section = str2;
        this.id = str3;
        this.cardName = str4;
        this.walletTab = walletTab;
        this.viewType = i;
        this.cardBackground = str5;
    }
}
