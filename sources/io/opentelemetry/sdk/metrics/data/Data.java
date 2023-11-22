package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;

/* loaded from: classes9.dex */
public interface Data<T extends PointData> {
    Collection<T> getPoints();
}
