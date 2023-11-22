package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.fullstory.instrumentation.FSDraw;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable, FSDraw {
    private AnimatedStateListState BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private Transition MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private int getAuthRequestContext;

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTint(int i) {
        super.setTint(i);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        PlaceComponentResult(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static AnimatedStateListDrawableCompat BuiltInFictitiousFunctionClassFactory(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            StringBuilder sb = new StringBuilder();
            sb.append(xmlPullParser.getPositionDescription());
            sb.append(": invalid animated-selector tag ");
            sb.append(name);
            throw new XmlPullParserException(sb.toString());
        }
        AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
        animatedStateListDrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, resources, xmlPullParser, attributeSet, theme);
        return animatedStateListDrawableCompat;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2);
        setVisible(authRequestContext.getBoolean(R.styleable.getErrorConfigVersion, true), true);
        getAuthRequestContext(authRequestContext);
        MyBillsEntityDataFactory(resources);
        authRequestContext.recycle();
        PlaceComponentResult(context, resources, xmlPullParser, attributeSet, theme);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Transition transition = this.MyBillsEntityDataFactory;
        if (transition != null && (visible || z2)) {
            if (z) {
                transition.PlaceComponentResult();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.MyBillsEntityDataFactory;
        if (transition != null) {
            transition.KClassImpl$Data$declaredNonStaticMembers$2();
            this.MyBillsEntityDataFactory = null;
            KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            this.getAuthRequestContext = -1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(iArr);
        boolean z = PlaceComponentResult != getAuthRequestContext() && (MyBillsEntityDataFactory(PlaceComponentResult) || KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean MyBillsEntityDataFactory(int i) {
        int authRequestContext;
        int BuiltInFictitiousFunctionClassFactory;
        Transition animatableTransition;
        Transition transition = this.MyBillsEntityDataFactory;
        if (transition != null) {
            if (i == this.getAuthRequestContext) {
                return true;
            }
            if (i == this.KClassImpl$Data$declaredNonStaticMembers$2 && transition.getAuthRequestContext()) {
                transition.MyBillsEntityDataFactory();
                this.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                return true;
            }
            authRequestContext = this.getAuthRequestContext;
            transition.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            authRequestContext = getAuthRequestContext();
        }
        this.MyBillsEntityDataFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.getAuthRequestContext = -1;
        AnimatedStateListState animatedStateListState = this.BuiltInFictitiousFunctionClassFactory;
        int authRequestContext2 = animatedStateListState.getAuthRequestContext(authRequestContext);
        int authRequestContext3 = animatedStateListState.getAuthRequestContext(i);
        if (authRequestContext3 == 0 || authRequestContext2 == 0 || (BuiltInFictitiousFunctionClassFactory = animatedStateListState.BuiltInFictitiousFunctionClassFactory(authRequestContext2, authRequestContext3)) < 0) {
            return false;
        }
        boolean PlaceComponentResult = animatedStateListState.PlaceComponentResult(authRequestContext2, authRequestContext3);
        KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            animatableTransition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext2, authRequestContext3), PlaceComponentResult);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            animatableTransition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                animatableTransition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        animatableTransition.PlaceComponentResult();
        this.MyBillsEntityDataFactory = animatableTransition;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        this.getAuthRequestContext = i;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Transition {
        public abstract void KClassImpl$Data$declaredNonStaticMembers$2();

        public void MyBillsEntityDataFactory() {
        }

        public abstract void PlaceComponentResult();

        public boolean getAuthRequestContext() {
            return false;
        }

        private Transition() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimatableTransition extends Transition {
        private final Animatable MyBillsEntityDataFactory;

        AnimatableTransition(Animatable animatable) {
            super();
            this.MyBillsEntityDataFactory = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void PlaceComponentResult() {
            this.MyBillsEntityDataFactory.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.MyBillsEntityDataFactory.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimationDrawableTransition extends Transition {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        private final ObjectAnimator getAuthRequestContext;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                Compatibility.Api18Impl.PlaceComponentResult(ofInt, true);
            }
            ofInt.setDuration(frameInterpolator.getAuthRequestContext());
            ofInt.setInterpolator(frameInterpolator);
            this.BuiltInFictitiousFunctionClassFactory = z2;
            this.getAuthRequestContext = ofInt;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void PlaceComponentResult() {
            this.getAuthRequestContext.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void MyBillsEntityDataFactory() {
            this.getAuthRequestContext.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.getAuthRequestContext.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat KClassImpl$Data$declaredNonStaticMembers$2;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void PlaceComponentResult() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.stop();
        }
    }

    private void getAuthRequestContext(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.BuiltInFictitiousFunctionClassFactory;
        if (Build.VERSION.SDK_INT >= 21) {
            animatedStateListState.BuiltInFictitiousFunctionClassFactory |= Compatibility.Api21Impl.BuiltInFictitiousFunctionClassFactory(typedArray);
        }
        animatedStateListState.getAuthRequestContext(typedArray.getBoolean(R.styleable.scheduleImpl, animatedStateListState.D));
        animatedStateListState.KClassImpl$Data$declaredNonStaticMembers$2(typedArray.getBoolean(R.styleable.getAuthRequestContext, animatedStateListState.isLayoutRequested));
        animatedStateListState.PlaceComponentResult(typedArray.getInt(R.styleable.PlaceComponentResult, animatedStateListState.NetworkUserEntityData$$ExternalSyntheticLambda5));
        animatedStateListState.MyBillsEntityDataFactory(typedArray.getInt(R.styleable.BuiltInFictitiousFunctionClassFactory, animatedStateListState.NetworkUserEntityData$$ExternalSyntheticLambda4));
        setDither(typedArray.getBoolean(R.styleable.MyBillsEntityDataFactory, animatedStateListState.newProxyInstance));
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        onStateChange(getState());
    }

    private void PlaceComponentResult(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    getAuthRequestContext(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    MyBillsEntityDataFactory(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
    
        if (r4 != 2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r10.getName().equals("animated-vector") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        r4 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory(r8, r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append(r10.getPositionDescription());
        r8.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r4 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (r1 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        if (r3 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
    
        return r7.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(r1, r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0084, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append(r10.getPositionDescription());
        r8.append(": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append(r10.getPositionDescription());
        r8.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b8, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
    
        if (r4 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
    
        r4 = r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r4 == 4) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int MyBillsEntityDataFactory(android.content.Context r8, android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r7 = this;
            int[] r0 = androidx.appcompat.resources.R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2
            android.content.res.TypedArray r0 = androidx.core.content.res.TypedArrayUtils.getAuthRequestContext(r9, r12, r11, r0)
            int r1 = androidx.appcompat.resources.R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1
            r2 = -1
            int r1 = r0.getResourceId(r1, r2)
            int r3 = androidx.appcompat.resources.R.styleable.initRecordTimeStamp
            int r3 = r0.getResourceId(r3, r2)
            int r4 = androidx.appcompat.resources.R.styleable.DatabaseTableConfigUtil
            int r4 = r0.getResourceId(r4, r2)
            if (r4 <= 0) goto L24
            androidx.appcompat.widget.ResourceManagerInternal r5 = androidx.appcompat.widget.ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2()
            android.graphics.drawable.Drawable r4 = r5.BuiltInFictitiousFunctionClassFactory(r8, r4)
            goto L25
        L24:
            r4 = 0
        L25:
            int r5 = androidx.appcompat.resources.R.styleable.GetContactSyncConfig
            r6 = 0
            boolean r5 = r0.getBoolean(r5, r6)
            r0.recycle()
            java.lang.String r0 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r4 != 0) goto L77
        L33:
            int r4 = r10.next()
            r6 = 4
            if (r4 == r6) goto L33
            r6 = 2
            if (r4 != r6) goto L5e
            java.lang.String r4 = r10.getName()
            java.lang.String r6 = "animated-vector"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L4e
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r4 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory(r8, r9, r10, r11, r12)
            goto L77
        L4e:
            int r8 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r8 < r4) goto L59
            android.graphics.drawable.Drawable r4 = androidx.appcompat.resources.Compatibility.Api21Impl.KClassImpl$Data$declaredNonStaticMembers$2(r9, r10, r11, r12)
            goto L77
        L59:
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r9, r10, r11)
            goto L77
        L5e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r10.getPositionDescription()
            r8.append(r9)
            r8.append(r0)
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L77:
            if (r4 == 0) goto L9f
            if (r1 == r2) goto L84
            if (r3 == r2) goto L84
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r8 = r7.BuiltInFictitiousFunctionClassFactory
            int r8 = r8.MyBillsEntityDataFactory(r1, r3, r4, r5)
            return r8
        L84:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r10.getPositionDescription()
            r8.append(r9)
            java.lang.String r9 = ": <transition> tag requires 'fromId' & 'toId' attributes"
            r8.append(r9)
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        L9f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r10.getPositionDescription()
            r8.append(r9)
            r8.append(r0)
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            goto Lb9
        Lb8:
            throw r9
        Lb9:
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.MyBillsEntityDataFactory(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if (r5 != 2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r7.getName().equals("vector") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        r5 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.BuiltInFictitiousFunctionClassFactory(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append(r7.getPositionDescription());
        r5.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r5 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        return r4.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(r0, r5, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append(r7.getPositionDescription());
        r5.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        if (r5 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        r5 = r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        if (r5 == 4) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getAuthRequestContext(android.content.Context r5, android.content.res.Resources r6, org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, android.content.res.Resources.Theme r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int[] r0 = androidx.appcompat.resources.R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0
            android.content.res.TypedArray r0 = androidx.core.content.res.TypedArrayUtils.getAuthRequestContext(r6, r9, r8, r0)
            int r1 = androidx.appcompat.resources.R.styleable.lookAheadTest
            r2 = 0
            int r1 = r0.getResourceId(r1, r2)
            int r2 = androidx.appcompat.resources.R.styleable.moveToNextValue
            r3 = -1
            int r2 = r0.getResourceId(r2, r3)
            if (r2 <= 0) goto L1f
            androidx.appcompat.widget.ResourceManagerInternal r3 = androidx.appcompat.widget.ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2()
            android.graphics.drawable.Drawable r5 = r3.BuiltInFictitiousFunctionClassFactory(r5, r2)
            goto L20
        L1f:
            r5 = 0
        L20:
            r0.recycle()
            int[] r0 = r4.BuiltInFictitiousFunctionClassFactory(r8)
            java.lang.String r2 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r5 != 0) goto L6f
        L2b:
            int r5 = r7.next()
            r3 = 4
            if (r5 == r3) goto L2b
            r3 = 2
            if (r5 != r3) goto L56
            java.lang.String r5 = r7.getName()
            java.lang.String r3 = "vector"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L46
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r5 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.BuiltInFictitiousFunctionClassFactory(r6, r7, r8, r9)
            goto L6f
        L46:
            int r5 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r5 < r3) goto L51
            android.graphics.drawable.Drawable r5 = androidx.appcompat.resources.Compatibility.Api21Impl.KClassImpl$Data$declaredNonStaticMembers$2(r6, r7, r8, r9)
            goto L6f
        L51:
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromXmlInner(r6, r7, r8)
            goto L6f
        L56:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r7.getPositionDescription()
            r5.append(r6)
            r5.append(r2)
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L6f:
            if (r5 == 0) goto L78
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r6 = r4.BuiltInFictitiousFunctionClassFactory
            int r5 = r6.KClassImpl$Data$declaredNonStaticMembers$2(r0, r5, r1)
            return r5
        L78:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r7.getPositionDescription()
            r5.append(r6)
            r5.append(r2)
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            goto L92
        L91:
            throw r6
        L92:
            goto L91
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.getAuthRequestContext(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):int");
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.PlaceComponentResult && super.mutate() == this) {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            this.PlaceComponentResult = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public AnimatedStateListState BuiltInFictitiousFunctionClassFactory() {
        return new AnimatedStateListState(this.BuiltInFictitiousFunctionClassFactory, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimatedStateListState extends StateListDrawable.StateListState {
        LongSparseArray<Long> PlaceComponentResult;
        SparseArrayCompat<Integer> getAuthRequestContext;

        private static long getErrorConfigVersion(int i, int i2) {
            return i2 | (i << 32);
        }

        AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.PlaceComponentResult = animatedStateListState.PlaceComponentResult;
                this.getAuthRequestContext = animatedStateListState.getAuthRequestContext;
                return;
            }
            this.PlaceComponentResult = new LongSparseArray<>();
            this.getAuthRequestContext = new SparseArrayCompat<>();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.PlaceComponentResult = this.PlaceComponentResult.clone();
            this.getAuthRequestContext = this.getAuthRequestContext.clone();
        }

        int MyBillsEntityDataFactory(int i, int i2, Drawable drawable, boolean z) {
            int PlaceComponentResult = super.PlaceComponentResult(drawable);
            long errorConfigVersion = getErrorConfigVersion(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = PlaceComponentResult;
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion, Long.valueOf(j2 | j));
            if (z) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return PlaceComponentResult;
        }

        int KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr, Drawable drawable, int i) {
            int authRequestContext = super.getAuthRequestContext(iArr, drawable);
            this.getAuthRequestContext.PlaceComponentResult(authRequestContext, Integer.valueOf(i));
            return authRequestContext;
        }

        int PlaceComponentResult(int[] iArr) {
            int MyBillsEntityDataFactory = super.MyBillsEntityDataFactory(iArr);
            return MyBillsEntityDataFactory >= 0 ? MyBillsEntityDataFactory : super.MyBillsEntityDataFactory(StateSet.WILD_CARD);
        }

        int getAuthRequestContext(int i) {
            if (i < 0) {
                return 0;
            }
            return this.getAuthRequestContext.getAuthRequestContext(i, 0).intValue();
        }

        int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            return (int) this.PlaceComponentResult.MyBillsEntityDataFactory(getErrorConfigVersion(i, i2), -1L).longValue();
        }

        boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            return (this.PlaceComponentResult.MyBillsEntityDataFactory(getErrorConfigVersion(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        boolean PlaceComponentResult(int i, int i2) {
            return (this.PlaceComponentResult.MyBillsEntityDataFactory(getErrorConfigVersion(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void PlaceComponentResult(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.PlaceComponentResult(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.BuiltInFictitiousFunctionClassFactory = (AnimatedStateListState) drawableContainerState;
        }
    }

    /* loaded from: classes.dex */
    static class FrameInterpolator implements TimeInterpolator {
        private int MyBillsEntityDataFactory;
        private int[] PlaceComponentResult;
        private int getAuthRequestContext;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            getAuthRequestContext(animationDrawable, z);
        }

        int getAuthRequestContext(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.MyBillsEntityDataFactory = numberOfFrames;
            int[] iArr = this.PlaceComponentResult;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.PlaceComponentResult = new int[numberOfFrames];
            }
            int[] iArr2 = this.PlaceComponentResult;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.getAuthRequestContext = i;
            return i;
        }

        int getAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.getAuthRequestContext) + 0.5f);
            int i2 = this.MyBillsEntityDataFactory;
            int[] iArr = this.PlaceComponentResult;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                if (i < i4) {
                    break;
                }
                i -= i4;
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.getAuthRequestContext : 0.0f);
        }
    }
}
