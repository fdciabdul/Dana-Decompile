package com.splunk.rum;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public enum NetworkState {
    NO_NETWORK_AVAILABLE(SemanticAttributes.NetHostConnectionTypeValues.UNAVAILABLE),
    TRANSPORT_CELLULAR(SemanticAttributes.NetHostConnectionTypeValues.CELL),
    TRANSPORT_WIFI("wifi"),
    TRANSPORT_UNKNOWN("unknown"),
    TRANSPORT_VPN("vpn");

    private final String humanName;

    NetworkState(String str) {
        this.humanName = str;
    }

    public final String getHumanName() {
        return this.humanName;
    }
}
