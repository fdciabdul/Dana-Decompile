package com.otaliastudios.cameraview.markers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.R;

/* loaded from: classes8.dex */
public class DefaultAutoFocusMarker implements AutoFocusMarker {
    View PlaceComponentResult;
    View getAuthRequestContext;

    @Override // com.otaliastudios.cameraview.markers.Marker
    public final View getAuthRequestContext(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_layout_focus_marker, viewGroup, false);
        this.getAuthRequestContext = inflate.findViewById(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a0775);
        this.PlaceComponentResult = inflate.findViewById(R.id.PlaceComponentResult_res_0x7f0a0776);
        return inflate;
    }

    @Override // com.otaliastudios.cameraview.markers.AutoFocusMarker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(AutoFocusTrigger autoFocusTrigger) {
        if (autoFocusTrigger == AutoFocusTrigger.METHOD) {
            return;
        }
        this.getAuthRequestContext.clearAnimation();
        this.PlaceComponentResult.clearAnimation();
        this.getAuthRequestContext.setScaleX(1.36f);
        this.getAuthRequestContext.setScaleY(1.36f);
        this.getAuthRequestContext.setAlpha(1.0f);
        this.PlaceComponentResult.setScaleX(0.0f);
        this.PlaceComponentResult.setScaleY(0.0f);
        this.PlaceComponentResult.setAlpha(1.0f);
        KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, 1.0f, 1.0f, 300L, 0L, null);
        KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, 1.0f, 1.0f, 300L, 0L, null);
    }

    @Override // com.otaliastudios.cameraview.markers.AutoFocusMarker
    public final void PlaceComponentResult(AutoFocusTrigger autoFocusTrigger, boolean z) {
        if (autoFocusTrigger == AutoFocusTrigger.METHOD) {
            return;
        }
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, 1.0f, 0.0f, 500L, 0L, null);
            KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, 1.0f, 0.0f, 500L, 0L, null);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, 0.0f, 0.0f, 500L, 0L, null);
        KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, 1.36f, 1.0f, 500L, 0L, new AnimatorListenerAdapter() { // from class: com.otaliastudios.cameraview.markers.DefaultAutoFocusMarker.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                DefaultAutoFocusMarker.KClassImpl$Data$declaredNonStaticMembers$2(DefaultAutoFocusMarker.this.getAuthRequestContext, 1.36f, 0.0f, 200L, 1000L, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f, float f2, long j, long j2, Animator.AnimatorListener animatorListener) {
        view.animate().scaleX(f).scaleY(f).alpha(f2).setDuration(j).setStartDelay(j2).setListener(animatorListener).start();
    }
}
