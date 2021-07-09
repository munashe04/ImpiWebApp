package com.thondo.whatsappconnect.constants;

public class AppConstants {

    public static final String VALID = "valid";
    public static final String INVALID = "invalid";
    public static final String EXPIRED = "expired";

    public static final String AUTHENTICATE = "Authenticate";
    public static final String AUTHORIZATION = "Authorization";
    public static final String REGISTER = "Register";

    public static final String PATH_PARAM_ID = "id";
    public static final String HEADER_PARAM_UNIQUE_REFERENCE_CODE = "Unique-Reference-Code";
    public static final String HEADER_PARAM_RESPONSE_TIME="Response-Timestamp";
    public static final String HEADER_PARAM_CONTENT_LENGTH ="Content-Length";
    public static final String HEADER_PARAM_API_KEY_ERROR ="The API key was not found or not the expected value.";
    
    public static final String DATA = "data";
    public static final String SECTOR = "sector";
    public static final String INDUSTRY = "industry";
    
    public static final String TYPE = "businessType";
    
    public static final String MARKET_STUDY = "market-study";
    public static final String BUSINESS_PLAN = "business-plan";
    public static final String FINANCIAL_MODEL = "financial-model";

    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failure";
    public static final String INVALID_OTP = "Invalid OTP";
    
    public static final String APPROVED = "Approved";
    public static final String PENDING = "Pending";
    public static final String DELETED = "Deleted";
    public static final String CREATED = "Created";
    public static final String NOT_ACCEPTED = "Invite not accepted by team member";

    public static final String ACCEPTED = "Accepted";
    public static final String DECLINED = "Declined";


    public static final String OFFER_LETTER_DOCUMENT_TYPE="offer-letter";
    public static final String FACILITY_SECURITY_DOCUMENT_TYPE="facility-securities";
    public static final String CHECKLIST_DOCUMENT_TYPE="checklist";

    public static final String PARTNER_ROLE = "Partner";
    public static final String ADMIN_ROLE = "Administrator";
    
    public static final String UNDERSCORE = "_";
    public static final String ENTITY_NOT_FOUND ="Entity with ID [%] is not found";

    public static final String CANNOT_INVITE_SAME_USER = "Cannot invite Same User";

    public static final String RM="RM";
    public static final String MANAGER_ROLE = "Manager";
    public static final String ICC="ICC";
    public static final String CREDIT_ANALYST="creditAnalyst";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    
    public static final String STATIC_CONTENT="static_content";
    public static final String CERTIFICATE="dealership-certificate";
    
    public static final String FILE_IS_NULL_MESSAGE = "Bad request, file is null";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String ARABIC = "ar-qa";

    public static final String DOWNLOAD_URL = "/numu/v1/api/application/sections/%s/subsections/%s/documents/%s";
    public static final String THE_LOAN_REQUEST = "The loan request";
    public static final String LOAN_REQUEST = "loan-request";

    public static final String STATUS_UPDATE_SUCCESSFULL = "Status Update Successfull";
    public static final String STATUS_UPDATE_UNSUCCESSFULL = "Status Update UnSuccessfull";
    public static final String SMS_en = "Hi %s , There's been update on your business application, you can login on the QDB portal to know more to and\n" +
            " take necessary action";
    public static final String SMS_ar = "مرحبا s%  هناك تحديث في طلبك. لمعرفة المزيد و إتخاذ الخطوات اللازمة أضغط هنا";

    public static final String CONSULTANT ="Consultant";

    public static final String XLSX = ".xlsx";

    public static final String EPD ="epd";
    public static final String TECHNICAL ="technical";
    public static final String CONSTRUCTION ="construction";
    public static final String MACHINERY ="machinery";

    public static final String EXISTING_BUSINESS = "Existing";
    public static final String NEW_BUSINESS = "New";
    public static final String RETURN_TO = "return-to-";
    public static final String SHAREHOLDER_CV = "shareholder-cv-";
    public static final String MANAGER_CV = "manager-cv-";

    public static final String ISIC_LOOKUP_TYPE = "sector-type";

    public static final int NUM_OF_RENEWAL_DOCS = 1;

    private AppConstants() {
    }

   public enum Status {
        IN_PROGRESS("In progress"),
        COMPLETED("Completed"),
        NO_INPUT("No input");

        private final String status;

        Status(String _status) {
            this.status = _status;
        }

        public String getStatus() {
            return this.status;
        }
    }

}
