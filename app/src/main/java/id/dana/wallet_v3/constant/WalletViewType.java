package id.dana.wallet_v3.constant;

import id.dana.domain.payasset.model.PayMethod;
import id.dana.notification.RedirectType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/wallet_v3/constant/WalletViewType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface WalletViewType {
    public static final int BANK_CARD = 0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DANA_BALANCE_CARD = 1;
    public static final int DANA_PLUS = 4;
    public static final int DEALS = 19;
    public static final int EMAS = 5;
    public static final int EMPTY = 7;
    public static final int EMPTY_CARD = 3;
    public static final int GOALS = 6;
    public static final int KTP = 14;
    public static final int LOADING_SPINNER = 11;
    public static final int LOYALTY_CARD = 13;
    public static final int MOVIE_TICKET = 15;
    public static final int NO_RESULT = 18;
    public static final int PARKING_TICKET = 10;
    public static final int PAYLATER_CARD = 2;
    public static final int SEARCH_RECOMMENDATION = 16;
    public static final int TITLE = 17;
    public static final int TRAVEL_TICKET = 9;
    public static final int VOUCHER = 8;
    public static final int VOUCHER_SHIMMER_LOADING = 12;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/constant/WalletViewType$Companion;", "", "", "BANK_CARD", "I", "DANA_BALANCE_CARD", PayMethod.DANA_PLUS, RedirectType.DEALS, "EMAS", "EMPTY", "EMPTY_CARD", "GOALS", "KTP", "LOADING_SPINNER", "LOYALTY_CARD", "MOVIE_TICKET", "NO_RESULT", "PARKING_TICKET", "PAYLATER_CARD", "SEARCH_RECOMMENDATION", "TITLE", "TRAVEL_TICKET", "VOUCHER", "VOUCHER_SHIMMER_LOADING", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BANK_CARD = 0;
        public static final int DANA_BALANCE_CARD = 1;
        public static final int DANA_PLUS = 4;
        public static final int DEALS = 19;
        public static final int EMAS = 5;
        public static final int EMPTY = 7;
        public static final int EMPTY_CARD = 3;
        public static final int GOALS = 6;
        public static final int KTP = 14;
        public static final int LOADING_SPINNER = 11;
        public static final int LOYALTY_CARD = 13;
        public static final int MOVIE_TICKET = 15;
        public static final int NO_RESULT = 18;
        public static final int PARKING_TICKET = 10;
        public static final int PAYLATER_CARD = 2;
        public static final int SEARCH_RECOMMENDATION = 16;
        public static final int TITLE = 17;
        public static final int TRAVEL_TICKET = 9;
        public static final int VOUCHER = 8;
        public static final int VOUCHER_SHIMMER_LOADING = 12;

        private Companion() {
        }
    }
}
