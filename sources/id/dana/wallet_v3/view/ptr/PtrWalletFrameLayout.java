package id.dana.wallet_v3.view.ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/wallet_v3/view/ptr/PtrWalletFrameLayout;", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "", "initViews", "()V", "Lid/dana/wallet_v3/view/ptr/PtrWalletSearchViewHeader;", "ptrWalletSearchViewHeader", "Lid/dana/wallet_v3/view/ptr/PtrWalletSearchViewHeader;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PtrWalletFrameLayout extends PtrFrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private PtrWalletSearchViewHeader ptrWalletSearchViewHeader;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PtrWalletFrameLayout(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout.<init>(android.content.Context):void");
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PtrWalletFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        initViews();
    }

    public /* synthetic */ PtrWalletFrameLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void initViews() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        PtrWalletSearchViewHeader ptrWalletSearchViewHeader = new PtrWalletSearchViewHeader(context);
        this.ptrWalletSearchViewHeader = ptrWalletSearchViewHeader;
        setHeaderView(ptrWalletSearchViewHeader);
        PtrWalletSearchViewHeader ptrWalletSearchViewHeader2 = this.ptrWalletSearchViewHeader;
        if (ptrWalletSearchViewHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrWalletSearchViewHeader2 = null;
        }
        addPtrUIHandler(ptrWalletSearchViewHeader2);
    }
}
