package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

/* loaded from: classes3.dex */
final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    private void setRowNumbers() {
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        int rowNumber;
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (imageRowToCodewordIndex < imageRowToCodewordIndex2) {
            Codeword codeword = codewords[imageRowToCodewordIndex];
            if (codeword != null) {
                int rowNumber2 = codeword.getRowNumber() - i;
                if (rowNumber2 == 0) {
                    i2++;
                } else {
                    if (rowNumber2 == 1) {
                        int max = Math.max(i3, i2);
                        rowNumber = codeword.getRowNumber();
                        i3 = max;
                    } else if (rowNumber2 < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber2 > imageRowToCodewordIndex) {
                        codewords[imageRowToCodewordIndex] = null;
                    } else {
                        if (i3 > 2) {
                            rowNumber2 *= i3 - 2;
                        }
                        boolean z = rowNumber2 >= imageRowToCodewordIndex;
                        for (int i4 = 1; i4 <= rowNumber2 && !z; i4++) {
                            z = codewords[imageRowToCodewordIndex - i4] != null;
                        }
                        if (z) {
                            codewords[imageRowToCodewordIndex] = null;
                        } else {
                            rowNumber = codeword.getRowNumber();
                        }
                    }
                    i = rowNumber;
                    i2 = 1;
                }
            }
            imageRowToCodewordIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] getRowHeights() {
        int rowNumber;
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int rowCount = barcodeMetadata.getRowCount();
        int[] iArr = new int[rowCount];
        for (Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) bottomLeft.getY());
        Codeword[] codewords = getCodewords();
        int i = -1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) topLeft.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber = codeword.getRowNumber() - i;
                if (rowNumber != 0) {
                    if (rowNumber == 1) {
                        i = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[imageRowToCodewordIndex2] = null;
                    } else {
                        i = codeword.getRowNumber();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                int i = rowNumber % 3;
                if (i == 0) {
                    barcodeValue2.setValue((value * 3) + 1);
                } else if (i == 1) {
                    barcodeValue4.setValue(value / 3);
                    barcodeValue3.setValue(value % 3);
                } else if (i == 2) {
                    barcodeValue.setValue(value + 1);
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codeword != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i2 = rowNumber % 3;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                                codewordArr[i] = null;
                            }
                        } else if (i2 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                            codewordArr[i] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i] = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isLeft() {
        return this.isLeft;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public final String toString() {
        StringBuilder sb = new StringBuilder("IsLeft: ");
        sb.append(this.isLeft);
        sb.append('\n');
        sb.append(super.toString());
        return sb.toString();
    }
}
