package id.dana.data.qrbarcode.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.model.DefaultInfoResult;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData;
import id.dana.data.qrbarcode.repository.source.network.request.DecodeQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.PreCreateOrderEntityRequest;
import id.dana.data.qrbarcode.repository.source.network.request.SplitBillPayerEntity;
import id.dana.data.qrbarcode.repository.source.network.request.SplitBillQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.TransferBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.request.TransferBankGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.TransferGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.request.UserBankGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.GenerateQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.SplitBillQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.UserBankQrResult;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J5\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\t2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J1\u0010/\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\t2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/NetworkQrBarcodeEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/qrbarcode/repository/source/network/QrFacade;", "Lid/dana/data/qrbarcode/repository/source/QrBarcodeEntityData;", "", ZdocRecordService.SCAN_RESULT, "scene", "", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "Lio/reactivex/Observable;", "Lid/dana/data/qrbarcode/repository/source/network/result/DecodedQrResult;", BranchLinkConstant.PathTarget.DECODE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/qrbarcode/repository/source/network/request/PreCreateOrderEntityRequest;", "preCreateOrderEntityRequest", "Lid/dana/data/model/DefaultInfoResult;", "preCreateCashierOrder", "(Lid/dana/data/qrbarcode/repository/source/network/request/PreCreateOrderEntityRequest;)Lio/reactivex/Observable;", "", "Lid/dana/data/qrbarcode/repository/source/network/request/SplitBillPayerEntity;", "payers", DecodedScanBizInfoKey.COMMENT, "Lid/dana/data/qrbarcode/repository/source/network/result/SplitBillQrResult;", "requestSplitBillCode", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/qrbarcode/repository/source/network/request/TransferBankGenerateQrEntity;", "transferBankGenerateQrEntity", "Lid/dana/data/qrbarcode/repository/source/network/result/UserBankQrResult;", "requestTransferBankCode", "(Lid/dana/data/qrbarcode/repository/source/network/request/TransferBankGenerateQrEntity;)Lio/reactivex/Observable;", "Lid/dana/data/qrbarcode/repository/source/network/request/TransferGenerateQrRequest;", "transferGenerateQrRequest", "Lid/dana/data/qrbarcode/repository/source/network/result/GenerateQrResult;", "requestTransferCode", "(Lid/dana/data/qrbarcode/repository/source/network/request/TransferGenerateQrRequest;)Lio/reactivex/Observable;", "Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity;", "userBankGenerateQrEntity", "userBankCode", "(Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity;)Lio/reactivex/Observable;", "", "qris", "qrisBizType", "", "qrCount", "userCode", "(ZLjava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkQrBarcodeEntityData extends SecureBaseNetwork<QrFacade> implements QrBarcodeEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<QrFacade> getFacadeClass() {
        return QrFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkQrBarcodeEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<DecodedQrResult> decode(final String str, final String str2, Long l) {
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                DecodedQrResult m1699decode$lambda1;
                m1699decode$lambda1 = NetworkQrBarcodeEntityData.m1699decode$lambda1(NetworkQrBarcodeEntityData.this, str, str2, (QrFacade) obj);
                return m1699decode$lambda1;
            }
        }, new QrBarcodeExceptionParser()).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1700decode$lambda2;
                m1700decode$lambda2 = NetworkQrBarcodeEntityData.m1700decode$lambda2((Throwable) obj);
                return m1700decode$lambda2;
            }
        });
        if (l != null) {
            return onErrorResumeNext.timeout(l.longValue(), TimeUnit.SECONDS);
        }
        return null;
    }

    /* renamed from: decode$lambda-1 */
    public static final DecodedQrResult m1699decode$lambda1(NetworkQrBarcodeEntityData networkQrBarcodeEntityData, String str, String str2, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        Intrinsics.checkNotNullParameter(qrFacade, "");
        DecodeQrRequest decodeQrRequest = new DecodeQrRequest();
        decodeQrRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        decodeQrRequest.qrCode = str;
        if (str2 == null) {
            str2 = "";
        }
        decodeQrRequest.scene = str2;
        return qrFacade.decode(decodeQrRequest);
    }

    /* renamed from: decode$lambda-2 */
    public static final ObservableSource m1700decode$lambda2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<UserBankQrResult> userBankCode(final UserBankGenerateQrEntity userBankGenerateQrEntity) {
        Intrinsics.checkNotNullParameter(userBankGenerateQrEntity, "");
        Observable<UserBankQrResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda8
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserBankQrResult m1709userBankCode$lambda6;
                m1709userBankCode$lambda6 = NetworkQrBarcodeEntityData.m1709userBankCode$lambda6(UserBankGenerateQrEntity.this, this, (QrFacade) obj);
                return m1709userBankCode$lambda6;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1710userBankCode$lambda7;
                m1710userBankCode$lambda7 = NetworkQrBarcodeEntityData.m1710userBankCode$lambda7((Throwable) obj);
                return m1710userBankCode$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: userBankCode$lambda-6 */
    public static final UserBankQrResult m1709userBankCode$lambda6(UserBankGenerateQrEntity userBankGenerateQrEntity, NetworkQrBarcodeEntityData networkQrBarcodeEntityData, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(userBankGenerateQrEntity, "");
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        UserBankGenerateQrRequest userBankGenerateQrRequest = new UserBankGenerateQrRequest(userBankGenerateQrEntity);
        userBankGenerateQrRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        return qrFacade.getUserBankQr(userBankGenerateQrRequest);
    }

    /* renamed from: userBankCode$lambda-7 */
    public static final ObservableSource m1710userBankCode$lambda7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<GenerateQrResult> userCode(final boolean qris, final String qrisBizType, final int qrCount) {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda12
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GenerateQrResult m1712userCode$lambda9;
                m1712userCode$lambda9 = NetworkQrBarcodeEntityData.m1712userCode$lambda9(qris, qrisBizType, qrCount, this, (QrFacade) obj);
                return m1712userCode$lambda9;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1711userCode$lambda10;
                m1711userCode$lambda10 = NetworkQrBarcodeEntityData.m1711userCode$lambda10((Throwable) obj);
                return m1711userCode$lambda10;
            }
        });
    }

    /* renamed from: userCode$lambda-9 */
    public static final GenerateQrResult m1712userCode$lambda9(boolean z, String str, int i, NetworkQrBarcodeEntityData networkQrBarcodeEntityData, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        UserGenerateQrRequest userGenerateQrRequest = new UserGenerateQrRequest(z, str, Integer.valueOf(i));
        userGenerateQrRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        return qrFacade.getUserQr(userGenerateQrRequest);
    }

    /* renamed from: userCode$lambda-10 */
    public static final ObservableSource m1711userCode$lambda10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<GenerateQrResult> requestTransferCode(final TransferGenerateQrRequest transferGenerateQrRequest) {
        Intrinsics.checkNotNullParameter(transferGenerateQrRequest, "");
        Observable<GenerateQrResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GenerateQrResult m1707requestTransferCode$lambda12;
                m1707requestTransferCode$lambda12 = NetworkQrBarcodeEntityData.m1707requestTransferCode$lambda12(TransferGenerateQrRequest.this, this, (QrFacade) obj);
                return m1707requestTransferCode$lambda12;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1708requestTransferCode$lambda13;
                m1708requestTransferCode$lambda13 = NetworkQrBarcodeEntityData.m1708requestTransferCode$lambda13((Throwable) obj);
                return m1708requestTransferCode$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: requestTransferCode$lambda-12 */
    public static final GenerateQrResult m1707requestTransferCode$lambda12(TransferGenerateQrRequest transferGenerateQrRequest, NetworkQrBarcodeEntityData networkQrBarcodeEntityData, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(transferGenerateQrRequest, "");
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        transferGenerateQrRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        return qrFacade.getTransferQr(transferGenerateQrRequest);
    }

    /* renamed from: requestTransferCode$lambda-13 */
    public static final ObservableSource m1708requestTransferCode$lambda13(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<UserBankQrResult> requestTransferBankCode(final TransferBankGenerateQrEntity transferBankGenerateQrEntity) {
        Intrinsics.checkNotNullParameter(transferBankGenerateQrEntity, "");
        Observable<UserBankQrResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserBankQrResult m1705requestTransferBankCode$lambda15;
                m1705requestTransferBankCode$lambda15 = NetworkQrBarcodeEntityData.m1705requestTransferBankCode$lambda15(TransferBankGenerateQrEntity.this, this, (QrFacade) obj);
                return m1705requestTransferBankCode$lambda15;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1706requestTransferBankCode$lambda16;
                m1706requestTransferBankCode$lambda16 = NetworkQrBarcodeEntityData.m1706requestTransferBankCode$lambda16((Throwable) obj);
                return m1706requestTransferBankCode$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: requestTransferBankCode$lambda-15 */
    public static final UserBankQrResult m1705requestTransferBankCode$lambda15(TransferBankGenerateQrEntity transferBankGenerateQrEntity, NetworkQrBarcodeEntityData networkQrBarcodeEntityData, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(transferBankGenerateQrEntity, "");
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        TransferBankGenerateQrRequest transferBankGenerateQrRequest = new TransferBankGenerateQrRequest(transferBankGenerateQrEntity);
        transferBankGenerateQrRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        return qrFacade.getTransferBankQr(transferBankGenerateQrRequest);
    }

    /* renamed from: requestTransferBankCode$lambda-16 */
    public static final ObservableSource m1706requestTransferBankCode$lambda16(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<SplitBillQrResult> requestSplitBillCode(final List<? extends SplitBillPayerEntity> payers, final String r4) {
        Intrinsics.checkNotNullParameter(payers, "");
        Intrinsics.checkNotNullParameter(r4, "");
        Observable<SplitBillQrResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SplitBillQrResult m1703requestSplitBillCode$lambda18;
                m1703requestSplitBillCode$lambda18 = NetworkQrBarcodeEntityData.m1703requestSplitBillCode$lambda18(NetworkQrBarcodeEntityData.this, payers, r4, (QrFacade) obj);
                return m1703requestSplitBillCode$lambda18;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1704requestSplitBillCode$lambda19;
                m1704requestSplitBillCode$lambda19 = NetworkQrBarcodeEntityData.m1704requestSplitBillCode$lambda19((Throwable) obj);
                return m1704requestSplitBillCode$lambda19;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: requestSplitBillCode$lambda-18 */
    public static final SplitBillQrResult m1703requestSplitBillCode$lambda18(NetworkQrBarcodeEntityData networkQrBarcodeEntityData, List list, String str, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        SplitBillQrRequest splitBillQrRequest = new SplitBillQrRequest();
        splitBillQrRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        splitBillQrRequest.splitBillPayers = list;
        splitBillQrRequest.comment = str;
        return qrFacade.getSplitBillQr(splitBillQrRequest);
    }

    /* renamed from: requestSplitBillCode$lambda-19 */
    public static final ObservableSource m1704requestSplitBillCode$lambda19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public final Observable<DefaultInfoResult> preCreateCashierOrder(final PreCreateOrderEntityRequest preCreateOrderEntityRequest) {
        Intrinsics.checkNotNullParameter(preCreateOrderEntityRequest, "");
        Observable<DefaultInfoResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda10
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                DefaultInfoResult m1701preCreateCashierOrder$lambda21;
                m1701preCreateCashierOrder$lambda21 = NetworkQrBarcodeEntityData.m1701preCreateCashierOrder$lambda21(PreCreateOrderEntityRequest.this, this, (QrFacade) obj);
                return m1701preCreateCashierOrder$lambda21;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1702preCreateCashierOrder$lambda22;
                m1702preCreateCashierOrder$lambda22 = NetworkQrBarcodeEntityData.m1702preCreateCashierOrder$lambda22((Throwable) obj);
                return m1702preCreateCashierOrder$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* renamed from: preCreateCashierOrder$lambda-21 */
    public static final DefaultInfoResult m1701preCreateCashierOrder$lambda21(PreCreateOrderEntityRequest preCreateOrderEntityRequest, NetworkQrBarcodeEntityData networkQrBarcodeEntityData, QrFacade qrFacade) {
        Intrinsics.checkNotNullParameter(preCreateOrderEntityRequest, "");
        Intrinsics.checkNotNullParameter(networkQrBarcodeEntityData, "");
        preCreateOrderEntityRequest.envInfo = networkQrBarcodeEntityData.generateMobileEnvInfo();
        return qrFacade.preCreateCashierOrder(preCreateOrderEntityRequest);
    }

    /* renamed from: preCreateCashierOrder$lambda-22 */
    public static final ObservableSource m1702preCreateCashierOrder$lambda22(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }
}
