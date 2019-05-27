package com.huang.study.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-03-11 09:53
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestVo {


    private EnvelopeBean envelope;
    private String signature;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnvelopeBean {

        private HeadBean head;
        private BodyBean body;


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class HeadBean {

            private String sysId;
            private String charset;
            private String timestamp;
            private String serialValue;
            private String version;
            private String orgcode;


        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class BodyBean {

            private String serviceCode;
            private ParametersBean parameters;


            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class ParametersBean {

                private String ZHLX;
                private String ZCLY;
                private String SJHM;
                private String SHBH;
                private String SHHYID;


            }
        }
    }
}
