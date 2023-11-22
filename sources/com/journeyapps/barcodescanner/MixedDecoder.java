package com.journeyapps.barcodescanner;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.common.HybridBinarizer;

/* loaded from: classes3.dex */
public class MixedDecoder extends Decoder {
    private boolean PlaceComponentResult;

    public MixedDecoder(Reader reader) {
        super(reader);
        this.PlaceComponentResult = true;
    }

    @Override // com.journeyapps.barcodescanner.Decoder
    protected final BinaryBitmap BuiltInFictitiousFunctionClassFactory(LuminanceSource luminanceSource) {
        if (this.PlaceComponentResult) {
            this.PlaceComponentResult = false;
            return new BinaryBitmap(new HybridBinarizer(luminanceSource.invert()));
        }
        this.PlaceComponentResult = true;
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }
}
