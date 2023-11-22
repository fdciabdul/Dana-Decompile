package id.dana.data.deeplink.repository.source.branch;

import android.content.Context;
import android.text.TextUtils;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.deeplink.DeepLinkConstant;
import id.dana.data.deeplink.repository.source.GenerateLinkEntityData;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkEntity;
import id.dana.data.util.DeepLinkUniqueCodeGenerator;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.util.LinkProperties;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class BranchGenerateLinkEntityData implements GenerateLinkEntityData {
    private final Context context;

    @Inject
    public BranchGenerateLinkEntityData(Context context) {
        this.context = context;
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<Boolean> saveProfileQrDeepLink(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateReferralDeepLink(String str) {
        if (str == null) {
            return Observable.error(new NoSuchElementException());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DanaUrl.DEEPLINK_URL);
        sb.append(String.format(BranchLinkConstant.PrefixAlias.REFERRAL, str));
        return Observable.just(new DeepLinkEntity(sb.toString()));
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateTransferQrDeepLink(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return Observable.error(new NoSuchElementException());
        }
        return generate(getBranchObjectProperties(String.format("minta/%s", str), str4, str5, BranchLinkConstant.DeepLinkImageUrl.REQUEST_MONEY), str, str2, str3, "minta/%s", true, DeepLinkConstant.Tag.P2P_TRANSFER, "Request Money");
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateProfileQrDeepLink(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return Observable.error(new NoSuchElementException());
        }
        if (z && TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            DeepLinkEntity deepLinkEntity = new DeepLinkEntity();
            deepLinkEntity.setLink(str2);
            return Observable.just(deepLinkEntity);
        }
        return generate(getBranchObjectProperties(String.format(BranchLinkConstant.CanonicalIdStarter.PROFILE, str), str4, str5, BranchLinkConstant.DeepLinkImageUrl.PROFILE_QR), str, str2, str3, BranchLinkConstant.PrefixAlias.QR, false, new String[0]);
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateSplitBillQrDeepLink(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return Observable.error(new NoSuchElementException());
        }
        return generate(getBranchObjectProperties(String.format("patungan/%s", str), str5, str6, BranchLinkConstant.DeepLinkImageUrl.SPLIT_BILL), str2, str3, str4, "patungan/%s", false, DeepLinkConstant.Tag.P2P_TRANSFER, "Split Bill");
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateSplitBillDetailDeepLink(String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.just(new DeepLinkEntity());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DanaUrl.DEEPLINK_URL);
        sb.append(String.format(BranchLinkConstant.PrefixAlias.SPLIT_BILL_DETAIL, str));
        return Observable.just(new DeepLinkEntity(sb.toString()));
    }

    private Observable<DeepLinkEntity> generate(final BranchUniversalObject branchUniversalObject, final String str, final String str2, final String str3, final String str4, final boolean z, final String... strArr) {
        return Observable.defer(new Callable() { // from class: id.dana.data.deeplink.repository.source.branch.BranchGenerateLinkEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BranchGenerateLinkEntityData.this.m1201xd60f2707(branchUniversalObject, str, str4, str2, str3, z, strArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generate$2$id-dana-data-deeplink-repository-source-branch-BranchGenerateLinkEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1201xd60f2707(final BranchUniversalObject branchUniversalObject, final String str, final String str2, final String str3, final String str4, final boolean z, final String[] strArr) throws Exception {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.deeplink.repository.source.branch.BranchGenerateLinkEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                BranchGenerateLinkEntityData.this.m1200xd540a886(branchUniversalObject, str, str2, str3, str4, z, strArr, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generate$1$id-dana-data-deeplink-repository-source-branch-BranchGenerateLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1200xd540a886(BranchUniversalObject branchUniversalObject, final String str, final String str2, String str3, final String str4, final boolean z, String[] strArr, final ObservableEmitter observableEmitter) throws Exception {
        final DeepLinkEntity deepLinkEntity = new DeepLinkEntity();
        Context context = this.context;
        LinkProperties decodeLinkProperties = getDecodeLinkProperties(str, str2, str3, str4, z, strArr);
        branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2(new BranchShortLinkBuilder(context), decodeLinkProperties).getAuthRequestContext(new Branch.BranchLinkCreateListener() { // from class: id.dana.data.deeplink.repository.source.branch.BranchGenerateLinkEntityData$$ExternalSyntheticLambda2
            @Override // io.branch.referral.Branch.BranchLinkCreateListener
            public final void onLinkCreate(String str5, BranchError branchError) {
                BranchGenerateLinkEntityData.this.m1199xd4722a05(deepLinkEntity, str4, observableEmitter, z, str, str2, str5, branchError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generate$0$id-dana-data-deeplink-repository-source-branch-BranchGenerateLinkEntityData  reason: not valid java name */
    public /* synthetic */ void m1199xd4722a05(DeepLinkEntity deepLinkEntity, String str, ObservableEmitter observableEmitter, boolean z, String str2, String str3, String str4, BranchError branchError) {
        if (branchError == null) {
            deepLinkEntity.setLink(str4);
            deepLinkEntity.setReferralCode(str);
            observableEmitter.onNext(deepLinkEntity);
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.DEEPLINK_PROFILE_QR);
            sb.append(getClass().getName());
            sb.append("Success");
            sb.append(deepLinkEntity.getLink());
            DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
        } else if (isAliasExists(branchError, z)) {
            deepLinkEntity.setLink(String.format(DanaUrl.DEEPLINK_URL_WITH_PARAM, getInnerUrlAlias(str2, z, str3, str)));
            deepLinkEntity.setReferralCode(str);
            observableEmitter.onNext(deepLinkEntity);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DanaLogConstants.Prefix.DEEPLINK_PROFILE_QR);
            sb2.append(getClass().getName());
            sb2.append("Error");
            sb2.append(deepLinkEntity.getLink());
            DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb2.toString());
        } else {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.BRANCH_DEEPLINK_GENERATION, DanaLogConstants.ExceptionType.DEEPLINK_BRANCH_FAIL, branchError.BuiltInFictitiousFunctionClassFactory);
            observableEmitter.onError(new Throwable(branchError.BuiltInFictitiousFunctionClassFactory));
        }
    }

    private BranchUniversalObject getBranchObjectProperties(String str, String str2, String str3, String str4) {
        BranchUniversalObject branchUniversalObject = new BranchUniversalObject();
        branchUniversalObject.BuiltInFictitiousFunctionClassFactory = str;
        branchUniversalObject.lookAheadTest = str2;
        branchUniversalObject.getAuthRequestContext = str3;
        StringBuilder sb = new StringBuilder();
        sb.append(DanaUrl.DEEPLINK_IMAGE_PREFIX_URL);
        sb.append(str4);
        branchUniversalObject.PlaceComponentResult = sb.toString();
        branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2 = BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC;
        branchUniversalObject.MyBillsEntityDataFactory = BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC;
        return branchUniversalObject;
    }

    private LinkProperties getDecodeLinkProperties(String str, String str2, String str3, String str4, boolean z, String... strArr) {
        LinkProperties linkProperties = new LinkProperties();
        linkProperties.MyBillsEntityDataFactory = getInnerUrlAlias(str, z, str2, str4);
        linkProperties.PlaceComponentResult.put("path", BranchLinkConstant.PathTarget.DECODE);
        if (!TextUtils.isEmpty(str4)) {
            linkProperties.PlaceComponentResult.put(BranchLinkConstant.PayloadKey.REFERRAL, str4);
        }
        linkProperties.PlaceComponentResult.put(BranchLinkConstant.PayloadKey.FULL_URL, str3);
        if (strArr.length > 0) {
            linkProperties.lookAheadTest.addAll(Arrays.asList(strArr));
        }
        return linkProperties;
    }

    private String getInnerUrlAlias(String str, boolean z, String str2, String str3) {
        return z ? String.format(str2, DeepLinkUniqueCodeGenerator.generateDynamicCode(str)) : String.format(str2, DeepLinkUniqueCodeGenerator.generateStaticCode(str, !TextUtils.isEmpty(str3)));
    }

    private boolean isAliasExists(BranchError branchError, boolean z) {
        return branchError.MyBillsEntityDataFactory == -105 && !z;
    }
}
