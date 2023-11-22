package zipkin2.reporter;

import zipkin2.Span;

/* loaded from: classes9.dex */
public interface Reporter<S> {
    public static final Reporter<Span> NetworkUserEntityData$$ExternalSyntheticLambda1 = new Reporter<Span>() { // from class: zipkin2.reporter.Reporter.1
        public String toString() {
            return "NoopReporter{}";
        }
    };
    public static final Reporter<Span> initRecordTimeStamp = new Reporter<Span>() { // from class: zipkin2.reporter.Reporter.2
        public String toString() {
            return "ConsoleReporter{}";
        }
    };
}
