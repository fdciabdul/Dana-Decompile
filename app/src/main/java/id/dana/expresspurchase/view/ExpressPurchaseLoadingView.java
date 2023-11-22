package id.dana.expresspurchase.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.History;
import com.zhuinden.simplestack.navigator.Navigator;
import id.dana.R;
import id.dana.extension.ContextExtKt;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.richview.DanaProtectionLoadingView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B'\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B+\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lid/dana/expresspurchase/view/ExpressPurchaseLoadingView$DanaProtectionLoadingEvent;", "event", "", "danaProtectionLoadingAction", "(Lid/dana/expresspurchase/view/ExpressPurchaseLoadingView$DanaProtectionLoadingEvent;)V", "onFinishInflate", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "DanaProtectionLoadingEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpressPurchaseLoadingView extends ConstraintLayout {
    public static final String KEY_LOADING_SCREEN_HEIGHT = "key_loading_screen_height";
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseLoadingView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ExpressPurchaseLoadingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        if (Navigator.isNavigatorAvailable(ContextExtKt.getAuthRequestContext(context))) {
            Bundle bundle = ((ExpressPurchaseLoadingScreen) Backstack.getKey(getContext())).KClassImpl$Data$declaredNonStaticMembers$2;
            Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt(KEY_LOADING_SCREEN_HEIGHT)) : null;
            DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) _$_findCachedViewById(R.id.express_purchase_loading_view);
            if (danaProtectionLoadingView != null) {
                Intrinsics.checkNotNullExpressionValue(danaProtectionLoadingView, "");
                DanaProtectionLoadingView danaProtectionLoadingView2 = danaProtectionLoadingView;
                ViewGroup.LayoutParams layoutParams = danaProtectionLoadingView2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = NumberExtKt.toSafeInt$default(valueOf, 0, 1, (Object) null);
                    danaProtectionLoadingView2.setLayoutParams(layoutParams);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            }
            EventBus.getDefault().register(this);
            DanaProtectionLoadingView danaProtectionLoadingView3 = (DanaProtectionLoadingView) _$_findCachedViewById(R.id.express_purchase_loading_view);
            if (danaProtectionLoadingView3 != null) {
                danaProtectionLoadingView3.startLoading();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseLoadingView$DanaProtectionLoadingEvent;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "p0", "p1", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DanaProtectionLoadingEvent {
        final Bundle BuiltInFictitiousFunctionClassFactory;
        final String PlaceComponentResult;

        public DanaProtectionLoadingEvent(String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = bundle;
        }

        public /* synthetic */ DanaProtectionLoadingEvent(String str, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : bundle);
        }
    }

    @Subscribe
    public final void danaProtectionLoadingAction(DanaProtectionLoadingEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        String str = event.PlaceComponentResult;
        if (!Intrinsics.areEqual(str, ExpressPurchaseActivity.STOP_LOADING)) {
            if (Intrinsics.areEqual(str, ExpressPurchaseActivity.OPEN_RESULT_PAGE)) {
                final Bundle bundle = event.BuiltInFictitiousFunctionClassFactory;
                DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) _$_findCachedViewById(R.id.express_purchase_loading_view);
                if (danaProtectionLoadingView != null) {
                    danaProtectionLoadingView.setDanaActionFinishListener(new Function0<Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseLoadingView$goToResultPage$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Context context = ExpressPurchaseLoadingView.this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "");
                            ExpressPurchaseNavigationManager navigationManager = ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).getNavigationManager();
                            ExpressPurchaseResultScreen expressPurchaseResultScreen = new ExpressPurchaseResultScreen(R.layout.view_express_purchase_bundle_result, bundle);
                            Intrinsics.checkNotNullParameter(expressPurchaseResultScreen, "");
                            navigationManager.BuiltInFictitiousFunctionClassFactory.setHistory(History.single(expressPurchaseResultScreen), 0);
                        }
                    });
                }
                EventBus.getDefault().unregister(this);
                return;
            }
            return;
        }
        DanaProtectionLoadingView danaProtectionLoadingView2 = (DanaProtectionLoadingView) _$_findCachedViewById(R.id.express_purchase_loading_view);
        if (danaProtectionLoadingView2 != null) {
            DanaProtectionLoadingView.finishLoading$default(danaProtectionLoadingView2, false, 1, null);
        }
    }
}
