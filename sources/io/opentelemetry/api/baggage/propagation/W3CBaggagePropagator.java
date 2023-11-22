package io.opentelemetry.api.baggage.propagation;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.internal.StringUtils;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.context.propagation.TextMapSetter;
import j$.util.function.BiConsumer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class W3CBaggagePropagator implements TextMapPropagator {
    private static final String FIELD = "baggage";
    private static final List<String> FIELDS = Collections.singletonList(FIELD);
    private static final W3CBaggagePropagator INSTANCE = new W3CBaggagePropagator();
    private static final PercentEscaper URL_ESCAPER = PercentEscaper.create();

    private static boolean isValidBaggageValue(String str) {
        return str != null;
    }

    public static W3CBaggagePropagator getInstance() {
        return INSTANCE;
    }

    private W3CBaggagePropagator() {
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final Collection<String> fields() {
        return FIELDS;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
        if (context == null || textMapSetter == null) {
            return;
        }
        Baggage fromContext = Baggage.CC.fromContext(context);
        if (fromContext.isEmpty()) {
            return;
        }
        String baggageToString = baggageToString(fromContext);
        if (baggageToString.isEmpty()) {
            return;
        }
        textMapSetter.set(c, FIELD, baggageToString);
    }

    private static String baggageToString(Baggage baggage) {
        final StringBuilder sb = new StringBuilder();
        baggage.forEach(new BiConsumer() { // from class: io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                W3CBaggagePropagator.lambda$baggageToString$0(sb, (String) obj, (BaggageEntry) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        if (sb.length() == 0) {
            return "";
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$baggageToString$0(StringBuilder sb, String str, BaggageEntry baggageEntry) {
        if (baggageIsInvalid(str, baggageEntry)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(encodeValue(baggageEntry.getValue()));
        String value = baggageEntry.getMetadata().getValue();
        if (value != null && !value.isEmpty()) {
            sb.append(";");
            sb.append(encodeValue(value));
        }
        sb.append(",");
    }

    private static String encodeValue(String str) {
        return URL_ESCAPER.escape(str);
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        String str;
        if (context == null) {
            return Context.CC.root();
        }
        if (textMapGetter == null || (str = textMapGetter.get(c, FIELD)) == null || str.isEmpty()) {
            return context;
        }
        BaggageBuilder builder = Baggage.CC.builder();
        try {
            extractEntries(str, builder);
            return context.with(builder.build());
        } catch (RuntimeException unused) {
            return context;
        }
    }

    private static void extractEntries(String str, BaggageBuilder baggageBuilder) {
        new Parser(str).parseInto(baggageBuilder);
    }

    private static boolean baggageIsInvalid(String str, BaggageEntry baggageEntry) {
        return (isValidBaggageKey(str) && isValidBaggageValue(baggageEntry.getValue())) ? false : true;
    }

    private static boolean isValidBaggageKey(String str) {
        return (str == null || str.isEmpty() || !StringUtils.isPrintableString(str)) ? false : true;
    }
}
