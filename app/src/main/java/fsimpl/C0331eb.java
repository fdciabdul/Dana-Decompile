package fsimpl;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.fullstory.jni.FSNative;
import com.fullstory.jni.FSNativeHooks;
import com.fullstory.util.Log;
import java.io.InputStream;

/* renamed from: fsimpl.eb  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0331eb implements FSNativeHooks {

    /* renamed from: a  reason: collision with root package name */
    private static final C0332ec f7966a = new C0332ec();

    private static void a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("Closed ");
        sb.append(j);
        Log.d(sb.toString());
        f7966a.b(j);
    }

    private static void a(long j, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        String a2 = f7966a.a(j);
        StringBuilder sb = new StringBuilder();
        sb.append("Read ");
        sb.append(bitmap);
        sb.append(" from ");
        sb.append(a2);
        Log.i(sb.toString());
        f7966a.a(bitmap, a2);
    }

    private static void a(long j, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Opened ");
        sb.append(j);
        sb.append(" with filename ");
        sb.append(str);
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(i);
        Log.d(sb.toString());
        f7966a.a(j, str);
    }

    public static boolean hook() {
        int a2 = FSNative.a(new C0331eb());
        boolean z = a2 == 0;
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to initialize FS native hooks: ");
            sb.append(a2);
            Log.e(sb.toString());
        }
        return z;
    }

    public static String identify(Bitmap bitmap) {
        return f7966a.a(bitmap);
    }

    public static boolean unhook() {
        int a2 = FSNative.a(null);
        boolean z = a2 == -1;
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to un-initialize FS native hooks: ");
            sb.append(a2);
            Log.e(sb.toString());
        }
        return z;
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void destroyAsset(AssetManager assetManager, int i) {
        a(i);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void destroyAsset(AssetManager assetManager, long j) {
        a(j);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nCreate(Class cls, Object obj, long j, Object obj2) {
        f7966a.putImageDecoder(obj, Long.valueOf(j));
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nCreate(Class cls, Object obj, InputStream inputStream, byte[] bArr, Object obj2) {
        f7966a.putImageDecoder(obj, C0330ea.a(inputStream));
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nDecodeBitmap(Class cls, Bitmap bitmap, long j, Object obj, boolean z, int i, int i2, Rect rect, boolean z2, int i3, boolean z3, boolean z4, boolean z5, long j2, boolean z6) {
        Long removeImageDecoder = f7966a.removeImageDecoder(obj);
        if (removeImageDecoder != null) {
            a(removeImageDecoder.longValue(), bitmap);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nDecodeBitmap(Class cls, Bitmap bitmap, long j, Object obj, boolean z, int i, int i2, Rect rect, boolean z2, int i3, boolean z3, boolean z4, boolean z5, Object obj2) {
        Long removeImageDecoder = f7966a.removeImageDecoder(obj);
        if (removeImageDecoder != null) {
            a(removeImageDecoder.longValue(), bitmap);
        }
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeAssetDestroy(Class cls, long j) {
        a(j);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, int i, Rect rect, BitmapFactory.Options options) {
        a(i, bitmap);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, int i, Rect rect, BitmapFactory.Options options, boolean z, float f) {
        a(i, bitmap);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options) {
        a(j, bitmap);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options, long j2, long j3) {
        a(j, bitmap);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options, boolean z, float f) {
        a(j, bitmap);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void nativeOpenNonAsset(Class cls, long j, long j2, int i, String str, int i2) {
        a(j, str, i);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void openNonAssetNative(AssetManager assetManager, int i, int i2, String str, int i3) {
        a(i, str, i2);
    }

    @Override // com.fullstory.jni.FSNativeHooks
    public void openNonAssetNative(AssetManager assetManager, long j, int i, String str, int i2) {
        a(j, str, i);
    }
}
