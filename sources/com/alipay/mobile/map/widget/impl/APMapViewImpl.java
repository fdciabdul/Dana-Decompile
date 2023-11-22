package com.alipay.mobile.map.widget.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.map.R;
import com.alipay.android.mapassist.ui.MarkerInfo;
import com.alipay.android.mapassist.ui.PoiOverlay;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterUiSettings;
import com.alipay.mobile.apmap.OnAdapterMapReadyCallback;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptor;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterCircleOptions;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.apmap.model.AdapterMyLocationStyle;
import com.alipay.mobile.apmap.model.AdapterPolygonOptions;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.LatLonPointEx;
import com.alipay.mobile.map.widget.APMapView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class APMapViewImpl extends BaseMapViewImpl implements SensorEventListener, AdapterAMap.AdapterInfoWindowAdapter, AdapterAMap.OnAdapterInfoWindowClickListener, AdapterAMap.OnAdapterMapClickListener, AdapterAMap.OnAdapterMapLoadedListener, AdapterAMap.OnAdapterMarkerClickListener, AdapterAMap.OnAdapterMarkerDragListener, APMapView {
    private long A;
    private float B;
    private boolean C;
    private String D;
    private String E;
    private String F;
    private AdapterUiSettings G;
    private String H;

    /* renamed from: a  reason: collision with root package name */
    private String f7205a;
    private View b;
    private boolean c;
    private boolean d;
    private Bitmap e;
    private int f;
    private APMapView.OnMapClickListener g;
    private APMapView.OnPoiActionListener h;
    Handler handler;
    private APMapView.OnSearchListener i;
    private APMapView.OnCloudSearchListener j;
    private AdapterAMap.OnAdapterMarkerClickListener k;
    private AdapterMarker l;
    private AdapterMarker m;
    HashMap<String, String> mapAppItem;
    ArrayList<String> mapAppList;
    private boolean n;

    /* renamed from: o  reason: collision with root package name */
    private PoiOverlay f7206o;
    private View p;
    private View q;
    private String r;
    private int s;
    private int t;
    private List<LatLonPoint> u;
    private List<LatLonPointEx> v;
    private LatLonPoint w;
    private LatLonPointEx x;
    private SensorManager y;
    private Sensor z;

    private void b() {
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterInfoWindowAdapter
    public View getInfoContents(AdapterMarker adapterMarker) {
        return null;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void moveToLatLng(LatLonPoint latLonPoint, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterInfoWindowClickListener
    public void onInfoWindowClick(AdapterMarker adapterMarker) {
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void searchRoute(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str, int i) {
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void searchRoute(LatLonPointEx latLonPointEx, LatLonPointEx latLonPointEx2, String str, int i) {
    }

    public APMapViewImpl(Context context) {
        super(context);
        this.f7205a = "APMapView";
        this.c = true;
        this.d = true;
        this.e = null;
        this.f = -1;
        this.n = false;
        this.r = null;
        this.s = 1002;
        this.t = -1;
        this.A = 0L;
        this.mapAppItem = new HashMap<>();
        this.mapAppList = new ArrayList<>();
        this.C = false;
        this.D = "Baidu Map";
        this.E = "com.autonavi.minimap";
        this.F = "com.baidu.BaiduMap";
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.9
            @Override // android.os.Handler
            public void handleMessage(Message message) {
            }
        };
        init();
    }

    public APMapViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7205a = "APMapView";
        this.c = true;
        this.d = true;
        this.e = null;
        this.f = -1;
        this.n = false;
        this.r = null;
        this.s = 1002;
        this.t = -1;
        this.A = 0L;
        this.mapAppItem = new HashMap<>();
        this.mapAppList = new ArrayList<>();
        this.C = false;
        this.D = "Baidu Map";
        this.E = "com.autonavi.minimap";
        this.F = "com.baidu.BaiduMap";
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.9
            @Override // android.os.Handler
            public void handleMessage(Message message) {
            }
        };
        init();
    }

    @Override // com.alipay.mobile.map.widget.impl.BaseMapViewImpl
    public void init() {
        super.init();
        this.mBizType = "APMapViewImpl";
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.y = sensorManager;
        this.z = sensorManager.getDefaultSensor(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.map.widget.impl.BaseMapViewImpl
    public void setUpMap() {
        super.setUpMap();
        if (this.mAMap == null) {
            return;
        }
        this.mAMap.setOnMarkerClickListener(this);
        this.mAMap.setInfoWindowAdapter(this);
        this.mAMap.setOnInfoWindowClickListener(this);
        this.mAMap.setOnMapClickListener(this);
        this.mAMap.setOnMarkerDragListener(this);
        this.mAMap.setOnMapLoadedListener(this);
        AdapterUiSettings uiSettings = this.mAMap.getUiSettings();
        this.G = uiSettings;
        if (uiSettings != null) {
            uiSettings.setScaleControlsEnabled(true);
        }
        AdapterMyLocationStyle adapterMyLocationStyle = new AdapterMyLocationStyle(this.mAMap);
        adapterMyLocationStyle.myLocationIcon(AdapterBitmapDescriptorFactory.fromBitmap(this.mAMap, this.e));
        adapterMyLocationStyle.strokeColor(getResources().getColor(R.color.griver_map_radiusBorderColor));
        adapterMyLocationStyle.strokeWidth(1.0f);
        adapterMyLocationStyle.radiusFillColor(getResources().getColor(R.color.griver_map_radiusFillColor));
        this.mAMap.setMyLocationStyle(adapterMyLocationStyle);
        this.f7206o = new PoiOverlay(this.mAMap);
    }

    @Override // com.alipay.mobile.map.widget.impl.BaseMapViewImpl, com.alipay.mobile.map.widget.APMapView
    public void onCreateView(Bundle bundle, OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        super.onCreateView(bundle, onAdapterMapReadyCallback);
        a();
    }

    @Override // com.alipay.mobile.map.widget.impl.BaseMapViewImpl, com.alipay.mobile.map.widget.APMapView
    public void onResumeView() {
        super.onResume();
        registerSensorListener();
    }

    public void registerSensorListener() {
        SensorManager sensorManager = this.y;
        if (sensorManager != null) {
            try {
                sensorManager.registerListener(this, this.z, 0);
            } catch (Throwable th) {
                RVLogger.e(this.f7205a, th);
            }
        }
    }

    public void unRegisterSensorListener() {
        SensorManager sensorManager = this.y;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.z);
        }
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPoint(double d, double d2, int i) {
        showPoint(new LatLonPoint(d, d2), i);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPoint(LatLonPoint latLonPoint, int i) {
        if (latLonPoint == null) {
            throw new RuntimeException("LatLonPoint is NULL!");
        }
        this.w = latLonPoint;
        this.t = i;
        this.f = 203;
        a(203, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPoint(double d, double d2) {
        showPoint(new LatLonPoint(d, d2));
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPoint(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            throw new RuntimeException("LatLonPoint is NULL!");
        }
        this.w = latLonPoint;
        this.f = 205;
        a(205, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPoints(List<LatLonPoint> list) {
        if (list == null || list.size() == 0) {
            throw new RuntimeException("There is no point!");
        }
        this.u = list;
        this.f = 201;
        a(201, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPointEx(LatLonPointEx latLonPointEx) {
        a(latLonPointEx);
        this.x = latLonPointEx;
        this.f = 206;
        a(206, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPointEx(LatLonPointEx latLonPointEx, int i) {
        a(latLonPointEx);
        this.x = latLonPointEx;
        this.t = i;
        this.f = 204;
        a(204, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void showPointsEx(List<LatLonPointEx> list) {
        if (list == null || list.size() == 0) {
            throw new RuntimeException("There is no pointEx!");
        }
        this.v = list;
        this.f = 202;
        a(202, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void clear() {
        if (this.mAMap == null) {
            return;
        }
        this.mAMap.clear();
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void locate() {
        startLocate();
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void search(String str, String str2) {
        showProgressDialog(getResources().getString(R.string.griver_map_searching));
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void searchViaCloud(String str, String str2, LatLonPoint latLonPoint) {
        searchViaCloud(str, str2, latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void searchViaCloud(String str, String str2, double d, double d2) {
        showProgressDialog(getResources().getString(R.string.griver_map_searching));
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setOnMapClickListener(APMapView.OnMapClickListener onMapClickListener) {
        this.g = onMapClickListener;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setOnPoiActionListener(APMapView.OnPoiActionListener onPoiActionListener) {
        this.h = onPoiActionListener;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setOnCloudSearchListener(APMapView.OnCloudSearchListener onCloudSearchListener) {
        this.j = onCloudSearchListener;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setOnMarkerClickListener(AdapterAMap.OnAdapterMarkerClickListener onAdapterMarkerClickListener) {
        this.k = onAdapterMarkerClickListener;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setOnSearchListener(APMapView.OnSearchListener onSearchListener) {
        this.i = onSearchListener;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setSearchRouteMode(int i) {
        this.s = i;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setMyLocationEnabled(boolean z) {
        this.mIsMyLocationEnable = z;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setMyLocationIcon(Bitmap bitmap) {
        this.e = bitmap;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setShowMarkerInfoWindowEnable(boolean z) {
        this.d = z;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setZoomControlsEnabled(boolean z) {
        this.mZoomControlEnable = z;
        if (this.mAMap == null || this.mAMap.getUiSettings() == null) {
            return;
        }
        this.mAMap.getUiSettings().setZoomControlsEnabled(this.mZoomControlEnable);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setInfoWindowClickEnabled(boolean z) {
        this.c = z;
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public boolean getInfoWindowClickEnabled() {
        return this.c;
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerClickListener
    public boolean onMarkerClick(AdapterMarker adapterMarker) {
        AdapterAMap.OnAdapterMarkerClickListener onAdapterMarkerClickListener = this.k;
        if (onAdapterMarkerClickListener != null) {
            return onAdapterMarkerClickListener.onMarkerClick(adapterMarker);
        }
        Object object = adapterMarker.getObject();
        if (object == null || !(object instanceof MarkerInfo)) {
            return false;
        }
        MarkerInfo markerInfo = (MarkerInfo) object;
        LatLonPointEx latLonPointEx = markerInfo.pointEx;
        if (adapterMarker.isInfoWindowShown()) {
            adapterMarker.hideInfoWindow();
            markerInfo.icon = markerInfo.pointEx.getIcon();
            adapterMarker.setIcon(a(markerInfo.icon));
        } else {
            adapterMarker.showInfoWindow();
            markerInfo.icon = markerInfo.pointEx.getClickIcon();
            adapterMarker.setIcon(a(markerInfo.icon));
        }
        AdapterMarker adapterMarker2 = this.m;
        if (adapterMarker2 != null && !a(adapterMarker, adapterMarker2)) {
            if (this.m.isInfoWindowShown()) {
                this.m.hideInfoWindow();
            }
            MarkerInfo markerInfo2 = (MarkerInfo) this.m.getObject();
            markerInfo2.icon = markerInfo.pointEx.getIcon();
            this.m.setIcon(a(markerInfo2.icon));
        }
        this.m = adapterMarker;
        APMapView.OnPoiActionListener onPoiActionListener = this.h;
        if (onPoiActionListener != null) {
            onPoiActionListener.onPoiClick(latLonPointEx);
            return false;
        }
        return false;
    }

    private AdapterBitmapDescriptor a(Bitmap bitmap) {
        return AdapterBitmapDescriptorFactory.fromBitmap(this.mAMap, bitmap);
    }

    public void toast(final String str) {
        this.handler.post(new Runnable() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(APMapViewImpl.this.mContext, str, 1).show();
            }
        });
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMapClickListener
    public void onMapClick(AdapterLatLng adapterLatLng) {
        APMapView.OnMapClickListener onMapClickListener = this.g;
        if (onMapClickListener != null) {
            onMapClickListener.onMapClick(new LatLonPoint(adapterLatLng.getLatitude(), adapterLatLng.getLongitude()));
        }
    }

    @Override // com.alipay.mobile.map.widget.impl.BaseMapViewImpl, com.alipay.mobile.apmap.AdapterLocationSource
    public void deactivate() {
        super.deactivate();
        unRegisterSensorListener();
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerDragListener
    public void onMarkerDrag(AdapterMarker adapterMarker) {
        Object object = adapterMarker.getObject();
        if (object instanceof MarkerInfo) {
            LatLonPointEx latLonPointEx = ((MarkerInfo) object).pointEx;
            latLonPointEx.setLatitude(adapterMarker.getPosition().getLatitude());
            latLonPointEx.setLongitude(adapterMarker.getPosition().getLongitude());
            APMapView.OnPoiActionListener onPoiActionListener = this.h;
            if (onPoiActionListener != null) {
                onPoiActionListener.onPoiDrag(latLonPointEx);
            }
        }
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerDragListener
    public void onMarkerDragEnd(AdapterMarker adapterMarker) {
        Object object = adapterMarker.getObject();
        if (object instanceof MarkerInfo) {
            LatLonPointEx latLonPointEx = ((MarkerInfo) object).pointEx;
            latLonPointEx.setLatitude(adapterMarker.getPosition().getLatitude());
            latLonPointEx.setLongitude(adapterMarker.getPosition().getLongitude());
            APMapView.OnPoiActionListener onPoiActionListener = this.h;
            if (onPoiActionListener != null) {
                onPoiActionListener.onPoiDragEnd(latLonPointEx);
            }
        }
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerDragListener
    public void onMarkerDragStart(AdapterMarker adapterMarker) {
        Object object = adapterMarker.getObject();
        if (!(object instanceof MarkerInfo) || this.h == null) {
            return;
        }
        this.h.onPoiDragStart(((MarkerInfo) object).pointEx);
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterInfoWindowAdapter
    public View getInfoWindow(AdapterMarker adapterMarker) {
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.griver_map_view_info_window, (ViewGroup) null);
        this.b = inflate;
        render(adapterMarker, inflate);
        return this.b;
    }

    public void render(AdapterMarker adapterMarker, View view) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.snippet);
        ImageView imageView = (ImageView) view.findViewById(R.id.badge);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.gototaxi);
        String title = adapterMarker.getTitle();
        String snippet = adapterMarker.getSnippet();
        if (!TextUtils.isEmpty(title)) {
            textView.setText(title);
            textView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(snippet)) {
            textView2.setText(snippet);
            textView2.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.H)) {
            for (String str : this.H.split("_")) {
                str.hashCode();
                if (str.equals("0")) {
                    imageView.setVisibility(8);
                } else if (str.equals("1")) {
                    imageView2.setVisibility(8);
                }
            }
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
    }

    private void a(LatLonPointEx latLonPointEx) {
        if (latLonPointEx.getIcon() == null) {
            latLonPointEx.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.griver_map_marker));
        }
        if (latLonPointEx.getClickIcon() == null) {
            latLonPointEx.setClickIcon(BitmapFactory.decodeResource(getResources(), R.drawable.griver_map_marker));
        }
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void startNavigate(Double d, Double d2, String str) {
        if (!this.C) {
            c();
            this.C = true;
        }
        if (this.mAMap != null) {
            AdapterMarker adapterMarker = this.m;
            if (adapterMarker == null) {
                AdapterMarker addMarker = this.mAMap.addMarker(new AdapterMarkerOptions(this.mAMap).position(new AdapterLatLng(this.mAMap, d.doubleValue(), d2.doubleValue())).snippet(str).icon(AdapterBitmapDescriptorFactory.fromBitmap(this.mAMap, BitmapFactory.decodeResource(getResources(), R.drawable.griver_map_select_other_poi_sendmap))));
                this.m = addMarker;
                addMarker.setVisible(false);
                return;
            }
            adapterMarker.setPosition(new AdapterLatLng(this.mAMap, d.doubleValue(), d2.doubleValue()));
            this.m.setSnippet(str);
        }
    }

    private boolean a(AdapterMarker adapterMarker, AdapterMarker adapterMarker2) {
        AdapterLatLng position = adapterMarker.getPosition();
        AdapterLatLng position2 = adapterMarker2.getPosition();
        return position.getLatitude() == position2.getLatitude() && position.getLongitude() == position2.getLongitude();
    }

    private void a() {
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.griver_map_route_group, (ViewGroup) null);
        this.p = inflate;
        addView(inflate);
        this.p.findViewById(R.id.route_detail).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.p.findViewById(R.id.bus_route).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (APMapViewImpl.this.q != null) {
                    APMapViewImpl.this.q.setSelected(false);
                }
                view.setSelected(true);
                APMapViewImpl.this.q = view;
                APMapViewImpl.this.s = 1001;
            }
        });
        View findViewById = this.p.findViewById(R.id.car_route);
        this.q = findViewById;
        findViewById.setSelected(true);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (APMapViewImpl.this.q != null) {
                    APMapViewImpl.this.q.setSelected(false);
                }
                view.setSelected(true);
                APMapViewImpl.this.q = view;
                APMapViewImpl.this.s = 1002;
            }
        });
        this.p.findViewById(R.id.foot_route).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (APMapViewImpl.this.q != null) {
                    APMapViewImpl.this.q.setSelected(false);
                }
                view.setSelected(true);
                APMapViewImpl.this.q = view;
                APMapViewImpl.this.s = 1003;
            }
        });
        this.p.findViewById(R.id.route_close).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.map.widget.impl.APMapViewImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APMapViewImpl aPMapViewImpl = APMapViewImpl.this;
                aPMapViewImpl.a(aPMapViewImpl.f, false);
            }
        });
        this.p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        if (this.mAMap == null) {
            return;
        }
        if (i == 101) {
            b();
        } else if (i == 103) {
            this.f = 103;
            a(this.d);
        } else if (i == 203) {
            this.f = 203;
            a(false);
            this.f7206o.onDrawSingle(BitmapFactory.decodeResource(getResources(), R.drawable.griver_map_marker), this.w, this.t);
        } else if (i == 204) {
            this.f = 204;
            a(this.d);
            this.f7206o.onDrawSingleEx(this.x, this.t, z);
        }
    }

    private void a(boolean z) {
        this.p.setVisibility(8);
        this.f7206o.removeFormMap();
        this.f7206o.setNeedSortByDistance(z);
    }

    private void c() {
        try {
            this.mapAppItem.put(this.F, this.D);
            PackageManager packageManager = this.mContext.getPackageManager();
            for (Map.Entry<String, String> entry : this.mapAppItem.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                new Intent();
                if (packageManager.getLaunchIntentForPackage(key) != null) {
                    this.mapAppList.add(value);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.A >= 100 && sensorEvent.sensor.getType() == 3) {
            float screenRotationOnPhone = (sensorEvent.values[0] + getScreenRotationOnPhone(this.mContext)) % 360.0f;
            if (screenRotationOnPhone > 180.0f) {
                screenRotationOnPhone -= 360.0f;
            } else if (screenRotationOnPhone < -180.0f) {
                screenRotationOnPhone += 360.0f;
            }
            if (Math.abs(this.B - screenRotationOnPhone) >= 5.0f) {
                this.B = screenRotationOnPhone;
                AdapterMarker adapterMarker = this.l;
                if (adapterMarker != null) {
                    adapterMarker.setRotateAngle(-screenRotationOnPhone);
                }
                this.A = System.currentTimeMillis();
            }
        }
    }

    public int getScreenRotationOnPhone(Context context) {
        int i;
        try {
            i = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        } catch (Throwable unused) {
            i = 0;
        }
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0 : -90;
            }
            return 180;
        }
        return 90;
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMapLoadedListener
    public void onMapLoaded() {
        this.n = true;
        RVLogger.d(this.f7205a, "onMapLoaded");
        a(this.f, this.d);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void drawingPolygonOptions(List<String> list) {
        if (this.mAMap == null || list == null || list.size() == 0) {
            return;
        }
        AdapterPolygonOptions adapterPolygonOptions = new AdapterPolygonOptions(this.mAMap);
        AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(this.mAMap);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split(",");
            if (split != null && split.length == 2) {
                try {
                    AdapterLatLng adapterLatLng = new AdapterLatLng(this.mAMap, Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                    adapterPolygonOptions.add(adapterLatLng);
                    adapterLatLngBounds.include(adapterLatLng);
                } catch (Exception unused) {
                }
            }
        }
        adapterPolygonOptions.fillColor(Color.argb(77, 253, 88, 77)).strokeColor(Color.argb(255, 253, 88, 77)).strokeWidth(2.0f);
        this.mAMap.addPolygon(adapterPolygonOptions);
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void drawingCircle(Double d, Double d2, Double d3) {
        if (this.mAMap == null) {
            return;
        }
        this.mAMap.addCircle(new AdapterCircleOptions(this.mAMap).center(new AdapterLatLng(this.mAMap, d.doubleValue(), d2.doubleValue())).radius(d3.doubleValue()).strokeColor(Color.argb(255, 253, 88, 77)).fillColor(Color.argb(77, 253, 88, 77)).strokeWidth(2.0f));
    }

    @Override // com.alipay.mobile.map.widget.APMapView
    public void setHiddenInfo(String str) {
        this.H = str;
    }
}
