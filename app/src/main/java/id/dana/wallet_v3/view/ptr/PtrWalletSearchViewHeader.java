package id.dana.wallet_v3.view.ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewWalletV3SearchHeaderBinding;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010!J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0014\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0017"}, d2 = {"Lid/dana/wallet_v3/view/ptr/PtrWalletSearchViewHeader;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewWalletV3SearchHeaderBinding;", "Lin/srain/cube/views/ptr/PtrUIHandler;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewWalletV3SearchHeaderBinding;", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "frame", "", "isUnderTouch", "", "status", "Lin/srain/cube/views/ptr/indicator/PtrIndicator;", "ptrIndicator", "", "onUIPositionChange", "(Lin/srain/cube/views/ptr/PtrFrameLayout;ZBLin/srain/cube/views/ptr/indicator/PtrIndicator;)V", "onUIRefreshBegin", "(Lin/srain/cube/views/ptr/PtrFrameLayout;)V", "onUIRefreshComplete", "onUIRefreshPrepare", "onUIReset", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PtrWalletSearchViewHeader extends ViewBindingRichView<ViewWalletV3SearchHeaderBinding> implements PtrUIHandler {
    public Map<Integer, View> _$_findViewCache;

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_wallet_v3_search_header;
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public final void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public final void onUIRefreshBegin(PtrFrameLayout frame) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PtrWalletSearchViewHeader(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PtrWalletSearchViewHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewWalletV3SearchHeaderBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewWalletV3SearchHeaderBinding MyBillsEntityDataFactory = ViewWalletV3SearchHeaderBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public final void onUIReset(PtrFrameLayout frame) {
        FrameLayout frameLayout = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public final void onUIRefreshPrepare(PtrFrameLayout frame) {
        FrameLayout frameLayout = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(0);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public final void onUIRefreshComplete(PtrFrameLayout frame) {
        FrameLayout frameLayout = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
    }
}
