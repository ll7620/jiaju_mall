package com.ll.furns.test;

import com.ll.furns.entity.Member;
import com.ll.furns.utils.DataUtils;
import com.ll.furns.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class dbtest {
    @Test
    public void test1() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("connection: "+connection);
        //JDBCUtilsByDruid.close(null,null,connection);
    }

    @Test
    public void time(){

        System.out.println(System.nanoTime());



    }
}
