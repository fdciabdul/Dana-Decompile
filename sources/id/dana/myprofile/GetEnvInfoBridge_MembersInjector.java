package id.dana.myprofile;

import dagger.MembersInjector;
import id.dana.domain.profilemenu.interactor.GetMobileEnvInfo;

/* loaded from: classes5.dex */
public final class GetEnvInfoBridge_MembersInjector implements MembersInjector<GetEnvInfoBridge> {
    public static void getAuthRequestContext(GetEnvInfoBridge getEnvInfoBridge, GetMobileEnvInfo getMobileEnvInfo) {
        getEnvInfoBridge.getMobileEnvInfo = getMobileEnvInfo;
    }
}
