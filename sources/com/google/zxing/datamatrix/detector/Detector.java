package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    public final DetectorResult detect() throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        BitMatrix sampleGrid;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint3 = detect[0];
        ResultPoint resultPoint4 = detect[1];
        ResultPoint resultPoint5 = detect[2];
        ResultPoint resultPoint6 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
        arrayList.add(transitionsBetween(resultPoint5, resultPoint6));
        AnonymousClass1 anonymousClass1 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        Object obj = null;
        Object obj2 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            Object obj3 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                obj = obj3;
            } else if (anonymousClass1 == null) {
                anonymousClass1 = obj3;
            } else {
                obj2 = obj3;
            }
        }
        if (anonymousClass1 == null || obj == null || obj2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {anonymousClass1, obj, obj2};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint7 = resultPointArr[0];
        ResultPoint resultPoint8 = resultPointArr[1];
        ResultPoint resultPoint9 = resultPointArr[2];
        if (!hashMap.containsKey(resultPoint3)) {
            resultPoint = resultPoint3;
        } else if (hashMap.containsKey(resultPoint4)) {
            resultPoint = !hashMap.containsKey(resultPoint5) ? resultPoint5 : resultPoint6;
        } else {
            resultPoint = resultPoint4;
        }
        int transitions = transitionsBetween(resultPoint9, resultPoint).getTransitions();
        int transitions2 = transitionsBetween(resultPoint7, resultPoint).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i2 = transitions2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            resultPoint2 = resultPoint9;
            ResultPoint correctTopRightRectangular = correctTopRightRectangular(resultPoint8, resultPoint7, resultPoint9, resultPoint, i, i2);
            if (correctTopRightRectangular != null) {
                resultPoint = correctTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint2, resultPoint).getTransitions();
            int transitions4 = transitionsBetween(resultPoint7, resultPoint).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i3 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint2, resultPoint8, resultPoint7, resultPoint, i3, transitions4);
        } else {
            ResultPoint correctTopRight = correctTopRight(resultPoint8, resultPoint7, resultPoint9, resultPoint, Math.min(i2, i));
            if (correctTopRight != null) {
                resultPoint = correctTopRight;
            }
            int max = Math.max(transitionsBetween(resultPoint9, resultPoint).getTransitions(), transitionsBetween(resultPoint7, resultPoint).getTransitions()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i4 = max;
            sampleGrid = sampleGrid(this.image, resultPoint9, resultPoint8, resultPoint7, resultPoint, i4, i4);
            resultPoint2 = resultPoint9;
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint2, resultPoint8, resultPoint7, resultPoint});
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        float distance = distance(resultPoint, resultPoint2) / i;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / i2;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (!isValid(resultPoint5)) {
            if (isValid(resultPoint6)) {
                return resultPoint6;
            }
            return null;
        } else if (isValid(resultPoint6)) {
            return Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions()) ? resultPoint5 : resultPoint6;
        } else {
            return resultPoint5;
        }
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f = i;
        float distance = distance(resultPoint, resultPoint2) / f;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / f;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        } else if (isValid(resultPoint6)) {
            return resultPoint6;
        } else {
            return null;
        }
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i = 0;
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (z) {
            y = x;
            x = y;
            y2 = x2;
            x2 = y2;
        }
        int abs = Math.abs(x2 - x);
        int abs2 = Math.abs(y2 - y);
        int i2 = (-abs) / 2;
        int i3 = y < y2 ? 1 : -1;
        int i4 = x >= x2 ? -1 : 1;
        boolean z2 = this.image.get(z ? y : x, z ? x : y);
        while (x != x2) {
            boolean z3 = this.image.get(z ? y : x, z ? x : y);
            if (z3 != z2) {
                i++;
                z2 = z3;
            }
            i2 += abs2;
            if (i2 > 0) {
                if (y == y2) {
                    break;
                }
                y += i3;
                i2 -= abs;
            }
            x += i4;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }

        final ResultPoint getFrom() {
            return this.from;
        }

        final ResultPoint getTo() {
            return this.to;
        }

        final int getTransitions() {
            return this.transitions;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.from);
            sb.append("/");
            sb.append(this.to);
            sb.append('/');
            sb.append(this.transitions);
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public final int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }
}
