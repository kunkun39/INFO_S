package com.changhong.system.domain;

import com.changhong.common.domain.EntityBase;
import com.changhong.common.utils.CHJodaUtils;
import org.joda.time.DateTime;

/**
 * User: Jack Wang
 * Date: 16-3-1
 * Time: 上午9:28
 */
public class DBBakHistory extends EntityBase {

    private DateTime actionTime;

    private String year;

    private String projectCode;

    private int projectId;

    private int dbConfId;

    public DBBakHistory() {
    }

    public DBBakHistory(int dbConfId) {
        this.dbConfId = dbConfId;
    }

    public DBBakHistory(int id, String actionTime, String year, String projectCode, int projectId, int dbConfId) {
        setId(id);
        this.actionTime = CHJodaUtils.parseDateTimedMyHM(actionTime);
        this.year = year;
        this.projectCode = projectCode;
        this.projectId = projectId;
        this.dbConfId = dbConfId;
    }

    public DateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(DateTime actionTime) {
        this.actionTime = actionTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getDbConfId() {
        return dbConfId;
    }

    public void setDbConfId(int dbConfId) {
        this.dbConfId = dbConfId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
