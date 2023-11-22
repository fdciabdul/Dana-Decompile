package com.alipay.iap.android.wallet.acl.base;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Map;
import o.AppCompatEmojiTextHelper;
import o.J;
import o.MyBillsEntityDataFactory;

/* loaded from: classes.dex */
public class BaseResult implements Result {
    private Map<String, String> extendedInfo;
    private boolean hasError;
    private ResultError resultError;

    public final /* synthetic */ void MyBillsEntityDataFactory(Gson gson, JsonReader jsonReader, int i) {
        boolean z = jsonReader.peek() != JsonToken.NULL;
        if (i == 286) {
            if (z) {
                this.extendedInfo = (Map) gson.getAdapter(new MyBillsEntityDataFactory()).read2(jsonReader);
                return;
            }
            this.extendedInfo = null;
            jsonReader.nextNull();
        } else if (i == 359) {
            if (z) {
                this.hasError = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        } else if (i != 527) {
            jsonReader.skipValue();
        } else if (z) {
            this.resultError = (ResultError) gson.getAdapter(ResultError.class).read2(jsonReader);
        } else {
            this.resultError = null;
            jsonReader.nextNull();
        }
    }

    public final /* synthetic */ void PlaceComponentResult(Gson gson, JsonWriter jsonWriter, J j) {
        if (this != this.extendedInfo) {
            j.PlaceComponentResult(jsonWriter, 557);
            MyBillsEntityDataFactory myBillsEntityDataFactory = new MyBillsEntityDataFactory();
            Map<String, String> map = this.extendedInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, myBillsEntityDataFactory, map).write(jsonWriter, map);
        }
        j.PlaceComponentResult(jsonWriter, 34);
        jsonWriter.value(this.hasError);
        if (this != this.resultError) {
            j.PlaceComponentResult(jsonWriter, 567);
            ResultError resultError = this.resultError;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, ResultError.class, resultError).write(jsonWriter, resultError);
        }
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public boolean isHasError() {
        if (this.resultError == null) {
            return this.hasError;
        }
        return true;
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public void setHasError(boolean z) {
        this.hasError = z;
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public ResultError getResultError() {
        return this.resultError;
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public void setResultError(ResultError resultError) {
        this.resultError = resultError;
        setHasError(true);
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public void setHasError(boolean z, String str) {
        this.hasError = z;
        if (z) {
            getExtendedInfo().put("ERROR_CODE", str);
        }
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public Map<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    @Override // com.alipay.iap.android.wallet.acl.base.Result
    public void setExtendedInfo(Map<String, String> map) {
        this.extendedInfo = map;
    }
}
