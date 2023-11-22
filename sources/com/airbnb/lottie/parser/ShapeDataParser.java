package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.opendevice.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser KClassImpl$Data$declaredNonStaticMembers$2 = new ShapeDataParser();
    private static final JsonReader.Options MyBillsEntityDataFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("c", SecurityConstants.KEY_VALUE, i.MyBillsEntityDataFactory, "o");

    private ShapeDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ ShapeData KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.getAuthRequestContext();
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(MyBillsEntityDataFactory);
            if (PlaceComponentResult == 0) {
                z = jsonReader.getErrorConfigVersion();
            } else if (PlaceComponentResult == 1) {
                list = JsonUtils.PlaceComponentResult(jsonReader, f);
            } else if (PlaceComponentResult == 2) {
                list2 = JsonUtils.PlaceComponentResult(jsonReader, f);
            } else if (PlaceComponentResult == 3) {
                list3 = JsonUtils.PlaceComponentResult(jsonReader, f);
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        jsonReader.PlaceComponentResult();
        if (jsonReader.GetContactSyncConfig() == JsonReader.Token.END_ARRAY) {
            jsonReader.MyBillsEntityDataFactory();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = list.get(i);
            int i2 = i - 1;
            arrayList.add(new CubicCurveData(MiscUtils.PlaceComponentResult(list.get(i2), list3.get(i2)), MiscUtils.PlaceComponentResult(pointF2, list2.get(i)), pointF2));
        }
        if (z) {
            PointF pointF3 = list.get(0);
            int i3 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.PlaceComponentResult(list.get(i3), list3.get(i3)), MiscUtils.PlaceComponentResult(pointF3, list2.get(0)), pointF3));
        }
        return new ShapeData(pointF, z, arrayList);
    }
}
