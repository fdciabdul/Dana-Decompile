package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptor;
import com.alipay.mobile.apmap.model.AdapterGroundOverlay;
import com.alipay.mobile.apmap.model.AdapterGroundOverlayOptions;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.embedview.mapbiz.data.GroundOverlay;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.zebra.ZebraLoader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class GroundOverlayController extends H5MapController {

    /* renamed from: a */
    private List<AdapterGroundOverlay> f7153a;

    public GroundOverlayController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7153a = new CopyOnWriteArrayList();
    }

    private void a() {
        if (this.f7153a.size() == 0) {
            return;
        }
        Iterator<AdapterGroundOverlay> it = this.f7153a.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        this.f7153a.clear();
    }

    public void setGroundOverlays(final AdapterAMap adapterAMap, List<GroundOverlay> list) {
        a();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (final GroundOverlay groundOverlay : list) {
            if (!TextUtils.isEmpty(groundOverlay.image)) {
                try {
                    AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(adapterAMap);
                    Iterator<Point> it = groundOverlay.includePoints.iterator();
                    while (it.hasNext()) {
                        adapterLatLngBounds.include(it.next().getLatLng(adapterAMap));
                    }
                    final AdapterLatLngBounds build = adapterLatLngBounds.build();
                    this.mMapContainer.resourceLoader.loadImage(groundOverlay.image, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.GroundOverlayController.1
                        {
                            GroundOverlayController.this = this;
                        }

                        @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                        public void onComplete(Bitmap bitmap) {
                            if (bitmap != null) {
                                RVLogger.d(H5MapContainer.TAG, "set ground overlay image");
                                AdapterGroundOverlayOptions adapterGroundOverlayOptions = new AdapterGroundOverlayOptions(adapterAMap);
                                adapterGroundOverlayOptions.zIndex(groundOverlay.zIndex).image(new AdapterBitmapDescriptor(BitmapDescriptorFactory.fromBitmap(bitmap))).transparency(1.0f - groundOverlay.alpha).positionFromBounds(build);
                                AdapterGroundOverlay addGroundOverlay = adapterAMap.addGroundOverlay(adapterGroundOverlayOptions);
                                if (addGroundOverlay != null) {
                                    addGroundOverlay.setVisible(true);
                                    GroundOverlayController.this.f7153a.add(addGroundOverlay);
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    RVLogger.e(H5MapContainer.TAG, th);
                }
            }
        }
    }
}
