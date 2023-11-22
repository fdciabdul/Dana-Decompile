package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class AutoValue_RegisteredView extends RegisteredView {
    private final InstrumentSelector instrumentSelector;
    private final View view;
    private final AttributesProcessor viewAttributesProcessor;
    private final SourceInfo viewSourceInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_RegisteredView(InstrumentSelector instrumentSelector, View view, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        if (instrumentSelector == null) {
            throw new NullPointerException("Null instrumentSelector");
        }
        this.instrumentSelector = instrumentSelector;
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
        if (attributesProcessor == null) {
            throw new NullPointerException("Null viewAttributesProcessor");
        }
        this.viewAttributesProcessor = attributesProcessor;
        if (sourceInfo == null) {
            throw new NullPointerException("Null viewSourceInfo");
        }
        this.viewSourceInfo = sourceInfo;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public final InstrumentSelector getInstrumentSelector() {
        return this.instrumentSelector;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public final View getView() {
        return this.view;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public final AttributesProcessor getViewAttributesProcessor() {
        return this.viewAttributesProcessor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public final SourceInfo getViewSourceInfo() {
        return this.viewSourceInfo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegisteredView) {
            RegisteredView registeredView = (RegisteredView) obj;
            return this.instrumentSelector.equals(registeredView.getInstrumentSelector()) && this.view.equals(registeredView.getView()) && this.viewAttributesProcessor.equals(registeredView.getViewAttributesProcessor()) && this.viewSourceInfo.equals(registeredView.getViewSourceInfo());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.instrumentSelector.hashCode();
        return ((((((hashCode ^ 1000003) * 1000003) ^ this.view.hashCode()) * 1000003) ^ this.viewAttributesProcessor.hashCode()) * 1000003) ^ this.viewSourceInfo.hashCode();
    }
}
