package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView lookAheadTest;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.lookAheadTest = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public final void getAuthRequestContext(int i) {
        ListViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, i);
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        ListView listView = this.lookAheadTest;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i > 0) {
            if (firstVisiblePosition + childCount >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
