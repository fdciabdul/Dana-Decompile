package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    protected ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    protected List<ExtraProcessor> extraProcessors;
    protected List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(new JSONLexer(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(new JSONLexer(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c = jSONLexer.ch;
        char c2 = JSONLexer.EOI;
        if (c == '{') {
            int i = jSONLexer.bp + 1;
            jSONLexer.bp = i;
            jSONLexer.ch = i < jSONLexer.len ? jSONLexer.text.charAt(i) : c2;
            jSONLexer.token = 12;
        } else if (jSONLexer.ch == '[') {
            int i2 = jSONLexer.bp + 1;
            jSONLexer.bp = i2;
            jSONLexer.ch = i2 < jSONLexer.len ? jSONLexer.text.charAt(i2) : c2;
            jSONLexer.token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x022f, code lost:
    
        r3.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0236, code lost:
    
        if (r3.token != 13) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0238, code lost:
    
        r3.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x023b, code lost:
    
        r2 = r18.config.getDeserializer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0243, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0245, code lost:
    
        r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2;
        r3 = r2.createInstance(r18, r6);
        r0 = r19.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0257, code lost:
    
        if (r0.hasNext() == false) goto L439;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0259, code lost:
    
        r4 = (java.util.Map.Entry) r0.next();
        r7 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0265, code lost:
    
        if ((r7 instanceof java.lang.String) == false) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0267, code lost:
    
        r7 = r2.getFieldDeserializer((java.lang.String) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x026d, code lost:
    
        if (r7 == null) goto L443;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x026f, code lost:
    
        r7.setValue(r3, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0277, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0278, code lost:
    
        if (r3 != null) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x027c, code lost:
    
        if (r6 != java.lang.Cloneable.class) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x027e, code lost:
    
        r3 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x028a, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r5) == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x028c, code lost:
    
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0291, code lost:
    
        r3 = r6.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0295, code lost:
    
        if (r13 != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0297, code lost:
    
        r18.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0299, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x029a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02a2, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02a3, code lost:
    
        r18.resolveStatus = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02a8, code lost:
    
        if (r18.contex == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02ac, code lost:
    
        if ((r20 instanceof java.lang.Integer) != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02ae, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02b5, code lost:
    
        if (r19.size() <= 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02b7, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r19, (java.lang.Class<java.lang.Object>) r6, r18.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02c0, code lost:
    
        if (r13 != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02c2, code lost:
    
        r18.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02c4, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02c5, code lost:
    
        r0 = r18.config.getDeserializer(r6).deserialze(r18, r6, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02cf, code lost:
    
        if (r13 != false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02d1, code lost:
    
        r18.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02d3, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01fb A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03b3 A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04cd A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04dc A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04e5 A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04e9 A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04ee A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0576 A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x04f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0591 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c0 A[Catch: all -> 0x06b1, TryCatch #0 {all -> 0x06b1, blocks: (B:21:0x0064, B:24:0x006e, B:27:0x0077, B:31:0x008b, B:33:0x0095, B:36:0x009e, B:37:0x00bc, B:95:0x01c0, B:99:0x01d3, B:115:0x01f2, B:118:0x01ff, B:121:0x0206, B:123:0x020e, B:125:0x0221, B:126:0x022f, B:128:0x0238, B:129:0x023b, B:132:0x0245, B:133:0x0253, B:135:0x0259, B:138:0x0267, B:140:0x026f, B:145:0x027e, B:146:0x0284, B:148:0x028c, B:149:0x0291, B:154:0x029b, B:155:0x02a2, B:156:0x02a3, B:160:0x02ae, B:161:0x02b1, B:163:0x02b7, B:167:0x02c5, B:174:0x02db, B:176:0x02e3, B:178:0x02ea, B:180:0x02f9, B:185:0x0305, B:187:0x0309, B:207:0x035a, B:209:0x035e, B:213:0x0368, B:214:0x0380, B:189:0x0310, B:191:0x0318, B:193:0x031c, B:194:0x031f, B:195:0x032b, B:198:0x0334, B:200:0x0338, B:201:0x033b, B:203:0x033f, B:204:0x0342, B:205:0x034e, B:215:0x0381, B:216:0x039d, B:219:0x03a2, B:225:0x03b3, B:227:0x03b9, B:229:0x03c5, B:230:0x03cb, B:232:0x03d0, B:333:0x0563, B:337:0x056d, B:340:0x0576, B:344:0x0589, B:343:0x0583, B:348:0x0595, B:352:0x05a8, B:354:0x05b1, B:358:0x05c4, B:375:0x060c, B:357:0x05be, B:361:0x05cf, B:365:0x05e2, B:364:0x05dc, B:368:0x05ed, B:372:0x0600, B:371:0x05fa, B:373:0x0607, B:351:0x05a2, B:379:0x0616, B:380:0x062e, B:233:0x03d4, B:240:0x03e4, B:244:0x03f3, B:248:0x040a, B:250:0x0413, B:255:0x0420, B:256:0x0423, B:258:0x042d, B:260:0x0434, B:262:0x0438, B:269:0x044a, B:270:0x0462, B:259:0x0431, B:247:0x0404, B:273:0x0467, B:277:0x047a, B:279:0x0482, B:281:0x048b, B:285:0x049f, B:287:0x04a5, B:290:0x04ab, B:292:0x04b1, B:294:0x04bb, B:298:0x04cd, B:301:0x04d5, B:302:0x04d7, B:304:0x04dc, B:306:0x04e5, B:309:0x04ee, B:310:0x04f1, B:312:0x04f7, B:314:0x04fe, B:321:0x050b, B:322:0x0523, B:307:0x04e9, B:282:0x0496, B:276:0x0474, B:325:0x052a, B:327:0x0537, B:330:0x054a, B:332:0x0556, B:381:0x062f, B:383:0x0640, B:384:0x0644, B:386:0x064d, B:390:0x0657, B:393:0x0666, B:394:0x067e, B:98:0x01cd, B:117:0x01fb, B:40:0x00c1, B:44:0x00d2, B:43:0x00cc, B:50:0x00e5, B:52:0x00ef, B:53:0x00f2, B:56:0x00f8, B:57:0x010e, B:67:0x0121, B:68:0x0127, B:70:0x012c, B:73:0x0139, B:74:0x013d, B:77:0x0142, B:78:0x015c, B:71:0x0131, B:79:0x015d, B:80:0x0177, B:85:0x0180, B:88:0x018f, B:90:0x0195, B:91:0x01b3, B:92:0x01b4, B:395:0x067f, B:396:0x0697, B:397:0x0698, B:398:0x06b0), top: B:405:0x0064, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1721
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        if (this.lexer.token == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (this.lexer.token == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        if (this.lexer.token == 21 || this.lexer.token == 22) {
            this.lexer.nextToken();
        }
        if (this.lexer.token != 14) {
            StringBuilder sb = new StringBuilder();
            sb.append("exepct '[', but ");
            sb.append(JSONToken.name(this.lexer.token));
            sb.append(", ");
            sb.append(this.lexer.info());
            throw new JSONException(sb.toString());
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(12);
        }
        ParseContext parseContext = this.contex;
        if (!this.lexer.disableCircularReferenceDetect) {
            setContext(this.contex, collection, obj);
        }
        int i = 0;
        while (true) {
            try {
                if (this.lexer.token == 16) {
                    this.lexer.nextToken();
                } else if (this.lexer.token != 15) {
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            if (parse != null) {
                                obj2 = parse.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token == 8) {
                            this.lexer.nextToken();
                        } else {
                            obj2 = deserializer.deserialze(this, type, Integer.valueOf(i));
                        }
                        collection.add(obj2);
                        if (this.resolveStatus == 1) {
                            checkListResolve(collection);
                        }
                    }
                    if (this.lexer.token == 16) {
                        this.lexer.nextToken();
                    }
                    i++;
                } else {
                    this.contex = parseContext;
                    this.lexer.nextToken(16);
                    return;
                }
            } catch (Throwable th) {
                this.contex = parseContext;
                throw th;
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z;
        int i = 8;
        if (this.lexer.token == 8) {
            this.lexer.nextToken(16);
            return null;
        } else if (this.lexer.token != 14) {
            StringBuilder sb = new StringBuilder();
            sb.append("syntax error, ");
            sb.append(this.lexer.info());
            throw new JSONException(sb.toString());
        } else {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token != 15) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("syntax error, ");
                    sb2.append(this.lexer.info());
                    throw new JSONException(sb2.toString());
                }
                this.lexer.nextToken(16);
                return new Object[0];
            }
            this.lexer.nextToken(2);
            int i2 = 0;
            while (i2 < typeArr.length) {
                if (this.lexer.token == i) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i2];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token == 2) {
                            cast = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type == String.class) {
                        if (this.lexer.token == 4) {
                            cast = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else {
                        if (i2 == typeArr.length - 1 && (type instanceof Class)) {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        } else {
                            cls = null;
                            z = false;
                        }
                        if (z && this.lexer.token != 14) {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    if (this.lexer.token != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(12);
                                }
                                if (this.lexer.token != 15) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("syntax error, ");
                                    sb3.append(this.lexer.info());
                                    throw new JSONException(sb3.toString());
                                }
                            }
                            cast = TypeUtils.cast(arrayList, type, this.config);
                        } else {
                            cast = this.config.getDeserializer(type).deserialze(this, type, null);
                        }
                    }
                }
                objArr[i2] = cast;
                if (this.lexer.token == 15) {
                    break;
                } else if (this.lexer.token != 16) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("syntax error, ");
                    sb4.append(this.lexer.info());
                    throw new JSONException(sb4.toString());
                } else {
                    if (i2 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i2++;
                    i = 8;
                }
            }
            if (this.lexer.token != 15) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("syntax error, ");
                sb5.append(this.lexer.info());
                throw new JSONException(sb5.toString());
            }
            this.lexer.nextToken(16);
            return objArr;
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i = this.lexer.token;
        if (i != 12 && i != 16) {
            StringBuilder sb = new StringBuilder();
            sb.append("syntax error, expect {, actual ");
            sb.append(JSONToken.name(i));
            throw new JSONException(sb.toString());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token == 16) {
                    continue;
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if ((this.lexer.features & Feature.IgnoreNotMatch.mask) == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("setter not found, class ");
                    sb2.append(cls.getName());
                    sb2.append(", property ");
                    sb2.append(scanSymbol);
                    throw new JSONException(sb2.toString());
                }
                this.lexer.nextTokenWithChar(':');
                parse();
                if (this.lexer.token == 13) {
                    this.lexer.nextToken();
                    return;
                }
            } else {
                Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                Type type = fieldDeserializer.fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithChar(':');
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithChar(':');
                    deserialze = parseString();
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithChar(':');
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithChar(':');
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token != 16 && this.lexer.token == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("not support type ");
            sb.append(type);
            throw new JSONException(sb.toString());
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class) type2, (Collection) arrayList);
            return arrayList;
        } else if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (Object.class.equals(type3)) {
                if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("not support type : ");
                sb2.append(type);
                throw new JSONException(sb2.toString());
            }
            ArrayList arrayList2 = new ArrayList();
            parseArray((Class) type3, (Collection) arrayList2);
            return arrayList2;
        } else {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length != 1) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("not support : ");
                    sb3.append(typeVariable);
                    throw new JSONException(sb3.toString());
                }
                Type type4 = bounds[0];
                if (type4 instanceof Class) {
                    ArrayList arrayList3 = new ArrayList();
                    parseArray((Class) type4, (Collection) arrayList3);
                    return arrayList3;
                }
            }
            if (type2 instanceof ParameterizedType) {
                ArrayList arrayList4 = new ArrayList();
                parseArray((ParameterizedType) type2, arrayList4);
                return arrayList4;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("TODO : ");
            sb4.append(type);
            throw new JSONException(sb4.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkListResolve(Collection collection) {
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), (Object) null);
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01fa A[Catch: all -> 0x0273, TryCatch #0 {all -> 0x0273, blocks: (B:12:0x002a, B:15:0x003e, B:20:0x004f, B:24:0x0067, B:33:0x008a, B:35:0x0090, B:37:0x009e, B:41:0x00b6, B:43:0x00bf, B:46:0x00c8, B:40:0x00ae, B:48:0x00d1, B:52:0x00e9, B:54:0x00f2, B:55:0x00f5, B:51:0x00e1, B:59:0x00ff, B:60:0x0104, B:62:0x010a, B:83:0x0139, B:115:0x0208, B:117:0x020f, B:118:0x0212, B:120:0x0218, B:122:0x021e, B:127:0x0232, B:130:0x0242, B:134:0x025e, B:133:0x0256, B:135:0x0261, B:85:0x013f, B:89:0x0149, B:90:0x0156, B:91:0x015e, B:92:0x0166, B:93:0x0167, B:95:0x0174, B:97:0x0184, B:96:0x017f, B:98:0x018d, B:99:0x0195, B:100:0x019f, B:103:0x01ab, B:105:0x01c3, B:107:0x01ce, B:108:0x01d4, B:109:0x01d8, B:111:0x01e5, B:113:0x01f4, B:112:0x01ed, B:114:0x01fa, B:23:0x005f, B:25:0x006e, B:26:0x0074, B:29:0x0081), top: B:146:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x020f A[Catch: all -> 0x0273, TryCatch #0 {all -> 0x0273, blocks: (B:12:0x002a, B:15:0x003e, B:20:0x004f, B:24:0x0067, B:33:0x008a, B:35:0x0090, B:37:0x009e, B:41:0x00b6, B:43:0x00bf, B:46:0x00c8, B:40:0x00ae, B:48:0x00d1, B:52:0x00e9, B:54:0x00f2, B:55:0x00f5, B:51:0x00e1, B:59:0x00ff, B:60:0x0104, B:62:0x010a, B:83:0x0139, B:115:0x0208, B:117:0x020f, B:118:0x0212, B:120:0x0218, B:122:0x021e, B:127:0x0232, B:130:0x0242, B:134:0x025e, B:133:0x0256, B:135:0x0261, B:85:0x013f, B:89:0x0149, B:90:0x0156, B:91:0x015e, B:92:0x0166, B:93:0x0167, B:95:0x0174, B:97:0x0184, B:96:0x017f, B:98:0x018d, B:99:0x0195, B:100:0x019f, B:103:0x01ab, B:105:0x01c3, B:107:0x01ce, B:108:0x01d4, B:109:0x01d8, B:111:0x01e5, B:113:0x01f4, B:112:0x01ed, B:114:0x01fa, B:23:0x005f, B:25:0x006e, B:26:0x0074, B:29:0x0081), top: B:146:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0218 A[Catch: all -> 0x0273, TryCatch #0 {all -> 0x0273, blocks: (B:12:0x002a, B:15:0x003e, B:20:0x004f, B:24:0x0067, B:33:0x008a, B:35:0x0090, B:37:0x009e, B:41:0x00b6, B:43:0x00bf, B:46:0x00c8, B:40:0x00ae, B:48:0x00d1, B:52:0x00e9, B:54:0x00f2, B:55:0x00f5, B:51:0x00e1, B:59:0x00ff, B:60:0x0104, B:62:0x010a, B:83:0x0139, B:115:0x0208, B:117:0x020f, B:118:0x0212, B:120:0x0218, B:122:0x021e, B:127:0x0232, B:130:0x0242, B:134:0x025e, B:133:0x0256, B:135:0x0261, B:85:0x013f, B:89:0x0149, B:90:0x0156, B:91:0x015e, B:92:0x0166, B:93:0x0167, B:95:0x0174, B:97:0x0184, B:96:0x017f, B:98:0x018d, B:99:0x0195, B:100:0x019f, B:103:0x01ab, B:105:0x01c3, B:107:0x01ce, B:108:0x01d4, B:109:0x01d8, B:111:0x01e5, B:113:0x01f4, B:112:0x01ed, B:114:0x01fa, B:23:0x005f, B:25:0x006e, B:26:0x0074, B:29:0x0081), top: B:146:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e A[Catch: all -> 0x0273, TryCatch #0 {all -> 0x0273, blocks: (B:12:0x002a, B:15:0x003e, B:20:0x004f, B:24:0x0067, B:33:0x008a, B:35:0x0090, B:37:0x009e, B:41:0x00b6, B:43:0x00bf, B:46:0x00c8, B:40:0x00ae, B:48:0x00d1, B:52:0x00e9, B:54:0x00f2, B:55:0x00f5, B:51:0x00e1, B:59:0x00ff, B:60:0x0104, B:62:0x010a, B:83:0x0139, B:115:0x0208, B:117:0x020f, B:118:0x0212, B:120:0x0218, B:122:0x021e, B:127:0x0232, B:130:0x0242, B:134:0x025e, B:133:0x0256, B:135:0x0261, B:85:0x013f, B:89:0x0149, B:90:0x0156, B:91:0x015e, B:92:0x0166, B:93:0x0167, B:95:0x0174, B:97:0x0184, B:96:0x017f, B:98:0x018d, B:99:0x0195, B:100:0x019f, B:103:0x01ab, B:105:0x01c3, B:107:0x01ce, B:108:0x01d4, B:109:0x01d8, B:111:0x01e5, B:113:0x01f4, B:112:0x01ed, B:114:0x01fa, B:23:0x005f, B:25:0x006e, B:26:0x0074, B:29:0x0081), top: B:146:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010a A[Catch: all -> 0x0273, LOOP:1: B:61:0x0108->B:62:0x010a, LOOP_END, TryCatch #0 {all -> 0x0273, blocks: (B:12:0x002a, B:15:0x003e, B:20:0x004f, B:24:0x0067, B:33:0x008a, B:35:0x0090, B:37:0x009e, B:41:0x00b6, B:43:0x00bf, B:46:0x00c8, B:40:0x00ae, B:48:0x00d1, B:52:0x00e9, B:54:0x00f2, B:55:0x00f5, B:51:0x00e1, B:59:0x00ff, B:60:0x0104, B:62:0x010a, B:83:0x0139, B:115:0x0208, B:117:0x020f, B:118:0x0212, B:120:0x0218, B:122:0x021e, B:127:0x0232, B:130:0x0242, B:134:0x025e, B:133:0x0256, B:135:0x0261, B:85:0x013f, B:89:0x0149, B:90:0x0156, B:91:0x015e, B:92:0x0166, B:93:0x0167, B:95:0x0174, B:97:0x0184, B:96:0x017f, B:98:0x018d, B:99:0x0195, B:100:0x019f, B:103:0x01ab, B:105:0x01c3, B:107:0x01ce, B:108:0x01d4, B:109:0x01d8, B:111:0x01e5, B:113:0x01f4, B:112:0x01ed, B:114:0x01fa, B:23:0x005f, B:25:0x006e, B:26:0x0074, B:29:0x0081), top: B:146:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseArray(java.util.Collection r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.disableCircularReferenceDetect) {
            return;
        }
        this.contex = parseContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex - 1;
        parseContextArr[i] = null;
        this.contextArrayIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i] = parseContext2;
        return parseContext2;
    }

    public Object parse() {
        return parse(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object parse(Object obj) {
        int i = this.lexer.token;
        if (i == 2) {
            Number integerValue = this.lexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
        if (i == 3) {
            Number decimalValue = this.lexer.decimalValue((this.lexer.features & Feature.UseBigDecimal.mask) != 0);
            this.lexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer = new JSONLexer(stringVal);
                try {
                    if (jSONLexer.scanISO8601DateIfMatch(true)) {
                        return jSONLexer.calendar.getTime();
                    }
                } finally {
                    jSONLexer.close();
                }
            }
            return stringVal;
        } else if (i == 12) {
            return parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), obj);
        } else if (i == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONArray;
        } else {
            switch (i) {
                case 6:
                    this.lexer.nextToken(16);
                    return Boolean.TRUE;
                case 7:
                    this.lexer.nextToken(16);
                    return Boolean.FALSE;
                case 8:
                    break;
                case 9:
                    this.lexer.nextToken(18);
                    if (this.lexer.token != 18) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("syntax error, ");
                        sb.append(this.lexer.info());
                        throw new JSONException(sb.toString());
                    }
                    this.lexer.nextToken(10);
                    accept(10);
                    long longValue = this.lexer.integerValue().longValue();
                    accept(2);
                    accept(11);
                    return new Date(longValue);
                default:
                    switch (i) {
                        case 20:
                            if (this.lexer.isBlankInput()) {
                                return null;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("syntax error, ");
                            sb2.append(this.lexer.info());
                            throw new JSONException(sb2.toString());
                        case 21:
                            this.lexer.nextToken();
                            HashSet hashSet = new HashSet();
                            parseArray(hashSet, obj);
                            return hashSet;
                        case 22:
                            this.lexer.nextToken();
                            TreeSet treeSet = new TreeSet();
                            parseArray(treeSet, obj);
                            return treeSet;
                        case 23:
                            break;
                        default:
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("syntax error, ");
                            sb3.append(this.lexer.info());
                            throw new JSONException(sb3.toString());
                    }
            }
            this.lexer.nextToken();
            return null;
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public final void accept(int i) {
        if (this.lexer.token == i) {
            this.lexer.nextToken();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("syntax error, expect ");
        sb.append(JSONToken.name(i));
        sb.append(", actual ");
        sb.append(JSONToken.name(this.lexer.token));
        throw new JSONException(sb.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.lexer.token == 20) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("not close json text, token : ");
            sb.append(JSONToken.name(this.lexer.token));
            throw new JSONException(sb.toString());
        } finally {
            this.lexer.close();
        }
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                Object obj2 = null;
                Object obj3 = resolveTask.ownerContext != null ? resolveTask.ownerContext.object : null;
                String str = resolveTask.referenceValue;
                if (str.startsWith("$")) {
                    for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
                        if (str.equals(this.contextArray[i2].toString())) {
                            obj2 = this.contextArray[i2].object;
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public String parseString() {
        int i = this.lexer.token;
        if (i != 4) {
            if (i == 2) {
                String numberString = this.lexer.numberString();
                this.lexer.nextToken(16);
                return numberString;
            }
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
        String stringVal = this.lexer.stringVal();
        char c = this.lexer.ch;
        char c2 = JSONLexer.EOI;
        if (c == ',') {
            JSONLexer jSONLexer = this.lexer;
            int i2 = jSONLexer.bp + 1;
            jSONLexer.bp = i2;
            JSONLexer jSONLexer2 = this.lexer;
            if (i2 < jSONLexer2.len) {
                c2 = this.lexer.text.charAt(i2);
            }
            jSONLexer2.ch = c2;
            this.lexer.token = 16;
        } else if (this.lexer.ch == ']') {
            JSONLexer jSONLexer3 = this.lexer;
            int i3 = jSONLexer3.bp + 1;
            jSONLexer3.bp = i3;
            JSONLexer jSONLexer4 = this.lexer;
            if (i3 < jSONLexer4.len) {
                c2 = this.lexer.text.charAt(i3);
            }
            jSONLexer4.ch = c2;
            this.lexer.token = 15;
        } else if (this.lexer.ch == '}') {
            JSONLexer jSONLexer5 = this.lexer;
            int i4 = jSONLexer5.bp + 1;
            jSONLexer5.bp = i4;
            JSONLexer jSONLexer6 = this.lexer;
            if (i4 < jSONLexer6.len) {
                c2 = this.lexer.text.charAt(i4);
            }
            jSONLexer6.ch = c2;
            this.lexer.token = 13;
        } else {
            this.lexer.nextToken();
        }
        return stringVal;
    }

    /* loaded from: classes3.dex */
    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }
}
