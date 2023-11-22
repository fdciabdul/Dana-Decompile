package io.split.android.client.telemetry.model;

/* loaded from: classes6.dex */
public enum OperationMode {
    STANDALONE(0),
    CONSUMER(1);

    private final int numericValue;

    OperationMode(int i) {
        this.numericValue = i;
    }

    public final int getNumericValue() {
        return this.numericValue;
    }
}
