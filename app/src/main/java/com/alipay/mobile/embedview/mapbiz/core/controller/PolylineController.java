package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.map.R;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterPolyline;
import com.alipay.mobile.apmap.model.AdapterPolylineOptions;
import com.alipay.mobile.embedview.mapbiz.core.H5MapPolyline;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.data.Polyline;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.ZebraLoader;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PolylineController extends H5MapController {
    public final Map<String, H5MapPolyline> h5MapPolylines;

    public PolylineController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.h5MapPolylines = new ConcurrentHashMap();
    }

    public void clear() {
        Iterator<Map.Entry<String, H5MapPolyline>> it = this.h5MapPolylines.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove();
        }
        this.h5MapPolylines.clear();
    }

    public boolean contains(H5MapPolyline h5MapPolyline) {
        return this.h5MapPolylines.containsKey(h5MapPolyline.f7142id);
    }

    public void add(H5MapPolyline h5MapPolyline) {
        this.h5MapPolylines.put(h5MapPolyline.f7142id, h5MapPolyline);
    }

    public void setPolyline(AdapterAMap adapterAMap, List<Polyline> list) {
        int i;
        if (list != null && !this.mMapContainer.configController.isRenderPolylineFast()) {
            setPolylineLegacy(adapterAMap, list);
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Polyline polyline = list.get(i2);
                if (polyline != null) {
                    String obtainId = polyline.obtainId();
                    if (!TextUtils.isEmpty(obtainId)) {
                        if (this.h5MapPolylines.containsKey(obtainId)) {
                            hashMap.put(obtainId, polyline);
                        } else {
                            arrayList.add(polyline);
                        }
                    } else {
                        arrayList.add(polyline);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, H5MapPolyline> entry : this.h5MapPolylines.entrySet()) {
            String key = entry.getKey();
            Polyline polyline2 = (Polyline) hashMap.get(key);
            if (polyline2 != null) {
                H5MapPolyline value = entry.getValue();
                if (polyline2.isSameStyle(value.polyline)) {
                    arrayList2.add(value);
                    value.polyline = polyline2;
                    value.setPoints(Point.toLatLangPoints(adapterAMap, polyline2.obtainPoints()));
                    if (this.mMapContainer.debuggable) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("PolylineController#setPolyline: update -> ");
                        sb.append(key);
                        RVLogger.d(H5MapContainer.TAG, sb.toString());
                    }
                } else {
                    entry.getValue().remove();
                    arrayList.add(polyline2);
                }
            } else {
                entry.getValue().remove();
            }
        }
        this.h5MapPolylines.clear();
        if (arrayList2.size() != 0) {
            add(arrayList2);
            i = arrayList2.size() + 0;
        } else {
            i = 0;
        }
        if (arrayList.size() != 0) {
            List<H5MapPolyline> addPolyline = addPolyline(adapterAMap, arrayList, false);
            if (addPolyline.size() != 0) {
                add(addPolyline);
                i += addPolyline.size();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setPolyline done: ");
        sb2.append(i);
        sb2.append(" -> ");
        sb2.append(arrayList2.size());
        RVLogger.d(H5MapContainer.TAG, sb2.toString());
    }

    protected void setPolylineLegacy(AdapterAMap adapterAMap, List<Polyline> list) {
        clear();
        if (list == null) {
            return;
        }
        add(addPolyline(adapterAMap, list, false));
        StringBuilder sb = new StringBuilder();
        sb.append("setPolyline done: ");
        sb.append(list.size());
        RVLogger.d(H5MapContainer.TAG, sb.toString());
    }

    protected void add(List<H5MapPolyline> list) {
        for (H5MapPolyline h5MapPolyline : list) {
            this.h5MapPolylines.put(h5MapPolyline.f7142id, h5MapPolyline);
        }
    }

    public H5MapPolyline addPolyline(AdapterAMap adapterAMap, Polyline polyline) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(polyline);
        List<H5MapPolyline> addPolyline = addPolyline(adapterAMap, arrayList, false);
        if (addPolyline == null || addPolyline.size() <= 0) {
            return null;
        }
        return addPolyline.get(0);
    }

    public List<H5MapPolyline> addPolyline(AdapterAMap adapterAMap, List<Polyline> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        try {
            Context context = this.mMapContainer.getContext();
            for (Polyline polyline : list) {
                H5MapPolyline h5MapPolyline = new H5MapPolyline(polyline, new ArrayList());
                arrayList.add(h5MapPolyline);
                List<Point> obtainPoints = polyline.obtainPoints();
                if (obtainPoints != null) {
                    AdapterPolylineOptions addAll = new AdapterPolylineOptions(adapterAMap).addAll(Point.toLatLangPoints(adapterAMap, obtainPoints));
                    if (polyline.zIndex != -1) {
                        addAll.zIndex(polyline.zIndex);
                    }
                    if (polyline.width != -1.0d) {
                        addAll.width(DensityUtil.dip2px(context, (float) polyline.width));
                    }
                    addAll.color(H5MapUtils.convertRGBAColor(polyline.color));
                    addAll.setDottedLine(polyline.dottedLine);
                    boolean z2 = (polyline.colorList == null || polyline.colorList.isEmpty()) ? false : true;
                    if (z2) {
                        ArrayList arrayList2 = new ArrayList(polyline.colorList.size());
                        Iterator<String> it = polyline.colorList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(Integer.valueOf(H5MapUtils.convertRGBAColor(it.next())));
                        }
                        addAll.colorValues(arrayList2);
                    }
                    if (z) {
                        if (polyline.dottedLine) {
                            h5MapPolyline.context.add(adapterAMap.addPolyline(addAll));
                        } else {
                            a(adapterAMap, h5MapPolyline, addAll, z2, TextUtils.isEmpty(polyline.iconPath));
                        }
                    } else if (!TextUtils.isEmpty(polyline.iconPath)) {
                        a(adapterAMap, h5MapPolyline, addAll, z2, false);
                    } else {
                        h5MapPolyline.context.add(adapterAMap.addPolyline(addAll));
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("PolylineController#addPolyline", th.getMessage());
        }
        return arrayList;
    }

    private void a(final AdapterAMap adapterAMap, final H5MapPolyline h5MapPolyline, AdapterPolylineOptions adapterPolylineOptions, boolean z, boolean z2) {
        if (z) {
            h5MapPolyline.context.add(adapterAMap.addPolyline(adapterPolylineOptions));
        }
        if (h5MapPolyline.polyline.iconWidth >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && !adapterAMap.is2dMapSdk()) {
            adapterPolylineOptions.width(DensityUtil.dip2px(this.mMapContainer.getContext(), (float) h5MapPolyline.polyline.iconWidth));
        }
        if (z2) {
            adapterPolylineOptions.setCustomTexture(AdapterBitmapDescriptorFactory.fromResource(adapterAMap, z ? R.drawable.griver_map_map_texture_transparent : R.drawable.griver_map_map_texture));
            h5MapPolyline.context.add(adapterAMap.addPolyline(adapterPolylineOptions));
            return;
        }
        final AdapterPolyline addPolyline = adapterAMap.addPolyline(adapterPolylineOptions);
        h5MapPolyline.context.add(addPolyline);
        this.mMapContainer.resourceLoader.loadImage(h5MapPolyline.polyline.iconPath, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.PolylineController.1
            {
                PolylineController.this = this;
            }

            @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
            public void onComplete(Bitmap bitmap) {
                if (bitmap != null) {
                    Bitmap rotateBitmap = H5MapUtils.rotateBitmap(bitmap, 180.0f);
                    RVLogger.d(H5MapContainer.TAG, "setPolyline icon");
                    addPolyline.setCustomTexture(AdapterBitmapDescriptorFactory.fromBitmap(adapterAMap, rotateBitmap));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("polyline resource error: ");
                sb.append(h5MapPolyline.polyline.iconPath);
                RVLogger.e(H5MapContainer.TAG, sb.toString());
                PolylineController.this.mMapContainer.reportController.reportParamError(6);
            }
        });
    }

    public List<AdapterPolyline> toAdapterPolylines(List<H5MapPolyline> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<H5MapPolyline> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().context);
        }
        return arrayList;
    }
}
