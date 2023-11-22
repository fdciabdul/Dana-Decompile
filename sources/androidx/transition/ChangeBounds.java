package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final Property<ViewBounds, PointF> KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Property<View, PointF> PlaceComponentResult;
    private static final Property<View, PointF> getAuthRequestContext;
    private static final Property<ViewBounds, PointF> scheduleImpl;
    private int[] DatabaseTableConfigUtil;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean moveToNextValue;
    private static final String[] lookAheadTest = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> MyBillsEntityDataFactory = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
        private Rect MyBillsEntityDataFactory = new Rect();

        @Override // android.util.Property
        public /* synthetic */ PointF get(Drawable drawable) {
            drawable.copyBounds(this.MyBillsEntityDataFactory);
            return new PointF(this.MyBillsEntityDataFactory.left, this.MyBillsEntityDataFactory.top);
        }

        @Override // android.util.Property
        public /* synthetic */ void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.MyBillsEntityDataFactory);
            this.MyBillsEntityDataFactory.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.MyBillsEntityDataFactory);
        }
    };
    private static final Property<View, PointF> BuiltInFictitiousFunctionClassFactory = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.ChangeBounds.6
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public /* synthetic */ void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            ViewUtils.getAuthRequestContext(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    };
    private static RectEvaluator getErrorConfigVersion = new RectEvaluator();

    static {
        String str = "topLeft";
        scheduleImpl = new Property<ViewBounds, PointF>(PointF.class, str) { // from class: androidx.transition.ChangeBounds.2
            @Override // android.util.Property
            public /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public /* synthetic */ void set(ViewBounds viewBounds, PointF pointF) {
                ViewBounds viewBounds2 = viewBounds;
                PointF pointF2 = pointF;
                viewBounds2.getAuthRequestContext = Math.round(pointF2.x);
                viewBounds2.MyBillsEntityDataFactory = Math.round(pointF2.y);
                int i = viewBounds2.getErrorConfigVersion + 1;
                viewBounds2.getErrorConfigVersion = i;
                if (i == viewBounds2.KClassImpl$Data$declaredNonStaticMembers$2) {
                    viewBounds2.BuiltInFictitiousFunctionClassFactory();
                }
            }
        };
        String str2 = "bottomRight";
        KClassImpl$Data$declaredNonStaticMembers$2 = new Property<ViewBounds, PointF>(PointF.class, str2) { // from class: androidx.transition.ChangeBounds.3
            @Override // android.util.Property
            public /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            public /* synthetic */ void set(ViewBounds viewBounds, PointF pointF) {
                ViewBounds viewBounds2 = viewBounds;
                PointF pointF2 = pointF;
                viewBounds2.BuiltInFictitiousFunctionClassFactory = Math.round(pointF2.x);
                viewBounds2.PlaceComponentResult = Math.round(pointF2.y);
                int i = viewBounds2.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                viewBounds2.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                if (viewBounds2.getErrorConfigVersion == i) {
                    viewBounds2.BuiltInFictitiousFunctionClassFactory();
                }
            }
        };
        getAuthRequestContext = new Property<View, PointF>(PointF.class, str2) { // from class: androidx.transition.ChangeBounds.4
            @Override // android.util.Property
            public /* bridge */ /* synthetic */ PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public /* synthetic */ void set(View view, PointF pointF) {
                View view2 = view;
                PointF pointF2 = pointF;
                ViewUtils.getAuthRequestContext(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
            }
        };
        PlaceComponentResult = new Property<View, PointF>(PointF.class, str) { // from class: androidx.transition.ChangeBounds.5
            @Override // android.util.Property
            public /* bridge */ /* synthetic */ PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            public /* synthetic */ void set(View view, PointF pointF) {
                View view2 = view;
                PointF pointF2 = pointF;
                ViewUtils.getAuthRequestContext(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
            }
        };
    }

    public ChangeBounds() {
        this.DatabaseTableConfigUtil = new int[2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.moveToNextValue = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DatabaseTableConfigUtil = new int[2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.moveToNextValue = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.BuiltInFictitiousFunctionClassFactory);
        boolean authRequestContext = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return lookAheadTest;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(TransitionValues transitionValues) {
        View view = transitionValues.MyBillsEntityDataFactory;
        if (!ViewCompat.getValueOfTouchPositionAbsolute(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.getAuthRequestContext.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.getAuthRequestContext.put("android:changeBounds:parent", transitionValues.MyBillsEntityDataFactory.getParent());
        if (this.moveToNextValue) {
            transitionValues.MyBillsEntityDataFactory.getLocationInWindow(this.DatabaseTableConfigUtil);
            transitionValues.getAuthRequestContext.put("android:changeBounds:windowX", Integer.valueOf(this.DatabaseTableConfigUtil[0]));
            transitionValues.getAuthRequestContext.put("android:changeBounds:windowY", Integer.valueOf(this.DatabaseTableConfigUtil[1]));
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            transitionValues.getAuthRequestContext.put("android:changeBounds:clip", ViewCompat.scheduleImpl(view));
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        KClassImpl$Data$declaredNonStaticMembers$2(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        KClassImpl$Data$declaredNonStaticMembers$2(transitionValues);
    }

    private boolean MyBillsEntityDataFactory(View view, View view2) {
        if (this.moveToNextValue) {
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
            if (matchedTransitionValues == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == matchedTransitionValues.MyBillsEntityDataFactory) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        final View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator BuiltInFictitiousFunctionClassFactory2;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.getAuthRequestContext;
        Map<String, Object> map2 = transitionValues2.getAuthRequestContext;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = transitionValues2.MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues.getAuthRequestContext.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) transitionValues2.getAuthRequestContext.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            final int i4 = rect3.left;
            int i5 = rect2.top;
            final int i6 = rect3.top;
            int i7 = rect2.right;
            final int i8 = rect3.right;
            int i9 = rect2.bottom;
            final int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) transitionValues.getAuthRequestContext.get("android:changeBounds:clip");
            final Rect rect5 = (Rect) transitionValues2.getAuthRequestContext.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    view = view2;
                    ViewUtils.getAuthRequestContext(view, i3, i5, i7, i9);
                    if (i == 2) {
                        if (i11 == i13 && i12 == i14) {
                            BuiltInFictitiousFunctionClassFactory2 = ObjectAnimatorUtils.getAuthRequestContext(view, BuiltInFictitiousFunctionClassFactory, getPathMotion().getPath(i3, i5, i4, i6));
                        } else {
                            ViewBounds viewBounds = new ViewBounds(view);
                            ObjectAnimator authRequestContext = ObjectAnimatorUtils.getAuthRequestContext(viewBounds, scheduleImpl, getPathMotion().getPath(i3, i5, i4, i6));
                            ObjectAnimator authRequestContext2 = ObjectAnimatorUtils.getAuthRequestContext(viewBounds, KClassImpl$Data$declaredNonStaticMembers$2, getPathMotion().getPath(i7, i9, i8, i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(authRequestContext, authRequestContext2);
                            animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7
                                final /* synthetic */ ViewBounds MyBillsEntityDataFactory;
                                private ViewBounds mViewBounds;

                                {
                                    ChangeBounds.this = this;
                                    this.MyBillsEntityDataFactory = viewBounds;
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            BuiltInFictitiousFunctionClassFactory2 = animatorSet;
                        }
                    } else if (i3 != i4 || i5 != i6) {
                        BuiltInFictitiousFunctionClassFactory2 = ObjectAnimatorUtils.getAuthRequestContext(view, PlaceComponentResult, getPathMotion().getPath(i3, i5, i4, i6));
                    } else {
                        BuiltInFictitiousFunctionClassFactory2 = ObjectAnimatorUtils.getAuthRequestContext(view, getAuthRequestContext, getPathMotion().getPath(i7, i9, i8, i10));
                    }
                } else {
                    view = view2;
                    ViewUtils.getAuthRequestContext(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                    ObjectAnimator authRequestContext3 = (i3 == i4 && i5 == i6) ? null : ObjectAnimatorUtils.getAuthRequestContext(view, BuiltInFictitiousFunctionClassFactory, getPathMotion().getPath(i3, i5, i4, i6));
                    if (rect4 == null) {
                        i2 = 0;
                        rect = new Rect(0, 0, i11, i12);
                    } else {
                        i2 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        ViewCompat.PlaceComponentResult(view, rect);
                        RectEvaluator rectEvaluator = getErrorConfigVersion;
                        Object[] objArr = new Object[2];
                        objArr[i2] = rect;
                        objArr[1] = rect6;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                        ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                            private boolean getErrorConfigVersion;

                            {
                                ChangeBounds.this = this;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                this.getErrorConfigVersion = true;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (this.getErrorConfigVersion) {
                                    return;
                                }
                                ViewCompat.PlaceComponentResult(view, rect5);
                                ViewUtils.getAuthRequestContext(view, i4, i6, i8, i10);
                            }
                        });
                        objectAnimator = ofObject;
                    }
                    BuiltInFictitiousFunctionClassFactory2 = TransitionUtils.BuiltInFictitiousFunctionClassFactory(authRequestContext3, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.MyBillsEntityDataFactory(viewGroup4, true);
                    addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                        boolean getAuthRequestContext = false;

                        {
                            ChangeBounds.this = this;
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionCancel(Transition transition) {
                            ViewGroupUtils.MyBillsEntityDataFactory(viewGroup4, false);
                            this.getAuthRequestContext = true;
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(Transition transition) {
                            if (!this.getAuthRequestContext) {
                                ViewGroupUtils.MyBillsEntityDataFactory(viewGroup4, false);
                            }
                            transition.removeListener(this);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionPause(Transition transition) {
                            ViewGroupUtils.MyBillsEntityDataFactory(viewGroup4, false);
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionResume(Transition transition) {
                            ViewGroupUtils.MyBillsEntityDataFactory(viewGroup4, true);
                        }
                    });
                }
                return BuiltInFictitiousFunctionClassFactory2;
            }
            return null;
        }
        int intValue = ((Integer) transitionValues.getAuthRequestContext.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues.getAuthRequestContext.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues2.getAuthRequestContext.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues2.getAuthRequestContext.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.DatabaseTableConfigUtil);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        final float PlaceComponentResult2 = ViewUtils.PlaceComponentResult(view2);
        ViewUtils.MyBillsEntityDataFactory(view2, 0.0f);
        ViewUtils.getAuthRequestContext(viewGroup).MyBillsEntityDataFactory(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.DatabaseTableConfigUtil;
        int i15 = iArr[0];
        int i16 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, pathMotion.getPath(intValue - i15, intValue2 - i16, intValue3 - i15, intValue4 - i16)));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
            {
                ChangeBounds.this = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewUtils.getAuthRequestContext(viewGroup).getAuthRequestContext(bitmapDrawable);
                ViewUtils.MyBillsEntityDataFactory(view2, PlaceComponentResult2);
            }
        });
        return ofPropertyValuesHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewBounds {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int getErrorConfigVersion;
        private View scheduleImpl;

        ViewBounds(View view) {
            this.scheduleImpl = view;
        }

        final void BuiltInFictitiousFunctionClassFactory() {
            ViewUtils.getAuthRequestContext(this.scheduleImpl, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
            this.getErrorConfigVersion = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
    }
}
