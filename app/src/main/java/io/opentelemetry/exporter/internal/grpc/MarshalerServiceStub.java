package io.opentelemetry.exporter.internal.grpc;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.stub.AbstractFutureStub;
import io.opentelemetry.exporter.internal.grpc.MarshalerServiceStub;
import io.opentelemetry.exporter.internal.marshal.Marshaler;

/* loaded from: classes9.dex */
public abstract class MarshalerServiceStub<T extends Marshaler, U, S extends MarshalerServiceStub<T, U, S>> extends AbstractFutureStub<S> {
    public abstract ListenableFuture<U> export(T t);

    protected MarshalerServiceStub(Channel channel, CallOptions callOptions) {
        super(channel, callOptions);
    }
}
