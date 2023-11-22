package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class AsyncDifferConfig<T> {
    final Executor BuiltInFictitiousFunctionClassFactory;
    public final DiffUtil.ItemCallback<T> PlaceComponentResult;
    public final Executor getAuthRequestContext;

    AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback<T> itemCallback) {
        this.BuiltInFictitiousFunctionClassFactory = executor;
        this.getAuthRequestContext = executor2;
        this.PlaceComponentResult = itemCallback;
    }

    /* loaded from: classes2.dex */
    public static final class Builder<T> {
        private static Executor BuiltInFictitiousFunctionClassFactory;
        private static final Object getAuthRequestContext = new Object();
        private final DiffUtil.ItemCallback<T> KClassImpl$Data$declaredNonStaticMembers$2;
        private Executor MyBillsEntityDataFactory;
        private Executor PlaceComponentResult;

        public Builder(DiffUtil.ItemCallback<T> itemCallback) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = itemCallback;
        }

        public final AsyncDifferConfig<T> PlaceComponentResult() {
            if (this.PlaceComponentResult == null) {
                synchronized (getAuthRequestContext) {
                    if (BuiltInFictitiousFunctionClassFactory == null) {
                        BuiltInFictitiousFunctionClassFactory = Executors.newFixedThreadPool(2);
                    }
                }
                this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            }
            return new AsyncDifferConfig<>(this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
