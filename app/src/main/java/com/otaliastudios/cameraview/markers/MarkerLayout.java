package com.otaliastudios.cameraview.markers;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MarkerLayout extends FrameLayout {
    public static final int TYPE_AUTOFOCUS = 1;
    private final HashMap<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    public MarkerLayout(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();
    }

    public void onMarker(int i, Marker marker) {
        View authRequestContext;
        View view = this.KClassImpl$Data$declaredNonStaticMembers$2.get(Integer.valueOf(i));
        if (view != null) {
            removeView(view);
        }
        if (marker == null || (authRequestContext = marker.getAuthRequestContext(getContext(), this)) == null) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(Integer.valueOf(i), authRequestContext);
        addView(authRequestContext);
    }

    public void onEvent(int i, PointF[] pointFArr) {
        View view = this.KClassImpl$Data$declaredNonStaticMembers$2.get(Integer.valueOf(i));
        if (view == null) {
            return;
        }
        view.clearAnimation();
        if (i == 1) {
            PointF pointF = pointFArr[0];
            float width = (int) (pointF.x - (view.getWidth() / 2));
            float height = (int) (pointF.y - (view.getHeight() / 2));
            view.setTranslationX(width);
            view.setTranslationY(height);
        }
    }
}
