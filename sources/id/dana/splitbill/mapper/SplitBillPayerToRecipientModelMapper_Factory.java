package id.dana.splitbill.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class SplitBillPayerToRecipientModelMapper_Factory implements Factory<SplitBillPayerToRecipientModelMapper> {
    public static SplitBillPayerToRecipientModelMapper BuiltInFictitiousFunctionClassFactory() {
        return new SplitBillPayerToRecipientModelMapper();
    }

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final SplitBillPayerToRecipientModelMapper_Factory BuiltInFictitiousFunctionClassFactory = new SplitBillPayerToRecipientModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillPayerToRecipientModelMapper();
    }
}
