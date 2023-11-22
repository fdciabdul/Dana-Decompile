package com.otaliastudios.cameraview.engine.action;

/* loaded from: classes8.dex */
public abstract class CompletionCallback implements ActionCallback {
    protected abstract void getAuthRequestContext();

    @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
    public final void PlaceComponentResult(Action action, int i) {
        if (i == Integer.MAX_VALUE) {
            getAuthRequestContext();
        }
    }
}
