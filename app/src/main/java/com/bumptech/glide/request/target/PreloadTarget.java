package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {
    private static final Handler getAuthRequestContext = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.request.target.PreloadTarget.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                PreloadTarget preloadTarget = (PreloadTarget) message.obj;
                preloadTarget.PlaceComponentResult.getAuthRequestContext((Target<?>) preloadTarget);
                return true;
            }
            return false;
        }
    });
    final RequestManager PlaceComponentResult;

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Z z, Transition<? super Z> transition) {
        getAuthRequestContext.obtainMessage(1, this).sendToTarget();
    }
}
