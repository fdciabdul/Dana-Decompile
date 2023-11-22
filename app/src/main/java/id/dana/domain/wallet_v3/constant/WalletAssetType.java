package id.dana.domain.wallet_v3.constant;

import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.CardAssetType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r"}, d2 = {"Lid/dana/domain/wallet_v3/constant/WalletAssetType;", "", "", "sectionType", "", "getAssetBySection", "(Ljava/lang/String;)Ljava/util/List;", "asset", "getSectionByAsset", "(Ljava/lang/String;)Ljava/lang/String;", "bankAssetTypes", "Ljava/util/List;", "getBankAssetTypes", "()Ljava/util/List;", "financialAssetTypes", "identityAssetTypes", "getIdentityAssetTypes", "investmentAssetTypes", "getInvestmentAssetTypes", "loyaltyAssetTypes", "getLoyaltyAssetTypes", "paymentAssetTypes", "getPaymentAssetTypes", "ticketAssetTypes", "getTicketAssetTypes", "voucherAndTicketAssetType", "voucherAssetTypes", "getVoucherAssetTypes", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WalletAssetType {
    public static final WalletAssetType INSTANCE = new WalletAssetType();
    private static final List<String> paymentAssetTypes = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.BALANCE.getAsset(), CardAssetType.CREDIT_CARD.getAsset(), CardAssetType.DEBIT_CARD.getAsset(), CardAssetType.PAYLATER.getAsset()});
    private static final List<String> financialAssetTypes = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.EMAS.getAsset(), CardAssetType.DANA_PLUS.getAsset(), CardAssetType.GOALS.getAsset()});
    private static final List<String> voucherAndTicketAssetType = CollectionsKt.listOf((Object[]) new String[]{AssetType.VOUCHER.getAsset(), AssetType.COUPON.getAsset(), AssetType.DISCOUNT_COUPON.getAsset(), AssetType.TRAVEL_TICKET.getAsset(), AssetType.PARKING.getAsset(), AssetType.TICKET.getAsset()});
    private static final List<String> bankAssetTypes = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.CREDIT_CARD.getAsset(), CardAssetType.DEBIT_CARD.getAsset()});
    private static final List<String> investmentAssetTypes = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.EMAS.getAsset(), CardAssetType.DANA_PLUS.getAsset(), CardAssetType.GOALS.getAsset()});
    private static final List<String> voucherAssetTypes = CollectionsKt.listOf((Object[]) new String[]{AssetType.VOUCHER.getAsset(), AssetType.COUPON.getAsset(), AssetType.DISCOUNT_COUPON.getAsset()});
    private static final List<String> ticketAssetTypes = CollectionsKt.listOf((Object[]) new String[]{AssetType.TRAVEL_TICKET.getAsset(), AssetType.PARKING.getAsset()});
    private static final List<String> loyaltyAssetTypes = CollectionsKt.listOf(AssetType.LOYALTY.getAsset());
    private static final List<String> identityAssetTypes = CollectionsKt.listOf(AssetType.ID_CARD.getAsset());

    private WalletAssetType() {
    }

    public final List<String> getAssetBySection(@WalletSectionType String sectionType) {
        Intrinsics.checkNotNullParameter(sectionType, "");
        String upperCase = sectionType.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        switch (upperCase.hashCode()) {
            case -1150817175:
                if (upperCase.equals("FINANCIAL")) {
                    return financialAssetTypes;
                }
                break;
            case -554006299:
                if (upperCase.equals("VOUCHER_AND_TICKET")) {
                    return voucherAndTicketAssetType;
                }
                break;
            case -68698650:
                if (upperCase.equals("PAYMENT")) {
                    return paymentAssetTypes;
                }
                break;
            case 646865086:
                if (upperCase.equals("IDENTITY")) {
                    return identityAssetTypes;
                }
                break;
            case 1076711462:
                if (upperCase.equals("LOYALTY")) {
                    return loyaltyAssetTypes;
                }
                break;
        }
        return CollectionsKt.emptyList();
    }

    @WalletSectionType
    public final String getSectionByAsset(String asset) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        List<String> list = paymentAssetTypes;
        boolean z5 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.equals((String) it.next(), asset, true)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return "PAYMENT";
        }
        List<String> list2 = financialAssetTypes;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (StringsKt.equals((String) it2.next(), asset, true)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            return "FINANCIAL";
        }
        List<String> list3 = loyaltyAssetTypes;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                if (StringsKt.equals((String) it3.next(), asset, true)) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            return "LOYALTY";
        }
        List<String> list4 = voucherAndTicketAssetType;
        if (!(list4 instanceof Collection) || !list4.isEmpty()) {
            Iterator<T> it4 = list4.iterator();
            while (it4.hasNext()) {
                if (StringsKt.equals((String) it4.next(), asset, true)) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        if (z4) {
            return "VOUCHER_AND_TICKET";
        }
        List<String> list5 = identityAssetTypes;
        if (!(list5 instanceof Collection) || !list5.isEmpty()) {
            Iterator<T> it5 = list5.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                } else if (StringsKt.equals((String) it5.next(), asset, true)) {
                    z5 = true;
                    break;
                }
            }
        }
        if (z5) {
            return "IDENTITY";
        }
        return null;
    }

    @JvmName(name = "getPaymentAssetTypes")
    public final List<String> getPaymentAssetTypes() {
        return paymentAssetTypes;
    }

    @JvmName(name = "getBankAssetTypes")
    public final List<String> getBankAssetTypes() {
        return bankAssetTypes;
    }

    @JvmName(name = "getInvestmentAssetTypes")
    public final List<String> getInvestmentAssetTypes() {
        return investmentAssetTypes;
    }

    @JvmName(name = "getVoucherAssetTypes")
    public final List<String> getVoucherAssetTypes() {
        return voucherAssetTypes;
    }

    @JvmName(name = "getTicketAssetTypes")
    public final List<String> getTicketAssetTypes() {
        return ticketAssetTypes;
    }

    @JvmName(name = "getLoyaltyAssetTypes")
    public final List<String> getLoyaltyAssetTypes() {
        return loyaltyAssetTypes;
    }

    @JvmName(name = "getIdentityAssetTypes")
    public final List<String> getIdentityAssetTypes() {
        return identityAssetTypes;
    }
}
