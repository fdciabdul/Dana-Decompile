package com.google.zxing.client.result;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes7.dex */
public final class GeoParsedResult extends ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final String query;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoParsedResult(double d, double d2, double d3, String str) {
        super(ParsedResultType.GEO);
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.query = str;
    }

    public final String getGeoURI() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.latitude);
        sb.append(',');
        sb.append(this.longitude);
        if (this.altitude > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            sb.append(',');
            sb.append(this.altitude);
        }
        if (this.query != null) {
            sb.append('?');
            sb.append(this.query);
        }
        return sb.toString();
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final String getQuery() {
        return this.query;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public final String getDisplayResult() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.latitude);
        sb.append(", ");
        sb.append(this.longitude);
        if (this.altitude > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            sb.append(", ");
            sb.append(this.altitude);
            sb.append('m');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(')');
        }
        return sb.toString();
    }
}