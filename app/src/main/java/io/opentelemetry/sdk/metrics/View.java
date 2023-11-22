package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import j$.util.StringJoiner;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class View {
    public abstract Aggregation getAggregation();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AttributesProcessor getAttributesProcessor();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getName();

    public static ViewBuilder builder() {
        return new ViewBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View create(@Nullable String str, @Nullable String str2, Aggregation aggregation, AttributesProcessor attributesProcessor) {
        return new AutoValue_View(str, str2, aggregation, attributesProcessor);
    }

    public final String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "View{", "}");
        if (getName() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("name=");
            sb.append(getName());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb.toString());
        }
        if (getDescription() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("description=");
            sb2.append(getDescription());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("aggregation=");
        sb3.append(getAggregation());
        stringJoiner.BuiltInFictitiousFunctionClassFactory(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("attributesProcessor=");
        sb4.append(getAttributesProcessor());
        stringJoiner.BuiltInFictitiousFunctionClassFactory(sb4.toString());
        return stringJoiner.toString();
    }
}
