package id.dana.richview.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.component.BaseRichView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%B+\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b$\u0010'J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198EX\u0085\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/richview/wallet/BaseWalletCardView;", "Lid/dana/component/BaseRichView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "constraintLayout", "", "addCardViewInto", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "", "getCardInstId", "()Ljava/lang/CharSequence;", "invokeListeners", "()V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "setupMarginLayoutForNewWalletFragmentSectionView", "()Lid/dana/richview/wallet/BaseWalletCardView;", "Lid/dana/richview/wallet/ElasticAnimator;", "elasticAnimator$delegate", "Lkotlin/Lazy;", "getElasticAnimator", "()Lid/dana/richview/wallet/ElasticAnimator;", "elasticAnimator", "Landroid/view/GestureDetector;", "gestureDetector$delegate", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseWalletCardView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: elasticAnimator$delegate  reason: from kotlin metadata */
    private final Lazy elasticAnimator;

    /* renamed from: gestureDetector$delegate  reason: from kotlin metadata */
    private final Lazy gestureDetector;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWalletCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWalletCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

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

    public abstract CharSequence getCardInstId();

    public abstract void invokeListeners();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWalletCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.elasticAnimator = LazyKt.lazy(new Function0<ElasticAnimator>() { // from class: id.dana.richview.wallet.BaseWalletCardView$elasticAnimator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ElasticAnimator invoke() {
                return new ElasticAnimator(BaseWalletCardView.this);
            }
        });
        this.gestureDetector = LazyKt.lazy(new Function0<GestureDetector>() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetector invoke() {
                Context context2 = BaseWalletCardView.this.getContext();
                final BaseWalletCardView baseWalletCardView = BaseWalletCardView.this;
                return new GestureDetector(context2, new GestureDetector.SimpleOnGestureListener() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public final boolean onDown(MotionEvent p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        return false;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public final boolean onSingleTapUp(MotionEvent p0) {
                        ElasticAnimator elasticAnimator;
                        Intrinsics.checkNotNullParameter(p0, "");
                        elasticAnimator = BaseWalletCardView.this.getElasticAnimator();
                        final BaseWalletCardView$gestureDetector$2$1$onSingleTapUp$1 baseWalletCardView$gestureDetector$2$1$onSingleTapUp$1 = new Function0<Unit>() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2$1$onSingleTapUp$1
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        };
                        final BaseWalletCardView baseWalletCardView2 = BaseWalletCardView.this;
                        final Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2$1$onSingleTapUp$2
                            /* JADX INFO: Access modifiers changed from: package-private */
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
                                ElasticAnimator elasticAnimator2;
                                BaseWalletCardView.this.invokeListeners();
                                elasticAnimator2 = BaseWalletCardView.this.getElasticAnimator();
                                ViewCompat.MyBillsEntityDataFactory(elasticAnimator2.getAuthRequestContext).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).NetworkUserEntityData$$ExternalSyntheticLambda0(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(1.0f).PlaceComponentResult();
                                View view = elasticAnimator2.getAuthRequestContext;
                                if (view instanceof ViewGroup) {
                                    IntRange until = RangesKt.until(0, ((ViewGroup) view).getChildCount());
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                                    Iterator<Integer> it = until.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((ViewGroup) elasticAnimator2.getAuthRequestContext).getChildAt(((IntIterator) it).nextInt()));
                                    }
                                    Iterator it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        ViewCompat.MyBillsEntityDataFactory((View) it2.next()).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).NetworkUserEntityData$$ExternalSyntheticLambda0(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(1.0f).MyBillsEntityDataFactory().PlaceComponentResult();
                                    }
                                }
                            }
                        };
                        Intrinsics.checkNotNullParameter(baseWalletCardView$gestureDetector$2$1$onSingleTapUp$1, "");
                        Intrinsics.checkNotNullParameter(function0, "");
                        ViewCompat.MyBillsEntityDataFactory(elasticAnimator.getAuthRequestContext).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(0.95f).KClassImpl$Data$declaredNonStaticMembers$2(0.95f).KClassImpl$Data$declaredNonStaticMembers$2(new Runnable() { // from class: id.dana.richview.wallet.ElasticAnimator$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                ElasticAnimator.getAuthRequestContext(Function0.this);
                            }
                        }).BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: id.dana.richview.wallet.ElasticAnimator$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ElasticAnimator.PlaceComponentResult(Function0.this);
                            }
                        }).PlaceComponentResult();
                        View view = elasticAnimator.getAuthRequestContext;
                        if (view instanceof ViewGroup) {
                            IntRange until = RangesKt.until(0, ((ViewGroup) view).getChildCount());
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                            Iterator<Integer> it = until.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((ViewGroup) elasticAnimator.getAuthRequestContext).getChildAt(((IntIterator) it).nextInt()));
                            }
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ViewCompat.MyBillsEntityDataFactory((View) it2.next()).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(0.95f).KClassImpl$Data$declaredNonStaticMembers$2(0.95f).MyBillsEntityDataFactory().PlaceComponentResult();
                            }
                            return true;
                        }
                        return true;
                    }
                });
            }
        });
    }

    public /* synthetic */ BaseWalletCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWalletCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.elasticAnimator = LazyKt.lazy(new Function0<ElasticAnimator>() { // from class: id.dana.richview.wallet.BaseWalletCardView$elasticAnimator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ElasticAnimator invoke() {
                return new ElasticAnimator(BaseWalletCardView.this);
            }
        });
        this.gestureDetector = LazyKt.lazy(new Function0<GestureDetector>() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetector invoke() {
                Context context2 = BaseWalletCardView.this.getContext();
                final BaseWalletCardView baseWalletCardView = BaseWalletCardView.this;
                return new GestureDetector(context2, new GestureDetector.SimpleOnGestureListener() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public final boolean onDown(MotionEvent p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        return false;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public final boolean onSingleTapUp(MotionEvent p0) {
                        ElasticAnimator elasticAnimator;
                        Intrinsics.checkNotNullParameter(p0, "");
                        elasticAnimator = BaseWalletCardView.this.getElasticAnimator();
                        final Function0 baseWalletCardView$gestureDetector$2$1$onSingleTapUp$1 = new Function0<Unit>() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2$1$onSingleTapUp$1
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        };
                        final BaseWalletCardView baseWalletCardView2 = BaseWalletCardView.this;
                        final Function0 function0 = new Function0<Unit>() { // from class: id.dana.richview.wallet.BaseWalletCardView$gestureDetector$2$1$onSingleTapUp$2
                            /* JADX INFO: Access modifiers changed from: package-private */
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
                                ElasticAnimator elasticAnimator2;
                                BaseWalletCardView.this.invokeListeners();
                                elasticAnimator2 = BaseWalletCardView.this.getElasticAnimator();
                                ViewCompat.MyBillsEntityDataFactory(elasticAnimator2.getAuthRequestContext).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).NetworkUserEntityData$$ExternalSyntheticLambda0(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(1.0f).PlaceComponentResult();
                                View view = elasticAnimator2.getAuthRequestContext;
                                if (view instanceof ViewGroup) {
                                    IntRange until = RangesKt.until(0, ((ViewGroup) view).getChildCount());
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                                    Iterator<Integer> it = until.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((ViewGroup) elasticAnimator2.getAuthRequestContext).getChildAt(((IntIterator) it).nextInt()));
                                    }
                                    Iterator it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        ViewCompat.MyBillsEntityDataFactory((View) it2.next()).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).NetworkUserEntityData$$ExternalSyntheticLambda0(0.0f).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(1.0f).KClassImpl$Data$declaredNonStaticMembers$2(1.0f).MyBillsEntityDataFactory().PlaceComponentResult();
                                    }
                                }
                            }
                        };
                        Intrinsics.checkNotNullParameter(baseWalletCardView$gestureDetector$2$1$onSingleTapUp$1, "");
                        Intrinsics.checkNotNullParameter(function0, "");
                        ViewCompat.MyBillsEntityDataFactory(elasticAnimator.getAuthRequestContext).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(0.95f).KClassImpl$Data$declaredNonStaticMembers$2(0.95f).KClassImpl$Data$declaredNonStaticMembers$2(new Runnable() { // from class: id.dana.richview.wallet.ElasticAnimator$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                ElasticAnimator.getAuthRequestContext(Function0.this);
                            }
                        }).BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: id.dana.richview.wallet.ElasticAnimator$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ElasticAnimator.PlaceComponentResult(Function0.this);
                            }
                        }).PlaceComponentResult();
                        View view = elasticAnimator.getAuthRequestContext;
                        if (view instanceof ViewGroup) {
                            IntRange until = RangesKt.until(0, ((ViewGroup) view).getChildCount());
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                            Iterator<Integer> it = until.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((ViewGroup) elasticAnimator.getAuthRequestContext).getChildAt(((IntIterator) it).nextInt()));
                            }
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ViewCompat.MyBillsEntityDataFactory((View) it2.next()).MyBillsEntityDataFactory(new FastOutSlowInInterpolator()).KClassImpl$Data$declaredNonStaticMembers$2(50L).BuiltInFictitiousFunctionClassFactory(0.95f).KClassImpl$Data$declaredNonStaticMembers$2(0.95f).MyBillsEntityDataFactory().PlaceComponentResult();
                            }
                            return true;
                        }
                        return true;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getElasticAnimator")
    public final ElasticAnimator getElasticAnimator() {
        return (ElasticAnimator) this.elasticAnimator.getValue();
    }

    @JvmName(name = "getGestureDetector")
    public final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    public final void addCardViewInto(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "");
        setId(ViewCompat.MyBillsEntityDataFactory());
        setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.BuiltInFictitiousFunctionClassFactory(getId(), 1, 0, 1);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getId(), 3, 0, 3);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getId(), 2, 0, 2);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getId(), 4, 0, 4);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
        ConstraintLayout constraintLayout2 = constraintLayout instanceof ViewGroup ? constraintLayout : null;
        if (constraintLayout2 != null) {
            int childCount = constraintLayout2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout2.getChildAt(i);
                BaseWalletCardView baseWalletCardView = childAt instanceof BaseWalletCardView ? (BaseWalletCardView) childAt : null;
                if (baseWalletCardView != null) {
                    constraintLayout2.removeView(baseWalletCardView);
                }
            }
            constraintLayout2.addView(this);
        }
    }

    public final BaseWalletCardView setupMarginLayoutForNewWalletFragmentSectionView() {
        setId(ViewCompat.MyBillsEntityDataFactory());
        setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        return this;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev != null) {
            return getGestureDetector().onTouchEvent(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }
}
