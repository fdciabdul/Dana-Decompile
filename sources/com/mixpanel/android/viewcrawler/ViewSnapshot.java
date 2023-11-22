package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.ResourceIds;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class ViewSnapshot {
    private final List<PropertyDescription> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MPConfig PlaceComponentResult;
    private final ResourceIds moveToNextValue;
    final Handler BuiltInFictitiousFunctionClassFactory = new Handler(Looper.getMainLooper());
    final RootViewFinder MyBillsEntityDataFactory = new RootViewFinder();
    private final ClassNameCache getAuthRequestContext = new ClassNameCache();

    /* loaded from: classes.dex */
    static class CachedBitmap {
        final Paint MyBillsEntityDataFactory = new Paint(2);
        Bitmap PlaceComponentResult = null;
    }

    public ViewSnapshot(Context context, List<PropertyDescription> list, ResourceIds resourceIds) {
        this.PlaceComponentResult = MPConfig.getAuthRequestContext(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.moveToNextValue = resourceIds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(JsonWriter jsonWriter, View view) throws IOException {
        float f;
        if (view.getVisibility() == 4 && this.PlaceComponentResult.lookAheadTest()) {
            return;
        }
        int id2 = view.getId();
        String BuiltInFictitiousFunctionClassFactory = -1 == id2 ? null : this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(id2);
        jsonWriter.beginObject();
        jsonWriter.name("hashCode").value(view.hashCode());
        jsonWriter.name("id").value(id2);
        jsonWriter.name("mp_id_name").value(BuiltInFictitiousFunctionClassFactory);
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null) {
            jsonWriter.name("contentDescription").nullValue();
        } else {
            jsonWriter.name("contentDescription").value(contentDescription.toString());
        }
        Object tag = view.getTag();
        if (tag == null) {
            jsonWriter.name("tag").nullValue();
        } else if (tag instanceof CharSequence) {
            jsonWriter.name("tag").value(tag.toString());
        }
        jsonWriter.name("top").value(view.getTop());
        jsonWriter.name("left").value(view.getLeft());
        jsonWriter.name(ZebraData.ATTR_WIDTH).value(view.getWidth());
        jsonWriter.name(ZebraData.ATTR_HEIGHT).value(view.getHeight());
        jsonWriter.name("scrollX").value(view.getScrollX());
        jsonWriter.name("scrollY").value(view.getScrollY());
        jsonWriter.name("visibility").value(view.getVisibility());
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT >= 11) {
            f2 = view.getTranslationX();
            f = view.getTranslationY();
        } else {
            f = 0.0f;
        }
        jsonWriter.name("translationX").value(f2);
        jsonWriter.name("translationY").value(f);
        jsonWriter.name("classes");
        jsonWriter.beginArray();
        Class<?> cls = view.getClass();
        do {
            jsonWriter.value(this.getAuthRequestContext.get(cls));
            cls = cls.getSuperclass();
            if (cls == Object.class) {
                break;
            }
        } while (cls != null);
        jsonWriter.endArray();
        PlaceComponentResult(jsonWriter, view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
            jsonWriter.name("layoutRules");
            jsonWriter.beginArray();
            for (int i : rules) {
                jsonWriter.value(i);
            }
            jsonWriter.endArray();
        }
        jsonWriter.name("subviews");
        jsonWriter.beginArray();
        boolean z = view instanceof ViewGroup;
        if (z) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) != null) {
                    jsonWriter.value(r5.hashCode());
                }
            }
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
        if (z) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                View childAt = viewGroup2.getChildAt(i3);
                if (childAt != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2(jsonWriter, childAt);
                }
            }
        }
    }

    private void PlaceComponentResult(JsonWriter jsonWriter, View view) throws IOException {
        Class<?> cls = view.getClass();
        for (PropertyDescription propertyDescription : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (propertyDescription.PlaceComponentResult.isAssignableFrom(cls) && propertyDescription.BuiltInFictitiousFunctionClassFactory != null) {
                Caller caller = propertyDescription.BuiltInFictitiousFunctionClassFactory;
                Object MyBillsEntityDataFactory = caller.MyBillsEntityDataFactory(view, caller.BuiltInFictitiousFunctionClassFactory);
                if (MyBillsEntityDataFactory != null) {
                    if (MyBillsEntityDataFactory instanceof Number) {
                        jsonWriter.name(propertyDescription.MyBillsEntityDataFactory).value((Number) MyBillsEntityDataFactory);
                    } else if (MyBillsEntityDataFactory instanceof Boolean) {
                        jsonWriter.name(propertyDescription.MyBillsEntityDataFactory).value(((Boolean) MyBillsEntityDataFactory).booleanValue());
                    } else if (MyBillsEntityDataFactory instanceof ColorStateList) {
                        jsonWriter.name(propertyDescription.MyBillsEntityDataFactory).value(Integer.valueOf(((ColorStateList) MyBillsEntityDataFactory).getDefaultColor()));
                    } else if (MyBillsEntityDataFactory instanceof Drawable) {
                        Drawable drawable = (Drawable) MyBillsEntityDataFactory;
                        Rect bounds = drawable.getBounds();
                        jsonWriter.name(propertyDescription.MyBillsEntityDataFactory);
                        jsonWriter.beginObject();
                        jsonWriter.name("classes");
                        jsonWriter.beginArray();
                        for (Class<?> cls2 = drawable.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                            jsonWriter.value(cls2.getCanonicalName());
                        }
                        jsonWriter.endArray();
                        jsonWriter.name("dimensions");
                        jsonWriter.beginObject();
                        jsonWriter.name("left").value(bounds.left);
                        jsonWriter.name("right").value(bounds.right);
                        jsonWriter.name("top").value(bounds.top);
                        jsonWriter.name("bottom").value(bounds.bottom);
                        jsonWriter.endObject();
                        if (drawable instanceof ColorDrawable) {
                            jsonWriter.name("color").value(((ColorDrawable) drawable).getColor());
                        }
                        jsonWriter.endObject();
                    } else {
                        jsonWriter.name(propertyDescription.MyBillsEntityDataFactory).value(MyBillsEntityDataFactory.toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ClassNameCache extends LruCache<Class<?>, String> {
        @Override // android.util.LruCache
        protected /* synthetic */ String create(Class<?> cls) {
            return cls.getCanonicalName();
        }

        public ClassNameCache() {
            super(255);
        }
    }

    /* loaded from: classes.dex */
    static class RootViewInfo {
        public final View KClassImpl$Data$declaredNonStaticMembers$2;
        public final String MyBillsEntityDataFactory;
        public CachedBitmap PlaceComponentResult = null;
        public float BuiltInFictitiousFunctionClassFactory = 1.0f;

        public RootViewInfo(String str, View view) {
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        }
    }

    /* loaded from: classes.dex */
    static class RootViewFinder implements Callable<List<RootViewInfo>> {
        UIThreadSet<Activity> PlaceComponentResult;
        private final int MyBillsEntityDataFactory = BlobStatic.MONITOR_IMAGE_WIDTH;
        private final DisplayMetrics getAuthRequestContext = new DisplayMetrics();
        private final List<RootViewInfo> BuiltInFictitiousFunctionClassFactory = new ArrayList();
        private final CachedBitmap KClassImpl$Data$declaredNonStaticMembers$2 = new CachedBitmap();

        /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0176  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ java.util.List<com.mixpanel.android.viewcrawler.ViewSnapshot.RootViewInfo> call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 399
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.ViewSnapshot.RootViewFinder.call():java.lang.Object");
        }
    }
}
