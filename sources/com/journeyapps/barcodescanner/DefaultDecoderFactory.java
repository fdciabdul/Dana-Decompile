package com.journeyapps.barcodescanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultDecoderFactory implements DecoderFactory {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private Map<DecodeHintType, ?> PlaceComponentResult;
    private Collection<BarcodeFormat> getAuthRequestContext;

    public DefaultDecoderFactory() {
    }

    public DefaultDecoderFactory(Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, int i) {
        this.getAuthRequestContext = collection;
        this.PlaceComponentResult = map;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = i;
    }

    @Override // com.journeyapps.barcodescanner.DecoderFactory
    public final Decoder MyBillsEntityDataFactory(Map<DecodeHintType, ?> map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map<DecodeHintType, ?> map2 = this.PlaceComponentResult;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        if (this.getAuthRequestContext != null) {
            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) this.getAuthRequestContext);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(enumMap);
        int i = this.MyBillsEntityDataFactory;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return new MixedDecoder(multiFormatReader);
                }
                return new Decoder(multiFormatReader);
            }
            return new InvertedDecoder(multiFormatReader);
        }
        return new Decoder(multiFormatReader);
    }
}
