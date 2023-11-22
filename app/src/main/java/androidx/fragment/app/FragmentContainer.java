package androidx.fragment.app;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public abstract class FragmentContainer {
    public abstract boolean MyBillsEntityDataFactory();

    public abstract View getAuthRequestContext(int i);

    @Deprecated
    public static Fragment getAuthRequestContext(Context context, String str) {
        return Fragment.instantiate(context, str, null);
    }
}
