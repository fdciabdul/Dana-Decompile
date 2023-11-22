package in.srain.cube.views.ptr;

import in.srain.cube.views.ptr.indicator.PtrIndicator;

/* loaded from: classes3.dex */
public interface PtrUIHandler {
    void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator);

    void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout);

    void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout);

    void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout);

    void onUIReset(PtrFrameLayout ptrFrameLayout);
}
