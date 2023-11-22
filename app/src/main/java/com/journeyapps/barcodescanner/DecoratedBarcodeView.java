package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.DecodeFormatManager;
import com.google.zxing.client.android.DecodeHintManager;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.camera.CameraParametersCallback;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DecoratedBarcodeView extends FrameLayout {
    private TorchListener KClassImpl$Data$declaredNonStaticMembers$2;
    private ViewfinderView MyBillsEntityDataFactory;
    private TextView PlaceComponentResult;
    private BarcodeView getAuthRequestContext;

    /* loaded from: classes3.dex */
    public interface TorchListener {
    }

    /* loaded from: classes3.dex */
    class WrappedCallback implements BarcodeCallback {
        private BarcodeCallback PlaceComponentResult;

        public WrappedCallback(BarcodeCallback barcodeCallback) {
            this.PlaceComponentResult = barcodeCallback;
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public final void getAuthRequestContext(BarcodeResult barcodeResult) {
            this.PlaceComponentResult.getAuthRequestContext(barcodeResult);
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public final void getAuthRequestContext(List<ResultPoint> list) {
            Iterator<ResultPoint> it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.MyBillsEntityDataFactory.addPossibleResultPoint(it.next());
            }
            this.PlaceComponentResult.getAuthRequestContext(list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        PlaceComponentResult(null);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult(attributeSet);
    }

    private void PlaceComponentResult(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R.id.zxing_barcode_surface);
        this.getAuthRequestContext = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.initializeAttributes(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.MyBillsEntityDataFactory = viewfinderView;
        if (viewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        viewfinderView.setCameraPreview(this.getAuthRequestContext);
        this.PlaceComponentResult = (TextView) findViewById(R.id.zxing_status_view);
    }

    public void initializeFromIntent(Intent intent) {
        int intExtra;
        Set<BarcodeFormat> parseDecodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
        Map<DecodeHintType, ?> parseDecodeHints = DecodeHintManager.parseDecodeHints(intent);
        CameraSettings cameraSettings = new CameraSettings();
        if (intent.hasExtra(Intents.Scan.CAMERA_ID) && (intExtra = intent.getIntExtra(Intents.Scan.CAMERA_ID, -1)) >= 0) {
            cameraSettings.KClassImpl$Data$declaredNonStaticMembers$2 = intExtra;
        }
        if (intent.hasExtra(Intents.Scan.TORCH_ENABLED) && intent.getBooleanExtra(Intents.Scan.TORCH_ENABLED, false)) {
            setTorchOn();
        }
        String stringExtra = intent.getStringExtra(Intents.Scan.PROMPT_MESSAGE);
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra(Intents.Scan.SCAN_TYPE, 0);
        String stringExtra2 = intent.getStringExtra(Intents.Scan.CHARACTER_SET);
        new MultiFormatReader().setHints(parseDecodeHints);
        this.getAuthRequestContext.setCameraSettings(cameraSettings);
        this.getAuthRequestContext.setDecoderFactory(new DefaultDecoderFactory(parseDecodeFormats, parseDecodeHints, stringExtra2, intExtra2));
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.getAuthRequestContext.setCameraSettings(cameraSettings);
    }

    public void setDecoderFactory(DecoderFactory decoderFactory) {
        this.getAuthRequestContext.setDecoderFactory(decoderFactory);
    }

    public DecoderFactory getDecoderFactory() {
        return this.getAuthRequestContext.getDecoderFactory();
    }

    public CameraSettings getCameraSettings() {
        return this.getAuthRequestContext.getCameraSettings();
    }

    public void setStatusText(String str) {
        TextView textView = this.PlaceComponentResult;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void pause() {
        this.getAuthRequestContext.pause();
    }

    public void pauseAndWait() {
        this.getAuthRequestContext.pauseAndWait();
    }

    public void resume() {
        this.getAuthRequestContext.resume();
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R.id.zxing_barcode_surface);
    }

    public ViewfinderView getViewFinder() {
        return this.MyBillsEntityDataFactory;
    }

    public TextView getStatusView() {
        return this.PlaceComponentResult;
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        this.getAuthRequestContext.decodeSingle(new WrappedCallback(barcodeCallback));
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.getAuthRequestContext.decodeContinuous(new WrappedCallback(barcodeCallback));
    }

    public void setTorchOn() {
        this.getAuthRequestContext.setTorch(true);
    }

    public void setTorchOff() {
        this.getAuthRequestContext.setTorch(false);
    }

    public void changeCameraParameters(CameraParametersCallback cameraParametersCallback) {
        this.getAuthRequestContext.changeCameraParameters(cameraParametersCallback);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            setTorchOn();
            return true;
        } else if (i == 25) {
            setTorchOff();
            return true;
        } else if (i == 27 || i == 80) {
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void setTorchListener(TorchListener torchListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = torchListener;
    }
}
