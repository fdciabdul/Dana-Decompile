package com.alipay.mobile.rome.syncsdk.msg;

import android.content.Context;
import com.alipay.mobile.rome.syncsdk.util.c;
import com.alipay.mobile.rome.syncsdk.util.g;
import id.dana.data.here.HereOauthManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class b extends a {
    private static final String b = "b";

    public b(Context context) {
        super(context);
    }

    @Override // com.alipay.mobile.rome.syncsdk.msg.a
    public final void a(String str) {
        this.f7217a = str;
    }

    private String[] b() {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(this.f7217a);
        String obj = sb.toString();
        String str = b;
        StringBuilder sb2 = new StringBuilder("getMsgList() perMsgName=");
        sb2.append(obj);
        c.a(str, sb2.toString());
        File file = new File(obj);
        String[] strArr = null;
        if (file.exists() && file.length() > 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(bArr, HereOauthManager.ENC);
                StringBuilder sb3 = new StringBuilder("getMsgList() listMsgId:");
                sb3.append(str2);
                c.a(str, sb3.toString());
                if (str2.trim().length() > 0) {
                    strArr = g.a(str2);
                    Arrays.sort(strArr);
                }
                fileInputStream.close();
            } catch (Exception e) {
                String str3 = b;
                StringBuilder sb4 = new StringBuilder("getMsgList() perMsgName isn't find! e=");
                sb4.append(e);
                c.d(str3, sb4.toString());
            }
        } else {
            c.a(str, "getMsgList() perMsgName isn't find!");
        }
        return strArr;
    }

    @Override // com.alipay.mobile.rome.syncsdk.msg.a
    public final boolean a(MsgInfo msgInfo) {
        String str = b;
        StringBuilder sb = new StringBuilder("isContainMsg() newPerMsgId=");
        sb.append(msgInfo.getPerMsgId());
        c.a(str, sb.toString());
        String[] b2 = b();
        if (b2 != null) {
            return g.a(b2, msgInfo.getPerMsgId());
        }
        return false;
    }

    private String[] b(String str) {
        String[] b2 = b();
        if (b2 == null || b2.length <= 0) {
            b2 = new String[]{str};
        } else if (b2.length >= 50) {
            b2[0] = str;
        } else {
            if (b2 == null) {
                b2 = new String[0];
            }
            int i = str == null ? 0 : 1;
            int length = b2.length;
            String[] strArr = new String[length + i];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = b2[i2];
            }
            if (i == 1) {
                strArr[length] = str;
            }
            b2 = strArr;
        }
        String str2 = b;
        StringBuilder sb = new StringBuilder("updatePerMsgList() perMsgId=");
        sb.append(str);
        c.a(str2, sb.toString());
        return b2;
    }

    @Override // com.alipay.mobile.rome.syncsdk.msg.a
    public final void b(MsgInfo msgInfo) {
        String perMsgId = msgInfo.getPerMsgId();
        String str = b;
        StringBuilder sb = new StringBuilder("saveMsgRecord() perMsgId=");
        sb.append(perMsgId);
        c.a(str, sb.toString());
        if (perMsgId != null && perMsgId.length() > 0) {
            String a2 = g.a(b(perMsgId));
            StringBuilder sb2 = new StringBuilder("saveMsgRecord() listMsgId:");
            sb2.append(a2);
            c.a(str, sb2.toString());
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a());
                sb3.append(this.f7217a);
                File file = new File(sb3.toString());
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(a2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            } catch (Exception unused) {
                c.a(b, "saveMsgRecord() encounter exception!");
                return;
            }
        }
        c.c(str, "saveMsgRecord() perMsgId is invalid!");
    }
}
