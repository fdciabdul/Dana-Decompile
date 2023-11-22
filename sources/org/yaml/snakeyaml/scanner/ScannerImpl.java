package org.yaml.snakeyaml.scanner;

import id.dana.cashier.view.InputCardNumberView;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEndToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DocumentEndToken;
import org.yaml.snakeyaml.tokens.DocumentStartToken;
import org.yaml.snakeyaml.tokens.FlowMappingEndToken;
import org.yaml.snakeyaml.tokens.FlowMappingStartToken;
import org.yaml.snakeyaml.tokens.FlowSequenceEndToken;
import org.yaml.snakeyaml.tokens.FlowSequenceStartToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;
import org.yaml.snakeyaml.util.UriEncoder;

/* loaded from: classes6.dex */
public final class ScannerImpl implements Scanner {
    public static final Map<Character, String> BuiltInFictitiousFunctionClassFactory;
    public static final Map<Character, Integer> KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Pattern MyBillsEntityDataFactory = Pattern.compile("[^0-9A-Fa-f]");
    private final StreamReader DatabaseTableConfigUtil;
    private final boolean GetContactSyncConfig;
    private final Map<Integer, SimpleKey> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final LoaderOptions getErrorConfigVersion;
    private final List<Token> initRecordTimeStamp;
    private Token lookAheadTest;
    private final ArrayStack<Integer> moveToNextValue;
    private boolean PlaceComponentResult = false;
    private int scheduleImpl = 0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private boolean getAuthRequestContext = true;

    static {
        HashMap hashMap = new HashMap();
        BuiltInFictitiousFunctionClassFactory = hashMap;
        HashMap hashMap2 = new HashMap();
        KClassImpl$Data$declaredNonStaticMembers$2 = hashMap2;
        hashMap.put('0', "\u0000");
        hashMap.put('a', "\u0007");
        hashMap.put('b', "\b");
        hashMap.put('t', "\t");
        hashMap.put('n', "\n");
        hashMap.put('v', "\u000b");
        hashMap.put('f', "\f");
        hashMap.put('r', "\r");
        hashMap.put('e', "\u001b");
        hashMap.put(Character.valueOf(InputCardNumberView.DIVIDER), " ");
        hashMap.put(Character.valueOf(Typography.quote), "\"");
        hashMap.put('\\', "\\");
        hashMap.put('N', "\u0085");
        hashMap.put('_', " ");
        hashMap.put('L', "\u2028");
        hashMap.put('P', "\u2029");
        hashMap2.put('x', 2);
        hashMap2.put('u', 4);
        hashMap2.put('U', 8);
    }

    public ScannerImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.GetContactSyncConfig = loaderOptions.PlaceComponentResult();
        this.DatabaseTableConfigUtil = streamReader;
        this.initRecordTimeStamp = new ArrayList(100);
        this.moveToNextValue = new ArrayStack<>(10);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new LinkedHashMap();
        this.getErrorConfigVersion = loaderOptions;
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest);
        StreamStartToken streamStartToken = new StreamStartToken(mark, mark);
        this.lookAheadTest = streamStartToken;
        this.initRecordTimeStamp.add(streamStartToken);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Token.ID... idArr) {
        while (NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            initRecordTimeStamp();
        }
        if (!this.initRecordTimeStamp.isEmpty()) {
            if (idArr.length == 0) {
                return true;
            }
            Token.ID BuiltInFictitiousFunctionClassFactory2 = this.initRecordTimeStamp.get(0).BuiltInFictitiousFunctionClassFactory();
            for (Token.ID id2 : idArr) {
                if (BuiltInFictitiousFunctionClassFactory2 == id2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public final Token MyBillsEntityDataFactory() {
        while (NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            initRecordTimeStamp();
        }
        return this.initRecordTimeStamp.get(0);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public final Token getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1++;
        return this.initRecordTimeStamp.remove(0);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(List<Token> list) {
        this.lookAheadTest = list.get(list.size() - 1);
        this.initRecordTimeStamp.addAll(list);
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.PlaceComponentResult) {
            return false;
        }
        if (this.initRecordTimeStamp.isEmpty()) {
            return true;
        }
        newProxyInstance();
        return (!this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty() ? this.NetworkUserEntityData$$ExternalSyntheticLambda2.values().iterator().next().PlaceComponentResult : -1) == this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0a69, code lost:
    
        if (r4.PlaceComponentResult(r12.getAuthRequestContext(3) ? r12.getAuthRequestContext[r12.lookAheadTest + 3] : 0) == false) goto L393;
     */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0afe  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0b25 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initRecordTimeStamp() {
        /*
            Method dump skipped, instructions count: 3136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.ScannerImpl.initRecordTimeStamp():void");
    }

    private void newProxyInstance() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty()) {
            return;
        }
        Iterator<SimpleKey> it = this.NetworkUserEntityData$$ExternalSyntheticLambda2.values().iterator();
        while (it.hasNext()) {
            SimpleKey next = it.next();
            if (next.BuiltInFictitiousFunctionClassFactory != this.DatabaseTableConfigUtil.PlaceComponentResult || this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2 - next.KClassImpl$Data$declaredNonStaticMembers$2 > 1024) {
                if (!next.MyBillsEntityDataFactory()) {
                    it.remove();
                } else {
                    Mark mark = next.getAuthRequestContext;
                    StreamReader streamReader = this.DatabaseTableConfigUtil;
                    throw new ScannerException("while scanning a simple key", mark, "could not find expected ':'", new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest));
                }
            }
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        boolean z = this.scheduleImpl == 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
        boolean z2 = this.getAuthRequestContext;
        if (!z2 && z) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (z2) {
            DatabaseTableConfigUtil();
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int size = this.initRecordTimeStamp.size();
            int i2 = this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = this.DatabaseTableConfigUtil.PlaceComponentResult;
            int i4 = i + size;
            int i5 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
            StreamReader streamReader = this.DatabaseTableConfigUtil;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.put(Integer.valueOf(this.scheduleImpl), new SimpleKey(i4, z, i2, i3, i5, new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest)));
        }
    }

    private void DatabaseTableConfigUtil() {
        SimpleKey remove = this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(Integer.valueOf(this.scheduleImpl));
        if (remove == null || !remove.MyBillsEntityDataFactory()) {
            return;
        }
        Mark mark = remove.getAuthRequestContext;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        throw new ScannerException("while scanning a simple key", mark, "could not find expected ':'", new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest));
    }

    private void PlaceComponentResult(int i) {
        if (this.scheduleImpl != 0) {
            return;
        }
        while (this.NetworkUserEntityData$$ExternalSyntheticLambda0 > i) {
            StreamReader streamReader = this.DatabaseTableConfigUtil;
            Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.moveToNextValue.getAuthRequestContext.remove(r0.size() - 1).intValue();
            BlockEndToken blockEndToken = new BlockEndToken(mark, mark);
            this.lookAheadTest = blockEndToken;
            this.initRecordTimeStamp.add(blockEndToken);
        }
    }

    private boolean getAuthRequestContext(int i) {
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (i2 < i) {
            ArrayStack<Integer> arrayStack = this.moveToNextValue;
            arrayStack.getAuthRequestContext.add(Integer.valueOf(i2));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
            return true;
        }
        return false;
    }

    private void PlaceComponentResult(boolean z) {
        Token documentEndToken;
        PlaceComponentResult(-1);
        DatabaseTableConfigUtil();
        this.getAuthRequestContext = false;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(3);
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        Mark mark2 = new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest);
        if (z) {
            documentEndToken = new DocumentStartToken(mark, mark2);
        } else {
            documentEndToken = new DocumentEndToken(mark, mark2);
        }
        this.lookAheadTest = documentEndToken;
        this.initRecordTimeStamp.add(documentEndToken);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        Token flowSequenceStartToken;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        this.scheduleImpl++;
        this.getAuthRequestContext = true;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        Mark mark2 = new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest);
        if (z) {
            flowSequenceStartToken = new FlowMappingStartToken(mark, mark2);
        } else {
            flowSequenceStartToken = new FlowSequenceStartToken(mark, mark2);
        }
        this.lookAheadTest = flowSequenceStartToken;
        this.initRecordTimeStamp.add(flowSequenceStartToken);
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        Token flowSequenceEndToken;
        DatabaseTableConfigUtil();
        this.scheduleImpl--;
        this.getAuthRequestContext = false;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        Mark mark2 = new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest);
        if (z) {
            flowSequenceEndToken = new FlowMappingEndToken(mark, mark2);
        } else {
            flowSequenceEndToken = new FlowSequenceEndToken(mark, mark2);
        }
        this.lookAheadTest = flowSequenceEndToken;
        this.initRecordTimeStamp.add(flowSequenceEndToken);
    }

    private void BuiltInFictitiousFunctionClassFactory(char c) {
        Boolean bool;
        Boolean bool2;
        int i;
        int i2;
        int i3;
        String str;
        Mark mark;
        Mark mark2;
        this.getAuthRequestContext = true;
        DatabaseTableConfigUtil();
        boolean z = c == '>';
        StringBuilder sb = new StringBuilder();
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark3 = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        int i4 = streamReader2.BuiltInFictitiousFunctionClassFactory() ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest] : 0;
        if (i4 != 45 && i4 != 43) {
            if (Character.isDigit(i4)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(i4)));
                if (i == 0) {
                    StreamReader streamReader3 = this.DatabaseTableConfigUtil;
                    throw new ScannerException("while scanning a block scalar", mark3, "expected indentation indicator in the range 1-9, but found 0", new Mark(streamReader3.MyBillsEntityDataFactory, streamReader3.KClassImpl$Data$declaredNonStaticMembers$2, streamReader3.PlaceComponentResult, streamReader3.BuiltInFictitiousFunctionClassFactory, streamReader3.getAuthRequestContext, streamReader3.lookAheadTest));
                }
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                StreamReader streamReader4 = this.DatabaseTableConfigUtil;
                int i5 = streamReader4.BuiltInFictitiousFunctionClassFactory() ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest] : 0;
                if (i5 == 45 || i5 == 43) {
                    if (i5 == 43) {
                        bool2 = Boolean.TRUE;
                    } else {
                        bool2 = Boolean.FALSE;
                    }
                    this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                }
            } else {
                i = -1;
            }
            bool2 = null;
        } else {
            if (i4 == 43) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
            StreamReader streamReader5 = this.DatabaseTableConfigUtil;
            int i6 = streamReader5.BuiltInFictitiousFunctionClassFactory() ? streamReader5.getAuthRequestContext[streamReader5.lookAheadTest] : 0;
            if (Character.isDigit(i6)) {
                int parseInt = Integer.parseInt(String.valueOf(Character.toChars(i6)));
                if (parseInt == 0) {
                    StreamReader streamReader6 = this.DatabaseTableConfigUtil;
                    throw new ScannerException("while scanning a block scalar", mark3, "expected indentation indicator in the range 1-9, but found 0", new Mark(streamReader6.MyBillsEntityDataFactory, streamReader6.KClassImpl$Data$declaredNonStaticMembers$2, streamReader6.PlaceComponentResult, streamReader6.BuiltInFictitiousFunctionClassFactory, streamReader6.getAuthRequestContext, streamReader6.lookAheadTest));
                }
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                bool2 = bool;
                i = parseInt;
            } else {
                bool2 = bool;
                i = -1;
            }
        }
        StreamReader streamReader7 = this.DatabaseTableConfigUtil;
        int i7 = streamReader7.BuiltInFictitiousFunctionClassFactory() ? streamReader7.getAuthRequestContext[streamReader7.lookAheadTest] : 0;
        if (Constant.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i7)) {
            String valueOf = String.valueOf(Character.toChars(i7));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("expected chomping or indentation indicators, but found ");
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(i7);
            sb2.append(")");
            String obj = sb2.toString();
            StreamReader streamReader8 = this.DatabaseTableConfigUtil;
            throw new ScannerException("while scanning a block scalar", mark3, obj, new Mark(streamReader8.MyBillsEntityDataFactory, streamReader8.KClassImpl$Data$declaredNonStaticMembers$2, streamReader8.PlaceComponentResult, streamReader8.BuiltInFictitiousFunctionClassFactory, streamReader8.getAuthRequestContext, streamReader8.lookAheadTest));
        }
        Chomping chomping = new Chomping(bool2, i);
        int i8 = chomping.getAuthRequestContext;
        while (true) {
            StreamReader streamReader9 = this.DatabaseTableConfigUtil;
            i2 = 32;
            if ((streamReader9.BuiltInFictitiousFunctionClassFactory() ? streamReader9.getAuthRequestContext[streamReader9.lookAheadTest] : 0) != 32) {
                break;
            }
            this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        }
        StreamReader streamReader10 = this.DatabaseTableConfigUtil;
        CommentToken BuiltInFictitiousFunctionClassFactory2 = (streamReader10.BuiltInFictitiousFunctionClassFactory() ? streamReader10.getAuthRequestContext[streamReader10.lookAheadTest] : 0) == 35 ? BuiltInFictitiousFunctionClassFactory(CommentType.IN_LINE) : null;
        StreamReader streamReader11 = this.DatabaseTableConfigUtil;
        int i9 = streamReader11.BuiltInFictitiousFunctionClassFactory() ? streamReader11.getAuthRequestContext[streamReader11.lookAheadTest] : 0;
        if (GetContactSyncConfig().length() != 0 || i9 == 0) {
            int i10 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
            if (i10 <= 0) {
                i10 = 1;
            }
            if (i8 != -1) {
                i3 = (i10 + i8) - 1;
                Object[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(i3);
                str = (String) KClassImpl$Data$declaredNonStaticMembers$22[0];
                mark = (Mark) KClassImpl$Data$declaredNonStaticMembers$22[1];
            } else {
                StringBuilder sb3 = new StringBuilder();
                StreamReader streamReader12 = this.DatabaseTableConfigUtil;
                Mark mark4 = new Mark(streamReader12.MyBillsEntityDataFactory, streamReader12.KClassImpl$Data$declaredNonStaticMembers$2, streamReader12.PlaceComponentResult, streamReader12.BuiltInFictitiousFunctionClassFactory, streamReader12.getAuthRequestContext, streamReader12.lookAheadTest);
                int i11 = 0;
                while (true) {
                    Constant constant = Constant.MyBillsEntityDataFactory;
                    StreamReader streamReader13 = this.DatabaseTableConfigUtil;
                    if (!constant.BuiltInFictitiousFunctionClassFactory(streamReader13.BuiltInFictitiousFunctionClassFactory() ? streamReader13.getAuthRequestContext[streamReader13.lookAheadTest] : 0, " \r")) {
                        break;
                    }
                    StreamReader streamReader14 = this.DatabaseTableConfigUtil;
                    if ((streamReader14.BuiltInFictitiousFunctionClassFactory() ? streamReader14.getAuthRequestContext[streamReader14.lookAheadTest] : 0) != i2) {
                        sb3.append(GetContactSyncConfig());
                        StreamReader streamReader15 = this.DatabaseTableConfigUtil;
                        mark4 = new Mark(streamReader15.MyBillsEntityDataFactory, streamReader15.KClassImpl$Data$declaredNonStaticMembers$2, streamReader15.PlaceComponentResult, streamReader15.BuiltInFictitiousFunctionClassFactory, streamReader15.getAuthRequestContext, streamReader15.lookAheadTest);
                    } else {
                        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                        if (this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory > i11) {
                            i11 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
                        }
                    }
                    i2 = 32;
                }
                Object[] objArr = {sb3.toString(), Integer.valueOf(i11), mark4};
                str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                mark = (Mark) objArr[2];
                i3 = Math.max(i10, intValue);
            }
            String str2 = "";
            while (this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory == i3) {
                StreamReader streamReader16 = this.DatabaseTableConfigUtil;
                if ((streamReader16.BuiltInFictitiousFunctionClassFactory() ? streamReader16.getAuthRequestContext[streamReader16.lookAheadTest] : 0) == 0) {
                    break;
                }
                sb.append(str);
                StreamReader streamReader17 = this.DatabaseTableConfigUtil;
                boolean z2 = " \t".indexOf(streamReader17.BuiltInFictitiousFunctionClassFactory() ? streamReader17.getAuthRequestContext[streamReader17.lookAheadTest] : 0) == -1;
                int i12 = 0;
                while (true) {
                    Constant constant2 = Constant.lookAheadTest;
                    StreamReader streamReader18 = this.DatabaseTableConfigUtil;
                    if (!constant2.MyBillsEntityDataFactory(streamReader18.getAuthRequestContext(i12) ? streamReader18.getAuthRequestContext[streamReader18.lookAheadTest + i12] : 0)) {
                        break;
                    }
                    i12++;
                }
                sb.append(this.DatabaseTableConfigUtil.PlaceComponentResult(i12));
                str2 = GetContactSyncConfig();
                Object[] KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2(i3);
                String str3 = (String) KClassImpl$Data$declaredNonStaticMembers$23[0];
                mark = (Mark) KClassImpl$Data$declaredNonStaticMembers$23[1];
                if (this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory == i3) {
                    StreamReader streamReader19 = this.DatabaseTableConfigUtil;
                    if ((streamReader19.BuiltInFictitiousFunctionClassFactory() ? streamReader19.getAuthRequestContext[streamReader19.lookAheadTest] : 0) != 0) {
                        if (z && "\n".equals(str2) && z2) {
                            StreamReader streamReader20 = this.DatabaseTableConfigUtil;
                            if (" \t".indexOf(streamReader20.BuiltInFictitiousFunctionClassFactory() ? streamReader20.getAuthRequestContext[streamReader20.lookAheadTest] : 0) == -1) {
                                if (str3.length() == 0) {
                                    sb.append(" ");
                                }
                                str = str3;
                            }
                        }
                        sb.append(str2);
                        str = str3;
                    }
                }
                mark2 = mark;
                str = str3;
                break;
            }
            mark2 = mark;
            if (chomping.MyBillsEntityDataFactory()) {
                sb.append(str2);
            }
            if (chomping.getAuthRequestContext()) {
                sb.append(str);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2, new ScalarToken(sb.toString(), false, mark3, mark2, DumperOptions.ScalarStyle.createStyle(Character.valueOf(c)))));
            return;
        }
        String valueOf2 = String.valueOf(Character.toChars(i9));
        StringBuilder sb4 = new StringBuilder();
        sb4.append("expected a comment or a line break, but found ");
        sb4.append(valueOf2);
        sb4.append("(");
        sb4.append(i9);
        sb4.append(")");
        String obj2 = sb4.toString();
        StreamReader streamReader21 = this.DatabaseTableConfigUtil;
        throw new ScannerException("while scanning a block scalar", mark3, obj2, new Mark(streamReader21.MyBillsEntityDataFactory, streamReader21.KClassImpl$Data$declaredNonStaticMembers$2, streamReader21.PlaceComponentResult, streamReader21.BuiltInFictitiousFunctionClassFactory, streamReader21.getAuthRequestContext, streamReader21.lookAheadTest));
    }

    private void PlaceComponentResult(char c) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        this.getAuthRequestContext = false;
        boolean z = c == '\"';
        StringBuilder sb = new StringBuilder();
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        int i = streamReader2.BuiltInFictitiousFunctionClassFactory() ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest] : 0;
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        sb.append(getAuthRequestContext(z, mark));
        while (true) {
            StreamReader streamReader3 = this.DatabaseTableConfigUtil;
            if ((streamReader3.BuiltInFictitiousFunctionClassFactory() ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest] : 0) != i) {
                StringBuilder sb2 = new StringBuilder();
                int i2 = 0;
                while (true) {
                    StreamReader streamReader4 = this.DatabaseTableConfigUtil;
                    if (" \t".indexOf(streamReader4.getAuthRequestContext(i2) ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest + i2] : 0) == -1) {
                        break;
                    }
                    i2++;
                }
                String PlaceComponentResult = this.DatabaseTableConfigUtil.PlaceComponentResult(i2);
                StreamReader streamReader5 = this.DatabaseTableConfigUtil;
                if ((streamReader5.BuiltInFictitiousFunctionClassFactory() ? streamReader5.getAuthRequestContext[streamReader5.lookAheadTest] : 0) == 0) {
                    StreamReader streamReader6 = this.DatabaseTableConfigUtil;
                    throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected end of stream", new Mark(streamReader6.MyBillsEntityDataFactory, streamReader6.KClassImpl$Data$declaredNonStaticMembers$2, streamReader6.PlaceComponentResult, streamReader6.BuiltInFictitiousFunctionClassFactory, streamReader6.getAuthRequestContext, streamReader6.lookAheadTest));
                }
                String GetContactSyncConfig = GetContactSyncConfig();
                if (GetContactSyncConfig.length() != 0) {
                    String authRequestContext = getAuthRequestContext(mark);
                    if (!"\n".equals(GetContactSyncConfig)) {
                        sb2.append(GetContactSyncConfig);
                    } else if (authRequestContext.length() == 0) {
                        sb2.append(" ");
                    }
                    sb2.append(authRequestContext);
                } else {
                    sb2.append(PlaceComponentResult);
                }
                sb.append(sb2.toString());
                sb.append(getAuthRequestContext(z, mark));
            } else {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                StreamReader streamReader7 = this.DatabaseTableConfigUtil;
                ScalarToken scalarToken = new ScalarToken(sb.toString(), false, mark, new Mark(streamReader7.MyBillsEntityDataFactory, streamReader7.KClassImpl$Data$declaredNonStaticMembers$2, streamReader7.PlaceComponentResult, streamReader7.BuiltInFictitiousFunctionClassFactory, streamReader7.getAuthRequestContext, streamReader7.lookAheadTest), DumperOptions.ScalarStyle.createStyle(Character.valueOf(c)));
                this.lookAheadTest = scalarToken;
                this.initRecordTimeStamp.add(scalarToken);
                return;
            }
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory == 0;
    }

    private boolean getErrorConfigVersion() {
        if (this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory == 0 && "---".equals(this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(3))) {
            Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
            StreamReader streamReader = this.DatabaseTableConfigUtil;
            return constant.PlaceComponentResult(streamReader.getAuthRequestContext(3) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 3] : 0);
        }
        return false;
    }

    private boolean lookAheadTest() {
        if (this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory == 0 && "...".equals(this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(3))) {
            Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
            StreamReader streamReader = this.DatabaseTableConfigUtil;
            return constant.PlaceComponentResult(streamReader.getAuthRequestContext(3) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 3] : 0);
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        return constant.PlaceComponentResult(streamReader.getAuthRequestContext(1) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 1] : 0);
    }

    private boolean moveToNextValue() {
        if (this.scheduleImpl != 0) {
            return true;
        }
        Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        return constant.PlaceComponentResult(streamReader.getAuthRequestContext(1) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 1] : 0);
    }

    private boolean scheduleImpl() {
        if (this.scheduleImpl != 0) {
            return true;
        }
        Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        return constant.PlaceComponentResult(streamReader.getAuthRequestContext(1) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 1] : 0);
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        int i = streamReader.BuiltInFictitiousFunctionClassFactory() ? streamReader.getAuthRequestContext[streamReader.lookAheadTest] : 0;
        if (!Constant.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i, "-?:,[]{}#&*!|>'\"%@`")) {
            Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            if (!constant.MyBillsEntityDataFactory(streamReader2.getAuthRequestContext(1) ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest + 1] : 0)) {
                return false;
            }
            if (i != 45 && (this.scheduleImpl != 0 || "?:".indexOf(i) == -1)) {
                return false;
            }
        }
        return true;
    }

    private CommentToken BuiltInFictitiousFunctionClassFactory(CommentType commentType) {
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        int i = 0;
        while (true) {
            Constant constant = Constant.lookAheadTest;
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            if (!constant.MyBillsEntityDataFactory(streamReader2.getAuthRequestContext(i) ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest + i] : 0)) {
                String PlaceComponentResult = this.DatabaseTableConfigUtil.PlaceComponentResult(i);
                StreamReader streamReader3 = this.DatabaseTableConfigUtil;
                return new CommentToken(commentType, PlaceComponentResult, mark, new Mark(streamReader3.MyBillsEntityDataFactory, streamReader3.KClassImpl$Data$declaredNonStaticMembers$2, streamReader3.PlaceComponentResult, streamReader3.BuiltInFictitiousFunctionClassFactory, streamReader3.getAuthRequestContext, streamReader3.lookAheadTest));
            }
            i++;
        }
    }

    private Integer KClassImpl$Data$declaredNonStaticMembers$2(Mark mark) {
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        int i = streamReader.BuiltInFictitiousFunctionClassFactory() ? streamReader.getAuthRequestContext[streamReader.lookAheadTest] : 0;
        if (!Character.isDigit(i)) {
            String valueOf = String.valueOf(Character.toChars(i));
            StringBuilder sb = new StringBuilder();
            sb.append("expected a digit, but found ");
            sb.append(valueOf);
            sb.append("(");
            sb.append(i);
            sb.append(")");
            String obj = sb.toString();
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            throw new ScannerException("while scanning a directive", mark, obj, new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest));
        }
        int i2 = 0;
        while (true) {
            StreamReader streamReader3 = this.DatabaseTableConfigUtil;
            if (!Character.isDigit(streamReader3.getAuthRequestContext(i2) ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest + i2] : 0)) {
                return Integer.valueOf(Integer.parseInt(this.DatabaseTableConfigUtil.PlaceComponentResult(i2)));
            }
            i2++;
        }
    }

    private Token MyBillsEntityDataFactory(boolean z) {
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        String str = (streamReader2.BuiltInFictitiousFunctionClassFactory() ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest] : 0) == 42 ? "alias" : "anchor";
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        StreamReader streamReader3 = this.DatabaseTableConfigUtil;
        int i = streamReader3.getAuthRequestContext(0) ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest + 0] : 0;
        int i2 = 0;
        while (Constant.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i, ":,[]{}/.*&")) {
            i2++;
            StreamReader streamReader4 = this.DatabaseTableConfigUtil;
            i = streamReader4.getAuthRequestContext(i2) ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest + i2] : 0;
        }
        if (i2 == 0) {
            String valueOf = String.valueOf(Character.toChars(i));
            StringBuilder sb = new StringBuilder();
            sb.append("while scanning an ");
            sb.append(str);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unexpected character found ");
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(i);
            sb2.append(")");
            String obj2 = sb2.toString();
            StreamReader streamReader5 = this.DatabaseTableConfigUtil;
            throw new ScannerException(obj, mark, obj2, new Mark(streamReader5.MyBillsEntityDataFactory, streamReader5.KClassImpl$Data$declaredNonStaticMembers$2, streamReader5.PlaceComponentResult, streamReader5.BuiltInFictitiousFunctionClassFactory, streamReader5.getAuthRequestContext, streamReader5.lookAheadTest));
        }
        String PlaceComponentResult = this.DatabaseTableConfigUtil.PlaceComponentResult(i2);
        StreamReader streamReader6 = this.DatabaseTableConfigUtil;
        int i3 = streamReader6.BuiltInFictitiousFunctionClassFactory() ? streamReader6.getAuthRequestContext[streamReader6.lookAheadTest] : 0;
        if (Constant.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i3, "?:,]}%@`")) {
            String valueOf2 = String.valueOf(Character.toChars(i3));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("while scanning an ");
            sb3.append(str);
            String obj3 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("unexpected character found ");
            sb4.append(valueOf2);
            sb4.append("(");
            sb4.append(i3);
            sb4.append(")");
            String obj4 = sb4.toString();
            StreamReader streamReader7 = this.DatabaseTableConfigUtil;
            throw new ScannerException(obj3, mark, obj4, new Mark(streamReader7.MyBillsEntityDataFactory, streamReader7.KClassImpl$Data$declaredNonStaticMembers$2, streamReader7.PlaceComponentResult, streamReader7.BuiltInFictitiousFunctionClassFactory, streamReader7.getAuthRequestContext, streamReader7.lookAheadTest));
        }
        StreamReader streamReader8 = this.DatabaseTableConfigUtil;
        Mark mark2 = new Mark(streamReader8.MyBillsEntityDataFactory, streamReader8.KClassImpl$Data$declaredNonStaticMembers$2, streamReader8.PlaceComponentResult, streamReader8.BuiltInFictitiousFunctionClassFactory, streamReader8.getAuthRequestContext, streamReader8.lookAheadTest);
        if (z) {
            return new AnchorToken(PlaceComponentResult, mark, mark2);
        }
        return new AliasToken(PlaceComponentResult, mark, mark2);
    }

    private Object[] KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        StringBuilder sb = new StringBuilder();
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        Mark mark = new Mark(streamReader.MyBillsEntityDataFactory, streamReader.KClassImpl$Data$declaredNonStaticMembers$2, streamReader.PlaceComponentResult, streamReader.BuiltInFictitiousFunctionClassFactory, streamReader.getAuthRequestContext, streamReader.lookAheadTest);
        for (int i2 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory; i2 < i; i2++) {
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            if ((streamReader2.BuiltInFictitiousFunctionClassFactory() ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest] : 0) != 32) {
                break;
            }
            this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        }
        while (true) {
            String GetContactSyncConfig = GetContactSyncConfig();
            if (GetContactSyncConfig.length() == 0) {
                return new Object[]{sb.toString(), mark};
            }
            sb.append(GetContactSyncConfig);
            StreamReader streamReader3 = this.DatabaseTableConfigUtil;
            Mark mark2 = new Mark(streamReader3.MyBillsEntityDataFactory, streamReader3.KClassImpl$Data$declaredNonStaticMembers$2, streamReader3.PlaceComponentResult, streamReader3.BuiltInFictitiousFunctionClassFactory, streamReader3.getAuthRequestContext, streamReader3.lookAheadTest);
            for (int i3 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory; i3 < i; i3++) {
                StreamReader streamReader4 = this.DatabaseTableConfigUtil;
                if ((streamReader4.BuiltInFictitiousFunctionClassFactory() ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest] : 0) == 32) {
                    this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                }
            }
            mark = mark2;
        }
    }

    private String getAuthRequestContext(boolean z, Mark mark) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = 0;
            while (true) {
                Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
                StreamReader streamReader = this.DatabaseTableConfigUtil;
                if (!constant.KClassImpl$Data$declaredNonStaticMembers$2(streamReader.getAuthRequestContext(i) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + i] : 0, "'\"\\")) {
                    break;
                }
                i++;
            }
            if (i != 0) {
                sb.append(this.DatabaseTableConfigUtil.PlaceComponentResult(i));
            }
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            int i2 = streamReader2.BuiltInFictitiousFunctionClassFactory() ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest] : 0;
            if (!z && i2 == 39) {
                StreamReader streamReader3 = this.DatabaseTableConfigUtil;
                if ((streamReader3.getAuthRequestContext(1) ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest + 1] : 0) == 39) {
                    sb.append("'");
                    this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(2);
                }
            }
            if ((z && i2 == 39) || (!z && "\"\\".indexOf(i2) != -1)) {
                sb.appendCodePoint(i2);
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
            } else if (!z || i2 != 92) {
                break;
            } else {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                StreamReader streamReader4 = this.DatabaseTableConfigUtil;
                int i3 = streamReader4.BuiltInFictitiousFunctionClassFactory() ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest] : 0;
                if (!Character.isSupplementaryCodePoint(i3)) {
                    Map<Character, String> map = BuiltInFictitiousFunctionClassFactory;
                    char c = (char) i3;
                    if (map.containsKey(Character.valueOf(c))) {
                        sb.append(map.get(Character.valueOf(c)));
                        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                    }
                }
                if (!Character.isSupplementaryCodePoint(i3)) {
                    Map<Character, Integer> map2 = KClassImpl$Data$declaredNonStaticMembers$2;
                    char c2 = (char) i3;
                    if (map2.containsKey(Character.valueOf(c2))) {
                        int intValue = map2.get(Character.valueOf(c2)).intValue();
                        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                        String BuiltInFictitiousFunctionClassFactory2 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(intValue);
                        if (MyBillsEntityDataFactory.matcher(BuiltInFictitiousFunctionClassFactory2).find()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("expected escape sequence of ");
                            sb2.append(intValue);
                            sb2.append(" hexadecimal numbers, but found: ");
                            sb2.append(BuiltInFictitiousFunctionClassFactory2);
                            String obj = sb2.toString();
                            StreamReader streamReader5 = this.DatabaseTableConfigUtil;
                            throw new ScannerException("while scanning a double-quoted scalar", mark, obj, new Mark(streamReader5.MyBillsEntityDataFactory, streamReader5.KClassImpl$Data$declaredNonStaticMembers$2, streamReader5.PlaceComponentResult, streamReader5.BuiltInFictitiousFunctionClassFactory, streamReader5.getAuthRequestContext, streamReader5.lookAheadTest));
                        }
                        sb.append(new String(Character.toChars(Integer.parseInt(BuiltInFictitiousFunctionClassFactory2, 16))));
                        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(intValue);
                    }
                }
                if (GetContactSyncConfig().length() != 0) {
                    sb.append(getAuthRequestContext(mark));
                } else {
                    String valueOf = String.valueOf(Character.toChars(i3));
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("found unknown escape character ");
                    sb3.append(valueOf);
                    sb3.append("(");
                    sb3.append(i3);
                    sb3.append(")");
                    String obj2 = sb3.toString();
                    StreamReader streamReader6 = this.DatabaseTableConfigUtil;
                    throw new ScannerException("while scanning a double-quoted scalar", mark, obj2, new Mark(streamReader6.MyBillsEntityDataFactory, streamReader6.KClassImpl$Data$declaredNonStaticMembers$2, streamReader6.PlaceComponentResult, streamReader6.BuiltInFictitiousFunctionClassFactory, streamReader6.getAuthRequestContext, streamReader6.lookAheadTest));
                }
            }
        }
        return sb.toString();
    }

    private String getAuthRequestContext(Mark mark) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String BuiltInFictitiousFunctionClassFactory2 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(3);
            if ("---".equals(BuiltInFictitiousFunctionClassFactory2) || "...".equals(BuiltInFictitiousFunctionClassFactory2)) {
                Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
                StreamReader streamReader = this.DatabaseTableConfigUtil;
                if (constant.PlaceComponentResult(streamReader.getAuthRequestContext(3) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 3] : 0)) {
                    StreamReader streamReader2 = this.DatabaseTableConfigUtil;
                    throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest));
                }
            }
            while (true) {
                StreamReader streamReader3 = this.DatabaseTableConfigUtil;
                if (" \t".indexOf(streamReader3.BuiltInFictitiousFunctionClassFactory() ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest] : 0) == -1) {
                    break;
                }
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
            }
            String GetContactSyncConfig = GetContactSyncConfig();
            if (GetContactSyncConfig.length() != 0) {
                sb.append(GetContactSyncConfig);
            } else {
                return sb.toString();
            }
        }
    }

    private boolean PlaceComponentResult() {
        int i;
        int i2 = this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory;
        int i3 = 0;
        while (true) {
            StreamReader streamReader = this.DatabaseTableConfigUtil;
            int i4 = streamReader.getAuthRequestContext(i3) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + i3] : 0;
            if (i4 == 0 || !Constant.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i4)) {
                break;
            }
            i3++;
            if (!Constant.MyBillsEntityDataFactory.PlaceComponentResult(i4)) {
                if (i4 == 13) {
                    StreamReader streamReader2 = this.DatabaseTableConfigUtil;
                    int i5 = i3 + 1;
                    if ((streamReader2.getAuthRequestContext(i5) ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest + i5] : 0) == 10) {
                    }
                }
                if (i4 != 65279) {
                    i2++;
                }
            }
            i2 = 0;
        }
        StreamReader streamReader3 = this.DatabaseTableConfigUtil;
        if ((streamReader3.getAuthRequestContext(i3) ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest + i3] : 0) != 35) {
            StreamReader streamReader4 = this.DatabaseTableConfigUtil;
            int i6 = i3 + 1;
            if ((streamReader4.getAuthRequestContext(i6) ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest + i6] : 0) != 0 && ((i = this.scheduleImpl) != 0 || i2 >= this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                if (i == 0) {
                    int i7 = 1;
                    while (true) {
                        StreamReader streamReader5 = this.DatabaseTableConfigUtil;
                        int i8 = i3 + i7;
                        int i9 = streamReader5.getAuthRequestContext(i8) ? streamReader5.getAuthRequestContext[streamReader5.lookAheadTest + i8] : 0;
                        if (i9 == 0 || Constant.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i9)) {
                            break;
                        }
                        if (i9 == 58) {
                            Constant constant = Constant.KClassImpl$Data$declaredNonStaticMembers$2;
                            StreamReader streamReader6 = this.DatabaseTableConfigUtil;
                            int i10 = i8 + 1;
                            if (constant.PlaceComponentResult(streamReader6.getAuthRequestContext(i10) ? streamReader6.getAuthRequestContext[streamReader6.lookAheadTest + i10] : 0)) {
                                return true;
                            }
                        }
                        i7++;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private String getAuthRequestContext(String str, Mark mark) {
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        int i = streamReader.BuiltInFictitiousFunctionClassFactory() ? streamReader.getAuthRequestContext[streamReader.lookAheadTest] : 0;
        if (i != 33) {
            String valueOf = String.valueOf(Character.toChars(i));
            StringBuilder sb = new StringBuilder();
            sb.append("while scanning a ");
            sb.append(str);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("expected '!', but found ");
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(i);
            sb2.append(")");
            String obj2 = sb2.toString();
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            throw new ScannerException(obj, mark, obj2, new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest));
        }
        StreamReader streamReader3 = this.DatabaseTableConfigUtil;
        int i2 = 1;
        int i3 = streamReader3.getAuthRequestContext(1) ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest + 1] : 0;
        if (i3 != 32) {
            int i4 = 1;
            while (Constant.getAuthRequestContext.PlaceComponentResult(i3)) {
                i4++;
                StreamReader streamReader4 = this.DatabaseTableConfigUtil;
                i3 = streamReader4.getAuthRequestContext(i4) ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest + i4] : 0;
            }
            if (i3 != 33) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(i4);
                String valueOf2 = String.valueOf(Character.toChars(i3));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("while scanning a ");
                sb3.append(str);
                String obj3 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("expected '!', but found ");
                sb4.append(valueOf2);
                sb4.append("(");
                sb4.append(i3);
                sb4.append(")");
                String obj4 = sb4.toString();
                StreamReader streamReader5 = this.DatabaseTableConfigUtil;
                throw new ScannerException(obj3, mark, obj4, new Mark(streamReader5.MyBillsEntityDataFactory, streamReader5.KClassImpl$Data$declaredNonStaticMembers$2, streamReader5.PlaceComponentResult, streamReader5.BuiltInFictitiousFunctionClassFactory, streamReader5.getAuthRequestContext, streamReader5.lookAheadTest));
            }
            i2 = 1 + i4;
        }
        return this.DatabaseTableConfigUtil.PlaceComponentResult(i2);
    }

    private String KClassImpl$Data$declaredNonStaticMembers$2(String str, Mark mark) {
        StringBuilder sb = new StringBuilder();
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        int i = streamReader.getAuthRequestContext(0) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + 0] : 0;
        int i2 = 0;
        while (Constant.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(i)) {
            if (i == 37) {
                sb.append(this.DatabaseTableConfigUtil.PlaceComponentResult(i2));
                sb.append(BuiltInFictitiousFunctionClassFactory(str, mark));
                i2 = 0;
            } else {
                i2++;
            }
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            i = streamReader2.getAuthRequestContext(i2) ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest + i2] : 0;
        }
        if (i2 != 0) {
            sb.append(this.DatabaseTableConfigUtil.PlaceComponentResult(i2));
        }
        if (sb.length() == 0) {
            String valueOf = String.valueOf(Character.toChars(i));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("while scanning a ");
            sb2.append(str);
            String obj = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("expected URI, but found ");
            sb3.append(valueOf);
            sb3.append("(");
            sb3.append(i);
            sb3.append(")");
            String obj2 = sb3.toString();
            StreamReader streamReader3 = this.DatabaseTableConfigUtil;
            throw new ScannerException(obj, mark, obj2, new Mark(streamReader3.MyBillsEntityDataFactory, streamReader3.KClassImpl$Data$declaredNonStaticMembers$2, streamReader3.PlaceComponentResult, streamReader3.BuiltInFictitiousFunctionClassFactory, streamReader3.getAuthRequestContext, streamReader3.lookAheadTest));
        }
        return sb.toString();
    }

    private String BuiltInFictitiousFunctionClassFactory(String str, Mark mark) {
        int i = 1;
        while (true) {
            StreamReader streamReader = this.DatabaseTableConfigUtil;
            int i2 = i * 3;
            if ((streamReader.getAuthRequestContext(i2) ? streamReader.getAuthRequestContext[streamReader.lookAheadTest + i2] : 0) != 37) {
                break;
            }
            i++;
        }
        StreamReader streamReader2 = this.DatabaseTableConfigUtil;
        Mark mark2 = new Mark(streamReader2.MyBillsEntityDataFactory, streamReader2.KClassImpl$Data$declaredNonStaticMembers$2, streamReader2.PlaceComponentResult, streamReader2.BuiltInFictitiousFunctionClassFactory, streamReader2.getAuthRequestContext, streamReader2.lookAheadTest);
        ByteBuffer allocate = ByteBuffer.allocate(i);
        while (true) {
            StreamReader streamReader3 = this.DatabaseTableConfigUtil;
            if ((streamReader3.BuiltInFictitiousFunctionClassFactory() ? streamReader3.getAuthRequestContext[streamReader3.lookAheadTest] : 0) != 37) {
                ByteBuffer byteBuffer = (ByteBuffer) allocate.flip();
                try {
                    return UriEncoder.MyBillsEntityDataFactory(allocate);
                } catch (CharacterCodingException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("while scanning a ");
                    sb.append(str);
                    String obj = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("expected URI in UTF-8: ");
                    sb2.append(e.getMessage());
                    throw new ScannerException(obj, mark, sb2.toString(), mark2);
                }
            }
            this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
            try {
                allocate.put((byte) Integer.parseInt(this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(2), 16));
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(2);
            } catch (NumberFormatException unused) {
                StreamReader streamReader4 = this.DatabaseTableConfigUtil;
                int i3 = streamReader4.BuiltInFictitiousFunctionClassFactory() ? streamReader4.getAuthRequestContext[streamReader4.lookAheadTest] : 0;
                String valueOf = String.valueOf(Character.toChars(i3));
                StreamReader streamReader5 = this.DatabaseTableConfigUtil;
                int i4 = streamReader5.getAuthRequestContext(1) ? streamReader5.getAuthRequestContext[streamReader5.lookAheadTest + 1] : 0;
                String valueOf2 = String.valueOf(Character.toChars(i4));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("while scanning a ");
                sb3.append(str);
                String obj2 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("expected URI escape sequence of 2 hexadecimal numbers, but found ");
                sb4.append(valueOf);
                sb4.append("(");
                sb4.append(i3);
                sb4.append(") and ");
                sb4.append(valueOf2);
                sb4.append("(");
                sb4.append(i4);
                sb4.append(")");
                String obj3 = sb4.toString();
                StreamReader streamReader6 = this.DatabaseTableConfigUtil;
                throw new ScannerException(obj2, mark, obj3, new Mark(streamReader6.MyBillsEntityDataFactory, streamReader6.KClassImpl$Data$declaredNonStaticMembers$2, streamReader6.PlaceComponentResult, streamReader6.BuiltInFictitiousFunctionClassFactory, streamReader6.getAuthRequestContext, streamReader6.lookAheadTest));
            }
        }
    }

    private String GetContactSyncConfig() {
        StreamReader streamReader = this.DatabaseTableConfigUtil;
        int i = streamReader.BuiltInFictitiousFunctionClassFactory() ? streamReader.getAuthRequestContext[streamReader.lookAheadTest] : 0;
        if (i != 13 && i != 10 && i != 133) {
            if (i == 8232 || i == 8233) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
                return String.valueOf(Character.toChars(i));
            }
            return "";
        }
        if (i == 13) {
            StreamReader streamReader2 = this.DatabaseTableConfigUtil;
            if (10 == (streamReader2.getAuthRequestContext(1) ? streamReader2.getAuthRequestContext[streamReader2.lookAheadTest + 1] : 0)) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(2);
                return "\n";
            }
        }
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1);
        return "\n";
    }

    private List<Token> MyBillsEntityDataFactory(Token... tokenArr) {
        ArrayList arrayList = new ArrayList();
        for (Token token : tokenArr) {
            if (token != null && (this.GetContactSyncConfig || !(token instanceof CommentToken))) {
                arrayList.add(token);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Chomping {
        private final Boolean BuiltInFictitiousFunctionClassFactory;
        final int getAuthRequestContext;

        public Chomping(Boolean bool, int i) {
            this.BuiltInFictitiousFunctionClassFactory = bool;
            this.getAuthRequestContext = i;
        }

        public final boolean MyBillsEntityDataFactory() {
            Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
            return bool == null || bool.booleanValue();
        }

        public final boolean getAuthRequestContext() {
            Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
            return bool != null && bool.booleanValue();
        }
    }
}
