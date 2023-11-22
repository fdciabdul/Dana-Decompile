package j$.time.zone;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList BuiltInFictitiousFunctionClassFactory;
    private static final ConcurrentHashMap MyBillsEntityDataFactory;

    /* loaded from: classes6.dex */
    final class TimeZoneRulesProvider extends ZoneRulesProvider {
        private final Set getAuthRequestContext;

        TimeZoneRulesProvider() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : TimeZone.getAvailableIDs()) {
                linkedHashSet.add(str);
            }
            this.getAuthRequestContext = Collections.unmodifiableSet(linkedHashSet);
        }

        @Override // j$.time.zone.ZoneRulesProvider
        protected final Set BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        @Override // j$.time.zone.ZoneRulesProvider
        protected final ZoneRules PlaceComponentResult(String str) {
            if (this.getAuthRequestContext.contains(str)) {
                return new ZoneRules(TimeZone.getTimeZone(str));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Not a built-in time zone: ");
            sb.append(str);
            throw new ZoneRulesException(sb.toString());
        }
    }

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        BuiltInFictitiousFunctionClassFactory = copyOnWriteArrayList;
        MyBillsEntityDataFactory = new ConcurrentHashMap(512, 0.75f, 2);
        final ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new PrivilegedAction() { // from class: j$.time.zone.ZoneRulesProvider.1
            @Override // java.security.PrivilegedAction
            public final Object run() {
                String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
                if (property == null) {
                    ZoneRulesProvider.getAuthRequestContext(new TimeZoneRulesProvider());
                    return null;
                }
                try {
                    ZoneRulesProvider zoneRulesProvider = (ZoneRulesProvider) ZoneRulesProvider.class.cast(Class.forName(property, true, ZoneRulesProvider.class.getClassLoader()).newInstance());
                    ZoneRulesProvider.getAuthRequestContext(zoneRulesProvider);
                    arrayList.add(zoneRulesProvider);
                    return null;
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
        });
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected ZoneRulesProvider() {
    }

    public static HashSet PlaceComponentResult() {
        return new HashSet(MyBillsEntityDataFactory.keySet());
    }

    public static ZoneRules getAuthRequestContext(String str) {
        if (str != null) {
            ConcurrentHashMap concurrentHashMap = MyBillsEntityDataFactory;
            ZoneRulesProvider zoneRulesProvider = (ZoneRulesProvider) concurrentHashMap.get(str);
            if (zoneRulesProvider == null) {
                if (concurrentHashMap.isEmpty()) {
                    throw new ZoneRulesException("No time-zone data files registered");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown time-zone ID: ");
                sb.append(str);
                throw new ZoneRulesException(sb.toString());
            }
            return zoneRulesProvider.PlaceComponentResult(str);
        }
        throw new NullPointerException("zoneId");
    }

    public static void getAuthRequestContext(ZoneRulesProvider zoneRulesProvider) {
        if (zoneRulesProvider == null) {
            throw new NullPointerException("provider");
        }
        for (String str : zoneRulesProvider.BuiltInFictitiousFunctionClassFactory()) {
            if (str == null) {
                throw new NullPointerException("zoneId");
            }
            if (((ZoneRulesProvider) MyBillsEntityDataFactory.putIfAbsent(str, zoneRulesProvider)) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to register zone as one already registered with that ID: ");
                sb.append(str);
                sb.append(", currently loading from provider: ");
                sb.append(zoneRulesProvider);
                throw new ZoneRulesException(sb.toString());
            }
        }
        BuiltInFictitiousFunctionClassFactory.add(zoneRulesProvider);
    }

    protected abstract Set BuiltInFictitiousFunctionClassFactory();

    protected abstract ZoneRules PlaceComponentResult(String str);
}
