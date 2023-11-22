package id.dana.network.util;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.core.network.BuildConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/network/util/AkamaiUserAgentFactory;", "", "", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AkamaiUserAgentFactory {
    public static final AkamaiUserAgentFactory INSTANCE = new AkamaiUserAgentFactory();

    private AkamaiUserAgentFactory() {
    }

    @JvmStatic
    public static final String create() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(BuildConfig.AKAMAI_USER_AGENT, Arrays.copyOf(new Object[]{"2.47.1", "2470106"}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}
