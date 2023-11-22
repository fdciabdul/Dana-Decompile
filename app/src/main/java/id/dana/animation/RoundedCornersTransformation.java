package id.dana.animation;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: classes5.dex */
public class RoundedCornersTransformation extends BitmapTransformation {
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int PlaceComponentResult;
    private final CornerType getAuthRequestContext;
    private final int scheduleImpl;

    /* loaded from: classes5.dex */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(width, height, Bitmap.Config.ARGB_8888);
        KClassImpl$Data$declaredNonStaticMembers$2.setHasAlpha(true);
        Canvas canvas = new Canvas(KClassImpl$Data$declaredNonStaticMembers$2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        float f = width;
        float f2 = height;
        float f3 = this.PlaceComponentResult;
        float f4 = f - f3;
        float f5 = f2 - f3;
        switch (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[this.getAuthRequestContext.ordinal()]) {
            case 1:
                float f6 = this.PlaceComponentResult;
                RectF rectF = new RectF(f6, f6, f4, f5);
                float f7 = this.scheduleImpl;
                canvas.drawRoundRect(rectF, f7, f7, paint);
                break;
            case 2:
                float f8 = this.PlaceComponentResult;
                float f9 = this.KClassImpl$Data$declaredNonStaticMembers$2 + f8;
                RectF rectF2 = new RectF(f8, f8, f9, f9);
                float f10 = this.scheduleImpl;
                canvas.drawRoundRect(rectF2, f10, f10, paint);
                float f11 = this.PlaceComponentResult;
                float f12 = this.scheduleImpl + f11;
                canvas.drawRect(new RectF(f11, f12, f12, f5), paint);
                float f13 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(this.scheduleImpl + f13, f13, f4, f5), paint);
                break;
            case 3:
                float f14 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                float f15 = this.PlaceComponentResult;
                RectF rectF3 = new RectF(f4 - f14, f15, f4, f14 + f15);
                float f16 = this.scheduleImpl;
                canvas.drawRoundRect(rectF3, f16, f16, paint);
                float f17 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f17, f17, f4 - this.scheduleImpl, f5), paint);
                float f18 = this.scheduleImpl;
                canvas.drawRect(new RectF(f4 - f18, this.PlaceComponentResult + f18, f4, f5), paint);
                break;
            case 4:
                float f19 = this.PlaceComponentResult;
                float f20 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                RectF rectF4 = new RectF(f19, f5 - f20, f20 + f19, f5);
                float f21 = this.scheduleImpl;
                canvas.drawRoundRect(rectF4, f21, f21, paint);
                float f22 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f22, f22, this.KClassImpl$Data$declaredNonStaticMembers$2 + f22, f5 - this.scheduleImpl), paint);
                float f23 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(this.scheduleImpl + f23, f23, f4, f5), paint);
                break;
            case 5:
                float f24 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                RectF rectF5 = new RectF(f4 - f24, f5 - f24, f4, f5);
                float f25 = this.scheduleImpl;
                canvas.drawRoundRect(rectF5, f25, f25, paint);
                float f26 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f26, f26, f4 - this.scheduleImpl, f5), paint);
                float f27 = this.scheduleImpl;
                canvas.drawRect(new RectF(f4 - f27, this.PlaceComponentResult, f4, f5 - f27), paint);
                break;
            case 6:
                float f28 = this.PlaceComponentResult;
                RectF rectF6 = new RectF(f28, f28, f4, this.KClassImpl$Data$declaredNonStaticMembers$2 + f28);
                float f29 = this.scheduleImpl;
                canvas.drawRoundRect(rectF6, f29, f29, paint);
                float f30 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f30, this.scheduleImpl + f30, f4, f5), paint);
                break;
            case 7:
                RectF rectF7 = new RectF(this.PlaceComponentResult, f5 - this.KClassImpl$Data$declaredNonStaticMembers$2, f4, f5);
                float f31 = this.scheduleImpl;
                canvas.drawRoundRect(rectF7, f31, f31, paint);
                float f32 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f32, f32, f4, f5 - this.scheduleImpl), paint);
                break;
            case 8:
                float f33 = this.PlaceComponentResult;
                RectF rectF8 = new RectF(f33, f33, this.KClassImpl$Data$declaredNonStaticMembers$2 + f33, f5);
                float f34 = this.scheduleImpl;
                canvas.drawRoundRect(rectF8, f34, f34, paint);
                float f35 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(this.scheduleImpl + f35, f35, f4, f5), paint);
                break;
            case 9:
                RectF rectF9 = new RectF(f4 - this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, f4, f5);
                float f36 = this.scheduleImpl;
                canvas.drawRoundRect(rectF9, f36, f36, paint);
                float f37 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f37, f37, f4 - this.scheduleImpl, f5), paint);
                break;
            case 10:
                RectF rectF10 = new RectF(this.PlaceComponentResult, f5 - this.KClassImpl$Data$declaredNonStaticMembers$2, f4, f5);
                float f38 = this.scheduleImpl;
                canvas.drawRoundRect(rectF10, f38, f38, paint);
                RectF rectF11 = new RectF(f4 - this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, f4, f5);
                float f39 = this.scheduleImpl;
                canvas.drawRoundRect(rectF11, f39, f39, paint);
                float f40 = this.PlaceComponentResult;
                float f41 = this.scheduleImpl;
                canvas.drawRect(new RectF(f40, f40, f4 - f41, f5 - f41), paint);
                break;
            case 11:
                float f42 = this.PlaceComponentResult;
                RectF rectF12 = new RectF(f42, f42, this.KClassImpl$Data$declaredNonStaticMembers$2 + f42, f5);
                float f43 = this.scheduleImpl;
                canvas.drawRoundRect(rectF12, f43, f43, paint);
                RectF rectF13 = new RectF(this.PlaceComponentResult, f5 - this.KClassImpl$Data$declaredNonStaticMembers$2, f4, f5);
                float f44 = this.scheduleImpl;
                canvas.drawRoundRect(rectF13, f44, f44, paint);
                float f45 = this.PlaceComponentResult;
                float f46 = this.scheduleImpl;
                canvas.drawRect(new RectF(f45 + f46, f45, f4, f5 - f46), paint);
                break;
            case 12:
                float f47 = this.PlaceComponentResult;
                RectF rectF14 = new RectF(f47, f47, f4, this.KClassImpl$Data$declaredNonStaticMembers$2 + f47);
                float f48 = this.scheduleImpl;
                canvas.drawRoundRect(rectF14, f48, f48, paint);
                RectF rectF15 = new RectF(f4 - this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, f4, f5);
                float f49 = this.scheduleImpl;
                canvas.drawRoundRect(rectF15, f49, f49, paint);
                float f50 = this.PlaceComponentResult;
                float f51 = this.scheduleImpl;
                canvas.drawRect(new RectF(f50, f50 + f51, f4 - f51, f5), paint);
                break;
            case 13:
                float f52 = this.PlaceComponentResult;
                RectF rectF16 = new RectF(f52, f52, f4, this.KClassImpl$Data$declaredNonStaticMembers$2 + f52);
                float f53 = this.scheduleImpl;
                canvas.drawRoundRect(rectF16, f53, f53, paint);
                float f54 = this.PlaceComponentResult;
                RectF rectF17 = new RectF(f54, f54, this.KClassImpl$Data$declaredNonStaticMembers$2 + f54, f5);
                float f55 = this.scheduleImpl;
                canvas.drawRoundRect(rectF17, f55, f55, paint);
                float f56 = this.PlaceComponentResult + this.scheduleImpl;
                canvas.drawRect(new RectF(f56, f56, f4, f5), paint);
                break;
            case 14:
                float f57 = this.PlaceComponentResult;
                float f58 = this.KClassImpl$Data$declaredNonStaticMembers$2 + f57;
                RectF rectF18 = new RectF(f57, f57, f58, f58);
                float f59 = this.scheduleImpl;
                canvas.drawRoundRect(rectF18, f59, f59, paint);
                float f60 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                RectF rectF19 = new RectF(f4 - f60, f5 - f60, f4, f5);
                float f61 = this.scheduleImpl;
                canvas.drawRoundRect(rectF19, f61, f61, paint);
                float f62 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(f62, this.scheduleImpl + f62, f4 - this.KClassImpl$Data$declaredNonStaticMembers$2, f5), paint);
                float f63 = this.PlaceComponentResult;
                canvas.drawRect(new RectF(this.KClassImpl$Data$declaredNonStaticMembers$2 + f63, f63, f4, f5 - this.scheduleImpl), paint);
                break;
            case 15:
                float f64 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                float f65 = this.PlaceComponentResult;
                RectF rectF20 = new RectF(f4 - f64, f65, f4, f64 + f65);
                float f66 = this.scheduleImpl;
                canvas.drawRoundRect(rectF20, f66, f66, paint);
                float f67 = this.PlaceComponentResult;
                float f68 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                RectF rectF21 = new RectF(f67, f5 - f68, f68 + f67, f5);
                float f69 = this.scheduleImpl;
                canvas.drawRoundRect(rectF21, f69, f69, paint);
                float f70 = this.PlaceComponentResult;
                float f71 = this.scheduleImpl;
                canvas.drawRect(new RectF(f70, f70, f4 - f71, f5 - f71), paint);
                float f72 = this.PlaceComponentResult + this.scheduleImpl;
                canvas.drawRect(new RectF(f72, f72, f4, f5), paint);
                break;
            default:
                float f73 = this.PlaceComponentResult;
                RectF rectF22 = new RectF(f73, f73, f4, f5);
                float f74 = this.scheduleImpl;
                canvas.drawRoundRect(rectF22, f74, f74, paint);
                break;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public RoundedCornersTransformation(int i, int i2) {
        this(i, i2, CornerType.ALL);
    }

    public RoundedCornersTransformation(int i, int i2, CornerType cornerType) {
        this.scheduleImpl = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i * 2;
        this.PlaceComponentResult = i2;
        this.getAuthRequestContext = cornerType;
    }

    /* renamed from: id.dana.home.RoundedCornersTransformation$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[CornerType.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RoundedTransformation(radius=");
        sb.append(this.scheduleImpl);
        sb.append(", margin=");
        sb.append(this.PlaceComponentResult);
        sb.append(", diameter=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", cornerType=");
        sb.append(this.getAuthRequestContext.name());
        sb.append(")");
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.scheduleImpl == this.scheduleImpl && roundedCornersTransformation.KClassImpl$Data$declaredNonStaticMembers$2 == this.KClassImpl$Data$declaredNonStaticMembers$2 && roundedCornersTransformation.PlaceComponentResult == this.PlaceComponentResult && roundedCornersTransformation.getAuthRequestContext == this.getAuthRequestContext) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.scheduleImpl * 10000) + 425235636 + (this.KClassImpl$Data$declaredNonStaticMembers$2 * 1000) + (this.PlaceComponentResult * 100) + (this.getAuthRequestContext.ordinal() * 10);
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        sb.append("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1");
        sb.append(this.scheduleImpl);
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(this.PlaceComponentResult);
        sb.append(this.getAuthRequestContext);
        messageDigest.update(sb.toString().getBytes(MyBillsEntityDataFactory));
    }
}
