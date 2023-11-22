package id.dana.richview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.google.zxing.client.android.Intents;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.SizeUtil;
import java.util.Locale;

/* loaded from: classes5.dex */
public class CustomDecoratedBarcodeView extends BaseRichView {
    private static final int PlaceComponentResult = SizeUtil.getAuthRequestContext(50);
    private CameraPreview.StateListener BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Rect MyBillsEntityDataFactory;
    @BindView(R.id.bv_bubble_status)
    BubbleView bvBubbleStatus;
    @BindView(R.id.cv_qris_dana_supported)
    CardView cvQrisSupported;
    @BindView(R.id.dbv_barcode_view)
    DecoratedBarcodeView decoratedBarcodeView;
    private boolean getAuthRequestContext;
    @BindView(R.id.iv_dana_cicil_logo)
    AppCompatImageView ivDanaCicilLogo;
    @BindView(R.id.iv_qris_logo)
    AppCompatImageView ivQrisLogo;
    @BindView(R.id.tv_use_dana_cicil)
    AppCompatTextView tvUseDanaCicil;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_custom_decorated_barcode;
    }

    public CustomDecoratedBarcodeView(Context context) {
        super(context);
    }

    public CustomDecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomDecoratedBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomDecoratedBarcodeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        if (getBarcodeView() != null) {
            CameraSettings cameraSettings = this.decoratedBarcodeView.getCameraSettings();
            cameraSettings.PlaceComponentResult = true;
            cameraSettings.MyBillsEntityDataFactory = CameraSettings.FocusMode.CONTINUOUS;
            IntentIntegrator intentIntegrator = new IntentIntegrator(getBaseActivity());
            intentIntegrator.addExtra(Intents.Scan.SCAN_TYPE, 2);
            this.decoratedBarcodeView.initializeFromIntent(intentIntegrator.createScanIntent());
            MyBillsEntityDataFactory();
            this.decoratedBarcodeView.getStatusView().setVisibility(8);
            getBarcodeView().addStateListener(new CameraPreview.StateListener() { // from class: id.dana.richview.CustomDecoratedBarcodeView.1
                @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    CustomDecoratedBarcodeView.this.previewSized();
                    if (CustomDecoratedBarcodeView.access$000(CustomDecoratedBarcodeView.this) != null) {
                        CustomDecoratedBarcodeView customDecoratedBarcodeView = CustomDecoratedBarcodeView.this;
                        customDecoratedBarcodeView.MyBillsEntityDataFactory = CustomDecoratedBarcodeView.access$000(customDecoratedBarcodeView);
                        CustomDecoratedBarcodeView.access$200(CustomDecoratedBarcodeView.this);
                        CustomDecoratedBarcodeView.this.setVisibilityToastText(true);
                    }
                }

                @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    CustomDecoratedBarcodeView.this.previewStarted();
                    if (CustomDecoratedBarcodeView.this.bvBubbleStatus == null || TextUtils.isEmpty(CustomDecoratedBarcodeView.this.bvBubbleStatus.getText())) {
                        if (CustomDecoratedBarcodeView.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                            CustomDecoratedBarcodeView customDecoratedBarcodeView = CustomDecoratedBarcodeView.this;
                            customDecoratedBarcodeView.setVisibilityQrisStampWithPlaceholder(true, customDecoratedBarcodeView.getAuthRequestContext);
                            return;
                        }
                        return;
                    }
                    CustomDecoratedBarcodeView.this.showBubbleText();
                    CustomDecoratedBarcodeView customDecoratedBarcodeView2 = CustomDecoratedBarcodeView.this;
                    customDecoratedBarcodeView2.setVisibilityQrisSupportedStamp(true, customDecoratedBarcodeView2.getAuthRequestContext);
                    CustomDecoratedBarcodeView.this.setVisibilityBubblePointer(true);
                }

                @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
                public final void getAuthRequestContext() {
                    CustomDecoratedBarcodeView.this.previewStopped();
                }

                @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
                public final void getAuthRequestContext(Exception exc) {
                    CustomDecoratedBarcodeView.this.cameraError(exc);
                }

                @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
                public final void MyBillsEntityDataFactory() {
                    CustomDecoratedBarcodeView.this.cameraClosed();
                }
            });
        }
    }

    private void MyBillsEntityDataFactory() {
        if (Locale.getDefault().getLanguage().equals("in")) {
            this.ivQrisLogo.setImageDrawable(ContextCompat.PlaceComponentResult(getBaseActivity(), (int) R.drawable.qris_supported_id));
        } else {
            this.ivQrisLogo.setImageDrawable(ContextCompat.PlaceComponentResult(getBaseActivity(), (int) R.drawable.qris_supported));
        }
    }

    public BarcodeView getBarcodeView() {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            return decoratedBarcodeView.getBarcodeView();
        }
        return null;
    }

    public ViewfinderView getViewFinderView() {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            return decoratedBarcodeView.getViewFinder();
        }
        return null;
    }

    public void setFramingRect(Size size) {
        getBarcodeView().setFramingRectSize(size);
    }

    public void setStateListener(CameraPreview.StateListener stateListener) {
        this.BuiltInFictitiousFunctionClassFactory = stateListener;
    }

    public void pause() {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.pause();
        }
    }

    public void resume() {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.resume();
        }
    }

    public void setBubbleStatusText(String str) {
        BubbleView bubbleView = this.bvBubbleStatus;
        if (bubbleView != null) {
            bubbleView.setText(str);
        }
    }

    public void showBubbleText() {
        BubbleView bubbleView = this.bvBubbleStatus;
        if (bubbleView != null) {
            bubbleView.setVisibilityPointer(true);
            this.bvBubbleStatus.setVisibilityBubbleText(true);
        }
    }

    public void clearBubbleView() {
        BubbleView bubbleView = this.bvBubbleStatus;
        if (bubbleView != null) {
            bubbleView.setVisibilityPointer(false);
            this.bvBubbleStatus.setVisibilityBubbleText(false);
            this.bvBubbleStatus.setVisibilityBubbleImage(false);
        }
    }

    public void setVisibilityQrisPlaceholder(boolean z) {
        BubbleView bubbleView = this.bvBubbleStatus;
        if (bubbleView != null) {
            if (z) {
                bubbleView.setVisibilityPointer(true);
                this.bvBubbleStatus.setVisibilityBubbleText(false);
                this.bvBubbleStatus.setVisibilityBubbleImage(true);
                return;
            }
            bubbleView.setVisibilityPointer(false);
            this.bvBubbleStatus.setVisibilityBubbleImage(false);
        }
    }

    public boolean isBubbleQrisSupportedVisible() {
        CardView cardView = this.cvQrisSupported;
        return cardView != null && cardView.getVisibility() == 0;
    }

    public void setVisibilityQrisStampWithPlaceholder(boolean z, boolean z2) {
        if (z) {
            setVisibilityQrisPlaceholder(true);
            setVisibilityQrisSupportedStamp(true, z2);
            return;
        }
        setVisibilityQrisPlaceholder(false);
        setVisibilityBubblePointer(false);
    }

    public void setVisibilityToastText(boolean z) {
        BubbleView bubbleView = this.bvBubbleStatus;
        if (bubbleView != null) {
            bubbleView.setVisibility(z ? 0 : 8);
        }
    }

    public void setVisibilityBubblePointer(boolean z) {
        BubbleView bubbleView = this.bvBubbleStatus;
        if (bubbleView != null) {
            bubbleView.setVisibilityPointer(z);
        }
    }

    public void setVisibilityQrisSupportedStamp(boolean z, boolean z2) {
        CardView cardView = this.cvQrisSupported;
        if (cardView != null) {
            cardView.setVisibility(z ? 0 : 8);
            this.tvUseDanaCicil.setVisibility(z2 ? 0 : 8);
            this.ivDanaCicilLogo.setVisibility(z2 ? 0 : 8);
            if (z2) {
                this.ivQrisLogo.setImageDrawable(ContextCompat.PlaceComponentResult(getBaseActivity(), (int) R.drawable.qris_logo_white));
            } else {
                MyBillsEntityDataFactory();
            }
            if (z2) {
                this.cvQrisSupported.setContentDescription(getContext().getString(R.string.sdet_lbl_ribbon_qris));
            }
        }
    }

    public void setTorchOff() {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setTorchOff();
        }
    }

    public void setTorchOn() {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setTorchOn();
        }
    }

    public void setPlaceholderShow(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public void setIsNeedToShowPaylaterCicilLogo(boolean z) {
        this.getAuthRequestContext = z;
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.decodeSingle(barcodeCallback);
        }
    }

    public void setStatusText(String str) {
        DecoratedBarcodeView decoratedBarcodeView = this.decoratedBarcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setStatusText(str);
        }
    }

    void previewSized() {
        CameraPreview.StateListener stateListener = this.BuiltInFictitiousFunctionClassFactory;
        if (stateListener != null) {
            stateListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    void previewStarted() {
        CameraPreview.StateListener stateListener = this.BuiltInFictitiousFunctionClassFactory;
        if (stateListener != null) {
            stateListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    void previewStopped() {
        CameraPreview.StateListener stateListener = this.BuiltInFictitiousFunctionClassFactory;
        if (stateListener != null) {
            stateListener.getAuthRequestContext();
        }
    }

    void cameraError(Exception exc) {
        CameraPreview.StateListener stateListener = this.BuiltInFictitiousFunctionClassFactory;
        if (stateListener != null) {
            stateListener.getAuthRequestContext(exc);
        }
    }

    void cameraClosed() {
        CameraPreview.StateListener stateListener = this.BuiltInFictitiousFunctionClassFactory;
        if (stateListener != null) {
            stateListener.MyBillsEntityDataFactory();
        }
    }

    static /* synthetic */ Rect access$000(CustomDecoratedBarcodeView customDecoratedBarcodeView) {
        if (customDecoratedBarcodeView.getBarcodeView() == null || customDecoratedBarcodeView.getBarcodeView().getFramingRect() == null) {
            return null;
        }
        return customDecoratedBarcodeView.getBarcodeView().getFramingRect();
    }

    static /* synthetic */ void access$200(CustomDecoratedBarcodeView customDecoratedBarcodeView) {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = ((Activity) customDecoratedBarcodeView.getContext()).getWindowManager().getCurrentWindowMetrics();
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            i = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) customDecoratedBarcodeView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
        }
        if (SizeUtil.PlaceComponentResult(i) >= 600) {
            Rect rect = customDecoratedBarcodeView.MyBillsEntityDataFactory;
            int i2 = rect.bottom;
            int i3 = PlaceComponentResult;
            rect.bottom = i2 - i3;
            customDecoratedBarcodeView.MyBillsEntityDataFactory.top += i3;
            customDecoratedBarcodeView.MyBillsEntityDataFactory.right -= i3;
            customDecoratedBarcodeView.MyBillsEntityDataFactory.left += i3;
        }
    }
}
