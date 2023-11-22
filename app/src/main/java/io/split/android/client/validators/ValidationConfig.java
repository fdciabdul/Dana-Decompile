package io.split.android.client.validators;

/* loaded from: classes6.dex */
public class ValidationConfig {
    private static final ValidationConfig mInstance = new ValidationConfig();
    private static final int maximumEventPropertyBytes = 32768;
    private int mMaximumKeyLength = 250;
    private String mTrackEventNamePattern = "^[a-zA-Z0-9][-_.:a-zA-Z0-9]{0,79}$";

    public int getMaximumEventPropertyBytes() {
        return maximumEventPropertyBytes;
    }

    public static ValidationConfig getInstance() {
        return mInstance;
    }

    private ValidationConfig() {
    }

    public int getMaximumKeyLength() {
        return this.mMaximumKeyLength;
    }

    public void setMaximumKeyLength(int i) {
        this.mMaximumKeyLength = i;
    }

    public String getTrackEventNamePattern() {
        return this.mTrackEventNamePattern;
    }

    public void setTrackEventNamePattern(String str) {
        this.mTrackEventNamePattern = str;
    }
}
