package com.smart.mp;

import lombok.Builder;

/**
 * 创建对象
 * 构建者模式
 * builder
 */

public class TestBuild {
    private String id;
    private String name="11111";

    private TestBuild(Build build) {
        this.id= build.id;
    }
    // druidDatasouce
    public static class Build {
        private String id;
        private String name;
        private String type1;
        public Build setId(String id) {
            this.id = id;
            return this;
        }
        public TestBuild build() {
            return new TestBuild(this);
        }
    }

    public static void main(String[] args) {
        new Build()
                .setId("1")
                .build();
    }
}
