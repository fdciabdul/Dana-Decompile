package com.alipay.androidinter.app.safepaybase.util;

import com.alipay.androidinter.app.safepaybase.EncryptRandomType;
import com.alipay.androidinter.app.safepaybase.encrypt.Rsa;
import com.alipay.androidinter.app.safepaybase.log.LogTracer;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class EditTextUtil {
    private Map<Integer, String> textMap = new ConcurrentHashMap();

    public void OnTextChanged(int i, String str, int i2, int i3, int i4) {
        String str2 = this.textMap.get(Integer.valueOf(i));
        if (str2 == null) {
            str2 = "";
        }
        try {
            String substring = str2.substring(0, i2);
            String substring2 = str2.substring(i3 + i2, str2.length());
            String substring3 = str.substring(i2, i4 + i2);
            Map<Integer, String> map = this.textMap;
            StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(substring3);
            sb.append(substring2);
            map.put(Integer.valueOf(i), sb.toString());
        } catch (Throwable th) {
            LogTracer.getInstance().printExceptionStackTrace(th);
        }
    }

    public String getText(int i, String str, String str2, EncryptRandomType encryptRandomType) {
        String obj;
        String str3 = this.textMap.get(Integer.valueOf(i));
        if (str3 == null) {
            return "";
        }
        if (encryptRandomType == EncryptRandomType.randombefore) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str3);
            obj = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str2);
            obj = sb2.toString();
        }
        return Rsa.encrypt(obj, str);
    }

    public void clear(int i) {
        this.textMap.remove(Integer.valueOf(i));
    }
}
