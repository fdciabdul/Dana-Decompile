package com.xiaomi.push;

import android.text.TextUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.xiaomi.push.au;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public class bi {
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    private static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static String lookAheadTest;
    int BuiltInFictitiousFunctionClassFactory;
    public short MyBillsEntityDataFactory;
    public au.a PlaceComponentResult;
    public String getAuthRequestContext;
    private byte[] scheduleImpl;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(cu.PlaceComponentResult());
        sb.append("-");
        lookAheadTest = sb.toString();
        KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new byte[0];
    }

    public bi() {
        this.MyBillsEntityDataFactory = (short) 2;
        this.scheduleImpl = NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.getAuthRequestContext = null;
        this.PlaceComponentResult = new au.a();
        this.BuiltInFictitiousFunctionClassFactory = 1;
    }

    private bi(au.a aVar, short s, byte[] bArr) {
        this.getAuthRequestContext = null;
        this.PlaceComponentResult = aVar;
        this.MyBillsEntityDataFactory = s;
        this.scheduleImpl = bArr;
        this.BuiltInFictitiousFunctionClassFactory = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bi getAuthRequestContext(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            au.a aVar = new au.a();
            aVar.BuiltInFictitiousFunctionClassFactory(slice.array(), slice.arrayOffset() + 8, s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new bi(aVar, s, bArr);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("read Blob err :");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            throw new IOException("Malformed Input");
        }
    }

    private static String getErrorConfigVersion() {
        String obj;
        synchronized (bi.class) {
            StringBuilder sb = new StringBuilder();
            sb.append(lookAheadTest);
            long j = KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$2 = 1 + j;
            sb.append(Long.toString(j));
            obj = sb.toString();
        }
        return obj;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
    }

    public final byte[] KClassImpl$Data$declaredNonStaticMembers$2() {
        return bj.MyBillsEntityDataFactory(this, this.scheduleImpl);
    }

    public int PlaceComponentResult() {
        return this.PlaceComponentResult.PlaceComponentResult() + 8 + this.scheduleImpl.length;
    }

    public final short getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    @Deprecated
    public static bi BuiltInFictitiousFunctionClassFactory(cj cjVar, String str) {
        int i;
        bi biVar = new bi();
        try {
            i = Integer.parseInt(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Blob parse chid err ");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            i = 1;
        }
        au.a aVar = biVar.PlaceComponentResult;
        aVar.getAuthRequestContext = true;
        aVar.PlaceComponentResult = i;
        String authRequestContext = cjVar.getAuthRequestContext();
        au.a aVar2 = biVar.PlaceComponentResult;
        aVar2.PrepareContext = true;
        aVar2.initRecordTimeStamp = authRequestContext;
        biVar.BuiltInFictitiousFunctionClassFactory(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda8);
        biVar.getAuthRequestContext = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda6;
        biVar.getAuthRequestContext("XMLMSG", null);
        try {
            biVar.BuiltInFictitiousFunctionClassFactory(cjVar.MyBillsEntityDataFactory().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                biVar.MyBillsEntityDataFactory = (short) 3;
            } else {
                biVar.MyBillsEntityDataFactory = (short) 2;
                biVar.getAuthRequestContext("SECMSG", null);
            }
        } catch (UnsupportedEncodingException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Blob setPayload err： ");
            sb2.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
        return biVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer PlaceComponentResult(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(PlaceComponentResult());
        }
        byteBuffer.putShort(this.MyBillsEntityDataFactory);
        au.a aVar = this.PlaceComponentResult;
        if (aVar.NetworkUserEntityData$$ExternalSyntheticLambda1 < 0) {
            aVar.PlaceComponentResult();
        }
        byteBuffer.putShort((short) aVar.NetworkUserEntityData$$ExternalSyntheticLambda1);
        byteBuffer.putInt(this.scheduleImpl.length);
        int position = byteBuffer.position();
        au.a aVar2 = this.PlaceComponentResult;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + position;
        au.a aVar3 = this.PlaceComponentResult;
        if (aVar3.NetworkUserEntityData$$ExternalSyntheticLambda1 < 0) {
            aVar3.PlaceComponentResult();
        }
        try {
            c BuiltInFictitiousFunctionClassFactory = c.BuiltInFictitiousFunctionClassFactory(array, arrayOffset, aVar3.NetworkUserEntityData$$ExternalSyntheticLambda1);
            aVar2.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            au.a aVar4 = this.PlaceComponentResult;
            if (aVar4.NetworkUserEntityData$$ExternalSyntheticLambda1 < 0) {
                aVar4.PlaceComponentResult();
            }
            byteBuffer.position(position + aVar4.NetworkUserEntityData$$ExternalSyntheticLambda1);
            byteBuffer.put(this.scheduleImpl);
            return byteBuffer;
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j, String str, String str2) {
        if (j != 0) {
            au.a aVar = this.PlaceComponentResult;
            aVar.scheduleImpl = true;
            aVar.MyBillsEntityDataFactory = j;
        }
        if (!TextUtils.isEmpty(str)) {
            au.a aVar2 = this.PlaceComponentResult;
            aVar2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            aVar2.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        au.a aVar3 = this.PlaceComponentResult;
        aVar3.GetContactSyncConfig = true;
        aVar3.BuiltInFictitiousFunctionClassFactory = str2;
    }

    public final void getAuthRequestContext(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        au.a aVar = this.PlaceComponentResult;
        aVar.DatabaseTableConfigUtil = true;
        aVar.lookAheadTest = str;
        au.a aVar2 = this.PlaceComponentResult;
        aVar2.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        aVar2.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        au.a aVar3 = this.PlaceComponentResult;
        aVar3.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        aVar3.NetworkUserEntityData$$ExternalSyntheticLambda2 = str2;
    }

    public final void BuiltInFictitiousFunctionClassFactory(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            au.a aVar = this.PlaceComponentResult;
            aVar.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            aVar.getErrorConfigVersion = 1;
            this.scheduleImpl = com.xiaomi.push.service.bh.KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.service.bh.getAuthRequestContext(str, MyBillsEntityDataFactory()), bArr);
            return;
        }
        au.a aVar2 = this.PlaceComponentResult;
        aVar2.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        aVar2.getErrorConfigVersion = 0;
        this.scheduleImpl = bArr;
    }

    public final byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (this.PlaceComponentResult.getErrorConfigVersion == 1) {
            return bj.MyBillsEntityDataFactory(this, com.xiaomi.push.service.bh.KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.service.bh.getAuthRequestContext(str, MyBillsEntityDataFactory()), this.scheduleImpl));
        }
        if (this.PlaceComponentResult.getErrorConfigVersion == 0) {
            return bj.MyBillsEntityDataFactory(this, this.scheduleImpl);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknow cipher = ");
        sb.append(this.PlaceComponentResult.getErrorConfigVersion);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        return bj.MyBillsEntityDataFactory(this, this.scheduleImpl);
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf(AUScreenAdaptTool.PREFIX_ID);
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            au.a aVar = this.PlaceComponentResult;
            aVar.scheduleImpl = true;
            aVar.MyBillsEntityDataFactory = parseLong;
            au.a aVar2 = this.PlaceComponentResult;
            aVar2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            aVar2.KClassImpl$Data$declaredNonStaticMembers$2 = substring;
            au.a aVar3 = this.PlaceComponentResult;
            aVar3.GetContactSyncConfig = true;
            aVar3.BuiltInFictitiousFunctionClassFactory = substring2;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Blob parse user err ");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
    }

    public final String MyBillsEntityDataFactory() {
        String str = this.PlaceComponentResult.initRecordTimeStamp;
        if ("ID_NOT_AVAILABLE".equals(str)) {
            return null;
        }
        if (this.PlaceComponentResult.MyBillsEntityDataFactory()) {
            return str;
        }
        String errorConfigVersion = getErrorConfigVersion();
        au.a aVar = this.PlaceComponentResult;
        aVar.PrepareContext = true;
        aVar.initRecordTimeStamp = errorConfigVersion;
        return errorConfigVersion;
    }

    public final String scheduleImpl() {
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2()) {
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toString(this.PlaceComponentResult.MyBillsEntityDataFactory));
            sb.append(AUScreenAdaptTool.PREFIX_ID);
            sb.append(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("/");
            sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            return sb.toString();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Blob [chid=");
        sb.append(this.PlaceComponentResult.PlaceComponentResult);
        sb.append("; Id=");
        sb.append(com.xiaomi.push.service.aw.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory()));
        sb.append("; cmd=");
        sb.append(this.PlaceComponentResult.lookAheadTest);
        sb.append("; type=");
        sb.append((int) getAuthRequestContext());
        sb.append("; from=");
        sb.append(scheduleImpl());
        sb.append(" ]");
        return sb.toString();
    }
}
