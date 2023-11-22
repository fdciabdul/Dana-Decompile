package id.dana.electronicmoney.view;

import id.dana.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017"}, d2 = {"Lid/dana/electronicmoney/view/CardReadStatus;", "", "", "getDescription", "()I", "getImage", "getTitle", "<init>", "(Ljava/lang/String;I)V", "TAP_ELECTRONIC_MONEY_CARD", "READING_ELECTRONIC_MONEY_CARD", "SHOWING_BRI_BRIZZI_BALANCE", "SHOWING_MANDIRI_EMONEY_BALANCE", "SCAN_CARD_TIMEOUT", "CARD_READ_FAILED", "SOMETHING_WRONG", "CARD_UNSUPPORTED", "SHOWING_CALL_CS", "CARD_EXPIRED", "UPDATE_BALANCE_FAILED", "BALANCE_REACH_LIMIT", "NO_NETWORK_CONNECTION", "RETRY_UPDATE_CARD_LIMIT", "INQUIRY_BALANCE_FAILED"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public enum CardReadStatus {
    TAP_ELECTRONIC_MONEY_CARD { // from class: id.dana.electronicmoney.view.CardReadStatus.TAP_ELECTRONIC_MONEY_CARD
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_tap_card_please;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_tap_e_money;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_update_saldo_first;
        }
    },
    READING_ELECTRONIC_MONEY_CARD { // from class: id.dana.electronicmoney.view.CardReadStatus.READING_ELECTRONIC_MONEY_CARD
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_trying_read_card;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_my_bill;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_update_saldo_second;
        }
    },
    SHOWING_BRI_BRIZZI_BALANCE { // from class: id.dana.electronicmoney.view.CardReadStatus.SHOWING_BRI_BRIZZI_BALANCE
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return 0;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_card_brizzi_bg;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return 0;
        }
    },
    SHOWING_MANDIRI_EMONEY_BALANCE { // from class: id.dana.electronicmoney.view.CardReadStatus.SHOWING_MANDIRI_EMONEY_BALANCE
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return 0;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_card_emoney_bg;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return 0;
        }
    },
    SCAN_CARD_TIMEOUT { // from class: id.dana.electronicmoney.view.CardReadStatus.SCAN_CARD_TIMEOUT
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_scan_card_time_out;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_timed_out;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_scan_card_time_out;
        }
    },
    CARD_READ_FAILED { // from class: id.dana.electronicmoney.view.CardReadStatus.CARD_READ_FAILED
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_card_read_failed;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_read_failed;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_card_read_failed;
        }
    },
    SOMETHING_WRONG { // from class: id.dana.electronicmoney.view.CardReadStatus.SOMETHING_WRONG
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_something_wrong;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_read_failed;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_something_wrong;
        }
    },
    CARD_UNSUPPORTED { // from class: id.dana.electronicmoney.view.CardReadStatus.CARD_UNSUPPORTED
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_card_unsupported;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_card_unsupported;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_card_unsupported;
        }
    },
    SHOWING_CALL_CS { // from class: id.dana.electronicmoney.view.CardReadStatus.SHOWING_CALL_CS
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_call_cs_emoney;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_call_cs_emoney;
        }
    },
    CARD_EXPIRED { // from class: id.dana.electronicmoney.view.CardReadStatus.CARD_EXPIRED
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_card_expired;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_card_unsupported;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_card_expired;
        }
    },
    UPDATE_BALANCE_FAILED { // from class: id.dana.electronicmoney.view.CardReadStatus.UPDATE_BALANCE_FAILED
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.desc_failed_update_balance;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_update_balance_failed;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.title_failed_update_balance;
        }
    },
    BALANCE_REACH_LIMIT { // from class: id.dana.electronicmoney.view.CardReadStatus.BALANCE_REACH_LIMIT
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return 0;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return 0;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return 0;
        }
    },
    NO_NETWORK_CONNECTION { // from class: id.dana.electronicmoney.view.CardReadStatus.NO_NETWORK_CONNECTION
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.unstable_internet_network_description;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_no_network_emoney;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.unstable_internet_network_title;
        }
    },
    RETRY_UPDATE_CARD_LIMIT { // from class: id.dana.electronicmoney.view.CardReadStatus.RETRY_UPDATE_CARD_LIMIT
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.retry_limit_read_card_description;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return R.drawable.ic_emoney_something_wrong;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return R.string.retry_limit_read_card_title;
        }
    },
    INQUIRY_BALANCE_FAILED { // from class: id.dana.electronicmoney.view.CardReadStatus.INQUIRY_BALANCE_FAILED
        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getDescription() {
            return R.string.error_description_failed_inquiry_balance;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getImage() {
            return 0;
        }

        @Override // id.dana.electronicmoney.view.CardReadStatus
        public final int getTitle() {
            return 0;
        }
    };

    /* synthetic */ CardReadStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDescription();

    public abstract int getImage();

    public abstract int getTitle();
}
