package id.dana.promodiscovery.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/promodiscovery/annotation/PromoDiscovery;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface PromoDiscovery {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final String DANA_DEALS_DETAIL_URL = "https://m.dana.id/i/dana-promotion/dana-deals/voucher-detail";
    public static final String DANA_DEALS_GOODS_ID_PARAM = "goodsId";
    public static final String DANA_DEALS_REVAMP_PARAM = "voucherV2";
    public static final String DANA_DEALS_URL = "https://m.dana.id/i/dana-promotion/dana-deals";
    public static final String DANA_PROMOTION_POINTS = "https://m.dana.id/i/dana-promotion/points";
    public static final String DANA_WALLET_LOYALTY = "https://link.dana.id/wallet-loyalty";
    public static final String DANA_WALLET_VOUCHER = "https://link.dana.id/wallet-voucher-and-ticket";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promodiscovery/annotation/PromoDiscovery$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
