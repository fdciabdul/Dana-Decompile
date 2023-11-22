package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Palette {
    static final Filter PlaceComponentResult = new Filter() { // from class: androidx.palette.graphics.Palette.1
        @Override // androidx.palette.graphics.Palette.Filter
        public final boolean BuiltInFictitiousFunctionClassFactory(float[] fArr) {
            return (KClassImpl$Data$declaredNonStaticMembers$2(fArr) || getAuthRequestContext(fArr) || PlaceComponentResult(fArr)) ? false : true;
        }

        private static boolean getAuthRequestContext(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        private static boolean PlaceComponentResult(float[] fArr) {
            float f = fArr[0];
            return f >= 10.0f && f <= 37.0f && fArr[1] <= 0.82f;
        }
    };
    public final Swatch KClassImpl$Data$declaredNonStaticMembers$2;
    final List<Target> MyBillsEntityDataFactory;
    final List<Swatch> getAuthRequestContext;
    final SparseBooleanArray getErrorConfigVersion = new SparseBooleanArray();
    final Map<Target, Swatch> BuiltInFictitiousFunctionClassFactory = new ArrayMap();

    /* loaded from: classes3.dex */
    public interface Filter {
        boolean BuiltInFictitiousFunctionClassFactory(float[] fArr);
    }

    /* loaded from: classes3.dex */
    public interface PaletteAsyncListener {
        void BuiltInFictitiousFunctionClassFactory(Palette palette);
    }

    public static Builder PlaceComponentResult(Bitmap bitmap) {
        return new Builder(bitmap);
    }

    Palette(List<Swatch> list, List<Target> list2) {
        this.getAuthRequestContext = list;
        this.MyBillsEntityDataFactory = list2;
        int size = this.getAuthRequestContext.size();
        int i = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = this.getAuthRequestContext.get(i2);
            if (swatch2.getAuthRequestContext > i) {
                i = swatch2.getAuthRequestContext;
                swatch = swatch2;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = swatch;
    }

    final boolean getAuthRequestContext(Swatch swatch, Target target) {
        float[] PlaceComponentResult2 = swatch.PlaceComponentResult();
        return PlaceComponentResult2[1] >= target.getErrorConfigVersion[0] && PlaceComponentResult2[1] <= target.getErrorConfigVersion[2] && PlaceComponentResult2[2] >= target.moveToNextValue[0] && PlaceComponentResult2[2] <= target.moveToNextValue[2] && !this.getErrorConfigVersion.get(swatch.PlaceComponentResult);
    }

    /* loaded from: classes3.dex */
    public static final class Swatch {
        private int BuiltInFictitiousFunctionClassFactory;
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        public final int PlaceComponentResult;
        final int getAuthRequestContext;
        private int getErrorConfigVersion;
        private final int moveToNextValue;
        private final int scheduleImpl;

        public Swatch(int i, int i2) {
            this.scheduleImpl = Color.red(i);
            this.moveToNextValue = Color.green(i);
            this.MyBillsEntityDataFactory = Color.blue(i);
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = i2;
        }

        public final float[] PlaceComponentResult() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[3];
            }
            ColorUtils.PlaceComponentResult(this.scheduleImpl, this.moveToNextValue, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            int MyBillsEntityDataFactory;
            int MyBillsEntityDataFactory2;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            int MyBillsEntityDataFactory3 = ColorUtils.MyBillsEntityDataFactory(-1, this.PlaceComponentResult, 4.5f);
            int MyBillsEntityDataFactory4 = ColorUtils.MyBillsEntityDataFactory(-1, this.PlaceComponentResult, 3.0f);
            if (MyBillsEntityDataFactory3 != -1 && MyBillsEntityDataFactory4 != -1) {
                this.BuiltInFictitiousFunctionClassFactory = ColorUtils.MyBillsEntityDataFactory(-1, MyBillsEntityDataFactory3);
                this.getErrorConfigVersion = ColorUtils.MyBillsEntityDataFactory(-1, MyBillsEntityDataFactory4);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return;
            }
            int MyBillsEntityDataFactory5 = ColorUtils.MyBillsEntityDataFactory(-16777216, this.PlaceComponentResult, 4.5f);
            int MyBillsEntityDataFactory6 = ColorUtils.MyBillsEntityDataFactory(-16777216, this.PlaceComponentResult, 3.0f);
            if (MyBillsEntityDataFactory5 != -1 && MyBillsEntityDataFactory6 != -1) {
                this.BuiltInFictitiousFunctionClassFactory = ColorUtils.MyBillsEntityDataFactory(-16777216, MyBillsEntityDataFactory5);
                this.getErrorConfigVersion = ColorUtils.MyBillsEntityDataFactory(-16777216, MyBillsEntityDataFactory6);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return;
            }
            if (MyBillsEntityDataFactory3 != -1) {
                MyBillsEntityDataFactory = ColorUtils.MyBillsEntityDataFactory(-1, MyBillsEntityDataFactory3);
            } else {
                MyBillsEntityDataFactory = ColorUtils.MyBillsEntityDataFactory(-16777216, MyBillsEntityDataFactory5);
            }
            this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            if (MyBillsEntityDataFactory4 != -1) {
                MyBillsEntityDataFactory2 = ColorUtils.MyBillsEntityDataFactory(-1, MyBillsEntityDataFactory4);
            } else {
                MyBillsEntityDataFactory2 = ColorUtils.MyBillsEntityDataFactory(-16777216, MyBillsEntityDataFactory6);
            }
            this.getErrorConfigVersion = MyBillsEntityDataFactory2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(getClass().getSimpleName());
            sb.append(" [RGB: #");
            sb.append(Integer.toHexString(this.PlaceComponentResult));
            sb.append(']');
            sb.append(" [HSL: ");
            sb.append(Arrays.toString(PlaceComponentResult()));
            sb.append(']');
            sb.append(" [Population: ");
            sb.append(this.getAuthRequestContext);
            sb.append(']');
            sb.append(" [Title Text: #");
            BuiltInFictitiousFunctionClassFactory();
            sb.append(Integer.toHexString(this.getErrorConfigVersion));
            sb.append(']');
            sb.append(" [Body Text: #");
            BuiltInFictitiousFunctionClassFactory();
            sb.append(Integer.toHexString(this.BuiltInFictitiousFunctionClassFactory));
            sb.append(']');
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            return this.getAuthRequestContext == swatch.getAuthRequestContext && this.PlaceComponentResult == swatch.PlaceComponentResult;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult * 31) + this.getAuthRequestContext;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        Rect BuiltInFictitiousFunctionClassFactory;
        final List<Filter> KClassImpl$Data$declaredNonStaticMembers$2;
        public final Bitmap MyBillsEntityDataFactory;
        final List<Target> NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int getErrorConfigVersion;
        final List<Swatch> scheduleImpl;

        public Builder(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arrayList;
            this.getAuthRequestContext = 16;
            this.PlaceComponentResult = 12544;
            this.getErrorConfigVersion = -1;
            ArrayList arrayList2 = new ArrayList();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(Palette.PlaceComponentResult);
            this.MyBillsEntityDataFactory = bitmap;
            this.scheduleImpl = null;
            arrayList.add(Target.KClassImpl$Data$declaredNonStaticMembers$2);
            arrayList.add(Target.scheduleImpl);
            arrayList.add(Target.PlaceComponentResult);
            arrayList.add(Target.BuiltInFictitiousFunctionClassFactory);
            arrayList.add(Target.getAuthRequestContext);
            arrayList.add(Target.MyBillsEntityDataFactory);
        }
    }
}
