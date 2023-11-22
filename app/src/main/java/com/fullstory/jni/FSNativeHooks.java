package com.fullstory.jni;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface FSNativeHooks {
    void destroyAsset(AssetManager assetManager, int i);

    void destroyAsset(AssetManager assetManager, long j);

    void nCreate(Class cls, Object obj, long j, Object obj2);

    void nCreate(Class cls, Object obj, InputStream inputStream, byte[] bArr, Object obj2);

    void nDecodeBitmap(Class cls, Bitmap bitmap, long j, Object obj, boolean z, int i, int i2, Rect rect, boolean z2, int i3, boolean z3, boolean z4, boolean z5, long j2, boolean z6);

    void nDecodeBitmap(Class cls, Bitmap bitmap, long j, Object obj, boolean z, int i, int i2, Rect rect, boolean z2, int i3, boolean z3, boolean z4, boolean z5, Object obj2);

    void nativeAssetDestroy(Class cls, long j);

    void nativeDecodeAsset(Class cls, Bitmap bitmap, int i, Rect rect, BitmapFactory.Options options);

    void nativeDecodeAsset(Class cls, Bitmap bitmap, int i, Rect rect, BitmapFactory.Options options, boolean z, float f);

    void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options);

    void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options, long j2, long j3);

    void nativeDecodeAsset(Class cls, Bitmap bitmap, long j, Rect rect, BitmapFactory.Options options, boolean z, float f);

    void nativeOpenNonAsset(Class cls, long j, long j2, int i, String str, int i2);

    void openNonAssetNative(AssetManager assetManager, int i, int i2, String str, int i3);

    void openNonAssetNative(AssetManager assetManager, long j, int i, String str, int i2);
}
