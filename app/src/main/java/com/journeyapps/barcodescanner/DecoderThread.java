package com.journeyapps.barcodescanner;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import com.journeyapps.barcodescanner.camera.CameraInstance$$ExternalSyntheticLambda3;
import com.journeyapps.barcodescanner.camera.PreviewCallback;

/* loaded from: classes3.dex */
public class DecoderThread {
    static final String KClassImpl$Data$declaredNonStaticMembers$2 = "DecoderThread";
    private Handler DatabaseTableConfigUtil;
    CameraInstance MyBillsEntityDataFactory;
    Decoder PlaceComponentResult;
    Rect getAuthRequestContext;
    HandlerThread lookAheadTest;
    Handler moveToNextValue;
    boolean getErrorConfigVersion = false;
    private final Object scheduleImpl = new Object();
    final Handler.Callback BuiltInFictitiousFunctionClassFactory = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.DecoderThread.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_decode) {
                DecoderThread.BuiltInFictitiousFunctionClassFactory(DecoderThread.this, (SourceData) message.obj);
                return true;
            } else if (message.what == R.id.zxing_preview_failed) {
                DecoderThread.PlaceComponentResult(DecoderThread.this);
                return true;
            } else {
                return true;
            }
        }
    };
    final PreviewCallback NetworkUserEntityData$$ExternalSyntheticLambda0 = new PreviewCallback() { // from class: com.journeyapps.barcodescanner.DecoderThread.2
        @Override // com.journeyapps.barcodescanner.camera.PreviewCallback
        public final void PlaceComponentResult(SourceData sourceData) {
            synchronized (DecoderThread.this.scheduleImpl) {
                if (DecoderThread.this.getErrorConfigVersion) {
                    DecoderThread.this.moveToNextValue.obtainMessage(R.id.zxing_decode, sourceData).sendToTarget();
                }
            }
        }

        @Override // com.journeyapps.barcodescanner.camera.PreviewCallback
        public final void MyBillsEntityDataFactory() {
            synchronized (DecoderThread.this.scheduleImpl) {
                if (DecoderThread.this.getErrorConfigVersion) {
                    DecoderThread.this.moveToNextValue.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                }
            }
        }
    };

    public DecoderThread(CameraInstance cameraInstance, Decoder decoder, Handler handler) {
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        this.MyBillsEntityDataFactory = cameraInstance;
        this.PlaceComponentResult = decoder;
        this.DatabaseTableConfigUtil = handler;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        synchronized (this.scheduleImpl) {
            this.getErrorConfigVersion = false;
            this.moveToNextValue.removeCallbacksAndMessages(null);
            this.lookAheadTest.quit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(com.journeyapps.barcodescanner.DecoderThread r26, com.journeyapps.barcodescanner.SourceData r27) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.DecoderThread.BuiltInFictitiousFunctionClassFactory(com.journeyapps.barcodescanner.DecoderThread, com.journeyapps.barcodescanner.SourceData):void");
    }

    static /* synthetic */ void PlaceComponentResult(DecoderThread decoderThread) {
        CameraInstance cameraInstance = decoderThread.MyBillsEntityDataFactory;
        cameraInstance.NetworkUserEntityData$$ExternalSyntheticLambda0.post(new CameraInstance$$ExternalSyntheticLambda3(cameraInstance, decoderThread.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }
}
