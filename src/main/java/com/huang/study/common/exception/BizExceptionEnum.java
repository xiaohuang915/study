package com.huang.study.common.exception;

/**
 * 所有业务异常的枚举
 */
public enum BizExceptionEnum {

    /**
     * token异常
     */
    TOKEN_EXPIRED("700", "token过期,请重新登陆获取"),
    TOKEN_ERROR("701", "token验证失败"),

    /**
     * 签名异常
     */
    SIGN_ERROR("702", "签名验证失败"),

    /**
     * 其他
     */
    AUTH_REQUEST_ERROR("400", "账号密码错误"),

    /**
     * 字典
     */
    DICT_EXISTED("400", "字典已经存在"),
    ERROR_CREATE_DICT("500", "创建字典失败"),
    ERROR_WRAPPER_FIELD("500", "包装字典属性失败"),


    /**
     * 文件上传
     */
    FILE_READING_ERROR("400", "FILE_READING_ERROR!"),
    FILE_NOT_FOUND("400", "FILE_NOT_FOUND!"),
    UPLOAD_ERROR("500", "上传图片出错"),

    /**
     * 权限和数据问题
     */
    DB_RESOURCE_NULL("400", "数据库中没有该资源"),
    NO_PERMITION("405", "权限异常"),
    REQUEST_INVALIDATE("400", "请求数据格式不正确"),
    INVALID_KAPTCHA("400", "验证码不正确"),
    CANT_DELETE_ADMIN("600", "不能删除超级管理员"),
    CANT_FREEZE_ADMIN("600", "不能冻结超级管理员"),
    CANT_CHANGE_ADMIN("600", "不能修改超级管理员角色"),

    /**
     * 账户问题
     */
    USER_ALREADY_REG("401", "该用户已经注册"),
    NO_THIS_USER("400", "没有此用户"),
    USER_NOT_EXISTED("400", "没有此用户"),
    ACCOUNT_FREEZED("401", "账号被冻结"),
    OLD_PWD_NOT_RIGHT("402", "原密码不正确"),
    TWO_PWD_NOT_MATCH("405", "两次输入密码不一致"),

    /**
     * 错误的请求
     */
    MENU_PCODE_COINCIDENCE("400", "菜单编号和副编号不能一致"),
    RECRUIT_ID_IS_NULL("400", "招聘信息主键id不能为空"),
    RECRUIT_POST_IS_NULL("400", "岗位不能为空"),
    EXISTED_THE_MENU("400", "菜单编号重复，不能添加"),
    DICT_MUST_BE_NUMBER("400", "字典的值必须为数字"),
    REQUEST_NULL("400", "请求有错误"),
    SESSION_TIMEOUT("400", "会话超时"),
    SERVER_ERROR("500", "服务器异常"),
    /**
     * 传入参数错误
     */
    PROPERTY_IS_EMPTY("-1", "字典名称不能为空！"),
    GUID_IS_EMPTY("-1", "guid不能为空！"),
    ID_IS_EMPTY("-1", "id不能为空！"),
    DISTRICT_NAME_IS_EMPTY("-1", "地区名称不能为空！"),
    DISTRICT_PARENT_ID_IS_EMPTY("-1", "地区父级id不能为空！"),
    STATUS_IS_EMPTY("-1", "状态不能为空,且只能为1或0！"),
    /**
     *没有该订单guid
     */
    NO_ORDER("-1", "没有该订单"),
    NO_USER("-1", "没有操作的用户"),
    NO_PAGE_NUM("-1", "没有对应页面"),
    NO_PAGE_DATA("-1", "没有页面数据"),
    PROPERTY_VALID_FAIL("-1", "属性验证失败"),
    INSERT_BATCH_FILE("-1", "文件保存出错"),

    ENTERPRIS_EPORTALS_TYPE_EMPTY("700", "接入企业类型不能为空"),
    ENTERPRIS_EPORTALS_LIST_NO_DATA("701", "接入的企业列表为空"),
    ENTERPRIS_EPORTALS_GUID_EMPTY("702", "接入企业主键不能为空"),
    ENTERPRIS_EPORTALS_NO_DATA("703", "接入的企业为空"),
    ENTERPRIS_EPORTALS_AUTHCODE_DATA("704", "接入企业信息不能位空"),
    ENTERPRIS_EPORTALS_SAVE_FAIL("705", "接入企业信息保存失败"),
    ERROR_FILE_TYPE("-1", "错误的文件类型,请选择直租的包装资料或者补充资料"),
	
    //审核参数错误
    DELIVERY_VEHICLE_STAGE_ERROR("-1","提车资料结果不能为空"),
	FIRSTVERIFY_STAGE_ERROR("-1","初审结果不能为空"),
	RECHECK_STAGE_ERROR("-1","复审结果不能为空"),
	FINALCHECK_STAGE_ERROR("-1","终审结果不能为空"),
	SIGN_STAGE_ERROR("-1","成交结果不能为空"),
	PAYMENT_STAGE_ERROR("-1","支付结果不能为空"),
	ORDER_STAGE_ERROR("-1","审核结果错误"),
	ORDER_ID_ERRO("-1","订单id不能为空"),
	ORDER_STAGE_ERRO("-1","审核阶段不能为空"),
	INVENTORY_DETAILS_ERROR("-1","未查询到相关车辆信息"),
	VEHICLEID_ERROR("-1","车辆id不能为空"),
	ORDER_PROCESS_ERROR("-1","未查询到直租相关流程信息"),
	PURCHASE_PROCESS_ERROR("-1","未查询到采购相关流程信息"),
	FINANCE_PROCESS_ERROR("-1","未查询到融资租赁相关流程信息"),
	BEEN_STORAGE_ERROR("-1","售前信息不能为空"),
	WAIT_VALIDATE_CAR_ERROR("-1","待验车信息不能为空"),
	WAIT_DELIVERY_VEHICLE_ERROR("-1","提车信息不能为空"),
	WAYBILLID_ERROR("-1","运单号不能为空"),
	LOGISTICS_ERROR("-1","采购信息不能为空"),
	BACK_STATUS_ERROR("-1","未查询到退回状态"),
	
	PURCHASE_LOGISTICS_NULL("801","采购物流信息不能为空"),
	PURCHASEID_LOGISTICS_NULL("802","采购订单ID物流信息不能为空"),
	PURCHASE_LOGISTICS_EXIST("803","采购订单物流信息已存在"),
	PURCHASE_LOGISTICS_WAYBILL_NOT_EXIST("804","采购订单物流运单信息不存在"),
	PROCESS_ROLES_ERROR("-1","未找到与流程相关的用户"),
	ADD_ALLOTTASK_ERROR("-1","新增分配任务未查到流程"),
	UPDATE_ALLOTTASK_ERROR("-1","修改分配任务未查到流程"),
	NO_GUARANTEE("419","无担保人信息"),
	NO_ORDERPERSONALDIRECTLEASEVO("420","无担直租信息"),
	;

    BizExceptionEnum(String code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    private String friendlyCode;

    private String friendlyMsg;

    public String getCode() {
        return friendlyCode;
    }

    public void setCode(String code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

}
