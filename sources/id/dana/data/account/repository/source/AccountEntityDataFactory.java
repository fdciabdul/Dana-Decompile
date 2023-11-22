package id.dana.data.account.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class AccountEntityDataFactory extends AbstractEntityDataFactory<AccountEntityData> {
    private final PreferenceAccountEntityData preferenceAccountEntityData;

    @Inject
    public AccountEntityDataFactory(PreferenceAccountEntityData preferenceAccountEntityData) {
        this.preferenceAccountEntityData = preferenceAccountEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public AccountEntityData createData2(String str) {
        return this.preferenceAccountEntityData;
    }
}
