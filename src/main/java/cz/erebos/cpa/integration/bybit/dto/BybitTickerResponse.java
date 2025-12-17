package cz.erebos.cpa.integration.bybit.dto;

import java.util.List;
import java.util.Map;

public class BybitTickerResponse {

    private int retCode;
    private String retMsg;
    private Result result;
    private Map<String, Object> retExtInfo;
    private long time;

    public int getRetCode() { return retCode; }
    public void setRetCode(int retCode) { this.retCode = retCode; }

    public String getRetMsg() { return retMsg; }
    public void setRetMsg(String retMsg) { this.retMsg = retMsg; }

    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }

    public Map<String, Object> getRetExtInfo() { return retExtInfo; }
    public void setRetExtInfo(Map<String, Object> retExtInfo) { this.retExtInfo = retExtInfo; }

    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }

    public static class Result {
        private String category;
        private List<BybitTicker> list;

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public List<BybitTicker> getList() { return list; }
        public void setList(List<BybitTicker> list) { this.list = list; }
    }
}