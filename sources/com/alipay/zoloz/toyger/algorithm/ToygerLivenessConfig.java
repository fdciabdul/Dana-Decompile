package com.alipay.zoloz.toyger.algorithm;

/* loaded from: classes7.dex */
public class ToygerLivenessConfig {
    public float batLivenessThreshold;
    public String collection;
    public float dragonflyMax;
    public float dragonflyMin;
    public boolean fppPreProcess;
    public float geminiMax;
    public float geminiMin;
    public String livenessCombinations;

    public ToygerLivenessConfig() {
        this.batLivenessThreshold = 0.5f;
        this.dragonflyMin = 0.0f;
        this.dragonflyMax = 0.0f;
        this.geminiMin = 0.0f;
        this.geminiMax = 0.0f;
        this.fppPreProcess = false;
    }

    public ToygerLivenessConfig(String str, float f, boolean z) {
        this.dragonflyMin = 0.0f;
        this.dragonflyMax = 0.0f;
        this.geminiMin = 0.0f;
        this.geminiMax = 0.0f;
        this.livenessCombinations = str;
        this.batLivenessThreshold = f;
        this.fppPreProcess = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToygerLivenessConfig{livenessCombinations='");
        sb.append(this.livenessCombinations);
        sb.append('\'');
        sb.append(", collection='");
        sb.append(this.collection);
        sb.append('\'');
        sb.append(", batLivenessThreshold=");
        sb.append(this.batLivenessThreshold);
        sb.append(", dragonflyMin=");
        sb.append(this.dragonflyMin);
        sb.append(", dragonflyMax=");
        sb.append(this.dragonflyMax);
        sb.append(", geminiMin=");
        sb.append(this.geminiMin);
        sb.append(", geminiMax=");
        sb.append(this.geminiMax);
        sb.append('}');
        return sb.toString();
    }
}
