package id.dana.core.ui.scrollanimation;

import android.view.View;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "MyBillsEntityDataFactory", "Landroidx/dynamicanimation/animation/SpringAnimation;", "getTranslationY", "()Landroidx/dynamicanimation/animation/SpringAnimation;", "translationY", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class BaseSpringAnimationViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SpringAnimation translationY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSpringAnimationViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "");
        SpringAnimation springAnimation = new SpringAnimation(view, SpringAnimation.getErrorConfigVersion);
        SpringForce springForce = new SpringForce();
        springForce.PlaceComponentResult = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        springForce.getAuthRequestContext = 0.5d;
        springForce.MyBillsEntityDataFactory = false;
        springAnimation.NetworkUserEntityData$$ExternalSyntheticLambda6 = springForce.KClassImpl$Data$declaredNonStaticMembers$2(1500.0f);
        Intrinsics.checkNotNullExpressionValue(springAnimation, "");
        this.translationY = springAnimation;
    }

    @JvmName(name = "getTranslationY")
    public final SpringAnimation getTranslationY() {
        return this.translationY;
    }
}
