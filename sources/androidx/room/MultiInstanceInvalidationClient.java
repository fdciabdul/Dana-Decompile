package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class MultiInstanceInvalidationClient {
    final IMultiInstanceInvalidationCallback BuiltInFictitiousFunctionClassFactory = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient.1
        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(final String[] strArr) {
            MultiInstanceInvalidationClient.this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.1.1
                @Override // java.lang.Runnable
                public void run() {
                    InvalidationTracker invalidationTracker = MultiInstanceInvalidationClient.this.PlaceComponentResult;
                    String[] strArr2 = strArr;
                    synchronized (invalidationTracker.lookAheadTest) {
                        Iterator<Map.Entry<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper>> it = invalidationTracker.lookAheadTest.iterator();
                        while (it.hasNext()) {
                            Map.Entry<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper> next = it.next();
                            if (!next.getKey().MyBillsEntityDataFactory()) {
                                InvalidationTracker.ObserverWrapper value = next.getValue();
                                Set<String> set = null;
                                if (value.BuiltInFictitiousFunctionClassFactory.length == 1) {
                                    int length = strArr2.length;
                                    int i = 0;
                                    while (true) {
                                        if (i >= length) {
                                            break;
                                        } else if (strArr2[i].equalsIgnoreCase(value.BuiltInFictitiousFunctionClassFactory[0])) {
                                            set = value.PlaceComponentResult;
                                            break;
                                        } else {
                                            i++;
                                        }
                                    }
                                } else {
                                    HashSet hashSet = new HashSet();
                                    for (String str : strArr2) {
                                        String[] strArr3 = value.BuiltInFictitiousFunctionClassFactory;
                                        int length2 = strArr3.length;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 < length2) {
                                                String str2 = strArr3[i2];
                                                if (str2.equalsIgnoreCase(str)) {
                                                    hashSet.add(str2);
                                                    break;
                                                }
                                                i2++;
                                            }
                                        }
                                    }
                                    if (hashSet.size() > 0) {
                                        set = hashSet;
                                    }
                                }
                                if (set != null) {
                                    value.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(set);
                                }
                            }
                        }
                    }
                }
            });
        }
    };
    final AtomicBoolean DatabaseTableConfigUtil = new AtomicBoolean(false);
    final Context KClassImpl$Data$declaredNonStaticMembers$2;
    final Executor MyBillsEntityDataFactory;
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    final InvalidationTracker PlaceComponentResult;
    int getAuthRequestContext;
    final InvalidationTracker.Observer getErrorConfigVersion;
    final Runnable initRecordTimeStamp;
    IMultiInstanceInvalidationService lookAheadTest;
    final ServiceConnection moveToNextValue;
    final Runnable scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker, Executor executor) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MultiInstanceInvalidationClient.this.lookAheadTest = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
                MultiInstanceInvalidationClient.this.MyBillsEntityDataFactory.execute(MultiInstanceInvalidationClient.this.initRecordTimeStamp);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                MultiInstanceInvalidationClient.this.MyBillsEntityDataFactory.execute(MultiInstanceInvalidationClient.this.scheduleImpl);
                MultiInstanceInvalidationClient.this.lookAheadTest = null;
            }
        };
        this.moveToNextValue = serviceConnection;
        this.initRecordTimeStamp = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.lookAheadTest;
                    if (iMultiInstanceInvalidationService != null) {
                        MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                        multiInstanceInvalidationClient.getAuthRequestContext = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.BuiltInFictitiousFunctionClassFactory, MultiInstanceInvalidationClient.this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        MultiInstanceInvalidationClient.this.PlaceComponentResult.MyBillsEntityDataFactory(MultiInstanceInvalidationClient.this.getErrorConfigVersion);
                    }
                } catch (RemoteException e) {
                    InstrumentInjector.log_w("ROOM", "Cannot register multi-instance invalidation callback", e);
                }
            }
        };
        this.scheduleImpl = new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient.4
            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient.this.PlaceComponentResult.getAuthRequestContext(MultiInstanceInvalidationClient.this.getErrorConfigVersion);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.PlaceComponentResult = invalidationTracker;
        this.MyBillsEntityDataFactory = executor;
        this.getErrorConfigVersion = new InvalidationTracker.Observer((String[]) invalidationTracker.initRecordTimeStamp.keySet().toArray(new String[0])) { // from class: androidx.room.MultiInstanceInvalidationClient.5
            @Override // androidx.room.InvalidationTracker.Observer
            final boolean MyBillsEntityDataFactory() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public final void PlaceComponentResult(Set<String> set) {
                if (MultiInstanceInvalidationClient.this.DatabaseTableConfigUtil.get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = MultiInstanceInvalidationClient.this.lookAheadTest;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.broadcastInvalidation(MultiInstanceInvalidationClient.this.getAuthRequestContext, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e) {
                    InstrumentInjector.log_w("ROOM", "Cannot broadcast invalidation", e);
                }
            }
        };
        applicationContext.bindService(intent, serviceConnection, 1);
    }
}
