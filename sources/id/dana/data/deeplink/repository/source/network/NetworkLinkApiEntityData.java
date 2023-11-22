package id.dana.data.deeplink.repository.source.network;

import id.dana.data.BuildConfig;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.deeplink.repository.source.LinkApiEntityData;
import id.dana.data.deeplink.repository.source.branch.mapper.BranchIoDeepLinkEntityMapper;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadPropertiesEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/deeplink/repository/source/network/NetworkLinkApiEntityData;", "Lid/dana/data/deeplink/repository/source/LinkApiEntityData;", "Lid/dana/data/config/source/ConfigEntityData;", "createSplitConfigEntity", "()Lid/dana/data/config/source/ConfigEntityData;", "", "url", "Lio/reactivex/Observable;", "Lid/dana/data/deeplink/repository/source/branch/result/DeepLinkPayloadEntity;", "readLink", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/deeplink/repository/source/network/BranchApi;", "branchApi", "Lid/dana/data/deeplink/repository/source/network/BranchApi;", "getBranchApi$annotations", "()V", "Lid/dana/data/deeplink/repository/source/branch/mapper/BranchIoDeepLinkEntityMapper;", "branchIoDeepLinkEntityMapper", "Lid/dana/data/deeplink/repository/source/branch/mapper/BranchIoDeepLinkEntityMapper;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "<init>", "(Lid/dana/data/deeplink/repository/source/network/BranchApi;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/deeplink/repository/source/branch/mapper/BranchIoDeepLinkEntityMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkLinkApiEntityData implements LinkApiEntityData {
    private final BranchApi branchApi;
    private final BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper;
    private final ConfigEntityDataFactory configEntityDataFactory;

    @Deprecated(message = "since we are move using the SDK instead")
    private static /* synthetic */ void getBranchApi$annotations() {
    }

    @Inject
    public NetworkLinkApiEntityData(BranchApi branchApi, ConfigEntityDataFactory configEntityDataFactory, BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper) {
        Intrinsics.checkNotNullParameter(branchApi, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(branchIoDeepLinkEntityMapper, "");
        this.branchApi = branchApi;
        this.configEntityDataFactory = configEntityDataFactory;
        this.branchIoDeepLinkEntityMapper = branchIoDeepLinkEntityMapper;
    }

    @Override // id.dana.data.deeplink.repository.source.LinkApiEntityData
    public final Observable<DeepLinkPayloadEntity> readLink(final String url) {
        Intrinsics.checkNotNullParameter(url, "");
        Observable<DeepLinkPayloadEntity> onErrorResumeNext = createSplitConfigEntity().getDeeplinkFeatureConfigList().flatMap(new Function() { // from class: id.dana.data.deeplink.repository.source.network.NetworkLinkApiEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1204readLink$lambda0;
                m1204readLink$lambda0 = NetworkLinkApiEntityData.m1204readLink$lambda0(NetworkLinkApiEntityData.this, url, (List) obj);
                return m1204readLink$lambda0;
            }
        }).onErrorResumeNext(this.branchApi.getDeepLinkProperties(url, BuildConfig.BRANCH_KEY).map(new Function() { // from class: id.dana.data.deeplink.repository.source.network.NetworkLinkApiEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DeepLinkPayloadEntity m1205readLink$lambda1;
                m1205readLink$lambda1 = NetworkLinkApiEntityData.m1205readLink$lambda1(NetworkLinkApiEntityData.this, (DeepLinkPayloadPropertiesEntity) obj);
                return m1205readLink$lambda1;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: readLink$lambda-0  reason: not valid java name */
    public static final ObservableSource m1204readLink$lambda0(NetworkLinkApiEntityData networkLinkApiEntityData, String str, List list) {
        Intrinsics.checkNotNullParameter(networkLinkApiEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        return networkLinkApiEntityData.createSplitConfigEntity().getDeeplinkFeatureConfigByKeys(list, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: readLink$lambda-1  reason: not valid java name */
    public static final DeepLinkPayloadEntity m1205readLink$lambda1(NetworkLinkApiEntityData networkLinkApiEntityData, DeepLinkPayloadPropertiesEntity deepLinkPayloadPropertiesEntity) {
        Intrinsics.checkNotNullParameter(networkLinkApiEntityData, "");
        Intrinsics.checkNotNullParameter(deepLinkPayloadPropertiesEntity, "");
        return networkLinkApiEntityData.branchIoDeepLinkEntityMapper.apply(new JSONObject(String.valueOf(deepLinkPayloadPropertiesEntity.getData())));
    }

    private final ConfigEntityData createSplitConfigEntity() {
        return this.configEntityDataFactory.createData2("split");
    }
}
