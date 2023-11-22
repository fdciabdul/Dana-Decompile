package id.dana.onboarding.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import id.dana.databinding.ViewSimpleIntroductionAnimatedBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tR\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\r"}, d2 = {"Lid/dana/onboarding/view/AnimatedIntroductionView;", "Lid/dana/onboarding/view/BaseSimpleViewBinding;", "Lid/dana/databinding/ViewSimpleIntroductionAnimatedBinding;", "Lid/dana/onboarding/view/AnimationListener;", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "()Lkotlin/jvm/functions/Function1;", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimatedIntroductionView extends BaseSimpleViewBinding<ViewSimpleIntroductionAnimatedBinding> implements AnimationListener {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    public AnimatedIntroductionView(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = str3;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        LottieAnimationView lottieAnimationView;
        LottieAnimationView lottieAnimationView2;
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        ViewSimpleIntroductionAnimatedBinding lookAheadTest = lookAheadTest();
        TextView textView = lookAheadTest != null ? lookAheadTest.PlaceComponentResult : null;
        if (textView != null) {
            textView.setText(str);
        }
        this.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
        View m_ = m_();
        LottieComposition lottieComposition = LottieCompositionFactory.getAuthRequestContext(m_ != null ? m_.getContext() : null, this.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult;
        if (lottieComposition != null) {
            ViewSimpleIntroductionAnimatedBinding lookAheadTest2 = lookAheadTest();
            if (lookAheadTest2 != null && (lottieAnimationView2 = lookAheadTest2.MyBillsEntityDataFactory) != null) {
                lottieAnimationView2.setComposition(lottieComposition);
            }
            ViewSimpleIntroductionAnimatedBinding lookAheadTest3 = lookAheadTest();
            if (lookAheadTest3 != null && (lottieAnimationView = lookAheadTest3.MyBillsEntityDataFactory) != null) {
                lottieAnimationView.playAnimation();
            }
        }
        String str2 = this.getAuthRequestContext;
        this.getAuthRequestContext = str2;
        ViewSimpleIntroductionAnimatedBinding lookAheadTest4 = lookAheadTest();
        TextView textView2 = lookAheadTest4 != null ? lookAheadTest4.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.onboarding.view.BaseSimpleViewBinding
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final Function1<LayoutInflater, ViewSimpleIntroductionAnimatedBinding> KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Function1<LayoutInflater, ViewSimpleIntroductionAnimatedBinding>() { // from class: id.dana.onboarding.view.AnimatedIntroductionView$bindingInflater$1
            @Override // kotlin.jvm.functions.Function1
            public final ViewSimpleIntroductionAnimatedBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                ViewSimpleIntroductionAnimatedBinding BuiltInFictitiousFunctionClassFactory = ViewSimpleIntroductionAnimatedBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                return BuiltInFictitiousFunctionClassFactory;
            }
        };
    }

    @Override // id.dana.onboarding.view.AnimationListener
    public final void MyBillsEntityDataFactory() {
        LottieAnimationView lottieAnimationView;
        ViewSimpleIntroductionAnimatedBinding lookAheadTest = lookAheadTest();
        if (lookAheadTest == null || (lottieAnimationView = lookAheadTest.MyBillsEntityDataFactory) == null) {
            return;
        }
        lottieAnimationView.playAnimation();
    }

    @Override // id.dana.onboarding.view.AnimationListener
    public final void PlaceComponentResult() {
        LottieAnimationView lottieAnimationView;
        ViewSimpleIntroductionAnimatedBinding lookAheadTest = lookAheadTest();
        if (lookAheadTest == null || (lottieAnimationView = lookAheadTest.MyBillsEntityDataFactory) == null) {
            return;
        }
        lottieAnimationView.pauseAnimation();
    }
}
