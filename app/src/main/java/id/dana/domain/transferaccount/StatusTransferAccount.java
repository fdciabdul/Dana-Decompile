package id.dana.domain.transferaccount;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.user.UserInfoResponseConstant;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lid/dana/domain/transferaccount/StatusTransferAccount;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", UserInfoResponseConstant.LoginStatus.INITIAL, "SUCCESS", "PENDING", "FAILED"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum StatusTransferAccount {
    INITIAL(UserInfoResponseConstant.LoginStatus.INITIAL),
    SUCCESS("SUCCESS"),
    PENDING("PENDING"),
    FAILED("FAILED");


    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, StatusTransferAccount> map;
    private final String status;

    @JvmStatic
    public static final StatusTransferAccount getValue(String str) {
        return INSTANCE.getValue(str);
    }

    StatusTransferAccount(String str) {
        this.status = str;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    static {
        StatusTransferAccount[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (StatusTransferAccount statusTransferAccount : values) {
            linkedHashMap.put(statusTransferAccount.status, statusTransferAccount);
        }
        map = linkedHashMap;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/transferaccount/StatusTransferAccount$Companion;", "", "", HomeTabActivity.WALLET_SECTION, "Lid/dana/domain/transferaccount/StatusTransferAccount;", "getValue", "(Ljava/lang/String;)Lid/dana/domain/transferaccount/StatusTransferAccount;", "", "map", "Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StatusTransferAccount getValue(String section) {
            String str;
            Map map = StatusTransferAccount.map;
            if (section != null) {
                str = section.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "");
            } else {
                str = null;
            }
            return (StatusTransferAccount) map.get(str);
        }
    }
}
