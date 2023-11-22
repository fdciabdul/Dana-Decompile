package id.dana.data.dialogtnc;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.TermsConditionsResult;
import id.dana.data.dialogtnc.mapper.TermsConditionsMapperKt;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.domain.tncsummary.model.TermsConditionsResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class TncEntitySummaryRepository implements TncSummaryRepository {
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

    @Inject
    public TncEntitySummaryRepository(ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.configEntityDataFactory = configEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.tncsummary.TncSummaryRepository
    public Observable<TermsConditionsResponse> getTncSummaryConfigWithSpaceCode() {
        return this.holdLoginV1EntityRepository.authenticatedRequest(getTermsConditionsConfig().map(new Function() { // from class: id.dana.data.dialogtnc.TncEntitySummaryRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TermsConditionsMapperKt.toTermsConditionsResponse((TermsConditionsResult) obj);
            }
        }));
    }

    @Override // id.dana.domain.tncsummary.TncSummaryRepository
    public Observable<Boolean> getFeatureTncSummary() {
        return this.holdLoginV1EntityRepository.authenticatedRequest(getTermsConditionsConfig().map(new Function() { // from class: id.dana.data.dialogtnc.TncEntitySummaryRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((TermsConditionsResult) obj).isEnable());
            }
        }));
    }

    private ConfigEntityData createSplitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private Observable<TermsConditionsResult> getTermsConditionsConfig() {
        return createSplitConfigEntityData().getTermsConditionsConfig();
    }
}
