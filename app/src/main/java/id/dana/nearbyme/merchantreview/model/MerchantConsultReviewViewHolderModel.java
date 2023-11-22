package id.dana.nearbyme.merchantreview.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0003\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "p0", "p1", "<init>", "(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantConsultReviewViewHolderModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MerchantConsultReviewModel PlaceComponentResult;

    public MerchantConsultReviewViewHolderModel(MerchantConsultReviewModel merchantConsultReviewModel, int i) {
        this.PlaceComponentResult = merchantConsultReviewModel;
        this.MyBillsEntityDataFactory = i;
    }

    public /* synthetic */ MerchantConsultReviewViewHolderModel(MerchantConsultReviewModel merchantConsultReviewModel, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : merchantConsultReviewModel, i);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004"}, d2 = {"Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel$Companion;", "", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "getAuthRequestContext", "()Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "PlaceComponentResult", "", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel] */
        public static MerchantConsultReviewViewHolderModel MyBillsEntityDataFactory() {
            ?? r1 = 0;
            return new MerchantConsultReviewViewHolderModel(r1, 0, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel] */
        public static MerchantConsultReviewViewHolderModel getAuthRequestContext() {
            int i = 1;
            ?? r2 = 0;
            return new MerchantConsultReviewViewHolderModel(r2, i, i, r2);
        }

        public static List<MerchantConsultReviewViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantConsultReviewModel> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            List<MerchantConsultReviewModel> list = p0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MerchantConsultReviewModel merchantConsultReviewModel : list) {
                Companion companion = MerchantConsultReviewViewHolderModel.INSTANCE;
                arrayList.add(new MerchantConsultReviewViewHolderModel(merchantConsultReviewModel, 2));
            }
            return arrayList;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel] */
        public static MerchantConsultReviewViewHolderModel BuiltInFictitiousFunctionClassFactory() {
            ?? r1 = 0;
            return new MerchantConsultReviewViewHolderModel(r1, 4, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel] */
        public static MerchantConsultReviewViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2() {
            ?? r1 = 0;
            return new MerchantConsultReviewViewHolderModel(r1, 5, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel] */
        public static MerchantConsultReviewViewHolderModel PlaceComponentResult() {
            ?? r1 = 0;
            return new MerchantConsultReviewViewHolderModel(r1, 6, 1, r1);
        }
    }
}
