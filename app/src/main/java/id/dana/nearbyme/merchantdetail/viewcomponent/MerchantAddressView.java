package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J#\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R*\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001d8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010\u001e\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010&R\u0018\u0010\u0016\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010&"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAddressView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideShimmer", "()V", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "showShimmer", "getAuthRequestContext", "Landroid/util/AttributeSet;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "value", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getMerchantAddress", "()Ljava/lang/String;", "setMerchantAddress", "(Ljava/lang/String;)V", "merchantAddress", "Landroid/view/View$OnClickListener;", "MyBillsEntityDataFactory", "Landroid/view/View$OnClickListener;", "getOnButtonClick", "()Landroid/view/View$OnClickListener;", "setOnButtonClick", "(Landroid/view/View$OnClickListener;)V", "onButtonClick", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantAddressView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String merchantAddress;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SkeletonScreen MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private View.OnClickListener onButtonClick;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private AttributeSet KClassImpl$Data$declaredNonStaticMembers$2;

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
        return R.layout.view_merchant_address;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = attributeSet;
        this.merchantAddress = "";
    }

    @JvmName(name = "getMerchantAddress")
    public final String getMerchantAddress() {
        return this.merchantAddress;
    }

    @JvmName(name = "setMerchantAddress")
    public final void setMerchantAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_address_value);
        if (textView != null) {
            textView.setText(str);
        }
        this.merchantAddress = str;
    }

    @JvmName(name = "getOnButtonClick")
    public final View.OnClickListener getOnButtonClick() {
        return this.onButtonClick;
    }

    @JvmName(name = "setOnButtonClick")
    public final void setOnButtonClick(View.OnClickListener onClickListener) {
        Button button = (Button) _$_findCachedViewById(R.id.res_0x7f0a01da_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider);
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
        this.onButtonClick = onClickListener;
    }

    public final void showShimmer() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
        SkeletonScreen skeletonScreen2 = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen2 != null) {
            skeletonScreen2.MyBillsEntityDataFactory();
        }
    }

    public final void hideShimmer() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        SkeletonScreen skeletonScreen2 = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult((TextView) _$_findCachedViewById(R.id.tv_address_value), R.layout.view_skeleton_merchant_address);
        this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult((Button) _$_findCachedViewById(R.id.res_0x7f0a01da_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider), R.layout.view_skeleton_direction_button);
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        super.parseAttrs(context, attrs);
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attrs, R.styleable.checkParameterIsNotNull) : null;
        if (obtainStyledAttributes != null) {
            try {
                String string = obtainStyledAttributes.getString(0);
                if (string == null) {
                    string = "";
                }
                setMerchantAddress(string);
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }
}
