package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.animation.HomeTabActivity;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.wallet_v3.model.WalletTab;
import id.dana.pay.PayCardViewItem;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.factory.WalletCardViewItemFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004 !\"#BI\b\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0001\u0004$%&'"}, d2 = {"Lid/dana/wallet_v3/model/PaymentCardModel;", "Lid/dana/wallet_v3/model/AssetCardModel;", "", "assetType", "Ljava/lang/String;", "getAssetType", "()Ljava/lang/String;", "cardBackground", "getCardBackground", "cardName", "getCardName", "id", "getId", "Lid/dana/pay/PayCardViewItem;", "payCardViewItem", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "()Lid/dana/pay/PayCardViewItem;", HomeTabActivity.WALLET_SECTION, "getSection", "", "viewType", "I", "getViewType", "()I", "Lid/dana/domain/wallet_v3/model/WalletTab;", "walletTab", "Lid/dana/domain/wallet_v3/model/WalletTab;", "getWalletTab", "()Lid/dana/domain/wallet_v3/model/WalletTab;", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/WalletTab;ILjava/lang/String;)V", "BankCard", "DanaCard", "EmptyCard", "PaylaterCard", "Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;", "Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;", "Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;", "Lid/dana/wallet_v3/model/PaymentCardModel$EmptyCard;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PaymentCardModel extends AssetCardModel {
    private final String assetType;
    private final String cardBackground;
    private final String cardName;
    private final String id;
    private final PayCardViewItem payCardViewItem;
    private final String section;
    private final int viewType;
    private final WalletTab walletTab;

    public /* synthetic */ PaymentCardModel(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, WalletTab walletTab, int i, String str5, DefaultConstructorMarker defaultConstructorMarker) {
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

    private PaymentCardModel(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, WalletTab walletTab, int i, String str5) {
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

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0006\u00101\u001a\u00020\u0005\u0012\b\u00102\u001a\u0004\u0018\u00010\n\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u000f\u0012\u0006\u00106\u001a\u00020\u000f\u0012\u0006\u00107\u001a\u00020\u0005\u0012\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0005\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u000f\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bo\u0010pJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0011J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0007J\u0010\u0010 \u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u0007J\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\u0007J\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u0007J\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\u0007J\u0010\u0010$\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b$\u0010\u0007J\u0010\u0010%\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b%\u0010\u0007J\u0092\u0002\u0010>\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n2\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u00052\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u000f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010A\u001a\u00020@HÖ\u0001¢\u0006\u0004\bA\u0010BJ\u001a\u0010E\u001a\u00020\u000f2\b\u0010D\u001a\u0004\u0018\u00010CHÖ\u0003¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020@HÖ\u0001¢\u0006\u0004\bG\u0010BJ\u0010\u0010H\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\bH\u0010\u0007J \u0010M\u001a\u00020L2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020@HÖ\u0001¢\u0006\u0004\bM\u0010NR\u001a\u0010'\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010O\u001a\u0004\bP\u0010\u0007R$\u0010=\u001a\u0004\u0018\u00010\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010Q\u001a\u0004\bR\u0010\u001e\"\u0004\bS\u0010TR\u001a\u0010:\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010O\u001a\u0004\bU\u0010\u0007R\u001a\u00107\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010O\u001a\u0004\bV\u0010\u0007R\u001a\u0010+\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b+\u0010O\u001a\u0004\bW\u0010\u0007R\u001a\u00104\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010O\u001a\u0004\bX\u0010\u0007R\u001a\u0010*\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b*\u0010O\u001a\u0004\bY\u0010\u0007R\u001a\u0010;\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010O\u001a\u0004\bZ\u0010\u0007R\u001a\u0010,\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010O\u001a\u0004\b[\u0010\u0007R\u001a\u00101\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010O\u001a\u0004\b\\\u0010\u0007R\u001a\u00109\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010O\u001a\u0004\b]\u0010\u0007R\u001a\u00105\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010^\u001a\u0004\b_\u0010\u0011R\u001a\u0010<\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010^\u001a\u0004\b`\u0010\u0011R\u001a\u00100\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010O\u001a\u0004\ba\u0010\u0007R\u001a\u0010/\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010O\u001a\u0004\bb\u0010\u0007R(\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010c\u001a\u0004\bd\u0010\u0016R\u001a\u0010)\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b)\u0010O\u001a\u0004\be\u0010\u0007R\u001a\u0010-\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010O\u001a\u0004\bf\u0010\u0007R\u001a\u0010.\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010O\u001a\u0004\bg\u0010\u0007R\u001a\u00103\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010O\u001a\u0004\bh\u0010\u0007R\u001a\u0010&\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b&\u0010i\u001a\u0004\bj\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010k\u001a\u0004\bl\u0010\fR\u001a\u0010(\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b(\u0010O\u001a\u0004\bm\u0010\u0007R\u001a\u00106\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010^\u001a\u0004\bn\u0010\u0011"}, d2 = {"Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;", "Lid/dana/wallet_v3/model/PaymentCardModel;", "Lid/dana/pay/PayCardViewItem;", "component1", "()Lid/dana/pay/PayCardViewItem;", "", "component10", "()Ljava/lang/String;", "component11", "component12", "Lid/dana/domain/nearbyme/model/MoneyView;", "component13", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component14", "component15", "", "component16", "()Z", "component17", "component18", "", "component19", "()Ljava/util/Map;", "component2", "component20", "component21", "component22", "component23", "", "component24", "()Ljava/lang/Long;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "payCardViewItem", "assetType", HomeTabActivity.WALLET_SECTION, "id", "cardName", "cardBackground", "cardScheme", "instId", "instOfficialName", "expiryYear", "expiryMonth", "contactBizType", "personalDailyLimit", "maskedCardNo", WalletConstant.CARD_INDEX_NO, "directDebit", "verified", "cardAssetType", "extInfo", "defaultAsset", "bindingId", "cardNoLength", "enableStatus", "backgroundUrlTimestamp", "copy", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Lid/dana/wallet_v3/model/PaymentCardModel$BankCard;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAssetType", "Ljava/lang/Long;", "getBackgroundUrlTimestamp", "setBackgroundUrlTimestamp", "(Ljava/lang/Long;)V", "getBindingId", "getCardAssetType", "getCardBackground", "getCardIndexNo", "getCardName", "getCardNoLength", "getCardScheme", "getContactBizType", "getDefaultAsset", "Z", "getDirectDebit", "getEnableStatus", "getExpiryMonth", "getExpiryYear", "Ljava/util/Map;", "getExtInfo", "getId", "getInstId", "getInstOfficialName", "getMaskedCardNo", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "Lid/dana/domain/nearbyme/model/MoneyView;", "getPersonalDailyLimit", "getSection", "getVerified", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class BankCard extends PaymentCardModel {
        public static final Parcelable.Creator<BankCard> CREATOR = new Creator();
        private final String assetType;
        private Long backgroundUrlTimestamp;
        private final String bindingId;
        private final String cardAssetType;
        private final String cardBackground;
        private final String cardIndexNo;
        private final String cardName;
        private final String cardNoLength;
        private final String cardScheme;
        private final String contactBizType;
        private final String defaultAsset;
        private final boolean directDebit;
        private final boolean enableStatus;
        private final String expiryMonth;
        private final String expiryYear;
        private final Map<String, String> extInfo;
        private final String id;
        private final String instId;
        private final String instOfficialName;
        private final String maskedCardNo;
        private final PayCardViewItem payCardViewItem;
        private final MoneyView personalDailyLimit;
        private final String section;
        private final boolean verified;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<BankCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BankCard createFromParcel(Parcel parcel) {
                LinkedHashMap linkedHashMap;
                boolean z;
                MoneyView moneyView;
                Intrinsics.checkNotNullParameter(parcel, "");
                PayCardViewItem payCardViewItem = (PayCardViewItem) parcel.readParcelable(BankCard.class.getClassLoader());
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                MoneyView moneyView2 = (MoneyView) parcel.readSerializable();
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                boolean z2 = parcel.readInt() != 0;
                boolean z3 = parcel.readInt() != 0;
                String readString14 = parcel.readString();
                if (parcel.readInt() == 0) {
                    z = z2;
                    moneyView = moneyView2;
                    linkedHashMap = null;
                } else {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    z = z2;
                    int i = 0;
                    while (i != readInt) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                        i++;
                        readInt = readInt;
                        moneyView2 = moneyView2;
                    }
                    moneyView = moneyView2;
                }
                return new BankCard(payCardViewItem, readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, moneyView, readString12, readString13, z, z3, readString14, linkedHashMap, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BankCard[] newArray(int i) {
                return new BankCard[i];
            }
        }

        public final PayCardViewItem component1() {
            return getPayCardViewItem();
        }

        /* renamed from: component10  reason: from getter */
        public final String getExpiryYear() {
            return this.expiryYear;
        }

        /* renamed from: component11  reason: from getter */
        public final String getExpiryMonth() {
            return this.expiryMonth;
        }

        /* renamed from: component12  reason: from getter */
        public final String getContactBizType() {
            return this.contactBizType;
        }

        /* renamed from: component13  reason: from getter */
        public final MoneyView getPersonalDailyLimit() {
            return this.personalDailyLimit;
        }

        /* renamed from: component14  reason: from getter */
        public final String getMaskedCardNo() {
            return this.maskedCardNo;
        }

        /* renamed from: component15  reason: from getter */
        public final String getCardIndexNo() {
            return this.cardIndexNo;
        }

        /* renamed from: component16  reason: from getter */
        public final boolean getDirectDebit() {
            return this.directDebit;
        }

        /* renamed from: component17  reason: from getter */
        public final boolean getVerified() {
            return this.verified;
        }

        /* renamed from: component18  reason: from getter */
        public final String getCardAssetType() {
            return this.cardAssetType;
        }

        public final Map<String, String> component19() {
            return this.extInfo;
        }

        public final String component2() {
            return getAssetType();
        }

        /* renamed from: component20  reason: from getter */
        public final String getDefaultAsset() {
            return this.defaultAsset;
        }

        /* renamed from: component21  reason: from getter */
        public final String getBindingId() {
            return this.bindingId;
        }

        /* renamed from: component22  reason: from getter */
        public final String getCardNoLength() {
            return this.cardNoLength;
        }

        /* renamed from: component23  reason: from getter */
        public final boolean getEnableStatus() {
            return this.enableStatus;
        }

        /* renamed from: component24  reason: from getter */
        public final Long getBackgroundUrlTimestamp() {
            return this.backgroundUrlTimestamp;
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
        public final String getCardScheme() {
            return this.cardScheme;
        }

        /* renamed from: component8  reason: from getter */
        public final String getInstId() {
            return this.instId;
        }

        /* renamed from: component9  reason: from getter */
        public final String getInstOfficialName() {
            return this.instOfficialName;
        }

        public final BankCard copy(PayCardViewItem payCardViewItem, String assetType, String section, String id2, String cardName, String cardBackground, String cardScheme, String instId, String instOfficialName, String expiryYear, String expiryMonth, String contactBizType, MoneyView personalDailyLimit, String maskedCardNo, String cardIndexNo, boolean directDebit, boolean verified, String cardAssetType, Map<String, String> extInfo, String defaultAsset, String bindingId, String cardNoLength, boolean enableStatus, Long backgroundUrlTimestamp) {
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(assetType, "");
            Intrinsics.checkNotNullParameter(section, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(cardName, "");
            Intrinsics.checkNotNullParameter(cardBackground, "");
            Intrinsics.checkNotNullParameter(cardScheme, "");
            Intrinsics.checkNotNullParameter(instId, "");
            Intrinsics.checkNotNullParameter(instOfficialName, "");
            Intrinsics.checkNotNullParameter(expiryYear, "");
            Intrinsics.checkNotNullParameter(expiryMonth, "");
            Intrinsics.checkNotNullParameter(contactBizType, "");
            Intrinsics.checkNotNullParameter(maskedCardNo, "");
            Intrinsics.checkNotNullParameter(cardIndexNo, "");
            Intrinsics.checkNotNullParameter(cardAssetType, "");
            Intrinsics.checkNotNullParameter(defaultAsset, "");
            Intrinsics.checkNotNullParameter(bindingId, "");
            Intrinsics.checkNotNullParameter(cardNoLength, "");
            return new BankCard(payCardViewItem, assetType, section, id2, cardName, cardBackground, cardScheme, instId, instOfficialName, expiryYear, expiryMonth, contactBizType, personalDailyLimit, maskedCardNo, cardIndexNo, directDebit, verified, cardAssetType, extInfo, defaultAsset, bindingId, cardNoLength, enableStatus, backgroundUrlTimestamp);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof BankCard) {
                BankCard bankCard = (BankCard) other;
                return Intrinsics.areEqual(getPayCardViewItem(), bankCard.getPayCardViewItem()) && Intrinsics.areEqual(getAssetType(), bankCard.getAssetType()) && Intrinsics.areEqual(getSection(), bankCard.getSection()) && Intrinsics.areEqual(getId(), bankCard.getId()) && Intrinsics.areEqual(getCardName(), bankCard.getCardName()) && Intrinsics.areEqual(getCardBackground(), bankCard.getCardBackground()) && Intrinsics.areEqual(this.cardScheme, bankCard.cardScheme) && Intrinsics.areEqual(this.instId, bankCard.instId) && Intrinsics.areEqual(this.instOfficialName, bankCard.instOfficialName) && Intrinsics.areEqual(this.expiryYear, bankCard.expiryYear) && Intrinsics.areEqual(this.expiryMonth, bankCard.expiryMonth) && Intrinsics.areEqual(this.contactBizType, bankCard.contactBizType) && Intrinsics.areEqual(this.personalDailyLimit, bankCard.personalDailyLimit) && Intrinsics.areEqual(this.maskedCardNo, bankCard.maskedCardNo) && Intrinsics.areEqual(this.cardIndexNo, bankCard.cardIndexNo) && this.directDebit == bankCard.directDebit && this.verified == bankCard.verified && Intrinsics.areEqual(this.cardAssetType, bankCard.cardAssetType) && Intrinsics.areEqual(this.extInfo, bankCard.extInfo) && Intrinsics.areEqual(this.defaultAsset, bankCard.defaultAsset) && Intrinsics.areEqual(this.bindingId, bankCard.bindingId) && Intrinsics.areEqual(this.cardNoLength, bankCard.cardNoLength) && this.enableStatus == bankCard.enableStatus && Intrinsics.areEqual(this.backgroundUrlTimestamp, bankCard.backgroundUrlTimestamp);
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
            int hashCode7 = this.cardScheme.hashCode();
            int hashCode8 = this.instId.hashCode();
            int hashCode9 = this.instOfficialName.hashCode();
            int hashCode10 = this.expiryYear.hashCode();
            int hashCode11 = this.expiryMonth.hashCode();
            int hashCode12 = this.contactBizType.hashCode();
            MoneyView moneyView = this.personalDailyLimit;
            int hashCode13 = moneyView == null ? 0 : moneyView.hashCode();
            int hashCode14 = this.maskedCardNo.hashCode();
            int hashCode15 = this.cardIndexNo.hashCode();
            boolean z = this.directDebit;
            int i = z ? 1 : z ? 1 : 0;
            boolean z2 = this.verified;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            int hashCode16 = this.cardAssetType.hashCode();
            Map<String, String> map = this.extInfo;
            int hashCode17 = map == null ? 0 : map.hashCode();
            int hashCode18 = this.defaultAsset.hashCode();
            int hashCode19 = this.bindingId.hashCode();
            int hashCode20 = this.cardNoLength.hashCode();
            boolean z3 = this.enableStatus;
            int i3 = z3 ? 1 : z3 ? 1 : 0;
            Long l = this.backgroundUrlTimestamp;
            return (((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i) * 31) + i2) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + i3) * 31) + (l != null ? l.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BankCard(payCardViewItem=");
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
            sb.append(", cardScheme=");
            sb.append(this.cardScheme);
            sb.append(", instId=");
            sb.append(this.instId);
            sb.append(", instOfficialName=");
            sb.append(this.instOfficialName);
            sb.append(", expiryYear=");
            sb.append(this.expiryYear);
            sb.append(", expiryMonth=");
            sb.append(this.expiryMonth);
            sb.append(", contactBizType=");
            sb.append(this.contactBizType);
            sb.append(", personalDailyLimit=");
            sb.append(this.personalDailyLimit);
            sb.append(", maskedCardNo=");
            sb.append(this.maskedCardNo);
            sb.append(", cardIndexNo=");
            sb.append(this.cardIndexNo);
            sb.append(", directDebit=");
            sb.append(this.directDebit);
            sb.append(", verified=");
            sb.append(this.verified);
            sb.append(", cardAssetType=");
            sb.append(this.cardAssetType);
            sb.append(", extInfo=");
            sb.append(this.extInfo);
            sb.append(", defaultAsset=");
            sb.append(this.defaultAsset);
            sb.append(", bindingId=");
            sb.append(this.bindingId);
            sb.append(", cardNoLength=");
            sb.append(this.cardNoLength);
            sb.append(", enableStatus=");
            sb.append(this.enableStatus);
            sb.append(", backgroundUrlTimestamp=");
            sb.append(this.backgroundUrlTimestamp);
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
            parcel.writeString(this.cardScheme);
            parcel.writeString(this.instId);
            parcel.writeString(this.instOfficialName);
            parcel.writeString(this.expiryYear);
            parcel.writeString(this.expiryMonth);
            parcel.writeString(this.contactBizType);
            parcel.writeSerializable(this.personalDailyLimit);
            parcel.writeString(this.maskedCardNo);
            parcel.writeString(this.cardIndexNo);
            parcel.writeInt(this.directDebit ? 1 : 0);
            parcel.writeInt(this.verified ? 1 : 0);
            parcel.writeString(this.cardAssetType);
            Map<String, String> map = this.extInfo;
            if (map == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    parcel.writeString(entry.getKey());
                    parcel.writeString(entry.getValue());
                }
            }
            parcel.writeString(this.defaultAsset);
            parcel.writeString(this.bindingId);
            parcel.writeString(this.cardNoLength);
            parcel.writeInt(this.enableStatus ? 1 : 0);
            Long l = this.backgroundUrlTimestamp;
            if (l == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }

        public /* synthetic */ BankCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, MoneyView moneyView, String str12, String str13, boolean z, boolean z2, String str14, Map map, String str15, String str16, String str17, boolean z3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(payCardViewItem, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, moneyView, str12, str13, z, z2, str14, map, str15, str16, str17, z3, (i & 8388608) != 0 ? null : l);
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getPayCardViewItem")
        public final PayCardViewItem getPayCardViewItem() {
            return this.payCardViewItem;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getAssetType")
        public final String getAssetType() {
            return this.assetType;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getSection")
        public final String getSection() {
            return this.section;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardName")
        public final String getCardName() {
            return this.cardName;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardBackground")
        public final String getCardBackground() {
            return this.cardBackground;
        }

        @JvmName(name = "getCardScheme")
        public final String getCardScheme() {
            return this.cardScheme;
        }

        @JvmName(name = "getInstId")
        public final String getInstId() {
            return this.instId;
        }

        @JvmName(name = "getInstOfficialName")
        public final String getInstOfficialName() {
            return this.instOfficialName;
        }

        @JvmName(name = "getExpiryYear")
        public final String getExpiryYear() {
            return this.expiryYear;
        }

        @JvmName(name = "getExpiryMonth")
        public final String getExpiryMonth() {
            return this.expiryMonth;
        }

        @JvmName(name = "getContactBizType")
        public final String getContactBizType() {
            return this.contactBizType;
        }

        @JvmName(name = "getPersonalDailyLimit")
        public final MoneyView getPersonalDailyLimit() {
            return this.personalDailyLimit;
        }

        @JvmName(name = "getMaskedCardNo")
        public final String getMaskedCardNo() {
            return this.maskedCardNo;
        }

        @JvmName(name = "getCardIndexNo")
        public final String getCardIndexNo() {
            return this.cardIndexNo;
        }

        @JvmName(name = "getDirectDebit")
        public final boolean getDirectDebit() {
            return this.directDebit;
        }

        @JvmName(name = "getVerified")
        public final boolean getVerified() {
            return this.verified;
        }

        @JvmName(name = "getCardAssetType")
        public final String getCardAssetType() {
            return this.cardAssetType;
        }

        @JvmName(name = "getExtInfo")
        public final Map<String, String> getExtInfo() {
            return this.extInfo;
        }

        @JvmName(name = "getDefaultAsset")
        public final String getDefaultAsset() {
            return this.defaultAsset;
        }

        @JvmName(name = "getBindingId")
        public final String getBindingId() {
            return this.bindingId;
        }

        @JvmName(name = "getCardNoLength")
        public final String getCardNoLength() {
            return this.cardNoLength;
        }

        @JvmName(name = "getEnableStatus")
        public final boolean getEnableStatus() {
            return this.enableStatus;
        }

        @JvmName(name = "getBackgroundUrlTimestamp")
        public final Long getBackgroundUrlTimestamp() {
            return this.backgroundUrlTimestamp;
        }

        @JvmName(name = "setBackgroundUrlTimestamp")
        public final void setBackgroundUrlTimestamp(Long l) {
            this.backgroundUrlTimestamp = l;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, MoneyView moneyView, String str12, String str13, boolean z, boolean z2, String str14, Map<String, String> map, String str15, String str16, String str17, boolean z3, Long l) {
            super(payCardViewItem, str, str2, str3, str4, WalletTab.Payment, 0, str5, null);
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            Intrinsics.checkNotNullParameter(str11, "");
            Intrinsics.checkNotNullParameter(str12, "");
            Intrinsics.checkNotNullParameter(str13, "");
            Intrinsics.checkNotNullParameter(str14, "");
            Intrinsics.checkNotNullParameter(str15, "");
            Intrinsics.checkNotNullParameter(str16, "");
            Intrinsics.checkNotNullParameter(str17, "");
            this.payCardViewItem = payCardViewItem;
            this.assetType = str;
            this.section = str2;
            this.id = str3;
            this.cardName = str4;
            this.cardBackground = str5;
            this.cardScheme = str6;
            this.instId = str7;
            this.instOfficialName = str8;
            this.expiryYear = str9;
            this.expiryMonth = str10;
            this.contactBizType = str11;
            this.personalDailyLimit = moneyView;
            this.maskedCardNo = str12;
            this.cardIndexNo = str13;
            this.directDebit = z;
            this.verified = z2;
            this.cardAssetType = str14;
            this.extInfo = map;
            this.defaultAsset = str15;
            this.bindingId = str16;
            this.cardNoLength = str17;
            this.enableStatus = z3;
            this.backgroundUrlTimestamp = l;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J~\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\u0007J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0018\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010.\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b1\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b2\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b3\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b4\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b5\u0010\u0007R\u001a\u0010\u001a\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b6\u0010\u0007R\u001a\u0010\u0019\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b7\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u00108\u001a\u0004\b9\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010.\u001a\u0004\b:\u0010\u0007"}, d2 = {"Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;", "Lid/dana/wallet_v3/model/PaymentCardModel;", "Lid/dana/pay/PayCardViewItem;", "component1", "()Lid/dana/pay/PayCardViewItem;", "", "component10", "()Ljava/lang/String;", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "payCardViewItem", "assetType", HomeTabActivity.WALLET_SECTION, "id", "cardName", "cardBackground", FirebaseAnalytics.Param.CURRENCY, "amount", "number", "nickname", WalletConstant.KYC_LEVEL, "copy", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/model/PaymentCardModel$DanaCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAmount", "getAssetType", "getCardBackground", "getCardName", "getCurrency", "getId", "getKycLevel", "getNickname", "getNumber", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "getSection", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DanaCard extends PaymentCardModel {
        public static final Parcelable.Creator<DanaCard> CREATOR = new Creator();
        private final String amount;
        private final String assetType;
        private final String cardBackground;
        private final String cardName;
        private final String currency;
        private final String id;
        private final String kycLevel;
        private final String nickname;
        private final String number;
        private final PayCardViewItem payCardViewItem;
        private final String section;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DanaCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DanaCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new DanaCard((PayCardViewItem) parcel.readParcelable(DanaCard.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DanaCard[] newArray(int i) {
                return new DanaCard[i];
            }
        }

        public final PayCardViewItem component1() {
            return getPayCardViewItem();
        }

        /* renamed from: component10  reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        /* renamed from: component11  reason: from getter */
        public final String getKycLevel() {
            return this.kycLevel;
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
        public final String getCurrency() {
            return this.currency;
        }

        /* renamed from: component8  reason: from getter */
        public final String getAmount() {
            return this.amount;
        }

        /* renamed from: component9  reason: from getter */
        public final String getNumber() {
            return this.number;
        }

        public final DanaCard copy(PayCardViewItem payCardViewItem, String assetType, String section, String id2, String cardName, String cardBackground, String currency, String amount, String number, String nickname, String kycLevel) {
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(assetType, "");
            Intrinsics.checkNotNullParameter(section, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(cardName, "");
            Intrinsics.checkNotNullParameter(cardBackground, "");
            Intrinsics.checkNotNullParameter(currency, "");
            Intrinsics.checkNotNullParameter(amount, "");
            Intrinsics.checkNotNullParameter(number, "");
            Intrinsics.checkNotNullParameter(nickname, "");
            Intrinsics.checkNotNullParameter(kycLevel, "");
            return new DanaCard(payCardViewItem, assetType, section, id2, cardName, cardBackground, currency, amount, number, nickname, kycLevel);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DanaCard) {
                DanaCard danaCard = (DanaCard) other;
                return Intrinsics.areEqual(getPayCardViewItem(), danaCard.getPayCardViewItem()) && Intrinsics.areEqual(getAssetType(), danaCard.getAssetType()) && Intrinsics.areEqual(getSection(), danaCard.getSection()) && Intrinsics.areEqual(getId(), danaCard.getId()) && Intrinsics.areEqual(getCardName(), danaCard.getCardName()) && Intrinsics.areEqual(getCardBackground(), danaCard.getCardBackground()) && Intrinsics.areEqual(this.currency, danaCard.currency) && Intrinsics.areEqual(this.amount, danaCard.amount) && Intrinsics.areEqual(this.number, danaCard.number) && Intrinsics.areEqual(this.nickname, danaCard.nickname) && Intrinsics.areEqual(this.kycLevel, danaCard.kycLevel);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((((((((((((getPayCardViewItem().hashCode() * 31) + getAssetType().hashCode()) * 31) + getSection().hashCode()) * 31) + getId().hashCode()) * 31) + getCardName().hashCode()) * 31) + getCardBackground().hashCode()) * 31) + this.currency.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.number.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.kycLevel.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DanaCard(payCardViewItem=");
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
            sb.append(", currency=");
            sb.append(this.currency);
            sb.append(", amount=");
            sb.append(this.amount);
            sb.append(", number=");
            sb.append(this.number);
            sb.append(", nickname=");
            sb.append(this.nickname);
            sb.append(", kycLevel=");
            sb.append(this.kycLevel);
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
            parcel.writeString(this.currency);
            parcel.writeString(this.amount);
            parcel.writeString(this.number);
            parcel.writeString(this.nickname);
            parcel.writeString(this.kycLevel);
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getPayCardViewItem")
        public final PayCardViewItem getPayCardViewItem() {
            return this.payCardViewItem;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getAssetType")
        public final String getAssetType() {
            return this.assetType;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getSection")
        public final String getSection() {
            return this.section;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardName")
        public final String getCardName() {
            return this.cardName;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardBackground")
        public final String getCardBackground() {
            return this.cardBackground;
        }

        @JvmName(name = "getCurrency")
        public final String getCurrency() {
            return this.currency;
        }

        @JvmName(name = "getAmount")
        public final String getAmount() {
            return this.amount;
        }

        @JvmName(name = "getNumber")
        public final String getNumber() {
            return this.number;
        }

        @JvmName(name = "getNickname")
        public final String getNickname() {
            return this.nickname;
        }

        @JvmName(name = "getKycLevel")
        public final String getKycLevel() {
            return this.kycLevel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DanaCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            super(payCardViewItem, str, str2, str3, str4, WalletTab.Payment, 1, str5, null);
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            this.payCardViewItem = payCardViewItem;
            this.assetType = str;
            this.section = str2;
            this.id = str3;
            this.cardName = str4;
            this.cardBackground = str5;
            this.currency = str6;
            this.amount = str7;
            this.number = str8;
            this.nickname = str9;
            this.kycLevel = str10;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJX\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\u0007J \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b,\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b-\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b.\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00028\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00058\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b1\u0010\u0007"}, d2 = {"Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;", "Lid/dana/wallet_v3/model/PaymentCardModel;", "Lid/dana/pay/PayCardViewItem;", "component1", "()Lid/dana/pay/PayCardViewItem;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "Lid/dana/domain/nearbyme/model/MoneyView;", "component7", "()Lid/dana/domain/nearbyme/model/MoneyView;", "payCardViewItem", "assetType", HomeTabActivity.WALLET_SECTION, "id", "cardName", "cardBackground", "balance", "copy", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/wallet_v3/model/PaymentCardModel$PaylaterCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAssetType", "Lid/dana/domain/nearbyme/model/MoneyView;", "getBalance", "getCardBackground", "getCardName", "getId", "Lid/dana/pay/PayCardViewItem;", "getPayCardViewItem", "getSection", "<init>", "(Lid/dana/pay/PayCardViewItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PaylaterCard extends PaymentCardModel {
        public static final Parcelable.Creator<PaylaterCard> CREATOR = new Creator();
        private final String assetType;
        private final MoneyView balance;
        private final String cardBackground;
        private final String cardName;
        private final String id;
        private final PayCardViewItem payCardViewItem;
        private final String section;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<PaylaterCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PaylaterCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new PaylaterCard((PayCardViewItem) parcel.readParcelable(PaylaterCard.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (MoneyView) parcel.readSerializable());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PaylaterCard[] newArray(int i) {
                return new PaylaterCard[i];
            }
        }

        public static /* synthetic */ PaylaterCard copy$default(PaylaterCard paylaterCard, PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, MoneyView moneyView, int i, Object obj) {
            if ((i & 1) != 0) {
                payCardViewItem = paylaterCard.getPayCardViewItem();
            }
            if ((i & 2) != 0) {
                str = paylaterCard.getAssetType();
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = paylaterCard.getSection();
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = paylaterCard.getId();
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = paylaterCard.getCardName();
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = paylaterCard.getCardBackground();
            }
            String str10 = str5;
            if ((i & 64) != 0) {
                moneyView = paylaterCard.balance;
            }
            return paylaterCard.copy(payCardViewItem, str6, str7, str8, str9, str10, moneyView);
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
        public final MoneyView getBalance() {
            return this.balance;
        }

        public final PaylaterCard copy(PayCardViewItem payCardViewItem, String assetType, String section, String id2, String cardName, String cardBackground, MoneyView balance) {
            Intrinsics.checkNotNullParameter(payCardViewItem, "");
            Intrinsics.checkNotNullParameter(assetType, "");
            Intrinsics.checkNotNullParameter(section, "");
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(cardName, "");
            Intrinsics.checkNotNullParameter(cardBackground, "");
            return new PaylaterCard(payCardViewItem, assetType, section, id2, cardName, cardBackground, balance);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof PaylaterCard) {
                PaylaterCard paylaterCard = (PaylaterCard) other;
                return Intrinsics.areEqual(getPayCardViewItem(), paylaterCard.getPayCardViewItem()) && Intrinsics.areEqual(getAssetType(), paylaterCard.getAssetType()) && Intrinsics.areEqual(getSection(), paylaterCard.getSection()) && Intrinsics.areEqual(getId(), paylaterCard.getId()) && Intrinsics.areEqual(getCardName(), paylaterCard.getCardName()) && Intrinsics.areEqual(getCardBackground(), paylaterCard.getCardBackground()) && Intrinsics.areEqual(this.balance, paylaterCard.balance);
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
            MoneyView moneyView = this.balance;
            return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (moneyView == null ? 0 : moneyView.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaylaterCard(payCardViewItem=");
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
            sb.append(", balance=");
            sb.append(this.balance);
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
            parcel.writeSerializable(this.balance);
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getPayCardViewItem")
        public final PayCardViewItem getPayCardViewItem() {
            return this.payCardViewItem;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getAssetType")
        public final String getAssetType() {
            return this.assetType;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getSection")
        public final String getSection() {
            return this.section;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardName")
        public final String getCardName() {
            return this.cardName;
        }

        @Override // id.dana.wallet_v3.model.PaymentCardModel, id.dana.wallet_v3.model.AssetCardModel
        @JvmName(name = "getCardBackground")
        public final String getCardBackground() {
            return this.cardBackground;
        }

        @JvmName(name = "getBalance")
        public final MoneyView getBalance() {
            return this.balance;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaylaterCard(PayCardViewItem payCardViewItem, String str, String str2, String str3, String str4, String str5, MoneyView moneyView) {
            super(payCardViewItem, str, str2, str3, str4, WalletTab.Payment, 2, str5, null);
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
            this.balance = moneyView;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/model/PaymentCardModel$EmptyCard;", "Lid/dana/wallet_v3/model/PaymentCardModel;", "", "component1", "()Ljava/lang/String;", "dummyData", "copy", "(Ljava/lang/String;)Lid/dana/wallet_v3/model/PaymentCardModel$EmptyCard;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDummyData", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class EmptyCard extends PaymentCardModel {
        public static final Parcelable.Creator<EmptyCard> CREATOR = new Creator();
        private final String dummyData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<EmptyCard> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmptyCard createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new EmptyCard(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmptyCard[] newArray(int i) {
                return new EmptyCard[i];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public EmptyCard() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.model.PaymentCardModel.EmptyCard.<init>():void");
        }

        public static /* synthetic */ EmptyCard copy$default(EmptyCard emptyCard, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emptyCard.dummyData;
            }
            return emptyCard.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getDummyData() {
            return this.dummyData;
        }

        public final EmptyCard copy(String dummyData) {
            return new EmptyCard(dummyData);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EmptyCard) && Intrinsics.areEqual(this.dummyData, ((EmptyCard) other).dummyData);
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
            sb.append("EmptyCard(dummyData=");
            sb.append(this.dummyData);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.dummyData);
        }

        public /* synthetic */ EmptyCard(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @JvmName(name = "getDummyData")
        public final String getDummyData() {
            return this.dummyData;
        }

        public EmptyCard(String str) {
            super(WalletCardViewItemFactory.INSTANCE.create("", "", false), "", "", "", "", WalletTab.Payment, 3, "", null);
            this.dummyData = str;
        }
    }
}
