package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import j$.util.Map;
import j$.util.function.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public class MetricStorageRegistry {
    private static final Logger logger = Logger.getLogger(MetricStorageRegistry.class.getName());
    private final Object lock = new Object();
    private final Map<MetricDescriptor, MetricStorage> registry = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MetricStorage lambda$register$0(MetricStorage metricStorage, MetricDescriptor metricDescriptor) {
        return metricStorage;
    }

    public Collection<MetricStorage> getStorages() {
        Collection<MetricStorage> unmodifiableCollection;
        synchronized (this.lock) {
            unmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(this.registry.values()));
        }
        return unmodifiableCollection;
    }

    public <I extends MetricStorage> I register(final I i) {
        MetricDescriptor metricDescriptor = i.getMetricDescriptor();
        synchronized (this.lock) {
            I i2 = (I) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) this.registry, (Object) metricDescriptor, new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageRegistry$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return MetricStorageRegistry.lambda$register$0(MetricStorage.this, (MetricDescriptor) obj);
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            });
            if (i == i2 && logger.isLoggable(Level.WARNING)) {
                Iterator it = new ArrayList(this.registry.values()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetricStorage metricStorage = (MetricStorage) it.next();
                    if (metricStorage != i) {
                        MetricDescriptor metricDescriptor2 = metricStorage.getMetricDescriptor();
                        if (metricDescriptor2.getName().equalsIgnoreCase(metricDescriptor.getName()) && !metricDescriptor2.isCompatibleWith(metricDescriptor)) {
                            logger.log(Level.WARNING, DebugUtils.duplicateMetricErrorMessage(metricDescriptor2, metricDescriptor));
                            break;
                        }
                    }
                }
                return i2;
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetForTest() {
        synchronized (this.lock) {
            this.registry.clear();
        }
    }
}
