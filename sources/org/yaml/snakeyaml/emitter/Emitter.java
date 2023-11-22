package org.yaml.snakeyaml.emitter;

import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.constant.BranchLinkConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.yaml.snakeyaml.DumperOptions;

/* loaded from: classes9.dex */
public final class Emitter implements Emitable {
    private static final Map<Character, String> BuiltInFictitiousFunctionClassFactory;
    private static final Pattern KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Set<Character> MyBillsEntityDataFactory;
    private static final Pattern PlaceComponentResult;
    private static final Map<String, String> getAuthRequestContext;
    private static final char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {InputCardNumberView.DIVIDER};
    private static final Pattern scheduleImpl = Pattern.compile("\\s");

    /* loaded from: classes9.dex */
    class ExpectBlockMappingKey implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectBlockMappingSimpleValue implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectBlockMappingValue implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectBlockSequenceItem implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectDocumentEnd implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectDocumentRoot implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectDocumentStart implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFirstBlockMappingKey implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFirstBlockSequenceItem implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFirstDocumentStart implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFirstFlowMappingKey implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFirstFlowSequenceItem implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFlowMappingKey implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFlowMappingSimpleValue implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFlowMappingValue implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectFlowSequenceItem implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectNothing implements EmitterState {
    }

    /* loaded from: classes9.dex */
    class ExpectStreamStart implements EmitterState {
    }

    static {
        HashSet hashSet = new HashSet();
        MyBillsEntityDataFactory = hashSet;
        hashSet.add('[');
        hashSet.add(']');
        hashSet.add('{');
        hashSet.add('}');
        hashSet.add(',');
        hashSet.add('*');
        hashSet.add(Character.valueOf(Typography.amp));
        HashMap hashMap = new HashMap();
        BuiltInFictitiousFunctionClassFactory = hashMap;
        hashMap.put((char) 0, "0");
        hashMap.put((char) 7, "a");
        hashMap.put('\b', "b");
        hashMap.put('\t', SecurityConstants.KEY_TEXT);
        hashMap.put('\n', "n");
        hashMap.put((char) 11, SecurityConstants.KEY_VALUE);
        hashMap.put('\f', f.f7258a);
        hashMap.put('\r', BranchLinkConstant.PayloadKey.REFERRAL);
        hashMap.put((char) 27, e.PlaceComponentResult);
        hashMap.put(Character.valueOf(Typography.quote), "\"");
        hashMap.put('\\', "\\");
        hashMap.put((char) 133, "N");
        hashMap.put(Character.valueOf(Typography.nbsp), "_");
        hashMap.put((char) 8232, "L");
        hashMap.put((char) 8233, "P");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        getAuthRequestContext = linkedHashMap;
        linkedHashMap.put("!", "!");
        linkedHashMap.put("tag:yaml.org,2002:", "!!");
        KClassImpl$Data$declaredNonStaticMembers$2 = Pattern.compile("^![-_\\w]*!$");
        PlaceComponentResult = Pattern.compile("0[0-9_]+");
    }

    /* renamed from: org.yaml.snakeyaml.emitter.Emitter$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[DumperOptions.ScalarStyle.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[DumperOptions.ScalarStyle.DOUBLE_QUOTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[DumperOptions.ScalarStyle.SINGLE_QUOTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[DumperOptions.ScalarStyle.FOLDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[DumperOptions.ScalarStyle.LITERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
