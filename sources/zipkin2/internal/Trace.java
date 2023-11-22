package zipkin2.internal;

import java.util.Comparator;
import zipkin2.Endpoint;
import zipkin2.Span;

/* loaded from: classes9.dex */
public class Trace {
    static final Comparator<Span> KClassImpl$Data$declaredNonStaticMembers$2 = new Comparator<Span>() { // from class: zipkin2.internal.Trace.1
        @Override // java.util.Comparator
        public /* synthetic */ int compare(Span span, Span span2) {
            Span span3 = span;
            Span span4 = span2;
            if (span3.equals(span4)) {
                return 0;
            }
            int compareTo = span3.id().compareTo(span4.id());
            if (compareTo != 0) {
                return compareTo;
            }
            int KClassImpl$Data$declaredNonStaticMembers$22 = Trace.KClassImpl$Data$declaredNonStaticMembers$2(span3, span4);
            return KClassImpl$Data$declaredNonStaticMembers$22 != 0 ? KClassImpl$Data$declaredNonStaticMembers$22 : Trace.MyBillsEntityDataFactory(span3.localEndpoint(), span4.localEndpoint());
        }
    };

    static int KClassImpl$Data$declaredNonStaticMembers$2(Span span, Span span2) {
        boolean equals = Boolean.TRUE.equals(span.shared());
        boolean equals2 = Boolean.TRUE.equals(span2.shared());
        if (equals && equals2) {
            return 0;
        }
        if (equals) {
            return 1;
        }
        if (equals2) {
            return -1;
        }
        boolean equals3 = Span.Kind.CLIENT.equals(span.kind());
        boolean equals4 = Span.Kind.CLIENT.equals(span2.kind());
        if (equals3 && equals4) {
            return 0;
        }
        if (equals3) {
            return -1;
        }
        return equals4 ? 1 : 0;
    }

    static int MyBillsEntityDataFactory(Endpoint endpoint, Endpoint endpoint2) {
        int compareTo;
        int compareTo2;
        if (endpoint == null) {
            return endpoint2 != null ? -1 : 0;
        } else if (endpoint2 == null) {
            return 1;
        } else {
            String serviceName = endpoint.serviceName();
            String serviceName2 = endpoint2.serviceName();
            if (serviceName == null) {
                compareTo = serviceName2 == null ? 0 : 1;
            } else {
                compareTo = serviceName2 == null ? -1 : serviceName.compareTo(serviceName2);
            }
            if (compareTo != 0) {
                return compareTo;
            }
            String ipv4 = endpoint.ipv4();
            String ipv42 = endpoint2.ipv4();
            if (ipv4 == null) {
                compareTo2 = ipv42 == null ? 0 : 1;
            } else {
                compareTo2 = ipv42 == null ? -1 : ipv4.compareTo(ipv42);
            }
            if (compareTo2 != 0) {
                return compareTo2;
            }
            String ipv6 = endpoint.ipv6();
            String ipv62 = endpoint2.ipv6();
            if (ipv6 == null) {
                return ipv62 == null ? 0 : 1;
            } else if (ipv62 == null) {
                return -1;
            } else {
                return ipv6.compareTo(ipv62);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class EndpointTracker {
        EndpointTracker() {
        }
    }

    Trace() {
    }
}
