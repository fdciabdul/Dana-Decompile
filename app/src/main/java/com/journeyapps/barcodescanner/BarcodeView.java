package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import com.journeyapps.barcodescanner.camera.CameraInstance$$ExternalSyntheticLambda3;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class BarcodeView extends CameraPreview {
    private final Handler.Callback BuiltInFictitiousFunctionClassFactory;
    private DecoderThread KClassImpl$Data$declaredNonStaticMembers$2;
    private DecodeMode MyBillsEntityDataFactory;
    private BarcodeCallback PlaceComponentResult;
    private DecoderFactory getAuthRequestContext;
    private Handler moveToNextValue;

    /* loaded from: classes3.dex */
    public enum DecodeMode {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = DecodeMode.NONE;
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.BarcodeView.1
            {
                BarcodeView.this = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_decode_succeeded) {
                    BarcodeResult barcodeResult = (BarcodeResult) message.obj;
                    if (barcodeResult != null && BarcodeView.this.PlaceComponentResult != null && BarcodeView.this.MyBillsEntityDataFactory != DecodeMode.NONE) {
                        BarcodeView.this.PlaceComponentResult.getAuthRequestContext(barcodeResult);
                        if (BarcodeView.this.MyBillsEntityDataFactory == DecodeMode.SINGLE) {
                            BarcodeView.this.stopDecoding();
                        }
                    }
                    return true;
                } else if (message.what == R.id.zxing_decode_failed) {
                    return true;
                } else {
                    if (message.what == R.id.zxing_possible_result_points) {
                        List<ResultPoint> list = (List) message.obj;
                        if (BarcodeView.this.PlaceComponentResult != null && BarcodeView.this.MyBillsEntityDataFactory != DecodeMode.NONE) {
                            BarcodeView.this.PlaceComponentResult.getAuthRequestContext(list);
                        }
                        return true;
                    }
                    return false;
                }
            }
        };
        this.getAuthRequestContext = new DefaultDecoderFactory();
        this.moveToNextValue = new Handler(this.BuiltInFictitiousFunctionClassFactory);
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = DecodeMode.NONE;
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.BarcodeView.1
            {
                BarcodeView.this = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_decode_succeeded) {
                    BarcodeResult barcodeResult = (BarcodeResult) message.obj;
                    if (barcodeResult != null && BarcodeView.this.PlaceComponentResult != null && BarcodeView.this.MyBillsEntityDataFactory != DecodeMode.NONE) {
                        BarcodeView.this.PlaceComponentResult.getAuthRequestContext(barcodeResult);
                        if (BarcodeView.this.MyBillsEntityDataFactory == DecodeMode.SINGLE) {
                            BarcodeView.this.stopDecoding();
                        }
                    }
                    return true;
                } else if (message.what == R.id.zxing_decode_failed) {
                    return true;
                } else {
                    if (message.what == R.id.zxing_possible_result_points) {
                        List<ResultPoint> list = (List) message.obj;
                        if (BarcodeView.this.PlaceComponentResult != null && BarcodeView.this.MyBillsEntityDataFactory != DecodeMode.NONE) {
                            BarcodeView.this.PlaceComponentResult.getAuthRequestContext(list);
                        }
                        return true;
                    }
                    return false;
                }
            }
        };
        this.getAuthRequestContext = new DefaultDecoderFactory();
        this.moveToNextValue = new Handler(this.BuiltInFictitiousFunctionClassFactory);
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = DecodeMode.NONE;
        this.PlaceComponentResult = null;
        this.BuiltInFictitiousFunctionClassFactory = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.BarcodeView.1
            {
                BarcodeView.this = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == R.id.zxing_decode_succeeded) {
                    BarcodeResult barcodeResult = (BarcodeResult) message.obj;
                    if (barcodeResult != null && BarcodeView.this.PlaceComponentResult != null && BarcodeView.this.MyBillsEntityDataFactory != DecodeMode.NONE) {
                        BarcodeView.this.PlaceComponentResult.getAuthRequestContext(barcodeResult);
                        if (BarcodeView.this.MyBillsEntityDataFactory == DecodeMode.SINGLE) {
                            BarcodeView.this.stopDecoding();
                        }
                    }
                    return true;
                } else if (message.what == R.id.zxing_decode_failed) {
                    return true;
                } else {
                    if (message.what == R.id.zxing_possible_result_points) {
                        List<ResultPoint> list = (List) message.obj;
                        if (BarcodeView.this.PlaceComponentResult != null && BarcodeView.this.MyBillsEntityDataFactory != DecodeMode.NONE) {
                            BarcodeView.this.PlaceComponentResult.getAuthRequestContext(list);
                        }
                        return true;
                    }
                    return false;
                }
            }
        };
        this.getAuthRequestContext = new DefaultDecoderFactory();
        this.moveToNextValue = new Handler(this.BuiltInFictitiousFunctionClassFactory);
    }

    public void setDecoderFactory(DecoderFactory decoderFactory) {
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        this.getAuthRequestContext = decoderFactory;
        DecoderThread decoderThread = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (decoderThread != null) {
            decoderThread.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private Decoder KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = createDefaultDecoderFactory();
        }
        DecoderResultPointCallback decoderResultPointCallback = new DecoderResultPointCallback();
        HashMap hashMap = new HashMap();
        hashMap.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, decoderResultPointCallback);
        Decoder MyBillsEntityDataFactory = this.getAuthRequestContext.MyBillsEntityDataFactory(hashMap);
        decoderResultPointCallback.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory;
        return MyBillsEntityDataFactory;
    }

    public DecoderFactory getDecoderFactory() {
        return this.getAuthRequestContext;
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        this.MyBillsEntityDataFactory = DecodeMode.SINGLE;
        this.PlaceComponentResult = barcodeCallback;
        MyBillsEntityDataFactory();
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.MyBillsEntityDataFactory = DecodeMode.CONTINUOUS;
        this.PlaceComponentResult = barcodeCallback;
        MyBillsEntityDataFactory();
    }

    public void stopDecoding() {
        this.MyBillsEntityDataFactory = DecodeMode.NONE;
        this.PlaceComponentResult = null;
        DecoderThread decoderThread = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (decoderThread != null) {
            decoderThread.KClassImpl$Data$declaredNonStaticMembers$2();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    protected DecoderFactory createDefaultDecoderFactory() {
        return new DefaultDecoderFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void previewStarted() {
        super.previewStarted();
        MyBillsEntityDataFactory();
    }

    private void MyBillsEntityDataFactory() {
        DecoderThread decoderThread = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (decoderThread != null) {
            decoderThread.KClassImpl$Data$declaredNonStaticMembers$2();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        if (this.MyBillsEntityDataFactory == DecodeMode.NONE || !isPreviewActive()) {
            return;
        }
        DecoderThread decoderThread2 = new DecoderThread(getCameraInstance(), KClassImpl$Data$declaredNonStaticMembers$2(), this.moveToNextValue);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = decoderThread2;
        decoderThread2.getAuthRequestContext = getPreviewFramingRect();
        DecoderThread decoderThread3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Util.KClassImpl$Data$declaredNonStaticMembers$2();
        HandlerThread handlerThread = new HandlerThread(DecoderThread.KClassImpl$Data$declaredNonStaticMembers$2);
        decoderThread3.lookAheadTest = handlerThread;
        handlerThread.start();
        decoderThread3.moveToNextValue = new Handler(decoderThread3.lookAheadTest.getLooper(), decoderThread3.BuiltInFictitiousFunctionClassFactory);
        decoderThread3.getErrorConfigVersion = true;
        CameraInstance cameraInstance = decoderThread3.MyBillsEntityDataFactory;
        cameraInstance.NetworkUserEntityData$$ExternalSyntheticLambda0.post(new CameraInstance$$ExternalSyntheticLambda3(cameraInstance, decoderThread3.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void pause() {
        DecoderThread decoderThread = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (decoderThread != null) {
            decoderThread.KClassImpl$Data$declaredNonStaticMembers$2();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        super.pause();
    }
}
