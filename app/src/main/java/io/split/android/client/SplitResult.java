package io.split.android.client;

/* loaded from: classes6.dex */
public class SplitResult {
    private String config;
    private String treatment;

    public SplitResult(String str, String str2) {
        this.treatment = str;
        this.config = str2;
    }

    public SplitResult(String str) {
        this(str, null);
    }

    public String treatment() {
        return this.treatment;
    }

    public String config() {
        return this.config;
    }
}
