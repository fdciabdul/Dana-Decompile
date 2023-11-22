package id.dana.kyb.view.richview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.request.BaseRequestOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.component.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.kyb.view.MyBusinessFragment;
import id.dana.utils.ImageResize;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0002¢\u0006\u0004\b@\u0010AB+\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\u0006\u0010?\u001a\u00020\u0002\u0012\u0006\u0010B\u001a\u00020\u0002¢\u0006\u0004\b@\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\tJ\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010$\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010/\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00103R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u00105R\u0016\u0010+\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00108\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u00105R\u0016\u00107\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010#"}, d2 = {"Lid/dana/kyb/view/richview/MyBusinessHeaderView;", "Lid/dana/component/BaseRichView;", "", "getLayout", "()I", "", "url", "", "setAvatar", "(Ljava/lang/String;)V", "merchantTier", "setBadge", "merchantName", "merchantLevel", "setHeaderContentDescription", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setKybTieringListener", "(Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;)V", "statusResId", "setMerchantLevel", "(I)V", "name", "setMerchantName", "setMerchantStatus", "variant", "setVariant", "setup", "()V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getAuthRequestContext", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lde/hdodenhof/circleimageview/CircleImageView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lde/hdodenhof/circleimageview/CircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "scheduleImpl", "Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;", "lookAheadTest", "Landroid/widget/LinearLayout;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/widget/LinearLayout;", "getErrorConfigVersion", "", "Z", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessHeaderView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private AppCompatImageView MyBillsEntityDataFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    private CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ViewGroup BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private LinearLayout getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private TextView initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda1;
    private ViewGroup PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    private ConstraintLayout getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private TextView moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private TextView scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MyBusinessFragment.KybTieringListener lookAheadTest;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBusinessHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBusinessHeaderView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.view_my_business_header;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBusinessHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MyBusinessHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBusinessHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setVariant(int variant) {
        ViewGroup viewGroup = this.BuiltInFictitiousFunctionClassFactory;
        LinearLayout linearLayout = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup = null;
        }
        viewGroup.setVisibility(variant == 0 ? 0 : 8);
        ViewGroup viewGroup2 = this.PlaceComponentResult;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(variant != 0 ? 0 : 8);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = variant == 1;
        ConstraintLayout constraintLayout = this.getAuthRequestContext;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 0 : 8);
        LinearLayout linearLayout2 = this.getErrorConfigVersion;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ^ true ? 0 : 8);
    }

    public final void setBadge(String merchantTier) {
        int i;
        Intrinsics.checkNotNullParameter(merchantTier, "");
        if (Intrinsics.areEqual(merchantTier, "10")) {
            i = R.drawable.ic_kyb_badge_gold;
            setMerchantLevel(R.string.tier_gold);
        } else if (Intrinsics.areEqual(merchantTier, "5")) {
            i = R.drawable.ic_kyb_badge_silver;
            setMerchantLevel(R.string.tier_silver);
        } else {
            setMerchantLevel(R.string.tier_bronze);
            i = R.drawable.ic_kyb_badge_bronze;
        }
        Context context = getContext();
        if (context != null) {
            GlideRequest<Bitmap> PlaceComponentResult = GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf(i)).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_kyb_badge_bronze).PlaceComponentResult((int) R.drawable.ic_kyb_badge_bronze);
            AppCompatImageView appCompatImageView = this.MyBillsEntityDataFactory;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                appCompatImageView = null;
            }
            PlaceComponentResult.MyBillsEntityDataFactory((ImageView) appCompatImageView);
        }
    }

    public final void setAvatar(String url) {
        Context context = getContext();
        if (context != null) {
            GlideRequest<Bitmap> PlaceComponentResult = GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(url).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_default_avatar_bisnis).PlaceComponentResult((int) R.drawable.ic_default_avatar_bisnis);
            CircleImageView circleImageView = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (circleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                circleImageView = null;
            }
            PlaceComponentResult.MyBillsEntityDataFactory((ImageView) circleImageView);
        }
    }

    public final void setMerchantName(String name) {
        Intrinsics.checkNotNullParameter(name, "");
        TextView textView = null;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            TextView textView2 = this.scheduleImpl;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                textView = textView2;
            }
            textView.setText(name);
            return;
        }
        TextView textView3 = this.initRecordTimeStamp;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView = textView3;
        }
        textView.setText(name);
    }

    public final void setHeaderContentDescription(String merchantName, String merchantLevel) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(merchantLevel, "");
        TextView textView = this.scheduleImpl;
        ViewGroup viewGroup = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setContentDescription(merchantName);
        ViewGroup viewGroup2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setContentDescription(merchantLevel);
    }

    public final void setMerchantLevel(int statusResId) {
        TextView textView = this.moveToNextValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setText(statusResId);
    }

    public final void setMerchantStatus(int statusResId) {
        TextView textView = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setText(statusResId);
    }

    public final void setKybTieringListener(MyBusinessFragment.KybTieringListener r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        this.lookAheadTest = r2;
    }

    public static /* synthetic */ void $r8$lambda$niuDhP1kqqOo_CwPPQRCP_o_Zao(MyBusinessHeaderView myBusinessHeaderView, View view) {
        Intrinsics.checkNotNullParameter(myBusinessHeaderView, "");
        MyBusinessFragment.KybTieringListener kybTieringListener = myBusinessHeaderView.lookAheadTest;
        if (kybTieringListener != null) {
            kybTieringListener.PlaceComponentResult();
        }
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
        View findViewById = findViewById(R.id.my_business_header_unregistered);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.BuiltInFictitiousFunctionClassFactory = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.my_business_header_other);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.PlaceComponentResult = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.iv_avatar_business);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CircleImageView) findViewById3;
        View findViewById4 = findViewById(R.id.view_profile_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        this.getAuthRequestContext = (ConstraintLayout) findViewById4;
        View findViewById5 = findViewById(R.id.ll_profile_detail_other);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "");
        this.getErrorConfigVersion = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.f4438tv_merchant_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "");
        this.scheduleImpl = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.tv_merchant_name_other_status);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "");
        this.initRecordTimeStamp = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_merchant_status);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.iv_badge_merchant);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "");
        this.MyBillsEntityDataFactory = (AppCompatImageView) findViewById9;
        View findViewById10 = findViewById(R.id.tv_level_merchant);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "");
        this.moveToNextValue = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.vg_level_merchant);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "");
        ViewGroup viewGroup = (ViewGroup) findViewById11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.MyBusinessHeaderView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessHeaderView.$r8$lambda$niuDhP1kqqOo_CwPPQRCP_o_Zao(MyBusinessHeaderView.this, view);
            }
        });
    }
}
