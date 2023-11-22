package id.dana.data.config.source.sharedpreference;

import com.google.gson.Gson;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.featureconfig.LocalSplitAttributesEntityData;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SharedPrefSplitAttributes;", "Lid/dana/domain/featureconfig/LocalSplitAttributesEntityData;", "", "clearAll", "()V", "Lid/dana/domain/user/DanaHomeBalanceConfigModel;", "getDanaHomeBalanceConfigModel", "()Lid/dana/domain/user/DanaHomeBalanceConfigModel;", "", "getUserCohort", "()Ljava/lang/String;", "data", "setDanaHomeBalanceConfigModel", "(Lid/dana/domain/user/DanaHomeBalanceConfigModel;)V", "userCohort", "setUserCohort", "(Ljava/lang/String;)V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedPrefSplitAttributes implements LocalSplitAttributesEntityData {
    public static final String SPLIT_ATTRIBUTES_PREF_KEY = "splitattributespreference";
    public static final String SPLIT_DANA_HOME_BALANCE_CONFIG = "DANA_HOME_BALANCE_CONFIG";
    private static final String USER_COHORT_KEY = "tagusercohort";
    private final Gson gson;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public SharedPrefSplitAttributes(@Named("splitattributespref") PreferenceFacade preferenceFacade, Gson gson) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.preferenceFacade = preferenceFacade;
        this.gson = gson;
    }

    @Override // id.dana.domain.featureconfig.LocalSplitAttributesEntityData
    public final void setUserCohort(String userCohort) {
        Intrinsics.checkNotNullParameter(userCohort, "");
        this.preferenceFacade.saveData(USER_COHORT_KEY, userCohort);
    }

    @Override // id.dana.domain.featureconfig.LocalSplitAttributesEntityData
    public final String getUserCohort() {
        String string = this.preferenceFacade.getString(USER_COHORT_KEY);
        return string == null ? "" : string;
    }

    @Override // id.dana.domain.featureconfig.LocalSplitAttributesEntityData
    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    @Override // id.dana.domain.featureconfig.LocalSplitAttributesEntityData
    public final void setDanaHomeBalanceConfigModel(DanaHomeBalanceConfigModel data) {
        Intrinsics.checkNotNullParameter(data, "");
        this.preferenceFacade.saveData(SPLIT_DANA_HOME_BALANCE_CONFIG, this.gson.toJson(data));
    }

    @Override // id.dana.domain.featureconfig.LocalSplitAttributesEntityData
    public final DanaHomeBalanceConfigModel getDanaHomeBalanceConfigModel() {
        return (DanaHomeBalanceConfigModel) this.gson.fromJson(this.preferenceFacade.getString(SPLIT_DANA_HOME_BALANCE_CONFIG), DanaHomeBalanceConfigModel.class);
    }
}
