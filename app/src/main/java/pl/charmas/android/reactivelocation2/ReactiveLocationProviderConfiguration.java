package pl.charmas.android.reactivelocation2;

import android.os.Handler;

/* loaded from: classes6.dex */
public class ReactiveLocationProviderConfiguration {
    public final Handler BuiltInFictitiousFunctionClassFactory;
    private final boolean PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ReactiveLocationProviderConfiguration(Builder builder, byte b) {
        this(builder);
    }

    private ReactiveLocationProviderConfiguration(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult;
        this.PlaceComponentResult = builder.MyBillsEntityDataFactory;
    }

    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    public static Builder PlaceComponentResult() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private Handler PlaceComponentResult = null;
        private boolean MyBillsEntityDataFactory = false;
    }
}
