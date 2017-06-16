package com.yjtc.cbg.basicmvpframwork.data.dto;

import java.util.List;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-16
 */
public class WeatherDto {


    /**
     * city : 故宫博物院
     * cnty : 中国
     * id : CN10101010018A
     * lat : 39.90999985
     * lon : 116.38999939
     * update : {"loc":"2017-06-16 10:19","utc":"2017-06-16 02:19"}
     */

    private BasicBean basic;
    /**
     * basic : {"city":"故宫博物院","cnty":"中国","id":"CN10101010018A","lat":"39.90999985","lon":"116.38999939","update":{"loc":"2017-06-16 10:19","utc":"2017-06-16 02:19"}}
     * daily_forecast : [{"astro":{"sr":"04:45","ss":"19:45"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-06-16","tmp":{"max":"36","min":"22"},"wind":{"dir":"南风","sc":"3-4"}},{"astro":{"sr":"04:45","ss":"19:45"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-06-17","tmp":{"max":"35","min":"23"},"wind":{"dir":"南风","sc":"微风"}},{"astro":{"sr":"04:45","ss":"19:45"},"cond":{"code_d":"104","code_n":"305","txt_d":"阴","txt_n":"小雨"},"date":"2017-06-18","tmp":{"max":"35","min":"19"},"wind":{"dir":"西北风","sc":"微风"}},{"astro":{"sr":"04:45","ss":"19:45"},"cond":{"code_d":"305","code_n":"306","txt_d":"小雨","txt_n":"中雨"},"date":"2017-06-19","tmp":{"max":"29","min":"18"},"wind":{"dir":"东南风","sc":"微风"}},{"astro":{"sr":"04:45","ss":"19:46"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2017-06-20","tmp":{"max":"32","min":"18"},"wind":{"dir":"南风","sc":"微风"}},{"astro":{"sr":"04:46","ss":"19:46"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2017-06-21","tmp":{"max":"29","min":"18"},"wind":{"dir":"北风","sc":"微风"}},{"astro":{"sr":"04:46","ss":"19:46"},"cond":{"code_d":"305","code_n":"305","txt_d":"小雨","txt_n":"小雨"},"date":"2017-06-22","tmp":{"max":"25","min":"18"},"wind":{"dir":"东南风","sc":"微风"}}]
     * status : ok
     */

    private String status;
    /**
     * astro : {"sr":"04:45","ss":"19:45"}
     * cond : {"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"}
     * date : 2017-06-16
     * tmp : {"max":"36","min":"22"}
     * wind : {"dir":"南风","sc":"3-4"}
     */

    private List<DailyForecastBean> daily_forecast;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public static class BasicBean {
        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        /**
         * loc : 2017-06-16 10:19
         * utc : 2017-06-16 02:19
         */

        private UpdateBean update;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public static class UpdateBean {
            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }
    }

    public static class DailyForecastBean {
        /**
         * sr : 04:45
         * ss : 19:45
         */

        private AstroBean astro;
        /**
         * code_d : 101
         * code_n : 101
         * txt_d : 多云
         * txt_n : 多云
         */

        private CondBean cond;
        private String date;
        /**
         * max : 36
         * min : 22
         */

        private TmpBean tmp;
        /**
         * dir : 南风
         * sc : 3-4
         */

        private WindBean wind;

        public AstroBean getAstro() {
            return astro;
        }

        public void setAstro(AstroBean astro) {
            this.astro = astro;
        }

        public CondBean getCond() {
            return cond;
        }

        public void setCond(CondBean cond) {
            this.cond = cond;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public TmpBean getTmp() {
            return tmp;
        }

        public void setTmp(TmpBean tmp) {
            this.tmp = tmp;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class AstroBean {
            private String sr;
            private String ss;

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }
        }

        public static class CondBean {
            private String code_d;
            private String code_n;
            private String txt_d;
            private String txt_n;

            public String getCode_d() {
                return code_d;
            }

            public void setCode_d(String code_d) {
                this.code_d = code_d;
            }

            public String getCode_n() {
                return code_n;
            }

            public void setCode_n(String code_n) {
                this.code_n = code_n;
            }

            public String getTxt_d() {
                return txt_d;
            }

            public void setTxt_d(String txt_d) {
                this.txt_d = txt_d;
            }

            public String getTxt_n() {
                return txt_n;
            }

            public void setTxt_n(String txt_n) {
                this.txt_n = txt_n;
            }
        }

        public static class TmpBean {
            private String max;
            private String min;

            public String getMax() {
                return max;
            }

            public void setMax(String max) {
                this.max = max;
            }

            public String getMin() {
                return min;
            }

            public void setMin(String min) {
                this.min = min;
            }
        }

        public static class WindBean {
            private String dir;
            private String sc;

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }
        }
    }
}
