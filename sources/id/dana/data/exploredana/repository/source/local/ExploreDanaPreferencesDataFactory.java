package id.dana.data.exploredana.repository.source.local;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ExploreDanaPreferencesDataFactory extends AbstractEntityDataFactory<ExploreDanaEntityData> {
    private final ExploreDanaPreferences exploreDanaPreferences;

    @Inject
    public ExploreDanaPreferencesDataFactory(ExploreDanaPreferences exploreDanaPreferences) {
        this.exploreDanaPreferences = exploreDanaPreferences;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ExploreDanaEntityData createData2(String str) {
        return new LocalExploreDanaEntityData(this.exploreDanaPreferences);
    }
}
