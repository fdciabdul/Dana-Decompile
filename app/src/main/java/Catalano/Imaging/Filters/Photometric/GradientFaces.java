package Catalano.Imaging.Filters.Photometric;

import Catalano.Math.Matrix;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class GradientFaces implements IPhotometricFilter {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private double KClassImpl$Data$declaredNonStaticMembers$2;
    private double[][] PlaceComponentResult;
    private double[][] getAuthRequestContext;

    public GradientFaces() {
        this((byte) 0);
    }

    private GradientFaces(byte b) {
        this((char) 0);
    }

    private GradientFaces(char c) {
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.75d;
        int floor = (int) Math.floor(2.625d);
        int i = (floor * 2) + 1;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (double[] dArr2 : dArr) {
            int i2 = -floor;
            int i3 = 0;
            while (i3 < dArr[0].length) {
                dArr2[i3] = i2;
                i3++;
                i2++;
            }
        }
        double[][] BuiltInFictitiousFunctionClassFactory = Matrix.BuiltInFictitiousFunctionClassFactory(dArr);
        this.getAuthRequestContext = (double[][]) Array.newInstance(Double.TYPE, dArr.length, dArr[0].length);
        int i4 = 0;
        while (true) {
            double[][] dArr3 = this.getAuthRequestContext;
            if (i4 >= dArr3.length) {
                this.PlaceComponentResult = Matrix.BuiltInFictitiousFunctionClassFactory(dArr3);
                this.BuiltInFictitiousFunctionClassFactory = false;
                return;
            }
            int i5 = 0;
            while (true) {
                double[][] dArr4 = this.getAuthRequestContext;
                if (i5 < dArr4[0].length) {
                    double[] dArr5 = dArr4[i4];
                    double d = dArr[i4][i5];
                    double d2 = BuiltInFictitiousFunctionClassFactory[i4][i5];
                    dArr5[i5] = (-2.0d) * d * Math.exp((-((d * d) + (d2 * d2))) / 1.125d);
                    i5++;
                }
            }
            i4++;
        }
    }
}
