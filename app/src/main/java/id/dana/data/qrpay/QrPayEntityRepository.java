package id.dana.data.qrpay;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alipay.iap.android.f2fpay.otp.OtpInitResult;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.base.AuthenticatedEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.offlinepay.source.PaymentModelMapper;
import id.dana.data.qrpay.source.QrPayEntityData;
import id.dana.data.qrpay.source.QrPayEntityDataFactory;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.domain.qrpay.QrPayRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import o.resetSizeCounter;

@Singleton
/* loaded from: classes2.dex */
public class QrPayEntityRepository implements QrPayRepository {
    public static final byte[] BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    public static final int PlaceComponentResult;
    private static final int QR_REFRESH_TIME = 60;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PaymentModelMapper paymentModelMapper;
    private final QrPayEntityDataFactory qrPayEntityDataFactory;
    private final SecurityEntityDataFactory securityEntityDataFactory;

    static {
        byte[] bArr = new byte[6834];
        System.arraycopy("m©i³ó\u0011çÉ:ñ\tõÃ\u0017\u001füõþö\u0007ã\u001dé\u000fíÜ/çþ\u0007\u0000ñ\u0002ûó\u0011çÉ:ñ\tõÃ\u0017!òý\u000fÓ\"û×\u0013Ø)\u0002õò\u000bÎ/çþ\u0007\u0000ñ\u0002û\u0000÷ý\u0001öý\u0002õ\u0007üñ\u0007úóý\u0003ôý\u0004óý\u0005ò\u0003\u0002ï\u0003\u0002ï\u0007ýðý\u0006ñ\u0002ÿóý\u0007ðý\bï\u0007þï\u0006ûó\u0001ûø\u0001ü÷\u0004ýó\u0007ñ\bôø\u0006ò\bõ÷\u0007ö÷\u0004\u0001ï\u0002üöý\u0000ûø\u0003\u0002ï\u0003\u0001ðý\u0000ü÷ý\u0000ýöý\u0002õý\u0000þõ\bööý\u0003ôý\u0004ó\u0007ùôý\u0000ÿô\bðý\u0005ò\u0002\u0000òý\u0007ðý\u0000þõý\u0000\u0000ó\b÷õ\u0003þó\bøô\u0003þó\u0001ûø\u0006ûó\u0004ýó\bùó\búò\bûñ\büð\u0001ü÷\u0007ñ\bð\u0003þó\u0004ýó\u0002\u0000ò\býï\u0003þó\u0006ûó\u0006ýñ\u0005ýò\u0007÷ö\tóøý\u0000\u0001ò\u0002þôý\u0000\u0002ñý\u0000\u0003ðý\u0000\u0004ï\u0002öý\u0001úøý\u0000þ\u0000÷\u0002ö\u0007ùô\u0001ûý÷\bðý\u0001ö\u0006÷÷ý\u0002õý\u0003ô\u0003\u0002ï\u0001\u0001üòý\u0004óý\u0005ò\u0002üÿóý\u0002õý\u0006ñ\u0002ü\u0000ò\u0002ü\u0001ñ\bð\u0003þó\u0004ýó\u0002\u0000ò\u0001\u0000\u0000ï\tóøý\u0007ð\u0003\u0002ï\u0003\u0001ðý\bïý\u0000ûøý\u0000ü÷ý\u0000ýöý\u0006ñ\u0006øö\u0001ý\u0000ò\u0001ü÷\u0002ü\u0002ð\u0007õø\u0001þùø\u0001ü\u0002ñ\u0002ü\u0003ï\u0002ýùø\u0001ü÷\tï\u0002ýú÷\u0003ÿò\u0003\u0000ñ\u0003\u0001ðý\u0007ð\u0003\u0002ï\u0003\u0001ðý\u0000þõý\u0000ÿôý\u0000\u0000óý\u0000ýö\u0002\u0003ïý\u0000\u0001ò\u0007üñ\u0002ú\u0003ñý\u0000\u0002ñý\u0000\u0003ð\u0002\u0003ïý\u0000\u0001ò\u0007üñ\u0001\u0003÷õý\u0000\u0002ñý\u0000\u0003ð\u0002\u0000òý\u0000\u0004ïý\u0000ýö\u0002öý\u0001ö\u0002ÿóý\u0000\u0004\u0000÷\u0002ö\u0003ùøý\u0001öý\u0002õý\u0003ô\u0002\u0003ïý\u0004óý\u0005òý\u0006ñ\u0002ýûöý\u0007ðý\u0003ôý\bï\u0002ýüõ\u0003þó\bøô\tõö\u0001üýö\u0001üþõ\u0002\u0000ò\u0001üþõ\bøô\u0003\u0000ñ\u0003\u0001ðý\u0000ûø\u0002þôý\u0000ü÷ý\u0000ýöý\u0000þõ\u0002öý\u0001öý\u0003ô\u0001üÿô\u0007ýðý\u0000ÿô\u0002ýýôý\u0007ðý\u0000þõý\u0000\u0000ó\u0002ú\u0000ô\u0006ûó\u0005ó\u0001ü÷\u0001ÿô\u0004ýó\u0007ñ\u0002ýþó\u0001þýô\u0001\u0004ï\u0003\u0000ñ\u0003\u0001ðý\u0000\u0001ò\u0003\u0002ï\u0003\u0001ðý\u0000\u0002ñý\u0000\u0003ðý\u0000\u0004\u0000÷\u0006øöý\u0001öý\u0002õ\u0004øø\bðý\u0003ôý\u0004ó\u0006ùõ\u0006úô\u0006ûó\u0001ûø\u0006üò\bð\u0006ýñ\u0006þð\u0001ü÷\u0007ñ\u0006ÿï\u0005ýò\u0007õø\bð\u0007ö÷\u0007÷ö\u0007øõ\u0003\u0001ðý\u0005ò\u0002þôý\u0006ñý\u0007ðý\bï\u0002ö\u0007ùôý\u0000ûø\bðý\u0000ü÷ý\u0000ýöý\u0000ýö\u0002öý\u0000ü÷ý\u0000ýö\u0007úóý\u0000þõý\u0000ÿô\u0007ûòý\u0001\u0000÷ý\u0001öý\u0002õý\u0001öý\u0003ô\u0004úö\u0004ûõ\u0004üô\u0004ýó\u0004þò\u0004ÿñ\bð\u0004\u0000ð\u0004\u0001ï\u0003\u0000ñ\u0003\u0001ðý\u0004ó\u0002þôý\u0005òý\u0006ñý\u0007ðý\bï\u0005÷ø\u0005ø÷\u0005ùö\u0005úõ\u0005ûô\u0005üó\bð\u0005ýò\u0004\u0001ï\u0003\u0000ñ\u0003\u0001ðý\u0000ûø\u0002þôý\u0000ü÷ý\u0000ýöý\u0000þõý\u0007ð\u0003\u0002ï\u0003\u0002ï\u0003\u0001ð\bðý\u0000ÿô\u0005ÿðý\u0000\u0000ó\u0002öý\u0000\u0001òý\u0001ö\u0002ö\u0005\u0000ï\u0006öøý\u0000\u0001ò\u0002\u0003ïý\u0000\u0002ñý\u0000\u0003ðý\u0000\u0004ïý\u0001úø\u0006÷÷ý\u0000\u0000\u0000÷ý\u0001öý\u0002õ\u0002ú\u0001ó\u0004ûõ\u0001ü÷\u0001ÿô\u0005üó\u0001\u0001øö\u0004ÿñ\u0006ÿï\u0002ú\u0002ò\u0007ñ\u0001þùø\u0001\u0000\u0000ï\tóøý\u0003ô\u0003\u0002ï\u0003\u0001ðý\u0004óý\u0005òý\u0006ñý\u0006ñý\u0001ö\u0002öý\u0007ðý\u0002õ\u0002ú\u0003ñ\u0005ø÷\u0001ûø\u0001ü÷\u0005üó\bôø\u0001ü÷\u0001ýö\bð\u0005ó\u0001ü÷\u0001ü÷\u0006ÿï\u0002\u0000ò\u0002ú\u0004ð\u0004ÿñ\u0001þùø\u0001\u0004úñ\u0002üöý\u0003ô\u0003\u0002ï\u0003\u0001ðý\bïý\u0000ûøý\u0000ü÷\u0001üÿô\u0007ýðý\u0000ýö\u0002\u0003ïý\u0000þõ\u0002ú\u0005ïý\u0000ÿôý\u0000\u0000óý\u0000üó\u0011çÉ:ñ\tõÃ\u0017!\u0002íþú\tó\u0011çÉ:ñ\tõÃ\u0011%ñ\u000eüÌ\u001a\u000eýÍ/çþ\u0007\u0000ñ\u0002ûó\u0011çÉ:ñ\tõÃ\u001c#óüà\u001bö\u0001\u0002í\tÏ/çþ\u0007\u0000ñ\u0002û\u0000÷\u0002\u0003ïý\u0001ö\u0002û\u0003ðý\u0002õý\u0003ô\u0002öý\u0004óý\u0005ò\u0002û\u0004ï\u0005ó\u0001ü÷\u0001ü÷\bð\u0004ýó\búò\u0006ûó\u0001ü÷\u0007ñ\u0006ÿï\u0002\u0000ò\u0001\u0004úñ\u0003\u0000ñ\u0003\u0001ðý\u0006ñ\u0003\u0002ï\u0003\u0001ðý\u0007ðý\bïý\u0000ûøý\u0005ò\u0002üúø\bøô\u0002üû÷\u0001ûø\u0001ü÷\u0005üó\bð\u0002üüö\u0002üýõ\tøó\u0002úÿõ\u0007ñ\u0001\u0002üñ\u0001\u0000ó\u0001ü\u0002ñ\u0007÷ö\u0002\u0000ò\u0003ÿò\u0003\u0000ñ\u0003\u0001ðý\u0006ñ\u0002þôý\u0000ü÷ý\u0000ýöý\u0000þõý\u0000þõ\u0002\u0000òý\u0000ÿô\u0002\u0003ïý\u0001ö\u0007üñ\u0002üþôý\u0002õý\u0003ôý\u0000\u0000ó\u0002ÿóý\u0000ÿôý\u0000\u0000ó\u0001üÿô\u0003\u0001ð\bðý\u0000\u0001òý\u0000\u0002\u0000÷\u0002\u0003ïý\u0001öý\u0002õ\u0001\u0000÷øý\u0003ôý\u0004óý\u0005òý\u0005ò\u0007üñý\u0006ñý\u0007ðý\bï\u0001\u0003ùó\u0006ûó\u0005ó\u0004üô\u0005üó\bð\u0001ý\u0003ï\u0001û\u0002ò\u0004ýó\u0005ýò\u0001ý\u0003ï\u0007ñ\bð\u0007ö÷\u0007÷ö\tóøý\u0000ûø\u0003\u0002ï\u0003\u0001ðý\u0000ü÷ý\u0000ýöý\u0000þõ\u0002\u0003ïý\u0001öý\u0002õ\u0001\u0000÷øý\u0003ô\u0007ùôý\u0000ÿô\bðý\u0004ó\u0002\u0000òý\u0000\u0000ó\u0003\u0002ï\u0002þô\bðý\u0000\u0001òý\u0000\u0002ñý\u0000\u0003ð\u0001\u0003úò\u0001ûø\u0005ó\u0001ü÷\u0004ýó\u0007ñ\bð\u0001ü\u0004ï\u0004\u0000ð\tï\bð\u0001\u0003ûñ\u0001\u0000ýò\u0001\u0003ôø\u0007ñ\bð\u0001þ\u0000ñ\tóøý\u0000\u0004ï\u0002þôý\u0001úøý\u0001û÷ý\u0001üö\u0002ÿóý\u0000\u0000óý\u0005òý\bï\u0001\u0003üð\u0005ó\u0004üô\u0004ýó\u0004þò\u0001\u0003ýï\u0004\u0000ð\bøô\u0001ûø\u0001ü÷\tï\bð\u0001ý\u0001ñ\u0003ÿò\u0003\u0000ñ\u0003\u0001ðý\u0000ûø\u0002þôý\u0001ýõý\u0001þôý\u0001ÿóý\u0000þõ\u0001ÿ\u0001ï\u0007üñý\u0001\u0000ò\u0001\u0000ûô\u0001\u0000÷øý\u0001\u0001ñ\u0002öý\u0001\u0002ðý\u0001ÿùøù\u0007\u0000÷ý\u0001ö\u0002ö\u0003ùøý\u0002õý\u0001ö\u0002ÿóý\u0003ôý\u0004ó\u0001\u0000ø÷\u0006ûó\töõ\u0004ÿñ\u0001ýû÷\u0004ýó\u0001û\u0002ò\u0007ö÷\u0007÷ö\bøô\u0002üöý\u0005ò\u0002þôý\u0006ñý\u0007ðý\bï\u0002\u0000òý\u0000ûøý\u0000ü÷\u0002\u0003ïý\u0000ýöý\u0000þõ\u0001ÿÿñý\u0000ÿô\u0001ÿ\u0000ð\u0001\u0000ùö\u0006öøý\u0000\u0000óý\u0000\u0001ò\u0001üÿô\u0003\u0001ð\bðý\u0000\u0002ñ\u0002\u0000òý\u0003ô\u0001ÿ\u0001ïý\u0000\u0003ð\u0001\u0000úõ\u0001\u0000÷øý\u0000\u0004ïý\u0001úøý\u0001û÷ý\u0001öý\u0001ö\u0002\u0003ïý\u0000ýöý\u0000þõ\u0001\u0000ûô\u0002\u0003ïý\u0000ÿô\u0001ÿ\u0000ðý\u0000\u0000óý\u0004ó\u0001\u0000üó\u0001\u0000ýò\u0002\u0000ò\u0003ýô\u0001þõ\u0001\u0000þñ\bôø\u0001ü÷\u0001\u0000ÿð\u0001ý\u0003ï\u0001û\u0002ò\u0001\u0000ó\u0001\u0000\u0000ï\tóøý\u0005ò\u0002þôý\u0001üöý\u0001ýõý\u0001þô\u0002ÿóý\u0000ûø\u0002öý\u0002\u0000÷ý\u0001öý\u0002õý\u0003ô\u0001\u0004óø\u0003þó\u0006ûó\u0004ýó\bùó\u0001û\u0002ò\u0005ýò\u0006ýñ\u0003þó\u0001ü\u0003ð\u0001ÿô\u0007ö÷\u0001\u0004ô÷\bð\u0005ýò\u0004\u0001ï\u0002üöý\u0004ó\u0002þôý\u0005òý\u0006ñý\u0007ðý\bï\u0001\u0004õö\u0001\u0002õø\u0002\u0000ò\u0001ü\u0002ñ\u0001û\u0002ò\u0003þó\u0006ûó\bùó\u0005üó\bôø\u0006ò\u0005ýò\u0003ÿò\u0002üöý\u0000ûø\u0002þôý\u0000ü÷ý\u0000ýöý\u0000þõý\u0002õ\u0002öý\u0000ÿôý\u0007ðý\u0000\u0000óý\u0000\u0001ò\u0001\u0000÷øý\u0000\u0002ñý\u0000\u0003ð\u0001\u0004öõ\u0001\u0004÷ôý\u0000\u0004ï\u0001\u0004øó\u0007üñý\u0001úøý\u0001û÷ý\bï\u0001\u0004ùò\u0004ÿñ\bð\u0001\u0000ó\u0001\u0004úñ\u0002üöý\u0000ûø\u0003\u0002ï\u0003\u0001ðý\u0001üöý\u0001ýõý\u0000\u0000ó\u0002\u0003ïý\u0001þô\u0001\u0004øóý\u0001ÿóý\u0001\u0000òý\u0001\u0001ñ\u0001\u0004ûðý\u0001\u0002ðý\u0001\u0003ïý\u0002ùø\u0001\u0004üïý\u0002ú÷ý\u0003ô\u0002úüø\u0007÷ö\bøô\u0003\u0000ñ\u0003\u0001ðý\u0004ó\u0003\u0002ï\u0003\u0001ðý\u0002ûöý\u0002üõý\u0002ýô\u0002ÿóý\u0002þó\u0002\u0000òý\u0002þó\u0004øø\bðý\u0002ÿò\u0002öý\u0000ÿô\u0002úý÷\u0007üñý\u0001\u0002ð\u0007ùô\u0001ûý÷\bðý\u0001\u0003ïý\u0000þõ\u0001\u0000÷øý\u0002\u0000ñý\u0002\u0001ðý\u0002\u0002ïý\u0003øøý\bï\u0002úþö\u0002úÿõ\u0007ñ\u0001\u0002üñ\u0007ö÷\u0007÷ö\bøô\u0002üöý\u0000ûø\u0003\u0002ï\u0003\u0001ðý\u0003ù÷ý\u0003úöý\u0002ùøý\u0002õ\u0002ú\u0000ôý\u0002ú\u0000÷\u0001û\u0000ôý\u0001öý\u0002õ\u0002\u0003ï\u0001ÿ\u0000ðý\u0003ôý\u0004óý\u0005òý\u0006ñ\u0007ùôý\u0007ð\bðý\bïý\u0000ûø\u0002þûõ\u0001ü\u0001ò\u0001ü\u0002ñ\u0007ñ\bð\u0001ü÷\u0002þüô\u0003\u0001ðý\u0000ü÷\u0002þôý\u0000ýöý\u0000þõý\u0000ÿôý\u0000ûø\u0002ú\u0003ñ\u0003þó\u0002þýó\u0001ü÷\u0001û\u0002ò\u0001ýýõ\u0001\u0001úô\u0006þð\u0001ûø\u0001\u0000þñ\bð\tï\u0001ûø\u0006ò\u0002þþò\u0001\u0002õø\u0002\u0000ò\u0003ýô\u0002þÿñ\u0003ÿò\u0002üöý\u0000ü÷\u0003\u0002ï\u0003\u0001ðý\u0000\u0000óý\u0000\u0001òý\u0000\u0002ñ\u0001üûøý\u0001öý\u0000\u0003ð\u0001\u0000ûô\u0002þ\u0000ðý\u0000\u0004ïý\u0001úøý\u0000ûø\u0002þ\u0001ï\u0001ûø\u0001ü÷\u0001ü÷\u0005úõ\u0001ýû÷\u0003þó\u0006ûó\u0003þó\u0001ü\u0001ò\u0001\u0001úô\u0003þó\u0001ü÷\u0001üþõ\bøô\u0003\u0000ñ\u0003\u0001ðý\u0000ü÷\u0002þôý\u0001û÷ý\u0001üöý\u0001ýõ\u0002\u0003ï\u0001ÿ\u0000ðý\u0003ôý\u0004óý\u0005òý\u0006ñý\bïý\u0002õ\u0002öý\u0001þô\u0001üÿô\u0003\u0001ð\bðý\u0001ÿó\u0002ÿóý\u0001\u0000òý\u0000\u0002ñý\u0002õ\u0002\u0000òý\u0001\u0000òý\u0002õý\u0001\u0001ñý\u0001\u0002ð\u0001ÿ\u0001ï\u0002\u0003ï\u0007üñý\u0001\u0003ïý\u0002ùøý\u0002ú÷\u0002ö\u0007ùôý\u0007ð\bðý\u0001þï\b\u0000ð\u0005ïå\u001dûÜ#óüó\u0011çÉ:ñ\tõÃ\u0010)üùõø\t\u0000÷\u0002\u0003ïý\u0001öý\u0002õý\u0003ôý\u0004ó\u0003\u0002ï\u0003\u0002ï\u0003\u0001ð\bðý\u0005ò\u0002ÿóý\u0006ñý\u0007ðý\bï\u0002ö\u0007ùô\u0001þú÷ý\u0000ûøý\u0000ü÷ý\u0000ýöý\u0000þõ\u0001þûö\u0001þüõ\tøó\u0003þó\u0006ûó\u0001ü÷\u0001þýô\u0002\u0000ò\u0001ü\u0002ñ\u0007÷ö\u0002\u0000ò\u0006þð\u0005ýò\u0002\u0000ò\u0003ýô\u0001þþó\tóøý\u0000ÿô\u0003\u0002ï\u0003\u0001ðý\u0000\u0000óý\u0000\u0001òý\u0000\u0002ñý\u0000\u0003ðý\bïý\u0000þõ\u0001þÿò\u0002\u0000ò\u0003ýô\bð\u0001þ\u0000ñ\u0007øõ\u0003\u0001ðý\u0000ÿô\u0002þôý\u0000\u0004ïý\u0001úøý\u0000\u0003ðý\bï\u0002öý\u0000ûø\u0002\u0000òý\u0006ó\u0011çÉ:ñ\tõÃ!\u001dúó\u0001õ\u0000÷ý\u0001ö\u0001ÿÿñý\u0002õý\u0003ôý\u0004óý\u0005òý\u0006ñ\u0001\u0001ýñ\u0005ø÷\u0001\u0001þð\u0001û\u0002ò\tï\bùó\u0004ýó\u0005ýò\u0007ñ\u0001þõ\u0001ü÷\u0001\u0001ÿï\u0002\u0000ò\u0001ü\u0002ñ\u0003þó\u0006ûó\u0001\u0002õø\u0002\u0000ò\u0001\u0001úô\u0003þó\u0001ü÷\u0001üþõ\u0007øõ\u0003\u0001ðý\u0007ð\u0003\u0002ï\u0003\u0001ðý\bïý\u0000ûøý\u0000ü÷\u0001ÿ\u0001ï\u0007üñ\u0001\u0000÷øý\u0000ýö\u0001\u0000ûôý\u0000þõý\u0000ÿôý\u0000ü÷ý\u0004ó\u0001\u0002ö÷ý\u0000\u0000óý\u0000\u0001òý\u0000\u0002ñý\u0000\u0003ðý\u0004ó\u0002öý\u0000\u0004ï\u0001\u0002÷öý\u0001úø\u0007ùôý\u0001û÷\bðý\u0001üöý\u0001ýõ\u0001\u0002øõ\u0006ûó\u0001ûø\u0001ü÷\u0006ýñ\tï\u0001\u0001þð\u0005ýò\u0004þò\u0001ûø\u0004üô\u0004ýó\u0002\u0000ò\u0001ü\u0002ñ\u0007÷ö\u0007øõ\u0003\u0001ðý\u0001þô\u0003\u0002ï\u0003\u0001ðý\u0001ÿóý\u0001\u0000òý\u0001\u0001ñ\u0002\u0000òý\u0001\u0002ð\u0002ÿóý\u0001\u0002ð\u0004øø\bðý\u0001\u0003ï\u0001\u0002÷öý\u0001úøý\u0001üó\u0011çÉ:ñ\tõÃ#\u0015\u0001þ÷üûÿþíûç\u001dñ\të\u000fñ\u0002ûÓ/çþ\u0007\u0000ñ\u0002û\u0000÷ý\u0001öý\u0002õ\u0002\u0000òý\u0003ô\u0002\u0003ïý\u0004óý\u0005ò\u0007ùô\u0001ûý÷\bðý\u0006ñý\u0001öý\u0001ö\u0002ÿóý\u0003ô\u0002öý\u0007ðý\bï\u0002ÿûô\u0002þýó\töõ\u0004ÿñ\t÷ô\u0007ñ\u0002ÿüó\u0002ÿýò\bøô\u0003\u0000ñ\u0003\u0001ðý\u0000ûø\u0002þôý\u0000ü÷ý\u0000ýöý\u0000þõ\u0002\u0003ïý\u0004óý\u0005òý\u0006ñ\u0004øø\bðý\u0000ÿç\u0007\u0005ìæ\u0013\u0001\u0002Þ\u0007\u0007\u0005ì\u0000÷ý\u0001öý\u0002õý\u0003ô\u0002ûûø\u0005ø÷\u0001ü÷\u0001þýô\u0005ýò\u0002ûü÷\u0001\u0001øö\u0004ýó\bùó\u0001û\u0002ò\u0005ýò\u0004ýó\u0003þó\u0006ûó\u0001ü\u0001ò\u0003ýô\bð\u0001ü÷\u0003ÿò\u0003\u0000ñ\u0003\u0001ðý\u0004ó\u0003\u0002ï\u0003\u0001ðý\u0005òý\u0006ñý\u0007ðý\bïý\u0000ûøý\u0000ü÷ý\u0002õ\u0002ÿóý\u0000ýö\u0002\u0000òý\u0000ýö\u0003\u0002ï\u0003\u0002ï\u0003\u0001ð\bðý\u0000þõý\u0000ÿô\u0002ûýö\u0006ûó\u0001\u0003ýï\u0006ûó\u0001ûø\u0004üô\u0004ýó\u0002\u0000ò\u0002ûþõ\túñ\bð\u0001üþõ\u0002\u0000ò\u0003ÿò\u0002üöý\u0000\u0000ó\u0003\u0002ï\u0003\u0001ðý\u0000\u0001òý\u0000\u0002ñý\u0001ö\u0002\u0003ïý\u0000\u0003ð\u0002ûÿôý\u0000\u0004ïý\u0001úø\u0002öý\u0001û÷\u0002\u0003ïý\u0000\u0003ð\u0002ú\u0005ïý\u0000\u0004ïý\u0001úøý\u0001üúÿìó\u0011çÉ:ñ\tõÃ\u001c#ôñÿ\tÐ%ÿ÷ð\u000fÍ/çþ\u0007\u0000ñ\u0002ûó\u0011çÉ:ñ\tõÃ \u001fõ\u0002ñ\u0000ôÜ/çþ\u0007\u0000ñ\u0002û\u0000÷\u0001ûÿõý\u0001öý\u0002õ\u0001ÿ\u0001ï\u0007üñ\u0001\u0000÷øý\u0003ôý\u0004ó\u0002öý\u0005òý\u0002õ\u0001\u0002ö÷ý\u0006ñý\u0007ðý\bïý\u0000ûøý\u0000ü÷ý\u0000ýö\u0002ýÿò\u0006þð\bùó\u0001\u0001ÿï\u0001\u0003ð\u0007õø\bð\u0004ýó\u0002ý\u0000ñ\u0003þó\u0001\u0003öö\bð\u0002ý\u0001ð\tóøý\u0000þõ\u0003\u0002ï\u0003\u0001ðý\u0000ÿôý\u0000\u0000óý\u0000\u0001òý\u0000\u0002ñ\u0001üÿô\u0007ýðý\u0000\u0003ð\u0002ú\u0000ôý\u0001öý\u0000ýö\u0002ý\u0002ï\u0003þó\u0006ûó\u0003þó\u0001ý\u0003ï\u0001þýô\u0001ÿýó\u0001\u0003ð\u0001ÿûõ\u0001\u0003ýï\u0002þøø\u0003þó\u0001\u0003ýï\u0003þó\u0001\u0000ó\u0001ü\u0002ñ\u0004\u0001ï\u0003\u0000ñ\u0003\u0001ðý\u0000þõ\u0002þôý\u0000\u0004ïý\u0001úøý\u0001û÷ý\u0001üöý\u0001ýõ\u0001\u0000ûô\u0002\u0003ïý\u0001þôý\u0001ÿóý\u0002õý\u0001\u0000òý\u0001û÷\u0002ö\u0007ùôý\u0001\u0001ñ\bðý\u0005òý\u0001\u0002ð\u0006øö\u0001\u0001÷÷\u0001ûø\u0001ü÷\u0001û\u0002ò\u0002þù÷\bð\u0006ûó\bùó\u0001ü÷\u0001þùø\u0001ü\u0002ñ\u0006ûó\u0005üó\u0002þúö\bøô\u0003\u0000ñ\u0003\u0001ðý\u0001\u0003ï\u0002þôý\u0002ùøý\u0002ú÷ý\u0000\u0002ó\u0011çÉ:ñ\tõÃ\u0017\u001füõþö\u0007Ñ-ñ\nôô\u0005\u0002Í/çþ\u0007\u0000ñ\u0002ûó\u0011çÉ:ñ\tõÃ\u0013/çþ\u0007\u0000ñ\u0002ûó\u0011çÉCûñÿ¾\u001d\u000f\u0004÷ú\rû\u0000÷\u0002ÿóý\u0001ö\u0002ö\u0003ùøý\u0002õý\u0003ô\u0001\u0002ùô\u0006ûó\u0004ýó\u0001ûø\u0001ü÷\u0001û\u0002ò\u0005ýò\u0001\u0002úó\u0006ûó\u0003þó\u0006ýñ\u0003þó\u0005ýò\u0007÷ö\u0001\u0002ûò\u0003þó\u0004ýó\u0007ñ\u0001\u0002üñ\u0005ýò\u0004\u0001ï\u0002üöý\u0004ó\u0002þôý\u0005òý\u0006ñý\u0007ðý\bï\u0002\u0000òý\u0000ûø\u0004øø\bðý\u0000ü÷ý\u0000ýöý\u0000þõý\u0000ÿô\u0001\u0000ûô\u0002\u0003ïý\u0000\u0000óý\u0000\u0001ò\u0001\u0002ö÷ý\u0000\u0002ñý\u0000\u0003ðý\u0000\u0004ïý\u0001úø\u0002öý\u0002õý\u0001û÷\u0001ÿ\u0001ï\u0001\u0002ýðý\u0001üöý\u0001ýõý\bïý\u0003ô\u0001\u0002þï\u0007ñ\u0001þõ\u0006üò\bð\u0004ýó\u0001\u0003ôø\u0001þüõ\tøó\u0001üþõ\u0001ûüø\u0003\u0000ñ\u0003\u0001ðý\u0004ó\u0002þôý\u0001þôý\u0001ÿóý\u0001û÷\u0002ÿóý\u0000ûøý\u0001\u0000òý\bïý\u0003ô\u0001\u0003õ÷\u0003þó\u0004ýó\u0007ñ\bð\u0001\u0002õø\bøô\u0001\u0003öö\bð\u0001üþõ\u0001ûüø\u0002üöý\u0004ó\u0003\u0002ï\u0003\u0001ðý\u0001\u0001ñý\u0001\u0002ðý\u0001\u0003ï\u0002\u0000òý\u0001öý\bïý\u0002ùø\u0001ÿ\u0001ï\u0007üñ\u0001\u0000÷øý\u0001üö\u0001\u0003÷õ\u0001\u0003øô\bðý\u0001ý\u0000÷ý\u0001öý\u0002õý\u0003ôý\u0004ó\u0001þ\u0001ðý\u0005òý\u0006ñ\u0001þ\u0002ï\u0004ûõ\u0004üô\u0005üó\bð\u0006ûó\u0001ü÷\u0007ñ\u0001ÿøø\u0007÷ö\bøô\u0002üöý\u0007ð\u0002þôý\bïý\u0000ûøý\u0000ü÷\u0001ÿù÷ý\u0005òý\u0000ýö\u0001ÿúö\u0001ÿûõ\u0004ÿñ\t÷ô\u0007ñ\bð\u0004ýó\u0002\u0000ò\u0001ü\u0002ñ\u0001û\u0001ó\búò\u0007÷ö\tóøý\u0000þõ\u0002þôý\u0000ÿôý\u0000\u0000óý\u0000\u0001òý\u0000\u0001òý\u0000\u0002ñ\u0002öý\u0000\u0003ðý\u0006ñ\u0001ÿüô\u0001ÿýó\u0007ñ\bð\u0001ÿûõ\u0004ÿñ\t÷ô\u0006þð\u0004ýó\búò\u0001ÿþò\u0003\u0001ðý\u0007ð\u0003\u0002ï\u0003\u0001ðý\u0000\u0004ïý\u0001úøý\u0004óý\u0000\u0002ñ\u0004øø\bðý\u0001û÷\u0002ö\u0007ùôý\u0001üö\bðý\u0000\u0003ð\u0002\u0003ïý\u0001ýõý\u0001þô\u0001ÿÿñý\u0001ÿóý\u0001\u0000òý\u0000\u0002ñ\u0001ÿ\u0000ð\u0001ÿ\u0001ïý\u0001\u0001ñ\bð\u0007üñ\u0001\u0000÷øý\u0001\u0002ðý\u0001\u0003\u0000÷\u0002öý\u0001öý\u0002õ\u0002ÿ÷ø\u0003þó\u0006ûó\u0001ü÷\u0001þýô\u0005ýò\u0002ûü÷\bð\u0003þó\u0006ûó\u0001ûø\u0001ü÷\u0006ýñ\u0001ü\u0004ï\u0004ýó\u0005ýò\u0006ûó\u0003þó\u0001ü÷\u0007ñ\bð\u0003þó\u0007ö÷\u0007÷ö\bøô\u0002üöý\u0003ô\u0002þôý\u0004óý\u0005òý\u0006ñ\u0002ÿø÷ý\u0007ð\u0007üñ\u0001\u0000÷øý\bï\u0001û\u0000ô\u0001û\u0003ñ\u0006öøý\u0000ûøý\u0000ü÷ý\u0000ýö\u0001\u0000ûô\u0002\u0003ïý\u0000þõ\u0001ÿ\u0001ïý\u0000ÿôý\u0000\u0000óý\u0000\u0001ò\u0002þûõ\u0005ýò\u0002ûü÷\u0001þþó\tóøý\u0000\u0002ñ\u0002þôý\u0000\u0003ðý\u0000\u0004ïý\u0001úøý\u0001û÷ý\u0001üöý\u0001üö\u0002üÿóý\u0001ýõ\u0007üñ\u0001\u0000÷øý\bïý\u0000ûø\u0002\u0003ï\u0001ÿ\u0000ðý\u0001þôý\u0001ÿóý\u0001\u0000òý\u0001\u0001ñý\u0001\u0002ð\u0002ÿùöý\u0007ðý\u0001üö\u0003\u0002ï\u0003\u0002ï\u0003\u0001ð\bðý\u0001\u0003ï\u0001\u0002ö÷ý\u0001þôý\u0001ÿóý\u0001\u0000òý\u0001\u0001ñ\u0002ÿúõ\bðý\u0001\u0002ðý\u0001üö\u0002ú\u0000ôý\u0001ý\u0000÷ý\u0001ö\u0007ùô\u0001ûý÷\bðý\u0002õý\u0003ôý\u0003ô\u0002ö\u0001û\u0003ñ\u0001û\u0003ñ\u0001û\u0004ð\bðý\u0004ó\u0001û\u0005ïý\u0005ò\u0006÷÷ý\u0005ò\u0002\u0000òý\u0006ñý\u0007ð\u0001üûø\u0001üü÷\u0001ûø\u0001üýö\u0001üþõ\u0002\u0000ò\u0001üþõ\tóøý\bï\u0002þôý\u0000ûøý\u0000ü÷ý\u0000ýöý\u0003ô\u0001üÿô\u0007ýðý\u0000þõý\u0000ÿôý\u0003ôý\u0007ð\u0001ü\u0000ó\u0006ûó\u0001ü\u0001ò\u0001ü\u0002ñ\u0007ñ\bð\u0001ü\u0003ð\u0004ýó\u0007ñ\bð\u0001ü\u0004ï\u0004ýó\u0005ýò\u0001ýúø\u0007ñ\u0001ýû÷\u0007÷ö\bøô\u0003\u0000ñ\u0003\u0001ðý\bï\u0003\u0002ï\u0003\u0001ðý\u0000\u0000óý\u0000\u0001òý\u0000\u0002ñý\u0001öý\u0002õý\u0000\u0003ð\u0002öý\u0004ó\u0002ÿóý\u0006\u0000÷\u0002öý\u0001öý\u0002õý\u0003ô\u0004ô\u0005ó\u0006ò\u0007ñ\bð\tï\u0001ûø\u0001ü÷\u0001ýö\u0001þõ\u0001ü÷\u0001ÿô\u0001\u0000ó\u0001\u0001ò\u0001\u0002ñ\u0001\u0003ð\u0001\u0004ï\u0002üöý\u0004ó\u0002þôý\u0005òý\u0006ñý\u0007ð\u0002ÿóý\bï\u0002\u0000òý\bï\u0002\u0003ïý\u0000ûøý\u0000ü÷ý\u0000ýö\u0003ùøý\u0000þõý\u0007ðý\u0000ÿôý\u0003ô\u0003ûö\u0003üõ\u0002\u0000ò\u0003ýô\bð\u0003þó\u0001ü÷\u0003ÿò\u0003\u0000ñ\u0003\u0001ðý\u0004ó\u0003\u0002ï\u0003\u0001ðý\u0000\u0000óý\u0000\u0001òý\u0000\u0002ñ\u0002\u0003ïý\u0000ûøý\u0000ü÷ý\u0000ýöý\u0000þõý\u0002õý\u0002õ\u0004øø\bðý\u0000\u0003\u0000÷ý\u0001öý\u0001öý\u0002õý\u0001ö\u0002\u0000òý\u0003ôý\u0004ó\u0004øø\bðý\u0005òý\u0001öý\u0006ñ\tô÷\bøô\tõö\u0006ûó\töõ\u0001ü÷\u0007ñ\t÷ô\tøó\tùò\túñ\tûð\tüï\u0001ûüø\u0003\u0000ñ\u0003\u0001ðý\u0007ð\u0003\u0002ï\u0003\u0001ðý\bïý\u0000ûøý\u0000ü÷\u0002ÿóý\u0003ô\u0002ö\u0007ùô\u0001ûý÷\bðý\u0000ýö\u0002\u0003ïý\u0000þõ\u0001ûþöý\u0000ÿô\u0001ûÿõý\u0000ÿô\u0002öý\u0000ýö\u0002\u0003ï\u0007ùô\u0001ûý÷\bðý\u0000þõý\u0000\u0000ó\u0001û\u0000ô\u0001û\u0001ó\u0001û\u0002ò\u0001\u0004ï\u0003\u0000ñ\u0003\u0001ðý\u0000\u0001ò\u0002þôý\u0000\u0002ñý\u0000\u0003ðý\u0000\u0004ó\u0011çÉ:ñ\tõÃ\u001d\u000f\u0004÷ú\r\u0000÷\u0002ÿóý\u0001öý\u0002õ\u0001\u0001öø\u0001\u0001÷÷\u0001ýþô\bð\u0005ýò\u0005üó\u0001\u0001øö\u0001ûø\u0001ü÷\u0001ÿô\u0007ö÷\u0003þó\u0006ûó\u0001\u0001ùõ\u0001\u0001úô\u0001\u0001ûó\u0007øõ\u0003\u0001ðý\u0003ô\u0003\u0002ï\u0003\u0001ðý\u0004óý\u0005òý\u0006ñ\u0003\u0002ï\u0001\u0001üòý\u0007ðý\bï\u0002\u0003ïý\u0000ûøý\u0000ü÷\u0007ùôý\u0000ýö\bðý\u0000þõ\u0002\u0003ïý\u0000ûøý\u0000ü÷ý\u0000þõý\u0000ÿôý\bï\u0002\u0000òý\u0001öý\bï\u0002öý\u0000\u0000ó\u0011çÉ:ñ\tõÃ\u000f-üë\u0014Ö\u001d÷ÿïÜ/çþ\u0007\u0000ñ\u0002û\u0000÷ý\u0001öý\u0001öý\u0001ö\u0002\u0000òý\u0002õý\u0003ôý\u0004óý\u0005ò\u0001ýüö\u0006ûó\u0004ÿñ\bð\u0001ýýõ\u0001ü\u0002ñ\u0004þò\u0004ýó\u0001ýþô\bð\u0005ýò\u0001ýÿó\u0001ý\u0000ò\u0001ü÷\tï\bð\u0001ý\u0001ñ\u0003ÿò\u0003\u0000ñ\u0003\u0001ðý\u0006ñ\u0003\u0002ï\u0003\u0001ðý\u0007ðý\bïý\u0000ûøý\u0005ò\u0001ý\u0002ð\u0001ý\u0003ï\u0007ñ\u0001þùø\u0001ü\u0002ñ\u0007÷ö\tóøý\u0006ñ\u0003\u0002ï\u0003\u0001ðý\u0000ü÷ý\u0000ýöý\u0000þõ\u0002ÿóý\u0002õ\u0002ö\u0007ùôý\u0000ÿô\bðý\u0000\u0000ó\u0004øø\bðý\u0000\u0001òý\u0000\u0002ñ\u0002öý\u0000\u0000óý\u0000û\u0000÷ý\u0001ö\u0002\u0000òý\u0002õ\u0002ÿóý\u0002õý\u0003ô\u0002û\u0000ó\u0005ó\u0001ü÷\u0001ü÷\bð\u0004ýó\u0007ñ\u0001\u0001øö\u0001\u0003ýï\u0004ýó\u0002û\u0001ò\u0003þó\u0001ü÷\u0001\u0003ð\u0001\u0000ó\u0001ü\u0002ñ\u0004\u0001ï\u0003\u0000ñ\u0003\u0001ðý\u0004ó\u0003\u0002ï\u0003\u0001ðý\u0005òý\u0006ñý\u0007ð\u0003\u0002ï\u0003\u0002ï\u0007ýðý\bï\u0002öý\u0000ûø\u0002\u0003ïý\u0000ü÷\u0002û\u0002ñý\u0000ýöý\u0000þõý\u0000ÿôý\u0000ÿô\u0002\u0003ïý\u0000ü÷\u0002ú\u0005ïý\u0000ýöý\u0000þ".getBytes("ISO-8859-1"), 0, bArr, 0, 6834);
        BuiltInFictitiousFunctionClassFactory = bArr;
        PlaceComponentResult = 188;
        MyBillsEntityDataFactory = 0;
        KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.data.qrpay.QrPayEntityRepository.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 1
            int r6 = 6673 - r6
            int r8 = r8 + 44
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L30
        L14:
            r3 = 0
        L15:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r9 = r9 + r7
            int r7 = r9 + 4
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.a(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0372, code lost:
    
        if (r10 <= 62) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0254, code lost:
    
        if (r10 <= 24) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.data.qrpay.source.QrPayEntityData createQrPayData() {
        /*
            Method dump skipped, instructions count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.createQrPayData():id.dana.data.qrpay.source.QrPayEntityData");
    }

    private SecurityEntityData createSecurityData() {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        resetSizeCounter resetsizecounter = new resetSizeCounter(this);
        Object[] objArr8 = new Object[1];
        a((short) 5801, (short) (PlaceComponentResult - 2), BuiltInFictitiousFunctionClassFactory[71], objArr8);
        String str = (String) objArr8[0];
        short s = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr9 = new Object[1];
        a((short) 2146, s, (byte) s, objArr9);
        try {
            Object[] objArr10 = {(String) objArr9[0]};
            short s2 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr11 = new Object[1];
            a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr11);
            Class<?> cls = Class.forName((String) objArr11[0]);
            short s3 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr12 = new Object[1];
            a((short) 4760, s3, (byte) (s3 | 67), objArr12);
            String str2 = (String) objArr12[0];
            Object[] objArr13 = new Object[1];
            a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr13);
            Object[] objArr14 = (Object[]) cls.getMethod(str2, Class.forName((String) objArr13[0])).invoke(str, objArr10);
            int[] iArr = new int[objArr14.length];
            for (int i = 0; i < objArr14.length; i++) {
                try {
                    Object[] objArr15 = {objArr14[i]};
                    short s4 = (short) 5420;
                    short s5 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr16 = new Object[1];
                    a(s4, s5, (byte) (s5 | 46), objArr16);
                    Class<?> cls2 = Class.forName((String) objArr16[0]);
                    Object[] objArr17 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr17);
                    String str3 = (String) objArr17[0];
                    Object[] objArr18 = new Object[1];
                    a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr18);
                    Object invoke = cls2.getMethod(str3, Class.forName((String) objArr18[0])).invoke(null, objArr15);
                    try {
                        short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr19 = new Object[1];
                        a(s4, s6, (byte) (s6 | 46), objArr19);
                        Class<?> cls3 = Class.forName((String) objArr19[0]);
                        Object[] objArr20 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr20);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr20[0], null).invoke(invoke, null)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 4;
            int i3 = 44;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                int i6 = 3;
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
                switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i4])) {
                    case -20:
                        i4 = 21;
                        i3 = 44;
                        break;
                    case -19:
                        try {
                            resetsizecounter.getAuthRequestContext = 2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            SecurityEntityDataFactory securityEntityDataFactory = (SecurityEntityDataFactory) resetsizecounter.lookAheadTest;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = securityEntityDataFactory.createData2((String) resetsizecounter.lookAheadTest);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                        } catch (Throwable th4) {
                            th = th4;
                            short s7 = (short) 6640;
                            short s8 = BuiltInFictitiousFunctionClassFactory[49];
                            objArr = new Object[1];
                            a(s7, s8, (byte) (s8 | 28), objArr);
                            if (Class.forName((String) objArr[0]).isInstance(th)) {
                            }
                            short s9 = BuiltInFictitiousFunctionClassFactory[1306];
                            objArr2 = new Object[1];
                            a((short) 227, s9, (byte) (s9 | 34), objArr2);
                            if (Class.forName((String) objArr2[0]).isInstance(th)) {
                                break;
                            }
                            objArr3 = new Object[1];
                            a((short) 2540, (short) (-BuiltInFictitiousFunctionClassFactory[6]), b, objArr3);
                            if (Class.forName((String) objArr3[0]).isInstance(th)) {
                            }
                            short s10 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                            objArr4 = new Object[1];
                            a((short) 2113, s10, (byte) (s10 | 44), objArr4);
                            if (Class.forName((String) objArr4[0]).isInstance(th)) {
                                break;
                            }
                            if (i5 >= 50) {
                                i6 = 1;
                                resetsizecounter.scheduleImpl = th;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                i4 = i6;
                                i2 = 4;
                                i3 = 44;
                                break;
                            }
                            objArr5 = new Object[1];
                            a((short) 5377, BuiltInFictitiousFunctionClassFactory[21], b, objArr5);
                            if (Class.forName((String) objArr5[0]).isInstance(th)) {
                                break;
                            }
                            short s11 = BuiltInFictitiousFunctionClassFactory[49];
                            objArr6 = new Object[1];
                            a(s7, s11, (byte) (s11 | 28), objArr6);
                            if (Class.forName((String) objArr6[0]).isInstance(th)) {
                                break;
                            }
                            short s12 = BuiltInFictitiousFunctionClassFactory[49];
                            objArr7 = new Object[1];
                            a(s7, s12, (byte) (s12 | 28), objArr7);
                            if (Class.forName((String) objArr7[0]).isInstance(th)) {
                            }
                            throw th;
                        }
                        i3 = 44;
                        break;
                    case -18:
                        resetsizecounter.scheduleImpl = "network";
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                        i4 = i5;
                        i3 = 44;
                        break;
                    case -17:
                        try {
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((QrPayEntityRepository) resetsizecounter.lookAheadTest).securityEntityDataFactory;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                        } catch (Throwable th5) {
                            th = th5;
                            short s72 = (short) 6640;
                            short s82 = BuiltInFictitiousFunctionClassFactory[49];
                            objArr = new Object[1];
                            a(s72, s82, (byte) (s82 | 28), objArr);
                            if (Class.forName((String) objArr[0]).isInstance(th) || i5 < i2 || i5 > 5) {
                                short s92 = BuiltInFictitiousFunctionClassFactory[1306];
                                objArr2 = new Object[1];
                                a((short) 227, s92, (byte) (s92 | 34), objArr2);
                                if (Class.forName((String) objArr2[0]).isInstance(th) || i5 < 16 || i5 > 17) {
                                    objArr3 = new Object[1];
                                    a((short) 2540, (short) (-BuiltInFictitiousFunctionClassFactory[6]), b, objArr3);
                                    if (Class.forName((String) objArr3[0]).isInstance(th) || i5 < 21 || i5 > 22) {
                                        short s102 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                        objArr4 = new Object[1];
                                        a((short) 2113, s102, (byte) (s102 | 44), objArr4);
                                        if (Class.forName((String) objArr4[0]).isInstance(th) || i5 < 33 || i5 > 34) {
                                            if (i5 >= 50 && i5 <= 53) {
                                                i6 = 1;
                                                resetsizecounter.scheduleImpl = th;
                                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                                i4 = i6;
                                                i2 = 4;
                                                i3 = 44;
                                            }
                                            objArr5 = new Object[1];
                                            a((short) 5377, BuiltInFictitiousFunctionClassFactory[21], b, objArr5);
                                            if (Class.forName((String) objArr5[0]).isInstance(th) || i5 < 54 || i5 > 58) {
                                                short s112 = BuiltInFictitiousFunctionClassFactory[49];
                                                objArr6 = new Object[1];
                                                a(s72, s112, (byte) (s112 | 28), objArr6);
                                                if (Class.forName((String) objArr6[0]).isInstance(th) || i5 < 55 || i5 > 56) {
                                                    short s122 = BuiltInFictitiousFunctionClassFactory[49];
                                                    objArr7 = new Object[1];
                                                    a(s72, s122, (byte) (s122 | 28), objArr7);
                                                    if (Class.forName((String) objArr7[0]).isInstance(th) || i5 < 56 || i5 > 58) {
                                                        throw th;
                                                    }
                                                }
                                                i6 = 48;
                                            }
                                            resetsizecounter.scheduleImpl = th;
                                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                            i4 = i6;
                                            i2 = 4;
                                            i3 = 44;
                                        }
                                    }
                                }
                            }
                            resetsizecounter.scheduleImpl = th;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                            i4 = i6;
                            i2 = 4;
                            i3 = 44;
                        }
                        i3 = 44;
                        break;
                    case -16:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                        return (SecurityEntityData) resetsizecounter.lookAheadTest;
                    case -15:
                        i4 = 2;
                        break;
                    case -14:
                        i4 = 4;
                        break;
                    case -13:
                        i4 = 44;
                        break;
                    case -12:
                        i4 = 58;
                        break;
                    case -11:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(57);
                        if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                            i4 = 37;
                            break;
                        } else {
                            i4 = i5;
                            break;
                        }
                    case -10:
                        resetsizecounter.getAuthRequestContext = 1;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                        KClassImpl$Data$declaredNonStaticMembers$2 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                        i4 = i5;
                        i3 = 44;
                        break;
                    case -9:
                        resetsizecounter.getAuthRequestContext = MyBillsEntityDataFactory;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                        i4 = i5;
                        i3 = 44;
                        break;
                    case -8:
                        i4 = 53;
                        break;
                    case -7:
                        i4 = 38;
                        break;
                    case -6:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(23);
                        if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                            i4 = 20;
                            break;
                        } else {
                            i4 = i5;
                            break;
                        }
                    case -5:
                        resetsizecounter.getAuthRequestContext = 1;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                        MyBillsEntityDataFactory = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                        i4 = i5;
                        i3 = 44;
                        break;
                    case -4:
                        resetsizecounter.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                        i4 = i5;
                        i3 = 44;
                        break;
                    case -3:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                        int i7 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                        if (i7 != i3 && i7 == 68) {
                            i4 = 49;
                            break;
                        }
                        i4 = 46;
                        break;
                    case -2:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                        throw ((Throwable) resetsizecounter.lookAheadTest);
                    case -1:
                        i4 = 39;
                        break;
                    default:
                        i4 = i5;
                        i3 = 44;
                        break;
                }
            }
        } catch (Throwable th6) {
            Throwable cause3 = th6.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th6;
        }
    }

    private <T> Function<Throwable, ? extends Observable<? extends T>> getKey(Observable<T> observable) {
        resetSizeCounter resetsizecounter = new resetSizeCounter(this, observable);
        Object[] objArr = new Object[1];
        a((short) 5938, (short) 137, BuiltInFictitiousFunctionClassFactory[71], objArr);
        char c = 0;
        String str = (String) objArr[0];
        short s = (short) 2146;
        short s2 = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr2 = new Object[1];
        a(s, s2, (byte) s2, objArr2);
        try {
            Object[] objArr3 = {(String) objArr2[0]};
            short s3 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr4 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            short s4 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr5 = new Object[1];
            a((short) 4760, s4, (byte) (s4 | 67), objArr5);
            String str2 = (String) objArr5[0];
            Object[] objArr6 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr6);
            Object[] objArr7 = (Object[]) cls.getMethod(str2, Class.forName((String) objArr6[0])).invoke(str, objArr3);
            int[] iArr = new int[objArr7.length];
            int i = 0;
            while (i < objArr7.length) {
                try {
                    Object[] objArr8 = new Object[1];
                    objArr8[c] = objArr7[i];
                    short s5 = (short) 5420;
                    short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr9 = new Object[1];
                    a(s5, s6, (byte) (s6 | 46), objArr9);
                    Class<?> cls2 = Class.forName((String) objArr9[c]);
                    Object[] objArr10 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr11);
                    Object invoke = cls2.getMethod(str3, Class.forName((String) objArr11[0])).invoke(null, objArr8);
                    try {
                        short s7 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr12 = new Object[1];
                        a(s5, s7, (byte) (s7 | 46), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr13);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr13[0], null).invoke(invoke, null)).intValue();
                        i++;
                        c = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 3;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
                switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i3])) {
                    case -14:
                        i3 = 7;
                        continue;
                    case -13:
                        resetsizecounter.getAuthRequestContext = 2;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                        final QrPayEntityRepository qrPayEntityRepository = (QrPayEntityRepository) resetsizecounter.lookAheadTest;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                        final Observable observable2 = (Observable) resetsizecounter.lookAheadTest;
                        resetsizecounter.scheduleImpl = new Function() { // from class: id.dana.data.qrpay.QrPayEntityRepository$$ExternalSyntheticLambda4
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj) {
                                return QrPayEntityRepository.this.m1716lambda$getKey$4$iddanadataqrpayQrPayEntityRepository(observable2, (Throwable) obj);
                            }
                        };
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                        i3 = i4;
                        break;
                    case -12:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                        throw ((Throwable) resetsizecounter.lookAheadTest);
                    case -11:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                        return (Function) resetsizecounter.lookAheadTest;
                    case -10:
                        resetsizecounter.getAuthRequestContext = 1;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                        resetsizecounter.getAuthRequestContext = resetsizecounter.lookAheadTest.hashCode();
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                        i3 = i4;
                        break;
                    case -9:
                        i3 = 44;
                        continue;
                    case -8:
                        i3 = 1;
                        continue;
                    case -7:
                        try {
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(23);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i3 = 30;
                            } else {
                                i3 = i4;
                                continue;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            short s8 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                            Object[] objArr14 = new Object[1];
                            a((short) 6670, s8, (byte) (s8 | 32), objArr14);
                            int i5 = 36;
                            if (!Class.forName((String) objArr14[0]).isInstance(th) || i4 < 7 || i4 > 31) {
                                Object[] objArr15 = new Object[1];
                                a(s, BuiltInFictitiousFunctionClassFactory[44], b, objArr15);
                                if (Class.forName((String) objArr15[0]).isInstance(th) && i4 >= 26 && i4 <= 27) {
                                    i5 = 37;
                                } else if (i4 < 32 || i4 > 36) {
                                    throw th;
                                }
                            } else {
                                i5 = 40;
                            }
                            resetsizecounter.scheduleImpl = th;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                            i3 = i5;
                            i2 = 3;
                        }
                        break;
                    case -6:
                        resetsizecounter.getAuthRequestContext = 1;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                        MyBillsEntityDataFactory = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                        i3 = i4;
                        break;
                    case -5:
                        resetsizecounter.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                        i3 = i4;
                        break;
                    case -4:
                        i3 = 41;
                        continue;
                    case -3:
                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                        i4 = 23;
                        if (resetsizecounter.BuiltInFictitiousFunctionClassFactory != 23) {
                            i3 = 31;
                        } else {
                            i3 = 38;
                            continue;
                        }
                    case -2:
                        i3 = 3;
                        continue;
                    case -1:
                        i3 = 4;
                        continue;
                    default:
                        i3 = i4;
                        break;
                }
                i2 = 3;
            }
        } catch (Throwable th5) {
            Throwable cause3 = th5.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th5;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0316, code lost:
    
        if (r11 <= 74) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> io.reactivex.Observable<T> keyedRequest(io.reactivex.Observable<T> r22) {
        /*
            Method dump skipped, instructions count: 908
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.keyedRequest(io.reactivex.Observable):io.reactivex.Observable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0274, code lost:
    
        if (r9 <= 30) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ io.reactivex.ObservableSource lambda$getKey$2(io.reactivex.Observable r19, java.lang.String r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.lambda$getKey$2(io.reactivex.Observable, java.lang.String):io.reactivex.ObservableSource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$getOtpInitResult$9(OtpInitResult otpInitResult) throws Exception {
        resetSizeCounter resetsizecounter = new resetSizeCounter(otpInitResult);
        Object[] objArr = new Object[1];
        a((short) 1059, (short) 238, BuiltInFictitiousFunctionClassFactory[71], objArr);
        String str = (String) objArr[0];
        short s = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr2 = new Object[1];
        a((short) 2146, s, (byte) s, objArr2);
        try {
            Object[] objArr3 = {(String) objArr2[0]};
            short s2 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr4 = new Object[1];
            a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            short s3 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr5 = new Object[1];
            a((short) 4760, s3, (byte) (s3 | 67), objArr5);
            String str2 = (String) objArr5[0];
            Object[] objArr6 = new Object[1];
            a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr6);
            Object[] objArr7 = (Object[]) cls.getMethod(str2, Class.forName((String) objArr6[0])).invoke(str, objArr3);
            int[] iArr = new int[objArr7.length];
            for (int i = 0; i < objArr7.length; i++) {
                try {
                    Object[] objArr8 = {objArr7[i]};
                    short s4 = (short) 5420;
                    short s5 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr9 = new Object[1];
                    a(s4, s5, (byte) (s5 | 46), objArr9);
                    Class<?> cls2 = Class.forName((String) objArr9[0]);
                    Object[] objArr10 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr11);
                    Object invoke = cls2.getMethod(str3, Class.forName((String) objArr11[0])).invoke(null, objArr8);
                    try {
                        short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr12 = new Object[1];
                        a(s4, s6, (byte) (s6 | 46), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr13);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr13[0], null).invoke(invoke, null)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 20;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                try {
                    switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i3])) {
                        case -18:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                            int i5 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            if (i5 == 0 || i5 != 1) {
                                i3 = 70;
                                break;
                            } else {
                                i3 = 8;
                                break;
                            }
                            break;
                        case -17:
                            i3 = 72;
                            break;
                        case -16:
                            i3 = 18;
                            break;
                        case -15:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(57);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i3 = 66;
                                break;
                            } else {
                                i3 = i4;
                                break;
                            }
                        case -14:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory != 24) {
                                i3 = 1;
                                break;
                            } else {
                                i3 = 67;
                                break;
                            }
                        case -13:
                            i3 = 20;
                            break;
                        case -12:
                            i3 = 14;
                            break;
                        case -11:
                            i3 = 16;
                            break;
                        case -10:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(57);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i3 = 33;
                                break;
                            } else {
                                i3 = i4;
                                break;
                            }
                        case -9:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            KClassImpl$Data$declaredNonStaticMembers$2 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i3 = i4;
                            break;
                        case -8:
                            resetsizecounter.getAuthRequestContext = MyBillsEntityDataFactory;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                            i3 = i4;
                            break;
                        case -7:
                            i3 = 69;
                            break;
                        case -6:
                            i3 = 38;
                            break;
                        case -5:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            return (Boolean) resetsizecounter.lookAheadTest;
                        case -4:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            throw ((Throwable) resetsizecounter.lookAheadTest);
                        case -3:
                            i3 = 40;
                            break;
                        case -2:
                            short s7 = BuiltInFictitiousFunctionClassFactory[3107];
                            Object[] objArr14 = new Object[1];
                            a((short) 3576, s7, (byte) (s7 | 46), objArr14);
                            Class<?> cls4 = Class.forName((String) objArr14[0]);
                            Object[] objArr15 = new Object[1];
                            a((short) 2573, BuiltInFictitiousFunctionClassFactory[83], (byte) (-BuiltInFictitiousFunctionClassFactory[53]), objArr15);
                            try {
                                resetsizecounter.scheduleImpl = cls4.getField((String) objArr15[0]).get(null);
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                                i3 = i4;
                            } catch (Throwable th3) {
                                th = th3;
                                int i6 = 7;
                                if (i4 < 2 || i4 > 6) {
                                    short s8 = (short) 2570;
                                    short s9 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                    Object[] objArr16 = new Object[1];
                                    a(s8, s9, (byte) (s9 | 32), objArr16);
                                    if (!Class.forName((String) objArr16[0]).isInstance(th) || i4 < 1 || i4 > 6) {
                                        if (i4 < 9 || i4 > 14) {
                                            Object[] objArr17 = new Object[1];
                                            a((short) 5404, BuiltInFictitiousFunctionClassFactory[1311], b, objArr17);
                                            if (!Class.forName((String) objArr17[0]).isInstance(th) || i4 < i2 || i4 > 34) {
                                                short s10 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                                Object[] objArr18 = new Object[1];
                                                a((short) 2113, s10, (byte) (s10 | 44), objArr18);
                                                if (!Class.forName((String) objArr18[0]).isInstance(th) || i4 < 29 || i4 > 34) {
                                                    short s11 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                                    Object[] objArr19 = new Object[1];
                                                    a((short) 6670, s11, (byte) (s11 | 32), objArr19);
                                                    if (!Class.forName((String) objArr19[0]).isInstance(th) || i4 < 40 || i4 > 67) {
                                                        Object[] objArr20 = new Object[1];
                                                        a((short) 2540, (short) (-BuiltInFictitiousFunctionClassFactory[6]), b, objArr20);
                                                        if (!Class.forName((String) objArr20[0]).isInstance(th) || i4 < 61 || i4 > 67) {
                                                            short s12 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                                            Object[] objArr21 = new Object[1];
                                                            a(s8, s12, (byte) (s12 | 32), objArr21);
                                                            if (!Class.forName((String) objArr21[0]).isInstance(th) || i4 < 67 || i4 > 69) {
                                                                throw th;
                                                            }
                                                            i6 = 34;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            i6 = 39;
                                        }
                                    }
                                } else {
                                    i6 = 6;
                                }
                                resetsizecounter.scheduleImpl = th;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                i3 = i6;
                                i2 = 20;
                            }
                            break;
                        case -1:
                            i3 = 35;
                            break;
                        default:
                            i3 = i4;
                            break;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            Throwable cause3 = th5.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0304, code lost:
    
        if (r12 <= 49) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Boolean lambda$init$1(java.lang.String r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.lambda$init$1(java.lang.String):java.lang.Boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02fe, code lost:
    
        if (r11 <= 48) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0280, code lost:
    
        if (r11 <= 21) goto L83;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<java.lang.Boolean> getOtpInitResult() {
        /*
            Method dump skipped, instructions count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.getOtpInitResult():io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0334, code lost:
    
        if (r14 <= 4) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03b4, code lost:
    
        if (r14 <= 46) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x040f, code lost:
    
        if (r14 <= 51) goto L139;
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02dc A[Catch: all -> 0x02f9, TryCatch #3 {all -> 0x02f9, blocks: (B:76:0x02c2, B:77:0x02c4, B:87:0x02d6, B:89:0x02dc, B:90:0x02dd, B:91:0x02de), top: B:198:0x02c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02dd A[Catch: all -> 0x02f9, TryCatch #3 {all -> 0x02f9, blocks: (B:76:0x02c2, B:77:0x02c4, B:87:0x02d6, B:89:0x02dc, B:90:0x02dd, B:91:0x02de), top: B:198:0x02c2 }] */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<id.dana.domain.model.f2fpay.response.F2FPaymentCodeResponse> getPaymentCode() {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.getPaymentCode():io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x038c, code lost:
    
        if (r9 > 31) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x047a, code lost:
    
        if (r9 > 81) goto L173;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027a A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:64:0x0263, B:82:0x0296, B:74:0x0274, B:76:0x027a, B:77:0x027b, B:78:0x027c, B:81:0x028d, B:83:0x029c), top: B:189:0x0263 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027b A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:64:0x0263, B:82:0x0296, B:74:0x0274, B:76:0x027a, B:77:0x027b, B:78:0x027c, B:81:0x028d, B:83:0x029c), top: B:189:0x0263 }] */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<id.dana.domain.model.f2fpay.response.F2FPayResultResponse> getPaymentResult() {
        /*
            Method dump skipped, instructions count: 1270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.getPaymentResult():io.reactivex.Observable");
    }

    @Override // id.dana.domain.qrpay.QrPayRepository
    public Observable<Boolean> getQrInitResult() {
        resetSizeCounter resetsizecounter = new resetSizeCounter(this);
        Object[] objArr = new Object[1];
        a((short) 389, (short) 162, BuiltInFictitiousFunctionClassFactory[71], objArr);
        String str = (String) objArr[0];
        short s = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr2 = new Object[1];
        a((short) 2146, s, (byte) s, objArr2);
        try {
            Object[] objArr3 = {(String) objArr2[0]};
            short s2 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr4 = new Object[1];
            a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            short s3 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr5 = new Object[1];
            a((short) 4760, s3, (byte) (s3 | 67), objArr5);
            String str2 = (String) objArr5[0];
            Object[] objArr6 = new Object[1];
            a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr6);
            Object[] objArr7 = (Object[]) cls.getMethod(str2, Class.forName((String) objArr6[0])).invoke(str, objArr3);
            int[] iArr = new int[objArr7.length];
            for (int i = 0; i < objArr7.length; i++) {
                try {
                    Object[] objArr8 = {objArr7[i]};
                    short s4 = (short) 5420;
                    short s5 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr9 = new Object[1];
                    a(s4, s5, (byte) (s5 | 46), objArr9);
                    Class<?> cls2 = Class.forName((String) objArr9[0]);
                    Object[] objArr10 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(s2, BuiltInFictitiousFunctionClassFactory[23], b, objArr11);
                    Object invoke = cls2.getMethod(str3, Class.forName((String) objArr11[0])).invoke(null, objArr8);
                    try {
                        short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr12 = new Object[1];
                        a(s4, s6, (byte) (s6 | 46), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr13);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr13[0], null).invoke(invoke, null)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 28;
            int i3 = 3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                int i6 = 31;
                try {
                    switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i4])) {
                        case -15:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            return (Observable) resetsizecounter.lookAheadTest;
                        case -14:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                            int i7 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            if (i7 != 0 && i7 == 1) {
                                i4 = 32;
                                break;
                            }
                            i4 = 39;
                            break;
                        case -13:
                            i4 = 48;
                            break;
                        case -12:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.getAuthRequestContext = resetsizecounter.lookAheadTest.hashCode();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i3);
                            i4 = i5;
                            break;
                        case -11:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((QrPayEntityData) resetsizecounter.lookAheadTest).getQrInitResult();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                            i4 = i5;
                            break;
                        case -10:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((QrPayEntityRepository) resetsizecounter.lookAheadTest).createQrPayData();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                            i4 = i5;
                            break;
                        case -9:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            throw ((Throwable) resetsizecounter.lookAheadTest);
                        case -8:
                            i4 = 3;
                            break;
                        case -7:
                            i4 = 1;
                            break;
                        case -6:
                            i4 = 45;
                            break;
                        case -5:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(57);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i4 = 27;
                                break;
                            } else {
                                i4 = i5;
                                break;
                            }
                        case -4:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            KClassImpl$Data$declaredNonStaticMembers$2 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i4 = i5;
                            break;
                        case -3:
                            resetsizecounter.getAuthRequestContext = MyBillsEntityDataFactory;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i3);
                            i4 = i5;
                            break;
                        case -2:
                            i4 = 43;
                            break;
                        case -1:
                            i4 = 28;
                            break;
                        default:
                            i4 = i5;
                            break;
                    }
                } catch (Throwable th3) {
                    Object[] objArr14 = new Object[1];
                    a((short) 2540, (short) (-BuiltInFictitiousFunctionClassFactory[6]), b, objArr14);
                    if (!Class.forName((String) objArr14[0]).isInstance(th3) || i5 < i3 || i5 > 4) {
                        short s7 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                        Object[] objArr15 = new Object[1];
                        a((short) 2113, s7, (byte) (s7 | 44), objArr15);
                        if (Class.forName((String) objArr15[0]).isInstance(th3) && i5 >= 22) {
                            if (i5 <= 23) {
                                i6 = 47;
                            }
                        }
                        if (i5 < 35 || i5 > 39) {
                            Object[] objArr16 = new Object[1];
                            a((short) 5404, BuiltInFictitiousFunctionClassFactory[1311], b, objArr16);
                            if (!Class.forName((String) objArr16[0]).isInstance(th3) || i5 < 34 || i5 > 35) {
                                short s8 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                Object[] objArr17 = new Object[1];
                                a((short) 2570, s8, (byte) (s8 | 32), objArr17);
                                if (!Class.forName((String) objArr17[0]).isInstance(th3) || i5 < 41 || i5 > 43) {
                                    throw th3;
                                }
                            }
                        } else {
                            i6 = 44;
                        }
                    }
                    resetsizecounter.scheduleImpl = th3;
                    resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                    i4 = i6;
                    i2 = 28;
                    i3 = 3;
                }
            }
        } catch (Throwable th4) {
            Throwable cause3 = th4.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th4;
        }
    }

    public Observable<Boolean> init() {
        resetSizeCounter resetsizecounter = new resetSizeCounter(this);
        Object[] objArr = new Object[1];
        a((short) 3333, (short) 319, BuiltInFictitiousFunctionClassFactory[71], objArr);
        char c = 0;
        String str = (String) objArr[0];
        short s = (short) 2146;
        short s2 = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr2 = new Object[1];
        a(s, s2, (byte) s2, objArr2);
        try {
            Object[] objArr3 = {(String) objArr2[0]};
            short s3 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr4 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            short s4 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr5 = new Object[1];
            a((short) 4760, s4, (byte) (s4 | 67), objArr5);
            String str2 = (String) objArr5[0];
            Object[] objArr6 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr6);
            Object[] objArr7 = (Object[]) cls.getMethod(str2, Class.forName((String) objArr6[0])).invoke(str, objArr3);
            int[] iArr = new int[objArr7.length];
            int i = 0;
            while (i < objArr7.length) {
                try {
                    Object[] objArr8 = new Object[1];
                    objArr8[c] = objArr7[i];
                    short s5 = (short) 5420;
                    short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr9 = new Object[1];
                    a(s5, s6, (byte) (s6 | 46), objArr9);
                    Class<?> cls2 = Class.forName((String) objArr9[c]);
                    Object[] objArr10 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr11);
                    Object invoke = cls2.getMethod(str3, Class.forName((String) objArr11[0])).invoke(null, objArr8);
                    try {
                        short s7 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr12 = new Object[1];
                        a(s5, s7, (byte) (s7 | 46), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr13);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr13[0], null).invoke(invoke, null)).intValue();
                        i++;
                        c = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 7;
            int i3 = 38;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                try {
                    switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i4])) {
                        case -29:
                            i4 = 7;
                            break;
                        case -28:
                            i4 = 6;
                            break;
                        case -27:
                            i4 = 87;
                            break;
                        case -26:
                            i4 = 85;
                            break;
                        case -25:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(57);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory != 0) {
                                i4 = i5;
                                break;
                            } else {
                                i4 = 84;
                                break;
                            }
                        case -24:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            KClassImpl$Data$declaredNonStaticMembers$2 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i4 = i5;
                            break;
                        case -23:
                            resetsizecounter.getAuthRequestContext = MyBillsEntityDataFactory;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                            i4 = i5;
                            break;
                        case -22:
                            i4 = 53;
                            break;
                        case -21:
                            try {
                                resetsizecounter.getAuthRequestContext = 1;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                                resetsizecounter.getAuthRequestContext = resetsizecounter.lookAheadTest.hashCode();
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                                i4 = i5;
                            } catch (Throwable th3) {
                                th = th3;
                                short s8 = (short) 2113;
                                int i6 = 52;
                                short s9 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                Object[] objArr14 = new Object[1];
                                a(s8, s9, (byte) (s9 | 44), objArr14);
                                if (!Class.forName((String) objArr14[0]).isInstance(th) || i5 < i2 || i5 > i3) {
                                    Object[] objArr15 = new Object[1];
                                    a(s, BuiltInFictitiousFunctionClassFactory[44], b, objArr15);
                                    if (!Class.forName((String) objArr15[0]).isInstance(th) || i5 < 32 || i5 > i3) {
                                        short s10 = (short) 5404;
                                        Object[] objArr16 = new Object[1];
                                        a(s10, BuiltInFictitiousFunctionClassFactory[1311], b, objArr16);
                                        if (Class.forName((String) objArr16[0]).isInstance(th) && i5 >= 41) {
                                            if (i5 <= 45) {
                                                i6 = 46;
                                                resetsizecounter.scheduleImpl = th;
                                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                                i4 = i6;
                                                i2 = 7;
                                                i3 = 38;
                                            }
                                        }
                                        Object[] objArr17 = new Object[1];
                                        a((short) 2540, (short) (-BuiltInFictitiousFunctionClassFactory[6]), b, objArr17);
                                        if (!Class.forName((String) objArr17[0]).isInstance(th) || i5 < 48 || i5 > 49) {
                                            short s11 = (short) 6670;
                                            short s12 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                            Object[] objArr18 = new Object[1];
                                            a(s11, s12, (byte) (s12 | 32), objArr18);
                                            if (!Class.forName((String) objArr18[0]).isInstance(th) || i5 < 49 || i5 > 52) {
                                                short s13 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                                Object[] objArr19 = new Object[1];
                                                a(s11, s13, (byte) (s13 | 32), objArr19);
                                                if (!Class.forName((String) objArr19[0]).isInstance(th) || i5 < 50 || i5 > 51) {
                                                    if (i5 < 57 || i5 > 61) {
                                                        Object[] objArr20 = new Object[1];
                                                        a(s10, BuiltInFictitiousFunctionClassFactory[1311], b, objArr20);
                                                        if (!Class.forName((String) objArr20[0]).isInstance(th) || i5 < 56 || i5 > 57) {
                                                            short s14 = (short) 6640;
                                                            short s15 = BuiltInFictitiousFunctionClassFactory[49];
                                                            Object[] objArr21 = new Object[1];
                                                            a(s14, s15, (byte) (s15 | 28), objArr21);
                                                            if (Class.forName((String) objArr21[0]).isInstance(th) && i5 >= 61 && i5 <= 85) {
                                                            }
                                                            short s16 = BuiltInFictitiousFunctionClassFactory[49];
                                                            Object[] objArr22 = new Object[1];
                                                            a(s14, s16, (byte) (s16 | 28), objArr22);
                                                            if (!Class.forName((String) objArr22[0]).isInstance(th) || i5 < 79 || i5 > 80) {
                                                                short s17 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                                                Object[] objArr23 = new Object[1];
                                                                a(s8, s17, (byte) (s17 | 44), objArr23);
                                                                if (!Class.forName((String) objArr23[0]).isInstance(th) || i5 < 93 || i5 > 95) {
                                                                    throw th;
                                                                }
                                                            }
                                                            i6 = 46;
                                                        }
                                                    } else {
                                                        i6 = 5;
                                                    }
                                                    resetsizecounter.scheduleImpl = th;
                                                    resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                                    i4 = i6;
                                                    i2 = 7;
                                                    i3 = 38;
                                                }
                                            }
                                        }
                                        resetsizecounter.scheduleImpl = th;
                                        resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                        i4 = i6;
                                        i2 = 7;
                                        i3 = 38;
                                    }
                                }
                                resetsizecounter.scheduleImpl = th;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                i4 = i6;
                                i2 = 7;
                                i3 = 38;
                            }
                            break;
                        case -20:
                            resetsizecounter.getAuthRequestContext = 2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            Observable observable = (Observable) resetsizecounter.lookAheadTest;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = observable.map((Function) resetsizecounter.lookAheadTest);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -19:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            return (Observable) resetsizecounter.lookAheadTest;
                        case -18:
                            i4 = 1;
                            break;
                        case -17:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((AccountEntityData) resetsizecounter.lookAheadTest).getOfflinePublicKey();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -16:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((AuthenticatedEntityRepository) resetsizecounter.lookAheadTest).createAccountData();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -15:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((QrPayEntityRepository) resetsizecounter.lookAheadTest).holdLoginV1EntityRepository;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -14:
                            i4 = 61;
                            break;
                        case -13:
                            resetsizecounter.scheduleImpl = new Function() { // from class: id.dana.data.qrpay.QrPayEntityRepository$$ExternalSyntheticLambda9
                                @Override // io.reactivex.functions.Function
                                public final Object apply(Object obj) {
                                    return QrPayEntityRepository.lambda$init$1((String) obj);
                                }
                            };
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -12:
                            resetsizecounter.getAuthRequestContext = 2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            Observable observable2 = (Observable) resetsizecounter.lookAheadTest;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = observable2.doOnNext((Consumer) resetsizecounter.lookAheadTest);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -11:
                            i4 = 47;
                            break;
                        case -10:
                            i4 = 45;
                            break;
                        case -9:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(23);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory != 0) {
                                i4 = i5;
                                break;
                            } else {
                                i4 = 37;
                                break;
                            }
                        case -8:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            MyBillsEntityDataFactory = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i4 = i5;
                            break;
                        case -7:
                            resetsizecounter.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                            i4 = i5;
                            break;
                        case -6:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i4 = 92;
                                break;
                            } else {
                                i4 = 55;
                                break;
                            }
                        case -5:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            throw ((Throwable) resetsizecounter.lookAheadTest);
                        case -4:
                            i4 = 38;
                            break;
                        case -3:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            final QrPayEntityRepository qrPayEntityRepository = (QrPayEntityRepository) resetsizecounter.lookAheadTest;
                            resetsizecounter.scheduleImpl = new Consumer() { // from class: id.dana.data.qrpay.QrPayEntityRepository$$ExternalSyntheticLambda8
                                @Override // io.reactivex.functions.Consumer
                                public final void accept(Object obj) {
                                    QrPayEntityRepository.this.m1717lambda$init$0$iddanadataqrpayQrPayEntityRepository((String) obj);
                                }
                            };
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -2:
                            resetsizecounter.getAuthRequestContext = 2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            QrPayEntityRepository qrPayEntityRepository2 = (QrPayEntityRepository) resetsizecounter.lookAheadTest;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = qrPayEntityRepository2.keyedRequest((Observable) resetsizecounter.lookAheadTest);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -1:
                            i4 = 89;
                            break;
                        default:
                            i4 = i5;
                            break;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            throw th;
        } catch (Throwable th5) {
            Throwable cause3 = th5.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0353, code lost:
    
        if (r10 <= 52) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03aa, code lost:
    
        if (r10 <= 61) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x042c, code lost:
    
        if (r10 <= 102) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0303, code lost:
    
        if (r10 <= 30) goto L85;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<java.lang.Boolean> initOfflinePay() {
        /*
            Method dump skipped, instructions count: 1208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.initOfflinePay():io.reactivex.Observable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03c9, code lost:
    
        if (r8 <= 44) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x033d, code lost:
    
        if (r8 <= 12) goto L84;
     */
    /* renamed from: lambda$getKey$3$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ io.reactivex.ObservableSource m1715lambda$getKey$3$iddanadataqrpayQrPayEntityRepository(io.reactivex.Observable r19, java.lang.String r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.m1715lambda$getKey$3$iddanadataqrpayQrPayEntityRepository(io.reactivex.Observable, java.lang.String):io.reactivex.ObservableSource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0424, code lost:
    
        if (r10 <= 88) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04b8, code lost:
    
        if (r10 <= 122) goto L112;
     */
    /* renamed from: lambda$getKey$4$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ io.reactivex.Observable m1716lambda$getKey$4$iddanadataqrpayQrPayEntityRepository(io.reactivex.Observable r19, java.lang.Throwable r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.m1716lambda$getKey$4$iddanadataqrpayQrPayEntityRepository(io.reactivex.Observable, java.lang.Throwable):io.reactivex.Observable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0281, code lost:
    
        if (r12 <= 52) goto L62;
     */
    /* renamed from: lambda$init$0$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void m1717lambda$init$0$iddanadataqrpayQrPayEntityRepository(java.lang.String r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.m1717lambda$init$0$iddanadataqrpayQrPayEntityRepository(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initOfflinePay$5$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1718lambda$initOfflinePay$5$iddanadataqrpayQrPayEntityRepository(String str) throws Exception {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        Object[] objArr8;
        int i;
        Class<?> cls;
        Object[] objArr9;
        resetSizeCounter resetsizecounter = new resetSizeCounter(this, str);
        Object[] objArr10 = new Object[1];
        a((short) 2833, (short) DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE, BuiltInFictitiousFunctionClassFactory[71], objArr10);
        char c = 0;
        String str2 = (String) objArr10[0];
        short s = (short) 2146;
        short s2 = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr11 = new Object[1];
        a(s, s2, (byte) s2, objArr11);
        try {
            Object[] objArr12 = {(String) objArr11[0]};
            short s3 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr13 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr13);
            Class<?> cls2 = Class.forName((String) objArr13[0]);
            short s4 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr14 = new Object[1];
            a((short) 4760, s4, (byte) (s4 | 67), objArr14);
            String str3 = (String) objArr14[0];
            Object[] objArr15 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr15);
            Object[] objArr16 = (Object[]) cls2.getMethod(str3, Class.forName((String) objArr15[0])).invoke(str2, objArr12);
            int[] iArr = new int[objArr16.length];
            int i2 = 0;
            while (i2 < objArr16.length) {
                try {
                    Object[] objArr17 = new Object[1];
                    objArr17[c] = objArr16[i2];
                    short s5 = (short) 5420;
                    short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr18 = new Object[1];
                    a(s5, s6, (byte) (s6 | 46), objArr18);
                    Class<?> cls3 = Class.forName((String) objArr18[c]);
                    Object[] objArr19 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr19);
                    String str4 = (String) objArr19[0];
                    Object[] objArr20 = new Object[1];
                    a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr20);
                    Object invoke = cls3.getMethod(str4, Class.forName((String) objArr20[0])).invoke(null, objArr17);
                    try {
                        short s7 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr21 = new Object[1];
                        a(s5, s7, (byte) (s7 | 46), objArr21);
                        Class<?> cls4 = Class.forName((String) objArr21[0]);
                        Object[] objArr22 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr22);
                        iArr[i2] = ((Integer) cls4.getMethod((String) objArr22[0], null).invoke(invoke, null)).intValue();
                        i2++;
                        c = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i3 = 31;
            int i4 = 3;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                try {
                    switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i5])) {
                        case -22:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i3);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i5 = 66;
                                break;
                            } else {
                                i5 = 73;
                                break;
                            }
                        case -21:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            return (ObservableSource) resetsizecounter.lookAheadTest;
                        case -20:
                            i5 = 31;
                            break;
                        case -19:
                            resetsizecounter.getAuthRequestContext = i4;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            QrPayEntityData qrPayEntityData = (QrPayEntityData) resetsizecounter.lookAheadTest;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            String str5 = (String) resetsizecounter.lookAheadTest;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            qrPayEntityData.init(str5, resetsizecounter.BuiltInFictitiousFunctionClassFactory);
                            i5 = i6;
                            break;
                        case -18:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((QrPayEntityRepository) resetsizecounter.lookAheadTest).createQrPayData();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i5 = i6;
                            break;
                        case -17:
                            i5 = 1;
                            break;
                        case -16:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(57);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory != 0) {
                                i5 = i6;
                                break;
                            } else {
                                i5 = 65;
                                break;
                            }
                        case -15:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            KClassImpl$Data$declaredNonStaticMembers$2 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i5 = i6;
                            break;
                        case -14:
                            resetsizecounter.getAuthRequestContext = MyBillsEntityDataFactory;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i4);
                            i5 = i6;
                            break;
                        case -13:
                            i5 = 3;
                            break;
                        case -12:
                            i5 = 78;
                            break;
                        case -11:
                            i5 = 44;
                            break;
                        case -10:
                            try {
                                resetsizecounter.getAuthRequestContext = 1;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                                resetsizecounter.scheduleImpl = Observable.just(resetsizecounter.lookAheadTest);
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                                i5 = i6;
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                                short s8 = (short) 6670;
                                short s9 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                objArr = new Object[1];
                                a(s8, s9, (byte) (s9 | 32), objArr);
                                if (Class.forName((String) objArr[0]).isInstance(th)) {
                                }
                                short s10 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                objArr2 = new Object[1];
                                a((short) 2113, s10, (byte) (s10 | 44), objArr2);
                                if (Class.forName((String) objArr2[0]).isInstance(th)) {
                                    break;
                                }
                                objArr3 = new Object[1];
                                a((short) 5377, BuiltInFictitiousFunctionClassFactory[21], b, objArr3);
                                if (Class.forName((String) objArr3[0]).isInstance(th)) {
                                }
                                short s11 = (short) 3014;
                                short s12 = (short) (BuiltInFictitiousFunctionClassFactory[1280] + 1);
                                objArr4 = new Object[1];
                                a(s11, s12, (byte) (s12 | 24), objArr4);
                                if (Class.forName((String) objArr4[0]).isInstance(th)) {
                                }
                                short s13 = BuiltInFictitiousFunctionClassFactory[1306];
                                objArr5 = new Object[1];
                                a((short) 227, s13, (byte) (s13 | 34), objArr5);
                                if (Class.forName((String) objArr5[0]).isInstance(th)) {
                                    break;
                                }
                                short s14 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                objArr6 = new Object[1];
                                a(s8, s14, (byte) (s14 | 32), objArr6);
                                if (Class.forName((String) objArr6[0]).isInstance(th)) {
                                    break;
                                }
                                objArr7 = new Object[1];
                                a(s, BuiltInFictitiousFunctionClassFactory[44], b, objArr7);
                                if (Class.forName((String) objArr7[0]).isInstance(th)) {
                                    break;
                                }
                                short s15 = (short) (BuiltInFictitiousFunctionClassFactory[1280] + 1);
                                objArr8 = new Object[1];
                                a(s11, s15, (byte) (s15 | 24), objArr8);
                                if (Class.forName((String) objArr8[0]).isInstance(th)) {
                                    break;
                                }
                                throw th;
                            }
                            break;
                        case -9:
                            short s16 = (short) 3576;
                            try {
                                try {
                                    short s17 = BuiltInFictitiousFunctionClassFactory[3107];
                                    Object[] objArr23 = new Object[1];
                                    a(s16, s17, (byte) (s17 | 46), objArr23);
                                    cls = Class.forName((String) objArr23[0]);
                                    objArr9 = new Object[1];
                                    a((short) 2573, BuiltInFictitiousFunctionClassFactory[83], (byte) (-BuiltInFictitiousFunctionClassFactory[53]), objArr9);
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                try {
                                    resetsizecounter.scheduleImpl = cls.getField((String) objArr9[0]).get(null);
                                    resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                                    i5 = i6;
                                } catch (Throwable th5) {
                                    th = th5;
                                    short s82 = (short) 6670;
                                    short s92 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                    objArr = new Object[1];
                                    a(s82, s92, (byte) (s92 | 32), objArr);
                                    if (Class.forName((String) objArr[0]).isInstance(th) || i6 < i4 || i6 > 4) {
                                        short s102 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                        objArr2 = new Object[1];
                                        a((short) 2113, s102, (byte) (s102 | 44), objArr2);
                                        if (Class.forName((String) objArr2[0]).isInstance(th) || i6 < 25 || i6 > 26) {
                                            objArr3 = new Object[1];
                                            a((short) 5377, BuiltInFictitiousFunctionClassFactory[21], b, objArr3);
                                            if (Class.forName((String) objArr3[0]).isInstance(th) || i6 < i3 || i6 > 32) {
                                                short s112 = (short) 3014;
                                                short s122 = (short) (BuiltInFictitiousFunctionClassFactory[1280] + 1);
                                                objArr4 = new Object[1];
                                                a(s112, s122, (byte) (s122 | 24), objArr4);
                                                if (Class.forName((String) objArr4[0]).isInstance(th) || i6 < 32 || i6 > 34) {
                                                    short s132 = BuiltInFictitiousFunctionClassFactory[1306];
                                                    objArr5 = new Object[1];
                                                    a((short) 227, s132, (byte) (s132 | 34), objArr5);
                                                    if (Class.forName((String) objArr5[0]).isInstance(th) || i6 < 44 || i6 > 45) {
                                                        short s142 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                                        objArr6 = new Object[1];
                                                        a(s82, s142, (byte) (s142 | 32), objArr6);
                                                        if (Class.forName((String) objArr6[0]).isInstance(th) || i6 < 60 || i6 > 66) {
                                                            objArr7 = new Object[1];
                                                            a(s, BuiltInFictitiousFunctionClassFactory[44], b, objArr7);
                                                            if (Class.forName((String) objArr7[0]).isInstance(th) || i6 < 69 || i6 > 70) {
                                                                short s152 = (short) (BuiltInFictitiousFunctionClassFactory[1280] + 1);
                                                                objArr8 = new Object[1];
                                                                a(s112, s152, (byte) (s152 | 24), objArr8);
                                                                if (Class.forName((String) objArr8[0]).isInstance(th) || i6 < 76 || i6 > 77) {
                                                                    throw th;
                                                                }
                                                                i = 34;
                                                                resetsizecounter.scheduleImpl = th;
                                                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                                                i5 = i;
                                                                i3 = 31;
                                                                i4 = 3;
                                                            } else {
                                                                i = 2;
                                                                resetsizecounter.scheduleImpl = th;
                                                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                                                i5 = i;
                                                                i3 = 31;
                                                                i4 = 3;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            i = 34;
                                            resetsizecounter.scheduleImpl = th;
                                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                            i5 = i;
                                            i3 = 31;
                                            i4 = 3;
                                        }
                                    }
                                    i = 2;
                                    resetsizecounter.scheduleImpl = th;
                                    resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                    i5 = i;
                                    i3 = 31;
                                    i4 = 3;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                            break;
                        case -8:
                            i5 = 37;
                            break;
                        case -7:
                            i5 = 35;
                            break;
                        case -6:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(23);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory != 0) {
                                i5 = i6;
                                break;
                            } else {
                                i5 = 30;
                                break;
                            }
                        case -5:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            MyBillsEntityDataFactory = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i5 = i6;
                            break;
                        case -4:
                            resetsizecounter.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(i4);
                            i5 = i6;
                            break;
                        case -3:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            throw ((Throwable) resetsizecounter.lookAheadTest);
                            break;
                        case -2:
                            i5 = 71;
                            break;
                        case -1:
                            i5 = 39;
                            break;
                        default:
                            i5 = i6;
                            break;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        } catch (Throwable th8) {
            Throwable cause3 = th8.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$restart$7$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1719lambda$restart$7$iddanadataqrpayQrPayEntityRepository(String str) throws Exception {
        resetSizeCounter resetsizecounter = new resetSizeCounter(this, str);
        short s = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr = new Object[1];
        a(s, (short) (s | 160), r0[71], objArr);
        String str2 = (String) objArr[0];
        short s2 = BuiltInFictitiousFunctionClassFactory[30];
        Object[] objArr2 = new Object[1];
        a((short) 2146, s2, (byte) s2, objArr2);
        try {
            Object[] objArr3 = {(String) objArr2[0]};
            short s3 = (short) 3348;
            byte b = (byte) 62;
            Object[] objArr4 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            short s4 = BuiltInFictitiousFunctionClassFactory[86];
            Object[] objArr5 = new Object[1];
            a((short) 4760, s4, (byte) (s4 | 67), objArr5);
            String str3 = (String) objArr5[0];
            Object[] objArr6 = new Object[1];
            a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr6);
            Object[] objArr7 = (Object[]) cls.getMethod(str3, Class.forName((String) objArr6[0])).invoke(str2, objArr3);
            int[] iArr = new int[objArr7.length];
            for (int i = 0; i < objArr7.length; i++) {
                try {
                    Object[] objArr8 = {objArr7[i]};
                    short s5 = (short) 5420;
                    short s6 = BuiltInFictitiousFunctionClassFactory[3107];
                    Object[] objArr9 = new Object[1];
                    a(s5, s6, (byte) (s6 | 46), objArr9);
                    Class<?> cls2 = Class.forName((String) objArr9[0]);
                    Object[] objArr10 = new Object[1];
                    a((short) 2846, BuiltInFictitiousFunctionClassFactory[101], (byte) 74, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(s3, BuiltInFictitiousFunctionClassFactory[23], b, objArr11);
                    Object invoke = cls2.getMethod(str4, Class.forName((String) objArr11[0])).invoke(null, objArr8);
                    try {
                        short s7 = BuiltInFictitiousFunctionClassFactory[3107];
                        Object[] objArr12 = new Object[1];
                        a(s5, s7, (byte) (s7 | 46), objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((short) 2840, BuiltInFictitiousFunctionClassFactory[19], (byte) (-BuiltInFictitiousFunctionClassFactory[12]), objArr13);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr13[0], null).invoke(invoke, null)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 6;
            int i3 = 32;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                try {
                    switch (resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(iArr[i4])) {
                        case -14:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            throw ((Throwable) resetsizecounter.lookAheadTest);
                            break;
                        case -13:
                            i4 = 36;
                            break;
                        case -12:
                            try {
                                resetsizecounter.getAuthRequestContext = 3;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                                QrPayEntityData qrPayEntityData = (QrPayEntityData) resetsizecounter.lookAheadTest;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                                String str5 = (String) resetsizecounter.lookAheadTest;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                                resetsizecounter.scheduleImpl = qrPayEntityData.reStart(str5, resetsizecounter.BuiltInFictitiousFunctionClassFactory);
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                                i4 = i5;
                            } catch (Throwable th3) {
                                th = th3;
                                short s8 = (short) (BuiltInFictitiousFunctionClassFactory[52] - 1);
                                Object[] objArr14 = new Object[1];
                                a((short) 2113, s8, (byte) (s8 | 44), objArr14);
                                boolean isInstance = Class.forName((String) objArr14[0]).isInstance(th);
                                int i6 = 44;
                                if (!isInstance || i5 < i2 || i5 > i3) {
                                    short s9 = (short) (-BuiltInFictitiousFunctionClassFactory[i2]);
                                    Object[] objArr15 = new Object[1];
                                    a((short) 2540, s9, b, objArr15);
                                    if (!Class.forName((String) objArr15[0]).isInstance(th) || i5 < 26 || i5 > i3) {
                                        short s10 = (short) (BuiltInFictitiousFunctionClassFactory[14] - 1);
                                        Object[] objArr16 = new Object[1];
                                        a((short) 6670, s10, (byte) (s10 | 32), objArr16);
                                        if (!Class.forName((String) objArr16[0]).isInstance(th) || i5 < 41 || i5 > 43) {
                                            short s11 = BuiltInFictitiousFunctionClassFactory[49];
                                            Object[] objArr17 = new Object[1];
                                            a((short) 6640, s11, (byte) (s11 | 28), objArr17);
                                            if (!Class.forName((String) objArr17[0]).isInstance(th) || i5 < 48 || i5 > 50) {
                                                throw th;
                                            }
                                        } else {
                                            i6 = 43;
                                        }
                                    }
                                }
                                resetsizecounter.scheduleImpl = th;
                                resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(41);
                                i4 = i6;
                                i2 = 6;
                                i3 = 32;
                            }
                            break;
                        case -11:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(27);
                            resetsizecounter.scheduleImpl = ((QrPayEntityRepository) resetsizecounter.lookAheadTest).createQrPayData();
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(28);
                            i4 = i5;
                            break;
                        case -10:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(1);
                            return (ObservableSource) resetsizecounter.lookAheadTest;
                        case -9:
                            i4 = 6;
                            break;
                        case -8:
                            i4 = 4;
                            break;
                        case -7:
                            i4 = 2;
                            break;
                        case -6:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(23);
                            if (resetsizecounter.BuiltInFictitiousFunctionClassFactory == 0) {
                                i4 = 31;
                                break;
                            } else {
                                i4 = i5;
                                break;
                            }
                        case -5:
                            resetsizecounter.getAuthRequestContext = 1;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(20);
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(21);
                            MyBillsEntityDataFactory = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            i4 = i5;
                            break;
                        case -4:
                            resetsizecounter.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(3);
                            i4 = i5;
                            break;
                        case -3:
                            i4 = 1;
                            break;
                        case -2:
                            resetsizecounter.KClassImpl$Data$declaredNonStaticMembers$2(31);
                            int i7 = resetsizecounter.BuiltInFictitiousFunctionClassFactory;
                            if (i7 != 0 && i7 == 1) {
                                i4 = 38;
                                break;
                            }
                            i4 = 45;
                            break;
                        case -1:
                            i4 = 32;
                            break;
                        default:
                            i4 = i5;
                            break;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            Throwable cause3 = th5.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0257, code lost:
    
        if (r9 <= 9) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02a6, code lost:
    
        if (r9 <= 31) goto L82;
     */
    /* renamed from: lambda$setSeedExtra$8$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ io.reactivex.ObservableSource m1720lambda$setSeedExtra$8$iddanadataqrpayQrPayEntityRepository(java.lang.String r18, java.lang.String r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.m1720lambda$setSeedExtra$8$iddanadataqrpayQrPayEntityRepository(java.lang.String, java.lang.String):io.reactivex.ObservableSource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0260, code lost:
    
        if (r10 <= 16) goto L76;
     */
    /* renamed from: lambda$start$6$id-dana-data-qrpay-QrPayEntityRepository  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ io.reactivex.ObservableSource m1721lambda$start$6$iddanadataqrpayQrPayEntityRepository(java.lang.String r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 878
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.m1721lambda$start$6$iddanadataqrpayQrPayEntityRepository(java.lang.String):io.reactivex.ObservableSource");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02bb, code lost:
    
        if (r11 <= 40) goto L99;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean pause() {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.pause():java.lang.Boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0403, code lost:
    
        if (r9 <= 76) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x042b, code lost:
    
        if (r9 <= 76) goto L84;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<java.lang.Boolean> restart() {
        /*
            Method dump skipped, instructions count: 1212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.restart():io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x03bb, code lost:
    
        if (r12 <= 62) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x045c, code lost:
    
        if (r12 <= 108) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0483, code lost:
    
        if (r12 <= 114) goto L99;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<java.lang.Boolean> setSeedExtra(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 1264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.setSeedExtra(java.lang.String):io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x03aa, code lost:
    
        if (r14 <= 51) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x03d1, code lost:
    
        if (r14 <= 63) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0401, code lost:
    
        if (r14 <= 63) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0482, code lost:
    
        if (r14 <= 79) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0313, code lost:
    
        if (r14 <= 35) goto L85;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<java.lang.Boolean> start() {
        /*
            Method dump skipped, instructions count: 1254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.start():io.reactivex.Observable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x021d, code lost:
    
        if (r10 <= 12) goto L63;
     */
    @Override // id.dana.domain.qrpay.QrPayRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean stop() {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrpay.QrPayEntityRepository.stop():java.lang.Boolean");
    }

    @Inject
    public QrPayEntityRepository(QrPayEntityDataFactory qrPayEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory, PaymentModelMapper paymentModelMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        try {
            this.qrPayEntityDataFactory = qrPayEntityDataFactory;
            this.securityEntityDataFactory = securityEntityDataFactory;
            try {
                this.paymentModelMapper = paymentModelMapper;
                try {
                    this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
                } catch (ArrayStoreException e) {
                    throw e;
                }
            } catch (ArrayStoreException e2) {
            }
        } catch (UnsupportedOperationException e3) {
            throw e3;
        }
    }
}
