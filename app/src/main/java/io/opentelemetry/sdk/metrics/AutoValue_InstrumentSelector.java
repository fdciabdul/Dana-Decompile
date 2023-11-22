package io.opentelemetry.sdk.metrics;

import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class AutoValue_InstrumentSelector extends InstrumentSelector {
    private final String instrumentName;
    private final InstrumentType instrumentType;
    private final String meterName;
    private final String meterSchemaUrl;
    private final String meterVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentSelector(@Nullable InstrumentType instrumentType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.instrumentType = instrumentType;
        this.instrumentName = str;
        this.meterName = str2;
        this.meterVersion = str3;
        this.meterSchemaUrl = str4;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public final String getInstrumentName() {
        return this.instrumentName;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public final String getMeterName() {
        return this.meterName;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public final String getMeterVersion() {
        return this.meterVersion;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public final String getMeterSchemaUrl() {
        return this.meterSchemaUrl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentSelector) {
            InstrumentSelector instrumentSelector = (InstrumentSelector) obj;
            InstrumentType instrumentType = this.instrumentType;
            if (instrumentType != null ? instrumentType.equals(instrumentSelector.getInstrumentType()) : instrumentSelector.getInstrumentType() == null) {
                String str = this.instrumentName;
                if (str != null ? str.equals(instrumentSelector.getInstrumentName()) : instrumentSelector.getInstrumentName() == null) {
                    String str2 = this.meterName;
                    if (str2 != null ? str2.equals(instrumentSelector.getMeterName()) : instrumentSelector.getMeterName() == null) {
                        String str3 = this.meterVersion;
                        if (str3 != null ? str3.equals(instrumentSelector.getMeterVersion()) : instrumentSelector.getMeterVersion() == null) {
                            String str4 = this.meterSchemaUrl;
                            if (str4 == null) {
                                if (instrumentSelector.getMeterSchemaUrl() == null) {
                                    return true;
                                }
                            } else if (str4.equals(instrumentSelector.getMeterSchemaUrl())) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        InstrumentType instrumentType = this.instrumentType;
        int hashCode = instrumentType == null ? 0 : instrumentType.hashCode();
        String str = this.instrumentName;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.meterName;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.meterVersion;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.meterSchemaUrl;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ (str4 != null ? str4.hashCode() : 0);
    }
}
