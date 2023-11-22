package com.alipay.mobile.beehive.poiselect.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.map.R;
import com.alibaba.griver.ui.ant.AUImageView;
import com.alibaba.griver.ui.ant.AUTitleBar;
import com.alibaba.griver.ui.ant.layout.AUFrameLayout;
import com.alibaba.griver.ui.ant.listview.AUListView;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.alipay.android.mapassist.util.Constants;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.apmap.AdapterMapView;
import com.alipay.mobile.apmap.AdapterUiSettings;
import com.alipay.mobile.apmap.OnAdapterMapReadyCallback;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.apmap.model.AdapterMyLocationStyle;
import com.alipay.mobile.beehive.poiselect.adapter.PoiListAdapter;
import com.alipay.mobile.beehive.poiselect.api.OnPoiSelectedListener;
import com.alipay.mobile.beehive.poiselect.api.PoiItemExt;
import com.alipay.mobile.beehive.poiselect.api.PoiSelectParams;
import com.alipay.mobile.common.lbs.LBSLocation;
import com.alipay.mobile.common.lbs.LBSLocationRequest;
import com.alipay.mobile.framework.service.GeocodeService;
import com.alipay.mobile.framework.service.LBSLocationManagerService;
import com.alipay.mobile.framework.service.OnLBSLocationListener;
import com.alipay.mobile.framework.service.OnPoiSearchListener;
import com.alipay.mobile.map.exception.GeocodeException;
import com.alipay.mobile.map.log.MapLoggerFactory;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.SearchPoiRequest;
import com.alipay.mobile.map.model.geocode.PoiItem;
import com.alipay.mobile.map.model.geocode.ReGeocodeResult;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class PoiListFragment extends BasePoiFragment implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    private static int M = 1;
    private boolean A;
    private AdapterCameraPosition B;
    private boolean C;
    private View D;
    private long E;
    private boolean J;

    /* renamed from: a */
    private AdapterAMap f7120a;
    public String appKey;
    private View b;
    private boolean c;
    public String city;
    private PoiListAdapter d;
    private int f;
    private boolean g;
    private String h;
    private LBSLocation i;
    public boolean isOverseas;
    private boolean j;
    private boolean k;
    public String keyword;
    protected AUListView listView;
    protected AUImageView mIVMyLocation;
    protected AUFrameLayout mLayoutMapContainer;
    protected AdapterMapView mMapView;
    private View n;

    /* renamed from: o */
    private View f7121o;
    private View p;
    protected PoiSelectParams params;
    private AdapterMarker s;
    private AdapterMarker t;
    public String title;
    protected AUTitleBar titleBar;
    private PoiItem v;
    private int w;
    private LoadData x;
    private PoiItem y;
    private PoiItem z;
    public static final byte[] $$a = {42, -48, 107, -19, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 179;
    public static final byte[] MyBillsEntityDataFactory = {114, -124, TarHeader.LF_CONTIG, 72, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 118;
    private List<PoiItem> e = new ArrayList();
    private double l = -999999.0d;
    private double m = -999999.0d;
    private boolean q = false;
    private boolean r = true;
    private boolean u = true;
    private Handler F = new Handler(Looper.getMainLooper());
    private Runnable G = new Runnable() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.1
        {
            PoiListFragment.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PoiListFragment.this.k) {
                PoiListFragment poiListFragment = PoiListFragment.this;
                poiListFragment.addOrUpdateCenterMarker(poiListFragment.params.latitude, PoiListFragment.this.params.longitude);
                PoiListFragment.this.f7120a.moveCamera(AdapterCameraUpdateFactory.newLatLngZoom(new AdapterLatLng(PoiListFragment.this.f7120a, PoiListFragment.this.params.latitude, PoiListFragment.this.params.longitude), PoiListFragment.this.params.scale));
            }
        }
    };
    private Runnable H = new Runnable() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.2
        {
            PoiListFragment.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.2.1
                {
                    AnonymousClass2.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PoiListFragment.this.queryNearbyLocationsAndShowFooter(true);
                    if (PoiListFragment.this.i != null) {
                        if (PoiListFragment.this.i.getLatitude() == PoiListFragment.this.m && PoiListFragment.this.i.getLatitude() == PoiListFragment.this.l) {
                            return;
                        }
                        PoiListFragment.this.addOrUpdateCurrLocationHeader(null);
                    }
                }
            });
        }
    };
    private boolean I = true;
    private volatile boolean K = false;
    private volatile float L = 16.0f;
    private OnPoiSearchListener N = new OnPoiSearchListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.7
        {
            PoiListFragment.this = this;
        }

        @Override // com.alipay.mobile.framework.service.OnPoiSearchListener
        public void onPoiSearched(List<PoiItem> list, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPoiSearched: items=");
            sb.append(list);
            sb.append(" pageNum=");
            sb.append(i);
            sb.append(" pageCount=");
            sb.append(i2);
            GriverLogger.d("GriverMapPoiListFragment", sb.toString());
            PoiListFragment.this.c = true;
            PoiListFragment.this.finishRefresh();
            if (list != null) {
                PoiListFragment.this.g = i < i2 - 1 && (i + 1) * 20 < 40;
                if (PoiListFragment.this.g) {
                    PoiListFragment.this.f = i + 1;
                }
                PoiListFragment.this.updateList(list, true);
            }
        }
    };
    private OnPoiSearchListener O = new OnPoiSearchListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.9
        {
            PoiListFragment.this = this;
        }

        @Override // com.alipay.mobile.framework.service.OnPoiSearchListener
        public void onPoiSearched(List<PoiItem> list, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPoiSearched: items=");
            sb.append(list);
            sb.append(" pageNum=");
            sb.append(i);
            sb.append(" pageCount=");
            sb.append(i2);
            GriverLogger.d("GriverMapPoiListFragment", sb.toString());
            PoiListFragment.this.c = true;
            PoiListFragment.this.finishRefresh();
            if (list != null) {
                PoiListFragment.this.g = i < i2 - 1 && (i + 1) * 20 < 40;
                if (PoiListFragment.this.g) {
                    PoiListFragment.this.f = i + 1;
                }
                PoiListFragment.this.updateList(list, false);
                if (PoiListFragment.this.getActivity() == null) {
                    return;
                }
                PoiListFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.9.1
                    {
                        AnonymousClass9.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PoiListFragment.this.listView.setSelection(0);
                    }
                });
            }
        }
    };

    /* loaded from: classes6.dex */
    public static class LoadData {
        public PoiItem mSearchItem;
        public String mSearchKeyword;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void P(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = r8 + 4
            byte[] r0 = com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.MyBillsEntityDataFactory
            int r7 = r7 + 105
            int r6 = r6 * 4
            int r6 = 16 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r6
            r4 = r8
            r3 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.P(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void Q(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.$$a
            int r6 = r6 * 4
            int r6 = 42 - r6
            int r8 = r8 * 3
            int r8 = 3 - r8
            int r7 = r7 * 3
            int r7 = 75 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.Q(short, short, short, java.lang.Object[]):void");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b2 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr = new Object[1];
            P(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            P(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    Q(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-998035774, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - TextUtils.getOffsetBefore("", 0), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(bundle);
                if (getArguments() != null) {
                    this.params = (PoiSelectParams) getArguments().getParcelable(PoiSelectActivity.KEY_POI_PARAMS);
                }
                if (this.params == null) {
                    this.params = new PoiSelectParams();
                }
                this.l = this.params.longitude;
                this.m = this.params.latitude;
                this.title = this.params.title;
                this.appKey = this.params.appKey;
                this.city = this.params.city;
                this.keyword = this.params.keyword;
                if (TextUtils.isEmpty(this.appKey)) {
                    this.appKey = Constants.POI_APPKEY;
                }
                if (!b()) {
                    this.r = false;
                }
                this.A = this.params.isShowConfirmSelectBtn;
                this.I = !TextUtils.equals(GriverConfig.getConfigWithProcessCache("poi_repair_empty_attrs", ""), "0");
                StringBuilder sb = new StringBuilder();
                sb.append("onCreate: params=");
                sb.append(this.params);
                GriverLogger.d("GriverMapPoiListFragment", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onCreate: params scale=");
                sb2.append(this.params.scale);
                GriverLogger.d("GriverMapPoiListFragment", sb2.toString());
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.griver_map_fragment_poi_list, viewGroup, false);
        this.listView = (AUListView) inflate.findViewById(R.id.poi_list);
        this.titleBar = (AUTitleBar) inflate.findViewById(R.id.title_bar);
        this.mMapView = (AdapterMapView) inflate.findViewById(R.id.map);
        this.mIVMyLocation = (AUImageView) inflate.findViewById(R.id.map_my_location);
        this.mLayoutMapContainer = (AUFrameLayout) inflate.findViewById(R.id.map_container);
        return inflate;
    }

    private void a(Bundle bundle) {
        this.mMapView.onCreate(bundle);
        this.mMapView.setOnTouchListener(new View.OnTouchListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.3
            {
                PoiListFragment.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (PoiListFragment.this.k) {
                    PoiListFragment.this.k = false;
                }
                return false;
            }
        });
        this.mMapView.getMap(new OnAdapterMapReadyCallback() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.4
            {
                PoiListFragment.this = this;
            }

            @Override // com.alipay.mobile.apmap.OnAdapterMapReadyCallback
            public void onAdapterMapReady(AdapterAMap adapterAMap) {
                if (!PoiListFragment.this.b()) {
                    PoiListFragment.this.mLayoutMapContainer.setVisibility(8);
                }
                PoiListFragment.this.f7120a = adapterAMap;
                PoiListFragment.this.f7120a.setMyLocationEnabled(true);
                AdapterMyLocationStyle adapterMyLocationStyle = new AdapterMyLocationStyle(PoiListFragment.this.f7120a);
                adapterMyLocationStyle.strokeColor(0);
                adapterMyLocationStyle.radiusFillColor(0);
                adapterMyLocationStyle.myLocationType(5);
                PoiListFragment.this.f7120a.setMyLocationStyle(adapterMyLocationStyle);
                PoiListFragment.this.f7120a.setOnMapLoadedListener(new AdapterAMap.OnAdapterMapLoadedListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.4.1
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMapLoadedListener
                    public void onMapLoaded() {
                        if (PoiListFragment.this.E == 0) {
                            PoiListFragment.this.E = System.currentTimeMillis();
                        }
                        if (PoiListFragment.this.b()) {
                            PoiListFragment.this.a();
                        }
                        PoiListFragment.this.K = true;
                    }
                });
                AdapterUiSettings uiSettings = PoiListFragment.this.f7120a.getUiSettings();
                if (uiSettings != null) {
                    uiSettings.setMyLocationButtonEnabled(false);
                    uiSettings.setZoomControlsEnabled(false);
                    uiSettings.setRotateGesturesEnabled(false);
                    uiSettings.setTiltGesturesEnabled(false);
                    uiSettings.setZoomInByScreenCenter(true);
                    uiSettings.setGestureScaleByMapCenter(true);
                    uiSettings.setScaleControlsEnabled(true);
                }
                PoiListFragment.this.mIVMyLocation.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.4.2
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PoiListFragment.this.k = false;
                        PoiListFragment.this.l = -999999.0d;
                        PoiListFragment.this.m = -999999.0d;
                        PoiListFragment.this.addOrUpdateCurrLocationHeader(null);
                        PoiListFragment.this.n();
                    }
                });
                if (!PoiListFragment.this.b()) {
                    PoiListFragment.this.mLayoutMapContainer.setVisibility(8);
                    return;
                }
                if (PoiListFragment.this.params.fullMap) {
                    if (PoiListFragment.this.mLayoutMapContainer != null) {
                        ViewGroup.LayoutParams layoutParams = PoiListFragment.this.mLayoutMapContainer.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = -1;
                        }
                        PoiListFragment.this.mLayoutMapContainer.setLayoutParams(layoutParams);
                    }
                    if (PoiListFragment.this.listView != null) {
                        PoiListFragment.this.listView.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(PoiListFragment.this.params.markerTitle)) {
                        PoiListFragment.this.f7120a.setInfoWindowAdapter(new AdapterAMap.AdapterInfoWindowAdapter() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.4.3

                            /* renamed from: a */
                            private View f7122a;
                            private TextView b;

                            @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterInfoWindowAdapter
                            public View getInfoContents(AdapterMarker adapterMarker) {
                                return null;
                            }

                            {
                                AnonymousClass4.this = this;
                            }

                            @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterInfoWindowAdapter
                            public View getInfoWindow(AdapterMarker adapterMarker) {
                                if (this.f7122a == null) {
                                    View inflate = LayoutInflater.from(PoiListFragment.this.getContext()).inflate(R.layout.griver_map_custom_info_window, (ViewGroup) null);
                                    this.f7122a = inflate;
                                    TextView textView = (TextView) inflate.findViewById(R.id.title);
                                    this.b = textView;
                                    DisplayMetrics displayMetrics = textView.getContext().getResources().getDisplayMetrics();
                                    int i = displayMetrics.widthPixels;
                                    int i2 = (int) (displayMetrics.density * 8.0f);
                                    int lineHeight = ((displayMetrics.heightPixels / 2) - (((int) (displayMetrics.density * 48.0f)) * 2)) / this.b.getLineHeight();
                                    if (lineHeight <= 1) {
                                        lineHeight = 1;
                                    }
                                    this.b.setMaxWidth(i - (i2 * 2));
                                    this.b.setMaxLines(lineHeight);
                                }
                                this.b.setText(adapterMarker.getTitle());
                                return this.f7122a;
                            }
                        });
                    }
                }
                if (PoiListFragment.this.params.latitude != -999999.0d && PoiListFragment.this.params.longitude != -999999.0d) {
                    PoiListFragment.this.k = true;
                    PoiListFragment.this.G.run();
                }
                PoiListFragment.this.f7120a.setOnCameraChangeListener(new AdapterAMap.OnAdapterCameraChangeListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.4.4
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterCameraChangeListener
                    public void onCameraChange(AdapterCameraPosition adapterCameraPosition) {
                        if (adapterCameraPosition.getGoogleMapCameraPosition().zoom == PoiListFragment.this.L && PoiListFragment.this.K) {
                            PoiListFragment.this.addOrUpdateCenterMarker(adapterCameraPosition.target.getLatitude(), adapterCameraPosition.target.getLongitude());
                            if (PoiListFragment.this.k && PoiListFragment.this.f7120a.is2dMapSdk()) {
                                PoiListFragment.this.F.removeCallbacks(PoiListFragment.this.H);
                                if (PoiListFragment.this.params.latitude == adapterCameraPosition.target.getLatitude() && PoiListFragment.this.params.longitude == adapterCameraPosition.target.getLongitude()) {
                                    return;
                                }
                                if (PoiListFragment.this.E == 0 || System.currentTimeMillis() - PoiListFragment.this.E < 3000) {
                                    PoiListFragment.this.F.removeCallbacks(PoiListFragment.this.G);
                                    PoiListFragment.this.F.postDelayed(PoiListFragment.this.G, 50L);
                                }
                            }
                        }
                    }

                    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterCameraChangeListener
                    public void onCameraChangeFinish(AdapterCameraPosition adapterCameraPosition) {
                        if (adapterCameraPosition.getGoogleMapCameraPosition().zoom == PoiListFragment.this.L) {
                            if (PoiListFragment.this.K && adapterCameraPosition != null) {
                                if (adapterCameraPosition.isAbroad && !PoiListFragment.this.J && PoiListFragment.this.params != null && !TextUtils.isEmpty(PoiListFragment.this.params.appId)) {
                                    PoiListFragment.this.J = true;
                                    MapLoggerFactory.getBusinessLogger().logJsApiCall(PoiListFragment.this.getContext(), PoiListFragment.this.params.appId, "renderAbroad");
                                }
                                if (PoiListFragment.this.B == null || !adapterCameraPosition.target.equals(PoiListFragment.this.B.target)) {
                                    PoiListFragment.this.B = adapterCameraPosition;
                                    PoiListFragment.this.addOrUpdateCenterMarker(adapterCameraPosition.target.getLatitude(), adapterCameraPosition.target.getLongitude());
                                    if (!PoiListFragment.this.u) {
                                        PoiListFragment.this.u = true;
                                        return;
                                    }
                                    PoiListFragment.this.m = adapterCameraPosition.target.getLatitude();
                                    PoiListFragment.this.l = adapterCameraPosition.target.getLongitude();
                                    if (!PoiListFragment.this.k || !PoiListFragment.this.f7120a.is2dMapSdk()) {
                                        PoiListFragment.this.H.run();
                                    } else {
                                        PoiListFragment.this.F.removeCallbacks(PoiListFragment.this.H);
                                        PoiListFragment.this.F.postDelayed(PoiListFragment.this.H, 200L);
                                    }
                                    if (PoiListFragment.this.x == null || PoiListFragment.this.x.mSearchItem == null) {
                                        return;
                                    }
                                    if (PoiListFragment.this.x.mSearchItem.getLatLonPoint().getLatitude() == PoiListFragment.this.m && PoiListFragment.this.x.mSearchItem.getLatLonPoint().getLatitude() == PoiListFragment.this.l) {
                                        return;
                                    }
                                    PoiListFragment.this.x = null;
                                    PoiListFragment.this.d.setKeyword(null);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        PoiListFragment.this.L = adapterCameraPosition.getGoogleMapCameraPosition().zoom;
                    }
                });
            }
        });
    }

    public void a() {
        if (this.C) {
            return;
        }
        this.C = true;
        if (this.l == -999999.0d || this.m == -999999.0d) {
            this.b.setVisibility(0);
            n();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityCreated:  longitude=");
        sb.append(this.l);
        sb.append(" latitude=");
        sb.append(this.m);
        sb.append(" locatedCity=");
        sb.append(this.h);
        GriverLogger.d("GriverMapPoiListFragment", sb.toString());
        d();
        c();
        this.titleBar.setVisibility(0);
        a(bundle);
    }

    public boolean b() {
        return "default".equals(this.params.mode);
    }

    private void c() {
        this.titleBar.setRightButtonText(getString(R.string.griver_map_send_btn));
        if (!TextUtils.isEmpty(this.params.sendBtnText)) {
            this.titleBar.setRightButtonText(this.params.sendBtnText);
        }
        if (!TextUtils.isEmpty(this.title)) {
            this.titleBar.setTitleText(this.title);
        } else {
            this.titleBar.setTitleText(getResources().getString(R.string.griver_map_location));
        }
        if (this.params.hideSearch) {
            this.titleBar.getLeftButton().setVisibility(8);
        } else {
            this.titleBar.setLeftButtonFont(DensityUtil.dip2px(getContext(), 24.0f), -12481310, false);
            this.titleBar.setLeftButtonIcon(getString(R.string.griver_iconfont_search));
            this.titleBar.getLeftButton().setContentDescription(getString(R.string.griver_map_search_location));
        }
        this.titleBar.getRightButton().setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.5
            {
                PoiListFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PoiListFragment.this.titleBar.getRightButton().setEnabled(false);
                if (PoiListFragment.this.v == null) {
                    ToastUtils.showToast(PoiListFragment.this.getActivity(), PoiListFragment.this.getString(R.string.griver_map_choose_location), 0);
                    PoiListFragment.this.titleBar.getRightButton().setEnabled(true);
                    return;
                }
                PoiListFragment poiListFragment = PoiListFragment.this;
                poiListFragment.a(poiListFragment.v, PoiListFragment.this.w, (Bitmap) null);
            }
        });
        this.titleBar.getLeftButton().setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.6
            {
                PoiListFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PoiListFragment.this.i();
            }
        });
        if (this.A) {
            return;
        }
        this.titleBar.getRightButton().setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.k = false;
        this.F.removeCallbacks(this.G);
        AdapterMapView adapterMapView = this.mMapView;
        if (adapterMapView != null) {
            adapterMapView.onDestroy();
        }
        this.f7120a = null;
    }

    private void d() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.griver_map_footer_load_more, (ViewGroup) this.listView, false);
        this.b = inflate;
        inflate.setVisibility(8);
        this.listView.setOnScrollListener(this);
        this.listView.setOnItemClickListener(this);
        this.listView.setFooterDividersEnabled(false);
        this.listView.setHeaderDividersEnabled(false);
        this.listView.addFooterView(LayoutInflater.from(getActivity()).inflate(R.layout.griver_map_footer_divider, (ViewGroup) this.listView, false), null, false);
        this.listView.addFooterView(this.b, null, false);
        e();
        PoiListAdapter poiListAdapter = new PoiListAdapter(getActivity(), this.e, true);
        this.d = poiListAdapter;
        poiListAdapter.setShowPoiActions(this.params.showPoiActions);
        this.d.setShowPoiDistance(this.params.showPoiDistance);
        this.listView.setAdapter((ListAdapter) this.d);
        this.c = true;
    }

    private void e() {
        f();
        m();
        g();
        h();
        addOrUpdateLocatedCityHeader(this.h, null);
        if (!TextUtils.isEmpty(this.params.name)) {
            PoiItem poiItem = new PoiItem();
            poiItem.setTitle(this.params.name);
            poiItem.setSnippet(this.params.addr);
            poiItem.setPoiId(this.params.poiId);
            poiItem.setShopID(this.params.shopId);
            if (this.params.prePOILat != -999999.0d && this.params.prePOILon != -999999.0d) {
                poiItem.setLatLonPoint(new LatLonPoint(this.params.prePOILat, this.params.prePOILon));
            }
            addOrUpdateCurrLocationHeader(poiItem);
            return;
        }
        this.f7121o.setVisibility(8);
    }

    private void f() {
        this.n = LayoutInflater.from(getActivity()).inflate(R.layout.griver_map_header_hide_location, (ViewGroup) this.listView, false);
        if (TextUtils.isEmpty(this.params.name)) {
            this.n.findViewById(R.id.poiselect_selection_mark).setVisibility(0);
        }
        this.listView.addHeaderView(createListViewHeader(getActivity(), this.n), null, true);
        if (this.params.showHideLocation) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    protected void addOrUpdateCurrLocationHeader(PoiItem poiItem) {
        if (poiItem == null) {
            this.z = null;
            this.f7121o.setVisibility(8);
            return;
        }
        ((AUTextView) this.f7121o.findViewById(R.id.poiselect_header_title)).setText(poiItem.getTitle());
        AUTextView aUTextView = (AUTextView) this.f7121o.findViewById(R.id.poiselect_addr);
        if (!TextUtils.isEmpty(poiItem.getSnippet())) {
            aUTextView.setVisibility(0);
            aUTextView.setText(poiItem.getSnippet());
        } else {
            aUTextView.setVisibility(8);
        }
        if (b() && TextUtils.isEmpty(poiItem.getPoiId())) {
            ((AUTextView) this.f7121o.findViewById(R.id.poiselect_header_title)).setText(poiItem.getSnippet());
            aUTextView.setVisibility(8);
        }
        this.z = poiItem;
        this.v = poiItem;
        a(this.p);
        b(this.f7121o);
    }

    private void g() {
        if (this.D != null || this.params.locatePOI == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.griver_map_header_current_location, (ViewGroup) this.listView, false);
        this.D = inflate;
        ((AUTextView) inflate.findViewById(R.id.poiselect_header_title)).setText(this.params.locatePOI.getTitle());
        ((AUTextView) this.D.findViewById(R.id.poiselect_addr)).setText(this.params.locatePOI.getSnippet());
        a(this.D);
        this.listView.addHeaderView(createListViewHeader(getActivity(), this.D), this.params.locatePOI, true);
    }

    private void h() {
        if (this.f7121o == null) {
            this.f7121o = LayoutInflater.from(getActivity()).inflate(R.layout.griver_map_header_current_location, (ViewGroup) this.listView, false);
            PoiItem poiItem = new PoiItem();
            poiItem.setPoiId("currLocationHeader");
            this.listView.addHeaderView(createListViewHeader(getActivity(), this.f7121o), poiItem, true);
        }
    }

    public void i() {
        getActivity().startActivityForResult(new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG)).build(getActivity()), M);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PoiItem poiItem;
        this.w = i;
        this.v = (PoiItem) adapterView.getAdapter().getItem(i);
        a(this.p);
        a(this.f7121o);
        PoiItem poiItem2 = this.v;
        if (poiItem2 != null) {
            if ("locatedCityHeader".equals(poiItem2.getPoiId())) {
                this.v = this.y;
                b(this.p);
            } else if ("currLocationHeader".equals(this.v.getPoiId())) {
                this.v = this.z;
                b(this.f7121o);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onItemClick: item=");
        sb.append(this.v);
        GriverLogger.d("GriverMapPoiListFragment", sb.toString());
        if (i >= this.listView.getHeaderViewsCount()) {
            this.d.setSelection(i - this.listView.getHeaderViewsCount());
            this.d.notifyDataSetChanged();
        } else {
            this.d.setSelection(-1);
            this.d.notifyDataSetChanged();
        }
        j();
        if (this.r && (poiItem = this.v) != null && poiItem.getLatLonPoint() != null) {
            a(this.v.getLatLonPoint().getLatitude(), this.v.getLatLonPoint().getLongitude(), false);
        } else {
            a(this.v, i, (Bitmap) null);
        }
    }

    private void j() {
        View view = this.n;
        if (view != null) {
            view.findViewById(R.id.poiselect_selection_mark).setVisibility(8);
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.findViewById(R.id.poiselect_selection_mark).setVisibility(8);
        ((AUTextView) view.findViewById(R.id.poiselect_header_title)).setTextColor(getResources().getColor(R.color.griver_map_poi_title_color));
        AUTextView aUTextView = (AUTextView) view.findViewById(R.id.poiselect_addr);
        if (aUTextView != null) {
            aUTextView.setTextColor(getResources().getColor(R.color.griver_map_poi_desc_color));
        }
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        if (this.params.showPoiActions) {
            view.findViewById(R.id.poiselect_selection_mark).setVisibility(8);
        } else {
            view.findViewById(R.id.poiselect_selection_mark).setVisibility(0);
        }
        ((AUTextView) view.findViewById(R.id.poiselect_header_title)).setTextColor(getResources().getColor(R.color.griver_AU_COLOR_LINK));
        AUTextView aUTextView = (AUTextView) view.findViewById(R.id.poiselect_addr);
        if (aUTextView != null) {
            aUTextView.setTextColor(getResources().getColor(R.color.griver_AU_COLOR_LINK));
        }
        this.d.setSelection(-1);
        this.d.notifyDataSetChanged();
    }

    public void a(PoiItem poiItem, int i, Bitmap bitmap) {
        List<Address> list;
        try {
            list = new Geocoder(getActivity(), Locale.getDefault()).getFromLocation(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude(), 1);
        } catch (Exception e) {
            GriverLogger.e("GriverMapPoiListFragment", "geo code failed", e);
            list = null;
        }
        if (list == null || list.size() == 0) {
            GriverLogger.d("GriverMapPoiListFragment", "geo code empty");
        } else {
            Address address = list.get(0);
            poiItem.setCountry(address.getCountryName());
            poiItem.setProvinceName(address.getAdminArea());
            poiItem.setCityName(address.getLocality());
            GriverLogger.d("GriverMapPoiListFragment", JSON.toJSONString(address));
        }
        OnPoiSelectedListener poiSelectListener = findPoiSelectService().getPoiSelectListener();
        if (poiSelectListener != null) {
            if (poiItem == null) {
                poiSelectListener.onHideLocationSelected();
            } else {
                PoiItemExt poiItemExt = new PoiItemExt(poiItem, this.isOverseas);
                poiItemExt.setResizeBmp(bitmap);
                poiSelectListener.onPoiSelected(poiItemExt);
            }
        }
        this.titleBar.getRightButton().setEnabled(true);
        getActivity().finish();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.c && this.g) {
            this.c = false;
            this.b.setVisibility(0);
            loadMoreData();
        }
    }

    protected void loadMoreData() {
        GriverLogger.d("GriverMapPoiListFragment", "loadMoreData()");
        GeocodeService geocodeService = getGeocodeService();
        if (geocodeService == null) {
            finishRefresh();
            return;
        }
        this.c = false;
        LatLonPoint latLonPoint = new LatLonPoint(this.m, this.l);
        SearchPoiRequest searchPoiRequest = new SearchPoiRequest();
        searchPoiRequest.setByfoursquare(this.isOverseas);
        searchPoiRequest.setPagesize(20);
        searchPoiRequest.setPagenum(this.f);
        if (!TextUtils.isEmpty(this.params.poiType)) {
            searchPoiRequest.setTypes(this.params.poiType);
        }
        if (this.params.radius > 0) {
            searchPoiRequest.setRadius(this.params.radius);
        }
        a(latLonPoint, searchPoiRequest);
        geocodeService.searchpoi(GriverEnv.getApplicationContext(), this.appKey, this.N, searchPoiRequest);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 != -1) {
            if (i2 == 2) {
                GriverLogger.d("GriverMapPoiListFragment", Autocomplete.getStatusFromIntent(intent).getStatusMessage());
            }
        } else {
            Place placeFromIntent = Autocomplete.getPlaceFromIntent(intent);
            LoadData loadData = new LoadData();
            PoiItem poiItem = new PoiItem();
            poiItem.setLatLonPoint(new LatLonPoint(placeFromIntent.getLatLng().latitude, placeFromIntent.getLatLng().longitude));
            poiItem.setTitle(placeFromIntent.getName());
            poiItem.setSnippet(placeFromIntent.getAddress());
            poiItem.setPoiId(placeFromIntent.getId());
            loadData.mSearchItem = poiItem;
            loadData.mSearchKeyword = placeFromIntent.getName();
            onLoadEvent(loadData);
        }
    }

    protected void queryNearbyLocations(final boolean z) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.8
            {
                PoiListFragment.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    PoiListFragment.this.k();
                }
                PoiListFragment.this.updateList(new ArrayList(), false);
                GriverLogger.d("GriverMapPoiListFragment", "queryNearbyLocations()");
                GeocodeService geocodeService = PoiListFragment.this.getGeocodeService();
                if (geocodeService != null) {
                    PoiListFragment.this.c = false;
                    PoiListFragment.this.l();
                    LatLonPoint latLonPoint = new LatLonPoint(PoiListFragment.this.m, PoiListFragment.this.l);
                    SearchPoiRequest searchPoiRequest = new SearchPoiRequest();
                    searchPoiRequest.setByfoursquare(PoiListFragment.this.isOverseas);
                    if (!TextUtils.isEmpty(PoiListFragment.this.params.poiType)) {
                        searchPoiRequest.setTypes(PoiListFragment.this.params.poiType);
                    }
                    if (PoiListFragment.this.params.radius > 0) {
                        searchPoiRequest.setRadius(PoiListFragment.this.params.radius);
                    }
                    searchPoiRequest.setPagesize(20);
                    searchPoiRequest.setPagenum(0);
                    PoiListFragment.this.a(latLonPoint, searchPoiRequest);
                    geocodeService.searchpoi(GriverEnv.getApplicationContext(), PoiListFragment.this.appKey, PoiListFragment.this.O, searchPoiRequest);
                    return;
                }
                PoiListFragment.this.finishRefresh();
            }
        });
    }

    protected void queryNearbyLocationsAndShowFooter(boolean z) {
        this.b.setVisibility(0);
        queryNearbyLocations(z);
    }

    public void k() {
        GeocodeService geocodeService = getGeocodeService();
        try {
            int i = b() ? 7 : 4;
            LatLonPoint latLonPoint = new LatLonPoint(this.m, this.l);
            ReGeocodeResult reverse = geocodeService.reverse(new LatLonPoint(this.m, this.l), 0.0f, "cdp-sdk-reverse", i);
            this.isOverseas = !PoiSelectParams.CHINA_COUNTRYCODE.equals(reverse.getCountryCode());
            String city = reverse.getCity();
            reverse.setLatlonPoint(latLonPoint);
            if (this.params.showLocatedCity) {
                if (a(city) || b()) {
                    addOrUpdateLocatedCityHeader(city, reverse);
                }
            }
        } catch (GeocodeException e) {
            GriverLogger.e("GriverMapPoiListFragment", "geocodeService reverse error", e);
        }
    }

    private boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.equals(this.h, str) || TextUtils.equals(this.params.name, str)) ? false : true;
    }

    public void a(LatLonPoint latLonPoint, SearchPoiRequest searchPoiRequest) {
        if (!TextUtils.isEmpty(this.city)) {
            searchPoiRequest.setCity(this.city);
        }
        if (!TextUtils.isEmpty(this.keyword)) {
            searchPoiRequest.setKeywords(this.keyword);
        }
        if (!TextUtils.isEmpty(this.city) && !this.j) {
            searchPoiRequest.setLatlng(Constants.INVALID_LATLONPOINT);
        } else {
            searchPoiRequest.setLatlng(latLonPoint);
        }
    }

    public void l() {
        this.f = 0;
        this.g = false;
    }

    protected void updateList(List<PoiItem> list, boolean z) {
        if (getActivity() == null || getActivity().isFinishing() || list == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("updateList: append=");
        sb.append(z);
        GriverLogger.d("GriverMapPoiListFragment", sb.toString());
        if (!z) {
            this.e.clear();
        }
        this.e.addAll(list);
        PoiItem poiItem = this.z;
        if (poiItem != null && !TextUtils.isEmpty(poiItem.getPoiId())) {
            b(this.z.getPoiId());
        }
        if (this.params.locatePOI != null && !TextUtils.isEmpty(this.params.locatePOI.getPoiId())) {
            b(this.params.locatePOI.getPoiId());
        }
        LoadData loadData = this.x;
        if (loadData != null) {
            this.d.setKeyword(loadData.mSearchKeyword);
        }
        if (!z && this.x == null && list.size() > 0) {
            this.d.setSelection(0);
            this.v = list.get(0);
        }
        this.d.notifyDataSetChanged();
    }

    private void b(String str) {
        int i = 0;
        while (true) {
            if (i >= this.e.size()) {
                i = -1;
                break;
            } else if (TextUtils.equals(this.e.get(i).getPoiId(), str)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            this.e.remove(i);
        }
    }

    protected void finishRefresh() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        GriverLogger.d("GriverMapPoiListFragment", "finishRefresh()");
        this.c = true;
        this.b.setVisibility(8);
    }

    protected void addOrUpdateLocatedCityHeader(String str, ReGeocodeResult reGeocodeResult) {
        this.p.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.y = new PoiItem();
        if (b() && (this.i != null || reGeocodeResult != null)) {
            this.y.setTitle(getString(R.string.griver_map_location_));
            if (reGeocodeResult != null && reGeocodeResult.getLatlonPoint() != null) {
                this.y.setLatLonPoint(new LatLonPoint(reGeocodeResult.getLatlonPoint().getLatitude(), reGeocodeResult.getLatlonPoint().getLongitude()));
                this.y.setAdCode(reGeocodeResult.getAdcode());
                this.y.setSnippet(reGeocodeResult.getFormatAddress());
                this.y.setCityCode(reGeocodeResult.getCityCode());
                this.y.setCityName(reGeocodeResult.getCity());
                this.y.setProvinceName(reGeocodeResult.getProvince());
                this.y.setMainland(reGeocodeResult.isChineseMainLand());
                str = reGeocodeResult.getFormatAddress();
                if (TextUtils.isEmpty(str)) {
                    str = reGeocodeResult.getCity();
                }
                if (this.I) {
                    this.y.setAdName(reGeocodeResult.getDistrict());
                }
            } else {
                LBSLocation lBSLocation = this.i;
                if (lBSLocation != null) {
                    this.y.setLatLonPoint(new LatLonPoint(lBSLocation.getLatitude(), this.i.getLongitude()));
                    this.y.setAdCode(this.i.getAdCode());
                    this.y.setSnippet(this.i.getAddress());
                    this.y.setCityCode(this.i.getCityCode());
                    this.y.setCityName(this.i.getCity());
                    this.y.setProvinceName(this.i.getProvince());
                    if (this.i.getReGeocodeResult() != null) {
                        this.y.setMainland(this.i.getReGeocodeResult().isChineseMainLand());
                    }
                    str = this.i.getAddress();
                    if (this.I) {
                        this.y.setAdName(this.i.getDistrict());
                    }
                }
            }
            PoiItem poiItem = this.v;
            if (poiItem == null || poiItem != this.z) {
                this.v = this.y;
                j();
                a(this.f7121o);
                b(this.p);
            }
            if (this.params.showLocatedCity && !TextUtils.isEmpty(str) && !TextUtils.equals(str, this.params.addr)) {
                this.p.setVisibility(0);
            }
        } else {
            this.y.setTitle(str);
            if (this.params.showLocatedCity && !TextUtils.isEmpty(str) && !TextUtils.equals(str, this.params.name)) {
                this.p.setVisibility(0);
            }
        }
        ((AUTextView) this.p.findViewById(R.id.poiselect_header_title)).setText(str);
    }

    private void m() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getActivity()).inflate(R.layout.griver_map_header_located_city, (ViewGroup) this.listView, false);
            PoiItem poiItem = new PoiItem();
            poiItem.setPoiId("locatedCityHeader");
            this.listView.addHeaderView(createListViewHeader(getActivity(), this.p), poiItem, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AdapterMapView adapterMapView = this.mMapView;
        if (adapterMapView != null) {
            adapterMapView.onResume();
        }
        if (!b()) {
            a();
        }
        if (this.q) {
            if ((this.params.showLocatedCity && TextUtils.isEmpty(this.h)) || this.l == -999999.0d || this.m == -999999.0d) {
                this.q = false;
                n();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.q = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AdapterMapView adapterMapView = this.mMapView;
        if (adapterMapView != null) {
            adapterMapView.onPause();
        }
    }

    public void n() {
        GriverLogger.d("GriverMapPoiListFragment", "doStartLocation()");
        LBSLocationManagerService lBSLocationManagerService = getLBSLocationManagerService();
        if (lBSLocationManagerService == null) {
            return;
        }
        LBSLocationRequest lBSLocationRequest = new LBSLocationRequest();
        lBSLocationRequest.setNeedAddress(true);
        lBSLocationRequest.setIsHighAccuracy(false);
        if (b()) {
            lBSLocationRequest.setReGeoLevel(7);
        } else {
            lBSLocationRequest.setReGeoLevel(4);
        }
        lBSLocationRequest.setBizType(Constants.POI_APPKEY);
        lBSLocationManagerService.locationWithRequest(lBSLocationRequest, new OnLBSLocationListener() { // from class: com.alipay.mobile.beehive.poiselect.ui.PoiListFragment.10
            {
                PoiListFragment.this = this;
            }

            @Override // com.alipay.mobile.framework.service.OnLBSLocationListener
            public void onLocationUpdate(LBSLocation lBSLocation) {
                boolean z;
                PoiListFragment.this.i = lBSLocation;
                if (PoiListFragment.this.getActivity() == null || PoiListFragment.this.getActivity().isFinishing()) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onLocationUpdate: location=");
                sb.append(lBSLocation);
                GriverLogger.d("GriverMapPoiListFragment", sb.toString());
                if (lBSLocation != null) {
                    PoiListFragment.this.addOrUpdateMyLocationMarker(lBSLocation.getLatitude(), lBSLocation.getLongitude());
                    if (!PoiListFragment.this.k) {
                        PoiListFragment.this.addOrUpdateCenterMarker(lBSLocation.getLatitude(), lBSLocation.getLongitude());
                    }
                    if (!TextUtils.isEmpty(lBSLocation.getCity())) {
                        PoiListFragment.this.h = lBSLocation.getCity();
                    }
                    boolean z2 = false;
                    if (PoiListFragment.this.l == -999999.0d || PoiListFragment.this.m == -999999.0d) {
                        PoiListFragment.this.l = lBSLocation.getLongitude();
                        PoiListFragment.this.m = lBSLocation.getLatitude();
                        z = false;
                    } else {
                        z = true;
                    }
                    if (lBSLocation.getReGeocodeResult() != null) {
                        PoiListFragment.this.isOverseas = true ^ lBSLocation.getReGeocodeResult().isChina();
                        lBSLocation.getReGeocodeResult().setLatlonPoint(new LatLonPoint(lBSLocation.getLatitude(), lBSLocation.getLongitude()));
                    }
                    if (!PoiListFragment.this.k) {
                        PoiListFragment poiListFragment = PoiListFragment.this;
                        poiListFragment.a(poiListFragment.m, PoiListFragment.this.l, false);
                    }
                    if (PoiListFragment.this.params.showLocatedCity) {
                        if (!PoiListFragment.this.b() || z) {
                            if (!PoiListFragment.this.b() || !z) {
                                if (!TextUtils.isEmpty(PoiListFragment.this.h) && !TextUtils.equals(PoiListFragment.this.h, PoiListFragment.this.params.name)) {
                                    PoiListFragment poiListFragment2 = PoiListFragment.this;
                                    poiListFragment2.addOrUpdateLocatedCityHeader(poiListFragment2.h, null);
                                }
                            }
                            PoiListFragment.this.queryNearbyLocationsAndShowFooter(z2);
                            return;
                        }
                        PoiListFragment poiListFragment3 = PoiListFragment.this;
                        poiListFragment3.addOrUpdateLocatedCityHeader(poiListFragment3.h, lBSLocation.getReGeocodeResult());
                    }
                    z2 = z;
                    PoiListFragment.this.queryNearbyLocationsAndShowFooter(z2);
                    return;
                }
                PoiListFragment.this.finishRefresh();
            }

            @Override // com.alipay.mobile.framework.service.OnLBSLocationListener
            public void onLocationFailed(int i) {
                if (PoiListFragment.this.getActivity() == null || PoiListFragment.this.getActivity().isFinishing()) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onLocationFailed: errCode=");
                sb.append(i);
                GriverLogger.d("GriverMapPoiListFragment", sb.toString());
                PoiListFragment.this.finishRefresh();
                MapLoggerFactory.getBusinessLogger().logJsApiError(PoiListFragment.this.getActivity(), PoiListFragment.this.params.appId, "chooseLocation", i, "onLocationFailed");
            }
        });
    }

    public void a(double d, double d2, boolean z) {
        this.u = z;
        if (this.f7120a == null) {
            return;
        }
        this.f7120a.moveCamera(AdapterCameraUpdateFactory.newLatLngZoom(new AdapterLatLng(this.f7120a, d, d2), 16.0f));
    }

    protected void addOrUpdateCenterMarker(double d, double d2) {
        AdapterMarker adapterMarker;
        AdapterMarker adapterMarker2 = this.t;
        if (adapterMarker2 == null) {
            AdapterAMap adapterAMap = this.f7120a;
            if (adapterAMap == null) {
                return;
            }
            this.t = adapterAMap.addMarker(a(new AdapterLatLng(this.f7120a, d, d2)));
        } else {
            adapterMarker2.setPosition(new AdapterLatLng(this.f7120a, d, d2));
        }
        PoiSelectParams poiSelectParams = this.params;
        if (poiSelectParams == null || !poiSelectParams.fullMap || TextUtils.isEmpty(this.params.markerTitle) || (adapterMarker = this.t) == null || adapterMarker.isInfoWindowShown()) {
            return;
        }
        this.t.setTitle(this.params.markerTitle);
        this.t.showInfoWindow();
    }

    protected void addOrUpdateMyLocationMarker(double d, double d2) {
        AdapterMarker adapterMarker = this.s;
        if (adapterMarker == null) {
            AdapterAMap adapterAMap = this.f7120a;
            if (adapterAMap == null) {
                return;
            }
            this.s = adapterAMap.addMarker(a(new AdapterLatLng(this.f7120a, d, d2), R.drawable.griver_map_icon_my_location));
            return;
        }
        adapterMarker.setPosition(new AdapterLatLng(this.f7120a, d, d2));
    }

    private AdapterMarkerOptions a(AdapterLatLng adapterLatLng, int i) {
        AdapterMarkerOptions adapterMarkerOptions = new AdapterMarkerOptions(this.f7120a);
        adapterMarkerOptions.position(adapterLatLng);
        adapterMarkerOptions.draggable(false);
        adapterMarkerOptions.zIndex(100.0f);
        adapterMarkerOptions.anchor(0.5f, 0.45f);
        adapterMarkerOptions.icon(AdapterBitmapDescriptorFactory.fromBitmap(this.f7120a, BitmapFactory.decodeResource(getResources(), i)));
        return adapterMarkerOptions;
    }

    private AdapterMarkerOptions a(AdapterLatLng adapterLatLng) {
        AdapterMarkerOptions adapterMarkerOptions = new AdapterMarkerOptions(this.f7120a);
        adapterMarkerOptions.position(adapterLatLng);
        adapterMarkerOptions.draggable(false);
        adapterMarkerOptions.zIndex(500.0f);
        adapterMarkerOptions.anchor(0.5f, 1.0f);
        adapterMarkerOptions.icon(AdapterBitmapDescriptorFactory.fromBitmap(this.f7120a, BitmapFactory.decodeResource(getResources(), R.drawable.griver_map_icon_center_location)));
        return adapterMarkerOptions;
    }

    public void onLoadEvent(LoadData loadData) {
        if (b()) {
            this.x = loadData;
            PoiItem poiItem = loadData.mSearchItem;
            if (poiItem != null) {
                addOrUpdateCurrLocationHeader(poiItem);
                this.p.setVisibility(8);
                this.m = poiItem.getLatLonPoint().getLatitude();
                this.l = poiItem.getLatLonPoint().getLongitude();
                a(poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude(), false);
                queryNearbyLocationsAndShowFooter(false);
            }
        }
    }
}
