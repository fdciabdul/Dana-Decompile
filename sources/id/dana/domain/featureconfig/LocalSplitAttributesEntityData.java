package id.dana.domain.featureconfig;

import id.dana.domain.user.DanaHomeBalanceConfigModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/featureconfig/LocalSplitAttributesEntityData;", "", "", "clearAll", "()V", "Lid/dana/domain/user/DanaHomeBalanceConfigModel;", "getDanaHomeBalanceConfigModel", "()Lid/dana/domain/user/DanaHomeBalanceConfigModel;", "", "getUserCohort", "()Ljava/lang/String;", "data", "setDanaHomeBalanceConfigModel", "(Lid/dana/domain/user/DanaHomeBalanceConfigModel;)V", "userCohort", "setUserCohort", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LocalSplitAttributesEntityData {
    void clearAll();

    DanaHomeBalanceConfigModel getDanaHomeBalanceConfigModel();

    String getUserCohort();

    void setDanaHomeBalanceConfigModel(DanaHomeBalanceConfigModel data);

    void setUserCohort(String userCohort);
}
