package id.dana;

import id.dana.domain.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class UIThread implements PostExecutionThread {
    @Inject
    public UIThread() {
    }

    @Override // id.dana.domain.PostExecutionThread
    public Scheduler getScheduler() {
        return AndroidSchedulers.PlaceComponentResult();
    }
}
