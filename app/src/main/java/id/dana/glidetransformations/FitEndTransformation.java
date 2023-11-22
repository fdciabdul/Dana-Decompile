package id.dana.glidetransformations;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u000f\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/glidetransformations/FitEndTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "Landroid/graphics/Bitmap;", "p1", "p2", "p3", "getAuthRequestContext", "(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;", "Ljava/security/MessageDigest;", "", "(Ljava/security/MessageDigest;)V", "", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FitEndTransformation extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int getAuthRequestContext = 1;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    public FitEndTransformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("jp.wasabeef.glide.transformations.MaskTransformation.");
        sb.append(1);
        this.MyBillsEntityDataFactory = sb.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object p0) {
        return p0 instanceof FitEndTransformation;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = this.MyBillsEntityDataFactory;
        Charset charset = com.bumptech.glide.load.resource.bitmap.BitmapTransformation.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        p0.update(bytes);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public final Bitmap getAuthRequestContext(BitmapPool p0, Bitmap p1, int p2, int p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Bitmap createBitmap = Bitmap.createBitmap(p1, p1.getWidth() - p2, 0, p2, p3);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "");
        return createBitmap;
    }
}
