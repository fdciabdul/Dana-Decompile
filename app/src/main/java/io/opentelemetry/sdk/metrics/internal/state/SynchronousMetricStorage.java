package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;

/* loaded from: classes6.dex */
public interface SynchronousMetricStorage extends MetricStorage, WriteableMetricStorage {

    /* renamed from: io.opentelemetry.sdk.metrics.internal.state.SynchronousMetricStorage$-CC */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static SynchronousMetricStorage empty() {
            return EmptyMetricStorage.INSTANCE;
        }

        public static <T, U extends ExemplarData> SynchronousMetricStorage create(RegisteredReader registeredReader, RegisteredView registeredView, InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
            View view = registeredView.getView();
            MetricDescriptor create = MetricDescriptor.create(view, registeredView.getViewSourceInfo(), instrumentDescriptor);
            Aggregator<T, U> createAggregator = ((AggregatorFactory) view.getAggregation()).createAggregator(instrumentDescriptor, exemplarFilter);
            if (Aggregator.CC.drop() == createAggregator) {
                return empty();
            }
            return new DefaultSynchronousMetricStorage(registeredReader, create, createAggregator, registeredView.getViewAttributesProcessor());
        }
    }
}
