package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.internal.Utils;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class InstrumentSelectorBuilder {
    @Nullable
    private String instrumentName;
    @Nullable
    private InstrumentType instrumentType;
    @Nullable
    private String meterName;
    @Nullable
    private String meterSchemaUrl;
    @Nullable
    private String meterVersion;

    public final InstrumentSelectorBuilder setType(InstrumentType instrumentType) {
        Objects.requireNonNull(instrumentType, "instrumentType");
        this.instrumentType = instrumentType;
        return this;
    }

    public final InstrumentSelectorBuilder setName(String str) {
        Objects.requireNonNull(str, "name");
        this.instrumentName = str;
        return this;
    }

    public final InstrumentSelectorBuilder setMeterName(String str) {
        Objects.requireNonNull(str, "meterName");
        this.meterName = str;
        return this;
    }

    public final InstrumentSelectorBuilder setMeterVersion(String str) {
        Objects.requireNonNull(str, "meterVersion");
        this.meterVersion = str;
        return this;
    }

    public final InstrumentSelectorBuilder setMeterSchemaUrl(String str) {
        Objects.requireNonNull(str, "meterSchemaUrl");
        this.meterSchemaUrl = str;
        return this;
    }

    public final InstrumentSelector build() {
        Utils.checkArgument((this.instrumentType == null && this.instrumentName == null && this.meterName == null && this.meterVersion == null && this.meterSchemaUrl == null) ? false : true, "Instrument selector must contain selection criteria");
        return InstrumentSelector.create(this.instrumentType, this.instrumentName, this.meterName, this.meterVersion, this.meterSchemaUrl);
    }
}
