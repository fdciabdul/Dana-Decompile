package io.opentelemetry.instrumentation.api.instrumenter.net;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface NetServerAttributesGetter<REQUEST> {

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC<REQUEST> {
        @Nullable
        public static String $default$sockFamily(NetServerAttributesGetter netServerAttributesGetter, Object obj) {
            return null;
        }

        @Nullable
        public static String $default$sockHostAddr(NetServerAttributesGetter netServerAttributesGetter, Object obj) {
            return null;
        }

        @Nullable
        public static Integer $default$sockHostPort(NetServerAttributesGetter netServerAttributesGetter, Object obj) {
            return null;
        }

        @Nullable
        public static String $default$sockPeerAddr(NetServerAttributesGetter netServerAttributesGetter, Object obj) {
            return null;
        }

        @Nullable
        public static Integer $default$sockPeerPort(NetServerAttributesGetter netServerAttributesGetter, Object obj) {
            return null;
        }
    }

    @Nullable
    String hostName(REQUEST request);

    @Nullable
    Integer hostPort(REQUEST request);

    @Nullable
    String sockFamily(REQUEST request);

    @Nullable
    String sockHostAddr(REQUEST request);

    @Nullable
    Integer sockHostPort(REQUEST request);

    @Nullable
    String sockPeerAddr(REQUEST request);

    @Nullable
    Integer sockPeerPort(REQUEST request);

    @Nullable
    String transport(REQUEST request);
}
