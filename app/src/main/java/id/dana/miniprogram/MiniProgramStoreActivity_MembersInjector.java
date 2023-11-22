package id.dana.miniprogram;

import dagger.MembersInjector;
import id.dana.miniprogram.di.MiniProgramPresenter;

/* loaded from: classes5.dex */
public final class MiniProgramStoreActivity_MembersInjector implements MembersInjector<MiniProgramStoreActivity> {
    public static void getAuthRequestContext(MiniProgramStoreActivity miniProgramStoreActivity, MiniProgramPresenter miniProgramPresenter) {
        miniProgramStoreActivity.presenter = miniProgramPresenter;
    }
}
