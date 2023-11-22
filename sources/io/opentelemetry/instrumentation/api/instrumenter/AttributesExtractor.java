package io.opentelemetry.instrumentation.api.instrumenter;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface AttributesExtractor<REQUEST, RESPONSE> {
    void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th);

    void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC<REQUEST, RESPONSE> {
        public static <REQUEST, RESPONSE, T> AttributesExtractor<REQUEST, RESPONSE> constant(AttributeKey<T> attributeKey, T t) {
            return new ConstantAttributesExtractor((AttributeKey) Objects.requireNonNull(attributeKey, "attributeKey"), Objects.requireNonNull(t, "attributeValue"));
        }
    }
}
