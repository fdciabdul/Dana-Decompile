package androidx.view;

import android.view.View;
import androidx.view.viewmodel.R;

/* loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R.id.getAuthRequestContext, viewModelStoreOwner);
    }
}
