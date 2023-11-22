package id.dana.domain.pocket.model;

import id.dana.sendmoney.ui.globalsend.landing.constant.SortType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015"}, d2 = {"Lid/dana/domain/pocket/model/AssetStatus;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "INIT", "INACTIVE", "EXPIRING", "EXPIRING_LAST", "NEWEST", SortType.OLDEST, "REDEEMED", "EXPIRED", "TRANSFERRED", "ACTIVE", "REVOKED", "EXPIRING_SOON"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum AssetStatus {
    INIT("INIT"),
    INACTIVE("INACTIVE"),
    EXPIRING("EXPIRING"),
    EXPIRING_LAST("EXPIRING_LAST"),
    NEWEST("NEWEST"),
    OLDEST(SortType.OLDEST),
    REDEEMED("REDEEMED"),
    EXPIRED("EXPIRED"),
    TRANSFERRED("TRANSFERRED"),
    ACTIVE("ACTIVE"),
    REVOKED("REVOKED"),
    EXPIRING_SOON("EXPIRING_SOON");

    public static final String USER_POCKET_STATUS_UNREAD = "UNREAD";
    private final String value;

    AssetStatus(String str) {
        this.value = str;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }
}
