package io.opentelemetry.sdk.metrics;

import j$.util.StringJoiner;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class InstrumentSelector {
    @Nullable
    public abstract String getInstrumentName();

    @Nullable
    public abstract InstrumentType getInstrumentType();

    @Nullable
    public abstract String getMeterName();

    @Nullable
    public abstract String getMeterSchemaUrl();

    @Nullable
    public abstract String getMeterVersion();

    public static InstrumentSelectorBuilder builder() {
        return new InstrumentSelectorBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InstrumentSelector create(@Nullable InstrumentType instrumentType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new AutoValue_InstrumentSelector(instrumentType, str, str2, str3, str4);
    }

    public final String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "InstrumentSelector{", "}");
        if (getInstrumentType() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("instrumentType=");
            sb.append(getInstrumentType());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb.toString());
        }
        if (getInstrumentName() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("instrumentName=");
            sb2.append(getInstrumentName());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb2.toString());
        }
        if (getMeterName() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("meterName=");
            sb3.append(getMeterName());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb3.toString());
        }
        if (getMeterVersion() != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("meterVersion=");
            sb4.append(getMeterVersion());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb4.toString());
        }
        if (getMeterSchemaUrl() != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("meterSchemaUrl=");
            sb5.append(getMeterSchemaUrl());
            stringJoiner.BuiltInFictitiousFunctionClassFactory(sb5.toString());
        }
        return stringJoiner.toString();
    }
}
