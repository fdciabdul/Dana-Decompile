package id.dana.eventbus.base;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b \u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0012\u0010\u0010\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/eventbus/base/BaseFragmentWithPageLoadTracker;", "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/base/viewbinding/ViewBindingFragment;", "", "onDestroy", "()V", "Lid/dana/eventbus/models/TimerEvent;", "timerEvent", "onReceiveEndTimerEvent", "(Lid/dana/eventbus/models/TimerEvent;)V", "onStart", "onStop", "p0", "", "p1", "PlaceComponentResult", "(Lid/dana/eventbus/models/TimerEvent;J)V", "Lid/dana/eventbus/models/TimerEventKey;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/eventbus/models/TimerEventKey;)V", "Lio/reactivex/disposables/Disposable;", "MyBillsEntityDataFactory", "Lio/reactivex/disposables/Disposable;", "", "Z", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "J", "scheduleImpl", "Lid/dana/eventbus/models/TimerEventKey;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseFragmentWithPageLoadTracker<V extends ViewBinding> extends ViewBindingFragment<V> {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Disposable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public long PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TimerEventKey KClassImpl$Data$declaredNonStaticMembers$2;

    public abstract void PlaceComponentResult(TimerEvent p0, long p1);

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public void _$_clearFindViewByIdCache() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void BuiltInFictitiousFunctionClassFactory(TimerEventKey p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
        if (disposable != null) {
            disposable.dispose();
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        this.PlaceComponentResult = 0L;
        this.BuiltInFictitiousFunctionClassFactory = Observable.interval(1L, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.PlaceComponentResult()).doOnNext(new Consumer() { // from class: id.dana.eventbus.base.BaseFragmentWithPageLoadTracker$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Long l = (Long) obj;
                BaseFragmentWithPageLoadTracker.getAuthRequestContext(BaseFragmentWithPageLoadTracker.this);
            }
        }).subscribe();
    }

    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)
    public final void onReceiveEndTimerEvent(TimerEvent timerEvent) {
        Intrinsics.checkNotNullParameter(timerEvent, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null || timerEvent.KClassImpl$Data$declaredNonStaticMembers$2 != this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        EventBus.getDefault().unregister(this);
        Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
        if (disposable != null) {
            disposable.dispose();
        }
        PlaceComponentResult(timerEvent, this.PlaceComponentResult);
        this.PlaceComponentResult = 0L;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.getAuthRequestContext = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.getAuthRequestContext = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
        if (disposable != null) {
            disposable.dispose();
        }
        EventBus.getDefault().unregister(this);
    }

    public static /* synthetic */ void getAuthRequestContext(BaseFragmentWithPageLoadTracker baseFragmentWithPageLoadTracker) {
        Intrinsics.checkNotNullParameter(baseFragmentWithPageLoadTracker, "");
        if (baseFragmentWithPageLoadTracker.getAuthRequestContext) {
            return;
        }
        baseFragmentWithPageLoadTracker.PlaceComponentResult++;
    }
}
