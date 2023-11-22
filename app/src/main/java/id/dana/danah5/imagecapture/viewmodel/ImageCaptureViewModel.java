package id.dana.danah5.imagecapture.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.danah5.imagecapture.viewmodel.ImageCaptureUiState;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.imagecapture.interactor.GetTipUploadPhotoCDP;
import id.dana.domain.promotion.Space;
import id.dana.phototips.mapper.PhotoTipsModelMapper;
import id.dana.phototips.model.PhotoTipsModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00128\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureViewModel;", "Landroidx/lifecycle/ViewModel;", "", "documentId", "spaceCode", "", "getTipUploadPhoto", "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/domain/imagecapture/interactor/GetTipUploadPhotoCDP;", "getTipUploadPhotoCDP", "Lid/dana/domain/imagecapture/interactor/GetTipUploadPhotoCDP;", "Lid/dana/phototips/mapper/PhotoTipsModelMapper;", "mapper", "Lid/dana/phototips/mapper/PhotoTipsModelMapper;", "Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "<init>", "(Lid/dana/domain/imagecapture/interactor/GetTipUploadPhotoCDP;Lid/dana/phototips/mapper/PhotoTipsModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ImageCaptureViewModel extends ViewModel {
    private final MutableStateFlow<ImageCaptureUiState> _uiState;
    private final GetTipUploadPhotoCDP getTipUploadPhotoCDP;
    private final PhotoTipsModelMapper mapper;
    private final StateFlow<ImageCaptureUiState> uiState;

    @Inject
    public ImageCaptureViewModel(GetTipUploadPhotoCDP getTipUploadPhotoCDP, PhotoTipsModelMapper photoTipsModelMapper) {
        Intrinsics.checkNotNullParameter(getTipUploadPhotoCDP, "");
        Intrinsics.checkNotNullParameter(photoTipsModelMapper, "");
        this.getTipUploadPhotoCDP = getTipUploadPhotoCDP;
        this.mapper = photoTipsModelMapper;
        MutableStateFlow<ImageCaptureUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(ImageCaptureUiState.Idle.INSTANCE);
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
    }

    @JvmName(name = "getUiState")
    public final StateFlow<ImageCaptureUiState> getUiState() {
        return this.uiState;
    }

    public final void getTipUploadPhoto(final String documentId, String spaceCode) {
        Intrinsics.checkNotNullParameter(documentId, "");
        Intrinsics.checkNotNullParameter(spaceCode, "");
        BaseFlowUseCase.execute$default(this.getTipUploadPhotoCDP, spaceCode, null, new Function1<Space, Unit>() { // from class: id.dana.danah5.imagecapture.viewmodel.ImageCaptureViewModel$getTipUploadPhoto$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Space space) {
                PhotoTipsModelMapper photoTipsModelMapper;
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(space, "");
                photoTipsModelMapper = ImageCaptureViewModel.this.mapper;
                Map<String, ? extends PhotoTipsModel> apply = photoTipsModelMapper.apply(space);
                ImageCaptureViewModel imageCaptureViewModel = ImageCaptureViewModel.this;
                String str = documentId;
                Map<String, ? extends PhotoTipsModel> map = apply;
                if (map == null || map.isEmpty()) {
                    mutableStateFlow2 = imageCaptureViewModel._uiState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        ImageCaptureUiState imageCaptureUiState = (ImageCaptureUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, new ImageCaptureUiState.InitPhotoTips(null)));
                    return;
                }
                mutableStateFlow = imageCaptureViewModel._uiState;
                do {
                    value = mutableStateFlow.getValue();
                    ImageCaptureUiState imageCaptureUiState2 = (ImageCaptureUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ImageCaptureUiState.InitPhotoTips((PhotoTipsModel) MapsKt.getValue(map, str))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.imagecapture.viewmodel.ImageCaptureViewModel$getTipUploadPhoto$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = ImageCaptureViewModel.this._uiState;
                do {
                    value = mutableStateFlow.getValue();
                    ImageCaptureUiState imageCaptureUiState = (ImageCaptureUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ImageCaptureUiState.InitPhotoTips(null)));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.IMAGE_CAPTURE_GET_PHOTO_TIPS, th.getMessage(), th);
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }
}
