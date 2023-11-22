package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ResourceManagerInternal {
    private static ResourceManagerInternal BuiltInFictitiousFunctionClassFactory;
    private static final PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$2 = PorterDuff.Mode.SRC_IN;
    private static final ColorFilterLruCache getAuthRequestContext = new ColorFilterLruCache();
    ResourceManagerHooks MyBillsEntityDataFactory;
    private SparseArrayCompat<String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> PlaceComponentResult = new WeakHashMap<>(0);
    private SimpleArrayMap<String, InflateDelegate> getErrorConfigVersion;
    private TypedValue lookAheadTest;
    private boolean moveToNextValue;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface InflateDelegate {
        Drawable MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
        PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$2(int i);

        Drawable KClassImpl$Data$declaredNonStaticMembers$2(ResourceManagerInternal resourceManagerInternal, Context context, int i);

        ColorStateList PlaceComponentResult(Context context, int i);

        boolean PlaceComponentResult(Context context, int i, Drawable drawable);

        boolean getAuthRequestContext(Context context, int i, Drawable drawable);
    }

    public static ResourceManagerInternal KClassImpl$Data$declaredNonStaticMembers$2() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                BuiltInFictitiousFunctionClassFactory = resourceManagerInternal2;
                if (Build.VERSION.SDK_INT < 24) {
                    VdcInflateDelegate vdcInflateDelegate = new VdcInflateDelegate();
                    if (resourceManagerInternal2.getErrorConfigVersion == null) {
                        resourceManagerInternal2.getErrorConfigVersion = new SimpleArrayMap<>();
                    }
                    resourceManagerInternal2.getErrorConfigVersion.put("vector", vdcInflateDelegate);
                    AvdcInflateDelegate avdcInflateDelegate = new AvdcInflateDelegate();
                    if (resourceManagerInternal2.getErrorConfigVersion == null) {
                        resourceManagerInternal2.getErrorConfigVersion = new SimpleArrayMap<>();
                    }
                    resourceManagerInternal2.getErrorConfigVersion.put("animated-vector", avdcInflateDelegate);
                    AsldcInflateDelegate asldcInflateDelegate = new AsldcInflateDelegate();
                    if (resourceManagerInternal2.getErrorConfigVersion == null) {
                        resourceManagerInternal2.getErrorConfigVersion = new SimpleArrayMap<>();
                    }
                    resourceManagerInternal2.getErrorConfigVersion.put("animated-selector", asldcInflateDelegate);
                    DrawableDelegate drawableDelegate = new DrawableDelegate();
                    if (resourceManagerInternal2.getErrorConfigVersion == null) {
                        resourceManagerInternal2.getErrorConfigVersion = new SimpleArrayMap<>();
                    }
                    resourceManagerInternal2.getErrorConfigVersion.put("drawable", drawableDelegate);
                }
            }
            resourceManagerInternal = BuiltInFictitiousFunctionClassFactory;
        }
        return resourceManagerInternal;
    }

    public final Drawable BuiltInFictitiousFunctionClassFactory(Context context, int i) {
        Drawable PlaceComponentResult;
        synchronized (this) {
            PlaceComponentResult = PlaceComponentResult(context, i, false);
        }
        return PlaceComponentResult;
    }

    private Drawable getAuthRequestContext(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, i);
        if (MyBillsEntityDataFactory != null) {
            if (DrawableUtils.BuiltInFictitiousFunctionClassFactory(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable scheduleImpl = DrawableCompat.scheduleImpl(drawable);
            DrawableCompat.PlaceComponentResult(scheduleImpl, MyBillsEntityDataFactory);
            ResourceManagerHooks resourceManagerHooks = this.MyBillsEntityDataFactory;
            PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$22 = resourceManagerHooks != null ? resourceManagerHooks.KClassImpl$Data$declaredNonStaticMembers$2(i) : null;
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$22);
                return scheduleImpl;
            }
            return scheduleImpl;
        }
        ResourceManagerHooks resourceManagerHooks2 = this.MyBillsEntityDataFactory;
        if ((resourceManagerHooks2 == null || !resourceManagerHooks2.getAuthRequestContext(context, i, drawable)) && !MyBillsEntityDataFactory(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    private Drawable getAuthRequestContext(Context context, int i) {
        int next;
        SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.getErrorConfigVersion;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (sparseArrayCompat != null) {
            String BuiltInFictitiousFunctionClassFactory2 = sparseArrayCompat.BuiltInFictitiousFunctionClassFactory(i);
            if ("appcompat_skip_skip".equals(BuiltInFictitiousFunctionClassFactory2) || (BuiltInFictitiousFunctionClassFactory2 != null && this.getErrorConfigVersion.get(BuiltInFictitiousFunctionClassFactory2) == null)) {
                return null;
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SparseArrayCompat<>();
        }
        if (this.lookAheadTest == null) {
            this.lookAheadTest = new TypedValue();
        }
        TypedValue typedValue = this.lookAheadTest;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, j);
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(i, name);
                InflateDelegate inflateDelegate = this.getErrorConfigVersion.get(name);
                if (inflateDelegate != null) {
                    MyBillsEntityDataFactory = inflateDelegate.MyBillsEntityDataFactory(context, xml, asAttributeSet, context.getTheme());
                }
                if (MyBillsEntityDataFactory != null) {
                    MyBillsEntityDataFactory.setChangingConfigurations(typedValue.changingConfigurations);
                    MyBillsEntityDataFactory(context, j, MyBillsEntityDataFactory);
                }
            } catch (Exception e) {
                InstrumentInjector.log_e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (MyBillsEntityDataFactory == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(i, "appcompat_skip_skip");
        }
        return MyBillsEntityDataFactory;
    }

    private Drawable MyBillsEntityDataFactory(Context context, long j) {
        synchronized (this) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.PlaceComponentResult.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> MyBillsEntityDataFactory = longSparseArray.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory != null) {
                Drawable.ConstantState constantState = MyBillsEntityDataFactory.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.PlaceComponentResult(j);
            }
            return null;
        }
    }

    private boolean MyBillsEntityDataFactory(Context context, long j, Drawable drawable) {
        synchronized (this) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.PlaceComponentResult.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray<>();
                    this.PlaceComponentResult.put(context, longSparseArray);
                }
                longSparseArray.getAuthRequestContext(j, new WeakReference<>(constantState));
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable KClassImpl$Data$declaredNonStaticMembers$2(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        synchronized (this) {
            Drawable authRequestContext = getAuthRequestContext(context, i);
            if (authRequestContext == null) {
                authRequestContext = vectorEnabledTintResources.getAuthRequestContext(i);
            }
            if (authRequestContext != null) {
                return getAuthRequestContext(context, i, false, authRequestContext);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory(Context context, int i, Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.MyBillsEntityDataFactory;
        return resourceManagerHooks != null && resourceManagerHooks.PlaceComponentResult(context, i, drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache() {
            super(6);
        }

        static int getAuthRequestContext(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (DrawableUtils.BuiltInFictitiousFunctionClassFactory(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                InstrumentInjector.log_d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        if (tintInfo.PlaceComponentResult || tintInfo.MyBillsEntityDataFactory) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = tintInfo.PlaceComponentResult ? tintInfo.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            PorterDuff.Mode mode = tintInfo.MyBillsEntityDataFactory ? tintInfo.getAuthRequestContext : KClassImpl$Data$declaredNonStaticMembers$2;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = PlaceComponentResult(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static PorterDuffColorFilter PlaceComponentResult(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = getAuthRequestContext;
            porterDuffColorFilter = colorFilterLruCache.get(Integer.valueOf(ColorFilterLruCache.getAuthRequestContext(i, mode)));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                colorFilterLruCache.put(Integer.valueOf(ColorFilterLruCache.getAuthRequestContext(i, mode)), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    private static boolean MyBillsEntityDataFactory(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public final Drawable MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.BuiltInFictitiousFunctionClassFactory(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                InstrumentInjector.log_e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public final Drawable MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.BuiltInFictitiousFunctionClassFactory(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                InstrumentInjector.log_e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public final Drawable MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.BuiltInFictitiousFunctionClassFactory(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                InstrumentInjector.log_e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public final Drawable MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e) {
                    InstrumentInjector.log_e("DrawableDelegate", "Exception while inflating <drawable>", e);
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable PlaceComponentResult(Context context, int i, boolean z) {
        Drawable authRequestContext;
        synchronized (this) {
            if (!this.moveToNextValue) {
                this.moveToNextValue = true;
                Drawable BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context, R.drawable.PlaceComponentResult);
                if (BuiltInFictitiousFunctionClassFactory2 == null || !MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2)) {
                    this.moveToNextValue = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            authRequestContext = getAuthRequestContext(context, i);
            if (authRequestContext == null) {
                if (this.lookAheadTest == null) {
                    this.lookAheadTest = new TypedValue();
                }
                TypedValue typedValue = this.lookAheadTest;
                context.getResources().getValue(i, typedValue, true);
                long j = (typedValue.assetCookie << 32) | typedValue.data;
                Drawable MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, j);
                if (MyBillsEntityDataFactory == null) {
                    ResourceManagerHooks resourceManagerHooks = this.MyBillsEntityDataFactory;
                    MyBillsEntityDataFactory = resourceManagerHooks == null ? null : resourceManagerHooks.KClassImpl$Data$declaredNonStaticMembers$2(this, context, i);
                    if (MyBillsEntityDataFactory != null) {
                        MyBillsEntityDataFactory.setChangingConfigurations(typedValue.changingConfigurations);
                        MyBillsEntityDataFactory(context, j, MyBillsEntityDataFactory);
                    }
                }
                authRequestContext = MyBillsEntityDataFactory;
            }
            if (authRequestContext == null) {
                authRequestContext = ContextCompat.PlaceComponentResult(context, i);
            }
            if (authRequestContext != null) {
                authRequestContext = getAuthRequestContext(context, i, z, authRequestContext);
            }
            if (authRequestContext != null) {
                DrawableUtils.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            }
        }
        return authRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ColorStateList MyBillsEntityDataFactory(Context context, int i) {
        ColorStateList BuiltInFictitiousFunctionClassFactory2;
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        synchronized (this) {
            WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.scheduleImpl;
            ColorStateList colorStateList = null;
            BuiltInFictitiousFunctionClassFactory2 = (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) ? null : sparseArrayCompat.BuiltInFictitiousFunctionClassFactory(i);
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                ResourceManagerHooks resourceManagerHooks = this.MyBillsEntityDataFactory;
                if (resourceManagerHooks != null) {
                    colorStateList = resourceManagerHooks.PlaceComponentResult(context, i);
                }
                if (colorStateList != null) {
                    if (this.scheduleImpl == null) {
                        this.scheduleImpl = new WeakHashMap<>();
                    }
                    SparseArrayCompat<ColorStateList> sparseArrayCompat2 = this.scheduleImpl.get(context);
                    if (sparseArrayCompat2 == null) {
                        sparseArrayCompat2 = new SparseArrayCompat<>();
                        this.scheduleImpl.put(context, sparseArrayCompat2);
                    }
                    sparseArrayCompat2.MyBillsEntityDataFactory(i, colorStateList);
                }
                BuiltInFictitiousFunctionClassFactory2 = colorStateList;
            }
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }
}
