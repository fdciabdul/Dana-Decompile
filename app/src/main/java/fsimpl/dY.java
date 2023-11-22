package fsimpl;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.fullstory.jni.FSNativeHooks;
import java.io.InputStream;

/* loaded from: classes.dex */
public class dY implements FSNativeHooks {

    /* renamed from: a  reason: collision with root package name */
    public int f7929a = -1;
    private FSNativeHooks b = null;

    public void a(FSNativeHooks fSNativeHooks) {
        this.b = fSNativeHooks;
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void destroyAsset(AssetManager assetManager, int i) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.destroyAsset(assetManager, i);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void destroyAsset(AssetManager assetManager, long j) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.destroyAsset(assetManager, j);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nCreate(Class cls, Object obj, long j, Object obj2) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nCreate(cls, obj, j, obj2);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nCreate(Class cls, Object obj, InputStream inputStream, byte[] bArr, Object obj2) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nCreate(cls, obj, inputStream, bArr, obj2);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nDecodeBitmap(Class cls, Bitmap bitmap, long j, Object obj, boolean z, int i, int i2, Rect rect, boolean z2, int i3, boolean z3, boolean z4, boolean z5, long j2, boolean z6) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nDecodeBitmap(cls, bitmap, j, obj, z, i, i2, rect, z2, i3, z3, z4, z5, j2, z6);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nDecodeBitmap(Class cls, Bitmap bitmap, long j, Object obj, boolean z, int i, int i2, Rect rect, boolean z2, int i3, boolean z3, boolean z4, boolean z5, Object obj2) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nDecodeBitmap(cls, bitmap, j, obj, z, i, i2, rect, z2, i3, z3, z4, z5, obj2);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeAssetDestroy(Class cls, long j) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeAssetDestroy(cls, j);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, int i, Rect rect, BitmapFactory.Options options) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeDecodeAsset(cls, bitmap, i, rect, options);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, int i, Rect rect, BitmapFactory.Options options, boolean z, float f) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeDecodeAsset(cls, bitmap, i, rect, options, z, f);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeDecodeAsset(cls, bitmap, j, rect, options);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options, long j2, long j3) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeDecodeAsset(cls, bitmap, j, rect, options, j2, j3);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options, boolean z, float f) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeDecodeAsset(cls, bitmap, j, rect, options, z, f);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeOpenNonAsset(Class cls, long j, long j2, int i, String str, int i2) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.nativeOpenNonAsset(cls, j, j2, i, str, i2);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void openNonAssetNative(AssetManager assetManager, int i, int i2, String str, int i3) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.openNonAssetNative(assetManager, i, i2, str, i3);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void openNonAssetNative(AssetManager assetManager, long j, int i, String str, int i2) {
        FSNativeHooks fSNativeHooks = this.b;
        if (fSNativeHooks != null) {
            fSNativeHooks.openNonAssetNative(assetManager, j, i, str, i2);
        }
    }
}
