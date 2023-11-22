package id.dana.di.component;

import com.google.gson.Gson;
import dagger.internal.Preconditions;
import id.dana.cashier.threeDS.CashierRisk3dsFragment;
import id.dana.cashier.threeDS.CashierRisk3dsFragment_MembersInjector;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.storage.PreferenceFacade;

/* loaded from: classes4.dex */
public final class DaggerCashierRisk3dsComponent {
    private DaggerCashierRisk3dsComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class CashierRisk3dsComponentImpl implements CashierRisk3dsComponent {
        private final CashierRisk3dsComponentImpl BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent getAuthRequestContext;

        public /* synthetic */ CashierRisk3dsComponentImpl(ApplicationComponent applicationComponent, byte b) {
            this(applicationComponent);
        }

        private CashierRisk3dsComponentImpl(ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.getAuthRequestContext = applicationComponent;
        }

        @Override // id.dana.di.component.CashierRisk3dsComponent
        public final void MyBillsEntityDataFactory(CashierRisk3dsFragment cashierRisk3dsFragment) {
            CashierRisk3dsFragment_MembersInjector.BuiltInFictitiousFunctionClassFactory(cashierRisk3dsFragment, new SharedPrefCashierConfig((PreferenceFacade) Preconditions.PlaceComponentResult(this.getAuthRequestContext.JsonParseException()), (Gson) Preconditions.PlaceComponentResult(this.getAuthRequestContext.C())));
        }
    }
}
