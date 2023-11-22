package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.state.SynchronousMetricStorage;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes6.dex */
public class MeterSharedState {
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Map<RegisteredReader, MetricStorageRegistry> readerStorageRegistries;
    private final Object collectLock = new Object();
    private final Object callbackLock = new Object();
    private final List<CallbackRegistration> callbackRegistrations = new ArrayList();

    private MeterSharedState(InstrumentationScopeInfo instrumentationScopeInfo, List<RegisteredReader> list) {
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.readerStorageRegistries = (Map) Collection.EL.getAuthRequestContext(list).BuiltInFictitiousFunctionClassFactory(Collectors.KClassImpl$Data$declaredNonStaticMembers$2(Function.CC.BuiltInFictitiousFunctionClassFactory(), new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.MeterSharedState$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return MeterSharedState.lambda$new$0((RegisteredReader) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MetricStorageRegistry lambda$new$0(RegisteredReader registeredReader) {
        return new MetricStorageRegistry();
    }

    public static MeterSharedState create(InstrumentationScopeInfo instrumentationScopeInfo, List<RegisteredReader> list) {
        return new MeterSharedState(instrumentationScopeInfo, list);
    }

    public void removeCallback(CallbackRegistration callbackRegistration) {
        synchronized (this.callbackLock) {
            this.callbackRegistrations.remove(callbackRegistration);
        }
    }

    public final void registerCallback(CallbackRegistration callbackRegistration) {
        synchronized (this.callbackLock) {
            this.callbackRegistrations.add(callbackRegistration);
        }
    }

    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    public List<MetricData> collectAll(RegisteredReader registeredReader, MeterProviderSharedState meterProviderSharedState, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        synchronized (this.callbackLock) {
            arrayList = new ArrayList(this.callbackRegistrations);
        }
        synchronized (this.collectLock) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((CallbackRegistration) it.next()).invokeCallback(registeredReader);
            }
            java.util.Collection<MetricStorage> storages = ((MetricStorageRegistry) Objects.requireNonNull(this.readerStorageRegistries.get(registeredReader))).getStorages();
            arrayList2 = new ArrayList(storages.size());
            Iterator<MetricStorage> it2 = storages.iterator();
            while (it2.hasNext()) {
                MetricData collectAndReset = it2.next().collectAndReset(meterProviderSharedState.getResource(), getInstrumentationScopeInfo(), meterProviderSharedState.getStartEpochNanos(), j);
                if (!collectAndReset.isEmpty()) {
                    arrayList2.add(collectAndReset);
                }
            }
        }
        return arrayList2;
    }

    public void resetForTest() {
        synchronized (this.collectLock) {
            synchronized (this.callbackLock) {
                this.callbackRegistrations.clear();
            }
            Iterable.EL.MyBillsEntityDataFactory(this.readerStorageRegistries.values(), new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.MeterSharedState$$ExternalSyntheticLambda0
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    ((MetricStorageRegistry) obj).resetForTest();
                }

                @Override // j$.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.PlaceComponentResult(this, consumer);
                }
            });
        }
    }

    public final WriteableMetricStorage registerSynchronousMetricStorage(InstrumentDescriptor instrumentDescriptor, MeterProviderSharedState meterProviderSharedState) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<RegisteredReader, MetricStorageRegistry> entry : this.readerStorageRegistries.entrySet()) {
            RegisteredReader key = entry.getKey();
            MetricStorageRegistry value = entry.getValue();
            for (RegisteredView registeredView : key.getViewRegistry().findViews(instrumentDescriptor, getInstrumentationScopeInfo())) {
                if (Aggregation.CC.drop() != registeredView.getView().getAggregation()) {
                    arrayList.add((SynchronousMetricStorage) value.register(SynchronousMetricStorage.CC.create(key, registeredView, instrumentDescriptor, meterProviderSharedState.getExemplarFilter())));
                }
            }
        }
        if (arrayList.size() == 1) {
            return (WriteableMetricStorage) arrayList.get(0);
        }
        return new MultiWritableMetricStorage(arrayList);
    }

    public final SdkObservableMeasurement registerObservableMeasurement(InstrumentDescriptor instrumentDescriptor) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<RegisteredReader, MetricStorageRegistry> entry : this.readerStorageRegistries.entrySet()) {
            RegisteredReader key = entry.getKey();
            MetricStorageRegistry value = entry.getValue();
            for (RegisteredView registeredView : key.getViewRegistry().findViews(instrumentDescriptor, getInstrumentationScopeInfo())) {
                if (Aggregation.CC.drop() != registeredView.getView().getAggregation()) {
                    arrayList.add((AsynchronousMetricStorage) value.register(AsynchronousMetricStorage.create(key, registeredView, instrumentDescriptor)));
                }
            }
        }
        return SdkObservableMeasurement.create(this.instrumentationScopeInfo, instrumentDescriptor, arrayList);
    }
}
