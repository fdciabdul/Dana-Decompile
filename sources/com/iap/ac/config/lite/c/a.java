package com.iap.ac.config.lite.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.rpc.model.HttpMethod;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import com.iap.ac.android.common.utils.security.RSAHelper;
import com.iap.ac.android.rpc.http.impl.HttpUrlTransport;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.ConfigGetter;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.endcomputing.evaluator.Evaluator;
import com.iap.ac.config.lite.endcomputing.model.CdnResult;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest;
import com.iap.ac.config.lite.facade.result.AmcsConfigCdnResult;
import com.iap.ac.config.lite.utils.AesUtils;
import com.iap.ac.config.lite.utils.RsaUtils;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class a extends b {
    private Context c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ConfigCenterContext configCenterContext) {
        super(configCenterContext);
        this.c = configCenterContext.getContext();
    }

    private String a(HttpResponse httpResponse) throws Exception {
        String str;
        CdnResult cdnResult = (CdnResult) JsonUtils.fromJson(new String(httpResponse.data), CdnResult.class);
        if (TextUtils.isEmpty(cdnResult.sk)) {
            return cdnResult.data;
        }
        try {
            str = RsaUtils.decrypt(cdnResult.sk, b(new String(Base64.decode("w4XDgcOBw4vDrMO/w4HDisOJw4zDicOGw4rDr8Ojw7nDoMOjw6HDj8Kxw7/CuMOKw4nDmcONw47D\nicOJw5vDi8OJw6XDjcO/w6/Dr8OCw6zDicOvw43DicOJw6fDj8OKw4nDgcOpw4rCusK5w5DDo8OS\nw47Dj8K6wr7DscORw43Di8Oyw6vDksK/wrDDi8Ofwr7DsMO7wrHDhsOrw7nDj8Olwr7DnsOsw6/D\nucOwwrjDvcOcw4/DmcK4w5HDrMOlw53Dp8O+w4fDjMOOwrHDvcOnwqPCvsOAwrDDhcOEwr3Dm8O4\nw6DDjcO9w53CsMOAwrzDhMONw5rDoMOMw5nDq8OBwrnCvsKxw4fDssOfw6bDrsOYw63Cu8OvwrvD\npcO8w7DDjcKxw5/DrcOqw73CusOqw7vCp8Kwwr/DqcOiw6/DicOdw4HDmMOjwr/Cu8OJw63DncOb\nw7vDv8O9w7nCvcKww6PDnsOpw4zDssOlw7nDhMK7w6zDusKnw7vCv8Kjw7HDisKnwrvDoMOMw7HD\nvcOBw7rDncK4wqPDjMKnw4/CuMOFw5/DhsOBw63Du8OGwr7DucOyw57DicOvw4XDisOJw4nDjcOL\nw6/DkcOKw6LDpMO/w7jDqsOdw6LDvcOjwrHDmsOpw73Do8Oww67DucO9w47CucK7wr/CuMORw7vD\nqcOHw6bDgMOKw6TDvMKnwrrDmMOiw4zDssK/w6HCp8OCw6PDqcKxw5rDrMOlw6/Dr8Ouw4bDmMOa\nw5LDisOMw4XDgcO+w6bDjcOFw57Dn8Orw4PDvsK4w4rDisOdw7zDoMOSw6nDuMOEw7jDsMOaw7rD\nnMODw43DusOkw4nDhcOJw53DpcKnw4TDnMOCw6DDpcOSw6XDuMO8w7LDnMOhw4DCuMOtw73DjMOB\nwrHCvcOLw5HDnMO8wrHDucK5w53DjcOyw5HDkMK5w4XCvMOFw5zDgMOCwr3DjsONw4PDqcObw5zD\nhcO/w47Dh8OOw4vDscOKwrHDisOPw6/CuMO+wrzDhMK8w7rDn8Kjw67Dh8K/w6TDkMKwwrHDisK5\nw4bDjcOZw4LDisOJw5jDmcODwrrDksO8w4nDisOQw4DDmMOew5jDksObwrrCsMOQw5vDksOsw4LD\njcOYw5HDuMOJw4PDr8OxwrjDucOMw6DDmsOHw6/DisOxw6TDgMODwr3DgMOBw7vDv8Kww5/DssOL\nw5DDncK/w7zDj8Osw6XDksOAw4zDjcOSw7rDjcOMw7rDisOyw4XCucOvw4HCp8Orw7DDmsO4w4zC\nuMK4wr3Cu8Obw53CsMOLw5nDmcOLw4bDj8OZwrjDgMKxw4nDncOgwqPDgsOCw6XDv8O7wr/DocOe\nw4fDo8O+w4fCuMO/w4LDvcK/wrDDh8Olw4vDh8OKw4zDj8Osw47DgcOdw6DDmcOfw6zDrcOawrjD\nvcO9wrnDssOCw5rDkMOxw6bDuMK5w4HDusO/w5jDnsOkw7HCu8O6w5HDgcO5w6zDm8ONwrjDu8Ow\nw4TCu8OYw6zDq8K4w4XCvcOpw6rDicOjw43DicK6w6bCvcO7w5DDqcOsw7/Dh8OAw6TDq8O4w4zC\nusOMw4TDsMORwrjDvcK9w43DjsOfw4vDkcOhw67CsMOfw77DksO8w7HDscOgw5DDv8OZw6TDhMOS\nw5jDqcKnwqPDoMK9wr/DgcOGw5nDgcOMw67DscOJw5LDoMObwrjDm8Okw4vDj8O4w6PDv8Kjw4rC\no8Knw6PCvsK6wrrDrMONw6bCo8O+w5vDuMK6w5nDgsOJw5DDp8OFw6fDh8Olw7nDkMOZw5LDjcOp\nw7jCo8OMw5DCvsOqwrrDhcK4w5nDpMKww5jDp8Oyw5DDmsO6w5rDq8OPwqPDkcO9w4vDuMK5w6bD\nusOvw4TDv8OCw6/DusOGw77DvcOCw4rDrsK+w6LDvcOqw4vDkcOYw4PDgcO6w6TCvMOkw6zDjMKj\nw4PDg8O5wrjDpsK4w6zDh8OLw5DDoMOdw4/DhcK9wqfDv8OCw4rDicOHw6rDncK+w4nDhMOtw7/D\nr8OpwqfCvsKnw7zDhsOOw7jDqsOjw6rDrsObw7jDu8O5w5DDoMOiwrHDj8OHw4/CvMOYw6rDv8Ou\nw7jCscOFw4nDpMK+w53CusOjw6DDrMO7w5nDv8Omw6TDvsOww5DCp8K/w5vDqcOOw5jDvsOOwrDD\nvcOPw4HDusK9w5LCucOhw43DnMOgw7zDqsOuw5HDuMK5w6vDrcOSw4XCtQ==\n".getBytes(), 0))));
        } catch (Exception e) {
            a(ConfigMonitor.Events.CONFIG_DECRYPT_FAIL, KVBuilder.newBuilder().put("type", RSAHelper.DEFAULT_ALGORITHM).put("message", e.getMessage()).build());
            str = null;
        }
        try {
            return AesUtils.decrypt(cdnResult.data, str);
        } catch (Exception e2) {
            a(ConfigMonitor.Events.CONFIG_DECRYPT_FAIL, KVBuilder.newBuilder().put("type", SecureKeyStorageProvider.ALGORITHM).put("message", e2.getMessage()).build());
            return null;
        }
    }

    private String c() {
        JSONObject jSONConfig;
        ConfigGetter sectionConfigGetter = ConfigCenter.getInstance(this.f7627a.getBizCode()).getSectionConfigGetter(AmcsConstants.X_AMCS_SECTION_KEY);
        return (sectionConfigGetter == null || (jSONConfig = sectionConfigGetter.getJSONConfig(AmcsConstants.CDN_END_COMPUTING_KEY)) == null) ? "" : jSONConfig.optString(AmcsConstants.CDN_URL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iap.ac.config.lite.c.b
    public AmcsConfigCdnResult b(String str, JSONObject jSONObject) throws Exception {
        HttpResponse b = b();
        int i = b.statusCode;
        if (i == 200) {
            String a2 = a(b);
            this.f7627a.getConfigStorage().a(a2);
            b(b);
            return new Evaluator(this.f7627a, a2).performCalculate(c(str, jSONObject));
        } else if (i == 304) {
            return new Evaluator(this.f7627a, this.f7627a.getConfigStorage().d()).performCalculate(c(str, jSONObject));
        } else {
            return null;
        }
    }

    public abstract AmcsConfigRpcRequest c(String str, JSONObject jSONObject);

    private HttpResponse b() throws Exception {
        HttpUrlTransport httpUrlTransport = new HttpUrlTransport(false, this.c);
        HttpRequest httpRequest = new HttpRequest(c(), HttpMethod.GET, null);
        httpRequest.addHeader("If-Modified-Since", this.f7627a.getConfigStorage().e());
        return httpUrlTransport.performRequest(httpRequest);
    }

    private void b(HttpResponse httpResponse) {
        List<String> list = httpResponse.headers.get("last-modified");
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f7627a.getConfigStorage().b(list.get(0));
    }

    private String b(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 136);
        }
        return String.valueOf(charArray);
    }
}
