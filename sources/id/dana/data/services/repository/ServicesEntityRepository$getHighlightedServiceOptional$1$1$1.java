package id.dana.data.services.repository;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import io.reactivex.ObservableEmitter;
import j$.util.Optional;
import j$.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lj$/util/Optional;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "optional", "", BridgeDSL.INVOKE, "(Lj$/util/Optional;)V"}, k = 3, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class ServicesEntityRepository$getHighlightedServiceOptional$1$1$1 extends Lambda implements Function1<Optional<ThirdPartyServiceResponse>, Unit> {
    final /* synthetic */ long $$currentTimeMillis;
    final /* synthetic */ ObservableEmitter<Optional<ThirdPartyServiceResponse>> $$emitter;
    final /* synthetic */ ServicesEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServicesEntityRepository$getHighlightedServiceOptional$1$1$1(ObservableEmitter<Optional<ThirdPartyServiceResponse>> observableEmitter, ServicesEntityRepository servicesEntityRepository, long j) {
        super(1);
        this.$$emitter = observableEmitter;
        this.this$0 = servicesEntityRepository;
        this.$$currentTimeMillis = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Optional<ThirdPartyServiceResponse> optional) {
        invoke2(optional);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Optional<ThirdPartyServiceResponse> optional) {
        Intrinsics.checkNotNullParameter(optional, "");
        this.$$emitter.onNext(optional);
        final ServicesEntityRepository servicesEntityRepository = this.this$0;
        final long j = this.$$currentTimeMillis;
        Consumer consumer = new Consumer() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getHighlightedServiceOptional$1$1$1$$ExternalSyntheticLambda0
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                ServicesEntityRepository$getHighlightedServiceOptional$1$1$1.m1999invoke$lambda0(ServicesEntityRepository.this, j, (ThirdPartyServiceResponse) obj);
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer.CC.PlaceComponentResult(this, consumer2);
            }
        };
        Object obj = optional.PlaceComponentResult;
        if (obj != null) {
            consumer.accept(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m1999invoke$lambda0(ServicesEntityRepository servicesEntityRepository, long j, ThirdPartyServiceResponse thirdPartyServiceResponse) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
        servicesEntityRepository.saveServiceHighlighted(new ServiceHighlighted(thirdPartyServiceResponse.getKey(), j, thirdPartyServiceResponse.getIndexOfHighlighted()));
    }
}
