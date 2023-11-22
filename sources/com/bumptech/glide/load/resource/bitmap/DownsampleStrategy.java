package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.Option;

/* loaded from: classes3.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy KClassImpl$Data$declaredNonStaticMembers$2;
    static final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final DownsampleStrategy getAuthRequestContext;
    public static final DownsampleStrategy getErrorConfigVersion;
    public static final Option<DownsampleStrategy> scheduleImpl;
    public static final DownsampleStrategy PlaceComponentResult = new AtLeast();
    public static final DownsampleStrategy BuiltInFictitiousFunctionClassFactory = new AtMost();
    public static final DownsampleStrategy moveToNextValue = new FitCenter();
    public static final DownsampleStrategy MyBillsEntityDataFactory = new CenterInside();

    /* loaded from: classes3.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    public abstract SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4);

    public abstract float MyBillsEntityDataFactory(int i, int i2, int i3, int i4);

    static {
        CenterOutside centerOutside = new CenterOutside();
        KClassImpl$Data$declaredNonStaticMembers$2 = centerOutside;
        getErrorConfigVersion = new None();
        getAuthRequestContext = centerOutside;
        scheduleImpl = Option.PlaceComponentResult("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = Build.VERSION.SDK_INT >= 19;
    }

    /* loaded from: classes3.dex */
    static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return Math.min(i3 / i, i4 / i2);
            }
            if (Math.max(i2 / i4, i / i3) != 0) {
                return 1.0f / Integer.highestOneBit(r2);
            }
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: classes3.dex */
    static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes3.dex */
    static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            if (Math.min(i2 / i4, i / i3) != 0) {
                return 1.0f / Integer.highestOneBit(r1);
            }
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes3.dex */
    static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: classes3.dex */
    static class None extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes3.dex */
    static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final float MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, moveToNextValue.MyBillsEntityDataFactory(i, i2, i3, i4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public final SampleSizeRounding KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
            if (Math.min(1.0f, moveToNextValue.MyBillsEntityDataFactory(i, i2, i3, i4)) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, i4);
        }
    }
}
