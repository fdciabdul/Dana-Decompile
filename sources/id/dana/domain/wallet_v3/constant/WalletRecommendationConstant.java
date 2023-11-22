package id.dana.domain.wallet_v3.constant;

import com.j256.ormlite.stmt.query.SimpleComparison;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.utils.StringWrapper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/domain/wallet_v3/constant/WalletRecommendationConstant;", "", "", "BASE_URL", "Ljava/lang/String;", "IMG_URL_BANK_CARD", "IMG_URL_DANA_PLUS", "IMG_URL_DEALS", "IMG_URL_EKTP", "KTP_DAO", "USER_PAYMENT_ASSET_DAO", "USER_POCKET_ASSET_DAO", "", "Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "defaultAssetMap", "Ljava/util/Map;", "getDefaultAssetMap", "()Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WalletRecommendationConstant {
    public static final String BASE_URL = "https://m.dana.id/resource/imgs/dana-wallet";
    public static final String IMG_URL_BANK_CARD = "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-bank.png";
    public static final String IMG_URL_DANA_PLUS = "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-danaplus-2.png";
    public static final String IMG_URL_DEALS = "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-deals.png";
    public static final String IMG_URL_EKTP = "https://m.dana.id/resource/imgs/dana-wallet/recom-bg-ktp.png";
    public static final WalletRecommendationConstant INSTANCE = new WalletRecommendationConstant();
    public static final String KTP_DAO = "KtpDaoEntity";
    public static final String USER_PAYMENT_ASSET_DAO = "UserPaymentAssetsDaoEntity";
    public static final String USER_POCKET_ASSET_DAO = "UserPocketAssetsDaoEntity";
    private static final Map<String, AssetRecommendation> defaultAssetMap;

    private WalletRecommendationConstant() {
    }

    @JvmName(name = "getDefaultAssetMap")
    public final Map<String, AssetRecommendation> getDefaultAssetMap() {
        return defaultAssetMap;
    }

    static {
        int i = 0;
        List list = null;
        ThirdPartyServiceResponse thirdPartyServiceResponse = null;
        int i2 = 1056;
        DefaultConstructorMarker defaultConstructorMarker = null;
        defaultAssetMap = MapsKt.mapOf(TuplesKt.to("service_ektp", new AssetRecommendation("service_ektp", IMG_URL_EKTP, new StringWrapper.StringLocaleValue("Add your e-KTP", "Simpan e-KTP"), new StringWrapper.StringLocaleValue("Access your personal ID within reach", "Akses kartu identitas dalam genggaman"), new StringWrapper.StringLocaleValue("ADD", "TAMBAH"), null, "SELECT pocketId FROM KtpDaoEntity WHERE pocketType is 'ID_CARD' LIMIT 1", "==", i, "IDENTITY", null, 1056, null)), TuplesKt.to("service_deals", new AssetRecommendation("service_deals", IMG_URL_DEALS, new StringWrapper.StringLocaleValue(TrackerKey.PromoCenterSourceType.DANA_DEALS, TrackerKey.PromoCenterSourceType.DANA_DEALS), new StringWrapper.StringLocaleValue("Find the best promos from your fave brands", "Temukan penawaran hemat dari brand favorit"), new StringWrapper.StringLocaleValue("BUY", "BELI"), list, "SELECT pocketId FROM UserPocketAssetsDaoEntity WHERE pocketType is 'VOUCHER' OR pocketType is 'COUPON' OR pocketType is 'DISCOUNT_COUPON' OR pocketType is 'TRAVEL_TICKET' OR pocketType is 'PARKING' OR pocketType is 'TICKET' LIMIT 1", SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION, i, "VOUCHER_AND_TICKET", thirdPartyServiceResponse, i2, defaultConstructorMarker)), TuplesKt.to("service_dana_plus", new AssetRecommendation("service_dana_plus", IMG_URL_DANA_PLUS, new StringWrapper.StringLocaleValue("DANA Plus", "DANA Plus"), new StringWrapper.StringLocaleValue("Transact easily with your DANA Plus profits", "Transaksi mudah pakai keuntungan DANA Plus"), new StringWrapper.StringLocaleValue("ADD", "TAMBAH"), list, "SELECT uniqueId FROM UserPaymentAssetsDaoEntity WHERE assetType is 'DANA_PLUS' LIMIT 1", "==", i, "FINANCIAL", thirdPartyServiceResponse, i2, defaultConstructorMarker)), TuplesKt.to("service_bank_card", new AssetRecommendation("service_bank_card", IMG_URL_BANK_CARD, new StringWrapper.StringLocaleValue("Bank Cards", "Kartu Bank"), new StringWrapper.StringLocaleValue("Pay simpler with your saved bank cards", "Bayar lebih simpel dengan kartu bank kamu"), new StringWrapper.StringLocaleValue("SAVE", "SIMPAN"), null, "SELECT uniqueId FROM UserPaymentAssetsDaoEntity WHERE assetType is 'DC' OR assetType is 'CC' LIMIT 10", SimpleComparison.LESS_THAN_OPERATION, 10, "PAYMENT", null, 1056, null)));
    }
}
