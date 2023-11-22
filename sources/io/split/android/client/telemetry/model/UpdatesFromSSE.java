package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UpdatesFromSSE {
    @SerializedName("ms")
    private long mMySegments;
    @SerializedName(RVParams.SHOW_PROGRESS)
    private long mSplits;

    public UpdatesFromSSE(long j, long j2) {
        this.mSplits = j;
        this.mMySegments = j2;
    }

    public long getSplits() {
        return this.mSplits;
    }

    public long getMySegments() {
        return this.mMySegments;
    }
}
