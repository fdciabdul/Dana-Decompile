package id.dana.richview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.richview.SimpleProfileWithQrView;
import id.dana.utils.MaskedTextUtil;

/* loaded from: classes5.dex */
public class SimpleProfileWithQrView extends BaseRichView {
    private Animation getAuthRequestContext;
    @BindView(R.id.f3883iv_dana_premium)
    ImageView ivDanaPremium;
    @BindView(R.id.tv_phone_number)
    TextView phoneNumber;
    @BindView(R.id.f4079xce2d0a5d)
    ImageView profileAvatarShadowOverlay;
    @BindView(R.id.f4078x49e4d33e)
    CircleImageView profileImageView;
    @BindView(R.id.f4208text_user_name)
    ProfileNameTextView userName;
    @BindView(R.id.f4562vg_profile_with_qr_show)
    ViewGroup vgProfileWithQrShow;

    /* loaded from: classes5.dex */
    public interface OnQrCodeClickedListener {
        void PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_simple_profile_with_qr;
    }

    public SimpleProfileWithQrView(Context context) {
        super(context);
    }

    public SimpleProfileWithQrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleProfileWithQrView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SimpleProfileWithQrView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        this.getAuthRequestContext = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
    }

    public void onPremiumUser(boolean z) {
        ImageView imageView = this.ivDanaPremium;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
        ImageView imageView2 = this.profileAvatarShadowOverlay;
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 0 : 4);
        }
    }

    public void stopRefreshAnimation() {
        if (this.getAuthRequestContext.hasEnded()) {
            return;
        }
        this.getAuthRequestContext.cancel();
    }

    public ImageView getUserProfileImageView() {
        return this.profileImageView;
    }

    public void setUserName(String str) {
        ProfileNameTextView profileNameTextView;
        if (TextUtils.isEmpty(str) || (profileNameTextView = this.userName) == null) {
            return;
        }
        profileNameTextView.setText(str);
    }

    public void setPhoneNumber(String str) {
        TextView textView = this.phoneNumber;
        if (textView != null) {
            textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.phoneNumber.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(str, false));
        }
    }

    public void setQrImageListener(final OnQrCodeClickedListener onQrCodeClickedListener) {
        ViewGroup viewGroup = this.vgProfileWithQrShow;
        if (viewGroup == null || onQrCodeClickedListener == null) {
            return;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.SimpleProfileWithQrView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleProfileWithQrView.OnQrCodeClickedListener.this.PlaceComponentResult();
            }
        });
    }
}
