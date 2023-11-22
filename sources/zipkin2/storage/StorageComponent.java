package zipkin2.storage;

import zipkin2.Component;

/* loaded from: classes9.dex */
public abstract class StorageComponent extends Component {

    /* renamed from: zipkin2.storage.StorageComponent$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 implements AutocompleteTags {
        public String toString() {
            return "EmptyAutocompleteTags{}";
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class Builder {
    }

    /* renamed from: zipkin2.storage.StorageComponent$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass2 implements ServiceAndSpanNames {
        final /* synthetic */ SpanStore getAuthRequestContext;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ServiceAndSpanNames{");
            sb.append(this.getAuthRequestContext);
            sb.append("}");
            return sb.toString();
        }
    }
}
