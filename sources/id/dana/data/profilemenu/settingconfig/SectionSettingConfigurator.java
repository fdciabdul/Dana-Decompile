package id.dana.data.profilemenu.settingconfig;

import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
public class SectionSettingConfigurator {
    private final HashMap<String, SettingConfigurationRunner> configRunners = new HashMap<>();
    private final int originalSectionPositionToIncludeBack;
    private final List<SettingModel> settingsToIncludeBack;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SectionSettingConfigurator(int i, List<SettingModel> list) {
        this.originalSectionPositionToIncludeBack = i;
        this.settingsToIncludeBack = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Observable<List<SettingModel>> getConfigurationsToRun() {
        ArrayList arrayList = new ArrayList();
        for (SettingModel settingModel : this.settingsToIncludeBack) {
            SettingConfigurationRunner settingConfigurationRunner = this.configRunners.get(settingModel.getName());
            if (settingConfigurationRunner != null) {
                arrayList.add(settingConfigurationRunner.performConfiguration(settingModel));
            }
        }
        return Observable.zip(arrayList, new Function() { // from class: id.dana.data.profilemenu.settingconfig.SectionSettingConfigurator$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SectionSettingConfigurator.this.m1610xc69e7efa((Object[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getConfigurationsToRun$0$id-dana-data-profilemenu-settingconfig-SectionSettingConfigurator  reason: not valid java name */
    public /* synthetic */ List m1610xc69e7efa(Object[] objArr) throws Exception {
        return this.settingsToIncludeBack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SettingModel> putBackToSettingList(List<SettingModel> list) {
        int insertionPositionForSection = getInsertionPositionForSection(list);
        List<SettingModel> list2 = this.settingsToIncludeBack;
        ListIterator<SettingModel> listIterator = list2.listIterator(list2.size());
        while (listIterator.hasPrevious()) {
            SettingModel previous = listIterator.previous();
            if (previous.isNeedToShow()) {
                list.add(insertionPositionForSection, previous);
            }
        }
        return list;
    }

    private int getInsertionPositionForSection(List<SettingModel> list) {
        return originalPositionNotExist(list) ? list.size() : this.originalSectionPositionToIncludeBack;
    }

    private boolean originalPositionNotExist(List<SettingModel> list) {
        return this.originalSectionPositionToIncludeBack > list.size();
    }

    public void add(List<SettingConfigurationRunner> list) {
        for (SettingConfigurationRunner settingConfigurationRunner : list) {
            this.configRunners.put(settingConfigurationRunner.getSettingName(), settingConfigurationRunner);
        }
    }
}
