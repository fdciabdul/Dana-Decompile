package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import android.view.KeyEvent;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ActivityChooserModel extends DataSetObservable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda3 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    static final String PlaceComponentResult = "ActivityChooserModel";
    private static int PrepareContext;
    private static final Map<String, ActivityChooserModel> getAuthRequestContext;
    private static boolean isLayoutRequested;
    private static final Object lookAheadTest;
    private static boolean newProxyInstance;
    final Context BuiltInFictitiousFunctionClassFactory;
    private Intent DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final String MyBillsEntityDataFactory;
    private final List<HistoricalRecord> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Object NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private ActivitySorter getErrorConfigVersion;
    private int initRecordTimeStamp;
    private final List<ActivityResolveInfo> moveToNextValue;
    private OnChooseActivityListener scheduleImpl;

    /* loaded from: classes6.dex */
    public interface ActivityChooserModelClient {
    }

    /* loaded from: classes6.dex */
    public interface ActivitySorter {
        void PlaceComponentResult(List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* loaded from: classes6.dex */
    public interface OnChooseActivityListener {
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda7 = new char[]{39875, 39874, 39888, 39915, 39902};
        newProxyInstance = true;
        isLayoutRequested = true;
        PrepareContext = 909155222;
    }

    static {
        try {
            getAuthRequestContext();
            try {
                lookAheadTest = new Object();
                getAuthRequestContext = new HashMap();
                int i = NetworkUserEntityData$$ExternalSyntheticLambda4 + 101;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static ActivityChooserModel getAuthRequestContext(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (lookAheadTest) {
            Map<String, ActivityChooserModel> map = getAuthRequestContext;
            activityChooserModel = map.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                map.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private ActivityChooserModel(Context context, String str) {
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Object();
            this.moveToNextValue = new ArrayList();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
            this.getErrorConfigVersion = new DefaultSorter();
            this.initRecordTimeStamp = 50;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.GetContactSyncConfig = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
            this.BuiltInFictitiousFunctionClassFactory = context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                if (!str.endsWith(".xml")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(".xml");
                    this.MyBillsEntityDataFactory = sb.toString();
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda4 + 29;
                    NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                    if ((i % 2 == 0 ? '\\' : '6') != '\\') {
                        return;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
            }
            this.MyBillsEntityDataFactory = str;
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda4 = i2 % 128;
            if ((i2 % 2 != 0 ? '[' : 'Z') != 'Z') {
                int i3 = 92 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final int PlaceComponentResult() {
        int size;
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            size = this.moveToNextValue.size();
        }
        return size;
    }

    public final ResolveInfo MyBillsEntityDataFactory(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            resolveInfo = this.moveToNextValue.get(i).MyBillsEntityDataFactory;
        }
        return resolveInfo;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(ResolveInfo resolveInfo) {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            List<ActivityResolveInfo> list = this.moveToNextValue;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).MyBillsEntityDataFactory == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent BuiltInFictitiousFunctionClassFactory(int i) {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            if (this.DatabaseTableConfigUtil == null) {
                return null;
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
            ActivityResolveInfo activityResolveInfo = this.moveToNextValue.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.MyBillsEntityDataFactory.activityInfo.packageName, activityResolveInfo.MyBillsEntityDataFactory.activityInfo.name);
            Intent intent = new Intent(this.DatabaseTableConfigUtil);
            intent.setComponent(componentName);
            if (this.scheduleImpl != null) {
                new Intent(intent);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo BuiltInFictitiousFunctionClassFactory() {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            if (this.moveToNextValue.isEmpty()) {
                return null;
            }
            return this.moveToNextValue.get(0).MyBillsEntityDataFactory;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            ActivityResolveInfo activityResolveInfo = this.moveToNextValue.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.moveToNextValue.get(0);
            KClassImpl$Data$declaredNonStaticMembers$2(new HistoricalRecord(new ComponentName(activityResolveInfo.MyBillsEntityDataFactory.activityInfo.packageName, activityResolveInfo.MyBillsEntityDataFactory.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.BuiltInFictitiousFunctionClassFactory - activityResolveInfo.BuiltInFictitiousFunctionClassFactory) + 5.0f : 1.0f));
        }
    }

    private void moveToNextValue() {
        if ((this.GetContactSyncConfig ? '\t' : 'O') == 'O') {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        int i = NetworkUserEntityData$$ExternalSyntheticLambda4 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            if (!TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
                try {
                    new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.NetworkUserEntityData$$ExternalSyntheticLambda0), this.MyBillsEntityDataFactory);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    public final int MyBillsEntityDataFactory() {
        int size;
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
        }
        return size;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda4 = i % 128;
            if ((i % 2 != 0 ? '+' : '\'') != '\'') {
                boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                boolean errorConfigVersion = getErrorConfigVersion();
                lookAheadTest();
                if (!(NetworkUserEntityData$$ExternalSyntheticLambda0 ^ errorConfigVersion)) {
                    return;
                }
            } else {
                boolean NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                boolean errorConfigVersion2 = getErrorConfigVersion();
                lookAheadTest();
                if (!(NetworkUserEntityData$$ExternalSyntheticLambda02 | errorConfigVersion2)) {
                    return;
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda1();
            notifyChanged();
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 3;
            NetworkUserEntityData$$ExternalSyntheticLambda4 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda4 = i % 128;
        int i2 = i % 2;
        try {
            if ((this.getErrorConfigVersion != null ? (char) 19 : 'a') != 'a') {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 119;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                if (this.DatabaseTableConfigUtil != null && !this.moveToNextValue.isEmpty()) {
                    if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty())) {
                        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 19;
                        NetworkUserEntityData$$ExternalSyntheticLambda3 = i5 % 128;
                        int i6 = i5 % 2;
                        this.getErrorConfigVersion.PlaceComponentResult(this.moveToNextValue, Collections.unmodifiableList(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = 0;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 117;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
            int i3 = i2 % 2;
            if ((this.DatabaseTableConfigUtil != null ? 'X' : '@') != '@') {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 55;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i4 % 128;
                int i5 = i4 % 2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                this.moveToNextValue.clear();
                List<ResolveInfo> queryIntentActivities = this.BuiltInFictitiousFunctionClassFactory.getPackageManager().queryIntentActivities(this.DatabaseTableConfigUtil, 0);
                int size = queryIntentActivities.size();
                while (i < size) {
                    this.moveToNextValue.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
                    i++;
                    int i6 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 55;
                    NetworkUserEntityData$$ExternalSyntheticLambda4 = i6 % 128;
                    int i7 = i6 % 2;
                }
                return true;
            }
        }
        int i8 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i8 % 128;
        if (!(i8 % 2 == 0)) {
            return false;
        }
        Object obj = null;
        obj.hashCode();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r4.MyBillsEntityDataFactory)) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r4.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        r4.GetContactSyncConfig = true;
        scheduleImpl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3 + 99;
        androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean getErrorConfigVersion() {
        /*
            r4 = this;
            int r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 9
            int r1 = r0 % 128
            androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = r1
            int r0 = r0 % 2
            boolean r0 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L12
            r0 = 1
            goto L13
        L12:
            r0 = 0
        L13:
            if (r0 == r2) goto L16
            goto L5b
        L16:
            boolean r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L5c
            if (r0 == 0) goto L5b
            int r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4
            int r0 = r0 + 111
            int r3 = r0 % 128
            androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L28
            r0 = 0
            goto L29
        L28:
            r0 = 1
        L29:
            if (r0 == 0) goto L39
            java.lang.String r0 = r4.MyBillsEntityDataFactory
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 == 0) goto L5b
            goto L45
        L39:
            java.lang.String r0 = r4.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L59
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L5c
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L5b
        L45:
            r4.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r4.GetContactSyncConfig = r2
            r4.scheduleImpl()
            int r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L59
            int r0 = r0 + 99
            int r1 = r0 % 128
            androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = r1     // Catch: java.lang.Exception -> L59
            int r0 = r0 % 2
            return r2
        L57:
            r0 = move-exception
            throw r0
        L59:
            r0 = move-exception
            throw r0
        L5b:
            return r1
        L5c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.getErrorConfigVersion():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if ((r4) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if ((r4 ? 3 : 'a') != 3) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        r3.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        lookAheadTest();
        moveToNextValue();
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        notifyChanged();
        r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4 + 21;
        androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2(androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord r4) {
        /*
            r3 = this;
            int r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4
            int r0 = r0 + 81
            int r1 = r0 % 128
            androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L23
            java.util.List<androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord> r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0
            boolean r4 = r0.add(r4)
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L1e
            r1 = 1
        L1e:
            if (r1 == r2) goto L33
            goto L4b
        L21:
            r4 = move-exception
            throw r4
        L23:
            java.util.List<androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord> r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0
            boolean r4 = r0.add(r4)
            r0 = 3
            if (r4 == 0) goto L2e
            r1 = 3
            goto L30
        L2e:
            r1 = 97
        L30:
            if (r1 == r0) goto L33
            goto L4b
        L33:
            r3.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2
            r3.lookAheadTest()
            r3.moveToNextValue()
            r3.NetworkUserEntityData$$ExternalSyntheticLambda1()
            r3.notifyChanged()
            int r0 = androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda4
            int r0 = r0 + 21
            int r1 = r0 % 128
            androidx.appcompat.widget.ActivityChooserModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            int r0 = r0 % 2
        L4b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.KClassImpl$Data$declaredNonStaticMembers$2(androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord):boolean");
    }

    private void lookAheadTest() {
        int size;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda4 = i % 128;
            if ((i % 2 != 0 ? '9' : (char) 21) != 21) {
                size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() % this.initRecordTimeStamp;
                if (size <= 0) {
                    return;
                }
            } else {
                size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() - this.initRecordTimeStamp;
                if (size <= 0) {
                    return;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            int i2 = 0;
            while (true) {
                if (!(i2 < size)) {
                    return;
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 7;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(0);
                i2++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* loaded from: classes6.dex */
    public static final class HistoricalRecord {
        public final long MyBillsEntityDataFactory;
        public final float PlaceComponentResult;
        public final ComponentName getAuthRequestContext;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.getAuthRequestContext = componentName;
            this.MyBillsEntityDataFactory = j;
            this.PlaceComponentResult = f;
        }

        public final int hashCode() {
            ComponentName componentName = this.getAuthRequestContext;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.MyBillsEntityDataFactory;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.PlaceComponentResult);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                HistoricalRecord historicalRecord = (HistoricalRecord) obj;
                ComponentName componentName = this.getAuthRequestContext;
                if (componentName == null) {
                    if (historicalRecord.getAuthRequestContext != null) {
                        return false;
                    }
                } else if (!componentName.equals(historicalRecord.getAuthRequestContext)) {
                    return false;
                }
                return this.MyBillsEntityDataFactory == historicalRecord.MyBillsEntityDataFactory && Float.floatToIntBits(this.PlaceComponentResult) == Float.floatToIntBits(historicalRecord.PlaceComponentResult);
            }
            return false;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:");
            sb.append(this.getAuthRequestContext);
            sb.append("; time:");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("; weight:");
            sb.append(new BigDecimal(this.PlaceComponentResult));
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public float BuiltInFictitiousFunctionClassFactory;
        public final ResolveInfo MyBillsEntityDataFactory;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.BuiltInFictitiousFunctionClassFactory) - Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory);
        }

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.MyBillsEntityDataFactory = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory) == Float.floatToIntBits(((ActivityResolveInfo) obj).BuiltInFictitiousFunctionClassFactory);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:");
            sb.append(this.MyBillsEntityDataFactory.toString());
            sb.append("; weight:");
            sb.append(new BigDecimal(this.BuiltInFictitiousFunctionClassFactory));
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    static final class DefaultSorter implements ActivitySorter {
        private final Map<ComponentName, ActivityResolveInfo> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

        DefaultSorter() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public final void PlaceComponentResult(List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.BuiltInFictitiousFunctionClassFactory = 0.0f;
                map.put(new ComponentName(activityResolveInfo.MyBillsEntityDataFactory.activityInfo.packageName, activityResolveInfo.MyBillsEntityDataFactory.activityInfo.name), activityResolveInfo);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.getAuthRequestContext);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.BuiltInFictitiousFunctionClassFactory += historicalRecord.PlaceComponentResult * f;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    private void scheduleImpl() {
        FileInputStream openFileInput;
        XmlPullParser newPullParser;
        try {
            try {
                openFileInput = this.BuiltInFictitiousFunctionClassFactory.openFileInput(this.MyBillsEntityDataFactory);
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        Object[] objArr = new Object[1];
                        Object[] objArr2 = null;
                        a(127 - KeyEvent.getDeadChar(0, 0), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
                        newPullParser.setInput(openFileInput, ((String) objArr[0]).intern());
                        int i = 0;
                        while (i != 1) {
                            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 115;
                            NetworkUserEntityData$$ExternalSyntheticLambda4 = i2 % 128;
                            int i3 = i2 % 2;
                            if (i == 2) {
                                break;
                            }
                            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda4 + 43;
                            NetworkUserEntityData$$ExternalSyntheticLambda3 = i4 % 128;
                            if (i4 % 2 == 0) {
                                i = newPullParser.next();
                                int length = objArr2.length;
                            } else {
                                i = newPullParser.next();
                            }
                        }
                    } catch (XmlPullParserException e) {
                        String str = PlaceComponentResult;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error reading historical recrod file: ");
                        sb.append(this.MyBillsEntityDataFactory);
                        InstrumentInjector.log_e(str, sb.toString(), e);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (IOException e2) {
                    String str2 = PlaceComponentResult;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error reading historical recrod file: ");
                    sb2.append(this.MyBillsEntityDataFactory);
                    InstrumentInjector.log_e(str2, sb2.toString(), e2);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<HistoricalRecord> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if ((openFileInput != null ? 'S' : '#') != 'S') {
                            return;
                        }
                    } else {
                        if (!(next == 3)) {
                            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 19;
                            NetworkUserEntityData$$ExternalSyntheticLambda4 = i5 % 128;
                            int i6 = i5 % 2;
                            if (next == 4) {
                                continue;
                            } else if (!"historical-record".equals(newPullParser.getName())) {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            } else {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, AkuEventParamsKey.KEY_ACTIVITY), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if ((openFileInput != null ? Typography.dollar : '\b') != '\b') {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int BuiltInFictitiousFunctionClassFactory = 519130272;
        private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1257195701;
        private static byte[] MyBillsEntityDataFactory = {-30, -58, -5, -18, -97};
        private static int PlaceComponentResult = -236922635;
        private static int getErrorConfigVersion = 1;
        private static int lookAheadTest;
        private static short[] scheduleImpl;

        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Object[] objArr) {
            Void PlaceComponentResult2;
            try {
                int i = getErrorConfigVersion + 99;
                lookAheadTest = i % 128;
                if ((i % 2 != 0 ? 'N' : (char) 1) != 1) {
                    PlaceComponentResult2 = PlaceComponentResult(objArr);
                    int i2 = 86 / 0;
                } else {
                    PlaceComponentResult2 = PlaceComponentResult(objArr);
                }
                try {
                    int i3 = getErrorConfigVersion + 7;
                    lookAheadTest = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        Object obj = null;
                        obj.hashCode();
                        return PlaceComponentResult2;
                    }
                    return PlaceComponentResult2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
        
            if ((r7 != null) != false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00e6, code lost:
        
            if (r7 == null) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0106, code lost:
        
            if (r7 == null) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0126, code lost:
        
            if (r7 != null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0129, code lost:
        
            r7.close();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.Void PlaceComponentResult(java.lang.Object... r20) {
            /*
                Method dump skipped, instructions count: 352
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.PlaceComponentResult(java.lang.Object[]):java.lang.Void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            if (r2 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        
            if (r2 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        
            r8 = r2.length;
            r9 = new byte[r8];
            r10 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        
            if (r10 >= r8) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
        
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        
            if (r11 == true) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        
            r2 = androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.$10 + 65;
            androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.$11 = r2 % 128;
            r2 = r2 % 2;
            r2 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        
            r9[r10] = (byte) (r2[r10] ^ 3097486228508854431L);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        
            r10 = r10 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
        
            if (r2 == null) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
        
            r2 = androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.$10 + 95;
            androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.$11 = r2 % 128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
        
            if ((r2 % 2) != 0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x008c, code lost:
        
            if (r2 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x009f, code lost:
        
            r2 = ((byte) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.MyBillsEntityDataFactory[r13 + ((int) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L));
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        
            r2 = ((byte) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.MyBillsEntityDataFactory[r13 - ((int) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.PlaceComponentResult + 3097486228508854431L))] % 3097486228508854431L)) >>> ((int) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.KClassImpl$Data$declaredNonStaticMembers$2 / 3097486228508854431L));
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00bb, code lost:
        
            r2 = (byte) r2;
            r8 = androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.$10 + 21;
            androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.$11 = r8 % 128;
            r8 = r8 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00c7, code lost:
        
            r2 = (short) (((short) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.scheduleImpl[r13 + ((int) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
            /*
                Method dump skipped, instructions count: 391
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.a(int, int, short, int, byte, java.lang.Object[]):void");
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        try {
            char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (cArr2 != null) {
                int i2 = $10 + 95;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = 0;
                while (i4 < length) {
                    int i5 = $10 + 113;
                    $11 = i5 % 128;
                    if (i5 % 2 == 0) {
                        cArr3[i4] = (char) (cArr2[i4] & 4571606982258105150L);
                        i4 /= 0;
                    } else {
                        cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                        i4++;
                    }
                }
                int i6 = $10 + 17;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr2 = cArr3;
            }
            int i8 = (int) (4571606982258105150L ^ PrepareContext);
            if ((isLayoutRequested ? 'C' : (char) 4) == 'C') {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i8);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if ((newProxyInstance ? '4' : 'S') != 'S') {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        } catch (Exception e) {
            throw e;
        }
    }
}
