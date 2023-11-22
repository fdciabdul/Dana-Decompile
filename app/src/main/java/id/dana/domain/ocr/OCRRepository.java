package id.dana.domain.ocr;

import android.graphics.Bitmap;
import id.dana.domain.ocr.model.ReceiptInfoModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/ocr/OCRRepository;", "", "", "sourceOcr", "rules", "", "merchantNameAlias", "Landroid/graphics/Bitmap;", "image", "Lio/reactivex/Observable;", "Lid/dana/domain/ocr/model/ReceiptInfoModel;", "processReceiptOcr", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroid/graphics/Bitmap;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface OCRRepository {
    Observable<ReceiptInfoModel> processReceiptOcr(String sourceOcr, String rules, List<String> merchantNameAlias, Bitmap image);
}
