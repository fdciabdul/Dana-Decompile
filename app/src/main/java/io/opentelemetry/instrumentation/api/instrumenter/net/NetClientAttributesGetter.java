package io.opentelemetry.instrumentation.api.instrumenter.net;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface NetClientAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String peerName(REQUEST request);

    @Nullable
    @Deprecated
    String peerName(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    Integer peerPort(REQUEST request);

    @Nullable
    @Deprecated
    Integer peerPort(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    String sockFamily(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    String sockPeerAddr(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    String sockPeerName(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    Integer sockPeerPort(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    String transport(REQUEST request, @Nullable RESPONSE response);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<REQUEST, RESPONSE> {
        @Nullable
        public static String $default$sockFamily(NetClientAttributesGetter netClientAttributesGetter, Object obj, @Nullable Object obj2) {
            return null;
        }

        @Nullable
        public static String $default$sockPeerAddr(NetClientAttributesGetter netClientAttributesGetter, Object obj, @Nullable Object obj2) {
            return null;
        }

        @Nullable
        public static String $default$sockPeerName(NetClientAttributesGetter netClientAttributesGetter, Object obj, @Nullable Object obj2) {
            return null;
        }

        @Nullable
        public static Integer $default$sockPeerPort(NetClientAttributesGetter netClientAttributesGetter, Object obj, @Nullable Object obj2) {
            return null;
        }

        @Nullable
        @Deprecated
        public static String $default$peerName(NetClientAttributesGetter netClientAttributesGetter, Object obj, @Nullable Object obj2) {
            throw new UnsupportedOperationException("This method is deprecated and will be removed in the next release");
        }

        @Nullable
        @Deprecated
        public static Integer $default$peerPort(NetClientAttributesGetter netClientAttributesGetter, Object obj, @Nullable Object obj2) {
            throw new UnsupportedOperationException("This method is deprecated and will be removed in the next release");
        }
    }
}
