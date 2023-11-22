package id.dana.data.exploredana.repository.source.local;

import id.dana.domain.promotion.CdpContent;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class LocalExploreDanaEntityData implements ExploreDanaEntityData {
    private final ExploreDanaPreferences exploreDanaPreferences;

    public LocalExploreDanaEntityData(ExploreDanaPreferences exploreDanaPreferences) {
        this.exploreDanaPreferences = exploreDanaPreferences;
    }

    @Override // id.dana.data.exploredana.repository.source.local.ExploreDanaEntityData
    public Observable<List<CdpContent>> checkExploreDanaPreferences(final List<CdpContent> list) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.exploredana.repository.source.local.LocalExploreDanaEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalExploreDanaEntityData.this.m1215x8a8c36e0(list);
            }
        });
    }

    /* renamed from: lambda$checkExploreDanaPreferences$0$id-dana-data-exploredana-repository-source-local-LocalExploreDanaEntityData */
    public /* synthetic */ List m1215x8a8c36e0(List list) throws Exception {
        List<CdpContent> checkExploreDanaItem = this.exploreDanaPreferences.checkExploreDanaItem(list);
        if (checkExploreDanaItem != null) {
            return checkExploreDanaItem;
        }
        throw new CallableReturnNullError("LocalExploreDanaEntityData#checkExploreDanaPreferences");
    }

    @Override // id.dana.data.exploredana.repository.source.local.ExploreDanaEntityData
    public Observable<Boolean> setReadDanaPreferences(String str) {
        return Observable.just(this.exploreDanaPreferences.saveExploreDanaItem(str));
    }

    @Override // id.dana.data.exploredana.repository.source.local.ExploreDanaEntityData
    public Observable<Boolean> setDismissAll(final List<String> list) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.exploredana.repository.source.local.LocalExploreDanaEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalExploreDanaEntityData.this.m1216xaf35245d(list);
            }
        });
    }

    /* renamed from: lambda$setDismissAll$1$id-dana-data-exploredana-repository-source-local-LocalExploreDanaEntityData */
    public /* synthetic */ Boolean m1216xaf35245d(List list) throws Exception {
        return this.exploreDanaPreferences.setDismissAll(list);
    }
}
