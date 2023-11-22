package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    public abstract void BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, Object obj);

    public abstract void BuiltInFictitiousFunctionClassFactory(Object obj, View view);

    public abstract boolean BuiltInFictitiousFunctionClassFactory(Object obj);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, View view);

    public abstract Object MyBillsEntityDataFactory(Object obj);

    public abstract Object MyBillsEntityDataFactory(Object obj, Object obj2, Object obj3);

    public abstract void MyBillsEntityDataFactory(Object obj, View view, ArrayList<View> arrayList);

    public abstract void PlaceComponentResult(Object obj, Rect rect);

    public abstract void PlaceComponentResult(Object obj, View view, ArrayList<View> arrayList);

    public abstract void PlaceComponentResult(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object getAuthRequestContext(Object obj);

    public abstract Object getAuthRequestContext(Object obj, Object obj2, Object obj3);

    public abstract void getAuthRequestContext(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void getAuthRequestContext(Object obj, ArrayList<View> arrayList);

    /* JADX INFO: Access modifiers changed from: protected */
    public void BuiltInFictitiousFunctionClassFactory(View view, Rect rect) {
        if (ViewCompat.C(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> MyBillsEntityDataFactory(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(ViewCompat.getCallingPid(view));
            ViewCompat.getAuthRequestContext(view, (String) null);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String callingPid = ViewCompat.getCallingPid(view2);
            arrayList4.add(callingPid);
            if (callingPid != null) {
                ViewCompat.getAuthRequestContext(view2, (String) null);
                String str = map.get(callingPid);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        ViewCompat.getAuthRequestContext(arrayList2.get(i2), callingPid);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        OneShotPreDrawListener.KClassImpl$Data$declaredNonStaticMembers$2(view, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    ViewCompat.getAuthRequestContext((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    ViewCompat.getAuthRequestContext((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    public void MyBillsEntityDataFactory(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void BuiltInFictitiousFunctionClassFactory(List<View> list, View view) {
        int size = list.size();
        if (BuiltInFictitiousFunctionClassFactory(list, view, size)) {
            return;
        }
        if (ViewCompat.getCallingPid(view) != null) {
            list.add(view);
        }
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!BuiltInFictitiousFunctionClassFactory(list, childAt, size) && ViewCompat.getCallingPid(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean PlaceComponentResult(List list) {
        return list == null || list.isEmpty();
    }
}
