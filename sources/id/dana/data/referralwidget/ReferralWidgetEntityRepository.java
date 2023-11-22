package id.dana.data.referralwidget;

import id.dana.data.referralwidget.mapper.ReferralWidgetMapper;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData;
import id.dana.data.referralwidget.repository.source.ReferralWidgetEntityDataFactory;
import id.dana.domain.referralwidget.ReferralWidgetRepository;
import id.dana.domain.referralwidget.model.ReferralWidget;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralWidgetEntityRepository implements ReferralWidgetRepository {
    private final ReferralWidgetEntityDataFactory referralWidgetEntityDataFactory;
    private final ReferralWidgetMapper referralWidgetMapper;

    @Inject
    public ReferralWidgetEntityRepository(ReferralWidgetEntityDataFactory referralWidgetEntityDataFactory, ReferralWidgetMapper referralWidgetMapper) {
        this.referralWidgetEntityDataFactory = referralWidgetEntityDataFactory;
        this.referralWidgetMapper = referralWidgetMapper;
    }

    @Override // id.dana.domain.referralwidget.ReferralWidgetRepository
    public Observable<List<ReferralWidget>> getReferralWidget() {
        Observable<Map<String, ReferralWidgetResult>> onErrorResumeNext = createWidgets().getReferralWidgets().onErrorResumeNext(defaultButtonsIfEmpty());
        final ReferralWidgetMapper referralWidgetMapper = this.referralWidgetMapper;
        Objects.requireNonNull(referralWidgetMapper);
        return onErrorResumeNext.map(new Function() { // from class: id.dana.data.referralwidget.ReferralWidgetEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralWidgetMapper.this.apply((Map) obj);
            }
        });
    }

    private ReferralWidgetEntityData createWidgets() {
        return this.referralWidgetEntityDataFactory.createData2("split");
    }

    private Function<Throwable, ObservableSource<Map<String, ReferralWidgetResult>>> defaultButtonsIfEmpty() {
        return new Function() { // from class: id.dana.data.referralwidget.ReferralWidgetEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralWidgetEntityRepository.this.m1790x85f914a7((Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultButtonsIfEmpty$0$id-dana-data-referralwidget-ReferralWidgetEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1790x85f914a7(Throwable th) throws Exception {
        return createDefaultWidgets().getReferralWidgets();
    }

    private ReferralWidgetEntityData createDefaultWidgets() {
        return this.referralWidgetEntityDataFactory.createData2("local");
    }
}
