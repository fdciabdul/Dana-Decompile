package com.alipay.mobile.embedview.mapbiz.core;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alipay.mobile.apmap.animation.AdapterAnimation;
import com.alipay.mobile.apmap.animation.AdapterTranslateAnimation;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.Range;
import com.alipay.mobile.embedview.mapbiz.marker.grid.CellTarget;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class H5MapMarker implements CellTarget {
    public static final int ANIM_STATE_CLUSTER = 0;
    public static final int ANIM_STATE_UN_CLUSTER = 1;
    public AdapterLatLng clusterRootPosition;
    public final String contextId;
    public boolean debuggable;

    /* renamed from: id  reason: collision with root package name */
    public String f7140id;
    protected volatile Set<H5MapMarker> mClusterChildren;
    protected H5MapMarker mClusterRoot;
    protected boolean mClustered;
    protected List<Range> mDisplayRanges;
    protected volatile boolean mIconSuccess;
    protected AdapterLatLng mPosition;
    protected int mZIndex;
    public Marker marker;
    public final AdapterMarker markerContext;
    public Point screenLocation;
    public static final byte[] $$a = {83, -75, 7, 97, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 165;
    public static final byte[] MyBillsEntityDataFactory = {112, 91, -28, 61, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = FileUtils.JPEG_MARKER_EOI;
    protected final AtomicLong mMarkerToken = new AtomicLong(0);
    protected boolean mVisible = true;
    protected AtomicLong mClusterAnimationToken = new AtomicLong();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.MyBillsEntityDataFactory
            int r6 = 106 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
            r5 = r8
            r8 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L35:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + 2
            int r6 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.c(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r6 = r6 * 2
            int r6 = 75 - r6
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1c:
            r3 = 0
        L1d:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L39:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.d(short, short, byte, java.lang.Object[]):void");
    }

    public H5MapMarker(Marker marker, AdapterMarker adapterMarker) {
        this.f7140id = marker.f7175id;
        this.contextId = adapterMarker.getId();
        this.marker = marker;
        this.markerContext = adapterMarker;
        this.mDisplayRanges = marker.displayRanges;
        AdapterLatLng position = adapterMarker.getPosition();
        this.mPosition = new AdapterLatLng(position, position.getLatitude(), position.getLongitude());
        this.mZIndex = marker.markerLevel;
    }

    public AdapterLatLng getPosition() {
        return this.mPosition;
    }

    public void onCreate() {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr = new Object[1];
            c(b, b, MyBillsEntityDataFactory[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = MyBillsEntityDataFactory[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            c(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 3 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                    byte b4 = (byte) ($$a[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    d(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-182104075, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - ExpandableListView.getPackedPositionType(0L), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                if (TextUtils.isEmpty(this.f7140id)) {
                    this.f7140id = H5MapIDAssistant.INSTANCE.obtainID();
                    if (this.debuggable) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("H5MapMarker#onCreate: id -> ");
                        sb.append(this.f7140id);
                        RVLogger.d(H5MapContainer.TAG, sb.toString());
                    }
                }
                AdapterMarker adapterMarker = this.markerContext;
                if (adapterMarker != null) {
                    adapterMarker.setVisible(false);
                }
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

    public void onIconSuccess() {
        AdapterMarker adapterMarker;
        if (this.mIconSuccess) {
            return;
        }
        this.mIconSuccess = true;
        if (this.mClusterChildren == null) {
            if (!this.mVisible || this.mClustered || (adapterMarker = this.markerContext) == null) {
                return;
            }
            adapterMarker.setVisible(true);
        } else if (!this.mVisible || this.mClusterChildren.size() <= 0) {
        } else {
            this.markerContext.setVisible(true);
        }
    }

    public void onUpdate() {
        Marker marker = this.marker;
        if (marker != null) {
            this.mDisplayRanges = marker.displayRanges;
            if (this.mZIndex != this.marker.markerLevel) {
                int i = this.marker.markerLevel;
                this.mZIndex = i;
                this.markerContext.setZIndex(i);
            }
        }
        AdapterLatLng position = this.markerContext.getPosition();
        this.mPosition = new AdapterLatLng(position, position.getLatitude(), position.getLongitude());
    }

    public void onRemove() {
        this.mMarkerToken.incrementAndGet();
        if (this.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("H5MapMarker#onRemove: ");
            sb.append(this.f7140id);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public long obtainMarkerToken() {
        long incrementAndGet = this.mMarkerToken.incrementAndGet();
        if (this.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("H5MapMarker#obtainMarkerToken: ");
            sb.append(this.f7140id);
            sb.append(" -> ");
            sb.append(incrementAndGet);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        return incrementAndGet;
    }

    public boolean isMarkerTokenInvalid(long j) {
        boolean z = j != this.mMarkerToken.get();
        if (z && this.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("H5MapMarker: [");
            sb.append(this.f7140id);
            sb.append("] token is invalid: ");
            sb.append(j);
            sb.append(" -> ");
            sb.append(this.mMarkerToken.get());
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        return z;
    }

    public boolean isWatchCamera() {
        Marker marker = this.marker;
        if (marker == null) {
            return false;
        }
        return (marker.displayRanges != null && this.marker.displayRanges.size() > 0) || this.marker.clusterEnabled;
    }

    public void onCameraChanged(AdapterCameraPosition adapterCameraPosition) {
        if (Range.canDisplay(adapterCameraPosition.zoom, this.mDisplayRanges)) {
            this.mVisible = true;
            return;
        }
        this.mVisible = false;
        AdapterMarker adapterMarker = this.markerContext;
        if (adapterMarker != null) {
            adapterMarker.setVisible(false);
        }
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public boolean canBeClustered() {
        Marker marker = this.marker;
        return marker != null && marker.clusterEnabled;
    }

    public boolean isClustered() {
        return this.mClustered;
    }

    public void setClusteredRoot(H5MapMarker h5MapMarker) {
        H5MapMarker h5MapMarker2;
        if (this.mClustered && (h5MapMarker2 = this.mClusterRoot) != null) {
            h5MapMarker2.a(this);
        }
        if (h5MapMarker == null) {
            this.mClustered = false;
            this.mClusterRoot = null;
            return;
        }
        this.mClustered = true;
        this.mClusterRoot = h5MapMarker;
        h5MapMarker.b(this);
    }

    public void onClusterStateChanged() {
        if (this.mClustered) {
            if (!this.mVisible || this.markerContext == null) {
                return;
            }
            if (this.mClusterAnimationToken.get() != 0) {
                this.markerContext.setPosition(this.mPosition);
            }
            this.markerContext.setVisible(false);
        } else if (this.mVisible && this.mIconSuccess && this.markerContext != null) {
            if (this.mClusterAnimationToken.get() != 0) {
                this.markerContext.setPosition(this.mPosition);
            }
            this.markerContext.setVisible(true);
        }
    }

    public H5MapMarker getClusterRoot() {
        return this.mClusterRoot;
    }

    public Set<H5MapMarker> getClusterChildren() {
        return this.mClusterChildren;
    }

    private void a(H5MapMarker h5MapMarker) {
        if (h5MapMarker == null || this.mClusterChildren == null) {
            return;
        }
        this.mClusterChildren.remove(h5MapMarker);
    }

    private void b(H5MapMarker h5MapMarker) {
        if (h5MapMarker == null) {
            return;
        }
        if (this.mClusterChildren == null) {
            synchronized (this) {
                if (this.mClusterChildren == null) {
                    this.mClusterChildren = new CopyOnWriteArraySet();
                }
            }
        }
        this.mClusterChildren.add(h5MapMarker);
    }

    public boolean checkClusterChildren() {
        if (this.mClusterChildren == null || this.mClusterChildren.size() == 0) {
            AdapterMarker adapterMarker = this.markerContext;
            if (adapterMarker != null) {
                adapterMarker.setVisible(false);
            }
            return false;
        }
        if (this.mIconSuccess && this.mVisible) {
            this.markerContext.setVisible(true);
        }
        return true;
    }

    public void doAnimationOnClusterStateChanged(int i) {
        if (this.markerContext == null) {
            return;
        }
        if (this.clusterRootPosition == null) {
            RVLogger.e(H5MapContainer.TAG, "no cluster root mPosition for animation");
            return;
        }
        final long incrementAndGet = this.mClusterAnimationToken.incrementAndGet();
        if (i == 0) {
            AdapterTranslateAnimation adapterTranslateAnimation = new AdapterTranslateAnimation(this.clusterRootPosition);
            adapterTranslateAnimation.setInterpolator(new AccelerateInterpolator());
            adapterTranslateAnimation.setDuration(150L);
            adapterTranslateAnimation.setAnimationListener(new AdapterAnimation.AdapterAnimationListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.1
                @Override // com.alipay.mobile.apmap.animation.AdapterAnimation.AdapterAnimationListener
                public void onAnimationStart() {
                }

                @Override // com.alipay.mobile.apmap.animation.AdapterAnimation.AdapterAnimationListener
                public void onAnimationEnd() {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (incrementAndGet == H5MapMarker.this.mClusterAnimationToken.get()) {
                                H5MapMarker.this.onClusterStateChanged();
                                H5MapMarker.this.markerContext.setPosition(H5MapMarker.this.mPosition);
                            }
                        }
                    });
                }
            });
            this.markerContext.setVisible(true);
            this.markerContext.setPosition(this.mPosition);
            this.markerContext.setAnimation(adapterTranslateAnimation);
            this.markerContext.startAnimation();
        } else if (i == 1) {
            AdapterTranslateAnimation adapterTranslateAnimation2 = new AdapterTranslateAnimation(this.mPosition);
            adapterTranslateAnimation2.setInterpolator(new AccelerateInterpolator());
            adapterTranslateAnimation2.setDuration(280L);
            adapterTranslateAnimation2.setAnimationListener(new AdapterAnimation.AdapterAnimationListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.2
                @Override // com.alipay.mobile.apmap.animation.AdapterAnimation.AdapterAnimationListener
                public void onAnimationStart() {
                }

                @Override // com.alipay.mobile.apmap.animation.AdapterAnimation.AdapterAnimationListener
                public void onAnimationEnd() {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.H5MapMarker.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (incrementAndGet == H5MapMarker.this.mClusterAnimationToken.get()) {
                                H5MapMarker.this.onClusterStateChanged();
                                H5MapMarker.this.markerContext.setPosition(H5MapMarker.this.mPosition);
                            }
                        }
                    });
                }
            });
            this.markerContext.setVisible(true);
            this.markerContext.setPosition(this.clusterRootPosition);
            this.markerContext.setAnimation(adapterTranslateAnimation2);
            this.markerContext.startAnimation();
        }
    }

    public static Marker getMarkerData(AdapterMarker adapterMarker) {
        if (adapterMarker != null) {
            Object object = adapterMarker.getObject();
            if (object instanceof Marker) {
                return (Marker) object;
            }
            return null;
        }
        return null;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.grid.CellTarget
    public Point toPoint() {
        return this.screenLocation;
    }
}
