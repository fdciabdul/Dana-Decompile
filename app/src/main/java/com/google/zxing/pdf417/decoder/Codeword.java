package com.google.zxing.pdf417.decoder;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes3.dex */
final class Codeword {
    private static final int BARCODE_ROW_UNKNOWN = -1;
    private final int bucket;
    private final int endX;
    private int rowNumber = -1;
    private final int startX;
    private final int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Codeword(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.endX = i2;
        this.bucket = i3;
        this.value = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasValidRowNumber() {
        return isValidRowNumber(this.rowNumber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isValidRowNumber(int i) {
        return i != -1 && this.bucket == (i % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getWidth() {
        return this.endX - this.startX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getStartX() {
        return this.startX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getEndX() {
        return this.endX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getBucket() {
        return this.bucket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getRowNumber() {
        return this.rowNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRowNumber(int i) {
        this.rowNumber = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rowNumber);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(this.value);
        return sb.toString();
    }
}
