package io.opentelemetry.api.baggage;

import io.opentelemetry.api.baggage.BaggageEntryMetadata;
import io.opentelemetry.api.internal.ImmutableKeyValuePairs;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import j$.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class ImmutableBaggage extends ImmutableKeyValuePairs<String, BaggageEntry> implements Baggage {
    private static final Baggage EMPTY = new Builder().build();

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Scope makeCurrent() {
        Scope makeCurrent;
        makeCurrent = Context.CC.current().with(this).makeCurrent();
        return makeCurrent;
    }

    @Override // io.opentelemetry.api.baggage.Baggage, io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Context storeInContext(Context context) {
        Context with;
        with = context.with(BaggageContextKey.KEY, this);
        return with;
    }

    private ImmutableBaggage(Object[] objArr) {
        super(objArr, Comparator.CC.BuiltInFictitiousFunctionClassFactory());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Baggage empty() {
        return EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaggageBuilder builder() {
        return new Builder();
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    @Nullable
    public final String getEntryValue(String str) {
        BaggageEntry baggageEntry = get(str);
        if (baggageEntry != null) {
            return baggageEntry.getValue();
        }
        return null;
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    public final BaggageBuilder toBuilder() {
        return new Builder(new ArrayList(data()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Baggage sortAndFilterToBaggage(Object[] objArr) {
        return new ImmutableBaggage(objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class Builder implements BaggageBuilder {
        private final List<Object> data;

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public /* synthetic */ BaggageBuilder put(String str, String str2) {
            BaggageBuilder put;
            put = put(str, str2, BaggageEntryMetadata.CC.empty());
            return put;
        }

        Builder() {
            this.data = new ArrayList();
        }

        Builder(List<Object> list) {
            this.data = list;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata) {
            if (str != null && str2 != null && baggageEntryMetadata != null) {
                this.data.add(str);
                this.data.add(ImmutableEntry.create(str2, baggageEntryMetadata));
            }
            return this;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder remove(String str) {
            if (str == null) {
                return this;
            }
            this.data.add(str);
            this.data.add(null);
            return this;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public Baggage build() {
            return ImmutableBaggage.sortAndFilterToBaggage(this.data.toArray());
        }
    }
}
