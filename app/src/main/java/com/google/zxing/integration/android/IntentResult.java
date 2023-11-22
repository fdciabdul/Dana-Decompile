package com.google.zxing.integration.android;

import android.content.Intent;

/* loaded from: classes7.dex */
public final class IntentResult {
    private final String barcodeImagePath;
    private final String contents;
    private final String errorCorrectionLevel;
    private final String formatName;
    private final Integer orientation;
    private final Intent originalIntent;
    private final byte[] rawBytes;

    IntentResult() {
        this(null, null, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntentResult(Intent intent) {
        this(null, null, null, null, null, null, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntentResult(String str, String str2, byte[] bArr, Integer num, String str3, String str4, Intent intent) {
        this.contents = str;
        this.formatName = str2;
        this.rawBytes = bArr;
        this.orientation = num;
        this.errorCorrectionLevel = str3;
        this.barcodeImagePath = str4;
        this.originalIntent = intent;
    }

    public final String getContents() {
        return this.contents;
    }

    public final String getFormatName() {
        return this.formatName;
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final Integer getOrientation() {
        return this.orientation;
    }

    public final String getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public final String getBarcodeImagePath() {
        return this.barcodeImagePath;
    }

    public final Intent getOriginalIntent() {
        return this.originalIntent;
    }

    public final String toString() {
        byte[] bArr = this.rawBytes;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sb = new StringBuilder();
        sb.append("Format: ");
        sb.append(this.formatName);
        sb.append('\n');
        sb.append("Contents: ");
        sb.append(this.contents);
        sb.append('\n');
        sb.append("Raw bytes: (");
        sb.append(length);
        sb.append(" bytes)\nOrientation: ");
        sb.append(this.orientation);
        sb.append('\n');
        sb.append("EC level: ");
        sb.append(this.errorCorrectionLevel);
        sb.append('\n');
        sb.append("Barcode image: ");
        sb.append(this.barcodeImagePath);
        sb.append('\n');
        sb.append("Original intent: ");
        sb.append(this.originalIntent);
        sb.append('\n');
        return sb.toString();
    }
}
