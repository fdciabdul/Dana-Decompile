package io.split.android.client.service.impressions;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.dtos.Identifiable;

/* loaded from: classes6.dex */
public class ImpressionsCountPerFeature implements Identifiable {
    private static final String FIELD_COUNT = "rc";
    private static final String FIELD_FEATURE = "f";
    private static final String FIELD_TIMEFRAME = "m";
    @SerializedName("rc")
    public final int count;
    @SerializedName("f")
    public final String feature;
    public transient long storageId;
    @SerializedName(FIELD_TIMEFRAME)
    public final long timeframe;

    public ImpressionsCountPerFeature(String str, long j, int i) {
        this.feature = str;
        this.timeframe = j;
        this.count = i;
    }

    public int hashCode() {
        return String.format("%s%d%d", this.feature, Long.valueOf(this.timeframe), Integer.valueOf(this.count)).hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImpressionsCountPerFeature impressionsCountPerFeature = (ImpressionsCountPerFeature) obj;
        return this.feature.equals(impressionsCountPerFeature.feature) && this.timeframe == impressionsCountPerFeature.timeframe && this.count == impressionsCountPerFeature.count;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }
}
