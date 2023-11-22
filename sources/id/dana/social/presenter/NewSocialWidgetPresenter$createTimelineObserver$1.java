package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001"}, d2 = {"Lid/dana/social/presenter/NewSocialWidgetPresenter$createTimelineObserver$1;", "Lid/dana/domain/DefaultObserver;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSocialWidgetPresenter$createTimelineObserver$1 extends DefaultObserver<Long> {
    final /* synthetic */ NewSocialWidgetPresenter BuiltInFictitiousFunctionClassFactory;

    public NewSocialWidgetPresenter$createTimelineObserver$1(NewSocialWidgetPresenter newSocialWidgetPresenter) {
        this.BuiltInFictitiousFunctionClassFactory = newSocialWidgetPresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        PublishSubject publishSubject;
        Number number = (Number) obj;
        publishSubject = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
        publishSubject.onNext(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }
}
