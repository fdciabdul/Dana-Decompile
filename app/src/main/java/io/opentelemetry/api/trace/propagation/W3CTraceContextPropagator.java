package io.opentelemetry.api.trace.propagation;

import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.internal.TemporaryBuffers;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.propagation.internal.W3CTraceContextEncoding;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.context.propagation.TextMapSetter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class W3CTraceContextPropagator implements TextMapPropagator {
    private static final W3CTraceContextPropagator INSTANCE;
    private static final int SPAN_ID_HEX_SIZE;
    private static final int SPAN_ID_OFFSET;
    private static final char TRACEPARENT_DELIMITER = '-';
    private static final int TRACEPARENT_DELIMITER_SIZE = 1;
    private static final int TRACEPARENT_HEADER_SIZE;
    private static final int TRACE_ID_HEX_SIZE;
    private static final int TRACE_ID_OFFSET = 3;
    private static final int TRACE_OPTION_HEX_SIZE;
    private static final int TRACE_OPTION_OFFSET;
    private static final Set<String> VALID_VERSIONS;
    private static final String VERSION = "00";
    private static final String VERSION_00 = "00";
    private static final int VERSION_SIZE = 2;
    private static final Logger logger = Logger.getLogger(W3CTraceContextPropagator.class.getName());
    static final String TRACE_PARENT = "traceparent";
    static final String TRACE_STATE = "tracestate";
    private static final List<String> FIELDS = Collections.unmodifiableList(Arrays.asList(TRACE_PARENT, TRACE_STATE));

    static {
        int length = TraceId.getLength();
        TRACE_ID_HEX_SIZE = length;
        int length2 = SpanId.getLength();
        SPAN_ID_HEX_SIZE = length2;
        int length3 = TraceFlags.CC.getLength();
        TRACE_OPTION_HEX_SIZE = length3;
        int i = length + 3 + 1;
        SPAN_ID_OFFSET = i;
        int i2 = i + length2 + 1;
        TRACE_OPTION_OFFSET = i2;
        TRACEPARENT_HEADER_SIZE = i2 + length3;
        INSTANCE = new W3CTraceContextPropagator();
        VALID_VERSIONS = new HashSet();
        for (int i3 = 0; i3 < 255; i3++) {
            String hexString = Long.toHexString(i3);
            if (hexString.length() < 2) {
                StringBuilder sb = new StringBuilder();
                sb.append('0');
                sb.append(hexString);
                hexString = sb.toString();
            }
            VALID_VERSIONS.add(hexString);
        }
    }

    private W3CTraceContextPropagator() {
    }

    public static W3CTraceContextPropagator getInstance() {
        return INSTANCE;
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
        SpanContext spanContext = Span.CC.fromContext(context).getSpanContext();
        if (spanContext.isValid()) {
            int i = TRACEPARENT_HEADER_SIZE;
            char[] chars = TemporaryBuffers.chars(i);
            chars[0] = "00".charAt(0);
            chars[1] = "00".charAt(1);
            chars[2] = TRACEPARENT_DELIMITER;
            String traceId = spanContext.getTraceId();
            traceId.getChars(0, traceId.length(), chars, 3);
            int i2 = SPAN_ID_OFFSET;
            chars[i2 - 1] = TRACEPARENT_DELIMITER;
            String spanId = spanContext.getSpanId();
            spanId.getChars(0, spanId.length(), chars, i2);
            int i3 = TRACE_OPTION_OFFSET;
            chars[i3 - 1] = TRACEPARENT_DELIMITER;
            String asHex = spanContext.getTraceFlags().asHex();
            chars[i3] = asHex.charAt(0);
            chars[i3 + 1] = asHex.charAt(1);
            textMapSetter.set(c, TRACE_PARENT, new String(chars, 0, i));
            TraceState traceState = spanContext.getTraceState();
            if (traceState.isEmpty()) {
                return;
            }
            textMapSetter.set(c, TRACE_STATE, W3CTraceContextEncoding.encodeTraceState(traceState));
        }
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        if (context == null) {
            return Context.CC.root();
        }
        if (textMapGetter == null) {
            return context;
        }
        SpanContext extractImpl = extractImpl(c, textMapGetter);
        return !extractImpl.isValid() ? context : context.with(Span.CC.wrap(extractImpl));
    }

    private static <C> SpanContext extractImpl(@Nullable C c, TextMapGetter<C> textMapGetter) {
        String str;
        String str2 = textMapGetter.get(c, TRACE_PARENT);
        if (str2 == null) {
            return SpanContext.CC.getInvalid();
        }
        SpanContext extractContextFromTraceParent = extractContextFromTraceParent(str2);
        if (extractContextFromTraceParent.isValid() && (str = textMapGetter.get(c, TRACE_STATE)) != null && !str.isEmpty()) {
            try {
                return SpanContext.CC.createFromRemoteParent(extractContextFromTraceParent.getTraceId(), extractContextFromTraceParent.getSpanId(), extractContextFromTraceParent.getTraceFlags(), W3CTraceContextEncoding.decodeTraceState(str));
            } catch (IllegalArgumentException unused) {
                logger.fine("Unparseable tracestate header. Returning span context without state.");
            }
        }
        return extractContextFromTraceParent;
    }

    private static SpanContext extractContextFromTraceParent(String str) {
        int length = str.length();
        int i = TRACEPARENT_HEADER_SIZE;
        if (!((length == i || (str.length() > i && str.charAt(i) == '-')) && str.charAt(2) == '-' && str.charAt(SPAN_ID_OFFSET - 1) == '-' && str.charAt(TRACE_OPTION_OFFSET - 1) == '-')) {
            logger.fine("Unparseable traceparent header. Returning INVALID span context.");
            return SpanContext.CC.getInvalid();
        }
        String substring = str.substring(0, 2);
        if (!VALID_VERSIONS.contains(substring)) {
            return SpanContext.CC.getInvalid();
        }
        if (substring.equals("00") && str.length() > i) {
            return SpanContext.CC.getInvalid();
        }
        String substring2 = str.substring(3, TraceId.getLength() + 3);
        int i2 = SPAN_ID_OFFSET;
        String substring3 = str.substring(i2, SpanId.getLength() + i2);
        int i3 = TRACE_OPTION_OFFSET;
        char charAt = str.charAt(i3);
        char charAt2 = str.charAt(i3 + 1);
        if (!OtelEncodingUtils.isValidBase16Character(charAt) || !OtelEncodingUtils.isValidBase16Character(charAt2)) {
            return SpanContext.CC.getInvalid();
        }
        return SpanContext.CC.createFromRemoteParent(substring2, substring3, TraceFlags.CC.fromByte(OtelEncodingUtils.byteFromBase16(charAt, charAt2)), TraceState.CC.getDefault());
    }
}
