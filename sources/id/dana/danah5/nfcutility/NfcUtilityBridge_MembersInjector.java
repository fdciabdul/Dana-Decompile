package id.dana.danah5.nfcutility;

import dagger.MembersInjector;
import id.dana.domain.electronicmoney.interactor.GetElectronicMoneyConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NfcUtilityBridge_MembersInjector implements MembersInjector<NfcUtilityBridge> {
    private final Provider<GetElectronicMoneyConfig> getElectronicMoneyConfigProvider;

    public NfcUtilityBridge_MembersInjector(Provider<GetElectronicMoneyConfig> provider) {
        this.getElectronicMoneyConfigProvider = provider;
    }

    public static MembersInjector<NfcUtilityBridge> create(Provider<GetElectronicMoneyConfig> provider) {
        return new NfcUtilityBridge_MembersInjector(provider);
    }

    public final void injectMembers(NfcUtilityBridge nfcUtilityBridge) {
        injectGetElectronicMoneyConfig(nfcUtilityBridge, this.getElectronicMoneyConfigProvider.get());
    }

    public static void injectGetElectronicMoneyConfig(NfcUtilityBridge nfcUtilityBridge, GetElectronicMoneyConfig getElectronicMoneyConfig) {
        nfcUtilityBridge.getElectronicMoneyConfig = getElectronicMoneyConfig;
    }
}
