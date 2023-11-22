package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import j$.util.function.BiFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class FixedSizeExemplarReservoir<T extends ExemplarData> implements ExemplarReservoir<T> {
    private final BiFunction<ReservoirCell, Attributes, T> mapAndResetCell;
    private final ReservoirCellSelector reservoirCellSelector;
    private final ReservoirCell[] storage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FixedSizeExemplarReservoir(Clock clock, int i, ReservoirCellSelector reservoirCellSelector, BiFunction<ReservoirCell, Attributes, T> biFunction) {
        this.storage = new ReservoirCell[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.storage[i2] = new ReservoirCell(clock);
        }
        this.reservoirCellSelector = reservoirCellSelector;
        this.mapAndResetCell = biFunction;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerLongMeasurement(long j, Attributes attributes, Context context) {
        int reservoirCellIndexFor = this.reservoirCellSelector.reservoirCellIndexFor(this.storage, j, attributes, context);
        if (reservoirCellIndexFor != -1) {
            this.storage[reservoirCellIndexFor].recordLongMeasurement(j, attributes, context);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerDoubleMeasurement(double d, Attributes attributes, Context context) {
        int reservoirCellIndexFor = this.reservoirCellSelector.reservoirCellIndexFor(this.storage, d, attributes, context);
        if (reservoirCellIndexFor != -1) {
            this.storage[reservoirCellIndexFor].recordDoubleMeasurement(d, attributes, context);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public List<T> collectAndReset(Attributes attributes) {
        ArrayList arrayList = new ArrayList();
        for (ReservoirCell reservoirCell : this.storage) {
            T apply = this.mapAndResetCell.apply(reservoirCell, attributes);
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        this.reservoirCellSelector.reset();
        return Collections.unmodifiableList(arrayList);
    }
}
