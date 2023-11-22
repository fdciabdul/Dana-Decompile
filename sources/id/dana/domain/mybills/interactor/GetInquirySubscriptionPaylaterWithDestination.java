package id.dana.domain.mybills.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.domain.mybills.model.BizProductDestination;
import id.dana.domain.mybills.model.MyBillPaylaterKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0002\u0011\u0012B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/mybills/interactor/GetInquirySubscriptionPaylaterWithDestination;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/mybills/model/BizProductDestination;", "Lid/dana/domain/mybills/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/util/List;)Lio/reactivex/Observable;", "getInquiryPaylater", "(Lid/dana/domain/mybills/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;)Lio/reactivex/Observable;", "getInquirySubscription", "Lid/dana/domain/mybills/MyBillsRepository;", "myBillsRepository", "Lid/dana/domain/mybills/MyBillsRepository;", "<init>", "(Lid/dana/domain/mybills/MyBillsRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetInquirySubscriptionPaylaterWithDestination extends BaseUseCase<List<? extends BizProductDestination>, List<? extends Params>> {
    public static final String GOODSTYPE_PAYLATER = "PAYLATER";
    public static final String TYPE_PAYLATER_UNPAID = "unpaid";
    private final MyBillsRepository myBillsRepository;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* bridge */ /* synthetic */ Observable<List<? extends BizProductDestination>> buildUseCase(List<? extends Params> list) {
        return buildUseCase2((List<Params>) list);
    }

    @Inject
    public GetInquirySubscriptionPaylaterWithDestination(MyBillsRepository myBillsRepository) {
        Intrinsics.checkNotNullParameter(myBillsRepository, "");
        this.myBillsRepository = myBillsRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/domain/mybills/interactor/GetInquirySubscriptionPaylaterWithDestination$Params;", "", "", "bizParam", "Ljava/lang/String;", "getBizParam", "()Ljava/lang/String;", "", "canBeInquiry", "Z", "getCanBeInquiry", "()Z", "goodsId", "getGoodsId", "goodsType", "getGoodsType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String bizParam;
        private final boolean canBeInquiry;
        private final String goodsId;
        private final String goodsType;

        public Params(String str, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.goodsId = str;
            this.bizParam = str2;
            this.goodsType = str3;
            this.canBeInquiry = z;
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getBizParam")
        public final String getBizParam() {
            return this.bizParam;
        }

        @JvmName(name = "getGoodsType")
        public final String getGoodsType() {
            return this.goodsType;
        }

        @JvmName(name = "getCanBeInquiry")
        public final boolean getCanBeInquiry() {
            return this.canBeInquiry;
        }
    }

    /* renamed from: buildUseCase  reason: avoid collision after fix types in other method */
    public final Observable<List<BizProductDestination>> buildUseCase2(List<Params> params) {
        Intrinsics.checkNotNullParameter(params, "");
        ArrayList arrayList = new ArrayList();
        for (Params params2 : params) {
            if (Intrinsics.areEqual(params2.getGoodsType(), GOODSTYPE_PAYLATER) && params2.getCanBeInquiry()) {
                arrayList.add(getInquiryPaylater(params2));
            } else {
                arrayList.add(getInquirySubscription(params2));
            }
        }
        Observable<List<BizProductDestination>> zip = Observable.zip(arrayList, new Function() { // from class: id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2367buildUseCase$lambda2;
                m2367buildUseCase$lambda2 = GetInquirySubscriptionPaylaterWithDestination.m2367buildUseCase$lambda2((Object[]) obj);
                return m2367buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private final Observable<BizProductDestination> getInquirySubscription(final Params params) {
        ?? r2 = 0;
        Observable<BizProductDestination> doOnNext = this.myBillsRepository.getInquirySubscriptionDestination(params.getGoodsId(), params.getBizParam()).onErrorReturnItem(new BizProductDestination(r2, r2, 3, r2)).doOnNext(new Consumer() { // from class: id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetInquirySubscriptionPaylaterWithDestination.m2369getInquirySubscription$lambda3(GetInquirySubscriptionPaylaterWithDestination.Params.this, (BizProductDestination) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getInquirySubscription$lambda-3  reason: not valid java name */
    public static final void m2369getInquirySubscription$lambda3(Params params, BizProductDestination bizProductDestination) {
        Intrinsics.checkNotNullParameter(params, "");
        bizProductDestination.setBillId(params.getBizParam());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private final Observable<BizProductDestination> getInquiryPaylater(Params params) {
        ?? r1 = 0;
        Observable<BizProductDestination> onErrorReturnItem = this.myBillsRepository.getListBillsByBillsIds(TYPE_PAYLATER_UNPAID, CollectionsKt.listOf(params.getBizParam())).map(new Function() { // from class: id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BizProductDestination m2368getInquiryPaylater$lambda4;
                m2368getInquiryPaylater$lambda4 = GetInquirySubscriptionPaylaterWithDestination.m2368getInquiryPaylater$lambda4((List) obj);
                return m2368getInquiryPaylater$lambda4;
            }
        }).onErrorReturnItem(new BizProductDestination(r1, r1, 3, r1));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getInquiryPaylater$lambda-4  reason: not valid java name */
    public static final BizProductDestination m2368getInquiryPaylater$lambda4(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return (BizProductDestination) CollectionsKt.first((List) MyBillPaylaterKt.toListBizProductDestination(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final List m2367buildUseCase$lambda2(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add((BizProductDestination) obj);
        }
        return arrayList;
    }
}
