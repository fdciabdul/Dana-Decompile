package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class OpReorderer {
    final Callback KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp PlaceComponentResult(int i, int i2, int i3, Object obj);

        void getAuthRequestContext(AdapterHelper.UpdateOp updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpReorderer(Callback callback) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.getAuthRequestContext < updateOp2.MyBillsEntityDataFactory ? -1 : 0;
        if (updateOp.MyBillsEntityDataFactory < updateOp2.MyBillsEntityDataFactory) {
            i3++;
        }
        if (updateOp2.MyBillsEntityDataFactory <= updateOp.MyBillsEntityDataFactory) {
            updateOp.MyBillsEntityDataFactory += updateOp2.getAuthRequestContext;
        }
        if (updateOp2.MyBillsEntityDataFactory <= updateOp.getAuthRequestContext) {
            updateOp.getAuthRequestContext += updateOp2.getAuthRequestContext;
        }
        updateOp2.MyBillsEntityDataFactory += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).KClassImpl$Data$declaredNonStaticMembers$2 != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
