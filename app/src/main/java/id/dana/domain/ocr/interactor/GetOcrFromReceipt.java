package id.dana.domain.ocr.interactor;

import android.graphics.Bitmap;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.ocr.OCRRepository;
import id.dana.domain.ocr.model.ReceiptInfoModel;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/ocr/interactor/GetOcrFromReceipt;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/ocr/model/ReceiptInfoModel;", "Lid/dana/domain/ocr/interactor/GetOcrFromReceipt$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/ocr/interactor/GetOcrFromReceipt$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/ocr/OCRRepository;", "ocrRepository", "Lid/dana/domain/ocr/OCRRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/ocr/OCRRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetOcrFromReceipt extends UseCase<ReceiptInfoModel, Params> {
    private final OCRRepository ocrRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetOcrFromReceipt(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OCRRepository oCRRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(oCRRepository, "");
        this.ocrRepository = oCRRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<ReceiptInfoModel> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.ocrRepository.processReceiptOcr("FIREBASE_VISION", params.getRules(), params.getMerchantNameAlias(), params.getImage());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/ocr/interactor/GetOcrFromReceipt$Params;", "", "Landroid/graphics/Bitmap;", "image", "Landroid/graphics/Bitmap;", "getImage", "()Landroid/graphics/Bitmap;", "", "", "merchantNameAlias", "Ljava/util/List;", "getMerchantNameAlias", "()Ljava/util/List;", "rules", "Ljava/lang/String;", "getRules", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/Bitmap;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {
        private final Bitmap image;
        private final List<String> merchantNameAlias;
        private final String rules;

        public Params(String str, List<String> list, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(bitmap, "");
            this.rules = str;
            this.merchantNameAlias = list;
            this.image = bitmap;
        }

        @JvmName(name = "getImage")
        public final Bitmap getImage() {
            return this.image;
        }

        @JvmName(name = "getMerchantNameAlias")
        public final List<String> getMerchantNameAlias() {
            return this.merchantNameAlias;
        }

        @JvmName(name = "getRules")
        public final String getRules() {
            return this.rules;
        }
    }
}
