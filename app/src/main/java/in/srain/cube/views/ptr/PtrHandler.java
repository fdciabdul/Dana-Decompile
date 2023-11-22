package in.srain.cube.views.ptr;

import android.view.View;

/* loaded from: classes2.dex */
public interface PtrHandler {
    boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2);

    void onRefreshBegin(PtrFrameLayout ptrFrameLayout);
}
