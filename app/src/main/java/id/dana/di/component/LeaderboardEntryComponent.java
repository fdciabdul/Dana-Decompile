package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.LeaderboardEntryModule;
import id.dana.richview.leaderboardentry.LeaderboardEntryView;

@Component(dependencies = {ApplicationComponent.class}, modules = {LeaderboardEntryModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface LeaderboardEntryComponent {
    void MyBillsEntityDataFactory(LeaderboardEntryView leaderboardEntryView);
}
