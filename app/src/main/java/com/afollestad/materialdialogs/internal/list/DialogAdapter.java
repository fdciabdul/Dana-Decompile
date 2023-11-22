package com.afollestad.materialdialogs.internal.list;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0006J)\u0010\u0017\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\n"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/DialogAdapter;", "IT", "SL", "", "", "checkAllItems", "()V", "", "indices", "checkItems", "([I)V", "disableItems", "", "getItemCount", "()I", "index", "", "isItemChecked", "(I)Z", "positiveButtonClicked", "", FirebaseAnalytics.Param.ITEMS, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "replaceItems", "(Ljava/util/List;Ljava/lang/Object;)V", "toggleAllChecked", "toggleItems", "uncheckAllItems", "uncheckItems"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public interface DialogAdapter<IT, SL> {
    void checkAllItems();

    void checkItems(int[] indices);

    void disableItems(int[] indices);

    int getItemCount();

    boolean isItemChecked(int index);

    void positiveButtonClicked();

    void replaceItems(List<? extends IT> items, SL listener);

    void toggleAllChecked();

    void toggleItems(int[] indices);

    void uncheckAllItems();

    void uncheckItems(int[] indices);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void replaceItems$default(DialogAdapter dialogAdapter, List list, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceItems");
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            dialogAdapter.replaceItems(list, obj);
        }
    }
}
