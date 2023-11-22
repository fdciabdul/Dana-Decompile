package io.opentelemetry.api.trace.propagation.internal;

import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.TraceStateBuilder;
import j$.util.function.BiConsumer;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public final class W3CTraceContextEncoding {
    private static final char TRACESTATE_ENTRY_DELIMITER = ',';
    private static final Pattern TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN = Pattern.compile("[ \t]*,[ \t]*");
    private static final char TRACESTATE_KEY_VALUE_DELIMITER = '=';
    private static final int TRACESTATE_MAX_MEMBERS = 32;
    private static final int TRACESTATE_MAX_SIZE = 512;

    private W3CTraceContextEncoding() {
    }

    public static TraceState decodeTraceState(String str) {
        TraceStateBuilder builder = TraceState.CC.builder();
        String[] split = TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN.split(str);
        Utils.checkArgument(split.length <= 32, "TraceState has too many elements.");
        for (int length = split.length - 1; length >= 0; length--) {
            String str2 = split[length];
            int indexOf = str2.indexOf(61);
            Utils.checkArgument(indexOf != -1, "Invalid TraceState list-member format.");
            builder.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
        }
        TraceState build = builder.build();
        return build.size() != split.length ? TraceState.CC.getDefault() : build;
    }

    public static String encodeTraceState(TraceState traceState) {
        if (traceState.isEmpty()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(512);
        traceState.forEach(new BiConsumer() { // from class: io.opentelemetry.api.trace.propagation.internal.W3CTraceContextEncoding$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                W3CTraceContextEncoding.lambda$encodeTraceState$0(sb, (String) obj, (String) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$encodeTraceState$0(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append(TRACESTATE_ENTRY_DELIMITER);
        }
        sb.append(str);
        sb.append(TRACESTATE_KEY_VALUE_DELIMITER);
        sb.append(str2);
    }
}
