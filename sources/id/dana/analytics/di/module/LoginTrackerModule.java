package id.dana.analytics.di.module;

import dagger.Binds;
import dagger.Module;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.analytics.tracker.login.LoginTrackerImpl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/analytics/di/module/LoginTrackerModule;", "", "<init>", "()V", "BindsModule"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BindsModule.class})
/* loaded from: classes.dex */
public final class LoginTrackerModule {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/analytics/di/module/LoginTrackerModule$BindsModule;", "", "Lid/dana/analytics/tracker/login/LoginTrackerImpl;", "p0", "Lid/dana/analytics/tracker/login/LoginTracker;", "getAuthRequestContext", "(Lid/dana/analytics/tracker/login/LoginTrackerImpl;)Lid/dana/analytics/tracker/login/LoginTracker;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes8.dex */
    public interface BindsModule {
        @Binds
        LoginTracker getAuthRequestContext(LoginTrackerImpl p0);
    }
}
