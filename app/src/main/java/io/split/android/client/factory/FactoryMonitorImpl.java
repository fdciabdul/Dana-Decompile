package io.split.android.client.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class FactoryMonitorImpl implements FactoryMonitor {
    private static FactoryMonitor sharedInstance;
    private Map<String, Integer> factories = new HashMap();

    public static FactoryMonitor getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new FactoryMonitorImpl();
        }
        return sharedInstance;
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public int count() {
        int i;
        synchronized (this) {
            Iterator<Integer> it = this.factories.values().iterator();
            i = 0;
            while (it.hasNext()) {
                i += it.next().intValue();
            }
        }
        return i;
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public int count(String str) {
        int intValue;
        synchronized (this) {
            Integer num = this.factories.get(str);
            intValue = num != null ? num.intValue() : 0;
        }
        return intValue;
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public void add(String str) {
        synchronized (this) {
            Integer num = this.factories.get(str);
            this.factories.put(str, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
    }

    @Override // io.split.android.client.factory.FactoryMonitor
    public void remove(String str) {
        synchronized (this) {
            Integer num = this.factories.get(str);
            int intValue = (num != null ? num.intValue() : 0) - 1;
            if (intValue > 0) {
                this.factories.put(str, Integer.valueOf(intValue));
            } else {
                this.factories.remove(str);
            }
        }
    }
}
