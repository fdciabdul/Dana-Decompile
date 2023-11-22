package io.opentelemetry.api.baggage;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ImplicitContextKeyed;
import j$.util.function.BiConsumer;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface Baggage extends ImplicitContextKeyed {
    Map<String, BaggageEntry> asMap();

    void forEach(BiConsumer<? super String, ? super BaggageEntry> biConsumer);

    @Nullable
    String getEntryValue(String str);

    boolean isEmpty();

    int size();

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    Context storeInContext(Context context);

    BaggageBuilder toBuilder();

    /* renamed from: io.opentelemetry.api.baggage.Baggage$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static Baggage empty() {
            return ImmutableBaggage.empty();
        }

        public static BaggageBuilder builder() {
            return ImmutableBaggage.builder();
        }

        public static Baggage current() {
            return fromContext(Context.CC.current());
        }

        public static Baggage fromContext(Context context) {
            Baggage baggage = (Baggage) context.get(BaggageContextKey.KEY);
            return baggage == null ? empty() : baggage;
        }

        @Nullable
        public static Baggage fromContextOrNull(Context context) {
            return (Baggage) context.get(BaggageContextKey.KEY);
        }

        public static boolean $default$isEmpty(Baggage baggage) {
            return baggage.size() == 0;
        }
    }
}
