package com.xiaomi.push;

import com.xiaomi.push.au;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class bo extends bi {
    @Override // com.xiaomi.push.bi
    public final int PlaceComponentResult() {
        if (KClassImpl$Data$declaredNonStaticMembers$2().length == 0) {
            return 0;
        }
        return super.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.bi
    public final ByteBuffer PlaceComponentResult(ByteBuffer byteBuffer) {
        return KClassImpl$Data$declaredNonStaticMembers$2().length == 0 ? byteBuffer : super.PlaceComponentResult(byteBuffer);
    }

    public bo() {
        getAuthRequestContext("PING", null);
        au.a aVar = this.PlaceComponentResult;
        aVar.PrepareContext = true;
        aVar.initRecordTimeStamp = "0";
        au.a aVar2 = this.PlaceComponentResult;
        aVar2.getAuthRequestContext = true;
        aVar2.PlaceComponentResult = 0;
    }
}
