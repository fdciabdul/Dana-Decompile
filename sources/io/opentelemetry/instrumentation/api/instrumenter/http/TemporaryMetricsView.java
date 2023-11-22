package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.function.BiConsumer;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
final class TemporaryMetricsView {
    private static final Set<AttributeKey> durationAlwaysInclude = buildDurationAlwaysInclude();
    private static final Set<AttributeKey> durationClientView = buildDurationClientView();
    private static final Set<AttributeKey> durationServerView = buildDurationServerView();
    private static final Set<AttributeKey> activeRequestsView = buildActiveRequestsView();

    private static Set<AttributeKey> buildDurationAlwaysInclude() {
        HashSet hashSet = new HashSet();
        hashSet.add(SemanticAttributes.HTTP_METHOD);
        hashSet.add(SemanticAttributes.HTTP_STATUS_CODE);
        hashSet.add(SemanticAttributes.HTTP_FLAVOR);
        return hashSet;
    }

    private static Set<AttributeKey> buildDurationClientView() {
        HashSet hashSet = new HashSet(durationAlwaysInclude);
        hashSet.add(SemanticAttributes.NET_PEER_NAME);
        hashSet.add(SemanticAttributes.NET_PEER_PORT);
        hashSet.add(AttributeKey.CC.stringKey("net.peer.sock.addr"));
        return hashSet;
    }

    private static Set<AttributeKey> buildDurationServerView() {
        HashSet hashSet = new HashSet(durationAlwaysInclude);
        hashSet.add(SemanticAttributes.HTTP_SCHEME);
        hashSet.add(SemanticAttributes.NET_HOST_NAME);
        hashSet.add(SemanticAttributes.NET_HOST_PORT);
        hashSet.add(SemanticAttributes.HTTP_ROUTE);
        return hashSet;
    }

    private static Set<AttributeKey> buildActiveRequestsView() {
        HashSet hashSet = new HashSet();
        hashSet.add(SemanticAttributes.HTTP_METHOD);
        hashSet.add(SemanticAttributes.HTTP_SCHEME);
        hashSet.add(SemanticAttributes.HTTP_FLAVOR);
        hashSet.add(SemanticAttributes.NET_HOST_NAME);
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Attributes applyClientDurationAndSizeView(Attributes attributes, Attributes attributes2) {
        AttributesBuilder builder = Attributes.CC.builder();
        Set<AttributeKey> set = durationClientView;
        applyView(builder, attributes, set);
        applyView(builder, attributes2, set);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Attributes applyServerDurationAndSizeView(Attributes attributes, Attributes attributes2) {
        AttributesBuilder builder = Attributes.CC.builder();
        Set<AttributeKey> set = durationServerView;
        applyView(builder, attributes, set);
        applyView(builder, attributes2, set);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Attributes applyActiveRequestsView(Attributes attributes) {
        AttributesBuilder builder = Attributes.CC.builder();
        applyView(builder, attributes, activeRequestsView);
        return builder.build();
    }

    private static void applyView(final AttributesBuilder attributesBuilder, Attributes attributes, final Set<AttributeKey> set) {
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.TemporaryMetricsView$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                TemporaryMetricsView.lambda$applyView$0(set, attributesBuilder, (AttributeKey) obj, obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$applyView$0(Set set, AttributesBuilder attributesBuilder, AttributeKey attributeKey, Object obj) {
        if (set.contains(attributeKey)) {
            attributesBuilder.put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
        }
    }

    private TemporaryMetricsView() {
    }
}
