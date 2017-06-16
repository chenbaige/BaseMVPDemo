package com.yjtc.cbg.basicmvpframwork.data.dto;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-15
 */
public class AreaDto extends BaseDto {
    //
//    private List<Area> mAreas;
//
//    public List<Area> getAreas() {
//        return mAreas;
//    }
//
//    public void setAreas(List<Area> areas) {
//        mAreas = areas;
//    }
//
//    public class  Area{
    private String AreaNo;
    private String AreaName;

    public String getAreaNo() {
        return AreaNo;
    }

    public void setAreaNo(String areaNo) {
        AreaNo = areaNo;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }
}
