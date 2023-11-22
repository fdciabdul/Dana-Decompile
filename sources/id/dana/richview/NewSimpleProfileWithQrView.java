package id.dana.richview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.richview.NewSimpleProfileWithQrView;
import id.dana.utils.MaskedTextUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002)*B'\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&B+\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b%\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/richview/NewSimpleProfileWithQrView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/widget/ImageView;", "getUserProfileImageView", "()Landroid/widget/ImageView;", "", "premium", "", "onPremiumUser", "(Z)V", "", "text", "setPhoneNumber", "(Ljava/lang/String;)V", "Lid/dana/richview/NewSimpleProfileWithQrView$OnProfilePictureClickListener;", "callback", "setProfilePictureClickListener", "(Lid/dana/richview/NewSimpleProfileWithQrView$OnProfilePictureClickListener;)V", "Lid/dana/richview/NewSimpleProfileWithQrView$OnQrCodeClickedListener;", "setQrImageClickListener", "(Lid/dana/richview/NewSimpleProfileWithQrView$OnQrCodeClickedListener;)V", "setUserName", "setup", "()V", "stopRefreshAnimation", "Landroid/view/animation/Animation;", "MyBillsEntityDataFactory", "Landroid/view/animation/Animation;", "PlaceComponentResult", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnProfilePictureClickListener", "OnQrCodeClickedListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewSimpleProfileWithQrView extends BaseRichView {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Animation PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/NewSimpleProfileWithQrView$OnProfilePictureClickListener;", "", "", "MyBillsEntityDataFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnProfilePictureClickListener {
        void MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/NewSimpleProfileWithQrView$OnQrCodeClickedListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnQrCodeClickedListener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSimpleProfileWithQrView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSimpleProfileWithQrView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_new_simple_profile_with_qr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSimpleProfileWithQrView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NewSimpleProfileWithQrView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSimpleProfileWithQrView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "");
        this.PlaceComponentResult = loadAnimation;
        if (loadAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadAnimation = null;
        }
        loadAnimation.setInterpolator(new LinearInterpolator());
    }

    public final void onPremiumUser(boolean premium) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.iv_dana_premium);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(premium ? 0 : 4);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0fdb_daggerpromocentercomponent_promocentercomponentimpl_settingrepositoryprovider);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(premium ? 0 : 4);
        }
    }

    public final void stopRefreshAnimation() {
        Animation animation = this.PlaceComponentResult;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            animation = null;
        }
        if (animation.hasEnded()) {
            return;
        }
        Animation animation3 = this.PlaceComponentResult;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            animation2 = animation3;
        }
        animation2.cancel();
    }

    public final ImageView getUserProfileImageView() {
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.res_0x7f0a0fda_abstractbinaryclassannotationandconstantloader_loadannotationsandinitializers_1_annotationvisitorformethod);
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        return circleImageView;
    }

    public final void setUserName(String text) {
        ProfileNameTextView profileNameTextView;
        Intrinsics.checkNotNullParameter(text, "");
        String str = text;
        if (TextUtils.isEmpty(str) || (profileNameTextView = (ProfileNameTextView) _$_findCachedViewById(R.id.text_user_name)) == null) {
            return;
        }
        profileNameTextView.setText(str);
    }

    public final void setPhoneNumber(String text) {
        TextView textView;
        Intrinsics.checkNotNullParameter(text, "");
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.access$createConstructor);
        if (textView2 != null) {
            textView2.setVisibility(TextUtils.isEmpty(text) ? 8 : 0);
        }
        if (TextUtils.isEmpty(text) || (textView = (TextView) _$_findCachedViewById(R.id.access$createConstructor)) == null) {
            return;
        }
        textView.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(text, false));
    }

    public final void setQrImageClickListener(final OnQrCodeClickedListener callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.vg_profile_with_qr_show);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.NewSimpleProfileWithQrView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewSimpleProfileWithQrView.$r8$lambda$mEKEOsURIZSHDrsw4g67O0RvGA8(NewSimpleProfileWithQrView.OnQrCodeClickedListener.this, view);
                }
            });
        }
    }

    public final void setProfilePictureClickListener(final OnProfilePictureClickListener callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        ((CircleImageView) _$_findCachedViewById(R.id.res_0x7f0a0fda_abstractbinaryclassannotationandconstantloader_loadannotationsandinitializers_1_annotationvisitorformethod)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.NewSimpleProfileWithQrView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSimpleProfileWithQrView.m2811$r8$lambda$4J2pPP_4rgazUc9SvYtYR65FE(NewSimpleProfileWithQrView.OnProfilePictureClickListener.this, view);
            }
        });
    }

    /* renamed from: $r8$lambda$4J2pPP_4rgazUc9S-vYtYR6-5FE  reason: not valid java name */
    public static /* synthetic */ void m2811$r8$lambda$4J2pPP_4rgazUc9SvYtYR65FE(OnProfilePictureClickListener onProfilePictureClickListener, View view) {
        Intrinsics.checkNotNullParameter(onProfilePictureClickListener, "");
        onProfilePictureClickListener.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$mEKEOsURIZSHDrsw4g67O0RvGA8(OnQrCodeClickedListener onQrCodeClickedListener, View view) {
        Intrinsics.checkNotNullParameter(onQrCodeClickedListener, "");
        onQrCodeClickedListener.BuiltInFictitiousFunctionClassFactory();
    }
}
