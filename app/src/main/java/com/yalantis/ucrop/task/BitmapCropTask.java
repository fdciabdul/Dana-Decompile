package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import com.fullstory.instrumentation.InstrumentInjector;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    private final Bitmap.CompressFormat BuiltInFictitiousFunctionClassFactory;
    private final RectF DatabaseTableConfigUtil;
    private float GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int PlaceComponentResult;
    private Bitmap PrepareContext;
    private final WeakReference<Context> getAuthRequestContext;
    private int getErrorConfigVersion;
    private final ExifInfo initRecordTimeStamp;
    private final int isLayoutRequested;
    private float lookAheadTest;
    private final RectF moveToNextValue;
    private final BitmapCropCallback scheduleImpl;

    @Override // android.os.AsyncTask
    protected /* synthetic */ Throwable doInBackground(Void[] voidArr) {
        return PlaceComponentResult();
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Throwable th) {
        Throwable th2 = th;
        BitmapCropCallback bitmapCropCallback = this.scheduleImpl;
        if (bitmapCropCallback != null) {
            if (th2 == null) {
                this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(Uri.fromFile(new File(this.NetworkUserEntityData$$ExternalSyntheticLambda2)), this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                return;
            }
            bitmapCropCallback.PlaceComponentResult(th2);
        }
    }

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.getAuthRequestContext = new WeakReference<>(context);
        this.PrepareContext = bitmap;
        this.moveToNextValue = imageState.BuiltInFictitiousFunctionClassFactory;
        this.DatabaseTableConfigUtil = imageState.MyBillsEntityDataFactory;
        this.GetContactSyncConfig = imageState.KClassImpl$Data$declaredNonStaticMembers$2;
        this.lookAheadTest = imageState.getAuthRequestContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = cropParameters.getErrorConfigVersion;
        this.isLayoutRequested = cropParameters.moveToNextValue;
        this.BuiltInFictitiousFunctionClassFactory = cropParameters.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = cropParameters.KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = cropParameters.getAuthRequestContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = cropParameters.PlaceComponentResult;
        this.initRecordTimeStamp = cropParameters.BuiltInFictitiousFunctionClassFactory;
        this.scheduleImpl = bitmapCropCallback;
    }

    private Throwable PlaceComponentResult() {
        Bitmap bitmap = this.PrepareContext;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.DatabaseTableConfigUtil.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            KClassImpl$Data$declaredNonStaticMembers$2();
            this.PrepareContext = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 > 0 && this.isLayoutRequested > 0) {
            float width = this.moveToNextValue.width() / this.GetContactSyncConfig;
            float height = this.moveToNextValue.height() / this.GetContactSyncConfig;
            float f = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (width > f || height > this.isLayoutRequested) {
                float min = Math.min(f / width, this.isLayoutRequested / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.PrepareContext, Math.round(r2.getWidth() * min), Math.round(this.PrepareContext.getHeight() * min), false);
                Bitmap bitmap = this.PrepareContext;
                if (bitmap != createScaledBitmap) {
                    bitmap.recycle();
                }
                this.PrepareContext = createScaledBitmap;
                this.GetContactSyncConfig /= min;
            }
        }
        if (this.lookAheadTest != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.lookAheadTest, this.PrepareContext.getWidth() / 2, this.PrepareContext.getHeight() / 2);
            Bitmap bitmap2 = this.PrepareContext;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.PrepareContext.getHeight(), matrix, true);
            Bitmap bitmap3 = this.PrepareContext;
            if (bitmap3 != createBitmap) {
                bitmap3.recycle();
            }
            this.PrepareContext = createBitmap;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.round((this.moveToNextValue.left - this.DatabaseTableConfigUtil.left) / this.GetContactSyncConfig);
        this.PlaceComponentResult = Math.round((this.moveToNextValue.top - this.DatabaseTableConfigUtil.top) / this.GetContactSyncConfig);
        this.getErrorConfigVersion = Math.round(this.moveToNextValue.width() / this.GetContactSyncConfig);
        int round = Math.round(this.moveToNextValue.height() / this.GetContactSyncConfig);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = round;
        boolean authRequestContext = getAuthRequestContext(this.getErrorConfigVersion, round);
        StringBuilder sb = new StringBuilder();
        sb.append("Should crop: ");
        sb.append(authRequestContext);
        InstrumentInjector.log_i("BitmapCropTask", sb.toString());
        if (authRequestContext) {
            ExifInterface exifInterface = new ExifInterface(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            Bitmap createBitmap2 = Bitmap.createBitmap(this.PrepareContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Context context = this.getAuthRequestContext.get();
            if (context != null) {
                OutputStream outputStream = null;
                try {
                    outputStream = context.getContentResolver().openOutputStream(Uri.fromFile(new File(this.NetworkUserEntityData$$ExternalSyntheticLambda2)));
                    createBitmap2.compress(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, outputStream);
                    createBitmap2.recycle();
                } finally {
                    BitmapLoadUtils.getAuthRequestContext(outputStream);
                }
            }
            if (this.BuiltInFictitiousFunctionClassFactory.equals(Bitmap.CompressFormat.JPEG)) {
                ImageHeaderParser.BuiltInFictitiousFunctionClassFactory(exifInterface, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                return true;
            }
            return true;
        }
        FileUtils.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        return false;
    }

    private boolean getAuthRequestContext(int i, int i2) {
        int round = Math.round(Math.max(i, i2) / 1000.0f);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 <= 0 || this.isLayoutRequested <= 0) {
            float f = round + 1;
            return Math.abs(this.moveToNextValue.left - this.DatabaseTableConfigUtil.left) > f || Math.abs(this.moveToNextValue.top - this.DatabaseTableConfigUtil.top) > f || Math.abs(this.moveToNextValue.bottom - this.DatabaseTableConfigUtil.bottom) > f || Math.abs(this.moveToNextValue.right - this.DatabaseTableConfigUtil.right) > f;
        }
        return true;
    }
}
