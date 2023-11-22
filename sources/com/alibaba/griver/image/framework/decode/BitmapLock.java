package com.alibaba.griver.image.framework.decode;

import android.graphics.Bitmap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class BitmapLock {

    /* renamed from: a  reason: collision with root package name */
    private static Lock f6575a = new ReentrantLock();
    private static boolean b = false;

    /* loaded from: classes6.dex */
    public interface ImageHandler {
        Bitmap handle();
    }

    private BitmapLock() {
    }

    public static Bitmap handleBitmap(ImageHandler imageHandler) {
        if (imageHandler == null) {
            return null;
        }
        if (b) {
            f6575a.lock();
            try {
                return imageHandler.handle();
            } finally {
                f6575a.unlock();
            }
        }
        return imageHandler.handle();
    }
}
