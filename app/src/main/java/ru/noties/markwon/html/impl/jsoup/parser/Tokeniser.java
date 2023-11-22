package ru.noties.markwon.html.impl.jsoup.parser;

import com.alibaba.wireless.security.SecExceptionCode;
import id.dana.cashier.view.InputCardNumberView;
import java.util.Arrays;
import kotlin.text.Typography;
import ru.noties.markwon.html.impl.jsoup.helper.Validate;
import ru.noties.markwon.html.impl.jsoup.nodes.CommonMarkEntities;
import ru.noties.markwon.html.impl.jsoup.parser.Token;

/* loaded from: classes6.dex */
public final class Tokeniser {
    static final int[] PlaceComponentResult;
    private static final char[] PrepareContext;
    String GetContactSyncConfig;
    Token.Tag NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final ParseErrorList NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final CharacterReader initRecordTimeStamp;
    public Token scheduleImpl;
    public TokeniserState NetworkUserEntityData$$ExternalSyntheticLambda2 = TokeniserState.Data;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    public String KClassImpl$Data$declaredNonStaticMembers$2 = null;
    public StringBuilder BuiltInFictitiousFunctionClassFactory = new StringBuilder(1024);
    StringBuilder moveToNextValue = new StringBuilder(1024);
    Token.StartTag DatabaseTableConfigUtil = new Token.StartTag();
    Token.EndTag lookAheadTest = new Token.EndTag();
    public Token.Character MyBillsEntityDataFactory = new Token.Character();
    Token.Doctype getErrorConfigVersion = new Token.Doctype();
    Token.Comment getAuthRequestContext = new Token.Comment();
    private final int[] isLayoutRequested = new int[1];
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda7 = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', InputCardNumberView.DIVIDER, Typography.less, Typography.amp};
        PrepareContext = cArr;
        PlaceComponentResult = new int[]{8364, 129, 8218, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.initRecordTimeStamp = characterReader;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parseErrorList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(Token token) {
        Validate.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, "There is an unread token pending!");
        this.scheduleImpl = token;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        if (token.BuiltInFictitiousFunctionClassFactory == Token.TokenType.StartTag) {
            this.GetContactSyncConfig = ((Token.StartTag) token).NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else if (token.BuiltInFictitiousFunctionClassFactory == Token.TokenType.EndTag && ((Token.EndTag) token).PlaceComponentResult != null && this.NetworkUserEntityData$$ExternalSyntheticLambda8.canAddError()) {
            ParseErrorList parseErrorList = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            CharacterReader characterReader = this.initRecordTimeStamp;
            parseErrorList.add(new ParseError(characterReader.getAuthRequestContext + characterReader.MyBillsEntityDataFactory, "Attributes incorrectly present on end tag"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(String str) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.length() == 0) {
            this.BuiltInFictitiousFunctionClassFactory.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        this.BuiltInFictitiousFunctionClassFactory.append(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] getAuthRequestContext(Character ch, boolean z) {
        int i;
        if (this.initRecordTimeStamp.scheduleImpl()) {
            return null;
        }
        if ((ch == null || ch.charValue() != this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0()) && !this.initRecordTimeStamp.getAuthRequestContext(PrepareContext)) {
            int[] iArr = this.isLayoutRequested;
            CharacterReader characterReader = this.initRecordTimeStamp;
            characterReader.BuiltInFictitiousFunctionClassFactory = characterReader.MyBillsEntityDataFactory;
            if (this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2("#")) {
                boolean BuiltInFictitiousFunctionClassFactory = this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory("X");
                CharacterReader characterReader2 = this.initRecordTimeStamp;
                String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory ? characterReader2.BuiltInFictitiousFunctionClassFactory() : characterReader2.PlaceComponentResult();
                if (BuiltInFictitiousFunctionClassFactory2.length() == 0) {
                    getAuthRequestContext("numeric reference with no numerals");
                    CharacterReader characterReader3 = this.initRecordTimeStamp;
                    characterReader3.MyBillsEntityDataFactory = characterReader3.BuiltInFictitiousFunctionClassFactory;
                    return null;
                }
                if (!this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(";")) {
                    getAuthRequestContext("missing semicolon");
                }
                try {
                    i = Integer.valueOf(BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i = -1;
                }
                if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                    getAuthRequestContext("character outside of valid range");
                    iArr[0] = 65533;
                    return iArr;
                }
                if (i >= 128) {
                    int[] iArr2 = PlaceComponentResult;
                    if (i < iArr2.length + 128) {
                        getAuthRequestContext("character is not a valid unicode code point");
                        i = iArr2[i - 128];
                    }
                }
                iArr[0] = i;
                return iArr;
            }
            String errorConfigVersion = this.initRecordTimeStamp.getErrorConfigVersion();
            boolean PlaceComponentResult2 = this.initRecordTimeStamp.PlaceComponentResult(';');
            if (!(CommonMarkEntities.BuiltInFictitiousFunctionClassFactory(errorConfigVersion) && PlaceComponentResult2)) {
                CharacterReader characterReader4 = this.initRecordTimeStamp;
                characterReader4.MyBillsEntityDataFactory = characterReader4.BuiltInFictitiousFunctionClassFactory;
                if (PlaceComponentResult2) {
                    getAuthRequestContext(String.format("invalid named referenece '%s'", errorConfigVersion));
                }
                return null;
            } else if (z && (this.initRecordTimeStamp.GetContactSyncConfig() || this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda1() || this.initRecordTimeStamp.PlaceComponentResult('=', '-', '_'))) {
                CharacterReader characterReader5 = this.initRecordTimeStamp;
                characterReader5.MyBillsEntityDataFactory = characterReader5.BuiltInFictitiousFunctionClassFactory;
                return null;
            } else {
                if (!this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(";")) {
                    getAuthRequestContext("missing semicolon");
                }
                int MyBillsEntityDataFactory = CommonMarkEntities.MyBillsEntityDataFactory(errorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                if (MyBillsEntityDataFactory == 1) {
                    iArr[0] = this.NetworkUserEntityData$$ExternalSyntheticLambda7[0];
                    return iArr;
                } else if (MyBillsEntityDataFactory == 2) {
                    return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected characters returned for ");
                    sb.append(errorConfigVersion);
                    Validate.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                    return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        if (this.GetContactSyncConfig != null) {
            Token.Tag tag = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str = tag.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Validate.BuiltInFictitiousFunctionClassFactory(str == null || str.length() == 0);
            if (tag.NetworkUserEntityData$$ExternalSyntheticLambda0.equalsIgnoreCase(this.GetContactSyncConfig)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(TokeniserState tokeniserState) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.canAddError()) {
            ParseErrorList parseErrorList = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            CharacterReader characterReader = this.initRecordTimeStamp;
            parseErrorList.add(new ParseError(characterReader.getAuthRequestContext + characterReader.MyBillsEntityDataFactory, "Unexpected character '%s' in input state [%s]", Character.valueOf(this.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0()), tokeniserState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(TokeniserState tokeniserState) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.canAddError()) {
            ParseErrorList parseErrorList = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            CharacterReader characterReader = this.initRecordTimeStamp;
            parseErrorList.add(new ParseError(characterReader.getAuthRequestContext + characterReader.MyBillsEntityDataFactory, "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    private void getAuthRequestContext(String str) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.canAddError()) {
            ParseErrorList parseErrorList = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            CharacterReader characterReader = this.initRecordTimeStamp;
            parseErrorList.add(new ParseError(characterReader.getAuthRequestContext + characterReader.MyBillsEntityDataFactory, "Invalid character reference: %s", str));
        }
    }
}
