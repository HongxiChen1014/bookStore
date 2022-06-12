package com.daisy.test;

import com.daisy.utils.*;
import org.junit.Test;
import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
        System.out.println(JdbcUtils.getConnection());
    }
}
