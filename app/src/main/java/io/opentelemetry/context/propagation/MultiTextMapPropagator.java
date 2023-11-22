package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class MultiTextMapPropagator implements TextMapPropagator {
    private final Collection<String> allFields;
    private final TextMapPropagator[] textPropagators;

    MultiTextMapPropagator(TextMapPropagator... textMapPropagatorArr) {
        this(Arrays.asList(textMapPropagatorArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiTextMapPropagator(List<TextMapPropagator> list) {
        TextMapPropagator[] textMapPropagatorArr = new TextMapPropagator[list.size()];
        this.textPropagators = textMapPropagatorArr;
        list.toArray(textMapPropagatorArr);
        this.allFields = Collections.unmodifiableList(getAllFields(textMapPropagatorArr));
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final Collection<String> fields() {
        return this.allFields;
    }

    private static List<String> getAllFields(TextMapPropagator[] textMapPropagatorArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (TextMapPropagator textMapPropagator : textMapPropagatorArr) {
            linkedHashSet.addAll(textMapPropagator.fields());
        }
        return new ArrayList(linkedHashSet);
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public final <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
        if (context == null || textMapSetter == null) {
            return;
        }
        for (TextMapPropagator textMapPropagator : this.textPropagators) {
            textMapPropagator.inject(context, c, textMapSetter);
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
        for (TextMapPropagator textMapPropagator : this.textPropagators) {
            context = textMapPropagator.extract(context, c, textMapGetter);
        }
        return context;
    }
}
