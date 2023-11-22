package id.dana.pay.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.BarcodeUtil;
import io.reactivex.functions.Consumer;

/* loaded from: classes5.dex */
public abstract class BasePayView extends BaseRichView {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private ImageView MyBillsEntityDataFactory;
    private ImageView PlaceComponentResult;
    private boolean getAuthRequestContext;
    @BindView(R.id.ll_offline_qr)
    LinearLayout llOfflineQr;
    protected OnClickListener onClickListener;
    @BindView(R.id.pay_qr)
    ImageView qrView;
    @BindView(R.id.pay_mid_refresh_label)
    TextView refreshLabel;
    protected boolean valid;

    /* loaded from: classes5.dex */
    public interface OnClickListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    protected abstract void onDisableCode();

    protected abstract void onSetCode(String str);

    protected abstract void setBarcodeOverlayViewVisibility(int i);

    public BasePayView(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public BasePayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public BasePayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public BasePayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    @Override // id.dana.base.BaseRichView
    public void onInjectedView(View view) {
        super.onInjectedView(view);
        this.MyBillsEntityDataFactory = (ImageView) view.findViewById(R.id.pay_mid_logo);
        this.PlaceComponentResult = (ImageView) view.findViewById(R.id.pay_mid_refresh);
    }

    @Override // id.dana.base.BaseRichView
    public void setup(boolean z) {
        super.setup(z);
        if (z) {
            return;
        }
        setCode("");
        fetchCode();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.view.BasePayView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BasePayView.this.m2776lambda$setup$0$iddanapayviewBasePayView(view);
            }
        });
        this.qrView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.view.BasePayView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BasePayView.this.m2777lambda$setup$1$iddanapayviewBasePayView(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-pay-view-BasePayView  reason: not valid java name */
    public /* synthetic */ void m2776lambda$setup$0$iddanapayviewBasePayView(View view) {
        OnClickListener onClickListener = this.onClickListener;
        if (onClickListener != null) {
            onClickListener.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$1$id-dana-pay-view-BasePayView  reason: not valid java name */
    public /* synthetic */ void m2777lambda$setup$1$iddanapayviewBasePayView(View view) {
        OnClickListener onClickListener = this.onClickListener;
        if (onClickListener == null || !this.valid) {
            return;
        }
        onClickListener.BuiltInFictitiousFunctionClassFactory();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void startRefresh() {
        fetchCode();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.PlaceComponentResult.startAnimation(loadAnimation);
        this.getAuthRequestContext = true;
    }

    public void fetchCode() {
        PlaceComponentResult(false);
        this.refreshLabel.setText(R.string.loading_pay_qr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showQR(boolean z) {
        ImageView imageView = this.MyBillsEntityDataFactory;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
        ImageView imageView2 = this.qrView;
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 0 : 4);
        }
    }

    public void invalidCode() {
        this.valid = false;
        PlaceComponentResult(false);
        TextView textView = this.refreshLabel;
        if (textView != null) {
            textView.setText(R.string.tap_to_refresh);
        }
        setBarcodeOverlayViewVisibility(0);
        stopRefresh();
    }

    public void disableCode() {
        this.valid = false;
        PlaceComponentResult(false);
        setBarcodeOverlayViewVisibility(8);
        TextView textView = this.refreshLabel;
        if (textView != null) {
            textView.setVisibility(8);
        }
        onDisableCode();
        ImageView imageView = this.PlaceComponentResult;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout = this.llOfflineQr;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        stopRefresh();
    }

    public void stopRefresh() {
        try {
            if (!TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2) && !this.KClassImpl$Data$declaredNonStaticMembers$2.equals("")) {
                PlaceComponentResult(true);
                setBarcodeOverlayViewVisibility(8);
            }
            ImageView imageView = this.PlaceComponentResult;
            if (imageView != null) {
                imageView.setAnimation(null);
            }
        } catch (Exception unused) {
        }
        this.getAuthRequestContext = false;
    }

    public String getCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setCode(String str) {
        if (!TextUtils.isEmpty(str) && !"".equals(str)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.valid = true;
        }
        addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(str).subscribe(new Consumer() { // from class: id.dana.pay.view.BasePayView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BasePayView.this.m2775lambda$setCode$2$iddanapayviewBasePayView((Bitmap) obj);
            }
        }));
        onSetCode(str);
        TextView textView = this.refreshLabel;
        if (textView != null) {
            textView.setText(R.string.tap_to_refresh);
        }
        stopRefresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCode$2$id-dana-pay-view-BasePayView  reason: not valid java name */
    public /* synthetic */ void m2775lambda$setCode$2$iddanapayviewBasePayView(Bitmap bitmap) throws Exception {
        this.qrView.setImageBitmap(bitmap);
    }

    public void resetQrCode() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public boolean getIsLoading() {
        return this.getAuthRequestContext;
    }

    private void PlaceComponentResult(boolean z) {
        boolean z2 = !z;
        ImageView imageView = this.PlaceComponentResult;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
        TextView textView = this.refreshLabel;
        if (textView != null) {
            textView.setVisibility(z2 ? 0 : 8);
        }
        showQR(z);
    }
}
