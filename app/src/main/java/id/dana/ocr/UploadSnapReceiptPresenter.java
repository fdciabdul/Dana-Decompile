package id.dana.ocr;

import android.text.TextUtils;
import id.dana.base.AbstractContractKt;
import id.dana.domain.loyalty.interactor.GetReceiptData;
import id.dana.domain.loyalty.interactor.RemoveReceiptData;
import id.dana.domain.loyalty.interactor.SaveReceiptData;
import id.dana.domain.loyalty.interactor.SubmitSnapReceipt;
import id.dana.domain.loyalty.model.Base64ReceiptLoyalty;
import id.dana.domain.loyalty.model.FileOcrReceiptLoyalty;
import id.dana.domain.loyalty.model.SubmitReceiptResult;
import id.dana.ocr.UploadSnapReceiptContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.model.OCRResultModel;
import id.dana.ocr.model.SubmitReceiptResultModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B1\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001d\u0012\u0006\u0010\b\u001a\u00020\u001a\u0012\u0006\u0010\n\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\u0012\u0012\u0006\u0010 \u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000eJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0010\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0014\u0010\f\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001b\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/ocr/UploadSnapReceiptPresenter;", "Lid/dana/ocr/UploadSnapReceiptContract$Presenter;", "", "onDestroy", "()V", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "p0", "Lid/dana/ocr/model/OCRRequestModel;", "p1", "", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;Lid/dana/ocr/model/OCRRequestModel;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Lid/dana/ocr/model/OCRRequestModel;)V", "Lid/dana/ocr/model/OCRResultModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/ocr/model/OCRRequestModel;Lid/dana/ocr/model/OCRResultModel;)V", "Lid/dana/domain/loyalty/interactor/GetReceiptData;", "Lid/dana/domain/loyalty/interactor/GetReceiptData;", "PlaceComponentResult", "Lid/dana/domain/loyalty/interactor/RemoveReceiptData;", "MyBillsEntityDataFactory", "Lid/dana/domain/loyalty/interactor/RemoveReceiptData;", "Lid/dana/domain/loyalty/interactor/SaveReceiptData;", "Lid/dana/domain/loyalty/interactor/SaveReceiptData;", "Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt;", "getAuthRequestContext", "Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt;", "Lid/dana/ocr/UploadSnapReceiptContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/ocr/UploadSnapReceiptContract$View;", "p4", "<init>", "(Lid/dana/ocr/UploadSnapReceiptContract$View;Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt;Lid/dana/domain/loyalty/interactor/SaveReceiptData;Lid/dana/domain/loyalty/interactor/GetReceiptData;Lid/dana/domain/loyalty/interactor/RemoveReceiptData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UploadSnapReceiptPresenter implements UploadSnapReceiptContract.Presenter {
    private static final String PlaceComponentResult;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetReceiptData PlaceComponentResult;
    private final SaveReceiptData KClassImpl$Data$declaredNonStaticMembers$2;
    private final RemoveReceiptData MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final UploadSnapReceiptContract.View getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SubmitSnapReceipt BuiltInFictitiousFunctionClassFactory;

    @Inject
    public UploadSnapReceiptPresenter(UploadSnapReceiptContract.View view, SubmitSnapReceipt submitSnapReceipt, SaveReceiptData saveReceiptData, GetReceiptData getReceiptData, RemoveReceiptData removeReceiptData) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(submitSnapReceipt, "");
        Intrinsics.checkNotNullParameter(saveReceiptData, "");
        Intrinsics.checkNotNullParameter(getReceiptData, "");
        Intrinsics.checkNotNullParameter(removeReceiptData, "");
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = submitSnapReceipt;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = saveReceiptData;
        this.PlaceComponentResult = getReceiptData;
        this.MyBillsEntityDataFactory = removeReceiptData;
    }

    @Override // id.dana.ocr.UploadSnapReceiptContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final OCRRequestModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.showProgress();
        this.PlaceComponentResult.execute(GetReceiptData.Params.INSTANCE.create(p1.moveToNextValue), new Function1<FileOcrReceiptLoyalty, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$uploadReceipt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
                invoke2(fileOcrReceiptLoyalty);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
                Intrinsics.checkNotNullParameter(fileOcrReceiptLoyalty, "");
                UploadSnapReceiptPresenter.PlaceComponentResult(this, p0, new Base64ReceiptLoyalty.Builder(fileOcrReceiptLoyalty.getOrderId(), fileOcrReceiptLoyalty.getMerchantName(), fileOcrReceiptLoyalty.getOrderAmount(), fileOcrReceiptLoyalty.getTimestamp(), fileOcrReceiptLoyalty.getRawText(), OCRRequestModel.this.getAuthRequestContext, OCRRequestModel.this.moveToNextValue), OCRRequestModel.this, fileOcrReceiptLoyalty.getFilePath());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$uploadReceipt$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                UploadSnapReceiptContract.View view;
                UploadSnapReceiptContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = UploadSnapReceiptPresenter.this.getAuthRequestContext;
                view.MyBillsEntityDataFactory(p0, "012");
                view2 = UploadSnapReceiptPresenter.this.getAuthRequestContext;
                view2.dismissProgress();
            }
        });
    }

    @Override // id.dana.ocr.UploadSnapReceiptContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, OCRRequestModel p1, OCRResultModel p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.getAuthRequestContext.showProgress();
        String PlaceComponentResult2 = BitmapUtil.PlaceComponentResult(p2.KClassImpl$Data$declaredNonStaticMembers$2);
        if (TextUtils.isEmpty(PlaceComponentResult2)) {
            this.getAuthRequestContext.dismissProgress();
            this.getAuthRequestContext.MyBillsEntityDataFactory(p0, "009");
            DanaLog.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "fail convert snap receipt to base 64");
            return;
        }
        Base64ReceiptLoyalty build = new Base64ReceiptLoyalty.Builder(p2.BuiltInFictitiousFunctionClassFactory, p2.PlaceComponentResult, p2.MyBillsEntityDataFactory, p2.NetworkUserEntityData$$ExternalSyntheticLambda0, p2.getErrorConfigVersion, p1.getAuthRequestContext, p1.moveToNextValue).withReceipt(PlaceComponentResult2).build();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(SaveReceiptData.Params.INSTANCE.create(new FileOcrReceiptLoyalty(p2.BuiltInFictitiousFunctionClassFactory, p2.PlaceComponentResult, p2.MyBillsEntityDataFactory, p2.NetworkUserEntityData$$ExternalSyntheticLambda0, p2.getErrorConfigVersion, p1.getAuthRequestContext, p1.moveToNextValue, p2.KClassImpl$Data$declaredNonStaticMembers$2)), new Function1<Boolean, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$saveReceiptData$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$saveReceiptData$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                str = UploadSnapReceiptPresenter.PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append("Error to save receipt data into db because of ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, sb.toString());
            }
        });
        BuiltInFictitiousFunctionClassFactory(build, p1, p0, p2.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private final void BuiltInFictitiousFunctionClassFactory(final Base64ReceiptLoyalty p0, OCRRequestModel p1, final String p2, final String p3) {
        this.getAuthRequestContext.PlaceComponentResult(p2);
        this.BuiltInFictitiousFunctionClassFactory.execute(SubmitSnapReceipt.Params.INSTANCE.create(p0, p1.BuiltInFictitiousFunctionClassFactory), new Function1<SubmitReceiptResult, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$submitting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SubmitReceiptResult submitReceiptResult) {
                invoke2(submitReceiptResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SubmitReceiptResult submitReceiptResult) {
                UploadSnapReceiptContract.View view;
                Intrinsics.checkNotNullParameter(submitReceiptResult, "");
                view = UploadSnapReceiptPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                UploadSnapReceiptPresenter.this.getAuthRequestContext.getAuthRequestContext(p2, new SubmitReceiptResultModel(submitReceiptResult.getId(), submitReceiptResult.getCreatedDate(), submitReceiptResult.getModifiedDate(), submitReceiptResult.getOrderId(), submitReceiptResult.getMerchantId(), submitReceiptResult.getMerchantName(), submitReceiptResult.getLoyaltyMerchantName(), submitReceiptResult.getOriginalMerchantName(), submitReceiptResult.getOrderDate(), submitReceiptResult.getOrderAmount(), submitReceiptResult.getImageAssetUrl(), submitReceiptResult.getUserLoyaltyId(), submitReceiptResult.getReceiptStatus(), submitReceiptResult.getReceiptResultType(), submitReceiptResult.getReceiptApprovalStatus(), submitReceiptResult.getPointGenerated(), submitReceiptResult.getReasonId(), submitReceiptResult.getReasonEn()));
                r3.MyBillsEntityDataFactory.execute(RemoveReceiptData.Params.INSTANCE.create(p0.getUserLoyaltyId()), new Function1<Boolean, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$removeReceiptData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        String str;
                        if (!z) {
                            str = UploadSnapReceiptPresenter.PlaceComponentResult;
                            DanaLog.BuiltInFictitiousFunctionClassFactory(str, "Fail to remove receipt data");
                            return;
                        }
                        UploadSnapReceiptPresenter.this.getAuthRequestContext.MyBillsEntityDataFactory(r2);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$removeReceiptData$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        String str;
                        Intrinsics.checkNotNullParameter(th, "");
                        str = UploadSnapReceiptPresenter.PlaceComponentResult;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error to remove receipt data on db because of ");
                        sb.append(th.getMessage());
                        DanaLog.BuiltInFictitiousFunctionClassFactory(str, sb.toString());
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.ocr.UploadSnapReceiptPresenter$submitting$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                UploadSnapReceiptContract.View view;
                UploadSnapReceiptContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = UploadSnapReceiptPresenter.this.getAuthRequestContext;
                view.MyBillsEntityDataFactory(p2, "011");
                view2 = UploadSnapReceiptPresenter.this.getAuthRequestContext;
                view2.dismissProgress();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    static {
        Intrinsics.checkNotNullExpressionValue("UploadSnapReceiptPresenter", "");
        PlaceComponentResult = "UploadSnapReceiptPresenter";
    }

    public static final /* synthetic */ void PlaceComponentResult(UploadSnapReceiptPresenter uploadSnapReceiptPresenter, String str, Base64ReceiptLoyalty.Builder builder, OCRRequestModel oCRRequestModel, String str2) {
        String PlaceComponentResult2 = BitmapUtil.PlaceComponentResult(str2);
        if (TextUtils.isEmpty(PlaceComponentResult2)) {
            uploadSnapReceiptPresenter.getAuthRequestContext.dismissProgress();
            uploadSnapReceiptPresenter.getAuthRequestContext.MyBillsEntityDataFactory(str, "009");
            DanaLog.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "fail convert snap receipt to base 64");
            return;
        }
        uploadSnapReceiptPresenter.BuiltInFictitiousFunctionClassFactory(builder.withReceipt(PlaceComponentResult2).build(), oCRRequestModel, str, str2);
    }
}
