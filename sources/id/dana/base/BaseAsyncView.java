package id.dana.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\u0006\u001a\u00020\u00032\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R-\u0010\u0017\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00040\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/base/BaseAsyncView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "bindFunc", "bindWhenInflated", "(Lkotlin/jvm/functions/Function1;)V", "", "getLayoutId", "()I", "inflate", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "setLayoutParams", "(II)V", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "PlaceComponentResult", "Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseAsyncView extends FrameLayout {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final List<Function1<BaseAsyncView, Unit>> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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

    public abstract int getLayoutId();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAsyncView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        inflate();
        this.PlaceComponentResult = new ArrayList();
    }

    public final void setLayoutParams(int width, int height) {
        setLayoutParams(new FrameLayout.LayoutParams(width, height));
    }

    public final void inflate() {
        AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(getContext());
        int layoutId = getLayoutId();
        BaseAsyncView baseAsyncView = this;
        AsyncLayoutInflater.OnInflateFinishedListener onInflateFinishedListener = new AsyncLayoutInflater.OnInflateFinishedListener() { // from class: id.dana.base.BaseAsyncView$$ExternalSyntheticLambda0
            @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
            public final void PlaceComponentResult(View view, int i, ViewGroup viewGroup) {
                BaseAsyncView.$r8$lambda$Mh5rS33901omB5lByeWwqQCpQbI(BaseAsyncView.this, view, i, viewGroup);
            }
        };
        AsyncLayoutInflater.InflateRequest BuiltInFictitiousFunctionClassFactory = asyncLayoutInflater.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new AsyncLayoutInflater.InflateRequest();
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = asyncLayoutInflater;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = layoutId;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = baseAsyncView;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = onInflateFinishedListener;
        try {
            asyncLayoutInflater.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.put(BuiltInFictitiousFunctionClassFactory);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (((androidx.fragment.app.FragmentActivity) r0).isDestroyed() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r2 = this;
            android.content.Context r0 = r2.getContext()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = r0 instanceof android.app.Application
            if (r0 != 0) goto L4a
            android.content.Context r0 = r2.getContext()
            boolean r0 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L2b
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L23
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            boolean r0 = r0.isDestroyed()
            if (r0 != 0) goto L41
            goto L2b
        L23:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            r0.<init>(r1)
            throw r0
        L2b:
            android.content.Context r0 = r2.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L4a
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L42
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isDestroyed()
            if (r0 == 0) goto L4a
        L41:
            return r1
        L42:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            r0.<init>(r1)
            throw r0
        L4a:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseAsyncView.KClassImpl$Data$declaredNonStaticMembers$2():boolean");
    }

    public final void bindWhenInflated(Function1<? super BaseAsyncView, Unit> bindFunc) {
        Intrinsics.checkNotNullParameter(bindFunc, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            bindFunc.invoke(this);
        } else {
            this.PlaceComponentResult.add(bindFunc);
        }
    }

    public static /* synthetic */ void $r8$lambda$Mh5rS33901omB5lByeWwqQCpQbI(BaseAsyncView baseAsyncView, View view, int i, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(baseAsyncView, "");
        Intrinsics.checkNotNullParameter(view, "");
        if (baseAsyncView.KClassImpl$Data$declaredNonStaticMembers$2()) {
            baseAsyncView.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            baseAsyncView.addView(view);
            List<Function1<BaseAsyncView, Unit>> list = baseAsyncView.PlaceComponentResult;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(baseAsyncView);
            }
            list.clear();
        }
    }
}
