package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.google.zxing.client.android.InactivityTimer;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.CaptureManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CaptureManager {
    static final String KClassImpl$Data$declaredNonStaticMembers$2 = "CaptureManager";
    static int PlaceComponentResult = 250;
    DecoratedBarcodeView BuiltInFictitiousFunctionClassFactory;
    boolean MyBillsEntityDataFactory;
    BeepManager NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final CameraPreview.StateListener NetworkUserEntityData$$ExternalSyntheticLambda7;
    Activity getAuthRequestContext;
    Handler lookAheadTest;
    InactivityTimer scheduleImpl;
    int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    boolean DatabaseTableConfigUtil = false;
    boolean GetContactSyncConfig = true;
    String initRecordTimeStamp = "";
    boolean getErrorConfigVersion = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    BarcodeCallback moveToNextValue = new AnonymousClass1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.journeyapps.barcodescanner.CaptureManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements BarcodeCallback {
        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public final void getAuthRequestContext(List<ResultPoint> list) {
        }

        AnonymousClass1() {
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public final void getAuthRequestContext(final BarcodeResult barcodeResult) {
            CaptureManager.this.BuiltInFictitiousFunctionClassFactory.pause();
            CaptureManager.this.NetworkUserEntityData$$ExternalSyntheticLambda0.playBeepSoundAndVibrate();
            CaptureManager.this.lookAheadTest.post(new Runnable() { // from class: com.journeyapps.barcodescanner.CaptureManager$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureManager.AnonymousClass1 anonymousClass1 = CaptureManager.AnonymousClass1.this;
                    BarcodeResult barcodeResult2 = barcodeResult;
                    CaptureManager captureManager = CaptureManager.this;
                    String authRequestContext = captureManager.getAuthRequestContext(barcodeResult2);
                    Intent intent = new Intent(Intents.Scan.ACTION);
                    intent.addFlags(524288);
                    intent.putExtra(Intents.Scan.RESULT, barcodeResult2.toString());
                    intent.putExtra(Intents.Scan.RESULT_FORMAT, barcodeResult2.PlaceComponentResult().toString());
                    byte[] BuiltInFictitiousFunctionClassFactory = barcodeResult2.BuiltInFictitiousFunctionClassFactory();
                    if (BuiltInFictitiousFunctionClassFactory != null && BuiltInFictitiousFunctionClassFactory.length > 0) {
                        intent.putExtra(Intents.Scan.RESULT_BYTES, BuiltInFictitiousFunctionClassFactory);
                    }
                    Map<ResultMetadataType, Object> KClassImpl$Data$declaredNonStaticMembers$2 = barcodeResult2.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        if (KClassImpl$Data$declaredNonStaticMembers$2.containsKey(ResultMetadataType.UPC_EAN_EXTENSION)) {
                            intent.putExtra(Intents.Scan.RESULT_UPC_EAN_EXTENSION, KClassImpl$Data$declaredNonStaticMembers$2.get(ResultMetadataType.UPC_EAN_EXTENSION).toString());
                        }
                        Number number = (Number) KClassImpl$Data$declaredNonStaticMembers$2.get(ResultMetadataType.ORIENTATION);
                        if (number != null) {
                            intent.putExtra(Intents.Scan.RESULT_ORIENTATION, number.intValue());
                        }
                        String str = (String) KClassImpl$Data$declaredNonStaticMembers$2.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
                        if (str != null) {
                            intent.putExtra(Intents.Scan.RESULT_ERROR_CORRECTION_LEVEL, str);
                        }
                        Iterable<byte[]> iterable = (Iterable) KClassImpl$Data$declaredNonStaticMembers$2.get(ResultMetadataType.BYTE_SEGMENTS);
                        if (iterable != null) {
                            int i = 0;
                            for (byte[] bArr : iterable) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(Intents.Scan.RESULT_BYTE_SEGMENTS_PREFIX);
                                sb.append(i);
                                intent.putExtra(sb.toString(), bArr);
                                i++;
                            }
                        }
                    }
                    if (authRequestContext != null) {
                        intent.putExtra(Intents.Scan.RESULT_BARCODE_IMAGE_PATH, authRequestContext);
                    }
                    captureManager.getAuthRequestContext.setResult(-1, intent);
                    captureManager.BuiltInFictitiousFunctionClassFactory();
                }
            });
        }
    }

    public CaptureManager(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        CameraPreview.StateListener stateListener = new CameraPreview.StateListener() { // from class: com.journeyapps.barcodescanner.CaptureManager.2
            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void BuiltInFictitiousFunctionClassFactory() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext() {
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void getAuthRequestContext(Exception exc) {
                CaptureManager captureManager = CaptureManager.this;
                captureManager.BuiltInFictitiousFunctionClassFactory(captureManager.getAuthRequestContext.getString(R.string.zxing_msg_camera_framework_bug));
            }

            @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
            public final void MyBillsEntityDataFactory() {
                if (CaptureManager.this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    InstrumentInjector.log_d(CaptureManager.KClassImpl$Data$declaredNonStaticMembers$2, "Camera closed; finishing activity");
                    CaptureManager.getErrorConfigVersion(CaptureManager.this);
                }
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = stateListener;
        this.MyBillsEntityDataFactory = false;
        this.getAuthRequestContext = activity;
        this.BuiltInFictitiousFunctionClassFactory = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().addStateListener(stateListener);
        this.lookAheadTest = new Handler();
        this.scheduleImpl = new InactivityTimer(activity, new Runnable() { // from class: com.journeyapps.barcodescanner.CaptureManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CaptureManager captureManager = CaptureManager.this;
                InstrumentInjector.log_d(CaptureManager.KClassImpl$Data$declaredNonStaticMembers$2, "Finishing due to inactivity");
                captureManager.getAuthRequestContext.finish();
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new BeepManager(activity);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int[] iArr) {
        if (i == PlaceComponentResult) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.BuiltInFictitiousFunctionClassFactory.resume();
                return;
            }
            Intent intent = new Intent(Intents.Scan.ACTION);
            intent.putExtra(Intents.Scan.MISSING_CAMERA_PERMISSION, true);
            this.getAuthRequestContext.setResult(0, intent);
            if (this.GetContactSyncConfig) {
                BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp);
            } else {
                BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAuthRequestContext(BarcodeResult barcodeResult) {
        if (this.DatabaseTableConfigUtil) {
            Bitmap MyBillsEntityDataFactory = barcodeResult.MyBillsEntityDataFactory();
            try {
                File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.getAuthRequestContext.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                MyBillsEntityDataFactory.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return createTempFile.getAbsolutePath();
            } catch (IOException e) {
                String str = KClassImpl$Data$declaredNonStaticMembers$2;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to create temporary file and store bitmap! ");
                sb.append(e);
                InstrumentInjector.log_w(str, sb.toString());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (!this.BuiltInFictitiousFunctionClassFactory.getBarcodeView().isCameraClosed()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        } else {
            this.getAuthRequestContext.finish();
        }
        this.BuiltInFictitiousFunctionClassFactory.pause();
        this.scheduleImpl.cancel();
    }

    protected final void BuiltInFictitiousFunctionClassFactory(String str) {
        if (this.getAuthRequestContext.isFinishing() || this.getErrorConfigVersion || this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        if (str.isEmpty()) {
            str = this.getAuthRequestContext.getString(R.string.zxing_msg_camera_framework_bug);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getAuthRequestContext);
        builder.setTitle(this.getAuthRequestContext.getString(R.string.zxing_app_name));
        builder.setMessage(str);
        builder.setPositiveButton(R.string.zxing_button_ok, new DialogInterface.OnClickListener() { // from class: com.journeyapps.barcodescanner.CaptureManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CaptureManager.this.getAuthRequestContext.finish();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.journeyapps.barcodescanner.CaptureManager$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                CaptureManager.this.getAuthRequestContext.finish();
            }
        });
        builder.show();
    }

    static /* synthetic */ void getErrorConfigVersion(CaptureManager captureManager) {
        captureManager.getAuthRequestContext.finish();
    }
}
