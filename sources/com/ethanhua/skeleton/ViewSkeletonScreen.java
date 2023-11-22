package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* loaded from: classes.dex */
public class ViewSkeletonScreen implements SkeletonScreen {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "com.ethanhua.skeleton.ViewSkeletonScreen";
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final int MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final View PlaceComponentResult;
    private final int getAuthRequestContext;
    private final ViewReplacer lookAheadTest;
    private final int moveToNextValue;

    public /* synthetic */ ViewSkeletonScreen(Builder builder, byte b) {
        this(builder);
    }

    private ViewSkeletonScreen(Builder builder) {
        this.PlaceComponentResult = builder.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.moveToNextValue = builder.PlaceComponentResult;
        this.getAuthRequestContext = builder.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory;
        this.lookAheadTest = new ViewReplacer(builder.lookAheadTest);
    }

    @Override // com.ethanhua.skeleton.SkeletonScreen
    public final void PlaceComponentResult() {
        if (this.lookAheadTest.scheduleImpl instanceof ShimmerLayout) {
            ((ShimmerLayout) this.lookAheadTest.scheduleImpl).stopShimmerAnimation();
        }
        ViewReplacer viewReplacer = this.lookAheadTest;
        ViewGroup viewGroup = viewReplacer.BuiltInFictitiousFunctionClassFactory;
        if (viewGroup != null) {
            viewGroup.removeView(viewReplacer.PlaceComponentResult);
            viewReplacer.BuiltInFictitiousFunctionClassFactory.addView(viewReplacer.KClassImpl$Data$declaredNonStaticMembers$2, viewReplacer.MyBillsEntityDataFactory, viewReplacer.lookAheadTest);
            viewReplacer.PlaceComponentResult = viewReplacer.KClassImpl$Data$declaredNonStaticMembers$2;
            viewReplacer.scheduleImpl = null;
            viewReplacer.getErrorConfigVersion = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public int MyBillsEntityDataFactory;
        public int getAuthRequestContext;
        public final View lookAheadTest;
        public boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
        public int PlaceComponentResult = 1000;
        public int BuiltInFictitiousFunctionClassFactory = 20;

        public Builder(View view) {
            this.lookAheadTest = view;
            this.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), R.color.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // com.ethanhua.skeleton.SkeletonScreen
    public final void MyBillsEntityDataFactory() {
        ShimmerLayout shimmerLayout;
        ViewParent parent = this.PlaceComponentResult.getParent();
        if (parent == null) {
            InstrumentInjector.log_e(KClassImpl$Data$declaredNonStaticMembers$2, "the source view have not attach to any view");
            shimmerLayout = null;
        } else {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                shimmerLayout = LayoutInflater.from(this.PlaceComponentResult.getContext()).inflate(this.NetworkUserEntityData$$ExternalSyntheticLambda0, viewGroup, false);
            } else {
                final ShimmerLayout shimmerLayout2 = (ShimmerLayout) LayoutInflater.from(this.PlaceComponentResult.getContext()).inflate(R.layout.layout_shimmer, viewGroup, false);
                shimmerLayout2.setShimmerColor(this.MyBillsEntityDataFactory);
                shimmerLayout2.setShimmerAngle(this.getAuthRequestContext);
                shimmerLayout2.setShimmerAnimationDuration(this.moveToNextValue);
                View inflate = LayoutInflater.from(this.PlaceComponentResult.getContext()).inflate(this.NetworkUserEntityData$$ExternalSyntheticLambda0, (ViewGroup) shimmerLayout2, false);
                ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                if (layoutParams != null) {
                    shimmerLayout2.setLayoutParams(layoutParams);
                }
                shimmerLayout2.addView(inflate);
                shimmerLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.ethanhua.skeleton.ViewSkeletonScreen.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        shimmerLayout2.startShimmerAnimation();
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        shimmerLayout2.stopShimmerAnimation();
                    }
                });
                shimmerLayout2.startShimmerAnimation();
                shimmerLayout = shimmerLayout2;
            }
        }
        if (shimmerLayout != null) {
            ViewReplacer viewReplacer = this.lookAheadTest;
            if (viewReplacer.PlaceComponentResult != shimmerLayout) {
                if (shimmerLayout.getParent() != null) {
                    ((ViewGroup) shimmerLayout.getParent()).removeView(shimmerLayout);
                }
                if (viewReplacer.PlaceComponentResult()) {
                    viewReplacer.scheduleImpl = shimmerLayout;
                    viewReplacer.BuiltInFictitiousFunctionClassFactory.removeView(viewReplacer.PlaceComponentResult);
                    viewReplacer.scheduleImpl.setId(viewReplacer.getAuthRequestContext);
                    viewReplacer.BuiltInFictitiousFunctionClassFactory.addView(viewReplacer.scheduleImpl, viewReplacer.MyBillsEntityDataFactory, viewReplacer.lookAheadTest);
                    viewReplacer.PlaceComponentResult = viewReplacer.scheduleImpl;
                }
            }
        }
    }
}
