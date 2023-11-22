package id.dana.utils;

import id.dana.utils.TimerUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class TimerUtil {
    public Disposable BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes5.dex */
    public interface OnTimerCallback {
        void onFinish();
    }

    @Inject
    public TimerUtil() {
    }

    public final void PlaceComponentResult(int i, final OnTimerCallback onTimerCallback) {
        this.BuiltInFictitiousFunctionClassFactory = Observable.timer(i, TimeUnit.SECONDS, Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.utils.TimerUtil$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Long l = (Long) obj;
                TimerUtil.OnTimerCallback.this.onFinish();
            }
        });
    }
}
