package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* loaded from: classes3.dex */
final class BoundingBox {
    private final ResultPoint bottomLeft;
    private final ResultPoint bottomRight;
    private final BitMatrix image;
    private final int maxX;
    private final int maxY;
    private final int minX;
    private final int minY;
    private final ResultPoint topLeft;
    private final ResultPoint topRight;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = resultPoint == null || resultPoint2 == null;
        boolean z2 = resultPoint3 == null || resultPoint4 == null;
        if (z && z2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z) {
            resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
            resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
        } else if (z2) {
            resultPoint3 = new ResultPoint(bitMatrix.getWidth() - 1, resultPoint.getY());
            resultPoint4 = new ResultPoint(bitMatrix.getWidth() - 1, resultPoint2.getY());
        }
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        this.minX = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
        this.maxX = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
        this.minY = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
        this.maxY = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundingBox(BoundingBox boundingBox) {
        this.image = boundingBox.image;
        this.topLeft = boundingBox.getTopLeft();
        this.bottomLeft = boundingBox.getBottomLeft();
        this.topRight = boundingBox.getTopRight();
        this.bottomRight = boundingBox.getBottomRight();
        this.minX = boundingBox.getMinX();
        this.maxX = boundingBox.getMaxX();
        this.minY = boundingBox.getMinY();
        this.maxY = boundingBox.getMaxY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        return boundingBox == null ? boundingBox2 : boundingBox2 == null ? boundingBox : new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.zxing.pdf417.decoder.BoundingBox addMissingRows(int r11, int r12, boolean r13) throws com.google.zxing.NotFoundException {
        /*
            r10 = this;
            com.google.zxing.ResultPoint r0 = r10.topLeft
            com.google.zxing.ResultPoint r1 = r10.bottomLeft
            com.google.zxing.ResultPoint r2 = r10.topRight
            com.google.zxing.ResultPoint r3 = r10.bottomRight
            if (r11 <= 0) goto L29
            if (r13 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.getY()
            int r5 = (int) r5
            int r5 = r5 - r11
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.google.zxing.ResultPoint r11 = new com.google.zxing.ResultPoint
            float r4 = r4.getX()
            float r5 = (float) r5
            r11.<init>(r4, r5)
            if (r13 == 0) goto L26
            r0 = r11
            goto L29
        L26:
            r8 = r11
            r6 = r0
            goto L2b
        L29:
            r6 = r0
            r8 = r2
        L2b:
            if (r12 <= 0) goto L5a
            if (r13 == 0) goto L32
            com.google.zxing.ResultPoint r11 = r10.bottomLeft
            goto L34
        L32:
            com.google.zxing.ResultPoint r11 = r10.bottomRight
        L34:
            float r0 = r11.getY()
            int r0 = (int) r0
            int r0 = r0 + r12
            com.google.zxing.common.BitMatrix r12 = r10.image
            int r12 = r12.getHeight()
            if (r0 < r12) goto L4a
            com.google.zxing.common.BitMatrix r12 = r10.image
            int r12 = r12.getHeight()
            int r0 = r12 + (-1)
        L4a:
            com.google.zxing.ResultPoint r12 = new com.google.zxing.ResultPoint
            float r11 = r11.getX()
            float r0 = (float) r0
            r12.<init>(r11, r0)
            if (r13 != 0) goto L59
            r9 = r12
            r7 = r1
            goto L5c
        L59:
            r1 = r12
        L5a:
            r7 = r1
            r9 = r3
        L5c:
            com.google.zxing.pdf417.decoder.BoundingBox r11 = new com.google.zxing.pdf417.decoder.BoundingBox
            com.google.zxing.common.BitMatrix r5 = r10.image
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.BoundingBox.addMissingRows(int, int, boolean):com.google.zxing.pdf417.decoder.BoundingBox");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getMinX() {
        return this.minX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getMaxX() {
        return this.maxX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getMinY() {
        return this.minY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getMaxY() {
        return this.maxY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ResultPoint getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ResultPoint getTopRight() {
        return this.topRight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
