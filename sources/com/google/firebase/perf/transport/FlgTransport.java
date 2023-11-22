package com.google.firebase.perf.transport;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FlgTransport {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private Transport<PerfMetric> flgTransport;
    private final Provider<TransportFactory> flgTransportFactoryProvider;
    private final String logSourceName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlgTransport(Provider<TransportFactory> provider, String str) {
        this.logSourceName = str;
        this.flgTransportFactoryProvider = provider;
    }

    public final void log(PerfMetric perfMetric) {
        if (!initializeFlgTransportClient()) {
            logger.warn("Unable to dispatch event because Flg Transport is not available");
        } else {
            this.flgTransport.send(Event.ofData(perfMetric));
        }
    }

    private boolean initializeFlgTransportClient() {
        if (this.flgTransport == null) {
            TransportFactory transportFactory = this.flgTransportFactoryProvider.get();
            if (transportFactory != null) {
                this.flgTransport = transportFactory.getTransport(this.logSourceName, PerfMetric.class, Encoding.of("proto"), new Transformer() { // from class: com.google.firebase.perf.transport.FlgTransport$$ExternalSyntheticLambda0
                    @Override // com.google.android.datatransport.Transformer
                    public final Object apply(Object obj) {
                        return ((PerfMetric) obj).toByteArray();
                    }
                });
            } else {
                logger.warn("Flg TransportFactory is not available at the moment");
            }
        }
        return this.flgTransport != null;
    }
}
