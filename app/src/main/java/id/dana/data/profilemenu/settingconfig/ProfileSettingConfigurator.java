package id.dana.data.profilemenu.settingconfig;

import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class ProfileSettingConfigurator {
    private RawSettingJsonMapper rawSettingJsonMapper;
    private List<SettingConfigurationRunner> settingConfigurations;
    private List<SettingModel> formattedSettingsToShow = new ArrayList();
    private List<SectionSettingConfigurator> sectionConfigToRun = new ArrayList();

    public ProfileSettingConfigurator(RawSettingJsonMapper rawSettingJsonMapper, List<SettingConfigurationRunner> list) {
        this.rawSettingJsonMapper = rawSettingJsonMapper;
        this.settingConfigurations = list;
    }

    public Observable<List<SettingModel>> getSettings(LinkedHashMap<String, LinkedHashMap<String, SettingModel>> linkedHashMap) {
        for (Map.Entry<String, LinkedHashMap<String, SettingModel>> entry : linkedHashMap.entrySet()) {
            List<SettingConfigurationRunner> configInThisSection = getConfigInThisSection(this.settingConfigurations, entry);
            if (needToRunConfigBeforeAddToList(configInThisSection)) {
                this.sectionConfigToRun.add(createConfigToRun(entry, configInThisSection));
            } else {
                addSectionToList(entry);
            }
        }
        if (this.sectionConfigToRun.isEmpty()) {
            return Observable.just(this.formattedSettingsToShow);
        }
        return runSectionConfig().startWith(Observable.just(new ArrayList(this.formattedSettingsToShow)));
    }

    private void addSectionToList(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry) {
        this.formattedSettingsToShow.addAll(transformUnformattedSection(entry));
    }

    private SectionSettingConfigurator createConfigToRun(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry, List<SettingConfigurationRunner> list) {
        SectionSettingConfigurator sectionSettingConfigurator = new SectionSettingConfigurator(this.formattedSettingsToShow.size(), transformUnformattedSection(entry));
        sectionSettingConfigurator.add(list);
        return sectionSettingConfigurator;
    }

    private List<SettingModel> transformUnformattedSection(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry) {
        return this.rawSettingJsonMapper.apply(entry);
    }

    private List<SettingConfigurationRunner> getConfigInThisSection(List<SettingConfigurationRunner> list, Map.Entry<String, LinkedHashMap<String, SettingModel>> entry) {
        ArrayList arrayList = new ArrayList();
        for (SettingConfigurationRunner settingConfigurationRunner : list) {
            if (isConfigExistInSectionAndEnabled(entry, settingConfigurationRunner)) {
                arrayList.add(settingConfigurationRunner);
            }
        }
        return arrayList;
    }

    private boolean needToRunConfigBeforeAddToList(List<SettingConfigurationRunner> list) {
        return !list.isEmpty();
    }

    private Observable<List<SettingModel>> runSectionConfig() {
        return Observable.zip(getSettingConfigToRun(), new Function() { // from class: id.dana.data.profilemenu.settingconfig.ProfileSettingConfigurator$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ProfileSettingConfigurator.this.m1609x363a1715((Object[]) obj);
            }
        });
    }

    /* renamed from: lambda$runSectionConfig$0$id-dana-data-profilemenu-settingconfig-ProfileSettingConfigurator */
    public /* synthetic */ List m1609x363a1715(Object[] objArr) throws Exception {
        putBackRemovedSectionAfterConfigDone(this.sectionConfigToRun, this.formattedSettingsToShow);
        return this.formattedSettingsToShow;
    }

    private boolean isConfigExistInSectionAndEnabled(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry, SettingConfigurationRunner settingConfigurationRunner) {
        SettingModel settingModel = entry.getValue().get(settingConfigurationRunner.getSettingName());
        return settingModel != null && settingModel.isEnable();
    }

    private List<Observable<List<SettingModel>>> getSettingConfigToRun() {
        ArrayList arrayList = new ArrayList();
        Iterator<SectionSettingConfigurator> it = this.sectionConfigToRun.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getConfigurationsToRun());
        }
        return arrayList;
    }

    private List<SettingModel> putBackRemovedSectionAfterConfigDone(List<SectionSettingConfigurator> list, List<SettingModel> list2) {
        ListIterator<SectionSettingConfigurator> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().putBackToSettingList(list2);
        }
        return list2;
    }
}
