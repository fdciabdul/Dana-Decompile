package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.danah5.akulaku.AkuEventParamsKey;

/* loaded from: classes3.dex */
public final class MemorySizeCalculator {
    public final int BuiltInFictitiousFunctionClassFactory;
    public final int MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    public final int getAuthRequestContext;

    /* loaded from: classes3.dex */
    interface ScreenDimensions {
        int KClassImpl$Data$declaredNonStaticMembers$2();

        int PlaceComponentResult();
    }

    public MemorySizeCalculator(Builder builder) {
        int i;
        this.PlaceComponentResult = builder.PlaceComponentResult;
        if (PlaceComponentResult(builder.BuiltInFictitiousFunctionClassFactory)) {
            i = builder.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
        } else {
            i = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        this.MyBillsEntityDataFactory = i;
        int round = Math.round(r1.getMemoryClass() * 1024 * 1024 * (PlaceComponentResult(builder.BuiltInFictitiousFunctionClassFactory) ? builder.scheduleImpl : builder.getErrorConfigVersion));
        float PlaceComponentResult = builder.lookAheadTest.PlaceComponentResult() * builder.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2() * 4;
        int round2 = Math.round(builder.getAuthRequestContext * PlaceComponentResult);
        int round3 = Math.round(PlaceComponentResult * builder.NetworkUserEntityData$$ExternalSyntheticLambda0);
        int i2 = round - i;
        int i3 = round3 + round2;
        if (i3 <= i2) {
            this.getAuthRequestContext = round3;
            this.BuiltInFictitiousFunctionClassFactory = round2;
        } else {
            float f = i2 / (builder.getAuthRequestContext + builder.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.getAuthRequestContext = Math.round(builder.NetworkUserEntityData$$ExternalSyntheticLambda0 * f);
            this.BuiltInFictitiousFunctionClassFactory = Math.round(f * builder.getAuthRequestContext);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(Formatter.formatFileSize(this.PlaceComponentResult, this.getAuthRequestContext));
            sb.append(", pool size: ");
            sb.append(Formatter.formatFileSize(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory));
            sb.append(", byte array size: ");
            sb.append(Formatter.formatFileSize(this.PlaceComponentResult, i));
            sb.append(", memory class limited? ");
            sb.append(i3 > round);
            sb.append(", max size: ");
            sb.append(Formatter.formatFileSize(this.PlaceComponentResult, round));
            sb.append(", memoryClass: ");
            sb.append(builder.BuiltInFictitiousFunctionClassFactory.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(PlaceComponentResult(builder.BuiltInFictitiousFunctionClassFactory));
            InstrumentInjector.log_d("MemorySizeCalculator", sb.toString());
        }
    }

    static boolean PlaceComponentResult(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        static final int MyBillsEntityDataFactory;
        ActivityManager BuiltInFictitiousFunctionClassFactory;
        final Context PlaceComponentResult;
        float getAuthRequestContext;
        ScreenDimensions lookAheadTest;
        float NetworkUserEntityData$$ExternalSyntheticLambda0 = 2.0f;
        float getErrorConfigVersion = 0.4f;
        float scheduleImpl = 0.33f;
        int KClassImpl$Data$declaredNonStaticMembers$2 = 4194304;

        static {
            MyBillsEntityDataFactory = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            this.getAuthRequestContext = MyBillsEntityDataFactory;
            this.PlaceComponentResult = context;
            this.BuiltInFictitiousFunctionClassFactory = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
            this.lookAheadTest = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory)) {
                return;
            }
            this.getAuthRequestContext = 0.0f;
        }
    }

    /* loaded from: classes3.dex */
    static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics BuiltInFictitiousFunctionClassFactory;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.BuiltInFictitiousFunctionClassFactory = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public final int PlaceComponentResult() {
            return this.BuiltInFictitiousFunctionClassFactory.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory.heightPixels;
        }
    }
}
