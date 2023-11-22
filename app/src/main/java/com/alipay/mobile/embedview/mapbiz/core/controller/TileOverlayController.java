package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterTileOverlay;
import com.alipay.mobile.apmap.model.AdapterTileOverlayOptions;
import com.alipay.mobile.apmap.model.AdapterUrlTileProvider;
import com.alipay.mobile.embedview.mapbiz.data.TileOverlay;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class TileOverlayController extends H5MapController {

    /* renamed from: a */
    private List<AdapterTileOverlay> f7173a;

    public TileOverlayController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7173a = new CopyOnWriteArrayList();
    }

    private void a() {
        if (this.f7173a.size() == 0) {
            return;
        }
        Iterator<AdapterTileOverlay> it = this.f7173a.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        this.f7173a.clear();
    }

    public void setTileOverlay(AdapterAMap adapterAMap, final TileOverlay tileOverlay) {
        a();
        if (tileOverlay == null) {
            return;
        }
        try {
            this.f7173a.add(adapterAMap.addTileOverlay(new AdapterTileOverlayOptions(adapterAMap).tileProvider(new AdapterUrlTileProvider(adapterAMap, tileOverlay.tileWidth, tileOverlay.tileHeight) { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.TileOverlayController.1
                {
                    TileOverlayController.this = this;
                }

                @Override // com.alipay.mobile.apmap.model.AdapterUrlTileProvider
                public URL getTileUrlAdapter(int i, int i2, int i3) {
                    try {
                        return new URL(String.format(tileOverlay.getMergeUrl(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
                    } catch (Exception e) {
                        RVLogger.e(H5MapContainer.TAG, e);
                        TileOverlayController.this.mMapContainer.reportController.reportParamError(5);
                        TileOverlayController.this.mMapContainer.reportController.reportException("TileOverlayController#getTileUrlAdapter", e.getMessage());
                        return null;
                    }
                }
            }).diskCacheEnabled(false).memoryCacheEnabled(true).memCacheSize(1024).zIndex(tileOverlay.zIndex)));
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("TileOverlayController#setTileOverlay", th.getMessage());
        }
    }
}
