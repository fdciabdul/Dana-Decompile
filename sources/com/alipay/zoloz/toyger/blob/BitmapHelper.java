package com.alipay.zoloz.toyger.blob;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class BitmapHelper {
    public static final int FRAME_MODE_BGR = 2;
    public static final int FRAME_MODE_BGRA = 1;
    public static final int FRAME_MODE_NV21 = 0;
    public static final int FRAME_MODE_RGB = 4;
    public static final int FRAME_MODE_RGBA = 3;

    public static int convertByteToInt(byte b) {
        return (((b >> 4) & 15) * 16) + (b & 15);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr, int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return RGBBytes2Bitmap(bArr, i, i2);
                }
                return RGBABytes2Bitmap(bArr, i, i2);
            }
            return BGRBytes2Bitmap(bArr, i, i2);
        }
        return getYUVBitmap(bArr, i, i2);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static Bitmap RGBABytes2Bitmap(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        return createBitmap;
    }

    public static Bitmap RGBBytes2Bitmap(byte[] bArr, int i, int i2) {
        int[] convertBytesToInts = convertBytesToInts(bArr);
        if (convertBytesToInts == null) {
            return null;
        }
        return Bitmap.createBitmap(convertBytesToInts, 0, i, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap BGRBytes2Bitmap(byte[] bArr, int i, int i2) {
        int[] convertBytesToIntsBGR = convertBytesToIntsBGR(bArr);
        if (convertBytesToIntsBGR == null) {
            return null;
        }
        return Bitmap.createBitmap(convertBytesToIntsBGR, 0, i, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static int[] convertBytesToIntsBGR(byte[] bArr) {
        int i;
        int length = bArr.length;
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = length % 3 != 0 ? 1 : 0;
        int i4 = (length / 3) + i3;
        int[] iArr = new int[i4];
        if (i3 == 0) {
            while (i2 < i4) {
                int i5 = i2 * 3;
                iArr[i2] = (convertByteToInt(bArr[i5 + 2]) << 16) | (convertByteToInt(bArr[i5 + 1]) << 8) | convertByteToInt(bArr[i5]) | (-16777216);
                i2++;
            }
        } else {
            while (true) {
                i = i4 - 1;
                if (i2 >= i) {
                    break;
                }
                int i6 = i2 * 3;
                iArr[i2] = (convertByteToInt(bArr[i6 + 2]) << 16) | (convertByteToInt(bArr[i6 + 1]) << 8) | convertByteToInt(bArr[i6]) | (-16777216);
                i2++;
            }
            iArr[i] = -16777216;
        }
        return iArr;
    }

    public static int[] convertBytesToInts(byte[] bArr) {
        int i;
        int length = bArr.length;
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = length % 3 != 0 ? 1 : 0;
        int i4 = (length / 3) + i3;
        int[] iArr = new int[i4];
        if (i3 == 0) {
            while (i2 < i4) {
                int i5 = i2 * 3;
                iArr[i2] = convertByteToInt(bArr[i5 + 2]) | (convertByteToInt(bArr[i5]) << 16) | (convertByteToInt(bArr[i5 + 1]) << 8) | (-16777216);
                i2++;
            }
        } else {
            while (true) {
                i = i4 - 1;
                if (i2 >= i) {
                    break;
                }
                int i6 = i2 * 3;
                iArr[i2] = convertByteToInt(bArr[i6 + 2]) | (convertByteToInt(bArr[i6]) << 16) | (convertByteToInt(bArr[i6 + 1]) << 8) | (-16777216);
                i2++;
            }
            iArr[i] = -16777216;
        }
        return iArr;
    }

    public static Bitmap readBitMap(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] Bitmap2BytesEx(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return addBMP_RGB_888(iArr, width, height);
    }

    private static byte[] addBMP_RGB_888(int[] iArr, int i, int i2) {
        byte[] bArr = new byte[i2 * i * 4];
        int length = iArr.length - 1;
        int i3 = 0;
        while (length >= i) {
            int i4 = length - i;
            for (int i5 = i4 + 1; i5 <= length; i5++) {
                int i6 = iArr[i5];
                bArr[i3] = (byte) (i6 >> 0);
                bArr[i3 + 1] = (byte) (i6 >> 8);
                bArr[i3 + 2] = (byte) (i6 >> 16);
                bArr[i3 + 3] = (byte) (i6 >> 24);
                i3 += 4;
            }
            length = i4;
        }
        return bArr;
    }

    public static Bitmap resize(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            bitmap.recycle();
            return createBitmap;
        }
        return null;
    }

    public static Bitmap resize(Bitmap bitmap, int i) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = i / width;
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                bitmap.recycle();
                return createBitmap;
            } catch (OutOfMemoryError unused) {
                return bitmap;
            }
        }
        return null;
    }

    public static void recycle(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static Bitmap getBitmap(byte[] bArr, int i, int i2) {
        if (bArr == 0) {
            return null;
        }
        int length = bArr.length / 3;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 3;
            int i5 = bArr[i4];
            int i6 = bArr[i4 + 1];
            int i7 = bArr[i4 + 2];
            if (i5 < 0) {
                i5 += 256;
            }
            if (i6 < 0) {
                i6 += 256;
            }
            if (i7 < 0) {
                i7 += 256;
            }
            iArr[i3] = Color.rgb(i5, i6, i7);
        }
        return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap getYUVBitmap(byte[] bArr, int i, int i2) {
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        } catch (OutOfMemoryError | Error unused) {
            return null;
        }
    }

    public static Bitmap getYUVBitmap(byte[] bArr, int i, int i2, int i3) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), i3, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static byte[] processImage(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        if (i != 0) {
            if (i != 3) {
                if (i != 4) {
                    return null;
                }
                return compressRGBImage(bArr, i2, i3, i4, i5);
            }
            return compressRGBAImage(bArr, i2, i3, i4, i5);
        }
        return rotateYUVImage(bArr, i2, i3, i4, i5);
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap, int i) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (OutOfMemoryError unused2) {
            return null;
        }
    }

    public static byte[] compressRGBImage(byte[] bArr, int i, int i2, int i3, int i4) {
        byte[] bArr2;
        Bitmap RGBBytes2Bitmap = RGBBytes2Bitmap(bArr, i, i2);
        if (i3 == 90 || i3 == 270) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i3);
            Bitmap createBitmap = Bitmap.createBitmap(RGBBytes2Bitmap, 0, 0, RGBBytes2Bitmap.getWidth(), RGBBytes2Bitmap.getHeight(), matrix, true);
            byte[] bitmapToByteArray = bitmapToByteArray(createBitmap, i4);
            createBitmap.recycle();
            bArr2 = bitmapToByteArray;
        } else {
            bArr2 = bitmapToByteArray(RGBBytes2Bitmap, i4);
        }
        RGBBytes2Bitmap.recycle();
        return bArr2;
    }

    public static byte[] compressRGBAImage(byte[] bArr, int i, int i2, int i3, int i4) {
        byte[] bArr2;
        Bitmap RGBABytes2Bitmap = RGBABytes2Bitmap(bArr, i, i2);
        if (i3 == 90 || i3 == 270) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i3);
            Bitmap createBitmap = Bitmap.createBitmap(RGBABytes2Bitmap, 0, 0, RGBABytes2Bitmap.getWidth(), RGBABytes2Bitmap.getHeight(), matrix, true);
            byte[] bitmapToByteArray = bitmapToByteArray(createBitmap, i4);
            createBitmap.recycle();
            bArr2 = bitmapToByteArray;
        } else {
            bArr2 = bitmapToByteArray(RGBABytes2Bitmap, i4);
        }
        RGBABytes2Bitmap.recycle();
        return bArr2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(1:3)(2:15|(1:17)(7:18|5|(1:7)|8|9|10|11))|4|5|(0)|8|9|10|11) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] rotateYUVImage(byte[] r7, int r8, int r9, int r10, int r11) {
        /*
            r0 = 90
            if (r10 != r0) goto L9
            byte[] r7 = rotateYUV420Degree270(r7, r8, r9)
            goto L11
        L9:
            r0 = 270(0x10e, float:3.78E-43)
            if (r10 != r0) goto L16
            byte[] r7 = rotateYUV420Degree90(r7, r8, r9)
        L11:
            r1 = r7
            r6 = r9
            r9 = r8
            r8 = r6
            goto L17
        L16:
            r1 = r7
        L17:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            if (r1 == 0) goto L32
            android.graphics.YuvImage r10 = new android.graphics.YuvImage
            r2 = 17
            r5 = 0
            r0 = r10
            r3 = r8
            r4 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            android.graphics.Rect r0 = new android.graphics.Rect
            r1 = 0
            r0.<init>(r1, r1, r8, r9)
            r10.compressToJpeg(r0, r11, r7)
        L32:
            r7.close()     // Catch: java.io.IOException -> L35
        L35:
            byte[] r7 = r7.toByteArray()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.toyger.blob.BitmapHelper.rotateYUVImage(byte[], int, int, int, int):byte[]");
    }

    public static byte[] rotateYUV420Degree90(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = i2 - 1; i7 >= 0; i7--) {
                bArr2[i5] = bArr[(i7 * i) + i6];
                i5++;
            }
        }
        int i8 = i4 - 1;
        for (int i9 = i - 1; i9 > 0; i9 -= 2) {
            for (int i10 = 0; i10 < i2 / 2; i10++) {
                int i11 = (i10 * i) + i3;
                bArr2[i8] = bArr[i11 + i9];
                int i12 = i8 - 1;
                bArr2[i12] = bArr[i11 + (i9 - 1)];
                i8 = i12 - 1;
            }
        }
        return bArr2;
    }

    private static byte[] rotateYUV420Degree180(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 * 3) / 2;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        for (int i7 = i4 - 1; i7 >= i3; i7 -= 2) {
            int i8 = i5 + 1;
            bArr2[i5] = bArr[i7 - 1];
            i5 = i8 + 1;
            bArr2[i8] = bArr[i7];
        }
        return bArr2;
    }

    public static byte[] rotateYUV420Degree270(byte[] bArr, int i, int i2) {
        return rotateYUV420Degree180(rotateYUV420Degree90(bArr, i, i2), i, i2);
    }

    public static Bitmap reverseBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        float[] fArr = i != 0 ? new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f} : new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return recycle(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), bitmap);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.setRotate(i);
            return recycle(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false), bitmap);
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap cropBitmap(Bitmap bitmap, Rect rect) {
        if (bitmap == null) {
            return null;
        }
        try {
            bitmap.getWidth();
            bitmap.getHeight();
            return recycle(Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top), bitmap);
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    private static Bitmap recycle(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return bitmap2;
        }
        if (bitmap != bitmap2) {
            bitmap2.recycle();
        }
        return bitmap;
    }
}
