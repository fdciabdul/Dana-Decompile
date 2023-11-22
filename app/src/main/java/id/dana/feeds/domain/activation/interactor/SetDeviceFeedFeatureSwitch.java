package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/SetDeviceFeedFeatureSwitch;", "Lid/dana/domain/social/core/SingleUseCase;", "", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "p0", "p1", "p2", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SetDeviceFeedFeatureSwitch extends SingleUseCase<Boolean, Boolean> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedInitRepository getAuthRequestContext;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        this.getAuthRequestContext.PlaceComponentResult(booleanValue);
        return new Result.Success(Boxing.boxBoolean(booleanValue));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SetDeviceFeedFeatureSwitch(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, FeedInitRepository feedInitRepository) {
        super(coroutineDispatcher, coroutineDispatcher2);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.getAuthRequestContext = feedInitRepository;
    }
}
