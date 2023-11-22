package id.dana.scanner.gallery;

import android.graphics.Bitmap;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.InvertedLuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.EnumMap;

/* loaded from: classes5.dex */
public class DecodeImage {
    private Bitmap KClassImpl$Data$declaredNonStaticMembers$2;
    private BitmapSourceData MyBillsEntityDataFactory;
    private MultiFormatReader PlaceComponentResult;

    public DecodeImage(Bitmap bitmap) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bitmap;
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.PlaceComponentResult = multiFormatReader;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.put((EnumMap) DecodeHintType.PURE_BARCODE, (DecodeHintType) Boolean.TRUE);
        multiFormatReader.setHints(enumMap);
        this.MyBillsEntityDataFactory = new BitmapSourceData(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final Result MyBillsEntityDataFactory() throws NotFoundException {
        try {
            return this.PlaceComponentResult.decode(new BinaryBitmap(new HybridBinarizer(this.MyBillsEntityDataFactory.PlaceComponentResult())));
        } catch (Exception unused) {
            return this.PlaceComponentResult.decode(new BinaryBitmap(new HybridBinarizer(new InvertedLuminanceSource(this.MyBillsEntityDataFactory.PlaceComponentResult()))));
        }
    }
}
