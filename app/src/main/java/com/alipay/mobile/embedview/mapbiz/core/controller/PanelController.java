package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.embedview.mapbiz.data.Panel;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class PanelController extends H5MapController {

    /* renamed from: a */
    private SparseArray<Panel> f7162a;

    public PanelController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7162a = new SparseArray<>();
    }

    public void setPanels(List<Panel> list) {
        Context context;
        AdapterTextureMapView mapView;
        boolean z;
        if (list == null || (context = this.mMapContainer.getContext()) == null || (mapView = this.mMapContainer.renderController.getMapView()) == null) {
            return;
        }
        RVLogger.d(H5MapContainer.TAG, "begin set panels");
        StringBuilder sb = new StringBuilder();
        sb.append("before remove mPanelArray: ");
        sb.append(this.f7162a.size());
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mapView.getAdapterChildCount(); i++) {
            View adapterChildAt = mapView.getAdapterChildAt(i);
            if (adapterChildAt.getTag() instanceof Panel) {
                Panel panel = (Panel) adapterChildAt.getTag();
                Iterator<Panel> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    Panel next = it.next();
                    if (next != null && next.equals(panel)) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(adapterChildAt);
                    this.f7162a.remove(panel.f7176id);
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            mapView.removeAdapterView((View) it2.next());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("after remove mPanelArray: ");
        sb2.append(this.f7162a.size());
        RVLogger.d(H5MapContainer.TAG, sb2.toString());
        for (Panel panel2 : list) {
            if (panel2 != null && panel2.position != null && panel2.layout != null && this.f7162a.get(panel2.f7176id) == null) {
                View layoutPanel = this.mMapContainer.layoutController.layoutPanel(context, panel2);
                layoutPanel.setTag(panel2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mMapContainer.metricsController.convertDp(panel2.position.width), (int) this.mMapContainer.metricsController.convertDp(panel2.position.height));
                if (panel2.position.left != null) {
                    layoutParams.leftMargin = (int) this.mMapContainer.metricsController.convertDp(panel2.position.left.doubleValue());
                    layoutParams.gravity = 3;
                } else if (panel2.position.right != null) {
                    layoutParams.rightMargin = (int) this.mMapContainer.metricsController.convertDp(panel2.position.right.doubleValue());
                    layoutParams.gravity = 5;
                }
                if (panel2.position.top != null) {
                    layoutParams.topMargin = (int) this.mMapContainer.metricsController.convertDp(panel2.position.top.doubleValue());
                    layoutParams.gravity |= 48;
                } else if (panel2.position.bottom != null) {
                    layoutParams.bottomMargin = (int) this.mMapContainer.metricsController.convertDp(panel2.position.bottom.doubleValue());
                    layoutParams.gravity |= 80;
                }
                this.f7162a.put(panel2.f7176id, panel2);
                mapView.addAdapterView(layoutPanel, layoutParams);
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("end set panels: ");
        sb3.append(this.f7162a.size());
        RVLogger.d(H5MapContainer.TAG, sb3.toString());
    }

    public void clear() {
        this.f7162a.clear();
    }
}
