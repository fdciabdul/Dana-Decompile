package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes7.dex */
final class zaa implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final ParcelFileDescriptor zac;

    public zaa(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Bitmap bitmap;
        Handler handler;
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.zac;
        boolean z2 = false;
        Bitmap bitmap2 = null;
        if (parcelFileDescriptor != null) {
            try {
                bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                String valueOf = String.valueOf(this.zab);
                String.valueOf(valueOf).length();
                InstrumentInjector.log_e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(valueOf)), e);
                z2 = true;
            }
            try {
                this.zac.close();
            } catch (IOException e2) {
                InstrumentInjector.log_e("ImageManager", "closed failed", e2);
            }
            z = z2;
            bitmap = bitmap2;
        } else {
            bitmap = null;
            z = false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        handler = imageManager.zae;
        handler.post(new zac(imageManager, this.zab, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            String valueOf2 = String.valueOf(this.zab);
            String.valueOf(valueOf2).length();
            InstrumentInjector.log_w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(valueOf2)));
        }
    }
}
