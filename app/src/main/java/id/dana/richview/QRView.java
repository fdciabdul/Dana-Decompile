package id.dana.richview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;

/* loaded from: classes5.dex */
public class QRView extends BaseRichView {
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.imageview_user_profile)
    CircleImageView imageViewUserProfile;
    @BindView(R.id.view_kyc)
    ImageView ivKyc;
    @BindView(R.id.iv_qr)
    ImageView ivQr;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.view_qr_skeleton)
    View viewQrSkeleton;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_qr;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public QRView(Context context) {
        super(context);
    }

    public QRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QRView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public QRView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setKycView(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("KYC0".equals(str)) {
            this.ivKyc.setVisibility(4);
        } else {
            this.ivKyc.setVisibility(0);
        }
    }

    public void displayUserAvatar(String str) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.avatar_placeholder).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) this.imageViewUserProfile);
    }

    public void displayUserAvatar(int i) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(Integer.valueOf(i)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.avatar_placeholder).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) this.imageViewUserProfile);
    }

    public void showEmptyQr() {
        this.ivKyc.setVisibility(4);
        displayUserAvatar(R.drawable.refresh);
        InstrumentInjector.Resources_setImageResource(this.ivQr, R.drawable.square_rounded_skeleton);
    }

    public void showSkeleton() {
        View view = this.viewQrSkeleton;
        if (view != null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(view);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_bar180x180_skeleton;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen;
            BuiltInFictitiousFunctionClassFactory(false);
        }
    }

    public void hideSkeleton() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.viewQrSkeleton.setVisibility(8);
        }
        BuiltInFictitiousFunctionClassFactory(true);
    }

    public ImageView getQrImageView() {
        return this.ivQr;
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.ivQr.setVisibility(z ? 0 : 8);
        this.imageViewUserProfile.setVisibility(z ? 0 : 8);
    }
}
