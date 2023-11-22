package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* loaded from: classes7.dex */
final class AutoValue_SendRequest extends SendRequest {
    private final Encoding encoding;
    private final Event<?> event;
    private final Transformer<?, byte[]> transformer;
    private final TransportContext transportContext;
    private final String transportName;

    private AutoValue_SendRequest(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.transportContext = transportContext;
        this.transportName = str;
        this.event = event;
        this.transformer = transformer;
        this.encoding = encoding;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final TransportContext getTransportContext() {
        return this.transportContext;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final String getTransportName() {
        return this.transportName;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    final Event<?> getEvent() {
        return this.event;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    final Transformer<?, byte[]> getTransformer() {
        return this.transformer;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public final Encoding getEncoding() {
        return this.encoding;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendRequest{transportContext=");
        sb.append(this.transportContext);
        sb.append(", transportName=");
        sb.append(this.transportName);
        sb.append(", event=");
        sb.append(this.event);
        sb.append(", transformer=");
        sb.append(this.transformer);
        sb.append(", encoding=");
        sb.append(this.encoding);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SendRequest) {
            SendRequest sendRequest = (SendRequest) obj;
            return this.transportContext.equals(sendRequest.getTransportContext()) && this.transportName.equals(sendRequest.getTransportName()) && this.event.equals(sendRequest.getEvent()) && this.transformer.equals(sendRequest.getTransformer()) && this.encoding.equals(sendRequest.getEncoding());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.transportContext.hashCode();
        int hashCode2 = this.transportName.hashCode();
        return ((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ this.event.hashCode()) * 1000003) ^ this.transformer.hashCode()) * 1000003) ^ this.encoding.hashCode();
    }

    /* loaded from: classes7.dex */
    static final class Builder extends SendRequest.Builder {
        private Encoding encoding;
        private Event<?> event;
        private Transformer<?, byte[]> transformer;
        private TransportContext transportContext;
        private String transportName;

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder setTransportContext(TransportContext transportContext) {
            if (transportContext == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.transportContext = transportContext;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest.Builder setTransportName(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.transportName = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        final SendRequest.Builder setEvent(Event<?> event) {
            if (event == null) {
                throw new NullPointerException("Null event");
            }
            this.event = event;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        final SendRequest.Builder setTransformer(Transformer<?, byte[]> transformer) {
            if (transformer == null) {
                throw new NullPointerException("Null transformer");
            }
            this.transformer = transformer;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        final SendRequest.Builder setEncoding(Encoding encoding) {
            if (encoding == null) {
                throw new NullPointerException("Null encoding");
            }
            this.encoding = encoding;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public final SendRequest build() {
            String str;
            if (this.transportContext == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" transportContext");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.transportName == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" transportName");
                str = sb2.toString();
            }
            if (this.event == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" event");
                str = sb3.toString();
            }
            if (this.transformer == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" transformer");
                str = sb4.toString();
            }
            if (this.encoding == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" encoding");
                str = sb5.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Missing required properties:");
                sb6.append(str);
                throw new IllegalStateException(sb6.toString());
            }
            return new AutoValue_SendRequest(this.transportContext, this.transportName, this.event, this.transformer, this.encoding);
        }
    }
}
