package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class SnapshotController extends H5MapController {

    /* renamed from: a */
    private Bitmap f7172a;

    public SnapshotController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public Bitmap getPreSnapshot() {
        StringBuilder sb = new StringBuilder();
        sb.append("getSnapshot ");
        Bitmap bitmap = this.f7172a;
        sb.append(bitmap != null ? bitmap.toString() : null);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        return this.f7172a;
    }

    public void triggerPreSnapshot() {
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        if (mapView == null || mapView.getMap() == null) {
            return;
        }
        mapView.getMap().getMapScreenShot(new AdapterAMap.OnAdapterMapScreenShotListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.SnapshotController.1
            {
                SnapshotController.this = this;
            }

            @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMapScreenShotListener
            public void onMapScreenShot(Bitmap bitmap) {
                SnapshotController.this.f7172a = bitmap;
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(SnapshotController.this.mMapContainer.getContext());
                Intent intent = new Intent();
                intent.setAction("embedview.snapshot.complete");
                localBroadcastManager.sendBroadcast(intent);
                StringBuilder sb = new StringBuilder();
                sb.append("triggerPreSnapshot ");
                sb.append(SnapshotController.this.f7172a != null ? SnapshotController.this.f7172a.toString() : null);
                RVLogger.d(H5MapContainer.TAG, sb.toString());
            }
        });
    }
}
