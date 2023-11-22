package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class ConstraintSet {
    public String BuiltInFictitiousFunctionClassFactory;
    public boolean moveToNextValue;
    private static final int[] getErrorConfigVersion = {0, 4, 8};
    private static SparseIntArray NetworkUserEntityData$$ExternalSyntheticLambda0 = new SparseIntArray();
    private static SparseIntArray scheduleImpl = new SparseIntArray();
    public String MyBillsEntityDataFactory = "";
    public int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private HashMap<String, ConstraintAttribute> lookAheadTest = new HashMap<>();
    public boolean PlaceComponentResult = true;
    public HashMap<Integer, Constraint> getAuthRequestContext = new HashMap<>();

    /* loaded from: classes6.dex */
    class WriteJsonEngine {
    }

    /* loaded from: classes6.dex */
    class WriteXmlEngine {
    }

    private static String PlaceComponentResult(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getMessaging, 25);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.FloatPoint, 26);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.LinearSmoothScroller, 29);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setDistrictAdcode, 30);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.GroupRecipientPermissionHelper, 36);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.access$loadDashboardData, 35);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.BarcodeUtil$$ExternalSyntheticLambda0, 4);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY, 3);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.CreateCredentialCustomException, 1);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.toFullstoryConfig, 91);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getLastClearRequest, 92);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.GifDrawableTransformation, 6);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.OrAudience, 7);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.BarcodeUtil$$ExternalSyntheticLambda1, 17);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.VerifyPushDerollRequest, 18);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setBackgroundTime, 19);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ServiceStarter, 99);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.TimeoutError, 27);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.forEach, 32);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.clearStatesNotIn, 33);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SeekBarStopChangeEvent, 10);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.onLoadComplete, 9);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getThread, 13);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.X509CRL, 16);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.onSuccessLoadMoreReview, 14);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.AttributeView, 11);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.MyBillsActivity$provideServicesModule$1, 15);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.Clause, 12);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.PaylaterRegistrationCooldownCache, 40);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.EventLoopImplBase$DelayedRunnableTask, 39);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.DialogTncInformation_ViewBinding, 41);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setBackgroundTint, 42);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.Code128Reader, 20);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SokalSneathDissimilarity, 37);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.BridgeActivity, 5);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.times, 87);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1, 87);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getDirName, 87);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.MapPageContract$Presenter, 87);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SourceParamUtil$DanaKagetClaimSource, 87);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.targetValue, 24);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.saveNickname, 28);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.FontsContractCompat$FontRequestCallback, 31);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.access$showKycAmlEddDialog, 8);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ContentDeliveryCacheEntityDataFactory, 34);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.createSecondaryAnimatorProvider, 2);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ImageCaptureViewModel$getTipUploadPhoto$1, 23);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.onGetActiveNotifications, 21);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SwitchFaceAuthContract, 95);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.PromoExploreModule_ProvidesPresenterFactory, 96);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.VerifyPasswordFacade, 22);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setRibbonLineTopText, 43);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.NearbyConstantsKt, 44);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.itemClicked$core, 45);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ImageCaptureViewModel$getTipUploadPhoto$2, 46);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.GetExpressPurchaseResponse$PriceEntity, 60);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setMatchingBeaconTypeCode, 47);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.parametersAsMap, 48);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.TrustRiskLogin$Params, 49);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ResourceResponseInfo, 50);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider, 51);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SightCameraView$ICameraFrameListener, 52);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider, 53);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getKybKaFilter, 54);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.DeserializedCallableMemberDescriptor, 55);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.OcrImagePreprocessingConfigModel, 56);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setNewRibbon, 57);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.TaskListBlock, 58);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ItemSnapshotList, 59);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.initResult, 61);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getSharingAgreementIds, 62);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.longitude, 63);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SubmitReceiptRequest, 64);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.NearbySearchPresenter$getNearbyTrendingKeyword$2, 65);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.resetSizeCounter, 66);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.NearbySearchPresenter$getNearbyTrendingKeyword$1, 67);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.access$setGoToMyLocationVisibility, 79);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ViewInputOtpBinding, 38);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ViewPayConfirmationAddOnBinding, 68);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setValue, 69);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.timer, 70);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.getImageAssetsFolder, 97);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.onCubeAppPerfEvent, 71);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.HttpClientAttributesExtractorBuilder, 72);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.QueryPayMethod, 73);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.ListPopupWindow$Api29Impl, 74);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.SearchConditionEntityKt, 75);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask, 76);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.addAutoLogActivity, 77);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.appendStatementEnd, 78);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.buildStats, 80);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.clearMerchantList, 81);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.setAmountToSent, 82);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.MyBillsFacade, 83);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.access$getMerchantInfoRepository$p, 84);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.notifyTakenPictureError, 85);
        NetworkUserEntityData$$ExternalSyntheticLambda0.append(R.styleable.PopupModel, 86);
        scheduleImpl.append(R.styleable.glVertexAttrib1fv, 6);
        scheduleImpl.append(R.styleable.glVertexAttrib1fv, 7);
        scheduleImpl.append(R.styleable.ConcurrentKt, 27);
        scheduleImpl.append(R.styleable.flow, 13);
        scheduleImpl.append(R.styleable.getTypeMappings, 16);
        scheduleImpl.append(R.styleable.AppCategory, 14);
        scheduleImpl.append(R.styleable.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider, 11);
        scheduleImpl.append(R.styleable.GetTopUpUserConsult, 15);
        scheduleImpl.append(R.styleable.RepaymentPlan, 12);
        scheduleImpl.append(R.styleable.EmergencyNotifActivity$getEmergencyNotifModule$1, 40);
        scheduleImpl.append(R.styleable.SubmitReceiptResultModel$Creator, 39);
        scheduleImpl.append(R.styleable.f12$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM, 41);
        scheduleImpl.append(R.styleable.getStackFromEnd, 42);
        scheduleImpl.append(R.styleable.getGnBenefitEntityDanaProtection, 20);
        scheduleImpl.append(R.styleable.SplitSavingConfigEntityData, 37);
        scheduleImpl.append(R.styleable.PrefetchDownloadStatus, 5);
        scheduleImpl.append(R.styleable.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl, 87);
        scheduleImpl.append(R.styleable.FamilyDashboardPresenter_Factory, 87);
        scheduleImpl.append(R.styleable.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0, 87);
        scheduleImpl.append(R.styleable.onTooManyRedirects, 87);
        scheduleImpl.append(R.styleable.checkParameterIsNotNull, 87);
        scheduleImpl.append(R.styleable.SecuritySettingsActivity$createPinLauncher$2$2, 24);
        scheduleImpl.append(R.styleable.CheckPromoQuestFeature, 28);
        scheduleImpl.append(R.styleable.f18x461046d9, 31);
        scheduleImpl.append(R.styleable.BaseSocialFeedContract$Presenter, 8);
        scheduleImpl.append(R.styleable.ArrayTable$3, 34);
        scheduleImpl.append(R.styleable.applyTrimPathIfNeeded, 2);
        scheduleImpl.append(R.styleable.containsObjectForKey, 23);
        scheduleImpl.append(R.styleable.SecuritySettingsActivity$createPinLauncher$2$1, 21);
        scheduleImpl.append(R.styleable.doCommonLog, 95);
        scheduleImpl.append(R.styleable.murmurHash64WithSeed, 96);
        scheduleImpl.append(R.styleable.InvestmentWalletAdapter, 22);
        scheduleImpl.append(R.styleable.getTextEndPadding, 43);
        scheduleImpl.append(R.styleable.encodingStream, 44);
        scheduleImpl.append(R.styleable.f19x461046da, 45);
        scheduleImpl.append(R.styleable.ArrayTable$2, 46);
        scheduleImpl.append(R.styleable.WithdrawSavedCardChannelView, 60);
        scheduleImpl.append(R.styleable.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1, 47);
        scheduleImpl.append(R.styleable.ArrayTable$1, 48);
        scheduleImpl.append(R.styleable.View$OnClickListener, 49);
        scheduleImpl.append(R.styleable.SchedulerPoolFactory, 50);
        scheduleImpl.append(R.styleable.BannerEntityDataFactory_Factory, 51);
        scheduleImpl.append(R.styleable.getPhoneMask, 52);
        scheduleImpl.append(R.styleable.DebugCoroutineInfoImpl, 53);
        scheduleImpl.append(R.styleable.isAllowRetry, 54);
        scheduleImpl.append(R.styleable.TypeToken$TypeSet, 55);
        scheduleImpl.append(R.styleable.NavigationMenuPresenter$HeaderViewHolder, 56);
        scheduleImpl.append(R.styleable.storeUserConfig, 57);
        scheduleImpl.append(R.styleable.f25getWalletV3RecommendationConfig$lambda193, 58);
        scheduleImpl.append(R.styleable.setValuePrefixBytes, 59);
        scheduleImpl.append(R.styleable.createJavaMethod, 62);
        scheduleImpl.append(R.styleable.checkMarmotConfig, 63);
        scheduleImpl.append(R.styleable.getExceptionOrNull, 64);
        scheduleImpl.append(R.styleable.setAkuEntranceOpen, 65);
        scheduleImpl.append(R.styleable.getOpPackageName, 66);
        scheduleImpl.append(R.styleable.SplitReferralConfigEntityData_Factory, 67);
        scheduleImpl.append(R.styleable.$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8, 79);
        scheduleImpl.append(R.styleable.isInfoWindowShown, 38);
        scheduleImpl.append(R.styleable.TwilioRepository, 98);
        scheduleImpl.append(R.styleable.removeFloat, 68);
        scheduleImpl.append(R.styleable.setIndex$kotlin_stdlib, 69);
        scheduleImpl.append(R.styleable.isTmpDetached, 70);
        scheduleImpl.append(R.styleable.PlaybackStateCompat$MediaKeyAction, 71);
        scheduleImpl.append(R.styleable.onPolygonsChanged, 72);
        scheduleImpl.append(R.styleable.getRecommendationData, 73);
        scheduleImpl.append(R.styleable.outerType, 74);
        scheduleImpl.append(R.styleable.TrackerKey$GlobalSearchOpenProperties, 75);
        scheduleImpl.append(R.styleable.getSavingConfigPresenter, 76);
        scheduleImpl.append(R.styleable.StandardRowSortedTable$1, 77);
        scheduleImpl.append(R.styleable.roundToPowerOfTwo, 78);
        scheduleImpl.append(R.styleable.UnicastProcessor$UnicastQueueSubscription, 80);
        scheduleImpl.append(R.styleable.MultiLanguageHttpClient, 81);
        scheduleImpl.append(R.styleable.connectionSpecs, 82);
        scheduleImpl.append(R.styleable.getNrCsiRsrp, 83);
        scheduleImpl.append(R.styleable.allowedTargets, 84);
        scheduleImpl.append(R.styleable.ISO8601Utils, 85);
        scheduleImpl.append(R.styleable.access$getFeaturedBankListAdapter$p, 86);
        scheduleImpl.append(R.styleable.fromContextOrNull, 97);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, TypedArray typedArray, int i, int i2) {
        if (obj == null) {
            return;
        }
        int i3 = typedArray.peekValue(i).type;
        if (i3 == 3) {
            MyBillsEntityDataFactory(obj, typedArray.getString(i), i2);
            return;
        }
        int i4 = -2;
        boolean z = false;
        if (i3 == 5) {
            i4 = typedArray.getDimensionPixelSize(i, 0);
        } else {
            int i5 = typedArray.getInt(i, 0);
            if (i5 != -4) {
                i4 = (i5 == -3 || !(i5 == -2 || i5 == -1)) ? 0 : i5;
            } else {
                z = true;
            }
        }
        if (obj instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
            if (i2 == 0) {
                layoutParams.width = i4;
                layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
                return;
            }
            layoutParams.height = i4;
            layoutParams.moveToNextValue = z;
        } else if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            if (i2 == 0) {
                layout.O = i4;
                layout.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
                return;
            }
            layout.G = i4;
            layout.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
        } else if (obj instanceof Constraint.Delta) {
            Constraint.Delta delta = (Constraint.Delta) obj;
            if (i2 == 0) {
                delta.KClassImpl$Data$declaredNonStaticMembers$2(23, i4);
                delta.KClassImpl$Data$declaredNonStaticMembers$2(80, z);
                return;
            }
            delta.KClassImpl$Data$declaredNonStaticMembers$2(21, i4);
            delta.KClassImpl$Data$declaredNonStaticMembers$2(81, z);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(ConstraintLayout.LayoutParams layoutParams, String str) {
        int i = -1;
        float f = Float.NaN;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i2 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i = 0;
                } else if (substring.equalsIgnoreCase(SummaryActivity.HOURS)) {
                    i = 1;
                }
                i2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = str.substring(i2, indexOf2);
                    String substring3 = str.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i == 1) {
                                f = Math.abs(parseFloat2 / parseFloat);
                                i = 1;
                            } else {
                                f = Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                } else {
                    String substring4 = str.substring(i2);
                    if (substring4.length() > 0) {
                        f = Float.parseFloat(substring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.GetContactSyncConfig = str;
        layoutParams.initRecordTimeStamp = f;
        layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
    }

    private static void MyBillsEntityDataFactory(Object obj, String str, int i) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if ("ratio".equalsIgnoreCase(trim)) {
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i == 0) {
                        layoutParams.width = 0;
                    } else {
                        layoutParams.height = 0;
                    }
                    BuiltInFictitiousFunctionClassFactory(layoutParams, trim2);
                    return;
                } else if (obj instanceof Layout) {
                    ((Layout) obj).initRecordTimeStamp = trim2;
                    return;
                } else if (obj instanceof Constraint.Delta) {
                    ((Constraint.Delta) obj).KClassImpl$Data$declaredNonStaticMembers$2(5, trim2);
                    return;
                } else {
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                        if (i == 0) {
                            layoutParams2.width = 0;
                            layoutParams2.getValueOfTouchPositionAbsolute = parseFloat;
                            return;
                        }
                        layoutParams2.height = 0;
                        layoutParams2.d = parseFloat;
                    } else if (obj instanceof Layout) {
                        Layout layout = (Layout) obj;
                        if (i == 0) {
                            layout.O = 0;
                            layout.getOnBoardingScenario = parseFloat;
                            return;
                        }
                        layout.G = 0;
                        layout.X = parseFloat;
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) obj;
                        if (i == 0) {
                            delta.KClassImpl$Data$declaredNonStaticMembers$2(23, 0);
                            delta.getAuthRequestContext(39, parseFloat);
                            return;
                        }
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(21, 0);
                        delta.getAuthRequestContext(40, parseFloat);
                    }
                } else if ("parent".equalsIgnoreCase(trim)) {
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                        if (i == 0) {
                            layoutParams3.width = 0;
                            layoutParams3.getNameOrBuilderList = max;
                            layoutParams3.H = 2;
                            return;
                        }
                        layoutParams3.height = 0;
                        layoutParams3.L = max;
                        layoutParams3.F = 2;
                    } else if (obj instanceof Layout) {
                        Layout layout2 = (Layout) obj;
                        if (i == 0) {
                            layout2.O = 0;
                            layout2.Y = max;
                            layout2.isAuto = 2;
                            return;
                        }
                        layout2.G = 0;
                        layout2.A = max;
                        layout2.readMicros = 2;
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) obj;
                        if (i == 0) {
                            delta2.KClassImpl$Data$declaredNonStaticMembers$2(23, 0);
                            delta2.KClassImpl$Data$declaredNonStaticMembers$2(54, 2);
                            return;
                        }
                        delta2.KClassImpl$Data$declaredNonStaticMembers$2(21, 0);
                        delta2.KClassImpl$Data$declaredNonStaticMembers$2(55, 2);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Layout {
        private static SparseIntArray Z;
        public int G;
        public String H;
        public int[] J;
        public String L;
        public int O;
        public boolean getNameOrBuilderList = false;
        public boolean getValueOfTouchPositionAbsolute = false;
        public boolean K = false;
        public int getCallingPid = -1;
        public int getSupportButtonTintMode = -1;
        public float SubSequence = -1.0f;
        public boolean whenAvailable = true;
        public int VerifyPinStateManager$executeRiskChallenge$2$2 = -1;
        public int D = -1;
        public int P = -1;
        public int SummaryVoucherView$$ExternalSyntheticLambda1 = -1;
        public int V = -1;
        public int W = -1;
        public int scheduleImpl = -1;
        public int lookAheadTest = -1;
        public int MyBillsEntityDataFactory = -1;
        public int PlaceComponentResult = -1;
        public int getAuthRequestContext = -1;
        public int S = -1;
        public int isAuth = -1;
        public int newProxyInstance = -1;
        public int isLayoutRequested = -1;
        public float BottomSheetCardBindingView$watcherCardNumberView$1 = 0.5f;
        public float U = 0.5f;
        public String initRecordTimeStamp = null;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        public int moveToNextValue = 0;
        public float getErrorConfigVersion = 0.0f;
        public int GetContactSyncConfig = -1;
        public int DatabaseTableConfigUtil = -1;
        public int N = -1;
        public int E = 0;
        public int SummaryVoucherView$$ExternalSyntheticLambda0 = 0;
        public int R = 0;
        public int BuiltInFictitiousFunctionClassFactory = 0;
        public int NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        public int SummaryVoucherView$$ExternalSyntheticLambda2 = 0;
        public int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        public int NetworkUserEntityData$$ExternalSyntheticLambda6 = Integer.MIN_VALUE;
        public int FragmentBottomSheetPaymentSettingBinding = Integer.MIN_VALUE;
        public int NetworkUserEntityData$$ExternalSyntheticLambda5 = Integer.MIN_VALUE;
        public int PrepareContext = Integer.MIN_VALUE;
        public int NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
        public int NetworkUserEntityData$$ExternalSyntheticLambda3 = Integer.MIN_VALUE;
        public int NetworkUserEntityData$$ExternalSyntheticLambda8 = Integer.MIN_VALUE;
        public float X = -1.0f;
        public float getOnBoardingScenario = -1.0f;
        public int B = 0;
        public int T = 0;
        public int isAuto = 0;
        public int readMicros = 0;
        public int shouldRecycleViewType = 0;
        public int C = 0;
        public int flip = 0;
        public int VerifyPinStateManager$executeRiskChallenge$2$1 = 0;
        public float Y = 1.0f;
        public float A = 1.0f;
        public int F = -1;
        public int I = 0;
        public int M = -1;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        public boolean AppCompatEmojiTextHelper = true;
        public int Q = 0;

        public final void PlaceComponentResult(Layout layout) {
            this.getNameOrBuilderList = layout.getNameOrBuilderList;
            this.O = layout.O;
            this.getValueOfTouchPositionAbsolute = layout.getValueOfTouchPositionAbsolute;
            this.G = layout.G;
            this.getCallingPid = layout.getCallingPid;
            this.getSupportButtonTintMode = layout.getSupportButtonTintMode;
            this.SubSequence = layout.SubSequence;
            this.whenAvailable = layout.whenAvailable;
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = layout.VerifyPinStateManager$executeRiskChallenge$2$2;
            this.D = layout.D;
            this.P = layout.P;
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = layout.SummaryVoucherView$$ExternalSyntheticLambda1;
            this.V = layout.V;
            this.W = layout.W;
            this.scheduleImpl = layout.scheduleImpl;
            this.lookAheadTest = layout.lookAheadTest;
            this.MyBillsEntityDataFactory = layout.MyBillsEntityDataFactory;
            this.PlaceComponentResult = layout.PlaceComponentResult;
            this.getAuthRequestContext = layout.getAuthRequestContext;
            this.S = layout.S;
            this.isAuth = layout.isAuth;
            this.newProxyInstance = layout.newProxyInstance;
            this.isLayoutRequested = layout.isLayoutRequested;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = layout.BottomSheetCardBindingView$watcherCardNumberView$1;
            this.U = layout.U;
            this.initRecordTimeStamp = layout.initRecordTimeStamp;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = layout.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.moveToNextValue = layout.moveToNextValue;
            this.getErrorConfigVersion = layout.getErrorConfigVersion;
            this.GetContactSyncConfig = layout.GetContactSyncConfig;
            this.DatabaseTableConfigUtil = layout.DatabaseTableConfigUtil;
            this.N = layout.N;
            this.E = layout.E;
            this.SummaryVoucherView$$ExternalSyntheticLambda0 = layout.SummaryVoucherView$$ExternalSyntheticLambda0;
            this.R = layout.R;
            this.BuiltInFictitiousFunctionClassFactory = layout.BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = layout.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.SummaryVoucherView$$ExternalSyntheticLambda2 = layout.SummaryVoucherView$$ExternalSyntheticLambda2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = layout.KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = layout.NetworkUserEntityData$$ExternalSyntheticLambda6;
            this.FragmentBottomSheetPaymentSettingBinding = layout.FragmentBottomSheetPaymentSettingBinding;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = layout.NetworkUserEntityData$$ExternalSyntheticLambda5;
            this.PrepareContext = layout.PrepareContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = layout.NetworkUserEntityData$$ExternalSyntheticLambda4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = layout.NetworkUserEntityData$$ExternalSyntheticLambda3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = layout.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.X = layout.X;
            this.getOnBoardingScenario = layout.getOnBoardingScenario;
            this.B = layout.B;
            this.T = layout.T;
            this.isAuto = layout.isAuto;
            this.readMicros = layout.readMicros;
            this.shouldRecycleViewType = layout.shouldRecycleViewType;
            this.C = layout.C;
            this.flip = layout.flip;
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = layout.VerifyPinStateManager$executeRiskChallenge$2$1;
            this.Y = layout.Y;
            this.A = layout.A;
            this.F = layout.F;
            this.I = layout.I;
            this.M = layout.M;
            this.H = layout.H;
            int[] iArr = layout.J;
            if (iArr != null && layout.L == null) {
                this.J = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.J = null;
            }
            this.L = layout.L;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = layout.NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = layout.NetworkUserEntityData$$ExternalSyntheticLambda2;
            this.AppCompatEmojiTextHelper = layout.AppCompatEmojiTextHelper;
            this.Q = layout.Q;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            Z = sparseIntArray;
            sparseIntArray.append(R.styleable.addOnSelectionChangedListener, 24);
            Z.append(R.styleable.getDefaultAsyncJsApiList, 25);
            Z.append(R.styleable.$r8$lambda$41qQ6liciC8qK_sJz7rcr6ft7NA, 28);
            Z.append(R.styleable.NfcAntennaInfo, 29);
            Z.append(R.styleable.SendMoneyPresenter_MembersInjector, 35);
            Z.append(R.styleable.Allocation$MipmapControl, 34);
            Z.append(R.styleable.RecordManager, 4);
            Z.append(R.styleable.StreamBitmapDecoder$UntrustedCallbacks, 3);
            Z.append(R.styleable.StreamConfigurationMap, 1);
            Z.append(R.styleable.ProductFlavor, 6);
            Z.append(R.styleable.parentColumn, 7);
            Z.append(R.styleable.getRssi, 17);
            Z.append(R.styleable.FeedNotificationSectionViewHolder, 18);
            Z.append(R.styleable.GlideExperiments$Builder, 19);
            Z.append(R.styleable.checkElementIndex$kotlin_stdlib, 90);
            Z.append(R.styleable.getSendMoneyEstimationTimeValue, 26);
            Z.append(R.styleable.BoundLongUpDownCounter, 31);
            Z.append(R.styleable.getPayMethod, 32);
            Z.append(R.styleable.Property$PropertyType$1, 10);
            Z.append(R.styleable.setTrackDrawable, 9);
            Z.append(R.styleable.DanaDealsVoucherOrderMapper_Factory, 13);
            Z.append(R.styleable.getJSON_KEY_AUTH_DATA$credentials_play_services_auth_release, 16);
            Z.append(R.styleable.getFadeModeThresholdFraction, 14);
            Z.append(R.styleable.Type, 11);
            Z.append(R.styleable.GetFeatureSendMoneyCashierNative, 15);
            Z.append(R.styleable.ContactsContract$DataColumnsWithJoins, 12);
            Z.append(R.styleable.ConfirmUpdateBalanceEmoney$Params, 38);
            Z.append(R.styleable.LoggerImplementation, 37);
            Z.append(R.styleable.DaggerPromoCenterComponent$PromoCenterComponentImpl$ProvidePaylaterRepositoryProvider, 39);
            Z.append(R.styleable.alertCameraNoPermissionDialog, 40);
            Z.append(R.styleable.clearJavaObjects, 20);
            Z.append(R.styleable.setValid, 36);
            Z.append(R.styleable.ActivityReactionsBottomSheetDialog$sortReactionCounts$$inlined$sortedByDescending$1, 5);
            Z.append(R.styleable.getKeyProgressIncrement, 91);
            Z.append(R.styleable.SummaryActivity$handleAccountFreezeSmartFriction$1, 91);
            Z.append(R.styleable._release, 91);
            Z.append(R.styleable.GetUserInfo, 91);
            Z.append(R.styleable.FSComposeAnnotatedString, 91);
            Z.append(R.styleable.ChannelLimitedFlowMerge, 23);
            Z.append(R.styleable.getWarmth, 27);
            Z.append(R.styleable.FeatureHoldLoginConfig, 30);
            Z.append(R.styleable.getGrowthFactor, 8);
            Z.append(R.styleable.setDocumentHeight, 33);
            Z.append(R.styleable.Locator, 2);
            Z.append(R.styleable.MediaStoreImageThumbLoader, 22);
            Z.append(R.styleable.enableMergePathsForKitKatAndAbove, 21);
            Z.append(R.styleable.setupButtonChild, 41);
            Z.append(R.styleable.MenuItemActionViewCollapseEvent, 42);
            Z.append(R.styleable.MerchantPhotoViewerComponent, 41);
            Z.append(R.styleable.getDiscountType, 42);
            Z.append(R.styleable.setH5OptionMenuTextFlag, 76);
            Z.append(R.styleable.unmodifiableSortedSetMultimap, 61);
            Z.append(R.styleable.setHelperTextAppearance, 62);
            Z.append(R.styleable.tntInstId, 63);
            Z.append(R.styleable.GlobalSearchFragment_MembersInjector, 69);
            Z.append(R.styleable.HttpTransporter, 70);
            Z.append(R.styleable.removeConsoleView, 71);
            Z.append(R.styleable.Interceptor4getComponentAuth, 72);
            Z.append(R.styleable.clearCanonicalScopes, 73);
            Z.append(R.styleable.addedContains, 74);
            Z.append(R.styleable.BioUtilityBridge_MembersInjector, 75);
        }

        final void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.updateViewSize);
            this.getValueOfTouchPositionAbsolute = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = Z.get(index);
                switch (i2) {
                    case 1:
                        this.MyBillsEntityDataFactory = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.MyBillsEntityDataFactory);
                        break;
                    case 2:
                        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimensionPixelSize(index, this.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 3:
                        this.lookAheadTest = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.lookAheadTest);
                        break;
                    case 4:
                        this.scheduleImpl = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.scheduleImpl);
                        break;
                    case 5:
                        this.initRecordTimeStamp = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.GetContactSyncConfig = obtainStyledAttributes.getDimensionPixelOffset(index, this.GetContactSyncConfig);
                        break;
                    case 7:
                        this.DatabaseTableConfigUtil = obtainStyledAttributes.getDimensionPixelOffset(index, this.DatabaseTableConfigUtil);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.isLayoutRequested = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.isLayoutRequested);
                        break;
                    case 10:
                        this.newProxyInstance = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.newProxyInstance);
                        break;
                    case 11:
                        this.PrepareContext = obtainStyledAttributes.getDimensionPixelSize(index, this.PrepareContext);
                        break;
                    case 12:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                        break;
                    case 13:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        break;
                    case 14:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
                        break;
                    case 15:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        break;
                    case 16:
                        this.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getDimensionPixelSize(index, this.FragmentBottomSheetPaymentSettingBinding);
                        break;
                    case 17:
                        this.getCallingPid = obtainStyledAttributes.getDimensionPixelOffset(index, this.getCallingPid);
                        break;
                    case 18:
                        this.getSupportButtonTintMode = obtainStyledAttributes.getDimensionPixelOffset(index, this.getSupportButtonTintMode);
                        break;
                    case 19:
                        this.SubSequence = obtainStyledAttributes.getFloat(index, this.SubSequence);
                        break;
                    case 20:
                        this.BottomSheetCardBindingView$watcherCardNumberView$1 = obtainStyledAttributes.getFloat(index, this.BottomSheetCardBindingView$watcherCardNumberView$1);
                        break;
                    case 21:
                        this.G = obtainStyledAttributes.getLayoutDimension(index, this.G);
                        break;
                    case 22:
                        this.O = obtainStyledAttributes.getLayoutDimension(index, this.O);
                        break;
                    case 23:
                        this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                        break;
                    case 24:
                        this.VerifyPinStateManager$executeRiskChallenge$2$2 = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.VerifyPinStateManager$executeRiskChallenge$2$2);
                        break;
                    case 25:
                        this.D = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.D);
                        break;
                    case 26:
                        this.N = obtainStyledAttributes.getInt(index, this.N);
                        break;
                    case 27:
                        this.SummaryVoucherView$$ExternalSyntheticLambda0 = obtainStyledAttributes.getDimensionPixelSize(index, this.SummaryVoucherView$$ExternalSyntheticLambda0);
                        break;
                    case 28:
                        this.P = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.P);
                        break;
                    case 29:
                        this.SummaryVoucherView$$ExternalSyntheticLambda1 = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.SummaryVoucherView$$ExternalSyntheticLambda1);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.SummaryVoucherView$$ExternalSyntheticLambda2 = obtainStyledAttributes.getDimensionPixelSize(index, this.SummaryVoucherView$$ExternalSyntheticLambda2);
                            break;
                        } else {
                            break;
                        }
                    case 31:
                        this.S = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.S);
                        break;
                    case 32:
                        this.isAuth = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.isAuth);
                        break;
                    case 33:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 34:
                        this.W = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.W);
                        break;
                    case 35:
                        this.V = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.V);
                        break;
                    case 36:
                        this.U = obtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case 37:
                        this.getOnBoardingScenario = obtainStyledAttributes.getFloat(index, this.getOnBoardingScenario);
                        break;
                    case 38:
                        this.X = obtainStyledAttributes.getFloat(index, this.X);
                        break;
                    case 39:
                        this.B = obtainStyledAttributes.getInt(index, this.B);
                        break;
                    case 40:
                        this.T = obtainStyledAttributes.getInt(index, this.T);
                        break;
                    case 41:
                        ConstraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                continue;
                            case 62:
                                this.moveToNextValue = obtainStyledAttributes.getDimensionPixelSize(index, this.moveToNextValue);
                                continue;
                            case 63:
                                this.getErrorConfigVersion = obtainStyledAttributes.getFloat(index, this.getErrorConfigVersion);
                                continue;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.Y = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                        continue;
                                    case 70:
                                        this.A = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        InstrumentInjector.log_e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.F = obtainStyledAttributes.getInt(index, this.F);
                                        continue;
                                    case 73:
                                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                                        continue;
                                    case 74:
                                        this.L = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.AppCompatEmojiTextHelper = obtainStyledAttributes.getBoolean(index, this.AppCompatEmojiTextHelper);
                                        continue;
                                    case 76:
                                        this.Q = obtainStyledAttributes.getInt(index, this.Q);
                                        continue;
                                    case 77:
                                        this.PlaceComponentResult = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.PlaceComponentResult);
                                        continue;
                                    case 78:
                                        this.getAuthRequestContext = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.getAuthRequestContext);
                                        continue;
                                    case 79:
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getDimensionPixelSize(index, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                                        continue;
                                    case 80:
                                        this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getDimensionPixelSize(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                                        continue;
                                    case 81:
                                        this.isAuto = obtainStyledAttributes.getInt(index, this.isAuto);
                                        continue;
                                    case 82:
                                        this.readMicros = obtainStyledAttributes.getInt(index, this.readMicros);
                                        continue;
                                    case 83:
                                        this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                        continue;
                                    case 84:
                                        this.shouldRecycleViewType = obtainStyledAttributes.getDimensionPixelSize(index, this.shouldRecycleViewType);
                                        continue;
                                    case 85:
                                        this.VerifyPinStateManager$executeRiskChallenge$2$1 = obtainStyledAttributes.getDimensionPixelSize(index, this.VerifyPinStateManager$executeRiskChallenge$2$1);
                                        continue;
                                    case 86:
                                        this.flip = obtainStyledAttributes.getDimensionPixelSize(index, this.flip);
                                        continue;
                                    case 87:
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getBoolean(index, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                        continue;
                                    case 88:
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getBoolean(index, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                        continue;
                                    case 89:
                                        this.H = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.whenAvailable = obtainStyledAttributes.getBoolean(index, this.whenAvailable);
                                        continue;
                                    case 91:
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("unused attribute 0x");
                                        sb.append(Integer.toHexString(index));
                                        sb.append("   ");
                                        sb.append(Z.get(index));
                                        InstrumentInjector.log_w("ConstraintSet", sb.toString());
                                        continue;
                                    default:
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Unknown attribute 0x");
                                        sb2.append(Integer.toHexString(index));
                                        sb2.append("   ");
                                        sb2.append(Z.get(index));
                                        InstrumentInjector.log_w("ConstraintSet", sb2.toString());
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static class Transform {
        private static SparseIntArray GetContactSyncConfig;
        public boolean BuiltInFictitiousFunctionClassFactory = false;
        public float MyBillsEntityDataFactory = 0.0f;
        public float KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        public float NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.0f;
        public float moveToNextValue = 1.0f;
        public float lookAheadTest = 1.0f;
        public float getErrorConfigVersion = Float.NaN;
        public float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
        public int scheduleImpl = -1;
        public float initRecordTimeStamp = 0.0f;
        public float DatabaseTableConfigUtil = 0.0f;
        public float NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        public boolean getAuthRequestContext = false;
        public float PlaceComponentResult = 0.0f;

        public final void MyBillsEntityDataFactory(Transform transform) {
            this.BuiltInFictitiousFunctionClassFactory = transform.BuiltInFictitiousFunctionClassFactory;
            this.MyBillsEntityDataFactory = transform.MyBillsEntityDataFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = transform.KClassImpl$Data$declaredNonStaticMembers$2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = transform.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.moveToNextValue = transform.moveToNextValue;
            this.lookAheadTest = transform.lookAheadTest;
            this.getErrorConfigVersion = transform.getErrorConfigVersion;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = transform.NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.scheduleImpl = transform.scheduleImpl;
            this.initRecordTimeStamp = transform.initRecordTimeStamp;
            this.DatabaseTableConfigUtil = transform.DatabaseTableConfigUtil;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = transform.NetworkUserEntityData$$ExternalSyntheticLambda2;
            this.getAuthRequestContext = transform.getAuthRequestContext;
            this.PlaceComponentResult = transform.PlaceComponentResult;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            GetContactSyncConfig = sparseIntArray;
            sparseIntArray.append(R.styleable.ofFailure, 1);
            GetContactSyncConfig.append(R.styleable.WindowInsetsCompat$BuilderImpl29, 2);
            GetContactSyncConfig.append(R.styleable.getGeneralError, 3);
            GetContactSyncConfig.append(R.styleable.DanaAppInitializer, 4);
            GetContactSyncConfig.append(R.styleable.getNumLinesChanged, 5);
            GetContactSyncConfig.append(R.styleable.f22checkReadInterstitialBanner$lambda3$lambda2, 6);
            GetContactSyncConfig.append(R.styleable.getEyeRightDet, 7);
            GetContactSyncConfig.append(R.styleable.QrScanWhitelistEntityData, 8);
            GetContactSyncConfig.append(R.styleable.onFocusChanged, 9);
            GetContactSyncConfig.append(R.styleable.isEncrypt, 10);
            GetContactSyncConfig.append(R.styleable.WindowInsetsCompat$BuilderImpl30, 11);
            GetContactSyncConfig.append(R.styleable.BaseDiscoverySectionViewHolder, 12);
        }

        final void MyBillsEntityDataFactory(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.onExecuted);
            this.BuiltInFictitiousFunctionClassFactory = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (GetContactSyncConfig.get(index)) {
                    case 1:
                        this.MyBillsEntityDataFactory = obtainStyledAttributes.getFloat(index, this.MyBillsEntityDataFactory);
                        break;
                    case 2:
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getFloat(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 3:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        break;
                    case 4:
                        this.moveToNextValue = obtainStyledAttributes.getFloat(index, this.moveToNextValue);
                        break;
                    case 5:
                        this.lookAheadTest = obtainStyledAttributes.getFloat(index, this.lookAheadTest);
                        break;
                    case 6:
                        this.getErrorConfigVersion = obtainStyledAttributes.getDimension(index, this.getErrorConfigVersion);
                        break;
                    case 7:
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getDimension(index, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    case 8:
                        this.initRecordTimeStamp = obtainStyledAttributes.getDimension(index, this.initRecordTimeStamp);
                        break;
                    case 9:
                        this.DatabaseTableConfigUtil = obtainStyledAttributes.getDimension(index, this.DatabaseTableConfigUtil);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getDimension(index, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.getAuthRequestContext = true;
                            this.PlaceComponentResult = obtainStyledAttributes.getDimension(index, this.PlaceComponentResult);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.scheduleImpl = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.scheduleImpl);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static class PropertySet {
        public boolean BuiltInFictitiousFunctionClassFactory = false;
        public int MyBillsEntityDataFactory = 0;
        public int PlaceComponentResult = 0;
        public float KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
        public float getAuthRequestContext = Float.NaN;

        public final void KClassImpl$Data$declaredNonStaticMembers$2(PropertySet propertySet) {
            this.BuiltInFictitiousFunctionClassFactory = propertySet.BuiltInFictitiousFunctionClassFactory;
            this.MyBillsEntityDataFactory = propertySet.MyBillsEntityDataFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = propertySet.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = propertySet.getAuthRequestContext;
            this.PlaceComponentResult = propertySet.PlaceComponentResult;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CallCsOrDianaViewModel$getHelpButtonChatBotFeature$2);
            this.BuiltInFictitiousFunctionClassFactory = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.HomeRecycleFragment$init$3$1) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getFloat(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.SendMoneyHomePresenter) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(index, this.MyBillsEntityDataFactory);
                    this.MyBillsEntityDataFactory = ConstraintSet.getErrorConfigVersion[this.MyBillsEntityDataFactory];
                } else if (index == R.styleable.logLevel) {
                    this.PlaceComponentResult = obtainStyledAttributes.getInt(index, this.PlaceComponentResult);
                } else if (index == R.styleable.constrainToRange) {
                    this.getAuthRequestContext = obtainStyledAttributes.getFloat(index, this.getAuthRequestContext);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static class Motion {
        private static SparseIntArray NetworkUserEntityData$$ExternalSyntheticLambda2;
        public boolean getAuthRequestContext = false;
        public int PlaceComponentResult = -1;
        public int BuiltInFictitiousFunctionClassFactory = 0;
        public String DatabaseTableConfigUtil = null;
        public int moveToNextValue = -1;
        public int MyBillsEntityDataFactory = 0;
        public float KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
        public int getErrorConfigVersion = -1;
        public float lookAheadTest = Float.NaN;
        public float GetContactSyncConfig = Float.NaN;
        public int initRecordTimeStamp = -1;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        public int NetworkUserEntityData$$ExternalSyntheticLambda1 = -3;
        public int scheduleImpl = -1;

        public final void BuiltInFictitiousFunctionClassFactory(Motion motion) {
            this.getAuthRequestContext = motion.getAuthRequestContext;
            this.PlaceComponentResult = motion.PlaceComponentResult;
            this.DatabaseTableConfigUtil = motion.DatabaseTableConfigUtil;
            this.moveToNextValue = motion.moveToNextValue;
            this.MyBillsEntityDataFactory = motion.MyBillsEntityDataFactory;
            this.lookAheadTest = motion.lookAheadTest;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = motion.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getErrorConfigVersion = motion.getErrorConfigVersion;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            NetworkUserEntityData$$ExternalSyntheticLambda2 = sparseIntArray;
            sparseIntArray.append(R.styleable.TextInputLayout$2, 1);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.TextInputLayout$3, 2);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.getCustomAttributesOrThrow, 3);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.TextInputLayout$1, 4);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.R2$string, 5);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.RecurringAnnouncementEntity, 6);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.TextInputLayout$4, 7);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.glTexEnvf, 8);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.setNearExpiredPromoBannerConfig, 9);
            NetworkUserEntityData$$ExternalSyntheticLambda2.append(R.styleable.getPreWorker, 10);
        }

        final void PlaceComponentResult(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.setHasError);
            this.getAuthRequestContext = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (NetworkUserEntityData$$ExternalSyntheticLambda2.get(index)) {
                    case 1:
                        this.lookAheadTest = obtainStyledAttributes.getFloat(index, this.lookAheadTest);
                        break;
                    case 2:
                        this.moveToNextValue = obtainStyledAttributes.getInt(index, this.moveToNextValue);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.DatabaseTableConfigUtil = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.DatabaseTableConfigUtil = Easing.PlaceComponentResult[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.PlaceComponentResult = ConstraintSet.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes, index, this.PlaceComponentResult);
                        break;
                    case 6:
                        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInteger(index, this.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 7:
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getFloat(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 8:
                        this.initRecordTimeStamp = obtainStyledAttributes.getInteger(index, this.initRecordTimeStamp);
                        break;
                    case 9:
                        this.GetContactSyncConfig = obtainStyledAttributes.getFloat(index, this.GetContactSyncConfig);
                        break;
                    case 10:
                        TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                        if (peekValue.type == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.scheduleImpl = resourceId;
                            if (resourceId != -1) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (peekValue.type == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = string;
                            if (string.indexOf("/") > 0) {
                                this.scheduleImpl = obtainStyledAttributes.getResourceId(index, -1);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -2;
                                break;
                            } else {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
                                break;
                            }
                        } else {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getInteger(index, this.scheduleImpl);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes2.dex */
    public static class Constraint {
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public Delta MyBillsEntityDataFactory;
        public String getAuthRequestContext;
        public final PropertySet scheduleImpl = new PropertySet();
        public final Motion getErrorConfigVersion = new Motion();
        public final Layout BuiltInFictitiousFunctionClassFactory = new Layout();
        public final Transform moveToNextValue = new Transform();
        public HashMap<String, ConstraintAttribute> PlaceComponentResult = new HashMap<>();

        /* loaded from: classes3.dex */
        public static class Delta {
            int[] getErrorConfigVersion = new int[10];
            int[] initRecordTimeStamp = new int[10];
            int MyBillsEntityDataFactory = 0;
            int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[10];
            float[] moveToNextValue = new float[10];
            int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            int[] scheduleImpl = new int[5];
            String[] DatabaseTableConfigUtil = new String[5];
            int BuiltInFictitiousFunctionClassFactory = 0;
            int[] PlaceComponentResult = new int[4];
            boolean[] lookAheadTest = new boolean[4];
            int getAuthRequestContext = 0;

            Delta() {
            }

            final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
                int i3 = this.MyBillsEntityDataFactory;
                int[] iArr = this.getErrorConfigVersion;
                if (i3 >= iArr.length) {
                    this.getErrorConfigVersion = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.initRecordTimeStamp;
                    this.initRecordTimeStamp = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.getErrorConfigVersion;
                int i4 = this.MyBillsEntityDataFactory;
                iArr3[i4] = i;
                int[] iArr4 = this.initRecordTimeStamp;
                this.MyBillsEntityDataFactory = i4 + 1;
                iArr4[i4] = i2;
            }

            final void getAuthRequestContext(int i, float f) {
                int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (i2 >= iArr.length) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.moveToNextValue;
                    this.moveToNextValue = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                iArr2[i3] = i;
                float[] fArr2 = this.moveToNextValue;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i3 + 1;
                fArr2[i3] = f;
            }

            final void KClassImpl$Data$declaredNonStaticMembers$2(int i, String str) {
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                int[] iArr = this.scheduleImpl;
                if (i2 >= iArr.length) {
                    this.scheduleImpl = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.DatabaseTableConfigUtil;
                    this.DatabaseTableConfigUtil = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.scheduleImpl;
                int i3 = this.BuiltInFictitiousFunctionClassFactory;
                iArr2[i3] = i;
                String[] strArr2 = this.DatabaseTableConfigUtil;
                this.BuiltInFictitiousFunctionClassFactory = i3 + 1;
                strArr2[i3] = str;
            }

            final void KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z) {
                int i2 = this.getAuthRequestContext;
                int[] iArr = this.PlaceComponentResult;
                if (i2 >= iArr.length) {
                    this.PlaceComponentResult = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.lookAheadTest;
                    this.lookAheadTest = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.PlaceComponentResult;
                int i3 = this.getAuthRequestContext;
                iArr2[i3] = i;
                boolean[] zArr2 = this.lookAheadTest;
                this.getAuthRequestContext = i3 + 1;
                zArr2[i3] = z;
            }

            public final void getAuthRequestContext(Constraint constraint) {
                for (int i = 0; i < this.MyBillsEntityDataFactory; i++) {
                    ConstraintSet.PlaceComponentResult(constraint, this.getErrorConfigVersion[i], this.initRecordTimeStamp[i]);
                }
                for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                    ConstraintSet.getAuthRequestContext(constraint, this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2], this.moveToNextValue[i2]);
                }
                for (int i3 = 0; i3 < this.BuiltInFictitiousFunctionClassFactory; i3++) {
                    ConstraintSet.MyBillsEntityDataFactory(constraint, this.scheduleImpl[i3], this.DatabaseTableConfigUtil[i3]);
                }
                for (int i4 = 0; i4 < this.getAuthRequestContext; i4++) {
                    ConstraintSet.BuiltInFictitiousFunctionClassFactory(constraint, this.PlaceComponentResult[i4], this.lookAheadTest[i4]);
                }
            }
        }

        /* renamed from: getAuthRequestContext */
        public final Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            constraint.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion);
            constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
            constraint.moveToNextValue.MyBillsEntityDataFactory(this.moveToNextValue);
            constraint.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            constraint.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
            return constraint;
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(int i, Constraints.LayoutParams layoutParams) {
            KClassImpl$Data$declaredNonStaticMembers$2(i, (ConstraintLayout.LayoutParams) layoutParams);
            this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = layoutParams.e;
            this.moveToNextValue.MyBillsEntityDataFactory = layoutParams.f;
            this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = layoutParams.FillAnimation;
            this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = layoutParams.FlowViewUtil$textChanges$1;
            this.moveToNextValue.moveToNextValue = layoutParams.connectForeground;
            this.moveToNextValue.lookAheadTest = layoutParams.FlowViewUtil$textChanges$2;
            this.moveToNextValue.getErrorConfigVersion = layoutParams.h;
            this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1 = layoutParams.i;
            this.moveToNextValue.initRecordTimeStamp = layoutParams.l;
            this.moveToNextValue.DatabaseTableConfigUtil = layoutParams.j;
            this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2 = layoutParams.k;
            this.moveToNextValue.PlaceComponentResult = layoutParams.g;
            this.moveToNextValue.getAuthRequestContext = layoutParams.TypeProjectionImpl;
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = layoutParams.I;
            this.BuiltInFictitiousFunctionClassFactory.D = layoutParams.G;
            this.BuiltInFictitiousFunctionClassFactory.P = layoutParams.V;
            this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1 = layoutParams.X;
            this.BuiltInFictitiousFunctionClassFactory.V = layoutParams.isAuto;
            this.BuiltInFictitiousFunctionClassFactory.W = layoutParams.Z;
            this.BuiltInFictitiousFunctionClassFactory.scheduleImpl = layoutParams.lookAheadTest;
            this.BuiltInFictitiousFunctionClassFactory.lookAheadTest = layoutParams.KClassImpl$Data$declaredNonStaticMembers$2;
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = layoutParams.PlaceComponentResult;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = layoutParams.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = layoutParams.MyBillsEntityDataFactory;
            this.BuiltInFictitiousFunctionClassFactory.S = layoutParams.W;
            this.BuiltInFictitiousFunctionClassFactory.isAuth = layoutParams.Y;
            this.BuiltInFictitiousFunctionClassFactory.newProxyInstance = layoutParams.PrepareContext;
            this.BuiltInFictitiousFunctionClassFactory.isLayoutRequested = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1 = layoutParams.BottomSheetCardBindingView$watcherCardNumberView$1;
            this.BuiltInFictitiousFunctionClassFactory.U = layoutParams.flip;
            this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = layoutParams.GetContactSyncConfig;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = layoutParams.scheduleImpl;
            this.BuiltInFictitiousFunctionClassFactory.moveToNextValue = layoutParams.getErrorConfigVersion;
            this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = layoutParams.isLayoutRequested;
            this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.BuiltInFictitiousFunctionClassFactory.N = layoutParams.O;
            this.BuiltInFictitiousFunctionClassFactory.SubSequence = layoutParams.SubSequence;
            this.BuiltInFictitiousFunctionClassFactory.getCallingPid = layoutParams.whenAvailable;
            this.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode = layoutParams.getSupportButtonTintMode;
            this.BuiltInFictitiousFunctionClassFactory.O = layoutParams.width;
            this.BuiltInFictitiousFunctionClassFactory.G = layoutParams.height;
            this.BuiltInFictitiousFunctionClassFactory.E = layoutParams.leftMargin;
            this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0 = layoutParams.rightMargin;
            this.BuiltInFictitiousFunctionClassFactory.R = layoutParams.topMargin;
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = layoutParams.bottomMargin;
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = layoutParams.getAuthRequestContext;
            this.BuiltInFictitiousFunctionClassFactory.X = layoutParams.d;
            this.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario = layoutParams.getValueOfTouchPositionAbsolute;
            this.BuiltInFictitiousFunctionClassFactory.T = layoutParams.shouldRecycleViewType;
            this.BuiltInFictitiousFunctionClassFactory.B = layoutParams.C;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = layoutParams.moveToNextValue;
            this.BuiltInFictitiousFunctionClassFactory.isAuto = layoutParams.H;
            this.BuiltInFictitiousFunctionClassFactory.readMicros = layoutParams.F;
            this.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType = layoutParams.J;
            this.BuiltInFictitiousFunctionClassFactory.C = layoutParams.AppCompatEmojiTextHelper;
            this.BuiltInFictitiousFunctionClassFactory.flip = layoutParams.M;
            this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1 = layoutParams.K;
            this.BuiltInFictitiousFunctionClassFactory.Y = layoutParams.getNameOrBuilderList;
            this.BuiltInFictitiousFunctionClassFactory.A = layoutParams.L;
            this.BuiltInFictitiousFunctionClassFactory.H = layoutParams.DatabaseTableConfigUtil;
            this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding = layoutParams.getCallingPid;
            this.BuiltInFictitiousFunctionClassFactory.PrepareContext = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda4;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda3;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda6;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3 = layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda5;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = layoutParams.FragmentBottomSheetPaymentSettingBinding;
            this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = layoutParams.newProxyInstance;
            this.BuiltInFictitiousFunctionClassFactory.Q = layoutParams.f5944a;
            if (Build.VERSION.SDK_INT >= 17) {
                this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = layoutParams.getMarginEnd();
                this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2 = layoutParams.getMarginStart();
            }
        }

        public final void PlaceComponentResult(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.I = this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2;
            layoutParams.G = this.BuiltInFictitiousFunctionClassFactory.D;
            layoutParams.V = this.BuiltInFictitiousFunctionClassFactory.P;
            layoutParams.X = this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1;
            layoutParams.isAuto = this.BuiltInFictitiousFunctionClassFactory.V;
            layoutParams.Z = this.BuiltInFictitiousFunctionClassFactory.W;
            layoutParams.lookAheadTest = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            layoutParams.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            layoutParams.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            layoutParams.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            layoutParams.W = this.BuiltInFictitiousFunctionClassFactory.S;
            layoutParams.Y = this.BuiltInFictitiousFunctionClassFactory.isAuth;
            layoutParams.PrepareContext = this.BuiltInFictitiousFunctionClassFactory.newProxyInstance;
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.BuiltInFictitiousFunctionClassFactory.isLayoutRequested;
            layoutParams.leftMargin = this.BuiltInFictitiousFunctionClassFactory.E;
            layoutParams.rightMargin = this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0;
            layoutParams.topMargin = this.BuiltInFictitiousFunctionClassFactory.R;
            layoutParams.bottomMargin = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda5 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
            layoutParams.FragmentBottomSheetPaymentSettingBinding = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
            layoutParams.getCallingPid = this.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding;
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.BuiltInFictitiousFunctionClassFactory.PrepareContext;
            layoutParams.BottomSheetCardBindingView$watcherCardNumberView$1 = this.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1;
            layoutParams.flip = this.BuiltInFictitiousFunctionClassFactory.U;
            layoutParams.scheduleImpl = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
            layoutParams.getErrorConfigVersion = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
            layoutParams.GetContactSyncConfig = this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp;
            layoutParams.isLayoutRequested = this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig;
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
            layoutParams.d = this.BuiltInFictitiousFunctionClassFactory.X;
            layoutParams.getValueOfTouchPositionAbsolute = this.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario;
            layoutParams.shouldRecycleViewType = this.BuiltInFictitiousFunctionClassFactory.T;
            layoutParams.C = this.BuiltInFictitiousFunctionClassFactory.B;
            layoutParams.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
            layoutParams.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2;
            layoutParams.H = this.BuiltInFictitiousFunctionClassFactory.isAuto;
            layoutParams.F = this.BuiltInFictitiousFunctionClassFactory.readMicros;
            layoutParams.J = this.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType;
            layoutParams.AppCompatEmojiTextHelper = this.BuiltInFictitiousFunctionClassFactory.C;
            layoutParams.M = this.BuiltInFictitiousFunctionClassFactory.flip;
            layoutParams.K = this.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1;
            layoutParams.getNameOrBuilderList = this.BuiltInFictitiousFunctionClassFactory.Y;
            layoutParams.L = this.BuiltInFictitiousFunctionClassFactory.A;
            layoutParams.O = this.BuiltInFictitiousFunctionClassFactory.N;
            layoutParams.SubSequence = this.BuiltInFictitiousFunctionClassFactory.SubSequence;
            layoutParams.whenAvailable = this.BuiltInFictitiousFunctionClassFactory.getCallingPid;
            layoutParams.getSupportButtonTintMode = this.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode;
            layoutParams.width = this.BuiltInFictitiousFunctionClassFactory.O;
            layoutParams.height = this.BuiltInFictitiousFunctionClassFactory.G;
            if (this.BuiltInFictitiousFunctionClassFactory.H != null) {
                layoutParams.DatabaseTableConfigUtil = this.BuiltInFictitiousFunctionClassFactory.H;
            }
            layoutParams.f5944a = this.BuiltInFictitiousFunctionClassFactory.Q;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2);
                layoutParams.setMarginEnd(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }
            layoutParams.PlaceComponentResult();
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Constraint constraint, ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            constraint.KClassImpl$Data$declaredNonStaticMembers$2(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                constraint.BuiltInFictitiousFunctionClassFactory.M = 1;
                Barrier barrier = (Barrier) constraintHelper;
                constraint.BuiltInFictitiousFunctionClassFactory.F = barrier.getType();
                constraint.BuiltInFictitiousFunctionClassFactory.J = barrier.getReferencedIds();
                constraint.BuiltInFictitiousFunctionClassFactory.I = barrier.getMargin();
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintSet constraintSet) {
        this.getAuthRequestContext.clear();
        for (Integer num : constraintSet.getAuthRequestContext.keySet()) {
            Constraint constraint = constraintSet.getAuthRequestContext.get(num);
            if (constraint != null) {
                this.getAuthRequestContext.put(num, constraint.clone());
            }
        }
    }

    public final void getAuthRequestContext(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.getAuthRequestContext.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.PlaceComponentResult && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.getAuthRequestContext.containsKey(Integer.valueOf(id2))) {
                this.getAuthRequestContext.put(Integer.valueOf(id2), new Constraint());
            }
            Constraint constraint = this.getAuthRequestContext.get(Integer.valueOf(id2));
            if (constraint != null) {
                constraint.PlaceComponentResult = ConstraintAttribute.getAuthRequestContext(this.lookAheadTest, childAt);
                constraint.KClassImpl$Data$declaredNonStaticMembers$2(id2, layoutParams);
                constraint.scheduleImpl.MyBillsEntityDataFactory = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = childAt.getAlpha();
                    constraint.moveToNextValue.MyBillsEntityDataFactory = childAt.getRotation();
                    constraint.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = childAt.getRotationX();
                    constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = childAt.getRotationY();
                    constraint.moveToNextValue.moveToNextValue = childAt.getScaleX();
                    constraint.moveToNextValue.lookAheadTest = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || pivotY != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        constraint.moveToNextValue.getErrorConfigVersion = pivotX;
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1 = pivotY;
                    }
                    constraint.moveToNextValue.initRecordTimeStamp = childAt.getTranslationX();
                    constraint.moveToNextValue.DatabaseTableConfigUtil = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2 = childAt.getTranslationZ();
                        if (constraint.moveToNextValue.getAuthRequestContext) {
                            constraint.moveToNextValue.PlaceComponentResult = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper = barrier.getAllowsGoneWidget();
                    constraint.BuiltInFictitiousFunctionClassFactory.J = barrier.getReferencedIds();
                    constraint.BuiltInFictitiousFunctionClassFactory.F = barrier.getType();
                    constraint.BuiltInFictitiousFunctionClassFactory.I = barrier.getMargin();
                }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintLayout constraintLayout) {
        BuiltInFictitiousFunctionClassFactory(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void MyBillsEntityDataFactory(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id2 = childAt.getId();
            if (!this.getAuthRequestContext.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb = new StringBuilder();
                sb.append("id unknown ");
                sb.append(Debug.MyBillsEntityDataFactory(childAt));
                InstrumentInjector.log_w("ConstraintSet", sb.toString());
            } else if (this.PlaceComponentResult && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (this.getAuthRequestContext.containsKey(Integer.valueOf(id2)) && (constraint = this.getAuthRequestContext.get(Integer.valueOf(id2))) != null) {
                    ConstraintAttribute.getAuthRequestContext(childAt, constraint.PlaceComponentResult);
                }
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.getAuthRequestContext.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id2 = childAt.getId();
            if (!this.getAuthRequestContext.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb = new StringBuilder();
                sb.append("id unknown ");
                sb.append(Debug.MyBillsEntityDataFactory(childAt));
                InstrumentInjector.log_w("ConstraintSet", sb.toString());
            } else if (this.PlaceComponentResult && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id2 != -1) {
                    if (this.getAuthRequestContext.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        Constraint constraint = this.getAuthRequestContext.get(Integer.valueOf(id2));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.BuiltInFictitiousFunctionClassFactory.M = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(constraint.BuiltInFictitiousFunctionClassFactory.F);
                                barrier.setMargin(constraint.BuiltInFictitiousFunctionClassFactory.I);
                                barrier.setAllowsGoneWidget(constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper);
                                if (constraint.BuiltInFictitiousFunctionClassFactory.J != null) {
                                    barrier.setReferencedIds(constraint.BuiltInFictitiousFunctionClassFactory.J);
                                } else if (constraint.BuiltInFictitiousFunctionClassFactory.L != null) {
                                    constraint.BuiltInFictitiousFunctionClassFactory.J = PlaceComponentResult(barrier, constraint.BuiltInFictitiousFunctionClassFactory.L);
                                    barrier.setReferencedIds(constraint.BuiltInFictitiousFunctionClassFactory.J);
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.PlaceComponentResult();
                            constraint.PlaceComponentResult(layoutParams);
                            ConstraintAttribute.getAuthRequestContext(childAt, constraint.PlaceComponentResult);
                            childAt.setLayoutParams(layoutParams);
                            if (constraint.scheduleImpl.PlaceComponentResult == 0) {
                                childAt.setVisibility(constraint.scheduleImpl.MyBillsEntityDataFactory);
                            }
                            if (Build.VERSION.SDK_INT >= 17) {
                                childAt.setAlpha(constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2);
                                childAt.setRotation(constraint.moveToNextValue.MyBillsEntityDataFactory);
                                childAt.setRotationX(constraint.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2);
                                childAt.setRotationY(constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                childAt.setScaleX(constraint.moveToNextValue.moveToNextValue);
                                childAt.setScaleY(constraint.moveToNextValue.lookAheadTest);
                                if (constraint.moveToNextValue.scheduleImpl != -1) {
                                    if (((View) childAt.getParent()).findViewById(constraint.moveToNextValue.scheduleImpl) != null) {
                                        float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                        float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                        if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                            float left2 = childAt.getLeft();
                                            float top2 = childAt.getTop();
                                            childAt.setPivotX(left - left2);
                                            childAt.setPivotY(top - top2);
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(constraint.moveToNextValue.getErrorConfigVersion)) {
                                        childAt.setPivotX(constraint.moveToNextValue.getErrorConfigVersion);
                                    }
                                    if (!Float.isNaN(constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                        childAt.setPivotY(constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                    }
                                }
                                childAt.setTranslationX(constraint.moveToNextValue.initRecordTimeStamp);
                                childAt.setTranslationY(constraint.moveToNextValue.DatabaseTableConfigUtil);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    childAt.setTranslationZ(constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                    if (constraint.moveToNextValue.getAuthRequestContext) {
                                        childAt.setElevation(constraint.moveToNextValue.PlaceComponentResult);
                                    }
                                }
                            }
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("WARNING NO CONSTRAINTS for view ");
                        sb2.append(id2);
                        InstrumentInjector.log_v("ConstraintSet", sb2.toString());
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.getAuthRequestContext.get(num);
            if (constraint2 != null) {
                if (constraint2.BuiltInFictitiousFunctionClassFactory.M == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    if (constraint2.BuiltInFictitiousFunctionClassFactory.J != null) {
                        barrier2.setReferencedIds(constraint2.BuiltInFictitiousFunctionClassFactory.J);
                    } else if (constraint2.BuiltInFictitiousFunctionClassFactory.L != null) {
                        constraint2.BuiltInFictitiousFunctionClassFactory.J = PlaceComponentResult(barrier2, constraint2.BuiltInFictitiousFunctionClassFactory.L);
                        barrier2.setReferencedIds(constraint2.BuiltInFictitiousFunctionClassFactory.J);
                    }
                    barrier2.setType(constraint2.BuiltInFictitiousFunctionClassFactory.F);
                    barrier2.setMargin(constraint2.BuiltInFictitiousFunctionClassFactory.I);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.PlaceComponentResult(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.BuiltInFictitiousFunctionClassFactory.getNameOrBuilderList) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.PlaceComponentResult(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = constraintLayout.getChildAt(i2);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4, int i5) {
        if (!this.getAuthRequestContext.containsKey(Integer.valueOf(i))) {
            this.getAuthRequestContext.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.getAuthRequestContext.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.D = -1;
                } else if (i4 == 2) {
                    constraint.BuiltInFictitiousFunctionClassFactory.D = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = -1;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Left to ");
                    sb.append(PlaceComponentResult(i4));
                    sb.append(" undefined");
                    throw new IllegalArgumentException(sb.toString());
                }
                constraint.BuiltInFictitiousFunctionClassFactory.E = i5;
                return;
            case 2:
                if (i4 == 1) {
                    constraint.BuiltInFictitiousFunctionClassFactory.P = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1 = -1;
                } else if (i4 == 2) {
                    constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1 = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.P = -1;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("right to ");
                    sb2.append(PlaceComponentResult(i4));
                    sb2.append(" undefined");
                    throw new IllegalArgumentException(sb2.toString());
                }
                constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0 = i5;
                return;
            case 3:
                if (i4 == 3) {
                    constraint.BuiltInFictitiousFunctionClassFactory.V = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                } else if (i4 == 4) {
                    constraint.BuiltInFictitiousFunctionClassFactory.W = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("right to ");
                    sb3.append(PlaceComponentResult(i4));
                    sb3.append(" undefined");
                    throw new IllegalArgumentException(sb3.toString());
                }
                constraint.BuiltInFictitiousFunctionClassFactory.R = i5;
                return;
            case 4:
                if (i4 == 4) {
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                } else if (i4 == 3) {
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("right to ");
                    sb4.append(PlaceComponentResult(i4));
                    sb4.append(" undefined");
                    throw new IllegalArgumentException(sb4.toString());
                }
                constraint.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = i5;
                return;
            case 5:
                if (i4 == 5) {
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    return;
                } else if (i4 == 3) {
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    return;
                } else if (i4 == 4) {
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    return;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("right to ");
                    sb5.append(PlaceComponentResult(i4));
                    sb5.append(" undefined");
                    throw new IllegalArgumentException(sb5.toString());
                }
            case 6:
                if (i4 == 6) {
                    constraint.BuiltInFictitiousFunctionClassFactory.isAuth = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.S = -1;
                } else if (i4 == 7) {
                    constraint.BuiltInFictitiousFunctionClassFactory.S = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.isAuth = -1;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("right to ");
                    sb6.append(PlaceComponentResult(i4));
                    sb6.append(" undefined");
                    throw new IllegalArgumentException(sb6.toString());
                }
                constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2 = i5;
                return;
            case 7:
                if (i4 == 7) {
                    constraint.BuiltInFictitiousFunctionClassFactory.isLayoutRequested = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.newProxyInstance = -1;
                } else if (i4 == 6) {
                    constraint.BuiltInFictitiousFunctionClassFactory.newProxyInstance = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.isLayoutRequested = -1;
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("right to ");
                    sb7.append(PlaceComponentResult(i4));
                    sb7.append(" undefined");
                    throw new IllegalArgumentException(sb7.toString());
                }
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = i5;
                return;
            default:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(PlaceComponentResult(i2));
                sb8.append(" to ");
                sb8.append(PlaceComponentResult(i4));
                sb8.append(" unknown");
                throw new IllegalArgumentException(sb8.toString());
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4) {
        if (!this.getAuthRequestContext.containsKey(Integer.valueOf(i))) {
            this.getAuthRequestContext.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.getAuthRequestContext.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.D = -1;
                    return;
                } else if (i4 == 2) {
                    constraint.BuiltInFictitiousFunctionClassFactory.D = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = -1;
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("left to ");
                    sb.append(PlaceComponentResult(i4));
                    sb.append(" undefined");
                    throw new IllegalArgumentException(sb.toString());
                }
            case 2:
                if (i4 == 1) {
                    constraint.BuiltInFictitiousFunctionClassFactory.P = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1 = -1;
                    return;
                } else if (i4 == 2) {
                    constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1 = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.P = -1;
                    return;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("right to ");
                    sb2.append(PlaceComponentResult(i4));
                    sb2.append(" undefined");
                    throw new IllegalArgumentException(sb2.toString());
                }
            case 3:
                if (i4 == 3) {
                    constraint.BuiltInFictitiousFunctionClassFactory.V = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                    return;
                } else if (i4 == 4) {
                    constraint.BuiltInFictitiousFunctionClassFactory.W = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                    return;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("right to ");
                    sb3.append(PlaceComponentResult(i4));
                    sb3.append(" undefined");
                    throw new IllegalArgumentException(sb3.toString());
                }
            case 4:
                if (i4 == 4) {
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                    return;
                } else if (i4 == 3) {
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                    return;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("right to ");
                    sb4.append(PlaceComponentResult(i4));
                    sb4.append(" undefined");
                    throw new IllegalArgumentException(sb4.toString());
                }
            case 5:
                if (i4 == 5) {
                    constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    return;
                } else if (i4 == 3) {
                    constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    return;
                } else if (i4 == 4) {
                    constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                    constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                    return;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("right to ");
                    sb5.append(PlaceComponentResult(i4));
                    sb5.append(" undefined");
                    throw new IllegalArgumentException(sb5.toString());
                }
            case 6:
                if (i4 == 6) {
                    constraint.BuiltInFictitiousFunctionClassFactory.isAuth = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.S = -1;
                    return;
                } else if (i4 == 7) {
                    constraint.BuiltInFictitiousFunctionClassFactory.S = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.isAuth = -1;
                    return;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("right to ");
                    sb6.append(PlaceComponentResult(i4));
                    sb6.append(" undefined");
                    throw new IllegalArgumentException(sb6.toString());
                }
            case 7:
                if (i4 == 7) {
                    constraint.BuiltInFictitiousFunctionClassFactory.isLayoutRequested = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.newProxyInstance = -1;
                    return;
                } else if (i4 == 6) {
                    constraint.BuiltInFictitiousFunctionClassFactory.newProxyInstance = i3;
                    constraint.BuiltInFictitiousFunctionClassFactory.isLayoutRequested = -1;
                    return;
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("right to ");
                    sb7.append(PlaceComponentResult(i4));
                    sb7.append(" undefined");
                    throw new IllegalArgumentException(sb7.toString());
                }
            default:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(PlaceComponentResult(i2));
                sb8.append(" to ");
                sb8.append(PlaceComponentResult(i4));
                sb8.append(" unknown");
                throw new IllegalArgumentException(sb8.toString());
        }
    }

    public final void MyBillsEntityDataFactory(int i, int i2) {
        Constraint constraint;
        if (!this.getAuthRequestContext.containsKey(Integer.valueOf(i)) || (constraint = this.getAuthRequestContext.get(Integer.valueOf(i))) == null) {
            return;
        }
        switch (i2) {
            case 1:
                constraint.BuiltInFictitiousFunctionClassFactory.D = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.E = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = Integer.MIN_VALUE;
                return;
            case 2:
                constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1 = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.P = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0 = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = Integer.MIN_VALUE;
                return;
            case 3:
                constraint.BuiltInFictitiousFunctionClassFactory.W = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.V = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.R = 0;
                constraint.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding = Integer.MIN_VALUE;
                return;
            case 4:
                constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
                constraint.BuiltInFictitiousFunctionClassFactory.PrepareContext = Integer.MIN_VALUE;
                return;
            case 5:
                constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = Integer.MIN_VALUE;
                return;
            case 6:
                constraint.BuiltInFictitiousFunctionClassFactory.S = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.isAuth = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2 = 0;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3 = Integer.MIN_VALUE;
                return;
            case 7:
                constraint.BuiltInFictitiousFunctionClassFactory.newProxyInstance = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.isLayoutRequested = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = Integer.MIN_VALUE;
                return;
            case 8:
                constraint.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = -1.0f;
                constraint.BuiltInFictitiousFunctionClassFactory.moveToNextValue = -1;
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        KClassImpl$Data$declaredNonStaticMembers$2(i).BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode = i2;
        KClassImpl$Data$declaredNonStaticMembers$2(i).BuiltInFictitiousFunctionClassFactory.getCallingPid = -1;
        KClassImpl$Data$declaredNonStaticMembers$2(i).BuiltInFictitiousFunctionClassFactory.SubSequence = -1.0f;
    }

    public final Constraint KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (!this.getAuthRequestContext.containsKey(Integer.valueOf(i))) {
            this.getAuthRequestContext.put(Integer.valueOf(i), new Constraint());
        }
        return this.getAuthRequestContext.get(Integer.valueOf(i));
    }

    public final void PlaceComponentResult(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getNameOrBuilderList = true;
                    }
                    this.getAuthRequestContext.put(Integer.valueOf(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2), MyBillsEntityDataFactory);
                } else {
                    continue;
                }
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x01c7, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.getAuthRequestContext(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    private static Constraint MyBillsEntityDataFactory(Context context, AttributeSet attributeSet, boolean z) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R.styleable.useDaemonThreadFactory : R.styleable.whenAvailable);
        if (z) {
            BuiltInFictitiousFunctionClassFactory(constraint, obtainStyledAttributes);
        } else {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index != R.styleable.ViewInputOtpBinding && R.styleable.FontsContractCompat$FontRequestCallback != index && R.styleable.access$showKycAmlEddDialog != index) {
                    constraint.getErrorConfigVersion.getAuthRequestContext = true;
                    constraint.BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute = true;
                    constraint.scheduleImpl.BuiltInFictitiousFunctionClassFactory = true;
                    constraint.moveToNextValue.BuiltInFictitiousFunctionClassFactory = true;
                }
                switch (NetworkUserEntityData$$ExternalSyntheticLambda0.get(index)) {
                    case 1:
                        Layout layout = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout.MyBillsEntityDataFactory = resourceId;
                        break;
                    case 2:
                        constraint.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 3:
                        Layout layout2 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.lookAheadTest);
                        if (resourceId2 == -1) {
                            resourceId2 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout2.lookAheadTest = resourceId2;
                        break;
                    case 4:
                        Layout layout3 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.scheduleImpl);
                        if (resourceId3 == -1) {
                            resourceId3 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout3.scheduleImpl = resourceId3;
                        break;
                    case 5:
                        constraint.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        constraint.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = obtainStyledAttributes.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig);
                        break;
                    case 7:
                        constraint.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil = obtainStyledAttributes.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT >= 17) {
                            constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        Layout layout4 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.isLayoutRequested);
                        if (resourceId4 == -1) {
                            resourceId4 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout4.isLayoutRequested = resourceId4;
                        break;
                    case 10:
                        Layout layout5 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
                        if (resourceId5 == -1) {
                            resourceId5 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout5.newProxyInstance = resourceId5;
                        break;
                    case 11:
                        constraint.BuiltInFictitiousFunctionClassFactory.PrepareContext = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.PrepareContext);
                        break;
                    case 12:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4);
                        break;
                    case 13:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        break;
                    case 14:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5);
                        break;
                    case 15:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        break;
                    case 16:
                        constraint.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding);
                        break;
                    case 17:
                        constraint.BuiltInFictitiousFunctionClassFactory.getCallingPid = obtainStyledAttributes.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.getCallingPid);
                        break;
                    case 18:
                        constraint.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode = obtainStyledAttributes.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode);
                        break;
                    case 19:
                        constraint.BuiltInFictitiousFunctionClassFactory.SubSequence = obtainStyledAttributes.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.SubSequence);
                        break;
                    case 20:
                        constraint.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1 = obtainStyledAttributes.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1);
                        break;
                    case 21:
                        constraint.BuiltInFictitiousFunctionClassFactory.G = obtainStyledAttributes.getLayoutDimension(index, constraint.BuiltInFictitiousFunctionClassFactory.G);
                        break;
                    case 22:
                        constraint.scheduleImpl.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(index, constraint.scheduleImpl.MyBillsEntityDataFactory);
                        constraint.scheduleImpl.MyBillsEntityDataFactory = getErrorConfigVersion[constraint.scheduleImpl.MyBillsEntityDataFactory];
                        break;
                    case 23:
                        constraint.BuiltInFictitiousFunctionClassFactory.O = obtainStyledAttributes.getLayoutDimension(index, constraint.BuiltInFictitiousFunctionClassFactory.O);
                        break;
                    case 24:
                        constraint.BuiltInFictitiousFunctionClassFactory.E = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.E);
                        break;
                    case 25:
                        Layout layout6 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$2);
                        if (resourceId6 == -1) {
                            resourceId6 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout6.VerifyPinStateManager$executeRiskChallenge$2$2 = resourceId6;
                        break;
                    case 26:
                        Layout layout7 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.D);
                        if (resourceId7 == -1) {
                            resourceId7 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout7.D = resourceId7;
                        break;
                    case 27:
                        constraint.BuiltInFictitiousFunctionClassFactory.N = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.N);
                        break;
                    case 28:
                        constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0);
                        break;
                    case 29:
                        Layout layout8 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.P);
                        if (resourceId8 == -1) {
                            resourceId8 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout8.P = resourceId8;
                        break;
                    case 30:
                        Layout layout9 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda1);
                        if (resourceId9 == -1) {
                            resourceId9 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout9.SummaryVoucherView$$ExternalSyntheticLambda1 = resourceId9;
                        break;
                    case 31:
                        if (Build.VERSION.SDK_INT >= 17) {
                            constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2);
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        Layout layout10 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.S);
                        if (resourceId10 == -1) {
                            resourceId10 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout10.S = resourceId10;
                        break;
                    case 33:
                        Layout layout11 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.isAuth);
                        if (resourceId11 == -1) {
                            resourceId11 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout11.isAuth = resourceId11;
                        break;
                    case 34:
                        constraint.BuiltInFictitiousFunctionClassFactory.R = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.R);
                        break;
                    case 35:
                        Layout layout12 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.W);
                        if (resourceId12 == -1) {
                            resourceId12 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout12.W = resourceId12;
                        break;
                    case 36:
                        Layout layout13 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.V);
                        if (resourceId13 == -1) {
                            resourceId13 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout13.V = resourceId13;
                        break;
                    case 37:
                        constraint.BuiltInFictitiousFunctionClassFactory.U = obtainStyledAttributes.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.U);
                        break;
                    case 38:
                        constraint.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, constraint.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 39:
                        constraint.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario = obtainStyledAttributes.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario);
                        break;
                    case 40:
                        constraint.BuiltInFictitiousFunctionClassFactory.X = obtainStyledAttributes.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.X);
                        break;
                    case 41:
                        constraint.BuiltInFictitiousFunctionClassFactory.B = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.B);
                        break;
                    case 42:
                        constraint.BuiltInFictitiousFunctionClassFactory.T = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.T);
                        break;
                    case 43:
                        constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getFloat(index, constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 44:
                        if (Build.VERSION.SDK_INT >= 21) {
                            constraint.moveToNextValue.getAuthRequestContext = true;
                            constraint.moveToNextValue.PlaceComponentResult = obtainStyledAttributes.getDimension(index, constraint.moveToNextValue.PlaceComponentResult);
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        constraint.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getFloat(index, constraint.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 46:
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getFloat(index, constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        break;
                    case 47:
                        constraint.moveToNextValue.moveToNextValue = obtainStyledAttributes.getFloat(index, constraint.moveToNextValue.moveToNextValue);
                        break;
                    case 48:
                        constraint.moveToNextValue.lookAheadTest = obtainStyledAttributes.getFloat(index, constraint.moveToNextValue.lookAheadTest);
                        break;
                    case 49:
                        constraint.moveToNextValue.getErrorConfigVersion = obtainStyledAttributes.getDimension(index, constraint.moveToNextValue.getErrorConfigVersion);
                        break;
                    case 50:
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getDimension(index, constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    case 51:
                        constraint.moveToNextValue.initRecordTimeStamp = obtainStyledAttributes.getDimension(index, constraint.moveToNextValue.initRecordTimeStamp);
                        break;
                    case 52:
                        constraint.moveToNextValue.DatabaseTableConfigUtil = obtainStyledAttributes.getDimension(index, constraint.moveToNextValue.DatabaseTableConfigUtil);
                        break;
                    case 53:
                        if (Build.VERSION.SDK_INT >= 21) {
                            constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getDimension(index, constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        constraint.BuiltInFictitiousFunctionClassFactory.isAuto = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.isAuto);
                        break;
                    case 55:
                        constraint.BuiltInFictitiousFunctionClassFactory.readMicros = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.readMicros);
                        break;
                    case 56:
                        constraint.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType);
                        break;
                    case 57:
                        constraint.BuiltInFictitiousFunctionClassFactory.C = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.C);
                        break;
                    case 58:
                        constraint.BuiltInFictitiousFunctionClassFactory.flip = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.flip);
                        break;
                    case 59:
                        constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1);
                        break;
                    case 60:
                        constraint.moveToNextValue.MyBillsEntityDataFactory = obtainStyledAttributes.getFloat(index, constraint.moveToNextValue.MyBillsEntityDataFactory);
                        break;
                    case 61:
                        Layout layout14 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        if (resourceId14 == -1) {
                            resourceId14 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout14.NetworkUserEntityData$$ExternalSyntheticLambda0 = resourceId14;
                        break;
                    case 62:
                        constraint.BuiltInFictitiousFunctionClassFactory.moveToNextValue = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.moveToNextValue);
                        break;
                    case 63:
                        constraint.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = obtainStyledAttributes.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion);
                        break;
                    case 64:
                        Motion motion = constraint.getErrorConfigVersion;
                        int resourceId15 = obtainStyledAttributes.getResourceId(index, constraint.getErrorConfigVersion.PlaceComponentResult);
                        if (resourceId15 == -1) {
                            resourceId15 = obtainStyledAttributes.getInt(index, -1);
                        }
                        motion.PlaceComponentResult = resourceId15;
                        break;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            constraint.getErrorConfigVersion.DatabaseTableConfigUtil = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            constraint.getErrorConfigVersion.DatabaseTableConfigUtil = Easing.PlaceComponentResult[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 66:
                        constraint.getErrorConfigVersion.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 67:
                        constraint.getErrorConfigVersion.lookAheadTest = obtainStyledAttributes.getFloat(index, constraint.getErrorConfigVersion.lookAheadTest);
                        break;
                    case 68:
                        constraint.scheduleImpl.getAuthRequestContext = obtainStyledAttributes.getFloat(index, constraint.scheduleImpl.getAuthRequestContext);
                        break;
                    case 69:
                        constraint.BuiltInFictitiousFunctionClassFactory.Y = obtainStyledAttributes.getFloat(index, 1.0f);
                        break;
                    case 70:
                        constraint.BuiltInFictitiousFunctionClassFactory.A = obtainStyledAttributes.getFloat(index, 1.0f);
                        break;
                    case 71:
                        InstrumentInjector.log_e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        constraint.BuiltInFictitiousFunctionClassFactory.F = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.F);
                        break;
                    case 73:
                        constraint.BuiltInFictitiousFunctionClassFactory.I = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.I);
                        break;
                    case 74:
                        constraint.BuiltInFictitiousFunctionClassFactory.L = obtainStyledAttributes.getString(index);
                        break;
                    case 75:
                        constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper = obtainStyledAttributes.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper);
                        break;
                    case 76:
                        constraint.getErrorConfigVersion.moveToNextValue = obtainStyledAttributes.getInt(index, constraint.getErrorConfigVersion.moveToNextValue);
                        break;
                    case 77:
                        constraint.BuiltInFictitiousFunctionClassFactory.H = obtainStyledAttributes.getString(index);
                        break;
                    case 78:
                        constraint.scheduleImpl.PlaceComponentResult = obtainStyledAttributes.getInt(index, constraint.scheduleImpl.PlaceComponentResult);
                        break;
                    case 79:
                        constraint.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getFloat(index, constraint.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 80:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    case 81:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                    case 82:
                        constraint.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInteger(index, constraint.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 83:
                        Transform transform = constraint.moveToNextValue;
                        int resourceId16 = obtainStyledAttributes.getResourceId(index, constraint.moveToNextValue.scheduleImpl);
                        if (resourceId16 == -1) {
                            resourceId16 = obtainStyledAttributes.getInt(index, -1);
                        }
                        transform.scheduleImpl = resourceId16;
                        break;
                    case 84:
                        constraint.getErrorConfigVersion.initRecordTimeStamp = obtainStyledAttributes.getInteger(index, constraint.getErrorConfigVersion.initRecordTimeStamp);
                        break;
                    case 85:
                        constraint.getErrorConfigVersion.GetContactSyncConfig = obtainStyledAttributes.getFloat(index, constraint.getErrorConfigVersion.GetContactSyncConfig);
                        break;
                    case 86:
                        TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                        if (peekValue.type == 1) {
                            constraint.getErrorConfigVersion.scheduleImpl = obtainStyledAttributes.getResourceId(index, -1);
                            if (constraint.getErrorConfigVersion.scheduleImpl != -1) {
                                constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (peekValue.type == 3) {
                            constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getString(index);
                            if (constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.indexOf("/") > 0) {
                                constraint.getErrorConfigVersion.scheduleImpl = obtainStyledAttributes.getResourceId(index, -1);
                                constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = -2;
                                break;
                            } else {
                                constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
                                break;
                            }
                        } else {
                            constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getInteger(index, constraint.getErrorConfigVersion.scheduleImpl);
                            break;
                        }
                    case 87:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda0.get(index));
                        InstrumentInjector.log_w("ConstraintSet", sb.toString());
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unknown attribute 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda0.get(index));
                        InstrumentInjector.log_w("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        Layout layout15 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId17 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
                        if (resourceId17 == -1) {
                            resourceId17 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout15.PlaceComponentResult = resourceId17;
                        break;
                    case 92:
                        Layout layout16 = constraint.BuiltInFictitiousFunctionClassFactory;
                        int resourceId18 = obtainStyledAttributes.getResourceId(index, constraint.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
                        if (resourceId18 == -1) {
                            resourceId18 = obtainStyledAttributes.getInt(index, -1);
                        }
                        layout16.getAuthRequestContext = resourceId18;
                        break;
                    case 93:
                        constraint.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    case 94:
                        constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        break;
                    case 95:
                        KClassImpl$Data$declaredNonStaticMembers$2(constraint.BuiltInFictitiousFunctionClassFactory, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        KClassImpl$Data$declaredNonStaticMembers$2(constraint.BuiltInFictitiousFunctionClassFactory, obtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        constraint.BuiltInFictitiousFunctionClassFactory.Q = obtainStyledAttributes.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.Q);
                        break;
                }
            }
            if (constraint.BuiltInFictitiousFunctionClassFactory.L != null) {
                constraint.BuiltInFictitiousFunctionClassFactory.J = null;
            }
        }
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public static Constraint MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.useDaemonThreadFactory);
        BuiltInFictitiousFunctionClassFactory(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private static void BuiltInFictitiousFunctionClassFactory(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.MyBillsEntityDataFactory = delta;
        constraint.getErrorConfigVersion.getAuthRequestContext = false;
        constraint.BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute = false;
        constraint.scheduleImpl.BuiltInFictitiousFunctionClassFactory = false;
        constraint.moveToNextValue.BuiltInFictitiousFunctionClassFactory = false;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (scheduleImpl.get(index)) {
                case 2:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(2, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown attribute 0x");
                    sb.append(Integer.toHexString(index));
                    sb.append("   ");
                    sb.append(NetworkUserEntityData$$ExternalSyntheticLambda0.get(index));
                    InstrumentInjector.log_w("ConstraintSet", sb.toString());
                    break;
                case 5:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(6, typedArray.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig));
                    break;
                case 7:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(7, typedArray.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil));
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(8, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(11, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.PrepareContext));
                    break;
                case 12:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(12, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4));
                    break;
                case 13:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(13, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6));
                    break;
                case 14:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(14, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5));
                    break;
                case 15:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(15, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3));
                    break;
                case 16:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(16, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding));
                    break;
                case 17:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(17, typedArray.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.getCallingPid));
                    break;
                case 18:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(18, typedArray.getDimensionPixelOffset(index, constraint.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode));
                    break;
                case 19:
                    delta.getAuthRequestContext(19, typedArray.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.SubSequence));
                    break;
                case 20:
                    delta.getAuthRequestContext(20, typedArray.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1));
                    break;
                case 21:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(21, typedArray.getLayoutDimension(index, constraint.BuiltInFictitiousFunctionClassFactory.G));
                    break;
                case 22:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(22, getErrorConfigVersion[typedArray.getInt(index, constraint.scheduleImpl.MyBillsEntityDataFactory)]);
                    break;
                case 23:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(23, typedArray.getLayoutDimension(index, constraint.BuiltInFictitiousFunctionClassFactory.O));
                    break;
                case 24:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(24, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.E));
                    break;
                case 27:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(27, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.N));
                    break;
                case 28:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(28, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(31, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2));
                        break;
                    } else {
                        break;
                    }
                case 34:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(34, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.R));
                    break;
                case 37:
                    delta.getAuthRequestContext(37, typedArray.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.U));
                    break;
                case 38:
                    constraint.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, constraint.KClassImpl$Data$declaredNonStaticMembers$2);
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(38, constraint.KClassImpl$Data$declaredNonStaticMembers$2);
                    break;
                case 39:
                    delta.getAuthRequestContext(39, typedArray.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario));
                    break;
                case 40:
                    delta.getAuthRequestContext(40, typedArray.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.X));
                    break;
                case 41:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(41, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.B));
                    break;
                case 42:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(42, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.T));
                    break;
                case 43:
                    delta.getAuthRequestContext(43, typedArray.getFloat(index, constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(44, true);
                        delta.getAuthRequestContext(44, typedArray.getDimension(index, constraint.moveToNextValue.PlaceComponentResult));
                        break;
                    } else {
                        break;
                    }
                case 45:
                    delta.getAuthRequestContext(45, typedArray.getFloat(index, constraint.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2));
                    break;
                case 46:
                    delta.getAuthRequestContext(46, typedArray.getFloat(index, constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    break;
                case 47:
                    delta.getAuthRequestContext(47, typedArray.getFloat(index, constraint.moveToNextValue.moveToNextValue));
                    break;
                case 48:
                    delta.getAuthRequestContext(48, typedArray.getFloat(index, constraint.moveToNextValue.lookAheadTest));
                    break;
                case 49:
                    delta.getAuthRequestContext(49, typedArray.getDimension(index, constraint.moveToNextValue.getErrorConfigVersion));
                    break;
                case 50:
                    delta.getAuthRequestContext(50, typedArray.getDimension(index, constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1));
                    break;
                case 51:
                    delta.getAuthRequestContext(51, typedArray.getDimension(index, constraint.moveToNextValue.initRecordTimeStamp));
                    break;
                case 52:
                    delta.getAuthRequestContext(52, typedArray.getDimension(index, constraint.moveToNextValue.DatabaseTableConfigUtil));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        delta.getAuthRequestContext(53, typedArray.getDimension(index, constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(54, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.isAuto));
                    break;
                case 55:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(55, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.readMicros));
                    break;
                case 56:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(56, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType));
                    break;
                case 57:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(57, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.C));
                    break;
                case 58:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(58, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.flip));
                    break;
                case 59:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(59, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1));
                    break;
                case 60:
                    delta.getAuthRequestContext(60, typedArray.getFloat(index, constraint.moveToNextValue.MyBillsEntityDataFactory));
                    break;
                case 62:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(62, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.moveToNextValue));
                    break;
                case 63:
                    delta.getAuthRequestContext(63, typedArray.getFloat(index, constraint.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion));
                    break;
                case 64:
                    int resourceId = typedArray.getResourceId(index, constraint.getErrorConfigVersion.PlaceComponentResult);
                    if (resourceId == -1) {
                        resourceId = typedArray.getInt(index, -1);
                    }
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(64, resourceId);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(65, typedArray.getString(index));
                        break;
                    } else {
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(65, Easing.PlaceComponentResult[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.getAuthRequestContext(67, typedArray.getFloat(index, constraint.getErrorConfigVersion.lookAheadTest));
                    break;
                case 68:
                    delta.getAuthRequestContext(68, typedArray.getFloat(index, constraint.scheduleImpl.getAuthRequestContext));
                    break;
                case 69:
                    delta.getAuthRequestContext(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.getAuthRequestContext(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    InstrumentInjector.log_e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(72, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.F));
                    break;
                case 73:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(73, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.I));
                    break;
                case 74:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(75, typedArray.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper));
                    break;
                case 76:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(76, typedArray.getInt(index, constraint.getErrorConfigVersion.moveToNextValue));
                    break;
                case 77:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(78, typedArray.getInt(index, constraint.scheduleImpl.PlaceComponentResult));
                    break;
                case 79:
                    delta.getAuthRequestContext(79, typedArray.getFloat(index, constraint.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2));
                    break;
                case 80:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(80, typedArray.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1));
                    break;
                case 81:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(81, typedArray.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2));
                    break;
                case 82:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(82, typedArray.getInteger(index, constraint.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory));
                    break;
                case 83:
                    int resourceId2 = typedArray.getResourceId(index, constraint.moveToNextValue.scheduleImpl);
                    if (resourceId2 == -1) {
                        resourceId2 = typedArray.getInt(index, -1);
                    }
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(83, resourceId2);
                    break;
                case 84:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(84, typedArray.getInteger(index, constraint.getErrorConfigVersion.initRecordTimeStamp));
                    break;
                case 85:
                    delta.getAuthRequestContext(85, typedArray.getFloat(index, constraint.getErrorConfigVersion.GetContactSyncConfig));
                    break;
                case 86:
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type == 1) {
                        constraint.getErrorConfigVersion.scheduleImpl = typedArray.getResourceId(index, -1);
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(89, constraint.getErrorConfigVersion.scheduleImpl);
                        if (constraint.getErrorConfigVersion.scheduleImpl != -1) {
                            constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = -2;
                            delta.KClassImpl$Data$declaredNonStaticMembers$2(88, constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            break;
                        } else {
                            break;
                        }
                    } else if (peekValue.type == 3) {
                        constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getString(index);
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(90, constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        if (constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.indexOf("/") > 0) {
                            constraint.getErrorConfigVersion.scheduleImpl = typedArray.getResourceId(index, -1);
                            delta.KClassImpl$Data$declaredNonStaticMembers$2(89, constraint.getErrorConfigVersion.scheduleImpl);
                            constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = -2;
                            delta.KClassImpl$Data$declaredNonStaticMembers$2(88, constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            break;
                        } else {
                            constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
                            delta.KClassImpl$Data$declaredNonStaticMembers$2(88, constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            break;
                        }
                    } else {
                        constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = typedArray.getInteger(index, constraint.getErrorConfigVersion.scheduleImpl);
                        delta.KClassImpl$Data$declaredNonStaticMembers$2(88, constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    }
                case 87:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unused attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda0.get(index));
                    InstrumentInjector.log_w("ConstraintSet", sb2.toString());
                    break;
                case 93:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(93, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2));
                    break;
                case 94:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(94, typedArray.getDimensionPixelSize(index, constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8));
                    break;
                case 95:
                    KClassImpl$Data$declaredNonStaticMembers$2(delta, typedArray, index, 0);
                    break;
                case 96:
                    KClassImpl$Data$declaredNonStaticMembers$2(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(97, typedArray.getInt(index, constraint.BuiltInFictitiousFunctionClassFactory.Q));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        constraint.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, constraint.KClassImpl$Data$declaredNonStaticMembers$2);
                        if (constraint.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                            constraint.getAuthRequestContext = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.getAuthRequestContext = typedArray.getString(index);
                        break;
                    } else {
                        constraint.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, constraint.KClassImpl$Data$declaredNonStaticMembers$2);
                        break;
                    }
                case 99:
                    delta.KClassImpl$Data$declaredNonStaticMembers$2(99, typedArray.getBoolean(index, constraint.BuiltInFictitiousFunctionClassFactory.whenAvailable));
                    break;
            }
        }
    }

    private static int[] PlaceComponentResult(View view, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    static /* synthetic */ int BuiltInFictitiousFunctionClassFactory(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    static /* synthetic */ void PlaceComponentResult(Constraint constraint, int i, int i2) {
        if (i == 6) {
            constraint.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = i2;
        } else if (i == 7) {
            constraint.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil = i2;
        } else if (i == 8) {
            constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = i2;
        } else if (i == 27) {
            constraint.BuiltInFictitiousFunctionClassFactory.N = i2;
        } else if (i == 28) {
            constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda0 = i2;
        } else if (i == 41) {
            constraint.BuiltInFictitiousFunctionClassFactory.B = i2;
        } else if (i == 42) {
            constraint.BuiltInFictitiousFunctionClassFactory.T = i2;
        } else if (i == 61) {
            constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2;
        } else if (i == 62) {
            constraint.BuiltInFictitiousFunctionClassFactory.moveToNextValue = i2;
        } else if (i == 72) {
            constraint.BuiltInFictitiousFunctionClassFactory.F = i2;
        } else if (i == 73) {
            constraint.BuiltInFictitiousFunctionClassFactory.I = i2;
        } else if (i == 2) {
            constraint.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = i2;
        } else if (i == 31) {
            constraint.BuiltInFictitiousFunctionClassFactory.SummaryVoucherView$$ExternalSyntheticLambda2 = i2;
        } else if (i == 34) {
            constraint.BuiltInFictitiousFunctionClassFactory.R = i2;
        } else if (i == 38) {
            constraint.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        } else if (i == 64) {
            constraint.getErrorConfigVersion.PlaceComponentResult = i2;
        } else if (i == 66) {
            constraint.getErrorConfigVersion.MyBillsEntityDataFactory = i2;
        } else if (i == 76) {
            constraint.getErrorConfigVersion.moveToNextValue = i2;
        } else if (i == 78) {
            constraint.scheduleImpl.PlaceComponentResult = i2;
        } else if (i == 97) {
            constraint.BuiltInFictitiousFunctionClassFactory.Q = i2;
        } else if (i == 93) {
            constraint.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        } else if (i != 94) {
            switch (i) {
                case 11:
                    constraint.BuiltInFictitiousFunctionClassFactory.PrepareContext = i2;
                    return;
                case 12:
                    constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = i2;
                    return;
                case 13:
                    constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = i2;
                    return;
                case 14:
                    constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = i2;
                    return;
                case 15:
                    constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3 = i2;
                    return;
                case 16:
                    constraint.BuiltInFictitiousFunctionClassFactory.FragmentBottomSheetPaymentSettingBinding = i2;
                    return;
                case 17:
                    constraint.BuiltInFictitiousFunctionClassFactory.getCallingPid = i2;
                    return;
                case 18:
                    constraint.BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode = i2;
                    return;
                default:
                    switch (i) {
                        case 21:
                            constraint.BuiltInFictitiousFunctionClassFactory.G = i2;
                            return;
                        case 22:
                            constraint.scheduleImpl.MyBillsEntityDataFactory = i2;
                            return;
                        case 23:
                            constraint.BuiltInFictitiousFunctionClassFactory.O = i2;
                            return;
                        case 24:
                            constraint.BuiltInFictitiousFunctionClassFactory.E = i2;
                            return;
                        default:
                            switch (i) {
                                case 54:
                                    constraint.BuiltInFictitiousFunctionClassFactory.isAuto = i2;
                                    return;
                                case 55:
                                    constraint.BuiltInFictitiousFunctionClassFactory.readMicros = i2;
                                    return;
                                case 56:
                                    constraint.BuiltInFictitiousFunctionClassFactory.shouldRecycleViewType = i2;
                                    return;
                                case 57:
                                    constraint.BuiltInFictitiousFunctionClassFactory.C = i2;
                                    return;
                                case 58:
                                    constraint.BuiltInFictitiousFunctionClassFactory.flip = i2;
                                    return;
                                case 59:
                                    constraint.BuiltInFictitiousFunctionClassFactory.VerifyPinStateManager$executeRiskChallenge$2$1 = i2;
                                    return;
                                default:
                                    switch (i) {
                                        case 82:
                                            constraint.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory = i2;
                                            return;
                                        case 83:
                                            constraint.moveToNextValue.scheduleImpl = i2;
                                            return;
                                        case 84:
                                            constraint.getErrorConfigVersion.initRecordTimeStamp = i2;
                                            return;
                                        default:
                                            switch (i) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1 = i2;
                                                    return;
                                                case 89:
                                                    constraint.getErrorConfigVersion.scheduleImpl = i2;
                                                    return;
                                                default:
                                                    InstrumentInjector.log_w("ConstraintSet", "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = i2;
        }
    }

    static /* synthetic */ void getAuthRequestContext(Constraint constraint, int i, float f) {
        if (i == 19) {
            constraint.BuiltInFictitiousFunctionClassFactory.SubSequence = f;
        } else if (i == 20) {
            constraint.BuiltInFictitiousFunctionClassFactory.BottomSheetCardBindingView$watcherCardNumberView$1 = f;
        } else if (i == 37) {
            constraint.BuiltInFictitiousFunctionClassFactory.U = f;
        } else if (i == 60) {
            constraint.moveToNextValue.MyBillsEntityDataFactory = f;
        } else if (i == 63) {
            constraint.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = f;
        } else if (i == 79) {
            constraint.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        } else if (i == 85) {
            constraint.getErrorConfigVersion.GetContactSyncConfig = f;
        } else if (i != 87) {
            if (i == 39) {
                constraint.BuiltInFictitiousFunctionClassFactory.getOnBoardingScenario = f;
            } else if (i != 40) {
                switch (i) {
                    case 43:
                        constraint.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 = f;
                        return;
                    case 44:
                        constraint.moveToNextValue.PlaceComponentResult = f;
                        constraint.moveToNextValue.getAuthRequestContext = true;
                        return;
                    case 45:
                        constraint.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = f;
                        return;
                    case 46:
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
                        return;
                    case 47:
                        constraint.moveToNextValue.moveToNextValue = f;
                        return;
                    case 48:
                        constraint.moveToNextValue.lookAheadTest = f;
                        return;
                    case 49:
                        constraint.moveToNextValue.getErrorConfigVersion = f;
                        return;
                    case 50:
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1 = f;
                        return;
                    case 51:
                        constraint.moveToNextValue.initRecordTimeStamp = f;
                        return;
                    case 52:
                        constraint.moveToNextValue.DatabaseTableConfigUtil = f;
                        return;
                    case 53:
                        constraint.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
                        return;
                    default:
                        switch (i) {
                            case 67:
                                constraint.getErrorConfigVersion.lookAheadTest = f;
                                return;
                            case 68:
                                constraint.scheduleImpl.getAuthRequestContext = f;
                                return;
                            case 69:
                                constraint.BuiltInFictitiousFunctionClassFactory.Y = f;
                                return;
                            case 70:
                                constraint.BuiltInFictitiousFunctionClassFactory.A = f;
                                return;
                            default:
                                InstrumentInjector.log_w("ConstraintSet", "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                constraint.BuiltInFictitiousFunctionClassFactory.X = f;
            }
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Constraint constraint, int i, String str) {
        if (i == 5) {
            constraint.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = str;
        } else if (i == 65) {
            constraint.getErrorConfigVersion.DatabaseTableConfigUtil = str;
        } else if (i == 74) {
            constraint.BuiltInFictitiousFunctionClassFactory.L = str;
            constraint.BuiltInFictitiousFunctionClassFactory.J = null;
        } else if (i == 77) {
            constraint.BuiltInFictitiousFunctionClassFactory.H = str;
        } else if (i != 87) {
            if (i == 90) {
                constraint.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            } else {
                InstrumentInjector.log_w("ConstraintSet", "Unknown attribute 0x");
            }
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Constraint constraint, int i, boolean z) {
        if (i == 44) {
            constraint.moveToNextValue.getAuthRequestContext = z;
        } else if (i == 75) {
            constraint.BuiltInFictitiousFunctionClassFactory.AppCompatEmojiTextHelper = z;
        } else if (i != 87) {
            if (i == 80) {
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
            } else if (i == 81) {
                constraint.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
            } else {
                InstrumentInjector.log_w("ConstraintSet", "Unknown attribute 0x");
            }
        }
    }
}
