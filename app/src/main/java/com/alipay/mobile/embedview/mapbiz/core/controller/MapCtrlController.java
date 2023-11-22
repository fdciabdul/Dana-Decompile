package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.embedview.mapbiz.data.Control;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.zebra.ZebraLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class MapCtrlController extends H5MapController {

    /* renamed from: a */
    private SparseArray<Control> f7158a;
    private View.OnClickListener b;

    public MapCtrlController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7158a = new SparseArray<>();
        this.b = new View.OnClickListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapCtrlController.1
            {
                MapCtrlController.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof Integer) {
                    Control control = (Control) MapCtrlController.this.f7158a.get(((Integer) view.getTag()).intValue());
                    if (MapCtrlController.this.mMapContainer.getH5Page() == null || control == null) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onControlClick ");
                    sb.append(control.f7174id);
                    RVLogger.d(H5MapContainer.TAG, sb.toString());
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("controlId", (Object) Integer.valueOf(control.f7174id));
                    jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) MapCtrlController.this.mMapContainer.getElementId());
                    jSONObject.put("data", (Object) jSONObject2);
                    if (MapCtrlController.this.mMapContainer.getExtraJsCallback() != null) {
                        MapCtrlController.this.mMapContainer.getExtraJsCallback().sendToWeb(MapCtrlController.this.mMapContainer.isCubeContainer() ? "controlTap" : "nbcomponent.map.bindcontroltap", jSONObject);
                    }
                }
            }
        };
    }

    public void setControls(List<Control> list) {
        final Context context;
        boolean z;
        if (list == null || (context = this.mMapContainer.getContext()) == null) {
            return;
        }
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        ArrayList<View> arrayList = new ArrayList();
        for (int i = 0; i < mapView.getAdapterChildCount(); i++) {
            View adapterChildAt = mapView.getAdapterChildAt(i);
            if ((adapterChildAt.getTag() instanceof Integer) && this.f7158a.get(((Integer) adapterChildAt.getTag()).intValue()) != null) {
                Control control = this.f7158a.get(((Integer) adapterChildAt.getTag()).intValue());
                Iterator<Control> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    Control next = it.next();
                    if (next != null && next.equals(control)) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(adapterChildAt);
                }
            }
        }
        boolean z2 = this.mMapContainer.debuggable;
        for (View view : arrayList) {
            mapView.removeAdapterView(view);
            this.f7158a.remove(((Integer) view.getTag()).intValue());
        }
        boolean z3 = this.mMapContainer.debuggable;
        for (final Control control2 : list) {
            if (control2 != null && !TextUtils.isEmpty(control2.iconPath) && control2.position != null && this.f7158a.get(control2.f7174id) == null) {
                final View view2 = new View(context);
                view2.setTag(Integer.valueOf(control2.f7174id));
                this.f7158a.put(control2.f7174id, control2);
                if (control2.clickable) {
                    view2.setOnClickListener(this.b);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mMapContainer.metricsController.convertDp(control2.position.width), (int) this.mMapContainer.metricsController.convertDp(control2.position.height));
                if (control2.position.left != null) {
                    layoutParams.leftMargin = (int) this.mMapContainer.metricsController.convertDp(control2.position.left.doubleValue());
                    layoutParams.gravity = 3;
                } else if (control2.position.right != null) {
                    layoutParams.rightMargin = (int) this.mMapContainer.metricsController.convertDp(control2.position.right.doubleValue());
                    layoutParams.gravity = 5;
                }
                if (control2.position.top != null) {
                    layoutParams.topMargin = (int) this.mMapContainer.metricsController.convertDp(control2.position.top.doubleValue());
                    layoutParams.gravity |= 48;
                } else if (control2.position.bottom != null) {
                    layoutParams.bottomMargin = (int) this.mMapContainer.metricsController.convertDp(control2.position.bottom.doubleValue());
                    layoutParams.gravity |= 80;
                }
                this.mMapContainer.resourceLoader.loadImage(control2.iconPath, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapCtrlController.2
                    {
                        MapCtrlController.this = this;
                    }

                    @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                    public void onComplete(Bitmap bitmap) {
                        if (bitmap != null) {
                            MapCtrlController.this.a(bitmap, view2, context);
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("control resource error: ");
                        sb.append(control2.iconPath);
                        RVLogger.e(H5MapContainer.TAG, sb.toString());
                        MapCtrlController.this.mMapContainer.reportController.reportParamError(4);
                    }
                });
                mapView.addAdapterView(view2, layoutParams);
            }
        }
    }

    public void a(Bitmap bitmap, View view, Context context) {
        if (bitmap != null) {
            try {
                if (!(view.getTag() instanceof Integer) || this.f7158a.get(((Integer) view.getTag()).intValue()) == null) {
                    return;
                }
                view.setBackground(new BitmapDrawable(context.getResources(), bitmap));
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
                this.mMapContainer.reportController.reportException("MapCtrlController#handleControlIcon", th.getMessage());
            }
        }
    }

    public void clear() {
        SparseArray<Control> sparseArray = this.f7158a;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }
}
