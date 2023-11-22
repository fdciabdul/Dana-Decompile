package id.dana.pay;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import butterknife.BindView;
import butterknife.OnClick;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.scanner.ScannerFragment;
import id.dana.scanner.TrackerQRScanner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0002!\"B\u0007¢\u0006\u0004\b \u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0013\u001a\u00020\u00108\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u001bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/pay/PayScannerFragment;", "Lid/dana/scanner/ScannerFragment;", "Lid/dana/pay/PaymentMethodListener;", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()V", "getAuthRequestContext", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "onIvFlashClicked", "onIvGalleryClicked", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Landroid/widget/ImageView;", "ivFlash", "Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "llScannerTools", "Landroid/widget/LinearLayout;", "Lid/dana/pay/PayScannerFragment$PayScannerListener;", "Lid/dana/pay/PayScannerFragment$PayScannerListener;", "Landroid/widget/TextView;", "tvDoneScan", "Landroid/widget/TextView;", "<init>", "Companion", "PayScannerListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayScannerFragment extends ScannerFragment implements PaymentMethodListener {
    PayScannerListener MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    @BindView(R.id.iv_flash)
    public ImageView ivFlash;
    @BindView(R.id.ll_scanner_tools)
    public LinearLayout llScannerTools;
    @BindView(R.id.tv_done_scan)
    public TextView tvDoneScan;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/pay/PayScannerFragment$PayScannerListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "PlaceComponentResult", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PayScannerListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(boolean p0);
    }

    @Override // id.dana.pay.PaymentMethodListener
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.scanner.ScannerFragment
    public final void getAuthRequestContext() {
    }

    @Override // id.dana.scanner.ScannerFragment, id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_pay_scanner;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.pay.PaymentMethodListener
    public final void MyBillsEntityDataFactory() {
        this.moveToNextValue = false;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTorchOff();
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    @Override // id.dana.scanner.ScannerFragment
    public final void BuiltInFictitiousFunctionClassFactory() {
        PayScannerListener payScannerListener = this.MyBillsEntityDataFactory;
        if (payScannerListener != null) {
            payScannerListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.scanner.ScannerFragment, id.dana.base.BaseFragment
    public final void init() {
        super.init();
        LinearLayout linearLayout = this.llScannerTools;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.tvDoneScan;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TrackerQRScanner.PlaceComponentResult("Camera Card");
        PlaceComponentResult(new ScannerFragment.ScannerListener() { // from class: id.dana.pay.PayScannerFragment$initScannerReadyListener$1
            @Override // id.dana.scanner.ScannerFragment.ScannerListener
            public final void MyBillsEntityDataFactory() {
                PayScannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(PayScannerFragment.this, true);
            }

            @Override // id.dana.scanner.ScannerFragment.ScannerListener
            public final void PlaceComponentResult() {
                PayScannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(PayScannerFragment.this, false);
            }
        });
    }

    @OnClick({R.id.iv_gallery})
    public final void onIvGalleryClicked() {
        openGallery();
    }

    @OnClick({R.id.iv_flash})
    public final void onIvFlashClicked() {
        setTorch();
        NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        Drawable BuiltInFictitiousFunctionClassFactory;
        ImageView imageView = this.ivFlash;
        if (imageView != null) {
            if (imageView != null) {
                BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(requireContext(), this.moveToNextValue ? R.drawable.bg_circle_white_transparent : R.drawable.bg_circle_transparent);
                imageView.setBackground(BuiltInFictitiousFunctionClassFactory);
            }
            ImageView imageView2 = this.ivFlash;
            if (imageView2 != null) {
                InstrumentInjector.Resources_setImageResource(imageView2, this.moveToNextValue ? R.drawable.ic_flash_pay_active : R.drawable.ic_flash_pay);
            }
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PayScannerFragment payScannerFragment, boolean z) {
        payScannerFragment.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        PayScannerListener payScannerListener = payScannerFragment.MyBillsEntityDataFactory;
        if (payScannerListener == null || payScannerListener == null) {
            return;
        }
        payScannerListener.PlaceComponentResult(z);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
