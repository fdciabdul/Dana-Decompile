package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EditState extends UIThreadSet<Activity> {
    public static final byte[] MyBillsEntityDataFactory = {36, -25, -14, -85, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 139;
    private final Handler NetworkUserEntityData$$ExternalSyntheticLambda0 = new Handler(Looper.getMainLooper());
    final Map<String, List<ViewVisitor>> getAuthRequestContext = new HashMap();
    final Set<EditBinding> PlaceComponentResult = new HashSet();

    private static void a(int i, byte b, byte b2, Object[] objArr) {
        int i2 = (b2 * 7) + 99;
        int i3 = i + 4;
        byte[] bArr = MyBillsEntityDataFactory;
        int i4 = 16 - (b * 3);
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i2 = i3 + (-i6) + 2;
            i3 = i3;
            i6 = i6;
        }
        while (true) {
            i5++;
            int i7 = i3 + 1;
            bArr2[i5] = (byte) i2;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = i2 + (-bArr[i7]) + 2;
            i3 = i7;
            i6 = i6;
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UIThreadSet
    public final /* bridge */ /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(activity);
    }

    @Override // com.mixpanel.android.viewcrawler.UIThreadSet
    public final /* synthetic */ void PlaceComponentResult(Activity activity) {
        super.PlaceComponentResult((EditState) activity);
        getAuthRequestContext();
    }

    /* renamed from: PlaceComponentResult  reason: avoid collision after fix types in other method */
    public final void PlaceComponentResult2(Activity activity) {
        super.PlaceComponentResult((EditState) activity);
        getAuthRequestContext();
    }

    public final void getAuthRequestContext(Activity activity) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        try {
            Object[] objArr = new Object[1];
            a(MyBillsEntityDataFactory[16], (byte) (MyBillsEntityDataFactory[15] + 1), (byte) (-MyBillsEntityDataFactory[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = MyBillsEntityDataFactory[15];
            byte b2 = (byte) (-b);
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) == this.NetworkUserEntityData$$ExternalSyntheticLambda0.getLooper().getThread()) {
                BuiltInFictitiousFunctionClassFactory();
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.post(new Runnable() { // from class: com.mixpanel.android.viewcrawler.EditState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditState.this.BuiltInFictitiousFunctionClassFactory();
                    }
                });
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory() {
        List<ViewVisitor> list;
        List<ViewVisitor> list2;
        for (Activity activity : MyBillsEntityDataFactory()) {
            String canonicalName = activity.getClass().getCanonicalName();
            View rootView = activity.getWindow().getDecorView().getRootView();
            synchronized (this.getAuthRequestContext) {
                list = this.getAuthRequestContext.get(canonicalName);
                list2 = this.getAuthRequestContext.get(null);
            }
            if (list != null) {
                PlaceComponentResult(rootView, list);
            }
            if (list2 != null) {
                PlaceComponentResult(rootView, list2);
            }
        }
    }

    private void PlaceComponentResult(View view, List<ViewVisitor> list) {
        synchronized (this.PlaceComponentResult) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.PlaceComponentResult.add(new EditBinding(view, list.get(i), this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EditBinding implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        final Handler KClassImpl$Data$declaredNonStaticMembers$2;
        private final ViewVisitor MyBillsEntityDataFactory;
        private final WeakReference<View> getAuthRequestContext;
        private boolean BuiltInFictitiousFunctionClassFactory = true;
        volatile boolean PlaceComponentResult = false;

        public EditBinding(View view, ViewVisitor viewVisitor, Handler handler) {
            this.MyBillsEntityDataFactory = viewVisitor;
            this.getAuthRequestContext = new WeakReference<>(view);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = handler;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                View view = this.getAuthRequestContext.get();
                if (view != null && !this.PlaceComponentResult) {
                    this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(this);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(this, 1000L);
                    return;
                }
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    View view2 = this.getAuthRequestContext.get();
                    if (view2 != null) {
                        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        }
                    }
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                }
                this.BuiltInFictitiousFunctionClassFactory = false;
            }
        }
    }
}
