package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import com.mixpanel.android.util.ActivityImageUtils;
import com.mixpanel.android.util.StackBlurManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class BackgroundCapture {
    private static final int KClassImpl$Data$declaredNonStaticMembers$2 = Color.argb(186, 28, 28, 28);

    /* loaded from: classes8.dex */
    public interface OnBackgroundCapturedListener {
    }

    BackgroundCapture() {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.BackgroundCapture$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ OnBackgroundCapturedListener MyBillsEntityDataFactory;
        final /* synthetic */ Activity getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            new BackgroundCaptureTask(this.getAuthRequestContext, this.MyBillsEntityDataFactory).execute(new Void[0]);
        }
    }

    /* loaded from: classes8.dex */
    static class BackgroundCaptureTask extends AsyncTask<Void, Void, Void> {
        private Bitmap BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2 = -16777216;
        private final Activity MyBillsEntityDataFactory;
        private final OnBackgroundCapturedListener getAuthRequestContext;

        @Override // android.os.AsyncTask
        protected /* synthetic */ Void doInBackground(Void[] voidArr) {
            return BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
        }

        public BackgroundCaptureTask(Activity activity, OnBackgroundCapturedListener onBackgroundCapturedListener) {
            this.MyBillsEntityDataFactory = activity;
            this.getAuthRequestContext = onBackgroundCapturedListener;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Bitmap PlaceComponentResult = ActivityImageUtils.PlaceComponentResult(this.MyBillsEntityDataFactory, 2, 2, true);
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ActivityImageUtils.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }

        private Void BuiltInFictitiousFunctionClassFactory() {
            Bitmap bitmap = this.BuiltInFictitiousFunctionClassFactory;
            if (bitmap != null) {
                try {
                    StackBlurManager.BuiltInFictitiousFunctionClassFactory(bitmap);
                    new Canvas(this.BuiltInFictitiousFunctionClassFactory).drawColor(BackgroundCapture.KClassImpl$Data$declaredNonStaticMembers$2, PorterDuff.Mode.SRC_ATOP);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    this.BuiltInFictitiousFunctionClassFactory = null;
                } catch (OutOfMemoryError unused2) {
                    this.BuiltInFictitiousFunctionClassFactory = null;
                }
            }
            return null;
        }
    }
}
