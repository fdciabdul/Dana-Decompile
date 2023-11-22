package id.dana.notificationcenter.mapper;

import id.dana.domain.notificationcenter.model.NotificationDTOResponse;
import id.dana.notificationcenter.model.NotificationDTO;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NotificationCenterMapper {
    @Inject
    public NotificationCenterMapper() {
    }

    public static NotificationDTO PlaceComponentResult(NotificationDTOResponse notificationDTOResponse) {
        if (notificationDTOResponse != null) {
            NotificationDTO notificationDTO = new NotificationDTO();
            notificationDTO.MyBillsEntityDataFactory = notificationDTOResponse.getContent();
            notificationDTO.BuiltInFictitiousFunctionClassFactory = notificationDTOResponse.getCreatedTime();
            notificationDTO.KClassImpl$Data$declaredNonStaticMembers$2 = notificationDTOResponse.getIconUrl();
            notificationDTO.PlaceComponentResult = notificationDTOResponse.getId();
            notificationDTO.getErrorConfigVersion = notificationDTOResponse.isRead();
            notificationDTO.lookAheadTest = notificationDTOResponse.getRedirectType();
            notificationDTO.moveToNextValue = notificationDTOResponse.getRedirectValue();
            return notificationDTO;
        }
        return null;
    }
}
