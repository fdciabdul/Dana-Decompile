package id.dana.data.playstorereview.repository;

import com.alibaba.fastjson.JSONObject;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.PlayStoreReviewConfig;
import id.dana.data.playstorereview.PlayStoreReviewEntityData;
import id.dana.data.playstorereview.mapper.PlayStoreReviewEntityMapper;
import id.dana.data.playstorereview.model.PlayStoreReviewEntity;
import id.dana.data.playstorereview.repository.source.PlayStoreReviewDataFactory;
import id.dana.domain.playstorereview.PlayStoreReviewActionKey;
import id.dana.domain.playstorereview.model.AppReviewInfo;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PlayStoreReviewEntityRepository implements PlayStoreReviewRepository {
    private static final long SIXTY_ONE_DAY_IN_MILLIS = 5270400000L;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final PlayStoreReviewDataFactory playStoreReviewDataFactory;
    private final PlayStoreReviewEntityMapper playStoreReviewEntityMapper;

    @Inject
    public PlayStoreReviewEntityRepository(PlayStoreReviewDataFactory playStoreReviewDataFactory, ConfigEntityDataFactory configEntityDataFactory, PlayStoreReviewEntityMapper playStoreReviewEntityMapper) {
        this.playStoreReviewDataFactory = playStoreReviewDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
        this.playStoreReviewEntityMapper = playStoreReviewEntityMapper;
    }

    public static long getDifferenceDays(long j, long j2) {
        return TimeUnit.DAYS.convert(j - j2, TimeUnit.MILLISECONDS);
    }

    @Override // id.dana.domain.playstorereview.repository.PlayStoreReviewRepository
    public Observable<AppReviewInfo> isNeedToShowPlayStoreReview() {
        return createData().getTransactionSuccessCount().flatMap(new Function() { // from class: id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PlayStoreReviewEntityRepository.this.m1582xbf3c9487((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isNeedToShowPlayStoreReview$0$id-dana-data-playstorereview-repository-PlayStoreReviewEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1582xbf3c9487(Integer num) throws Exception {
        return onGotTransactionSuccessCount(num.intValue() >= 0 ? 1 + num.intValue() : 1);
    }

    @Override // id.dana.domain.playstorereview.repository.PlayStoreReviewRepository
    public Observable<Boolean> saveLastPlayStoreReviewShow(String str, long j, long j2) {
        return createData().saveLastPlayStoreReviewShow(str, j, j2);
    }

    private PlayStoreReviewEntityData createData() {
        return this.playStoreReviewDataFactory.createData2("local");
    }

    private Observable<AppReviewInfo> onGotTransactionSuccessCount(final int i) {
        return createData().saveSuccessTransaction(i).flatMap(new Function() { // from class: id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PlayStoreReviewEntityRepository.this.m1584xe2219272(i, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onGotTransactionSuccessCount$1$id-dana-data-playstorereview-repository-PlayStoreReviewEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1584xe2219272(int i, Boolean bool) throws Exception {
        return onSavedTransactionSuccessCount(i);
    }

    private Observable<AppReviewInfo> onSavedTransactionSuccessCount(int i) {
        if (i > 1) {
            Observable<JSONObject> playStoreReviewFeature = createSplitDataConfig().getPlayStoreReviewFeature();
            final PlayStoreReviewEntityMapper playStoreReviewEntityMapper = this.playStoreReviewEntityMapper;
            Objects.requireNonNull(playStoreReviewEntityMapper);
            return playStoreReviewFeature.map(new Function() { // from class: id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PlayStoreReviewEntityMapper.this.apply((JSONObject) obj);
                }
            }).flatMap(new Function() { // from class: id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Observable onGotPlayStoreReviewFeature;
                    onGotPlayStoreReviewFeature = PlayStoreReviewEntityRepository.this.onGotPlayStoreReviewFeature((PlayStoreReviewConfig) obj);
                    return onGotPlayStoreReviewFeature;
                }
            });
        }
        return Observable.just(createDefaultAppReviewInfo());
    }

    private ConfigEntityData createSplitDataConfig() {
        return this.configEntityDataFactory.createData2("split");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<AppReviewInfo> onGotPlayStoreReviewFeature(final PlayStoreReviewConfig playStoreReviewConfig) {
        if (playStoreReviewConfig.isShowReviewEntrance()) {
            return createData().getLastPlayStoreReviewShow().flatMap(new Function() { // from class: id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PlayStoreReviewEntityRepository.this.m1583x303047ba(playStoreReviewConfig, (PlayStoreReviewEntity) obj);
                }
            });
        }
        return Observable.just(createDefaultAppReviewInfo());
    }

    private AppReviewInfo createDefaultAppReviewInfo() {
        return new AppReviewInfo(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onGetLastPlayStoreReviewShow  reason: merged with bridge method [inline-methods] */
    public Observable<AppReviewInfo> m1583x303047ba(PlayStoreReviewEntity playStoreReviewEntity, PlayStoreReviewConfig playStoreReviewConfig) {
        boolean z;
        if (playStoreReviewEntity == null || playStoreReviewEntity.getTriggerTime() == null) {
            z = true;
        } else {
            long time = new Date().getTime() - SIXTY_ONE_DAY_IN_MILLIS;
            try {
                time = Long.parseLong(playStoreReviewEntity.getActionTime());
            } catch (Exception unused) {
            }
            long differenceDays = getDifferenceDays(new Date().getTime(), time);
            if (PlayStoreReviewActionKey.OPEN.equals(playStoreReviewEntity.getAction())) {
                z = isExpire(differenceDays, playStoreReviewConfig.getOptionRateCountdown()).booleanValue();
            } else {
                z = isExpire(differenceDays, playStoreReviewConfig.getOptionSkipCountdown()).booleanValue();
            }
        }
        return Observable.just(new AppReviewInfo(z, playStoreReviewConfig.isShowInAppReview()));
    }

    private Boolean isExpire(long j, int i) {
        return Boolean.valueOf(j > ((long) i));
    }
}
