package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.pdf.PrintedPdfDocument;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public final class PrintHelper {
    static final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    static final boolean MyBillsEntityDataFactory;
    BitmapFactory.Options BuiltInFictitiousFunctionClassFactory;
    final Context PlaceComponentResult;
    final Object getAuthRequestContext;
    int scheduleImpl;

    /* loaded from: classes6.dex */
    public interface OnPrintFinishCallback {
    }

    static {
        MyBillsEntityDataFactory = Build.VERSION.SDK_INT < 20 || Build.VERSION.SDK_INT > 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = Build.VERSION.SDK_INT != 23;
    }

    /* loaded from: classes6.dex */
    class PrintBitmapAdapter extends PrintDocumentAdapter {
        final /* synthetic */ PrintHelper BuiltInFictitiousFunctionClassFactory;
        private final Bitmap KClassImpl$Data$declaredNonStaticMembers$2;
        private final OnPrintFinishCallback MyBillsEntityDataFactory;
        private PrintAttributes PlaceComponentResult;
        private final int getAuthRequestContext;
        private final String moveToNextValue;

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.PlaceComponentResult = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.moveToNextValue).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PrintUriAdapter extends PrintDocumentAdapter {
        Bitmap BuiltInFictitiousFunctionClassFactory;
        PrintAttributes KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        final /* synthetic */ PrintHelper NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Uri PlaceComponentResult;
        final OnPrintFinishCallback getAuthRequestContext;
        final String getErrorConfigVersion;
        AsyncTask<Uri, Boolean, Bitmap> lookAheadTest;

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes printAttributes, final PrintAttributes printAttributes2, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.BuiltInFictitiousFunctionClassFactory != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.getErrorConfigVersion).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.lookAheadTest = new AsyncTask<Uri, Boolean, Bitmap>() { // from class: androidx.print.PrintHelper.PrintUriAdapter.1
                    @Override // android.os.AsyncTask
                    protected /* synthetic */ Bitmap doInBackground(Uri[] uriArr) {
                        return KClassImpl$Data$declaredNonStaticMembers$2();
                    }

                    @Override // android.os.AsyncTask
                    protected /* synthetic */ void onCancelled(Bitmap bitmap) {
                        layoutResultCallback.onLayoutCancelled();
                        PrintUriAdapter.this.lookAheadTest = null;
                    }

                    @Override // android.os.AsyncTask
                    protected /* synthetic */ void onPostExecute(Bitmap bitmap) {
                        PrintAttributes.MediaSize mediaSize;
                        Bitmap bitmap2 = bitmap;
                        super.onPostExecute(bitmap2);
                        if (bitmap2 != null && (!PrintHelper.MyBillsEntityDataFactory || PrintUriAdapter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.scheduleImpl == 0)) {
                            synchronized (this) {
                                mediaSize = PrintUriAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2.getMediaSize();
                            }
                            if (mediaSize != null && mediaSize.isPortrait() != PrintHelper.BuiltInFictitiousFunctionClassFactory(bitmap2)) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                            }
                        }
                        PrintUriAdapter.this.BuiltInFictitiousFunctionClassFactory = bitmap2;
                        if (bitmap2 != null) {
                            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(PrintUriAdapter.this.getErrorConfigVersion).setContentType(1).setPageCount(1).build(), true ^ printAttributes2.equals(printAttributes));
                        } else {
                            layoutResultCallback.onLayoutFailed(null);
                        }
                        PrintUriAdapter.this.lookAheadTest = null;
                    }

                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.print.PrintHelper.PrintUriAdapter.1.1
                            @Override // android.os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                PrintUriAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2();
                                cancel(false);
                            }
                        });
                    }

                    private Bitmap KClassImpl$Data$declaredNonStaticMembers$2() {
                        try {
                            return PrintUriAdapter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(PrintUriAdapter.this.PlaceComponentResult);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }
                }.execute(new Uri[0]);
            }
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory.requestCancelDecode();
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            KClassImpl$Data$declaredNonStaticMembers$2();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.lookAheadTest;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            Bitmap bitmap = this.BuiltInFictitiousFunctionClassFactory;
            if (bitmap != null) {
                bitmap.recycle();
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static boolean BuiltInFictitiousFunctionClassFactory(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    static Matrix KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, RectF rectF, int i3) {
        float min;
        Matrix matrix = new Matrix();
        float f = i;
        float width = rectF.width() / f;
        if (i3 == 2) {
            min = Math.max(width, rectF.height() / i2);
        } else {
            min = Math.min(width, rectF.height() / i2);
        }
        matrix.postScale(min, min);
        matrix.postTranslate((rectF.width() - (f * min)) / 2.0f, (rectF.height() - (i2 * min)) / 2.0f);
        return matrix;
    }

    final void getAuthRequestContext(final PrintAttributes printAttributes, final int i, final Bitmap bitmap, final ParcelFileDescriptor parcelFileDescriptor, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes build;
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            build = printAttributes;
        } else {
            PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
                minMargins.setDuplexMode(printAttributes.getDuplexMode());
            }
            build = minMargins.setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        new AsyncTask<Void, Void, Throwable>() { // from class: androidx.print.PrintHelper.1
            @Override // android.os.AsyncTask
            protected /* synthetic */ Throwable doInBackground(Void[] voidArr) {
                return getAuthRequestContext();
            }

            @Override // android.os.AsyncTask
            protected /* synthetic */ void onPostExecute(Throwable th) {
                Throwable th2 = th;
                if (cancellationSignal.isCanceled()) {
                    writeResultCallback.onWriteCancelled();
                } else if (th2 == null) {
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    InstrumentInjector.log_e("PrintHelper", "Error writing printed content", th2);
                    writeResultCallback.onWriteFailed(null);
                }
            }

            private Throwable getAuthRequestContext() {
                RectF rectF;
                try {
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelper.this.PlaceComponentResult, build);
                    Bitmap authRequestContext = PrintHelper.getAuthRequestContext(bitmap, build.getColorMode());
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    try {
                        PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                        if (PrintHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                            rectF = new RectF(startPage.getInfo().getContentRect());
                        } else {
                            PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelper.this.PlaceComponentResult, printAttributes);
                            PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                            RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                            printedPdfDocument2.finishPage(startPage2);
                            printedPdfDocument2.close();
                            rectF = rectF2;
                        }
                        Matrix KClassImpl$Data$declaredNonStaticMembers$22 = PrintHelper.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getWidth(), authRequestContext.getHeight(), rectF, i);
                        if (!PrintHelper.KClassImpl$Data$declaredNonStaticMembers$2) {
                            KClassImpl$Data$declaredNonStaticMembers$22.postTranslate(rectF.left, rectF.top);
                            startPage.getCanvas().clipRect(rectF);
                        }
                        startPage.getCanvas().drawBitmap(authRequestContext, KClassImpl$Data$declaredNonStaticMembers$22, null);
                        printedPdfDocument.finishPage(startPage);
                        if (!cancellationSignal.isCanceled()) {
                            printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                            printedPdfDocument.close();
                            ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
                            if (parcelFileDescriptor2 != null) {
                                try {
                                    parcelFileDescriptor2.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (authRequestContext != bitmap) {
                                authRequestContext.recycle();
                            }
                            return null;
                        }
                        printedPdfDocument.close();
                        ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptor;
                        if (parcelFileDescriptor3 != null) {
                            try {
                                parcelFileDescriptor3.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (authRequestContext != bitmap) {
                            authRequestContext.recycle();
                        }
                        return null;
                    } finally {
                    }
                } catch (Throwable th) {
                    return th;
                }
            }
        }.execute(new Void[0]);
    }

    final Bitmap KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.PlaceComponentResult == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        getAuthRequestContext(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int max = Math.max(i, i2);
            int i3 = 1;
            while (max > 3500) {
                max >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                synchronized (this.getAuthRequestContext) {
                    BitmapFactory.Options options3 = new BitmapFactory.Options();
                    this.BuiltInFictitiousFunctionClassFactory = options3;
                    options3.inMutable = true;
                    this.BuiltInFictitiousFunctionClassFactory.inSampleSize = i3;
                    options = this.BuiltInFictitiousFunctionClassFactory;
                }
                try {
                    Bitmap authRequestContext = getAuthRequestContext(uri, options);
                    synchronized (this.getAuthRequestContext) {
                        this.BuiltInFictitiousFunctionClassFactory = null;
                    }
                    return authRequestContext;
                } catch (Throwable th) {
                    synchronized (this.getAuthRequestContext) {
                        this.BuiltInFictitiousFunctionClassFactory = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    private Bitmap getAuthRequestContext(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        Context context;
        Throwable th;
        InputStream openInputStream;
        if (uri == null || (context = this.PlaceComponentResult) == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream inputStream = null;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException e) {
                    InstrumentInjector.log_w("PrintHelper", "close fail ", e);
                }
            }
            return decodeStream;
        } catch (Throwable th3) {
            th = th3;
            inputStream = openInputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException e2) {
                    InstrumentInjector.log_w("PrintHelper", "close fail ", e2);
                    throw th;
                }
            }
            throw th;
        }
    }

    static Bitmap getAuthRequestContext(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
