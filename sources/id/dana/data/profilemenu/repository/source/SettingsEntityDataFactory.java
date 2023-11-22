package id.dana.data.profilemenu.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.profilemenu.repository.source.local.DefaultSettingsEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SettingsEntityDataFactory extends AbstractEntityDataFactory<SettingsEntityData> {
    private final DefaultSettingsEntityData defaultSettingsEntityData;
    private final SplitSettingsEntityData splitSettingsEntityData;

    @Inject
    public SettingsEntityDataFactory(DefaultSettingsEntityData defaultSettingsEntityData, SplitSettingsEntityData splitSettingsEntityData) {
        this.defaultSettingsEntityData = defaultSettingsEntityData;
        this.splitSettingsEntityData = splitSettingsEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SettingsEntityData createData2(String str) {
        if ("local".equals(str)) {
            return this.defaultSettingsEntityData;
        }
        return this.splitSettingsEntityData;
    }
}
