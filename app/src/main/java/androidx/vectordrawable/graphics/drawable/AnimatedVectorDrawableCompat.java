package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.fullstory.instrumentation.FSDraw;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat, FSDraw {
    ArrayList<Animatable2Compat.AnimationCallback> KClassImpl$Data$declaredNonStaticMembers$2;
    final Drawable.Callback MyBillsEntityDataFactory;
    private AnimatedVectorDrawableCompatState PlaceComponentResult;
    private Animator.AnimatorListener getAuthRequestContext;
    private Context moveToNextValue;
    private android.animation.ArgbEvaluator scheduleImpl;

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.scheduleImpl = null;
        this.getAuthRequestContext = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        Drawable.Callback callback = new Drawable.Callback() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.MyBillsEntityDataFactory = callback;
        this.moveToNextValue = context;
        if (animatedVectorDrawableCompatState != null) {
            this.PlaceComponentResult = animatedVectorDrawableCompatState;
        } else {
            this.PlaceComponentResult = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, callback, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.mutate();
        }
        return this;
    }

    public static AnimatedVectorDrawableCompat BuiltInFictitiousFunctionClassFactory(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.BuiltInFictitiousFunctionClassFactory == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.BuiltInFictitiousFunctionClassFactory.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.PlaceComponentResult.PlaceComponentResult;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.draw(canvas);
            return;
        }
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.draw(canvas);
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.setBounds(rect);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.setState(iArr);
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setState(iArr);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.setLevel(i);
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.setAlpha(i);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.setColorFilter(colorFilter);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, i);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, colorStateList);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, mode);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.setVisible(z, z2);
        }
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.isStateful();
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getOpacity();
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getIntrinsicWidth();
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return this.BuiltInFictitiousFunctionClassFactory.getIntrinsicHeight();
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, z);
        } else {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth();
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth + 1 || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, AndroidResources.MyBillsEntityDataFactory);
                    int resourceId = authRequestContext.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat MyBillsEntityDataFactory = VectorDrawableCompat.MyBillsEntityDataFactory(resources, resourceId, theme);
                        MyBillsEntityDataFactory.PlaceComponentResult(false);
                        MyBillsEntityDataFactory.setCallback(this.MyBillsEntityDataFactory);
                        if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != null) {
                            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setCallback(null);
                        }
                        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
                    }
                    authRequestContext.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.getAuthRequestContext);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.moveToNextValue;
                        if (context != null) {
                            getAuthRequestContext(string, AnimatorInflaterCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            DrawableCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return DrawableCompat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    /* loaded from: classes.dex */
    static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState getAuthRequestContext;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.getAuthRequestContext = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.newDrawable();
            animatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory.setCallback(animatedVectorDrawableCompat.MyBillsEntityDataFactory);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.newDrawable(resources);
            animatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory.setCallback(animatedVectorDrawableCompat.MyBillsEntityDataFactory);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.newDrawable(resources, theme);
            animatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory.setCallback(animatedVectorDrawableCompat.MyBillsEntityDataFactory);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.getAuthRequestContext.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.getAuthRequestContext.getChangingConfigurations();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        VectorDrawableCompat BuiltInFictitiousFunctionClassFactory;
        AnimatorSet KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayMap<Animator, String> MyBillsEntityDataFactory;
        int PlaceComponentResult;
        ArrayList<Animator> getAuthRequestContext;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.PlaceComponentResult = animatedVectorDrawableCompatState.PlaceComponentResult;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.BuiltInFictitiousFunctionClassFactory;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.BuiltInFictitiousFunctionClassFactory = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.BuiltInFictitiousFunctionClassFactory.mutate();
                    this.BuiltInFictitiousFunctionClassFactory = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.BuiltInFictitiousFunctionClassFactory.setBounds(animatedVectorDrawableCompatState.BuiltInFictitiousFunctionClassFactory.getBounds());
                    this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false);
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.getAuthRequestContext;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.getAuthRequestContext = new ArrayList<>(size);
                    this.MyBillsEntityDataFactory = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = animatedVectorDrawableCompatState.getAuthRequestContext.get(i);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableCompatState.MyBillsEntityDataFactory.get(animator);
                        clone.setTarget(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(str));
                        this.getAuthRequestContext.add(clone);
                        this.MyBillsEntityDataFactory.put(clone, str);
                    }
                    BuiltInFictitiousFunctionClassFactory();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.PlaceComponentResult;
        }

        public void BuiltInFictitiousFunctionClassFactory() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new AnimatorSet();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.playTogether(this.getAuthRequestContext);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                BuiltInFictitiousFunctionClassFactory(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.scheduleImpl == null) {
                    this.scheduleImpl = new android.animation.ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.scheduleImpl);
            }
        }
    }

    private void getAuthRequestContext(String str, Animator animator) {
        animator.setTarget(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(str));
        if (Build.VERSION.SDK_INT < 21) {
            BuiltInFictitiousFunctionClassFactory(animator);
        }
        if (this.PlaceComponentResult.getAuthRequestContext == null) {
            this.PlaceComponentResult.getAuthRequestContext = new ArrayList<>();
            this.PlaceComponentResult.MyBillsEntityDataFactory = new ArrayMap<>();
        }
        this.PlaceComponentResult.getAuthRequestContext.add(animator);
        this.PlaceComponentResult.MyBillsEntityDataFactory.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            return ((AnimatedVectorDrawable) this.BuiltInFictitiousFunctionClassFactory).isRunning();
        }
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            ((AnimatedVectorDrawable) this.BuiltInFictitiousFunctionClassFactory).start();
        } else if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.isStarted()) {
        } else {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            ((AnimatedVectorDrawable) this.BuiltInFictitiousFunctionClassFactory).stop();
        } else {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.end();
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatedVectorDrawableCompat MyBillsEntityDataFactory;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationStart(this.MyBillsEntityDataFactory);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationEnd(this.MyBillsEntityDataFactory);
            }
        }
    }
}
