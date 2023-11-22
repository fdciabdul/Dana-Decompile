package com.alibaba.griver.bluetooth.ibeacon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconConsumer;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconParser;
import com.alibaba.griver.bluetooth.altbeacon.beacon.RangeNotifier;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.ble.ErrorConstants;
import com.alibaba.griver.bluetooth.ble.model.BluetoothState;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothHelper;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class MyBeaconServiceImpl implements MyBeaconService {
    private static final String IBEACON_LAYOUT = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25";
    private Set<MyBeacon> allBeaconList;
    private BeaconConsumer beaconConsumer = new BeaconConsumer() { // from class: com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.1
        @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconConsumer
        public void onBeaconServiceConnect() {
            MyBeaconServiceImpl.this.beaconManager.addRangeNotifier(new RangeNotifier() { // from class: com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.1.1
                @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.RangeNotifier
                public void didRangeBeaconsInRegion(Collection<Beacon> collection, Region region) {
                    if (collection != null) {
                        MyBeaconServiceImpl.this.myBeaconList.clear();
                        for (Beacon beacon : collection) {
                            if (MyBeaconServiceImpl.this.filterUUIDList != null && MyBeaconServiceImpl.this.filterUUIDList.contains(beacon.getIdentifier(0).toUuid())) {
                                MyBeacon myBeacon = new MyBeacon(beacon.getIdentifier(0).toString(), beacon.getIdentifier(1).toInt(), beacon.getIdentifier(2).toInt(), beacon.getDistance(), beacon.getRssi(), beacon.getTxPower());
                                MyBeaconServiceImpl.this.myBeaconList.add(myBeacon);
                                if (!MyBeaconServiceImpl.this.allBeaconList.contains(myBeacon)) {
                                    MyBeaconServiceImpl.this.allBeaconList.add(myBeacon);
                                } else {
                                    MyBeaconServiceImpl.this.allBeaconList.remove(myBeacon);
                                    MyBeaconServiceImpl.this.allBeaconList.add(myBeacon);
                                }
                            }
                        }
                        if (MyBeaconServiceImpl.this.myBeaconListener == null || MyBeaconServiceImpl.this.myBeaconList.isEmpty()) {
                            return;
                        }
                        MyBeaconServiceImpl.this.myBeaconListener.onBeaconUpdate(MyBeaconServiceImpl.this.myBeaconList);
                    }
                }
            });
            try {
                MyBeaconServiceImpl.this.beaconManager.startRangingBeaconsInRegion(new Region(getApplicationContext().getPackageName(), null, null, null));
            } catch (RemoteException unused) {
            }
        }

        @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconConsumer
        public Context getApplicationContext() {
            return MyBeaconServiceImpl.this.getMicroApplicationContext();
        }

        @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconConsumer
        public void unbindService(ServiceConnection serviceConnection) {
            getApplicationContext().unbindService(serviceConnection);
        }

        @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconConsumer
        public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
            boolean bindService = getApplicationContext().bindService(intent, serviceConnection, i);
            if (!bindService) {
                MyBeaconServiceImpl.this.isDiscovering = false;
            }
            return bindService;
        }
    };
    private BeaconManager beaconManager;
    private BroadcastReceiver bluetoothReceiver;
    private List<UUID> filterUUIDList;
    private boolean isDiscovering;
    private List<MyBeacon> myBeaconList;
    private MyBeaconListener myBeaconListener;
    public static final byte[] $$a = {84, -107, -124, 66, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 19;
    public static final byte[] PlaceComponentResult = {44, 104, -53, -66, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 124;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 16
            byte[] r0 = com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.PlaceComponentResult
            int r8 = r8 + 105
            int r6 = r6 * 15
            int r6 = 19 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r7 = r7 + 1
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.a(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.$$a
            int r8 = r8 * 4
            int r8 = r8 + 4
            int r7 = r7 * 4
            int r7 = r7 + 42
            int r9 = r9 * 4
            int r9 = r9 + 75
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1a
            r9 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r7
            goto L36
        L1a:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1f:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r9]
            r6 = r10
            r10 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r7 = r7 + r8
            int r9 = r9 + 1
            int r7 = r7 + (-7)
            r8 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.b(short, int, int, java.lang.Object[]):void");
    }

    @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconService
    public void onCreate() {
        try {
            byte b = (byte) (PlaceComponentResult[5] - 1);
            Object[] objArr = new Object[1];
            a(b, b, PlaceComponentResult[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = PlaceComponentResult[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            a(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.getCapsMode("", 0, 0), Drawable.resolveOpacity(0, 0) + 4, (char) (Process.myPid() >> 22));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1023961748, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 17 - ExpandableListView.getPackedPositionChild(0L), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                initBeaconManager();
                this.myBeaconList = new ArrayList();
                this.allBeaconList = new HashSet();
                this.filterUUIDList = new ArrayList();
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

    @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconService
    public void onDestroy() {
        this.beaconManager = null;
    }

    private void initBeaconManager() {
        this.beaconManager = BeaconManager.getInstanceForApplication(getMicroApplicationContext());
    }

    @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconService
    public void setMyBeaconListener(MyBeaconListener myBeaconListener) {
        this.myBeaconListener = myBeaconListener;
    }

    @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconService
    public BeaconResult startBeaconDiscovery(String[] strArr) {
        if (this.isDiscovering) {
            return new BeaconResult(false, ErrorConstants.ERROR_BEACON_ALREADY_DISCOVERING);
        }
        if (!BluetoothHelper.isSupportBLE(getMicroApplicationContext().getApplicationContext())) {
            return new BeaconResult(false, ErrorConstants.ERROR_BEACON_UNSUPPORT);
        }
        if (BluetoothHelper.getBluetoothState() != BluetoothState.ON) {
            return new BeaconResult(false, ErrorConstants.ERROR_BEACON_BLUETOOTH_UNAVAILABLE);
        }
        if (this.beaconManager == null) {
            initBeaconManager();
        }
        this.filterUUIDList.clear();
        if (strArr != null) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    return new BeaconResult(false, ErrorConstants.ERROR_BEACON_UUID_EMPTY);
                }
                UUID uUIDFromString = BluetoothHelper.getUUIDFromString(str);
                if (uUIDFromString == null) {
                    return new BeaconResult(false, ErrorConstants.ERROR_BEACON_INVALID_UUID);
                }
                this.filterUUIDList.add(uUIDFromString);
            }
        }
        this.isDiscovering = true;
        this.beaconManager.isMainProcess();
        this.beaconManager.removeAllMonitorNotifiers();
        this.beaconManager.removeAllRangeNotifiers();
        this.beaconManager.getBeaconParsers().clear();
        this.beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout(IBEACON_LAYOUT));
        this.beaconManager.bind(this.beaconConsumer);
        registerReceiver();
        return new BeaconResult(true);
    }

    @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconService
    public BeaconResult stopBeaconDiscovery() {
        this.isDiscovering = false;
        this.filterUUIDList.clear();
        this.myBeaconList.clear();
        this.allBeaconList.clear();
        this.beaconManager.removeAllMonitorNotifiers();
        this.beaconManager.removeAllRangeNotifiers();
        this.beaconManager.unbind(this.beaconConsumer);
        unregisterReceiver();
        return new BeaconResult(true);
    }

    @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconService
    public BeaconResult getBeacons() {
        BeaconResult beaconResult = new BeaconResult(true);
        beaconResult.obj = this.allBeaconList;
        return beaconResult;
    }

    private void registerReceiver() {
        if (this.bluetoothReceiver != null) {
            return;
        }
        this.bluetoothReceiver = new BroadcastReceiver() { // from class: com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                if (intExtra != 10) {
                    if (intExtra != 12 || MyBeaconServiceImpl.this.myBeaconListener == null) {
                        return;
                    }
                    MyBeaconServiceImpl.this.myBeaconListener.onBeaconServiceChange(true, MyBeaconServiceImpl.this.isDiscovering);
                } else if (MyBeaconServiceImpl.this.myBeaconListener != null) {
                    MyBeaconServiceImpl.this.myBeaconListener.onBeaconServiceChange(false, MyBeaconServiceImpl.this.isDiscovering);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        getMicroApplicationContext().getApplicationContext().registerReceiver(this.bluetoothReceiver, intentFilter);
    }

    private void unregisterReceiver() {
        if (this.bluetoothReceiver != null) {
            getMicroApplicationContext().getApplicationContext().unregisterReceiver(this.bluetoothReceiver);
        }
        this.bluetoothReceiver = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getMicroApplicationContext() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return null;
        }
        return rVEnvironmentService.getApplicationContext();
    }
}
