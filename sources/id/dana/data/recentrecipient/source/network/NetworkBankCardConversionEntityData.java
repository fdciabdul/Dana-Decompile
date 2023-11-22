package id.dana.data.recentrecipient.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.recentrecipient.mapper.BankCardConversionMapper;
import id.dana.data.recentrecipient.model.BankCardConversionRequest;
import id.dana.data.recentrecipient.model.BankCardConversionResult;
import id.dana.data.recentrecipient.source.BankCardConversionEntityData;
import id.dana.data.security.SecureString;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.network.base.ExceptionParserAphome;
import id.dana.network.base.ResultResponse;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B9\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/recentrecipient/source/network/NetworkBankCardConversionEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/recentrecipient/source/network/ConvertCardIndexNoSecureApi;", "Lid/dana/data/recentrecipient/source/BankCardConversionEntityData;", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "recentRecipient", "", "publicKey", "", "encryptCardEnabled", "Lio/reactivex/Observable;", "Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "convertCardIndexNo", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/recentrecipient/mapper/BankCardConversionMapper;", "bankCardConversionMapper", "Lid/dana/data/recentrecipient/mapper/BankCardConversionMapper;", "convertCardIndexNoSecureApi", "Lid/dana/data/recentrecipient/source/network/ConvertCardIndexNoSecureApi;", "Landroid/content/Context;", "appContext", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/data/recentrecipient/mapper/BankCardConversionMapper;Lid/dana/data/recentrecipient/source/network/ConvertCardIndexNoSecureApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkBankCardConversionEntityData extends SecureBaseNetwork<ConvertCardIndexNoSecureApi> implements BankCardConversionEntityData {
    private final BankCardConversionMapper bankCardConversionMapper;
    private final ConvertCardIndexNoSecureApi convertCardIndexNoSecureApi;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<ConvertCardIndexNoSecureApi> getFacadeClass() {
        return ConvertCardIndexNoSecureApi.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkBankCardConversionEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, BankCardConversionMapper bankCardConversionMapper, ConvertCardIndexNoSecureApi convertCardIndexNoSecureApi) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(bankCardConversionMapper, "");
        Intrinsics.checkNotNullParameter(convertCardIndexNoSecureApi, "");
        this.bankCardConversionMapper = bankCardConversionMapper;
        this.convertCardIndexNoSecureApi = convertCardIndexNoSecureApi;
    }

    @Override // id.dana.data.recentrecipient.source.BankCardConversionEntityData
    public final Observable<BankCardConversionResult> convertCardIndexNo(RecentRecipient recentRecipient, String publicKey, boolean encryptCardEnabled) {
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        Intrinsics.checkNotNullParameter(publicKey, "");
        BankCardConversionRequest transform = this.bankCardConversionMapper.transform(recentRecipient, publicKey, encryptCardEnabled);
        transform.envInfo = generateMobileEnvInfo();
        SecureString authRequestContext = CookieUtil.getAuthRequestContext();
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        Observable<BankCardConversionResult> flatMap = this.convertCardIndexNoSecureApi.convertCardIndexNo(authRequestContext.toString(), transform).map(new Function() { // from class: id.dana.data.recentrecipient.source.network.NetworkBankCardConversionEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BankCardConversionResult m1749convertCardIndexNo$lambda0;
                m1749convertCardIndexNo$lambda0 = NetworkBankCardConversionEntityData.m1749convertCardIndexNo$lambda0((ResultResponse) obj);
                return m1749convertCardIndexNo$lambda0;
            }
        }).flatMap(new ExceptionParserAphome());
        authRequestContext.clear();
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: convertCardIndexNo$lambda-0  reason: not valid java name */
    public static final BankCardConversionResult m1749convertCardIndexNo$lambda0(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (BankCardConversionResult) resultResponse.getResult();
    }
}
