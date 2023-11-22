package id.dana.data.usersecurityquestions.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class UserSecurityQuestionResultMapper_Factory implements Factory<UserSecurityQuestionResultMapper> {
    @Override // javax.inject.Provider
    public final UserSecurityQuestionResultMapper get() {
        return newInstance();
    }

    public static UserSecurityQuestionResultMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static UserSecurityQuestionResultMapper newInstance() {
        return new UserSecurityQuestionResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final UserSecurityQuestionResultMapper_Factory getAuthRequestContext = new UserSecurityQuestionResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
