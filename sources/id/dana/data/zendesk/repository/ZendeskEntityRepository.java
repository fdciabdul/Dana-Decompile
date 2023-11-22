package id.dana.data.zendesk.repository;

import android.util.Base64;
import id.dana.data.zendesk.mapper.ZendeskEntityRepositoryMapperExtKt;
import id.dana.data.zendesk.repository.source.ZendeskEntityData;
import id.dana.data.zendesk.repository.source.ZendeskEntityDataFactory;
import id.dana.data.zendesk.repository.source.network.response.CreateZendeskTicketResponse;
import id.dana.domain.zendesk.ZendeskRepository;
import id.dana.domain.zendesk.model.ZendeskBasicTicket;
import id.dana.domain.zendesk.model.ZendeskBasicTicketResult;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/zendesk/repository/ZendeskEntityRepository;", "Lid/dana/domain/zendesk/ZendeskRepository;", "Lid/dana/domain/zendesk/model/ZendeskBasicTicket;", "zendeskBasicTicket", "Lio/reactivex/Observable;", "Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult;", "createTicket", "(Lid/dana/domain/zendesk/model/ZendeskBasicTicket;)Lio/reactivex/Observable;", "", "getApiTokenAuthentication", "()Ljava/lang/String;", "Lid/dana/data/zendesk/repository/source/ZendeskEntityData;", "networkZendeskEntityData$delegate", "Lkotlin/Lazy;", "getNetworkZendeskEntityData", "()Lid/dana/data/zendesk/repository/source/ZendeskEntityData;", "networkZendeskEntityData", "Lid/dana/data/zendesk/repository/source/ZendeskEntityDataFactory;", "zendeskEntityDataFactory", "Lid/dana/data/zendesk/repository/source/ZendeskEntityDataFactory;", "<init>", "(Lid/dana/data/zendesk/repository/source/ZendeskEntityDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ZendeskEntityRepository implements ZendeskRepository {
    private static final String API_TOKEN = "OOca07HPtP6KsS9AbY6pBcKeF3CW7u1NYaQSEtT9";
    private static final String ZENDESK_EMAIL_ADDRESS = "testing@dana.id";

    /* renamed from: networkZendeskEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkZendeskEntityData;
    private final ZendeskEntityDataFactory zendeskEntityDataFactory;

    @Inject
    public ZendeskEntityRepository(ZendeskEntityDataFactory zendeskEntityDataFactory) {
        Intrinsics.checkNotNullParameter(zendeskEntityDataFactory, "");
        this.zendeskEntityDataFactory = zendeskEntityDataFactory;
        this.networkZendeskEntityData = LazyKt.lazy(new Function0<ZendeskEntityData>() { // from class: id.dana.data.zendesk.repository.ZendeskEntityRepository$networkZendeskEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZendeskEntityData invoke() {
                ZendeskEntityDataFactory zendeskEntityDataFactory2;
                zendeskEntityDataFactory2 = ZendeskEntityRepository.this.zendeskEntityDataFactory;
                return zendeskEntityDataFactory2.createData2("network");
            }
        });
    }

    @Override // id.dana.domain.zendesk.ZendeskRepository
    public final Observable<ZendeskBasicTicketResult> createTicket(ZendeskBasicTicket zendeskBasicTicket) {
        Observable<ZendeskBasicTicketResult> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(zendeskBasicTicket, "");
        Single<CreateZendeskTicketResponse> createTicket = getNetworkZendeskEntityData().createTicket(getApiTokenAuthentication(), ZendeskEntityRepositoryMapperExtKt.toCreateZendeskTicketRequest(zendeskBasicTicket));
        Function function = new Function() { // from class: id.dana.data.zendesk.repository.ZendeskEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ZendeskBasicTicketResult m2239createTicket$lambda0;
                m2239createTicket$lambda0 = ZendeskEntityRepository.m2239createTicket$lambda0((CreateZendeskTicketResponse) obj);
                return m2239createTicket$lambda0;
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(createTicket, function));
        if (BuiltInFictitiousFunctionClassFactory2 instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) BuiltInFictitiousFunctionClassFactory2).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(BuiltInFictitiousFunctionClassFactory2));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTicket$lambda-0  reason: not valid java name */
    public static final ZendeskBasicTicketResult m2239createTicket$lambda0(CreateZendeskTicketResponse createZendeskTicketResponse) {
        Intrinsics.checkNotNullParameter(createZendeskTicketResponse, "");
        return ZendeskEntityRepositoryMapperExtKt.toZendeskBasicTicketResult(createZendeskTicketResponse);
    }

    private final String getApiTokenAuthentication() {
        byte[] bytes = "testing@dana.id/token:OOca07HPtP6KsS9AbY6pBcKeF3CW7u1NYaQSEtT9".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        String encodeToString = Base64.encodeToString(bytes, 2);
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(encodeToString);
        return sb.toString();
    }

    @JvmName(name = "getNetworkZendeskEntityData")
    private final ZendeskEntityData getNetworkZendeskEntityData() {
        return (ZendeskEntityData) this.networkZendeskEntityData.getValue();
    }
}
