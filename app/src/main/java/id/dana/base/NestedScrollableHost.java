package id.dana.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.push.e;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/base/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "", "p0", "", "p1", "", "PlaceComponentResult", "(IF)Z", "Landroid/view/MotionEvent;", e.PlaceComponentResult, "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "BuiltInFictitiousFunctionClassFactory", LogConstants.RESULT_FALSE, "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getScrollParent", "()Z", "setScrollParent", "(Z)V", "scrollParent", "MyBillsEntityDataFactory", "I", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NestedScrollableHost extends FrameLayout {
    private float BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean scrollParent;
    private int MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

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
    public NestedScrollableHost(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scrollParent = true;
        this.MyBillsEntityDataFactory = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scrollParent = true;
        this.MyBillsEntityDataFactory = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @JvmName(name = "getScrollParent")
    public final boolean getScrollParent() {
        return this.scrollParent;
    }

    @JvmName(name = "setScrollParent")
    public final void setScrollParent(boolean z) {
        this.scrollParent = z;
    }

    private final boolean PlaceComponentResult(int p0, float p1) {
        View childAt;
        int i = -((int) Math.signum(p1));
        if (p0 == 0) {
            childAt = getChildCount() > 0 ? getChildAt(0) : null;
            if (childAt != null) {
                return childAt.canScrollHorizontally(i);
            }
            return false;
        } else if (p0 != 1) {
            throw new IllegalArgumentException();
        } else {
            childAt = getChildCount() > 0 ? getChildAt(0) : null;
            if (childAt != null) {
                return childAt.canScrollVertically(i);
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[LOOP:0: B:7:0x001b->B:12:0x0029, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0017 -> B:7:0x001b). Please submit an issue!!! */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.NestedScrollableHost.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
