package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* loaded from: classes2.dex */
public abstract class RegisteredView {
    public abstract InstrumentSelector getInstrumentSelector();

    public abstract View getView();

    public abstract AttributesProcessor getViewAttributesProcessor();

    public abstract SourceInfo getViewSourceInfo();

    public static RegisteredView create(InstrumentSelector instrumentSelector, View view, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        return new AutoValue_RegisteredView(instrumentSelector, view, attributesProcessor, sourceInfo);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisteredView{instrumentSelector=");
        sb.append(getInstrumentSelector());
        sb.append(", view=");
        sb.append(getView());
        sb.append("}");
        return sb.toString();
    }
}
