package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ColorCutQuantizer {
    private static final Comparator<Vbox> getErrorConfigVersion = new Comparator<Vbox>() { // from class: androidx.palette.graphics.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.PlaceComponentResult() - vbox.PlaceComponentResult();
        }
    };
    final int[] BuiltInFictitiousFunctionClassFactory;
    final List<Palette.Swatch> KClassImpl$Data$declaredNonStaticMembers$2;
    final Palette.Filter[] MyBillsEntityDataFactory;
    final int[] PlaceComponentResult;
    private final float[] lookAheadTest = new float[3];
    final TimingLogger getAuthRequestContext = null;

    static int BuiltInFictitiousFunctionClassFactory(int i) {
        return i & 31;
    }

    static int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return (i >> 10) & 31;
    }

    static int getAuthRequestContext(int i) {
        return (i >> 5) & 31;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorCutQuantizer(int[] iArr, int i, Palette.Filter[] filterArr) {
        Vbox vbox;
        int i2;
        this.MyBillsEntityDataFactory = filterArr;
        int[] iArr2 = new int[32768];
        this.BuiltInFictitiousFunctionClassFactory = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            int blue = ((Color.blue(i4) >> 3) & 31) | (((Color.red(i4) >> 3) & 31) << 10) | (((Color.green(i4) >> 3) & 31) << 5);
            iArr[i3] = blue;
            iArr2[blue] = iArr2[blue] + 1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0 && PlaceComponentResult(i6)) {
                iArr2[i6] = 0;
            }
            if (iArr2[i6] > 0) {
                i5++;
            }
        }
        int[] iArr3 = new int[i5];
        this.PlaceComponentResult = iArr3;
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                iArr3[i7] = i8;
                i7++;
            }
        }
        if (i5 <= i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = iArr3[i9];
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(new Palette.Swatch(Color.rgb((((i10 >> 10) & 31) << 3) & 255, (((i10 >> 5) & 31) << 3) & 255, ((i10 & 31) << 3) & 255), iArr2[i10]));
            }
            return;
        }
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue(i, getErrorConfigVersion);
        priorityQueue.offer(new Vbox(0, this.PlaceComponentResult.length - 1));
        while (priorityQueue.size() < i && (vbox = (Vbox) priorityQueue.poll()) != null && vbox.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (!vbox.KClassImpl$Data$declaredNonStaticMembers$2()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int i11 = vbox.KClassImpl$Data$declaredNonStaticMembers$2 - vbox.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i12 = vbox.getAuthRequestContext - vbox.moveToNextValue;
            int i13 = vbox.BuiltInFictitiousFunctionClassFactory - vbox.PlaceComponentResult;
            int i14 = (i11 < i12 || i11 < i13) ? (i12 < i11 || i12 < i13) ? -1 : -2 : -3;
            int[] iArr4 = ColorCutQuantizer.this.PlaceComponentResult;
            int[] iArr5 = ColorCutQuantizer.this.BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory(iArr4, i14, vbox.MyBillsEntityDataFactory, vbox.scheduleImpl);
            Arrays.sort(iArr4, vbox.MyBillsEntityDataFactory, vbox.scheduleImpl + 1);
            BuiltInFictitiousFunctionClassFactory(iArr4, i14, vbox.MyBillsEntityDataFactory, vbox.scheduleImpl);
            int i15 = vbox.getErrorConfigVersion / 2;
            int i16 = vbox.MyBillsEntityDataFactory;
            int i17 = 0;
            while (true) {
                int i18 = vbox.scheduleImpl;
                if (i16 <= i18) {
                    i17 += iArr5[iArr4[i16]];
                    if (i17 >= i15) {
                        i2 = Math.min(i18 - 1, i16);
                        break;
                    }
                    i16++;
                } else {
                    i2 = vbox.MyBillsEntityDataFactory;
                    break;
                }
            }
            Vbox vbox2 = new Vbox(i2 + 1, vbox.scheduleImpl);
            vbox.scheduleImpl = i2;
            vbox.getAuthRequestContext();
            priorityQueue.offer(vbox2);
            priorityQueue.offer(vbox);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (Vbox vbox3 : priorityQueue) {
            int[] iArr6 = ColorCutQuantizer.this.PlaceComponentResult;
            int[] iArr7 = ColorCutQuantizer.this.BuiltInFictitiousFunctionClassFactory;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = vbox3.MyBillsEntityDataFactory; i23 <= vbox3.scheduleImpl; i23++) {
                int i24 = iArr6[i23];
                int i25 = iArr7[i24];
                i20 += i25;
                i19 += ((i24 >> 10) & 31) * i25;
                i21 += ((i24 >> 5) & 31) * i25;
                i22 += i25 * (i24 & 31);
            }
            float f = i20;
            Palette.Swatch swatch = new Palette.Swatch(Color.rgb((Math.round(i19 / f) << 3) & 255, (Math.round(i21 / f) << 3) & 255, (Math.round(i22 / f) << 3) & 255), i20);
            if (!KClassImpl$Data$declaredNonStaticMembers$2(swatch)) {
                arrayList.add(swatch);
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
    }

    /* loaded from: classes3.dex */
    class Vbox {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int getErrorConfigVersion;
        int moveToNextValue;
        int scheduleImpl;

        Vbox(int i, int i2) {
            this.MyBillsEntityDataFactory = i;
            this.scheduleImpl = i2;
            getAuthRequestContext();
        }

        final int PlaceComponentResult() {
            return ((this.KClassImpl$Data$declaredNonStaticMembers$2 - this.NetworkUserEntityData$$ExternalSyntheticLambda0) + 1) * ((this.getAuthRequestContext - this.moveToNextValue) + 1) * ((this.BuiltInFictitiousFunctionClassFactory - this.PlaceComponentResult) + 1);
        }

        final void getAuthRequestContext() {
            int[] iArr = ColorCutQuantizer.this.PlaceComponentResult;
            int[] iArr2 = ColorCutQuantizer.this.BuiltInFictitiousFunctionClassFactory;
            int i = Integer.MIN_VALUE;
            int i2 = Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = 0;
            for (int i8 = this.MyBillsEntityDataFactory; i8 <= this.scheduleImpl; i8++) {
                int i9 = iArr[i8];
                i7 += iArr2[i9];
                int KClassImpl$Data$declaredNonStaticMembers$2 = ColorCutQuantizer.KClassImpl$Data$declaredNonStaticMembers$2(i9);
                int authRequestContext = ColorCutQuantizer.getAuthRequestContext(i9);
                int BuiltInFictitiousFunctionClassFactory = ColorCutQuantizer.BuiltInFictitiousFunctionClassFactory(i9);
                if (KClassImpl$Data$declaredNonStaticMembers$2 > i) {
                    i = KClassImpl$Data$declaredNonStaticMembers$2;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                    i4 = KClassImpl$Data$declaredNonStaticMembers$2;
                }
                if (authRequestContext > i2) {
                    i2 = authRequestContext;
                }
                if (authRequestContext < i5) {
                    i5 = authRequestContext;
                }
                if (BuiltInFictitiousFunctionClassFactory > i3) {
                    i3 = BuiltInFictitiousFunctionClassFactory;
                }
                if (BuiltInFictitiousFunctionClassFactory < i6) {
                    i6 = BuiltInFictitiousFunctionClassFactory;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i4;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.moveToNextValue = i5;
            this.getAuthRequestContext = i2;
            this.PlaceComponentResult = i6;
            this.BuiltInFictitiousFunctionClassFactory = i3;
            this.getErrorConfigVersion = i7;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return (this.scheduleImpl + 1) - this.MyBillsEntityDataFactory > 1;
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = (i4 & 31) | (((i4 >> 5) & 31) << 10) | (((i4 >> 10) & 31) << 5);
                i2++;
            }
        } else if (i == -1) {
            while (i2 <= i3) {
                int i5 = iArr[i2];
                iArr[i2] = ((i5 >> 10) & 31) | ((i5 & 31) << 10) | (((i5 >> 5) & 31) << 5);
                i2++;
            }
        }
    }

    private boolean PlaceComponentResult(float[] fArr) {
        Palette.Filter[] filterArr = this.MyBillsEntityDataFactory;
        if (filterArr != null && filterArr.length > 0) {
            int length = filterArr.length;
            for (int i = 0; i < length; i++) {
                if (!this.MyBillsEntityDataFactory[i].BuiltInFictitiousFunctionClassFactory(fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean PlaceComponentResult(int i) {
        ColorUtils.MyBillsEntityDataFactory(Color.rgb((((i >> 10) & 31) << 3) & 255, (((i >> 5) & 31) << 3) & 255, ((i & 31) << 3) & 255), this.lookAheadTest);
        return PlaceComponentResult(this.lookAheadTest);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Palette.Swatch swatch) {
        int i = swatch.PlaceComponentResult;
        return PlaceComponentResult(swatch.PlaceComponentResult());
    }
}
