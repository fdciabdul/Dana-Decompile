package id.dana.network.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/network/util/BotProtectionUtil;", "", "", "AKAMAI_BOT_HEADER", "Ljava/lang/String;", "AKAMAI_BOT_REGEX", "AKAMAI_DEFAULT_BOT_REGEX", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BotProtectionUtil {
    public static final String AKAMAI_BOT_HEADER = "AkamaiBot";
    public static final String AKAMAI_BOT_REGEX = "^([A-Za-z0-9]+) (\\([^)]*\\)):([A-Za-z]+):([A-Za-z]+ [A-Za-z]+):([0-9]+):([A-Za-z]+)";
    public static final String AKAMAI_DEFAULT_BOT_REGEX = "^([^\\(]*) \\(([^\\)]*)\\):([^:)]*):([^:)]*)(?:$|:([^:)]*):([^:)]*))";
    public static final BotProtectionUtil INSTANCE = new BotProtectionUtil();

    private BotProtectionUtil() {
    }
}
