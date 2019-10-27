package com.google.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class GoogleTest {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new GoogleData("world"),
                new GoogleData("snow")
        };
    }

    class GoogleData {
        private String message;

        public GoogleData(String data) {
            this.message = data;
        }

        @BeforeClass
        public void BeforeClassExecute() {
           System.out.println("BeforeClassExecute");
        }

        @Test
        public void SomeTestExecution() {
            System.out.println("SomeTestExecution" + message);
        }

        @AfterClass
        public void AfterClassExecute() {
            System.out.println("AfterClassExecute");
        }
    }
}