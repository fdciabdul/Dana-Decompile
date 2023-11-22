package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes3.dex */
public final class ListViewCompat {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.MyBillsEntityDataFactory(listView, i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }

    public static boolean MyBillsEntityDataFactory(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.getAuthRequestContext(listView, i);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i > 0) {
            return firstVisiblePosition + childCount < listView.getCount() || listView.getChildAt(childCount + (-1)).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
        }
        return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
    }

    private ListViewCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static void MyBillsEntityDataFactory(ListView listView, int i) {
            listView.scrollListBy(i);
        }

        static boolean getAuthRequestContext(ListView listView, int i) {
            return listView.canScrollList(i);
        }
    }
}
