package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistEnum;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MODE_OPEN_TO_PUBLIC", "MODE_WHITELIST", "MODE_BLACKLIST"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum CashierMerchantWhitelistEnum {
    MODE_OPEN_TO_PUBLIC("open"),
    MODE_WHITELIST("whitelist"),
    MODE_BLACKLIST("blacklist");

    private String mode;

    CashierMerchantWhitelistEnum(String str) {
        this.mode = str;
    }

    @JvmName(name = "getMode")
    public final String getMode() {
        return this.mode;
    }

    @JvmName(name = "setMode")
    public final void setMode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.mode = str;
    }
}
