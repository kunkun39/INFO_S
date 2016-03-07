package com.changhong.system.property;

import javax.servlet.http.HttpServletRequest;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 14:37
 */
public class MenuKeyProperties {
    /* KEY */
    private final static String MENU_KEY = "MENU_KEY";

    private final static String SUB_MENU_KEY = "SUB_MENU_KEY";

    /* MENU KEY */
    public final static String INFO_GATER = "INFO_GATER";

    /* SUB MENU key */
    public final static String PROJECT_MANAGE = "PROJECT_MANAGE";

    public final static String METADATA_MANAGE = "METADATA_MANAGE";

    public static void setMenuKey(HttpServletRequest request , String menuKey, String subMenuKey) {
        request.getSession().setAttribute(MenuKeyProperties.MENU_KEY, menuKey);
        request.getSession().setAttribute(MenuKeyProperties.SUB_MENU_KEY, subMenuKey);
    }
}
