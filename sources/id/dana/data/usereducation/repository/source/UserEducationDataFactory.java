package id.dana.data.usereducation.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.usereducation.repository.UserEducationEntityData;
import id.dana.data.usereducation.repository.source.local.PreferenceUserEducationEntityData;
import id.dana.data.usereducation.repository.source.local.UserEducationPreference;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserEducationDataFactory extends AbstractEntityDataFactory<UserEducationEntityData> {
    private final UserEducationPreference userEducationPreference;

    @Inject
    public UserEducationDataFactory(UserEducationPreference userEducationPreference) {
        this.userEducationPreference = userEducationPreference;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    public UserEducationEntityData createData(String str) {
        return new PreferenceUserEducationEntityData(this.userEducationPreference);
    }
}
