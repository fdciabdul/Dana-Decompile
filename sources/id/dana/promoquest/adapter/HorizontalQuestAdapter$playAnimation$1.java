package id.dana.promoquest.adapter;

import android.view.animation.Animation;
import android.widget.ImageView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/promoquest/adapter/HorizontalQuestAdapter$playAnimation$1;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationEnd", "(Landroid/view/animation/Animation;)V", "onAnimationRepeat", "onAnimationStart"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HorizontalQuestAdapter$playAnimation$1 implements Animation.AnimationListener {
    final /* synthetic */ Animation KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ HorizontalQuestAdapter MyBillsEntityDataFactory;
    final /* synthetic */ ImageView getAuthRequestContext;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation p0) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation p0) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HorizontalQuestAdapter$playAnimation$1(Animation animation, HorizontalQuestAdapter horizontalQuestAdapter, ImageView imageView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animation;
        this.MyBillsEntityDataFactory = horizontalQuestAdapter;
        this.getAuthRequestContext = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setAnimationListener(this);
        HorizontalQuestAdapter horizontalQuestAdapter = this.MyBillsEntityDataFactory;
        Observable<Long> observeOn = Observable.timer(2L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        final HorizontalQuestAdapter horizontalQuestAdapter2 = this.MyBillsEntityDataFactory;
        final ImageView imageView = this.getAuthRequestContext;
        final Animation animation = this.KClassImpl$Data$declaredNonStaticMembers$2;
        horizontalQuestAdapter.BuiltInFictitiousFunctionClassFactory = observeOn.subscribe(new Consumer() { // from class: id.dana.promoquest.adapter.HorizontalQuestAdapter$playAnimation$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Long l = (Long) obj;
                HorizontalQuestAdapter$playAnimation$1.MyBillsEntityDataFactory(HorizontalQuestAdapter.this, imageView, animation);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(HorizontalQuestAdapter horizontalQuestAdapter, ImageView imageView, Animation animation) {
        Intrinsics.checkNotNullParameter(horizontalQuestAdapter, "");
        Intrinsics.checkNotNullParameter(imageView, "");
        Intrinsics.checkNotNullExpressionValue(animation, "");
        imageView.startAnimation(animation);
    }
}
