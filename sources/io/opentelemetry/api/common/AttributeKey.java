package io.opentelemetry.api.common;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.api.internal.InternalAttributeKeyImpl;
import java.util.List;

/* loaded from: classes.dex */
public interface AttributeKey<T> {
    String getKey();

    AttributeType getType();

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.api.common.AttributeKey$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC<T> {
        public static AttributeKey<String> stringKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.STRING);
        }

        public static AttributeKey<Boolean> booleanKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.BOOLEAN);
        }

        public static AttributeKey<Long> longKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.LONG);
        }

        public static AttributeKey<Double> doubleKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.DOUBLE);
        }

        public static AttributeKey<List<String>> stringArrayKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.STRING_ARRAY);
        }

        public static AttributeKey<List<Boolean>> booleanArrayKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.BOOLEAN_ARRAY);
        }

        public static AttributeKey<List<Long>> longArrayKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.LONG_ARRAY);
        }

        public static AttributeKey<List<Double>> doubleArrayKey(String str) {
            return InternalAttributeKeyImpl.create(str, AttributeType.DOUBLE_ARRAY);
        }
    }
}
