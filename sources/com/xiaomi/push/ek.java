package com.xiaomi.push;

import com.xiaomi.push.el;
import java.io.ByteArrayOutputStream;

/* loaded from: classes8.dex */
public class ek {
    private final ByteArrayOutputStream BuiltInFictitiousFunctionClassFactory;
    private final ew KClassImpl$Data$declaredNonStaticMembers$2;
    private ep PlaceComponentResult;

    public ek() {
        this(new el.a());
    }

    public ek(er erVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.BuiltInFictitiousFunctionClassFactory = byteArrayOutputStream;
        ew ewVar = new ew(byteArrayOutputStream);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ewVar;
        this.PlaceComponentResult = erVar.a(ewVar);
    }

    public final byte[] KClassImpl$Data$declaredNonStaticMembers$2(ef efVar) {
        this.BuiltInFictitiousFunctionClassFactory.reset();
        efVar.b(this.PlaceComponentResult);
        return this.BuiltInFictitiousFunctionClassFactory.toByteArray();
    }
}
