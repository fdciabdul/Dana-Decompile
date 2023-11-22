package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

/* loaded from: classes.dex */
class FragmentAnim {
    private FragmentAnim() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimationOrAnimator BuiltInFictitiousFunctionClassFactory(Context context, Fragment fragment, boolean z, boolean z2) {
        int exitAnim;
        int i;
        int nextTransition = fragment.getNextTransition();
        if (z2) {
            if (z) {
                exitAnim = fragment.getPopEnterAnim();
            } else {
                exitAnim = fragment.getPopExitAnim();
            }
        } else if (z) {
            exitAnim = fragment.getEnterAnim();
        } else {
            exitAnim = fragment.getExitAnim();
        }
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        if (fragment.mContainer != null && fragment.mContainer.getTag(R.id.MyBillsEntityDataFactory) != null) {
            fragment.mContainer.setTag(R.id.MyBillsEntityDataFactory, null);
        }
        if (fragment.mContainer == null || fragment.mContainer.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, exitAnim);
            if (onCreateAnimation != null) {
                return new AnimationOrAnimator(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, exitAnim);
            if (onCreateAnimator != null) {
                return new AnimationOrAnimator(onCreateAnimator);
            }
            if (exitAnim == 0 && nextTransition != 0) {
                if (nextTransition == 4097) {
                    i = z ? R.animator.BuiltInFictitiousFunctionClassFactory : R.animator.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else if (nextTransition == 8194) {
                    i = z ? R.animator.PlaceComponentResult : R.animator.KClassImpl$Data$declaredNonStaticMembers$2;
                } else if (nextTransition != 8197) {
                    if (nextTransition == 4099) {
                        i = z ? R.animator.getAuthRequestContext : R.animator.MyBillsEntityDataFactory;
                    } else if (nextTransition != 4100) {
                        exitAnim = -1;
                    } else if (z) {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842936});
                        exitAnim = obtainStyledAttributes.getResourceId(0, -1);
                        obtainStyledAttributes.recycle();
                    } else {
                        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(16973825, new int[]{16842937});
                        exitAnim = obtainStyledAttributes2.getResourceId(0, -1);
                        obtainStyledAttributes2.recycle();
                    }
                } else if (z) {
                    TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(16973825, new int[]{16842938});
                    exitAnim = obtainStyledAttributes3.getResourceId(0, -1);
                    obtainStyledAttributes3.recycle();
                } else {
                    TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(16973825, new int[]{16842939});
                    exitAnim = obtainStyledAttributes4.getResourceId(0, -1);
                    obtainStyledAttributes4.recycle();
                }
                exitAnim = i;
            }
            if (exitAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(exitAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, exitAnim);
                        if (loadAnimation != null) {
                            return new AnimationOrAnimator(loadAnimation);
                        }
                        z3 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z3) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, exitAnim);
                        if (loadAnimator != null) {
                            return new AnimationOrAnimator(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (equals) {
                            throw e2;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, exitAnim);
                        if (loadAnimation2 != null) {
                            return new AnimationOrAnimator(loadAnimation2);
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes.dex */
    static class AnimationOrAnimator {
        public final Animator BuiltInFictitiousFunctionClassFactory;
        public final Animation KClassImpl$Data$declaredNonStaticMembers$2;

        AnimationOrAnimator(Animation animation) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = animation;
            this.BuiltInFictitiousFunctionClassFactory = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.BuiltInFictitiousFunctionClassFactory = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* loaded from: classes.dex */
    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean BuiltInFictitiousFunctionClassFactory;
        private final View KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;
        private boolean PlaceComponentResult;
        private final ViewGroup getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.getAuthRequestContext = viewGroup;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.PlaceComponentResult) {
                return !this.MyBillsEntityDataFactory;
            }
            if (!super.getTransformation(j, transformation)) {
                this.PlaceComponentResult = true;
                OneShotPreDrawListener.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.PlaceComponentResult) {
                return !this.MyBillsEntityDataFactory;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.PlaceComponentResult = true;
                OneShotPreDrawListener.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory) {
                this.BuiltInFictitiousFunctionClassFactory = false;
                this.getAuthRequestContext.post(this);
                return;
            }
            this.getAuthRequestContext.endViewTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.MyBillsEntityDataFactory = true;
        }
    }
}
