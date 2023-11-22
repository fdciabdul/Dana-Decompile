package id.dana.domain.wallet_v3.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u000e\b\u0003\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160#\u0012\u000e\b\u0003\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160#\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160#8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001aR\u001c\u0010*\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160#8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'"}, d2 = {"Lid/dana/domain/wallet_v3/model/WalletV3Config;", "", "", "cacheDuration", "Ljava/lang/Integer;", "getCacheDuration", "()Ljava/lang/Integer;", "Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;", "categoryFinancial", "Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;", "getCategoryFinancial", "()Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;", "categoryIdentity", "getCategoryIdentity", "categoryLoyalty", "getCategoryLoyalty", "categoryPayment", "getCategoryPayment", "categoryVoucherAndTicket", "getCategoryVoucherAndTicket", "danaDealsVersion", "getDanaDealsVersion", "", "defaultBackgroundColor", "Ljava/lang/String;", "getDefaultBackgroundColor", "()Ljava/lang/String;", "defaultFontColor", "getDefaultFontColor", "discountCouponDefaultBackgroundColor", "getDiscountCouponDefaultBackgroundColor", "discountCouponDefaultFontColor", "getDiscountCouponDefaultFontColor", "discountCouponVersion", "getDiscountCouponVersion", "", "sectionOrderingV3", "Ljava/util/List;", "getSectionOrderingV3", "()Ljava/util/List;", "voucherInjectionDefaultBackgroundColor", "getVoucherInjectionDefaultBackgroundColor", "voucherInjectionDefaultFontColor", "getVoucherInjectionDefaultFontColor", "walletFinancialSection", "getWalletFinancialSection", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;Lid/dana/domain/wallet_v3/model/WalletV3AddAssetServices;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletV3Config {
    public Integer cacheDuration;
    public WalletV3AddAssetServices categoryFinancial;
    public WalletV3AddAssetServices categoryIdentity;
    public WalletV3AddAssetServices categoryLoyalty;
    public WalletV3AddAssetServices categoryPayment;
    public WalletV3AddAssetServices categoryVoucherAndTicket;
    public Integer danaDealsVersion;
    public String defaultBackgroundColor;
    public String defaultFontColor;
    public String discountCouponDefaultBackgroundColor;
    public String discountCouponDefaultFontColor;
    public Integer discountCouponVersion;
    public List<String> sectionOrderingV3;
    public String voucherInjectionDefaultBackgroundColor;
    public String voucherInjectionDefaultFontColor;
    public List<String> walletFinancialSection;

    public WalletV3Config() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public WalletV3Config(@JSONField(name = "section_ordering_v3") List<String> list, @JSONField(name = "wallet_financial_section") List<String> list2, @JSONField(name = "dana_deals_version") Integer num, @JSONField(name = "voucher_default_background_color") String str, @JSONField(name = "voucher_default_font_color") String str2, @JSONField(name = "discount_coupon_version") Integer num2, @JSONField(name = "discount_coupon_default_background_color") String str3, @JSONField(name = "discount_coupon_default_font_color") String str4, @JSONField(name = "category_payment") WalletV3AddAssetServices walletV3AddAssetServices, @JSONField(name = "category_financial") WalletV3AddAssetServices walletV3AddAssetServices2, @JSONField(name = "category_voucher_and_ticket") WalletV3AddAssetServices walletV3AddAssetServices3, @JSONField(name = "category_loyalty") WalletV3AddAssetServices walletV3AddAssetServices4, @JSONField(name = "category_identity") WalletV3AddAssetServices walletV3AddAssetServices5, @JSONField(name = "voucher_injection_default_background_color") String str5, @JSONField(name = "voucher_injection_default_font_color") String str6, @JSONField(name = "cache_duration") Integer num3) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.sectionOrderingV3 = list;
        this.walletFinancialSection = list2;
        this.danaDealsVersion = num;
        this.defaultBackgroundColor = str;
        this.defaultFontColor = str2;
        this.discountCouponVersion = num2;
        this.discountCouponDefaultBackgroundColor = str3;
        this.discountCouponDefaultFontColor = str4;
        this.categoryPayment = walletV3AddAssetServices;
        this.categoryFinancial = walletV3AddAssetServices2;
        this.categoryVoucherAndTicket = walletV3AddAssetServices3;
        this.categoryLoyalty = walletV3AddAssetServices4;
        this.categoryIdentity = walletV3AddAssetServices5;
        this.voucherInjectionDefaultBackgroundColor = str5;
        this.voucherInjectionDefaultFontColor = str6;
        this.cacheDuration = num3;
    }

    public /* synthetic */ WalletV3Config(List list, List list2, Integer num, String str, String str2, Integer num2, String str3, String str4, WalletV3AddAssetServices walletV3AddAssetServices, WalletV3AddAssetServices walletV3AddAssetServices2, WalletV3AddAssetServices walletV3AddAssetServices3, WalletV3AddAssetServices walletV3AddAssetServices4, WalletV3AddAssetServices walletV3AddAssetServices5, String str5, String str6, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : walletV3AddAssetServices, (i & 512) != 0 ? null : walletV3AddAssetServices2, (i & 1024) != 0 ? null : walletV3AddAssetServices3, (i & 2048) != 0 ? null : walletV3AddAssetServices4, (i & 4096) != 0 ? null : walletV3AddAssetServices5, (i & 8192) != 0 ? null : str5, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : num3);
    }

    @JvmName(name = "getSectionOrderingV3")
    public final List<String> getSectionOrderingV3() {
        return this.sectionOrderingV3;
    }

    @JvmName(name = "getWalletFinancialSection")
    public final List<String> getWalletFinancialSection() {
        return this.walletFinancialSection;
    }

    @JvmName(name = "getDanaDealsVersion")
    public final Integer getDanaDealsVersion() {
        return this.danaDealsVersion;
    }

    @JvmName(name = "getDefaultBackgroundColor")
    public final String getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    @JvmName(name = "getDefaultFontColor")
    public final String getDefaultFontColor() {
        return this.defaultFontColor;
    }

    @JvmName(name = "getDiscountCouponVersion")
    public final Integer getDiscountCouponVersion() {
        return this.discountCouponVersion;
    }

    @JvmName(name = "getDiscountCouponDefaultBackgroundColor")
    public final String getDiscountCouponDefaultBackgroundColor() {
        return this.discountCouponDefaultBackgroundColor;
    }

    @JvmName(name = "getDiscountCouponDefaultFontColor")
    public final String getDiscountCouponDefaultFontColor() {
        return this.discountCouponDefaultFontColor;
    }

    @JvmName(name = "getCategoryPayment")
    public final WalletV3AddAssetServices getCategoryPayment() {
        return this.categoryPayment;
    }

    @JvmName(name = "getCategoryFinancial")
    public final WalletV3AddAssetServices getCategoryFinancial() {
        return this.categoryFinancial;
    }

    @JvmName(name = "getCategoryVoucherAndTicket")
    public final WalletV3AddAssetServices getCategoryVoucherAndTicket() {
        return this.categoryVoucherAndTicket;
    }

    @JvmName(name = "getCategoryLoyalty")
    public final WalletV3AddAssetServices getCategoryLoyalty() {
        return this.categoryLoyalty;
    }

    @JvmName(name = "getCategoryIdentity")
    public final WalletV3AddAssetServices getCategoryIdentity() {
        return this.categoryIdentity;
    }

    @JvmName(name = "getVoucherInjectionDefaultBackgroundColor")
    public final String getVoucherInjectionDefaultBackgroundColor() {
        return this.voucherInjectionDefaultBackgroundColor;
    }

    @JvmName(name = "getVoucherInjectionDefaultFontColor")
    public final String getVoucherInjectionDefaultFontColor() {
        return this.voucherInjectionDefaultFontColor;
    }

    @JvmName(name = "getCacheDuration")
    public final Integer getCacheDuration() {
        return this.cacheDuration;
    }
}
